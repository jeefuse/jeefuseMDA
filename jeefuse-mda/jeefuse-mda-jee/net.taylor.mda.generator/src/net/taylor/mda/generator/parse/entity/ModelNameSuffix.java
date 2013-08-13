package net.taylor.mda.generator.parse.entity;

/**
 * 模型类命名后缀规则.
 * @author yonclv
 * @email yonclv@gmail.com
 */
public enum ModelNameSuffix {
	Entity(""),
	EntityField("Field"),
	EntityPropertyValueGet("ValueGet"),
	Validate("Validate"),
	enumeration(""),
	//service
	Service("Service"),
	ServiceImpl("ServiceImpl"),
	serviceFactory("ServiceFactory"),
	serviceFacade("ServiceFacade"),
	serviceGeneric("Service"),
	serviceGenericImpl("ServiceImpl"),
	serviceIbatis("Service"),
	serviceIbatisTest("ServiceTest"),
	//web
	FlexiGridJsonWriter("FlexiGridJsonWriter"),
	TreeGridJsonWriter("TreeGridJsonWriter"),
	ResultMsgJsonWriter("ResultMsgJsonWriter"),
	RenderUtil("RenderUtil"),
	Action("Action"),
	RTO("RTO"),
	fileUpload("UploadFile"),
	tableFactory("TableFactory"),
	//seb site
	site_action("SiteAction"),
	//extjs
	Extjs(""),
	//impexp
	importFactory("ImportFactory"),
	importExcel("ExcelImport"),
	exportFactory("ExportFactory"),
	//date transfer
	DTO("DTO"),
	VO("VO");

	private ModelNameSuffix(String value) {
		this.value = value;
	}

	private String value;

	public String getValue() {
		return value;
	}

}
