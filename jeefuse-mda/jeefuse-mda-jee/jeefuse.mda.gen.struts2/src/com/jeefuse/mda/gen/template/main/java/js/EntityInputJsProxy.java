package com.jeefuse.mda.gen.template.main.java.js;

import net.taylor.mda.generator.parse.NameRuled.nameRuled.*;
import net.taylor.mda.generator.parse.NameRuled.*;
import net.taylor.mda.generator.parse.stereotype.*;
import net.taylor.mda.generator.parse.page.*;
import java.util.List;
import java.util.ArrayList;
import net.taylor.mda.generator.parse.*;
import net.taylor.mda.generator.parse.entity.*;
import java.util.Iterator;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.*;
import net.taylor.mda.generator.util.*;
import org.eclipse.emf.codegen.util.*;

public class EntityInputJsProxy
{
  protected static String nl;
  public static synchronized EntityInputJsProxy create(String lineSeparator)
  {
    nl = lineSeparator;
    EntityInputJsProxy result = new EntityInputJsProxy();
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
  protected final String TEXT_19 = "'," + NL + "\t\t'cancelImg' : ctx+'/resources/style/'+theme+'/images/cancel.png'," + NL + "\t\t'auto'      : false," + NL + "\t\t'folder'    : '/userFiles'," + NL + "\t\t'wmode'     : 'transparent'," + NL + "\t\t'queueID'   : 'path_fileInput_queue'," + NL + "\t\t'multi'     : true," + NL + "\t\t'fileExt'\t:  goolov.file.imageExtSemicolon," + NL + "\t\t'fileDesc'\t:  goolov.file.imageDesc," + NL + "\t\t'sizeLimit' : 1024*1024*2," + NL + "\t\t'queueSizeLimit':20," + NL + "\t\t'onComplete':function(event,ID,fileObj,response,data){" + NL + "\t\t\ttry {" + NL + "\t\t\t\tvar result=JSON.parse(response);" + NL + "\t\t\t\tif (result&&result.success) {" + NL + "\t\t\t\t\tjQuery(\"#path_fileInput\" + ID + \" .percentage\").html(\" - <span class='success'>上传成功!</span>\");" + NL + "\t\t\t\t\twindow.parent.addRowData(result.data);" + NL + "\t\t\t\t\tjQuery(\"#path_fileInput\" + ID).fadeOut(3000, function() { jQuery(this).remove();});" + NL + "\t\t\t\t\treturn false;" + NL + "\t\t\t\t}else if(result&&result.message){" + NL + "\t\t\t\t\t//goolov.msgbox.error('\"'+fileObj.name+'\"上传错误!'+result.message);" + NL + "\t\t\t\t\tjQuery(\"#path_fileInput\" + ID + \" .percentage\").html(\" - <span class='error'>上传错误:\"+result.message+\"</span>\");" + NL + "\t\t\t\t\tjQuery(\"#path_fileInput\" + ID).addClass('uploadifyError');" + NL + "\t\t\t\t\tjQuery(\"#path_fileInput\" + ID).fadeOut(3000, function() { jQuery(this).remove();});" + NL + "\t\t\t\t\treturn false;" + NL + "\t\t\t\t}else{" + NL + "\t\t\t\t\t//goolov.msgbox.error('\"'+fileObj.name+'\"上传错误!');" + NL + "\t\t\t\t\tjQuery(\"#path_fileInput\" + ID + \" .percentage\").html(\" - <span class='error'>上传失败!</span>\");" + NL + "\t\t\t\t\tjQuery(\"#path_fileInput\" + ID).addClass('uploadifyError');" + NL + "\t\t\t\t\tjQuery(\"#path_fileInput\" + ID).fadeOut(3000, function() { jQuery(this).remove();});" + NL + "\t\t\t\t\treturn false;" + NL + "\t\t\t\t}" + NL + "\t\t\t} catch (e) {" + NL + "\t\t\t\tjQuery(\"#path_fileInput\" + ID + \" .percentage\").html(\" - <span class='error'>解析出错!</span>\");" + NL + "\t\t\t\tjQuery(\"#path_fileInput\" + ID).addClass('uploadifyError');" + NL + "\t\t\t\tjQuery(\"#path_fileInput\" + ID).fadeOut(3000, function() { jQuery(this).remove();});" + NL + "\t\t\t}" + NL + "\t\t\treturn false;" + NL + "\t\t}," + NL + "\t\t'onAllComplete':function(event,data){" + NL + "\t\t\t//var msg='上传完成';" + NL + "\t\t\t//var msg='上传完成'+data.filesUploaded+'个文件';" + NL + "//\t\t\tif(data.errors>0){" + NL + "//\t\t\t\tmsg+='<br/>上传失败'+data.errors+'个文件';" + NL + "//\t\t\t}" + NL + "\t\t\t//msg+='<br/>平均速率'+Math.round(data.speed)+'KB/s';" + NL + "\t\t\t//goolov.growl.show(msg);" + NL + "\t\t}" + NL + "\t});" + NL + "});" + NL + "var validator;" + NL + "/*******reset Data******/" + NL + "function resetData(){" + NL + "\tvalidator.resetForm();" + NL + "\t$('#path_fileInput').uploadifyClearQueue();" + NL + "}" + NL + "function uploadImage(){" + NL + "\tif(!$(\"#inputForm\").valid()){" + NL + " \t\tvar invalideNum=validator.numberOfInvalids();" + NL + "\t    if(invalideNum>0){" + NL + "\t    \tgoolov.growl.success('有<font color=red> '+invalideNum+'</font> 个选项未填写正确!');" + NL + "\t\t    return ;" + NL + "\t    }" + NL + "\t}" + NL + "\tvar scriptData={";
  protected final String TEXT_20 = NL + "\t\t  \t\t";
  protected final String TEXT_21 = ",";
  protected final String TEXT_22 = "'";
  protected final String TEXT_23 = "':$('#";
  protected final String TEXT_24 = "').val()";
  protected final String TEXT_25 = NL + "\t\t\t\t";
  protected final String TEXT_26 = ",";
  protected final String TEXT_27 = "'";
  protected final String TEXT_28 = ".";
  protected final String TEXT_29 = "':$('#";
  protected final String TEXT_30 = "_";
  protected final String TEXT_31 = "').val()";
  protected final String TEXT_32 = NL + "\t\t\t\t};" + NL + "\t$('#path_fileInput').uploadifySettings('scriptData',scriptData);" + NL + "\t$('#path_fileInput').uploadifyUpload();" + NL + "}" + NL + "function uploadClearQueue(){" + NL + "\t$('#path_fileInput').uploadifyClearQueue();" + NL + "}" + NL + "/*******updateDataWithEditWin******/" + NL + "function editWinUpdateData(){" + NL + "\tvar submitUrl=ctx+'";
  protected final String TEXT_33 = "';" + NL + "    $('#inputForm').ajaxSubmit({ " + NL + "\t\t type : 'post'," + NL + "\t\t dataType:'json', " + NL + "\t\t url:submitUrl," + NL + "\t\t beforeSubmit:function(formData, jqForm, options) {" + NL + "\t\t     \tif(!$(\"#inputForm\").valid()){" + NL + "\t\t\t \t\tvar invalideNum=validator.numberOfInvalids();" + NL + "\t\t\t\t    if(invalideNum>0){" + NL + "\t\t\t\t    \tgoolov.growl.success('有<font color=red> '+invalideNum+'</font> 个选项未填写正确!');" + NL + "\t\t\t\t\t    return false;" + NL + "\t\t\t\t    }" + NL + "\t\t\t\t}" + NL + "\t\t\t\tgoolov.growl.waiting('新增数据中...');" + NL + "\t\t }," + NL + "\t     success:function(result, statusText, xhr, $form) {" + NL + "\t     \t\tgoolov.growl.unwaiting();" + NL + "\t\t\t\tif (result&&result.success) {" + NL + "\t\t\t\t\tgoolov.growl.success(result.message);" + NL + "\t\t\t\t\twindow.parent.addRowData(result.data);" + NL + "\t\t\t\t}else if(result&&result.message){" + NL + "\t\t\t\t\tgoolov.msgbox.error(result.message);" + NL + "\t\t\t\t}else{" + NL + "\t\t\t\t\tgoolov.msgbox.error();" + NL + "\t\t\t\t}" + NL + "\t\t }," + NL + "\t\t error:function(request,status,errorThrown) {" + NL + "\t\t \tgoolov.growl.unwaiting();" + NL + "\t\t\tgoolov.msgbox.error();" + NL + "\t\t}" + NL + "\t}); " + NL + "}" + NL + "/*******close edit win******/" + NL + "function editWinClose(){" + NL + "\twindow.parent.editWinClose();" + NL + "}";
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
  protected final String TEXT_54 = NL + "$(document).ready(function() {";
  protected final String TEXT_55 = NL + "\t\t//定义tabs" + NL + "\t\t$(\"#firstTabs\").tabs({fit:true,border:false});";
  protected final String TEXT_56 = NL + "\t\tvalidator=$(\"#inputForm\").validate({" + NL + "\t\t\trules : {";
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
  protected final String TEXT_71 = NL + "\t\t\t}" + NL + "\t\t\t//,errorType: \"bftip\"" + NL + "\t});";
  protected final String TEXT_72 = NL + "\t//";
  protected final String TEXT_73 = " combo tree" + NL + "\t$('#";
  protected final String TEXT_74 = "_";
  protected final String TEXT_75 = "').comboTree({" + NL + "\t\turl: ctx+'";
  protected final String TEXT_76 = "'," + NL + "\t\ticonspath:ctx+\"/resources/style/default/tree/images/\"," + NL + "\t\tkeyEl:'";
  protected final String TEXT_77 = "_";
  protected final String TEXT_78 = "'," + NL + "\t\tonSelect:function(){" + NL + "\t\t\t$(\"#";
  protected final String TEXT_79 = "_";
  protected final String TEXT_80 = "\").valid();" + NL + "\t\t}" + NL + "\t});";
  protected final String TEXT_81 = NL + "\t/****";
  protected final String TEXT_82 = " combo grid*****/" + NL + "\t$('#";
  protected final String TEXT_83 = "_";
  protected final String TEXT_84 = "').comboGrid({" + NL + "\t\twidth: 350," + NL + "\t\theight:160," + NL + "\t\tlabelField:'";
  protected final String TEXT_85 = "'," + NL + "\t\tvalueField:'";
  protected final String TEXT_86 = "'," + NL + "\t\tvalueEl:'";
  protected final String TEXT_87 = "_";
  protected final String TEXT_88 = "'," + NL + "\t\tgridSetting:{" + NL + "\t\t\turl: ctx+'";
  protected final String TEXT_89 = "'," + NL + "\t        colModel: [";
  protected final String TEXT_90 = NL + "\t\t   ";
  protected final String TEXT_91 = ",";
  protected final String TEXT_92 = "{ display: '";
  protected final String TEXT_93 = "',name: '";
  protected final String TEXT_94 = "',width: ";
  protected final String TEXT_95 = ", sortable: ";
  protected final String TEXT_96 = ", align: 'left',process:format";
  protected final String TEXT_97 = "}";
  protected final String TEXT_98 = NL + "\t\t   ";
  protected final String TEXT_99 = ",";
  protected final String TEXT_100 = "{ display: '";
  protected final String TEXT_101 = "',name: '";
  protected final String TEXT_102 = "',width: ";
  protected final String TEXT_103 = ", sortable: ";
  protected final String TEXT_104 = ", align: 'left'}";
  protected final String TEXT_105 = NL + "\t\t   ";
  protected final String TEXT_106 = ",";
  protected final String TEXT_107 = "{ display: '";
  protected final String TEXT_108 = "',name: '";
  protected final String TEXT_109 = ".";
  protected final String TEXT_110 = "',width: ";
  protected final String TEXT_111 = ", sortable: ";
  protected final String TEXT_112 = ", align: 'left'}";
  protected final String TEXT_113 = NL + "\t\t   ";
  protected final String TEXT_114 = ",";
  protected final String TEXT_115 = "{ display: '";
  protected final String TEXT_116 = "',name: '";
  protected final String TEXT_117 = ".";
  protected final String TEXT_118 = "',width: ";
  protected final String TEXT_119 = ", sortable: ";
  protected final String TEXT_120 = ", align: 'left'}";
  protected final String TEXT_121 = NL + "\t\t\t],    " + NL + "\t\t\tindexId:'";
  protected final String TEXT_122 = "'," + NL + "\t\t\tautoload: true" + NL + "\t\t}" + NL + "\t});";
  protected final String TEXT_123 = "\t" + NL + "});" + NL + "var validator;" + NL + "/*******reset Data******/" + NL + "function resetData(){" + NL + "\tvalidator.resetForm();" + NL + "}" + NL + "/********saveDataWithNewWin**************/" + NL + "function newWinSaveData(){" + NL + "\tvar submitUrl=ctx+'";
  protected final String TEXT_124 = "';";
  protected final String TEXT_125 = "\t";
  protected final String TEXT_126 = NL + "\tvar ";
  protected final String TEXT_127 = "=FCKeditorAPI.GetInstance('fck_";
  protected final String TEXT_128 = "').GetHTML(true);";
  protected final String TEXT_129 = "\t";
  protected final String TEXT_130 = "\t" + NL + "    $('#inputForm').ajaxSubmit({ " + NL + "\t\t type : 'post'," + NL + "\t\t dataType:'json', ";
  protected final String TEXT_131 = NL + "\t\t data:";
  protected final String TEXT_132 = ",";
  protected final String TEXT_133 = NL + "\t\t url:submitUrl," + NL + "\t\t beforeSubmit:function(formData, jqForm, options) {" + NL + "\t\t     \tif(!$(\"#inputForm\").valid()){" + NL + "\t\t\t \t\tvar invalideNum=validator.numberOfInvalids();" + NL + "\t\t\t\t    if(invalideNum>0){" + NL + "\t\t\t\t    \tgoolov.growl.success('有<font color=red> '+invalideNum+'</font> 个选项未填写正确!');" + NL + "\t\t\t\t\t    return false;" + NL + "\t\t\t\t    }" + NL + "\t\t\t\t}" + NL + "\t\t\t\tgoolov.growl.waiting('新增数据中...');" + NL + "\t\t }," + NL + "\t     success:function(result, statusText, xhr, $form) {" + NL + "\t     \t\tgoolov.growl.unwaiting();" + NL + "\t\t\t\tif (result&&result.success) {" + NL + "\t\t\t\t\tgoolov.growl.success(result.message);" + NL + "\t\t\t\t\t$(\"#";
  protected final String TEXT_134 = "\").val(result.data.id);" + NL + "\t\t\t\t\twindow.parent.addRowData(result.data);" + NL + "\t\t\t\t}else if(result&&result.message){" + NL + "\t\t\t\t\tgoolov.msgbox.error(result.message);" + NL + "\t\t\t\t}else{" + NL + "\t\t\t\t\tgoolov.msgbox.error();" + NL + "\t\t\t\t}" + NL + "\t\t }," + NL + "\t\t error:function(request,status,errorThrown) {" + NL + "\t\t \tgoolov.growl.unwaiting();" + NL + "\t\t\tgoolov.msgbox.error();" + NL + "\t\t}" + NL + "\t}); " + NL + "}" + NL + "function newWinClose(){" + NL + "\twindow.parent.newWinClose();" + NL + "}" + NL + "/*******updateDataWithEditWin******/" + NL + "function editWinUpdateData(){" + NL + "\tvar submitUrl=ctx+'";
  protected final String TEXT_135 = "';";
  protected final String TEXT_136 = NL + "\tvar ";
  protected final String TEXT_137 = "=FCKeditorAPI.GetInstance('fck_";
  protected final String TEXT_138 = "').GetHTML(true);";
  protected final String TEXT_139 = NL + "    $('#inputForm').ajaxSubmit({ " + NL + "\t\t type : 'post'," + NL + "\t\t dataType:'json', ";
  protected final String TEXT_140 = NL + "\t\t data:";
  protected final String TEXT_141 = ",";
  protected final String TEXT_142 = NL + "\t\t url:submitUrl," + NL + "\t\t beforeSubmit:function(formData, jqForm, options) {" + NL + "\t\t     \tif(!$(\"#inputForm\").valid()){" + NL + "\t\t\t \t\tvar invalideNum=validator.numberOfInvalids();" + NL + "\t\t\t\t    if(invalideNum>0){" + NL + "\t\t\t\t    \tgoolov.growl.success('有<font color=red> '+invalideNum+'</font> 个选项未填写正确!');" + NL + "\t\t\t\t\t    return false;" + NL + "\t\t\t\t    }" + NL + "\t\t\t\t}" + NL + "\t\t\t\tgoolov.growl.waiting('新增数据中...');" + NL + "\t\t }," + NL + "\t     success:function(result, statusText, xhr, $form) {" + NL + "\t     \t\tgoolov.growl.unwaiting();" + NL + "\t\t\t\tif (result&&result.success) {" + NL + "\t\t\t\t\tgoolov.growl.success(result.message);" + NL + "\t\t\t\t\twindow.parent.addRowData(result.data);" + NL + "\t\t\t\t}else if(result&&result.message){" + NL + "\t\t\t\t\tgoolov.msgbox.error(result.message);" + NL + "\t\t\t\t}else{" + NL + "\t\t\t\t\tgoolov.msgbox.error();" + NL + "\t\t\t\t}" + NL + "\t\t }," + NL + "\t\t error:function(request,status,errorThrown) {" + NL + "\t\t \tgoolov.growl.unwaiting();" + NL + "\t\t\tgoolov.msgbox.error();" + NL + "\t\t}" + NL + "\t}); " + NL + "}" + NL + "/*******close edit win******/" + NL + "function editWinClose(){" + NL + "\twindow.parent.editWinClose();" + NL + "}";
  protected final String TEXT_143 = NL + "var diningDefaultNoPictureUrl=ctx+'/resources/style/default/images/defaultNoPicture.jpg';" + NL + "/*******upload ";
  protected final String TEXT_144 = " image*******/" + NL + "function ";
  protected final String TEXT_145 = "Browse(e){" + NL + "\tif (!goolov.validete.image(e)) {" + NL + "\t\treturn;" + NL + "\t}" + NL + "\t$('#";
  protected final String TEXT_146 = "_image_uploaded').hide();" + NL + "\t$('#";
  protected final String TEXT_147 = "_image_browse').show();" + NL + "\tgoolov.file.previewImage(e,{previewWrapId:'";
  protected final String TEXT_148 = "_image_browse_preview',width:150,height:140});" + NL + "}" + NL + "function ";
  protected final String TEXT_149 = "PreviewRemove(){" + NL + "\tgoolov.file.clear(\"";
  protected final String TEXT_150 = "_image\");" + NL + "\t$('#";
  protected final String TEXT_151 = "_image_browse').hide();" + NL + "\t$('#";
  protected final String TEXT_152 = "_image_uploaded').show();" + NL + "}" + NL + "/*******del photo image********/" + NL + "function ";
  protected final String TEXT_153 = "Del(id){" + NL + "\tvar submitUrl=ctx+'";
  protected final String TEXT_154 = "?id='+id;" + NL + "    $.ajax({ " + NL + "\t\t type : 'post'," + NL + "\t\t dataType:'html', " + NL + "\t\t url:submitUrl," + NL + "\t\t beforeSubmit:function(formData, jqForm, options) {" + NL + "\t\t\t\tgoolov.growl.waiting('正在删除中...');" + NL + "\t\t }," + NL + "\t     success:function(result, statusText, xhr, $form) {" + NL + "\t     \t\tgoolov.growl.unwaiting();" + NL + "\t     \t\tvar result=JSON.parse(result);" + NL + "\t\t\t\tif (result&&result.success) {" + NL + "\t\t\t\t\tgoolov.growl.success(result.message);" + NL + "\t\t\t\t\t";
  protected final String TEXT_155 = "Update();" + NL + "\t\t\t\t}else if(result&&result.message){" + NL + "\t\t\t\t\tgoolov.msgbox.error(result.message);" + NL + "\t\t\t\t}else{" + NL + "\t\t\t\t\tgoolov.msgbox.error();" + NL + "\t\t\t\t}" + NL + "\t\t }," + NL + "\t\t error:function(request,status,errorThrown) {" + NL + "\t\t \tgoolov.growl.unwaiting();" + NL + "\t\t\tgoolov.msgbox.error();" + NL + "\t\t}" + NL + "\t}); " + NL + "}" + NL + "function ";
  protected final String TEXT_156 = "Update(data){" + NL + "\tgoolov.file.clear('";
  protected final String TEXT_157 = "_image');" + NL + "\t$('#";
  protected final String TEXT_158 = "_image_browse').hide();" + NL + "\tvar oldHtml=[];" + NL + "\tif(data&&data.";
  protected final String TEXT_159 = "){" + NL + "\t\toldHtml.push('<img ',' width=\"',150,'\" height=\"'+140+'\" src=\"'+ctx+'/'+data.";
  protected final String TEXT_160 = "+'\"/>');" + NL + "\t\t//oldHtml.push('<span class=\"label\">已上传</span><a href=\"javascript:";
  protected final String TEXT_161 = "Del(\\''+data.id+'\\');\" class=\"remove\" >删除</a>');" + NL + "\t\toldHtml.push('<span class=\"label\">已上传</span>');" + NL + "\t}else{" + NL + "\t\toldHtml.push('<img ',' width=\"',150,'\" height=\"'+140+'\" src=\"'+diningDefaultNoPictureUrl+'\"/>');" + NL + "\t}" + NL + "\t$('#";
  protected final String TEXT_162 = "_image_uploaded').empty().html(oldHtml.join('')).show();//.fadeOut(250, function() { $(this).remove();});" + NL + "}";
  protected final String TEXT_163 = NL + "/*******del ";
  protected final String TEXT_164 = " file********/" + NL + "function ";
  protected final String TEXT_165 = "Del(id){" + NL + "\tvar submitUrl=ctx+'";
  protected final String TEXT_166 = "?id='+id;" + NL + "    $.ajax({ " + NL + "\t\t type : 'post'," + NL + "\t\t dataType:'json', " + NL + "\t\t url:submitUrl," + NL + "\t\t beforeSubmit:function(formData, jqForm, options) {" + NL + "\t\t\t\tgoolov.growl.waiting('正在删除中...');" + NL + "\t\t }," + NL + "\t     success:function(result, statusText, xhr, $form) {" + NL + "\t     \t\tgoolov.growl.unwaiting();" + NL + "\t     \t\tvar result=JSON.parse(result);" + NL + "\t\t\t\tif (result&&result.success) {" + NL + "\t\t\t\t\tgoolov.growl.success(result.message);" + NL + "\t\t\t\t\t";
  protected final String TEXT_167 = "Update();" + NL + "\t\t\t\t}else if(result&&result.message){" + NL + "\t\t\t\t\tgoolov.msgbox.error(result.message);" + NL + "\t\t\t\t}else{" + NL + "\t\t\t\t\tgoolov.msgbox.error();" + NL + "\t\t\t\t}" + NL + "\t\t }," + NL + "\t\t error:function(request,status,errorThrown) {" + NL + "\t\t \tgoolov.growl.unwaiting();" + NL + "\t\t\tgoolov.msgbox.error();" + NL + "\t\t}" + NL + "\t}); " + NL + "}";
  protected final String TEXT_168 = NL;
  protected final String TEXT_169 = NL + "/*******rel ";
  protected final String TEXT_170 = " manager**********/" + NL + "var ";
  protected final String TEXT_171 = "Win;" + NL + "function ";
  protected final String TEXT_172 = "WinInit(){" + NL + "\tif(!";
  protected final String TEXT_173 = "Win){" + NL + "\t\t";
  protected final String TEXT_174 = "Win=new goolov.winbox({" + NL + "\t\t\twidth:goolov.winWidth(750)," + NL + "\t\t\theight:goolov.winHeight(450)," + NL + "\t\t\tmodal:true," + NL + "\t\t\tneeedReLoad:false" + NL + "\t\t});" + NL + "\t}" + NL + "}" + NL + "function ";
  protected final String TEXT_175 = "WinOpen(settings){" + NL + "\t";
  protected final String TEXT_176 = "WinInit();" + NL + "\t";
  protected final String TEXT_177 = "Win.open(settings);" + NL + "}" + NL + "function ";
  protected final String TEXT_178 = "WinClose(){" + NL + "\t";
  protected final String TEXT_179 = "Win.close();" + NL + "}" + NL + "function ";
  protected final String TEXT_180 = "(id,name){" + NL + "\tvar title='";
  protected final String TEXT_181 = "选择';" + NL + "\tvar url=ctx+'";
  protected final String TEXT_182 = "';" + NL + "\t";
  protected final String TEXT_183 = "WinOpen({title:title,url:url});" + NL + "}" + NL + "function ";
  protected final String TEXT_184 = "Process(id,name){" + NL + "\t$('#";
  protected final String TEXT_185 = "_";
  protected final String TEXT_186 = "').val(id);" + NL + "\t$('#";
  protected final String TEXT_187 = "_";
  protected final String TEXT_188 = "').val(name);" + NL + "\t";
  protected final String TEXT_189 = "WinClose();" + NL + "\tvalidator.form();" + NL + "}" + NL + "function relGlDiningSiteListForSelectClear(){" + NL + "\t$('#";
  protected final String TEXT_190 = "_";
  protected final String TEXT_191 = "').val('');" + NL + "\t$('#";
  protected final String TEXT_192 = "_";
  protected final String TEXT_193 = "').val('');" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    Class uml2Class_proxy = (Class) argument;
    if(FileStereotypeHelper.isClass_file(uml2Class_proxy)||FileStereotypeHelper.isClass_Image(uml2Class_proxy)){//应用了File or Image
    Class uml2Class = (Class) argument;Package uml2Package = uml2Class.getPackage();
    stringBuffer.append(TEXT_1);
    
List<Property> tabsList=ViewInputHelper.getTabsProperty(uml2Class);
UmlClassWrap clazzWrap=new UmlClassWrap(uml2Class);

    List<Property> contentTabPropertyList=ViewInputHelper.getViewInputContentTab(uml2Class);
    if(!tabsList.isEmpty()||!contentTabPropertyList.isEmpty()){
    stringBuffer.append(TEXT_2);
    }
    stringBuffer.append(TEXT_3);
    
//Property idProperty=EntityHelper.getIDProperty(uml2Class);
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
    stringBuffer.append(clazzWrap.getUrl(WebUrlName.saveOutJson));
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
    stringBuffer.append(MdaHelper.getModelUrl(uml2Class,WebUrlName.updateOutJson));
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
    }else{//只应用了Entity
    Class uml2Class = (Class) argument;Package uml2Package = uml2Class.getPackage();
    
UmlClassWrap clazzWrap=new UmlClassWrap(uml2Class);
List<Property> contentPropertyList=ViewInputHelper.getViewInputContentOrContentTab(uml2Class);

    stringBuffer.append(TEXT_54);
    List<Property> tabsList=ViewInputHelper.getTabsProperty(uml2Class);
    List<Property> contentTabPropertyList=ViewInputHelper.getViewInputContentTab(uml2Class);
    if(!tabsList.isEmpty()||!contentTabPropertyList.isEmpty()){
    stringBuffer.append(TEXT_55);
    }
    stringBuffer.append(TEXT_56);
    
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
    stringBuffer.append(TEXT_72);
    stringBuffer.append(propertyTypeComment);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(MdaHelper.getModelUrl(propertyType,WebUrlName.listTreeOutJson));
    stringBuffer.append(TEXT_76);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_80);
    		}else{
    stringBuffer.append(TEXT_81);
    stringBuffer.append(propertyTypeComment);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(MdaHelper.getModelUrl(propertyType,WebUrlName.listForSelectOutJson));
    stringBuffer.append(TEXT_89);
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
    stringBuffer.append(TEXT_90);
    if(firstLine){firstLine=false;}else{
    stringBuffer.append(TEXT_91);
    }
    stringBuffer.append(TEXT_92);
    stringBuffer.append(relClassPropertyCommentName);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(relClassPropertyUncapSafeName);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(width);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(sortable);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(modelEnumName);
    stringBuffer.append(TEXT_97);
    		}else{
    stringBuffer.append(TEXT_98);
    if(firstLine){firstLine=false;}else{
    stringBuffer.append(TEXT_99);
    }
    stringBuffer.append(TEXT_100);
    stringBuffer.append(relClassPropertyCommentName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(relClassPropertyUncapSafeName);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(width);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(sortable);
    stringBuffer.append(TEXT_104);
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
    stringBuffer.append(TEXT_105);
    if(firstLine){firstLine=false;}else{
    stringBuffer.append(TEXT_106);
    }
    stringBuffer.append(TEXT_107);
    stringBuffer.append(relClassPropertyTypeCommentName);
    stringBuffer.append(relClassPropertyListLabelComment);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(relClassPropertyUncapSafeName);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(relClassPropertyListLabelUncapSafeName);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(width);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(sortable);
    stringBuffer.append(TEXT_112);
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
    stringBuffer.append(TEXT_113);
    if(firstLine){firstLine=false;}else{
    stringBuffer.append(TEXT_114);
    }
    stringBuffer.append(TEXT_115);
    stringBuffer.append(relClassPropertyTypeCommentName);
    stringBuffer.append(relClassPropertyListLabelComment);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(relClassPropertyUncapSafeName);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(relClassPropertyListLabelUncapSafeName);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(width);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(sortable);
    stringBuffer.append(TEXT_120);
    }
    stringBuffer.append(TEXT_121);
    stringBuffer.append(NameHelper.uncapSafeName(propertyTypeIdProperty));
    stringBuffer.append(TEXT_122);
    	}
    }
    		}
    stringBuffer.append(TEXT_123);
    stringBuffer.append(clazzWrap.getUrl(WebUrlName.saveOutJson));
    stringBuffer.append(TEXT_124);
    List<String> postDataList=new ArrayList<String>();
    stringBuffer.append(TEXT_125);
    if(!contentPropertyList.isEmpty()){
    	for(Iterator<Property> iter=contentPropertyList.iterator();iter.hasNext();){
    		Property property=iter.next();
     		String propertyUncapSafeName=NameHelper.uncapSafeName(property);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_128);
    		postDataList.add(propertyUncapSafeName+":"+propertyUncapSafeName);
    stringBuffer.append(TEXT_129);
    	}
    }
    stringBuffer.append(TEXT_130);
    if(!postDataList.isEmpty()){
    stringBuffer.append(TEXT_131);
    stringBuffer.append(GenHelper.constructPostDataJsObject(postDataList));
    stringBuffer.append(TEXT_132);
    }
    stringBuffer.append(TEXT_133);
    stringBuffer.append(idPropertyUncapSafeName);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(clazzWrap.getUrl(WebUrlName.updateOutJson));
    stringBuffer.append(TEXT_135);
    if(!contentPropertyList.isEmpty()){
    	for(Iterator<Property> iter=contentPropertyList.iterator();iter.hasNext();){
    		Property property=iter.next();
     		String propertyUncapSafeName=NameHelper.uncapSafeName(property);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_138);
    	}
    }
    stringBuffer.append(TEXT_139);
    if(!postDataList.isEmpty()){
    stringBuffer.append(TEXT_140);
    stringBuffer.append(GenHelper.constructPostDataJsObject(postDataList));
    stringBuffer.append(TEXT_141);
    }
    stringBuffer.append(TEXT_142);
    
/*****************************************************************
 * process image property
/*****************************************************************/

    if (FileStereotypeHelper.hasProperty_Image(uml2Class)) {// image
    	Property property=FileStereotypeHelper.getProperty_Image(uml2Class);
     	String propertyUncapSafeName=NameHelper.uncapSafeName(property);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(MdaHelper.getModelUrl(uml2Class,WebUrlName.deleteImageOutJson));
    stringBuffer.append(TEXT_154);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_162);
    }
    
/*****************************************************************
 * process file property
/*****************************************************************/

    if(FileStereotypeHelper.hasProperty_File(uml2Class)) {// file
    	Property property=FileStereotypeHelper.getProperty_File(uml2Class);
     	String propertyUncapSafeName=NameHelper.uncapSafeName(property);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(MdaHelper.getModelUrl(uml2Class,WebUrlName.deleteImageOutJson));
    stringBuffer.append(TEXT_166);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_167);
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
    stringBuffer.append(TEXT_168);
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
    stringBuffer.append(TEXT_169);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(relM2OAndO2OSelectPage);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(relM2OAndO2OSelectPage);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(relM2OAndO2OSelectPage);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(relM2OAndO2OSelectPage);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(relM2OAndO2OSelectPage);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(relM2OAndO2OSelectPage);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(relM2OAndO2OSelectPage);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(relM2OAndO2OSelectPage);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(relM2OAndO2OSelectPage);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(relM2OAndO2OSelectPage);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(MdaHelper.getModelUrl(propertyTypeClass,WebUrlName.listForSelect));
    stringBuffer.append(TEXT_182);
    stringBuffer.append(relM2OAndO2OSelectPage);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(relM2OAndO2OSelectPage);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(relM2OAndO2OSelectPage);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_193);
    	}
    }
    }
    return stringBuffer.toString();
  }
}
