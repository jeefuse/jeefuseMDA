package com.jeefuse.mda.gen.template.main.java.js;

import net.taylor.mda.generator.parse.NameRuled.nameRuled.*;
import net.taylor.mda.generator.parse.NameRuled.*;
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

public class EntityInputJSManageByPropertyForFile
{
  protected static String nl;
  public static synchronized EntityInputJSManageByPropertyForFile create(String lineSeparator)
  {
    nl = lineSeparator;
    EntityInputJSManageByPropertyForFile result = new EntityInputJSManageByPropertyForFile();
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
  protected final String TEXT_18 = NL + "\t\t}," + NL + "\t\terrorType: \"bftip\"" + NL + "\t});" + NL + "\t\t//uploadFile" + NL + "\t$('#path_fileInput').uploadify({" + NL + "\t\t'uploader'  : ctx+'/resources/js/uploadify/uploadify.swf'," + NL + "\t\t'script'    : ctx+'";
  protected final String TEXT_19 = "'," + NL + "\t\t'cancelImg' : ctx+'/resources/style/'+theme+'/images/cancel.png'," + NL + "\t\t'auto'      : false," + NL + "\t\t'folder'    : '/userFiles'," + NL + "\t\t'wmode'     : 'transparent'," + NL + "\t\t'queueID'   : 'path_fileInput_queue'," + NL + "\t\t'multi'     : true," + NL + "\t\t'fileExt'\t:  goolov.file.imageExtSemicolon," + NL + "\t\t'fileDesc'\t:  goolov.file.imageDesc," + NL + "\t\t'sizeLimit' : 1024*1024*2," + NL + "\t\t'queueSizeLimit':20," + NL + "\t\t'onComplete':function(event,ID,fileObj,response,data){" + NL + "\t\t\ttry {" + NL + "\t\t\t\tvar result=JSON.parse(response);" + NL + "\t\t\t\tif (result&&result.success) {" + NL + "\t\t\t\t\tjQuery(\"#path_fileInput\" + ID + \" .percentage\").html(\" - <span class='success'>上传成功!</span>\");" + NL + "\t\t\t\t\twindow.parent.addRowData(result.data);" + NL + "\t\t\t\t\tjQuery(\"#path_fileInput\" + ID).fadeOut(2000, function() { jQuery(this).remove();});" + NL + "\t\t\t\t\treturn false;" + NL + "\t\t\t\t}else if(result&&result.message){" + NL + "\t\t\t\t\t//goolov.msgbox.error('\"'+fileObj.name+'\"上传错误!'+result.message);" + NL + "\t\t\t\t\tjQuery(\"#path_fileInput\" + ID + \" .percentage\").html(\" - <span class='error'>上传错误:\"+result.message+\"</span>\");" + NL + "\t\t\t\t\tjQuery(\"#path_fileInput\" + ID).addClass('uploadifyError');" + NL + "\t\t\t\t\tjQuery(\"#path_fileInput\" + ID).fadeOut(2000, function() { jQuery(this).remove();});" + NL + "\t\t\t\t\treturn false;" + NL + "\t\t\t\t}else{" + NL + "\t\t\t\t\t//goolov.msgbox.error('\"'+fileObj.name+'\"上传错误!');" + NL + "\t\t\t\t\tjQuery(\"#path_fileInput\" + ID + \" .percentage\").html(\" - <span class='error'>上传失败!</span>\");" + NL + "\t\t\t\t\tjQuery(\"#path_fileInput\" + ID).addClass('uploadifyError');" + NL + "\t\t\t\t\tjQuery(\"#path_fileInput\" + ID).fadeOut(2000, function() { jQuery(this).remove();});" + NL + "\t\t\t\t\treturn false;" + NL + "\t\t\t\t}" + NL + "\t\t\t} catch (e) {" + NL + "\t\t\t\tjQuery(\"#path_fileInput\" + ID + \" .percentage\").html(\" - <span class='error'>解析出错!</span>\");" + NL + "\t\t\t\tjQuery(\"#path_fileInput\" + ID).addClass('uploadifyError');" + NL + "\t\t\t\tjQuery(\"#path_fileInput\" + ID).fadeOut(2000, function() { jQuery(this).remove();});" + NL + "\t\t\t}" + NL + "\t\t\treturn false;" + NL + "\t\t}," + NL + "\t\t'onAllComplete':function(event,data){" + NL + "\t\t\tvar msg='上传完成';" + NL + "\t\t\t//var msg='上传完成'+data.filesUploaded+'个文件';" + NL + "\t\t\tif(data.errors>0){" + NL + "\t\t\t\tmsg+='<br/>上传失败'+data.errors+'个文件';" + NL + "\t\t\t}" + NL + "\t\t\tmsg+='<br/>平均速率'+Math.round(data.speed)+'KB/s';" + NL + "\t\t\tgoolov.growl.show(msg);" + NL + "\t\t}" + NL + "\t});" + NL + "});" + NL + "var validator;" + NL + "/*******reset Data******/" + NL + "function resetData(){" + NL + "\tvalidator.resetForm();" + NL + "\t$('#path_fileInput').uploadifyClearQueue();" + NL + "}" + NL + "function uploadImage(){" + NL + "\tif(!$(\"#inputForm\").valid()){" + NL + " \t\tvar invalideNum=validator.numberOfInvalids();" + NL + "\t    if(invalideNum>0){" + NL + "\t    \tgoolov.growl.success('有<font color=red> '+invalideNum+'</font> 个选项未填写正确!');" + NL + "\t\t    return ;" + NL + "\t    }" + NL + "\t}" + NL + "\tvar scriptData={";
  protected final String TEXT_20 = NL + "\t\t  \t\t";
  protected final String TEXT_21 = ",";
  protected final String TEXT_22 = "'";
  protected final String TEXT_23 = "':$('#";
  protected final String TEXT_24 = "').val(),";
  protected final String TEXT_25 = NL + "\t\t\t\t";
  protected final String TEXT_26 = ",";
  protected final String TEXT_27 = "'";
  protected final String TEXT_28 = ".";
  protected final String TEXT_29 = "':$('#";
  protected final String TEXT_30 = "_";
  protected final String TEXT_31 = "').val()";
  protected final String TEXT_32 = NL + "\t\t\t\t};" + NL + "\t$('#path_fileInput').uploadifySettings('scriptData',scriptData);" + NL + "\t$('#path_fileInput').uploadifyUpload();" + NL + "}" + NL + "function uploadClearQueue(){" + NL + "\t$('#path_fileInput').uploadifyClearQueue();" + NL + "}" + NL + "/*******updateDataWithEditWin******/" + NL + "function editWinUpdateData(){" + NL + "\tvar submitUrl=ctx+'";
  protected final String TEXT_33 = "';" + NL + "    $('#inputForm').ajaxSubmit({ " + NL + "\t\t type : 'post'," + NL + "\t\t dataType:'json', " + NL + "\t\t url:submitUrl," + NL + "\t\t beforeSubmit:function(formData, jqForm, options) {" + NL + "\t\t     \tif(!$(\"#inputForm\").valid()){" + NL + "\t\t\t \t\tvar invalideNum=validator.numberOfInvalids();" + NL + "\t\t\t\t    if(invalideNum>0){" + NL + "\t\t\t\t    \tgoolov.growl.success('有<font color=red> '+invalideNum+'</font> 个选项未填写正确!');" + NL + "\t\t\t\t\t    return false;" + NL + "\t\t\t\t    }" + NL + "\t\t\t\t}" + NL + "\t\t\t\tgoolov.growl.waiting('新增数据中...');" + NL + "\t\t }," + NL + "\t     success:function(result, statusText, xhr, $form) {" + NL + "\t     \t\tgoolov.growl.unwaiting();" + NL + "\t\t\t\tif (result&&result.success) {" + NL + "\t\t\t\t\tgoolov.growl.success(result.message);" + NL + "\t\t\t\t\twindow.parent.addRowData(result.data);" + NL + "\t\t\t\t}else if(result&&result.message){" + NL + "\t\t\t\t\tgoolov.msgbox.error(result.message);" + NL + "\t\t\t\t}else{" + NL + "\t\t\t\t\tgoolov.msgbox.error();" + NL + "\t\t\t\t}" + NL + "\t\t }," + NL + "\t\t error:function(request,status,errorThrown) {" + NL + "\t\t \tgoolov.growl.unwaiting();" + NL + "\t\t\tgoolov.msgbox.error();" + NL + "\t\t}" + NL + "\t}); " + NL + "}" + NL + "/*******close edit win******/" + NL + "function editWinClose(){" + NL + "\twindow.parent.editWinClose();" + NL + "}" + NL + "function editWinCloseAndRefresh(){" + NL + "\twindow.parent.editWinCloseAndRefresh();" + NL + "}";
  protected final String TEXT_34 = NL + "/*******rel GsysCodevalue manager**********/" + NL + "var ";
  protected final String TEXT_35 = "Win;" + NL + "function ";
  protected final String TEXT_36 = "WinInit(){" + NL + "\tif(!";
  protected final String TEXT_37 = "Win){" + NL + "\t\t";
  protected final String TEXT_38 = "Win=new goolov.winbox({" + NL + "\t\t\twidth:goolov.winWidth(750)," + NL + "\t\t\theight:goolov.winHeight(450)," + NL + "\t\t\tmodal:true" + NL + "\t\t});" + NL + "\t}" + NL + "}" + NL + "function ";
  protected final String TEXT_39 = "WinOpen(settings){" + NL + "\t";
  protected final String TEXT_40 = "WinInit();" + NL + "\t";
  protected final String TEXT_41 = "Win.open(settings);" + NL + "}" + NL + "function ";
  protected final String TEXT_42 = "WinClose(){" + NL + "\t";
  protected final String TEXT_43 = "Win.close();" + NL + "}" + NL + "function ";
  protected final String TEXT_44 = "(id,name){" + NL + "\tvar title=baseTitle+'('+name+')->";
  protected final String TEXT_45 = "选择';" + NL + "\tvar url=ctx+'";
  protected final String TEXT_46 = "';" + NL + "\t";
  protected final String TEXT_47 = "WinOpen({title:title,url:url});" + NL + "}" + NL + "function ";
  protected final String TEXT_48 = "Process(id,name){" + NL + "\t$('#";
  protected final String TEXT_49 = "_";
  protected final String TEXT_50 = "').val(id);" + NL + "\t$('#";
  protected final String TEXT_51 = "_";
  protected final String TEXT_52 = "').val(name);" + NL + "\t";
  protected final String TEXT_53 = "WinClose();" + NL + "\tvalidator.form();" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    Property curProperty = (Property) argument;Package uml2Package = curProperty.getNearestPackage();
    //String curPropertyGetAccessor=ModelHelper.getGetAccessor(curProperty);
    Class ownerClass=(Class)curProperty.getOwner();
    //Property ownerClassIdProperty=EntityHelper.getIDProperty(ownerClass);
    //String ownerClassIdPropertyGetter=ClassHelper.getGetAccessor(ownerClassIdProperty);
    UmlClassByPropertyWrap named=new UmlClassByPropertyWrap(curProperty);
    Class uml2Class=ownerClass;
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
propertyList.addAll(inputValidateList);
//List<Property> M2OSelectList=ViewInputHelper.getApplyM2OSelect(uml2Class);
//List<Property> O2OSelectList=ViewInputHelper.getApplyO2OSelect(uml2Class);
//List<Property> O2OSelectPageList=ViewInputHelper.getApplyO2OSelectPage(uml2Class);
//List<Property> M2OSelectPageList=ViewInputHelper.getApplyM2OSelectPage(uml2Class);
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
    	if(property.getName().equals(curProperty.getName())){
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
    if(count!=0){
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
    stringBuffer.append(named.getUrl(WebUrlName.saveOutJson));
    stringBuffer.append(TEXT_19);
    List<Property> fileSimpleInputPropertyList=ViewInputHelper.getFileSimpleInputProperty(uml2Class);
    boolean firstLine=true;
    for (Iterator<Property> it=fileSimpleInputPropertyList.iterator();it.hasNext();){//process simpleProperty
    		Property property=it.next();
     		//String propertyCommentName=TypeHelper.getDocumentationOrName(property);
     		String propertyUncapSafeName=NameHelper.uncapSafeName(property);
    		if(ClassHelper.isSimple(property)){
    stringBuffer.append(TEXT_20);
    if(firstLine){firstLine=false;}else{
    stringBuffer.append(TEXT_21);
    }
    stringBuffer.append(TEXT_22);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_24);
    		}else if(ClassHelper.isOneToOne(property)||ClassHelper.isManyToOne(property)){
    			Type propertyType=property.getType();
    			Class propertyTypeClass=(Class)propertyType;
    			//String relTargetClassCapName=NameHelper.getCapName(relTargetClass);
    			//String relTargetClassUncapName=NameHelper.getUncapName(relTargetClass);
    			//String relTargetClassCommentName=TypeHelper.getDocumentationOrName(propertyTypeClass);
    			//String relM2OAndO2OSelectPage=NamedUtil.getPropertyNamedUncap(propertyTypeClass,PropertyNamedRuleKind.relM2OAndO2OSelectPage);
     			Property propertyTypeIdProperty=EntityHelper.getIDProperty(propertyTypeClass);
     			String propertyTypeIdPropertyUncapSafeName=NameHelper.uncapSafeName(propertyTypeIdProperty);
    stringBuffer.append(TEXT_25);
    if(firstLine){firstLine=false;}else{
    stringBuffer.append(TEXT_26);
    }
    stringBuffer.append(TEXT_27);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_31);
    		}
    }
    stringBuffer.append(TEXT_32);
    stringBuffer.append(named.getUrl(WebUrlName.updateOutJson));
    stringBuffer.append(TEXT_33);
    
/*****************************************************************
 * rel O2OSelectPage M2OSelectPage
/*****************************************************************/

    List<Property> resultPropertyList=ViewInputHelper.getApplyM2OSelectPage(uml2Class);
    List<Property> m2oPropertyList=ViewListHelper.getViewListPropertiesFromM2o(uml2Class);
    List<Property> o2oPropertyList=ViewListHelper.getViewListPropertiesFromO2o(uml2Class);
    resultPropertyList.addAll(m2oPropertyList);
    resultPropertyList.addAll(o2oPropertyList);
    if(null!=resultPropertyList&&!resultPropertyList.isEmpty()){
    	for(Iterator<Property> iter=resultPropertyList.iterator();iter.hasNext();){
    		Property property=iter.next();
    		if(property.getName().equals(curProperty.getName())){
    			continue;
    		}
    		String propertyUncapSafeName=NameHelper.uncapSafeName(property);
    		Type propertyType=property.getType();
    		Class relTargetClass=(Class)propertyType;
    		//String relTargetClassCapName=NameHelper.getCapName(relTargetClass);
    		//String relTargetClassUncapName=NameHelper.getUncapName(relTargetClass);
    		String relTargetClassCommentName=TypeHelper.getDocumentationOrName(relTargetClass);
    		String relM2OAndO2OSelectPage=NamedUtil.getPropertyNamedUncap(relTargetClass,PropertyNamedRuleKind.relM2OAndO2OSelectPage);
     		Property propertyTypeIdProperty=EntityHelper.getIDProperty(relTargetClass);
     		String propertyTypeIdPropertyUncapSafeName=NameHelper.uncapSafeName(propertyTypeIdProperty);
     		String listLabelPropertyUncapSafeName=ViewListHelper.getViewListLabelRelPropertyName(property);
     		//String listLabelPropertyComment=ViewListHelper.getViewListLabelRelPropertyComment(property);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(relM2OAndO2OSelectPage);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(relM2OAndO2OSelectPage);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(relM2OAndO2OSelectPage);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(relM2OAndO2OSelectPage);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(relM2OAndO2OSelectPage);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(relM2OAndO2OSelectPage);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(relM2OAndO2OSelectPage);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(relM2OAndO2OSelectPage);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(relM2OAndO2OSelectPage);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(relM2OAndO2OSelectPage);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(MdaHelper.getModelUrlByRel(uml2Class,relTargetClass,WebUrlName.relM2OAndO2OSelectPage));
    stringBuffer.append(TEXT_46);
    stringBuffer.append(relM2OAndO2OSelectPage);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(relM2OAndO2OSelectPage);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(relM2OAndO2OSelectPage);
    stringBuffer.append(TEXT_53);
    	}
    }
    return stringBuffer.toString();
  }
}
