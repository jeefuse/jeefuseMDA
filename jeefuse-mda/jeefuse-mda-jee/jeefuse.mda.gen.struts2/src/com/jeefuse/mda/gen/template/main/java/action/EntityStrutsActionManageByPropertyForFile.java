package com.jeefuse.mda.gen.template.main.java.action;

import net.taylor.mda.generator.parse.NameRuled.nameRuled.*;
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

public class EntityStrutsActionManageByPropertyForFile
{
  protected static String nl;
  public static synchronized EntityStrutsActionManageByPropertyForFile create(String lineSeparator)
  {
    nl = lineSeparator;
    EntityStrutsActionManageByPropertyForFile result = new EntityStrutsActionManageByPropertyForFile();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "/*" + NL + " * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the \"License\")" + NL + " * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms." + NL + " * email:yonclv@gmail.com" + NL + " */" + NL + "package ";
  protected final String TEXT_3 = ";";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * ";
  protected final String TEXT_5 = " by ";
  protected final String TEXT_6 = " Entity CRUD action." + NL + " *" + NL + " * @author ";
  protected final String TEXT_7 = NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_8 = " extends BaseAction implements ModelDriven<";
  protected final String TEXT_9 = "> {" + NL + "\t/** @generated */" + NL + "\tprivate static final long serialVersionUID = 1L;" + NL + "\t" + NL + "\t/**" + NL + "\t * ";
  protected final String TEXT_10 = " Entity CRUD service." + NL + "\t * @generated" + NL + "\t */" + NL + "\t@Autowired" + NL + "\tprivate ";
  protected final String TEXT_11 = " ";
  protected final String TEXT_12 = ";" + NL + "\t" + NL + "\t/*****************************************************************" + NL + "\t * property define" + NL + "\t/*****************************************************************/" + NL + "" + NL + "\t/** @generated */" + NL + "\tprivate Page<";
  protected final String TEXT_13 = "> page=null;" + NL + "\t/** @generated */" + NL + "\tprivate ";
  protected final String TEXT_14 = " mo=null;" + NL + "\t/** @generated */" + NL + "\tprivate ";
  protected final String TEXT_15 = " rto=null;" + NL + "" + NL + "" + NL + "\t/** @generated */" + NL + "\tpublic Page<";
  protected final String TEXT_16 = "> getPage() {" + NL + "\t\tif(null==page)" + NL + "\t\t\tpage=new Page<";
  protected final String TEXT_17 = ">();" + NL + "\t\treturn page;" + NL + "\t}" + NL + "" + NL + "\t/** @generated */" + NL + "\tpublic ";
  protected final String TEXT_18 = " getModel() {" + NL + "\t\tif(null==rto)" + NL + "\t\t\trto = new ";
  protected final String TEXT_19 = "();" + NL + "\t\treturn rto;" + NL + "\t}" + NL + "\t" + NL + "\t/** @generated */" + NL + "\tpublic ";
  protected final String TEXT_20 = " getMo() {" + NL + "\t\tif (null == mo) {" + NL + "\t\t\tmo = new ";
  protected final String TEXT_21 = "();" + NL + "\t\t}" + NL + "\t\treturn mo;" + NL + "\t}" + NL + "" + NL + "\t/************************************************************************" + NL + "\t * request function invoke" + NL + "\t ************************************************************************/" + NL + "" + NL + "\t/**" + NL + "\t * 转向管理页面." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic String manage() {" + NL + "\t\t\t\ttry {" + NL + "\t\t\tif (SecurityHolder.isUserNoLogin())" + NL + "\t\t\t\treturn LOGIN;" + NL + "\t\t\treturn SUCCESS;" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tSysLogger.appError(e.getMessage(), e,getRequest());" + NL + "\t\t\treturn ERROR;" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\treturn ERROR;" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * 获取Entity列表.返回json格式." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void listOutJson() {" + NL + "\t\ttry {" + NL + "\t\t\tif (SecurityHolder.isUserNoLogin()) {" + NL + "\t\t\t\tRenderUtil.renderJsonNoLogin();" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\tString ";
  protected final String TEXT_22 = " = getModel().";
  protected final String TEXT_23 = ";" + NL + "\t\t\tAppAssert.isNotblank(";
  protected final String TEXT_24 = ", \"未指定";
  protected final String TEXT_25 = "\");" + NL + "\t\t\tOrder[] orders = RequestUtil.buildOrders(getRequest());" + NL + "\t\t\tpage=";
  protected final String TEXT_26 = ".findBy";
  protected final String TEXT_27 = "(";
  protected final String TEXT_28 = ",getPage(), getModel(), orders);" + NL + "\t\t\t";
  protected final String TEXT_29 = ".jsonFlexiGridBy";
  protected final String TEXT_30 = "(page);" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tSysLogger.appError(e.getMessage(), e,getRequest());" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError(e.getMessage());" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError();" + NL + "\t\t}" + NL + "\t}" + NL;
  protected final String TEXT_31 = "\t" + NL + "\t/** @generated */" + NL + "\tprivate List<";
  protected final String TEXT_32 = "> ";
  protected final String TEXT_33 = "List = null;";
  protected final String TEXT_34 = "\t" + NL + "\t" + NL + "\t/**" + NL + "\t * 图片Gallary展示." + NL + "\t * " + NL + "\t */" + NL + "\tpublic String gallaryView() {" + NL + "\t\ttry {" + NL + "\t\t\t";
  protected final String TEXT_35 = "List= ";
  protected final String TEXT_36 = ".getGallaryList(null);//.findByGlDiningMenu(getPage(), getModel(), null);" + NL + "\t\t\treturn SUCCESS;" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tSysLogger.appError(e.getMessage(), e,getRequest());" + NL + "\t\t\taddActionError(e.getMessage());" + NL + "\t\t\treturn ERROR;" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\treturn ERROR;" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_37 = NL + NL + "\t/**" + NL + "\t * 根据ID获取Entity对象,返回json格式." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void getOutJson() {" + NL + "\t\ttry {" + NL + "\t\t\tAppAssert.notNull(getModel().getId());" + NL + "\t\t\tmo = ";
  protected final String TEXT_38 = ".get(getModel().getId());" + NL + "\t\t\t";
  protected final String TEXT_39 = ".jsonResultMsg(true, mo, null);" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError(e.getMessage());" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError();" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_40 = NL + "\tprivate static final String ";
  protected final String TEXT_41 = " = \"";
  protected final String TEXT_42 = "\";//rel ";
  protected final String TEXT_43 = " for checkboxs" + NL + "\tprivate String ";
  protected final String TEXT_44 = ";";
  protected final String TEXT_45 = NL + "\tprivate String ";
  protected final String TEXT_46 = ";// rel ";
  protected final String TEXT_47 = " for Treeview";
  protected final String TEXT_48 = NL + "\t/**根据主键获取Entity,并转向修改页面." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic String edit() {" + NL + "\t\ttry {" + NL + "\t\t\tif (SecurityHolder.isUserNoLogin())" + NL + "\t\t\t\treturn NO_LOGIN;" + NL + "\t\t\tif (StringUtils.isBlank(getModel().getId())) {";
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
  protected final String TEXT_74 = "\t\t\t\t";
  protected final String TEXT_75 = "\t";
  protected final String TEXT_76 = "\t\t";
  protected final String TEXT_77 = "\t";
  protected final String TEXT_78 = "\t";
  protected final String TEXT_79 = "\t\t";
  protected final String TEXT_80 = NL + "\t\t\t\t// rel ";
  protected final String TEXT_81 = " for checkboxs" + NL + "\t\t\t\tList<KeyLabel> ";
  protected final String TEXT_82 = " = ";
  protected final String TEXT_83 = ".get";
  protected final String TEXT_84 = "().";
  protected final String TEXT_85 = "();" + NL + "\t\t\t\tList<String> ";
  protected final String TEXT_86 = " =  ";
  protected final String TEXT_87 = ".get";
  protected final String TEXT_88 = "().";
  protected final String TEXT_89 = "(mo.getId());" + NL + "\t\t\t\t";
  protected final String TEXT_90 = " = KeyLabelRenderUtil.renderHtmlCheckboxs(";
  protected final String TEXT_91 = ",";
  protected final String TEXT_92 = ", ";
  protected final String TEXT_93 = ");";
  protected final String TEXT_94 = "\t\t\t\t";
  protected final String TEXT_95 = "\t";
  protected final String TEXT_96 = "\t\t";
  protected final String TEXT_97 = "\t";
  protected final String TEXT_98 = "\t\t";
  protected final String TEXT_99 = NL + "\t\t\t\t// rel ";
  protected final String TEXT_100 = " for Treeview" + NL + "\t\t\t\tList<TreeViewItem> ";
  protected final String TEXT_101 = " = ";
  protected final String TEXT_102 = ".get";
  protected final String TEXT_103 = "().";
  protected final String TEXT_104 = "();" + NL + "\t\t\t\tList<String> ";
  protected final String TEXT_105 = " = ";
  protected final String TEXT_106 = ".get";
  protected final String TEXT_107 = "().";
  protected final String TEXT_108 = "(mo.getId());" + NL + "\t\t\t\t";
  protected final String TEXT_109 = " =TreeRenderUtil.jsonTreeviewShowCheckString(";
  protected final String TEXT_110 = ", ";
  protected final String TEXT_111 = ");";
  protected final String TEXT_112 = NL + "\t\t\t}" + NL + "\t\t\treturn SUCCESS;" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tSysLogger.appError(e.getMessage(), e,getRequest());" + NL + "\t\t\treturn ERROR;" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\treturn ERROR;" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * 保存或更新Entity,返回json格式." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void saveOutJson() {" + NL + "\t\ttry {" + NL + "\t\t\tif (SecurityHolder.isUserNoLogin()) {" + NL + "\t\t\t\tRenderUtil.renderHtmlNoLogin();" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\tString ";
  protected final String TEXT_113 = " = getModel().";
  protected final String TEXT_114 = ";" + NL + "\t\t\tAppAssert.isNotblank(";
  protected final String TEXT_115 = ", \"未指定";
  protected final String TEXT_116 = "\");";
  protected final String TEXT_117 = "\t";
  protected final String TEXT_118 = "\t" + NL + "\t\t\tString[] ";
  protected final String TEXT_119 = " = ChangeUtil.stringToArray(getModel().";
  protected final String TEXT_120 = "(), true);";
  protected final String TEXT_121 = "\t\t\t";
  protected final String TEXT_122 = NL + "\t\t\tList<UploadFile> uploadFiles = ";
  protected final String TEXT_123 = ".uploadFiles(getRequest());" + NL + "\t\t\tif (null != uploadFiles && !uploadFiles.isEmpty()) {" + NL + "\t\t\t\tmo = getModel().getNewModel();" + NL + "\t\t\t\tint count = 0;" + NL + "\t\t\t\tfor (UploadFile uploadFile : uploadFiles) {";
  protected final String TEXT_124 = "\t";
  protected final String TEXT_125 = NL + "\t\t\t\t\tmo.";
  protected final String TEXT_126 = "(uploadFile.getSavePath());";
  protected final String TEXT_127 = NL + "\t\t\t\t\tmo.setPath(uploadFile.getSavePath());";
  protected final String TEXT_128 = "\t\t\t\t";
  protected final String TEXT_129 = "\t";
  protected final String TEXT_130 = NL + "\t\t\t\t\tmo.";
  protected final String TEXT_131 = "(uploadFile.getSize());";
  protected final String TEXT_132 = "\t";
  protected final String TEXT_133 = NL + "\t\t\t\t\tmo.";
  protected final String TEXT_134 = "(uploadFile.getExtention());";
  protected final String TEXT_135 = "\t";
  protected final String TEXT_136 = NL + "\t\t\t\t\tmo.";
  protected final String TEXT_137 = "(uploadFile.getFileType());";
  protected final String TEXT_138 = "\t";
  protected final String TEXT_139 = NL + "\t\t\t\t\tmo.";
  protected final String TEXT_140 = "(uploadFile.getFileName());";
  protected final String TEXT_141 = NL + "\t\t\t\t\t";
  protected final String TEXT_142 = ".save(getModel()";
  protected final String TEXT_143 = ");" + NL + "\t\t\t\t\tcount++;" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_144 = ".htmlResultMsgBy";
  protected final String TEXT_145 = "(true, mo, \"保存成功\" + count + \"项记录!\");" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\treturn;";
  protected final String TEXT_146 = "\t\t\t" + NL + "\t\t} catch (InvalidStateException e) {";
  protected final String TEXT_147 = NL + "\t\t\tString invalidateMsg = ";
  protected final String TEXT_148 = ".getValidateMessageWithHtmlBR(e.getInvalidValues());" + NL + "\t\t\tlogger.error(invalidateMsg, e);" + NL + "\t\t\tSysLogger.appError(invalidateMsg, e, getRequest());" + NL + "\t\t\tRenderUtil.renderHtmlResultMsgError(invalidateMsg);" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tSysLogger.appError(invalidateMsg, e, getRequest());" + NL + "\t\t\tRenderUtil.renderHtmlResultMsgError(e.getMessage());" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderHtmlResultMsgError();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * 更新Entity,返回json格式." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void updateOutJson() {" + NL + "\t\ttry {";
  protected final String TEXT_149 = NL + "\t\t\tif (SecurityHolder.isUserNoLogin()) {" + NL + "\t\t\t\tRenderUtil.renderHtmlNoLogin();" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\tString ";
  protected final String TEXT_150 = " = getModel().";
  protected final String TEXT_151 = ";" + NL + "\t\t\tAppAssert.isNotblank(";
  protected final String TEXT_152 = ", \"未指定";
  protected final String TEXT_153 = "\");" + NL + "\t\t\tAppAssert.notNull(getModel().getId(), \"未指定更新记录!\");";
  protected final String TEXT_154 = "\t";
  protected final String TEXT_155 = "\t" + NL + "\t\t\tString[] ";
  protected final String TEXT_156 = " = ChangeUtil.stringToArray(getModel().";
  protected final String TEXT_157 = "(), true);";
  protected final String TEXT_158 = "\t\t\t";
  protected final String TEXT_159 = NL + "\t\t\tmo=";
  protected final String TEXT_160 = ".update(getModel()";
  protected final String TEXT_161 = ");" + NL + "\t\t\t";
  protected final String TEXT_162 = ".htmlResultMsgBy";
  protected final String TEXT_163 = "(true, mo, \"更新成功!\");" + NL + "\t\t\treturn; " + NL + "\t\t} catch (InvalidStateException e) {" + NL + "\t\t\tString invalidateMsg = ";
  protected final String TEXT_164 = ".getValidateMessageWithHtmlBR(e.getInvalidValues());" + NL + "\t\t\tlogger.error(invalidateMsg, e);" + NL + "\t\t\tSysLogger.appError(invalidateMsg, e, getRequest());" + NL + "\t\t\tRenderUtil.renderHtmlResultMsgError(invalidateMsg);" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tSysLogger.appError(invalidateMsg, e, getRequest());" + NL + "\t\t\tRenderUtil.renderHtmlResultMsgError(e.getMessage());" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderHtmlResultMsgError();" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * 删除Entity,返回json格式." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void deleteOutJson() {" + NL + "\t\ttry {" + NL + "\t\t\tAppAssert.notNull(getModel().getId(), \"未指定删除的对象!\");" + NL + "\t\t\tfinal String[] delIds = StringUtils.split(getModel().getId(), \",\");" + NL + "\t\t\t//int delCount = ";
  protected final String TEXT_165 = ".delete(delIds);" + NL + "\t\t\tfor (String id : delIds) {" + NL + "\t\t\t\t";
  protected final String TEXT_166 = " ";
  protected final String TEXT_167 = " = ";
  protected final String TEXT_168 = ".get(id);";
  protected final String TEXT_169 = "\t";
  protected final String TEXT_170 = NL + "\t\t\t\tString filePath=";
  protected final String TEXT_171 = ".";
  protected final String TEXT_172 = "();";
  protected final String TEXT_173 = NL + "\t\t\t\tString filePath = ";
  protected final String TEXT_174 = ".getFileSavePath();";
  protected final String TEXT_175 = "\t" + NL + "\t\t\t\t// 删除文件" + NL + "\t\t\t\tif (StringUtils.isNotBlank(filePath)) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_176 = ".deleteFile(filePath, getRequest());" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_177 = ".delete(";
  protected final String TEXT_178 = ");" + NL + "\t\t\t\tdelCount++;" + NL + "\t\t\t}" + NL + "\t\t\tRenderUtil.renderJsonResultMsgSuccess(\"删除成功\" + delCount + \"项记录!\");" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError(e.getMessage());" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * 删除所有Entity,返回json格式." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void deleteAllOutJson() {" + NL + "\t\ttry {" + NL + "\t\t\tString ";
  protected final String TEXT_179 = " = getModel().";
  protected final String TEXT_180 = ";" + NL + "\t\t\tAppAssert.isNotblank(";
  protected final String TEXT_181 = ", \"未指定";
  protected final String TEXT_182 = "\");" + NL + "\t\t\tint delCount = 0;" + NL + "\t\t\tList<";
  protected final String TEXT_183 = "> ";
  protected final String TEXT_184 = "s = ";
  protected final String TEXT_185 = ".getAll();" + NL + "\t\t\tfor (";
  protected final String TEXT_186 = " ";
  protected final String TEXT_187 = " : ";
  protected final String TEXT_188 = "s) {" + NL + "\t\t\t\tString filePath = ";
  protected final String TEXT_189 = ".getPath();" + NL + "\t\t\t\t// 删除文件" + NL + "\t\t\t\tif (StringUtils.isNotBlank(filePath)) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_190 = ".deleteFile(filePath, getRequest());" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_191 = ".delete(";
  protected final String TEXT_192 = ");" + NL + "\t\t\t\tdelCount++;" + NL + "\t\t\t}" + NL + "\t\t\tRenderUtil.renderJsonResultMsgSuccess(\"删除成功\" + delCount + \"项记录!\");" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError(e.getMessage());" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError();" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "" + NL + "\t";
  protected final String TEXT_193 = NL + "\t/************************************************************************" + NL + "\t * code kind define" + NL + "\t ************************************************************************/" + NL + "\t ";
  protected final String TEXT_194 = "\t";
  protected final String TEXT_195 = NL + "\t" + NL + "\t/** @generated */" + NL + "\tpublic String get";
  protected final String TEXT_196 = "() {" + NL + "\t\treturn ";
  protected final String TEXT_197 = ".toHtmlSelect(null == mo ? null : mo.";
  protected final String TEXT_198 = "());" + NL + "\t}";
  protected final String TEXT_199 = NL + "\t/** @generated */" + NL + "\tpublic String get";
  protected final String TEXT_200 = "() {" + NL + "\t\treturn ";
  protected final String TEXT_201 = ".toHtmlJSON;" + NL + "\t}";
  protected final String TEXT_202 = NL;
  protected final String TEXT_203 = "\t" + NL + "" + NL + "\t/** @generated */" + NL + "\tpublic String get";
  protected final String TEXT_204 = "() {" + NL + "\t";
  protected final String TEXT_205 = NL + "\t\tif (null == ";
  protected final String TEXT_206 = ")" + NL + "\t\t\treturn \"{}\";" + NL + "\t";
  protected final String TEXT_207 = NL + "\t\treturn ";
  protected final String TEXT_208 = ";" + NL + "\t}";
  protected final String TEXT_209 = "\t";
  protected final String TEXT_210 = "\t" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
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
    stringBuffer.append(TEXT_2);
    stringBuffer.append(modelActionPackageName);
    stringBuffer.append(TEXT_3);
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
    stringBuffer.append(modelEntityName);
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
    stringBuffer.append(clazzByPropertyWrap.getValueName());
    stringBuffer.append(TEXT_22);
    stringBuffer.append(clazzByPropertyWrap.getValueGetAccessor());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(clazzByPropertyWrap.getValueName());
    stringBuffer.append(TEXT_24);
    stringBuffer.append(curPropertyComment);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(curPropertyCapName);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(clazzByPropertyWrap.getValueName());
    stringBuffer.append(TEXT_28);
    stringBuffer.append(renderUtilName);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(curPropertyCapName);
    stringBuffer.append(TEXT_30);
    /********is apply image********/
    if(FileStereotypeHelper.isClass_Image(uml2Class)){
    stringBuffer.append(TEXT_31);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_33);
    	pageAccessAttrList.add(modelEntityName+"List");
    stringBuffer.append(TEXT_34);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_36);
    }
    stringBuffer.append(TEXT_37);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(renderUtilName);
    stringBuffer.append(TEXT_39);
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
    stringBuffer.append(TEXT_40);
    stringBuffer.append(relPropertyCheckboxsDomId);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(relPropertyCheckboxs);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(relPropertyCheckboxs);
    stringBuffer.append(TEXT_44);
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
    stringBuffer.append(TEXT_45);
    stringBuffer.append(relPropertyShowCheckTreeJson);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_47);
    		pageAccessAttrList.add(relPropertyShowCheckTreeJson);
    	}
    }
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
    /********process rel M2MCheckboxs process********/
    stringBuffer.append(TEXT_74);
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
    stringBuffer.append(TEXT_75);
    		//relPropertyCheckboxs
    stringBuffer.append(TEXT_76);
    		String relTargetClassCheckboxs=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relCheckboxs);
    		String relTargetClassCheckboxsDomId=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relCheckboxsDomId);
    		String relTargetClassAllKeyLabelList=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.allKeyLabelList);
    		String relTargetClassGetAllForKeyLabel=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.getAllForKeyLabel);
    stringBuffer.append(TEXT_77);
    		String relTargetClassIdsList=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relIdsList);
    stringBuffer.append(TEXT_78);
    		String relTargetClassGetRelIdsMethodName=ModelHelper.getRelIdsMethodName(relTargetClass,uml2Class);
    stringBuffer.append(TEXT_79);
    		importManager.addImport("com.jeefuse.base.modules.keyLabel.KeyLabel");
    		importManager.addImport("com.jeefuse.base.modules.keyLabel.KeyLabelRenderUtil");
    stringBuffer.append(TEXT_80);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(relTargetClassAllKeyLabelList);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(relTargetClassPackageServiceFactoryClassName);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(relTargetClassServiceUnCapName);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(relTargetClassGetAllForKeyLabel);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(relTargetClassIdsList);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(relTargetClassPackageServiceFactoryClassName);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(relTargetClassServiceUnCapName);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(relTargetClassGetRelIdsMethodName);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(relTargetClassCheckboxs);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(relTargetClassAllKeyLabelList);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(relTargetClassIdsList);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(relTargetClassCheckboxsDomId);
    stringBuffer.append(TEXT_93);
    	}
    }
    stringBuffer.append(TEXT_94);
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
    stringBuffer.append(TEXT_95);
    		//relPropertyShowCheckTree
    		String relTargetClassShowCheckTreeJson=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relShowCheckTreeJson);
    		String relTargetClassAllTreeviewList=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.allTreeviewList);
    		String relTargetClassGetAllForTreeviewList=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.getAllForTreeviewList);
    stringBuffer.append(TEXT_96);
    		String relTargetClassIdsList=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relIdsList);
    stringBuffer.append(TEXT_97);
    		String relTargetClassGetRelIdsMethodName=ModelHelper.getRelIdsMethodName(relTargetClass,uml2Class);
    stringBuffer.append(TEXT_98);
    		importManager.addImport("com.jeefuse.base.modules.tree.renders.treeview.TreeViewItem");
    		importManager.addImport("com.jeefuse.base.modules.tree.TreeRenderUtil");
    stringBuffer.append(TEXT_99);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(relTargetClassAllTreeviewList);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(relTargetClassPackageServiceFactoryClassName);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(relTargetClassServiceUnCapName);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(relTargetClassGetAllForTreeviewList);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(relTargetClassIdsList);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(relTargetClassPackageServiceFactoryClassName);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(relTargetClassServiceUnCapName);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(relTargetClassGetRelIdsMethodName);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(relTargetClassShowCheckTreeJson);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(relTargetClassAllTreeviewList);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(relTargetClassIdsList);
    stringBuffer.append(TEXT_111);
    	}
    }
    stringBuffer.append(TEXT_112);
    stringBuffer.append(clazzByPropertyWrap.getValueName());
    stringBuffer.append(TEXT_113);
    stringBuffer.append(clazzByPropertyWrap.getValueGetAccessor());
    stringBuffer.append(TEXT_114);
    stringBuffer.append(clazzByPropertyWrap.getValueName());
    stringBuffer.append(TEXT_115);
    stringBuffer.append(curPropertyComment);
    stringBuffer.append(TEXT_116);
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
    stringBuffer.append(TEXT_117);
    		String relTargetClassGetRelCheckIdsMethod=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.getRelCheckIdsMethod);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(relTargetClassCheckIds);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(relTargetClassGetRelCheckIdsMethod);
    stringBuffer.append(TEXT_120);
    		saveCheckIdsSb.append(relTargetClassCheckIds);
    stringBuffer.append(TEXT_121);
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
    stringBuffer.append(TEXT_122);
    stringBuffer.append(modelFileUploadClassName);
    stringBuffer.append(TEXT_123);
    if(null!=propertyFileFileSavePath){
    		//String propertyGetAccessorName=ClassHelper.getGetAccessor(propertyFileFileSavePath);
    stringBuffer.append(TEXT_124);
    		String propertySetAccessorName="set"+ClassHelper.getAccessorName(propertyFileFileSavePath);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(propertySetAccessorName);
    stringBuffer.append(TEXT_126);
    }else{
    stringBuffer.append(TEXT_127);
    }
    stringBuffer.append(TEXT_128);
    if(null!=propertyFileFileSize){
    		//String propertyGetAccessorName=ClassHelper.getGetAccessor(propertyFileFileSize);
    stringBuffer.append(TEXT_129);
    		String propertySetAccessorName="set"+ClassHelper.getAccessorName(propertyFileFileSize);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(propertySetAccessorName);
    stringBuffer.append(TEXT_131);
    }
    if(null!=propertyFileExtention){
    		//String propertyGetAccessorName=ClassHelper.getGetAccessor(propertyFileExtention);
    stringBuffer.append(TEXT_132);
    		String propertySetAccessorName="set"+ClassHelper.getAccessorName(propertyFileExtention);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(propertySetAccessorName);
    stringBuffer.append(TEXT_134);
    }
    if(null!=propertyFileFileType){
    		//String propertyGetAccessorName=ClassHelper.getGetAccessor(propertyFileFileType);
    stringBuffer.append(TEXT_135);
    		String propertySetAccessorName="set"+ClassHelper.getAccessorName(propertyFileFileType);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(propertySetAccessorName);
    stringBuffer.append(TEXT_137);
    }
    if(null!=propertyFileApplyFileName){
    		//String propertyGetAccessorName=ClassHelper.getGetAccessor(propertyFileApplyFileName);
    stringBuffer.append(TEXT_138);
    		String propertySetAccessorName="set"+ClassHelper.getAccessorName(propertyFileApplyFileName);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(propertySetAccessorName);
    stringBuffer.append(TEXT_140);
    }
    stringBuffer.append(TEXT_141);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(saveCheckIdsSb.toString());
    stringBuffer.append(TEXT_143);
    stringBuffer.append(renderUtilName);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(curPropertyCapName);
    stringBuffer.append(TEXT_145);
    importManager.addImport("org.hibernate.validator.InvalidStateException");
    stringBuffer.append(TEXT_146);
    
//model validate
String modelQualifiedForValidate=MdaHelper.getModelQualifiedName(uml2Class,PKGSuffix.Validate,ModelNameSuffix.Validate);
//String modelPackageNameForValidate=MdaHelper.getPackageQualifiedName(uml2Class,PKGSuffix.Validate);
String modelClassNameForValidate=MdaHelper.getModelClassName(uml2Class,ModelNameSuffix.Validate);
importManager.addImport(modelQualifiedForValidate);

    stringBuffer.append(TEXT_147);
    stringBuffer.append(modelClassNameForValidate);
    stringBuffer.append(TEXT_148);
    importManager.addImport("com.jeefuse.base.exception.AppAssert");
    stringBuffer.append(TEXT_149);
    stringBuffer.append(clazzByPropertyWrap.getValueName());
    stringBuffer.append(TEXT_150);
    stringBuffer.append(clazzByPropertyWrap.getValueGetAccessor());
    stringBuffer.append(TEXT_151);
    stringBuffer.append(clazzByPropertyWrap.getValueName());
    stringBuffer.append(TEXT_152);
    stringBuffer.append(curPropertyComment);
    stringBuffer.append(TEXT_153);
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
    stringBuffer.append(TEXT_154);
    		String relTargetClassGetRelCheckIdsMethod=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.getRelCheckIdsMethod);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(relTargetClassCheckIds);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(relTargetClassGetRelCheckIdsMethod);
    stringBuffer.append(TEXT_157);
    		updateCheckIdsSb.append(relTargetClassCheckIds);
    stringBuffer.append(TEXT_158);
    		if(it.hasNext())updateCheckIdsSb.append(",");
    	}
    }
    stringBuffer.append(TEXT_159);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(saveCheckIdsSb.toString());
    stringBuffer.append(TEXT_161);
    stringBuffer.append(renderUtilName);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(curPropertyCapName);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(modelClassNameForValidate);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(modelEntityUncapName);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_168);
    if(null!=propertyFileFileSavePath){
    		String propertyGetAccessorName=ClassHelper.getGetAccessor(propertyFileFileSavePath);
    stringBuffer.append(TEXT_169);
    		//String propertySetAccessorName="set"+ClassHelper.getAccessorName(propertyFileFileSavePath);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(modelEntityUncapName);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(propertyGetAccessorName);
    stringBuffer.append(TEXT_172);
    }else{
    stringBuffer.append(TEXT_173);
    stringBuffer.append(modelEntityUncapName);
    stringBuffer.append(TEXT_174);
    }
    stringBuffer.append(TEXT_175);
    stringBuffer.append(modelFileUploadClassName);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(modelEntityUncapName);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(clazzByPropertyWrap.getValueName());
    stringBuffer.append(TEXT_179);
    stringBuffer.append(clazzByPropertyWrap.getValueGetAccessor());
    stringBuffer.append(TEXT_180);
    stringBuffer.append(clazzByPropertyWrap.getValueName());
    stringBuffer.append(TEXT_181);
    stringBuffer.append(curPropertyComment);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(modelEntityUncapName);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(modelEntityUncapName);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(modelEntityUncapName);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(modelEntityUncapName);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(modelFileUploadClassName);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(modelEntityUncapName);
    stringBuffer.append(TEXT_192);
    //code kind define
    List<Property> codeKindPropertiesList=EnumKindHelper.getPropertiesAppliedEnumKind(uml2Class);
    if(null!=codeKindPropertiesList&&codeKindPropertiesList.size()>0){
    	//importManager.addImport("java.util.Map");
    stringBuffer.append(TEXT_193);
    	for(Property property:codeKindPropertiesList){
    		String propertyGetAccessorName=ClassHelper.getGetAccessor(property);
    stringBuffer.append(TEXT_194);
    		Enumeration enumeration=EnumKindHelper.getAppliedEnumKindEnumeration(property);
    		if(null!=enumeration){
    			String modelEnumQualifiedName=MdaHelper.getModelQualifiedName(enumeration,PKGSuffix.enumeration,ModelNameSuffix.enumeration);
    			String modelEnumName=MdaHelper.getModelClassName(enumeration,ModelNameSuffix.enumeration);
    			String modelEnumSelectHtml=NamedUtil.getPropertyNamed(enumeration,PropertyNamedRuleKind.selectHtml);
    			importManager.addImport(modelEnumQualifiedName);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(modelEnumSelectHtml);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(modelEnumName);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(propertyGetAccessorName);
    stringBuffer.append(TEXT_198);
    			String modelEnumJsoncapName=NamedUtil.getPropertyNamed(enumeration,PropertyNamedRuleKind.elementJsonNamed);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(modelEnumJsoncapName);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(modelEnumName);
    stringBuffer.append(TEXT_201);
    		}
    	}
    }
    stringBuffer.append(TEXT_202);
    if(null!=pageAccessAttrList){
     for(String str:pageAccessAttrList){
    stringBuffer.append(TEXT_203);
    stringBuffer.append(NameHelper.getCapName(str));
    stringBuffer.append(TEXT_204);
    if(str.endsWith("Json")){
    stringBuffer.append(TEXT_205);
    stringBuffer.append(str);
    stringBuffer.append(TEXT_206);
    }
    stringBuffer.append(TEXT_207);
    stringBuffer.append(str);
    stringBuffer.append(TEXT_208);
    	}
    stringBuffer.append(TEXT_209);
    }
    stringBuffer.append(TEXT_210);
    importStringBuffer.insert(importInsertionPoint, importManager.computeSortedImports());
    return stringBuffer.toString();
  }
}
