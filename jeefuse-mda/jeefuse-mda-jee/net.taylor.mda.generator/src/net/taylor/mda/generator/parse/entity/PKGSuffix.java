package net.taylor.mda.generator.parse.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 包命名规则.
 * @author yonclv
 * @email yonclv@gmail.com
 */
public enum PKGSuffix {
	//entity
	model("model"),
	EntityField("model.parse"),
	EntityPropertyValueGet("model.parse"),
	Validate("model.validate"),
	vo("model"),
	sqlmap("model.sqlmap"),
	enumeration("model.enumeration"),
	rto("model.rto"),
	//service
	service("service"),
	serviceImpl("service.impl"),
	serviceFactory("service"),
	serviceFacade("service"),
	serviceGeneric("service"),
	serviceGenericImpl("service.impl"),
	serviceIbatis("service"),
	serviceIbatisTest("service"),
	//web
	web("web"),
	action("web.action"),
	actionForIbatis("action"),
	actionxml("web"),
	fileUpload("web.uploadFiles"),
	tableFactory("web.view"),
	//render
	FlexiGridJsonWriter("web.render"),
	ResultMsgJsonWriter("web.render"),
	TreeGridJsonWriter("web.render"),
	RenderUtil("web.render"),
	//extjs
	Extjs("extjs"),
	//impexp
	importFactory("web.imports"),
	importExcel("web.imports.excel"),
	exportFactory("web.exports"),
	//webservice
	webservice("webservice"),
	//web site
	site_action("site.web.action"),
	site_actionXml("site.web"),
	//web maintain
	maintain_action("site.web.action"),
	//index
	indexDAO("dao"),
	indexDAOImpl("dao.impl"),
	IndexSearchService("service"),
	IndexSearchServiceImpl("service.impl"),
	IndexCreateService("service"),
	IndexCreateServiceImpl("service.impl"),
	IndexCreateServiceImplTest("service.impl"),
	IndexSolrServer("server"),
	IndexSearchServiceImplTest("service.impl")
	;

	private PKGSuffix(String value) {
		this.value = value;
	}

	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public static List<String> toValuesList(){
		List<String> list=new ArrayList<String>();
		for(PKGSuffix o:PKGSuffix.values()){
			list.add(o.getValue());
		}
		return list;
	}
}
