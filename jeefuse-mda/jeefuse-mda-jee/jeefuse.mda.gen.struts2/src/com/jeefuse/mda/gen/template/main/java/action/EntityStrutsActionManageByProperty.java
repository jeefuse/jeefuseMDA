package com.jeefuse.mda.gen.template.main.java.action;

import net.taylor.mda.generator.parse.NameRuled.nameRuled.*;
import net.taylor.mda.generator.parse.NameRuled.className.*;
import net.taylor.mda.generator.parse.NameRuled.*;
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

public class EntityStrutsActionManageByProperty
{
  protected static String nl;
  public static synchronized EntityStrutsActionManageByProperty create(String lineSeparator)
  {
    nl = lineSeparator;
    EntityStrutsActionManageByProperty result = new EntityStrutsActionManageByProperty();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "/*" + NL + " * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the \"License\")" + NL + " * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms." + NL + " * email:yonclv@gmail.com" + NL + " */" + NL + "package ";
  protected final String TEXT_3 = ";";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * ";
  protected final String TEXT_5 = " by ";
  protected final String TEXT_6 = " manage action." + NL + " *" + NL + " * @author ";
  protected final String TEXT_7 = NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_8 = " extends BaseAction implements ModelDriven<";
  protected final String TEXT_9 = "> {" + NL + "\t/** @generated */" + NL + "\tprivate static final long serialVersionUID = 1L;" + NL + "\t" + NL + "\t" + NL + "\t/**" + NL + "\t * ";
  protected final String TEXT_10 = " Entity CRUD service." + NL + "\t * @generated" + NL + "\t */" + NL + "\t@Autowired" + NL + "\tprivate ";
  protected final String TEXT_11 = " ";
  protected final String TEXT_12 = ";" + NL + "\t" + NL + "\t/*****************************************************************" + NL + "\t * property define" + NL + "\t *****************************************************************/" + NL + "" + NL + "\t/** @generated */" + NL + "\tprivate Page<";
  protected final String TEXT_13 = "> page=null;" + NL + "\t/** @generated */" + NL + "\tprivate ";
  protected final String TEXT_14 = " mo=null;" + NL + "\t/** @generated */" + NL + "\tprivate ";
  protected final String TEXT_15 = " rto=null;" + NL + "" + NL + "\t/** @generated */" + NL + "\tpublic Page<";
  protected final String TEXT_16 = "> getPage() {" + NL + "\t\tif(null==page)" + NL + "\t\t\tpage=new Page<";
  protected final String TEXT_17 = ">();" + NL + "\t\treturn page;" + NL + "\t}" + NL + "" + NL + "\t/** @generated */" + NL + "\tpublic ";
  protected final String TEXT_18 = " getModel() {" + NL + "\t\tif(null==rto)" + NL + "\t\t\trto = new ";
  protected final String TEXT_19 = "();" + NL + "\t\treturn rto;" + NL + "\t}" + NL + "\t" + NL + "\t/** @generated */" + NL + "\tpublic ";
  protected final String TEXT_20 = " getMo() {" + NL + "\t\tif (null == mo) {" + NL + "\t\t\tmo = new ";
  protected final String TEXT_21 = "();" + NL + "\t\t}" + NL + "\t\treturn mo;" + NL + "\t}" + NL + "" + NL + "\t/************************************************************************" + NL + "\t * request function invoke" + NL + "\t ************************************************************************/" + NL + "" + NL + "\t/**" + NL + "\t * 转向管理页面." + NL + "\t * " + NL + " \t * @generated" + NL + "\t */" + NL + "\tpublic String manage() {" + NL + "\t\ttry {" + NL + "\t\t\tif (SecurityHolder.isUserNoLogin())" + NL + "\t\t\t\treturn LOGIN;" + NL + "\t\t\treturn SUCCESS;" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tSysLogger.appError(e.getMessage(), e,getRequest());" + NL + "\t\t\treturn ERROR;" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\treturn ERROR;" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * 获取Entity列表.返回json格式." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void listOutJson() {" + NL + "\t\ttry {" + NL + "\t\t\tif (SecurityHolder.isUserNoLogin()) {" + NL + "\t\t\t\tRenderUtil.renderJsonNoLogin();" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}";
  protected final String TEXT_22 = "\t\t" + NL + "\t\t\tString ";
  protected final String TEXT_23 = " = getModel().";
  protected final String TEXT_24 = ";" + NL + "\t\t\tAppAssert.isNotblank(";
  protected final String TEXT_25 = ", \"未指定";
  protected final String TEXT_26 = "\");" + NL + "\t\t\tOrder[] orders = RequestUtil.buildOrders(getRequest());" + NL + "\t\t\tpage=";
  protected final String TEXT_27 = ".findBy";
  protected final String TEXT_28 = "(";
  protected final String TEXT_29 = ",getPage(), getModel(), orders);" + NL + "\t\t\t";
  protected final String TEXT_30 = ".jsonFlexiGridBy";
  protected final String TEXT_31 = "(page);" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tSysLogger.appError(e.getMessage(), e,getRequest());" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError(e.getMessage());" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * 根据ID获取Entity对象,返回json格式." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void getOutJson() {" + NL + "\t\ttry {" + NL + "\t\t\tif (SecurityHolder.isUserNoLogin()) {" + NL + "\t\t\t\tRenderUtil.renderJsonNoLogin();" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\tAppAssert.notNull(getModel().getId());" + NL + "\t\t\tmo = ";
  protected final String TEXT_32 = ".get(getModel().getId());" + NL + "\t\t\t";
  protected final String TEXT_33 = ".jsonResultMsgBy";
  protected final String TEXT_34 = "(true, mo, null);" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tSysLogger.appError(e.getMessage(), e,getRequest());" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError(e.getMessage());" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError();" + NL + "\t\t}" + NL + "\t}" + NL + "\t";
  protected final String TEXT_35 = NL + "\tprivate static final String ";
  protected final String TEXT_36 = " = \"";
  protected final String TEXT_37 = "\";//rel ";
  protected final String TEXT_38 = " for checkboxs" + NL + "\tprivate String ";
  protected final String TEXT_39 = ";";
  protected final String TEXT_40 = NL + "\tprivate String ";
  protected final String TEXT_41 = ";// rel ";
  protected final String TEXT_42 = " for Treeview";
  protected final String TEXT_43 = NL + "\t/**根据主键获取Entity,并转向修改页面." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic String edit() {" + NL + "\t\ttry {" + NL + "\t\t\tif (SecurityHolder.isUserNoLogin())" + NL + "\t\t\t\treturn NO_LOGIN;" + NL + "\t\t\tif (StringUtils.isBlank(getModel().getId())) {";
  protected final String TEXT_44 = "\t\t\t\t";
  protected final String TEXT_45 = "\t";
  protected final String TEXT_46 = "\t\t";
  protected final String TEXT_47 = "\t\t\t";
  protected final String TEXT_48 = NL + "\t\t\t\t// rel ";
  protected final String TEXT_49 = " for checkboxs" + NL + "\t\t\t\tList<KeyLabel> ";
  protected final String TEXT_50 = " = ";
  protected final String TEXT_51 = ".get";
  protected final String TEXT_52 = "().";
  protected final String TEXT_53 = "();" + NL + "\t\t\t\t";
  protected final String TEXT_54 = " = KeyLabelRenderUtil.renderHtmlCheckboxs(";
  protected final String TEXT_55 = ", null,";
  protected final String TEXT_56 = " );";
  protected final String TEXT_57 = "\t";
  protected final String TEXT_58 = "\t\t";
  protected final String TEXT_59 = NL + "\t\t\t\t// rel ";
  protected final String TEXT_60 = " for Treeview" + NL + "\t\t\t\tList<TreeViewItem> ";
  protected final String TEXT_61 = " = ";
  protected final String TEXT_62 = ".get";
  protected final String TEXT_63 = "().";
  protected final String TEXT_64 = "();" + NL + "\t\t\t\t";
  protected final String TEXT_65 = " =TreeRenderUtil.jsonTreeviewShowCheckString(";
  protected final String TEXT_66 = ", null);";
  protected final String TEXT_67 = NL + "\t\t\t} else {" + NL + "\t\t\t\tmo = ";
  protected final String TEXT_68 = ".get(getModel().getId());";
  protected final String TEXT_69 = "\t\t\t\t";
  protected final String TEXT_70 = "\t";
  protected final String TEXT_71 = "\t\t";
  protected final String TEXT_72 = "\t";
  protected final String TEXT_73 = "\t";
  protected final String TEXT_74 = "\t\t";
  protected final String TEXT_75 = NL + "\t\t\t\t// rel ";
  protected final String TEXT_76 = " for checkboxs" + NL + "\t\t\t\tList<KeyLabel> ";
  protected final String TEXT_77 = " = ";
  protected final String TEXT_78 = ".get";
  protected final String TEXT_79 = "().";
  protected final String TEXT_80 = "();" + NL + "\t\t\t\tList<String> ";
  protected final String TEXT_81 = " =  ";
  protected final String TEXT_82 = ".get";
  protected final String TEXT_83 = "().";
  protected final String TEXT_84 = "(mo.getId());" + NL + "\t\t\t\t";
  protected final String TEXT_85 = " = KeyLabelRenderUtil.renderHtmlCheckboxs(";
  protected final String TEXT_86 = ",";
  protected final String TEXT_87 = ", ";
  protected final String TEXT_88 = ");";
  protected final String TEXT_89 = "\t\t\t\t";
  protected final String TEXT_90 = "\t";
  protected final String TEXT_91 = "\t\t";
  protected final String TEXT_92 = "\t";
  protected final String TEXT_93 = "\t\t";
  protected final String TEXT_94 = NL + "\t\t\t\t// rel ";
  protected final String TEXT_95 = " for Treeview" + NL + "\t\t\t\tList<TreeViewItem> ";
  protected final String TEXT_96 = " = ";
  protected final String TEXT_97 = ".get";
  protected final String TEXT_98 = "().";
  protected final String TEXT_99 = "();" + NL + "\t\t\t\tList<String> ";
  protected final String TEXT_100 = " = ";
  protected final String TEXT_101 = ".get";
  protected final String TEXT_102 = "().";
  protected final String TEXT_103 = "(mo.getId());" + NL + "\t\t\t\t";
  protected final String TEXT_104 = " =TreeRenderUtil.jsonTreeviewShowCheckString(";
  protected final String TEXT_105 = ", ";
  protected final String TEXT_106 = ");";
  protected final String TEXT_107 = NL + "\t\t\t}" + NL + "\t\t\treturn SUCCESS;" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tSysLogger.appError(e.getMessage(), e,getRequest());" + NL + "\t\t\treturn ERROR;" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\treturn ERROR;" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * 保存或更新Entity,返回json格式." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void saveOutJson() {" + NL + "\t\ttry {" + NL + "\t\t\tif (SecurityHolder.isUserNoLogin()) {" + NL + "\t\t\t\tRenderUtil.renderJsonNoLogin();" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\tString ";
  protected final String TEXT_108 = " = getModel().";
  protected final String TEXT_109 = ";" + NL + "\t\t\tAppAssert.isNotblank(";
  protected final String TEXT_110 = ", \"未指定";
  protected final String TEXT_111 = "\");";
  protected final String TEXT_112 = "\t";
  protected final String TEXT_113 = "\t" + NL + "\t\t\tString[] ";
  protected final String TEXT_114 = " = ChangeUtil.stringToArray(getModel().";
  protected final String TEXT_115 = "(), true);";
  protected final String TEXT_116 = "\t\t\t";
  protected final String TEXT_117 = NL + "\t\t\tmo=";
  protected final String TEXT_118 = ".saveBy";
  protected final String TEXT_119 = "(";
  protected final String TEXT_120 = ",getModel()";
  protected final String TEXT_121 = ");" + NL + "\t\t\t";
  protected final String TEXT_122 = ".jsonResultMsgBy";
  protected final String TEXT_123 = "(true, mo, \"新增成功!\");" + NL + "\t\t\treturn;" + NL + "\t\t} catch (InvalidStateException e) {";
  protected final String TEXT_124 = NL + "\t\t\tString invalidateMsg = ";
  protected final String TEXT_125 = ".getValidateMessageWithHtmlBR(e.getInvalidValues());" + NL + "\t\t\tlogger.error(invalidateMsg, e);" + NL + "\t\t\tSysLogger.appError(invalidateMsg, e, getRequest());" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError(invalidateMsg);" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tSysLogger.appError(e.getMessage(), e,getRequest());" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError(e.getMessage());" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * 更新Entity,返回json格式." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void updateOutJson() {" + NL + "\t\ttry {" + NL + "\t\t\tif (SecurityHolder.isUserNoLogin()) {" + NL + "\t\t\t\tRenderUtil.renderJsonNoLogin();" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\tString ";
  protected final String TEXT_126 = " = getModel().";
  protected final String TEXT_127 = ";" + NL + "\t\t\tAppAssert.isNotblank(";
  protected final String TEXT_128 = ", \"未指定";
  protected final String TEXT_129 = "\");";
  protected final String TEXT_130 = "\t";
  protected final String TEXT_131 = "\t" + NL + "\t\t\tString[] ";
  protected final String TEXT_132 = " = ChangeUtil.stringToArray(getModel().";
  protected final String TEXT_133 = "(), true);";
  protected final String TEXT_134 = "\t\t\t";
  protected final String TEXT_135 = NL + "\t\t\tmo=";
  protected final String TEXT_136 = ".updateBy";
  protected final String TEXT_137 = "(";
  protected final String TEXT_138 = ",getModel()";
  protected final String TEXT_139 = ");" + NL + "\t\t\t";
  protected final String TEXT_140 = ".jsonResultMsgBy";
  protected final String TEXT_141 = "(true, mo, \"更新成功!\");" + NL + "\t\t\treturn; ";
  protected final String TEXT_142 = NL + "\t\t} catch (InvalidStateException e) {" + NL + "\t\t\tString invalidateMsg = ";
  protected final String TEXT_143 = ".getValidateMessageWithHtmlBR(e.getInvalidValues());" + NL + "\t\t\tlogger.error(invalidateMsg, e);" + NL + "\t\t\tSysLogger.appError(invalidateMsg, e, getRequest());" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError(invalidateMsg);" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tSysLogger.appError(e.getMessage(), e,getRequest());" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError(e.getMessage());" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError();" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * 删除Entity,返回json格式." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void deleteOutJson() {" + NL + "\t\ttry {" + NL + "\t\t\tif (SecurityHolder.isUserNoLogin()) {" + NL + "\t\t\t\tRenderUtil.renderJsonNoLogin();" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\tAppAssert.notNull(getModel().getId(), \"未指定删除的对象!\");" + NL + "\t\t\tfinal String[] delIds = StringUtils.split(getModel().getId(), \",\");" + NL + "\t\t\tint delCount = ";
  protected final String TEXT_144 = ".delete(delIds);" + NL + "\t\t\tString msg = delCount == 0?\"无记录删除!\":\"删除成功\" + delCount + \"项记录!\";" + NL + "\t\t\tRenderUtil.renderJsonResultMsgSuccess(msg);" + NL + "\t\t}catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tSysLogger.appError(e.getMessage(), e,getRequest());" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError(e.getMessage());" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * 删除所有Entity,返回json格式." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void deleteAllOutJson() {" + NL + "\t\ttry {" + NL + "\t\t\tif (SecurityHolder.isUserNoLogin()) {" + NL + "\t\t\t\tRenderUtil.renderJsonNoLogin();" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\tString ";
  protected final String TEXT_145 = " = getModel().";
  protected final String TEXT_146 = ";" + NL + "\t\t\tAppAssert.isNotblank(";
  protected final String TEXT_147 = ", \"未指定";
  protected final String TEXT_148 = "\");" + NL + "\t\t\tint delCount = ";
  protected final String TEXT_149 = ".deleteAllBy";
  protected final String TEXT_150 = "(";
  protected final String TEXT_151 = ");" + NL + "\t\t\tString msg = delCount == 0?\"无记录删除!\":\"删除成功\" + delCount + \"项记录!\";" + NL + "\t\t\tRenderUtil.renderJsonResultMsgSuccess(msg);" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tSysLogger.appError(e.getMessage(), e,getRequest());" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError(e.getMessage());" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError();" + NL + "\t\t}" + NL + "\t}" + NL;
  protected final String TEXT_152 = NL + "\t/**" + NL + "\t * 导出 Excel 文件." + NL + "     * @generated" + NL + "\t */" + NL + "\tpublic void exportExcelFile() {" + NL + "\t\ttry {" + NL + "\t\t\tString ";
  protected final String TEXT_153 = " = getModel().";
  protected final String TEXT_154 = ";" + NL + "\t\t\tAppAssert.isNotblank(";
  protected final String TEXT_155 = ", \"未指定";
  protected final String TEXT_156 = "\");" + NL + "\t\t\tOrder[] orders = RequestUtil.buildOrders(getRequest());" + NL + "\t\t\tpage=";
  protected final String TEXT_157 = ".findBy";
  protected final String TEXT_158 = "(";
  protected final String TEXT_159 = ",getPage(), getModel(), orders);" + NL + "\t\t\t";
  protected final String TEXT_160 = ".excelExportAllField(getResponse(), getPage().getResult());" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t}" + NL + "\t}" + NL;
  protected final String TEXT_161 = NL + "\t/**" + NL + "\t * 导入excel文件." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic String importExcelFile() {" + NL + "\t\ttry {" + NL + "\t\t\tif (SecurityHolder.isUserNoLogin())" + NL + "\t\t\t\treturn NO_LOGIN;" + NL + "\t\t\treturn SUCCESS;" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\treturn ERROR;" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * 导入excel 文件处理." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void ";
  protected final String TEXT_162 = "() {" + NL + "" + NL + "\t\ttry {" + NL + "\t\t\tif (SecurityHolder.isUserNoLogin()) {" + NL + "\t\t\t\tRenderUtil.renderJsonNoLogin();" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\tList<File> fileList = StrutsWebFileUtil.getUploadFile(getRequest());" + NL + "\t\t\tif (!fileList.isEmpty()) {" + NL + "\t\t\t\tList<";
  protected final String TEXT_163 = "> importModelList = ";
  protected final String TEXT_164 = ".excelToModel(fileList.get(0));";
  protected final String TEXT_165 = "\t" + NL + "\t\t\t\tResultMsg<";
  protected final String TEXT_166 = "> resultMsg =";
  protected final String TEXT_167 = ".";
  protected final String TEXT_168 = "(importModelList);" + NL + "\t\t\t\tRenderUtil.renderHtml(resultMsg.getMessage());" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\tRenderUtil.renderHtml(\"请上传需要导入的excel文件!\");" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tSysLogger.appError(e.getMessage(), e,getRequest());" + NL + "\t\t\tRenderUtil.renderHtml(e.getMessage());" + NL + "\t\t} catch (IOException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tSysLogger.appError(e.getMessage(), e,getRequest());" + NL + "\t\t\tRenderUtil.renderHtml(\"导入失败!文件加载错误!\");" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderHtml(\"导入失败!\");" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "" + NL + "\t";
  protected final String TEXT_169 = "\t";
  protected final String TEXT_170 = NL + "\t" + NL + "\t/** @generated */" + NL + "\tpublic String get";
  protected final String TEXT_171 = "() {" + NL + "\t\treturn ";
  protected final String TEXT_172 = ".toHtmlSelect(null == mo ? null : mo.";
  protected final String TEXT_173 = "());" + NL + "\t}";
  protected final String TEXT_174 = NL + "\t/** @generated */" + NL + "\tpublic String get";
  protected final String TEXT_175 = "() {" + NL + "\t\treturn ";
  protected final String TEXT_176 = ".toHtmlJSON;" + NL + "\t}";
  protected final String TEXT_177 = NL;
  protected final String TEXT_178 = "\t" + NL + "\t/** @generated */" + NL + "\tpublic String get";
  protected final String TEXT_179 = "() {" + NL + "\t";
  protected final String TEXT_180 = NL + "\t\tif (null == ";
  protected final String TEXT_181 = ")" + NL + "\t\t\treturn \"{}\";" + NL + "\t";
  protected final String TEXT_182 = NL + "\t\treturn ";
  protected final String TEXT_183 = ";" + NL + "\t}";
  protected final String TEXT_184 = "\t";
  protected final String TEXT_185 = "\t" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
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

    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(modelActionPackageName);
    stringBuffer.append(TEXT_3);
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

    stringBuffer.append(TEXT_4);
    stringBuffer.append(ownerClassCommentName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(curPropertyComment);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(System.getProperty("user.name"));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(modelActionClassName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(modelRTOName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(ownerClassCommentName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(modelServiceName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(modelRTOName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(modelRTOName);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(modelRTOName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_21);
    String propertyNamePath=clazzByPropertyWrap.getValueNameWithUnderLine();
    stringBuffer.append(TEXT_22);
    stringBuffer.append(propertyNamePath);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(clazzByPropertyWrap.getValueGetAccessor());
    stringBuffer.append(TEXT_24);
    stringBuffer.append(propertyNamePath);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(curPropertyComment);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(curPropertyCapName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(propertyNamePath);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(renderUtilName);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(curPropertyCapName);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(renderUtilName);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(curPropertyCapName);
    stringBuffer.append(TEXT_34);
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
    stringBuffer.append(TEXT_35);
    stringBuffer.append(relPropertyCheckboxsDomId);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(relPropertyCheckboxs);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(relPropertyCheckboxs);
    stringBuffer.append(TEXT_39);
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
    stringBuffer.append(TEXT_40);
    stringBuffer.append(relPropertyShowCheckTreeJson);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_42);
    		pageAccessAttrList.add(relPropertyShowCheckTreeJson);
    	}
    }
    stringBuffer.append(TEXT_43);
    /********process rel M2MCheckboxs M2MCheckboxsTab process********/
    stringBuffer.append(TEXT_44);
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
    stringBuffer.append(TEXT_45);
    		//relTargetClassCheckboxs
    stringBuffer.append(TEXT_46);
    		String relTargetClassCheckboxs=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relCheckboxs);
    		String relTargetClassCheckboxsDomId=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relCheckboxsDomId);
    		String relTargetClassAllKeyLabelList=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.allKeyLabelList);
    		String relTargetClassGetAllForKeyLabel=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.getAllForKeyLabel);
    stringBuffer.append(TEXT_47);
    		importManager.addImport("com.jeefuse.base.modules.keyLabel.KeyLabel");
    		importManager.addImport("com.jeefuse.base.modules.keyLabel.KeyLabelRenderUtil");
    stringBuffer.append(TEXT_48);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(relTargetClassAllKeyLabelList);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(relTargetClassPackageServiceFactoryClassName);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(relTargetClassServiceUnCapName);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(relTargetClassGetAllForKeyLabel);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(relTargetClassCheckboxs);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(relTargetClassAllKeyLabelList);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(relTargetClassCheckboxsDomId);
    stringBuffer.append(TEXT_56);
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
    stringBuffer.append(TEXT_57);
    		//relPropertyShowCheckTree
    		String relTargetClassShowCheckTreeJson=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relShowCheckTreeJson);
    		String relTargetClassAllTreeviewList=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.allTreeviewList);
    		String relTargetClassGetAllForTreeviewList=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.getAllForTreeviewList);
    stringBuffer.append(TEXT_58);
    		importManager.addImport("com.jeefuse.base.modules.tree.renders.treeview.TreeViewItem");
    		importManager.addImport("com.jeefuse.base.modules.tree.TreeRenderUtil");
    stringBuffer.append(TEXT_59);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(relTargetClassAllTreeviewList);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(relTargetClassPackageServiceFactoryClassName);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(relTargetClassServiceUnCapName);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(relTargetClassGetAllForTreeviewList);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(relTargetClassShowCheckTreeJson);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(relTargetClassAllTreeviewList);
    stringBuffer.append(TEXT_66);
    	}
    }
    stringBuffer.append(TEXT_67);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_68);
    /********process rel M2MCheckboxs M2MCheckboxsTab process********/
    stringBuffer.append(TEXT_69);
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
    stringBuffer.append(TEXT_70);
    		//relPropertyCheckboxs
    stringBuffer.append(TEXT_71);
    		String relTargetClassCheckboxs=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relCheckboxs);
    		String relTargetClassCheckboxsDomId=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relCheckboxsDomId);
    		String relTargetClassAllKeyLabelList=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.allKeyLabelList);
    		String relTargetClassGetAllForKeyLabel=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.getAllForKeyLabel);
    stringBuffer.append(TEXT_72);
    		String relTargetClassIdsList=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relIdsList);
    stringBuffer.append(TEXT_73);
    		String relTargetClassGetRelIdsMethodName=ModelHelper.getRelIdsMethodName(relTargetClass,ownerClass);
    stringBuffer.append(TEXT_74);
    		importManager.addImport("com.jeefuse.base.modules.keyLabel.KeyLabel");
    		importManager.addImport("com.jeefuse.base.modules.keyLabel.KeyLabelRenderUtil");
    stringBuffer.append(TEXT_75);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(relTargetClassAllKeyLabelList);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(relTargetClassPackageServiceFactoryClassName);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(relTargetClassServiceUnCapName);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(relTargetClassGetAllForKeyLabel);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(relTargetClassIdsList);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(relTargetClassPackageServiceFactoryClassName);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(relTargetClassServiceUnCapName);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(relTargetClassGetRelIdsMethodName);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(relTargetClassCheckboxs);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(relTargetClassAllKeyLabelList);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(relTargetClassIdsList);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(relTargetClassCheckboxsDomId);
    stringBuffer.append(TEXT_88);
    	}
    }
    stringBuffer.append(TEXT_89);
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
    stringBuffer.append(TEXT_90);
    		//relPropertyShowCheckTree
    		String relTargetClassShowCheckTreeJson=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relShowCheckTreeJson);
    		String relTargetClassAllTreeviewList=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.allTreeviewList);
    		String relTargetClassGetAllForTreeviewList=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.getAllForTreeviewList);
    stringBuffer.append(TEXT_91);
    		String relTargetClassIdsList=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relIdsList);
    stringBuffer.append(TEXT_92);
    		String relTargetClassGetRelIdsMethodName=ModelHelper.getRelIdsMethodName(relTargetClass,ownerClass);
    stringBuffer.append(TEXT_93);
    		importManager.addImport("com.jeefuse.base.modules.tree.renders.treeview.TreeViewItem");
    		importManager.addImport("com.jeefuse.base.modules.tree.TreeRenderUtil");
    stringBuffer.append(TEXT_94);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(relTargetClassAllTreeviewList);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(relTargetClassPackageServiceFactoryClassName);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(relTargetClassServiceUnCapName);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(relTargetClassGetAllForTreeviewList);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(relTargetClassIdsList);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(relTargetClassPackageServiceFactoryClassName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(relTargetClassServiceUnCapName);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(relTargetClassGetRelIdsMethodName);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(relTargetClassShowCheckTreeJson);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(relTargetClassAllTreeviewList);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(relTargetClassIdsList);
    stringBuffer.append(TEXT_106);
    	}
    }
    stringBuffer.append(TEXT_107);
    stringBuffer.append(propertyNamePath);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(clazzByPropertyWrap.getValueGetAccessor());
    stringBuffer.append(TEXT_109);
    stringBuffer.append(propertyNamePath);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(curPropertyComment);
    stringBuffer.append(TEXT_111);
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
    stringBuffer.append(TEXT_112);
    		String relTargetClassGetRelCheckIdsMethod=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.getRelCheckIdsMethod);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(relTargetClassCheckIds);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(relTargetClassGetRelCheckIdsMethod);
    stringBuffer.append(TEXT_115);
    		saveCheckIdsSb.append(relTargetClassCheckIds);
    stringBuffer.append(TEXT_116);
    		if(it.hasNext())saveCheckIdsSb.append(",");
    	}
    }
    stringBuffer.append(TEXT_117);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(curPropertyCapName);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(propertyNamePath);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(saveCheckIdsSb.toString());
    stringBuffer.append(TEXT_121);
    stringBuffer.append(renderUtilName);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(curPropertyCapName);
    stringBuffer.append(TEXT_123);
    
//model validate
String modelQualifiedForValidate=MdaHelper.getModelQualifiedName(ownerClass,PKGSuffix.Validate,ModelNameSuffix.Validate);
//String modelPackageNameForValidate=MdaHelper.getPackageQualifiedName(uml2Class,PKGSuffix.Validate);
String validateName=MdaHelper.getModelClassName(ownerClass,ModelNameSuffix.Validate);
importManager.addImport(modelQualifiedForValidate);

    stringBuffer.append(TEXT_124);
    stringBuffer.append(validateName);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(propertyNamePath);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(clazzByPropertyWrap.getValueGetAccessor());
    stringBuffer.append(TEXT_127);
    stringBuffer.append(propertyNamePath);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(curPropertyComment);
    stringBuffer.append(TEXT_129);
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
    stringBuffer.append(TEXT_130);
    		String relTargetClassGetRelCheckIdsMethod=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.getRelCheckIdsMethod);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(relTargetClassCheckIds);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(relTargetClassGetRelCheckIdsMethod);
    stringBuffer.append(TEXT_133);
    		updateCheckIdsSb.append(relTargetClassCheckIds);
    stringBuffer.append(TEXT_134);
    		if(it.hasNext())updateCheckIdsSb.append(",");
    	}
    }
    stringBuffer.append(TEXT_135);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(curPropertyCapName);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(propertyNamePath);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(saveCheckIdsSb.toString());
    stringBuffer.append(TEXT_139);
    stringBuffer.append(renderUtilName);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(curPropertyCapName);
    stringBuffer.append(TEXT_141);
    importManager.addImport("org.hibernate.validator.InvalidStateException");
    stringBuffer.append(TEXT_142);
    stringBuffer.append(validateName);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(propertyNamePath);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(clazzByPropertyWrap.getValueGetAccessor());
    stringBuffer.append(TEXT_146);
    stringBuffer.append(propertyNamePath);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(curPropertyComment);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(curPropertyCapName);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(propertyNamePath);
    stringBuffer.append(TEXT_151);
    
//model exportFactory 
String modelExportFactoryQualifiedName=MdaHelper.getModelQualifiedName(ownerClass,PKGSuffix.exportFactory,ModelNameSuffix.exportFactory);
//String modelExportFactoryPackageName=MdaHelper.getPackageQualifiedName(ownerClass,PKGSuffix.exportFactory);
String modelExportFactoryClassName=MdaHelper.getModelClassName(ownerClass,ModelNameSuffix.exportFactory);
importManager.addImport(modelExportFactoryQualifiedName);

//model excel export file name
//String ExcelExportTemplateFileCapName=PropertyNamedRuleKind.ExcelExportTemplateFileName.getRuleCapNamed(ownerClass);
//String ExcelExportTemplateFileUncapName=PropertyNamedRuleKind.ExcelExportTemplateFileName.getRuleUnCapNamed(ownerClass);


    stringBuffer.append(TEXT_152);
    stringBuffer.append(propertyNamePath);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(clazzByPropertyWrap.getValueGetAccessor());
    stringBuffer.append(TEXT_154);
    stringBuffer.append(propertyNamePath);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(curPropertyComment);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(curPropertyCapName);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(propertyNamePath);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(modelExportFactoryClassName);
    stringBuffer.append(TEXT_160);
    
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

    stringBuffer.append(TEXT_161);
    stringBuffer.append(WebUrlName.importExcelFileProcess.getValue());
    stringBuffer.append(TEXT_162);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(modelImportFactoryClassName);
    stringBuffer.append(TEXT_164);
    importManager.addImport("com.jeefuse.base.web.result.ResultMsg");
    stringBuffer.append(TEXT_165);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(MethodNamedRuleKind.importDatas.getRuleNamed(ownerClass));
    stringBuffer.append(TEXT_168);
    //code kind define
    List<Property> codeKindPropertiesList=EnumKindHelper.getPropertiesAppliedEnumKind(ownerClass);
    if(null!=codeKindPropertiesList&&codeKindPropertiesList.size()>0){
    	//importManager.addImport("java.util.Map");
    	for(Property property:codeKindPropertiesList){
    		String propertyGetAccessorName=ClassHelper.getGetAccessor(property);
    stringBuffer.append(TEXT_169);
    		Enumeration enumeration=EnumKindHelper.getAppliedEnumKindEnumeration(property);
    		if(null!=enumeration){
    			String modelEnumQualifiedName=MdaHelper.getModelQualifiedName(enumeration,PKGSuffix.enumeration,ModelNameSuffix.enumeration);
    			String modelEnumName=MdaHelper.getModelClassName(enumeration,ModelNameSuffix.enumeration);
    			String modelEnumSelectHtml=NamedUtil.getPropertyNamed(enumeration,PropertyNamedRuleKind.selectHtml);
    			importManager.addImport(modelEnumQualifiedName);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(modelEnumSelectHtml);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(modelEnumName);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(propertyGetAccessorName);
    stringBuffer.append(TEXT_173);
    			String modelEnumJsoncapName=NamedUtil.getPropertyNamed(enumeration,PropertyNamedRuleKind.elementJsonNamed);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(modelEnumJsoncapName);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(modelEnumName);
    stringBuffer.append(TEXT_176);
    		}
    	}
    }
    stringBuffer.append(TEXT_177);
    if(null!=pageAccessAttrList){
     for(String str:pageAccessAttrList){
    stringBuffer.append(TEXT_178);
    stringBuffer.append(NameHelper.getCapName(str));
    stringBuffer.append(TEXT_179);
    if(str.endsWith("Json")){
    stringBuffer.append(TEXT_180);
    stringBuffer.append(str);
    stringBuffer.append(TEXT_181);
    }
    stringBuffer.append(TEXT_182);
    stringBuffer.append(str);
    stringBuffer.append(TEXT_183);
    	}
    stringBuffer.append(TEXT_184);
    }
    stringBuffer.append(TEXT_185);
    importStringBuffer.insert(importInsertionPoint, importManager.computeSortedImports());
    return stringBuffer.toString();
  }
}
