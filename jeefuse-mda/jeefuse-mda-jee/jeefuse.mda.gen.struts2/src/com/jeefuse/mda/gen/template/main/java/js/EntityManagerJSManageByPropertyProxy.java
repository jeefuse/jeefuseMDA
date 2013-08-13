package com.jeefuse.mda.gen.template.main.java.js;

import net.taylor.mda.generator.parse.NameRuled.nameRuled.*;
import net.taylor.mda.generator.parse.NameRuled.className.*;
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

public class EntityManagerJSManageByPropertyProxy
{
  protected static String nl;
  public static synchronized EntityManagerJSManageByPropertyProxy create(String lineSeparator)
  {
    nl = lineSeparator;
    EntityManagerJSManageByPropertyProxy result = new EntityManagerJSManageByPropertyProxy();
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
  protected final String TEXT_71 = NL + NL + "\t//process ";
  protected final String TEXT_72 = " render" + NL + "\t$(\"#";
  protected final String TEXT_73 = ",#";
  protected final String TEXT_74 = "\").datepickerRange({startEl:'";
  protected final String TEXT_75 = "',endEl:'";
  protected final String TEXT_76 = "'});";
  protected final String TEXT_77 = "\t";
  protected final String TEXT_78 = "\t" + NL + "    //variate";
  protected final String TEXT_79 = NL + "    //variate" + NL + "    var ";
  protected final String TEXT_80 = "=$('#";
  protected final String TEXT_81 = "').val();" + NL + "    config.inputUrl=ctx+'";
  protected final String TEXT_82 = "?";
  protected final String TEXT_83 = "='+";
  protected final String TEXT_84 = ";" + NL + "    config.editUrl=ctx+'";
  protected final String TEXT_85 = "?";
  protected final String TEXT_86 = "='+";
  protected final String TEXT_87 = ";" + NL + "    config.deleteOutJsonUrl=ctx+'";
  protected final String TEXT_88 = "?";
  protected final String TEXT_89 = "='+";
  protected final String TEXT_90 = ";" + NL + "    config.deleteOutJsonAllUrl=ctx+'";
  protected final String TEXT_91 = "?";
  protected final String TEXT_92 = "='+";
  protected final String TEXT_93 = ";" + NL + "    config.deleteDescendantOutJsonUrl=ctx+'";
  protected final String TEXT_94 = "?";
  protected final String TEXT_95 = "='+";
  protected final String TEXT_96 = ";" + NL + "});" + NL + "var grid;" + NL + "var searchFormValidator;" + NL + "var config={" + NL + "\tbaseTitle:\"";
  protected final String TEXT_97 = "管理\"," + NL + "\tinputUrl:null," + NL + "\teditUrl:null," + NL + "\tdeleteOutJsonUrl:null," + NL + "\tdeleteOutJsonAllUrl:null," + NL + "\tdeleteDescendantOutJsonUrl:null" + NL + "};" + NL + "/******grid contenxt menu process*****/" + NL + "/******context menu*****/" + NL + "var imgPath=ctx+\"/resources/style/default/contextmenu/images/\";" + NL + "var menu = {" + NL + "\t\twidth : 150" + NL + "\t\t,items : [" + NL + "\t\t\t\t{text : \"刷新\",icon : imgPath+\"table_refresh.png\",alias : \"refresh\",action : contextMenuClick}" + NL + "\t\t\t\t,{type: \"splitLine\" }" + NL + "\t\t\t\t,{text : \"新增\",icon :imgPath+\"view.png\",alias : \"add\",action :contextMenuClick}" + NL + "\t\t\t\t,{text : \"编辑\",icon : imgPath+\"edit.png\",alias : \"edit\",action : contextMenuClick}" + NL + "\t\t\t\t,{type: \"splitLine\" }" + NL + "\t\t\t\t,{text : \"删除该项记录\",icon : imgPath+\"rowdelete.png\",alias : \"deleteCurrent\",action : contextMenuClick}" + NL + "\t\t\t\t,{text : \"删除该项记录及子节点\",icon : imgPath+\"rowdelete.png\",alias : \"deleteCurrentAndDescendant\",action : contextMenuClick}" + NL + "\t\t\t\t,{text : \"删除所选记录\",icon : imgPath+\"rowdelete.png\",alias : \"deleteSels\",action : contextMenuClick}" + NL + "\t\t\t\t,{text : \"删除所选记录及子节点\",icon : imgPath+\"rowdelete.png\",alias : \"deleteDescendant\",action : contextMenuClick}" + NL + "\t\t\t\t,{text : \"删除所有记录\",icon : imgPath+\"rowdelete.png\",alias : \"deleteAll\",action : contextMenuClick}" + NL + "\t\t\t\t]" + NL + "\t\t" + NL + "};" + NL + "function contextMenuClick(target,cmd) {" + NL + "\tvar domId=$(target).attr(\"id\");" + NL + "\tvar id = domId.substr(3);" + NL + "\tvar rowIdx = $(target).attr(\"seq\");" + NL + "\tswitch(cmd){" + NL + "\t\tcase 'add':" + NL + "\t\t\tvar title=config.baseTitle+'->新增';" + NL + "\t\t\tnewWinOpen();" + NL + "\t\t\tbreak;" + NL + "\t\tcase 'edit':" + NL + "\t\t\tvar title = config.baseTitle+'->编辑 (序号:' + rowIdx + ')';" + NL + "\t\t\tvar url=goolov.addUrlParams(config.editUrl,\"id=\"+id);" + NL + "\t\t\teditWinOpen( {title:title,url:url});" + NL + "\t\t\tbreak;" + NL + "\t\tcase 'deleteCurrent':" + NL + "\t\t\tdeleteOrphanOutJson(new Array(id));" + NL + "\t\t\tbreak;" + NL + "\t\tcase 'deleteCurrentAndDescendant':" + NL + "\t\t\tdeleteDescendantOutJson(new Array(id));" + NL + "\t\t\tbreak;" + NL + "\t\tcase 'deleteSels':" + NL + "\t\t\tvar ids=grid.getCheckedRows();" + NL + "\t\t\tdeleteOrphanOutJson(ids);" + NL + "\t\t\tbreak;" + NL + "\t\tcase 'deleteDecendant':" + NL + "\t\t\tvar ids=grid.getCheckedRows();" + NL + "\t\t\tdeleteDescendantOutJson(ids);" + NL + "\t\t\tbreak;" + NL + "\t\tcase 'deleteAll':" + NL + "\t\t\tdelAllData();" + NL + "\t\t\tbreak;" + NL + "\t\tdefault:" + NL + "\t\t\tgrid.flexReload();" + NL + "\t}" + NL + "};" + NL + "function gridContextmenu(row) {" + NL + "\t$(row).contextmenu(menu);" + NL + "} " + NL + "/******refresh grid data*******/" + NL + "function reloadGrid(){" + NL + "\tsearchFormValidator.form();" + NL + "\tif(!searchFormValidator.valid()){" + NL + " \t\tvar invalideNum=searchFormValidator.numberOfInvalids();" + NL + "\t    if(invalideNum>0){" + NL + "\t    \tgoolov.growl.success('有<font color=red> '+invalideNum+'</font> 个查询选项未填写正确!');" + NL + "\t\t    return false;" + NL + "\t    }" + NL + "\t}" + NL + "\tgrid.flexReload();" + NL + "}" + NL + "" + NL + "/******refresh  *******/" + NL + "function refresh(){" + NL + "\treloadGrid();" + NL + "}" + NL + "/******reset clear  *******/" + NL + "function clear(){" + NL + "\tdocument.getElementById('firstSearchForm').reset();" + NL + "\tgrid.flexReload({newp:1});" + NL + "}" + NL + "/******search*******/" + NL + "function firstSearch(){" + NL + "\treloadGrid();" + NL + "}" + NL + "/******add data**********/" + NL + "var newWin;" + NL + "function newWinInit(){" + NL + "\tif(!newWin){" + NL + "\t\tvar title=config.baseTitle+'->新增';" + NL + "\t\tvar url=config.inputUrl;" + NL + "\t\tnewWin=new goolov.winbox({" + NL + "\t\t\twidth:goolov.winWidth(";
  protected final String TEXT_98 = ")," + NL + "\t\t\theight:goolov.winHeight(";
  protected final String TEXT_99 = ")," + NL + "\t\t\ttitle:title," + NL + "\t\t\turl:url" + NL + "\t\t});" + NL + "\t}" + NL + "}" + NL + "function newWinOpen(settings){" + NL + "\tnewWinInit();" + NL + "\tnewWin.open(settings);" + NL + "}" + NL + "function newWinClose(){" + NL + "\tnewWin.close();" + NL + "}" + NL + "function newWinCloseAndRefresh(){" + NL + "\tnewWinClose();" + NL + "\trefresh();" + NL + "}" + NL + "function newData(){" + NL + "\tnewWinOpen();" + NL + "}" + NL + "/******edit data window**********/" + NL + "var editWin;" + NL + "function editWinInit(){" + NL + "\tif(!editWin){" + NL + "\t\teditWin=new goolov.winbox({" + NL + "\t\t\twidth:goolov.winWidth(";
  protected final String TEXT_100 = ")," + NL + "\t\t\theight:goolov.winHeight(";
  protected final String TEXT_101 = ")" + NL + "\t\t});" + NL + "\t}" + NL + "}" + NL + "function editWinOpen(settings){" + NL + "\teditWinInit();" + NL + "\teditWin.open(settings);" + NL + "}" + NL + "function editWinClose(){" + NL + "\teditWin.close();" + NL + "}" + NL + "function editWinCloseAndRefresh(){" + NL + "\teditWinClose();" + NL + "\trefresh();" + NL + "}" + NL + "function onRowDblclick(target){" + NL + "\tvar id = $(target).attr(\"id\").substr(3);" + NL + "\tvar rowIdx=$(target).attr(\"seq\");" + NL + "\tvar title=config.baseTitle+'->编辑 (序号:'+rowIdx+')';" + NL + "\tvar url=goolov.addUrlParams(config.editUrl,\"id=\"+id);" + NL + "\teditWinOpen({title:title,url:url});" + NL + "}" + NL + "function editData(){" + NL + "\tvar ids=grid.getCheckedRows();" + NL + "\tvar selCount=ids.length;" + NL + "\tif (selCount== 0) {" + NL + "\t\tgoolov.growl.info('请先选择需要修改的记录,或双击需要编辑的行.');" + NL + "\t\treturn;" + NL + "\t}" + NL + "\tif(selCount>1){" + NL + "\t\tgoolov.growl.info('一次只能选择修改一项记录.');" + NL + "\t\treturn;" + NL + "\t}" + NL + "\tvar id=ids[0];" + NL + "\tvar rowtr=grid.getRowDom(id);//获取该ID的行元素." + NL + "\tvar rowIdx=$(rowtr).attr(\"seq\");" + NL + "\tvar title=config.baseTitle+'->编辑 (序号:'+rowIdx+')';" + NL + "\tvar url=goolov.addUrlParams(config.editUrl,\"id=\"+ids[0]);" + NL + "\tvar opts={title:title,url:url};" + NL + "\teditWinOpen(opts);" + NL + "}" + NL + "/**********add row data**************/" + NL + "function addRowData(row){" + NL + "\tvar indexId=grid.getIndexId();" + NL + "\tvar rowTr=grid.getRowDom(row[indexId]);////获取该ID的行元素.;" + NL + "\tif (rowtr.length==0) {" + NL + "\t\tgrid.flexAddRowData(row);" + NL + "\t}else{" + NL + "\t\tgrid.flexEditRowData(rowtr[0],row);" + NL + "\t\t//for update Descendant need refresh grid" + NL + "\t\t//refresh();" + NL + "\t}" + NL + "\tloadCategoryTree();" + NL + "}" + NL + "/******del data**********/" + NL + "function delData(){" + NL + "\tvar ids=grid.getCheckedRows();" + NL + "\tdeleteOutJson(ids);" + NL + "}" + NL + "/******del data process**********/" + NL + "function deleteOutJson(idsArray){" + NL + "\tif (!idsArray||idsArray.length==0) {" + NL + "\t\tgoolov.growl.info('请选择需要删除的记录.');" + NL + "\t\treturn;" + NL + "\t}" + NL + "\tvar selCount=idsArray.length;" + NL + "\tvar idsStr=idsArray.join(',');" + NL + "\tgoolov.msgbox.confirm('删除确认','您确认删除这<span class=\"highlight\">'+selCount+'</span>项记录吗?删除后将不可恢复!',function(r){" + NL + "\t\t\tif(r){" + NL + "\t\t\t\t$.ajax({" + NL + "\t\t\t\t\ttype : 'post'," + NL + "\t\t\t\t\turl : config.deleteOutJsonUrl," + NL + "\t\t\t\t\tdata : {id:idsStr}," + NL + "\t\t\t\t\tdataType:'json'," + NL + "\t\t\t\t\tbeforeSend :function() {" + NL + "\t\t\t\t\t\tgoolov.growl.waiting('正在删除中!请稍后...');" + NL + "\t\t\t\t\t}," + NL + "\t\t\t\t\tsuccess : function(result) {" + NL + "\t\t\t\t\t\tgoolov.growl.unwaiting();" + NL + "\t\t\t\t\t\tif (result&&result.success) {" + NL + "\t\t\t\t\t\t\tgoolov.growl.success(result.message);" + NL + "\t\t\t\t\t\t\trefresh();" + NL + "\t\t\t\t\t\t}else if(result&&result.message){" + NL + "\t\t\t\t\t\t\tgoolov.msgbox.error(result.message);" + NL + "\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\tgoolov.msgbox.error();" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}," + NL + "\t\t\t\t\terror:function(request,status,errorThrown) {" + NL + "\t\t\t\t\t\tgoolov.growl.unwaiting();" + NL + "\t\t\t\t\t\tgoolov.msgbox.error();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t});" + NL + "\t\t\t}" + NL + "\t});" + NL + "}" + NL + "/*******del deleteDescendant***/" + NL + "function delDescendantData(){" + NL + "\tvar ids=grid.getCheckedRows();" + NL + "\tdeleteDescendantOutJson(ids);" + NL + "}" + NL + "/*******del deleteDescendant process***/" + NL + "function deleteDescendantOutJson(idsArray){" + NL + "\tif (!idsArray||idsArray.length==0) {" + NL + "\t\tgoolov.msgbox.alert('请选择需要删除的记录.');" + NL + "\t\treturn;" + NL + "\t}" + NL + "\tvar selCount=idsArray.length;" + NL + "\tvar idsStr=idsArray.join(',');" + NL + "\tgoolov.msgbox.confirm('删除确认','您确认删除这<span class=\"highlight\">'+selCount+'</span>项记录吗?删除后将不可恢复!',function(r){" + NL + "\t\tif(r){" + NL + "\t\t\t$.ajax({" + NL + "\t\t\t\ttype : 'post'," + NL + "\t\t\t\turl : config.deleteDescendantOutJson," + NL + "\t\t\t\tdata : {id:idsStr}," + NL + "\t\t\t\tdataType:'json'," + NL + "\t\t\t\tbeforeSend :function() {" + NL + "\t\t\t\t\tgoolov.growl.waiting('正在删除中!请稍后...');" + NL + "\t\t\t\t}," + NL + "\t\t\t\tsuccess : function(result) {" + NL + "\t\t\t\t\tgoolov.growl.unwaiting();" + NL + "\t\t\t\t\tif (result&&result.success) {" + NL + "\t\t\t\t\t\tgoolov.growl.success(result.message);" + NL + "\t\t\t\t\t\trefresh();" + NL + "\t\t\t\t\t}else if(result&&result.message){" + NL + "\t\t\t\t\t\tgoolov.msgbox.error(result.message);" + NL + "\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\tgoolov.msgbox.error();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}," + NL + "\t\t\t\terror:function(request,status,errorThrown) {" + NL + "\t\t\t\t\tgoolov.growl.unwaiting();" + NL + "\t\t\t\t\tgoolov.msgbox.error();" + NL + "\t\t\t\t}" + NL + "\t\t\t});" + NL + "\t\t}" + NL + "\t});" + NL + "}" + NL + "/******del all data   *******/" + NL + "function delAllData(){" + NL + "\t\tgoolov.msgbox.confirm('删除确认','您确认这删除所有记录吗?删除后将不可恢复!',function(r){" + NL + "\t\tif(r){" + NL + "\t\t\t$.ajax({" + NL + "\t\t\t\t\ttype : 'get'," + NL + "\t\t\t\t\turl : deleteOutJsonAllUrl," + NL + "\t\t\t\t\tdataType:'json'," + NL + "\t\t\t\t\tbeforeSend :function() {" + NL + "\t\t\t\t\t\tgoolov.growl.waiting('正在删除中!请稍后...');" + NL + "\t\t\t\t\t}," + NL + "\t\t\t\t\tsuccess : function(result) {" + NL + "\t\t\t\t\t\tgoolov.growl.unwaiting();" + NL + "\t\t\t\t\t\tif (result&&result.success) {" + NL + "\t\t\t\t\t\t\tgoolov.growl.success(result.message);" + NL + "\t\t\t\t\t\t\trefresh();" + NL + "\t\t\t\t\t\t}else if(result&&result.message){" + NL + "\t\t\t\t\t\t\tgoolov.msgbox.error(result.message);" + NL + "\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\tgoolov.msgbox.error();" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}," + NL + "\t\t\t\t\terror:function(request,status,errorThrown) {" + NL + "\t\t\t\t\t\tgoolov.growl.unwaiting();" + NL + "\t\t\t\t\t\tgoolov.msgbox.error();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t});" + NL + "\t\t}" + NL + "\t});" + NL + "}" + NL + "/******export excel*******/" + NL + "function exportExcel(){" + NL + "\tvar paramSerialize=grid.getParamsString();" + NL + "\tvar exportExcelFileUrl=ctx+'";
  protected final String TEXT_102 = "';" + NL + "\tlocation.href=goolov.addUrlParams(exportExcelFileUrl,paramSerialize);" + NL + "}";
  protected final String TEXT_103 = NL + "/******import importExcel**********/" + NL + "var importExcelWin;" + NL + "function importExcelWinInit(){" + NL + "\tif(!importExcelWin){" + NL + "\t\timportExcelWin=new goolov.winbox({" + NL + "\t\t\twidth:goolov.winWidth(";
  protected final String TEXT_104 = ")," + NL + "\t\t\theight:goolov.winHeight(";
  protected final String TEXT_105 = ")," + NL + "\t\t\turl:ctx+'";
  protected final String TEXT_106 = "'" + NL + "\t\t});" + NL + "\t}" + NL + "}" + NL + "function importExcelWinOpen(settings){" + NL + "\timportExcelWinInit();" + NL + "\timportExcelWin.open(settings);" + NL + "}" + NL + "function importExcelWinClose(){" + NL + "\timportExcelWin.close();" + NL + "}" + NL + "function importExcelWinCloseAndRefresh(){" + NL + "\timportExcelWinClose();" + NL + "\trefresh();" + NL + "}" + NL + "function importExcel(){" + NL + "\tvar title=config.baseTitle+'->导入Excel文件数据';" + NL + "\timportExcelWinOpen({title:title});" + NL + "}";
  protected final String TEXT_107 = NL + "/*******rel GsysCodevalue manager**********/" + NL + "var ";
  protected final String TEXT_108 = "Win;" + NL + "function ";
  protected final String TEXT_109 = "WinInit(){" + NL + "\tif(!";
  protected final String TEXT_110 = "Win){" + NL + "\t\t";
  protected final String TEXT_111 = "Win=new goolov.winbox({" + NL + "\t\t\twidth:goolov.winWidth(750)," + NL + "\t\t\theight:goolov.winHeight(450)," + NL + "\t\t\tmodal:true" + NL + "\t\t});" + NL + "\t}" + NL + "}" + NL + "function ";
  protected final String TEXT_112 = "WinOpen(settings){" + NL + "\t";
  protected final String TEXT_113 = "WinInit();" + NL + "\t";
  protected final String TEXT_114 = "Win.open(settings);" + NL + "}" + NL + "function ";
  protected final String TEXT_115 = "WinClose(){" + NL + "\t";
  protected final String TEXT_116 = "Win.close();" + NL + "}" + NL + "function ";
  protected final String TEXT_117 = "(id,name){" + NL + "\tvar title=config.baseTitle+'->";
  protected final String TEXT_118 = "('+name+')->管理';" + NL + "\tvar url=ctx+'";
  protected final String TEXT_119 = "?";
  protected final String TEXT_120 = ".";
  protected final String TEXT_121 = "='+id;" + NL + "\t";
  protected final String TEXT_122 = "WinOpen({title:title,url:url});" + NL + "}";
  protected final String TEXT_123 = NL + "$(function(){" + NL + "\t$('#header').height($('#header').outerHeight(true)+2);" + NL + "\t$('#container').layout({});" + NL + "\tvar w = $(\"#firstContent\").outerWidth(true);" + NL + "\tvar gridpm = 58; //GridHead，toolbar,footer,gridmargin" + NL + "\tvar h=$(\"#center\").height()-gridpm;" + NL + "    var option = {" + NL + "        height: h, " + NL + "        width: w," + NL + "        url: ctx+'";
  protected final String TEXT_124 = "'," + NL + "        colModel: [";
  protected final String TEXT_125 = NL + "\t\t   ";
  protected final String TEXT_126 = ",";
  protected final String TEXT_127 = "{ display: '";
  protected final String TEXT_128 = "',name: '";
  protected final String TEXT_129 = "',width: ";
  protected final String TEXT_130 = ", sortable: ";
  protected final String TEXT_131 = ", align: 'left',process:format";
  protected final String TEXT_132 = "}";
  protected final String TEXT_133 = NL + "\t\t   ";
  protected final String TEXT_134 = ",";
  protected final String TEXT_135 = "{ display: '";
  protected final String TEXT_136 = "',name: '";
  protected final String TEXT_137 = "',width: ";
  protected final String TEXT_138 = ", sortable: ";
  protected final String TEXT_139 = ", align: 'left'}";
  protected final String TEXT_140 = NL + "\t\t   ";
  protected final String TEXT_141 = ",";
  protected final String TEXT_142 = "{ display: '";
  protected final String TEXT_143 = "',name: '";
  protected final String TEXT_144 = ".";
  protected final String TEXT_145 = "',width: ";
  protected final String TEXT_146 = ", sortable: ";
  protected final String TEXT_147 = ", align: 'left'}";
  protected final String TEXT_148 = NL + "\t\t   ";
  protected final String TEXT_149 = ",";
  protected final String TEXT_150 = "{ display: '";
  protected final String TEXT_151 = "',name: '";
  protected final String TEXT_152 = ".";
  protected final String TEXT_153 = "',width: ";
  protected final String TEXT_154 = ", sortable: ";
  protected final String TEXT_155 = ", align: 'left'}";
  protected final String TEXT_156 = NL + "\t\t],      " + NL + "\t\tindexId:'";
  protected final String TEXT_157 = "'," + NL + "\t\tsortname: \"";
  protected final String TEXT_158 = "\"," + NL + "\t\tsortorder: \"";
  protected final String TEXT_159 = "\"," + NL + "\t\tsearchparam:searchparamsCall," + NL + "\t\tautoload: true," + NL + "\t\tshowcheckbox: true," + NL + "\t\tusepager: true," + NL + "\t\tshowseq:true," + NL + "        rowhandler: gridContextmenu," + NL + "\t\trowbinddata: false," + NL + "\t\tonRowDblclick:onRowDblclick," + NL + "\t\tnowrap:false" + NL + "    };" + NL + "    " + NL + "\t//format" + NL + "\t";
  protected final String TEXT_160 = NL + "\tfunction format";
  protected final String TEXT_161 = "(value, pid) {" + NL + "\t\treturn ";
  protected final String TEXT_162 = "[value];" + NL + "\t}";
  protected final String TEXT_163 = NL + NL + "    //search params" + NL + "    function searchparamsCall(){" + NL + "\t\tvar params=$(\"#firstSearchForm\").serializeArray();" + NL + "     \treturn params;" + NL + "\t}" + NL + "\t" + NL + "\t//grid" + NL + "    grid = $(\"#dataGrid\").flexigrid(option);" + NL + "    " + NL + "    //validate";
  protected final String TEXT_164 = "    ";
  protected final String TEXT_165 = NL + "\tsearchFormValidator=$(\"#firstSearchForm\").validate({" + NL + "\t\trules : {";
  protected final String TEXT_166 = NL + "\t\t\t\t";
  protected final String TEXT_167 = ",";
  protected final String TEXT_168 = ":{";
  protected final String TEXT_169 = "}//";
  protected final String TEXT_170 = " ";
  protected final String TEXT_171 = NL + "\t\t\t\t,";
  protected final String TEXT_172 = ":{";
  protected final String TEXT_173 = "}//";
  protected final String TEXT_174 = " ";
  protected final String TEXT_175 = NL + "\t\t\t\t";
  protected final String TEXT_176 = ",";
  protected final String TEXT_177 = "\"";
  protected final String TEXT_178 = ".";
  protected final String TEXT_179 = "\":{";
  protected final String TEXT_180 = "}//";
  protected final String TEXT_181 = " ";
  protected final String TEXT_182 = "\t\t\t\t\t\t";
  protected final String TEXT_183 = NL + "\t\t\t\t";
  protected final String TEXT_184 = ",";
  protected final String TEXT_185 = ":{";
  protected final String TEXT_186 = "}//";
  protected final String TEXT_187 = " ";
  protected final String TEXT_188 = "\t";
  protected final String TEXT_189 = NL + "    \t}," + NL + "    \terrorType: \"bftip\"" + NL + "\t});";
  protected final String TEXT_190 = "\t";
  protected final String TEXT_191 = "\t";
  protected final String TEXT_192 = NL + NL + "\t//process ";
  protected final String TEXT_193 = " render" + NL + "\t$(\"#";
  protected final String TEXT_194 = ",#";
  protected final String TEXT_195 = "\").datepickerRange({startEl:'";
  protected final String TEXT_196 = "',endEl:'";
  protected final String TEXT_197 = "'});";
  protected final String TEXT_198 = "\t";
  protected final String TEXT_199 = "\t" + NL + "    //variate";
  protected final String TEXT_200 = NL + "    //variate" + NL + "    var ";
  protected final String TEXT_201 = "=$('#";
  protected final String TEXT_202 = "').val();" + NL + "    config.inputUrl=ctx+'";
  protected final String TEXT_203 = "?";
  protected final String TEXT_204 = "='+";
  protected final String TEXT_205 = ";" + NL + "    config.editUrl=ctx+'";
  protected final String TEXT_206 = "?";
  protected final String TEXT_207 = "='+";
  protected final String TEXT_208 = ";" + NL + "    config.deleteOutJsonUrl=ctx+'";
  protected final String TEXT_209 = "?";
  protected final String TEXT_210 = "='+";
  protected final String TEXT_211 = ";" + NL + "    config.deleteOutJsonAllUrl=ctx+'";
  protected final String TEXT_212 = "?";
  protected final String TEXT_213 = "='+";
  protected final String TEXT_214 = ";" + NL + "    config.deleteDescendantOutJsonUrl=ctx+'";
  protected final String TEXT_215 = "?";
  protected final String TEXT_216 = "='+";
  protected final String TEXT_217 = ";" + NL + "    //load category tree" + NL + "    loadCategoryTree();" + NL + "});" + NL + "var grid;" + NL + "var searchFormValidator;" + NL + "var config={" + NL + "\tbaseTitle:\"";
  protected final String TEXT_218 = "管理\"," + NL + "\tinputUrl:null," + NL + "\teditUrl:null," + NL + "\tdeleteOutJsonUrl:null," + NL + "\tdeleteOutJsonAllUrl:null," + NL + "\tdeleteDescendantOutJsonUrl:null" + NL + "};" + NL + "/******grid contenxt menu process*****/" + NL + "/******context menu*****/" + NL + "var imgPath=ctx+\"/resources/style/default/contextmenu/images/\";" + NL + "var menu = {" + NL + "\t\twidth : 150" + NL + "\t\t,items : [" + NL + "\t\t\t\t{text : \"刷新\",icon : imgPath+\"table_refresh.png\",alias : \"refresh\",action : contextMenuClick}" + NL + "\t\t\t\t,{type: \"splitLine\" }" + NL + "\t\t\t\t,{text : \"新增\",icon :imgPath+\"view.png\",alias : \"add\",action :contextMenuClick}" + NL + "\t\t\t\t,{text : \"编辑\",icon : imgPath+\"edit.png\",alias : \"edit\",action : contextMenuClick}" + NL + "\t\t\t\t,{type: \"splitLine\" }" + NL + "\t\t\t\t,{text : \"删除该项记录\",icon : imgPath+\"rowdelete.png\",alias : \"deleteCurrent\",action : contextMenuClick}" + NL + "\t\t\t\t,{text : \"删除该项记录及子节点\",icon : imgPath+\"rowdelete.png\",alias : \"deleteCurrentAndDescendant\",action : contextMenuClick}" + NL + "\t\t\t\t,{text : \"删除所选记录\",icon : imgPath+\"rowdelete.png\",alias : \"deleteSels\",action : contextMenuClick}" + NL + "\t\t\t\t,{text : \"删除所选记录及子节点\",icon : imgPath+\"rowdelete.png\",alias : \"deleteDescendant\",action : contextMenuClick}" + NL + "\t\t\t\t,{text : \"删除所有记录\",icon : imgPath+\"rowdelete.png\",alias : \"deleteAll\",action : contextMenuClick}" + NL + "\t\t\t\t]" + NL + "\t\t" + NL + "};" + NL + "function contextMenuClick(target,cmd) {" + NL + "\tvar domId=$(target).attr(\"id\");" + NL + "\tvar id = domId.substr(3);" + NL + "\tvar rowIdx = $(target).attr(\"seq\");" + NL + "\tswitch(cmd){" + NL + "\t\tcase 'add':" + NL + "\t\t\tvar title=config.baseTitle+'->新增';" + NL + "\t\t\tnewWinOpen();" + NL + "\t\t\tbreak;" + NL + "\t\tcase 'edit':" + NL + "\t\t\tvar title = config.baseTitle+'->编辑 (序号:' + rowIdx + ')';" + NL + "\t\t\tvar url=goolov.addUrlParams(config.editUrl,\"id=\"+id);" + NL + "\t\t\teditWinOpen( {title:title,url:url});" + NL + "\t\t\tbreak;" + NL + "\t\tcase 'deleteCurrent':" + NL + "\t\t\tdeleteOutJson(new Array(id));" + NL + "\t\t\tbreak;" + NL + "\t\tcase 'deleteCurrentAndDescendant':" + NL + "\t\t\tdeleteDescendantOutJson(new Array(id));" + NL + "\t\t\tbreak;" + NL + "\t\tcase 'deleteSels':" + NL + "\t\t\tvar ids=grid.getCheckedRows();" + NL + "\t\t\tdeleteOutJson(ids);" + NL + "\t\t\tbreak;" + NL + "\t\tcase 'deleteDecendant':" + NL + "\t\t\tvar ids=grid.getCheckedRows();" + NL + "\t\t\tdeleteDescendantOutJson(ids);" + NL + "\t\t\tbreak;" + NL + "\t\tcase 'deleteAll':" + NL + "\t\t\tdelAllData();" + NL + "\t\t\tbreak;" + NL + "\t\tdefault:" + NL + "\t\t\tgrid.flexReload();" + NL + "\t}" + NL + "};" + NL + "function gridContextmenu(row) {" + NL + "\t$(row).contextmenu(menu);" + NL + "} " + NL + "/******category tree ***************/" + NL + "function loadCategoryTree(){" + NL + "    var url=ctx+'";
  protected final String TEXT_219 = "';" + NL + "    var options = { url:url,onnodeclick:treeNodeClick,showcheck: false,iconspath:ctx+\"/resources/style/\"+theme+\"/tree/images/\"/*,theme: \"bbit-tree-lines\"*/ };" + NL + "    $('#firstTree').ajaxTree(options);" + NL + "}" + NL + "function treeNodeClick(item) {" + NL + "    if(!item.id||'root'==item.id){" + NL + "    \t$(\"#parentId\").val('');" + NL + "    }else{" + NL + "    \t$(\"#parentId\").val(item.id);" + NL + "    }" + NL + "\tgrid.flexReload({newp:1});" + NL + "}" + NL + "/******refresh grid data*******/" + NL + "function reloadGrid(){" + NL + "\tsearchFormValidator.form();" + NL + "\tif(!searchFormValidator.valid()){" + NL + " \t\tvar invalideNum=searchFormValidator.numberOfInvalids();" + NL + "\t    if(invalideNum>0){" + NL + "\t    \tgoolov.growl.success('有<font color=red> '+invalideNum+'</font> 个查询选项未填写正确!');" + NL + "\t\t    return false;" + NL + "\t    }" + NL + "\t}" + NL + "\tgrid.flexReload();" + NL + "}" + NL + "" + NL + "/******refresh  *******/" + NL + "function refresh(){" + NL + "\treloadGrid();" + NL + "\tloadCategoryTree();" + NL + "}" + NL + "/******reset clear  *******/" + NL + "function clear(){" + NL + "\tdocument.getElementById('firstSearchForm').reset();" + NL + "\tgrid.flexReload({newp:1});" + NL + "}" + NL + "/******search*******/" + NL + "function firstSearch(){" + NL + "\treloadGrid();" + NL + "}" + NL + "/******add data**********/" + NL + "var newWin;" + NL + "function newWinInit(){" + NL + "\tif(!newWin){" + NL + "\t\tvar title=config.baseTitle+'->新增';" + NL + "\t\tvar url=config.inputUrl;" + NL + "\t\tnewWin=new goolov.winbox({" + NL + "\t\t\twidth:goolov.winWidth(";
  protected final String TEXT_220 = ")," + NL + "\t\t\theight:goolov.winHeight(";
  protected final String TEXT_221 = ")," + NL + "\t\t\ttitle:title," + NL + "\t\t\turl:url" + NL + "\t\t});" + NL + "\t}" + NL + "}" + NL + "function newWinOpen(settings){" + NL + "\tnewWinInit();" + NL + "\tnewWin.open(settings);" + NL + "}" + NL + "function newWinClose(){" + NL + "\tnewWin.close();" + NL + "}" + NL + "function newWinCloseAndRefresh(){" + NL + "\tnewWinClose();" + NL + "\trefresh();" + NL + "}" + NL + "function newData(){" + NL + "\tnewWinOpen();" + NL + "}" + NL + "/******edit data window**********/" + NL + "var editWin;" + NL + "function editWinInit(){" + NL + "\tif(!editWin){" + NL + "\t\teditWin=new goolov.winbox({" + NL + "\t\t\twidth:goolov.winWidth(";
  protected final String TEXT_222 = ")," + NL + "\t\t\theight:goolov.winHeight(";
  protected final String TEXT_223 = ")" + NL + "\t\t});" + NL + "\t}" + NL + "}" + NL + "function editWinOpen(settings){" + NL + "\teditWinInit();" + NL + "\teditWin.open(settings);" + NL + "}" + NL + "function editWinClose(){" + NL + "\teditWin.close();" + NL + "}" + NL + "function editWinCloseAndRefresh(){" + NL + "\teditWinClose();" + NL + "\trefresh();" + NL + "}" + NL + "function onRowDblclick(target){" + NL + "\tvar id = $(target).attr(\"id\").substr(3);" + NL + "\tvar rowIdx=$(target).attr(\"seq\");" + NL + "\tvar title=config.baseTitle+'->编辑 (序号:'+rowIdx+')';" + NL + "\tvar url=goolov.addUrlParams(config.editUrl,\"id=\"+id);" + NL + "\teditWinOpen({title:title,url:url});" + NL + "}" + NL + "function editData(){" + NL + "\tvar ids=grid.getCheckedRows();" + NL + "\tvar selCount=ids.length;" + NL + "\tif (selCount== 0) {" + NL + "\t\tgoolov.growl.info('请先选择需要修改的记录,或双击需要编辑的行.');" + NL + "\t\treturn;" + NL + "\t}" + NL + "\tif(selCount>1){" + NL + "\t\tgoolov.growl.info('一次只能选择修改一项记录.');" + NL + "\t\treturn;" + NL + "\t}" + NL + "\tvar id=ids[0];" + NL + "\tvar rowtr=grid.getRowDom(id);//获取该ID的行元素." + NL + "\tvar rowIdx=$(rowtr).attr(\"seq\");" + NL + "\tvar title=config.baseTitle+'->编辑 (序号:'+rowIdx+')';" + NL + "\tvar url=goolov.addUrlParams(config.editUrl,\"id=\"+ids[0]);" + NL + "\tvar opts={title:title,url:url};" + NL + "\teditWinOpen(opts);" + NL + "}" + NL + "/**********add row data**************/" + NL + "function addRowData(row){" + NL + "\tvar indexId=grid.getIndexId();" + NL + "\tvar rowTr=grid.getRowDom(row[indexId]);////获取该ID的行元素.;" + NL + "\tif (rowtr.length==0) {" + NL + "\t\tgrid.flexAddRowData(row);" + NL + "\t}else{" + NL + "\t\tgrid.flexEditRowData(rowtr[0],row);" + NL + "\t\t//for update Descendant need refresh grid" + NL + "\t\t//refresh();" + NL + "\t}" + NL + "\tloadCategoryTree();" + NL + "}" + NL + "/******del data**********/" + NL + "function delData(){" + NL + "\tvar ids=grid.getCheckedRows();" + NL + "\tdeleteOutJson(ids);" + NL + "}" + NL + "/******del data process**********/" + NL + "function deleteOutJson(idsArray){" + NL + "\tif (!idsArray||idsArray.length==0) {" + NL + "\t\tgoolov.growl.info('请选择需要删除的记录.');" + NL + "\t\treturn;" + NL + "\t}" + NL + "\tvar selCount=idsArray.length;" + NL + "\tvar idsStr=idsArray.join(',');" + NL + "\tgoolov.msgbox.confirm('删除确认','您确认删除这<span class=\"highlight\">'+selCount+'</span>项记录吗?删除后将不可恢复!',function(r){" + NL + "\t\t\tif(r){" + NL + "\t\t\t\t$.ajax({" + NL + "\t\t\t\t\ttype : 'post'," + NL + "\t\t\t\t\turl : config.deleteOutJsonUrl," + NL + "\t\t\t\t\tdata : {id:idsStr}," + NL + "\t\t\t\t\tdataType:'json'," + NL + "\t\t\t\t\tbeforeSend :function() {" + NL + "\t\t\t\t\t\tgoolov.growl.waiting('正在删除中!请稍后...');" + NL + "\t\t\t\t\t}," + NL + "\t\t\t\t\tsuccess : function(result) {" + NL + "\t\t\t\t\t\tgoolov.growl.unwaiting();" + NL + "\t\t\t\t\t\tif (result&&result.success) {" + NL + "\t\t\t\t\t\t\tgoolov.growl.success(result.message);" + NL + "\t\t\t\t\t\t\trefresh();" + NL + "\t\t\t\t\t\t}else if(result&&result.message){" + NL + "\t\t\t\t\t\t\tgoolov.msgbox.error(result.message);" + NL + "\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\tgoolov.msgbox.error();" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}," + NL + "\t\t\t\t\terror:function(request,status,errorThrown) {" + NL + "\t\t\t\t\t\tgoolov.growl.unwaiting();" + NL + "\t\t\t\t\t\tgoolov.msgbox.error();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t});" + NL + "\t\t\t}" + NL + "\t});" + NL + "}" + NL + "/*******del deleteDescendant***/" + NL + "function delDescendantData(){" + NL + "\tvar ids=grid.getCheckedRows();" + NL + "\tdeleteDescendantOutJson(ids);" + NL + "}" + NL + "/*******del deleteDescendant process***/" + NL + "function deleteDescendantOutJson(idsArray){" + NL + "\tif (!idsArray||idsArray.length==0) {" + NL + "\t\tgoolov.msgbox.alert('请选择需要删除的记录.');" + NL + "\t\treturn;" + NL + "\t}" + NL + "\tvar selCount=idsArray.length;" + NL + "\tvar idsStr=idsArray.join(',');" + NL + "\tgoolov.msgbox.confirm('删除确认','您确认删除这<span class=\"highlight\">'+selCount+'</span>项记录吗?删除后将不可恢复!',function(r){" + NL + "\t\tif(r){" + NL + "\t\t\t$.ajax({" + NL + "\t\t\t\ttype : 'post'," + NL + "\t\t\t\turl : config.deleteDescendantOutJson," + NL + "\t\t\t\tdata : {id:idsStr}," + NL + "\t\t\t\tdataType:'json'," + NL + "\t\t\t\tbeforeSend :function() {" + NL + "\t\t\t\t\tgoolov.growl.waiting('正在删除中!请稍后...');" + NL + "\t\t\t\t}," + NL + "\t\t\t\tsuccess : function(result) {" + NL + "\t\t\t\t\tgoolov.growl.unwaiting();" + NL + "\t\t\t\t\tif (result&&result.success) {" + NL + "\t\t\t\t\t\tgoolov.growl.success(result.message);" + NL + "\t\t\t\t\t\trefresh();" + NL + "\t\t\t\t\t}else if(result&&result.message){" + NL + "\t\t\t\t\t\tgoolov.msgbox.error(result.message);" + NL + "\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\tgoolov.msgbox.error();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}," + NL + "\t\t\t\terror:function(request,status,errorThrown) {" + NL + "\t\t\t\t\tgoolov.growl.unwaiting();" + NL + "\t\t\t\t\tgoolov.msgbox.error();" + NL + "\t\t\t\t}" + NL + "\t\t\t});" + NL + "\t\t}" + NL + "\t});" + NL + "}" + NL + "/******del all data   *******/" + NL + "function delAllData(){" + NL + "\t\tgoolov.msgbox.confirm('删除确认','您确认这删除所有记录吗?删除后将不可恢复!',function(r){" + NL + "\t\tif(r){" + NL + "\t\t\t$.ajax({" + NL + "\t\t\t\t\ttype : 'get'," + NL + "\t\t\t\t\turl : deleteOutJsonAllUrl," + NL + "\t\t\t\t\tdataType:'json'," + NL + "\t\t\t\t\tbeforeSend :function() {" + NL + "\t\t\t\t\t\tgoolov.growl.waiting('正在删除中!请稍后...');" + NL + "\t\t\t\t\t}," + NL + "\t\t\t\t\tsuccess : function(result) {" + NL + "\t\t\t\t\t\tgoolov.growl.unwaiting();" + NL + "\t\t\t\t\t\tif (result&&result.success) {" + NL + "\t\t\t\t\t\t\tgoolov.growl.success(result.message);" + NL + "\t\t\t\t\t\t\trefresh();" + NL + "\t\t\t\t\t\t}else if(result&&result.message){" + NL + "\t\t\t\t\t\t\tgoolov.msgbox.error(result.message);" + NL + "\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\tgoolov.msgbox.error();" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}," + NL + "\t\t\t\t\terror:function(request,status,errorThrown) {" + NL + "\t\t\t\t\t\tgoolov.growl.unwaiting();" + NL + "\t\t\t\t\t\tgoolov.msgbox.error();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t});" + NL + "\t\t}" + NL + "\t});" + NL + "}" + NL + "/******export excel*******/" + NL + "function exportExcel(){" + NL + "\tvar paramSerialize=grid.getParamsString();" + NL + "\tvar exportExcelFileUrl=ctx+'";
  protected final String TEXT_224 = "';" + NL + "\tlocation.href=goolov.addUrlParams(exportExcelFileUrl,paramSerialize);" + NL + "}";
  protected final String TEXT_225 = NL + "/******import importExcel**********/" + NL + "var importExcelWin;" + NL + "function importExcelWinInit(){" + NL + "\tif(!importExcelWin){" + NL + "\t\timportExcelWin=new goolov.winbox({" + NL + "\t\t\twidth:goolov.winWidth(";
  protected final String TEXT_226 = ")," + NL + "\t\t\theight:goolov.winHeight(";
  protected final String TEXT_227 = ")," + NL + "\t\t\turl:ctx+'";
  protected final String TEXT_228 = "'" + NL + "\t\t});" + NL + "\t}" + NL + "}" + NL + "function importExcelWinOpen(settings){" + NL + "\timportExcelWinInit();" + NL + "\timportExcelWin.open(settings);" + NL + "}" + NL + "function importExcelWinClose(){" + NL + "\timportExcelWin.close();" + NL + "}" + NL + "function importExcelWinCloseAndRefresh(){" + NL + "\timportExcelWinClose();" + NL + "\trefresh();" + NL + "}" + NL + "function importExcel(){" + NL + "\tvar title=config.baseTitle+'->导入Excel文件数据';" + NL + "\timportExcelWinOpen({title:title});" + NL + "}";
  protected final String TEXT_229 = NL + "/*******rel GsysCodevalue manager**********/" + NL + "var ";
  protected final String TEXT_230 = "Win;" + NL + "function ";
  protected final String TEXT_231 = "WinInit(){" + NL + "\tif(!";
  protected final String TEXT_232 = "Win){" + NL + "\t\t";
  protected final String TEXT_233 = "Win=new goolov.winbox({" + NL + "\t\t\twidth:goolov.winWidth(750)," + NL + "\t\t\theight:goolov.winHeight(450)," + NL + "\t\t\tmodal:true" + NL + "\t\t});" + NL + "\t}" + NL + "}" + NL + "function ";
  protected final String TEXT_234 = "WinOpen(settings){" + NL + "\t";
  protected final String TEXT_235 = "WinInit();" + NL + "\t";
  protected final String TEXT_236 = "Win.open(settings);" + NL + "}" + NL + "function ";
  protected final String TEXT_237 = "WinClose(){" + NL + "\t";
  protected final String TEXT_238 = "Win.close();" + NL + "}" + NL + "function ";
  protected final String TEXT_239 = "(id,name){" + NL + "\tvar title=config.baseTitle+'->";
  protected final String TEXT_240 = "('+name+')->管理';" + NL + "\tvar url=ctx+'";
  protected final String TEXT_241 = "?";
  protected final String TEXT_242 = ".";
  protected final String TEXT_243 = "='+id;" + NL + "\t";
  protected final String TEXT_244 = "WinOpen({title:title,url:url});" + NL + "}";
  protected final String TEXT_245 = NL + "$(function(){" + NL + "\tvar mainheight = document.documentElement.clientHeight;" + NL + "\tvar gridpm = 58; //GridHead，toolbar，footer,gridmargin" + NL + "\tvar h = mainheight - gridpm-$(\"#header\").outerHeight(true);" + NL + "\tvar w = $(\"#first-content\").width();" + NL + "    var option = {" + NL + "        height: h, " + NL + "        width: w," + NL + "        url: ctx+'";
  protected final String TEXT_246 = "'," + NL + "        colModel: [";
  protected final String TEXT_247 = NL + "\t\t   ";
  protected final String TEXT_248 = ",";
  protected final String TEXT_249 = "{ display: '";
  protected final String TEXT_250 = "',name: '";
  protected final String TEXT_251 = "',width: ";
  protected final String TEXT_252 = ", sortable: ";
  protected final String TEXT_253 = ", align: 'left',process:format";
  protected final String TEXT_254 = "}";
  protected final String TEXT_255 = NL + "\t\t   ";
  protected final String TEXT_256 = ",";
  protected final String TEXT_257 = "{ display: '";
  protected final String TEXT_258 = "',name: '";
  protected final String TEXT_259 = "',width: ";
  protected final String TEXT_260 = ", sortable: ";
  protected final String TEXT_261 = ", align: 'left'}";
  protected final String TEXT_262 = NL + "\t\t  ";
  protected final String TEXT_263 = ",";
  protected final String TEXT_264 = "{ display: '";
  protected final String TEXT_265 = "',name: '";
  protected final String TEXT_266 = ".";
  protected final String TEXT_267 = "',width: ";
  protected final String TEXT_268 = ", sortable: ";
  protected final String TEXT_269 = ", align: 'left'}";
  protected final String TEXT_270 = NL + "\t\t   ";
  protected final String TEXT_271 = ",";
  protected final String TEXT_272 = "{ display: '";
  protected final String TEXT_273 = "',name: '";
  protected final String TEXT_274 = ".";
  protected final String TEXT_275 = "',width: ";
  protected final String TEXT_276 = ", sortable: ";
  protected final String TEXT_277 = ", align: 'left'}";
  protected final String TEXT_278 = NL + "\t\t],      " + NL + "\t\tindexId:'";
  protected final String TEXT_279 = "'," + NL + "\t\tsortname: \"";
  protected final String TEXT_280 = "\"," + NL + "\t\tsortorder: \"";
  protected final String TEXT_281 = "\"," + NL + "\t\tsearchparam:searchparamsCall," + NL + "\t\tautoload: true," + NL + "\t\tshowcheckbox: true," + NL + "\t\tusepager: true," + NL + "\t\tshowseq:true," + NL + "        rowhandler: gridContextmenu," + NL + "\t\trowbinddata: false," + NL + "\t\tonRowDblclick:onRowDblclick" + NL + "    };" + NL + "    //search params" + NL + "    function searchparamsCall(){" + NL + "\t\tvar params=$(\"#firstSearchForm\").serializeArray();" + NL + "     \treturn params;" + NL + "\t}" + NL + "\t//format" + NL + "\t";
  protected final String TEXT_282 = NL + "\tfunction format";
  protected final String TEXT_283 = "(value, row) {" + NL + "\t\treturn ";
  protected final String TEXT_284 = "[value];" + NL + "\t}";
  protected final String TEXT_285 = NL + NL + "    grid = $(\"#dataGrid\").flexigrid(option);" + NL + "    " + NL + "    //validate";
  protected final String TEXT_286 = "    ";
  protected final String TEXT_287 = NL + "\tsearchFormValidator=$(\"#firstSearchForm\").validate({" + NL + "\t\trules : {";
  protected final String TEXT_288 = NL + "\t\t\t\t";
  protected final String TEXT_289 = ",";
  protected final String TEXT_290 = ":{";
  protected final String TEXT_291 = "}//";
  protected final String TEXT_292 = " ";
  protected final String TEXT_293 = NL + "\t\t\t\t,";
  protected final String TEXT_294 = ":{";
  protected final String TEXT_295 = "}//";
  protected final String TEXT_296 = " ";
  protected final String TEXT_297 = NL + "\t\t\t\t";
  protected final String TEXT_298 = ",";
  protected final String TEXT_299 = "\"";
  protected final String TEXT_300 = ".";
  protected final String TEXT_301 = "\":{";
  protected final String TEXT_302 = "}//";
  protected final String TEXT_303 = " ";
  protected final String TEXT_304 = "\t\t\t\t\t\t";
  protected final String TEXT_305 = NL + "\t\t\t\t";
  protected final String TEXT_306 = ",";
  protected final String TEXT_307 = ":{";
  protected final String TEXT_308 = "}//";
  protected final String TEXT_309 = " ";
  protected final String TEXT_310 = "\t";
  protected final String TEXT_311 = NL + "    \t}," + NL + "    \terrorType: \"bftip\"" + NL + "\t});";
  protected final String TEXT_312 = "\t";
  protected final String TEXT_313 = "\t";
  protected final String TEXT_314 = NL + NL + "\t//process ";
  protected final String TEXT_315 = " render" + NL + "\t$(\"#";
  protected final String TEXT_316 = ",#";
  protected final String TEXT_317 = "\").datepickerRange({startEl:'";
  protected final String TEXT_318 = "',endEl:'";
  protected final String TEXT_319 = "'});";
  protected final String TEXT_320 = NL + "    //variate" + NL + "    var ";
  protected final String TEXT_321 = "=$('#";
  protected final String TEXT_322 = "').val();" + NL + "    config.inputUrl=ctx+'";
  protected final String TEXT_323 = "?";
  protected final String TEXT_324 = "='+";
  protected final String TEXT_325 = ";" + NL + "    config.editUrl=ctx+'";
  protected final String TEXT_326 = "?";
  protected final String TEXT_327 = "='+";
  protected final String TEXT_328 = ";" + NL + "    config.deleteOutJsonUrl=ctx+'";
  protected final String TEXT_329 = "?";
  protected final String TEXT_330 = "='+";
  protected final String TEXT_331 = ";" + NL + "    config.deleteOutJsonAllUrl=ctx+'";
  protected final String TEXT_332 = "?";
  protected final String TEXT_333 = "='+";
  protected final String TEXT_334 = ";" + NL + "});" + NL + "var grid;" + NL + "var searchFormValidator;" + NL + "var config={" + NL + "\tbaseTitle:\"";
  protected final String TEXT_335 = "管理\"," + NL + "\tinputUrl:null," + NL + "\teditUrl:null," + NL + "\tdeleteOutJsonUrl:null," + NL + "\tdeleteOutJsonAllUrl:null" + NL + "};" + NL + "/******contenxtmenu*****/" + NL + "var imgPath=ctx+\"/resources/style/default/contextmenu/images/\";" + NL + "var menu = {" + NL + "\t\twidth : 150" + NL + "\t\t,items : [" + NL + "\t\t\t\t {text : \"刷新\",icon : imgPath+\"table_refresh.png\",alias : \"refresh\",action : contextMenuClick}" + NL + "\t\t\t\t,{type: \"splitLine\" }" + NL + "\t\t\t\t,{text : \"新增\",icon :imgPath+\"view.png\",alias : \"add\",action :contextMenuClick}" + NL + "\t\t\t\t,{text : \"编辑\",icon : imgPath+\"edit.png\",alias : \"edit\",action : contextMenuClick}" + NL + "\t\t\t\t,{type: \"splitLine\" }" + NL + "\t\t\t\t,{text : \"删除该项记录\",icon : imgPath+\"rowdelete.png\",alias : \"deleteCurrent\",action : contextMenuClick}" + NL + "\t\t\t\t,{text : \"删除所选记录\",icon : imgPath+\"rowdelete.png\",alias : \"deleteSels\",action : contextMenuClick}" + NL + "\t\t\t\t,{text : \"删除所有记录\",icon : imgPath+\"rowdelete.png\",alias : \"deleteAll\",action : contextMenuClick}" + NL + "\t\t\t\t]" + NL + "\t};" + NL + "function contextMenuClick(target) {" + NL + "\tvar id = $(target).attr(\"id\").substr(3);" + NL + "\tvar rowIdx = $(target).attr(\"seq\");" + NL + "\tvar cmd = this.data.alias;" + NL + "\tswitch(cmd){" + NL + "\t\tcase 'add':" + NL + "\t\t\tvar title=config.baseTitle+'->新增';" + NL + "\t\t\tnewWinOpen({title:title});" + NL + "\t\t\tbreak;" + NL + "\t\tcase 'edit':" + NL + "\t\t\tvar title = config.baseTitle+'->编辑 (序号:' + rowIdx + ')';" + NL + "\t\t\tvar url=goolov.addUrlParams(config.editUrl,\"id=\"+id);" + NL + "\t\t\teditWinOpen( {title:title,url:url});" + NL + "\t\t\tbreak;" + NL + "\t\tcase 'deleteSels':" + NL + "\t\t\tdelData();" + NL + "\t\t\tbreak;" + NL + "\t\tcase 'deleteAll':" + NL + "\t\t\tdelAllData();" + NL + "\t\t\tbreak;" + NL + "\t\tcase 'refresh':" + NL + "\t\t\trefresh();" + NL + "\t\t\tbreak;" + NL + "\t}" + NL + "};" + NL + "function gridContextmenu(row) {" + NL + "\t$(row).contextmenu(menu);" + NL + "} " + NL + "/******searchForm validate check******/" + NL + "function searchFormValidCheck(){" + NL + "\tsearchFormValidator.form();" + NL + "\tif(!searchFormValidator.valid()){" + NL + " \t\tvar invalideNum=searchFormValidator.numberOfInvalids();" + NL + "\t    if(invalideNum>0){" + NL + "\t    \tgoolov.growl.success('有<font color=red> '+invalideNum+'</font> 个查询选项未填写正确!');" + NL + "\t\t    return false;" + NL + "\t    }" + NL + "\t}" + NL + "\treturn true;" + NL + "}" + NL + "/******refresh grid *******/" + NL + "function reloadGrid(setting){" + NL + "\tif(searchFormValidCheck()){" + NL + "\t\tgrid.flexReload(setting?setting:{});" + NL + "\t}" + NL + "}" + NL + "/******refresh  *******/" + NL + "function refresh(){" + NL + "\treloadGrid();" + NL + "}" + NL + "/******reset clear *******/" + NL + "function clear(){" + NL + "\tdocument.getElementById('firstSearchForm').reset();" + NL + "\tsearchFormValidator.resetForm();" + NL + "\treloadGrid({newp:1});" + NL + "}" + NL + "/******search*******/" + NL + "function firstSearch(){" + NL + "\treloadGrid({newp:1});" + NL + "}" + NL + "/******add data**********/" + NL + "var newWin;" + NL + "function newWinOpen(settings){" + NL + "\tif(!newWin){" + NL + "\t\tvar title=config.baseTitle+'->新增';" + NL + "\t\tvar url=config.inputUrl;" + NL + "\t\tnewWin=new goolov.winbox({" + NL + "\t\t\twidth:goolov.winWidth(";
  protected final String TEXT_336 = ")," + NL + "\t\t\theight:goolov.winHeight(";
  protected final String TEXT_337 = ")," + NL + "\t\t\ttitle:title," + NL + "\t\t\turl:url" + NL + "\t\t});" + NL + "\t}" + NL + "\tnewWin.open(settings);" + NL + "}" + NL + "function newWinClose(){" + NL + "\tnewWin.close();" + NL + "}" + NL + "function newWinCloseAndRefresh(){" + NL + "\tnewWinClose();" + NL + "\trefresh();" + NL + "}" + NL + "function newData(){" + NL + "\tvar title=config.baseTitle+'->新增';" + NL + "\tvar parentId=$('#parentId').val();" + NL + "\tvar url=goolov.addUrlParams(config.inputUrl,\"parentId=\"+parentId);" + NL + "\tnewWinOpen({title : title,url:url});" + NL + "}" + NL + "/******edit data window**********/" + NL + "var editWin;" + NL + "function editWinOpen(settings){" + NL + "\tif(!editWin){" + NL + "\t\teditWin=new goolov.winbox({" + NL + "\t\t\twidth:goolov.winWidth(";
  protected final String TEXT_338 = ")," + NL + "\t\t\theight:goolov.winHeight(";
  protected final String TEXT_339 = ")" + NL + "\t\t});" + NL + "\t}" + NL + "\teditWin.open(settings);" + NL + "}" + NL + "function editWinClose(){" + NL + "\teditWin.close();" + NL + "}" + NL + "function editWinCloseAndRefresh(){" + NL + "\teditWinClose();" + NL + "\trefresh();" + NL + "}" + NL + "function onRowDblclick(target){" + NL + "\tvar id = $(target).attr(\"id\").substr(3);" + NL + "\tvar rowIdx=$(target).attr(\"seq\");" + NL + "\tvar title=config.baseTitle+'->编辑 (序号:'+rowIdx+')';" + NL + "\tvar url=goolov.addUrlParams(config.editUrl,\"id=\"+id);" + NL + "\teditWinOpen({title:title,url:url});" + NL + "}" + NL + "function editData(){" + NL + "\tvar ids=grid.getCheckedRows();" + NL + "\tvar selCount=ids.length;" + NL + "\tif (selCount== 0) {" + NL + "\t\tgoolov.growl.info('请选择需要修改的记录,或双击需要编辑的行.');" + NL + "\t\treturn;" + NL + "\t}" + NL + "\tif(selCount>1){" + NL + "\t\tgoolov.growl.info('一次只能选择修改一项记录.');" + NL + "\t\treturn;" + NL + "\t}" + NL + "\tvar id=ids[0];" + NL + "\tedit(id);" + NL + "}" + NL + "function edit(id){" + NL + "\tif(!id){" + NL + "\t\tgoolov.growl.info('请选择需要修改的记录,或双击需要编辑的行.');" + NL + "\t\treturn;" + NL + "\t}" + NL + "\tvar rowtr=grid.getRowDom(id);//获取该ID的行元素." + NL + "\tvar rowIdx=$(rowtr).attr(\"seq\");" + NL + "\tvar title=config.baseTitle+'->编辑 (序号:'+rowIdx+')';" + NL + "\tvar url=goolov.addUrlParams(config.editUrl,\"id=\"+id);" + NL + "\tvar opts={title:title,url:url};" + NL + "\teditWinOpen(opts);" + NL + "}" + NL + "/**********add row data**************/" + NL + "function addRowData(row){" + NL + "\tvar indexId=grid.getIndexId();" + NL + "\tvar rowTr=grid.getRowDom(row[indexId]);////获取该ID的行元素.;" + NL + "\tif (rowtr.length==0) {" + NL + "\t\tgrid.flexAddRowData(row);\t\t" + NL + "\t}else{" + NL + "\t\tgrid.flexEditRowData(rowtr[0],row);" + NL + "\t}" + NL + "}" + NL + "/******del data**********/" + NL + "function delData(){" + NL + "\tvar ids=grid.getCheckedRows();" + NL + "\tdeleteOutJson(ids);" + NL + "}" + NL + "function del(id){" + NL + "\tif(!id){" + NL + "\t\tgoolov.growl.info('当前选择无效!');" + NL + "\t\treturn;" + NL + "\t}" + NL + "\tvar ids=new Array(id);" + NL + "\tdeleteOutJson(ids);" + NL + "}" + NL + "/******del data process**********/" + NL + "function deleteOutJson(idsArray){" + NL + "\tif (!idsArray||!$.isArray(idsArray)) {" + NL + "\t\tgoolov.growl.info('当前选择无效!');" + NL + "\t\treturn;" + NL + "\t}" + NL + "\tif (idsArray.length==0) {" + NL + "\t\tgoolov.growl.info('请选择需要删除的记录.');" + NL + "\t\treturn;" + NL + "\t}" + NL + "\tvar selCount=idsArray.length;" + NL + "\tvar idsStr=idsArray.join(',');" + NL + "\tgoolov.msgbox.confirm('删除确认','您确认删除这<span class=\"highlight\">'+selCount+'</span>项记录吗?删除后将不可恢复!',function(r){" + NL + "\t\t\tif(r){" + NL + "\t\t\t\t$.ajax({" + NL + "\t\t\t\t\ttype : 'post'," + NL + "\t\t\t\t\turl : config.deleteOutJsonUrl," + NL + "\t\t\t\t\tdata : {id:idsStr}," + NL + "\t\t\t\t\tdataType:'json'," + NL + "\t\t\t\t\tbeforeSend :function() {" + NL + "\t\t\t\t\t\tgoolov.growl.waiting('正在删除中!请稍后...');" + NL + "\t\t\t\t\t}," + NL + "\t\t\t\t\tsuccess : function(result) {" + NL + "\t\t\t\t\t\tgoolov.growl.unwaiting();" + NL + "\t\t\t\t\t\tif (result&&result.success) {" + NL + "\t\t\t\t\t\t\tgoolov.growl.success(result.message);" + NL + "\t\t\t\t\t\t\trefresh();" + NL + "\t\t\t\t\t\t}else if(result&&result.message){" + NL + "\t\t\t\t\t\t\tgoolov.msgbox.error(result.message);" + NL + "\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\tgoolov.msgbox.error();" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}," + NL + "\t\t\t\t\terror:function(request,status,errorThrown) {" + NL + "\t\t\t\t\t\tgoolov.growl.unwaiting();" + NL + "\t\t\t\t\t\tgoolov.msgbox.error();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t});" + NL + "\t\t\t}" + NL + "\t});" + NL + "}" + NL + "/******del all data   *******/" + NL + "function delAllData(){" + NL + "\t\tgoolov.msgbox.confirm('删除确认','您确认删除所有记录吗?删除后将不可恢复!',function(r){" + NL + "\t\tif(r){" + NL + "\t\t\t$.ajax({" + NL + "\t\t\t\t\ttype : 'get'," + NL + "\t\t\t\t\turl : config.deleteOutJsonAllUrl," + NL + "\t\t\t\t\tdataType:'json'," + NL + "\t\t\t\t\tbeforeSend :function() {" + NL + "\t\t\t\t\t\tgoolov.growl.waiting('正在删除中!请稍后...');" + NL + "\t\t\t\t\t}," + NL + "\t\t\t\t\tsuccess : function(result) {" + NL + "\t\t\t\t\t\tgoolov.growl.unwaiting();" + NL + "\t\t\t\t\t\tif (result&&result.success) {" + NL + "\t\t\t\t\t\t\tgoolov.growl.success(result.message);" + NL + "\t\t\t\t\t\t\trefresh();" + NL + "\t\t\t\t\t\t}else if(result&&result.message){" + NL + "\t\t\t\t\t\t\tgoolov.msgbox.error(result.message);" + NL + "\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\tgoolov.msgbox.error();" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}," + NL + "\t\t\t\t\terror:function(request,status,errorThrown) {" + NL + "\t\t\t\t\t\tgoolov.growl.unwaiting();" + NL + "\t\t\t\t\t\tgoolov.msgbox.error();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t});" + NL + "\t\t}" + NL + "\t});" + NL + "}";
  protected final String TEXT_340 = NL + "/******export excel*******/" + NL + "function exportExcel(){" + NL + "\tvar paramSerialize=grid.getParamsString();" + NL + "\tvar exportExcelFileUrl=ctx+'";
  protected final String TEXT_341 = "';" + NL + "\tlocation.href=goolov.addUrlParams(exportExcelFileUrl,paramSerialize);" + NL + "}" + NL + "/******import importExcel**********/" + NL + "var importExcelWin;" + NL + "function importExcelWinInit(){" + NL + "\tif(!importExcelWin){" + NL + "\t\timportExcelWin=new goolov.winbox({" + NL + "\t\t\twidth:goolov.winWidth(";
  protected final String TEXT_342 = ")," + NL + "\t\t\theight:goolov.winHeight(";
  protected final String TEXT_343 = ")," + NL + "\t\t\turl:ctx+'";
  protected final String TEXT_344 = "'" + NL + "\t\t});" + NL + "\t}" + NL + "}" + NL + "function importExcelWinOpen(settings){" + NL + "\timportExcelWinInit();" + NL + "\timportExcelWin.open(settings);" + NL + "}" + NL + "function importExcelWinClose(){" + NL + "\timportExcelWin.close();" + NL + "}" + NL + "function importExcelWinCloseAndRefresh(){" + NL + "\timportExcelWinClose();" + NL + "\trefresh();" + NL + "}" + NL + "function importExcel(){" + NL + "\tvar title=config.baseTitle+'->导入Excel文件数据';" + NL + "\timportExcelWinOpen({title:title});" + NL + "}";
  protected final String TEXT_345 = NL + "/*******rel GsysCodevalue manager**********/" + NL + "var ";
  protected final String TEXT_346 = "Win;" + NL + "function ";
  protected final String TEXT_347 = "WinInit(){" + NL + "\tif(!";
  protected final String TEXT_348 = "Win){" + NL + "\t\t";
  protected final String TEXT_349 = "Win=new goolov.winbox({" + NL + "\t\t\twidth:goolov.winWidth(750)," + NL + "\t\t\theight:goolov.winHeight(450)," + NL + "\t\t\tmodal:true" + NL + "\t\t});" + NL + "\t}" + NL + "}" + NL + "function ";
  protected final String TEXT_350 = "WinOpen(settings){" + NL + "\t";
  protected final String TEXT_351 = "WinInit();" + NL + "\t";
  protected final String TEXT_352 = "Win.open(settings);" + NL + "}" + NL + "function ";
  protected final String TEXT_353 = "WinClose(){" + NL + "\t";
  protected final String TEXT_354 = "Win.close();" + NL + "}" + NL + "function ";
  protected final String TEXT_355 = "(id,name){" + NL + "\tvar title=config.baseTitle+'->";
  protected final String TEXT_356 = "('+name+')->管理';" + NL + "\tvar url=ctx+'";
  protected final String TEXT_357 = "?";
  protected final String TEXT_358 = ".";
  protected final String TEXT_359 = "='+id;" + NL + "\t";
  protected final String TEXT_360 = "WinOpen({title:title,url:url});" + NL + "}";
  protected final String TEXT_361 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    Property uml2Property_proxy = (Property) argument;
    Class uml2Class_proxy = (Class) uml2Property_proxy.getOwner();
    if(ModelStereoTypeHelper.isApplyModel_Tree(uml2Class_proxy)){//应用了tree
    	if(TreeStereotypeHelper.getValue_treeListStyle(uml2Class_proxy).equalsIgnoreCase("treeGrid")){
    Property curProperty = (Property) argument;Package uml2Package = curProperty.getNearestPackage();
    //String curPropertyCapName=ModelHelper.getCapName(curProperty);
    //String curPropertyComment=ModelHelper.getComment(curProperty);
    Class ownerClass=(Class)curProperty.getOwner();
    //String ownerClassCapName=NameHelper.getCapName(ownerClass);
    //String ownerClassUnCapName=NameHelper.getUncapName(ownerClass);
    String ownerClassCommentName=TypeHelper.getDocumentationOrName(ownerClass);
    UmlClassByPropertyWrap named=new UmlClassByPropertyWrap(curProperty);
    Class uml2Class=ownerClass;
    stringBuffer.append(TEXT_1);
    stringBuffer.append(named.getUrl(WebUrlName.listOutJson));
    stringBuffer.append(TEXT_2);
    
Property idProperty=EntityHelper.getIDProperty(uml2Class);
Iterator<Property> simplePropertyList=ViewListHelper.getViewListPropertiesFromSimple(uml2Class).iterator();
Iterator<Property> m2oPropertyList=ViewListHelper.getViewListPropertiesFromM2o(uml2Class).iterator();
Iterator<Property> o2oPropertyList=ViewListHelper.getViewListPropertiesFromO2o(uml2Class).iterator();
boolean firstLine=true;

    for (;simplePropertyList.hasNext();){//process simpleProperty
    		Property property=simplePropertyList.next();
    		if(property.getName().equals(curProperty.getName())){
    			continue;
    		}
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
    		if(property.getName().equals(curProperty.getName())){
    			continue;
    		}
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
    		if(property.getName().equals(curProperty.getName())){
    			continue;
    		}
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
     			String propertyUncapSafeName=NameHelper.uncapSafeName(property);
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
    String ownerClassIdName=named.getValueNameWithUnderLine();
    String ownerClassIdPath=named.getValueName();
    stringBuffer.append(TEXT_79);
    stringBuffer.append(ownerClassIdName);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(ownerClassIdName);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(named.getUrl(WebUrlName.input));
    stringBuffer.append(TEXT_82);
    stringBuffer.append(ownerClassIdPath);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(ownerClassIdName);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(named.getUrl(WebUrlName.edit));
    stringBuffer.append(TEXT_85);
    stringBuffer.append(ownerClassIdPath);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(ownerClassIdName);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(named.getUrl(WebUrlName.deleteOutJson));
    stringBuffer.append(TEXT_88);
    stringBuffer.append(ownerClassIdPath);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(ownerClassIdName);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(named.getUrl(WebUrlName.deleteAllOutJson));
    stringBuffer.append(TEXT_91);
    stringBuffer.append(ownerClassIdPath);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(ownerClassIdName);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(named.getUrl(WebUrlName.deleteDescendantOutJson));
    stringBuffer.append(TEXT_94);
    stringBuffer.append(ownerClassIdPath);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(ownerClassIdName);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(ownerClassCommentName);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(PageHelper.getWinWidth(uml2Class));
    stringBuffer.append(TEXT_98);
    stringBuffer.append(PageHelper.getWinHeight(uml2Class));
    stringBuffer.append(TEXT_99);
    stringBuffer.append(PageHelper.getWinWidth(uml2Class));
    stringBuffer.append(TEXT_100);
    stringBuffer.append(PageHelper.getWinHeight(uml2Class));
    stringBuffer.append(TEXT_101);
    stringBuffer.append(named.getUrl(WebUrlName.exportExcelFile));
    stringBuffer.append(TEXT_102);
    if(ServiceStereotypeUtil.isApplied_impExcel(uml2Class)){
    stringBuffer.append(TEXT_103);
    stringBuffer.append(PageHelper.getWinWidth(uml2Class));
    stringBuffer.append(TEXT_104);
    stringBuffer.append(PageHelper.getWinHeight(uml2Class));
    stringBuffer.append(TEXT_105);
    stringBuffer.append(named.getUrl(WebUrlName.importExcelFile));
    stringBuffer.append(TEXT_106);
    }
    
/*****************************************************************
 * rel O2MManagerPage
/*****************************************************************/


    List<Property> O2MManagerPageList=ViewInputHelper.getApplyO2MManagerPage(uml2Class);
    if(null!=O2MManagerPageList&&!O2MManagerPageList.isEmpty()){
    	for(Iterator<Property> iter=O2MManagerPageList.iterator();iter.hasNext();){
    		Property property=iter.next();
    		if(property.getName().equals(curProperty.getName())){
    			continue;
    		}
    		String propertyUncapSafeName=ModelHelper.getUncapName(property);
    		Type propertyType=property.getType();
    		Class relTargetClass=(Class)propertyType;
    		//String relTargetClassCapName=NameHelper.getCapName(relTargetClass);
    		//String relTargetClassUncapName=NameHelper.getUncapName(relTargetClass);
    		String relTargetClassCommentName=TypeHelper.getDocumentationOrName(relTargetClass);
    		String relO2MManager=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relO2MManager);
     		Property propertyTypeIdProperty=EntityHelper.getIDProperty(relTargetClass);
     		String propertyTypeIdPropertyUncapSafeName=NameHelper.uncapSafeName(propertyTypeIdProperty);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(relO2MManager);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(relO2MManager);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(relO2MManager);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(relO2MManager);
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
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(MdaHelper.getModelUrlByRel(relTargetClass,uml2Class,WebUrlName.relO2MManage));
    stringBuffer.append(TEXT_119);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(relO2MManager);
    stringBuffer.append(TEXT_122);
    	}
    }
    	}else{
    Property curProperty = (Property) argument;Package uml2Package = curProperty.getNearestPackage();
    //String curPropertyCapName=ModelHelper.getCapName(curProperty);
    //String curPropertyComment=ModelHelper.getComment(curProperty);
    Class ownerClass=(Class)curProperty.getOwner();
    //String ownerClassCapName=NameHelper.getCapName(ownerClass);
    //String ownerClassUnCapName=NameHelper.getUncapName(ownerClass);
    String ownerClassCommentName=TypeHelper.getDocumentationOrName(ownerClass);
    UmlClassByPropertyWrap named=new UmlClassByPropertyWrap(curProperty);
    Class uml2Class=ownerClass;
    stringBuffer.append(TEXT_123);
    stringBuffer.append(named.getUrl(WebUrlName.listOutJson));
    stringBuffer.append(TEXT_124);
    
Property idProperty=EntityHelper.getIDProperty(uml2Class);
Iterator<Property> simplePropertyList=ViewListHelper.getViewListPropertiesFromSimple(uml2Class).iterator();
Iterator<Property> m2oPropertyList=ViewListHelper.getViewListPropertiesFromM2o(uml2Class).iterator();
Iterator<Property> o2oPropertyList=ViewListHelper.getViewListPropertiesFromO2o(uml2Class).iterator();
boolean firstLine=true;

    for (;simplePropertyList.hasNext();){//process simpleProperty
    		Property property=simplePropertyList.next();
    		if(property.getName().equals(curProperty.getName())){
    			continue;
    		}
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
    stringBuffer.append(TEXT_125);
    if(firstLine){firstLine=false;}else{
    stringBuffer.append(TEXT_126);
    }
    stringBuffer.append(TEXT_127);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(width);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(sortable);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(modelEnumName);
    stringBuffer.append(TEXT_132);
    		}else{
    stringBuffer.append(TEXT_133);
    if(firstLine){firstLine=false;}else{
    stringBuffer.append(TEXT_134);
    }
    stringBuffer.append(TEXT_135);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(width);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(sortable);
    stringBuffer.append(TEXT_139);
    		}
    }
    for (;m2oPropertyList.hasNext();){//process m2oPropertyList
    		Property property=m2oPropertyList.next();
    		if(property.getName().equals(curProperty.getName())){
    			continue;
    		}
    		Class propertyType = (Class) property.getType();
     		String propertyTypeCommentName=TypeHelper.getDocumentationOrName(propertyType);
     		String propertyUncapSafeName=NameHelper.uncapSafeName(property);
     		int width=ViewListHelper.getViewListWidth(property);
     		boolean sortable=ViewListHelper.isSortable(property);
    		//rel list label
     		String listLabelPropertyUncapSafeName=ViewListHelper.getViewListLabelRelPropertyName(property);
     		String listLabelPropertyComment=ViewListHelper.getViewListLabelRelPropertyComment(property);
    stringBuffer.append(TEXT_140);
    if(firstLine){firstLine=false;}else{
    stringBuffer.append(TEXT_141);
    }
    stringBuffer.append(TEXT_142);
    stringBuffer.append(propertyTypeCommentName);
    stringBuffer.append(listLabelPropertyComment);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(width);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(sortable);
    stringBuffer.append(TEXT_147);
    }
    for (;o2oPropertyList.hasNext();){//process o2oPropertyList
    		Property property=o2oPropertyList.next();
    		if(property.getName().equals(curProperty.getName())){
    			continue;
    		}
    		Class propertyType = (Class) property.getType();
     		String propertyTypeCommentName=TypeHelper.getDocumentationOrName(propertyType);
     		String propertyUncapSafeName=NameHelper.uncapSafeName(property);
     		int width=ViewListHelper.getViewListWidth(property);
     		boolean sortable=ViewListHelper.isSortable(property);
    		//rel list label
     		String listLabelPropertyUncapSafeName=ViewListHelper.getViewListLabelRelPropertyName(property);
     		String listLabelPropertyComment=ViewListHelper.getViewListLabelRelPropertyComment(property);
    stringBuffer.append(TEXT_148);
    if(firstLine){firstLine=false;}else{
    stringBuffer.append(TEXT_149);
    }
    stringBuffer.append(TEXT_150);
    stringBuffer.append(propertyTypeCommentName);
    stringBuffer.append(listLabelPropertyComment);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(width);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(sortable);
    stringBuffer.append(TEXT_155);
    }
    stringBuffer.append(TEXT_156);
    stringBuffer.append(NameHelper.uncapSafeName(idProperty));
    stringBuffer.append(TEXT_157);
    stringBuffer.append(OrderByHelper.getOrderField(uml2Class));
    stringBuffer.append(TEXT_158);
    stringBuffer.append(OrderByHelper.getOrderMode(uml2Class));
    stringBuffer.append(TEXT_159);
    //code kind define
    List<Property> codeKindPropertiesList=EnumKindHelper.getPropertiesAppliedEnumKind(uml2Class);
    if(null!=codeKindPropertiesList&&codeKindPropertiesList.size()>0){
    	for(Property property:codeKindPropertiesList){
    		Enumeration enumeration=EnumKindHelper.getAppliedEnumKindEnumeration(property);
    		if(null!=enumeration){
    //			String modelEnumQualifiedName=MdaHelper.getModelQualifiedName(enumeration,PKGSuffix.enumeration,ModelNameSuffix.enumeration);
    			String modelEnumName=MdaHelper.getModelClassName(enumeration,ModelNameSuffix.enumeration);
    			String modelEnumJsoncapName=NamedUtil.getPropertyNamed(enumeration,PropertyNamedRuleKind.elementJsonNamed);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(modelEnumName);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(modelEnumJsoncapName);
    stringBuffer.append(TEXT_162);
    		}
    	}
    }
    stringBuffer.append(TEXT_163);
    List<Property> validatePropertyList=new ArrayList<Property>();
    stringBuffer.append(TEXT_164);
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
    stringBuffer.append(TEXT_165);
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
    stringBuffer.append(TEXT_166);
    if(i!=0){
    stringBuffer.append(TEXT_167);
    }
    stringBuffer.append(dateSearchStartUncapSafeName);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(jqueryValidate);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(++count);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(dateSearchEndNameUncapSafeName);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(jqueryValidate);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(++count);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(propertyCommentName);
    		}
    		else if(!ClassHelper.isSimple(property)&&null!=jqueryValidate&&!jqueryValidate.trim().equals("")){
     				//String propertySelectListKey=ViewInputHelper.getRelForListKey(property);
    				Class propertyType = (Class) property.getType();
    				//String propertyTypeComment = TypeHelper.getDocumentationOrName(propertyType);
     				Property propertyTypeIdProperty=EntityHelper.getIDProperty(propertyType);
     				String propertyTypeIdPropertyUncapSafeName=NameHelper.uncapSafeName(propertyTypeIdProperty);
    stringBuffer.append(TEXT_175);
    if(i!=0){
    stringBuffer.append(TEXT_176);
    }
    stringBuffer.append(TEXT_177);
    stringBuffer.append(NameHelper.getUncapName(property));
    stringBuffer.append(TEXT_178);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(jqueryValidate);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(++count);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_182);
    			}else{
    stringBuffer.append(TEXT_183);
    if(i!=0){
    stringBuffer.append(TEXT_184);
    }
    stringBuffer.append(NameHelper.getUncapName(property));
    stringBuffer.append(TEXT_185);
    stringBuffer.append(jqueryValidate);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(++count);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(propertyCommentName);
    			}
    		}
    stringBuffer.append(TEXT_188);
    	}
    stringBuffer.append(TEXT_189);
    }
    stringBuffer.append(TEXT_190);
    for (int i=0;i<searchPropertyList.size();i++){
    stringBuffer.append(TEXT_191);
    	Property property=searchPropertyList.get(i);
      if(ViewInputHelper.isViewInputDatePicker(property)){//process datePicker
     		String propertyUncapSafeName=NameHelper.uncapSafeName(property);
    		String dateSearchStartName=NamedUtil.getPropertyNamed(property,PropertyNamedRuleKind.dateSearchStartName);
     		String dateSearchStartUncapSafeName=NameHelper.uncapName(dateSearchStartName);
    		String dateSearchEndName=NamedUtil.getPropertyNamed(property,PropertyNamedRuleKind.dateSearchEndName);
     		String dateSearchEndNameUncapSafeName=NameHelper.uncapName(dateSearchEndName);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(dateSearchStartUncapSafeName);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(dateSearchEndNameUncapSafeName);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(dateSearchStartUncapSafeName);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(dateSearchEndNameUncapSafeName);
    stringBuffer.append(TEXT_197);
    	}
    stringBuffer.append(TEXT_198);
    }
    stringBuffer.append(TEXT_199);
    String ownerClassIdName=named.getValueNameWithUnderLine();
    String ownerClassIdPath=named.getValueName();
    stringBuffer.append(TEXT_200);
    stringBuffer.append(ownerClassIdName);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(ownerClassIdName);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(named.getUrl(WebUrlName.input));
    stringBuffer.append(TEXT_203);
    stringBuffer.append(ownerClassIdPath);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(ownerClassIdName);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(named.getUrl(WebUrlName.edit));
    stringBuffer.append(TEXT_206);
    stringBuffer.append(ownerClassIdPath);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(ownerClassIdName);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(named.getUrl(WebUrlName.deleteOutJson));
    stringBuffer.append(TEXT_209);
    stringBuffer.append(ownerClassIdPath);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(ownerClassIdName);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(named.getUrl(WebUrlName.deleteAllOutJson));
    stringBuffer.append(TEXT_212);
    stringBuffer.append(ownerClassIdPath);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(ownerClassIdName);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(named.getUrl(WebUrlName.deleteDescendantOutJson));
    stringBuffer.append(TEXT_215);
    stringBuffer.append(ownerClassIdPath);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(ownerClassIdName);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(ownerClassCommentName);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(MdaHelper.getModelUrl(uml2Class,WebUrlName.listTreeOutJson));
    stringBuffer.append(TEXT_219);
    stringBuffer.append(PageHelper.getWinWidth(uml2Class));
    stringBuffer.append(TEXT_220);
    stringBuffer.append(PageHelper.getWinHeight(uml2Class));
    stringBuffer.append(TEXT_221);
    stringBuffer.append(PageHelper.getWinWidth(uml2Class));
    stringBuffer.append(TEXT_222);
    stringBuffer.append(PageHelper.getWinHeight(uml2Class));
    stringBuffer.append(TEXT_223);
    stringBuffer.append(named.getUrl(WebUrlName.exportExcelFile));
    stringBuffer.append(TEXT_224);
    if(ServiceStereotypeUtil.isApplied_impExcel(uml2Class)){
    stringBuffer.append(TEXT_225);
    stringBuffer.append(PageHelper.getWinWidth(uml2Class));
    stringBuffer.append(TEXT_226);
    stringBuffer.append(PageHelper.getWinHeight(uml2Class));
    stringBuffer.append(TEXT_227);
    stringBuffer.append(named.getUrl(WebUrlName.importExcelFile));
    stringBuffer.append(TEXT_228);
    }
    
/*****************************************************************
 * rel O2MManagerPage
/*****************************************************************/


    List<Property> O2MManagerPageList=ViewInputHelper.getApplyO2MManagerPage(uml2Class);
    if(null!=O2MManagerPageList&&!O2MManagerPageList.isEmpty()){
    	for(Iterator<Property> iter=O2MManagerPageList.iterator();iter.hasNext();){
    		Property property=iter.next();
    		if(property.getName().equals(curProperty.getName())){
    			continue;
    		}
    		String propertyUncapSafeName=ModelHelper.getUncapName(property);
    		Type propertyType=property.getType();
    		Class relTargetClass=(Class)propertyType;
    		//String relTargetClassCapName=NameHelper.getCapName(relTargetClass);
    		//String relTargetClassUncapName=NameHelper.getUncapName(relTargetClass);
    		String relTargetClassCommentName=TypeHelper.getDocumentationOrName(relTargetClass);
    		String relO2MManager=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relO2MManager);
     		Property propertyTypeIdProperty=EntityHelper.getIDProperty(relTargetClass);
     		String propertyTypeIdPropertyUncapSafeName=NameHelper.uncapSafeName(propertyTypeIdProperty);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(relO2MManager);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(relO2MManager);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(relO2MManager);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(relO2MManager);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(relO2MManager);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(relO2MManager);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(relO2MManager);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(relO2MManager);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(relO2MManager);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(relO2MManager);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(MdaHelper.getModelUrlByRel(relTargetClass,uml2Class,WebUrlName.relO2MManage));
    stringBuffer.append(TEXT_241);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(relO2MManager);
    stringBuffer.append(TEXT_244);
    	}
    }
    	}
    }else{//只应用了Entity
    Property curProperty = (Property) argument;Package uml2Package = curProperty.getNearestPackage();
    Class ownerClass=(Class)curProperty.getOwner();
    String ownerClassCommentName=TypeHelper.getDocumentationOrName(ownerClass);
    UmlClassByPropertyWrap named=new UmlClassByPropertyWrap(curProperty);
    Class uml2Class=ownerClass;
    stringBuffer.append(TEXT_245);
    stringBuffer.append(named.getUrl(WebUrlName.listOutJson));
    stringBuffer.append(TEXT_246);
    
Property idProperty=EntityHelper.getIDProperty(uml2Class);
Iterator<Property> simplePropertyList=ViewListHelper.getViewListPropertiesFromSimple(uml2Class).iterator();
Iterator<Property> m2oPropertyList=ViewListHelper.getViewListPropertiesFromM2o(uml2Class).iterator();
Iterator<Property> o2oPropertyList=ViewListHelper.getViewListPropertiesFromO2o(uml2Class).iterator();
boolean firstLine=true;

    for (;simplePropertyList.hasNext();){//process simpleProperty
    		Property property=simplePropertyList.next();
    		if(property.getName().equals(curProperty.getName())){
    			continue;
    		}
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
    stringBuffer.append(TEXT_247);
    if(firstLine){firstLine=false;}else{
    stringBuffer.append(TEXT_248);
    }
    stringBuffer.append(TEXT_249);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(width);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(sortable);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(modelEnumName);
    stringBuffer.append(TEXT_254);
    		}else{
    stringBuffer.append(TEXT_255);
    if(firstLine){firstLine=false;}else{
    stringBuffer.append(TEXT_256);
    }
    stringBuffer.append(TEXT_257);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_258);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(width);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(sortable);
    stringBuffer.append(TEXT_261);
    		}
    }
    for (;m2oPropertyList.hasNext();){//process m2oPropertyList
    		Property property=m2oPropertyList.next();
    		if(property.getName().equals(curProperty.getName())){
    			continue;
    		}
    		Class propertyType = (Class) property.getType();
     		String propertyTypeCommentName=TypeHelper.getDocumentationOrName(propertyType);
     		String propertyUncapSafeName=NameHelper.uncapSafeName(property);
     		int width=ViewListHelper.getViewListWidth(property);
     		boolean sortable=ViewListHelper.isSortable(property);
     		//Property relM2OIdProperty=EntityHelper.getIDProperty(propertyType);
    		//String relM2OIdPropertyName=NameHelper.uncapSafeName(relM2OIdProperty);
     		String listLabelPropertyUncapSafeName=ViewListHelper.getViewListLabelRelPropertyName(property);
     		String listLabelPropertyComment=ViewListHelper.getViewListLabelRelPropertyComment(property);
    stringBuffer.append(TEXT_262);
    if(firstLine){firstLine=false;}else{
    stringBuffer.append(TEXT_263);
    }
    stringBuffer.append(TEXT_264);
    stringBuffer.append(propertyTypeCommentName);
    stringBuffer.append(listLabelPropertyComment);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(width);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(sortable);
    stringBuffer.append(TEXT_269);
    }
    for (;o2oPropertyList.hasNext();){//process o2oPropertyList
    		Property property=o2oPropertyList.next();
    		if(property.getName().equals(curProperty.getName())){
    			continue;
    		}
    		Class propertyType = (Class) property.getType();
     		String propertyTypeCommentName=TypeHelper.getDocumentationOrName(propertyType);
     		String propertyUncapSafeName=NameHelper.uncapSafeName(property);
     		int width=ViewListHelper.getViewListWidth(property);
     		boolean sortable=ViewListHelper.isSortable(property);
     		//Property relM2OIdProperty=EntityHelper.getIDProperty(propertyType);
    		//String relM2OIdPropertyName=NameHelper.uncapSafeName(relM2OIdProperty);
     		String listLabelPropertyUncapSafeName=ViewListHelper.getViewListLabelRelPropertyName(property);
     		String listLabelPropertyComment=ViewListHelper.getViewListLabelRelPropertyComment(property);
    stringBuffer.append(TEXT_270);
    if(firstLine){firstLine=false;}else{
    stringBuffer.append(TEXT_271);
    }
    stringBuffer.append(TEXT_272);
    stringBuffer.append(propertyTypeCommentName);
    stringBuffer.append(listLabelPropertyComment);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(width);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(sortable);
    stringBuffer.append(TEXT_277);
    }
    stringBuffer.append(TEXT_278);
    stringBuffer.append(NameHelper.uncapSafeName(idProperty));
    stringBuffer.append(TEXT_279);
    stringBuffer.append(OrderByHelper.getOrderField(uml2Class));
    stringBuffer.append(TEXT_280);
    stringBuffer.append(OrderByHelper.getOrderMode(uml2Class));
    stringBuffer.append(TEXT_281);
    //code kind define
    List<Property> codeKindPropertiesList=EnumKindHelper.getPropertiesAppliedEnumKind(uml2Class);
    if(null!=codeKindPropertiesList&&codeKindPropertiesList.size()>0){
    	for(Property property:codeKindPropertiesList){
    		Enumeration enumeration=EnumKindHelper.getAppliedEnumKindEnumeration(property);
    		if(null!=enumeration){
    //			String modelEnumQualifiedName=MdaHelper.getModelQualifiedName(enumeration,PKGSuffix.enumeration,ModelNameSuffix.enumeration);
    			String modelEnumName=MdaHelper.getModelClassName(enumeration,ModelNameSuffix.enumeration);
    			String modelEnumJsoncapName=NamedUtil.getPropertyNamed(enumeration,PropertyNamedRuleKind.elementJsonNamed);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(modelEnumName);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(modelEnumJsoncapName);
    stringBuffer.append(TEXT_284);
    		}
    	}
    }
    stringBuffer.append(TEXT_285);
    List<Property> validatePropertyList=new ArrayList<Property>();
    stringBuffer.append(TEXT_286);
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
    stringBuffer.append(TEXT_287);
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
    stringBuffer.append(TEXT_288);
    if(i!=0){
    stringBuffer.append(TEXT_289);
    }
    stringBuffer.append(dateSearchStartUncapSafeName);
    stringBuffer.append(TEXT_290);
    stringBuffer.append(jqueryValidate);
    stringBuffer.append(TEXT_291);
    stringBuffer.append(++count);
    stringBuffer.append(TEXT_292);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_293);
    stringBuffer.append(dateSearchEndNameUncapSafeName);
    stringBuffer.append(TEXT_294);
    stringBuffer.append(jqueryValidate);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(++count);
    stringBuffer.append(TEXT_296);
    stringBuffer.append(propertyCommentName);
    		}
    		else if(!ClassHelper.isSimple(property)&&null!=jqueryValidate&&!jqueryValidate.trim().equals("")){
     				//String propertySelectListKey=ViewInputHelper.getRelForListKey(property);
    				Class propertyType = (Class) property.getType();
    				//String propertyTypeComment = TypeHelper.getDocumentationOrName(propertyType);
     				Property propertyTypeIdProperty=EntityHelper.getIDProperty(propertyType);
     				String propertyTypeIdPropertyUncapSafeName=NameHelper.uncapSafeName(propertyTypeIdProperty);
    stringBuffer.append(TEXT_297);
    if(i!=0){
    stringBuffer.append(TEXT_298);
    }
    stringBuffer.append(TEXT_299);
    stringBuffer.append(NameHelper.getUncapName(property));
    stringBuffer.append(TEXT_300);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_301);
    stringBuffer.append(jqueryValidate);
    stringBuffer.append(TEXT_302);
    stringBuffer.append(++count);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_304);
    			}else{
    stringBuffer.append(TEXT_305);
    if(i!=0){
    stringBuffer.append(TEXT_306);
    }
    stringBuffer.append(NameHelper.getUncapName(property));
    stringBuffer.append(TEXT_307);
    stringBuffer.append(jqueryValidate);
    stringBuffer.append(TEXT_308);
    stringBuffer.append(++count);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(propertyCommentName);
    			}
    		}
    stringBuffer.append(TEXT_310);
    	}
    stringBuffer.append(TEXT_311);
    }
    stringBuffer.append(TEXT_312);
    for (int i=0;i<searchPropertyList.size();i++){
    stringBuffer.append(TEXT_313);
    	Property property=searchPropertyList.get(i);
      if(ViewInputHelper.isViewInputDatePicker(property)){//process datePicker
     		String propertyUncapSafeName=NameHelper.uncapSafeName(property);
    		String dateSearchStartName=NamedUtil.getPropertyNamed(property,PropertyNamedRuleKind.dateSearchStartName);
     		String dateSearchStartUncapSafeName=NameHelper.uncapName(dateSearchStartName);
    		String dateSearchEndName=NamedUtil.getPropertyNamed(property,PropertyNamedRuleKind.dateSearchEndName);
     		String dateSearchEndNameUncapSafeName=NameHelper.uncapName(dateSearchEndName);
    stringBuffer.append(TEXT_314);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_315);
    stringBuffer.append(dateSearchStartUncapSafeName);
    stringBuffer.append(TEXT_316);
    stringBuffer.append(dateSearchEndNameUncapSafeName);
    stringBuffer.append(TEXT_317);
    stringBuffer.append(dateSearchStartUncapSafeName);
    stringBuffer.append(TEXT_318);
    stringBuffer.append(dateSearchEndNameUncapSafeName);
    stringBuffer.append(TEXT_319);
    	}
    }
    String byPropertyIdName=named.getValueNameWithUnderLine();
    String byPropertyIdPath=named.getValueName();
    stringBuffer.append(TEXT_320);
    stringBuffer.append(byPropertyIdName);
    stringBuffer.append(TEXT_321);
    stringBuffer.append(byPropertyIdName);
    stringBuffer.append(TEXT_322);
    stringBuffer.append(named.getUrl(WebUrlName.input));
    stringBuffer.append(TEXT_323);
    stringBuffer.append(byPropertyIdPath);
    stringBuffer.append(TEXT_324);
    stringBuffer.append(byPropertyIdName);
    stringBuffer.append(TEXT_325);
    stringBuffer.append(named.getUrl(WebUrlName.edit));
    stringBuffer.append(TEXT_326);
    stringBuffer.append(byPropertyIdPath);
    stringBuffer.append(TEXT_327);
    stringBuffer.append(byPropertyIdName);
    stringBuffer.append(TEXT_328);
    stringBuffer.append(named.getUrl(WebUrlName.deleteOutJson));
    stringBuffer.append(TEXT_329);
    stringBuffer.append(byPropertyIdPath);
    stringBuffer.append(TEXT_330);
    stringBuffer.append(byPropertyIdName);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(named.getUrl(WebUrlName.deleteAllOutJson));
    stringBuffer.append(TEXT_332);
    stringBuffer.append(byPropertyIdPath);
    stringBuffer.append(TEXT_333);
    stringBuffer.append(byPropertyIdName);
    stringBuffer.append(TEXT_334);
    stringBuffer.append(ownerClassCommentName);
    stringBuffer.append(TEXT_335);
    stringBuffer.append(PageHelper.getWinWidth(uml2Class));
    stringBuffer.append(TEXT_336);
    stringBuffer.append(PageHelper.getWinHeight(uml2Class));
    stringBuffer.append(TEXT_337);
    stringBuffer.append(PageHelper.getWinWidth(uml2Class));
    stringBuffer.append(TEXT_338);
    stringBuffer.append(PageHelper.getWinHeight(uml2Class));
    stringBuffer.append(TEXT_339);
    if(ServiceStereotypeUtil.isApplied_impExcel(uml2Class)){
    stringBuffer.append(TEXT_340);
    stringBuffer.append(named.getUrl(WebUrlName.exportExcelFile));
    stringBuffer.append(TEXT_341);
    stringBuffer.append(PageHelper.getWinWidth(uml2Class));
    stringBuffer.append(TEXT_342);
    stringBuffer.append(PageHelper.getWinHeight(uml2Class));
    stringBuffer.append(TEXT_343);
    stringBuffer.append(named.getUrl(WebUrlName.importExcelFile));
    stringBuffer.append(TEXT_344);
    }
    
/*****************************************************************
 * rel O2MManagerPage
/*****************************************************************/

    List<Property> O2MManagerPageList=ViewInputHelper.getApplyO2MManagerPage(uml2Class);
    if(null!=O2MManagerPageList&&!O2MManagerPageList.isEmpty()){
    	for(Iterator<Property> iter=O2MManagerPageList.iterator();iter.hasNext();){
    		Property property=iter.next();
    		if(property.getName().equals(curProperty.getName())){
    			continue;
    		}
    		String propertyUncapSafeName=ModelHelper.getUncapName(property);
    		Type propertyType=property.getType();
    		Class relTargetClass=(Class)propertyType;
    		//String relTargetClassCapName=NameHelper.getCapName(relTargetClass);
    		//String relTargetClassUncapName=NameHelper.getUncapName(relTargetClass);
    		String relTargetClassCommentName=TypeHelper.getDocumentationOrName(relTargetClass);
    		String relO2MManager=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relO2MManager);
     		Property propertyTypeIdProperty=EntityHelper.getIDProperty(relTargetClass);
     		String propertyTypeIdPropertyUncapSafeName=NameHelper.uncapSafeName(propertyTypeIdProperty);
    stringBuffer.append(TEXT_345);
    stringBuffer.append(relO2MManager);
    stringBuffer.append(TEXT_346);
    stringBuffer.append(relO2MManager);
    stringBuffer.append(TEXT_347);
    stringBuffer.append(relO2MManager);
    stringBuffer.append(TEXT_348);
    stringBuffer.append(relO2MManager);
    stringBuffer.append(TEXT_349);
    stringBuffer.append(relO2MManager);
    stringBuffer.append(TEXT_350);
    stringBuffer.append(relO2MManager);
    stringBuffer.append(TEXT_351);
    stringBuffer.append(relO2MManager);
    stringBuffer.append(TEXT_352);
    stringBuffer.append(relO2MManager);
    stringBuffer.append(TEXT_353);
    stringBuffer.append(relO2MManager);
    stringBuffer.append(TEXT_354);
    stringBuffer.append(relO2MManager);
    stringBuffer.append(TEXT_355);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_356);
    stringBuffer.append(MdaHelper.getModelUrlByRel(relTargetClass,uml2Class,WebUrlName.relO2MManage));
    stringBuffer.append(TEXT_357);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_358);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_359);
    stringBuffer.append(relO2MManager);
    stringBuffer.append(TEXT_360);
    	}
    }
    }
    stringBuffer.append(TEXT_361);
    return stringBuffer.toString();
  }
}
