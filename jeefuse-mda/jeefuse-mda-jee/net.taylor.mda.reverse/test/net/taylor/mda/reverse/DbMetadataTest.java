package net.taylor.mda.reverse;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import junit.framework.TestCase;

public class DbMetadataTest extends TestCase {

	public void testMetadata() throws Exception {
		// String driverClassName="oracle.jdbc.driver.OracleDriver";
		// String url="jdbc:oracle:thin:@localhost:1521:orcl";
//		String driverClassName = "org.gjt.mm.mysql.Driver";
//		String url = "jdbc:mysql://localhost/gldining?useUnicode=true&amp;characterEncoding=utf-8";
//		String username = "root";
//		String password = "congen321";
		 String driverClassName="oracle.jdbc.driver.OracleDriver";
		 String url="jdbc:oracle:thin:@192.168.100.100:1521:wlb";
		 String username="fastdev";
		 String password="fastdev123";
		Class.forName(driverClassName);
		Connection conn = DriverManager.getConnection(url, username, password);
		DatabaseMetaData dm = conn.getMetaData();

		ResultSet schema = dm.getSchemas();
		// ResultSet schema = dm.getSchemas("fastDev", "");
		while (schema.next()) {
			print("Schema", schema.toString());
		}
		schema.close();

		ResultSet catalogs = dm.getCatalogs();
		printNames(catalogs);
		print("conn catalog:", conn.getCatalog());
		while (catalogs.next()) {
			print("Catalog", catalogs.getString("TABLE_CAT"));
		}
		catalogs.close();

		// ResultSet tables = dm.getTables(null, "%", "%", null);
		ResultSet tables = dm.getTables(null, "FASTDEV", "%", null);
		// printNames(tables);
		while (tables.next()) {
			printTable(tables,conn);

			ResultSet columns = dm.getColumns(null, "%", tables.getString("TABLE_NAME"), "%");
			// printNames(columns);
			while (columns.next()) {
				printColumn(dm, columns);
			}
			columns.close();
		}
		tables.close();

	}



	protected void printNames(ResultSet rs) throws Exception {
		System.out.println(line);
		ResultSetMetaData md = rs.getMetaData();
		for (int i = 1; i <= md.getColumnCount(); i++)
			print("Name", md.getColumnName(i));
	}

	protected void print(String name, String value) {
		System.out.println(name + ": " + value);
	}

	static String line = "------------------------------";

	protected void printTable(ResultSet tables, Connection conn) throws Exception {
		System.out.println(line);
		// @Table
		// name The name of the table The unqualified class name.
		// catalog the table's catalog none
		// schema the table's schema none
		// uniqueConstraint unique constraints during generation none
		print("Table.name", tables.getString("TABLE_NAME"));
		print("Table.schema", tables.getString("TABLE_SCHEM"));
		print("Table.catalog", tables.getString("TABLE_CAT"));
		print("Table.type", tables.getString("TABLE_TYPE"));
		print("Table.remarks", tables.getString("REMARKS"));
		print("TABLE_CAT   : ", tables.getObject(1) + "");
		print("TABLE_SCHEM : ", tables.getObject(2) + "");
		print("TABLE_NAME  : ", tables.getObject(3) + "");
		print("TABLE_TYPE  : ", tables.getObject(4) + "");
		print("REMARKS     : ", tables.getObject(5) + "");
		
		//print("get table comment",getTableComment(tables.getString("TABLE_NAME"),conn)+"");
	}

	protected boolean isPrimary(DatabaseMetaData dm, ResultSet columns) throws Exception {
		ResultSet ids = dm.getPrimaryKeys(columns.getString("TABLE_SCHEM"), columns.getString("TABLE_CAT"), columns
				.getString("TABLE_NAME"));
		String name = columns.getString("COLUMN_NAME");
		while (ids.next()) {
			if (name.equals(ids.getString("COLUMN_NAME"))) {
				return true;
			}
		}
		return false;
	}

	protected boolean isForeign(DatabaseMetaData dm, ResultSet columns) throws Exception {
		ResultSet tables = dm.getTables(null, "%", "%", null);
		String name = columns.getString("COLUMN_NAME");
		while (tables.next()) {
			ResultSet fks = dm.getCrossReference(columns.getString("TABLE_CAT"), columns.getString("TABLE_SCHEM"),
					columns.getString("TABLE_NAME"), tables.getString("TABLE_CAT"), tables.getString("TABLE_SCHEM"),
					tables.getString("TABLE_NAME"));

			while (fks.next()) {
				if (name.equals(fks.getString("FKCOLUMN_NAME"))) {
					printNames(fks);
					// return true;
				}
			}
		}
		return false;
	}

	protected void printColumn(DatabaseMetaData dm, ResultSet columns) throws Exception {
		System.out.println(line);
		// @Column()
		// name The SQL name of the column the field name
		// unique True for UNIQUE columns false
		// nullable False for IS NOT NULL columns true
		// insertable True if column is inserted on a create call true
		// updatable True if column is updated when the field is modified false
		// columnDefinition SQL to create the column in a CREATE TABLE none
		// table specified if column is stored in a secondary table none
		// length the default length for a VARCHAR for a CREATE TABLE 255
		// precision the default length for a number definition for a CREATE
		// TABLE 0
		// scale

		// @Identity
		// @GeneratedValue - maybe not

		// @OneToMany
		// @ManyToOne
		isForeign(dm, columns);

		print("Column.name", columns.getString("COLUMN_NAME"));
		print("Column.primary", isPrimary(dm, columns) ? "Y" : "N");

		// TODO translate
		print("Column.type", columns.getString("TYPE_NAME"));
		print("Column.datatype", columns.getString("DATA_TYPE"));
		print("Column.size", columns.getString("COLUMN_SIZE"));
		print("Column.digits", columns.getString("DECIMAL_DIGITS"));
		print("Column.null", columns.getString("NULLABLE"));
		print("Column.remarks", columns.getString("REMARKS"));

		print("Column.bufLength", columns.getString("BUFFER_LENGTH"));
		print("Column.numPrecRad", columns.getString("NUM_PREC_RADIX"));
		print("Column.columnDef", columns.getString("COLUMN_DEF"));
		print("Column.sqlDataType", columns.getString("SQL_DATA_TYPE"));
		print("Column.sqlDateTimeSub", columns.getString("SQL_DATETIME_SUB"));
		print("Column.charOcLen", columns.getString("CHAR_OCTET_LENGTH"));
		print("Column.ordinal", columns.getString("ORDINAL_POSITION"));
		print("Column.isNullable", columns.getString("IS_NULLABLE"));
	}

}
