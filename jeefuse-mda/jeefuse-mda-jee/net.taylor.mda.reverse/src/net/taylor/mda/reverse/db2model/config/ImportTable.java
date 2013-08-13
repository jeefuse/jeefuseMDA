package net.taylor.mda.reverse.db2model.config;

import java.util.ArrayList;
import java.util.List;

public class ImportTable {

	private String packageName = null;
	private List<String> tableMatchs = null;
	private List<ImpSql> impSqls = null;

	public class ImpSql {
		private String name;
		private String sql;

		public ImpSql(String name, String sql) {
			this.name = name;
			this.sql = sql;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getSql() {
			return sql;
		}

		public void setSql(String sql) {
			this.sql = sql;
		}
	}

	public ImportTable() {
		tableMatchs = new ArrayList<String>();
		impSqls=new ArrayList<ImpSql>();
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public List<String> getTableMatchs() {
		return tableMatchs;
	}

	public void addTableMatchs(String tableMatch) {
		if (null == tableMatchs) {
			tableMatchs = new ArrayList<String>();
		}
		tableMatchs.add(tableMatch);
	}

	public void setTableMatchs(List<String> tableMatchs) {
		this.tableMatchs = tableMatchs;
	}

	public void addImpSql(String name, String sql) {
		if (null == impSqls) {
			impSqls = new ArrayList<ImpSql>();
		}
		impSqls.add(new ImpSql(name, sql));
	}

	public List<ImpSql> getImpSqls() {
		return impSqls;
	}

}
