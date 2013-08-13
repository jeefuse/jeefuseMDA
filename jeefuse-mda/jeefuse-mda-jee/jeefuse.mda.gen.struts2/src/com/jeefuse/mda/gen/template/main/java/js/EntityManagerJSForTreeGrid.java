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

public class EntityManagerJSForTreeGrid
{
  protected static String nl;
  public static synchronized EntityManagerJSForTreeGrid create(String lineSeparator)
  {
    nl = lineSeparator;
    EntityManagerJSForTreeGrid result = new EntityManagerJSForTreeGrid();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "$(function(){" + NL + "\tvar mainheight = document.documentElement.clientHeight;" + NL + "\tvar gridpm = 58; //GridHead，toolbar，footer,gridmargin" + NL + "\tvar h = mainheight - gridpm-$(\"#header\").outerHeight(true);" + NL + "\tvar w = $(\"#first-content\").width();" + NL + "    var option = {" + NL + "        height: h, " + NL + "        width: w," + NL + "        url: ctx+'";
  protected final String TEXT_2 = "'," + NL + "        colModel: [";
  protected final String TEXT_3 = NL + "\t\t   ";
  protected final String TEXT_4 = ",";
  protected final String TEXT_5 = "{ display: '";
  protected final String TEXT_6 = "',name: '";
  protected final String TEXT_7 = "',width: ";
  protected final String TEXT_8 = ", sortable: ";
  protected final String TEXT_9 = ", align: 'left',process:format";
  protected final String TEXT_10 = "}";
  protected final String TEXT_11 = NL + "\t\t   ";
  protected final String TEXT_12 = ",";
  protected final String TEXT_13 = "{ display: '";
  protected final String TEXT_14 = "',name: '";
  protected final String TEXT_15 = "',width: ";
  protected final String TEXT_16 = ", sortable: ";
  protected final String TEXT_17 = ", align: 'left'}";
  protected final String TEXT_18 = NL + "\t\t   ";
  protected final String TEXT_19 = ",";
  protected final String TEXT_20 = "{ display: '";
  protected final String TEXT_21 = "',name: '";
  protected final String TEXT_22 = ".";
  protected final String TEXT_23 = "',width: ";
  protected final String TEXT_24 = ", sortable: ";
  protected final String TEXT_25 = ", align: 'left'}";
  protected final String TEXT_26 = NL + "\t\t   ";
  protected final String TEXT_27 = ",";
  protected final String TEXT_28 = "{ display: '";
  protected final String TEXT_29 = "',name: '";
  protected final String TEXT_30 = ".";
  protected final String TEXT_31 = "',width: ";
  protected final String TEXT_32 = ", sortable: ";
  protected final String TEXT_33 = ", align: 'left'}";
  protected final String TEXT_34 = NL + "\t\t],      " + NL + "\t\tindexId:'";
  protected final String TEXT_35 = "'," + NL + "\t\tsortname: \"";
  protected final String TEXT_36 = "\"," + NL + "\t\tsortorder: \"";
  protected final String TEXT_37 = "\"," + NL + "\t\tsearchparam:searchparamsCall," + NL + "\t\tautoload: true," + NL + "\t\tshowcheckbox: true," + NL + "\t\tusepager: true," + NL + "\t\tshowseq:true," + NL + "        rowhandler: gridContextmenu," + NL + "\t\trowbinddata: false," + NL + "\t\tonRowDblclick:onRowDblclick," + NL + "\t\ttree:true," + NL + "\t\tuseRp:false," + NL + "\t\ttreeFieldName:'";
  protected final String TEXT_38 = "'," + NL + "\t\ticonspath:ctx+\"/resources/style/default/tree/images/\"" + NL + "    };" + NL + "    " + NL + "\t//format" + NL + "\t";
  protected final String TEXT_39 = NL + "\tfunction format";
  protected final String TEXT_40 = "(value, pid) {" + NL + "\t\treturn ";
  protected final String TEXT_41 = "[value];" + NL + "\t}";
  protected final String TEXT_42 = NL + NL + "    //search params" + NL + "    function searchparamsCall(){" + NL + "\t\tvar params=$(\"#firstSearchForm\").serializeArray();" + NL + "     \treturn params;" + NL + "\t}" + NL + "\t" + NL + "\t//grid" + NL + "    grid = $(\"#dataGrid\").flexigrid(option);" + NL + "    " + NL + "    //validate";
  protected final String TEXT_43 = "    ";
  protected final String TEXT_44 = NL + "\tsearchFormValidator=$(\"#firstSearchForm\").validate({" + NL + "\t\trules : {";
  protected final String TEXT_45 = NL + "\t\t\t\t";
  protected final String TEXT_46 = ",";
  protected final String TEXT_47 = ":{";
  protected final String TEXT_48 = "}//";
  protected final String TEXT_49 = " ";
  protected final String TEXT_50 = NL + "\t\t\t\t,";
  protected final String TEXT_51 = ":{";
  protected final String TEXT_52 = "}//";
  protected final String TEXT_53 = " ";
  protected final String TEXT_54 = NL + "\t\t\t\t";
  protected final String TEXT_55 = ",";
  protected final String TEXT_56 = "\"";
  protected final String TEXT_57 = ".";
  protected final String TEXT_58 = "\":{";
  protected final String TEXT_59 = "}//";
  protected final String TEXT_60 = " ";
  protected final String TEXT_61 = "\t\t\t\t\t\t";
  protected final String TEXT_62 = NL + "\t\t\t\t";
  protected final String TEXT_63 = ",";
  protected final String TEXT_64 = ":{";
  protected final String TEXT_65 = "}//";
  protected final String TEXT_66 = " ";
  protected final String TEXT_67 = "\t";
  protected final String TEXT_68 = NL + "    \t}," + NL + "    \terrorType: \"bftip\"" + NL + "\t});";
  protected final String TEXT_69 = "\t";
  protected final String TEXT_70 = "\t";
  protected final String TEXT_71 = NL + "\t//process ";
  protected final String TEXT_72 = " render" + NL + "\t$(\"#";
  protected final String TEXT_73 = ",#";
  protected final String TEXT_74 = "\").datepickerRange({startEl:'";
  protected final String TEXT_75 = "',endEl:'";
  protected final String TEXT_76 = "'});";
  protected final String TEXT_77 = "\t";
  protected final String TEXT_78 = "\t" + NL + "    //variate";
  protected final String TEXT_79 = NL + "    config.inputUrl=ctx+'";
  protected final String TEXT_80 = "';";
  protected final String TEXT_81 = "    " + NL + "    config.editUrl=ctx+'";
  protected final String TEXT_82 = "';";
  protected final String TEXT_83 = "    " + NL + "    config.deleteOutJsonUrl=ctx+'";
  protected final String TEXT_84 = "';";
  protected final String TEXT_85 = "   " + NL + "    config.deleteOutJsonAllUrl=ctx+'";
  protected final String TEXT_86 = "';" + NL + "    config.deleteDescendantOutJsonUrl=ctx+'";
  protected final String TEXT_87 = "';";
  protected final String TEXT_88 = NL + "});" + NL + "var grid;" + NL + "var searchFormValidator;" + NL + "var config={" + NL + "\tbaseTitle:\"";
  protected final String TEXT_89 = "管理\"," + NL + "\tinputUrl:null," + NL + "\teditUrl:null," + NL + "\tdeleteOutJsonUrl:null," + NL + "\tdeleteOutJsonAllUrl:null," + NL + "\tdeleteDescendantOutJsonUrl:null" + NL + "};" + NL + "/******grid contenxt menu process*****/" + NL + "function gridContextmenu(row) {" + NL + "\t$(row).contextmenu(menu);" + NL + "} " + NL + "/******context menu*****/" + NL + "var imgPath=ctx+\"/resources/style/default/contextmenu/images/\";" + NL + "var menu = {" + NL + "\t\twidth : 150" + NL + "\t\t,items : [" + NL + "\t\t\t\t{text : \"刷新\",icon : imgPath+\"table_refresh.png\",alias : \"refresh\",action : contextMenuClick" + NL + "\t\t\t\t,{type: \"splitLine\" }";
  protected final String TEXT_90 = NL + "\t\t\t\t,{text : \"新增\",icon :imgPath+\"view.png\",alias : \"add\",action :contextMenuClick}";
  protected final String TEXT_91 = NL + "\t\t\t\t,{text : \"编辑\",icon : imgPath+\"edit.png\",alias : \"edit\",action : contextMenuClick}";
  protected final String TEXT_92 = NL + "\t\t\t\t,{type: \"splitLine\" }" + NL + "\t\t\t\t,{text : \"删除该项记录\",icon : imgPath+\"rowdelete.png\",alias : \"deleteCurrent\",action : contextMenuClick}" + NL + "\t\t\t\t,{text : \"删除该项记录及子节点\",icon : imgPath+\"rowdelete.png\",alias : \"deleteCurrentAndDescendant\",action : contextMenuClick}" + NL + "\t\t\t\t,{text : \"删除所选记录\",icon : imgPath+\"rowdelete.png\",alias : \"deleteSels\",action : contextMenuClick}" + NL + "\t\t\t\t,{text : \"删除所选记录及子节点\",icon : imgPath+\"rowdelete.png\",alias : \"deleteDescendant\",action : contextMenuClick}";
  protected final String TEXT_93 = NL + "\t\t\t\t}]" + NL + "};" + NL + "function contextMenuClick(target,cmd) {" + NL + "\tvar domId=$(target).attr(\"id\");" + NL + "\tvar id = domId.substr(3);" + NL + "\tvar rowIdx = $(target).attr(\"seq\");" + NL + "\tswitch(cmd){";
  protected final String TEXT_94 = "\t" + NL + "\t\tcase 'add':" + NL + "\t\t\tvar title=config.baseTitle+'->新增';" + NL + "\t\t\tnewWinOpen();" + NL + "\t\t\tbreak;";
  protected final String TEXT_95 = NL + "\t\tcase 'edit':" + NL + "\t\t\tvar title = config.baseTitle+'->编辑 (序号:' + rowIdx + ')';" + NL + "\t\t\tvar url=goolov.addUrlParams(config.editUrl,\"id=\"+id);" + NL + "\t\t\teditWinOpen( {title:title,url:url});" + NL + "\t\t\tbreak;";
  protected final String TEXT_96 = NL + "\t\tcase 'deleteCurrent':" + NL + "\t\t\tdeleteOrphanOutJson(new Array(id));" + NL + "\t\t\tbreak;" + NL + "\t\tcase 'deleteCurrentAndDescendant':" + NL + "\t\t\tdeleteDescendantOutJson(new Array(id));" + NL + "\t\t\tbreak;" + NL + "\t\tcase 'deleteSels':" + NL + "\t\t\tvar ids=grid.getCheckedRows();" + NL + "\t\t\tdeleteOrphanOutJson(ids);" + NL + "\t\t\tbreak;" + NL + "\t\tcase 'deleteDecendant':" + NL + "\t\t\tvar ids=grid.getCheckedRows();" + NL + "\t\t\tdeleteDescendantOutJson(ids);" + NL + "\t\t\tbreak;";
  protected final String TEXT_97 = NL + "\t\tdefault:" + NL + "\t\t\tgrid.flexReload();" + NL + "\t}" + NL + "};" + NL + "/******refresh grid data*******/" + NL + "function reloadGrid(){" + NL + "\tsearchFormValidator.form();" + NL + "\tif(!searchFormValidator.valid()){" + NL + " \t\tvar invalideNum=searchFormValidator.numberOfInvalids();" + NL + "\t    if(invalideNum>0){" + NL + "\t    \tgoolov.growl.success('有<font color=red> '+invalideNum+'</font> 个查询选项未填写正确!');" + NL + "\t\t    return false;" + NL + "\t    }" + NL + "\t}" + NL + "\tgrid.flexReload();" + NL + "}" + NL + "" + NL + "/******refresh  *******/" + NL + "function refresh(){" + NL + "\treloadGrid();" + NL + "\tloadCategoryTree();" + NL + "}" + NL + "/******reset clear  *******/" + NL + "function clear(){" + NL + "\tdocument.getElementById('firstSearchForm').reset();" + NL + "\tgrid.flexReload({newp:1});" + NL + "}" + NL + "/******search*******/" + NL + "function firstSearch(){" + NL + "\treloadGrid();" + NL + "}";
  protected final String TEXT_98 = NL + "/******add data**********/" + NL + "var newWin;" + NL + "function newWinInit(){" + NL + "\tif(!newWin){" + NL + "\t\tvar title=config.baseTitle+'->新增';" + NL + "\t\tvar url=config.inputUrl;" + NL + "\t\tnewWin=new goolov.winbox({" + NL + "\t\t\twidth:goolov.winWidth(";
  protected final String TEXT_99 = ")," + NL + "\t\t\theight:goolov.winHeight(";
  protected final String TEXT_100 = ")," + NL + "\t\t\ttitle:title," + NL + "\t\t\turl:url" + NL + "\t\t});" + NL + "\t}" + NL + "}" + NL + "function newWinOpen(settings){" + NL + "\tnewWinInit();" + NL + "\tnewWin.open(settings);" + NL + "}" + NL + "function newWinClose(){" + NL + "\tnewWin.close();" + NL + "}" + NL + "function newData(){" + NL + "\tnewWinOpen();" + NL + "}";
  protected final String TEXT_101 = NL + "/******edit data window**********/" + NL + "var editWin;" + NL + "function editWinInit(){" + NL + "\tif(!editWin){" + NL + "\t\teditWin=new goolov.winbox({" + NL + "\t\t\twidth:goolov.winWidth(";
  protected final String TEXT_102 = ")," + NL + "\t\t\theight:goolov.winHeight(";
  protected final String TEXT_103 = ")" + NL + "\t\t});" + NL + "\t}" + NL + "}" + NL + "function editWinOpen(settings){" + NL + "\teditWinInit();" + NL + "\teditWin.open(settings);" + NL + "}" + NL + "function editWinClose(){" + NL + "\teditWin.close();" + NL + "}" + NL + "function onRowDblclick(target){" + NL + "\tvar id = $(target).attr(\"id\").substr(3);" + NL + "\tvar rowIdx=$(target).attr(\"seq\");" + NL + "\tvar title=config.baseTitle+'->编辑 (序号:'+rowIdx+')';" + NL + "\tvar url=goolov.addUrlParams(config.editUrl,\"id=\"+id);" + NL + "\teditWinOpen({title:title,url:url});" + NL + "}" + NL + "function editData(){" + NL + "\tvar ids=grid.getCheckedRows();" + NL + "\tvar selCount=ids.length;" + NL + "\tif (selCount== 0) {" + NL + "\t\tgoolov.growl.info('请先选择需要修改的记录,或双击需要编辑的行.');" + NL + "\t\treturn;" + NL + "\t}" + NL + "\tif(selCount>1){" + NL + "\t\tgoolov.growl.info('一次只能选择修改一项记录.');" + NL + "\t\treturn;" + NL + "\t}" + NL + "\tvar id=ids[0];" + NL + "\tvar rowtr=grid.getRowDom(id);//获取该ID的行元素." + NL + "\tvar rowIdx=$(rowtr).attr(\"seq\");" + NL + "\tvar title=config.baseTitle+'->编辑 (序号:'+rowIdx+')';" + NL + "\tvar url=goolov.addUrlParams(config.editUrl,\"id=\"+ids[0]);" + NL + "\tvar opts={title:title,url:url};" + NL + "\teditWinOpen(opts);" + NL + "}";
  protected final String TEXT_104 = NL + "/**********add row data**************/" + NL + "function addRowData(row){" + NL + "\tvar indexId=grid.getIndexId();" + NL + "\tvar rowTr=grid.getRowDom(row[indexId]);////获取该ID的行元素.;" + NL + "\tif (rowtr.length==0) {" + NL + "\t\tgrid.flexAddRowData(row);" + NL + "\t}else{" + NL + "\t\tgrid.flexEditRowData(rowtr[0],row);" + NL + "\t\t//for update Descendant need refresh grid" + NL + "\t\t//refresh();" + NL + "\t}" + NL + "\tloadCategoryTree();" + NL + "}";
  protected final String TEXT_105 = " " + NL + "/******del data**********/" + NL + "function delData(){" + NL + "\tvar ids=grid.getCheckedRows();" + NL + "\tdeleteOutJson(ids);" + NL + "}" + NL + "/******del data process**********/" + NL + "function deleteOutJson(idsArray){" + NL + "\tif (!idsArray||idsArray.length==0) {" + NL + "\t\tgoolov.growl.info('请选择需要删除的记录.');" + NL + "\t\treturn;" + NL + "\t}" + NL + "\tvar selCount=idsArray.length;" + NL + "\tvar idsStr=idsArray.join(',');" + NL + "\tgoolov.msgbox.confirm('删除确认','您确认删除这<span class=\"highlight\">'+selCount+'</span>项记录吗?删除后将不可恢复!',function(r){" + NL + "\t\t\tif(r){" + NL + "\t\t\t\t$.ajax({" + NL + "\t\t\t\t\ttype : 'post'," + NL + "\t\t\t\t\turl : config.deleteOutJsonUrl," + NL + "\t\t\t\t\tdata : {id:idsStr}," + NL + "\t\t\t\t\tdataType:'json'," + NL + "\t\t\t\t\tbeforeSend :function() {" + NL + "\t\t\t\t\t\tgoolov.growl.waiting('正在删除中!请稍后...');" + NL + "\t\t\t\t\t}," + NL + "\t\t\t\t\tsuccess : function(result) {" + NL + "\t\t\t\t\t\tgoolov.growl.unwaiting();" + NL + "\t\t\t\t\t\tif (result&&result.success) {" + NL + "\t\t\t\t\t\t\tgoolov.growl.success(result.message);" + NL + "\t\t\t\t\t\t\trefresh();" + NL + "\t\t\t\t\t\t}else if(result&&result.message){" + NL + "\t\t\t\t\t\t\tgoolov.msgbox.error(result.message);" + NL + "\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\tgoolov.msgbox.error();" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}," + NL + "\t\t\t\t\terror:function(request,status,errorThrown) {" + NL + "\t\t\t\t\t\tgoolov.growl.unwaiting();" + NL + "\t\t\t\t\t\tgoolov.msgbox.error();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t});" + NL + "\t\t\t}" + NL + "\t});" + NL + "}" + NL + "/*******del deleteDescendant***/" + NL + "function delDescendantData(){" + NL + "\tvar ids=grid.getCheckedRows();" + NL + "\tdeleteDescendantOutJson(ids);" + NL + "}" + NL + "/*******del deleteDescendant process***/" + NL + "function deleteDescendantOutJson(idsArray){" + NL + "\tif (!idsArray||idsArray.length==0) {" + NL + "\t\tgoolov.msgbox.alert('请选择需要删除的记录.');" + NL + "\t\treturn;" + NL + "\t}" + NL + "\tvar selCount=idsArray.length;" + NL + "\tvar idsStr=idsArray.join(',');" + NL + "\tgoolov.msgbox.confirm('删除确认','您确认删除这<span class=\"highlight\">'+selCount+'</span>项记录吗?删除后将不可恢复!',function(r){" + NL + "\t\tif(r){" + NL + "\t\t\t$.ajax({" + NL + "\t\t\t\ttype : 'post'," + NL + "\t\t\t\turl : config.deleteDescendantOutJsonUrl," + NL + "\t\t\t\tdata : {id:idsStr}," + NL + "\t\t\t\tdataType:'json'," + NL + "\t\t\t\tbeforeSend :function() {" + NL + "\t\t\t\t\tgoolov.growl.waiting('正在删除中!请稍后...');" + NL + "\t\t\t\t}," + NL + "\t\t\t\tsuccess : function(result) {" + NL + "\t\t\t\t\tgoolov.growl.unwaiting();" + NL + "\t\t\t\t\tif (result&&result.success) {" + NL + "\t\t\t\t\t\tgoolov.growl.success(result.message);" + NL + "\t\t\t\t\t\trefresh();" + NL + "\t\t\t\t\t}else if(result&&result.message){" + NL + "\t\t\t\t\t\tgoolov.msgbox.error(result.message);" + NL + "\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\tgoolov.msgbox.error();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}," + NL + "\t\t\t\terror:function(request,status,errorThrown) {" + NL + "\t\t\t\t\tgoolov.growl.unwaiting();" + NL + "\t\t\t\t\tgoolov.msgbox.error();" + NL + "\t\t\t\t}" + NL + "\t\t\t});" + NL + "\t\t}" + NL + "\t});" + NL + "}";
  protected final String TEXT_106 = NL + "/******del all data   *******/" + NL + "function delAllData(){" + NL + "\t\tgoolov.msgbox.confirm('删除确认','您确认这删除所有记录吗?删除后将不可恢复!',function(r){" + NL + "\t\tif(r){" + NL + "\t\t\t$.ajax({" + NL + "\t\t\t\t\ttype : 'get'," + NL + "\t\t\t\t\turl : config.deleteOutJsonAllUrl," + NL + "\t\t\t\t\tdataType:'json'," + NL + "\t\t\t\t\tbeforeSend :function() {" + NL + "\t\t\t\t\t\tgoolov.growl.waiting('正在删除中!请稍后...');" + NL + "\t\t\t\t\t}," + NL + "\t\t\t\t\tsuccess : function(result) {" + NL + "\t\t\t\t\t\tgoolov.growl.unwaiting();" + NL + "\t\t\t\t\t\tif (result&&result.success) {" + NL + "\t\t\t\t\t\t\tgoolov.growl.success(result.message);" + NL + "\t\t\t\t\t\t\trefresh();" + NL + "\t\t\t\t\t\t}else if(result&&result.message){" + NL + "\t\t\t\t\t\t\tgoolov.msgbox.error(result.message);" + NL + "\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\tgoolov.msgbox.error();" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}," + NL + "\t\t\t\t\terror:function(request,status,errorThrown) {" + NL + "\t\t\t\t\t\tgoolov.growl.unwaiting();" + NL + "\t\t\t\t\t\tgoolov.msgbox.error();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t});" + NL + "\t\t}" + NL + "\t});" + NL + "}";
  protected final String TEXT_107 = NL + "/******export excel*******/" + NL + "function exportExcel(){" + NL + "\tvar paramSerialize=grid.getParamsString();" + NL + "\tvar exportExcelFileUrl=ctx+'";
  protected final String TEXT_108 = "';" + NL + "\tlocation.href=goolov.addUrlParams(exportExcelFileUrl,paramSerialize);" + NL + "}";
  protected final String TEXT_109 = NL + "/******import importExcel**********/" + NL + "var importExcelFormValidator;" + NL + "var importExcelWin;" + NL + "$(document).ready(function() {" + NL + "\timportExcelWin=$('#importExcelWin').window({" + NL + "\t\ttitle: config.baseTitle+'->导入Excel文件数据'," + NL + "\t\twidth: 450," + NL + "\t\theight: 300," + NL + "\t\tmodal: true," + NL + "\t\tshadow: true," + NL + "\t\tclosed: true," + NL + "\t\tcollapsible:false," + NL + "\t\tminimizable:false," + NL + "\t\tmaximizable:false" + NL + "\t});" + NL + "\t//表单验证" + NL + "\timportExcelFormValidator=$(\"#importExcelForm\").validate({" + NL + "\t\trules : {" + NL + "\t\t}" + NL + "\t});\t" + NL + "});" + NL + "//打开导入Excel文件窗口" + NL + "function importExcel(){" + NL + "\timportExcelWin.window('open');" + NL + "}" + NL + "//关闭导入Excel文件窗口" + NL + "function importExcelWinClose(){" + NL + "\timportExcelWin.window('close');" + NL + "\trefresh();" + NL + "}" + NL + "/**" + NL + " * 导入excel文件提交处理." + NL + " */" + NL + "function importExcelSubmit(){" + NL + "\t$(\"#importExcelForm\").ajaxSubmit({" + NL + "\t\t type : 'post'," + NL + "\t\t dataType:'html', " + NL + "\t\t url:ctx+'";
  protected final String TEXT_110 = "'," + NL + "\t\t beforeSubmit:function(formData, jqForm, options) {" + NL + "\t\t\t    if(importExcelFormValidator.numberOfInvalids()>0){" + NL + "\t\t\t\t    return false;" + NL + "\t\t\t    }" + NL + "\t\t\t    goolov.growl.waiting('导入数据中...');" + NL + "\t\t }," + NL + "\t     success:function(result, statusText, xhr, $form) {" + NL + "\t    \t \tgoolov.growl.unwaiting();" + NL + "\t\t\t\tgoolov.msgbox.info('友情提示',result?result:\"请求出现错误,请查看网络是否连接!\");" + NL + "\t\t }," + NL + "\t\t error:function(request,status,errorThrown) {" + NL + "\t\t\t goolov.growl.unwaiting();" + NL + "\t\t\t goolov.msgbox.error();" + NL + "\t\t}" + NL + "\t}); " + NL + "}";
  protected final String TEXT_111 = NL + "/*******rel GsysCodevalue manager**********/" + NL + "var ";
  protected final String TEXT_112 = "Win;" + NL + "function ";
  protected final String TEXT_113 = "WinInit(){" + NL + "\tif(!";
  protected final String TEXT_114 = "Win){" + NL + "\t\t";
  protected final String TEXT_115 = "Win=new goolov.winbox({" + NL + "\t\t\twidth:goolov.winWidth(750)," + NL + "\t\t\theight:goolov.winHeight(450)," + NL + "\t\t\tmodal:true" + NL + "\t\t});" + NL + "\t}" + NL + "}" + NL + "function ";
  protected final String TEXT_116 = "WinOpen(settings){" + NL + "\t";
  protected final String TEXT_117 = "WinInit();" + NL + "\t";
  protected final String TEXT_118 = "Win.open(settings);" + NL + "}" + NL + "function ";
  protected final String TEXT_119 = "WinClose(){" + NL + "\t";
  protected final String TEXT_120 = "Win.close();" + NL + "}" + NL + "function ";
  protected final String TEXT_121 = "(id,name){" + NL + "\tvar title=config.baseTitle+'('+name+')->";
  protected final String TEXT_122 = "管理';" + NL + "\tvar url=ctx+'";
  protected final String TEXT_123 = "?";
  protected final String TEXT_124 = ".";
  protected final String TEXT_125 = "='+id;" + NL + "\t";
  protected final String TEXT_126 = "WinOpen({title:title,url:url});" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    Class uml2Class = (Class) argument;Package uml2Package = uml2Class.getPackage();
    
UmlClassWrap clazzWrap=new UmlClassWrap(uml2Class);
String modelUncapName=NameHelper.getUncapName(uml2Class);
String modelCommentName=TypeHelper.getDocumentationOrName(uml2Class);

    stringBuffer.append(TEXT_1);
    stringBuffer.append(clazzWrap.getUrl(WebUrlName.listOutJson));
    stringBuffer.append(TEXT_2);
    
Property idProperty=EntityHelper.getIDProperty(uml2Class);
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
    stringBuffer.append(TEXT_3);
    if(firstLine){firstLine=false;}else{
    stringBuffer.append(TEXT_4);
    }
    stringBuffer.append(TEXT_5);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(width);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(sortable);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(modelEnumName);
    stringBuffer.append(TEXT_10);
    		}else{
    stringBuffer.append(TEXT_11);
    if(firstLine){firstLine=false;}else{
    stringBuffer.append(TEXT_12);
    }
    stringBuffer.append(TEXT_13);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(width);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(sortable);
    stringBuffer.append(TEXT_17);
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
    stringBuffer.append(TEXT_18);
    if(firstLine){firstLine=false;}else{
    stringBuffer.append(TEXT_19);
    }
    stringBuffer.append(TEXT_20);
    stringBuffer.append(propertyTypeCommentName);
    stringBuffer.append(listLabelPropertyComment);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(width);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(sortable);
    stringBuffer.append(TEXT_25);
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
    stringBuffer.append(TEXT_26);
    if(firstLine){firstLine=false;}else{
    stringBuffer.append(TEXT_27);
    }
    stringBuffer.append(TEXT_28);
    stringBuffer.append(propertyTypeCommentName);
    stringBuffer.append(listLabelPropertyComment);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(width);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(sortable);
    stringBuffer.append(TEXT_33);
    }
    stringBuffer.append(TEXT_34);
    stringBuffer.append(NameHelper.uncapSafeName(idProperty));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(OrderByHelper.getOrderField(uml2Class));
    stringBuffer.append(TEXT_36);
    stringBuffer.append(OrderByHelper.getOrderMode(uml2Class));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(TreeStereotypeHelper.getProperty_layerCode(uml2Class));
    stringBuffer.append(TEXT_38);
    //code kind define
    List<Property> codeKindPropertiesList=EnumKindHelper.getPropertiesAppliedEnumKind(uml2Class);
    if(null!=codeKindPropertiesList&&codeKindPropertiesList.size()>0){
    	for(Property property:codeKindPropertiesList){
    		Enumeration enumeration=EnumKindHelper.getAppliedEnumKindEnumeration(property);
    		if(null!=enumeration){
    //			String modelEnumQualifiedName=MdaHelper.getModelQualifiedName(enumeration,PKGSuffix.enumeration,ModelNameSuffix.enumeration);
    			String modelEnumName=MdaHelper.getModelClassName(enumeration,ModelNameSuffix.enumeration);
    			String modelEnumJsoncapName=NamedUtil.getPropertyNamed(enumeration,PropertyNamedRuleKind.elementJsonNamed);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(modelEnumName);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(modelEnumJsoncapName);
    stringBuffer.append(TEXT_41);
    		}
    	}
    }
    stringBuffer.append(TEXT_42);
    List<Property> validatePropertyList=new ArrayList<Property>();
    stringBuffer.append(TEXT_43);
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
    stringBuffer.append(TEXT_44);
    	int count=0;
    	for (int i=0;i<validatePropertyList.size();i++){
    		Property property=validatePropertyList.get(i);
    		String jqueryValidate=PageHelper.getJqueryValidateForSearch(property);
    		if(null!=jqueryValidate){
     			String propertyCommentName=TypeHelper.getDocumentationOrName(property);
      		if(ViewInputHelper.isViewInputDatePicker(property)){//process datePicker
     			//String propertyUncapSafeName=NameHelper.uncapSafeName(property);
    			String dateSearchStartName=NamedUtil.getPropertyNamed(property,PropertyNamedRuleKind.dateSearchStartName);
     			String dateSearchStartUncapSafeName=NameHelper.uncapName(dateSearchStartName);
    			String dateSearchEndName=NamedUtil.getPropertyNamed(property,PropertyNamedRuleKind.dateSearchEndName);
     			String dateSearchEndNameUncapSafeName=NameHelper.uncapName(dateSearchEndName);
    stringBuffer.append(TEXT_45);
    if(i!=0){
    stringBuffer.append(TEXT_46);
    }
    stringBuffer.append(dateSearchStartUncapSafeName);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(jqueryValidate);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(++count);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(dateSearchEndNameUncapSafeName);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(jqueryValidate);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(++count);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(propertyCommentName);
    		}
    		else if(!ClassHelper.isSimple(property)&&null!=jqueryValidate&&!jqueryValidate.trim().equals("")){
     				//String propertySelectListKey=ViewInputHelper.getRelForListKey(property);
    				Class propertyType = (Class) property.getType();
    				//String propertyTypeComment = TypeHelper.getDocumentationOrName(propertyType);
     				Property propertyTypeIdProperty=EntityHelper.getIDProperty(propertyType);
     				String propertyTypeIdPropertyUncapSafeName=NameHelper.uncapSafeName(propertyTypeIdProperty);
    stringBuffer.append(TEXT_54);
    if(i!=0){
    stringBuffer.append(TEXT_55);
    }
    stringBuffer.append(TEXT_56);
    stringBuffer.append(NameHelper.getUncapName(property));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(jqueryValidate);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(++count);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_61);
    			}else{
    stringBuffer.append(TEXT_62);
    if(i!=0){
    stringBuffer.append(TEXT_63);
    }
    stringBuffer.append(NameHelper.getUncapName(property));
    stringBuffer.append(TEXT_64);
    stringBuffer.append(jqueryValidate);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(++count);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(propertyCommentName);
    			}
    		}
    stringBuffer.append(TEXT_67);
    	}
    stringBuffer.append(TEXT_68);
    }
    stringBuffer.append(TEXT_69);
    for (int i=0;i<searchPropertyList.size();i++){
    stringBuffer.append(TEXT_70);
    	Property property=searchPropertyList.get(i);
      if(ViewInputHelper.isViewInputDatePicker(property)){//process datePicker
     		String propertyUncapSafeName=NameHelper.uncapSafeName(property);
    		String dateSearchStartName=NamedUtil.getPropertyNamed(property,PropertyNamedRuleKind.dateSearchStartName);
     		String dateSearchStartUncapSafeName=NameHelper.uncapName(dateSearchStartName);
    		String dateSearchEndName=NamedUtil.getPropertyNamed(property,PropertyNamedRuleKind.dateSearchEndName);
     		String dateSearchEndNameUncapSafeName=NameHelper.uncapName(dateSearchEndName);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(dateSearchStartUncapSafeName);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(dateSearchEndNameUncapSafeName);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(dateSearchStartUncapSafeName);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(dateSearchEndNameUncapSafeName);
    stringBuffer.append(TEXT_76);
    	}
    stringBuffer.append(TEXT_77);
    }
    stringBuffer.append(TEXT_78);
    if(FunctionStereotypeUtil.isApplied_input(uml2Class)){
    stringBuffer.append(TEXT_79);
    stringBuffer.append(clazzWrap.getUrl(WebUrlName.systempage_input));
    stringBuffer.append(TEXT_80);
    }
    if(FunctionStereotypeUtil.isApplied_edit(uml2Class)){
    stringBuffer.append(TEXT_81);
    stringBuffer.append(clazzWrap.getUrl(WebUrlName.systempage_edit));
    stringBuffer.append(TEXT_82);
    }
    if(FunctionStereotypeUtil.isApplied_deleteOutJson(uml2Class)){
    stringBuffer.append(TEXT_83);
    stringBuffer.append(clazzWrap.getUrl(WebUrlName.deleteOutJson));
    stringBuffer.append(TEXT_84);
    }
    if(FunctionStereotypeUtil.isApplied_deleteAllOutJson(uml2Class)){
    stringBuffer.append(TEXT_85);
    stringBuffer.append(clazzWrap.getUrl(WebUrlName.deleteAllOutJson));
    stringBuffer.append(TEXT_86);
    stringBuffer.append(clazzWrap.getUrl(WebUrlName.deleteDescendantOutJson));
    stringBuffer.append(TEXT_87);
    }
    stringBuffer.append(TEXT_88);
    stringBuffer.append(modelCommentName);
    stringBuffer.append(TEXT_89);
    if(FunctionStereotypeUtil.isApplied_input(uml2Class)){
    stringBuffer.append(TEXT_90);
    }
    if(FunctionStereotypeUtil.isApplied_edit(uml2Class)){
    stringBuffer.append(TEXT_91);
    }
    if(FunctionStereotypeUtil.isApplied_deleteOutJson(uml2Class)){
    stringBuffer.append(TEXT_92);
    }
    stringBuffer.append(TEXT_93);
    if(FunctionStereotypeUtil.isApplied_input(uml2Class)){
    stringBuffer.append(TEXT_94);
    }
    if(FunctionStereotypeUtil.isApplied_edit(uml2Class)){
    stringBuffer.append(TEXT_95);
    }
    if(FunctionStereotypeUtil.isApplied_deleteOutJson(uml2Class)){
    stringBuffer.append(TEXT_96);
    }
    stringBuffer.append(TEXT_97);
    if(FunctionStereotypeUtil.isApplied_input(uml2Class)){
    stringBuffer.append(TEXT_98);
    stringBuffer.append(PageHelper.getWinWidth(uml2Class));
    stringBuffer.append(TEXT_99);
    stringBuffer.append(PageHelper.getWinHeight(uml2Class));
    stringBuffer.append(TEXT_100);
    }
    if(FunctionStereotypeUtil.isApplied_edit(uml2Class)){
    stringBuffer.append(TEXT_101);
    stringBuffer.append(PageHelper.getWinWidth(uml2Class));
    stringBuffer.append(TEXT_102);
    stringBuffer.append(PageHelper.getWinHeight(uml2Class));
    stringBuffer.append(TEXT_103);
    }
    stringBuffer.append(TEXT_104);
    if(FunctionStereotypeUtil.isApplied_deleteOutJson(uml2Class)){
    stringBuffer.append(TEXT_105);
    }
    	if(FunctionStereotypeUtil.isApplied_deleteAllOutJson(uml2Class)){
    stringBuffer.append(TEXT_106);
    }
    	if(ServiceStereotypeUtil.isApplied_expExcel(uml2Class)){
    stringBuffer.append(TEXT_107);
    stringBuffer.append(MdaHelper.getModelUrl(uml2Class,WebUrlName.exportExcelFile));
    stringBuffer.append(TEXT_108);
    	}
    if(ServiceStereotypeUtil.isApplied_impExcel(uml2Class)){//applied importExcelFile
    stringBuffer.append(TEXT_109);
    stringBuffer.append(clazzWrap.getUrl(WebUrlName.importExcelFileProcess));
    stringBuffer.append(TEXT_110);
    }//applied importExcelFile end
    
/*****************************************************************
 * rel O2MManagerPage
/*****************************************************************/


    List<Property> O2MManagerPageList=ViewInputHelper.getApplyO2MManagerPage(uml2Class);
    if(null!=O2MManagerPageList&&!O2MManagerPageList.isEmpty()){
    	for(Iterator<Property> iter=O2MManagerPageList.iterator();iter.hasNext();){
    		Property property=iter.next();
    		Type propertyType=property.getType();
    		Class relTargetClass=(Class)propertyType;
    		//String relTargetClassCapName=NameHelper.getCapName(relTargetClass);
    		//String relTargetClassUncapName=NameHelper.getUncapName(relTargetClass);
    		String relTargetClassCommentName=TypeHelper.getDocumentationOrName(relTargetClass);
    		String relO2MManager=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relO2MManager);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(relO2MManager);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(relO2MManager);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(relO2MManager);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(relO2MManager);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(relO2MManager);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(relO2MManager);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(relO2MManager);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(relO2MManager);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(relO2MManager);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(relO2MManager);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(MdaHelper.getModelUrlByRel(uml2Class,relTargetClass,WebUrlName.relO2MManage));
    stringBuffer.append(TEXT_123);
    stringBuffer.append(modelUncapName);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(NameHelper.getUncapName(idProperty));
    stringBuffer.append(TEXT_125);
    stringBuffer.append(relO2MManager);
    stringBuffer.append(TEXT_126);
    	}
    }
    return stringBuffer.toString();
  }
}
