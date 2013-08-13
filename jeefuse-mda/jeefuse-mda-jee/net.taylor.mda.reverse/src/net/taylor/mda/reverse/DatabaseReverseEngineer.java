package net.taylor.mda.reverse;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Driver;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import net.taylor.mda.utils.StrUtil;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.osgi.framework.Bundle;


public class DatabaseReverseEngineer extends ModelReverseEngineer {

	public InputStream createModel(IProgressMonitor monitor, String jarPath, String driver, String url, String schema,
			String name) {
		try {
			registerResourceFactories();
			//goal = "jar:file:/" + path + "/plugins/org.eclipse.uml2.uml.resources_<version>.jar!/"
			Bundle b = Platform.getBundle("org.eclipse.uml2.uml.resources");
			String location = b.getLocation();
			location = location.replace("reference", "jar");
			location = location + "!/";
			registerPathmaps(URI.createURI(location));

			out("Creating model...");
			Model model = createModel(name, URI.createURI("model").appendSegment(name).appendFileExtension(
					UMLResource.FILE_EXTENSION));
			// these are for unit testing
			// importProfile(
			// model,
			// "file://C:/workspaces/taylor/taylor.mda3.workspace/net.taylor.mda.profiles/profiles/Persistence.profile.uml");
			// importProfile(
			// model,
			// "file://C:/workspaces/taylor/taylor.mda3.workspace/net.taylor.mda.profiles/profiles/types.profile.uml");

			Connection connection = getConnection(jarPath, driver, url);
			DatabaseMetaData dm = connection.getMetaData();

			// TODO consider doing this instead
			// String[] types = {"TABLE"};
			// ResultSet rs = dm.getTables(null,null,"%",types);

			ResultSet catalogs = dm.getCatalogs();
			if (catalogs.next()) {
				processByCatalog(connection, dm, schema, monitor, model);
			} else {
				processBySchema(connection, dm, schema, monitor, model);
			}
			catalogs.close();
			connection.close();

			out("Saving model...");
			return toInputStream(model, URI.createURI("model").appendSegment(name).appendFileExtension(
					UMLResource.FILE_EXTENSION));
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
	protected void processBySchema(Connection connection, DatabaseMetaData dm, String schema, IProgressMonitor monitor,
			Model model) throws Throwable {
		Package pkg = createPackage(model, schema);
		setCount(monitor, dm, null, schema);
		ResultSet tables = dm.getTables(null, schema, "%", null);
		while (tables.next()) {
			org.eclipse.uml2.uml.Class entity = processTable(pkg, tables);

			String name = tables.getString("TABLE_NAME");
			out("Processing Table: " + name);
			ResultSet columns = dm.getColumns(null, schema, name, "%");
			while (columns.next()) {
				processColumn(model, entity, dm, columns);
			}
			columns.close();
			monitor.worked(1);
		}
		processForeignKey(pkg);
		tables.close();
	}

	/**
	 * Some databases, such as oracle, return nothing for dm.getSchemas()
	 */
	protected void processByCatalog(Connection connection, DatabaseMetaData dm, String schema,
			IProgressMonitor monitor, Model model) throws Throwable {

		ResultSet catalogs = dm.getCatalogs();
		while (catalogs.next()) {
			String catalog = catalogs.getString("TABLE_CAT");
			if (!connection.getCatalog().equals(catalog)) {
				continue;
			}

			Package pkg = createPackage(model, catalog);
			setCount(monitor, dm, catalog, schema);
			ResultSet tables = dm.getTables(catalog, schema, "%", null);
			while (tables.next()) {
				org.eclipse.uml2.uml.Class entity = processTable(pkg, tables);
				ResultSet columns = dm.getColumns(catalog, schema, tables.getString("TABLE_NAME"), "%");
				while (columns.next()) {
					processColumn(model, entity, dm, columns);
				}
				columns.close();
				monitor.worked(1);
			}
			processForeignKey(pkg);
			tables.close();
		}
		catalogs.close();
	}

	protected void setCount(IProgressMonitor monitor, DatabaseMetaData dm, String catalog, String schema)
			throws Exception {
		ResultSet tables = dm.getTables(catalog, schema, "%", null);
		int count = 0;
		while (tables.next()) {
			count++;
		}
		tables.close();
		monitor.beginTask("Processing (" + count + ") Tables", count);
	}

	protected Connection getConnection(String jarPath, String driver, String url) throws Exception {
		URL[] jars = new URL[1];
		jars[0] = new File(jarPath).toURL();
		ClassLoader cl = URLClassLoader.newInstance(jars, this.getClass().getClassLoader());
		Driver jdbcDriver = (Driver) cl.loadClass(driver).newInstance();
		return jdbcDriver.connect(url, new Properties());
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
					result += temp.substring(0, 1).toUpperCase() + temp.substring(1);
				}
				return result;
			} else {
				//return name.substring(0, 1).toUpperCase() + name.substring(1);
				String temp = name.toLowerCase();
				return temp.substring(0, 1).toUpperCase() + temp.substring(1);
			}
		}
	}

	protected String lowerCamel(String name) {
		if (name.length() == 0) {
			return name;
		} else if (!name.contains("_")) {
			//return name.substring(0, 1).toLowerCase() + name.substring(1);
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
					result += temp.substring(0, 1).toUpperCase() + temp.substring(1);
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

		out("Primitive type '" + primitiveType.getQualifiedName() + "' imported.");

		return primitiveType;
	}

	protected Class processTable(Package pkg, ResultSet tables) throws Exception {
		String tableName = tables.getString("TABLE_NAME");
		Class entity = createClass(pkg, upperCamel(tableName), false);
		// entity = (Class) pkg.getOwnedType(tableName);
		applyStereotype(entity, "javax.persistence.Entity");
		Stereotype table = applyStereotype(entity, "javax.persistence.Table");
		out("Table Stereotype: " + table.toString());
		// @Table
		// uniqueConstraint unique constraints during generation none
		entity.setValue(table, "name", tableName);
		entity.setValue(table, "catalog", tables.getString("TABLE_CAT"));
		entity.setValue(table, "schema", tables.getString("TABLE_SCHEM"));
		//add comment
		String remark = tables.getString("REMARKS");
		if (!StrUtil.isBlank(remark))
			entity.createOwnedComment().setBody(remark);

		// print("Table.type", tables.getString("TABLE_TYPE"));
		// print("Table.remarks", tables.getString("REMARKS"));
		return entity;
	}

	protected boolean isPrimary(DatabaseMetaData dm, ResultSet columns) throws Exception {
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

	protected boolean isForeign(DatabaseMetaData dm, ResultSet columns) throws Exception {
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
			System.out.println("Name: " + md.getColumnName(i) + " Value: " + rs.getString(md.getColumnName(i)));
		}
	}

	protected void processColumn(Model model, org.eclipse.uml2.uml.Class entity, DatabaseMetaData dm, ResultSet columns)
			throws Exception {
		if (isForeign(dm, columns)) {
			// @OneToMany
			// @ManyToOne
			// handeled by post processing
		} else {
			Property property = createAttribute(entity, lowerCamel(columns.getString("COLUMN_NAME")), getPrimitiveType(
					model, getType(columns.getString("TYPE_NAME"))), 0, 1);
			Stereotype column = applyStereotype(property, "javax.persistence.Column");
			// @Column()
			property.setValue(column, "name", columns.getString("COLUMN_NAME"));
			// unique True for UNIQUE columns false
			property.setValue(column, "nullable", columns.getInt("NULLABLE") == 0 ? "false" : "true");
			property.setValue(column, "length", columns.getString("COLUMN_SIZE"));
			String remark = columns.getString("REMARKS");
			if (!StrUtil.isBlank(remark))
				property.createOwnedComment().setBody(remark);

			int columnSize = 0;
			try {
				columnSize = Integer.parseInt(columns.getString("COLUMN_SIZE"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			String columnJavaType = getType(columns.getString("TYPE_NAME"));

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
				applyStereotype(property, "javax.persistence.GeneratedValue");
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

	protected String getType(String type) {
		type = type.toUpperCase();
		if (type.equals("FLOAT") || type.equals("DECIMAL") || type.equals("REAL") || type.equals("DOUBLE")
				|| type.equals("NUMERIC")) {
			return "Double";
		}
		if (type.equals("SMALLINT") || type.equals("BIGINT") || type.equals("INTEGER")) {
			return "Long";
		}
		if (type.equals("BIT")) {
			return "Boolean";
		}
		if (type.equals("DATETIME") || type.equals("DATE") || type.equals("TIME") || type.equals("TIMESTAMP")) {
			return "Date";
		}
		if (type.equals("BINARY") || type.equals("VARBINARY") || type.equals("LONGVARBINARY") || type.equals("BLOB")) {
			return "Byte[]";
		}
		return "String";
	}

	protected void processForeignKey(Package pkg) {
		for (ForeignKey fk : fkList) {
			// System.out.println("---------");
			// System.out.println("pkt: " + fk.primaryTable);
			// System.out.println("pkc: " + fk.primaryColumn);
			// System.out.println("fkt: " + fk.foreignTable);
			// System.out.println("fkc: " + fk.foreignColumn);
			Class pkt = (Class) pkg.getOwnedType(upperCamel(fk.primaryTable));
			Class fkt = (Class) pkg.getOwnedType(upperCamel(fk.foreignTable));

			String manySideName = lowerCamel(fk.foreignTable) + "s";
			String oneSideName = lowerCamel(fk.primaryTable);

			Association assoc = createAssociation(pkt, true, AggregationKind.COMPOSITE_LITERAL, manySideName, 0, -1,
					fkt, true, AggregationKind.NONE_LITERAL, oneSideName, 0, 1);
			Element manyEnd = assoc.getMemberEnd(oneSideName, assoc.getEndType(oneSideName));

			// @JoinColumn(name = "order_id")
			Stereotype jc = applyStereotype(manyEnd, "javax.persistence.JoinColumn");
			manyEnd.setValue(jc, "name", fk.foreignColumn);

			Stereotype m2o = applyStereotype(manyEnd, "javax.persistence.ManyToOne");
			//manyEnd.setValue(m2o, "Fetch",1 );

			Element oneEnd = assoc.getMemberEnd(manySideName, assoc.getEndType(manySideName));

			Stereotype o2m = applyStereotype(oneEnd, "javax.persistence.OneToMany");
			oneEnd.setValue(o2m, "mappedBy", fk.foreignTable);
		}
	}
}
