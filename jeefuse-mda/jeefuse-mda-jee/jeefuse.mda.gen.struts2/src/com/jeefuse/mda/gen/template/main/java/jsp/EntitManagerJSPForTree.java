package com.jeefuse.mda.gen.template.main.java.jsp;

import net.taylor.mda.generator.parse.NameRuled.nameRuled.*;
import net.taylor.mda.generator.parse.NameRuled.*;
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

public class EntitManagerJSPForTree
{
  protected static String nl;
  public static synchronized EntitManagerJSPForTree create(String lineSeparator)
  {
    nl = lineSeparator;
    EntitManagerJSPForTree result = new EntitManagerJSPForTree();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = " page contentType=\"text/html;charset=UTF-8\" ";
  protected final String TEXT_3 = NL;
  protected final String TEXT_4 = " include file=\"/common/taglibs.jsp\" ";
  protected final String TEXT_5 = NL + "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">" + NL + "<html xmlns=\"http://www.w3.org/1999/xhtml\">" + NL + "<head>" + NL + "<title>";
  protected final String TEXT_6 = "管理</title>";
  protected final String TEXT_7 = NL;
  protected final String TEXT_8 = " include file=\"/common/meta.jsp\" ";
  protected final String TEXT_9 = NL + "<script src=\"";
  protected final String TEXT_10 = "\" type=\"text/javascript\"></script>" + NL + "<script>" + NL + "\tvar ctx = '${ctx}';" + NL + "\tvar theme = '${theme}';";
  protected final String TEXT_11 = NL + "\tvar ";
  protected final String TEXT_12 = "=";
  protected final String TEXT_13 = ".toHtmlJSON";
  protected final String TEXT_14 = ";";
  protected final String TEXT_15 = NL + "\timportCssFile('sys|ui|flexiGrid|treeview|contextmenu', ctx, theme);" + NL + "\timportJsFile('jquery|common|blockUI|ui|flexiTreeGrid|treeview|validate|contextmenu";
  protected final String TEXT_16 = "|form";
  protected final String TEXT_17 = "',ctx);" + NL + "\timportJsFile('";
  protected final String TEXT_18 = "', ctx);" + NL + "</script>";
  protected final String TEXT_19 = NL + NL + "</head>" + NL + "<body id=\"container\" class=\"v-container\">" + NL + "    <div id=\"header\" region=\"north\" split=\"false\" border=\"false\"  class=\"v-header\"><!-- header start -->" + NL + "\t\t<div id=\"firstTitle\" class=\"v-title\"></div>" + NL + "\t\t" + NL + "\t\t<div id=\"firstToolbar\" class=\"v-toolbar\"><!-- v-toolbar start -->" + NL + "\t\t\t<a href=\"javascript:newData();\" class=\" l-btn l-btn-plain\" >" + NL + "\t\t\t\t<span class=\"l-btn-left\"><span  class=\"l-btn-text icon-add\">新增</span></span>" + NL + "\t\t\t</a>" + NL + "\t\t\t<a href=\"javascript:editData()\" class=\" l-btn l-btn-plain\" >" + NL + "\t\t\t\t<span class=\"l-btn-left\"><span  class=\"l-btn-text icon-form-edit\">编辑</span></span>" + NL + "\t\t\t</a>" + NL + "\t\t\t<a href=\"javascript:delData();\" class=\" l-btn l-btn-plain\" >" + NL + "\t\t\t\t<span class=\"l-btn-left\"><span  class=\"l-btn-text icon-remove\">删除</span></span>" + NL + "\t\t\t</a>" + NL + "\t\t\t<a href=\"javascript:delDescendantData();\" class=\" l-btn l-btn-plain\" >" + NL + "\t\t\t\t<span class=\"l-btn-left\"><span  class=\"l-btn-text icon-remove\">删除及其子节点</span></span>" + NL + "\t\t\t</a>" + NL + "\t\t\t<a href=\"javascript:delAllData();\" class=\" l-btn l-btn-plain\" >" + NL + "\t\t\t\t<span class=\"l-btn-left\"><span  class=\"l-btn-text icon-remove\">删除所有</span></span>" + NL + "\t\t\t</a>" + NL + "\t\t\t<a href=\"javascript:refresh()\" class=\" l-btn l-btn-plain\" >" + NL + "\t\t\t\t<span class=\"l-btn-left\"><span  class=\"l-btn-text icon-reload\">刷新</span></span>" + NL + "\t\t\t</a>" + NL + "\t\t\t<a href=\"javascript:clear()\" class=\" l-btn l-btn-plain\" >" + NL + "\t\t\t\t<span class=\"l-btn-left\"><span  class=\"l-btn-text icon-reset\">重置</span></span>" + NL + "\t\t\t</a>";
  protected final String TEXT_20 = NL + "\t\t\t<a href=\"javascript:exportExcel();\" class=\" l-btn l-btn-plain\" >" + NL + "\t\t\t\t<span class=\"l-btn-left\"><span  class=\"l-btn-text icon-excel\">导出EXCEL</span></span>" + NL + "\t\t\t</a>";
  protected final String TEXT_21 = NL + "\t\t\t<a href=\"javascript:importExcel();\" class=\" l-btn l-btn-plain\" >" + NL + "\t\t\t\t<span class=\"l-btn-left\"><span  class=\"l-btn-text icon-excel\">导入EXCEL</span></span>" + NL + "\t\t\t</a>";
  protected final String TEXT_22 = NL + "\t\t</div><!-- v-toolbar end -->" + NL + "\t\t" + NL + "\t\t<div id=\"firstSearch\" class=\"v-search\"><!-- first-search -->";
  protected final String TEXT_23 = "\t\t";
  protected final String TEXT_24 = NL + "\t\t   <form id=\"firstSearchForm\">";
  protected final String TEXT_25 = NL + "\t\t\t\t<input type=\"hidden\" id=\"parentId\" name=\"parentId\"/>";
  protected final String TEXT_26 = "   " + NL + "\t\t\t\t<table>";
  protected final String TEXT_27 = "\t\t\t\t";
  protected final String TEXT_28 = NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_29 = "\t";
  protected final String TEXT_30 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_31 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_32 = NL + "\t\t\t\t\t\t<td>" + NL + "\t\t\t\t\t\t\t <label>";
  protected final String TEXT_33 = ":</label>\t" + NL + "\t\t\t\t\t\t</td>" + NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_34 = "\">" + NL + "\t\t\t\t\t\t\t ${propertySearchRadios}" + NL + "\t\t\t\t\t\t</td>";
  protected final String TEXT_35 = "\t";
  protected final String TEXT_36 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_37 = "\t\t\t\t\t\t";
  protected final String TEXT_38 = "\t";
  protected final String TEXT_39 = NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_40 = "\t";
  protected final String TEXT_41 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_42 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_43 = NL + "\t\t\t\t\t\t<td>" + NL + "\t\t\t\t\t\t\t <label>";
  protected final String TEXT_44 = ":</label>\t" + NL + "\t\t\t\t\t\t</td>" + NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_45 = "\">" + NL + "\t\t\t\t\t\t\t ${propertySearchCheckboxs}" + NL + "\t\t\t\t\t\t</td>";
  protected final String TEXT_46 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_47 = "\t\t\t\t\t\t";
  protected final String TEXT_48 = "\t";
  protected final String TEXT_49 = NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_50 = "\t";
  protected final String TEXT_51 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_52 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_53 = NL + NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_54 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_55 = "\">" + NL + "\t\t      \t\t\t\t<select  id=\"";
  protected final String TEXT_56 = "\" name=\"";
  protected final String TEXT_57 = "\" class=\"text\">" + NL + "\t\t\t\t\t\t\t     <s:property value=\"";
  protected final String TEXT_58 = "\" escape=\"false\"/>" + NL + "\t\t\t\t\t\t\t </select>" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_59 = NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_60 = "\t";
  protected final String TEXT_61 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_62 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_63 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>开始";
  protected final String TEXT_64 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\">" + NL + "\t\t      \t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_65 = "\" name=\"";
  protected final String TEXT_66 = "\" value=\"${param.";
  protected final String TEXT_67 = "}\"   class=\"dateCN\"/>" + NL + "\t\t      \t\t\t</td>" + NL + "" + NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>结束";
  protected final String TEXT_68 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_69 = "\">" + NL + "\t\t      \t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_70 = "\" name=\"";
  protected final String TEXT_71 = "\" value=\"${param.";
  protected final String TEXT_72 = "}\"   class=\"dateCN\"/>" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_73 = NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_74 = "\t";
  protected final String TEXT_75 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_76 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_77 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_78 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_79 = "\">" + NL + "\t\t      \t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_80 = "\" name=\"";
  protected final String TEXT_81 = "\" value=\"${param.";
  protected final String TEXT_82 = "}\"   class=\"text\"/>" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_83 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_84 = "\t\t\t\t\t\t";
  protected final String TEXT_85 = "\t";
  protected final String TEXT_86 = NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_87 = "\t";
  protected final String TEXT_88 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_89 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_90 = NL + "\t\t\t\t\t\t<td>" + NL + "\t\t\t\t\t\t\t<div class=\"v-buttons\">" + NL + "\t\t\t\t\t\t\t\t\t<a href=\"javascript:firstSearch();\" class=\"easyui-linkbutton\" icon=\"icon-search\" > 查 询</a>" + NL + "\t\t\t\t\t\t\t</div>" + NL + "\t\t\t\t\t\t</td>";
  protected final String TEXT_91 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_92 = "\t" + NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_93 = "\"></td>" + NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_94 = "\t" + NL + "\t\t\t\t</table>" + NL + "\t\t\t</form>";
  protected final String TEXT_95 = NL + "\t\t</div><!-- first-search End-->" + NL + "     </div><!-- header end -->" + NL + "     ";
  protected final String TEXT_96 = NL + "     <!-- category start -->" + NL + "     <div id=\"category\" region=\"west\"  border=\"true\" style=\"width:210px;\">" + NL + "\t\t\t<div class=\"v-title v-title-panel\">";
  protected final String TEXT_97 = "树</div>" + NL + "\t\t\t<div id=\"firstTree\" class=\"v-tree\" ></div>" + NL + "     </div><!-- category end -->";
  protected final String TEXT_98 = "   " + NL + " " + NL + "     <!-- center start -->" + NL + "\t <div id=\"center\" region=\"center\"  border=\"true\">" + NL + "   \t\t<div id=\"firstContent\" class=\"v-content\">" + NL + "\t\t\t<div id=\"dataGrid\"  style=\"display:none;\"></div>" + NL + "\t\t</div>" + NL + "\t</div><!-- center end -->\t\t\t\t\t\t" + NL + "</body>" + NL + "</html>";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    Property curProperty = (Property) argument;Package O2MManagePropertyPackage = curProperty.getNearestPackage();
    Class ownerClass=(Class)curProperty.getOwner();
    //String ownerClassCapName=NameHelper.getCapName(ownerClass);
    //String ownerClassUncapName=NameHelper.getUncapName(ownerClass);
    String ownerClassCommentName=TypeHelper.getDocumentationOrName(ownerClass);
    //Property ownerClassIdProperty=EntityHelper.getIDProperty(ownerClass);
    //String ownerClassIdPropertyName=NameHelper.uncapSafeName(ownerClassIdProperty);
    //String ownerClassIdPropertyGetter=ClassHelper.getGetAccessor(ownerClassIdProperty);
    UmlClassByPropertyWrap named=new UmlClassByPropertyWrap(curProperty);
    Class uml2Class=ownerClass;
    
String jspScriptStart="<%@";
String jspScriptEnd="%"+">";
String jspScriptAssign="<%=";
boolean isImpExcel=false;//是否导入excel
if(ServiceStereotypeUtil.isApplied_impExcel(uml2Class)){
	isImpExcel=true;
}

    stringBuffer.append(TEXT_1);
    stringBuffer.append(jspScriptStart);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(jspScriptEnd);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(jspScriptStart);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(jspScriptEnd);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(ownerClassCommentName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(jspScriptStart);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(jspScriptEnd);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(Config.web_resources_js_include);
    stringBuffer.append(TEXT_10);
    List<Property> codeKindPropertiesList=EnumKindHelper.getPropertiesAppliedEnumKind(uml2Class);
    if(null!=codeKindPropertiesList&&codeKindPropertiesList.size()>0){
    	for(Property property:codeKindPropertiesList){
    		Enumeration enumeration=EnumKindHelper.getAppliedEnumKindEnumeration(property);
    		if(null!=enumeration){
    			String modelEnumJsoncapName=NamedUtil.getPropertyNamed(enumeration,PropertyNamedRuleKind.elementJsonNamed);
    			String modelEnumQualifiedName=MdaHelper.getModelQualifiedName(enumeration,PKGSuffix.enumeration,ModelNameSuffix.enumeration);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(modelEnumJsoncapName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(jspScriptAssign);
    stringBuffer.append(modelEnumQualifiedName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(jspScriptEnd);
    stringBuffer.append(TEXT_14);
    		}
    	}
    }
    stringBuffer.append(TEXT_15);
    if(isImpExcel){
    stringBuffer.append(TEXT_16);
    }
    stringBuffer.append(TEXT_17);
    stringBuffer.append(named.getWebPath(NameRuledWebPathKind.js_manager));
    stringBuffer.append(TEXT_18);
    
List<Property> searchPropertyList=ViewSearchHelper.getSearchTextFieldPropertiesFromSimple(uml2Class);
List<Property> radioPropertyList=ViewSearchHelper.getSearchRadioFieldPropertiesFromSimple(uml2Class);
List<Property> checkboxPropertyList=ViewSearchHelper.getSearchCheckboxFieldPropertiesFromSimple(uml2Class);
int trIncludeTd=8;
//int searchTextTrNum=(searchPropertyList.size()%8)==0?(searchPropertyList.size()/8):(searchPropertyList.size()/8)+1;
//int searchRadioTrNum=radioPropertyList.size();
//int searchCheckboxTrNum=checkboxPropertyList.size();

    stringBuffer.append(TEXT_19);
    if(ServiceStereotypeUtil.isApplied_expExcel(uml2Class)){
    stringBuffer.append(TEXT_20);
    }
    if(ServiceStereotypeUtil.isApplied_impExcel(uml2Class)){
    stringBuffer.append(TEXT_21);
    }
    stringBuffer.append(TEXT_22);
    
/*****************************************************************
 * process search
/*****************************************************************/

    stringBuffer.append(TEXT_23);
    
if((null!=searchPropertyList&&searchPropertyList.size()>0)||radioPropertyList.size()>0||checkboxPropertyList.size()>0){
int tdCount=0;
int needTd=2;

    stringBuffer.append(TEXT_24);
    	if(TreeStereotypeHelper.getValue_treeListStyle(uml2Class).equalsIgnoreCase("treeGrid")){
    	}else{
    stringBuffer.append(TEXT_25);
    	}
    stringBuffer.append(TEXT_26);
    
/*****************************************************************
 * process radio property search 
/*****************************************************************/

    stringBuffer.append(TEXT_27);
    for (int i=0;i<radioPropertyList.size();i++){
    	Property property=radioPropertyList.get(i);
     	String propertyCommentName=TypeHelper.getDocumentationOrName(property);
     	//String propertyUncapSafeName=NameHelper.uncapSafeName(property);
    	//String propertySearchRadios=NamedUtil.getPropertyNamed(property,PropertyNamedRuleKind.searchRadios);
    	needTd=8;
    			if(tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_28);
    			}
    stringBuffer.append(TEXT_29);
    			if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_30);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_31);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    			}
    stringBuffer.append(TEXT_32);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_34);
    			tdCount+=needTd;
    stringBuffer.append(TEXT_35);
    			if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_36);
    			}
    stringBuffer.append(TEXT_37);
    }
    
/*****************************************************************
 * process checkboxPropertyList search 
/*****************************************************************/

    stringBuffer.append(TEXT_38);
    for (int i=0;i<checkboxPropertyList.size();i++){
    	Property property=checkboxPropertyList.get(i);
     	String propertyCommentName=TypeHelper.getDocumentationOrName(property);
     	//String propertyUncapSafeName=NameHelper.uncapSafeName(property);
    	//String propertySearchCheckboxs=NamedUtil.getPropertyNamed(property,PropertyNamedRuleKind.searchCheckboxs);
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
    			if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_46);
    			}
    stringBuffer.append(TEXT_47);
    }
    
/*****************************************************************
 * process searchPropertyList search 
/*****************************************************************/

    stringBuffer.append(TEXT_48);
    for (int i=0;i<searchPropertyList.size();i++){
    	Property property=searchPropertyList.get(i);
    	if(property.getName().equals(curProperty.getName())){
    		continue;
    	}
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
    stringBuffer.append(TEXT_49);
    			}
    stringBuffer.append(TEXT_50);
    			if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_51);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_52);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    			}
    stringBuffer.append(TEXT_53);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(modelEnumSelectHtml);
    stringBuffer.append(TEXT_58);
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
    stringBuffer.append(TEXT_59);
    			}
    stringBuffer.append(TEXT_60);
    			if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_61);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_62);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    			}
    stringBuffer.append(TEXT_63);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(dateSearchStartUncapSafeName);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(dateSearchStartUncapSafeName);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(dateSearchStartUncapSafeName);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(needTd-3);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(dateSearchEndNameUncapSafeName);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(dateSearchEndNameUncapSafeName);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(dateSearchEndNameUncapSafeName);
    stringBuffer.append(TEXT_72);
    			tdCount+=needTd;
    	}else{//process text
    			needTd=2;
    			if(tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_73);
    			}
    stringBuffer.append(TEXT_74);
    			if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_75);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_76);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    			}
    stringBuffer.append(TEXT_77);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_82);
    			tdCount+=needTd;
    	}
    			if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_83);
    			}
    stringBuffer.append(TEXT_84);
    }
    
/*****************************************************************
 * process  search button 
/*****************************************************************/

    stringBuffer.append(TEXT_85);
    	needTd=1;
    			if(tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_86);
    			}
    stringBuffer.append(TEXT_87);
    			if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_88);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_89);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    			}
    stringBuffer.append(TEXT_90);
    			tdCount+=needTd;
    	if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_91);
    	}
    	if (tdCount%trIncludeTd!=0){
    stringBuffer.append(TEXT_92);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_93);
    	}
    stringBuffer.append(TEXT_94);
    }
    stringBuffer.append(TEXT_95);
    	if(TreeStereotypeHelper.getValue_treeListStyle(uml2Class).equalsIgnoreCase("treeGrid")){
    	}else{
    stringBuffer.append(TEXT_96);
    stringBuffer.append(ownerClassCommentName);
    stringBuffer.append(TEXT_97);
    	}
    stringBuffer.append(TEXT_98);
    return stringBuffer.toString();
  }
}
