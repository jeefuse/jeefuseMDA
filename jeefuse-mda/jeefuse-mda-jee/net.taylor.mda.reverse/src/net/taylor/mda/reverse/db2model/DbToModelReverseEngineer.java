package net.taylor.mda.reverse.db2model;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import net.taylor.mda.generator.parse.entity.Config;
import net.taylor.mda.generator.parse.entity.DbReverseUtil;
import net.taylor.mda.generator.parse.entity.EntityHelper;
import net.taylor.mda.generator.parse.page.PageHelper;
import net.taylor.mda.generator.util.NameHelper;
import net.taylor.mda.generator.util.StereotypeHelper;
import net.taylor.mda.reverse.ModelReverseEngineer;
import net.taylor.mda.reverse.db2model.config.Db2ModelXmlConfig;
import net.taylor.mda.reverse.db2model.config.DbReverseConfig;
import net.taylor.mda.reverse.db2model.config.ImportTable;
import net.taylor.mda.reverse.db2model.config.Jdbc;
import net.taylor.mda.utils.SqlUtil;
import net.taylor.mda.utils.StrUtil;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.osgi.framework.Bundle;

import net.jeefuse.mda.annotations.MdaStereotype;
import net.jeefuse.mda.annotations.condition.Operator;
import net.jeefuse.mda.annotations.hibernate.HibernateStereotype;
import net.jeefuse.mda.annotations.view.CssClassKind;
import net.jeefuse.mda.annotations.view.InputAnnotations;
import net.jeefuse.mda.annotations.view.InputKind;
import net.jeefuse.mda.annotations.view.ListAnnotations;
import net.jeefuse.mda.annotations.view.SearchAnnotations;

public class DbToModelReverseEngineer extends ModelReverseEngineer {

	public InputStream createModel(IProgressMonitor monitor, String jarPath,
			String configFile, String name) {
		try {
			registerResourceFactories();
			// goal = "jar:file:/" + path +
			// "/plugins/org.eclipse.uml2.uml.resources_<version>.jar!/"
			Bundle b = Platform.getBundle("org.eclipse.uml2.uml.resources");
			String location = b.getLocation();
			location = location.replace("reference", "jar");
			location = location + "!/";
			registerPathmaps(URI.createURI(location));

			out("Creating model...");
			Model model = createModel(name, URI.createURI("model")
					.appendSegment(name).appendFileExtension(
							UMLResource.FILE_EXTENSION));
			// these are for unit testing
			// importProfile(
			// model,
			// "file://C:/workspaces/taylor/taylor.mda3.workspace/net.taylor.mda.profiles/profiles/Persistence.profile.uml");
			// importProfile(
			// model,
			// "file://C:/workspaces/taylor/taylor.mda3.workspace/net.taylor.mda.profiles/profiles/types.profile.uml");

			// config
			Db2ModelXmlConfig db2ModelConfig = new Db2ModelXmlConfig(configFile);
			Jdbc jdbc = db2ModelConfig.getJdbc();
			out("connection info :" + jdbc.toString());
			Connection connection = getConnection(jarPath, jdbc.getDriver(),
					jdbc.getUrl(), jdbc.getUsername(), jdbc.getPassword());
			DatabaseMetaData dm = connection.getMetaData();

			// consider doing this instead
			// String[] types = {"TABLE"};
			// ResultSet rs = dm.getTables(null,null,"%",types);

			ResultSet catalogs = dm.getCatalogs();
			if (catalogs.next()) {
				processByCatalog(connection, dm, jdbc.getSchema(), monitor,
						model, db2ModelConfig.getImportList());
			} else {
				processBySchema(connection, dm, jdbc.getSchema(), monitor,
						model, db2ModelConfig.getImportList());
			}
			catalogs.close();
			connection.close();

			out("Saving model...");
			return toInputStream(model, URI.createURI("model").appendSegment(
					name).appendFileExtension(UMLResource.FILE_EXTENSION));
			// these are for unit testing
			// save(model, URI.createURI("model").appendSegment(name)
			// .appendFileExtension(UMLResource.FILE_EXTENSION));
			// return null;

		} catch (Throwable e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * Some databases, such as oracle, return nothing for dm.getCatalogs()
	 */
	protected void processBySchema(Connection connection, DatabaseMetaData dm,
			String schema, IProgressMonitor monitor, Model model,
			List<ImportTable> importList) throws Throwable {
		for (ImportTable imp : importList) {
			fkList = new ArrayList<ForeignKey>();
			String packageName = imp.getPackageName();
			if (StrUtil.isBlank(packageName))
				packageName = schema;
			List<String> tableMatchs = imp.getTableMatchs();
			setCount(monitor, dm, null, schema, imp);
			ResultSet tables = dm.getTables(null, schema, "%", null);
			Package pkg = createPackage(model, packageName);
			// 应用服务工厂
			applyStereotype(pkg, MdaStereotype.service_JoinServiceFactory);
			while (tables.next()) {
				String tableName = tables.getString("TABLE_NAME");
				if (isTableMatch(tableName, tableMatchs)) {
					out("process match tableName:"+tableName);
					out("Processing Table: " + tableName + " package:"+ imp.getPackageName());
					org.eclipse.uml2.uml.Class entity = processTable(pkg,
							tableName);
					// process column
					ResultSet columns = dm.getColumns(null, schema, tableName,"%");
					while (columns.next()) {
						processColumn(model, entity, dm, columns, connection,
								tableName);
					}
					columns.close();
					// check class for association
					if (EntityHelper.isM2MAssociationClass(entity)) {
						if (EntityHelper.hasIDProperty(entity)) {
							applyStereotype(entity, "javax.persistence.Entity");
							applyStereotype(entity,
									MdaStereotype.model_M2mWithId);
						} else {
							applyStereotype(entity, MdaStereotype.model_M2m);
						}
					} else {
						applyStereotype(entity, "javax.persistence.Entity");
					}
					Stereotype table = applyStereotype(entity,
							"javax.persistence.Table");
					out("Table Stereotype: " + table.toString());
					// uniqueConstraint unique constraints during generation
					// none
					entity.setValue(table, "name", tableName);
					entity.setValue(table, "catalog", tables
							.getString("TABLE_CAT"));
					entity.setValue(table, "schema", tables
							.getString("TABLE_SCHEM"));
					// add comment
					String remark = tables.getString("REMARKS");
					if (StrUtil.isBlank(remark)) {
						if (connection.getMetaData().getURL().indexOf("mysql") != -1) {
							remark = SqlUtil.getMysqlTableComment(tableName,
									connection);
						} else if (connection.getMetaData().getURL().indexOf(
								"oracle") != -1) {
							remark = SqlUtil.getOracleTableComment(tableName,
									connection);
						}
					}
					if (!StrUtil.isBlank(remark)) {
						entity.createOwnedComment().setBody(remark);
					}
					// apply functions
					applyStereotype(entity,MdaStereotype.service_Functions);

					monitor.worked(1);
				}
			}
			// process sql
			if (null != imp.getImpSqls() && !imp.getImpSqls().isEmpty()) {
				for (ImportTable.ImpSql impSql : imp.getImpSqls()) {
					String name = impSql.getName();
					org.eclipse.uml2.uml.Class entity = processTable(pkg, name);
					applyStereotype(entity,"net.jeefuse.mda.annotations.model.vo");
					out("Processing sql: " + name + " package:"
							+ imp.getPackageName());
					// apply functions
					 applyStereotype(entity,
							MdaStereotype.service_Functions);
					// process sql column
					Statement state = connection.createStatement();
					ResultSet rs = state.executeQuery(impSql.getSql());
					ResultSetMetaData rsmt = rs.getMetaData();
					processColumnsBySql(model, entity, rsmt, connection);
					rs.close();
					state.close();
					monitor.worked(1);
				}
			}
			// process foreignkey
			processForeignKey(pkg, model);
			tables.close();
		}
	}

	/**
	 * Some databases, such as oracle, return nothing for dm.getSchemas()
	 */
	protected void processByCatalog(Connection connection, DatabaseMetaData dm,
			String schema, IProgressMonitor monitor, Model model,
			List<ImportTable> importList) throws Throwable {

		ResultSet catalogs = dm.getCatalogs();
		while (catalogs.next()) {
			String catalog = catalogs.getString("TABLE_CAT");
			if (!connection.getCatalog().equals(catalog)) {
				continue;
			}
			for (ImportTable imp : importList) {
				fkList = new ArrayList<ForeignKey>();
				String packageName = imp.getPackageName();
				if (StrUtil.isBlank(packageName))
					packageName = catalog;
				List<String> tableMatchs = imp.getTableMatchs();
				setCount(monitor, dm, catalog, schema, imp);
				Package pkg = createPackage(model, packageName);
				// 应用服务工厂
				applyStereotype(pkg, MdaStereotype.service_JoinServiceFactory);
				// process table
				ResultSet tables = dm.getTables(catalog, schema, "%", null);
				while (tables.next()) {
					String tableName = tables.getString("TABLE_NAME");
					if (isTableMatch(tableName, tableMatchs)) {
						out("process match tableName:"+tableName);
						out("Processing Table: " + tableName + " package:"
								+ imp.getPackageName());
						org.eclipse.uml2.uml.Class entity = processTable(pkg,
								tableName);
						// process column
						ResultSet columns = dm.getColumns(catalog, schema,
								tableName, "%");
						while (columns.next()) {
							processColumn(model, entity, dm, columns,
									connection, tableName);
						}
						columns.close();
						// check class for association
						if (EntityHelper.isM2MAssociationClass(entity)) {
							if (EntityHelper.hasIDProperty(entity)) {
								applyStereotype(entity,
										"javax.persistence.Entity");
								applyStereotype(entity,
										MdaStereotype.model_M2mWithId);
							} else {
								applyStereotype(entity, MdaStereotype.model_M2m);
							}
						} else {
							applyStereotype(entity, "javax.persistence.Entity");
						}
						Stereotype table = applyStereotype(entity,
								"javax.persistence.Table");
						out("Table Stereotype: " + table.toString());
						// uniqueConstraint unique constraints during generation
						// none
						entity.setValue(table, "name", tableName);
						entity.setValue(table, "catalog", tables
								.getString("TABLE_CAT"));
						entity.setValue(table, "schema", tables
								.getString("TABLE_SCHEM"));
						// add comment
						// String remark = tables.getString("REMARKS");
						String remark = (String) tables.getObject(5);
						if (StrUtil.isBlank(remark)) {
							if (connection.getMetaData().getURL().indexOf(
									"mysql") != -1) {
								remark = SqlUtil.getMysqlTableComment(
										tableName, connection);
							} else if (connection.getMetaData().getURL()
									.indexOf("oracle") != -1) {
								remark = SqlUtil.getOracleTableComment(
										tableName, connection);
							}
						}

						if (!StrUtil.isBlank(remark)) {
							if (entity.getOwnedComments().isEmpty()) {
								entity.createOwnedComment().setBody(remark);
							} else {
								entity.getOwnedComments().clear();
								entity.createOwnedComment().setBody(remark);
							}
							// entity.createOwnedComment().setBody(remark);
						}
						// apply functions
						Stereotype functions = applyStereotype(entity,
								MdaStereotype.service_Functions);

						monitor.worked(1);
					}
				}
				// process sql
				if (null != imp.getImpSqls() && !imp.getImpSqls().isEmpty()) {
					for (ImportTable.ImpSql impSql : imp.getImpSqls()) {
						String name = impSql.getName();
						org.eclipse.uml2.uml.Class entity = processTable(pkg,
								name);
						applyStereotype(entity,
								"net.jeefuse.mda.annotations.model.vo");
						out("Processing sql: " + name + " package:"
								+ imp.getPackageName());
						// apply functions
						Stereotype functions = applyStereotype(entity,
								MdaStereotype.service_Functions);
						// process sql column
						Statement state = connection.createStatement();
						ResultSet rs = state.executeQuery(impSql.getSql());
						ResultSetMetaData rsmt = rs.getMetaData();
						processColumnsBySql(model, entity, rsmt, connection);
						rs.close();
						state.close();
						monitor.worked(1);
					}
				}
				// process foreignkey
				processForeignKey(pkg, model);
				tables.close();
			}
		}
		catalogs.close();
	}

	private boolean isTableMatch(String tableName, List<String> tableMatchs) {
		for (String tableMatch : tableMatchs) {
			if (tableName.matches(tableMatch)
					|| tableName.equalsIgnoreCase(tableMatch)) {
				return true;
			}
		}
		return false;
	}

	protected void setCount(IProgressMonitor monitor, DatabaseMetaData dm,
			String catalog, String schema, ImportTable imp) throws Exception {
		int count = null!=imp.getTableMatchs()?imp.getTableMatchs().size():0;
		int impSqlCount = 0;
		if (null != imp.getImpSqls() && imp.getImpSqls().size() > 0) {
			impSqlCount = imp.getImpSqls().size();
		}
		monitor.beginTask("Processing (" + count + ") Tables ,import "
				+ impSqlCount + " sql for package:" + imp.getPackageName(),
				count + impSqlCount);
	}

	protected Connection getConnection(String jarPath, String driver,
			String url, String userName, String password) throws Exception {
		if (null == jarPath || jarPath.trim().equals("")) {
			java.lang.Class.forName(driver);
			return DriverManager.getConnection(url, userName, password);
		} else {
			URL[] jars = new URL[1];
			jars[0] = new File(jarPath).toURL();
			ClassLoader cl = URLClassLoader.newInstance(jars, this.getClass()
					.getClassLoader());
			Driver jdbcDriver = (Driver) cl.loadClass(driver).newInstance();
			Properties info = new Properties();
			if (userName != null) {
				info.put("user", userName);
			}
			if (password != null) {
				info.put("password", password);
			}
			return jdbcDriver.connect(url, info);
		}
	}

	protected String upperCamel(String name) {
		if (name.length() == 0) {
			return name;
		} else {
			if (name.contains("_")) {
				String result = "";
				String[] tokens = name.split("_");
				for (String segment : tokens) {
					String temp = segment.toLowerCase();
					result += temp.substring(0, 1).toUpperCase()
							+ temp.substring(1);
				}
				return result;
			} else {
				// return name.substring(0, 1).toUpperCase() +
				// name.substring(1);
				String temp = name.toLowerCase();
				return temp.substring(0, 1).toUpperCase() + temp.substring(1);
			}
		}
	}

	protected String lowerCamel(String name) {
		if (name.length() == 0) {
			return name;
		} else if (!name.contains("_")) {
			// return name.substring(0, 1).toLowerCase() + name.substring(1);
			String temp = name.toLowerCase();
			return temp;
		} else {
			String result = null;
			String[] tokens = name.split("_");
			for (String segment : tokens) {
				if (result == null) {
					result = segment.toLowerCase();
				} else {
					String temp = segment.toLowerCase();
					result += temp.substring(0, 1).toUpperCase()
							+ temp.substring(1);
				}
			}
			return result;
		}
	}

	protected PrimitiveType getPrimitiveType(Package package_, String name) {
		Profile types = package_.getAppliedProfile("types");
		// (Model) load(URI
		// .createURI(UMLResource.UML_PRIMITIVE_TYPES_LIBRARY_URI));

		PrimitiveType primitiveType = (PrimitiveType) types.getOwnedType(name);

		// package_.createElementImport(primitiveType,
		// VisibilityKind.PUBLIC_LITERAL);

		out("Primitive type '" + primitiveType.getQualifiedName()
				+ "' imported.");

		return primitiveType;
	}

	protected Class processTable(Package pkg, String tableName)
			throws Exception {
		// String tableName = tables.getString("TABLE_NAME");
		Class entity = createClass(pkg, upperCamel(tableName), false);
		return entity;
	}

	protected boolean isPrimary(DatabaseMetaData dm, ResultSet columns)
			throws Exception {
		String schema = columns.getString("TABLE_SCHEM");
		String catalog = columns.getString("TABLE_CAT");
		String table = columns.getString("TABLE_NAME");

		ResultSet ids = dm.getPrimaryKeys(catalog, schema, table);
		String name = columns.getString("COLUMN_NAME");
		while (ids.next()) {
			if (name.equals(ids.getString("COLUMN_NAME"))) {
				ids.close();
				return true;
			}
		}
		ids.close();
		return false;
	}

	private class ForeignKey {
		public String primaryTable;

		public String primaryColumn;

		public String foreignTable;

		public String foreignColumn;
	}

	private static List<ForeignKey> fkList = new ArrayList<ForeignKey>();

	protected boolean isForeign(DatabaseMetaData dm, ResultSet columns)
			throws Exception {
		// http://www.princeton.edu/~storacle/jdbc8_doc/oracle.jdbc.driver.OracleDatabaseMetaData.html#getTables(java.lang.String,%20java.lang.String,%20java.lang.String,%20java.lang.String[])
		String schema = columns.getString("TABLE_SCHEM");
		String catalog = columns.getString("TABLE_CAT");
		String table = columns.getString("TABLE_NAME");
		String name = columns.getString("COLUMN_NAME");

		ResultSet fks = dm.getImportedKeys(catalog, schema, table);
		while (fks.next()) {
			// printNames(fks);
			if (name.equals(fks.getString("FKCOLUMN_NAME"))) {
				ForeignKey fk = new ForeignKey();
				fk.primaryTable = fks.getString("PKTABLE_NAME");
				fk.primaryColumn = fks.getString("PKCOLUMN_NAME");
				fk.foreignTable = fks.getString("FKTABLE_NAME");
				fk.foreignColumn = fks.getString("FKCOLUMN_NAME");
				fkList.add(fk);
				fks.close();
				return true;
			}
		}
		fks.close();
		return false;
	}

	protected void printNames(ResultSet rs) throws Exception {
		System.out.println("------------------------");
		ResultSetMetaData md = rs.getMetaData();
		for (int i = 1; i <= md.getColumnCount(); i++) {
			System.out.println("Name: " + md.getColumnName(i) + " Value: "
					+ rs.getString(md.getColumnName(i)));
		}
	}

	protected void processColumn(Model model,
			org.eclipse.uml2.uml.Class entity, DatabaseMetaData dm,
			ResultSet columns, Connection connection, String tableName)
			throws Exception {
		if (isForeign(dm, columns)) {
			// @OneToMany
			// @ManyToOne
			// handeled by post processing
		} else {
			String columnName = columns.getString("COLUMN_NAME");
			String columnJavaType = getType(columns.getString("TYPE_NAME"));
			String propertyName = lowerCamel(columnName);
			String propertyNameLowerCase = propertyName.toLowerCase();
			Property property = createAttribute(entity, propertyName,
					getPrimitiveType(model, columnJavaType), 0, 1);

			// @Column()
			Stereotype column = applyStereotype(property,
					"javax.persistence.Column");
			property.setValue(column, "name", columnName);
			// unique True for UNIQUE columns false
			String nullable = columns.getInt("NULLABLE") == 0 ? "false"
					: "true";
			property.setValue(column, "nullable", nullable);
			if ("false".equalsIgnoreCase(nullable)) {
				applyStereotype(property, HibernateStereotype.validator_NotNull);
			}

			// set length
			int columnSize = 0;
			try {
				columnSize = Integer.parseInt(columns.getString("COLUMN_SIZE"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			property.setValue(column, "length", columnSize);

			if ("String".equalsIgnoreCase(columnJavaType) && columnSize > 0) {
				// Stereotype
				// ste_max=applyStereotype(property,HibernateStereotype.validator_Max);
				// property.setValue(ste_max, "value", columnSize);
				Stereotype ste_max = applyStereotype(property,
						HibernateStereotype.validator_Length);
				property.setValue(ste_max, "max", columnSize);
			}

			// set remark
			String remark = columns.getString("REMARKS");
			if (StrUtil.isBlank(remark)) {
				if (connection.getMetaData().getURL().indexOf("oracle") != -1) {
					remark = SqlUtil.getOracleColumnComment(tableName,
							columnName, connection);
				}
			}
			if (!StrUtil.isBlank(remark)) {
				if (property.getOwnedComments().isEmpty()) {
					property.createOwnedComment().setBody(remark);
				} else {
					property.getOwnedComments().clear();
					property.createOwnedComment().setBody(remark);
				}
			}

			// apply input stereotype
			if (DbReverseUtil.isApplyInput(propertyName)) {
				if (isPrimary(dm, columns)
						&& (propertyNameLowerCase.endsWith("id") || propertyNameLowerCase
								.endsWith("guid"))) {

				} else {
					Stereotype ste_input = applyStereotype(property,
							MdaStereotype.view_Input);
					// width
					int width = PageHelper.getMaxPixel(columnSize);
					property.setValue(ste_input, InputAnnotations.width
							.toString(), width);
					property.setValue(ste_input, InputAnnotations.sitewidth
							.toString(), width);

					// type cssClass
					InputKind type = InputKind.text;
					String cssClass = CssClassKind.text.toParam();
					if ("Date".equalsIgnoreCase(columnJavaType)) {
						type = InputKind.datePicker;
						cssClass = CssClassKind.text.toParam();
					} else if (columnSize > Config.defaultTitlePropertyLength_Min
							&& columnSize <= Config.defaultTitlePropertyLength_Max) {
						type = InputKind.title;
						cssClass = CssClassKind.title.toParam();
					} else if (columnSize > Config.defaultTextAreaPropertyLength_Min
							&& columnSize <= Config.defaultTextAreaPropertyLength_Max) {
						type = InputKind.textarea;
						cssClass = CssClassKind.textarea.toParam();
					} else if (columnSize > Config.defaultContentPropertyLength_min) {
						type = InputKind.contenttab;
						cssClass = CssClassKind.content.toParam();
					}
					Element inputKindEnum = getElement(model,
							MdaStereotype.view_InputKind);
					if (null != inputKindEnum) {
						EnumerationLiteral s_inputKind = ((Enumeration) inputKindEnum)
								.getOwnedLiteral(type.toString());
						property.setValue(ste_input, InputAnnotations.type
								.toString(), s_inputKind);
						property.setValue(ste_input, InputAnnotations.sitetype
								.toString(), s_inputKind);
					}

					// property.setValue(ste_input,
					// InputAnnotations.type.toString(), type);
					property.setValue(ste_input, InputAnnotations.cssClass
							.toString(), cssClass);

					// for site
					// property.setValue(ste_input,
					// InputAnnotations.sitetype.toString(), type);
					property.setValue(ste_input, InputAnnotations.sitecssClass
							.toString(), cssClass);
					// validate

					// readonly
					if (DbReverseUtil.isApplyInputReadonly(propertyName)) {
						property.setValue(ste_input, "readonly", "true");
					}
				}

			}
			// apply list sterotype
			if (DbReverseUtil.isApplyList(propertyName)) {
				if (isPrimary(dm, columns)
						&& !propertyNameLowerCase.endsWith("cid")) {
					// auto generate id
				} else {
					if (columnSize < Config.defaultTextAreaPropertyLength_Max) {
						Stereotype ste_list = applyStereotype(property,
								MdaStereotype.view_List);
						int textPixed = PageHelper.getMaxPixel(columnSize);
						property.setValue(ste_list, ListAnnotations.width
								.toString(), textPixed);
						property.setValue(ste_list, ListAnnotations.sitewidth
								.toString(), textPixed);
						// sortable
						if (columnSize > Config.defaultTitlePropertyLength_Max) {
							property.setValue(ste_list,
									ListAnnotations.sortable.toString(), false);
							property.setValue(ste_list,
									ListAnnotations.sitesortable.toString(),
									false);
						}
					}
				}
			}

			// apply listKind sterotype
			if (DbReverseUtil.isApplyListKind(propertyName)) {
				applyStereotype(property, MdaStereotype.view_ListKind);
			}

			// apply search sterotype
			if (("String".equalsIgnoreCase(columnJavaType)
					|| "Date".equalsIgnoreCase(columnJavaType) || "Boolean"
					.equalsIgnoreCase(columnJavaType))
					&& columnSize < Config.defaultTextAreaPropertyLength_Min
					&& DbReverseUtil.isApplySearch(propertyName)) {
				Stereotype ste_search = applyStereotype(property,
						MdaStereotype.view_Search);
				if (null == remark || remark.trim().equals(""))
					remark = propertyName;
				property.setValue(ste_search, SearchAnnotations.searchTextLabel
						.toString(), remark);
				if ("Date".equalsIgnoreCase(columnJavaType)) {
					property.setValue(ste_search, SearchAnnotations.searchText
							.toString(), propertyName
							+ DbReverseConfig.dateFieldFirstSuffix);
					property.setValue(ste_search,
							SearchAnnotations.searchTextTwo.toString(),
							propertyName
									+ DbReverseConfig.dateFieldSecondSuffix);
					property.setValue(ste_search, SearchAnnotations.operator
							.toString(), Operator.between.toParam());
					// for site
					property.setValue(ste_search, SearchAnnotations.siteenabled
							.toString(), true);
				} else {
					property.setValue(ste_search, SearchAnnotations.searchText
							.toString(), propertyName);
				}
			}

			applyMoreStereotype(property, propertyName);
			// precision the default length for a number definition for a CREATE
			// TABLE 0
			// scale

			// insertable True if column is inserted on a create call true
			// updatable True if column is updated when the field is modified
			// false
			// columnDefinition SQL to create the column in a CREATE TABLE none

			// table specified if column is stored in a secondary table none

			// @Id
			// @GeneratedValue - maybe not
			if (isPrimary(dm, columns)) {
				applyStereotype(property, "javax.persistence.Id");
				Stereotype generateValue = applyStereotype(property,
						"javax.persistence.GeneratedValue");
				if (propertyNameLowerCase.endsWith("cid")
						|| "Long".equalsIgnoreCase(columnJavaType)
						|| "Integer".equalsIgnoreCase(columnJavaType)) {
					property.setValue(generateValue, "strategy", null);
					property.setValue(generateValue, "generator",
							"hibernate-assigned");
					Stereotype gemerocGenerator = applyStereotype(property,
							"org.hibernate.annotations.GenericGenerator");
					property.setValue(gemerocGenerator, "name",
							"hibernate-assigned");
					property.setValue(gemerocGenerator, "strategy", "assigned");
				}/*
				 * if("Long".equalsIgnoreCase(columnJavaType)||"Integer".equalsIgnoreCase
				 * (columnJavaType)){//auto Element generationType =
				 * getElement(model, "javax.persistence.GenerationType"); if
				 * (null != generationType) { EnumerationLiteral fetchTypeLazy =
				 * ((Enumeration) generationType).getOwnedLiteral("AUTO");
				 * property.setValue(generateValue, "strategy", fetchTypeLazy);
				 * } }
				 */else if (propertyNameLowerCase.endsWith("id")
						|| propertyNameLowerCase.endsWith("guid")) {// guid
					property.setValue(generateValue, "strategy", null);
					property.setValue(generateValue, "generator",
							"hibernate-uuid");
					Stereotype gemerocGenerator = applyStereotype(property,
							"org.hibernate.annotations.GenericGenerator");
					property.setValue(gemerocGenerator, "name",
							"hibernate-uuid");
					property.setValue(gemerocGenerator, "strategy", "uuid");
				} else {
					property.setValue(generateValue, "strategy", null);
					property.setValue(generateValue, "generator",
							"hibernate-assigned");
					Stereotype gemerocGenerator = applyStereotype(property,
							"org.hibernate.annotations.GenericGenerator");
					property.setValue(gemerocGenerator, "name",
							"hibernate-assigned");
					property.setValue(gemerocGenerator, "strategy", "assigned");
				}

				// 添加唯一性约束
				if (StereotypeHelper.isStereotypeApplied(property,
						"javax.persistence.Column")) {
					Stereotype pColumn = StereotypeHelper.getStereotype(
							property, "javax.persistence.Column");
					property.setValue(pColumn, "unique", "true");
				}
			}

			// print("Column.digits", columns.getString("DECIMAL_DIGITS"));
			// print("Column.remarks", columns.getString("REMARKS"));
			//
			// print("Column.bufLength", columns.getString("BUFFER_LENGTH"));
			// print("Column.numPrecRad", columns.getString("NUM_PREC_RADIX"));
			// print("Column.columnDef", columns.getString("COLUMN_DEF"));
			// print("Column.sqlDataType", columns.getString("SQL_DATA_TYPE"));
			// print("Column.sqlDateTimeSub",
			// columns.getString("SQL_DATETIME_SUB"));
			// print("Column.charOcLen",
			// columns.getString("CHAR_OCTET_LENGTH"));
			// print("Column.ordinal", columns.getString("ORDINAL_POSITION"));
		}
	}

	protected void processColumnsBySql(Model model,
			org.eclipse.uml2.uml.Class entity, ResultSetMetaData rsmt,
			Connection connection) throws Exception {
		// 获得所有列的数目及实际列数
		int columnCount = rsmt.getColumnCount();
		for (int i = 1; i <= columnCount; i++) {
//			String columnName = rsmt.getColumnName(i);// 获得指定列的列名
			String columnName = rsmt.getColumnLabel(i);
			int columnType = rsmt.getColumnType(i);// 获得指定列的数据类型
			String columnTypeName = rsmt.getColumnTypeName(i);// 获得指定列的数据类型名
			String catalogName = rsmt.getCatalogName(i);// 所在的Catalog名字
			String columnClassName = rsmt.getColumnClassName(i);// 对应数据类型的类
			int columnDisplaySize = rsmt.getColumnDisplaySize(i);// 在数据库中类型的最大字符个数
			String columnLabel = rsmt.getColumnLabel(i);// 默认的列的标题
			String schemaName = rsmt.getSchemaName(i);// 获得列的模式
			int precision = rsmt.getPrecision(i);// 某列类型的精确度(类型的长度)
			int scale = rsmt.getScale(i);// 小数点后的位数
			String tableName = rsmt.getTableName(i);// 获取某列对应的表名
			boolean isAutoInctement = rsmt.isAutoIncrement(i);// 是否自动递增
			boolean isCurrency = rsmt.isCurrency(i);// 在数据库中是否为货币型
			int isNullable = rsmt.isNullable(i);// 是否为空
			boolean isReadOnly = rsmt.isReadOnly(i);// 是否为只读
			boolean isSearchable = rsmt.isSearchable(i);// 能否出现在where中
			// java property
			String columnJavaType = getType(columnTypeName);
			String propertyName = lowerCamel(columnName);
			String propertyNameLowerCase = propertyName.toLowerCase();
			Property property = createAttribute(entity, propertyName,
					getPrimitiveType(model, columnJavaType), 0, 1);
			// apply column
			Stereotype column = applyStereotype(property,
					"javax.persistence.Column");
			property.setValue(column, "name", columnName);
			// unique True for UNIQUE columns false
			String nullable = isNullable == 0 ? "false" : "true";
			property.setValue(column, "nullable", nullable);
			if ("false".equalsIgnoreCase(nullable)) {
				applyStereotype(property, HibernateStereotype.validator_NotNull);
			}
			// set length
			int columnSize = 0;
			try {
				columnSize = columnDisplaySize;
			} catch (Exception e) {
				e.printStackTrace();
			}
			property.setValue(column, "length", columnSize);
			// apply max
			if ("String".equalsIgnoreCase(columnJavaType) && columnSize > 0) {
				Stereotype stereotype_max = applyStereotype(property,
						HibernateStereotype.validator_Length);
				property.setValue(stereotype_max, "max", columnSize);
			}
			// set remark
			String remark = columnLabel;
			if (!StrUtil.isBlank(remark)) {
				if (property.getOwnedComments().isEmpty()) {
					property.createOwnedComment().setBody(remark);
				} else {
					property.getOwnedComments().clear();
					property.createOwnedComment().setBody(remark);
				}
			}
			// apply input stereotype
			if (DbReverseUtil.isApplyInput(propertyName)) {
				Stereotype ste_input = applyStereotype(property,
						MdaStereotype.view_Input);
				// width
				int width = PageHelper.getMaxPixel(columnSize);
				property.setValue(ste_input, InputAnnotations.width.toString(),
						width);
				property.setValue(ste_input, InputAnnotations.sitewidth
						.toString(), width);

				// type cssClass
				InputKind type = InputKind.text;
				String cssClass = CssClassKind.text.toParam();
				if ("Date".equalsIgnoreCase(columnJavaType)) {
					type = InputKind.datePicker;
					cssClass = CssClassKind.text.toParam();
				} else if (columnSize > Config.defaultTitlePropertyLength_Min
						&& columnSize <= Config.defaultTitlePropertyLength_Max) {
					type = InputKind.title;
					cssClass = CssClassKind.title.toParam();
				} else if (columnSize > Config.defaultTextAreaPropertyLength_Min
						&& columnSize <= Config.defaultTextAreaPropertyLength_Max) {
					type = InputKind.textarea;
					cssClass = CssClassKind.textarea.toParam();
				} else if (columnSize > Config.defaultContentPropertyLength_min) {
					type = InputKind.contenttab;
					cssClass = CssClassKind.content.toParam();
				}
				property.setValue(ste_input, InputAnnotations.cssClass
						.toString(), cssClass);
				// for site
				property.setValue(ste_input, InputAnnotations.sitecssClass
						.toString(), cssClass);
				// set type
				Element inputKindEnum = getElement(model,
						MdaStereotype.view_InputKind);
				if (null != inputKindEnum) {
					EnumerationLiteral s_inputKind = ((Enumeration) inputKindEnum)
							.getOwnedLiteral(type.toString());
					property.setValue(ste_input, InputAnnotations.type
							.toString(), s_inputKind);
					property.setValue(ste_input, InputAnnotations.sitetype
							.toString(), s_inputKind);
				}
				// readonly
				if (DbReverseUtil.isApplyInputReadonly(propertyName)) {
					property.setValue(ste_input, "readonly", "true");
				}
			}
			// apply list sterotype
			if (DbReverseUtil.isApplyList(propertyName)) {
				if (columnSize < Config.defaultTextAreaPropertyLength_Max) {
					Stereotype ste_list = applyStereotype(property,
							MdaStereotype.view_List);
					int textPixed = PageHelper.getMaxPixel(columnSize);
					property.setValue(ste_list, ListAnnotations.width
							.toString(), textPixed);
					property.setValue(ste_list, ListAnnotations.sitewidth
							.toString(), textPixed);
					// sortable
					if (columnSize > Config.defaultTitlePropertyLength_Max) {
						property.setValue(ste_list, ListAnnotations.sortable
								.toString(), false);
						property.setValue(ste_list,
								ListAnnotations.sitesortable.toString(), false);
					}
				}
			}

			// apply listKind sterotype
			if (DbReverseUtil.isApplyListKind(propertyName)) {
				applyStereotype(property, MdaStereotype.view_ListKind);
			}

			// apply search sterotype
			if (("String".equalsIgnoreCase(columnJavaType)
					|| "Date".equalsIgnoreCase(columnJavaType) || "Boolean"
					.equalsIgnoreCase(columnJavaType))
					&& columnSize < Config.defaultTextAreaPropertyLength_Min
					&& DbReverseUtil.isApplySearch(propertyName)) {
				Stereotype ste_search = applyStereotype(property,
						MdaStereotype.view_Search);
				if (null == remark || remark.trim().equals(""))
					remark = propertyName;
				property.setValue(ste_search, SearchAnnotations.searchTextLabel
						.toString(), remark);
				if ("Date".equalsIgnoreCase(columnJavaType)) {
					property.setValue(ste_search, SearchAnnotations.searchText
							.toString(), propertyName
							+ DbReverseConfig.dateFieldFirstSuffix);
					property.setValue(ste_search,
							SearchAnnotations.searchTextTwo.toString(),
							propertyName
									+ DbReverseConfig.dateFieldSecondSuffix);
					property.setValue(ste_search, SearchAnnotations.operator
							.toString(), Operator.between.toParam());
					// for site
					property.setValue(ste_search, SearchAnnotations.siteenabled
							.toString(), true);
				} else {
					property.setValue(ste_search, SearchAnnotations.searchText
							.toString(), propertyName);
				}
			}

			applyMoreStereotype(property, propertyName);
		}
	}

	private void applyMoreStereotype(Property property, String propertyName) {
		// email:true
		if (propertyName.equalsIgnoreCase("email")) {
			applyStereotype(property, HibernateStereotype.validator_Email);
		}
		// idCardNo:true
		if (propertyName.equalsIgnoreCase("idCardNo")) {
			applyStereotype(property, MdaStereotype.validate_IdCardNo);
		}
		// letterNum
		if (propertyName.equalsIgnoreCase("letterNum")) {
			applyStereotype(property, MdaStereotype.validate_letterNum);
		}
		// mobile:true
		if (propertyName.equalsIgnoreCase("mobile")) {
			applyStereotype(property, MdaStereotype.validate_Mobile);
		}
		// phone:true
		if (propertyName.equalsIgnoreCase("phone")) {
			applyStereotype(property, MdaStereotype.validate_Phone);
		}

		// tel
		if (propertyName.equalsIgnoreCase("tel")) {
			applyStereotype(property, MdaStereotype.validate_Tel);
		}

	}

	protected String getType(String type) {
		type = type.toUpperCase();
		if (type.equals("FLOAT") || type.equals("DECIMAL")
				|| type.equals("REAL") || type.equals("DOUBLE")
				|| type.equals("NUMERIC") || type.startsWith("NUMBER(")) {
			return "Double";
		}
		if (type.equals("LONG") || type.equals("BIGINT")
				|| type.equals("NUMBER")) {
			return "Long";
		}
		if (type.equals("INT") || type.equals("INTEGER")
				|| type.equals("SMALLINT")) {
			return "Integer";
		}
		if (type.equals("BIT")) {
			return "Boolean";
		}
		if (type.equals("DATETIME") || type.equals("DATE")
				|| type.equals("TIME") || type.equals("TIMESTAMP")) {
			return "Date";
		}
		if (type.equals("BINARY") || type.equals("VARBINARY")
				|| type.equals("LONGVARBINARY") || type.equals("BLOB")) {
			return "Byte[]";
		}
		return "String";
	}

	private Element getElement(Package pkg, String name) {
		EList<Profile> profiles = pkg.getAppliedProfiles();
		for (Profile profile : profiles) {
			Element element = profile.getOwnedMember(name);
			if (null != element)
				return element;
		}
		return null;
	}

	protected void processForeignKey(Package pkg, Model model) {
		for (ForeignKey fk : fkList) {
			// System.out.println("---------");
			// System.out.println("pkt: " + fk.primaryTable);
			// System.out.println("pkc: " + fk.primaryColumn);
			// System.out.println("fkt: " + fk.foreignTable);
			// System.out.println("fkc: " + fk.foreignColumn);
			Class fkt = (Class) pkg.getOwnedType(upperCamel(fk.foreignTable));
			String manySideName = lowerCamel(fk.foreignTable) + "s";
			String oneSideName = lowerCamel(fk.primaryTable);

			Class pkt = (Class) pkg.getOwnedType(upperCamel(fk.primaryTable));
			if (null == pkt) {
				Property pkProperty = createAttribute(fkt, oneSideName + "Id",
						getPrimitiveType(model, "String"), 0, 1);
				// Stereotype jc = applyStereotype(pkProperty,
				// "javax.persistence.JoinColumn");
				// pkProperty.setValue(jc, "name", fk.foreignColumn);
				// Stereotype m2o = applyStereotype(pkProperty,
				// "javax.persistence.ManyToOne");

			} else {
				Property oneSideproperty = fkt.getOwnedAttribute(oneSideName,
						pkt);
				if (null != oneSideproperty) {
					oneSideproperty.destroy();
				}
				Property manySideproperty = pkt.getOwnedAttribute(manySideName,
						fkt);
				if (null != manySideproperty) {
					manySideproperty.destroy();
				}
				Association assoc = createAssociation(pkt, true,
						AggregationKind.COMPOSITE_LITERAL, manySideName, 0, -1,
						fkt, true, AggregationKind.NONE_LITERAL, oneSideName,
						0, 1);
				Property manyEnd = assoc.getMemberEnd(oneSideName, assoc
						.getEndType(oneSideName));

				// @JoinColumn(name = "order_id")
				Stereotype jc = applyStereotype(manyEnd,
						"javax.persistence.JoinColumn");
				manyEnd.setValue(jc, "name", fk.foreignColumn);
				manyEnd.setValue(jc, "nullable", false);

				// m2o stereotype manyToOne
				Stereotype m2o = applyStereotype(manyEnd,
						"javax.persistence.ManyToOne");
				// Stereotype
				// fetchType=getStereotype(manyEnd,"javax.persistence.FetchType");
				// set fetchType
				Element fetchType = getElement(model,
						"javax.persistence.FetchType");
				if (null != fetchType) {
					EnumerationLiteral fetchTypeLazy = ((Enumeration) fetchType)
							.getOwnedLiteral("LAZY");
					manyEnd.setValue(m2o, "fetch", fetchTypeLazy);
				}
				// set cascadeType
				Element cascadeType = getElement(model,
						"javax.persistence.CascadeType");
				if (null != cascadeType) {
					EnumerationLiteral[] cascadeTypes = new EnumerationLiteral[2];
					cascadeTypes[0] = ((Enumeration) cascadeType)
							.getOwnedLiteral("PERSIST");
					manyEnd.setValue(m2o, "cascade", cascadeTypes[0]);
					manyEnd.setValue(m2o, "cascade", cascadeTypes[1]);
				}

				// apply tree
				if (EntityHelper.hasParentIdProperty(pkt)) {
					applyStereotype(pkt, MdaStereotype.model_Tree);
					applyStereotype(manyEnd, MdaStereotype.M2OSelect);
				} else {
					applyStereotype(manyEnd, MdaStereotype.M2OSelectPage);
				}

				// apply list list
				applyStereotype(manyEnd, MdaStereotype.view_List);

				// apply list search
				// applyStereotype(manyEnd, MdaStereotype.view_Search);

				Property oneEnd = assoc.getMemberEnd(manySideName, assoc
						.getEndType(manySideName));
				Stereotype o2m = applyStereotype(oneEnd,
						"javax.persistence.OneToMany");
				// oneEnd.setValue(o2m, "mappedBy", fk.foreignTable);
				oneEnd.setValue(o2m, "mappedBy", NameHelper
						.getUncapName(manyEnd));
				if (null != fetchType) {
					EnumerationLiteral enumerationLiteral = ((Enumeration) fetchType)
							.getOwnedLiteral("LAZY");
					oneEnd.setValue(o2m, "fetch", enumerationLiteral);
				}
				if (null != cascadeType) {
					EnumerationLiteral cascadeTypeRemove = ((Enumeration) cascadeType)
							.getOwnedLiteral("REMOVE");
					oneEnd.setValue(o2m, "cascade", cascadeTypeRemove);
				}

			}
		}
	}
}
