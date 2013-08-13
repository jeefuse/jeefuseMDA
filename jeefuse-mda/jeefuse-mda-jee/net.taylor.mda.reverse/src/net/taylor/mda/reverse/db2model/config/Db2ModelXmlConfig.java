package net.taylor.mda.reverse.db2model.config;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.taylor.mda.generator.parse.LogUtil;
import net.taylor.mda.generator.parse.StringUtils;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Db2ModelXmlConfig {
	private static final String defaultConfigFilePath = "importDbToModel.xml";
	private String configFilePath = defaultConfigFilePath;
	Jdbc jdbc = null;
	List<ImportTable> importList = null;

	/**
	 * import Db to model 配置.
	 */
	public Db2ModelXmlConfig(String configFile) {
		if (null != configFile && !configFile.trim().equals("")) {
			configFilePath = configFile;
		}
		File file = new File(configFilePath);
		initConfig(file);
	}


	private Document loadDocument(File file) {
		Document document = null;
		try {
			SAXReader saxReader = new SAXReader();
			document = saxReader.read(file);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return document;
	}

	@SuppressWarnings("unchecked")
	private void initConfig(File configFile) {
		Document document = loadDocument(configFile);
		// setting jdbc
		jdbc = new Jdbc();
		List jdbcList = document.selectNodes("/DbToModel/jdbc");
		if (null != jdbcList) {
			Element jdbcEle = (Element) jdbcList.get(0);
			Iterator paramEles = jdbcEle.elementIterator("param");
			while (paramEles.hasNext()) {
				Element param = (Element) paramEles.next();
				String name = param.attribute("name").getValue();
				String value = param.getText();
				if ("url".equals(name)) {
					jdbc.setUrl(value);
				} else if ("driver".equals(name)) {
					jdbc.setDriver(value);
				} else if ("password".equals(name)) {
					jdbc.setPassword(value);
				} else if ("username".equals(name)) {
					jdbc.setUsername(value);
				} else if ("schema".equals(name)) {
					jdbc.setSchema(value);
				}
			}
		}
		// setting import
		importList = new ArrayList<ImportTable>();
		List<Element> importConfigList = document.selectNodes("/DbToModel/import");
		Iterator<Element> importConfigIT = importConfigList.iterator();
		while (importConfigIT.hasNext()) {
			Element importConfig = (Element) importConfigIT.next();
			ImportTable importModel = new ImportTable();
			String packageName = importConfig.attribute("packageName").getValue();
			importModel.setPackageName(packageName);
			//add table
			Iterator<Element> tableFilterEleIt = importConfig.elementIterator("table-filter");
			while (tableFilterEleIt.hasNext()) {
				Element tableFilterEle = (Element) tableFilterEleIt.next();
				String tableMatch = tableFilterEle.attributeValue("match-name");
				if(StringUtils.isNotBlank(tableMatch)){
					importModel.addTableMatchs(tableMatch);
				}
			}
			//add sql
			Iterator sqlIt = importConfig.elementIterator("sql");
			while (sqlIt.hasNext()) {
				Element sqlele = (Element) sqlIt.next();
				String name = sqlele.attributeValue("name");
				if(null!=name&&!name.trim().equals("")){
					String sql=sqlele.getText();
					if(StringUtils.isNotBlank(sql)){
						importModel.addImpSql(name, sql);
					}
				}
			}
			//add to import list
			importList.add(importModel);
		}
	}


	public String getConfigFilePath() {
		return configFilePath;
	}


	public void setConfigFilePath(String configFilePath) {
		this.configFilePath = configFilePath;
	}


	public Jdbc getJdbc() {
		return jdbc;
	}


	public void setJdbc(Jdbc jdbc) {
		this.jdbc = jdbc;
	}


	public List<ImportTable> getImportList() {
		return importList;
	}


	public void setImportList(List<ImportTable> importList) {
		this.importList = importList;
	}

}
