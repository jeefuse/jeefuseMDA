package net.taylor.mda.generator.parse.NameRuled.nameRuled;

import net.taylor.mda.generator.util.NameHelper;

/**
 * class名称规则.
 * 
 */
public enum NameRuledClassKind implements NameRuled<org.eclipse.uml2.uml.Type> {
	Entity("",""),
	EntityField("","Field"),
	EntityPropertyValueGet("","ValueGet"),
	Validate("","Validate"),
	enumeration("",""),
	//service
	Service("","Service"),
	ServiceImpl("","ServiceImpl"),
	serviceFactory("","ServiceFactory"),
	serviceFacade("","ServiceFacade"),
	serviceGeneric("","Service"),
	serviceGenericImpl("","ServiceImpl"),
	serviceIbatis("","Service"),
	serviceIbatisTest("","ServiceTest"),
	//web
	FlexiGridJsonWriter("","FlexiGridJsonWriter"),
	TreeGridJsonWriter("","TreeGridJsonWriter"),
	ResultMsgJsonWriter("","ResultMsgJsonWriter"),
	RenderUtil("","RenderUtil"),
	Action("","Action"),
	RTO("","RTO"),
	fileUpload("","UploadFile"),
	tableFactory("","TableFactory"),
	//extjs
	Extjs("",""),
	//impexp
	importFactory("","ImportFactory"),
	importExcel("","ExcelImport"),
	exportFactory("","ExportFactory"),
	//date transfer
	DTO("","DTO"),
	VO("",""),
	/**site action 类名称*/
	site_action("Site", "Action"),
	/**maitain action 类名称*/
	maintain_action("Maintain", "Action"),
	/*index*/
	indexDAO("","IndexDao"), 
	indexDAOImpl("","IndexDaoImpl"),
	IndexSearchService("","IndexSearchService"),
	IndexSearchServiceImpl("","IndexSearchServiceImpl"),
	IndexCreateService("","IndexCreateService"),
	IndexCreateServiceImpl("","IndexCreateServiceImpl"), 
	IndexCreateServiceImplTest("","IndexCreateServiceImplTest"), 
	IndexSolrServer("","SolrServer"),
	IndexSearchServiceImplTest("","IndexSearchServiceImplTest")
	;


	private String preffix;
	private String suffix;

	private NameRuledClassKind(String preffix, String suffix) {
		this.preffix = preffix;
		this.suffix = suffix;
	}

	public String getPreffix() {
		return preffix;
	}

	public String getSuffix() {
		return suffix;
	}

	@Override
	public String getRuleNamed(org.eclipse.uml2.uml.Type element) {
		return this.preffix + NameHelper.getCapName(element) + this.suffix;
	}
}