package com.jeefuse.mda.gen.template.main.java.action;

import net.taylor.mda.generator.parse.NameRuled.nameRuled.*;
import net.taylor.mda.generator.parse.NameRuled.*;
import net.taylor.mda.generator.parse.NameRuled.className.*;
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

public class EntityStrutsActionManageByPropertyProxy
{
  protected static String nl;
  public static synchronized EntityStrutsActionManageByPropertyProxy create(String lineSeparator)
  {
    nl = lineSeparator;
    EntityStrutsActionManageByPropertyProxy result = new EntityStrutsActionManageByPropertyProxy();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "/*" + NL + " * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the \"License\")" + NL + " * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms." + NL + " * email:yonclv@gmail.com" + NL + " */" + NL + "package ";
  protected final String TEXT_2 = ";";
  protected final String TEXT_3 = NL + NL + "/**" + NL + " * ";
  protected final String TEXT_4 = " by ";
  protected final String TEXT_5 = " Entity CRUD action." + NL + " *" + NL + " * @author ";
  protected final String TEXT_6 = NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_7 = " extends BaseAction implements ModelDriven<";
  protected final String TEXT_8 = "> {" + NL + "\t/** @generated */" + NL + "\tprivate static final long serialVersionUID = 1L;" + NL + "\t" + NL + "\t" + NL + "\t/**" + NL + "\t * ";
  protected final String TEXT_9 = " Entity CRUD service." + NL + "\t * @generated" + NL + "\t */" + NL + "\t@Autowired" + NL + "\tprivate ";
  protected final String TEXT_10 = " ";
  protected final String TEXT_11 = ";" + NL + "\t" + NL + "\t/*****************************************************************" + NL + "\t * property define" + NL + "\t/*****************************************************************/" + NL + "" + NL + "\t/** @generated */" + NL + "\tprivate Page<";
  protected final String TEXT_12 = "> page=null;" + NL + "\t/** @generated */" + NL + "\tprivate ";
  protected final String TEXT_13 = " mo=null;" + NL + "\t/** @generated */" + NL + "\tprivate ";
  protected final String TEXT_14 = " rto=null;" + NL + "" + NL + "\t/** @generated */" + NL + "\tpublic Page<";
  protected final String TEXT_15 = "> getPage() {" + NL + "\t\tif(null==page)" + NL + "\t\t\tpage=new Page<";
  protected final String TEXT_16 = ">();" + NL + "\t\treturn page;" + NL + "\t}" + NL + "" + NL + "\t/** @generated */" + NL + "\tpublic ";
  protected final String TEXT_17 = " getModel() {" + NL + "\t\tif(null==rto)" + NL + "\t\t\trto = new ";
  protected final String TEXT_18 = "();" + NL + "\t\treturn rto;" + NL + "\t}" + NL + "\t" + NL + "\t/** @generated */" + NL + "\tpublic ";
  protected final String TEXT_19 = " getMo() {" + NL + "\t\tif (null == mo) {" + NL + "\t\t\tmo = new ";
  protected final String TEXT_20 = "();" + NL + "\t\t}" + NL + "\t\treturn mo;" + NL + "\t}" + NL + "\t\t" + NL + "\t/************************************************************************" + NL + "\t * request function invoke" + NL + "\t ************************************************************************/" + NL + "" + NL + "\t/**" + NL + "\t * 转向管理页面." + NL + "\t * " + NL + " \t * @generated" + NL + "\t */" + NL + "\tpublic String manage() {" + NL + "\t\ttry {" + NL + "\t\t\tif (SecurityHolder.isUserNoLogin())" + NL + "\t\t\t\treturn LOGIN;" + NL + "\t\t\treturn SUCCESS;" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tSysLogger.appError(e.getMessage(), e,getRequest());" + NL + "\t\t\treturn ERROR;" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\treturn ERROR;" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * 获取Entity列表.返回json格式." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void listOutJson() {" + NL + "\t\ttry {" + NL + "\t\t\tOrder[] orders = RequestUtil.buildOrders(getRequest());" + NL + "\t\t\tpage = ";
  protected final String TEXT_21 = ".findDescendantBy";
  protected final String TEXT_22 = "(page, rto, orders);" + NL + "\t\t\t";
  protected final String TEXT_23 = ".jsonFlexiGridBy";
  protected final String TEXT_24 = "(page);" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tSysLogger.appError(e.getMessage(), e,getRequest());" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError(e.getMessage());" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * 获取Entity列表.返回json格式." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void listTreeGridOutJson() {" + NL + "\t\ttry {" + NL + "\t\t\tOrder[] orders = RequestUtil.buildOrders(getRequest());" + NL + "\t\t\tpage = ";
  protected final String TEXT_25 = ".findDescendantBy";
  protected final String TEXT_26 = "(page, rto, orders);" + NL + "\t\t\t";
  protected final String TEXT_27 = ".jsonFlexiTreeGridBy";
  protected final String TEXT_28 = "(page);" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tSysLogger.appError(e.getMessage(), e,getRequest());" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError(e.getMessage());" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError();" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\tpublic void listTreeOutJson() {" + NL + "\t\ttry {";
  protected final String TEXT_29 = NL + "\t\t\tList<TreeViewItem> list = ";
  protected final String TEXT_30 = ".getAllForTreeviewBy";
  protected final String TEXT_31 = "(null);" + NL + "\t\t\tTreeRenderUtil.jsonTreeview(list,\"所有";
  protected final String TEXT_32 = "\");" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tSysLogger.appError(e.getMessage(), e,getRequest());" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError(e.getMessage());" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * 根据ID获取Entity对象,返回json格式." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void getOutJson() {" + NL + "\t\ttry {" + NL + "\t\t\tAppAssert.notNull(getModel().getId());" + NL + "\t\t\tmo = ";
  protected final String TEXT_33 = ".get(getModel().getId());" + NL + "\t\t\t";
  protected final String TEXT_34 = ".jsonResultMsgBy";
  protected final String TEXT_35 = "(true, mo, null);" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tSysLogger.appError(e.getMessage(), e,getRequest());" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError(e.getMessage());" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError();" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\tprivate String htmlSelectTree;// 构造Html select 树";
  protected final String TEXT_36 = NL + "\t" + NL;
  protected final String TEXT_37 = NL + "\tprivate static final String ";
  protected final String TEXT_38 = " = \"";
  protected final String TEXT_39 = "\";//rel ";
  protected final String TEXT_40 = " for checkboxs" + NL + "\tprivate String ";
  protected final String TEXT_41 = ";";
  protected final String TEXT_42 = NL + "\tprivate String ";
  protected final String TEXT_43 = ";// rel ";
  protected final String TEXT_44 = " for Treeview";
  protected final String TEXT_45 = NL + "\t/**根据主键获取Entity,并转向修改页面." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic String edit() {" + NL + "\t\ttry {";
  protected final String TEXT_46 = NL + "\t\t\tList<TreeViewItem> list = ";
  protected final String TEXT_47 = ".getAllForTreeviewBy";
  protected final String TEXT_48 = "(null);" + NL + "\t\t\tString parentId = null;" + NL + "\t\t\tif (StringUtils.isBlank(getModel().getId())) {" + NL + "\t\t\t\tif (StringUtils.isNotBlank(getModel().getParentId())) {" + NL + "\t\t\t\t\tparentId = rto.getParentId();" + NL + "\t\t\t\t}";
  protected final String TEXT_49 = "\t\t\t\t";
  protected final String TEXT_50 = "\t";
  protected final String TEXT_51 = "\t\t";
  protected final String TEXT_52 = "\t\t\t";
  protected final String TEXT_53 = NL + "\t\t\t\t// rel ";
  protected final String TEXT_54 = " for checkboxs" + NL + "\t\t\t\tList<KeyLabel> ";
  protected final String TEXT_55 = " = ";
  protected final String TEXT_56 = ".get";
  protected final String TEXT_57 = "().";
  protected final String TEXT_58 = "();" + NL + "\t\t\t\t";
  protected final String TEXT_59 = " = KeyLabelRenderUtil.renderHtmlCheckboxs(";
  protected final String TEXT_60 = ", null,";
  protected final String TEXT_61 = " );";
  protected final String TEXT_62 = "\t";
  protected final String TEXT_63 = "\t\t";
  protected final String TEXT_64 = NL + "\t\t\t\t// rel ";
  protected final String TEXT_65 = " for Treeview" + NL + "\t\t\t\tList<TreeViewItem> ";
  protected final String TEXT_66 = " = ";
  protected final String TEXT_67 = ".get";
  protected final String TEXT_68 = "().";
  protected final String TEXT_69 = "();" + NL + "\t\t\t\t";
  protected final String TEXT_70 = " =TreeRenderUtil.jsonTreeviewShowCheckString(";
  protected final String TEXT_71 = ", null);";
  protected final String TEXT_72 = NL + "\t\t\t} else {" + NL + "\t\t\t\tmo = ";
  protected final String TEXT_73 = ".get(rto.getId());";
  protected final String TEXT_74 = NL + "\t\t\t\tChangeUtil.excludeTreeIds(list, mo.getId());" + NL + "\t\t\t\tparentId = mo.getParentId();";
  protected final String TEXT_75 = "\t\t\t\t";
  protected final String TEXT_76 = "\t";
  protected final String TEXT_77 = "\t\t";
  protected final String TEXT_78 = "\t";
  protected final String TEXT_79 = "\t";
  protected final String TEXT_80 = "\t\t";
  protected final String TEXT_81 = NL + "\t\t\t\t// rel ";
  protected final String TEXT_82 = " for checkboxs" + NL + "\t\t\t\tList<KeyLabel> ";
  protected final String TEXT_83 = " = ";
  protected final String TEXT_84 = ".get";
  protected final String TEXT_85 = "().";
  protected final String TEXT_86 = "();" + NL + "\t\t\t\tList<String> ";
  protected final String TEXT_87 = " =  ";
  protected final String TEXT_88 = ".get";
  protected final String TEXT_89 = "().";
  protected final String TEXT_90 = "(mo.getId());" + NL + "\t\t\t\t";
  protected final String TEXT_91 = " = KeyLabelRenderUtil.renderHtmlCheckboxs(";
  protected final String TEXT_92 = ",";
  protected final String TEXT_93 = ", ";
  protected final String TEXT_94 = ");";
  protected final String TEXT_95 = "\t\t\t\t";
  protected final String TEXT_96 = "\t";
  protected final String TEXT_97 = "\t\t";
  protected final String TEXT_98 = "\t";
  protected final String TEXT_99 = "\t\t";
  protected final String TEXT_100 = NL + "\t\t\t\t// rel ";
  protected final String TEXT_101 = " for Treeview" + NL + "\t\t\t\tList<TreeViewItem> ";
  protected final String TEXT_102 = " = ";
  protected final String TEXT_103 = ".get";
  protected final String TEXT_104 = "().";
  protected final String TEXT_105 = "();" + NL + "\t\t\t\tList<String> ";
  protected final String TEXT_106 = " = ";
  protected final String TEXT_107 = ".get";
  protected final String TEXT_108 = "().";
  protected final String TEXT_109 = "(mo.getId());" + NL + "\t\t\t\t";
  protected final String TEXT_110 = " =TreeRenderUtil.jsonTreeviewShowCheckString(";
  protected final String TEXT_111 = ", ";
  protected final String TEXT_112 = ");";
  protected final String TEXT_113 = NL + "\t\t\t}";
  protected final String TEXT_114 = NL + "\t\t\thtmlSelectTree = TreeRenderUtil.renderHtmlTreeSelect(list, parentId);" + NL + "\t\t\treturn SUCCESS;" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tSysLogger.appError(e.getMessage(), e,getRequest());" + NL + "\t\t\treturn ERROR;" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\treturn ERROR;" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * 保存或更新Entity,返回json格式." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void saveOutJson() {" + NL + "\t\ttry {";
  protected final String TEXT_115 = "\t\t" + NL + "\t\t\tAssert.notNull(getModel());" + NL + "\t\t\tString ";
  protected final String TEXT_116 = " = getModel().";
  protected final String TEXT_117 = ";" + NL + "\t\t\tAppAssert.isNotblank(";
  protected final String TEXT_118 = ", \"未指定";
  protected final String TEXT_119 = "\");";
  protected final String TEXT_120 = "\t";
  protected final String TEXT_121 = "\t" + NL + "\t\t\tString[] ";
  protected final String TEXT_122 = " = ChangeUtil.stringToArray(getModel().";
  protected final String TEXT_123 = "(), true);";
  protected final String TEXT_124 = "\t\t\t";
  protected final String TEXT_125 = NL + "\t\t\tmo = ";
  protected final String TEXT_126 = ".save(getModel()";
  protected final String TEXT_127 = ");" + NL + "\t\t\t";
  protected final String TEXT_128 = ".jsonResultMsgBy";
  protected final String TEXT_129 = "(true, mo, \"新增成功!\");" + NL + "\t\t\treturn;" + NL + "\t\t} catch (InvalidStateException e) {";
  protected final String TEXT_130 = NL + "\t\t\tString invalidateMsg = ";
  protected final String TEXT_131 = ".getValidateMessageWithHtmlBR(e.getInvalidValues());" + NL + "\t\t\tlogger.error(invalidateMsg, e);" + NL + "\t\t\tSysLogger.appError(e.getMessage(), e,getRequest());" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError(invalidateMsg);" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tSysLogger.appError(e.getMessage(), e,getRequest());" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError(e.getMessage());" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * 更新Entity,返回json格式." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void updateOutJson() {" + NL + "\t\ttry {";
  protected final String TEXT_132 = NL + "\t\t\tString ";
  protected final String TEXT_133 = " = getModel().";
  protected final String TEXT_134 = ";" + NL + "\t\t\tAppAssert.isNotblank(";
  protected final String TEXT_135 = ", \"未指定";
  protected final String TEXT_136 = "\");";
  protected final String TEXT_137 = "\t";
  protected final String TEXT_138 = "\t" + NL + "\t\t\tString[] ";
  protected final String TEXT_139 = " = ChangeUtil.stringToArray(getModel().";
  protected final String TEXT_140 = "(), true);";
  protected final String TEXT_141 = "\t\t\t";
  protected final String TEXT_142 = NL + "\t\t\tmo = ";
  protected final String TEXT_143 = ".update(getModel()";
  protected final String TEXT_144 = ");" + NL + "\t\t\t";
  protected final String TEXT_145 = ".jsonResultMsgBy";
  protected final String TEXT_146 = "(true, mo, \"更新成功!\");" + NL + "\t\t\treturn; " + NL + "\t\t} catch (InvalidStateException e) {" + NL + "\t\t\tString invalidateMsg = ";
  protected final String TEXT_147 = ".getValidateMessageWithHtmlBR(e.getInvalidValues());" + NL + "\t\t\tlogger.error(invalidateMsg, e);" + NL + "\t\t\tSysLogger.appError(e.getMessage(), e,getRequest());" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError(invalidateMsg);" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tSysLogger.appError(e.getMessage(), e,getRequest());" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError(e.getMessage());" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * 删除Entity,返回json格式." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void deleteOutJson() {" + NL + "\t\ttry {" + NL + "\t\t\tAppAssert.notNull(getModel().getId(), \"未指定删除的对象!\");" + NL + "\t\t\tfinal String[] delIds = StringUtils.split(getModel().getId(), \",\");" + NL + "\t\t\tint delCount = ";
  protected final String TEXT_148 = ".delete(delIds);" + NL + "\t\t\tString msg = delCount == 0?\"无记录删除!\":\"删除成功\" + delCount + \"项记录!\";" + NL + "\t\t\tRenderUtil.renderJsonResultMsgSuccess(msg);" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tSysLogger.appError(e.getMessage(), e,getRequest());" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError(e.getMessage());" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * 删除当前对象及后代对象." + NL + "\t */" + NL + "\tpublic void deleteDescendantOutJson() {" + NL + "\t\ttry {" + NL + "\t\t\tAppAssert.notNull(getModel().getId(), \"未指定删除的对象!\");" + NL + "\t\t\tfinal String[] delIds = StringUtils.split(getModel().getId(), \",\");" + NL + "\t\t\tint delCount = ";
  protected final String TEXT_149 = ".deleteDescendant(delIds);" + NL + "\t\t\tString msg = delCount == 0 ? \"无记录删除!\" : \"删除成功\" + delCount + \"项记录!\";" + NL + "\t\t\tRenderUtil.renderJsonResultMsgSuccess(msg);" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tSysLogger.appError(e.getMessage(), e,getRequest());" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError(e.getMessage());" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * 删除所有Entity,返回json格式." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void deleteAllOutJson() {" + NL + "\t\ttry {" + NL + "\t\t\tString ";
  protected final String TEXT_150 = " = getModel().";
  protected final String TEXT_151 = ";" + NL + "\t\t\tAppAssert.isNotblank(";
  protected final String TEXT_152 = ", \"未指定";
  protected final String TEXT_153 = "\");" + NL + "\t\t\tint delCount = ";
  protected final String TEXT_154 = ".deleteAllBy";
  protected final String TEXT_155 = "(";
  protected final String TEXT_156 = ");" + NL + "\t\t\tString msg = delCount == 0?\"无记录删除!\":\"删除成功\" + delCount + \"项记录!\";" + NL + "\t\t\tRenderUtil.renderJsonResultMsgSuccess(msg);" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError(e.getMessage());" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError();" + NL + "\t\t}" + NL + "\t}" + NL;
  protected final String TEXT_157 = NL + "\t/**" + NL + "\t * 导出 Excel 文件." + NL + "     * @generated" + NL + "\t */" + NL + "\tpublic void exportExcelFile() {" + NL + "\t\ttry {" + NL + "\t\t\tOrder[] orders = RequestUtil.buildOrders(getRequest());" + NL + "\t\t\tpage = ";
  protected final String TEXT_158 = ".find(getPage(), getModel(), orders);" + NL + "\t\t\t";
  protected final String TEXT_159 = ".excelExportAllField(getResponse(), getPage().getResult());" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t}" + NL + "\t}" + NL;
  protected final String TEXT_160 = NL + "\t/**" + NL + "\t * 导入excel文件." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic String importExcelFile() {" + NL + "\t\ttry {" + NL + "\t\t\tif (SecurityHolder.isUserNoLogin())" + NL + "\t\t\t\treturn NO_LOGIN;" + NL + "\t\t\treturn SUCCESS;" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\treturn ERROR;" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * 导入excel 文件处理." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void ";
  protected final String TEXT_161 = "() {" + NL + "" + NL + "\t\ttry {" + NL + "\t\t\tif (SecurityHolder.isUserNoLogin()) {" + NL + "\t\t\t\tRenderUtil.renderJsonNoLogin();" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\tList<File> fileList = StrutsWebFileUtil.getUploadFile(getRequest());" + NL + "\t\t\tif (!fileList.isEmpty()) {" + NL + "\t\t\t\tList<";
  protected final String TEXT_162 = "> importModelList = ";
  protected final String TEXT_163 = ".excelToModel(fileList.get(0));";
  protected final String TEXT_164 = "\t" + NL + "\t\t\t\tResultMsg<";
  protected final String TEXT_165 = "> resultMsg =";
  protected final String TEXT_166 = ".";
  protected final String TEXT_167 = "(importModelList);" + NL + "\t\t\t\tRenderUtil.renderHtml(resultMsg.getMessage());" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\tRenderUtil.renderHtml(\"请上传需要导入的excel文件!\");" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tSysLogger.appError(e.getMessage(), e,getRequest());" + NL + "\t\t\tRenderUtil.renderHtml(e.getMessage());" + NL + "\t\t} catch (IOException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tSysLogger.appError(e.getMessage(), e,getRequest());" + NL + "\t\t\tRenderUtil.renderHtml(\"导入失败!文件加载错误!\");" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderHtml(\"导入失败!\");" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\t";
  protected final String TEXT_168 = "\t";
  protected final String TEXT_169 = NL + NL + "\t/** @generated */" + NL + "\tpublic String get";
  protected final String TEXT_170 = "() {" + NL + "\t\treturn ";
  protected final String TEXT_171 = ".toHtmlSelect(null == mo ? null : mo.";
  protected final String TEXT_172 = "());" + NL + "\t}";
  protected final String TEXT_173 = NL + "\t/** @generated */" + NL + "\tpublic String get";
  protected final String TEXT_174 = "() {" + NL + "\t\treturn ";
  protected final String TEXT_175 = ".toHtmlJSON;" + NL + "\t}";
  protected final String TEXT_176 = NL + "\t";
  protected final String TEXT_177 = "\t" + NL + "\tpublic String get";
  protected final String TEXT_178 = "() {" + NL + "\t";
  protected final String TEXT_179 = NL + "\t\tif (null == ";
  protected final String TEXT_180 = ")" + NL + "\t\t\treturn \"{}\";" + NL + "\t";
  protected final String TEXT_181 = NL + "\t\treturn ";
  protected final String TEXT_182 = ";" + NL + "\t}";
  protected final String TEXT_183 = "\t";
  protected final String TEXT_184 = "\t" + NL + "}";
  protected final String TEXT_185 = NL;
  protected final String TEXT_186 = "/*" + NL + " * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the \"License\")" + NL + " * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms." + NL + " * email:yonclv@gmail.com" + NL + " */" + NL + "package ";
  protected final String TEXT_187 = ";";
  protected final String TEXT_188 = NL + NL + "/**" + NL + " * ";
  protected final String TEXT_189 = " by ";
  protected final String TEXT_190 = " Entity CRUD action." + NL + " *" + NL + " * @author ";
  protected final String TEXT_191 = NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_192 = " extends BaseAction implements ModelDriven<";
  protected final String TEXT_193 = "> {" + NL + "\t/** @generated */" + NL + "\tprivate static final long serialVersionUID = 1L;" + NL + "\t" + NL + "\t/**" + NL + "\t * ";
  protected final String TEXT_194 = " Entity CRUD service." + NL + "\t * @generated" + NL + "\t */" + NL + "\t@Autowired" + NL + "\tprivate ";
  protected final String TEXT_195 = " ";
  protected final String TEXT_196 = ";" + NL + "\t" + NL + "\t/*****************************************************************" + NL + "\t * property define" + NL + "\t/*****************************************************************/" + NL + "" + NL + "\t/** @generated */" + NL + "\tprivate Page<";
  protected final String TEXT_197 = "> page=null;" + NL + "\t/** @generated */" + NL + "\tprivate ";
  protected final String TEXT_198 = " mo=null;" + NL + "\t/** @generated */" + NL + "\tprivate ";
  protected final String TEXT_199 = " rto=null;" + NL + "" + NL + "" + NL + "\t/** @generated */" + NL + "\tpublic Page<";
  protected final String TEXT_200 = "> getPage() {" + NL + "\t\tif(null==page)" + NL + "\t\t\tpage=new Page<";
  protected final String TEXT_201 = ">();" + NL + "\t\treturn page;" + NL + "\t}" + NL + "" + NL + "\t/** @generated */" + NL + "\tpublic ";
  protected final String TEXT_202 = " getModel() {" + NL + "\t\tif(null==rto)" + NL + "\t\t\trto = new ";
  protected final String TEXT_203 = "();" + NL + "\t\treturn rto;" + NL + "\t}" + NL + "\t" + NL + "\t/** @generated */" + NL + "\tpublic ";
  protected final String TEXT_204 = " getMo() {" + NL + "\t\tif (null == mo) {" + NL + "\t\t\tmo = new ";
  protected final String TEXT_205 = "();" + NL + "\t\t}" + NL + "\t\treturn mo;" + NL + "\t}" + NL + "" + NL + "\t/************************************************************************" + NL + "\t * request function invoke" + NL + "\t ************************************************************************/" + NL + "" + NL + "\t/**" + NL + "\t * 转向管理页面." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic String manage() {" + NL + "\t\t\t\ttry {" + NL + "\t\t\tif (SecurityHolder.isUserNoLogin())" + NL + "\t\t\t\treturn LOGIN;" + NL + "\t\t\treturn SUCCESS;" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tSysLogger.appError(e.getMessage(), e,getRequest());" + NL + "\t\t\treturn ERROR;" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\treturn ERROR;" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * 获取Entity列表.返回json格式." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void listOutJson() {" + NL + "\t\ttry {" + NL + "\t\t\tif (SecurityHolder.isUserNoLogin()) {" + NL + "\t\t\t\tRenderUtil.renderJsonNoLogin();" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\tString ";
  protected final String TEXT_206 = " = getModel().";
  protected final String TEXT_207 = ";" + NL + "\t\t\tAppAssert.isNotblank(";
  protected final String TEXT_208 = ", \"未指定";
  protected final String TEXT_209 = "\");" + NL + "\t\t\tOrder[] orders = RequestUtil.buildOrders(getRequest());" + NL + "\t\t\tpage=";
  protected final String TEXT_210 = ".findBy";
  protected final String TEXT_211 = "(";
  protected final String TEXT_212 = ",getPage(), getModel(), orders);" + NL + "\t\t\t";
  protected final String TEXT_213 = ".jsonFlexiGridBy";
  protected final String TEXT_214 = "(page);" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tSysLogger.appError(e.getMessage(), e,getRequest());" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError(e.getMessage());" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError();" + NL + "\t\t}" + NL + "\t}" + NL;
  protected final String TEXT_215 = "\t" + NL + "\t/** @generated */" + NL + "\tprivate List<";
  protected final String TEXT_216 = "> ";
  protected final String TEXT_217 = "List = null;";
  protected final String TEXT_218 = "\t" + NL + "\t" + NL + "\t/**" + NL + "\t * 图片Gallary展示." + NL + "\t * " + NL + "\t */" + NL + "\tpublic String gallaryView() {" + NL + "\t\ttry {" + NL + "\t\t\t";
  protected final String TEXT_219 = "List= ";
  protected final String TEXT_220 = ".getGallaryList(null);//.findByGlDiningMenu(getPage(), getModel(), null);" + NL + "\t\t\treturn SUCCESS;" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tSysLogger.appError(e.getMessage(), e,getRequest());" + NL + "\t\t\taddActionError(e.getMessage());" + NL + "\t\t\treturn ERROR;" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\treturn ERROR;" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_221 = NL + NL + "\t/**" + NL + "\t * 根据ID获取Entity对象,返回json格式." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void getOutJson() {" + NL + "\t\ttry {" + NL + "\t\t\tAppAssert.notNull(getModel().getId());" + NL + "\t\t\tmo = ";
  protected final String TEXT_222 = ".get(getModel().getId());" + NL + "\t\t\t";
  protected final String TEXT_223 = ".jsonResultMsg(true, mo, null);" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError(e.getMessage());" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError();" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_224 = NL + "\tprivate static final String ";
  protected final String TEXT_225 = " = \"";
  protected final String TEXT_226 = "\";//rel ";
  protected final String TEXT_227 = " for checkboxs" + NL + "\tprivate String ";
  protected final String TEXT_228 = ";";
  protected final String TEXT_229 = NL + "\tprivate String ";
  protected final String TEXT_230 = ";// rel ";
  protected final String TEXT_231 = " for Treeview";
  protected final String TEXT_232 = NL + "\t/**根据主键获取Entity,并转向修改页面." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic String edit() {" + NL + "\t\ttry {" + NL + "\t\t\tif (SecurityHolder.isUserNoLogin())" + NL + "\t\t\t\treturn NO_LOGIN;" + NL + "\t\t\tif (StringUtils.isBlank(getModel().getId())) {";
  protected final String TEXT_233 = "\t\t\t\t";
  protected final String TEXT_234 = "\t";
  protected final String TEXT_235 = "\t\t";
  protected final String TEXT_236 = "\t\t\t";
  protected final String TEXT_237 = NL + "\t\t\t\t// rel ";
  protected final String TEXT_238 = " for checkboxs" + NL + "\t\t\t\tList<KeyLabel> ";
  protected final String TEXT_239 = " = ";
  protected final String TEXT_240 = ".get";
  protected final String TEXT_241 = "().";
  protected final String TEXT_242 = "();" + NL + "\t\t\t\t";
  protected final String TEXT_243 = " = KeyLabelRenderUtil.renderHtmlCheckboxs(";
  protected final String TEXT_244 = ", null,";
  protected final String TEXT_245 = " );";
  protected final String TEXT_246 = "\t";
  protected final String TEXT_247 = "\t\t";
  protected final String TEXT_248 = NL + "\t\t\t\t// rel ";
  protected final String TEXT_249 = " for Treeview" + NL + "\t\t\t\tList<TreeViewItem> ";
  protected final String TEXT_250 = " = ";
  protected final String TEXT_251 = ".get";
  protected final String TEXT_252 = "().";
  protected final String TEXT_253 = "();" + NL + "\t\t\t\t";
  protected final String TEXT_254 = " =TreeRenderUtil.jsonTreeviewShowCheckString(";
  protected final String TEXT_255 = ", null);";
  protected final String TEXT_256 = NL + "\t\t\t} else {" + NL + "\t\t\t\tmo = ";
  protected final String TEXT_257 = ".get(rto.getId());";
  protected final String TEXT_258 = "\t\t\t\t";
  protected final String TEXT_259 = "\t";
  protected final String TEXT_260 = "\t\t";
  protected final String TEXT_261 = "\t";
  protected final String TEXT_262 = "\t";
  protected final String TEXT_263 = "\t\t";
  protected final String TEXT_264 = NL + "\t\t\t\t// rel ";
  protected final String TEXT_265 = " for checkboxs" + NL + "\t\t\t\tList<KeyLabel> ";
  protected final String TEXT_266 = " = ";
  protected final String TEXT_267 = ".get";
  protected final String TEXT_268 = "().";
  protected final String TEXT_269 = "();" + NL + "\t\t\t\tList<String> ";
  protected final String TEXT_270 = " =  ";
  protected final String TEXT_271 = ".get";
  protected final String TEXT_272 = "().";
  protected final String TEXT_273 = "(mo.getId());" + NL + "\t\t\t\t";
  protected final String TEXT_274 = " = KeyLabelRenderUtil.renderHtmlCheckboxs(";
  protected final String TEXT_275 = ",";
  protected final String TEXT_276 = ", ";
  protected final String TEXT_277 = ");";
  protected final String TEXT_278 = "\t\t\t\t";
  protected final String TEXT_279 = "\t";
  protected final String TEXT_280 = "\t\t";
  protected final String TEXT_281 = "\t";
  protected final String TEXT_282 = "\t\t";
  protected final String TEXT_283 = NL + "\t\t\t\t// rel ";
  protected final String TEXT_284 = " for Treeview" + NL + "\t\t\t\tList<TreeViewItem> ";
  protected final String TEXT_285 = " = ";
  protected final String TEXT_286 = ".get";
  protected final String TEXT_287 = "().";
  protected final String TEXT_288 = "();" + NL + "\t\t\t\tList<String> ";
  protected final String TEXT_289 = " = ";
  protected final String TEXT_290 = ".get";
  protected final String TEXT_291 = "().";
  protected final String TEXT_292 = "(mo.getId());" + NL + "\t\t\t\t";
  protected final String TEXT_293 = " =TreeRenderUtil.jsonTreeviewShowCheckString(";
  protected final String TEXT_294 = ", ";
  protected final String TEXT_295 = ");";
  protected final String TEXT_296 = NL + "\t\t\t}" + NL + "\t\t\treturn SUCCESS;" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tSysLogger.appError(e.getMessage(), e,getRequest());" + NL + "\t\t\treturn ERROR;" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\treturn ERROR;" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * 保存或更新Entity,返回json格式." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void saveOutJson() {" + NL + "\t\ttry {" + NL + "\t\t\tif (SecurityHolder.isUserNoLogin()) {" + NL + "\t\t\t\tRenderUtil.renderHtmlNoLogin();" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\tString ";
  protected final String TEXT_297 = " = getModel().";
  protected final String TEXT_298 = ";" + NL + "\t\t\tAppAssert.isNotblank(";
  protected final String TEXT_299 = ", \"未指定";
  protected final String TEXT_300 = "\");";
  protected final String TEXT_301 = "\t";
  protected final String TEXT_302 = "\t" + NL + "\t\t\tString[] ";
  protected final String TEXT_303 = " = ChangeUtil.stringToArray(getModel().";
  protected final String TEXT_304 = "(), true);";
  protected final String TEXT_305 = "\t\t\t";
  protected final String TEXT_306 = NL + "\t\t\tList<UploadFile> uploadFiles = ";
  protected final String TEXT_307 = ".uploadFiles(getRequest());" + NL + "\t\t\tif (null != uploadFiles && !uploadFiles.isEmpty()) {" + NL + "\t\t\t\tmo = getModel().getNewModel();" + NL + "\t\t\t\tint count = 0;" + NL + "\t\t\t\tfor (UploadFile uploadFile : uploadFiles) {";
  protected final String TEXT_308 = "\t";
  protected final String TEXT_309 = NL + "\t\t\t\t\tmo.";
  protected final String TEXT_310 = "(uploadFile.getSavePath());";
  protected final String TEXT_311 = NL + "\t\t\t\t\tmo.setPath(uploadFile.getSavePath());";
  protected final String TEXT_312 = "\t\t\t\t";
  protected final String TEXT_313 = "\t";
  protected final String TEXT_314 = NL + "\t\t\t\t\tmo.";
  protected final String TEXT_315 = "(uploadFile.getSize());";
  protected final String TEXT_316 = "\t";
  protected final String TEXT_317 = NL + "\t\t\t\t\tmo.";
  protected final String TEXT_318 = "(uploadFile.getExtention());";
  protected final String TEXT_319 = "\t";
  protected final String TEXT_320 = NL + "\t\t\t\t\tmo.";
  protected final String TEXT_321 = "(uploadFile.getFileType());";
  protected final String TEXT_322 = "\t";
  protected final String TEXT_323 = NL + "\t\t\t\t\tmo.";
  protected final String TEXT_324 = "(uploadFile.getFileName());";
  protected final String TEXT_325 = NL + "\t\t\t\t\t";
  protected final String TEXT_326 = ".save(getModel()";
  protected final String TEXT_327 = ");" + NL + "\t\t\t\t\tcount++;" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_328 = ".htmlResultMsgBy";
  protected final String TEXT_329 = "(true, mo, \"保存成功\" + count + \"项记录!\");" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\treturn;";
  protected final String TEXT_330 = "\t\t\t" + NL + "\t\t} catch (InvalidStateException e) {";
  protected final String TEXT_331 = NL + "\t\t\tString invalidateMsg = ";
  protected final String TEXT_332 = ".getValidateMessageWithHtmlBR(e.getInvalidValues());" + NL + "\t\t\tlogger.error(invalidateMsg, e);" + NL + "\t\t\tSysLogger.appError(invalidateMsg, e, getRequest());" + NL + "\t\t\tRenderUtil.renderHtmlResultMsgError(invalidateMsg);" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tSysLogger.appError(invalidateMsg, e, getRequest());" + NL + "\t\t\tRenderUtil.renderHtmlResultMsgError(e.getMessage());" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderHtmlResultMsgError();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * 更新Entity,返回json格式." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void updateOutJson() {" + NL + "\t\ttry {";
  protected final String TEXT_333 = NL + "\t\t\tif (SecurityHolder.isUserNoLogin()) {" + NL + "\t\t\t\tRenderUtil.renderHtmlNoLogin();" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\tString ";
  protected final String TEXT_334 = " = getModel().";
  protected final String TEXT_335 = ";" + NL + "\t\t\tAppAssert.isNotblank(";
  protected final String TEXT_336 = ", \"未指定";
  protected final String TEXT_337 = "\");" + NL + "\t\t\tAppAssert.notNull(getModel().getId(), \"未指定更新记录!\");";
  protected final String TEXT_338 = "\t";
  protected final String TEXT_339 = "\t" + NL + "\t\t\tString[] ";
  protected final String TEXT_340 = " = ChangeUtil.stringToArray(getModel().";
  protected final String TEXT_341 = "(), true);";
  protected final String TEXT_342 = "\t\t\t";
  protected final String TEXT_343 = NL + "\t\t\tmo=";
  protected final String TEXT_344 = ".update(getModel()";
  protected final String TEXT_345 = ");" + NL + "\t\t\t";
  protected final String TEXT_346 = ".htmlResultMsgBy";
  protected final String TEXT_347 = "(true, mo, \"更新成功!\");" + NL + "\t\t\treturn; " + NL + "\t\t} catch (InvalidStateException e) {" + NL + "\t\t\tString invalidateMsg = ";
  protected final String TEXT_348 = ".getValidateMessageWithHtmlBR(e.getInvalidValues());" + NL + "\t\t\tlogger.error(invalidateMsg, e);" + NL + "\t\t\tSysLogger.appError(invalidateMsg, e, getRequest());" + NL + "\t\t\tRenderUtil.renderHtmlResultMsgError(invalidateMsg);" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tSysLogger.appError(invalidateMsg, e, getRequest());" + NL + "\t\t\tRenderUtil.renderHtmlResultMsgError(e.getMessage());" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderHtmlResultMsgError();" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * 删除Entity,返回json格式." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void deleteOutJson() {" + NL + "\t\ttry {" + NL + "\t\t\tAppAssert.notNull(getModel().getId(), \"未指定删除的对象!\");" + NL + "\t\t\tfinal String[] delIds = StringUtils.split(getModel().getId(), \",\");" + NL + "\t\t\t//int delCount = ";
  protected final String TEXT_349 = ".delete(delIds);" + NL + "\t\t\tfor (String id : delIds) {" + NL + "\t\t\t\t";
  protected final String TEXT_350 = " ";
  protected final String TEXT_351 = " = ";
  protected final String TEXT_352 = ".get(id);";
  protected final String TEXT_353 = "\t";
  protected final String TEXT_354 = NL + "\t\t\t\tString filePath=";
  protected final String TEXT_355 = ".";
  protected final String TEXT_356 = "();";
  protected final String TEXT_357 = NL + "\t\t\t\tString filePath = ";
  protected final String TEXT_358 = ".getFileSavePath();";
  protected final String TEXT_359 = "\t" + NL + "\t\t\t\t// 删除文件" + NL + "\t\t\t\tif (StringUtils.isNotBlank(filePath)) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_360 = ".deleteFile(filePath, getRequest());" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_361 = ".delete(";
  protected final String TEXT_362 = ");" + NL + "\t\t\t\tdelCount++;" + NL + "\t\t\t}" + NL + "\t\t\tRenderUtil.renderJsonResultMsgSuccess(\"删除成功\" + delCount + \"项记录!\");" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError(e.getMessage());" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * 删除所有Entity,返回json格式." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void deleteAllOutJson() {" + NL + "\t\ttry {" + NL + "\t\t\tString ";
  protected final String TEXT_363 = " = getModel().";
  protected final String TEXT_364 = ";" + NL + "\t\t\tAppAssert.isNotblank(";
  protected final String TEXT_365 = ", \"未指定";
  protected final String TEXT_366 = "\");" + NL + "\t\t\tint delCount = 0;" + NL + "\t\t\tList<";
  protected final String TEXT_367 = "> ";
  protected final String TEXT_368 = "s = ";
  protected final String TEXT_369 = ".getAll();" + NL + "\t\t\tfor (";
  protected final String TEXT_370 = " ";
  protected final String TEXT_371 = " : ";
  protected final String TEXT_372 = "s) {" + NL + "\t\t\t\tString filePath = ";
  protected final String TEXT_373 = ".getPath();" + NL + "\t\t\t\t// 删除文件" + NL + "\t\t\t\tif (StringUtils.isNotBlank(filePath)) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_374 = ".deleteFile(filePath, getRequest());" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_375 = ".delete(";
  protected final String TEXT_376 = ");" + NL + "\t\t\t\tdelCount++;" + NL + "\t\t\t}" + NL + "\t\t\tRenderUtil.renderJsonResultMsgSuccess(\"删除成功\" + delCount + \"项记录!\");" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError(e.getMessage());" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError();" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "" + NL + "\t";
  protected final String TEXT_377 = NL + "\t/************************************************************************" + NL + "\t * code kind define" + NL + "\t ************************************************************************/" + NL + "\t ";
  protected final String TEXT_378 = "\t";
  protected final String TEXT_379 = NL + "\t" + NL + "\t/** @generated */" + NL + "\tpublic String get";
  protected final String TEXT_380 = "() {" + NL + "\t\treturn ";
  protected final String TEXT_381 = ".toHtmlSelect(null == mo ? null : mo.";
  protected final String TEXT_382 = "());" + NL + "\t}";
  protected final String TEXT_383 = NL + "\t/** @generated */" + NL + "\tpublic String get";
  protected final String TEXT_384 = "() {" + NL + "\t\treturn ";
  protected final String TEXT_385 = ".toHtmlJSON;" + NL + "\t}";
  protected final String TEXT_386 = NL;
  protected final String TEXT_387 = "\t" + NL + "" + NL + "\t/** @generated */" + NL + "\tpublic String get";
  protected final String TEXT_388 = "() {" + NL + "\t";
  protected final String TEXT_389 = NL + "\t\tif (null == ";
  protected final String TEXT_390 = ")" + NL + "\t\t\treturn \"{}\";" + NL + "\t";
  protected final String TEXT_391 = NL + "\t\treturn ";
  protected final String TEXT_392 = ";" + NL + "\t}";
  protected final String TEXT_393 = "\t";
  protected final String TEXT_394 = "\t" + NL + "}";
  protected final String TEXT_395 = NL;
  protected final String TEXT_396 = "/*" + NL + " * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the \"License\")" + NL + " * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms." + NL + " * email:yonclv@gmail.com" + NL + " */" + NL + "package ";
  protected final String TEXT_397 = ";";
  protected final String TEXT_398 = NL + NL + "/**" + NL + " * ";
  protected final String TEXT_399 = " by ";
  protected final String TEXT_400 = " manage action." + NL + " *" + NL + " * @author ";
  protected final String TEXT_401 = NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_402 = " extends BaseAction implements ModelDriven<";
  protected final String TEXT_403 = "> {" + NL + "\t/** @generated */" + NL + "\tprivate static final long serialVersionUID = 1L;" + NL + "\t" + NL + "\t" + NL + "\t/**" + NL + "\t * ";
  protected final String TEXT_404 = " Entity CRUD service." + NL + "\t * @generated" + NL + "\t */" + NL + "\t@Autowired" + NL + "\tprivate ";
  protected final String TEXT_405 = " ";
  protected final String TEXT_406 = ";" + NL + "\t" + NL + "\t/*****************************************************************" + NL + "\t * property define" + NL + "\t *****************************************************************/" + NL + "" + NL + "\t/** @generated */" + NL + "\tprivate Page<";
  protected final String TEXT_407 = "> page=null;" + NL + "\t/** @generated */" + NL + "\tprivate ";
  protected final String TEXT_408 = " mo=null;" + NL + "\t/** @generated */" + NL + "\tprivate ";
  protected final String TEXT_409 = " rto=null;" + NL + "" + NL + "\t/** @generated */" + NL + "\tpublic Page<";
  protected final String TEXT_410 = "> getPage() {" + NL + "\t\tif(null==page)" + NL + "\t\t\tpage=new Page<";
  protected final String TEXT_411 = ">();" + NL + "\t\treturn page;" + NL + "\t}" + NL + "" + NL + "\t/** @generated */" + NL + "\tpublic ";
  protected final String TEXT_412 = " getModel() {" + NL + "\t\tif(null==rto)" + NL + "\t\t\trto = new ";
  protected final String TEXT_413 = "();" + NL + "\t\treturn rto;" + NL + "\t}" + NL + "\t" + NL + "\t/** @generated */" + NL + "\tpublic ";
  protected final String TEXT_414 = " getMo() {" + NL + "\t\tif (null == mo) {" + NL + "\t\t\tmo = new ";
  protected final String TEXT_415 = "();" + NL + "\t\t}" + NL + "\t\treturn mo;" + NL + "\t}" + NL + "" + NL + "\t/************************************************************************" + NL + "\t * request function invoke" + NL + "\t ************************************************************************/" + NL + "" + NL + "\t/**" + NL + "\t * 转向管理页面." + NL + "\t * " + NL + " \t * @generated" + NL + "\t */" + NL + "\tpublic String manage() {" + NL + "\t\ttry {" + NL + "\t\t\tif (SecurityHolder.isUserNoLogin())" + NL + "\t\t\t\treturn LOGIN;" + NL + "\t\t\treturn SUCCESS;" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tSysLogger.appError(e.getMessage(), e,getRequest());" + NL + "\t\t\treturn ERROR;" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\treturn ERROR;" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * 获取Entity列表.返回json格式." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void listOutJson() {" + NL + "\t\ttry {" + NL + "\t\t\tif (SecurityHolder.isUserNoLogin()) {" + NL + "\t\t\t\tRenderUtil.renderJsonNoLogin();" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}";
  protected final String TEXT_416 = "\t\t" + NL + "\t\t\tString ";
  protected final String TEXT_417 = " = getModel().";
  protected final String TEXT_418 = ";" + NL + "\t\t\tAppAssert.isNotblank(";
  protected final String TEXT_419 = ", \"未指定";
  protected final String TEXT_420 = "\");" + NL + "\t\t\tOrder[] orders = RequestUtil.buildOrders(getRequest());" + NL + "\t\t\tpage=";
  protected final String TEXT_421 = ".findBy";
  protected final String TEXT_422 = "(";
  protected final String TEXT_423 = ",getPage(), getModel(), orders);" + NL + "\t\t\t";
  protected final String TEXT_424 = ".jsonFlexiGridBy";
  protected final String TEXT_425 = "(page);" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tSysLogger.appError(e.getMessage(), e,getRequest());" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError(e.getMessage());" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * 根据ID获取Entity对象,返回json格式." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void getOutJson() {" + NL + "\t\ttry {" + NL + "\t\t\tif (SecurityHolder.isUserNoLogin()) {" + NL + "\t\t\t\tRenderUtil.renderJsonNoLogin();" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\tAppAssert.notNull(getModel().getId());" + NL + "\t\t\tmo = ";
  protected final String TEXT_426 = ".get(getModel().getId());" + NL + "\t\t\t";
  protected final String TEXT_427 = ".jsonResultMsgBy";
  protected final String TEXT_428 = "(true, mo, null);" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tSysLogger.appError(e.getMessage(), e,getRequest());" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError(e.getMessage());" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError();" + NL + "\t\t}" + NL + "\t}" + NL + "\t";
  protected final String TEXT_429 = NL + "\tprivate static final String ";
  protected final String TEXT_430 = " = \"";
  protected final String TEXT_431 = "\";//rel ";
  protected final String TEXT_432 = " for checkboxs" + NL + "\tprivate String ";
  protected final String TEXT_433 = ";";
  protected final String TEXT_434 = NL + "\tprivate String ";
  protected final String TEXT_435 = ";// rel ";
  protected final String TEXT_436 = " for Treeview";
  protected final String TEXT_437 = NL + "\t/**根据主键获取Entity,并转向修改页面." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic String edit() {" + NL + "\t\ttry {" + NL + "\t\t\tif (SecurityHolder.isUserNoLogin())" + NL + "\t\t\t\treturn NO_LOGIN;" + NL + "\t\t\tif (StringUtils.isBlank(getModel().getId())) {";
  protected final String TEXT_438 = "\t\t\t\t";
  protected final String TEXT_439 = "\t";
  protected final String TEXT_440 = "\t\t";
  protected final String TEXT_441 = "\t\t\t";
  protected final String TEXT_442 = NL + "\t\t\t\t// rel ";
  protected final String TEXT_443 = " for checkboxs" + NL + "\t\t\t\tList<KeyLabel> ";
  protected final String TEXT_444 = " = ";
  protected final String TEXT_445 = ".get";
  protected final String TEXT_446 = "().";
  protected final String TEXT_447 = "();" + NL + "\t\t\t\t";
  protected final String TEXT_448 = " = KeyLabelRenderUtil.renderHtmlCheckboxs(";
  protected final String TEXT_449 = ", null,";
  protected final String TEXT_450 = " );";
  protected final String TEXT_451 = "\t";
  protected final String TEXT_452 = "\t\t";
  protected final String TEXT_453 = NL + "\t\t\t\t// rel ";
  protected final String TEXT_454 = " for Treeview" + NL + "\t\t\t\tList<TreeViewItem> ";
  protected final String TEXT_455 = " = ";
  protected final String TEXT_456 = ".get";
  protected final String TEXT_457 = "().";
  protected final String TEXT_458 = "();" + NL + "\t\t\t\t";
  protected final String TEXT_459 = " =TreeRenderUtil.jsonTreeviewShowCheckString(";
  protected final String TEXT_460 = ", null);";
  protected final String TEXT_461 = NL + "\t\t\t} else {" + NL + "\t\t\t\tmo = ";
  protected final String TEXT_462 = ".get(getModel().getId());";
  protected final String TEXT_463 = "\t\t\t\t";
  protected final String TEXT_464 = "\t";
  protected final String TEXT_465 = "\t\t";
  protected final String TEXT_466 = "\t";
  protected final String TEXT_467 = "\t";
  protected final String TEXT_468 = "\t\t";
  protected final String TEXT_469 = NL + "\t\t\t\t// rel ";
  protected final String TEXT_470 = " for checkboxs" + NL + "\t\t\t\tList<KeyLabel> ";
  protected final String TEXT_471 = " = ";
  protected final String TEXT_472 = ".get";
  protected final String TEXT_473 = "().";
  protected final String TEXT_474 = "();" + NL + "\t\t\t\tList<String> ";
  protected final String TEXT_475 = " =  ";
  protected final String TEXT_476 = ".get";
  protected final String TEXT_477 = "().";
  protected final String TEXT_478 = "(mo.getId());" + NL + "\t\t\t\t";
  protected final String TEXT_479 = " = KeyLabelRenderUtil.renderHtmlCheckboxs(";
  protected final String TEXT_480 = ",";
  protected final String TEXT_481 = ", ";
  protected final String TEXT_482 = ");";
  protected final String TEXT_483 = "\t\t\t\t";
  protected final String TEXT_484 = "\t";
  protected final String TEXT_485 = "\t\t";
  protected final String TEXT_486 = "\t";
  protected final String TEXT_487 = "\t\t";
  protected final String TEXT_488 = NL + "\t\t\t\t// rel ";
  protected final String TEXT_489 = " for Treeview" + NL + "\t\t\t\tList<TreeViewItem> ";
  protected final String TEXT_490 = " = ";
  protected final String TEXT_491 = ".get";
  protected final String TEXT_492 = "().";
  protected final String TEXT_493 = "();" + NL + "\t\t\t\tList<String> ";
  protected final String TEXT_494 = " = ";
  protected final String TEXT_495 = ".get";
  protected final String TEXT_496 = "().";
  protected final String TEXT_497 = "(mo.getId());" + NL + "\t\t\t\t";
  protected final String TEXT_498 = " =TreeRenderUtil.jsonTreeviewShowCheckString(";
  protected final String TEXT_499 = ", ";
  protected final String TEXT_500 = ");";
  protected final String TEXT_501 = NL + "\t\t\t}" + NL + "\t\t\treturn SUCCESS;" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tSysLogger.appError(e.getMessage(), e,getRequest());" + NL + "\t\t\treturn ERROR;" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\treturn ERROR;" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * 保存或更新Entity,返回json格式." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void saveOutJson() {" + NL + "\t\ttry {" + NL + "\t\t\tif (SecurityHolder.isUserNoLogin()) {" + NL + "\t\t\t\tRenderUtil.renderJsonNoLogin();" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\tString ";
  protected final String TEXT_502 = " = getModel().";
  protected final String TEXT_503 = ";" + NL + "\t\t\tAppAssert.isNotblank(";
  protected final String TEXT_504 = ", \"未指定";
  protected final String TEXT_505 = "\");";
  protected final String TEXT_506 = "\t";
  protected final String TEXT_507 = "\t" + NL + "\t\t\tString[] ";
  protected final String TEXT_508 = " = ChangeUtil.stringToArray(getModel().";
  protected final String TEXT_509 = "(), true);";
  protected final String TEXT_510 = "\t\t\t";
  protected final String TEXT_511 = NL + "\t\t\tmo=";
  protected final String TEXT_512 = ".saveBy";
  protected final String TEXT_513 = "(";
  protected final String TEXT_514 = ",getModel()";
  protected final String TEXT_515 = ");" + NL + "\t\t\t";
  protected final String TEXT_516 = ".jsonResultMsgBy";
  protected final String TEXT_517 = "(true, mo, \"新增成功!\");" + NL + "\t\t\treturn;" + NL + "\t\t} catch (InvalidStateException e) {";
  protected final String TEXT_518 = NL + "\t\t\tString invalidateMsg = ";
  protected final String TEXT_519 = ".getValidateMessageWithHtmlBR(e.getInvalidValues());" + NL + "\t\t\tlogger.error(invalidateMsg, e);" + NL + "\t\t\tSysLogger.appError(invalidateMsg, e, getRequest());" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError(invalidateMsg);" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tSysLogger.appError(e.getMessage(), e,getRequest());" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError(e.getMessage());" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * 更新Entity,返回json格式." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void updateOutJson() {" + NL + "\t\ttry {" + NL + "\t\t\tif (SecurityHolder.isUserNoLogin()) {" + NL + "\t\t\t\tRenderUtil.renderJsonNoLogin();" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\tString ";
  protected final String TEXT_520 = " = getModel().";
  protected final String TEXT_521 = ";" + NL + "\t\t\tAppAssert.isNotblank(";
  protected final String TEXT_522 = ", \"未指定";
  protected final String TEXT_523 = "\");";
  protected final String TEXT_524 = "\t";
  protected final String TEXT_525 = "\t" + NL + "\t\t\tString[] ";
  protected final String TEXT_526 = " = ChangeUtil.stringToArray(getModel().";
  protected final String TEXT_527 = "(), true);";
  protected final String TEXT_528 = "\t\t\t";
  protected final String TEXT_529 = NL + "\t\t\tmo=";
  protected final String TEXT_530 = ".updateBy";
  protected final String TEXT_531 = "(";
  protected final String TEXT_532 = ",getModel()";
  protected final String TEXT_533 = ");" + NL + "\t\t\t";
  protected final String TEXT_534 = ".jsonResultMsgBy";
  protected final String TEXT_535 = "(true, mo, \"更新成功!\");" + NL + "\t\t\treturn; ";
  protected final String TEXT_536 = NL + "\t\t} catch (InvalidStateException e) {" + NL + "\t\t\tString invalidateMsg = ";
  protected final String TEXT_537 = ".getValidateMessageWithHtmlBR(e.getInvalidValues());" + NL + "\t\t\tlogger.error(invalidateMsg, e);" + NL + "\t\t\tSysLogger.appError(invalidateMsg, e, getRequest());" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError(invalidateMsg);" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tSysLogger.appError(e.getMessage(), e,getRequest());" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError(e.getMessage());" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError();" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * 删除Entity,返回json格式." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void deleteOutJson() {" + NL + "\t\ttry {" + NL + "\t\t\tif (SecurityHolder.isUserNoLogin()) {" + NL + "\t\t\t\tRenderUtil.renderJsonNoLogin();" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\tAppAssert.notNull(getModel().getId(), \"未指定删除的对象!\");" + NL + "\t\t\tfinal String[] delIds = StringUtils.split(getModel().getId(), \",\");" + NL + "\t\t\tint delCount = ";
  protected final String TEXT_538 = ".delete(delIds);" + NL + "\t\t\tString msg = delCount == 0?\"无记录删除!\":\"删除成功\" + delCount + \"项记录!\";" + NL + "\t\t\tRenderUtil.renderJsonResultMsgSuccess(msg);" + NL + "\t\t}catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tSysLogger.appError(e.getMessage(), e,getRequest());" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError(e.getMessage());" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * 删除所有Entity,返回json格式." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void deleteAllOutJson() {" + NL + "\t\ttry {" + NL + "\t\t\tif (SecurityHolder.isUserNoLogin()) {" + NL + "\t\t\t\tRenderUtil.renderJsonNoLogin();" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\tString ";
  protected final String TEXT_539 = " = getModel().";
  protected final String TEXT_540 = ";" + NL + "\t\t\tAppAssert.isNotblank(";
  protected final String TEXT_541 = ", \"未指定";
  protected final String TEXT_542 = "\");" + NL + "\t\t\tint delCount = ";
  protected final String TEXT_543 = ".deleteAllBy";
  protected final String TEXT_544 = "(";
  protected final String TEXT_545 = ");" + NL + "\t\t\tString msg = delCount == 0?\"无记录删除!\":\"删除成功\" + delCount + \"项记录!\";" + NL + "\t\t\tRenderUtil.renderJsonResultMsgSuccess(msg);" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tSysLogger.appError(e.getMessage(), e,getRequest());" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError(e.getMessage());" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError();" + NL + "\t\t}" + NL + "\t}" + NL;
  protected final String TEXT_546 = NL + "\t/**" + NL + "\t * 导出 Excel 文件." + NL + "     * @generated" + NL + "\t */" + NL + "\tpublic void exportExcelFile() {" + NL + "\t\ttry {" + NL + "\t\t\tString ";
  protected final String TEXT_547 = " = getModel().";
  protected final String TEXT_548 = ";" + NL + "\t\t\tAppAssert.isNotblank(";
  protected final String TEXT_549 = ", \"未指定";
  protected final String TEXT_550 = "\");" + NL + "\t\t\tOrder[] orders = RequestUtil.buildOrders(getRequest());" + NL + "\t\t\tpage=";
  protected final String TEXT_551 = ".findBy";
  protected final String TEXT_552 = "(";
  protected final String TEXT_553 = ",getPage(), getModel(), orders);" + NL + "\t\t\t";
  protected final String TEXT_554 = ".excelExportAllField(getResponse(), getPage().getResult());" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t}" + NL + "\t}" + NL;
  protected final String TEXT_555 = NL + "\t/**" + NL + "\t * 导入excel文件." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic String importExcelFile() {" + NL + "\t\ttry {" + NL + "\t\t\tif (SecurityHolder.isUserNoLogin())" + NL + "\t\t\t\treturn NO_LOGIN;" + NL + "\t\t\treturn SUCCESS;" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\treturn ERROR;" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * 导入excel 文件处理." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void ";
  protected final String TEXT_556 = "() {" + NL + "" + NL + "\t\ttry {" + NL + "\t\t\tif (SecurityHolder.isUserNoLogin()) {" + NL + "\t\t\t\tRenderUtil.renderJsonNoLogin();" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\tList<File> fileList = StrutsWebFileUtil.getUploadFile(getRequest());" + NL + "\t\t\tif (!fileList.isEmpty()) {" + NL + "\t\t\t\tList<";
  protected final String TEXT_557 = "> importModelList = ";
  protected final String TEXT_558 = ".excelToModel(fileList.get(0));";
  protected final String TEXT_559 = "\t" + NL + "\t\t\t\tResultMsg<";
  protected final String TEXT_560 = "> resultMsg =";
  protected final String TEXT_561 = ".";
  protected final String TEXT_562 = "(importModelList);" + NL + "\t\t\t\tRenderUtil.renderHtml(resultMsg.getMessage());" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\tRenderUtil.renderHtml(\"请上传需要导入的excel文件!\");" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tSysLogger.appError(e.getMessage(), e,getRequest());" + NL + "\t\t\tRenderUtil.renderHtml(e.getMessage());" + NL + "\t\t} catch (IOException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tSysLogger.appError(e.getMessage(), e,getRequest());" + NL + "\t\t\tRenderUtil.renderHtml(\"导入失败!文件加载错误!\");" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderHtml(\"导入失败!\");" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "" + NL + "\t";
  protected final String TEXT_563 = "\t";
  protected final String TEXT_564 = NL + "\t" + NL + "\t/** @generated */" + NL + "\tpublic String get";
  protected final String TEXT_565 = "() {" + NL + "\t\treturn ";
  protected final String TEXT_566 = ".toHtmlSelect(null == mo ? null : mo.";
  protected final String TEXT_567 = "());" + NL + "\t}";
  protected final String TEXT_568 = NL + "\t/** @generated */" + NL + "\tpublic String get";
  protected final String TEXT_569 = "() {" + NL + "\t\treturn ";
  protected final String TEXT_570 = ".toHtmlJSON;" + NL + "\t}";
  protected final String TEXT_571 = NL;
  protected final String TEXT_572 = "\t" + NL + "\t/** @generated */" + NL + "\tpublic String get";
  protected final String TEXT_573 = "() {" + NL + "\t";
  protected final String TEXT_574 = NL + "\t\tif (null == ";
  protected final String TEXT_575 = ")" + NL + "\t\t\treturn \"{}\";" + NL + "\t";
  protected final String TEXT_576 = NL + "\t\treturn ";
  protected final String TEXT_577 = ";" + NL + "\t}";
  protected final String TEXT_578 = "\t";
  protected final String TEXT_579 = "\t" + NL + "}";
  protected final String TEXT_580 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    Property uml2Property_proxy = (Property) argument;
    Class uml2Class_proxy = (Class) uml2Property_proxy.getOwner();
    if(ModelStereoTypeHelper.isApplyModel_Tree(uml2Class_proxy)){//应用了tree
    Property curProperty = (Property) argument;Package uml2Package = curProperty.getNearestPackage();
    
/******property wrap********/
UmlPropertyWrap propertyWrap=new UmlPropertyWrap(curProperty);
String curPropertyCapName=propertyWrap.getCapName();
//String curPropertyUnCapName=propertyWrap.getUncapName();
String curPropertyComment=propertyWrap.getCommentName();
Class uml2Class=(Class)curProperty.getOwner();

/*******clazz wrap********/
UmlClassWrap clazzWrap=new UmlClassWrap(uml2Class);
String ownerClassCommentName=clazzWrap.getCommentName();

/******** clazz by property wrap ********/
UmlClassByPropertyWrap clazzByPropertyWrap=new UmlClassByPropertyWrap(curProperty);

/******** clazz by Property action define********/
ClassNameDefineByPropertyCommon actionByProperty=clazzByPropertyWrap.getNameDefineActionByProperty();
String modelActionPackageName=actionByProperty.getPackageQualifiedName();
String modelActionClassName=actionByProperty.getClassName();
//String modelActionClassQualifiedName=actionByProperty.getClassQualifiedName();


    stringBuffer.append(TEXT_1);
    stringBuffer.append(modelActionPackageName);
    stringBuffer.append(TEXT_2);
    ImportManager	importManager = ImportHelper.makeImportManager("");
    //importManager.addImport("java.util.List");
    //importManager.addImport("java.io.File");
    //importManager.addImport("java.io.IOException");
    importManager.addImport("org.apache.commons.lang.StringUtils");
    importManager.addImport("org.springframework.beans.factory.annotation.Autowired");
    importManager.addImport("org.springframework.util.Assert");
    importManager.addImport("com.opensymphony.xwork2.ModelDriven");
    importManager.addImport("com.jeefuse.base.exception.ApplicationException");
    importManager.addImport("com.jeefuse.base.utils.page.Page");
    importManager.addImport("com.jeefuse.base.web.action.BaseAction");
    importManager.addImport("com.jeefuse.base.web.utils.RenderUtil");
    importManager.addImport("com.jeefuse.base.modules.condition.order.Order");
    importManager.addImport("com.jeefuse.base.exception.AppAssert");
    importManager.addImport("com.jeefuse.base.web.utils.RequestUtil");
    importManager.addImport("com.jeefuse.base.modules.tree.TreeRenderUtil");
    importManager.addImport("com.jeefuse.system.security.service.spring.SecurityHolder");
    importManager.addImport("com.jeefuse.system.log.service.SysLogger");
    
//model entity define
ClassNameDefineCommon entityDefine=clazzWrap.getNameDefineEntity();
String modelEntityQualifiedName=entityDefine.getClassQualifiedName();
//String modelEntityPackage=entityDefine.getPackageQualifiedName();
String modelEntityName=entityDefine.getClassCapName();
String modelEntityUncapName=entityDefine.getClassUncapName();
importManager.addImport(modelEntityQualifiedName);

//model service define
ClassNameDefineCommon serviceDefine=clazzWrap.getNameDefineService();
String modelServiceQualifiedName=serviceDefine.getClassQualifiedName();
//String modelServicePackage=serviceDefine.getPackageQualifiedName();
String modelServiceName=serviceDefine.getClassCapName();
String modelServiceUnCapName=serviceDefine.getClassUncapName();
importManager.addImport(modelServiceQualifiedName);

//model RTO define
ClassNameDefineCommon rtoDefine=clazzWrap.getNameDefineRTO();
String modelRTOQualifiedName=rtoDefine.getClassQualifiedName();
//String modelRTOPackageName=rtoDefine.getPackageQualifiedName();
String modelRTOName=rtoDefine.getClassCapName();
importManager.addImport(modelRTOQualifiedName);

// model RenderUtilByProperty define
ClassNameDefineByPropertyCommon renderUtilDefine=clazzByPropertyWrap.getNameDefineRenderUtilByProperty();
String renderUtilQualifiedName=renderUtilDefine.getClassQualifiedName();
String renderUtilName=renderUtilDefine.getClassCapName();
importManager.addImport(renderUtilQualifiedName);

//serviceFacotry define
//UmlPackageWrap umlPackageWrap=new UmlPackageWrap(uml2Package);
//String packageServiceFactoryClassName=umlPackageWrap.getServiceFactoryClassName();
//String packageServiceFactoryClassQualifiedName=umlPackageWrap.getServiceFactoryClassQualifiedName();
//importManager.addImport(packageServiceFactoryClassQualifiedName);


    
StringBuffer importStringBuffer = stringBuffer;
int importInsertionPoint = stringBuffer.length();
importManager.addCompilationUnitImports(stringBuffer.toString());

    /****** Page access attributes List   *****/
    List<String> pageAccessAttrList=new ArrayList<String>();
    stringBuffer.append(TEXT_3);
    stringBuffer.append(ownerClassCommentName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(curPropertyComment);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(System.getProperty("user.name"));
    stringBuffer.append(TEXT_6);
    stringBuffer.append(modelActionClassName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(modelRTOName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(ownerClassCommentName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(modelServiceName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(modelRTOName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(modelRTOName);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(modelRTOName);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(curPropertyCapName);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(renderUtilName);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(curPropertyCapName);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(curPropertyCapName);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(renderUtilName);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(curPropertyCapName);
    stringBuffer.append(TEXT_28);
    		importManager.addImport("com.jeefuse.base.modules.tree.renders.treeview.TreeViewItem");
    stringBuffer.append(TEXT_29);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(curPropertyCapName);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(ownerClassCommentName);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(renderUtilName);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(curPropertyCapName);
    stringBuffer.append(TEXT_35);
    		pageAccessAttrList.add("htmlSelectTree");
    stringBuffer.append(TEXT_36);
    /********process rel M2MCheckboxs ,M2MCheckboxsTab Property ********/
    List<Property> needM2MCheckboxsList=new ArrayList<Property>();
    List<Property> M2MCheckboxsPropertyList=ViewInputHelper.getApplyM2MCheckboxs(uml2Class);
    if(null!=M2MCheckboxsPropertyList){//M2MCheckboxs 
    	needM2MCheckboxsList.addAll(M2MCheckboxsPropertyList);
    }
    List<Property> M2MCheckboxsTabPropertyList=ViewInputHelper.getApplyM2MCheckboxsTab(uml2Class);
    if(null!=M2MCheckboxsTabPropertyList){//M2MCheckboxsTab 
    	needM2MCheckboxsList.addAll(M2MCheckboxsTabPropertyList);
    }
    if(null!=needM2MCheckboxsList&&needM2MCheckboxsList.size()>0){
    	for(Property property:needM2MCheckboxsList){
    		Type propertyType=property.getType();
    		Class relTargetClass=(Class)propertyType;
    		if(ModelStereoTypeHelper.isApplyModel_M2M(propertyType)||ModelStereoTypeHelper.isApplyModel_M2mWithId(propertyType)){
    			Class relUml2Class=(Class)propertyType;
    			relTargetClass=ModelHelper.getRelTargetClass(relUml2Class,uml2Class);
    		}
    		String relTargetClassCommentName=TypeHelper.getDocumentationOrName(relTargetClass);
    		String relPropertyCheckboxs=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relCheckboxs);
    		String relPropertyCheckboxsDomId=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relCheckboxsDomId);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(relPropertyCheckboxsDomId);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(relPropertyCheckboxs);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(relPropertyCheckboxs);
    stringBuffer.append(TEXT_41);
    		pageAccessAttrList.add(relPropertyCheckboxs);
    	}
    }
    /********process rel M2MCheckboxsTree M2MCheckboxsTreeTab Property********/
    List<Property> needM2MCheckboxsTreeList=new ArrayList<Property>();
    List<Property> M2MCheckboxsTreePropertyList=ViewInputHelper.getApplyM2MCheckboxsTree(uml2Class);
    if(null!=M2MCheckboxsTreePropertyList){//M2MCheckboxsTree 
    	needM2MCheckboxsTreeList.addAll(M2MCheckboxsTreePropertyList);
    }
    List<Property> M2MCheckboxsTreeTabPropertyList=ViewInputHelper.getApplyM2MCheckboxsTreeTab(uml2Class);
    if(null!=M2MCheckboxsTreeTabPropertyList){//M2MCheckboxsTreeTab 
    	needM2MCheckboxsTreeList.addAll(M2MCheckboxsTreeTabPropertyList);
    }
    if(null!=needM2MCheckboxsTreeList&&needM2MCheckboxsTreeList.size()>0){
    	for(Property property:needM2MCheckboxsTreeList){
    		Type propertyType=property.getType();
    		Class relTargetClass=(Class)propertyType;
    		if(ModelStereoTypeHelper.isApplyModel_M2M(propertyType)||ModelStereoTypeHelper.isApplyModel_M2mWithId(propertyType)){
    			Class relUml2Class=(Class)propertyType;
    			relTargetClass=ModelHelper.getRelTargetClass(relUml2Class,uml2Class);
    		}
    		String relTargetClassCommentName=TypeHelper.getDocumentationOrName(relTargetClass);
    		String relPropertyShowCheckTreeJson=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relShowCheckTreeJson);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(relPropertyShowCheckTreeJson);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_44);
    		pageAccessAttrList.add(relPropertyShowCheckTreeJson);
    	}
    }
    stringBuffer.append(TEXT_45);
    		importManager.addImport("com.jeefuse.base.modules.tree.renders.treeview.TreeViewItem");
    stringBuffer.append(TEXT_46);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(curPropertyCapName);
    stringBuffer.append(TEXT_48);
    /********process rel M2MCheckboxs process********/
    stringBuffer.append(TEXT_49);
    if(null!=M2MCheckboxsPropertyList&&M2MCheckboxsPropertyList.size()>0){
    	for(Property property:M2MCheckboxsPropertyList){
    		Type propertyType=property.getType();
    		Class relTargetClass=(Class)propertyType;
    		if(ModelStereoTypeHelper.isApplyModel_M2M(propertyType)||ModelStereoTypeHelper.isApplyModel_M2mWithId(propertyType)){
    			Class relUml2Class=(Class)propertyType;
    			relTargetClass=ModelHelper.getRelTargetClass(relUml2Class,uml2Class);
    		}
    		String relTargetClassCommentName=TypeHelper.getDocumentationOrName(relTargetClass);
    		//relTargetClassPackageServiceFacotry define
    		String relTargetClassPackageServiceFactoryPackageName=MdaHelper.getPackageQualifiedName(relTargetClass.getNearestPackage(),PKGSuffix.serviceFactory);
    		String relTargetClassPackageServiceFactoryClassName=MdaHelper.getPackageClassName(relTargetClass.getNearestPackage(),ModelNameSuffix.serviceFactory);
    		String relTargetClassPackageServiceFactoryQualifiedName=relTargetClassPackageServiceFactoryPackageName+"."+relTargetClassPackageServiceFactoryClassName;
    		importManager.addImport(relTargetClassPackageServiceFactoryQualifiedName);
    		//model service
    		String relTargetClassServiceQualifiedName=MdaHelper.getModelQualifiedName(relTargetClass,PKGSuffix.service,ModelNameSuffix.Service);
    		String relTargetClassServiceName=ImportHelper.getImportedName(relTargetClassServiceQualifiedName);
    		String relTargetClassServiceUnCapName=NameHelper.uncapName(relTargetClassServiceName);	
    stringBuffer.append(TEXT_50);
    		//relTargetClassCheckboxs
    stringBuffer.append(TEXT_51);
    		String relTargetClassCheckboxs=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relCheckboxs);
    		String relTargetClassCheckboxsDomId=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relCheckboxsDomId);
    		String relTargetClassAllKeyLabelList=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.allKeyLabelList);
    		String relTargetClassGetAllForKeyLabel=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.getAllForKeyLabel);
    stringBuffer.append(TEXT_52);
    		importManager.addImport("com.jeefuse.base.modules.keyLabel.KeyLabel");
    		importManager.addImport("com.jeefuse.base.modules.keyLabel.KeyLabelRenderUtil");
    stringBuffer.append(TEXT_53);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(relTargetClassAllKeyLabelList);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(relTargetClassPackageServiceFactoryClassName);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(relTargetClassServiceUnCapName);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(relTargetClassGetAllForKeyLabel);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(relTargetClassCheckboxs);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(relTargetClassAllKeyLabelList);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(relTargetClassCheckboxsDomId);
    stringBuffer.append(TEXT_61);
    	}
    }
    /********process rel M2MCheckboxsTree process********/
    if(null!=needM2MCheckboxsTreeList&&needM2MCheckboxsTreeList.size()>0){
    	for(Property property:needM2MCheckboxsTreeList){
    		Type propertyType=property.getType();
    		Class relTargetClass=(Class)propertyType;
    		if(ModelStereoTypeHelper.isApplyModel_M2M(propertyType)||ModelStereoTypeHelper.isApplyModel_M2mWithId(propertyType)){
    			Class relUml2Class=(Class)propertyType;
    			relTargetClass=ModelHelper.getRelTargetClass(relUml2Class,uml2Class);
    		}
    		String relTargetClassCapName=NameHelper.getCapName(relTargetClass);
    		String relTargetClassUncapName=NameHelper.getUncapName(relTargetClass);
    		String relTargetClassCommentName=TypeHelper.getDocumentationOrName(relTargetClass);
    		//relTargetClassPackageServiceFacotry define
    		String relTargetClassPackageServiceFactoryPackageName=MdaHelper.getPackageQualifiedName(relTargetClass.getNearestPackage(),PKGSuffix.serviceFactory);
    		String relTargetClassPackageServiceFactoryClassName=MdaHelper.getPackageClassName(relTargetClass.getNearestPackage(),ModelNameSuffix.serviceFactory);
    		String relTargetClassPackageServiceFactoryQualifiedName=relTargetClassPackageServiceFactoryPackageName+"."+relTargetClassPackageServiceFactoryClassName;
    		importManager.addImport(relTargetClassPackageServiceFactoryQualifiedName);
    		//model service
    		String relTargetClassServiceQualifiedName=MdaHelper.getModelQualifiedName(relTargetClass,PKGSuffix.service,ModelNameSuffix.Service);
    		String relTargetClassServiceName=ImportHelper.getImportedName(relTargetClassServiceQualifiedName);
    		String relTargetClassServiceUnCapName=NameHelper.uncapName(relTargetClassServiceName);	
    stringBuffer.append(TEXT_62);
    		//relPropertyShowCheckTree
    		String relTargetClassShowCheckTreeJson=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relShowCheckTreeJson);
    		String relTargetClassAllTreeviewList=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.allTreeviewList);
    		String relTargetClassGetAllForTreeviewList=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.getAllForTreeviewList);
    stringBuffer.append(TEXT_63);
    		importManager.addImport("com.jeefuse.base.modules.tree.renders.treeview.TreeViewItem");
    		importManager.addImport("com.jeefuse.base.modules.tree.TreeRenderUtil");
    stringBuffer.append(TEXT_64);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(relTargetClassAllTreeviewList);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(relTargetClassPackageServiceFactoryClassName);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(relTargetClassServiceUnCapName);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(relTargetClassGetAllForTreeviewList);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(relTargetClassShowCheckTreeJson);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(relTargetClassAllTreeviewList);
    stringBuffer.append(TEXT_71);
    	}
    }
    stringBuffer.append(TEXT_72);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_73);
    		importManager.addImport("com.jeefuse.base.utils.common.ChangeUtil");
    stringBuffer.append(TEXT_74);
    /********process rel M2MCheckboxs process********/
    stringBuffer.append(TEXT_75);
    if(null!=M2MCheckboxsPropertyList&&M2MCheckboxsPropertyList.size()>0){
    	for(Property property:M2MCheckboxsPropertyList){
    		Type propertyType=property.getType();
    		Class relTargetClass=(Class)propertyType;
    		if(ModelStereoTypeHelper.isApplyModel_M2M(propertyType)||ModelStereoTypeHelper.isApplyModel_M2mWithId(propertyType)){
    			Class relUml2Class=(Class)propertyType;
    			relTargetClass=ModelHelper.getRelTargetClass(relUml2Class,uml2Class);
    		}
    		String relTargetClassCommentName=TypeHelper.getDocumentationOrName(relTargetClass);
    		//relTargetClassPackageServiceFacotry define
    		String relTargetClassPackageServiceFactoryPackageName=MdaHelper.getPackageQualifiedName(relTargetClass.getNearestPackage(),PKGSuffix.serviceFactory);
    		String relTargetClassPackageServiceFactoryClassName=MdaHelper.getPackageClassName(relTargetClass.getNearestPackage(),ModelNameSuffix.serviceFactory);
    		String relTargetClassPackageServiceFactoryQualifiedName=relTargetClassPackageServiceFactoryPackageName+"."+relTargetClassPackageServiceFactoryClassName;
    		importManager.addImport(relTargetClassPackageServiceFactoryQualifiedName);
    		//model service
    		String relTargetClassServiceQualifiedName=MdaHelper.getModelQualifiedName(relTargetClass,PKGSuffix.service,ModelNameSuffix.Service);
    		String relTargetClassServiceName=ImportHelper.getImportedName(relTargetClassServiceQualifiedName);
    		String relTargetClassServiceUnCapName=NameHelper.uncapName(relTargetClassServiceName);	
    stringBuffer.append(TEXT_76);
    		//relPropertyCheckboxs
    stringBuffer.append(TEXT_77);
    		String relTargetClassCheckboxs=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relCheckboxs);
    		String relTargetClassCheckboxsDomId=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relCheckboxsDomId);
    		String relTargetClassAllKeyLabelList=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.allKeyLabelList);
    		String relTargetClassGetAllForKeyLabel=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.getAllForKeyLabel);
    stringBuffer.append(TEXT_78);
    		String relTargetClassIdsList=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relIdsList);
    stringBuffer.append(TEXT_79);
    		String relTargetClassGetRelIdsMethodName=ModelHelper.getRelIdsMethodName(relTargetClass,uml2Class);
    stringBuffer.append(TEXT_80);
    		importManager.addImport("com.jeefuse.base.modules.keyLabel.KeyLabel");
    		importManager.addImport("com.jeefuse.base.modules.keyLabel.KeyLabelRenderUtil");
    stringBuffer.append(TEXT_81);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(relTargetClassAllKeyLabelList);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(relTargetClassPackageServiceFactoryClassName);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(relTargetClassServiceUnCapName);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(relTargetClassGetAllForKeyLabel);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(relTargetClassIdsList);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(relTargetClassPackageServiceFactoryClassName);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(relTargetClassServiceUnCapName);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(relTargetClassGetRelIdsMethodName);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(relTargetClassCheckboxs);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(relTargetClassAllKeyLabelList);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(relTargetClassIdsList);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(relTargetClassCheckboxsDomId);
    stringBuffer.append(TEXT_94);
    	}
    }
    stringBuffer.append(TEXT_95);
    /********process rel M2MCheckboxsTree process********/
    if(null!=needM2MCheckboxsTreeList&&needM2MCheckboxsTreeList.size()>0){
    	for(Property property:needM2MCheckboxsTreeList){
    		Type propertyType=property.getType();
    		Class relTargetClass=(Class)propertyType;
    		if(ModelStereoTypeHelper.isApplyModel_M2M(propertyType)||ModelStereoTypeHelper.isApplyModel_M2mWithId(propertyType)){
    			Class relUml2Class=(Class)propertyType;
    			relTargetClass=ModelHelper.getRelTargetClass(relUml2Class,uml2Class);
    		}
    		String relTargetClassCapName=NameHelper.getCapName(relTargetClass);
    		String relTargetClassUncapName=NameHelper.getUncapName(relTargetClass);
    		String relTargetClassCommentName=TypeHelper.getDocumentationOrName(relTargetClass);
    		//relTargetClassPackageServiceFacotry define
    		String relTargetClassPackageServiceFactoryPackageName=MdaHelper.getPackageQualifiedName(relTargetClass.getNearestPackage(),PKGSuffix.serviceFactory);
    		String relTargetClassPackageServiceFactoryClassName=MdaHelper.getPackageClassName(relTargetClass.getNearestPackage(),ModelNameSuffix.serviceFactory);
    		String relTargetClassPackageServiceFactoryQualifiedName=relTargetClassPackageServiceFactoryPackageName+"."+relTargetClassPackageServiceFactoryClassName;
    		importManager.addImport(relTargetClassPackageServiceFactoryQualifiedName);
    		//model service
    		String relTargetClassServiceQualifiedName=MdaHelper.getModelQualifiedName(relTargetClass,PKGSuffix.service,ModelNameSuffix.Service);
    		String relTargetClassServiceName=ImportHelper.getImportedName(relTargetClassServiceQualifiedName);
    		String relTargetClassServiceUnCapName=NameHelper.uncapName(relTargetClassServiceName);	
    stringBuffer.append(TEXT_96);
    		//relPropertyShowCheckTree
    		String relTargetClassShowCheckTreeJson=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relShowCheckTreeJson);
    		String relTargetClassAllTreeviewList=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.allTreeviewList);
    		String relTargetClassGetAllForTreeviewList=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.getAllForTreeviewList);
    stringBuffer.append(TEXT_97);
    		String relTargetClassIdsList=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relIdsList);
    stringBuffer.append(TEXT_98);
    		String relTargetClassGetRelIdsMethodName=ModelHelper.getRelIdsMethodName(relTargetClass,uml2Class);
    stringBuffer.append(TEXT_99);
    		importManager.addImport("com.jeefuse.base.modules.tree.renders.treeview.TreeViewItem");
    		importManager.addImport("com.jeefuse.base.modules.tree.TreeRenderUtil");
    stringBuffer.append(TEXT_100);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(relTargetClassAllTreeviewList);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(relTargetClassPackageServiceFactoryClassName);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(relTargetClassServiceUnCapName);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(relTargetClassGetAllForTreeviewList);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(relTargetClassIdsList);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(relTargetClassPackageServiceFactoryClassName);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(relTargetClassServiceUnCapName);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(relTargetClassGetRelIdsMethodName);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(relTargetClassShowCheckTreeJson);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(relTargetClassAllTreeviewList);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(relTargetClassIdsList);
    stringBuffer.append(TEXT_112);
    	}
    }
    stringBuffer.append(TEXT_113);
    		importManager.addImport("com.jeefuse.base.modules.tree.TreeRenderUtil");
    stringBuffer.append(TEXT_114);
    importManager.addImport("org.hibernate.validator.InvalidStateException");
    stringBuffer.append(TEXT_115);
    stringBuffer.append(clazzByPropertyWrap.getValueName());
    stringBuffer.append(TEXT_116);
    stringBuffer.append(clazzByPropertyWrap.getValueGetAccessor());
    stringBuffer.append(TEXT_117);
    stringBuffer.append(clazzByPropertyWrap.getValueName());
    stringBuffer.append(TEXT_118);
    stringBuffer.append(curPropertyComment);
    stringBuffer.append(TEXT_119);
    /********process rel M2MCheckIdsList ********/
    List<Property> M2MCheckIdsList=new ArrayList<Property>();
    if(null!=M2MCheckboxsPropertyList){//M2MCheckboxs 
    	M2MCheckIdsList.addAll(M2MCheckboxsPropertyList);
    }
    if(null!=M2MCheckboxsTabPropertyList){//M2MCheckboxsTab 
    	M2MCheckIdsList.addAll(M2MCheckboxsTabPropertyList);
    }
    if(null!=M2MCheckboxsTreePropertyList){//M2MCheckboxsTree 
    	M2MCheckIdsList.addAll(M2MCheckboxsTreePropertyList);
    }
    if(null!=M2MCheckboxsTreeTabPropertyList){//M2MCheckboxsTreeTab 
    	M2MCheckIdsList.addAll(M2MCheckboxsTreeTabPropertyList);
    }
    StringBuilder saveCheckIdsSb=new StringBuilder();
    if(null!=M2MCheckIdsList&&M2MCheckIdsList.size()>0){
    	saveCheckIdsSb.append(",");
    	for(Iterator<Property> it=M2MCheckIdsList.iterator();it.hasNext();){
    		Type propertyType=it.next().getType();
    		Class relTargetClass=(Class)propertyType;
    		if(ModelStereoTypeHelper.isApplyModel_M2M(propertyType)||ModelStereoTypeHelper.isApplyModel_M2mWithId(propertyType)){
    			Class relUml2Class=(Class)propertyType;
    			relTargetClass=ModelHelper.getRelTargetClass(relUml2Class,uml2Class);
    		}
    		String relTargetClassCheckIds=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relCheckIds);
    stringBuffer.append(TEXT_120);
    		String relTargetClassGetRelCheckIdsMethod=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.getRelCheckIdsMethod);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(relTargetClassCheckIds);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(relTargetClassGetRelCheckIdsMethod);
    stringBuffer.append(TEXT_123);
    		saveCheckIdsSb.append(relTargetClassCheckIds);
    stringBuffer.append(TEXT_124);
    		if(it.hasNext())saveCheckIdsSb.append(",");
    	}
    }
    stringBuffer.append(TEXT_125);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(saveCheckIdsSb.toString());
    stringBuffer.append(TEXT_127);
    stringBuffer.append(renderUtilName);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(curPropertyCapName);
    stringBuffer.append(TEXT_129);
    
//model validate
String modelQualifiedForValidate=MdaHelper.getModelQualifiedName(uml2Class,PKGSuffix.Validate,ModelNameSuffix.Validate);
String modelPackageNameForValidate=MdaHelper.getPackageQualifiedName(uml2Class,PKGSuffix.Validate);
String modelClassNameForValidate=MdaHelper.getModelClassName(uml2Class,ModelNameSuffix.Validate);
importManager.addImport(modelQualifiedForValidate);

    stringBuffer.append(TEXT_130);
    stringBuffer.append(modelClassNameForValidate);
    stringBuffer.append(TEXT_131);
    importManager.addImport("com.jeefuse.base.exception.AppAssert");
    stringBuffer.append(TEXT_132);
    stringBuffer.append(clazzByPropertyWrap.getValueName());
    stringBuffer.append(TEXT_133);
    stringBuffer.append(clazzByPropertyWrap.getValueGetAccessor());
    stringBuffer.append(TEXT_134);
    stringBuffer.append(clazzByPropertyWrap.getValueName());
    stringBuffer.append(TEXT_135);
    stringBuffer.append(curPropertyComment);
    stringBuffer.append(TEXT_136);
    StringBuilder updateCheckIdsSb=new StringBuilder();
    if(null!=M2MCheckIdsList&&M2MCheckIdsList.size()>0){
    	updateCheckIdsSb.append(",");
    	for(Iterator<Property> it=M2MCheckIdsList.iterator();it.hasNext();){
    		Type propertyType=it.next().getType();
    		Class relTargetClass=(Class)propertyType;
    		if(ModelStereoTypeHelper.isApplyModel_M2M(propertyType)||ModelStereoTypeHelper.isApplyModel_M2mWithId(propertyType)){
    			Class relUml2Class=(Class)propertyType;
    			relTargetClass=ModelHelper.getRelTargetClass(relUml2Class,uml2Class);
    		}
    		String relTargetClassCheckIds=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relCheckIds);
    stringBuffer.append(TEXT_137);
    		String relTargetClassGetRelCheckIdsMethod=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.getRelCheckIdsMethod);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(relTargetClassCheckIds);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(relTargetClassGetRelCheckIdsMethod);
    stringBuffer.append(TEXT_140);
    		updateCheckIdsSb.append(relTargetClassCheckIds);
    stringBuffer.append(TEXT_141);
    		if(it.hasNext())updateCheckIdsSb.append(",");
    	}
    }
    stringBuffer.append(TEXT_142);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(saveCheckIdsSb.toString());
    stringBuffer.append(TEXT_144);
    stringBuffer.append(renderUtilName);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(curPropertyCapName);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(modelClassNameForValidate);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(clazzByPropertyWrap.getValueName());
    stringBuffer.append(TEXT_150);
    stringBuffer.append(clazzByPropertyWrap.getValueGetAccessor());
    stringBuffer.append(TEXT_151);
    stringBuffer.append(clazzByPropertyWrap.getValueName());
    stringBuffer.append(TEXT_152);
    stringBuffer.append(curPropertyComment);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(curPropertyCapName);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(clazzByPropertyWrap.getValueName());
    stringBuffer.append(TEXT_156);
    
//model exportFactory 
String modelExportFactoryQualifiedName=MdaHelper.getModelQualifiedName(uml2Class,PKGSuffix.exportFactory,ModelNameSuffix.exportFactory);
//String modelExportFactoryPackageName=MdaHelper.getPackageQualifiedName(uml2Class,PKGSuffix.exportFactory);
String modelExportFactoryClassName=MdaHelper.getModelClassName(uml2Class,ModelNameSuffix.exportFactory);
importManager.addImport(modelExportFactoryQualifiedName);

//model excel export file name
String ExcelExportTemplateFileCapName=PropertyNamedRuleKind.ExcelExportTemplateFileName.getRuleCapNamed(uml2Class);
String ExcelExportTemplateFileUncapName=PropertyNamedRuleKind.ExcelExportTemplateFileName.getRuleUnCapNamed(uml2Class);


    stringBuffer.append(TEXT_157);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(modelExportFactoryClassName);
    stringBuffer.append(TEXT_159);
    
//model importFactory
String modelImportFactoryQualifiedName=MdaHelper.getModelQualifiedName(uml2Class,PKGSuffix.importFactory,ModelNameSuffix.importFactory);
//String modelImportFactoryPackageName=MdaHelper.getPackageQualifiedName(uml2Class,PKGSuffix.importFactory);
String modelImportFactoryClassName=MdaHelper.getModelClassName(uml2Class,ModelNameSuffix.importFactory);;
importManager.addImport(modelImportFactoryQualifiedName);

//model excelImport 
//String modelExcelImportQualifiedName=MdaHelper.getModelQualifiedName(uml2Class,PKGSuffix.importExcel,ModelNameSuffix.importExcel);
//String modelExcelImportClassName=MdaHelper.getModelClassName(uml2Class,ModelNameSuffix.importExcel);
//importManager.addImport(modelExcelImportQualifiedName);

//webFileUtil
importManager.addImport("com.jeefuse.base.web.uploadFile.StrutsWebFileUtil");
importManager.addImport("java.util.List");
importManager.addImport("java.io.File");
importManager.addImport("java.io.IOException");

    stringBuffer.append(TEXT_160);
    stringBuffer.append(WebUrlName.importExcelFileProcess.getValue());
    stringBuffer.append(TEXT_161);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(modelImportFactoryClassName);
    stringBuffer.append(TEXT_163);
    importManager.addImport("com.jeefuse.base.web.result.ResultMsg");
    stringBuffer.append(TEXT_164);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(MethodNamedRuleKind.importDatas.getRuleNamed(uml2Class));
    stringBuffer.append(TEXT_167);
    //code kind define
    List<Property> codeKindPropertiesList=EnumKindHelper.getPropertiesAppliedEnumKind(uml2Class);
    if(null!=codeKindPropertiesList&&codeKindPropertiesList.size()>0){
    	//importManager.addImport("java.util.Map");
    	for(Property property:codeKindPropertiesList){
    		String propertyGetAccessorName=ClassHelper.getGetAccessor(property);
    stringBuffer.append(TEXT_168);
    		Enumeration enumeration=EnumKindHelper.getAppliedEnumKindEnumeration(property);
    		if(null!=enumeration){
    			String modelEnumQualifiedName=MdaHelper.getModelQualifiedName(enumeration,PKGSuffix.enumeration,ModelNameSuffix.enumeration);
    			String modelEnumName=MdaHelper.getModelClassName(enumeration,ModelNameSuffix.enumeration);
    			String modelEnumSelectHtml=NamedUtil.getPropertyNamed(enumeration,PropertyNamedRuleKind.selectHtml);
    			importManager.addImport(modelEnumQualifiedName);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(modelEnumSelectHtml);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(modelEnumName);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(propertyGetAccessorName);
    stringBuffer.append(TEXT_172);
    			String modelEnumJsoncapName=NamedUtil.getPropertyNamed(enumeration,PropertyNamedRuleKind.elementJsonNamed);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(modelEnumJsoncapName);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(modelEnumName);
    stringBuffer.append(TEXT_175);
    		}
    	}
    }
    stringBuffer.append(TEXT_176);
    if(null!=pageAccessAttrList){
     for(String str:pageAccessAttrList){
    stringBuffer.append(TEXT_177);
    stringBuffer.append(NameHelper.getCapName(str));
    stringBuffer.append(TEXT_178);
    if(str.endsWith("Json")){
    stringBuffer.append(TEXT_179);
    stringBuffer.append(str);
    stringBuffer.append(TEXT_180);
    }
    stringBuffer.append(TEXT_181);
    stringBuffer.append(str);
    stringBuffer.append(TEXT_182);
    	}
    stringBuffer.append(TEXT_183);
    }
    stringBuffer.append(TEXT_184);
    importStringBuffer.insert(importInsertionPoint, importManager.computeSortedImports());
    }else if(FileStereotypeHelper.isClass_file(uml2Class_proxy)||FileStereotypeHelper.isClass_Image(uml2Class_proxy)){//应用了File or Image
    Property curProperty = (Property) argument;Package uml2Package = curProperty.getNearestPackage();
    
/******property wrap********/
UmlPropertyWrap propertyWrap=new UmlPropertyWrap(curProperty);
String curPropertyCapName=propertyWrap.getCapName();
//String curPropertyUnCapName=propertyWrap.getUncapName();
String curPropertyComment=propertyWrap.getCommentName();
Class uml2Class=(Class)curProperty.getOwner();

/*******clazz wrap********/
UmlClassWrap clazzWrap=new UmlClassWrap(uml2Class);
String ownerClassCommentName=clazzWrap.getCommentName();

/******** clazz by property wrap ********/
UmlClassByPropertyWrap clazzByPropertyWrap=new UmlClassByPropertyWrap(curProperty);

/******** clazz by Property action define********/
ClassNameDefineByPropertyCommon actionByProperty=clazzByPropertyWrap.getNameDefineActionByProperty();
String modelActionPackageName=actionByProperty.getPackageQualifiedName();
String modelActionClassName=actionByProperty.getClassName();
//String modelActionClassQualifiedName=actionByProperty.getClassQualifiedName();


    stringBuffer.append(TEXT_185);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(modelActionPackageName);
    stringBuffer.append(TEXT_187);
    ImportManager importManager = ImportHelper.makeImportManager("");
    //importManager.addImport("java.util.List");
    //importManager.addImport("java.io.File");
    //importManager.addImport("java.io.IOException");
    importManager.addImport("org.apache.commons.lang.StringUtils");
    importManager.addImport("org.springframework.beans.factory.annotation.Autowired");
    importManager.addImport("org.springframework.util.Assert");
    importManager.addImport("com.opensymphony.xwork2.ModelDriven");
    importManager.addImport("com.jeefuse.base.exception.ApplicationException");
    importManager.addImport("com.jeefuse.base.utils.page.Page");
    importManager.addImport("com.jeefuse.base.web.action.BaseAction");
    importManager.addImport("com.jeefuse.base.web.utils.RenderUtil");
    importManager.addImport("com.jeefuse.base.modules.condition.order.Order");
    importManager.addImport("com.jeefuse.system.security.service.spring.SecurityHolder");
    importManager.addImport("com.jeefuse.system.log.service.SysLogger");
    importManager.addImport("com.jeefuse.base.exception.AppAssert");
    importManager.addImport("com.jeefuse.base.web.utils.RequestUtil");
    
//model entity define
ClassNameDefineCommon entityDefine=clazzWrap.getNameDefineEntity();
String modelEntityQualifiedName=entityDefine.getClassQualifiedName();
//String modelEntityPackage=entityDefine.getPackageQualifiedName();
String modelEntityName=entityDefine.getClassCapName();
String modelEntityUncapName=entityDefine.getClassUncapName();
importManager.addImport(modelEntityQualifiedName);

//model service define
ClassNameDefineCommon serviceDefine=clazzWrap.getNameDefineService();
String modelServiceQualifiedName=serviceDefine.getClassQualifiedName();
//String modelServicePackage=serviceDefine.getPackageQualifiedName();
String modelServiceName=serviceDefine.getClassCapName();
String modelServiceUnCapName=serviceDefine.getClassUncapName();
importManager.addImport(modelServiceQualifiedName);

//model RTO define
ClassNameDefineCommon rtoDefine=clazzWrap.getNameDefineRTO();
String modelRTOQualifiedName=rtoDefine.getClassQualifiedName();
//String modelRTOPackageName=rtoDefine.getPackageQualifiedName();
String modelRTOName=rtoDefine.getClassCapName();
importManager.addImport(modelRTOQualifiedName);

// model RenderUtil define
ClassNameDefineByPropertyCommon renderUtilDefine=clazzByPropertyWrap.getNameDefineRenderUtilByProperty();
String renderUtilQualifiedName=renderUtilDefine.getClassQualifiedName();
String renderUtilName=renderUtilDefine.getClassCapName();
importManager.addImport(renderUtilQualifiedName);

//serviceFacotry define
//UmlPackageWrap umlPackageWrap=new UmlPackageWrap(uml2Package);
//String packageServiceFactoryClassName=umlPackageWrap.getServiceFactoryClassName();
//String packageServiceFactoryClassQualifiedName=umlPackageWrap.getServiceFactoryClassQualifiedName();
//importManager.addImport(packageServiceFactoryClassQualifiedName);

/****** Page access attributes List   *****/
List<String> pageAccessAttrList=new ArrayList<String>();


    
StringBuffer importStringBuffer = stringBuffer;
int importInsertionPoint = stringBuffer.length();
importManager.addCompilationUnitImports(stringBuffer.toString());

    stringBuffer.append(TEXT_188);
    stringBuffer.append(ownerClassCommentName);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(curPropertyComment);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(System.getProperty("user.name"));
    stringBuffer.append(TEXT_191);
    stringBuffer.append(modelActionClassName);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(modelRTOName);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(ownerClassCommentName);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(modelServiceName);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(modelRTOName);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(modelRTOName);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(clazzByPropertyWrap.getValueName());
    stringBuffer.append(TEXT_206);
    stringBuffer.append(clazzByPropertyWrap.getValueGetAccessor());
    stringBuffer.append(TEXT_207);
    stringBuffer.append(clazzByPropertyWrap.getValueName());
    stringBuffer.append(TEXT_208);
    stringBuffer.append(curPropertyComment);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(curPropertyCapName);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(clazzByPropertyWrap.getValueName());
    stringBuffer.append(TEXT_212);
    stringBuffer.append(renderUtilName);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(curPropertyCapName);
    stringBuffer.append(TEXT_214);
    /********is apply image********/
    if(FileStereotypeHelper.isClass_Image(uml2Class)){
    stringBuffer.append(TEXT_215);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_217);
    	pageAccessAttrList.add(modelEntityName+"List");
    stringBuffer.append(TEXT_218);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_220);
    }
    stringBuffer.append(TEXT_221);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(renderUtilName);
    stringBuffer.append(TEXT_223);
    /****** Page access attributes List   *****/
    /********process rel M2MCheckboxs ,M2MCheckboxsTab Property ********/
    List<Property> needM2MCheckboxsList=new ArrayList<Property>();
    List<Property> M2MCheckboxsPropertyList=ViewInputHelper.getApplyM2MCheckboxs(uml2Class);
    if(null!=M2MCheckboxsPropertyList){//M2MCheckboxs 
    	needM2MCheckboxsList.addAll(M2MCheckboxsPropertyList);
    }
    List<Property> M2MCheckboxsTabPropertyList=ViewInputHelper.getApplyM2MCheckboxsTab(uml2Class);
    if(null!=M2MCheckboxsTabPropertyList){//M2MCheckboxsTab 
    	needM2MCheckboxsList.addAll(M2MCheckboxsTabPropertyList);
    }
    if(null!=needM2MCheckboxsList&&needM2MCheckboxsList.size()>0){
    	for(Property property:needM2MCheckboxsList){
    		Type propertyType=property.getType();
    		Class relTargetClass=(Class)propertyType;
    		if(ModelStereoTypeHelper.isApplyModel_M2M(propertyType)||ModelStereoTypeHelper.isApplyModel_M2mWithId(propertyType)){
    			Class relUml2Class=(Class)propertyType;
    			relTargetClass=ModelHelper.getRelTargetClass(relUml2Class,uml2Class);
    		}
    		String relTargetClassCommentName=TypeHelper.getDocumentationOrName(relTargetClass);
    		String relPropertyCheckboxs=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relCheckboxs);
    		String relPropertyCheckboxsDomId=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relCheckboxsDomId);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(relPropertyCheckboxsDomId);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(relPropertyCheckboxs);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(relPropertyCheckboxs);
    stringBuffer.append(TEXT_228);
    		pageAccessAttrList.add(relPropertyCheckboxs);
    	}
    }
    /********process rel M2MCheckboxsTree M2MCheckboxsTreeTab Property********/
    List<Property> needM2MCheckboxsTreeList=new ArrayList<Property>();
    List<Property> M2MCheckboxsTreePropertyList=ViewInputHelper.getApplyM2MCheckboxsTree(uml2Class);
    if(null!=M2MCheckboxsTreePropertyList){//M2MCheckboxsTree 
    	needM2MCheckboxsTreeList.addAll(M2MCheckboxsTreePropertyList);
    }
    List<Property> M2MCheckboxsTreeTabPropertyList=ViewInputHelper.getApplyM2MCheckboxsTreeTab(uml2Class);
    if(null!=M2MCheckboxsTreeTabPropertyList){//M2MCheckboxsTreeTab 
    	needM2MCheckboxsTreeList.addAll(M2MCheckboxsTreeTabPropertyList);
    }
    if(null!=needM2MCheckboxsTreeList&&needM2MCheckboxsTreeList.size()>0){
    	for(Property property:needM2MCheckboxsTreeList){
    		Type propertyType=property.getType();
    		Class relTargetClass=(Class)propertyType;
    		if(ModelStereoTypeHelper.isApplyModel_M2M(propertyType)||ModelStereoTypeHelper.isApplyModel_M2mWithId(propertyType)){
    			Class relUml2Class=(Class)propertyType;
    			relTargetClass=ModelHelper.getRelTargetClass(relUml2Class,uml2Class);
    		}
    		String relTargetClassCommentName=TypeHelper.getDocumentationOrName(relTargetClass);
    		String relPropertyShowCheckTreeJson=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relShowCheckTreeJson);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(relPropertyShowCheckTreeJson);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_231);
    		pageAccessAttrList.add(relPropertyShowCheckTreeJson);
    	}
    }
    stringBuffer.append(TEXT_232);
    /********process rel M2MCheckboxs process********/
    stringBuffer.append(TEXT_233);
    if(null!=M2MCheckboxsPropertyList&&M2MCheckboxsPropertyList.size()>0){
    	for(Property property:M2MCheckboxsPropertyList){
    		Type propertyType=property.getType();
    		Class relTargetClass=(Class)propertyType;
    		if(ModelStereoTypeHelper.isApplyModel_M2M(propertyType)||ModelStereoTypeHelper.isApplyModel_M2mWithId(propertyType)){
    			Class relUml2Class=(Class)propertyType;
    			relTargetClass=ModelHelper.getRelTargetClass(relUml2Class,uml2Class);
    		}
    		String relTargetClassCommentName=TypeHelper.getDocumentationOrName(relTargetClass);
    		//relTargetClassPackageServiceFacotry define
    		String relTargetClassPackageServiceFactoryPackageName=MdaHelper.getPackageQualifiedName(relTargetClass.getNearestPackage(),PKGSuffix.serviceFactory);
    		String relTargetClassPackageServiceFactoryClassName=MdaHelper.getPackageClassName(relTargetClass.getNearestPackage(),ModelNameSuffix.serviceFactory);
    		String relTargetClassPackageServiceFactoryQualifiedName=relTargetClassPackageServiceFactoryPackageName+"."+relTargetClassPackageServiceFactoryClassName;
    		importManager.addImport(relTargetClassPackageServiceFactoryQualifiedName);
    		//model service
    		String relTargetClassServiceQualifiedName=MdaHelper.getModelQualifiedName(relTargetClass,PKGSuffix.service,ModelNameSuffix.Service);
    		String relTargetClassServiceName=ImportHelper.getImportedName(relTargetClassServiceQualifiedName);
    		String relTargetClassServiceUnCapName=NameHelper.uncapName(relTargetClassServiceName);	
    stringBuffer.append(TEXT_234);
    		//relTargetClassCheckboxs
    stringBuffer.append(TEXT_235);
    		String relTargetClassCheckboxs=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relCheckboxs);
    		String relTargetClassCheckboxsDomId=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relCheckboxsDomId);
    		String relTargetClassAllKeyLabelList=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.allKeyLabelList);
    		String relTargetClassGetAllForKeyLabel=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.getAllForKeyLabel);
    stringBuffer.append(TEXT_236);
    		importManager.addImport("com.jeefuse.base.modules.keyLabel.KeyLabel");
    		importManager.addImport("com.jeefuse.base.modules.keyLabel.KeyLabelRenderUtil");
    stringBuffer.append(TEXT_237);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(relTargetClassAllKeyLabelList);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(relTargetClassPackageServiceFactoryClassName);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(relTargetClassServiceUnCapName);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(relTargetClassGetAllForKeyLabel);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(relTargetClassCheckboxs);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(relTargetClassAllKeyLabelList);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(relTargetClassCheckboxsDomId);
    stringBuffer.append(TEXT_245);
    	}
    }
    /********process rel M2MCheckboxsTree process********/
    if(null!=needM2MCheckboxsTreeList&&needM2MCheckboxsTreeList.size()>0){
    	for(Property property:needM2MCheckboxsTreeList){
    		Type propertyType=property.getType();
    		Class relTargetClass=(Class)propertyType;
    		if(ModelStereoTypeHelper.isApplyModel_M2M(propertyType)||ModelStereoTypeHelper.isApplyModel_M2mWithId(propertyType)){
    			Class relUml2Class=(Class)propertyType;
    			relTargetClass=ModelHelper.getRelTargetClass(relUml2Class,uml2Class);
    		}
    		String relTargetClassCapName=NameHelper.getCapName(relTargetClass);
    		String relTargetClassUncapName=NameHelper.getUncapName(relTargetClass);
    		String relTargetClassCommentName=TypeHelper.getDocumentationOrName(relTargetClass);
    		//relTargetClassPackageServiceFacotry define
    		String relTargetClassPackageServiceFactoryPackageName=MdaHelper.getPackageQualifiedName(relTargetClass.getNearestPackage(),PKGSuffix.serviceFactory);
    		String relTargetClassPackageServiceFactoryClassName=MdaHelper.getPackageClassName(relTargetClass.getNearestPackage(),ModelNameSuffix.serviceFactory);
    		String relTargetClassPackageServiceFactoryQualifiedName=relTargetClassPackageServiceFactoryPackageName+"."+relTargetClassPackageServiceFactoryClassName;
    		importManager.addImport(relTargetClassPackageServiceFactoryQualifiedName);
    		//model service
    		String relTargetClassServiceQualifiedName=MdaHelper.getModelQualifiedName(relTargetClass,PKGSuffix.service,ModelNameSuffix.Service);
    		String relTargetClassServiceName=ImportHelper.getImportedName(relTargetClassServiceQualifiedName);
    		String relTargetClassServiceUnCapName=NameHelper.uncapName(relTargetClassServiceName);	
    stringBuffer.append(TEXT_246);
    		//relPropertyShowCheckTree
    		String relTargetClassShowCheckTreeJson=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relShowCheckTreeJson);
    		String relTargetClassAllTreeviewList=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.allTreeviewList);
    		String relTargetClassGetAllForTreeviewList=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.getAllForTreeviewList);
    stringBuffer.append(TEXT_247);
    		importManager.addImport("com.jeefuse.base.modules.tree.renders.treeview.TreeViewItem");
    		importManager.addImport("com.jeefuse.base.modules.tree.TreeRenderUtil");
    stringBuffer.append(TEXT_248);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(relTargetClassAllTreeviewList);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(relTargetClassPackageServiceFactoryClassName);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(relTargetClassServiceUnCapName);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(relTargetClassGetAllForTreeviewList);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(relTargetClassShowCheckTreeJson);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(relTargetClassAllTreeviewList);
    stringBuffer.append(TEXT_255);
    	}
    }
    stringBuffer.append(TEXT_256);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_257);
    /********process rel M2MCheckboxs process********/
    stringBuffer.append(TEXT_258);
    if(null!=M2MCheckboxsPropertyList&&M2MCheckboxsPropertyList.size()>0){
    	for(Property property:M2MCheckboxsPropertyList){
    		Type propertyType=property.getType();
    		Class relTargetClass=(Class)propertyType;
    		if(ModelStereoTypeHelper.isApplyModel_M2M(propertyType)||ModelStereoTypeHelper.isApplyModel_M2mWithId(propertyType)){
    			Class relUml2Class=(Class)propertyType;
    			relTargetClass=ModelHelper.getRelTargetClass(relUml2Class,uml2Class);
    		}
    		String relTargetClassCommentName=TypeHelper.getDocumentationOrName(relTargetClass);
    		//relTargetClassPackageServiceFacotry define
    		String relTargetClassPackageServiceFactoryPackageName=MdaHelper.getPackageQualifiedName(relTargetClass.getNearestPackage(),PKGSuffix.serviceFactory);
    		String relTargetClassPackageServiceFactoryClassName=MdaHelper.getPackageClassName(relTargetClass.getNearestPackage(),ModelNameSuffix.serviceFactory);
    		String relTargetClassPackageServiceFactoryQualifiedName=relTargetClassPackageServiceFactoryPackageName+"."+relTargetClassPackageServiceFactoryClassName;
    		importManager.addImport(relTargetClassPackageServiceFactoryQualifiedName);
    		//model service
    		String relTargetClassServiceQualifiedName=MdaHelper.getModelQualifiedName(relTargetClass,PKGSuffix.service,ModelNameSuffix.Service);
    		String relTargetClassServiceName=ImportHelper.getImportedName(relTargetClassServiceQualifiedName);
    		String relTargetClassServiceUnCapName=NameHelper.uncapName(relTargetClassServiceName);	
    stringBuffer.append(TEXT_259);
    		//relPropertyCheckboxs
    stringBuffer.append(TEXT_260);
    		String relTargetClassCheckboxs=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relCheckboxs);
    		String relTargetClassCheckboxsDomId=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relCheckboxsDomId);
    		String relTargetClassAllKeyLabelList=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.allKeyLabelList);
    		String relTargetClassGetAllForKeyLabel=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.getAllForKeyLabel);
    stringBuffer.append(TEXT_261);
    		String relTargetClassIdsList=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relIdsList);
    stringBuffer.append(TEXT_262);
    		String relTargetClassGetRelIdsMethodName=ModelHelper.getRelIdsMethodName(relTargetClass,uml2Class);
    stringBuffer.append(TEXT_263);
    		importManager.addImport("com.jeefuse.base.modules.keyLabel.KeyLabel");
    		importManager.addImport("com.jeefuse.base.modules.keyLabel.KeyLabelRenderUtil");
    stringBuffer.append(TEXT_264);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(relTargetClassAllKeyLabelList);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(relTargetClassPackageServiceFactoryClassName);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(relTargetClassServiceUnCapName);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(relTargetClassGetAllForKeyLabel);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(relTargetClassIdsList);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(relTargetClassPackageServiceFactoryClassName);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(relTargetClassServiceUnCapName);
    stringBuffer.append(TEXT_272);
    stringBuffer.append(relTargetClassGetRelIdsMethodName);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(relTargetClassCheckboxs);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(relTargetClassAllKeyLabelList);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(relTargetClassIdsList);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(relTargetClassCheckboxsDomId);
    stringBuffer.append(TEXT_277);
    	}
    }
    stringBuffer.append(TEXT_278);
    /********process rel M2MCheckboxsTree process********/
    if(null!=needM2MCheckboxsTreeList&&needM2MCheckboxsTreeList.size()>0){
    	for(Property property:needM2MCheckboxsTreeList){
    		Type propertyType=property.getType();
    		Class relTargetClass=(Class)propertyType;
    		if(ModelStereoTypeHelper.isApplyModel_M2M(propertyType)||ModelStereoTypeHelper.isApplyModel_M2mWithId(propertyType)){
    			Class relUml2Class=(Class)propertyType;
    			relTargetClass=ModelHelper.getRelTargetClass(relUml2Class,uml2Class);
    		}
    		String relTargetClassCapName=NameHelper.getCapName(relTargetClass);
    		String relTargetClassUncapName=NameHelper.getUncapName(relTargetClass);
    		String relTargetClassCommentName=TypeHelper.getDocumentationOrName(relTargetClass);
    		//relTargetClassPackageServiceFacotry define
    		String relTargetClassPackageServiceFactoryPackageName=MdaHelper.getPackageQualifiedName(relTargetClass.getNearestPackage(),PKGSuffix.serviceFactory);
    		String relTargetClassPackageServiceFactoryClassName=MdaHelper.getPackageClassName(relTargetClass.getNearestPackage(),ModelNameSuffix.serviceFactory);
    		String relTargetClassPackageServiceFactoryQualifiedName=relTargetClassPackageServiceFactoryPackageName+"."+relTargetClassPackageServiceFactoryClassName;
    		importManager.addImport(relTargetClassPackageServiceFactoryQualifiedName);
    		//model service
    		String relTargetClassServiceQualifiedName=MdaHelper.getModelQualifiedName(relTargetClass,PKGSuffix.service,ModelNameSuffix.Service);
    		String relTargetClassServiceName=ImportHelper.getImportedName(relTargetClassServiceQualifiedName);
    		String relTargetClassServiceUnCapName=NameHelper.uncapName(relTargetClassServiceName);	
    stringBuffer.append(TEXT_279);
    		//relPropertyShowCheckTree
    		String relTargetClassShowCheckTreeJson=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relShowCheckTreeJson);
    		String relTargetClassAllTreeviewList=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.allTreeviewList);
    		String relTargetClassGetAllForTreeviewList=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.getAllForTreeviewList);
    stringBuffer.append(TEXT_280);
    		String relTargetClassIdsList=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relIdsList);
    stringBuffer.append(TEXT_281);
    		String relTargetClassGetRelIdsMethodName=ModelHelper.getRelIdsMethodName(relTargetClass,uml2Class);
    stringBuffer.append(TEXT_282);
    		importManager.addImport("com.jeefuse.base.modules.tree.renders.treeview.TreeViewItem");
    		importManager.addImport("com.jeefuse.base.modules.tree.TreeRenderUtil");
    stringBuffer.append(TEXT_283);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_284);
    stringBuffer.append(relTargetClassAllTreeviewList);
    stringBuffer.append(TEXT_285);
    stringBuffer.append(relTargetClassPackageServiceFactoryClassName);
    stringBuffer.append(TEXT_286);
    stringBuffer.append(relTargetClassServiceUnCapName);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(relTargetClassGetAllForTreeviewList);
    stringBuffer.append(TEXT_288);
    stringBuffer.append(relTargetClassIdsList);
    stringBuffer.append(TEXT_289);
    stringBuffer.append(relTargetClassPackageServiceFactoryClassName);
    stringBuffer.append(TEXT_290);
    stringBuffer.append(relTargetClassServiceUnCapName);
    stringBuffer.append(TEXT_291);
    stringBuffer.append(relTargetClassGetRelIdsMethodName);
    stringBuffer.append(TEXT_292);
    stringBuffer.append(relTargetClassShowCheckTreeJson);
    stringBuffer.append(TEXT_293);
    stringBuffer.append(relTargetClassAllTreeviewList);
    stringBuffer.append(TEXT_294);
    stringBuffer.append(relTargetClassIdsList);
    stringBuffer.append(TEXT_295);
    	}
    }
    stringBuffer.append(TEXT_296);
    stringBuffer.append(clazzByPropertyWrap.getValueName());
    stringBuffer.append(TEXT_297);
    stringBuffer.append(clazzByPropertyWrap.getValueGetAccessor());
    stringBuffer.append(TEXT_298);
    stringBuffer.append(clazzByPropertyWrap.getValueName());
    stringBuffer.append(TEXT_299);
    stringBuffer.append(curPropertyComment);
    stringBuffer.append(TEXT_300);
    /********process rel M2MCheckIdsList ********/
    List<Property> M2MCheckIdsList=new ArrayList<Property>();
    if(null!=M2MCheckboxsPropertyList){//M2MCheckboxs 
    	M2MCheckIdsList.addAll(M2MCheckboxsPropertyList);
    }
    if(null!=M2MCheckboxsTabPropertyList){//M2MCheckboxsTab 
    	M2MCheckIdsList.addAll(M2MCheckboxsTabPropertyList);
    }
    if(null!=M2MCheckboxsTreePropertyList){//M2MCheckboxsTree 
    	M2MCheckIdsList.addAll(M2MCheckboxsTreePropertyList);
    }
    if(null!=M2MCheckboxsTreeTabPropertyList){//M2MCheckboxsTreeTab 
    	M2MCheckIdsList.addAll(M2MCheckboxsTreeTabPropertyList);
    }
    StringBuilder saveCheckIdsSb=new StringBuilder();
    if(null!=M2MCheckIdsList&&M2MCheckIdsList.size()>0){
    	saveCheckIdsSb.append(",");
    	for(Iterator<Property> it=M2MCheckIdsList.iterator();it.hasNext();){
    		Type propertyType=it.next().getType();
    		Class relTargetClass=(Class)propertyType;
    		if(ModelStereoTypeHelper.isApplyModel_M2M(propertyType)||ModelStereoTypeHelper.isApplyModel_M2mWithId(propertyType)){
    			Class relUml2Class=(Class)propertyType;
    			relTargetClass=ModelHelper.getRelTargetClass(relUml2Class,uml2Class);
    		}
    		String relTargetClassCheckIds=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relCheckIds);
    stringBuffer.append(TEXT_301);
    		String relTargetClassGetRelCheckIdsMethod=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.getRelCheckIdsMethod);
    stringBuffer.append(TEXT_302);
    stringBuffer.append(relTargetClassCheckIds);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(relTargetClassGetRelCheckIdsMethod);
    stringBuffer.append(TEXT_304);
    		saveCheckIdsSb.append(relTargetClassCheckIds);
    stringBuffer.append(TEXT_305);
    		if(it.hasNext())saveCheckIdsSb.append(",");
    	}
    }
    importManager.addImport("com.jeefuse.base.web.uploadFile.UploadFile");
    /********model exportFileUpload********/
    //String modelFileUploadPackageName=MdaHelper.getPackageQualifiedName(uml2Class,PKGSuffix.fileUpload);
    String modelFileUploadClassName=MdaHelper.getModelClassName(uml2Class,ModelNameSuffix.fileUpload);
    String modelFileUploadQualifiedClassName=MdaHelper.getModelQualifiedName(uml2Class,PKGSuffix.fileUpload,ModelNameSuffix.fileUpload);
    importManager.addImport(modelFileUploadQualifiedClassName);
    Property propertyFileExtention=FileStereotypeHelper.getProperty_FileExtention(uml2Class);
    Property propertyFileApplyFileName=FileStereotypeHelper.getProperty_FileName(uml2Class);
    Property propertyFileFileSavePath=FileStereotypeHelper.getProperty_FileSavePath(uml2Class);
    Property propertyFileFileSize=FileStereotypeHelper.getProperty_FileSize(uml2Class);
    Property propertyFileFileType=FileStereotypeHelper.getProperty_FileType(uml2Class);
    stringBuffer.append(TEXT_306);
    stringBuffer.append(modelFileUploadClassName);
    stringBuffer.append(TEXT_307);
    if(null!=propertyFileFileSavePath){
    		//String propertyGetAccessorName=ClassHelper.getGetAccessor(propertyFileFileSavePath);
    stringBuffer.append(TEXT_308);
    		String propertySetAccessorName="set"+ClassHelper.getAccessorName(propertyFileFileSavePath);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(propertySetAccessorName);
    stringBuffer.append(TEXT_310);
    }else{
    stringBuffer.append(TEXT_311);
    }
    stringBuffer.append(TEXT_312);
    if(null!=propertyFileFileSize){
    		//String propertyGetAccessorName=ClassHelper.getGetAccessor(propertyFileFileSize);
    stringBuffer.append(TEXT_313);
    		String propertySetAccessorName="set"+ClassHelper.getAccessorName(propertyFileFileSize);
    stringBuffer.append(TEXT_314);
    stringBuffer.append(propertySetAccessorName);
    stringBuffer.append(TEXT_315);
    }
    if(null!=propertyFileExtention){
    		//String propertyGetAccessorName=ClassHelper.getGetAccessor(propertyFileExtention);
    stringBuffer.append(TEXT_316);
    		String propertySetAccessorName="set"+ClassHelper.getAccessorName(propertyFileExtention);
    stringBuffer.append(TEXT_317);
    stringBuffer.append(propertySetAccessorName);
    stringBuffer.append(TEXT_318);
    }
    if(null!=propertyFileFileType){
    		//String propertyGetAccessorName=ClassHelper.getGetAccessor(propertyFileFileType);
    stringBuffer.append(TEXT_319);
    		String propertySetAccessorName="set"+ClassHelper.getAccessorName(propertyFileFileType);
    stringBuffer.append(TEXT_320);
    stringBuffer.append(propertySetAccessorName);
    stringBuffer.append(TEXT_321);
    }
    if(null!=propertyFileApplyFileName){
    		//String propertyGetAccessorName=ClassHelper.getGetAccessor(propertyFileApplyFileName);
    stringBuffer.append(TEXT_322);
    		String propertySetAccessorName="set"+ClassHelper.getAccessorName(propertyFileApplyFileName);
    stringBuffer.append(TEXT_323);
    stringBuffer.append(propertySetAccessorName);
    stringBuffer.append(TEXT_324);
    }
    stringBuffer.append(TEXT_325);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_326);
    stringBuffer.append(saveCheckIdsSb.toString());
    stringBuffer.append(TEXT_327);
    stringBuffer.append(renderUtilName);
    stringBuffer.append(TEXT_328);
    stringBuffer.append(curPropertyCapName);
    stringBuffer.append(TEXT_329);
    importManager.addImport("org.hibernate.validator.InvalidStateException");
    stringBuffer.append(TEXT_330);
    
//model validate
String modelQualifiedForValidate=MdaHelper.getModelQualifiedName(uml2Class,PKGSuffix.Validate,ModelNameSuffix.Validate);
//String modelPackageNameForValidate=MdaHelper.getPackageQualifiedName(uml2Class,PKGSuffix.Validate);
String modelClassNameForValidate=MdaHelper.getModelClassName(uml2Class,ModelNameSuffix.Validate);
importManager.addImport(modelQualifiedForValidate);

    stringBuffer.append(TEXT_331);
    stringBuffer.append(modelClassNameForValidate);
    stringBuffer.append(TEXT_332);
    importManager.addImport("com.jeefuse.base.exception.AppAssert");
    stringBuffer.append(TEXT_333);
    stringBuffer.append(clazzByPropertyWrap.getValueName());
    stringBuffer.append(TEXT_334);
    stringBuffer.append(clazzByPropertyWrap.getValueGetAccessor());
    stringBuffer.append(TEXT_335);
    stringBuffer.append(clazzByPropertyWrap.getValueName());
    stringBuffer.append(TEXT_336);
    stringBuffer.append(curPropertyComment);
    stringBuffer.append(TEXT_337);
    StringBuilder updateCheckIdsSb=new StringBuilder();
    if(null!=M2MCheckIdsList&&M2MCheckIdsList.size()>0){
    	updateCheckIdsSb.append(",");
    	for(Iterator<Property> it=M2MCheckIdsList.iterator();it.hasNext();){
    		Type propertyType=it.next().getType();
    		Class relTargetClass=(Class)propertyType;
    		if(ModelStereoTypeHelper.isApplyModel_M2M(propertyType)||ModelStereoTypeHelper.isApplyModel_M2mWithId(propertyType)){
    			Class relUml2Class=(Class)propertyType;
    			relTargetClass=ModelHelper.getRelTargetClass(relUml2Class,uml2Class);
    		}
    		String relTargetClassCheckIds=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relCheckIds);
    stringBuffer.append(TEXT_338);
    		String relTargetClassGetRelCheckIdsMethod=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.getRelCheckIdsMethod);
    stringBuffer.append(TEXT_339);
    stringBuffer.append(relTargetClassCheckIds);
    stringBuffer.append(TEXT_340);
    stringBuffer.append(relTargetClassGetRelCheckIdsMethod);
    stringBuffer.append(TEXT_341);
    		updateCheckIdsSb.append(relTargetClassCheckIds);
    stringBuffer.append(TEXT_342);
    		if(it.hasNext())updateCheckIdsSb.append(",");
    	}
    }
    stringBuffer.append(TEXT_343);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_344);
    stringBuffer.append(saveCheckIdsSb.toString());
    stringBuffer.append(TEXT_345);
    stringBuffer.append(renderUtilName);
    stringBuffer.append(TEXT_346);
    stringBuffer.append(curPropertyCapName);
    stringBuffer.append(TEXT_347);
    stringBuffer.append(modelClassNameForValidate);
    stringBuffer.append(TEXT_348);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_349);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_350);
    stringBuffer.append(modelEntityUncapName);
    stringBuffer.append(TEXT_351);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_352);
    if(null!=propertyFileFileSavePath){
    		String propertyGetAccessorName=ClassHelper.getGetAccessor(propertyFileFileSavePath);
    stringBuffer.append(TEXT_353);
    		//String propertySetAccessorName="set"+ClassHelper.getAccessorName(propertyFileFileSavePath);
    stringBuffer.append(TEXT_354);
    stringBuffer.append(modelEntityUncapName);
    stringBuffer.append(TEXT_355);
    stringBuffer.append(propertyGetAccessorName);
    stringBuffer.append(TEXT_356);
    }else{
    stringBuffer.append(TEXT_357);
    stringBuffer.append(modelEntityUncapName);
    stringBuffer.append(TEXT_358);
    }
    stringBuffer.append(TEXT_359);
    stringBuffer.append(modelFileUploadClassName);
    stringBuffer.append(TEXT_360);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_361);
    stringBuffer.append(modelEntityUncapName);
    stringBuffer.append(TEXT_362);
    stringBuffer.append(clazzByPropertyWrap.getValueName());
    stringBuffer.append(TEXT_363);
    stringBuffer.append(clazzByPropertyWrap.getValueGetAccessor());
    stringBuffer.append(TEXT_364);
    stringBuffer.append(clazzByPropertyWrap.getValueName());
    stringBuffer.append(TEXT_365);
    stringBuffer.append(curPropertyComment);
    stringBuffer.append(TEXT_366);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_367);
    stringBuffer.append(modelEntityUncapName);
    stringBuffer.append(TEXT_368);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_369);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_370);
    stringBuffer.append(modelEntityUncapName);
    stringBuffer.append(TEXT_371);
    stringBuffer.append(modelEntityUncapName);
    stringBuffer.append(TEXT_372);
    stringBuffer.append(modelEntityUncapName);
    stringBuffer.append(TEXT_373);
    stringBuffer.append(modelFileUploadClassName);
    stringBuffer.append(TEXT_374);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_375);
    stringBuffer.append(modelEntityUncapName);
    stringBuffer.append(TEXT_376);
    //code kind define
    List<Property> codeKindPropertiesList=EnumKindHelper.getPropertiesAppliedEnumKind(uml2Class);
    if(null!=codeKindPropertiesList&&codeKindPropertiesList.size()>0){
    	//importManager.addImport("java.util.Map");
    stringBuffer.append(TEXT_377);
    	for(Property property:codeKindPropertiesList){
    		String propertyGetAccessorName=ClassHelper.getGetAccessor(property);
    stringBuffer.append(TEXT_378);
    		Enumeration enumeration=EnumKindHelper.getAppliedEnumKindEnumeration(property);
    		if(null!=enumeration){
    			String modelEnumQualifiedName=MdaHelper.getModelQualifiedName(enumeration,PKGSuffix.enumeration,ModelNameSuffix.enumeration);
    			String modelEnumName=MdaHelper.getModelClassName(enumeration,ModelNameSuffix.enumeration);
    			String modelEnumSelectHtml=NamedUtil.getPropertyNamed(enumeration,PropertyNamedRuleKind.selectHtml);
    			importManager.addImport(modelEnumQualifiedName);
    stringBuffer.append(TEXT_379);
    stringBuffer.append(modelEnumSelectHtml);
    stringBuffer.append(TEXT_380);
    stringBuffer.append(modelEnumName);
    stringBuffer.append(TEXT_381);
    stringBuffer.append(propertyGetAccessorName);
    stringBuffer.append(TEXT_382);
    			String modelEnumJsoncapName=NamedUtil.getPropertyNamed(enumeration,PropertyNamedRuleKind.elementJsonNamed);
    stringBuffer.append(TEXT_383);
    stringBuffer.append(modelEnumJsoncapName);
    stringBuffer.append(TEXT_384);
    stringBuffer.append(modelEnumName);
    stringBuffer.append(TEXT_385);
    		}
    	}
    }
    stringBuffer.append(TEXT_386);
    if(null!=pageAccessAttrList){
     for(String str:pageAccessAttrList){
    stringBuffer.append(TEXT_387);
    stringBuffer.append(NameHelper.getCapName(str));
    stringBuffer.append(TEXT_388);
    if(str.endsWith("Json")){
    stringBuffer.append(TEXT_389);
    stringBuffer.append(str);
    stringBuffer.append(TEXT_390);
    }
    stringBuffer.append(TEXT_391);
    stringBuffer.append(str);
    stringBuffer.append(TEXT_392);
    	}
    stringBuffer.append(TEXT_393);
    }
    stringBuffer.append(TEXT_394);
    importStringBuffer.insert(importInsertionPoint, importManager.computeSortedImports());
    }else{//只应用了Entity
    Property curProperty = (Property) argument;Package uml2Package = curProperty.getNearestPackage();
    
/******property wrap*/
UmlPropertyWrap propertyWrap=new UmlPropertyWrap(curProperty);
String curPropertyCapName=propertyWrap.getCapName();
//String curPropertyUnCapName=propertyWrap.getUncapName();
String curPropertyComment=propertyWrap.getCommentName();
Class ownerClass=(Class)curProperty.getOwner();

/*******clazz wrap********/
UmlClassWrap clazzWrap=new UmlClassWrap(ownerClass);
String ownerClassCommentName=clazzWrap.getCommentName();

/******** clazz by property wrap ********/
UmlClassByPropertyWrap clazzByPropertyWrap=new UmlClassByPropertyWrap(curProperty);

/******** clazz by Property action define********/
ClassNameDefineByPropertyCommon actionByProperty=clazzByPropertyWrap.getNameDefineActionByProperty();
String modelActionPackageName=actionByProperty.getPackageQualifiedName();
String modelActionClassName=actionByProperty.getClassName();
//String modelActionClassQualifiedName=actionByProperty.getClassQualifiedName();

    stringBuffer.append(TEXT_395);
    stringBuffer.append(TEXT_396);
    stringBuffer.append(modelActionPackageName);
    stringBuffer.append(TEXT_397);
    ImportManager	importManager = ImportHelper.makeImportManager("");
    importManager.addImport("org.apache.commons.lang.StringUtils");
    importManager.addImport("org.springframework.beans.factory.annotation.Autowired");
    importManager.addImport("org.springframework.util.Assert");
    importManager.addImport("com.opensymphony.xwork2.ModelDriven");
    importManager.addImport("com.jeefuse.base.exception.ApplicationException");
    importManager.addImport("com.jeefuse.base.utils.page.Page");
    importManager.addImport("com.jeefuse.base.web.action.BaseAction");
    importManager.addImport("com.jeefuse.base.web.utils.RenderUtil");
    importManager.addImport("com.jeefuse.base.modules.condition.order.Order");
    importManager.addImport("com.jeefuse.system.security.service.spring.SecurityHolder");
    importManager.addImport("com.jeefuse.system.log.service.SysLogger");
    importManager.addImport("com.jeefuse.base.exception.AppAssert");
    importManager.addImport("com.jeefuse.base.web.utils.RequestUtil");
    
//model entity define
ClassNameDefineCommon entityDefine=clazzWrap.getNameDefineEntity();
String modelEntityQualifiedName=entityDefine.getClassQualifiedName();
//String modelEntityPackage=entityDefine.getPackageQualifiedName();
String modelEntityName=entityDefine.getClassCapName();
importManager.addImport(modelEntityQualifiedName);

//model service define
ClassNameDefineCommon serviceDefine=clazzWrap.getNameDefineService();
String modelServiceQualifiedName=serviceDefine.getClassQualifiedName();
//String modelServicePackage=serviceDefine.getPackageQualifiedName();
String modelServiceName=serviceDefine.getClassCapName();
String modelServiceUnCapName=serviceDefine.getClassUncapName();
importManager.addImport(modelServiceQualifiedName);

//model RTO define
ClassNameDefineCommon rtoDefine=clazzWrap.getNameDefineRTO();
String modelRTOQualifiedName=rtoDefine.getClassQualifiedName();
//String modelRTOPackageName=rtoDefine.getPackageQualifiedName();
String modelRTOName=rtoDefine.getClassCapName();
importManager.addImport(modelRTOQualifiedName);

// model RenderUtil define
ClassNameDefineByPropertyCommon renderUtilDefine=clazzByPropertyWrap.getNameDefineRenderUtilByProperty();
String renderUtilQualifiedName=renderUtilDefine.getClassQualifiedName();
String renderUtilName=renderUtilDefine.getClassCapName();
importManager.addImport(renderUtilQualifiedName);

//serviceFacotry define
//UmlPackageWrap umlPackageWrap=new UmlPackageWrap(uml2Package);
//String packageServiceFactoryClassName=umlPackageWrap.getServiceFactoryClassName();
//String packageServiceFactoryClassQualifiedName=umlPackageWrap.getServiceFactoryClassQualifiedName();
//importManager.addImport(packageServiceFactoryClassQualifiedName);

/****** Page access attributes List   *****/
List<String> pageAccessAttrList=new ArrayList<String>();

    
StringBuffer importStringBuffer = stringBuffer;
int importInsertionPoint = stringBuffer.length();
importManager.addCompilationUnitImports(stringBuffer.toString());

    stringBuffer.append(TEXT_398);
    stringBuffer.append(ownerClassCommentName);
    stringBuffer.append(TEXT_399);
    stringBuffer.append(curPropertyComment);
    stringBuffer.append(TEXT_400);
    stringBuffer.append(System.getProperty("user.name"));
    stringBuffer.append(TEXT_401);
    stringBuffer.append(modelActionClassName);
    stringBuffer.append(TEXT_402);
    stringBuffer.append(modelRTOName);
    stringBuffer.append(TEXT_403);
    stringBuffer.append(ownerClassCommentName);
    stringBuffer.append(TEXT_404);
    stringBuffer.append(modelServiceName);
    stringBuffer.append(TEXT_405);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_406);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_407);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_408);
    stringBuffer.append(modelRTOName);
    stringBuffer.append(TEXT_409);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_410);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_411);
    stringBuffer.append(modelRTOName);
    stringBuffer.append(TEXT_412);
    stringBuffer.append(modelRTOName);
    stringBuffer.append(TEXT_413);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_414);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_415);
    String propertyNamePath=clazzByPropertyWrap.getValueNameWithUnderLine();
    stringBuffer.append(TEXT_416);
    stringBuffer.append(propertyNamePath);
    stringBuffer.append(TEXT_417);
    stringBuffer.append(clazzByPropertyWrap.getValueGetAccessor());
    stringBuffer.append(TEXT_418);
    stringBuffer.append(propertyNamePath);
    stringBuffer.append(TEXT_419);
    stringBuffer.append(curPropertyComment);
    stringBuffer.append(TEXT_420);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_421);
    stringBuffer.append(curPropertyCapName);
    stringBuffer.append(TEXT_422);
    stringBuffer.append(propertyNamePath);
    stringBuffer.append(TEXT_423);
    stringBuffer.append(renderUtilName);
    stringBuffer.append(TEXT_424);
    stringBuffer.append(curPropertyCapName);
    stringBuffer.append(TEXT_425);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_426);
    stringBuffer.append(renderUtilName);
    stringBuffer.append(TEXT_427);
    stringBuffer.append(curPropertyCapName);
    stringBuffer.append(TEXT_428);
    /********process rel M2MCheckboxs ,M2MCheckboxsTab Property ********/
    List<Property> needM2MCheckboxsList=new ArrayList<Property>();
    List<Property> M2MCheckboxsPropertyList=ViewInputHelper.getApplyM2MCheckboxs(ownerClass);
    if(null!=M2MCheckboxsPropertyList){//M2MCheckboxs 
    	needM2MCheckboxsList.addAll(M2MCheckboxsPropertyList);
    }
    List<Property> M2MCheckboxsTabPropertyList=ViewInputHelper.getApplyM2MCheckboxsTab(ownerClass);
    if(null!=M2MCheckboxsTabPropertyList){//M2MCheckboxsTab 
    	needM2MCheckboxsList.addAll(M2MCheckboxsTabPropertyList);
    }
    if(null!=needM2MCheckboxsList&&needM2MCheckboxsList.size()>0){
    	for(Property property:needM2MCheckboxsList){
    		Type propertyType=property.getType();
    		Class relTargetClass=(Class)propertyType;
    		if(ModelStereoTypeHelper.isApplyModel_M2M(propertyType)||ModelStereoTypeHelper.isApplyModel_M2mWithId(propertyType)){
    			Class relUml2Class=(Class)propertyType;
    			relTargetClass=ModelHelper.getRelTargetClass(relUml2Class,ownerClass);
    		}
    		String relTargetClassCommentName=TypeHelper.getDocumentationOrName(relTargetClass);
    		String relPropertyCheckboxs=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relCheckboxs);
    		String relPropertyCheckboxsDomId=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relCheckboxsDomId);
    stringBuffer.append(TEXT_429);
    stringBuffer.append(relPropertyCheckboxsDomId);
    stringBuffer.append(TEXT_430);
    stringBuffer.append(relPropertyCheckboxs);
    stringBuffer.append(TEXT_431);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_432);
    stringBuffer.append(relPropertyCheckboxs);
    stringBuffer.append(TEXT_433);
    		pageAccessAttrList.add(relPropertyCheckboxs);
    	}
    }
    /********process rel M2MCheckboxsTree M2MCheckboxsTreeTab Property********/
    List<Property> needM2MCheckboxsTreeList=new ArrayList<Property>();
    List<Property> M2MCheckboxsTreePropertyList=ViewInputHelper.getApplyM2MCheckboxsTree(ownerClass);
    if(null!=M2MCheckboxsTreePropertyList){//M2MCheckboxsTree 
    	needM2MCheckboxsTreeList.addAll(M2MCheckboxsTreePropertyList);
    }
    List<Property> M2MCheckboxsTreeTabPropertyList=ViewInputHelper.getApplyM2MCheckboxsTreeTab(ownerClass);
    if(null!=M2MCheckboxsTreeTabPropertyList){//M2MCheckboxsTreeTab 
    	needM2MCheckboxsTreeList.addAll(M2MCheckboxsTreeTabPropertyList);
    }
    if(null!=needM2MCheckboxsTreeList&&needM2MCheckboxsTreeList.size()>0){
    	for(Property property:needM2MCheckboxsTreeList){
    		Type propertyType=property.getType();
    		Class relTargetClass=(Class)propertyType;
    		if(ModelStereoTypeHelper.isApplyModel_M2M(propertyType)||ModelStereoTypeHelper.isApplyModel_M2mWithId(propertyType)){
    			Class relUml2Class=(Class)propertyType;
    			relTargetClass=ModelHelper.getRelTargetClass(relUml2Class,ownerClass);
    		}
    		String relTargetClassCommentName=TypeHelper.getDocumentationOrName(relTargetClass);
    		String relPropertyShowCheckTreeJson=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relShowCheckTreeJson);
    stringBuffer.append(TEXT_434);
    stringBuffer.append(relPropertyShowCheckTreeJson);
    stringBuffer.append(TEXT_435);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_436);
    		pageAccessAttrList.add(relPropertyShowCheckTreeJson);
    	}
    }
    stringBuffer.append(TEXT_437);
    /********process rel M2MCheckboxs M2MCheckboxsTab process********/
    stringBuffer.append(TEXT_438);
    if(null!=M2MCheckboxsPropertyList&&M2MCheckboxsPropertyList.size()>0){
    	for(Property property:M2MCheckboxsPropertyList){
    		Type propertyType=property.getType();
    		Class relTargetClass=(Class)propertyType;
    		if(ModelStereoTypeHelper.isApplyModel_M2M(propertyType)||ModelStereoTypeHelper.isApplyModel_M2mWithId(propertyType)){
    			Class relUml2Class=(Class)propertyType;
    			relTargetClass=ModelHelper.getRelTargetClass(relUml2Class,ownerClass);
    		}
    		String relTargetClassCommentName=TypeHelper.getDocumentationOrName(relTargetClass);
    		//relTargetClassPackageServiceFacotry define
    		String relTargetClassPackageServiceFactoryPackageName=MdaHelper.getPackageQualifiedName(relTargetClass.getNearestPackage(),PKGSuffix.serviceFactory);
    		String relTargetClassPackageServiceFactoryClassName=MdaHelper.getPackageClassName(relTargetClass.getNearestPackage(),ModelNameSuffix.serviceFactory);
    		String relTargetClassPackageServiceFactoryQualifiedName=relTargetClassPackageServiceFactoryPackageName+"."+relTargetClassPackageServiceFactoryClassName;
    		importManager.addImport(relTargetClassPackageServiceFactoryQualifiedName);
    		//model service
    		String relTargetClassServiceQualifiedName=MdaHelper.getModelQualifiedName(relTargetClass,PKGSuffix.service,ModelNameSuffix.Service);
    		String relTargetClassServiceName=ImportHelper.getImportedName(relTargetClassServiceQualifiedName);
    		String relTargetClassServiceUnCapName=NameHelper.uncapName(relTargetClassServiceName);	
    stringBuffer.append(TEXT_439);
    		//relTargetClassCheckboxs
    stringBuffer.append(TEXT_440);
    		String relTargetClassCheckboxs=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relCheckboxs);
    		String relTargetClassCheckboxsDomId=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relCheckboxsDomId);
    		String relTargetClassAllKeyLabelList=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.allKeyLabelList);
    		String relTargetClassGetAllForKeyLabel=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.getAllForKeyLabel);
    stringBuffer.append(TEXT_441);
    		importManager.addImport("com.jeefuse.base.modules.keyLabel.KeyLabel");
    		importManager.addImport("com.jeefuse.base.modules.keyLabel.KeyLabelRenderUtil");
    stringBuffer.append(TEXT_442);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_443);
    stringBuffer.append(relTargetClassAllKeyLabelList);
    stringBuffer.append(TEXT_444);
    stringBuffer.append(relTargetClassPackageServiceFactoryClassName);
    stringBuffer.append(TEXT_445);
    stringBuffer.append(relTargetClassServiceUnCapName);
    stringBuffer.append(TEXT_446);
    stringBuffer.append(relTargetClassGetAllForKeyLabel);
    stringBuffer.append(TEXT_447);
    stringBuffer.append(relTargetClassCheckboxs);
    stringBuffer.append(TEXT_448);
    stringBuffer.append(relTargetClassAllKeyLabelList);
    stringBuffer.append(TEXT_449);
    stringBuffer.append(relTargetClassCheckboxsDomId);
    stringBuffer.append(TEXT_450);
    	}
    }
    /********process rel M2MCheckboxsTree M2MCheckboxsTreeTab process********/
    if(null!=needM2MCheckboxsTreeList&&needM2MCheckboxsTreeList.size()>0){
    	for(Property property:needM2MCheckboxsTreeList){
    		Type propertyType=property.getType();
    		Class relTargetClass=(Class)propertyType;
    		if(ModelStereoTypeHelper.isApplyModel_M2M(propertyType)||ModelStereoTypeHelper.isApplyModel_M2mWithId(propertyType)){
    			Class relUml2Class=(Class)propertyType;
    			relTargetClass=ModelHelper.getRelTargetClass(relUml2Class,ownerClass);
    		}
    		//String relTargetClassCapName=NameHelper.getCapName(relTargetClass);
    		//String relTargetClassUncapName=NameHelper.getUncapName(relTargetClass);
    		String relTargetClassCommentName=TypeHelper.getDocumentationOrName(relTargetClass);
    		//relTargetClassPackageServiceFacotry define
    		String relTargetClassPackageServiceFactoryPackageName=MdaHelper.getPackageQualifiedName(relTargetClass.getNearestPackage(),PKGSuffix.serviceFactory);
    		String relTargetClassPackageServiceFactoryClassName=MdaHelper.getPackageClassName(relTargetClass.getNearestPackage(),ModelNameSuffix.serviceFactory);
    		String relTargetClassPackageServiceFactoryQualifiedName=relTargetClassPackageServiceFactoryPackageName+"."+relTargetClassPackageServiceFactoryClassName;
    		importManager.addImport(relTargetClassPackageServiceFactoryQualifiedName);
    		//model service
    		String relTargetClassServiceQualifiedName=MdaHelper.getModelQualifiedName(relTargetClass,PKGSuffix.service,ModelNameSuffix.Service);
    		String relTargetClassServiceName=ImportHelper.getImportedName(relTargetClassServiceQualifiedName);
    		String relTargetClassServiceUnCapName=NameHelper.uncapName(relTargetClassServiceName);	
    stringBuffer.append(TEXT_451);
    		//relPropertyShowCheckTree
    		String relTargetClassShowCheckTreeJson=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relShowCheckTreeJson);
    		String relTargetClassAllTreeviewList=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.allTreeviewList);
    		String relTargetClassGetAllForTreeviewList=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.getAllForTreeviewList);
    stringBuffer.append(TEXT_452);
    		importManager.addImport("com.jeefuse.base.modules.tree.renders.treeview.TreeViewItem");
    		importManager.addImport("com.jeefuse.base.modules.tree.TreeRenderUtil");
    stringBuffer.append(TEXT_453);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_454);
    stringBuffer.append(relTargetClassAllTreeviewList);
    stringBuffer.append(TEXT_455);
    stringBuffer.append(relTargetClassPackageServiceFactoryClassName);
    stringBuffer.append(TEXT_456);
    stringBuffer.append(relTargetClassServiceUnCapName);
    stringBuffer.append(TEXT_457);
    stringBuffer.append(relTargetClassGetAllForTreeviewList);
    stringBuffer.append(TEXT_458);
    stringBuffer.append(relTargetClassShowCheckTreeJson);
    stringBuffer.append(TEXT_459);
    stringBuffer.append(relTargetClassAllTreeviewList);
    stringBuffer.append(TEXT_460);
    	}
    }
    stringBuffer.append(TEXT_461);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_462);
    /********process rel M2MCheckboxs M2MCheckboxsTab process********/
    stringBuffer.append(TEXT_463);
    if(null!=M2MCheckboxsPropertyList&&M2MCheckboxsPropertyList.size()>0){
    	for(Property property:M2MCheckboxsPropertyList){
    		Type propertyType=property.getType();
    		Class relTargetClass=(Class)propertyType;
    		if(ModelStereoTypeHelper.isApplyModel_M2M(propertyType)||ModelStereoTypeHelper.isApplyModel_M2mWithId(propertyType)){
    			Class relUml2Class=(Class)propertyType;
    			relTargetClass=ModelHelper.getRelTargetClass(relUml2Class,ownerClass);
    		}
    		String relTargetClassCommentName=TypeHelper.getDocumentationOrName(relTargetClass);
    		//relTargetClassPackageServiceFacotry define
    		String relTargetClassPackageServiceFactoryPackageName=MdaHelper.getPackageQualifiedName(relTargetClass.getNearestPackage(),PKGSuffix.serviceFactory);
    		String relTargetClassPackageServiceFactoryClassName=MdaHelper.getPackageClassName(relTargetClass.getNearestPackage(),ModelNameSuffix.serviceFactory);
    		String relTargetClassPackageServiceFactoryQualifiedName=relTargetClassPackageServiceFactoryPackageName+"."+relTargetClassPackageServiceFactoryClassName;
    		importManager.addImport(relTargetClassPackageServiceFactoryQualifiedName);
    		//model service
    		String relTargetClassServiceQualifiedName=MdaHelper.getModelQualifiedName(relTargetClass,PKGSuffix.service,ModelNameSuffix.Service);
    		String relTargetClassServiceName=ImportHelper.getImportedName(relTargetClassServiceQualifiedName);
    		String relTargetClassServiceUnCapName=NameHelper.uncapName(relTargetClassServiceName);	
    stringBuffer.append(TEXT_464);
    		//relPropertyCheckboxs
    stringBuffer.append(TEXT_465);
    		String relTargetClassCheckboxs=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relCheckboxs);
    		String relTargetClassCheckboxsDomId=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relCheckboxsDomId);
    		String relTargetClassAllKeyLabelList=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.allKeyLabelList);
    		String relTargetClassGetAllForKeyLabel=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.getAllForKeyLabel);
    stringBuffer.append(TEXT_466);
    		String relTargetClassIdsList=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relIdsList);
    stringBuffer.append(TEXT_467);
    		String relTargetClassGetRelIdsMethodName=ModelHelper.getRelIdsMethodName(relTargetClass,ownerClass);
    stringBuffer.append(TEXT_468);
    		importManager.addImport("com.jeefuse.base.modules.keyLabel.KeyLabel");
    		importManager.addImport("com.jeefuse.base.modules.keyLabel.KeyLabelRenderUtil");
    stringBuffer.append(TEXT_469);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_470);
    stringBuffer.append(relTargetClassAllKeyLabelList);
    stringBuffer.append(TEXT_471);
    stringBuffer.append(relTargetClassPackageServiceFactoryClassName);
    stringBuffer.append(TEXT_472);
    stringBuffer.append(relTargetClassServiceUnCapName);
    stringBuffer.append(TEXT_473);
    stringBuffer.append(relTargetClassGetAllForKeyLabel);
    stringBuffer.append(TEXT_474);
    stringBuffer.append(relTargetClassIdsList);
    stringBuffer.append(TEXT_475);
    stringBuffer.append(relTargetClassPackageServiceFactoryClassName);
    stringBuffer.append(TEXT_476);
    stringBuffer.append(relTargetClassServiceUnCapName);
    stringBuffer.append(TEXT_477);
    stringBuffer.append(relTargetClassGetRelIdsMethodName);
    stringBuffer.append(TEXT_478);
    stringBuffer.append(relTargetClassCheckboxs);
    stringBuffer.append(TEXT_479);
    stringBuffer.append(relTargetClassAllKeyLabelList);
    stringBuffer.append(TEXT_480);
    stringBuffer.append(relTargetClassIdsList);
    stringBuffer.append(TEXT_481);
    stringBuffer.append(relTargetClassCheckboxsDomId);
    stringBuffer.append(TEXT_482);
    	}
    }
    stringBuffer.append(TEXT_483);
    /********process rel M2MCheckboxsTree M2MCheckboxsTreeTab process********/
    if(null!=needM2MCheckboxsTreeList&&needM2MCheckboxsTreeList.size()>0){
    	for(Property property:needM2MCheckboxsTreeList){
    		Type propertyType=property.getType();
    		Class relTargetClass=(Class)propertyType;
    		if(ModelStereoTypeHelper.isApplyModel_M2M(propertyType)||ModelStereoTypeHelper.isApplyModel_M2mWithId(propertyType)){
    			Class relUml2Class=(Class)propertyType;
    			relTargetClass=ModelHelper.getRelTargetClass(relUml2Class,ownerClass);
    		}
    		//String relTargetClassCapName=NameHelper.getCapName(relTargetClass);
    		//String relTargetClassUncapName=NameHelper.getUncapName(relTargetClass);
    		String relTargetClassCommentName=TypeHelper.getDocumentationOrName(relTargetClass);
    		//relTargetClassPackageServiceFacotry define
    		String relTargetClassPackageServiceFactoryPackageName=MdaHelper.getPackageQualifiedName(relTargetClass.getNearestPackage(),PKGSuffix.serviceFactory);
    		String relTargetClassPackageServiceFactoryClassName=MdaHelper.getPackageClassName(relTargetClass.getNearestPackage(),ModelNameSuffix.serviceFactory);
    		String relTargetClassPackageServiceFactoryQualifiedName=relTargetClassPackageServiceFactoryPackageName+"."+relTargetClassPackageServiceFactoryClassName;
    		importManager.addImport(relTargetClassPackageServiceFactoryQualifiedName);
    		//model service
    		String relTargetClassServiceQualifiedName=MdaHelper.getModelQualifiedName(relTargetClass,PKGSuffix.service,ModelNameSuffix.Service);
    		String relTargetClassServiceName=ImportHelper.getImportedName(relTargetClassServiceQualifiedName);
    		String relTargetClassServiceUnCapName=NameHelper.uncapName(relTargetClassServiceName);	
    stringBuffer.append(TEXT_484);
    		//relPropertyShowCheckTree
    		String relTargetClassShowCheckTreeJson=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relShowCheckTreeJson);
    		String relTargetClassAllTreeviewList=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.allTreeviewList);
    		String relTargetClassGetAllForTreeviewList=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.getAllForTreeviewList);
    stringBuffer.append(TEXT_485);
    		String relTargetClassIdsList=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relIdsList);
    stringBuffer.append(TEXT_486);
    		String relTargetClassGetRelIdsMethodName=ModelHelper.getRelIdsMethodName(relTargetClass,ownerClass);
    stringBuffer.append(TEXT_487);
    		importManager.addImport("com.jeefuse.base.modules.tree.renders.treeview.TreeViewItem");
    		importManager.addImport("com.jeefuse.base.modules.tree.TreeRenderUtil");
    stringBuffer.append(TEXT_488);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_489);
    stringBuffer.append(relTargetClassAllTreeviewList);
    stringBuffer.append(TEXT_490);
    stringBuffer.append(relTargetClassPackageServiceFactoryClassName);
    stringBuffer.append(TEXT_491);
    stringBuffer.append(relTargetClassServiceUnCapName);
    stringBuffer.append(TEXT_492);
    stringBuffer.append(relTargetClassGetAllForTreeviewList);
    stringBuffer.append(TEXT_493);
    stringBuffer.append(relTargetClassIdsList);
    stringBuffer.append(TEXT_494);
    stringBuffer.append(relTargetClassPackageServiceFactoryClassName);
    stringBuffer.append(TEXT_495);
    stringBuffer.append(relTargetClassServiceUnCapName);
    stringBuffer.append(TEXT_496);
    stringBuffer.append(relTargetClassGetRelIdsMethodName);
    stringBuffer.append(TEXT_497);
    stringBuffer.append(relTargetClassShowCheckTreeJson);
    stringBuffer.append(TEXT_498);
    stringBuffer.append(relTargetClassAllTreeviewList);
    stringBuffer.append(TEXT_499);
    stringBuffer.append(relTargetClassIdsList);
    stringBuffer.append(TEXT_500);
    	}
    }
    stringBuffer.append(TEXT_501);
    stringBuffer.append(propertyNamePath);
    stringBuffer.append(TEXT_502);
    stringBuffer.append(clazzByPropertyWrap.getValueGetAccessor());
    stringBuffer.append(TEXT_503);
    stringBuffer.append(propertyNamePath);
    stringBuffer.append(TEXT_504);
    stringBuffer.append(curPropertyComment);
    stringBuffer.append(TEXT_505);
    /********process rel M2MCheckIdsList ********/
    List<Property> M2MCheckIdsList=new ArrayList<Property>();
    if(null!=M2MCheckboxsPropertyList){//M2MCheckboxs 
    	M2MCheckIdsList.addAll(M2MCheckboxsPropertyList);
    }
    if(null!=M2MCheckboxsTabPropertyList){//M2MCheckboxsTab 
    	M2MCheckIdsList.addAll(M2MCheckboxsTabPropertyList);
    }
    if(null!=M2MCheckboxsTreePropertyList){//M2MCheckboxsTree 
    	M2MCheckIdsList.addAll(M2MCheckboxsTreePropertyList);
    }
    if(null!=M2MCheckboxsTreeTabPropertyList){//M2MCheckboxsTreeTab 
    	M2MCheckIdsList.addAll(M2MCheckboxsTreeTabPropertyList);
    }
    StringBuilder saveCheckIdsSb=new StringBuilder();
    if(null!=M2MCheckIdsList&&M2MCheckIdsList.size()>0){
    	saveCheckIdsSb.append(",");
    	for(Iterator<Property> it=M2MCheckIdsList.iterator();it.hasNext();){
    		Type propertyType=it.next().getType();
    		Class relTargetClass=(Class)propertyType;
    		if(ModelStereoTypeHelper.isApplyModel_M2M(propertyType)||ModelStereoTypeHelper.isApplyModel_M2mWithId(propertyType)){
    			Class relUml2Class=(Class)propertyType;
    			relTargetClass=ModelHelper.getRelTargetClass(relUml2Class,ownerClass);
    		}
    		String relTargetClassCheckIds=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relCheckIds);
    stringBuffer.append(TEXT_506);
    		String relTargetClassGetRelCheckIdsMethod=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.getRelCheckIdsMethod);
    stringBuffer.append(TEXT_507);
    stringBuffer.append(relTargetClassCheckIds);
    stringBuffer.append(TEXT_508);
    stringBuffer.append(relTargetClassGetRelCheckIdsMethod);
    stringBuffer.append(TEXT_509);
    		saveCheckIdsSb.append(relTargetClassCheckIds);
    stringBuffer.append(TEXT_510);
    		if(it.hasNext())saveCheckIdsSb.append(",");
    	}
    }
    stringBuffer.append(TEXT_511);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_512);
    stringBuffer.append(curPropertyCapName);
    stringBuffer.append(TEXT_513);
    stringBuffer.append(propertyNamePath);
    stringBuffer.append(TEXT_514);
    stringBuffer.append(saveCheckIdsSb.toString());
    stringBuffer.append(TEXT_515);
    stringBuffer.append(renderUtilName);
    stringBuffer.append(TEXT_516);
    stringBuffer.append(curPropertyCapName);
    stringBuffer.append(TEXT_517);
    
//model validate
String modelQualifiedForValidate=MdaHelper.getModelQualifiedName(ownerClass,PKGSuffix.Validate,ModelNameSuffix.Validate);
//String modelPackageNameForValidate=MdaHelper.getPackageQualifiedName(uml2Class,PKGSuffix.Validate);
String validateName=MdaHelper.getModelClassName(ownerClass,ModelNameSuffix.Validate);
importManager.addImport(modelQualifiedForValidate);

    stringBuffer.append(TEXT_518);
    stringBuffer.append(validateName);
    stringBuffer.append(TEXT_519);
    stringBuffer.append(propertyNamePath);
    stringBuffer.append(TEXT_520);
    stringBuffer.append(clazzByPropertyWrap.getValueGetAccessor());
    stringBuffer.append(TEXT_521);
    stringBuffer.append(propertyNamePath);
    stringBuffer.append(TEXT_522);
    stringBuffer.append(curPropertyComment);
    stringBuffer.append(TEXT_523);
    StringBuilder updateCheckIdsSb=new StringBuilder();
    if(null!=M2MCheckIdsList&&M2MCheckIdsList.size()>0){
    	updateCheckIdsSb.append(",");
    	for(Iterator<Property> it=M2MCheckIdsList.iterator();it.hasNext();){
    		Type propertyType=it.next().getType();
    		Class relTargetClass=(Class)propertyType;
    		if(ModelStereoTypeHelper.isApplyModel_M2M(propertyType)||ModelStereoTypeHelper.isApplyModel_M2mWithId(propertyType)){
    			Class relUml2Class=(Class)propertyType;
    			relTargetClass=ModelHelper.getRelTargetClass(relUml2Class,ownerClass);
    		}
    		String relTargetClassCheckIds=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relCheckIds);
    stringBuffer.append(TEXT_524);
    		String relTargetClassGetRelCheckIdsMethod=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.getRelCheckIdsMethod);
    stringBuffer.append(TEXT_525);
    stringBuffer.append(relTargetClassCheckIds);
    stringBuffer.append(TEXT_526);
    stringBuffer.append(relTargetClassGetRelCheckIdsMethod);
    stringBuffer.append(TEXT_527);
    		updateCheckIdsSb.append(relTargetClassCheckIds);
    stringBuffer.append(TEXT_528);
    		if(it.hasNext())updateCheckIdsSb.append(",");
    	}
    }
    stringBuffer.append(TEXT_529);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_530);
    stringBuffer.append(curPropertyCapName);
    stringBuffer.append(TEXT_531);
    stringBuffer.append(propertyNamePath);
    stringBuffer.append(TEXT_532);
    stringBuffer.append(saveCheckIdsSb.toString());
    stringBuffer.append(TEXT_533);
    stringBuffer.append(renderUtilName);
    stringBuffer.append(TEXT_534);
    stringBuffer.append(curPropertyCapName);
    stringBuffer.append(TEXT_535);
    importManager.addImport("org.hibernate.validator.InvalidStateException");
    stringBuffer.append(TEXT_536);
    stringBuffer.append(validateName);
    stringBuffer.append(TEXT_537);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_538);
    stringBuffer.append(propertyNamePath);
    stringBuffer.append(TEXT_539);
    stringBuffer.append(clazzByPropertyWrap.getValueGetAccessor());
    stringBuffer.append(TEXT_540);
    stringBuffer.append(propertyNamePath);
    stringBuffer.append(TEXT_541);
    stringBuffer.append(curPropertyComment);
    stringBuffer.append(TEXT_542);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_543);
    stringBuffer.append(curPropertyCapName);
    stringBuffer.append(TEXT_544);
    stringBuffer.append(propertyNamePath);
    stringBuffer.append(TEXT_545);
    
//model exportFactory 
String modelExportFactoryQualifiedName=MdaHelper.getModelQualifiedName(ownerClass,PKGSuffix.exportFactory,ModelNameSuffix.exportFactory);
//String modelExportFactoryPackageName=MdaHelper.getPackageQualifiedName(ownerClass,PKGSuffix.exportFactory);
String modelExportFactoryClassName=MdaHelper.getModelClassName(ownerClass,ModelNameSuffix.exportFactory);
importManager.addImport(modelExportFactoryQualifiedName);

//model excel export file name
//String ExcelExportTemplateFileCapName=PropertyNamedRuleKind.ExcelExportTemplateFileName.getRuleCapNamed(ownerClass);
//String ExcelExportTemplateFileUncapName=PropertyNamedRuleKind.ExcelExportTemplateFileName.getRuleUnCapNamed(ownerClass);


    stringBuffer.append(TEXT_546);
    stringBuffer.append(propertyNamePath);
    stringBuffer.append(TEXT_547);
    stringBuffer.append(clazzByPropertyWrap.getValueGetAccessor());
    stringBuffer.append(TEXT_548);
    stringBuffer.append(propertyNamePath);
    stringBuffer.append(TEXT_549);
    stringBuffer.append(curPropertyComment);
    stringBuffer.append(TEXT_550);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_551);
    stringBuffer.append(curPropertyCapName);
    stringBuffer.append(TEXT_552);
    stringBuffer.append(propertyNamePath);
    stringBuffer.append(TEXT_553);
    stringBuffer.append(modelExportFactoryClassName);
    stringBuffer.append(TEXT_554);
    
//model importFactory
String modelImportFactoryQualifiedName=MdaHelper.getModelQualifiedName(ownerClass,PKGSuffix.importFactory,ModelNameSuffix.importFactory);
//String modelImportFactoryPackageName=MdaHelper.getPackageQualifiedName(ownerClass,PKGSuffix.importFactory);
String modelImportFactoryClassName=MdaHelper.getModelClassName(ownerClass,ModelNameSuffix.importFactory);;
importManager.addImport(modelImportFactoryQualifiedName);

//model excelImport 
//String modelExcelImportQualifiedName=MdaHelper.getModelQualifiedName(uml2Class,PKGSuffix.importExcel,ModelNameSuffix.importExcel);
//String modelExcelImportClassName=MdaHelper.getModelClassName(uml2Class,ModelNameSuffix.importExcel);
//importManager.addImport(modelExcelImportQualifiedName);

//webFileUtil
importManager.addImport("com.jeefuse.base.web.uploadFile.StrutsWebFileUtil");
importManager.addImport("java.util.List");
importManager.addImport("java.io.File");
importManager.addImport("java.io.IOException");

    stringBuffer.append(TEXT_555);
    stringBuffer.append(WebUrlName.importExcelFileProcess.getValue());
    stringBuffer.append(TEXT_556);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_557);
    stringBuffer.append(modelImportFactoryClassName);
    stringBuffer.append(TEXT_558);
    importManager.addImport("com.jeefuse.base.web.result.ResultMsg");
    stringBuffer.append(TEXT_559);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_560);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_561);
    stringBuffer.append(MethodNamedRuleKind.importDatas.getRuleNamed(ownerClass));
    stringBuffer.append(TEXT_562);
    //code kind define
    List<Property> codeKindPropertiesList=EnumKindHelper.getPropertiesAppliedEnumKind(ownerClass);
    if(null!=codeKindPropertiesList&&codeKindPropertiesList.size()>0){
    	//importManager.addImport("java.util.Map");
    	for(Property property:codeKindPropertiesList){
    		String propertyGetAccessorName=ClassHelper.getGetAccessor(property);
    stringBuffer.append(TEXT_563);
    		Enumeration enumeration=EnumKindHelper.getAppliedEnumKindEnumeration(property);
    		if(null!=enumeration){
    			String modelEnumQualifiedName=MdaHelper.getModelQualifiedName(enumeration,PKGSuffix.enumeration,ModelNameSuffix.enumeration);
    			String modelEnumName=MdaHelper.getModelClassName(enumeration,ModelNameSuffix.enumeration);
    			String modelEnumSelectHtml=NamedUtil.getPropertyNamed(enumeration,PropertyNamedRuleKind.selectHtml);
    			importManager.addImport(modelEnumQualifiedName);
    stringBuffer.append(TEXT_564);
    stringBuffer.append(modelEnumSelectHtml);
    stringBuffer.append(TEXT_565);
    stringBuffer.append(modelEnumName);
    stringBuffer.append(TEXT_566);
    stringBuffer.append(propertyGetAccessorName);
    stringBuffer.append(TEXT_567);
    			String modelEnumJsoncapName=NamedUtil.getPropertyNamed(enumeration,PropertyNamedRuleKind.elementJsonNamed);
    stringBuffer.append(TEXT_568);
    stringBuffer.append(modelEnumJsoncapName);
    stringBuffer.append(TEXT_569);
    stringBuffer.append(modelEnumName);
    stringBuffer.append(TEXT_570);
    		}
    	}
    }
    stringBuffer.append(TEXT_571);
    if(null!=pageAccessAttrList){
     for(String str:pageAccessAttrList){
    stringBuffer.append(TEXT_572);
    stringBuffer.append(NameHelper.getCapName(str));
    stringBuffer.append(TEXT_573);
    if(str.endsWith("Json")){
    stringBuffer.append(TEXT_574);
    stringBuffer.append(str);
    stringBuffer.append(TEXT_575);
    }
    stringBuffer.append(TEXT_576);
    stringBuffer.append(str);
    stringBuffer.append(TEXT_577);
    	}
    stringBuffer.append(TEXT_578);
    }
    stringBuffer.append(TEXT_579);
    importStringBuffer.insert(importInsertionPoint, importManager.computeSortedImports());
    }
    stringBuffer.append(TEXT_580);
    return stringBuffer.toString();
  }
}
