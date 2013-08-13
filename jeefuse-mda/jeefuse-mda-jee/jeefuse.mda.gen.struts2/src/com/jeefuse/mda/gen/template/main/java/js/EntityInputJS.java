package com.jeefuse.mda.gen.template.main.java.js;

import net.taylor.mda.generator.parse.NameRuled.*;
import net.taylor.mda.generator.parse.NameRuled.nameRuled.*;
import net.taylor.mda.generator.parse.stereotype.*;
import net.taylor.mda.generator.parse.*;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.*;
import net.taylor.mda.generator.util.*;
import net.taylor.mda.generator.parse.entity.*;
import net.taylor.mda.generator.parse.page.*;
import org.eclipse.emf.codegen.util.*;

public class EntityInputJS
{
  protected static String nl;
  public static synchronized EntityInputJS create(String lineSeparator)
  {
    nl = lineSeparator;
    EntityInputJS result = new EntityInputJS();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "$(document).ready(function() {";
  protected final String TEXT_2 = NL + "\t\t//定义tabs" + NL + "\t\t$(\"#firstTabs\").tabs({fit:true,border:false});";
  protected final String TEXT_3 = NL + "\t\tvalidator=$(\"#inputForm\").validate({" + NL + "\t\t\trules : {";
  protected final String TEXT_4 = NL + "\t\t\t\t";
  protected final String TEXT_5 = ",";
  protected final String TEXT_6 = "\"";
  protected final String TEXT_7 = ".";
  protected final String TEXT_8 = "\":{";
  protected final String TEXT_9 = "}//";
  protected final String TEXT_10 = " ";
  protected final String TEXT_11 = "\t\t\t\t\t\t";
  protected final String TEXT_12 = NL + "\t\t\t\t";
  protected final String TEXT_13 = ",";
  protected final String TEXT_14 = ":{";
  protected final String TEXT_15 = "}//";
  protected final String TEXT_16 = " ";
  protected final String TEXT_17 = "\t";
  protected final String TEXT_18 = NL + "\t\t\t}" + NL + "\t\t\t//,errorType: \"bftip\"" + NL + "\t});";
  protected final String TEXT_19 = NL + "\t//";
  protected final String TEXT_20 = " combo tree" + NL + "\t$('#";
  protected final String TEXT_21 = "_";
  protected final String TEXT_22 = "').comboTree({" + NL + "\t\turl: ctx+'";
  protected final String TEXT_23 = "'," + NL + "\t\ticonspath:ctx+\"/resources/style/default/tree/images/\"," + NL + "\t\tkeyEl:'";
  protected final String TEXT_24 = "_";
  protected final String TEXT_25 = "'," + NL + "\t\tonSelect:function(){" + NL + "\t\t\t$(\"#";
  protected final String TEXT_26 = "_";
  protected final String TEXT_27 = "\").valid();" + NL + "\t\t}" + NL + "\t});";
  protected final String TEXT_28 = NL + "\t/****";
  protected final String TEXT_29 = " combo grid*****/" + NL + "\t$('#";
  protected final String TEXT_30 = "_";
  protected final String TEXT_31 = "').comboGrid({" + NL + "\t\twidth: 350," + NL + "\t\theight:160," + NL + "\t\tlabelField:'";
  protected final String TEXT_32 = "'," + NL + "\t\tvalueField:'";
  protected final String TEXT_33 = "'," + NL + "\t\tvalueEl:'";
  protected final String TEXT_34 = "_";
  protected final String TEXT_35 = "'," + NL + "\t\tgridSetting:{" + NL + "\t\t\turl: ctx+'";
  protected final String TEXT_36 = "'," + NL + "\t        colModel: [";
  protected final String TEXT_37 = NL + "\t\t   ";
  protected final String TEXT_38 = ",";
  protected final String TEXT_39 = "{ display: '";
  protected final String TEXT_40 = "',name: '";
  protected final String TEXT_41 = "',width: ";
  protected final String TEXT_42 = ", sortable: ";
  protected final String TEXT_43 = ", align: 'left',process:format";
  protected final String TEXT_44 = "}";
  protected final String TEXT_45 = NL + "\t\t   ";
  protected final String TEXT_46 = ",";
  protected final String TEXT_47 = "{ display: '";
  protected final String TEXT_48 = "',name: '";
  protected final String TEXT_49 = "',width: ";
  protected final String TEXT_50 = ", sortable: ";
  protected final String TEXT_51 = ", align: 'left'}";
  protected final String TEXT_52 = NL + "\t\t   ";
  protected final String TEXT_53 = ",";
  protected final String TEXT_54 = "{ display: '";
  protected final String TEXT_55 = "',name: '";
  protected final String TEXT_56 = ".";
  protected final String TEXT_57 = "',width: ";
  protected final String TEXT_58 = ", sortable: ";
  protected final String TEXT_59 = ", align: 'left'}";
  protected final String TEXT_60 = NL + "\t\t   ";
  protected final String TEXT_61 = ",";
  protected final String TEXT_62 = "{ display: '";
  protected final String TEXT_63 = "',name: '";
  protected final String TEXT_64 = ".";
  protected final String TEXT_65 = "',width: ";
  protected final String TEXT_66 = ", sortable: ";
  protected final String TEXT_67 = ", align: 'left'}";
  protected final String TEXT_68 = NL + "\t\t\t],    " + NL + "\t\t\tindexId:'";
  protected final String TEXT_69 = "'," + NL + "\t\t\tautoload: true" + NL + "\t\t}" + NL + "\t});";
  protected final String TEXT_70 = "\t" + NL + "});" + NL + "var validator;" + NL + "/*******reset Data******/" + NL + "function resetData(){" + NL + "\tvalidator.resetForm();" + NL + "}" + NL + "/********saveDataWithNewWin**************/" + NL + "function newWinSaveData(){" + NL + "\tvar submitUrl=ctx+'";
  protected final String TEXT_71 = "';";
  protected final String TEXT_72 = "\t";
  protected final String TEXT_73 = NL + "\tvar ";
  protected final String TEXT_74 = "=FCKeditorAPI.GetInstance('fck_";
  protected final String TEXT_75 = "').GetHTML(true);";
  protected final String TEXT_76 = "\t";
  protected final String TEXT_77 = "\t" + NL + "    $('#inputForm').ajaxSubmit({ " + NL + "\t\t type : 'post'," + NL + "\t\t dataType:'json', ";
  protected final String TEXT_78 = NL + "\t\t data:";
  protected final String TEXT_79 = ",";
  protected final String TEXT_80 = NL + "\t\t url:submitUrl," + NL + "\t\t beforeSubmit:function(formData, jqForm, options) {" + NL + "\t\t     \tif(!$(\"#inputForm\").valid()){" + NL + "\t\t\t \t\tvar invalideNum=validator.numberOfInvalids();" + NL + "\t\t\t\t    if(invalideNum>0){" + NL + "\t\t\t\t    \tgoolov.growl.success('有<font color=red> '+invalideNum+'</font> 个选项未填写正确!');" + NL + "\t\t\t\t\t    return false;" + NL + "\t\t\t\t    }" + NL + "\t\t\t\t}" + NL + "\t\t\t\tgoolov.growl.waiting('新增数据中...');" + NL + "\t\t }," + NL + "\t     success:function(result, statusText, xhr, $form) {" + NL + "\t     \t\tgoolov.growl.unwaiting();" + NL + "\t\t\t\tif (result&&result.success) {" + NL + "\t\t\t\t\tgoolov.growl.success(result.message);" + NL + "\t\t\t\t\t$(\"#";
  protected final String TEXT_81 = "\").val(result.data.id);" + NL + "\t\t\t\t\twindow.parent.addRowData(result.data);" + NL + "\t\t\t\t}else if(result&&result.message){" + NL + "\t\t\t\t\tgoolov.msgbox.error(result.message);" + NL + "\t\t\t\t}else{" + NL + "\t\t\t\t\tgoolov.msgbox.error();" + NL + "\t\t\t\t}" + NL + "\t\t }," + NL + "\t\t error:function(request,status,errorThrown) {" + NL + "\t\t \tgoolov.growl.unwaiting();" + NL + "\t\t\tgoolov.msgbox.error();" + NL + "\t\t}" + NL + "\t}); " + NL + "}" + NL + "function newWinClose(){" + NL + "\twindow.parent.newWinClose();" + NL + "}" + NL + "/*******updateDataWithEditWin******/" + NL + "function editWinUpdateData(){" + NL + "\tvar submitUrl=ctx+'";
  protected final String TEXT_82 = "';";
  protected final String TEXT_83 = NL + "\tvar ";
  protected final String TEXT_84 = "=FCKeditorAPI.GetInstance('fck_";
  protected final String TEXT_85 = "').GetHTML(true);";
  protected final String TEXT_86 = NL + "    $('#inputForm').ajaxSubmit({ " + NL + "\t\t type : 'post'," + NL + "\t\t dataType:'json', ";
  protected final String TEXT_87 = NL + "\t\t data:";
  protected final String TEXT_88 = ",";
  protected final String TEXT_89 = NL + "\t\t url:submitUrl," + NL + "\t\t beforeSubmit:function(formData, jqForm, options) {" + NL + "\t\t     \tif(!$(\"#inputForm\").valid()){" + NL + "\t\t\t \t\tvar invalideNum=validator.numberOfInvalids();" + NL + "\t\t\t\t    if(invalideNum>0){" + NL + "\t\t\t\t    \tgoolov.growl.success('有<font color=red> '+invalideNum+'</font> 个选项未填写正确!');" + NL + "\t\t\t\t\t    return false;" + NL + "\t\t\t\t    }" + NL + "\t\t\t\t}" + NL + "\t\t\t\tgoolov.growl.waiting('新增数据中...');" + NL + "\t\t }," + NL + "\t     success:function(result, statusText, xhr, $form) {" + NL + "\t     \t\tgoolov.growl.unwaiting();" + NL + "\t\t\t\tif (result&&result.success) {" + NL + "\t\t\t\t\tgoolov.growl.success(result.message);" + NL + "\t\t\t\t\twindow.parent.addRowData(result.data);" + NL + "\t\t\t\t}else if(result&&result.message){" + NL + "\t\t\t\t\tgoolov.msgbox.error(result.message);" + NL + "\t\t\t\t}else{" + NL + "\t\t\t\t\tgoolov.msgbox.error();" + NL + "\t\t\t\t}" + NL + "\t\t }," + NL + "\t\t error:function(request,status,errorThrown) {" + NL + "\t\t \tgoolov.growl.unwaiting();" + NL + "\t\t\tgoolov.msgbox.error();" + NL + "\t\t}" + NL + "\t}); " + NL + "}" + NL + "/*******close edit win******/" + NL + "function editWinClose(){" + NL + "\twindow.parent.editWinClose();" + NL + "}";
  protected final String TEXT_90 = NL + "var diningDefaultNoPictureUrl=ctx+'/resources/style/default/images/defaultNoPicture.jpg';" + NL + "/*******upload ";
  protected final String TEXT_91 = " image*******/" + NL + "function ";
  protected final String TEXT_92 = "Browse(e){" + NL + "\tif (!goolov.validete.image(e)) {" + NL + "\t\treturn;" + NL + "\t}" + NL + "\t$('#";
  protected final String TEXT_93 = "_image_uploaded').hide();" + NL + "\t$('#";
  protected final String TEXT_94 = "_image_browse').show();" + NL + "\tgoolov.file.previewImage(e,{previewWrapId:'";
  protected final String TEXT_95 = "_image_browse_preview',width:150,height:140});" + NL + "}" + NL + "function ";
  protected final String TEXT_96 = "PreviewRemove(){" + NL + "\tgoolov.file.clear(\"";
  protected final String TEXT_97 = "_image\");" + NL + "\t$('#";
  protected final String TEXT_98 = "_image_browse').hide();" + NL + "\t$('#";
  protected final String TEXT_99 = "_image_uploaded').show();" + NL + "}" + NL + "/*******del photo image********/" + NL + "function ";
  protected final String TEXT_100 = "Del(id){" + NL + "\tvar submitUrl=ctx+'";
  protected final String TEXT_101 = "?id='+id;" + NL + "    $.ajax({ " + NL + "\t\t type : 'post'," + NL + "\t\t dataType:'html', " + NL + "\t\t url:submitUrl," + NL + "\t\t beforeSubmit:function(formData, jqForm, options) {" + NL + "\t\t\t\tgoolov.growl.waiting('正在删除中...');" + NL + "\t\t }," + NL + "\t     success:function(result, statusText, xhr, $form) {" + NL + "\t     \t\tgoolov.growl.unwaiting();" + NL + "\t     \t\tvar result=JSON.parse(result);" + NL + "\t\t\t\tif (result&&result.success) {" + NL + "\t\t\t\t\tgoolov.growl.success(result.message);" + NL + "\t\t\t\t\t";
  protected final String TEXT_102 = "Update();" + NL + "\t\t\t\t}else if(result&&result.message){" + NL + "\t\t\t\t\tgoolov.msgbox.error(result.message);" + NL + "\t\t\t\t}else{" + NL + "\t\t\t\t\tgoolov.msgbox.error();" + NL + "\t\t\t\t}" + NL + "\t\t }," + NL + "\t\t error:function(request,status,errorThrown) {" + NL + "\t\t \tgoolov.growl.unwaiting();" + NL + "\t\t\tgoolov.msgbox.error();" + NL + "\t\t}" + NL + "\t}); " + NL + "}" + NL + "function ";
  protected final String TEXT_103 = "Update(data){" + NL + "\tgoolov.file.clear('";
  protected final String TEXT_104 = "_image');" + NL + "\t$('#";
  protected final String TEXT_105 = "_image_browse').hide();" + NL + "\tvar oldHtml=[];" + NL + "\tif(data&&data.";
  protected final String TEXT_106 = "){" + NL + "\t\toldHtml.push('<img ',' width=\"',150,'\" height=\"'+140+'\" src=\"'+ctx+'/'+data.";
  protected final String TEXT_107 = "+'\"/>');" + NL + "\t\t//oldHtml.push('<span class=\"label\">已上传</span><a href=\"javascript:";
  protected final String TEXT_108 = "Del(\\''+data.id+'\\');\" class=\"remove\" >删除</a>');" + NL + "\t\toldHtml.push('<span class=\"label\">已上传</span>');" + NL + "\t}else{" + NL + "\t\toldHtml.push('<img ',' width=\"',150,'\" height=\"'+140+'\" src=\"'+diningDefaultNoPictureUrl+'\"/>');" + NL + "\t}" + NL + "\t$('#";
  protected final String TEXT_109 = "_image_uploaded').empty().html(oldHtml.join('')).show();//.fadeOut(250, function() { $(this).remove();});" + NL + "}";
  protected final String TEXT_110 = NL + "/*******del ";
  protected final String TEXT_111 = " file********/" + NL + "function ";
  protected final String TEXT_112 = "Del(id){" + NL + "\tvar submitUrl=ctx+'";
  protected final String TEXT_113 = "?id='+id;" + NL + "    $.ajax({ " + NL + "\t\t type : 'post'," + NL + "\t\t dataType:'json', " + NL + "\t\t url:submitUrl," + NL + "\t\t beforeSubmit:function(formData, jqForm, options) {" + NL + "\t\t\t\tgoolov.growl.waiting('正在删除中...');" + NL + "\t\t }," + NL + "\t     success:function(result, statusText, xhr, $form) {" + NL + "\t     \t\tgoolov.growl.unwaiting();" + NL + "\t     \t\tvar result=JSON.parse(result);" + NL + "\t\t\t\tif (result&&result.success) {" + NL + "\t\t\t\t\tgoolov.growl.success(result.message);" + NL + "\t\t\t\t\t";
  protected final String TEXT_114 = "Update();" + NL + "\t\t\t\t}else if(result&&result.message){" + NL + "\t\t\t\t\tgoolov.msgbox.error(result.message);" + NL + "\t\t\t\t}else{" + NL + "\t\t\t\t\tgoolov.msgbox.error();" + NL + "\t\t\t\t}" + NL + "\t\t }," + NL + "\t\t error:function(request,status,errorThrown) {" + NL + "\t\t \tgoolov.growl.unwaiting();" + NL + "\t\t\tgoolov.msgbox.error();" + NL + "\t\t}" + NL + "\t}); " + NL + "}";
  protected final String TEXT_115 = NL;
  protected final String TEXT_116 = NL + "/*******rel ";
  protected final String TEXT_117 = " manager**********/" + NL + "var ";
  protected final String TEXT_118 = "Win;" + NL + "function ";
  protected final String TEXT_119 = "WinInit(){" + NL + "\tif(!";
  protected final String TEXT_120 = "Win){" + NL + "\t\t";
  protected final String TEXT_121 = "Win=new goolov.winbox({" + NL + "\t\t\twidth:goolov.winWidth(750)," + NL + "\t\t\theight:goolov.winHeight(450)," + NL + "\t\t\tmodal:true," + NL + "\t\t\tneeedReLoad:false" + NL + "\t\t});" + NL + "\t}" + NL + "}" + NL + "function ";
  protected final String TEXT_122 = "WinOpen(settings){" + NL + "\t";
  protected final String TEXT_123 = "WinInit();" + NL + "\t";
  protected final String TEXT_124 = "Win.open(settings);" + NL + "}" + NL + "function ";
  protected final String TEXT_125 = "WinClose(){" + NL + "\t";
  protected final String TEXT_126 = "Win.close();" + NL + "}" + NL + "function ";
  protected final String TEXT_127 = "(id,name){" + NL + "\tvar title='";
  protected final String TEXT_128 = "选择';" + NL + "\tvar url=ctx+'";
  protected final String TEXT_129 = "';" + NL + "\t";
  protected final String TEXT_130 = "WinOpen({title:title,url:url});" + NL + "}" + NL + "function ";
  protected final String TEXT_131 = "Process(id,name){" + NL + "\t$('#";
  protected final String TEXT_132 = "_";
  protected final String TEXT_133 = "').val(id);" + NL + "\t$('#";
  protected final String TEXT_134 = "_";
  protected final String TEXT_135 = "').val(name);" + NL + "\t";
  protected final String TEXT_136 = "WinClose();" + NL + "\tvalidator.form();" + NL + "}" + NL + "function relGlDiningSiteListForSelectClear(){" + NL + "\t$('#";
  protected final String TEXT_137 = "_";
  protected final String TEXT_138 = "').val('');" + NL + "\t$('#";
  protected final String TEXT_139 = "_";
  protected final String TEXT_140 = "').val('');" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    Class uml2Class = (Class) argument;Package uml2Package = uml2Class.getPackage();
    
UmlClassWrap clazzWrap=new UmlClassWrap(uml2Class);
List<Property> contentPropertyList=ViewInputHelper.getViewInputContentOrContentTab(uml2Class);

    stringBuffer.append(TEXT_1);
    List<Property> tabsList=ViewInputHelper.getTabsProperty(uml2Class);
    List<Property> contentTabPropertyList=ViewInputHelper.getViewInputContentTab(uml2Class);
    if(!tabsList.isEmpty()||!contentTabPropertyList.isEmpty()){
    stringBuffer.append(TEXT_2);
    }
    stringBuffer.append(TEXT_3);
    
Property idProperty=EntityHelper.getIDProperty(uml2Class);
String idPropertyUncapSafeName=NameHelper.uncapSafeName(idProperty);
List<Property> propertyList=new ArrayList<Property>();
List<Property> inputValidateList=ViewInputHelper.getInputPropertyForValidate(uml2Class);
//List<Property> M2OSelectList=ViewInputHelper.getApplyM2OSelect(uml2Class);
//List<Property> O2OSelectList=ViewInputHelper.getApplyO2OSelect(uml2Class);
//List<Property> O2OSelectPageList=ViewInputHelper.getApplyO2OSelectPage(uml2Class);
//List<Property> M2OSelectPageList=ViewInputHelper.getApplyM2OSelectPage(uml2Class);
propertyList.addAll(inputValidateList);
//propertyList.addAll(M2OSelectList);
//propertyList.addAll(O2OSelectList);
//propertyList.addAll(O2OSelectPageList);
//propertyList.addAll(M2OSelectPageList);

    int count=0;
    for (int i=0;i<propertyList.size();i++){
    	Property property=propertyList.get(i);
    	if(ViewInputHelper.isViewInput_readonly(property)){
    		continue;
    }
    	String jqueryValidate=PageHelper.getJqueryValidate(property);
    	if(null!=jqueryValidate){
     		String propertyCommentName=TypeHelper.getDocumentationOrName(property);
    		if(!ClassHelper.isSimple(property)&&null!=jqueryValidate&&!jqueryValidate.trim().equals("")){
     				//String propertySelectListKey=ViewInputHelper.getRelForListKey(property);
    				Class propertyType = (Class) property.getType();
    				//String propertyTypeComment = TypeHelper.getDocumentationOrName(propertyType);
     				Property propertyTypeIdProperty=EntityHelper.getIDProperty(propertyType);
     				String propertyTypeIdPropertyUncapSafeName=NameHelper.uncapSafeName(propertyTypeIdProperty);
    stringBuffer.append(TEXT_4);
    if(i!=0){
    stringBuffer.append(TEXT_5);
    }
    stringBuffer.append(TEXT_6);
    stringBuffer.append(NameHelper.getUncapName(property));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(jqueryValidate);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(++count);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_11);
    		}else{
    stringBuffer.append(TEXT_12);
    if(i!=0){
    stringBuffer.append(TEXT_13);
    }
    stringBuffer.append(NameHelper.getUncapName(property));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(jqueryValidate);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(++count);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(propertyCommentName);
    		}
    	}
    stringBuffer.append(TEXT_17);
    }
    stringBuffer.append(TEXT_18);
    List<Property> m2oAndO2OProperty=ViewInputHelper.getApplyM2OAndO2OSelect(uml2Class);
    if(null!=m2oAndO2OProperty&&!m2oAndO2OProperty.isEmpty()){
    	for(Iterator<Property> iter=m2oAndO2OProperty.iterator();iter.hasNext();){
    		Property property=iter.next();
     		String propertyUncapSafeName=NameHelper.uncapSafeName(property);
    		Class propertyType = (Class) property.getType();
    		String propertyTypeComment = TypeHelper.getDocumentationOrName(propertyType);
     		Property propertyTypeIdProperty=EntityHelper.getIDProperty(propertyType);
     		String propertyTypeIdPropertyUncapSafeName=NameHelper.uncapSafeName(propertyTypeIdProperty);
     		String listLabelPropertyUncapSafeName=ViewListHelper.getViewListLabelRelPropertyName(property);
    		if(ModelStereoTypeHelper.isApplyModel_Tree(propertyType)){//应用了tree
    stringBuffer.append(TEXT_19);
    stringBuffer.append(propertyTypeComment);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(MdaHelper.getModelUrl(propertyType,WebUrlName.listTreeOutJson));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_27);
    		}else{
    stringBuffer.append(TEXT_28);
    stringBuffer.append(propertyTypeComment);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(MdaHelper.getModelUrl(propertyType,WebUrlName.listForSelectOutJson));
    stringBuffer.append(TEXT_36);
    Iterator<Property> simplePropertyList=ViewListHelper.getViewListPropertiesFromSimple(propertyType).iterator();
    Iterator<Property> m2oPropertyList=ViewListHelper.getViewListPropertiesFromM2o(propertyType).iterator();
    Iterator<Property> o2oPropertyList=ViewListHelper.getViewListPropertiesFromO2o(propertyType).iterator();
    boolean firstLine=true;
    for (;simplePropertyList.hasNext();){//process simpleProperty
    		Property relClassProperty=simplePropertyList.next();
     		String relClassPropertyCommentName=TypeHelper.getDocumentationOrName(relClassProperty);
     		String relClassPropertyUncapSafeName=NameHelper.uncapSafeName(relClassProperty);
     		int width=ViewListHelper.getViewListWidth(relClassProperty);
     		boolean sortable=ViewListHelper.isSortable(relClassProperty);
    		//process apply enumeration
    		Enumeration enumeration=EnumKindHelper.getAppliedEnumKindEnumeration(relClassProperty);
    		if(null!=enumeration){
    			String modelEnumName=MdaHelper.getModelClassName(enumeration,ModelNameSuffix.enumeration);
    stringBuffer.append(TEXT_37);
    if(firstLine){firstLine=false;}else{
    stringBuffer.append(TEXT_38);
    }
    stringBuffer.append(TEXT_39);
    stringBuffer.append(relClassPropertyCommentName);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(relClassPropertyUncapSafeName);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(width);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(sortable);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(modelEnumName);
    stringBuffer.append(TEXT_44);
    		}else{
    stringBuffer.append(TEXT_45);
    if(firstLine){firstLine=false;}else{
    stringBuffer.append(TEXT_46);
    }
    stringBuffer.append(TEXT_47);
    stringBuffer.append(relClassPropertyCommentName);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(relClassPropertyUncapSafeName);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(width);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(sortable);
    stringBuffer.append(TEXT_51);
    		}
    }
    for (;m2oPropertyList.hasNext();){//process m2oPropertyList
    		Property relClassProperty=m2oPropertyList.next();
    		Class relClassPropertyType = (Class) relClassProperty.getType();
     		String relClassPropertyTypeCommentName=TypeHelper.getDocumentationOrName(relClassPropertyType);
     		String relClassPropertyUncapSafeName=NameHelper.uncapSafeName(relClassProperty);
     		int width=ViewListHelper.getViewListWidth(relClassProperty);
     		boolean sortable=ViewListHelper.isSortable(relClassProperty);
    		//rel list label
     		String relClassPropertyListLabelUncapSafeName=ViewListHelper.getViewListLabelRelPropertyName(relClassProperty);
     		String relClassPropertyListLabelComment=ViewListHelper.getViewListLabelRelPropertyComment(relClassProperty);
    stringBuffer.append(TEXT_52);
    if(firstLine){firstLine=false;}else{
    stringBuffer.append(TEXT_53);
    }
    stringBuffer.append(TEXT_54);
    stringBuffer.append(relClassPropertyTypeCommentName);
    stringBuffer.append(relClassPropertyListLabelComment);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(relClassPropertyUncapSafeName);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(relClassPropertyListLabelUncapSafeName);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(width);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(sortable);
    stringBuffer.append(TEXT_59);
    }
    for (;o2oPropertyList.hasNext();){//process o2oPropertyList
    		Property relClassProperty=o2oPropertyList.next();
    		Class relClassPropertyType = (Class) relClassProperty.getType();
     		String relClassPropertyTypeCommentName=TypeHelper.getDocumentationOrName(relClassPropertyType);
     		String relClassPropertyUncapSafeName=NameHelper.uncapSafeName(relClassProperty);
     		int width=ViewListHelper.getViewListWidth(relClassProperty);
     		boolean sortable=ViewListHelper.isSortable(relClassProperty);
    		//rel list label
     		String relClassPropertyListLabelUncapSafeName=ViewListHelper.getViewListLabelRelPropertyName(relClassProperty);
     		String relClassPropertyListLabelComment=ViewListHelper.getViewListLabelRelPropertyComment(relClassProperty);
    stringBuffer.append(TEXT_60);
    if(firstLine){firstLine=false;}else{
    stringBuffer.append(TEXT_61);
    }
    stringBuffer.append(TEXT_62);
    stringBuffer.append(relClassPropertyTypeCommentName);
    stringBuffer.append(relClassPropertyListLabelComment);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(relClassPropertyUncapSafeName);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(relClassPropertyListLabelUncapSafeName);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(width);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(sortable);
    stringBuffer.append(TEXT_67);
    }
    stringBuffer.append(TEXT_68);
    stringBuffer.append(NameHelper.uncapSafeName(propertyTypeIdProperty));
    stringBuffer.append(TEXT_69);
    	}
    }
    		}
    stringBuffer.append(TEXT_70);
    stringBuffer.append(clazzWrap.getUrl(WebUrlName.saveOutJson));
    stringBuffer.append(TEXT_71);
    List<String> postDataList=new ArrayList<String>();
    stringBuffer.append(TEXT_72);
    if(!contentPropertyList.isEmpty()){
    	for(Iterator<Property> iter=contentPropertyList.iterator();iter.hasNext();){
    		Property property=iter.next();
     		String propertyUncapSafeName=NameHelper.uncapSafeName(property);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_75);
    		postDataList.add(propertyUncapSafeName+":"+propertyUncapSafeName);
    stringBuffer.append(TEXT_76);
    	}
    }
    stringBuffer.append(TEXT_77);
    if(!postDataList.isEmpty()){
    stringBuffer.append(TEXT_78);
    stringBuffer.append(GenHelper.constructPostDataJsObject(postDataList));
    stringBuffer.append(TEXT_79);
    }
    stringBuffer.append(TEXT_80);
    stringBuffer.append(idPropertyUncapSafeName);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(clazzWrap.getUrl(WebUrlName.updateOutJson));
    stringBuffer.append(TEXT_82);
    if(!contentPropertyList.isEmpty()){
    	for(Iterator<Property> iter=contentPropertyList.iterator();iter.hasNext();){
    		Property property=iter.next();
     		String propertyUncapSafeName=NameHelper.uncapSafeName(property);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_85);
    	}
    }
    stringBuffer.append(TEXT_86);
    if(!postDataList.isEmpty()){
    stringBuffer.append(TEXT_87);
    stringBuffer.append(GenHelper.constructPostDataJsObject(postDataList));
    stringBuffer.append(TEXT_88);
    }
    stringBuffer.append(TEXT_89);
    
/*****************************************************************
 * process image property
/*****************************************************************/

    if (FileStereotypeHelper.hasProperty_Image(uml2Class)) {// image
    	Property property=FileStereotypeHelper.getProperty_Image(uml2Class);
     	String propertyUncapSafeName=NameHelper.uncapSafeName(property);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(MdaHelper.getModelUrl(uml2Class,WebUrlName.deleteImageOutJson));
    stringBuffer.append(TEXT_101);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_109);
    }
    
/*****************************************************************
 * process file property
/*****************************************************************/

    if(FileStereotypeHelper.hasProperty_File(uml2Class)) {// file
    	Property property=FileStereotypeHelper.getProperty_File(uml2Class);
     	String propertyUncapSafeName=NameHelper.uncapSafeName(property);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(MdaHelper.getModelUrl(uml2Class,WebUrlName.deleteImageOutJson));
    stringBuffer.append(TEXT_113);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_114);
    }
    
/*****************************************************************
 * rel O2OSelectPage M2OSelectPage
/*****************************************************************/

    List<Property> resultPropertyList=ViewInputHelper.getApplyM2OSelectPage(uml2Class);
    //List<Property> m2oPropertyList=ViewListHelper.getViewListPropertiesFromM2o(uml2Class);
    //List<Property> o2oPropertyList=ViewListHelper.getViewListPropertiesFromO2o(uml2Class);
    //resultPropertyList.addAll(m2oPropertyList);
    //resultPropertyList.addAll(o2oPropertyList);
    if(null!=resultPropertyList&&!resultPropertyList.isEmpty()){
    	for(Iterator<Property> iter=resultPropertyList.iterator();iter.hasNext();){
    stringBuffer.append(TEXT_115);
    		Property property=iter.next();
    		String propertyUncapSafeName=NameHelper.uncapSafeName(property);
    		Type propertyType=property.getType();
    		Class propertyTypeClass=(Class)propertyType;
    		//String relTargetClassCapName=NameHelper.getCapName(relTargetClass);
    		//String relTargetClassUncapName=NameHelper.getUncapName(relTargetClass);
    		String relTargetClassCommentName=TypeHelper.getDocumentationOrName(propertyTypeClass);
    		String relM2OAndO2OSelectPage=NamedUtil.getPropertyNamedUncap(propertyTypeClass,PropertyNamedRuleKind.relM2OAndO2OSelectPage);
     		Property propertyTypeIdProperty=EntityHelper.getIDProperty(propertyTypeClass);
     		String propertyTypeIdPropertyUncapSafeName=NameHelper.uncapSafeName(propertyTypeIdProperty);
     		String listLabelPropertyUncapSafeName=ViewListHelper.getViewListLabelRelPropertyName(property);
     		//String listLabelPropertyComment=ViewListHelper.getViewListLabelRelPropertyComment(property);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(relM2OAndO2OSelectPage);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(relM2OAndO2OSelectPage);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(relM2OAndO2OSelectPage);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(relM2OAndO2OSelectPage);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(relM2OAndO2OSelectPage);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(relM2OAndO2OSelectPage);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(relM2OAndO2OSelectPage);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(relM2OAndO2OSelectPage);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(relM2OAndO2OSelectPage);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(relM2OAndO2OSelectPage);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(MdaHelper.getModelUrl(propertyTypeClass,WebUrlName.listForSelect));
    stringBuffer.append(TEXT_129);
    stringBuffer.append(relM2OAndO2OSelectPage);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(relM2OAndO2OSelectPage);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(relM2OAndO2OSelectPage);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_140);
    	}
    }
    return stringBuffer.toString();
  }
}
