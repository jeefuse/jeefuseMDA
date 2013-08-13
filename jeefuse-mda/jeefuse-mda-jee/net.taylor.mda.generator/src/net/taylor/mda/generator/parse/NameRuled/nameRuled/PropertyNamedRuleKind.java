package net.taylor.mda.generator.parse.NameRuled.nameRuled;

import net.taylor.mda.generator.util.NameHelper;

import org.eclipse.uml2.uml.NamedElement;

/**
 * 
 * 属性命名.
 */
public enum PropertyNamedRuleKind {
	dateToDateTimeStr("ToStr", "")
	, radioStrutsList("Map", "")
	, toMap("Map", "")
	// ,selectStrutsList("Map","")
	, selectHtml("HtmlSelect", "")
	, elementJsonNamed("Json", "")
	, elementArrayNamed("Array", "")
	, viewSearchFieldTwoName("Two", "")
	// 导出命名
	, ExcelExportTemplateFileName("ExcelExportTemplateFileName", "")
	// 导入命名
	, ExcelImportTemplateFileName("ExcelImportTemplateFileName", "")
	// ,ExcelImportTemplateFileNameValue("ExcelImportTemplateFileName.xml","")
	, ExcelImportTemplateFileNameValue("导入Excel模板文件.xml", "")
	, ExcelImportTemplateDir("ExcelImportTemplateDir", "")
	, ExcelImportTemplateCaption("ExcelImportTemplateCaption", "")
	, ExcelImportTemplateFilePath("ExcelImportTemplateFilePath", "")
	, dateSearchStartName("Start", "")
	, dateSearchEndName("End", "")
	, searchCheckboxs("Checkboxs", "search")
	, searchRadios("Radios","search")
	, inputRadioGroup("inputRadioGroup", "")
	// 关联命名
	, relShowCheckTreeJson("ShowCheckTreeJson", "rel")
	, relCheckTreeDomId("CheckTree", "rel")
	, relCheckboxs("Checkboxs", "rel")
	, relCheckboxsDomId("CheckboxsDomId", "rel")
	, allKeyLabelList("KeyLabelList", "all")
	, getAllForKeyLabel("ForKeyLabel", "getAll")
	, allTreeviewList("TreeviewList", "all")
	, getAllForTreeviewList("ForTreeviewList","getAll")
	, relIdsList("IdList", "rel")
	, relCheckIds("CheckIds", "rel")
	, getRelCheckIdsMethod("CheckIds","getRel")
	/******** o2mManager win ********/
	, relO2MManager("Manage", "rel"), relM2OAndO2OSelectPage("ListForSelect", "rel");

	private PropertyNamedRuleKind(String suffix, String preffix) {
		this.suffix = suffix;
		this.preffix = preffix;
	}

	private String suffix;
	private String preffix;

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getPreffix() {
		return preffix;
	}

	public void setPreffix(String preffix) {
		this.preffix = preffix;
	}

	/**
	 * 获取元素命名. 形式如:元素名+后缀.
	 * 
	 * @param element
	 * @return
	 */
	public String getRuleCapNamed(NamedElement element) {
		String ruleName = this.getPreffix() + NameHelper.getCapName(element) + this.getSuffix();
		return NameHelper.capName(ruleName);
	}

	public String getRuleUnCapNamed(NamedElement element) {
		String ruleName = this.getPreffix() + NameHelper.getCapName(element) + this.getSuffix();
		return NameHelper.uncapName(ruleName);
		// return ruleName;
	}
}
