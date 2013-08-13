package net.taylor.mda.reverse.db2model.config;

public class Jdbc {
	String url = "";
	String driver = "";
	String schema = "";
	String catalog = "";
	String password = "";
	String username = "";

	public Jdbc() {
		
	}

	public Jdbc(String username, String password, String url, String driver, String schema, String catalog) {
		this.username = username;
		this.password = password;
		this.url = url;
		this.driver = driver;
		this.schema = schema;
		this.catalog = catalog;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getSchema() {
		return schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}

	public String getCatalog() {
		return catalog;
	}

	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}

	@Override
	public String toString() {
		return "Jdbc [catalog=" + catalog + ", driver=" + driver + ", password=" + password + ", schema=" + schema
				+ ", url=" + url + ", username=" + username + "]";
	}


}
