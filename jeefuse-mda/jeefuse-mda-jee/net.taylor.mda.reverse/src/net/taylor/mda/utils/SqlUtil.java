package net.taylor.mda.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlUtil {

	static public String getMysqlTableComment(String tableName, Connection conn) {
		Statement st = null;
		ResultSet rs = null;
		String result = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery("SELECT TABLE_COMMENT FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME='" + tableName
					+ "'");
			while (rs.next()) {
				result = rs.getString(1);
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				rs = null;
				if (st != null)
					st.close();
				st = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public static String getOracleTableComment(String tableName, Connection conn) {
		Statement st = null;
		ResultSet rs = null;
		String result = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery("select   t.comments   from   user_tab_comments t where t.table_name='" + tableName
					+ "'");
			while (rs.next()) {
				result = rs.getString(1);
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				rs = null;
				if (st != null)
					st.close();
				st = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public static String getOracleColumnComment(String tableName, String columnName, Connection conn) {
		Statement st = null;
		ResultSet rs = null;
		String result = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery("select   t.comments  from   user_col_comments  t where t.table_name='" + tableName
					+ "' and t.column_name='" + columnName + "'");
			while (rs.next()) {
				result = rs.getString(1);
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				rs = null;
				if (st != null)
					st.close();
				st = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
