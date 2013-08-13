package com.jeefuse.mda.gen.template.main.java.js;

import net.taylor.mda.generator.parse.NameRuled.nameRuled.*;
import net.taylor.mda.generator.parse.NameRuled.*;
import java.util.ArrayList;
import net.taylor.mda.generator.parse.stereotype.*;
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

public class EntityListForSelect
{
  protected static String nl;
  public static synchronized EntityListForSelect create(String lineSeparator)
  {
    nl = lineSeparator;
    EntityListForSelect result = new EntityListForSelect();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t";
  protected final String TEXT_2 = "\t";
  protected final String TEXT_3 = "\t\t" + NL + "$(function(){" + NL + "\tvar mainheight = document.documentElement.clientHeight;" + NL + "\t//var mainheight=$(\"#first-box\").height();" + NL + "\tvar w = $(\"#first-content\").width() -2;" + NL + "\tvar gridpm = 25+30+2+20; //GridHead，toolbar，footer,gridmargin" + NL + "\tvar h = mainheight - gridpm-$(\"#first-toolbar\").height()-$(\"#first-search\").height();" + NL + "    var option = {" + NL + "        height: h, " + NL + "        width: w," + NL + "        url: ctx+'";
  protected final String TEXT_4 = "'," + NL + "        colModel: [" + NL + "             { display: '操作',name: '";
  protected final String TEXT_5 = "',width: 50, sortable: true, align: 'center',process:formatOperator}";
  protected final String TEXT_6 = NL + "\t\t   ";
  protected final String TEXT_7 = ",";
  protected final String TEXT_8 = "{ display: '";
  protected final String TEXT_9 = "',name: '";
  protected final String TEXT_10 = "',width: ";
  protected final String TEXT_11 = ", sortable: ";
  protected final String TEXT_12 = ", align: 'center',process:format";
  protected final String TEXT_13 = "}";
  protected final String TEXT_14 = NL + "\t\t   ";
  protected final String TEXT_15 = ",";
  protected final String TEXT_16 = "{ display: '";
  protected final String TEXT_17 = "',name: '";
  protected final String TEXT_18 = "',width: ";
  protected final String TEXT_19 = ", sortable: ";
  protected final String TEXT_20 = ", align: 'center'}";
  protected final String TEXT_21 = NL + "\t\t   ";
  protected final String TEXT_22 = ",";
  protected final String TEXT_23 = "{ display: '";
  protected final String TEXT_24 = "',name: '";
  protected final String TEXT_25 = "_";
  protected final String TEXT_26 = "',width: ";
  protected final String TEXT_27 = ", sortable: ";
  protected final String TEXT_28 = ", align: 'center'}";
  protected final String TEXT_29 = NL + "\t\t   ";
  protected final String TEXT_30 = ",";
  protected final String TEXT_31 = "{ display: '";
  protected final String TEXT_32 = "',name: '";
  protected final String TEXT_33 = "_";
  protected final String TEXT_34 = "',width: ";
  protected final String TEXT_35 = ", sortable: ";
  protected final String TEXT_36 = ", align: 'center'}";
  protected final String TEXT_37 = NL + "\t\t],      " + NL + "\t\tindexId:'";
  protected final String TEXT_38 = "'," + NL + "\t\tsortname: \"";
  protected final String TEXT_39 = "\"," + NL + "\t\tsortorder: \"";
  protected final String TEXT_40 = "\"," + NL + "\t\tsearchparam:searchparamsCall," + NL + "\t\tautoload: true," + NL + "\t\tresizable: false, " + NL + "\t\tshowcheckbox: true," + NL + "\t\tusepager: true," + NL + "\t\tshowseq:true," + NL + "        rowhandler: gridContextmenu," + NL + "\t\trowbinddata: false," + NL + "\t\tonRowDblclick:onRowDblclick" + NL + "    };" + NL + "    " + NL + "\t//format" + NL + "\tfunction formatOperator(id,row){" + NL + "\t\treturn \t'<a href=\"javascript:select(\\''+id+'\\',\\''+row['";
  protected final String TEXT_41 = "']+'\\')\" >'+'选择'+'</a>';" + NL + "\t}" + NL + "\t" + NL + "\t";
  protected final String TEXT_42 = NL + "\tfunction format";
  protected final String TEXT_43 = "(value, pid) {" + NL + "\t\treturn ";
  protected final String TEXT_44 = "[value];" + NL + "\t}";
  protected final String TEXT_45 = NL + NL + "    //search params" + NL + "    function searchparamsCall(){" + NL + "\t\tvar params=$(\"#firstSearchForm\").serializeArray();" + NL + "     \treturn params;" + NL + "\t}" + NL + "\t" + NL + "\t//grid" + NL + "    grid = $(\"#dataGrid\").flexigrid(option);" + NL + "    " + NL + "    //validate";
  protected final String TEXT_46 = "    ";
  protected final String TEXT_47 = NL + "\tsearchFormValidator=$(\"#firstSearchForm\").validate({" + NL + "\t\trules : {";
  protected final String TEXT_48 = NL + "\t\t\t\t";
  protected final String TEXT_49 = ",";
  protected final String TEXT_50 = ":{";
  protected final String TEXT_51 = "}//";
  protected final String TEXT_52 = " ";
  protected final String TEXT_53 = NL + "\t\t\t\t,";
  protected final String TEXT_54 = ":{";
  protected final String TEXT_55 = "}//";
  protected final String TEXT_56 = " ";
  protected final String TEXT_57 = NL + "\t\t\t\t";
  protected final String TEXT_58 = ",";
  protected final String TEXT_59 = "\"";
  protected final String TEXT_60 = ".";
  protected final String TEXT_61 = "\":{";
  protected final String TEXT_62 = "}//";
  protected final String TEXT_63 = " ";
  protected final String TEXT_64 = "\t\t\t\t\t\t";
  protected final String TEXT_65 = NL + "\t\t\t\t";
  protected final String TEXT_66 = ",";
  protected final String TEXT_67 = ":{";
  protected final String TEXT_68 = "}//";
  protected final String TEXT_69 = " ";
  protected final String TEXT_70 = "\t";
  protected final String TEXT_71 = NL + "    \t}," + NL + "    \terrorType: \"bftip\"" + NL + "\t});";
  protected final String TEXT_72 = "\t";
  protected final String TEXT_73 = "\t";
  protected final String TEXT_74 = NL + NL + "\t\t//process ";
  protected final String TEXT_75 = " render" + NL + "\t$(\"#";
  protected final String TEXT_76 = ",#";
  protected final String TEXT_77 = "\").datepicker({" + NL + "\t\t\t  picker: '<img class=\"picker\" src=\"'+ctx+'/resources/style/default/tree/images/s.gif\" alt=\"\" align=\"middle\">'" + NL + "\t\t\t  ,applyrule: ";
  protected final String TEXT_78 = "Rule" + NL + "\t});" + NL + "\t function ";
  protected final String TEXT_79 = "Rule(id) {" + NL + "         if (id == '";
  protected final String TEXT_80 = "') {" + NL + "             var v = $(\"#";
  protected final String TEXT_81 = "\").val();" + NL + "             if (v == \"\") {" + NL + "                 return null;" + NL + "             }else {" + NL + "                 var d = v.match(/^(\\d{1,4})(-|\\/|.)(\\d{1,2})\\2(\\d{1,2})$/);" + NL + "                 if (d != null) {" + NL + "                     var nd = new Date(parseInt(d[1], 10), parseInt(d[3], 10) - 1, parseInt(d[4], 10));" + NL + "                     return { enddate: nd };" + NL + "                 }else {" + NL + "                     return null;" + NL + "                 }" + NL + "             }" + NL + "         } else {" + NL + "             var v = $(\"#";
  protected final String TEXT_82 = "\").val();" + NL + "             if (v == \"\") {" + NL + "                 return null;" + NL + "             }else {" + NL + "                 var d = v.match(/^(\\d{1,4})(-|\\/|.)(\\d{1,2})\\2(\\d{1,2})$/);" + NL + "                 if (d != null) {" + NL + "                     var nd = new Date(parseInt(d[1], 10), parseInt(d[3], 10) - 1, parseInt(d[4], 10));" + NL + "                     return { startdate: nd };" + NL + "                 } else {" + NL + "                     return null;" + NL + "                 }" + NL + "             }" + NL + "         }" + NL + "     }";
  protected final String TEXT_83 = "\t";
  protected final String TEXT_84 = "\t" + NL + "    //variate" + NL + "    config.inputUrl=ctx+'";
  protected final String TEXT_85 = "';" + NL + "    config.editUrl=ctx+'";
  protected final String TEXT_86 = "';" + NL + "    config.deleteOutJsonUrl=ctx+'";
  protected final String TEXT_87 = "';" + NL + "    config.deleteOutJsonAllUrl=ctx+'";
  protected final String TEXT_88 = "';" + NL + "});" + NL + "var grid;" + NL + "var searchFormValidator;" + NL + "var baseTitle=\"";
  protected final String TEXT_89 = "管理\";" + NL + "var inputUrl;" + NL + "var editUrl;" + NL + "var deleteOutJsonUrl;" + NL + "var deleteOutJsonAllUrl;" + NL + "/******contenxtmenu*****/" + NL + "var menu = {" + NL + "\t\twidth : 150," + NL + "\t\titems : [ {" + NL + "\t\t\ttext : \"新增\"," + NL + "\t\t\ticon : ctx+\"/resources/style/default/contextmenu/images/view.png\"," + NL + "\t\t\talias : \"add\"," + NL + "\t\t\taction : contextmenuClick" + NL + "\t\t}, {" + NL + "\t\t\ttext : \"编辑\"," + NL + "\t\t\ticon : ctx+\"/resources/style/default/contextmenu/images/edit.png\"," + NL + "\t\t\talias : \"edit\"," + NL + "\t\t\taction : contextmenuClick" + NL + "\t\t},  {" + NL + "\t\t\ttext : \"删除所选记录\"," + NL + "\t\t\ticon : ctx+\"/resources/style/default/contextmenu/images/rowdelete.png\"," + NL + "\t\t\talias : \"deleteSels\"," + NL + "\t\t\taction : contextmenuClick" + NL + "\t\t},  {" + NL + "\t\t\ttext : \"删除所有记录\"," + NL + "\t\t\ticon : ctx+\"/resources/style/default/contextmenu/images/rowdelete.png\"," + NL + "\t\t\talias : \"deleteAll\"," + NL + "\t\t\taction : contextmenuClick" + NL + "\t\t},{" + NL + "\t\t\ttext : \"刷新\"," + NL + "\t\t\ticon : ctx+\"/resources/style/default/contextmenu/images/table_refresh.png\"," + NL + "\t\t\talias : \"refresh\"," + NL + "\t\t\taction : contextmenuClick" + NL + "\t\t}]" + NL + "\t};" + NL + "function contextmenuClick(target) {" + NL + "\tvar id = $(target).attr(\"id\").substr(3);" + NL + "\tvar rowIdx = $(target).attr(\"seq\");" + NL + "\tvar cmd = this.data.alias;" + NL + "\tswitch(cmd){" + NL + "\t\tcase 'add':" + NL + "\t\t\tvar title=baseTitle+'->新增';" + NL + "\t\t\tnewWinOpen({title:title});" + NL + "\t\t\tbreak;" + NL + "\t\tcase 'edit':" + NL + "\t\t\tvar title = baseTitle+'->编辑 (序号:' + rowIdx + ')';" + NL + "\t\t\tvar url=goolov.addUrlParams(editUrl,\"id=\"+id);" + NL + "\t\t\teditWinOpen( {title:title,url:url});" + NL + "\t\t\tbreak;" + NL + "\t\tcase 'deleteSels':" + NL + "\t\t\tdelData();" + NL + "\t\t\tbreak;" + NL + "\t\tcase 'deleteAll':" + NL + "\t\t\tdelAllData();" + NL + "\t\t\tbreak;" + NL + "\t\tcase 'refresh':" + NL + "\t\t\trefresh();" + NL + "\t\t\tbreak;" + NL + "\t}" + NL + "};" + NL + "function gridContextmenu(row) {" + NL + "\t$(row).contextmenu(menu);" + NL + "} " + NL + "/******searchForm validate check******/" + NL + "function searchFormValidCheck(){" + NL + "\tsearchFormValidator.form();" + NL + "\tif(!searchFormValidator.valid()){" + NL + " \t\tvar invalideNum=searchFormValidator.numberOfInvalids();" + NL + "\t    if(invalideNum>0){" + NL + "\t    \tgoolov.growl.success('有<font color=red> '+invalideNum+'</font> 个查询选项未填写正确!');" + NL + "\t\t    return false;" + NL + "\t    }" + NL + "\t}" + NL + "\treturn true;" + NL + "}" + NL + "/******refresh grid *******/" + NL + "function reloadGrid(setting){" + NL + "\tif(searchFormValidCheck()){" + NL + "\t\tgrid.flexReload(setting?setting:{});" + NL + "\t}" + NL + "}" + NL + "/******refresh  *******/" + NL + "function refresh(){" + NL + "\treloadGrid();" + NL + "}" + NL + "/******reset clear *******/" + NL + "function clear(){" + NL + "\tdocument.getElementById('firstSearchForm').reset();" + NL + "\tsearchFormValidator.resetForm();" + NL + "\treloadGrid({newp:1});" + NL + "}" + NL + "/******search*******/" + NL + "function firstSearch(){" + NL + "\treloadGrid({newp:1});" + NL + "}" + NL + "/******select*******/" + NL + "function select(id,name){";
  protected final String TEXT_90 = NL + "\twindow.parent.";
  protected final String TEXT_91 = "Process(id,name);" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    Class uml2Class = (Class) argument;Package uml2Package = uml2Class.getPackage();
    
UmlClassWrap clazzWrap=new UmlClassWrap(uml2Class);
String modelUncapName=NameHelper.getUncapName(uml2Class);
String modelCommentName=TypeHelper.getDocumentationOrName(uml2Class);

     Property idProperty=EntityHelper.getIDProperty(uml2Class);
     String idPropertyUncapSafeName=NameHelper.uncapSafeName(idProperty);
    Property listKeyProperty=KeyLabelStereotypeHelper.getProperty_liskKey(uml2Class);
    stringBuffer.append(TEXT_1);
    String listKeyPropertyName=NameHelper.uncapSafeName(listKeyProperty);
    Property listLabelProperty=KeyLabelStereotypeHelper.getProperty_listLabel(uml2Class);
    stringBuffer.append(TEXT_2);
    String listLabelPropertyName=NameHelper.uncapSafeName(listLabelProperty);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(clazzWrap.getUrl(WebUrlName.listOutJson));
    stringBuffer.append(TEXT_4);
    stringBuffer.append(idPropertyUncapSafeName);
    stringBuffer.append(TEXT_5);
    
Iterator<Property> simplePropertyList=ViewListHelper.getViewListPropertiesFromSimple(uml2Class).iterator();
Iterator<Property> m2oPropertyList=ViewListHelper.getViewListPropertiesFromM2o(uml2Class).iterator();
Iterator<Property> o2oPropertyList=ViewListHelper.getViewListPropertiesFromO2o(uml2Class).iterator();
boolean firstLine=true;

    for (;simplePropertyList.hasNext();){//process simpleProperty
    		Property property=simplePropertyList.next();
     		String propertyCommentName=TypeHelper.getDocumentationOrName(property);
     		String propertyUncapSafeName=NameHelper.uncapSafeName(property);
     		int width=ViewListHelper.getViewListWidth(property);
     		boolean sortable=ViewListHelper.isSortable(property);
    		//process apply enumeration
    		Enumeration enumeration=EnumKindHelper.getAppliedEnumKindEnumeration(property);
    		if(null!=enumeration){
    			//String modelEnumQualifiedName=MdaHelper.getModelQualifiedName(enumeration,PKGSuffix.enumeration,ModelNameSuffix.enumeration);
    			String modelEnumName=MdaHelper.getModelClassName(enumeration,ModelNameSuffix.enumeration);
    			//String modelEnumJsoncapName=NamedUtil.getPropertyNamed(enumeration,PropertyNamedRuleKind.elementJsonNamed);
    stringBuffer.append(TEXT_6);
    if(firstLine){firstLine=false;}else{
    stringBuffer.append(TEXT_7);
    }
    stringBuffer.append(TEXT_8);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(width);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(sortable);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(modelEnumName);
    stringBuffer.append(TEXT_13);
    		}else{
    stringBuffer.append(TEXT_14);
    if(firstLine){firstLine=false;}else{
    stringBuffer.append(TEXT_15);
    }
    stringBuffer.append(TEXT_16);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(width);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(sortable);
    stringBuffer.append(TEXT_20);
    		}
    }
    for (;m2oPropertyList.hasNext();){//process m2oPropertyList
    		Property property=m2oPropertyList.next();
    		Class propertyType = (Class) property.getType();
     		String propertyTypeCommentName=TypeHelper.getDocumentationOrName(propertyType);
     		String propertyUncapSafeName=NameHelper.uncapSafeName(property);
     		int width=ViewListHelper.getViewListWidth(property);
     		boolean sortable=ViewListHelper.isSortable(property);
    		//rel list label
     		String listLabelPropertyUncapSafeName=ViewListHelper.getViewListLabelRelPropertyName(property);
     		String listLabelPropertyComment=ViewListHelper.getViewListLabelRelPropertyComment(property);
    stringBuffer.append(TEXT_21);
    if(firstLine){firstLine=false;}else{
    stringBuffer.append(TEXT_22);
    }
    stringBuffer.append(TEXT_23);
    stringBuffer.append(propertyTypeCommentName);
    stringBuffer.append(listLabelPropertyComment);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(width);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(sortable);
    stringBuffer.append(TEXT_28);
    }
    for (;o2oPropertyList.hasNext();){//process o2oPropertyList
    		Property property=o2oPropertyList.next();
    		Class propertyType = (Class) property.getType();
     		String propertyTypeCommentName=TypeHelper.getDocumentationOrName(propertyType);
     		String propertyUncapSafeName=NameHelper.uncapSafeName(property);
     		int width=ViewListHelper.getViewListWidth(property);
     		boolean sortable=ViewListHelper.isSortable(property);
    		//rel list label
     		String listLabelPropertyUncapSafeName=ViewListHelper.getViewListLabelRelPropertyName(property);
     		String listLabelPropertyComment=ViewListHelper.getViewListLabelRelPropertyComment(property);
    stringBuffer.append(TEXT_29);
    if(firstLine){firstLine=false;}else{
    stringBuffer.append(TEXT_30);
    }
    stringBuffer.append(TEXT_31);
    stringBuffer.append(propertyTypeCommentName);
    stringBuffer.append(listLabelPropertyComment);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(width);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(sortable);
    stringBuffer.append(TEXT_36);
    }
    stringBuffer.append(TEXT_37);
    stringBuffer.append(NameHelper.uncapSafeName(idProperty));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(OrderByHelper.getOrderField(uml2Class));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(OrderByHelper.getOrderMode(uml2Class));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(listLabelPropertyName);
    stringBuffer.append(TEXT_41);
    //code kind define
    List<Property> codeKindPropertiesList=EnumKindHelper.getPropertiesAppliedEnumKind(uml2Class);
    if(null!=codeKindPropertiesList&&codeKindPropertiesList.size()>0){
    	for(Property property:codeKindPropertiesList){
    		Enumeration enumeration=EnumKindHelper.getAppliedEnumKindEnumeration(property);
    		if(null!=enumeration){
    //			String modelEnumQualifiedName=MdaHelper.getModelQualifiedName(enumeration,PKGSuffix.enumeration,ModelNameSuffix.enumeration);
    			String modelEnumName=MdaHelper.getModelClassName(enumeration,ModelNameSuffix.enumeration);
    			String modelEnumJsoncapName=NamedUtil.getPropertyNamed(enumeration,PropertyNamedRuleKind.elementJsonNamed);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(modelEnumName);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(modelEnumJsoncapName);
    stringBuffer.append(TEXT_44);
    		}
    	}
    }
    stringBuffer.append(TEXT_45);
    List<Property> validatePropertyList=new ArrayList<Property>();
    stringBuffer.append(TEXT_46);
    List<Property> searchPropertyList=ViewSearchHelper.getSearchTextFieldPropertiesFromSimple(uml2Class); 
    for(Iterator<Property> iter=searchPropertyList.iterator();iter.hasNext();){
	Property property=iter.next();
	if (TypeHelper.isDecimal(property) || TypeHelper.isDouble(property.getType())) {
		validatePropertyList.add(property);
	}
	if (TypeHelper.isInteger(property) || TypeHelper.isLong(property.getType())) {
		validatePropertyList.add(property);
	}
	if (TypeHelper.isDate(property)) {
		validatePropertyList.add(property);
	}
}
    if((null!=searchPropertyList&&searchPropertyList.size()>0)){
    stringBuffer.append(TEXT_47);
    	int count=0;
    	for (int i=0;i<validatePropertyList.size();i++){
    		Property property=validatePropertyList.get(i);
    		String jqueryValidate=PageHelper.getJqueryValidateForSearch(property);
    		if(null!=jqueryValidate){
     			String propertyCommentName=TypeHelper.getDocumentationOrName(property);
      		if(ViewInputHelper.isViewInputDatePicker(property)){//process datePicker
     			String propertyUncapSafeName=NameHelper.uncapSafeName(property);
    			String dateSearchStartName=NamedUtil.getPropertyNamed(property,PropertyNamedRuleKind.dateSearchStartName);
     			String dateSearchStartUncapSafeName=NameHelper.uncapName(dateSearchStartName);
    			String dateSearchEndName=NamedUtil.getPropertyNamed(property,PropertyNamedRuleKind.dateSearchEndName);
     			String dateSearchEndNameUncapSafeName=NameHelper.uncapName(dateSearchEndName);
    stringBuffer.append(TEXT_48);
    if(i!=0){
    stringBuffer.append(TEXT_49);
    }
    stringBuffer.append(dateSearchStartUncapSafeName);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(jqueryValidate);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(++count);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(dateSearchEndNameUncapSafeName);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(jqueryValidate);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(++count);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(propertyCommentName);
    		}
    		else if(!ClassHelper.isSimple(property)&&null!=jqueryValidate&&!jqueryValidate.trim().equals("")){
     				//String propertySelectListKey=ViewInputHelper.getRelForListKey(property);
    				Class propertyType = (Class) property.getType();
    				//String propertyTypeComment = TypeHelper.getDocumentationOrName(propertyType);
     				Property propertyTypeIdProperty=EntityHelper.getIDProperty(propertyType);
     				String propertyTypeIdPropertyUncapSafeName=NameHelper.uncapSafeName(propertyTypeIdProperty);
    stringBuffer.append(TEXT_57);
    if(i!=0){
    stringBuffer.append(TEXT_58);
    }
    stringBuffer.append(TEXT_59);
    stringBuffer.append(NameHelper.getUncapName(property));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(jqueryValidate);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(++count);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_64);
    			}else{
    stringBuffer.append(TEXT_65);
    if(i!=0){
    stringBuffer.append(TEXT_66);
    }
    stringBuffer.append(NameHelper.getUncapName(property));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(jqueryValidate);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(++count);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(propertyCommentName);
    			}
    		}
    stringBuffer.append(TEXT_70);
    	}
    stringBuffer.append(TEXT_71);
    }
    stringBuffer.append(TEXT_72);
    for (int i=0;i<searchPropertyList.size();i++){
    stringBuffer.append(TEXT_73);
    	Property property=searchPropertyList.get(i);
      if(ViewInputHelper.isViewInputDatePicker(property)){//process datePicker
     		String propertyUncapSafeName=NameHelper.uncapSafeName(property);
    		String dateSearchStartName=NamedUtil.getPropertyNamed(property,PropertyNamedRuleKind.dateSearchStartName);
     		String dateSearchStartUncapSafeName=NameHelper.uncapName(dateSearchStartName);
    		String dateSearchEndName=NamedUtil.getPropertyNamed(property,PropertyNamedRuleKind.dateSearchEndName);
     		String dateSearchEndNameUncapSafeName=NameHelper.uncapName(dateSearchEndName);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(dateSearchStartUncapSafeName);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(dateSearchEndNameUncapSafeName);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(dateSearchStartUncapSafeName);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(dateSearchEndNameUncapSafeName);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(dateSearchStartUncapSafeName);
    stringBuffer.append(TEXT_82);
    	}
    stringBuffer.append(TEXT_83);
    }
    stringBuffer.append(TEXT_84);
    stringBuffer.append(clazzWrap.getUrl(WebUrlName.systempage_input));
    stringBuffer.append(TEXT_85);
    stringBuffer.append(clazzWrap.getUrl(WebUrlName.systempage_edit));
    stringBuffer.append(TEXT_86);
    stringBuffer.append(clazzWrap.getUrl(WebUrlName.deleteOutJson));
    stringBuffer.append(TEXT_87);
    stringBuffer.append(clazzWrap.getUrl(WebUrlName.deleteAllOutJson));
    stringBuffer.append(TEXT_88);
    stringBuffer.append(modelCommentName);
    stringBuffer.append(TEXT_89);
    		String relM2OAndO2OSelectPage=NamedUtil.getPropertyNamedUncap(uml2Class,PropertyNamedRuleKind.relM2OAndO2OSelectPage);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(relM2OAndO2OSelectPage);
    stringBuffer.append(TEXT_91);
    return stringBuffer.toString();
  }
}
