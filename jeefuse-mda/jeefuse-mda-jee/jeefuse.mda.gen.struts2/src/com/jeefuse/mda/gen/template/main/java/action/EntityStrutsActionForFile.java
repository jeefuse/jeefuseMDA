package com.jeefuse.mda.gen.template.main.java.action;

import net.taylor.mda.generator.parse.entity.*;
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

public class EntityStrutsActionForFile
{
  protected static String nl;
  public static synchronized EntityStrutsActionForFile create(String lineSeparator)
  {
    nl = lineSeparator;
    EntityStrutsActionForFile result = new EntityStrutsActionForFile();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "/*" + NL + " * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the \"License\")" + NL + " * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms." + NL + " * email:yonclv@gmail.com" + NL + " */" + NL + "package ";
  protected final String TEXT_2 = ";";
  protected final String TEXT_3 = NL + NL + "/**" + NL + " * ";
  protected final String TEXT_4 = " Entity CRUD action." + NL + " *" + NL + " * @author ";
  protected final String TEXT_5 = NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " extends BaseAction implements ModelDriven<";
  protected final String TEXT_7 = "> {" + NL + "\t/** @generated */" + NL + "\tprivate static final long serialVersionUID = 1L;" + NL + "\t" + NL + "\t/**" + NL + "\t * ";
  protected final String TEXT_8 = " Entity CRUD service." + NL + "\t * @generated" + NL + "\t */" + NL + "\t@Autowired" + NL + "\tprivate ";
  protected final String TEXT_9 = " ";
  protected final String TEXT_10 = ";" + NL + "\t" + NL + "\t/*****************************************************************" + NL + "\t * property define" + NL + "\t/*****************************************************************/" + NL + "" + NL + "\t/** @generated */" + NL + "\tprivate Page<";
  protected final String TEXT_11 = "> page=null;" + NL + "\t/** @generated */" + NL + "\tprivate ";
  protected final String TEXT_12 = " mo=null;" + NL + "\t/** @generated */" + NL + "\tprivate ";
  protected final String TEXT_13 = " rto=null;" + NL + "" + NL + "" + NL + "\t/** @generated */" + NL + "\tpublic Page<";
  protected final String TEXT_14 = "> getPage() {" + NL + "\t\tif(null==page)" + NL + "\t\t\tpage=new Page<";
  protected final String TEXT_15 = ">();" + NL + "\t\treturn page;" + NL + "\t}" + NL + "" + NL + "\t/** @generated */" + NL + "\tpublic ";
  protected final String TEXT_16 = " getModel() {" + NL + "\t\tif(null==rto)" + NL + "\t\t\trto = new ";
  protected final String TEXT_17 = "();" + NL + "\t\treturn rto;" + NL + "\t}" + NL + "\t" + NL + "\t/** @generated */" + NL + "\tpublic ";
  protected final String TEXT_18 = " getMo() {" + NL + "\t\tif (null == mo) {" + NL + "\t\t\tmo = new ";
  protected final String TEXT_19 = "();" + NL + "\t\t}" + NL + "\t\treturn mo;" + NL + "\t}" + NL + "" + NL + "\t/************************************************************************" + NL + "\t * request function invoke" + NL + "\t ************************************************************************/" + NL;
  protected final String TEXT_20 = " " + NL + "\t/**" + NL + "\t * 转向管理页面." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic String manage() {" + NL + "\t\treturn SUCCESS;" + NL + "\t}";
  protected final String TEXT_21 = NL;
  protected final String TEXT_22 = "\t\t" + NL + "\t/**" + NL + "\t * 获取Entity列表.返回json格式." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void listOutJson() {" + NL + "\t\ttry {" + NL + "\t\t\tOrder[] orders = RequestUtil.buildOrders(getRequest());";
  protected final String TEXT_23 = NL + "\t\t\tpage = ";
  protected final String TEXT_24 = ".findDescendant(page, rto, orders);";
  protected final String TEXT_25 = NL + "\t\t\tpage=";
  protected final String TEXT_26 = ".find(getPage(), getModel(), orders);";
  protected final String TEXT_27 = NL + "\t\t\t";
  protected final String TEXT_28 = ".jsonFlexiGrid(getPage());" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError(e.getMessage());" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError();" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_29 = NL;
  protected final String TEXT_30 = "\t" + NL + "\t/** @generated */" + NL + "\tprivate List<";
  protected final String TEXT_31 = "> ";
  protected final String TEXT_32 = "List = null;";
  protected final String TEXT_33 = "\t" + NL + "\t/**" + NL + "\t * 图片Gallary展示." + NL + "\t */" + NL + "\tpublic String gallaryView() {" + NL + "\t\ttry {" + NL + "\t\t\t";
  protected final String TEXT_34 = "List= ";
  protected final String TEXT_35 = ".getGallaryList(null);//.findByGlDiningMenu(getPage(), getModel(), null);" + NL + "\t\t\treturn SUCCESS;" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\taddActionError(e.getMessage());" + NL + "\t\t\treturn ERROR;" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\treturn ERROR;" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_36 = NL;
  protected final String TEXT_37 = NL + "\t/**" + NL + "\t * 根据ID获取Entity对象,返回json格式." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void getOutJson() {" + NL + "\t\ttry {" + NL + "\t\t\tAppAssert.notNull(getModel().getId());" + NL + "\t\t\tmo = ";
  protected final String TEXT_38 = ".get(getModel().getId());" + NL + "\t\t\t";
  protected final String TEXT_39 = ".jsonResultMsg(true, mo, null);" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError(e.getMessage());" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError();" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_40 = NL;
  protected final String TEXT_41 = NL + "\tprivate static final String ";
  protected final String TEXT_42 = " = \"";
  protected final String TEXT_43 = "\";//rel ";
  protected final String TEXT_44 = " for checkboxs" + NL + "\tprivate String ";
  protected final String TEXT_45 = ";";
  protected final String TEXT_46 = NL + "\tprivate String ";
  protected final String TEXT_47 = ";// rel ";
  protected final String TEXT_48 = " for Treeview";
  protected final String TEXT_49 = NL;
  protected final String TEXT_50 = NL + "\t/**根据主键获取Entity,并转向修改页面." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic String edit() {" + NL + "\t\ttry {" + NL + "\t\t\tif (StringUtils.isBlank(getModel().getId())) {";
  protected final String TEXT_51 = "\t\t\t\t";
  protected final String TEXT_52 = "\t";
  protected final String TEXT_53 = "\t\t";
  protected final String TEXT_54 = "\t\t\t";
  protected final String TEXT_55 = NL + "\t\t\t\t// rel ";
  protected final String TEXT_56 = " for checkboxs" + NL + "\t\t\t\tList<KeyLabel> ";
  protected final String TEXT_57 = " = ";
  protected final String TEXT_58 = ".get";
  protected final String TEXT_59 = "().";
  protected final String TEXT_60 = "();" + NL + "\t\t\t\t";
  protected final String TEXT_61 = " = KeyLabelRenderUtil.renderHtmlCheckboxs(";
  protected final String TEXT_62 = ", null,";
  protected final String TEXT_63 = " );";
  protected final String TEXT_64 = "\t";
  protected final String TEXT_65 = "\t\t";
  protected final String TEXT_66 = NL + "\t\t\t\t// rel ";
  protected final String TEXT_67 = " for Treeview" + NL + "\t\t\t\tList<TreeViewItem> ";
  protected final String TEXT_68 = " = ";
  protected final String TEXT_69 = ".get";
  protected final String TEXT_70 = "().";
  protected final String TEXT_71 = "();" + NL + "\t\t\t\t";
  protected final String TEXT_72 = " =TreeRenderUtil.jsonTreeviewShowCheckString(";
  protected final String TEXT_73 = ", null);";
  protected final String TEXT_74 = NL + "\t\t\t} else {" + NL + "\t\t\t\tmo = ";
  protected final String TEXT_75 = ".get(rto.getId());";
  protected final String TEXT_76 = "\t\t\t\t";
  protected final String TEXT_77 = "\t";
  protected final String TEXT_78 = "\t\t";
  protected final String TEXT_79 = "\t";
  protected final String TEXT_80 = "\t";
  protected final String TEXT_81 = "\t\t";
  protected final String TEXT_82 = NL + "\t\t\t\t// rel ";
  protected final String TEXT_83 = " for checkboxs" + NL + "\t\t\t\tList<KeyLabel> ";
  protected final String TEXT_84 = " = ";
  protected final String TEXT_85 = ".get";
  protected final String TEXT_86 = "().";
  protected final String TEXT_87 = "();" + NL + "\t\t\t\tList<String> ";
  protected final String TEXT_88 = " =  ";
  protected final String TEXT_89 = ".get";
  protected final String TEXT_90 = "().";
  protected final String TEXT_91 = "(mo.getId());" + NL + "\t\t\t\t";
  protected final String TEXT_92 = " = KeyLabelRenderUtil.renderHtmlCheckboxs(";
  protected final String TEXT_93 = ",";
  protected final String TEXT_94 = ", ";
  protected final String TEXT_95 = ");";
  protected final String TEXT_96 = "\t\t\t\t";
  protected final String TEXT_97 = "\t";
  protected final String TEXT_98 = "\t\t";
  protected final String TEXT_99 = "\t";
  protected final String TEXT_100 = "\t\t";
  protected final String TEXT_101 = NL + "\t\t\t\t// rel ";
  protected final String TEXT_102 = " for Treeview" + NL + "\t\t\t\tList<TreeViewItem> ";
  protected final String TEXT_103 = " = ";
  protected final String TEXT_104 = ".get";
  protected final String TEXT_105 = "().";
  protected final String TEXT_106 = "();" + NL + "\t\t\t\tList<String> ";
  protected final String TEXT_107 = " = ";
  protected final String TEXT_108 = ".get";
  protected final String TEXT_109 = "().";
  protected final String TEXT_110 = "(mo.getId());" + NL + "\t\t\t\t";
  protected final String TEXT_111 = " =TreeRenderUtil.jsonTreeviewShowCheckString(";
  protected final String TEXT_112 = ", ";
  protected final String TEXT_113 = ");";
  protected final String TEXT_114 = NL + "\t\t\t}" + NL + "\t\t\treturn SUCCESS;" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\treturn ERROR;" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_115 = NL + "\t";
  protected final String TEXT_116 = NL + "\t/**" + NL + "\t * 保存或更新Entity,返回json格式." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void saveOutJson() {" + NL + "\t\ttry {" + NL + "\t\t\tAssert.notNull(getModel());";
  protected final String TEXT_117 = "\t";
  protected final String TEXT_118 = "\t" + NL + "\t\t\tString[] ";
  protected final String TEXT_119 = " = ChangeUtil.stringToArray(getModel().";
  protected final String TEXT_120 = "(), true);";
  protected final String TEXT_121 = "\t\t\t";
  protected final String TEXT_122 = NL + "\t\t\tList<UploadFile> uploadFiles = ";
  protected final String TEXT_123 = ".uploadFiles(getRequest(),SecurityHolder.getLoginUserId());" + NL + "\t\t\tif (null != uploadFiles && !uploadFiles.isEmpty()) {" + NL + "\t\t\t\tmo = getModel().getNewModel();" + NL + "\t\t\t\tint count = 0;" + NL + "\t\t\t\tfor (UploadFile uploadFile : uploadFiles) {";
  protected final String TEXT_124 = "\t";
  protected final String TEXT_125 = NL + "\t\t\t\t\tmo.";
  protected final String TEXT_126 = "(uploadFile.getSavePath());";
  protected final String TEXT_127 = NL + "\t\t\t\t\tmo.setPath(uploadFile.getSavePath());";
  protected final String TEXT_128 = "\t";
  protected final String TEXT_129 = NL + "\t\t\t\t\tmo.";
  protected final String TEXT_130 = "(uploadFile.getVisitPath());";
  protected final String TEXT_131 = "\t\t\t\t";
  protected final String TEXT_132 = "\t";
  protected final String TEXT_133 = NL + "\t\t\t\t\tmo.";
  protected final String TEXT_134 = "(uploadFile.getSize());";
  protected final String TEXT_135 = "\t";
  protected final String TEXT_136 = NL + "\t\t\t\t\tmo.";
  protected final String TEXT_137 = "(uploadFile.getExtention());";
  protected final String TEXT_138 = "\t";
  protected final String TEXT_139 = NL + "\t\t\t\t\tmo.";
  protected final String TEXT_140 = "(uploadFile.getFileType());";
  protected final String TEXT_141 = "\t";
  protected final String TEXT_142 = NL + "\t\t\t\t\tmo.";
  protected final String TEXT_143 = "(uploadFile.getFileName());";
  protected final String TEXT_144 = NL + "\t\t\t\t\t";
  protected final String TEXT_145 = ".save(getModel()";
  protected final String TEXT_146 = ");" + NL + "\t\t\t\t\tcount++;" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_147 = ".htmlResultMsg(true, mo, \"保存成功\" + count + \"项记录!\");" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\treturn;";
  protected final String TEXT_148 = "\t\t\t" + NL + "\t\t} catch (InvalidStateException e) {";
  protected final String TEXT_149 = NL + "\t\t\tString invalidateMsg = ";
  protected final String TEXT_150 = ".getValidateMessageWithHtmlBR(e.getInvalidValues());" + NL + "\t\t\tlogger.error(invalidateMsg, e);" + NL + "\t\t\tRenderUtil.renderHtmlResultMsgError(invalidateMsg);" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderHtmlResultMsgError(e.getMessage());" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderHtmlResultMsgError();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * 更新Entity,返回json格式." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void updateOutJson() {" + NL + "\t\ttry {";
  protected final String TEXT_151 = NL + "\t\t\tAppAssert.notNull(getModel().getId(), \"未指定更新记录!\");";
  protected final String TEXT_152 = "\t";
  protected final String TEXT_153 = "\t" + NL + "\t\t\tString[] ";
  protected final String TEXT_154 = " = ChangeUtil.stringToArray(getModel().";
  protected final String TEXT_155 = "(), true);";
  protected final String TEXT_156 = "\t\t\t";
  protected final String TEXT_157 = NL;
  protected final String TEXT_158 = " ";
  protected final String TEXT_159 = "= ";
  protected final String TEXT_160 = ".get(getModel().getId());" + NL + "\t\t\tmo = getModel().getModifiedModel(";
  protected final String TEXT_161 = ");" + NL + "\t\t\tList<UploadFile> uploadFiles = GlDiningMenuUploadFile.uploadFile(getRequest());" + NL + "\t\t\tif (null != uploadFiles && !uploadFiles.isEmpty()) {" + NL + "\t\t\t\t// 删除文件" + NL + "\t\t\t\t";
  protected final String TEXT_162 = "\t";
  protected final String TEXT_163 = NL + "\t\t\t\tString filePath=";
  protected final String TEXT_164 = ".";
  protected final String TEXT_165 = "();";
  protected final String TEXT_166 = NL + "\t\t\t\tString filePath = ";
  protected final String TEXT_167 = ".getFileSavePath();";
  protected final String TEXT_168 = "\t" + NL + "\t\t\t\tif (StringUtils.isNotBlank(filePath)) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_169 = ".deleteFile(filePath);" + NL + "\t\t\t\t}" + NL + "\t\t\t\tUploadFile uploadFile = uploadFiles.get(0);";
  protected final String TEXT_170 = "\t";
  protected final String TEXT_171 = NL + "\t\t\t\tmo.";
  protected final String TEXT_172 = "(uploadFile.getSavePath());";
  protected final String TEXT_173 = NL + "\t\t\t\tmo.setPath(uploadFile.getSavePath());";
  protected final String TEXT_174 = "\t\t";
  protected final String TEXT_175 = "\t";
  protected final String TEXT_176 = NL + "\t\t\t\tmo.";
  protected final String TEXT_177 = "(uploadFile.getVisitPath());";
  protected final String TEXT_178 = "\t\t\t\t";
  protected final String TEXT_179 = "\t";
  protected final String TEXT_180 = NL + "\t\t\t\tmo.";
  protected final String TEXT_181 = "(uploadFile.getSize());";
  protected final String TEXT_182 = "\t";
  protected final String TEXT_183 = NL + "\t\t\t\tmo.";
  protected final String TEXT_184 = "(uploadFile.getExtention());";
  protected final String TEXT_185 = "\t";
  protected final String TEXT_186 = NL + "\t\t\t\tmo.";
  protected final String TEXT_187 = "(uploadFile.getFileType());";
  protected final String TEXT_188 = "\t";
  protected final String TEXT_189 = NL + "\t\t\t\tmo.";
  protected final String TEXT_190 = "(uploadFile.getFileName());";
  protected final String TEXT_191 = NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_192 = ".update(mo";
  protected final String TEXT_193 = ");" + NL + "\t\t\t";
  protected final String TEXT_194 = ".htmlResultMsg(true, mo, \"更新成功!\");" + NL + "\t\t\treturn; " + NL + "\t\t} catch (InvalidStateException e) {" + NL + "\t\t\tString invalidateMsg = ";
  protected final String TEXT_195 = ".getValidateMessageWithHtmlBR(e.getInvalidValues());" + NL + "\t\t\tlogger.error(invalidateMsg, e);" + NL + "\t\t\tRenderUtil.renderHtmlResultMsgError(invalidateMsg);" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderHtmlResultMsgError(e.getMessage());" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderHtmlResultMsgError();" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_196 = NL;
  protected final String TEXT_197 = NL + "\t/**" + NL + "\t * 删除Entity,返回json格式." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void deleteOutJson() {" + NL + "\t\ttry {" + NL + "\t\t\tAppAssert.notNull(getModel().getId(), \"未指定删除的对象!\");" + NL + "\t\t\tfinal String[] delIds = StringUtils.split(getModel().getId(), \",\");" + NL + "\t\t\t//int delCount = ";
  protected final String TEXT_198 = ".delete(delIds);" + NL + "\t\t\tint delCount=0;" + NL + "\t\t\tfor (String id : delIds) {" + NL + "\t\t\t\t";
  protected final String TEXT_199 = " ";
  protected final String TEXT_200 = " = ";
  protected final String TEXT_201 = ".get(id);";
  protected final String TEXT_202 = "\t";
  protected final String TEXT_203 = NL + "\t\t\t\tString filePath=";
  protected final String TEXT_204 = ".";
  protected final String TEXT_205 = "();";
  protected final String TEXT_206 = NL + "\t\t\t\tString filePath = ";
  protected final String TEXT_207 = ".getFileSavePath();";
  protected final String TEXT_208 = "\t" + NL + "\t\t\t\t// 删除文件" + NL + "\t\t\t\tif (StringUtils.isNotBlank(filePath)) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_209 = ".deleteFile(filePath);" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_210 = ".delete(";
  protected final String TEXT_211 = ");" + NL + "\t\t\t\tdelCount++;" + NL + "\t\t\t}" + NL + "\t\t\tRenderUtil.renderJsonResultMsgSuccess(\"删除成功\" + delCount + \"项记录!\");" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError(e.getMessage());" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError();" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_212 = NL;
  protected final String TEXT_213 = NL + "\t/**" + NL + "\t * 删除所有Entity,返回json格式." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void deleteAllOutJson() {" + NL + "\t\ttry {" + NL + "\t\t\tint delCount = 0;" + NL + "\t\t\tList<";
  protected final String TEXT_214 = "> ";
  protected final String TEXT_215 = "s = ";
  protected final String TEXT_216 = ".getAll();" + NL + "\t\t\tfor (";
  protected final String TEXT_217 = " ";
  protected final String TEXT_218 = " : ";
  protected final String TEXT_219 = "s) {";
  protected final String TEXT_220 = "\t";
  protected final String TEXT_221 = NL + "\t\t\t\tString filePath=";
  protected final String TEXT_222 = ".";
  protected final String TEXT_223 = "();";
  protected final String TEXT_224 = NL + "\t\t\t\tString filePath = ";
  protected final String TEXT_225 = ".getFileSavePath();";
  protected final String TEXT_226 = "\t" + NL + "\t\t\t\t// 删除文件" + NL + "\t\t\t\tif (StringUtils.isNotBlank(filePath)) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_227 = ".deleteFile(filePath);" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_228 = ".delete(";
  protected final String TEXT_229 = ");" + NL + "\t\t\t\tdelCount++;" + NL + "\t\t\t}" + NL + "\t\t\tRenderUtil.renderJsonResultMsgSuccess(\"删除成功\" + delCount + \"项记录!\");" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError(e.getMessage());" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError();" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_230 = NL;
  protected final String TEXT_231 = NL + "\t/**" + NL + "\t * 导出 Excel 文件." + NL + "     * @generated" + NL + "\t */" + NL + "\tpublic void exportExcelFile() {" + NL + "\t\ttry {" + NL + "\t\t\tOrder[] orders = RequestUtil.buildOrders(getRequest());" + NL + "\t\t\tpage = ";
  protected final String TEXT_232 = ".find(getPage(), getModel(), orders);" + NL + "\t\t\t";
  protected final String TEXT_233 = ".excelExportAllField(getResponse(), getPage().getResult());" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\te.printStackTrace();" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_234 = NL;
  protected final String TEXT_235 = NL + "\t/**" + NL + "\t * 导入excel 文件处理." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void ";
  protected final String TEXT_236 = "() {" + NL + "" + NL + "\t\tif (!SecurityHolder.isUserLogin()) {" + NL + "\t\t\tRenderUtil.renderHtmlNoLogin();" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "" + NL + "\t\ttry {" + NL + "\t\t\tList<File> fileList = StrutsWebFileUtil.getUploadFile(getRequest());" + NL + "\t\t\tif (!fileList.isEmpty()) {" + NL + "\t\t\t\tList<";
  protected final String TEXT_237 = "> importModelList = ";
  protected final String TEXT_238 = ".excelToModel(fileList.get(0));";
  protected final String TEXT_239 = "\t" + NL + "\t\t\t\tResultMsg<";
  protected final String TEXT_240 = "> resultMsg =";
  protected final String TEXT_241 = ".";
  protected final String TEXT_242 = "(importModelList);" + NL + "\t\t\t\tRenderUtil.renderHtml(resultMsg.getMessage());" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\tRenderUtil.renderHtml(\"请上传需要导入的excel文件!\");" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tRenderUtil.renderHtml(e.getMessage());" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t} catch (IOException e) {" + NL + "\t\t\tRenderUtil.renderHtml(\"导入失败!文件加载错误!\");" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tRenderUtil.renderHtml(\"导入失败!\");" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_243 = "\t" + NL + "" + NL + "\t";
  protected final String TEXT_244 = NL + "\t/************************************************************************" + NL + "\t * code kind define" + NL + "\t ************************************************************************/" + NL + "\t ";
  protected final String TEXT_245 = "\t";
  protected final String TEXT_246 = NL + "\t" + NL + "\t/** @generated */" + NL + "\tpublic String get";
  protected final String TEXT_247 = "() {" + NL + "\t\treturn ";
  protected final String TEXT_248 = ".toHtmlSelect(null == mo ? null : mo.";
  protected final String TEXT_249 = "());" + NL + "\t}";
  protected final String TEXT_250 = NL + "\t/** @generated */" + NL + "\tpublic String get";
  protected final String TEXT_251 = "() {" + NL + "\t\treturn ";
  protected final String TEXT_252 = ".toHtmlJSON;" + NL + "\t}";
  protected final String TEXT_253 = NL;
  protected final String TEXT_254 = "\t" + NL + "" + NL + "\t/** @generated */" + NL + "\tpublic String get";
  protected final String TEXT_255 = "() {" + NL + "\t";
  protected final String TEXT_256 = NL + "\t\tif (null == ";
  protected final String TEXT_257 = ")" + NL + "\t\t\treturn \"{}\";" + NL + "\t";
  protected final String TEXT_258 = NL + "\t\treturn ";
  protected final String TEXT_259 = ";" + NL + "\t}";
  protected final String TEXT_260 = "\t";
  protected final String TEXT_261 = "\t" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    Class uml2Class = (Class) argument;Package uml2Package = uml2Class.getPackage();
    
/*******clazz wrap********/	
UmlClassWrap clazzWrap=new UmlClassWrap(uml2Class);
String modelCapName=clazzWrap.getCapName();
String modelUncapName=clazzWrap.getUncapName();
String modelCommentName=clazzWrap.getCommentName();
//action define
ClassNameDefineCommon actionDefine=clazzWrap.getNameDefineAction();
String modelActionQualifiedName=actionDefine.getClassQualifiedName();
//String modelActionPackageName=actionDefine.getPackageQualifiedName();
String modelActionName=actionDefine.getClassCapName();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(modelActionQualifiedName);
    stringBuffer.append(TEXT_2);
    ImportManager importManager = ImportHelper.makeImportManager("");
    importManager.addImport("org.apache.commons.lang.StringUtils");
    importManager.addImport("org.springframework.beans.factory.annotation.Autowired");
    importManager.addImport("org.springframework.util.Assert");
    importManager.addImport("com.opensymphony.xwork2.ModelDriven");
    importManager.addImport("com.jeefuse.base.exception.ApplicationException");
    importManager.addImport("com.jeefuse.base.utils.page.Page");
    importManager.addImport("com.jeefuse.base.web.action.BaseAction");
    importManager.addImport("com.jeefuse.base.web.utils.RenderUtil");
    importManager.addImport("com.jeefuse.base.web.utils.RequestUtil");
    importManager.addImport("com.jeefuse.base.modules.condition.order.Order");
    importManager.addImport("com.jeefuse.base.exception.AppAssert");
    importManager.addImport("java.util.List");
    importManager.addImport("java.io.File");
    importManager.addImport("java.io.IOException");
    
//model entity define
ClassNameDefineCommon entityDefine=clazzWrap.getNameDefineEntity();
String modelEntityQualifiedName=entityDefine.getClassQualifiedName();
//String modelEntityName=entityDefine.getClassCapName();
importManager.addImport(modelEntityQualifiedName);

//model service define
ClassNameDefineCommon serviceDefine=clazzWrap.getNameDefineService();
String modelServiceQualifiedName=serviceDefine.getClassQualifiedName();
String modelServiceName=serviceDefine.getClassCapName();
String modelServiceUnCapName=serviceDefine.getClassUncapName();
importManager.addImport(modelServiceQualifiedName);

//model RTO define
ClassNameDefineCommon rtoDefine=clazzWrap.getNameDefineRTO();
String modelRTOQualifiedName=rtoDefine.getClassQualifiedName();
String modelRTOName=rtoDefine.getClassCapName();
importManager.addImport(modelRTOQualifiedName);

// model RenderUtil define
ClassNameDefineCommon renderUtilDefine=clazzWrap.getNameDefineRenderUtil();
String modelRenderUtilQualifiedName=renderUtilDefine.getClassQualifiedName();
String modelRenderUtilName=renderUtilDefine.getClassCapName();
importManager.addImport(modelRenderUtilQualifiedName);

//serviceFacotry define
//UmlPackageWrap umlPackageWrap=new UmlPackageWrap(uml2Package);
//String packageServiceFactoryClassName=umlPackageWrap.getServiceFactoryClassName();
//String packageServiceFactoryClassQualifiedName=umlPackageWrap.getServiceFactoryClassQualifiedName();
//importManager.addImport(packageServiceFactoryClassQualifiedName);


    
StringBuffer importStringBuffer = stringBuffer;
int importInsertionPoint = stringBuffer.length();
importManager.addCompilationUnitImports(stringBuffer.toString());

    List<String> pageAccessAttrList=new ArrayList<String>();
    stringBuffer.append(TEXT_3);
    stringBuffer.append(modelCommentName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(System.getProperty("user.name"));
    stringBuffer.append(TEXT_5);
    stringBuffer.append(modelActionName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(modelRTOName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(modelCommentName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(modelServiceName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(modelCapName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(modelCapName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(modelRTOName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(modelCapName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(modelCapName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(modelRTOName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(modelRTOName);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(modelCapName);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(modelCapName);
    stringBuffer.append(TEXT_19);
    if(FunctionStereotypeUtil.isApplied_manage(uml2Class)){
    stringBuffer.append(TEXT_20);
    }
    stringBuffer.append(TEXT_21);
    if(FunctionStereotypeUtil.isApplied_listOutJson(uml2Class)){
    stringBuffer.append(TEXT_22);
    /********is apply tree********/
    if(ModelStereoTypeHelper.isApplyModel_Tree(uml2Class)){
    stringBuffer.append(TEXT_23);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_24);
    }else{
    stringBuffer.append(TEXT_25);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_26);
    }
    stringBuffer.append(TEXT_27);
    stringBuffer.append(modelRenderUtilName);
    stringBuffer.append(TEXT_28);
    }
    stringBuffer.append(TEXT_29);
    /********is apply image********/
    if(FileStereotypeHelper.isClass_Image(uml2Class)){
    stringBuffer.append(TEXT_30);
    stringBuffer.append(modelCapName);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(modelCapName);
    stringBuffer.append(TEXT_32);
    	pageAccessAttrList.add(modelCapName+"List");
    stringBuffer.append(TEXT_33);
    stringBuffer.append(modelCapName);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_35);
    }
    stringBuffer.append(TEXT_36);
    if(FunctionStereotypeUtil.isApplied_getOutJson(uml2Class)){
    stringBuffer.append(TEXT_37);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(modelRenderUtilName);
    stringBuffer.append(TEXT_39);
    }
    stringBuffer.append(TEXT_40);
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
    stringBuffer.append(TEXT_41);
    stringBuffer.append(relPropertyCheckboxsDomId);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(relPropertyCheckboxs);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(relPropertyCheckboxs);
    stringBuffer.append(TEXT_45);
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
    stringBuffer.append(TEXT_46);
    stringBuffer.append(relPropertyShowCheckTreeJson);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_48);
    		pageAccessAttrList.add(relPropertyShowCheckTreeJson);
    	}
    stringBuffer.append(TEXT_49);
    if(FunctionStereotypeUtil.isApplied_input(uml2Class)||FunctionStereotypeUtil.isApplied_edit(uml2Class)){//is applied edit
    }
    stringBuffer.append(TEXT_50);
    /********process rel M2MCheckboxs process********/
    stringBuffer.append(TEXT_51);
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
    stringBuffer.append(TEXT_52);
    		//relTargetClassCheckboxs
    stringBuffer.append(TEXT_53);
    		String relTargetClassCheckboxs=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relCheckboxs);
    		String relTargetClassCheckboxsDomId=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relCheckboxsDomId);
    		String relTargetClassAllKeyLabelList=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.allKeyLabelList);
    		String relTargetClassGetAllForKeyLabel=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.getAllForKeyLabel);
    stringBuffer.append(TEXT_54);
    		importManager.addImport("com.jeefuse.base.modules.keyLabel.KeyLabel");
    		importManager.addImport("com.jeefuse.base.modules.keyLabel.KeyLabelRenderUtil");
    stringBuffer.append(TEXT_55);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(relTargetClassAllKeyLabelList);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(relTargetClassPackageServiceFactoryClassName);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(relTargetClassServiceUnCapName);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(relTargetClassGetAllForKeyLabel);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(relTargetClassCheckboxs);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(relTargetClassAllKeyLabelList);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(relTargetClassCheckboxsDomId);
    stringBuffer.append(TEXT_63);
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
    stringBuffer.append(TEXT_64);
    		//relPropertyShowCheckTree
    		String relTargetClassShowCheckTreeJson=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relShowCheckTreeJson);
    		String relTargetClassAllTreeviewList=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.allTreeviewList);
    		String relTargetClassGetAllForTreeviewList=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.getAllForTreeviewList);
    stringBuffer.append(TEXT_65);
    		importManager.addImport("com.jeefuse.base.modules.tree.renders.treeview.TreeViewItem");
    		importManager.addImport("com.jeefuse.base.modules.tree.TreeRenderUtil");
    stringBuffer.append(TEXT_66);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(relTargetClassAllTreeviewList);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(relTargetClassPackageServiceFactoryClassName);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(relTargetClassServiceUnCapName);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(relTargetClassGetAllForTreeviewList);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(relTargetClassShowCheckTreeJson);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(relTargetClassAllTreeviewList);
    stringBuffer.append(TEXT_73);
    	}
    }
    stringBuffer.append(TEXT_74);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_75);
    /********process rel M2MCheckboxs process********/
    stringBuffer.append(TEXT_76);
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
    stringBuffer.append(TEXT_77);
    		//relPropertyCheckboxs
    stringBuffer.append(TEXT_78);
    		String relTargetClassCheckboxs=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relCheckboxs);
    		String relTargetClassCheckboxsDomId=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relCheckboxsDomId);
    		String relTargetClassAllKeyLabelList=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.allKeyLabelList);
    		String relTargetClassGetAllForKeyLabel=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.getAllForKeyLabel);
    stringBuffer.append(TEXT_79);
    		String relTargetClassIdsList=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relIdsList);
    stringBuffer.append(TEXT_80);
    		String relTargetClassGetRelIdsMethodName=ModelHelper.getRelIdsMethodName(relTargetClass,uml2Class);
    stringBuffer.append(TEXT_81);
    		importManager.addImport("com.jeefuse.base.modules.keyLabel.KeyLabel");
    		importManager.addImport("com.jeefuse.base.modules.keyLabel.KeyLabelRenderUtil");
    stringBuffer.append(TEXT_82);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(relTargetClassAllKeyLabelList);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(relTargetClassPackageServiceFactoryClassName);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(relTargetClassServiceUnCapName);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(relTargetClassGetAllForKeyLabel);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(relTargetClassIdsList);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(relTargetClassPackageServiceFactoryClassName);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(relTargetClassServiceUnCapName);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(relTargetClassGetRelIdsMethodName);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(relTargetClassCheckboxs);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(relTargetClassAllKeyLabelList);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(relTargetClassIdsList);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(relTargetClassCheckboxsDomId);
    stringBuffer.append(TEXT_95);
    	}
    }
    stringBuffer.append(TEXT_96);
    /********process rel M2MCheckboxsTree process********/
    if(null!=needM2MCheckboxsTreeList&&needM2MCheckboxsTreeList.size()>0){
    	for(Property property:needM2MCheckboxsTreeList){
    		Type propertyType=property.getType();
    		Class relTargetClass=(Class)propertyType;
    		if(ModelStereoTypeHelper.isApplyModel_M2M(propertyType)||ModelStereoTypeHelper.isApplyModel_M2mWithId(propertyType)){
    			Class relUml2Class=(Class)propertyType;
    			relTargetClass=ModelHelper.getRelTargetClass(relUml2Class,uml2Class);
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
    stringBuffer.append(TEXT_97);
    		//relPropertyShowCheckTree
    		String relTargetClassShowCheckTreeJson=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relShowCheckTreeJson);
    		String relTargetClassAllTreeviewList=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.allTreeviewList);
    		String relTargetClassGetAllForTreeviewList=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.getAllForTreeviewList);
    stringBuffer.append(TEXT_98);
    		String relTargetClassIdsList=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relIdsList);
    stringBuffer.append(TEXT_99);
    		String relTargetClassGetRelIdsMethodName=ModelHelper.getRelIdsMethodName(relTargetClass,uml2Class);
    stringBuffer.append(TEXT_100);
    		importManager.addImport("com.jeefuse.base.modules.tree.renders.treeview.TreeViewItem");
    		importManager.addImport("com.jeefuse.base.modules.tree.TreeRenderUtil");
    stringBuffer.append(TEXT_101);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(relTargetClassAllTreeviewList);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(relTargetClassPackageServiceFactoryClassName);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(relTargetClassServiceUnCapName);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(relTargetClassGetAllForTreeviewList);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(relTargetClassIdsList);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(relTargetClassPackageServiceFactoryClassName);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(relTargetClassServiceUnCapName);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(relTargetClassGetRelIdsMethodName);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(relTargetClassShowCheckTreeJson);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(relTargetClassAllTreeviewList);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(relTargetClassIdsList);
    stringBuffer.append(TEXT_113);
    	}
    }
    stringBuffer.append(TEXT_114);
    }//end applied edit 
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
    /********model exportFileUpload********/
    //String modelFileUploadPackageName=MdaHelper.getPackageQualifiedName(uml2Class,PKGSuffix.fileUpload);
    String modelFileUploadClassName=MdaHelper.getModelClassName(uml2Class,ModelNameSuffix.fileUpload);
    String modelFileUploadQualifiedClassName=MdaHelper.getModelQualifiedName(uml2Class,PKGSuffix.fileUpload,ModelNameSuffix.fileUpload);
    importManager.addImport(modelFileUploadQualifiedClassName);
    Property propertyFileExtention=FileStereotypeHelper.getProperty_FileExtention(uml2Class);
    Property propertyFileApplyFileName=FileStereotypeHelper.getProperty_FileName(uml2Class);
    Property propertyFileSavePath=FileStereotypeHelper.getProperty_FileSavePath(uml2Class);
    Property propertyFileVisitPath=FileStereotypeHelper.getProperty_visitPath(uml2Class);
    Property propertyFileFileSize=FileStereotypeHelper.getProperty_FileSize(uml2Class);
    Property propertyFileFileType=FileStereotypeHelper.getProperty_FileType(uml2Class);
    stringBuffer.append(TEXT_115);
    	if(FunctionStereotypeUtil.isApplied_saveOutJson(uml2Class)){//start isApplied saveOutjson
    stringBuffer.append(TEXT_116);
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
    stringBuffer.append(TEXT_122);
    stringBuffer.append(modelFileUploadClassName);
    stringBuffer.append(TEXT_123);
    if(null!=propertyFileSavePath){
    		//String propertyGetAccessorName=ClassHelper.getGetAccessor(propertyFileSavePath);
    stringBuffer.append(TEXT_124);
    		String propertySetAccessorName="set"+ClassHelper.getAccessorName(propertyFileSavePath);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(propertySetAccessorName);
    stringBuffer.append(TEXT_126);
    }else{
    stringBuffer.append(TEXT_127);
    }
    if(null!=propertyFileVisitPath){
    		//String propertyGetAccessorName=ClassHelper.getGetAccessor(propertyFileVisitPath);
    stringBuffer.append(TEXT_128);
    		String propertySetAccessorName="set"+ClassHelper.getAccessorName(propertyFileVisitPath);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(propertySetAccessorName);
    stringBuffer.append(TEXT_130);
    }
    stringBuffer.append(TEXT_131);
    if(null!=propertyFileFileSize){
    		//String propertyGetAccessorName=ClassHelper.getGetAccessor(propertyFileFileSize);
    stringBuffer.append(TEXT_132);
    		String propertySetAccessorName="set"+ClassHelper.getAccessorName(propertyFileFileSize);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(propertySetAccessorName);
    stringBuffer.append(TEXT_134);
    }
    if(null!=propertyFileExtention){
    		//String propertyGetAccessorName=ClassHelper.getGetAccessor(propertyFileExtention);
    stringBuffer.append(TEXT_135);
    		String propertySetAccessorName="set"+ClassHelper.getAccessorName(propertyFileExtention);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(propertySetAccessorName);
    stringBuffer.append(TEXT_137);
    }
    if(null!=propertyFileFileType){
    		//String propertyGetAccessorName=ClassHelper.getGetAccessor(propertyFileFileType);
    stringBuffer.append(TEXT_138);
    		String propertySetAccessorName="set"+ClassHelper.getAccessorName(propertyFileFileType);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(propertySetAccessorName);
    stringBuffer.append(TEXT_140);
    }
    if(null!=propertyFileApplyFileName){
    		//String propertyGetAccessorName=ClassHelper.getGetAccessor(propertyFileApplyFileName);
    stringBuffer.append(TEXT_141);
    		String propertySetAccessorName="set"+ClassHelper.getAccessorName(propertyFileApplyFileName);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(propertySetAccessorName);
    stringBuffer.append(TEXT_143);
    }
    stringBuffer.append(TEXT_144);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(saveCheckIdsSb.toString());
    stringBuffer.append(TEXT_146);
    stringBuffer.append(modelRenderUtilName);
    stringBuffer.append(TEXT_147);
    importManager.addImport("org.hibernate.validator.InvalidStateException");
    stringBuffer.append(TEXT_148);
    
//model validate
String modelQualifiedForValidate=MdaHelper.getModelQualifiedName(uml2Class,PKGSuffix.Validate,ModelNameSuffix.Validate);
String modelClassNameForValidate=MdaHelper.getModelClassName(uml2Class,ModelNameSuffix.Validate);
importManager.addImport(modelQualifiedForValidate);

    stringBuffer.append(TEXT_149);
    stringBuffer.append(modelClassNameForValidate);
    stringBuffer.append(TEXT_150);
    importManager.addImport("com.jeefuse.base.exception.AppAssert");
    stringBuffer.append(TEXT_151);
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
    stringBuffer.append(TEXT_152);
    		String relTargetClassGetRelCheckIdsMethod=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.getRelCheckIdsMethod);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(relTargetClassCheckIds);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(relTargetClassGetRelCheckIdsMethod);
    stringBuffer.append(TEXT_155);
    		updateCheckIdsSb.append(relTargetClassCheckIds);
    stringBuffer.append(TEXT_156);
    		if(it.hasNext())updateCheckIdsSb.append(",");
    	}
    }
    stringBuffer.append(TEXT_157);
    stringBuffer.append(modelCapName);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(modelUncapName);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(modelUncapName);
    stringBuffer.append(TEXT_161);
    if(null!=propertyFileSavePath){
    		String propertyGetAccessorName=ClassHelper.getGetAccessor(propertyFileSavePath);
    stringBuffer.append(TEXT_162);
    		//String propertySetAccessorName="set"+ClassHelper.getAccessorName(propertyFileSavePath);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(modelUncapName);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(propertyGetAccessorName);
    stringBuffer.append(TEXT_165);
    }else{
    stringBuffer.append(TEXT_166);
    stringBuffer.append(modelUncapName);
    stringBuffer.append(TEXT_167);
    }
    stringBuffer.append(TEXT_168);
    stringBuffer.append(modelFileUploadClassName);
    stringBuffer.append(TEXT_169);
    if(null!=propertyFileSavePath){
    		//String propertyGetAccessorName=ClassHelper.getGetAccessor(propertyFileSavePath);
    stringBuffer.append(TEXT_170);
    		String propertySetAccessorName="set"+ClassHelper.getAccessorName(propertyFileSavePath);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(propertySetAccessorName);
    stringBuffer.append(TEXT_172);
    }else{
    stringBuffer.append(TEXT_173);
    }
    stringBuffer.append(TEXT_174);
    if(null!=propertyFileVisitPath){
    		//String propertyGetAccessorName=ClassHelper.getGetAccessor(propertyFileVisitPath);
    stringBuffer.append(TEXT_175);
    		String propertySetAccessorName="set"+ClassHelper.getAccessorName(propertyFileVisitPath);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(propertySetAccessorName);
    stringBuffer.append(TEXT_177);
    }
    stringBuffer.append(TEXT_178);
    if(null!=propertyFileFileSize){
    		//String propertyGetAccessorName=ClassHelper.getGetAccessor(propertyFileFileSize);
    stringBuffer.append(TEXT_179);
    		String propertySetAccessorName="set"+ClassHelper.getAccessorName(propertyFileFileSize);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(propertySetAccessorName);
    stringBuffer.append(TEXT_181);
    }
    if(null!=propertyFileExtention){
    		//String propertyGetAccessorName=ClassHelper.getGetAccessor(propertyFileExtention);
    stringBuffer.append(TEXT_182);
    		String propertySetAccessorName="set"+ClassHelper.getAccessorName(propertyFileExtention);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(propertySetAccessorName);
    stringBuffer.append(TEXT_184);
    }
    if(null!=propertyFileFileType){
    		//String propertyGetAccessorName=ClassHelper.getGetAccessor(propertyFileFileType);
    stringBuffer.append(TEXT_185);
    		String propertySetAccessorName="set"+ClassHelper.getAccessorName(propertyFileFileType);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(propertySetAccessorName);
    stringBuffer.append(TEXT_187);
    }
    if(null!=propertyFileApplyFileName){
    		//String propertyGetAccessorName=ClassHelper.getGetAccessor(propertyFileApplyFileName);
    stringBuffer.append(TEXT_188);
    		String propertySetAccessorName="set"+ClassHelper.getAccessorName(propertyFileApplyFileName);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(propertySetAccessorName);
    stringBuffer.append(TEXT_190);
    }
    stringBuffer.append(TEXT_191);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(saveCheckIdsSb.toString());
    stringBuffer.append(TEXT_193);
    stringBuffer.append(modelRenderUtilName);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(modelClassNameForValidate);
    stringBuffer.append(TEXT_195);
    }//end isApplied saveOutjson
    stringBuffer.append(TEXT_196);
    	if(FunctionStereotypeUtil.isApplied_deleteOutJson(uml2Class)){
    stringBuffer.append(TEXT_197);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(modelCapName);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(modelUncapName);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_201);
    if(null!=propertyFileSavePath){
    		String propertyGetAccessorName=ClassHelper.getGetAccessor(propertyFileSavePath);
    stringBuffer.append(TEXT_202);
    		//String propertySetAccessorName="set"+ClassHelper.getAccessorName(propertyFileSavePath);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(modelUncapName);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(propertyGetAccessorName);
    stringBuffer.append(TEXT_205);
    }else{
    stringBuffer.append(TEXT_206);
    stringBuffer.append(modelUncapName);
    stringBuffer.append(TEXT_207);
    }
    stringBuffer.append(TEXT_208);
    stringBuffer.append(modelFileUploadClassName);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(modelUncapName);
    stringBuffer.append(TEXT_211);
    	}
    stringBuffer.append(TEXT_212);
    	if(FunctionStereotypeUtil.isApplied_deleteAllOutJson(uml2Class)){//isApplied deleteAllOutJson
    stringBuffer.append(TEXT_213);
    stringBuffer.append(modelCapName);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(modelUncapName);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(modelCapName);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(modelUncapName);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(modelUncapName);
    stringBuffer.append(TEXT_219);
    if(null!=propertyFileSavePath){
    		String propertyGetAccessorName=ClassHelper.getGetAccessor(propertyFileSavePath);
    stringBuffer.append(TEXT_220);
    		//String propertySetAccessorName="set"+ClassHelper.getAccessorName(propertyFileSavePath);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(modelUncapName);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(propertyGetAccessorName);
    stringBuffer.append(TEXT_223);
    }else{
    stringBuffer.append(TEXT_224);
    stringBuffer.append(modelUncapName);
    stringBuffer.append(TEXT_225);
    }
    stringBuffer.append(TEXT_226);
    stringBuffer.append(modelFileUploadClassName);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(modelUncapName);
    stringBuffer.append(TEXT_229);
    	}//isApplied deleteAllOutJson end
    stringBuffer.append(TEXT_230);
    
if(ServiceStereotypeUtil.isApplied_expExcel(uml2Class)){//isApplied importExcelFile
//model exportFactory 
String modelExportFactoryQualifiedName=MdaHelper.getModelQualifiedName(uml2Class,PKGSuffix.exportFactory,ModelNameSuffix.exportFactory);
//String modelExportFactoryPackageName=MdaHelper.getPackageQualifiedName(uml2Class,PKGSuffix.exportFactory);
String modelExportFactoryClassName=MdaHelper.getModelClassName(uml2Class,ModelNameSuffix.exportFactory);
importManager.addImport(modelExportFactoryQualifiedName);
//model excel export file name
//String ExcelExportTemplateFileCapName=PropertyNamedRuleKind.ExcelExportTemplateFileName.getRuleCapNamed(uml2Class);
//String ExcelExportTemplateFileUncapName=PropertyNamedRuleKind.ExcelExportTemplateFileName.getRuleUnCapNamed(uml2Class);

    stringBuffer.append(TEXT_231);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(modelExportFactoryClassName);
    stringBuffer.append(TEXT_233);
    }//isApplied importExcelFile end
    stringBuffer.append(TEXT_234);
    	if(ServiceStereotypeUtil.isApplied_impExcel(uml2Class)){
    
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

    stringBuffer.append(TEXT_235);
    stringBuffer.append(WebUrlName.importExcelFileProcess.getValue());
    stringBuffer.append(TEXT_236);
    stringBuffer.append(modelCapName);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(modelImportFactoryClassName);
    stringBuffer.append(TEXT_238);
    importManager.addImport("com.jeefuse.base.web.result.ResultMsg");
    stringBuffer.append(TEXT_239);
    stringBuffer.append(modelCapName);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(NamedUtil.getMethodNamedCapital(uml2Class,MethodNamedRuleKind.importDatas));
    stringBuffer.append(TEXT_242);
    }
    stringBuffer.append(TEXT_243);
    //code kind define
    List<Property> codeKindPropertiesList=EnumKindHelper.getPropertiesAppliedEnumKind(uml2Class);
    if(null!=codeKindPropertiesList&&codeKindPropertiesList.size()>0){
    	//importManager.addImport("java.util.Map");
    stringBuffer.append(TEXT_244);
    	for(Property property:codeKindPropertiesList){
    		String propertyGetAccessorName=ClassHelper.getGetAccessor(property);
    stringBuffer.append(TEXT_245);
    		Enumeration enumeration=EnumKindHelper.getAppliedEnumKindEnumeration(property);
    		if(null!=enumeration){
    			String modelEnumQualifiedName=MdaHelper.getModelQualifiedName(enumeration,PKGSuffix.enumeration,ModelNameSuffix.enumeration);
    			String modelEnumName=MdaHelper.getModelClassName(enumeration,ModelNameSuffix.enumeration);
    			String modelEnumSelectHtml=PropertyNamedRuleKind.selectHtml.getRuleCapNamed(enumeration);
    			importManager.addImport(modelEnumQualifiedName);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(modelEnumSelectHtml);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(modelEnumName);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(propertyGetAccessorName);
    stringBuffer.append(TEXT_249);
    			String modelEnumJsoncapName=PropertyNamedRuleKind.elementJsonNamed.getRuleCapNamed(enumeration);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(modelEnumJsoncapName);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(modelEnumName);
    stringBuffer.append(TEXT_252);
    		}
    	}
    }
    stringBuffer.append(TEXT_253);
    if(null!=pageAccessAttrList){
     for(String str:pageAccessAttrList){
    stringBuffer.append(TEXT_254);
    stringBuffer.append(NameHelper.getCapName(str));
    stringBuffer.append(TEXT_255);
    if(str.endsWith("Json")){
    stringBuffer.append(TEXT_256);
    stringBuffer.append(str);
    stringBuffer.append(TEXT_257);
    }
    stringBuffer.append(TEXT_258);
    stringBuffer.append(str);
    stringBuffer.append(TEXT_259);
    	}
    stringBuffer.append(TEXT_260);
    }
    stringBuffer.append(TEXT_261);
    importStringBuffer.insert(importInsertionPoint, importManager.computeSortedImports());
    return stringBuffer.toString();
  }
}
