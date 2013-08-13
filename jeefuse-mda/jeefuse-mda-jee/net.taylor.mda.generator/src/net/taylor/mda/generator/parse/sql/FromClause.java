package net.taylor.mda.generator.parse.sql;

public class FromClause {

	private String tableName;
	private String tableNameAs;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getTableNameAs() {
		return tableNameAs;
	}

	public void setTableNameAs(String tableNameAs) {
		this.tableNameAs = tableNameAs;
	}

}
