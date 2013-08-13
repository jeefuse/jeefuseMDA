package com.jeefuse.mda.gen.template.main.java.jsp;

import net.taylor.mda.generator.parse.NameRuled.*;
import net.taylor.mda.generator.parse.NameRuled.nameRuled.*;
import java.util.ArrayList;
import net.taylor.mda.generator.parse.stereotype.*;
import net.taylor.mda.generator.parse.entity.*;
import net.taylor.mda.generator.parse.*;
import java.util.Iterator;
import java.util.List;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.*;
import net.taylor.mda.generator.util.*;
import net.taylor.mda.generator.parse.entity.*;
import net.taylor.mda.generator.parse.page.*;
import org.eclipse.emf.codegen.util.*;

public class EntitManagerJSP
{
  protected static String nl;
  public static synchronized EntitManagerJSP create(String lineSeparator)
  {
    nl = lineSeparator;
    EntitManagerJSP result = new EntitManagerJSP();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = " page contentType=\"text/html;charset=UTF-8\" ";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = " include file=\"/common/taglibs.jsp\" ";
  protected final String TEXT_4 = NL + "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">" + NL + "<html xmlns=\"http://www.w3.org/1999/xhtml\">" + NL + "<head>" + NL + "<title>";
  protected final String TEXT_5 = "管理</title>";
  protected final String TEXT_6 = NL;
  protected final String TEXT_7 = " include file=\"/common/meta.jsp\" ";
  protected final String TEXT_8 = NL + "<script src=\"";
  protected final String TEXT_9 = "\" type=\"text/javascript\"></script>" + NL + "<script>" + NL + "\tvar ctx = '${ctx}';" + NL + "\tvar theme = '${theme}';";
  protected final String TEXT_10 = NL + "\tvar ";
  protected final String TEXT_11 = "=";
  protected final String TEXT_12 = ".toHtmlJSON";
  protected final String TEXT_13 = ";";
  protected final String TEXT_14 = NL + "\timportCssFile('sys|ui|flexiGrid|contextmenu";
  protected final String TEXT_15 = "|datePicker";
  protected final String TEXT_16 = "', ctx, theme);" + NL + "\timportJsFile('jquery|blockUI|common|ui|flexiGrid|validate|contextmenu";
  protected final String TEXT_17 = "|datePicker";
  protected final String TEXT_18 = "|form";
  protected final String TEXT_19 = "', ctx);" + NL + "\timportJsFile('";
  protected final String TEXT_20 = "', ctx);" + NL + "</script>" + NL + "" + NL + "</head>" + NL + "<body id=\"container\" class=\"v-container\">" + NL + "\t<div id=\"header\" region=\"north\" split=\"false\" border=\"false\"  class=\"v-header\"><!-- header start -->" + NL + "\t\t<div id=\"first-title\" class=\"v-title\">" + NL + "\t\t\t" + NL + "\t\t</div>" + NL + "\t\t" + NL + "\t\t<div id=\"first-toolbar\" class=\"v-toolbar\"><!-- v-toolbar start -->" + NL + "\t\t\t<div class=\"v-menu\">";
  protected final String TEXT_21 = NL + "\t\t\t\t<a href=\"javascript:newData()\" class=\" l-btn l-btn-plain\" >" + NL + "\t\t\t\t\t<span class=\"l-btn-left\"><span  class=\"l-btn-text icon-add\">新增</span></span>" + NL + "\t\t\t\t</a>";
  protected final String TEXT_22 = NL + "\t\t\t\t<a href=\"javascript:editData()\" class=\" l-btn l-btn-plain\" >" + NL + "\t\t\t\t\t<span class=\"l-btn-left\"><span  class=\"l-btn-text icon-form-edit\">编辑</span></span>" + NL + "\t\t\t\t</a>";
  protected final String TEXT_23 = NL + "\t\t\t\t<a href=\"javascript:delData();\" class=\" l-btn l-btn-plain\" >" + NL + "\t\t\t\t\t<span class=\"l-btn-left\"><span  class=\"l-btn-text icon-remove\">删除</span></span>" + NL + "\t\t\t\t</a>";
  protected final String TEXT_24 = NL + "\t\t\t\t<a href=\"javascript:delAllData();\" class=\" l-btn l-btn-plain\" >" + NL + "\t\t\t\t\t<span class=\"l-btn-left\"><span  class=\"l-btn-text icon-remove\">删除所有</span></span>" + NL + "\t\t\t\t</a>";
  protected final String TEXT_25 = NL + "\t\t\t\t<a href=\"javascript:refresh()\" class=\" l-btn l-btn-plain\" >" + NL + "\t\t\t\t\t<span class=\"l-btn-left\"><span  class=\"l-btn-text icon-reload\">刷新</span></span>" + NL + "\t\t\t\t</a>" + NL + "\t\t\t\t<a href=\"javascript:clear()\" class=\" l-btn l-btn-plain\" >" + NL + "\t\t\t\t\t<span class=\"l-btn-left\"><span  class=\"l-btn-text icon-reset\">重置</span></span>" + NL + "\t\t\t\t</a>";
  protected final String TEXT_26 = NL + "\t\t\t\t<a href=\"javascript:exportExcel();\" class=\" l-btn l-btn-plain\" >" + NL + "\t\t\t\t\t<span class=\"l-btn-left\"><span  class=\"l-btn-text icon-excel\">导出EXCEL</span></span>" + NL + "\t\t\t\t</a>";
  protected final String TEXT_27 = NL + "\t\t\t\t<a href=\"javascript:importExcel();\" class=\" l-btn l-btn-plain\" >" + NL + "\t\t\t\t\t<span class=\"l-btn-left\"><span  class=\"l-btn-text icon-excel\">导入EXCEL</span></span>" + NL + "\t\t\t\t</a>";
  protected final String TEXT_28 = NL + "\t\t\t</div>" + NL + "\t\t</div><!-- v-toolbar end -->" + NL + "\t\t" + NL + "\t\t<div id=\"first-search\" class=\"v-search\"><!-- first-search -->";
  protected final String TEXT_29 = "\t\t";
  protected final String TEXT_30 = NL + "\t\t   <form id=\"firstSearchForm\">";
  protected final String TEXT_31 = "\t";
  protected final String TEXT_32 = NL + "\t\t\t\t<input type=\"hidden\" id=\"";
  protected final String TEXT_33 = "_";
  protected final String TEXT_34 = "\" name=\"";
  protected final String TEXT_35 = ".";
  protected final String TEXT_36 = "\"/>";
  protected final String TEXT_37 = "\t" + NL + "\t\t\t\t<table>" + NL;
  protected final String TEXT_38 = "\t\t\t\t";
  protected final String TEXT_39 = NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_40 = "\t";
  protected final String TEXT_41 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_42 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_43 = NL + "\t\t\t\t\t\t<td>" + NL + "\t\t\t\t\t\t\t <label>";
  protected final String TEXT_44 = ":</label>\t" + NL + "\t\t\t\t\t\t</td>" + NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_45 = "\">" + NL + "\t\t\t\t\t\t\t ${propertySearchRadios}" + NL + "\t\t\t\t\t\t</td>";
  protected final String TEXT_46 = "\t";
  protected final String TEXT_47 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_48 = "\t\t\t\t\t\t";
  protected final String TEXT_49 = "\t";
  protected final String TEXT_50 = NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_51 = "\t";
  protected final String TEXT_52 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_53 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_54 = NL + "\t\t\t\t\t\t<td>" + NL + "\t\t\t\t\t\t\t <label>";
  protected final String TEXT_55 = ":</label>\t" + NL + "\t\t\t\t\t\t</td>" + NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_56 = "\">" + NL + "\t\t\t\t\t\t\t ${propertySearchCheckboxs}" + NL + "\t\t\t\t\t\t</td>";
  protected final String TEXT_57 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_58 = "\t\t\t\t\t\t";
  protected final String TEXT_59 = "\t";
  protected final String TEXT_60 = NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_61 = "\t";
  protected final String TEXT_62 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_63 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_64 = NL + NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_65 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_66 = "\">" + NL + "\t\t      \t\t\t\t<select  id=\"";
  protected final String TEXT_67 = "\" name=\"";
  protected final String TEXT_68 = "\" class=\"text\">" + NL + "\t\t\t\t\t\t\t     <option value=\"\" >所有</option>" + NL + "\t\t\t\t\t\t\t     <s:property value=\"";
  protected final String TEXT_69 = "\" escape=\"false\"/>" + NL + "\t\t\t\t\t\t\t </select>" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_70 = NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_71 = "\t";
  protected final String TEXT_72 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_73 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_74 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>开始";
  protected final String TEXT_75 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\">" + NL + "\t\t      \t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_76 = "\" name=\"";
  protected final String TEXT_77 = "\" value=\"${param.";
  protected final String TEXT_78 = "}\"  class=\"dateCN\"/>" + NL + "\t\t      \t\t\t</td>" + NL + "" + NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>结束";
  protected final String TEXT_79 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_80 = "\">" + NL + "\t\t      \t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_81 = "\" name=\"";
  protected final String TEXT_82 = "\" value=\"${param.";
  protected final String TEXT_83 = "}\"   class=\"dateCN\"/>" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_84 = NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_85 = "\t";
  protected final String TEXT_86 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_87 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_88 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_89 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_90 = "\">" + NL + "\t\t      \t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_91 = "\" name=\"";
  protected final String TEXT_92 = "\" value=\"${param.";
  protected final String TEXT_93 = "}\"  class=\"text\"/>" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_94 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_95 = "\t\t\t\t\t\t";
  protected final String TEXT_96 = "\t";
  protected final String TEXT_97 = NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_98 = "\t";
  protected final String TEXT_99 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_100 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_101 = NL + "\t\t\t\t\t\t<td>" + NL + "\t\t\t\t\t\t\t<div class=\"v-buttons\">" + NL + "\t\t\t\t\t\t\t\t<a href=\"javascript:firstSearch();\" class=\"easyui-linkbutton\" icon=\"icon-search\" > 查 询</a>" + NL + "\t\t\t\t\t\t\t</div>" + NL + "\t\t\t\t\t\t</td>";
  protected final String TEXT_102 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_103 = "\t" + NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_104 = "\"></td>" + NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_105 = "\t" + NL + "\t\t\t\t</table>" + NL + "\t\t\t</form>";
  protected final String TEXT_106 = NL + "\t\t</div><!-- first-search End-->" + NL + "\t</div><!-- header end -->\t";
  protected final String TEXT_107 = "\t";
  protected final String TEXT_108 = "\t";
  protected final String TEXT_109 = NL + "\t<!-- category start -->" + NL + "\t<div id=\"category\" region=\"west\"  border=\"true\" class=\"v-category\">" + NL + "<!--    \t\t<div class=\"v-title v-title-panel\">";
  protected final String TEXT_110 = "树</div>-->" + NL + "    \t\t<div id=\"firstTree\" class=\"v-tree\" ></div>" + NL + "    </div><!-- cate end -->\t";
  protected final String TEXT_111 = "\t" + NL + "" + NL + "\t<div id=\"center\" region=\"center\"  border=\"true\">" + NL + "   \t\t<div id=\"first-content\">" + NL + "\t\t\t<div id=\"dataGrid\"  style=\"display:none;\"></div>" + NL + "\t\t</div>" + NL + "\t</div><!-- center end -->\t" + NL;
  protected final String TEXT_112 = "\t" + NL + "\t<!-- 导入Excel文件数据窗口 -->" + NL + "\t<div id=\"importExcelWin\"  title=\"导入Excel文件数据\" style=\"width:0px;height:0px;\"> " + NL + "\t\t<div class=\"v-section-wrap\">" + NL + "\t\t\t<div class=\"hd\">" + NL + "\t\t\t\t<span class=\"title\">导入Excel文件数据</span>" + NL + "\t\t\t</div>" + NL + "\t\t\t<div class=\"bd\">" + NL + "\t\t\t\t<form id=\"importExcelForm\" method=\"post\" class=\"v-form\">" + NL + "\t\t\t      \t<table>" + NL + "\t\t\t      \t\t<tr>" + NL + "\t\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t\t      \t\t\t\t<label>选择Excel导入文件:</label>" + NL + "\t\t\t      \t\t\t</td>" + NL + "\t\t\t      \t\t</tr>" + NL + "\t\t\t      \t\t<tr>" + NL + "\t\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t\t      \t\t\t\t<input type=\"file\" id=\"file\" name=\"file\" size=\"50\" class=\"required\" onchange=\"goolov.validete.file(this,'xls');\"/>" + NL + "\t\t\t      \t\t\t</td>" + NL + "\t\t\t      \t\t</tr>" + NL + "\t\t\t\t\t</table>" + NL + "\t\t\t\t</form>" + NL + "\t\t\t\t<div class=\"v-buttons\">" + NL + "\t\t\t\t\t\t<a href=\"javascript:void(0)\" onclick=\"importExcelSubmit();\"  class=\"easyui-linkbutton\" icon=\"icon-excel-imp\" >执行导入</a>" + NL + "\t\t\t\t\t   \t<a href=\"javascript:importExcelWinClose();\" class=\"easyui-linkbutton\" >关闭</a>" + NL + "\t\t\t\t</div>" + NL + "\t\t\t</div>" + NL + "\t\t</div>" + NL + "\t</div>";
  protected final String TEXT_113 = "\t\t\t\t\t\t" + NL + "</body>" + NL + "</html>";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    Class uml2Class = (Class) argument;Package uml2Package = uml2Class.getPackage();
    
UmlClassWrap clazzWrap=new UmlClassWrap(uml2Class);
String modelCommentName=TypeHelper.getDocumentationOrName(uml2Class);
String modelManagerJsPath=clazzWrap.getWebPath(NameRuledWebPathKind.js_manager);
String jspScriptStart="<%@";
String jspScriptEnd="%"+">";
String jspScriptAssign="<%=";
boolean isImpExcel=false;//是否导入excel
if(ServiceStereotypeUtil.isApplied_impExcel(uml2Class)){
	isImpExcel=true;
}

    stringBuffer.append(jspScriptStart);
    stringBuffer.append(TEXT_1);
    stringBuffer.append(jspScriptEnd);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(jspScriptStart);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(jspScriptEnd);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(modelCommentName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(jspScriptStart);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(jspScriptEnd);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(Config.web_resources_js_include);
    stringBuffer.append(TEXT_9);
    List<Property> codeKindPropertiesList=EnumKindHelper.getPropertiesAppliedEnumKind(uml2Class);
    if(null!=codeKindPropertiesList&&codeKindPropertiesList.size()>0){
    	for(Property property:codeKindPropertiesList){
    		Enumeration enumeration=EnumKindHelper.getAppliedEnumKindEnumeration(property);
    		if(null!=enumeration){
    			String modelEnumJsoncapName=NamedUtil.getPropertyNamed(enumeration,PropertyNamedRuleKind.elementJsonNamed);
    			String modelEnumQualifiedName=MdaHelper.getModelQualifiedName(enumeration,PKGSuffix.enumeration,ModelNameSuffix.enumeration);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(modelEnumJsoncapName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(jspScriptAssign);
    stringBuffer.append(modelEnumQualifiedName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(jspScriptEnd);
    stringBuffer.append(TEXT_13);
    		}
    	}
    }
    List<Property> datePickerList=ViewInputHelper.getViewInputDatePicker(uml2Class);
    stringBuffer.append(TEXT_14);
    if(!datePickerList.isEmpty()){
    stringBuffer.append(TEXT_15);
    }
    stringBuffer.append(TEXT_16);
    if(!datePickerList.isEmpty()){
    stringBuffer.append(TEXT_17);
    }
    if(isImpExcel){
    stringBuffer.append(TEXT_18);
    }
    stringBuffer.append(TEXT_19);
    stringBuffer.append(modelManagerJsPath);
    stringBuffer.append(TEXT_20);
    if(FunctionStereotypeUtil.isApplied_input(uml2Class)){
    stringBuffer.append(TEXT_21);
    }
    if(FunctionStereotypeUtil.isApplied_edit(uml2Class)){
    stringBuffer.append(TEXT_22);
    }
    	if(FunctionStereotypeUtil.isApplied_deleteOutJson(uml2Class)){
    stringBuffer.append(TEXT_23);
    	}
    	if(FunctionStereotypeUtil.isApplied_deleteAllOutJson(uml2Class)){
    stringBuffer.append(TEXT_24);
    	}
    stringBuffer.append(TEXT_25);
    if(ServiceStereotypeUtil.isApplied_expExcel(uml2Class)){
    stringBuffer.append(TEXT_26);
    }
    if(ServiceStereotypeUtil.isApplied_impExcel(uml2Class)){
    stringBuffer.append(TEXT_27);
    }
    stringBuffer.append(TEXT_28);
    
/*****************************************************************
 * process search
/*****************************************************************/

    stringBuffer.append(TEXT_29);
    
List<Property> searchPropertyList=ViewSearchHelper.getSearchTextFieldPropertiesFromSimple(uml2Class);
List<Property> radioPropertyList=ViewSearchHelper.getSearchRadioFieldPropertiesFromSimple(uml2Class);
List<Property> checkboxPropertyList=ViewSearchHelper.getSearchCheckboxFieldPropertiesFromSimple(uml2Class);
if((null!=searchPropertyList&&searchPropertyList.size()>0)||radioPropertyList.size()>0||checkboxPropertyList.size()>0){
int trIncludeTd=8;
int tdCount=0;
int needTd=2;

    stringBuffer.append(TEXT_30);
    
/*****************************************************************
 * process Property category
/*****************************************************************/

    if(PropertyStereotypeHelper.hasProperty_Category(uml2Class)){
    	Property property=PropertyStereotypeHelper.getProperty_Category(uml2Class);
    stringBuffer.append(TEXT_31);
    	Class propertyType = (Class) property.getType();
    	//String propertyTypeComment = TypeHelper.getDocumentationOrName(propertyType);
    	String propertyTypeCapName = NameHelper.getCapName(propertyType);
    	//String propertyTypeUncapName = NameHelper.getUncapName(propertyType);
     	Property propertyTypeIdProperty=EntityHelper.getIDProperty(propertyType);
     	String propertyTypeIdPropertyUncapSafeName=NameHelper.uncapSafeName(propertyTypeIdProperty);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(propertyTypeCapName);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(propertyTypeCapName);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_36);
    }
    stringBuffer.append(TEXT_37);
    
/*****************************************************************
 * process radio property search 
/*****************************************************************/

    stringBuffer.append(TEXT_38);
    for (int i=0;i<radioPropertyList.size();i++){
    	Property property=radioPropertyList.get(i);
     	String propertyCommentName=TypeHelper.getDocumentationOrName(property);
     //	String propertyUncapSafeName=NameHelper.uncapSafeName(property);
    	//String propertySearchRadios=NamedUtil.getPropertyNamed(property,PropertyNamedRuleKind.searchRadios);
    	needTd=8;
    			if(tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_39);
    			}
    stringBuffer.append(TEXT_40);
    			if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_41);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_42);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    			}
    stringBuffer.append(TEXT_43);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_45);
    			tdCount+=needTd;
    stringBuffer.append(TEXT_46);
    			if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_47);
    			}
    stringBuffer.append(TEXT_48);
    }
    
/*****************************************************************
 * process checkboxPropertyList search 
/*****************************************************************/

    stringBuffer.append(TEXT_49);
    for (int i=0;i<checkboxPropertyList.size();i++){
    	Property property=checkboxPropertyList.get(i);
     	String propertyCommentName=TypeHelper.getDocumentationOrName(property);
     	//String propertyUncapSafeName=NameHelper.uncapSafeName(property);
    	//String propertySearchCheckboxs=NamedUtil.getPropertyNamed(property,PropertyNamedRuleKind.searchCheckboxs);
    	needTd=8;
    			if(tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_50);
    			}
    stringBuffer.append(TEXT_51);
    			if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_52);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_53);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    			}
    stringBuffer.append(TEXT_54);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_56);
    			tdCount+=needTd;
    			if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_57);
    			}
    stringBuffer.append(TEXT_58);
    }
    
/*****************************************************************
 * process searchPropertyList search 
/*****************************************************************/

    stringBuffer.append(TEXT_59);
    for (int i=0;i<searchPropertyList.size();i++){
    	Property property=searchPropertyList.get(i);
     	String propertyCommentName=TypeHelper.getDocumentationOrName(property);
     	String propertyUncapSafeName=NameHelper.uncapSafeName(property);
    	if(EnumKindHelper.isAppliedEnumKind(property)){//process enumKind
    		Enumeration enumeration=EnumKindHelper.getAppliedEnumKindEnumeration(property);
    		if(null!=enumeration){
    			//String modelEnumQualifiedName=MdaHelper.getModelQualifiedName(enumeration,PKGSuffix.enumeration,ModelNameSuffix.enumeration);
    			//String modelEnumName=MdaHelper.getModelClassName(enumeration,ModelNameSuffix.enumeration);
    			String modelEnumSelectHtml=NamedUtil.getPropertyNamed(enumeration,PropertyNamedRuleKind.selectHtml);
    			if(ViewInputHelper.isViewInputSelect(property)){//process select
    			needTd=2;
    			if(tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_60);
    			}
    stringBuffer.append(TEXT_61);
    			if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_62);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_63);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    			}
    stringBuffer.append(TEXT_64);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(modelEnumSelectHtml);
    stringBuffer.append(TEXT_69);
    			tdCount+=needTd;
    			}
    			if(ViewInputHelper.isViewInputRadio(property)){//process radio
    				radioPropertyList.add(property);
    			}
    			if(ViewInputHelper.isViewInputCheckbox(property)){//process radio
    				checkboxPropertyList.add(property);
    			}
    		}
    	}else if(ViewInputHelper.isViewInputDatePicker(property)){//process datePicker
    		String dateSearchStartName=NamedUtil.getPropertyNamed(property,PropertyNamedRuleKind.dateSearchStartName);
     		String dateSearchStartUncapSafeName=NameHelper.uncapName(dateSearchStartName);
    		String dateSearchEndName=NamedUtil.getPropertyNamed(property,PropertyNamedRuleKind.dateSearchEndName);
     		String dateSearchEndNameUncapSafeName=NameHelper.uncapName(dateSearchEndName);
    			needTd=4;
    			if(tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_70);
    			}
    stringBuffer.append(TEXT_71);
    			if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_72);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_73);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    			}
    stringBuffer.append(TEXT_74);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(dateSearchStartUncapSafeName);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(dateSearchStartUncapSafeName);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(dateSearchStartUncapSafeName);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(needTd-3);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(dateSearchEndNameUncapSafeName);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(dateSearchEndNameUncapSafeName);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(dateSearchEndNameUncapSafeName);
    stringBuffer.append(TEXT_83);
    			tdCount+=needTd;
    	}else{//process text
    			needTd=2;
    			if(tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_84);
    			}
    stringBuffer.append(TEXT_85);
    			if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_86);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_87);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    			}
    stringBuffer.append(TEXT_88);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_93);
    			tdCount+=needTd;
    	}
    			if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_94);
    			}
    stringBuffer.append(TEXT_95);
    }
    
/*****************************************************************
 * process  search button 
/*****************************************************************/

    stringBuffer.append(TEXT_96);
    	needTd=1;
    			if(tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_97);
    			}
    stringBuffer.append(TEXT_98);
    			if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_99);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_100);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    			}
    stringBuffer.append(TEXT_101);
    			tdCount+=needTd;
    	if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_102);
    	}
    	if (tdCount%trIncludeTd!=0){
    stringBuffer.append(TEXT_103);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_104);
    	}
    stringBuffer.append(TEXT_105);
    }
    stringBuffer.append(TEXT_106);
    
/*****************************************************************
 * process Property category
/*****************************************************************/

    stringBuffer.append(TEXT_107);
    if(PropertyStereotypeHelper.hasProperty_Category(uml2Class)){
    	Property property=PropertyStereotypeHelper.getProperty_Category(uml2Class);
    stringBuffer.append(TEXT_108);
    	Class propertyType = (Class) property.getType();
    	String propertyTypeComment = TypeHelper.getDocumentationOrName(propertyType);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(propertyTypeComment);
    stringBuffer.append(TEXT_110);
    }
    stringBuffer.append(TEXT_111);
    if(ServiceStereotypeUtil.isApplied_impExcel(uml2Class)){
    stringBuffer.append(TEXT_112);
    }
    stringBuffer.append(TEXT_113);
    return stringBuffer.toString();
  }
}
