package com.jeefuse.mda.gen.template.main.java.action;

import net.taylor.mda.generator.parse.NameRuled.nameRuled.*;
import net.taylor.mda.generator.parse.NameRuled.*;
import net.taylor.mda.generator.parse.NameRuled.className.*;
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

public class EntityStrutsActionProxy
{
  protected static String nl;
  public static synchronized EntityStrutsActionProxy create(String lineSeparator)
  {
    nl = lineSeparator;
    EntityStrutsActionProxy result = new EntityStrutsActionProxy();
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
  protected final String TEXT_7 = "> {" + NL + "\t/** @generated */" + NL + "\tprivate static final long serialVersionUID = 1L;" + NL + "\t" + NL + "\t";
  protected final String TEXT_8 = NL + "\t/**" + NL + "\t * ";
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
  protected final String TEXT_20 = "();" + NL + "\t\t}" + NL + "\t\treturn mo;" + NL + "\t}" + NL + "\t\t" + NL + "\t/************************************************************************" + NL + "\t * request function invoke" + NL + "\t ************************************************************************/" + NL;
  protected final String TEXT_21 = NL + "\t/**" + NL + "\t * 转向管理页面." + NL + "\t */" + NL + "\tpublic String manage() {" + NL + "\t\treturn SUCCESS;" + NL + "\t}";
  protected final String TEXT_22 = NL;
  protected final String TEXT_23 = "\t\t" + NL + "\t/**" + NL + "\t * 获取Entity列表.返回json格式." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void listOutJson() {" + NL + "\t\ttry {" + NL + "\t\t\tOrder[] orders = RequestUtil.buildOrders(getRequest());" + NL + "\t\t\tpage = ";
  protected final String TEXT_24 = ".findDescendant(page, rto, orders);" + NL + "\t\t\t";
  protected final String TEXT_25 = ".jsonFlexiGrid(getPage());" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError(e.getMessage());" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError();" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_26 = NL;
  protected final String TEXT_27 = NL + "\tpublic void listTreeOutJson() {" + NL + "\t\ttry {";
  protected final String TEXT_28 = NL + "\t\t\tList<TreeViewItem> list = ";
  protected final String TEXT_29 = ".getAllForTreeview(null);";
  protected final String TEXT_30 = NL + "\t\t\tTreeRenderUtil.jsonTreeview(list,\"所有";
  protected final String TEXT_31 = "\");" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError(e.getMessage());" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError();" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_32 = NL;
  protected final String TEXT_33 = NL + "\t/**" + NL + "\t * 根据ID获取Entity对象,返回json格式." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void getOutJson() {" + NL + "\t\ttry {" + NL + "\t\t\tAppAssert.notNull(getModel().getId());" + NL + "\t\t\tmo = ";
  protected final String TEXT_34 = ".get(getModel().getId());" + NL + "\t\t\t";
  protected final String TEXT_35 = ".jsonResultMsg(true, mo, null);" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError(e.getMessage());" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError();" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_36 = NL + "\t" + NL + "\tprivate String htmlSelectTree;// 构造Html select 树";
  protected final String TEXT_37 = NL + "\t" + NL;
  protected final String TEXT_38 = NL + "\tprivate static final String ";
  protected final String TEXT_39 = " = \"";
  protected final String TEXT_40 = "\";//rel ";
  protected final String TEXT_41 = " for checkboxs" + NL + "\tprivate String ";
  protected final String TEXT_42 = ";";
  protected final String TEXT_43 = NL + "\tprivate String ";
  protected final String TEXT_44 = ";// rel ";
  protected final String TEXT_45 = " for Treeview";
  protected final String TEXT_46 = NL;
  protected final String TEXT_47 = NL + "\t/**根据主键获取Entity,并转向修改页面." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic String edit() {" + NL + "\t\ttry {";
  protected final String TEXT_48 = NL + "\t\t\tList<TreeViewItem> list = ";
  protected final String TEXT_49 = ".getAllForTreeview(null);" + NL + "\t\t\tString parentId = null;" + NL + "\t\t\tif (StringUtils.isBlank(getModel().getId())) {" + NL + "\t\t\t\tif (StringUtils.isNotBlank(getModel().getParentId())) {" + NL + "\t\t\t\t\tparentId = rto.getParentId();" + NL + "\t\t\t\t}";
  protected final String TEXT_50 = "\t\t\t\t";
  protected final String TEXT_51 = "\t";
  protected final String TEXT_52 = "\t\t";
  protected final String TEXT_53 = "\t\t\t";
  protected final String TEXT_54 = NL + "\t\t\t\t// rel ";
  protected final String TEXT_55 = " for checkboxs" + NL + "\t\t\t\tList<KeyLabel> ";
  protected final String TEXT_56 = " = ";
  protected final String TEXT_57 = ".get";
  protected final String TEXT_58 = "().";
  protected final String TEXT_59 = "();" + NL + "\t\t\t\t";
  protected final String TEXT_60 = " = KeyLabelRenderUtil.renderHtmlCheckboxs(";
  protected final String TEXT_61 = ", null,";
  protected final String TEXT_62 = " );";
  protected final String TEXT_63 = "\t";
  protected final String TEXT_64 = "\t\t";
  protected final String TEXT_65 = NL + "\t\t\t\t// rel ";
  protected final String TEXT_66 = " for Treeview" + NL + "\t\t\t\tList<TreeViewItem> ";
  protected final String TEXT_67 = " = ";
  protected final String TEXT_68 = ".get";
  protected final String TEXT_69 = "().";
  protected final String TEXT_70 = "();" + NL + "\t\t\t\t";
  protected final String TEXT_71 = " =TreeRenderUtil.jsonTreeviewShowCheckString(";
  protected final String TEXT_72 = ", null);";
  protected final String TEXT_73 = NL + "\t\t\t} else {" + NL + "\t\t\t\tmo = ";
  protected final String TEXT_74 = ".get(rto.getId());";
  protected final String TEXT_75 = NL + "\t\t\t\tChangeUtil.excludeTreeIds(list, mo.getId());" + NL + "\t\t\t\tparentId = mo.getParentId();";
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
  protected final String TEXT_114 = NL + "\t\t\t}";
  protected final String TEXT_115 = NL + "\t\t\thtmlSelectTree = TreeRenderUtil.renderHtmlTreeSelect(list, parentId);" + NL + "\t\t\treturn SUCCESS;" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\treturn ERROR;" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_116 = NL;
  protected final String TEXT_117 = "\t" + NL + "\t/**" + NL + "\t * 保存或更新Entity,返回json格式." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void saveOutJson() {" + NL + "\t\ttry {";
  protected final String TEXT_118 = "\t\t" + NL + "\t\t\tAssert.notNull(getModel());";
  protected final String TEXT_119 = "\t";
  protected final String TEXT_120 = "\t" + NL + "\t\t\tString[] ";
  protected final String TEXT_121 = " = ChangeUtil.stringToArray(getModel().";
  protected final String TEXT_122 = "(), true);";
  protected final String TEXT_123 = "\t\t\t";
  protected final String TEXT_124 = NL + "\t\t\tmo = ";
  protected final String TEXT_125 = ".save(getModel()";
  protected final String TEXT_126 = ");" + NL + "\t\t\t";
  protected final String TEXT_127 = ".jsonResultMsg(true, mo, \"保存成功!\");" + NL + "\t\t\treturn;" + NL + "\t\t} catch (InvalidStateException e) {";
  protected final String TEXT_128 = NL + "\t\t\tString invalidateMsg = ";
  protected final String TEXT_129 = ".getValidateMessageWithHtmlBR(e.getInvalidValues());" + NL + "\t\t\tlogger.error(invalidateMsg, e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError(invalidateMsg);" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError(e.getMessage());" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * 更新Entity,返回json格式." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void updateOutJson() {" + NL + "\t\ttry {";
  protected final String TEXT_130 = NL + "\t\t\tAppAssert.notNull(getModel().getId(), \"未指定更新记录!\");";
  protected final String TEXT_131 = "\t";
  protected final String TEXT_132 = "\t" + NL + "\t\t\tString[] ";
  protected final String TEXT_133 = " = ChangeUtil.stringToArray(getModel().";
  protected final String TEXT_134 = "(), true);";
  protected final String TEXT_135 = "\t\t\t";
  protected final String TEXT_136 = NL + "\t\t\tmo = ";
  protected final String TEXT_137 = ".update(getModel()";
  protected final String TEXT_138 = ");" + NL + "\t\t\t";
  protected final String TEXT_139 = ".jsonResultMsg(true, mo, \"更新成功!\");" + NL + "\t\t\treturn; " + NL + "\t\t} catch (InvalidStateException e) {" + NL + "\t\t\tString invalidateMsg = ";
  protected final String TEXT_140 = ".getValidateMessageWithHtmlBR(e.getInvalidValues());" + NL + "\t\t\tlogger.error(invalidateMsg, e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError(invalidateMsg);" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError(e.getMessage());" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError();" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_141 = NL;
  protected final String TEXT_142 = NL + "\t/**" + NL + "\t * 删除Entity,返回json格式." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void deleteOutJson() {" + NL + "\t\ttry {" + NL + "\t\t\tAppAssert.notNull(getModel().getId(), \"未指定删除的对象!\");" + NL + "\t\t\tfinal String[] delIds = StringUtils.split(getModel().getId(), \",\");" + NL + "\t\t\tint delCount = ";
  protected final String TEXT_143 = ".delete(delIds);" + NL + "\t\t\tString msg = delCount == 0?\"无记录删除!\":\"删除成功\" + delCount + \"项记录!\";" + NL + "\t\t\tRenderUtil.renderJsonResultMsgSuccess(msg);" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError(e.getMessage());" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * 删除当前对象及后代对象." + NL + "\t */" + NL + "\tpublic void deleteDescendantOutJson() {" + NL + "\t\ttry {" + NL + "\t\t\tAppAssert.notNull(getModel().getId(), \"未指定删除的对象!\");" + NL + "\t\t\tfinal String[] delIds = StringUtils.split(getModel().getId(), \",\");" + NL + "\t\t\tint delCount = ";
  protected final String TEXT_144 = ".deleteDescendant(delIds);" + NL + "\t\t\tString msg = delCount == 0 ? \"无记录删除!\" : \"删除成功\" + delCount + \"项记录!\";" + NL + "\t\t\tRenderUtil.renderJsonResultMsgSuccess(msg);" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError(e.getMessage());" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError();" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_145 = NL;
  protected final String TEXT_146 = NL + "\t/**" + NL + "\t * 删除所有Entity,返回json格式." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void deleteAllOutJson() {" + NL + "\t\ttry {" + NL + "\t\t\tint delCount = ";
  protected final String TEXT_147 = ".deleteAll();" + NL + "\t\t\tString msg = delCount == 0?\"无记录删除!\":\"删除成功\" + delCount + \"项记录!\";" + NL + "\t\t\tRenderUtil.renderJsonResultMsgSuccess(msg);" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError(e.getMessage());" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError();" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_148 = NL;
  protected final String TEXT_149 = NL + "\t/**" + NL + "\t * 导出 Excel 文件." + NL + "     * @generated" + NL + "\t */" + NL + "\tpublic void exportExcelFile() {" + NL + "\t\ttry {" + NL + "\t\t\tOrder[] orders = RequestUtil.buildOrders(getRequest());" + NL + "\t\t\tpage = ";
  protected final String TEXT_150 = ".find(getPage(), getModel(), orders);" + NL + "\t\t\t";
  protected final String TEXT_151 = ".excelExportAllField(getResponse(), getPage().getResult());" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\te.printStackTrace();" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_152 = NL + NL + "\t/**" + NL + "\t * 导入excel 文件处理." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void ";
  protected final String TEXT_153 = "() {" + NL + "\t\ttry {" + NL + "\t\t\tList<File> fileList = StrutsWebFileUtil.getUploadFile(getRequest());" + NL + "\t\t\tif (!fileList.isEmpty()) {" + NL + "\t\t\t\tList<";
  protected final String TEXT_154 = "> importModelList = ";
  protected final String TEXT_155 = ".excelToModel(fileList.get(0));";
  protected final String TEXT_156 = "\t" + NL + "\t\t\t\tResultMsg<";
  protected final String TEXT_157 = "> resultMsg =";
  protected final String TEXT_158 = ".";
  protected final String TEXT_159 = "(importModelList);" + NL + "\t\t\t\tRenderUtil.renderHtml(resultMsg.getMessage());" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\tRenderUtil.renderHtml(\"请上传需要导入的excel文件!\");" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tRenderUtil.renderHtml(e.getMessage());" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t} catch (IOException e) {" + NL + "\t\t\tRenderUtil.renderHtml(\"导入失败!文件加载错误!\");" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tRenderUtil.renderHtml(\"导入失败!\");" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_160 = "\t" + NL + "" + NL + "\t";
  protected final String TEXT_161 = "\t";
  protected final String TEXT_162 = NL + NL + "\t/** @generated */" + NL + "\tpublic String get";
  protected final String TEXT_163 = "() {" + NL + "\t\treturn ";
  protected final String TEXT_164 = ".toHtmlSelect(null == mo ? null : mo.";
  protected final String TEXT_165 = "());" + NL + "\t}";
  protected final String TEXT_166 = NL + "\t/** @generated */" + NL + "\tpublic String get";
  protected final String TEXT_167 = "() {" + NL + "\t\treturn ";
  protected final String TEXT_168 = ".toHtmlJSON;" + NL + "\t}";
  protected final String TEXT_169 = NL + "\t";
  protected final String TEXT_170 = "\t" + NL + "\tpublic String get";
  protected final String TEXT_171 = "() {" + NL + "\t";
  protected final String TEXT_172 = NL + "\t\tif (null == ";
  protected final String TEXT_173 = ")" + NL + "\t\t\treturn \"{}\";" + NL + "\t";
  protected final String TEXT_174 = NL + "\t\treturn ";
  protected final String TEXT_175 = ";" + NL + "\t}";
  protected final String TEXT_176 = "\t";
  protected final String TEXT_177 = "\t" + NL + "}";
  protected final String TEXT_178 = "/*" + NL + " * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the \"License\")" + NL + " * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms." + NL + " * email:yonclv@gmail.com" + NL + " */" + NL + "package ";
  protected final String TEXT_179 = ";";
  protected final String TEXT_180 = NL + NL + "/**" + NL + " * ";
  protected final String TEXT_181 = " Entity CRUD action." + NL + " *" + NL + " * @author ";
  protected final String TEXT_182 = NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_183 = " extends BaseAction implements ModelDriven<";
  protected final String TEXT_184 = "> {" + NL + "\t/** @generated */" + NL + "\tprivate static final long serialVersionUID = 1L;" + NL + "\t" + NL + "\t/**" + NL + "\t * ";
  protected final String TEXT_185 = " Entity CRUD service." + NL + "\t * @generated" + NL + "\t */" + NL + "\t@Autowired" + NL + "\tprivate ";
  protected final String TEXT_186 = " ";
  protected final String TEXT_187 = ";" + NL + "\t" + NL + "\t/*****************************************************************" + NL + "\t * property define" + NL + "\t/*****************************************************************/" + NL + "" + NL + "\t/** @generated */" + NL + "\tprivate Page<";
  protected final String TEXT_188 = "> page=null;" + NL + "\t/** @generated */" + NL + "\tprivate ";
  protected final String TEXT_189 = " mo=null;" + NL + "\t/** @generated */" + NL + "\tprivate ";
  protected final String TEXT_190 = " rto=null;" + NL + "" + NL + "" + NL + "\t/** @generated */" + NL + "\tpublic Page<";
  protected final String TEXT_191 = "> getPage() {" + NL + "\t\tif(null==page)" + NL + "\t\t\tpage=new Page<";
  protected final String TEXT_192 = ">();" + NL + "\t\treturn page;" + NL + "\t}" + NL + "" + NL + "\t/** @generated */" + NL + "\tpublic ";
  protected final String TEXT_193 = " getModel() {" + NL + "\t\tif(null==rto)" + NL + "\t\t\trto = new ";
  protected final String TEXT_194 = "();" + NL + "\t\treturn rto;" + NL + "\t}" + NL + "\t" + NL + "\t/** @generated */" + NL + "\tpublic ";
  protected final String TEXT_195 = " getMo() {" + NL + "\t\tif (null == mo) {" + NL + "\t\t\tmo = new ";
  protected final String TEXT_196 = "();" + NL + "\t\t}" + NL + "\t\treturn mo;" + NL + "\t}" + NL + "" + NL + "\t/************************************************************************" + NL + "\t * request function invoke" + NL + "\t ************************************************************************/" + NL;
  protected final String TEXT_197 = " " + NL + "\t/**" + NL + "\t * 转向管理页面." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic String manage() {" + NL + "\t\treturn SUCCESS;" + NL + "\t}";
  protected final String TEXT_198 = NL;
  protected final String TEXT_199 = "\t\t" + NL + "\t/**" + NL + "\t * 获取Entity列表.返回json格式." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void listOutJson() {" + NL + "\t\ttry {" + NL + "\t\t\tOrder[] orders = RequestUtil.buildOrders(getRequest());";
  protected final String TEXT_200 = NL + "\t\t\tpage = ";
  protected final String TEXT_201 = ".findDescendant(page, rto, orders);";
  protected final String TEXT_202 = NL + "\t\t\tpage=";
  protected final String TEXT_203 = ".find(getPage(), getModel(), orders);";
  protected final String TEXT_204 = NL + "\t\t\t";
  protected final String TEXT_205 = ".jsonFlexiGrid(getPage());" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError(e.getMessage());" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError();" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_206 = NL;
  protected final String TEXT_207 = "\t" + NL + "\t/** @generated */" + NL + "\tprivate List<";
  protected final String TEXT_208 = "> ";
  protected final String TEXT_209 = "List = null;";
  protected final String TEXT_210 = "\t" + NL + "\t/**" + NL + "\t * 图片Gallary展示." + NL + "\t */" + NL + "\tpublic String gallaryView() {" + NL + "\t\ttry {" + NL + "\t\t\t";
  protected final String TEXT_211 = "List= ";
  protected final String TEXT_212 = ".getGallaryList(null);//.findByGlDiningMenu(getPage(), getModel(), null);" + NL + "\t\t\treturn SUCCESS;" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\taddActionError(e.getMessage());" + NL + "\t\t\treturn ERROR;" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\treturn ERROR;" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_213 = NL;
  protected final String TEXT_214 = NL + "\t/**" + NL + "\t * 根据ID获取Entity对象,返回json格式." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void getOutJson() {" + NL + "\t\ttry {" + NL + "\t\t\tAppAssert.notNull(getModel().getId());" + NL + "\t\t\tmo = ";
  protected final String TEXT_215 = ".get(getModel().getId());" + NL + "\t\t\t";
  protected final String TEXT_216 = ".jsonResultMsg(true, mo, null);" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError(e.getMessage());" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError();" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_217 = NL;
  protected final String TEXT_218 = NL + "\tprivate static final String ";
  protected final String TEXT_219 = " = \"";
  protected final String TEXT_220 = "\";//rel ";
  protected final String TEXT_221 = " for checkboxs" + NL + "\tprivate String ";
  protected final String TEXT_222 = ";";
  protected final String TEXT_223 = NL + "\tprivate String ";
  protected final String TEXT_224 = ";// rel ";
  protected final String TEXT_225 = " for Treeview";
  protected final String TEXT_226 = NL;
  protected final String TEXT_227 = NL + "\t/**根据主键获取Entity,并转向修改页面." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic String edit() {" + NL + "\t\ttry {" + NL + "\t\t\tif (StringUtils.isBlank(getModel().getId())) {";
  protected final String TEXT_228 = "\t\t\t\t";
  protected final String TEXT_229 = "\t";
  protected final String TEXT_230 = "\t\t";
  protected final String TEXT_231 = "\t\t\t";
  protected final String TEXT_232 = NL + "\t\t\t\t// rel ";
  protected final String TEXT_233 = " for checkboxs" + NL + "\t\t\t\tList<KeyLabel> ";
  protected final String TEXT_234 = " = ";
  protected final String TEXT_235 = ".get";
  protected final String TEXT_236 = "().";
  protected final String TEXT_237 = "();" + NL + "\t\t\t\t";
  protected final String TEXT_238 = " = KeyLabelRenderUtil.renderHtmlCheckboxs(";
  protected final String TEXT_239 = ", null,";
  protected final String TEXT_240 = " );";
  protected final String TEXT_241 = "\t";
  protected final String TEXT_242 = "\t\t";
  protected final String TEXT_243 = NL + "\t\t\t\t// rel ";
  protected final String TEXT_244 = " for Treeview" + NL + "\t\t\t\tList<TreeViewItem> ";
  protected final String TEXT_245 = " = ";
  protected final String TEXT_246 = ".get";
  protected final String TEXT_247 = "().";
  protected final String TEXT_248 = "();" + NL + "\t\t\t\t";
  protected final String TEXT_249 = " =TreeRenderUtil.jsonTreeviewShowCheckString(";
  protected final String TEXT_250 = ", null);";
  protected final String TEXT_251 = NL + "\t\t\t} else {" + NL + "\t\t\t\tmo = ";
  protected final String TEXT_252 = ".get(rto.getId());";
  protected final String TEXT_253 = "\t\t\t\t";
  protected final String TEXT_254 = "\t";
  protected final String TEXT_255 = "\t\t";
  protected final String TEXT_256 = "\t";
  protected final String TEXT_257 = "\t";
  protected final String TEXT_258 = "\t\t";
  protected final String TEXT_259 = NL + "\t\t\t\t// rel ";
  protected final String TEXT_260 = " for checkboxs" + NL + "\t\t\t\tList<KeyLabel> ";
  protected final String TEXT_261 = " = ";
  protected final String TEXT_262 = ".get";
  protected final String TEXT_263 = "().";
  protected final String TEXT_264 = "();" + NL + "\t\t\t\tList<String> ";
  protected final String TEXT_265 = " =  ";
  protected final String TEXT_266 = ".get";
  protected final String TEXT_267 = "().";
  protected final String TEXT_268 = "(mo.getId());" + NL + "\t\t\t\t";
  protected final String TEXT_269 = " = KeyLabelRenderUtil.renderHtmlCheckboxs(";
  protected final String TEXT_270 = ",";
  protected final String TEXT_271 = ", ";
  protected final String TEXT_272 = ");";
  protected final String TEXT_273 = "\t\t\t\t";
  protected final String TEXT_274 = "\t";
  protected final String TEXT_275 = "\t\t";
  protected final String TEXT_276 = "\t";
  protected final String TEXT_277 = "\t\t";
  protected final String TEXT_278 = NL + "\t\t\t\t// rel ";
  protected final String TEXT_279 = " for Treeview" + NL + "\t\t\t\tList<TreeViewItem> ";
  protected final String TEXT_280 = " = ";
  protected final String TEXT_281 = ".get";
  protected final String TEXT_282 = "().";
  protected final String TEXT_283 = "();" + NL + "\t\t\t\tList<String> ";
  protected final String TEXT_284 = " = ";
  protected final String TEXT_285 = ".get";
  protected final String TEXT_286 = "().";
  protected final String TEXT_287 = "(mo.getId());" + NL + "\t\t\t\t";
  protected final String TEXT_288 = " =TreeRenderUtil.jsonTreeviewShowCheckString(";
  protected final String TEXT_289 = ", ";
  protected final String TEXT_290 = ");";
  protected final String TEXT_291 = NL + "\t\t\t}" + NL + "\t\t\treturn SUCCESS;" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\treturn ERROR;" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_292 = NL + "\t";
  protected final String TEXT_293 = NL + "\t/**" + NL + "\t * 保存或更新Entity,返回json格式." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void saveOutJson() {" + NL + "\t\ttry {" + NL + "\t\t\tAssert.notNull(getModel());";
  protected final String TEXT_294 = "\t";
  protected final String TEXT_295 = "\t" + NL + "\t\t\tString[] ";
  protected final String TEXT_296 = " = ChangeUtil.stringToArray(getModel().";
  protected final String TEXT_297 = "(), true);";
  protected final String TEXT_298 = "\t\t\t";
  protected final String TEXT_299 = NL + "\t\t\tList<UploadFile> uploadFiles = ";
  protected final String TEXT_300 = ".uploadFiles(getRequest(),SecurityHolder.getLoginUserId());" + NL + "\t\t\tif (null != uploadFiles && !uploadFiles.isEmpty()) {" + NL + "\t\t\t\tmo = getModel().getNewModel();" + NL + "\t\t\t\tint count = 0;" + NL + "\t\t\t\tfor (UploadFile uploadFile : uploadFiles) {";
  protected final String TEXT_301 = "\t";
  protected final String TEXT_302 = NL + "\t\t\t\t\tmo.";
  protected final String TEXT_303 = "(uploadFile.getSavePath());";
  protected final String TEXT_304 = NL + "\t\t\t\t\tmo.setPath(uploadFile.getSavePath());";
  protected final String TEXT_305 = "\t";
  protected final String TEXT_306 = NL + "\t\t\t\t\tmo.";
  protected final String TEXT_307 = "(uploadFile.getVisitPath());";
  protected final String TEXT_308 = "\t\t\t\t";
  protected final String TEXT_309 = "\t";
  protected final String TEXT_310 = NL + "\t\t\t\t\tmo.";
  protected final String TEXT_311 = "(uploadFile.getSize());";
  protected final String TEXT_312 = "\t";
  protected final String TEXT_313 = NL + "\t\t\t\t\tmo.";
  protected final String TEXT_314 = "(uploadFile.getExtention());";
  protected final String TEXT_315 = "\t";
  protected final String TEXT_316 = NL + "\t\t\t\t\tmo.";
  protected final String TEXT_317 = "(uploadFile.getFileType());";
  protected final String TEXT_318 = "\t";
  protected final String TEXT_319 = NL + "\t\t\t\t\tmo.";
  protected final String TEXT_320 = "(uploadFile.getFileName());";
  protected final String TEXT_321 = NL + "\t\t\t\t\t";
  protected final String TEXT_322 = ".save(getModel()";
  protected final String TEXT_323 = ");" + NL + "\t\t\t\t\tcount++;" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_324 = ".htmlResultMsg(true, mo, \"保存成功\" + count + \"项记录!\");" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\treturn;";
  protected final String TEXT_325 = "\t\t\t" + NL + "\t\t} catch (InvalidStateException e) {";
  protected final String TEXT_326 = NL + "\t\t\tString invalidateMsg = ";
  protected final String TEXT_327 = ".getValidateMessageWithHtmlBR(e.getInvalidValues());" + NL + "\t\t\tlogger.error(invalidateMsg, e);" + NL + "\t\t\tRenderUtil.renderHtmlResultMsgError(invalidateMsg);" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderHtmlResultMsgError(e.getMessage());" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderHtmlResultMsgError();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * 更新Entity,返回json格式." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void updateOutJson() {" + NL + "\t\ttry {";
  protected final String TEXT_328 = NL + "\t\t\tAppAssert.notNull(getModel().getId(), \"未指定更新记录!\");";
  protected final String TEXT_329 = "\t";
  protected final String TEXT_330 = "\t" + NL + "\t\t\tString[] ";
  protected final String TEXT_331 = " = ChangeUtil.stringToArray(getModel().";
  protected final String TEXT_332 = "(), true);";
  protected final String TEXT_333 = "\t\t\t";
  protected final String TEXT_334 = NL;
  protected final String TEXT_335 = " ";
  protected final String TEXT_336 = "= ";
  protected final String TEXT_337 = ".get(getModel().getId());" + NL + "\t\t\tmo = getModel().getModifiedModel(";
  protected final String TEXT_338 = ");" + NL + "\t\t\tList<UploadFile> uploadFiles = GlDiningMenuUploadFile.uploadFile(getRequest());" + NL + "\t\t\tif (null != uploadFiles && !uploadFiles.isEmpty()) {" + NL + "\t\t\t\t// 删除文件" + NL + "\t\t\t\t";
  protected final String TEXT_339 = "\t";
  protected final String TEXT_340 = NL + "\t\t\t\tString filePath=";
  protected final String TEXT_341 = ".";
  protected final String TEXT_342 = "();";
  protected final String TEXT_343 = NL + "\t\t\t\tString filePath = ";
  protected final String TEXT_344 = ".getFileSavePath();";
  protected final String TEXT_345 = "\t" + NL + "\t\t\t\tif (StringUtils.isNotBlank(filePath)) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_346 = ".deleteFile(filePath);" + NL + "\t\t\t\t}" + NL + "\t\t\t\tUploadFile uploadFile = uploadFiles.get(0);";
  protected final String TEXT_347 = "\t";
  protected final String TEXT_348 = NL + "\t\t\t\tmo.";
  protected final String TEXT_349 = "(uploadFile.getSavePath());";
  protected final String TEXT_350 = NL + "\t\t\t\tmo.setPath(uploadFile.getSavePath());";
  protected final String TEXT_351 = "\t\t";
  protected final String TEXT_352 = "\t";
  protected final String TEXT_353 = NL + "\t\t\t\tmo.";
  protected final String TEXT_354 = "(uploadFile.getVisitPath());";
  protected final String TEXT_355 = "\t\t\t\t";
  protected final String TEXT_356 = "\t";
  protected final String TEXT_357 = NL + "\t\t\t\tmo.";
  protected final String TEXT_358 = "(uploadFile.getSize());";
  protected final String TEXT_359 = "\t";
  protected final String TEXT_360 = NL + "\t\t\t\tmo.";
  protected final String TEXT_361 = "(uploadFile.getExtention());";
  protected final String TEXT_362 = "\t";
  protected final String TEXT_363 = NL + "\t\t\t\tmo.";
  protected final String TEXT_364 = "(uploadFile.getFileType());";
  protected final String TEXT_365 = "\t";
  protected final String TEXT_366 = NL + "\t\t\t\tmo.";
  protected final String TEXT_367 = "(uploadFile.getFileName());";
  protected final String TEXT_368 = NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_369 = ".update(mo";
  protected final String TEXT_370 = ");" + NL + "\t\t\t";
  protected final String TEXT_371 = ".htmlResultMsg(true, mo, \"更新成功!\");" + NL + "\t\t\treturn; " + NL + "\t\t} catch (InvalidStateException e) {" + NL + "\t\t\tString invalidateMsg = ";
  protected final String TEXT_372 = ".getValidateMessageWithHtmlBR(e.getInvalidValues());" + NL + "\t\t\tlogger.error(invalidateMsg, e);" + NL + "\t\t\tRenderUtil.renderHtmlResultMsgError(invalidateMsg);" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderHtmlResultMsgError(e.getMessage());" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderHtmlResultMsgError();" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_373 = NL;
  protected final String TEXT_374 = NL + "\t/**" + NL + "\t * 删除Entity,返回json格式." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void deleteOutJson() {" + NL + "\t\ttry {" + NL + "\t\t\tAppAssert.notNull(getModel().getId(), \"未指定删除的对象!\");" + NL + "\t\t\tfinal String[] delIds = StringUtils.split(getModel().getId(), \",\");" + NL + "\t\t\t//int delCount = ";
  protected final String TEXT_375 = ".delete(delIds);" + NL + "\t\t\tint delCount=0;" + NL + "\t\t\tfor (String id : delIds) {" + NL + "\t\t\t\t";
  protected final String TEXT_376 = " ";
  protected final String TEXT_377 = " = ";
  protected final String TEXT_378 = ".get(id);";
  protected final String TEXT_379 = "\t";
  protected final String TEXT_380 = NL + "\t\t\t\tString filePath=";
  protected final String TEXT_381 = ".";
  protected final String TEXT_382 = "();";
  protected final String TEXT_383 = NL + "\t\t\t\tString filePath = ";
  protected final String TEXT_384 = ".getFileSavePath();";
  protected final String TEXT_385 = "\t" + NL + "\t\t\t\t// 删除文件" + NL + "\t\t\t\tif (StringUtils.isNotBlank(filePath)) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_386 = ".deleteFile(filePath);" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_387 = ".delete(";
  protected final String TEXT_388 = ");" + NL + "\t\t\t\tdelCount++;" + NL + "\t\t\t}" + NL + "\t\t\tRenderUtil.renderJsonResultMsgSuccess(\"删除成功\" + delCount + \"项记录!\");" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError(e.getMessage());" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError();" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_389 = NL;
  protected final String TEXT_390 = NL + "\t/**" + NL + "\t * 删除所有Entity,返回json格式." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void deleteAllOutJson() {" + NL + "\t\ttry {" + NL + "\t\t\tint delCount = 0;" + NL + "\t\t\tList<";
  protected final String TEXT_391 = "> ";
  protected final String TEXT_392 = "s = ";
  protected final String TEXT_393 = ".getAll();" + NL + "\t\t\tfor (";
  protected final String TEXT_394 = " ";
  protected final String TEXT_395 = " : ";
  protected final String TEXT_396 = "s) {";
  protected final String TEXT_397 = "\t";
  protected final String TEXT_398 = NL + "\t\t\t\tString filePath=";
  protected final String TEXT_399 = ".";
  protected final String TEXT_400 = "();";
  protected final String TEXT_401 = NL + "\t\t\t\tString filePath = ";
  protected final String TEXT_402 = ".getFileSavePath();";
  protected final String TEXT_403 = "\t" + NL + "\t\t\t\t// 删除文件" + NL + "\t\t\t\tif (StringUtils.isNotBlank(filePath)) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_404 = ".deleteFile(filePath);" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_405 = ".delete(";
  protected final String TEXT_406 = ");" + NL + "\t\t\t\tdelCount++;" + NL + "\t\t\t}" + NL + "\t\t\tRenderUtil.renderJsonResultMsgSuccess(\"删除成功\" + delCount + \"项记录!\");" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError(e.getMessage());" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError();" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_407 = NL;
  protected final String TEXT_408 = NL + "\t/**" + NL + "\t * 导出 Excel 文件." + NL + "     * @generated" + NL + "\t */" + NL + "\tpublic void exportExcelFile() {" + NL + "\t\ttry {" + NL + "\t\t\tOrder[] orders = RequestUtil.buildOrders(getRequest());" + NL + "\t\t\tpage = ";
  protected final String TEXT_409 = ".find(getPage(), getModel(), orders);" + NL + "\t\t\t";
  protected final String TEXT_410 = ".excelExportAllField(getResponse(), getPage().getResult());" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\te.printStackTrace();" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_411 = NL;
  protected final String TEXT_412 = NL + "\t/**" + NL + "\t * 导入excel 文件处理." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void ";
  protected final String TEXT_413 = "() {" + NL + "" + NL + "\t\tif (!SecurityHolder.isUserLogin()) {" + NL + "\t\t\tRenderUtil.renderHtmlNoLogin();" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "" + NL + "\t\ttry {" + NL + "\t\t\tList<File> fileList = StrutsWebFileUtil.getUploadFile(getRequest());" + NL + "\t\t\tif (!fileList.isEmpty()) {" + NL + "\t\t\t\tList<";
  protected final String TEXT_414 = "> importModelList = ";
  protected final String TEXT_415 = ".excelToModel(fileList.get(0));";
  protected final String TEXT_416 = "\t" + NL + "\t\t\t\tResultMsg<";
  protected final String TEXT_417 = "> resultMsg =";
  protected final String TEXT_418 = ".";
  protected final String TEXT_419 = "(importModelList);" + NL + "\t\t\t\tRenderUtil.renderHtml(resultMsg.getMessage());" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\tRenderUtil.renderHtml(\"请上传需要导入的excel文件!\");" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tRenderUtil.renderHtml(e.getMessage());" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t} catch (IOException e) {" + NL + "\t\t\tRenderUtil.renderHtml(\"导入失败!文件加载错误!\");" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tRenderUtil.renderHtml(\"导入失败!\");" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_420 = "\t" + NL + "" + NL + "\t";
  protected final String TEXT_421 = NL + "\t/************************************************************************" + NL + "\t * code kind define" + NL + "\t ************************************************************************/" + NL + "\t ";
  protected final String TEXT_422 = "\t";
  protected final String TEXT_423 = NL + "\t" + NL + "\t/** @generated */" + NL + "\tpublic String get";
  protected final String TEXT_424 = "() {" + NL + "\t\treturn ";
  protected final String TEXT_425 = ".toHtmlSelect(null == mo ? null : mo.";
  protected final String TEXT_426 = "());" + NL + "\t}";
  protected final String TEXT_427 = NL + "\t/** @generated */" + NL + "\tpublic String get";
  protected final String TEXT_428 = "() {" + NL + "\t\treturn ";
  protected final String TEXT_429 = ".toHtmlJSON;" + NL + "\t}";
  protected final String TEXT_430 = NL;
  protected final String TEXT_431 = "\t" + NL + "" + NL + "\t/** @generated */" + NL + "\tpublic String get";
  protected final String TEXT_432 = "() {" + NL + "\t";
  protected final String TEXT_433 = NL + "\t\tif (null == ";
  protected final String TEXT_434 = ")" + NL + "\t\t\treturn \"{}\";" + NL + "\t";
  protected final String TEXT_435 = NL + "\t\treturn ";
  protected final String TEXT_436 = ";" + NL + "\t}";
  protected final String TEXT_437 = "\t";
  protected final String TEXT_438 = "\t" + NL + "}";
  protected final String TEXT_439 = "/*" + NL + " * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the \"License\")" + NL + " * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms." + NL + " * email:yonclv@gmail.com" + NL + " */" + NL + "package ";
  protected final String TEXT_440 = ";";
  protected final String TEXT_441 = NL;
  protected final String TEXT_442 = NL + NL + "/**" + NL + " * ";
  protected final String TEXT_443 = " Entity CRUD action." + NL + " *" + NL + " * @author ";
  protected final String TEXT_444 = NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_445 = " extends BaseAction implements ModelDriven<";
  protected final String TEXT_446 = "> {" + NL + "\t/** @generated */" + NL + "\tprivate static final long serialVersionUID = 1L;" + NL + "\t" + NL + "\t" + NL + "\t/**" + NL + "\t * ";
  protected final String TEXT_447 = " Entity CRUD service." + NL + "\t * @generated" + NL + "\t */" + NL + "\t@Autowired" + NL + "\tprivate ";
  protected final String TEXT_448 = " ";
  protected final String TEXT_449 = ";" + NL + "\t" + NL + "\t/*****************************************************************" + NL + "\t * property define" + NL + "\t/*****************************************************************/" + NL + "" + NL + "\t/** @generated */" + NL + "\tprivate Page<";
  protected final String TEXT_450 = "> page=null;" + NL + "\t/** @generated */" + NL + "\tprivate ";
  protected final String TEXT_451 = " mo=null;" + NL + "\t/** @generated */" + NL + "\tprivate ";
  protected final String TEXT_452 = " rto=null;" + NL + "" + NL + "\t/** @generated */" + NL + "\tpublic Page<";
  protected final String TEXT_453 = "> getPage() {" + NL + "\t\tif(null==page)" + NL + "\t\t\tpage=new Page<";
  protected final String TEXT_454 = ">();" + NL + "\t\treturn page;" + NL + "\t}" + NL + "" + NL + "\t/** @generated */" + NL + "\tpublic ";
  protected final String TEXT_455 = " getModel() {" + NL + "\t\tif(null==rto)" + NL + "\t\t\trto = new ";
  protected final String TEXT_456 = "();" + NL + "\t\treturn rto;" + NL + "\t}" + NL + "\t" + NL + "\t/** @generated */" + NL + "\tpublic ";
  protected final String TEXT_457 = " getMo() {" + NL + "\t\tif (null == mo) {" + NL + "\t\t\tmo = new ";
  protected final String TEXT_458 = "();" + NL + "\t\t}" + NL + "\t\treturn mo;" + NL + "\t}" + NL + "\t\t" + NL + "\t/************************************************************************" + NL + "\t * request function invoke" + NL + "\t ************************************************************************/";
  protected final String TEXT_459 = " " + NL + "\t/**" + NL + "\t * 转向管理页面." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic String manage() {" + NL + "\t\treturn SUCCESS;" + NL + "\t}";
  protected final String TEXT_460 = NL;
  protected final String TEXT_461 = "\t" + NL + "\t/**" + NL + "\t * 获取Entity列表.返回json格式." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void listOutJson() {" + NL + "\t\ttry {" + NL + "\t\t\tOrder[] orders = RequestUtil.buildOrders(getRequest());";
  protected final String TEXT_462 = NL + "\t\t\tpage = gsysFunctionService.findDescendant(page, rto, orders);";
  protected final String TEXT_463 = NL + "\t\t\tpage=";
  protected final String TEXT_464 = ".find(getPage(), getModel(), orders);";
  protected final String TEXT_465 = NL + "\t\t\t";
  protected final String TEXT_466 = ".jsonFlexiGrid(getPage());" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError(e.getMessage());" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError();" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_467 = NL;
  protected final String TEXT_468 = NL + "\t/**" + NL + "\t * 根据ID获取Entity对象,返回json格式." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void getOutJson() {" + NL + "\t\ttry {" + NL + "\t\t\tAppAssert.notNull(getModel().getId());" + NL + "\t\t\tmo = ";
  protected final String TEXT_469 = ".get(getModel().getId());" + NL + "\t\t\t";
  protected final String TEXT_470 = ".jsonResultMsg(true, mo, null);" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError(e.getMessage());" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError();" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_471 = NL;
  protected final String TEXT_472 = NL + "\tprivate static final String ";
  protected final String TEXT_473 = " = \"";
  protected final String TEXT_474 = "\";//rel ";
  protected final String TEXT_475 = " for checkboxs" + NL + "\tprivate String ";
  protected final String TEXT_476 = ";";
  protected final String TEXT_477 = NL + "\tprivate String ";
  protected final String TEXT_478 = ";// rel ";
  protected final String TEXT_479 = " for Treeview";
  protected final String TEXT_480 = NL;
  protected final String TEXT_481 = NL + "\t/**根据主键获取Entity,并转向修改页面." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic String edit() {" + NL + "\t\ttry {" + NL + "\t\t\tif (StringUtils.isBlank(getModel().getId())) {";
  protected final String TEXT_482 = "\t\t\t\t";
  protected final String TEXT_483 = "\t";
  protected final String TEXT_484 = "\t\t";
  protected final String TEXT_485 = "\t\t\t";
  protected final String TEXT_486 = NL + "\t\t\t\t// rel ";
  protected final String TEXT_487 = " for checkboxs" + NL + "\t\t\t\tList<KeyLabel> ";
  protected final String TEXT_488 = " = ";
  protected final String TEXT_489 = ".get";
  protected final String TEXT_490 = "().";
  protected final String TEXT_491 = "();" + NL + "\t\t\t\t";
  protected final String TEXT_492 = " = KeyLabelRenderUtil.renderHtmlCheckboxs(";
  protected final String TEXT_493 = ", null,";
  protected final String TEXT_494 = " );";
  protected final String TEXT_495 = "\t";
  protected final String TEXT_496 = "\t\t";
  protected final String TEXT_497 = NL + "\t\t\t\t// rel ";
  protected final String TEXT_498 = " for Treeview" + NL + "\t\t\t\tList<TreeViewItem> ";
  protected final String TEXT_499 = " = ";
  protected final String TEXT_500 = ".get";
  protected final String TEXT_501 = "().";
  protected final String TEXT_502 = "();" + NL + "\t\t\t\t";
  protected final String TEXT_503 = " =TreeRenderUtil.jsonTreeviewShowCheckString(";
  protected final String TEXT_504 = ", null);";
  protected final String TEXT_505 = NL + "\t\t\t} else {" + NL + "\t\t\t\tmo = ";
  protected final String TEXT_506 = ".get(rto.getId());";
  protected final String TEXT_507 = "\t\t\t\t";
  protected final String TEXT_508 = "\t";
  protected final String TEXT_509 = "\t\t";
  protected final String TEXT_510 = "\t";
  protected final String TEXT_511 = "\t";
  protected final String TEXT_512 = "\t\t";
  protected final String TEXT_513 = NL + "\t\t\t\t// rel ";
  protected final String TEXT_514 = " for checkboxs" + NL + "\t\t\t\tList<KeyLabel> ";
  protected final String TEXT_515 = " = ";
  protected final String TEXT_516 = ".get";
  protected final String TEXT_517 = "().";
  protected final String TEXT_518 = "();" + NL + "\t\t\t\tList<String> ";
  protected final String TEXT_519 = " =  ";
  protected final String TEXT_520 = ".get";
  protected final String TEXT_521 = "().";
  protected final String TEXT_522 = "(mo.getId());" + NL + "\t\t\t\t";
  protected final String TEXT_523 = " = KeyLabelRenderUtil.renderHtmlCheckboxs(";
  protected final String TEXT_524 = ",";
  protected final String TEXT_525 = ", ";
  protected final String TEXT_526 = ");";
  protected final String TEXT_527 = "\t\t\t\t";
  protected final String TEXT_528 = "\t";
  protected final String TEXT_529 = "\t\t";
  protected final String TEXT_530 = "\t";
  protected final String TEXT_531 = "\t\t";
  protected final String TEXT_532 = NL + "\t\t\t\t// rel ";
  protected final String TEXT_533 = " for Treeview" + NL + "\t\t\t\tList<TreeViewItem> ";
  protected final String TEXT_534 = " = ";
  protected final String TEXT_535 = ".get";
  protected final String TEXT_536 = "().";
  protected final String TEXT_537 = "();" + NL + "\t\t\t\tList<String> ";
  protected final String TEXT_538 = " = ";
  protected final String TEXT_539 = ".get";
  protected final String TEXT_540 = "().";
  protected final String TEXT_541 = "(mo.getId());" + NL + "\t\t\t\t";
  protected final String TEXT_542 = " =TreeRenderUtil.jsonTreeviewShowCheckString(";
  protected final String TEXT_543 = ", ";
  protected final String TEXT_544 = ");";
  protected final String TEXT_545 = NL + "\t\t\t}" + NL + "\t\t\treturn SUCCESS;" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\treturn ERROR;" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_546 = NL;
  protected final String TEXT_547 = NL + "\t/**" + NL + "\t * 保存或更新Entity,返回json格式." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void saveOutJson() {" + NL + "\t\ttry {" + NL + "\t\t\tAssert.notNull(getModel());";
  protected final String TEXT_548 = "\t";
  protected final String TEXT_549 = "\t" + NL + "\t\t\tString[] ";
  protected final String TEXT_550 = " = ChangeUtil.stringToArray(getModel().";
  protected final String TEXT_551 = "(), true);";
  protected final String TEXT_552 = "\t\t\t";
  protected final String TEXT_553 = NL + "\t\t\tmo=";
  protected final String TEXT_554 = ".save(getModel()";
  protected final String TEXT_555 = ");";
  protected final String TEXT_556 = NL + "\t\t\t// 上传";
  protected final String TEXT_557 = NL + "\t\t\tList<UploadFile> uploadFiles = ";
  protected final String TEXT_558 = ".upload";
  protected final String TEXT_559 = "File(getRequest());" + NL + "\t\t\tif (null != uploadFiles && !uploadFiles.isEmpty()) {" + NL + "\t\t\t\tUploadFile uploadFile = uploadFiles.get(0);" + NL + "\t\t\t\tmo.";
  protected final String TEXT_560 = "(uploadFile.getSavePath());" + NL + "\t\t\t}";
  protected final String TEXT_561 = "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_562 = ".jsonResultMsg(true, mo, \"保存成功!\");" + NL + "\t\t\treturn;";
  protected final String TEXT_563 = "\t\t\t" + NL + "\t\t} catch (InvalidStateException e) {";
  protected final String TEXT_564 = NL + "\t\t\tString invalidateMsg = ";
  protected final String TEXT_565 = ".getValidateMessageWithHtmlBR(e.getInvalidValues());" + NL + "\t\t\tlogger.error(invalidateMsg, e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError(invalidateMsg);" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError(e.getMessage());" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * 更新Entity,返回json格式." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void updateOutJson() {" + NL + "\t\ttry {";
  protected final String TEXT_566 = NL + "\t\t\tAppAssert.notNull(getModel().getId(), \"未指定更新记录!\");";
  protected final String TEXT_567 = "\t";
  protected final String TEXT_568 = "\t" + NL + "\t\t\tString[] ";
  protected final String TEXT_569 = " = ChangeUtil.stringToArray(getModel().";
  protected final String TEXT_570 = "(), true);";
  protected final String TEXT_571 = "\t\t\t";
  protected final String TEXT_572 = NL + "\t\t\t// 上传";
  protected final String TEXT_573 = NL + "\t\t\tList<UploadFile> uploadFiles = ";
  protected final String TEXT_574 = ".upload";
  protected final String TEXT_575 = "File(getRequest());" + NL + "\t\t\tif (null != uploadFiles && !uploadFiles.isEmpty()) {" + NL + "\t\t\t\t// delete old file" + NL + "\t\t\t\tif (StringUtils.isNotBlank(oldLogo)) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_576 = ".delete";
  protected final String TEXT_577 = "FFile(oldLogo, getRequest());" + NL + "\t\t\t\t}" + NL + "\t\t\t\tUploadFile uploadFile = uploadFiles.get(0);" + NL + "\t\t\t\tmo.";
  protected final String TEXT_578 = "(uploadFile.getSavePath());" + NL + "\t\t\t}";
  protected final String TEXT_579 = NL + "\t\t\tmo=";
  protected final String TEXT_580 = ".update(getModel()";
  protected final String TEXT_581 = ");" + NL + "\t\t\t";
  protected final String TEXT_582 = ".jsonResultMsg(true, mo, \"更新成功!\");" + NL + "\t\t\treturn; " + NL + "\t\t} catch (InvalidStateException e) {" + NL + "\t\t\tString invalidateMsg = ";
  protected final String TEXT_583 = ".getValidateMessageWithHtmlBR(e.getInvalidValues());" + NL + "\t\t\tlogger.error(invalidateMsg, e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError(invalidateMsg);" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError(e.getMessage());" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError();" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_584 = NL + "\t";
  protected final String TEXT_585 = "\t";
  protected final String TEXT_586 = NL + NL + "\t/**" + NL + "\t * 删除";
  protected final String TEXT_587 = " 文件." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void delete";
  protected final String TEXT_588 = "OutJson() {" + NL + "\t\ttry {" + NL + "\t\t\tAppAssert.notNull(getModel().getId(), \"未指定删除的记录!\");" + NL + "\t\t\t";
  protected final String TEXT_589 = " ";
  protected final String TEXT_590 = " = ";
  protected final String TEXT_591 = ".get(getModel().getId());" + NL + "\t\t\tAppAssert.notNull(";
  protected final String TEXT_592 = ", \"删除的记录不存在!\");" + NL + "\t\t\tString uploadPath = ";
  protected final String TEXT_593 = ".";
  protected final String TEXT_594 = "();" + NL + "\t\t\t// delete old file" + NL + "\t\t\tif (StringUtils.isNotBlank(uploadPath)) {" + NL + "\t\t\t\t";
  protected final String TEXT_595 = ".delete";
  protected final String TEXT_596 = "File(uploadPath, getRequest());" + NL + "\t\t\t\t";
  protected final String TEXT_597 = ".";
  protected final String TEXT_598 = "(null);" + NL + "\t\t\t\t";
  protected final String TEXT_599 = ".update(";
  protected final String TEXT_600 = ");" + NL + "\t\t\t\tRenderUtil.renderHtmlResultMsgSuccess(\"删除图片成功!\");" + NL + "\t\t\t} else {" + NL + "\t\t\t\tRenderUtil.renderHtmlResultMsgSuccess(\"图片不存在!\");" + NL + "\t\t\t}" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderHtmlResultMsgError(e.getMessage());" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderHtmlResultMsgError(\"删除LOGO图片失败!\");" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_601 = NL;
  protected final String TEXT_602 = NL + "\t/**" + NL + "\t * 删除Entity,返回json格式." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void deleteOutJson() {" + NL + "\t\ttry {" + NL + "\t\t\tAppAssert.notNull(getModel().getId(), \"未指定删除的对象!\");" + NL + "\t\t\tfinal String[] delIds = StringUtils.split(getModel().getId(), \",\");" + NL + "\t\t\tint delCount = ";
  protected final String TEXT_603 = ".delete(delIds);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgSuccess(\"删除成功\" + delCount + \"项记录!\");" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError(e.getMessage());" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError();" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_604 = NL;
  protected final String TEXT_605 = NL + "\t/**" + NL + "\t * 删除所有Entity,返回json格式." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void deleteAllOutJson() {" + NL + "\t\ttry {" + NL + "\t\t\tint delCount = ";
  protected final String TEXT_606 = ".deleteAll();" + NL + "\t\t\tRenderUtil.renderJsonResultMsgSuccess(\"删除成功\" + delCount + \"项记录!\");" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError(e.getMessage());" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderJsonResultMsgError();" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_607 = NL;
  protected final String TEXT_608 = NL + "\t/**" + NL + "\t * 导出 Excel 文件." + NL + "     * @generated" + NL + "\t */" + NL + "\tpublic void exportExcelFile() {" + NL + "\t\ttry {" + NL + "\t\t\tOrder[] orders = RequestUtil.buildOrders(getRequest());" + NL + "\t\t\tpage = ";
  protected final String TEXT_609 = ".find(getPage(), getModel(), orders);" + NL + "\t\t\t";
  protected final String TEXT_610 = ".excelExportAllField(getResponse(), getPage().getResult());" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_611 = NL + NL + "\t/**" + NL + "\t * 导入excel 文件处理." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void ";
  protected final String TEXT_612 = "() {" + NL + "\t\ttry {" + NL + "\t\t\tList<File> fileList = StrutsWebFileUtil.getUploadFile(getRequest());" + NL + "\t\t\tif (!fileList.isEmpty()) {" + NL + "\t\t\t\tList<";
  protected final String TEXT_613 = "> importModelList = ";
  protected final String TEXT_614 = ".excelToModel(fileList.get(0));";
  protected final String TEXT_615 = "\t" + NL + "\t\t\t\tResultMsg<";
  protected final String TEXT_616 = "> resultMsg =";
  protected final String TEXT_617 = ".";
  protected final String TEXT_618 = "(importModelList);" + NL + "\t\t\t\tRenderUtil.renderHtml(resultMsg.getMessage());" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\tRenderUtil.renderHtml(\"请上传需要导入的excel文件!\");" + NL + "\t\t} catch (ApplicationException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderHtml(e.getMessage());" + NL + "\t\t} catch (IOException e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderHtml(\"导入失败!文件加载错误!\");" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tlogger.error(e.getMessage(), e);" + NL + "\t\t\tRenderUtil.renderHtml(\"导入失败!\");" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_619 = "\t" + NL + "" + NL + "\t";
  protected final String TEXT_620 = "\t";
  protected final String TEXT_621 = NL + "\t" + NL + "\t/** @generated */" + NL + "\tpublic String get";
  protected final String TEXT_622 = "() {" + NL + "\t\treturn ";
  protected final String TEXT_623 = ".toHtmlSelect(null == mo ? null : mo.";
  protected final String TEXT_624 = "());" + NL + "\t}";
  protected final String TEXT_625 = NL + "\t/** @generated */" + NL + "\tpublic String get";
  protected final String TEXT_626 = "() {" + NL + "\t\treturn ";
  protected final String TEXT_627 = ".toHtmlJSON;" + NL + "\t}";
  protected final String TEXT_628 = NL + "\t";
  protected final String TEXT_629 = "\t" + NL + "\t/** @generated */" + NL + "\tpublic String get";
  protected final String TEXT_630 = "() {" + NL + "\t";
  protected final String TEXT_631 = NL + "\t\tif (null == ";
  protected final String TEXT_632 = ")" + NL + "\t\t\treturn \"{}\";" + NL + "\t";
  protected final String TEXT_633 = NL + "\t\treturn ";
  protected final String TEXT_634 = ";" + NL + "\t}";
  protected final String TEXT_635 = "\t";
  protected final String TEXT_636 = "\t" + NL + "}";
  protected final String TEXT_637 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    Class uml2Class_proxy = (Class) argument;
    if(ModelStereoTypeHelper.isApplyModel_Tree(uml2Class_proxy)){//应用了tree
    Class uml2Class = (Class) argument;Package uml2Package = uml2Class.getPackage();
    
/*******clazz wrap********/	
UmlClassWrap clazzWrap=new UmlClassWrap(uml2Class);
String modelCapName=clazzWrap.getCapName();
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

    /****** Page access attributes List   *****/
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
    //importManager.addImport("org.springframework.beans.factory.annotation.Autowired");
    stringBuffer.append(TEXT_8);
    stringBuffer.append(modelCommentName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(modelServiceName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(modelCapName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(modelCapName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(modelRTOName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(modelCapName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(modelCapName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(modelRTOName);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(modelRTOName);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(modelCapName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(modelCapName);
    stringBuffer.append(TEXT_20);
    if(FunctionStereotypeUtil.isApplied_manage(uml2Class)){
    stringBuffer.append(TEXT_21);
    }
    stringBuffer.append(TEXT_22);
    if(FunctionStereotypeUtil.isApplied_listOutJson(uml2Class)){
    stringBuffer.append(TEXT_23);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(modelRenderUtilName);
    stringBuffer.append(TEXT_25);
    }
    stringBuffer.append(TEXT_26);
    if(ModelStereoTypeHelper.isApplyModel_Tree(uml2Class)){
    stringBuffer.append(TEXT_27);
    		importManager.addImport("com.jeefuse.base.modules.tree.renders.treeview.TreeViewItem");
    stringBuffer.append(TEXT_28);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_29);
    			//<\%modelRenderUtilName%\>.jsonTreeview(list);
    		importManager.addImport("com.jeefuse.base.modules.tree.TreeRenderUtil");
    stringBuffer.append(TEXT_30);
    stringBuffer.append(modelCommentName);
    stringBuffer.append(TEXT_31);
    	}
    stringBuffer.append(TEXT_32);
    if(FunctionStereotypeUtil.isApplied_getOutJson(uml2Class)){
    stringBuffer.append(TEXT_33);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(modelRenderUtilName);
    stringBuffer.append(TEXT_35);
    }
    stringBuffer.append(TEXT_36);
    		pageAccessAttrList.add("htmlSelectTree");
    stringBuffer.append(TEXT_37);
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
    stringBuffer.append(TEXT_38);
    stringBuffer.append(relPropertyCheckboxsDomId);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(relPropertyCheckboxs);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(relPropertyCheckboxs);
    stringBuffer.append(TEXT_42);
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
    stringBuffer.append(TEXT_43);
    stringBuffer.append(relPropertyShowCheckTreeJson);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_45);
    		pageAccessAttrList.add(relPropertyShowCheckTreeJson);
    	}
    }
    stringBuffer.append(TEXT_46);
    if(FunctionStereotypeUtil.isApplied_input(uml2Class)||FunctionStereotypeUtil.isApplied_edit(uml2Class)){
    stringBuffer.append(TEXT_47);
    		importManager.addImport("com.jeefuse.base.modules.tree.renders.treeview.TreeViewItem");
    stringBuffer.append(TEXT_48);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_49);
    /********process rel M2MCheckboxs process********/
    stringBuffer.append(TEXT_50);
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
    stringBuffer.append(TEXT_51);
    		//relTargetClassCheckboxs
    stringBuffer.append(TEXT_52);
    		String relTargetClassCheckboxs=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relCheckboxs);
    		String relTargetClassCheckboxsDomId=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relCheckboxsDomId);
    		String relTargetClassAllKeyLabelList=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.allKeyLabelList);
    		String relTargetClassGetAllForKeyLabel=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.getAllForKeyLabel);
    stringBuffer.append(TEXT_53);
    		importManager.addImport("com.jeefuse.base.modules.keyLabel.KeyLabel");
    		importManager.addImport("com.jeefuse.base.modules.keyLabel.KeyLabelRenderUtil");
    stringBuffer.append(TEXT_54);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(relTargetClassAllKeyLabelList);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(relTargetClassPackageServiceFactoryClassName);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(relTargetClassServiceUnCapName);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(relTargetClassGetAllForKeyLabel);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(relTargetClassCheckboxs);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(relTargetClassAllKeyLabelList);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(relTargetClassCheckboxsDomId);
    stringBuffer.append(TEXT_62);
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
    stringBuffer.append(TEXT_63);
    		//relPropertyShowCheckTree
    		String relTargetClassShowCheckTreeJson=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relShowCheckTreeJson);
    		String relTargetClassAllTreeviewList=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.allTreeviewList);
    		String relTargetClassGetAllForTreeviewList=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.getAllForTreeviewList);
    stringBuffer.append(TEXT_64);
    		importManager.addImport("com.jeefuse.base.modules.tree.renders.treeview.TreeViewItem");
    		importManager.addImport("com.jeefuse.base.modules.tree.TreeRenderUtil");
    stringBuffer.append(TEXT_65);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(relTargetClassAllTreeviewList);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(relTargetClassPackageServiceFactoryClassName);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(relTargetClassServiceUnCapName);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(relTargetClassGetAllForTreeviewList);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(relTargetClassShowCheckTreeJson);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(relTargetClassAllTreeviewList);
    stringBuffer.append(TEXT_72);
    	}
    }
    stringBuffer.append(TEXT_73);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_74);
    		importManager.addImport("com.jeefuse.base.utils.common.ChangeUtil");
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
    		importManager.addImport("com.jeefuse.base.modules.tree.TreeRenderUtil");
    stringBuffer.append(TEXT_115);
    }
    stringBuffer.append(TEXT_116);
    	if(FunctionStereotypeUtil.isApplied_saveOutJson(uml2Class)){
    stringBuffer.append(TEXT_117);
    importManager.addImport("org.hibernate.validator.InvalidStateException");
    stringBuffer.append(TEXT_118);
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
    stringBuffer.append(TEXT_119);
    		String relTargetClassGetRelCheckIdsMethod=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.getRelCheckIdsMethod);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(relTargetClassCheckIds);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(relTargetClassGetRelCheckIdsMethod);
    stringBuffer.append(TEXT_122);
    		saveCheckIdsSb.append(relTargetClassCheckIds);
    stringBuffer.append(TEXT_123);
    		if(it.hasNext())saveCheckIdsSb.append(",");
    	}
    }
    stringBuffer.append(TEXT_124);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(saveCheckIdsSb.toString());
    stringBuffer.append(TEXT_126);
    stringBuffer.append(modelRenderUtilName);
    stringBuffer.append(TEXT_127);
    
//model validate
String modelQualifiedForValidate=MdaHelper.getModelQualifiedName(uml2Class,PKGSuffix.Validate,ModelNameSuffix.Validate);
String modelClassNameForValidate=MdaHelper.getModelClassName(uml2Class,ModelNameSuffix.Validate);
importManager.addImport(modelQualifiedForValidate);

    stringBuffer.append(TEXT_128);
    stringBuffer.append(modelClassNameForValidate);
    stringBuffer.append(TEXT_129);
    importManager.addImport("com.jeefuse.base.exception.AppAssert");
    stringBuffer.append(TEXT_130);
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
    stringBuffer.append(TEXT_131);
    		String relTargetClassGetRelCheckIdsMethod=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.getRelCheckIdsMethod);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(relTargetClassCheckIds);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(relTargetClassGetRelCheckIdsMethod);
    stringBuffer.append(TEXT_134);
    		updateCheckIdsSb.append(relTargetClassCheckIds);
    stringBuffer.append(TEXT_135);
    		if(it.hasNext())updateCheckIdsSb.append(",");
    	}
    }
    stringBuffer.append(TEXT_136);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(saveCheckIdsSb.toString());
    stringBuffer.append(TEXT_138);
    stringBuffer.append(modelRenderUtilName);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(modelClassNameForValidate);
    stringBuffer.append(TEXT_140);
    	}
    stringBuffer.append(TEXT_141);
    	if(FunctionStereotypeUtil.isApplied_deleteOutJson(uml2Class)){
    stringBuffer.append(TEXT_142);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_144);
    	}
    stringBuffer.append(TEXT_145);
    	if(FunctionStereotypeUtil.isApplied_deleteAllOutJson(uml2Class)){
    stringBuffer.append(TEXT_146);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_147);
    	}
    stringBuffer.append(TEXT_148);
    	if(ServiceStereotypeUtil.isApplied_expExcel(uml2Class)){//isApplied exportExcelFile
    
//model exportFactory 
String modelExportFactoryQualifiedName=MdaHelper.getModelQualifiedName(uml2Class,PKGSuffix.exportFactory,ModelNameSuffix.exportFactory);
//String modelExportFactoryPackageName=MdaHelper.getPackageQualifiedName(uml2Class,PKGSuffix.exportFactory);
String modelExportFactoryClassName=MdaHelper.getModelClassName(uml2Class,ModelNameSuffix.exportFactory);
importManager.addImport(modelExportFactoryQualifiedName);

//model excel export file name
//String ExcelExportTemplateFileCapName=PropertyNamedRuleKind.ExcelExportTemplateFileName.getRuleCapNamed(uml2Class);
//String ExcelExportTemplateFileUncapName=PropertyNamedRuleKind.ExcelExportTemplateFileName.getRuleUnCapNamed(uml2Class);


    stringBuffer.append(TEXT_149);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(modelExportFactoryClassName);
    stringBuffer.append(TEXT_151);
    	}//isApplied exportExcelFile end
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

    		importManager.addImport("java.io.File");
    		importManager.addImport("java.io.IOException");
    		importManager.addImport("java.util.List");
    stringBuffer.append(TEXT_152);
    stringBuffer.append(WebUrlName.importExcelFileProcess.getValue());
    stringBuffer.append(TEXT_153);
    stringBuffer.append(modelCapName);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(modelImportFactoryClassName);
    stringBuffer.append(TEXT_155);
    importManager.addImport("com.jeefuse.base.web.result.ResultMsg");
    stringBuffer.append(TEXT_156);
    stringBuffer.append(modelCapName);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(MethodNamedRuleKind.importDatas.getRuleNamed(uml2Class));
    stringBuffer.append(TEXT_159);
    	}
    stringBuffer.append(TEXT_160);
    //code kind define
    List<Property> codeKindPropertiesList=EnumKindHelper.getPropertiesAppliedEnumKind(uml2Class);
    if(null!=codeKindPropertiesList&&codeKindPropertiesList.size()>0){
    	//importManager.addImport("java.util.Map");
    	for(Property property:codeKindPropertiesList){
    		String propertyGetAccessorName=ClassHelper.getGetAccessor(property);
    stringBuffer.append(TEXT_161);
    		Enumeration enumeration=EnumKindHelper.getAppliedEnumKindEnumeration(property);
    		if(null!=enumeration){
    			String modelEnumQualifiedName=MdaHelper.getModelQualifiedName(enumeration,PKGSuffix.enumeration,ModelNameSuffix.enumeration);
    			String modelEnumName=MdaHelper.getModelClassName(enumeration,ModelNameSuffix.enumeration);
    			String modelEnumSelectHtml=NamedUtil.getPropertyNamed(enumeration,PropertyNamedRuleKind.selectHtml);
    			importManager.addImport(modelEnumQualifiedName);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(modelEnumSelectHtml);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(modelEnumName);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(propertyGetAccessorName);
    stringBuffer.append(TEXT_165);
    			String modelEnumJsoncapName=NamedUtil.getPropertyNamed(enumeration,PropertyNamedRuleKind.elementJsonNamed);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(modelEnumJsoncapName);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(modelEnumName);
    stringBuffer.append(TEXT_168);
    		}
    	}
    }
    stringBuffer.append(TEXT_169);
    if(null!=pageAccessAttrList){
     for(String str:pageAccessAttrList){
    stringBuffer.append(TEXT_170);
    stringBuffer.append(NameHelper.getCapName(str));
    stringBuffer.append(TEXT_171);
    if(str.endsWith("Json")){
    stringBuffer.append(TEXT_172);
    stringBuffer.append(str);
    stringBuffer.append(TEXT_173);
    }
    stringBuffer.append(TEXT_174);
    stringBuffer.append(str);
    stringBuffer.append(TEXT_175);
    	}
    stringBuffer.append(TEXT_176);
    }
    stringBuffer.append(TEXT_177);
    importStringBuffer.insert(importInsertionPoint, importManager.computeSortedImports());
    }else if(FileStereotypeHelper.isClass_file(uml2Class_proxy)||FileStereotypeHelper.isClass_Image(uml2Class_proxy)){//应用了File or Image
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

    stringBuffer.append(TEXT_178);
    stringBuffer.append(modelActionQualifiedName);
    stringBuffer.append(TEXT_179);
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
    stringBuffer.append(TEXT_180);
    stringBuffer.append(modelCommentName);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(System.getProperty("user.name"));
    stringBuffer.append(TEXT_182);
    stringBuffer.append(modelActionName);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(modelRTOName);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(modelCommentName);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(modelServiceName);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(modelCapName);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(modelCapName);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(modelRTOName);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(modelCapName);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(modelCapName);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(modelRTOName);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(modelRTOName);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(modelCapName);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(modelCapName);
    stringBuffer.append(TEXT_196);
    if(FunctionStereotypeUtil.isApplied_manage(uml2Class)){
    stringBuffer.append(TEXT_197);
    }
    stringBuffer.append(TEXT_198);
    if(FunctionStereotypeUtil.isApplied_listOutJson(uml2Class)){
    stringBuffer.append(TEXT_199);
    /********is apply tree********/
    if(ModelStereoTypeHelper.isApplyModel_Tree(uml2Class)){
    stringBuffer.append(TEXT_200);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_201);
    }else{
    stringBuffer.append(TEXT_202);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_203);
    }
    stringBuffer.append(TEXT_204);
    stringBuffer.append(modelRenderUtilName);
    stringBuffer.append(TEXT_205);
    }
    stringBuffer.append(TEXT_206);
    /********is apply image********/
    if(FileStereotypeHelper.isClass_Image(uml2Class)){
    stringBuffer.append(TEXT_207);
    stringBuffer.append(modelCapName);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(modelCapName);
    stringBuffer.append(TEXT_209);
    	pageAccessAttrList.add(modelCapName+"List");
    stringBuffer.append(TEXT_210);
    stringBuffer.append(modelCapName);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_212);
    }
    stringBuffer.append(TEXT_213);
    if(FunctionStereotypeUtil.isApplied_getOutJson(uml2Class)){
    stringBuffer.append(TEXT_214);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(modelRenderUtilName);
    stringBuffer.append(TEXT_216);
    }
    stringBuffer.append(TEXT_217);
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
    stringBuffer.append(TEXT_218);
    stringBuffer.append(relPropertyCheckboxsDomId);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(relPropertyCheckboxs);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(relPropertyCheckboxs);
    stringBuffer.append(TEXT_222);
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
    stringBuffer.append(TEXT_223);
    stringBuffer.append(relPropertyShowCheckTreeJson);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_225);
    		pageAccessAttrList.add(relPropertyShowCheckTreeJson);
    	}
    stringBuffer.append(TEXT_226);
    if(FunctionStereotypeUtil.isApplied_input(uml2Class)||FunctionStereotypeUtil.isApplied_edit(uml2Class)){//is applied edit
    }
    stringBuffer.append(TEXT_227);
    /********process rel M2MCheckboxs process********/
    stringBuffer.append(TEXT_228);
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
    stringBuffer.append(TEXT_229);
    		//relTargetClassCheckboxs
    stringBuffer.append(TEXT_230);
    		String relTargetClassCheckboxs=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relCheckboxs);
    		String relTargetClassCheckboxsDomId=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relCheckboxsDomId);
    		String relTargetClassAllKeyLabelList=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.allKeyLabelList);
    		String relTargetClassGetAllForKeyLabel=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.getAllForKeyLabel);
    stringBuffer.append(TEXT_231);
    		importManager.addImport("com.jeefuse.base.modules.keyLabel.KeyLabel");
    		importManager.addImport("com.jeefuse.base.modules.keyLabel.KeyLabelRenderUtil");
    stringBuffer.append(TEXT_232);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(relTargetClassAllKeyLabelList);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(relTargetClassPackageServiceFactoryClassName);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(relTargetClassServiceUnCapName);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(relTargetClassGetAllForKeyLabel);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(relTargetClassCheckboxs);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(relTargetClassAllKeyLabelList);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(relTargetClassCheckboxsDomId);
    stringBuffer.append(TEXT_240);
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
    stringBuffer.append(TEXT_241);
    		//relPropertyShowCheckTree
    		String relTargetClassShowCheckTreeJson=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relShowCheckTreeJson);
    		String relTargetClassAllTreeviewList=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.allTreeviewList);
    		String relTargetClassGetAllForTreeviewList=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.getAllForTreeviewList);
    stringBuffer.append(TEXT_242);
    		importManager.addImport("com.jeefuse.base.modules.tree.renders.treeview.TreeViewItem");
    		importManager.addImport("com.jeefuse.base.modules.tree.TreeRenderUtil");
    stringBuffer.append(TEXT_243);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(relTargetClassAllTreeviewList);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(relTargetClassPackageServiceFactoryClassName);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(relTargetClassServiceUnCapName);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(relTargetClassGetAllForTreeviewList);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(relTargetClassShowCheckTreeJson);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(relTargetClassAllTreeviewList);
    stringBuffer.append(TEXT_250);
    	}
    }
    stringBuffer.append(TEXT_251);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_252);
    /********process rel M2MCheckboxs process********/
    stringBuffer.append(TEXT_253);
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
    stringBuffer.append(TEXT_254);
    		//relPropertyCheckboxs
    stringBuffer.append(TEXT_255);
    		String relTargetClassCheckboxs=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relCheckboxs);
    		String relTargetClassCheckboxsDomId=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relCheckboxsDomId);
    		String relTargetClassAllKeyLabelList=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.allKeyLabelList);
    		String relTargetClassGetAllForKeyLabel=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.getAllForKeyLabel);
    stringBuffer.append(TEXT_256);
    		String relTargetClassIdsList=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relIdsList);
    stringBuffer.append(TEXT_257);
    		String relTargetClassGetRelIdsMethodName=ModelHelper.getRelIdsMethodName(relTargetClass,uml2Class);
    stringBuffer.append(TEXT_258);
    		importManager.addImport("com.jeefuse.base.modules.keyLabel.KeyLabel");
    		importManager.addImport("com.jeefuse.base.modules.keyLabel.KeyLabelRenderUtil");
    stringBuffer.append(TEXT_259);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(relTargetClassAllKeyLabelList);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(relTargetClassPackageServiceFactoryClassName);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(relTargetClassServiceUnCapName);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(relTargetClassGetAllForKeyLabel);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(relTargetClassIdsList);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(relTargetClassPackageServiceFactoryClassName);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(relTargetClassServiceUnCapName);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(relTargetClassGetRelIdsMethodName);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(relTargetClassCheckboxs);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(relTargetClassAllKeyLabelList);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(relTargetClassIdsList);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(relTargetClassCheckboxsDomId);
    stringBuffer.append(TEXT_272);
    	}
    }
    stringBuffer.append(TEXT_273);
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
    stringBuffer.append(TEXT_274);
    		//relPropertyShowCheckTree
    		String relTargetClassShowCheckTreeJson=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relShowCheckTreeJson);
    		String relTargetClassAllTreeviewList=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.allTreeviewList);
    		String relTargetClassGetAllForTreeviewList=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.getAllForTreeviewList);
    stringBuffer.append(TEXT_275);
    		String relTargetClassIdsList=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relIdsList);
    stringBuffer.append(TEXT_276);
    		String relTargetClassGetRelIdsMethodName=ModelHelper.getRelIdsMethodName(relTargetClass,uml2Class);
    stringBuffer.append(TEXT_277);
    		importManager.addImport("com.jeefuse.base.modules.tree.renders.treeview.TreeViewItem");
    		importManager.addImport("com.jeefuse.base.modules.tree.TreeRenderUtil");
    stringBuffer.append(TEXT_278);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(relTargetClassAllTreeviewList);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(relTargetClassPackageServiceFactoryClassName);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(relTargetClassServiceUnCapName);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(relTargetClassGetAllForTreeviewList);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(relTargetClassIdsList);
    stringBuffer.append(TEXT_284);
    stringBuffer.append(relTargetClassPackageServiceFactoryClassName);
    stringBuffer.append(TEXT_285);
    stringBuffer.append(relTargetClassServiceUnCapName);
    stringBuffer.append(TEXT_286);
    stringBuffer.append(relTargetClassGetRelIdsMethodName);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(relTargetClassShowCheckTreeJson);
    stringBuffer.append(TEXT_288);
    stringBuffer.append(relTargetClassAllTreeviewList);
    stringBuffer.append(TEXT_289);
    stringBuffer.append(relTargetClassIdsList);
    stringBuffer.append(TEXT_290);
    	}
    }
    stringBuffer.append(TEXT_291);
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
    stringBuffer.append(TEXT_292);
    	if(FunctionStereotypeUtil.isApplied_saveOutJson(uml2Class)){//start isApplied saveOutjson
    stringBuffer.append(TEXT_293);
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
    stringBuffer.append(TEXT_294);
    		String relTargetClassGetRelCheckIdsMethod=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.getRelCheckIdsMethod);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(relTargetClassCheckIds);
    stringBuffer.append(TEXT_296);
    stringBuffer.append(relTargetClassGetRelCheckIdsMethod);
    stringBuffer.append(TEXT_297);
    		saveCheckIdsSb.append(relTargetClassCheckIds);
    stringBuffer.append(TEXT_298);
    		if(it.hasNext())saveCheckIdsSb.append(",");
    	}
    }
    importManager.addImport("com.jeefuse.base.web.uploadFile.UploadFile");
    stringBuffer.append(TEXT_299);
    stringBuffer.append(modelFileUploadClassName);
    stringBuffer.append(TEXT_300);
    if(null!=propertyFileSavePath){
    		//String propertyGetAccessorName=ClassHelper.getGetAccessor(propertyFileSavePath);
    stringBuffer.append(TEXT_301);
    		String propertySetAccessorName="set"+ClassHelper.getAccessorName(propertyFileSavePath);
    stringBuffer.append(TEXT_302);
    stringBuffer.append(propertySetAccessorName);
    stringBuffer.append(TEXT_303);
    }else{
    stringBuffer.append(TEXT_304);
    }
    if(null!=propertyFileVisitPath){
    		//String propertyGetAccessorName=ClassHelper.getGetAccessor(propertyFileVisitPath);
    stringBuffer.append(TEXT_305);
    		String propertySetAccessorName="set"+ClassHelper.getAccessorName(propertyFileVisitPath);
    stringBuffer.append(TEXT_306);
    stringBuffer.append(propertySetAccessorName);
    stringBuffer.append(TEXT_307);
    }
    stringBuffer.append(TEXT_308);
    if(null!=propertyFileFileSize){
    		//String propertyGetAccessorName=ClassHelper.getGetAccessor(propertyFileFileSize);
    stringBuffer.append(TEXT_309);
    		String propertySetAccessorName="set"+ClassHelper.getAccessorName(propertyFileFileSize);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(propertySetAccessorName);
    stringBuffer.append(TEXT_311);
    }
    if(null!=propertyFileExtention){
    		//String propertyGetAccessorName=ClassHelper.getGetAccessor(propertyFileExtention);
    stringBuffer.append(TEXT_312);
    		String propertySetAccessorName="set"+ClassHelper.getAccessorName(propertyFileExtention);
    stringBuffer.append(TEXT_313);
    stringBuffer.append(propertySetAccessorName);
    stringBuffer.append(TEXT_314);
    }
    if(null!=propertyFileFileType){
    		//String propertyGetAccessorName=ClassHelper.getGetAccessor(propertyFileFileType);
    stringBuffer.append(TEXT_315);
    		String propertySetAccessorName="set"+ClassHelper.getAccessorName(propertyFileFileType);
    stringBuffer.append(TEXT_316);
    stringBuffer.append(propertySetAccessorName);
    stringBuffer.append(TEXT_317);
    }
    if(null!=propertyFileApplyFileName){
    		//String propertyGetAccessorName=ClassHelper.getGetAccessor(propertyFileApplyFileName);
    stringBuffer.append(TEXT_318);
    		String propertySetAccessorName="set"+ClassHelper.getAccessorName(propertyFileApplyFileName);
    stringBuffer.append(TEXT_319);
    stringBuffer.append(propertySetAccessorName);
    stringBuffer.append(TEXT_320);
    }
    stringBuffer.append(TEXT_321);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_322);
    stringBuffer.append(saveCheckIdsSb.toString());
    stringBuffer.append(TEXT_323);
    stringBuffer.append(modelRenderUtilName);
    stringBuffer.append(TEXT_324);
    importManager.addImport("org.hibernate.validator.InvalidStateException");
    stringBuffer.append(TEXT_325);
    
//model validate
String modelQualifiedForValidate=MdaHelper.getModelQualifiedName(uml2Class,PKGSuffix.Validate,ModelNameSuffix.Validate);
String modelClassNameForValidate=MdaHelper.getModelClassName(uml2Class,ModelNameSuffix.Validate);
importManager.addImport(modelQualifiedForValidate);

    stringBuffer.append(TEXT_326);
    stringBuffer.append(modelClassNameForValidate);
    stringBuffer.append(TEXT_327);
    importManager.addImport("com.jeefuse.base.exception.AppAssert");
    stringBuffer.append(TEXT_328);
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
    stringBuffer.append(TEXT_329);
    		String relTargetClassGetRelCheckIdsMethod=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.getRelCheckIdsMethod);
    stringBuffer.append(TEXT_330);
    stringBuffer.append(relTargetClassCheckIds);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(relTargetClassGetRelCheckIdsMethod);
    stringBuffer.append(TEXT_332);
    		updateCheckIdsSb.append(relTargetClassCheckIds);
    stringBuffer.append(TEXT_333);
    		if(it.hasNext())updateCheckIdsSb.append(",");
    	}
    }
    stringBuffer.append(TEXT_334);
    stringBuffer.append(modelCapName);
    stringBuffer.append(TEXT_335);
    stringBuffer.append(modelUncapName);
    stringBuffer.append(TEXT_336);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_337);
    stringBuffer.append(modelUncapName);
    stringBuffer.append(TEXT_338);
    if(null!=propertyFileSavePath){
    		String propertyGetAccessorName=ClassHelper.getGetAccessor(propertyFileSavePath);
    stringBuffer.append(TEXT_339);
    		//String propertySetAccessorName="set"+ClassHelper.getAccessorName(propertyFileSavePath);
    stringBuffer.append(TEXT_340);
    stringBuffer.append(modelUncapName);
    stringBuffer.append(TEXT_341);
    stringBuffer.append(propertyGetAccessorName);
    stringBuffer.append(TEXT_342);
    }else{
    stringBuffer.append(TEXT_343);
    stringBuffer.append(modelUncapName);
    stringBuffer.append(TEXT_344);
    }
    stringBuffer.append(TEXT_345);
    stringBuffer.append(modelFileUploadClassName);
    stringBuffer.append(TEXT_346);
    if(null!=propertyFileSavePath){
    		//String propertyGetAccessorName=ClassHelper.getGetAccessor(propertyFileSavePath);
    stringBuffer.append(TEXT_347);
    		String propertySetAccessorName="set"+ClassHelper.getAccessorName(propertyFileSavePath);
    stringBuffer.append(TEXT_348);
    stringBuffer.append(propertySetAccessorName);
    stringBuffer.append(TEXT_349);
    }else{
    stringBuffer.append(TEXT_350);
    }
    stringBuffer.append(TEXT_351);
    if(null!=propertyFileVisitPath){
    		//String propertyGetAccessorName=ClassHelper.getGetAccessor(propertyFileVisitPath);
    stringBuffer.append(TEXT_352);
    		String propertySetAccessorName="set"+ClassHelper.getAccessorName(propertyFileVisitPath);
    stringBuffer.append(TEXT_353);
    stringBuffer.append(propertySetAccessorName);
    stringBuffer.append(TEXT_354);
    }
    stringBuffer.append(TEXT_355);
    if(null!=propertyFileFileSize){
    		//String propertyGetAccessorName=ClassHelper.getGetAccessor(propertyFileFileSize);
    stringBuffer.append(TEXT_356);
    		String propertySetAccessorName="set"+ClassHelper.getAccessorName(propertyFileFileSize);
    stringBuffer.append(TEXT_357);
    stringBuffer.append(propertySetAccessorName);
    stringBuffer.append(TEXT_358);
    }
    if(null!=propertyFileExtention){
    		//String propertyGetAccessorName=ClassHelper.getGetAccessor(propertyFileExtention);
    stringBuffer.append(TEXT_359);
    		String propertySetAccessorName="set"+ClassHelper.getAccessorName(propertyFileExtention);
    stringBuffer.append(TEXT_360);
    stringBuffer.append(propertySetAccessorName);
    stringBuffer.append(TEXT_361);
    }
    if(null!=propertyFileFileType){
    		//String propertyGetAccessorName=ClassHelper.getGetAccessor(propertyFileFileType);
    stringBuffer.append(TEXT_362);
    		String propertySetAccessorName="set"+ClassHelper.getAccessorName(propertyFileFileType);
    stringBuffer.append(TEXT_363);
    stringBuffer.append(propertySetAccessorName);
    stringBuffer.append(TEXT_364);
    }
    if(null!=propertyFileApplyFileName){
    		//String propertyGetAccessorName=ClassHelper.getGetAccessor(propertyFileApplyFileName);
    stringBuffer.append(TEXT_365);
    		String propertySetAccessorName="set"+ClassHelper.getAccessorName(propertyFileApplyFileName);
    stringBuffer.append(TEXT_366);
    stringBuffer.append(propertySetAccessorName);
    stringBuffer.append(TEXT_367);
    }
    stringBuffer.append(TEXT_368);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_369);
    stringBuffer.append(saveCheckIdsSb.toString());
    stringBuffer.append(TEXT_370);
    stringBuffer.append(modelRenderUtilName);
    stringBuffer.append(TEXT_371);
    stringBuffer.append(modelClassNameForValidate);
    stringBuffer.append(TEXT_372);
    }//end isApplied saveOutjson
    stringBuffer.append(TEXT_373);
    	if(FunctionStereotypeUtil.isApplied_deleteOutJson(uml2Class)){
    stringBuffer.append(TEXT_374);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_375);
    stringBuffer.append(modelCapName);
    stringBuffer.append(TEXT_376);
    stringBuffer.append(modelUncapName);
    stringBuffer.append(TEXT_377);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_378);
    if(null!=propertyFileSavePath){
    		String propertyGetAccessorName=ClassHelper.getGetAccessor(propertyFileSavePath);
    stringBuffer.append(TEXT_379);
    		//String propertySetAccessorName="set"+ClassHelper.getAccessorName(propertyFileSavePath);
    stringBuffer.append(TEXT_380);
    stringBuffer.append(modelUncapName);
    stringBuffer.append(TEXT_381);
    stringBuffer.append(propertyGetAccessorName);
    stringBuffer.append(TEXT_382);
    }else{
    stringBuffer.append(TEXT_383);
    stringBuffer.append(modelUncapName);
    stringBuffer.append(TEXT_384);
    }
    stringBuffer.append(TEXT_385);
    stringBuffer.append(modelFileUploadClassName);
    stringBuffer.append(TEXT_386);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_387);
    stringBuffer.append(modelUncapName);
    stringBuffer.append(TEXT_388);
    	}
    stringBuffer.append(TEXT_389);
    	if(FunctionStereotypeUtil.isApplied_deleteAllOutJson(uml2Class)){//isApplied deleteAllOutJson
    stringBuffer.append(TEXT_390);
    stringBuffer.append(modelCapName);
    stringBuffer.append(TEXT_391);
    stringBuffer.append(modelUncapName);
    stringBuffer.append(TEXT_392);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_393);
    stringBuffer.append(modelCapName);
    stringBuffer.append(TEXT_394);
    stringBuffer.append(modelUncapName);
    stringBuffer.append(TEXT_395);
    stringBuffer.append(modelUncapName);
    stringBuffer.append(TEXT_396);
    if(null!=propertyFileSavePath){
    		String propertyGetAccessorName=ClassHelper.getGetAccessor(propertyFileSavePath);
    stringBuffer.append(TEXT_397);
    		//String propertySetAccessorName="set"+ClassHelper.getAccessorName(propertyFileSavePath);
    stringBuffer.append(TEXT_398);
    stringBuffer.append(modelUncapName);
    stringBuffer.append(TEXT_399);
    stringBuffer.append(propertyGetAccessorName);
    stringBuffer.append(TEXT_400);
    }else{
    stringBuffer.append(TEXT_401);
    stringBuffer.append(modelUncapName);
    stringBuffer.append(TEXT_402);
    }
    stringBuffer.append(TEXT_403);
    stringBuffer.append(modelFileUploadClassName);
    stringBuffer.append(TEXT_404);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_405);
    stringBuffer.append(modelUncapName);
    stringBuffer.append(TEXT_406);
    	}//isApplied deleteAllOutJson end
    stringBuffer.append(TEXT_407);
    
if(ServiceStereotypeUtil.isApplied_expExcel(uml2Class)){//isApplied importExcelFile
//model exportFactory 
String modelExportFactoryQualifiedName=MdaHelper.getModelQualifiedName(uml2Class,PKGSuffix.exportFactory,ModelNameSuffix.exportFactory);
//String modelExportFactoryPackageName=MdaHelper.getPackageQualifiedName(uml2Class,PKGSuffix.exportFactory);
String modelExportFactoryClassName=MdaHelper.getModelClassName(uml2Class,ModelNameSuffix.exportFactory);
importManager.addImport(modelExportFactoryQualifiedName);
//model excel export file name
//String ExcelExportTemplateFileCapName=PropertyNamedRuleKind.ExcelExportTemplateFileName.getRuleCapNamed(uml2Class);
//String ExcelExportTemplateFileUncapName=PropertyNamedRuleKind.ExcelExportTemplateFileName.getRuleUnCapNamed(uml2Class);

    stringBuffer.append(TEXT_408);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_409);
    stringBuffer.append(modelExportFactoryClassName);
    stringBuffer.append(TEXT_410);
    }//isApplied importExcelFile end
    stringBuffer.append(TEXT_411);
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

    stringBuffer.append(TEXT_412);
    stringBuffer.append(WebUrlName.importExcelFileProcess.getValue());
    stringBuffer.append(TEXT_413);
    stringBuffer.append(modelCapName);
    stringBuffer.append(TEXT_414);
    stringBuffer.append(modelImportFactoryClassName);
    stringBuffer.append(TEXT_415);
    importManager.addImport("com.jeefuse.base.web.result.ResultMsg");
    stringBuffer.append(TEXT_416);
    stringBuffer.append(modelCapName);
    stringBuffer.append(TEXT_417);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_418);
    stringBuffer.append(NamedUtil.getMethodNamedCapital(uml2Class,MethodNamedRuleKind.importDatas));
    stringBuffer.append(TEXT_419);
    }
    stringBuffer.append(TEXT_420);
    //code kind define
    List<Property> codeKindPropertiesList=EnumKindHelper.getPropertiesAppliedEnumKind(uml2Class);
    if(null!=codeKindPropertiesList&&codeKindPropertiesList.size()>0){
    	//importManager.addImport("java.util.Map");
    stringBuffer.append(TEXT_421);
    	for(Property property:codeKindPropertiesList){
    		String propertyGetAccessorName=ClassHelper.getGetAccessor(property);
    stringBuffer.append(TEXT_422);
    		Enumeration enumeration=EnumKindHelper.getAppliedEnumKindEnumeration(property);
    		if(null!=enumeration){
    			String modelEnumQualifiedName=MdaHelper.getModelQualifiedName(enumeration,PKGSuffix.enumeration,ModelNameSuffix.enumeration);
    			String modelEnumName=MdaHelper.getModelClassName(enumeration,ModelNameSuffix.enumeration);
    			String modelEnumSelectHtml=PropertyNamedRuleKind.selectHtml.getRuleCapNamed(enumeration);
    			importManager.addImport(modelEnumQualifiedName);
    stringBuffer.append(TEXT_423);
    stringBuffer.append(modelEnumSelectHtml);
    stringBuffer.append(TEXT_424);
    stringBuffer.append(modelEnumName);
    stringBuffer.append(TEXT_425);
    stringBuffer.append(propertyGetAccessorName);
    stringBuffer.append(TEXT_426);
    			String modelEnumJsoncapName=PropertyNamedRuleKind.elementJsonNamed.getRuleCapNamed(enumeration);
    stringBuffer.append(TEXT_427);
    stringBuffer.append(modelEnumJsoncapName);
    stringBuffer.append(TEXT_428);
    stringBuffer.append(modelEnumName);
    stringBuffer.append(TEXT_429);
    		}
    	}
    }
    stringBuffer.append(TEXT_430);
    if(null!=pageAccessAttrList){
     for(String str:pageAccessAttrList){
    stringBuffer.append(TEXT_431);
    stringBuffer.append(NameHelper.getCapName(str));
    stringBuffer.append(TEXT_432);
    if(str.endsWith("Json")){
    stringBuffer.append(TEXT_433);
    stringBuffer.append(str);
    stringBuffer.append(TEXT_434);
    }
    stringBuffer.append(TEXT_435);
    stringBuffer.append(str);
    stringBuffer.append(TEXT_436);
    	}
    stringBuffer.append(TEXT_437);
    }
    stringBuffer.append(TEXT_438);
    importStringBuffer.insert(importInsertionPoint, importManager.computeSortedImports());
    }else{//只应用了Entity
    Class uml2Class = (Class) argument;Package uml2Package = uml2Class.getPackage();
    
/*******clazz wrap********/	
UmlClassWrap clazzWrap=new UmlClassWrap(uml2Class);
String modelCapName=clazzWrap.getCapName();
String modelUncapName=clazzWrap.getUncapName();
String modelCommentName=clazzWrap.getCommentName();
//action define
ClassNameDefineCommon actionDefine=clazzWrap.getNameDefineAction();
//String modelActionQualifiedName=actionDefine.getClassQualifiedName();
String modelActionPackageName=actionDefine.getPackageQualifiedName();
String modelActionName=actionDefine.getClassCapName();

    stringBuffer.append(TEXT_439);
    stringBuffer.append(modelActionPackageName);
    stringBuffer.append(TEXT_440);
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
    stringBuffer.append(TEXT_441);
    
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

    stringBuffer.append(TEXT_442);
    stringBuffer.append(modelCommentName);
    stringBuffer.append(TEXT_443);
    stringBuffer.append(System.getProperty("user.name"));
    stringBuffer.append(TEXT_444);
    stringBuffer.append(modelActionName);
    stringBuffer.append(TEXT_445);
    stringBuffer.append(modelRTOName);
    stringBuffer.append(TEXT_446);
    stringBuffer.append(modelCommentName);
    stringBuffer.append(TEXT_447);
    stringBuffer.append(modelServiceName);
    stringBuffer.append(TEXT_448);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_449);
    stringBuffer.append(modelCapName);
    stringBuffer.append(TEXT_450);
    stringBuffer.append(modelCapName);
    stringBuffer.append(TEXT_451);
    stringBuffer.append(modelRTOName);
    stringBuffer.append(TEXT_452);
    stringBuffer.append(modelCapName);
    stringBuffer.append(TEXT_453);
    stringBuffer.append(modelCapName);
    stringBuffer.append(TEXT_454);
    stringBuffer.append(modelRTOName);
    stringBuffer.append(TEXT_455);
    stringBuffer.append(modelRTOName);
    stringBuffer.append(TEXT_456);
    stringBuffer.append(modelCapName);
    stringBuffer.append(TEXT_457);
    stringBuffer.append(modelCapName);
    stringBuffer.append(TEXT_458);
    if(FunctionStereotypeUtil.isApplied_manage(uml2Class)){
    stringBuffer.append(TEXT_459);
    }
    stringBuffer.append(TEXT_460);
    if(FunctionStereotypeUtil.isApplied_listOutJson(uml2Class)){
    stringBuffer.append(TEXT_461);
    /********is apply tree********/
    if(ModelStereoTypeHelper.isApplyModel_Tree(uml2Class)){
    stringBuffer.append(TEXT_462);
    }else{
    stringBuffer.append(TEXT_463);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_464);
    }
    stringBuffer.append(TEXT_465);
    stringBuffer.append(modelRenderUtilName);
    stringBuffer.append(TEXT_466);
    }
    stringBuffer.append(TEXT_467);
    if(FunctionStereotypeUtil.isApplied_getOutJson(uml2Class)){
    stringBuffer.append(TEXT_468);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_469);
    stringBuffer.append(modelRenderUtilName);
    stringBuffer.append(TEXT_470);
    }
    stringBuffer.append(TEXT_471);
    /****** Page access attributes List   *****/
    List<String> pageAccessAttrList=new ArrayList<String>();
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
    stringBuffer.append(TEXT_472);
    stringBuffer.append(relPropertyCheckboxsDomId);
    stringBuffer.append(TEXT_473);
    stringBuffer.append(relPropertyCheckboxs);
    stringBuffer.append(TEXT_474);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_475);
    stringBuffer.append(relPropertyCheckboxs);
    stringBuffer.append(TEXT_476);
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
    stringBuffer.append(TEXT_477);
    stringBuffer.append(relPropertyShowCheckTreeJson);
    stringBuffer.append(TEXT_478);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_479);
    		pageAccessAttrList.add(relPropertyShowCheckTreeJson);
    	}
    }
    stringBuffer.append(TEXT_480);
    if(FunctionStereotypeUtil.isApplied_edit(uml2Class)||FunctionStereotypeUtil.isApplied_input(uml2Class)){//is applied edit
    stringBuffer.append(TEXT_481);
    /********process rel M2MCheckboxs process********/
    stringBuffer.append(TEXT_482);
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
    stringBuffer.append(TEXT_483);
    		//relTargetClassCheckboxs
    stringBuffer.append(TEXT_484);
    		String relTargetClassCheckboxs=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relCheckboxs);
    		String relTargetClassCheckboxsDomId=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relCheckboxsDomId);
    		String relTargetClassAllKeyLabelList=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.allKeyLabelList);
    		String relTargetClassGetAllForKeyLabel=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.getAllForKeyLabel);
    stringBuffer.append(TEXT_485);
    		importManager.addImport("com.jeefuse.base.modules.keyLabel.KeyLabel");
    		importManager.addImport("com.jeefuse.base.modules.keyLabel.KeyLabelRenderUtil");
    stringBuffer.append(TEXT_486);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_487);
    stringBuffer.append(relTargetClassAllKeyLabelList);
    stringBuffer.append(TEXT_488);
    stringBuffer.append(relTargetClassPackageServiceFactoryClassName);
    stringBuffer.append(TEXT_489);
    stringBuffer.append(relTargetClassServiceUnCapName);
    stringBuffer.append(TEXT_490);
    stringBuffer.append(relTargetClassGetAllForKeyLabel);
    stringBuffer.append(TEXT_491);
    stringBuffer.append(relTargetClassCheckboxs);
    stringBuffer.append(TEXT_492);
    stringBuffer.append(relTargetClassAllKeyLabelList);
    stringBuffer.append(TEXT_493);
    stringBuffer.append(relTargetClassCheckboxsDomId);
    stringBuffer.append(TEXT_494);
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
    stringBuffer.append(TEXT_495);
    		//relPropertyShowCheckTree
    		String relTargetClassShowCheckTreeJson=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relShowCheckTreeJson);
    		String relTargetClassAllTreeviewList=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.allTreeviewList);
    		String relTargetClassGetAllForTreeviewList=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.getAllForTreeviewList);
    stringBuffer.append(TEXT_496);
    		importManager.addImport("com.jeefuse.base.modules.tree.renders.treeview.TreeViewItem");
    		importManager.addImport("com.jeefuse.base.modules.tree.TreeRenderUtil");
    stringBuffer.append(TEXT_497);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_498);
    stringBuffer.append(relTargetClassAllTreeviewList);
    stringBuffer.append(TEXT_499);
    stringBuffer.append(relTargetClassPackageServiceFactoryClassName);
    stringBuffer.append(TEXT_500);
    stringBuffer.append(relTargetClassServiceUnCapName);
    stringBuffer.append(TEXT_501);
    stringBuffer.append(relTargetClassGetAllForTreeviewList);
    stringBuffer.append(TEXT_502);
    stringBuffer.append(relTargetClassShowCheckTreeJson);
    stringBuffer.append(TEXT_503);
    stringBuffer.append(relTargetClassAllTreeviewList);
    stringBuffer.append(TEXT_504);
    	}
    }
    stringBuffer.append(TEXT_505);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_506);
    /********process rel M2MCheckboxs process********/
    stringBuffer.append(TEXT_507);
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
    stringBuffer.append(TEXT_508);
    		//relPropertyCheckboxs
    stringBuffer.append(TEXT_509);
    		String relTargetClassCheckboxs=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relCheckboxs);
    		String relTargetClassCheckboxsDomId=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relCheckboxsDomId);
    		String relTargetClassAllKeyLabelList=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.allKeyLabelList);
    		String relTargetClassGetAllForKeyLabel=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.getAllForKeyLabel);
    stringBuffer.append(TEXT_510);
    		String relTargetClassIdsList=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relIdsList);
    stringBuffer.append(TEXT_511);
    		String relTargetClassGetRelIdsMethodName=ModelHelper.getRelIdsMethodName(relTargetClass,uml2Class);
    stringBuffer.append(TEXT_512);
    		importManager.addImport("com.jeefuse.base.modules.keyLabel.KeyLabel");
    		importManager.addImport("com.jeefuse.base.modules.keyLabel.KeyLabelRenderUtil");
    stringBuffer.append(TEXT_513);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_514);
    stringBuffer.append(relTargetClassAllKeyLabelList);
    stringBuffer.append(TEXT_515);
    stringBuffer.append(relTargetClassPackageServiceFactoryClassName);
    stringBuffer.append(TEXT_516);
    stringBuffer.append(relTargetClassServiceUnCapName);
    stringBuffer.append(TEXT_517);
    stringBuffer.append(relTargetClassGetAllForKeyLabel);
    stringBuffer.append(TEXT_518);
    stringBuffer.append(relTargetClassIdsList);
    stringBuffer.append(TEXT_519);
    stringBuffer.append(relTargetClassPackageServiceFactoryClassName);
    stringBuffer.append(TEXT_520);
    stringBuffer.append(relTargetClassServiceUnCapName);
    stringBuffer.append(TEXT_521);
    stringBuffer.append(relTargetClassGetRelIdsMethodName);
    stringBuffer.append(TEXT_522);
    stringBuffer.append(relTargetClassCheckboxs);
    stringBuffer.append(TEXT_523);
    stringBuffer.append(relTargetClassAllKeyLabelList);
    stringBuffer.append(TEXT_524);
    stringBuffer.append(relTargetClassIdsList);
    stringBuffer.append(TEXT_525);
    stringBuffer.append(relTargetClassCheckboxsDomId);
    stringBuffer.append(TEXT_526);
    	}
    }
    stringBuffer.append(TEXT_527);
    /********process rel M2MCheckboxsTree process********/
    if(null!=needM2MCheckboxsTreeList&&needM2MCheckboxsTreeList.size()>0){
    	for(Property property:needM2MCheckboxsTreeList){
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
    stringBuffer.append(TEXT_528);
    		//relPropertyShowCheckTree
    		String relTargetClassShowCheckTreeJson=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relShowCheckTreeJson);
    		String relTargetClassAllTreeviewList=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.allTreeviewList);
    		String relTargetClassGetAllForTreeviewList=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.getAllForTreeviewList);
    stringBuffer.append(TEXT_529);
    		String relTargetClassIdsList=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relIdsList);
    stringBuffer.append(TEXT_530);
    		String relTargetClassGetRelIdsMethodName=ModelHelper.getRelIdsMethodName(relTargetClass,uml2Class);
    stringBuffer.append(TEXT_531);
    		importManager.addImport("com.jeefuse.base.modules.tree.renders.treeview.TreeViewItem");
    		importManager.addImport("com.jeefuse.base.modules.tree.TreeRenderUtil");
    stringBuffer.append(TEXT_532);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_533);
    stringBuffer.append(relTargetClassAllTreeviewList);
    stringBuffer.append(TEXT_534);
    stringBuffer.append(relTargetClassPackageServiceFactoryClassName);
    stringBuffer.append(TEXT_535);
    stringBuffer.append(relTargetClassServiceUnCapName);
    stringBuffer.append(TEXT_536);
    stringBuffer.append(relTargetClassGetAllForTreeviewList);
    stringBuffer.append(TEXT_537);
    stringBuffer.append(relTargetClassIdsList);
    stringBuffer.append(TEXT_538);
    stringBuffer.append(relTargetClassPackageServiceFactoryClassName);
    stringBuffer.append(TEXT_539);
    stringBuffer.append(relTargetClassServiceUnCapName);
    stringBuffer.append(TEXT_540);
    stringBuffer.append(relTargetClassGetRelIdsMethodName);
    stringBuffer.append(TEXT_541);
    stringBuffer.append(relTargetClassShowCheckTreeJson);
    stringBuffer.append(TEXT_542);
    stringBuffer.append(relTargetClassAllTreeviewList);
    stringBuffer.append(TEXT_543);
    stringBuffer.append(relTargetClassIdsList);
    stringBuffer.append(TEXT_544);
    	}
    }
    stringBuffer.append(TEXT_545);
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
    List<Property> fileAndImageProperties=FileStereotypeHelper.getProperties_FileAndImage(uml2Class);
    stringBuffer.append(TEXT_546);
    	if(FunctionStereotypeUtil.isApplied_saveOutJson(uml2Class)){//start isApplied saveOutjson
    stringBuffer.append(TEXT_547);
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
    stringBuffer.append(TEXT_548);
    		String relTargetClassGetRelCheckIdsMethod=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.getRelCheckIdsMethod);
    stringBuffer.append(TEXT_549);
    stringBuffer.append(relTargetClassCheckIds);
    stringBuffer.append(TEXT_550);
    stringBuffer.append(relTargetClassGetRelCheckIdsMethod);
    stringBuffer.append(TEXT_551);
    		saveCheckIdsSb.append(relTargetClassCheckIds);
    stringBuffer.append(TEXT_552);
    		if(it.hasNext())saveCheckIdsSb.append(",");
    	}
    }
    stringBuffer.append(TEXT_553);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_554);
    stringBuffer.append(saveCheckIdsSb.toString());
    stringBuffer.append(TEXT_555);
    
/*****************************************************************
 * process image and file property
/*****************************************************************/
    if(null!=fileAndImageProperties&&!fileAndImageProperties.isEmpty()){
    
/*****************************************************************
 * model FileUpload
/*****************************************************************/
    //String modelFileUploadPackageName=MdaHelper.getPackageQualifiedName(uml2Class,PKGSuffix.fileUpload);
    String modelFileUploadClassName=MdaHelper.getModelClassName(uml2Class,ModelNameSuffix.fileUpload);
    String modelFileUploadQualifiedClassName=MdaHelper.getModelQualifiedName(uml2Class,PKGSuffix.fileUpload,ModelNameSuffix.fileUpload);
    importManager.addImport(modelFileUploadQualifiedClassName);
    	for(Iterator<Property> it=fileAndImageProperties.iterator();it.hasNext();) {// image
    		Property property=it.next();
     		String propertyCapSafeName=NameHelper.getCapName(property);
     		//String propertyUncapSafeName=NameHelper.uncapSafeName(property);
    		String propertySetAccessorName="set"+ClassHelper.getAccessorName(property);
     		String propertyComment=TypeHelper.getDocumentationOrName(property);
    		importManager.addImport("com.jeefuse.base.web.uploadFile.UploadFile");
    		importManager.addImport("java.io.File");
    stringBuffer.append(TEXT_556);
    stringBuffer.append(propertyComment);
    stringBuffer.append(TEXT_557);
    stringBuffer.append(modelFileUploadClassName);
    stringBuffer.append(TEXT_558);
    stringBuffer.append(propertyCapSafeName);
    stringBuffer.append(TEXT_559);
    stringBuffer.append(propertySetAccessorName);
    stringBuffer.append(TEXT_560);
    	}
    }
    stringBuffer.append(TEXT_561);
    stringBuffer.append(modelRenderUtilName);
    stringBuffer.append(TEXT_562);
    importManager.addImport("org.hibernate.validator.InvalidStateException");
    stringBuffer.append(TEXT_563);
    
//model validate
String modelQualifiedForValidate=MdaHelper.getModelQualifiedName(uml2Class,PKGSuffix.Validate,ModelNameSuffix.Validate);
//String modelPackageNameForValidate=MdaHelper.getPackageQualifiedName(uml2Class,PKGSuffix.Validate);
String modelClassNameForValidate=MdaHelper.getModelClassName(uml2Class,ModelNameSuffix.Validate);
importManager.addImport(modelQualifiedForValidate);

    stringBuffer.append(TEXT_564);
    stringBuffer.append(modelClassNameForValidate);
    stringBuffer.append(TEXT_565);
    importManager.addImport("com.jeefuse.base.exception.AppAssert");
    stringBuffer.append(TEXT_566);
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
    stringBuffer.append(TEXT_567);
    		String relTargetClassGetRelCheckIdsMethod=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.getRelCheckIdsMethod);
    stringBuffer.append(TEXT_568);
    stringBuffer.append(relTargetClassCheckIds);
    stringBuffer.append(TEXT_569);
    stringBuffer.append(relTargetClassGetRelCheckIdsMethod);
    stringBuffer.append(TEXT_570);
    		updateCheckIdsSb.append(relTargetClassCheckIds);
    stringBuffer.append(TEXT_571);
    		if(it.hasNext())updateCheckIdsSb.append(",");
    	}
    }
    
/*****************************************************************
 * process image and file property
/*****************************************************************/
    if(null!=fileAndImageProperties&&!fileAndImageProperties.isEmpty()){
    
/*****************************************************************
 * model FileUpload
/*****************************************************************/
    		importManager.addImport("java.io.File");
    //String modelFileUploadPackageName=MdaHelper.getPackageQualifiedName(uml2Class,PKGSuffix.fileUpload);
    String modelFileUploadClassName=MdaHelper.getModelClassName(uml2Class,ModelNameSuffix.fileUpload);
    String modelFileUploadQualifiedClassName=MdaHelper.getModelQualifiedName(uml2Class,PKGSuffix.fileUpload,ModelNameSuffix.fileUpload);
    importManager.addImport(modelFileUploadQualifiedClassName);
    	for(Iterator<Property> it=fileAndImageProperties.iterator();it.hasNext();) {// image
    		Property property=it.next();
     		String propertyCapSafeName=NameHelper.getCapName(property);
     		//String propertyUncapSafeName=NameHelper.uncapSafeName(property);
    		String propertySetAccessorName="set"+ClassHelper.getAccessorName(property);
     		String propertyComment=TypeHelper.getDocumentationOrName(property);
    stringBuffer.append(TEXT_572);
    stringBuffer.append(propertyComment);
    stringBuffer.append(TEXT_573);
    stringBuffer.append(modelFileUploadClassName);
    stringBuffer.append(TEXT_574);
    stringBuffer.append(propertyCapSafeName);
    stringBuffer.append(TEXT_575);
    stringBuffer.append(modelFileUploadClassName);
    stringBuffer.append(TEXT_576);
    stringBuffer.append(propertyCapSafeName);
    stringBuffer.append(TEXT_577);
    stringBuffer.append(propertySetAccessorName);
    stringBuffer.append(TEXT_578);
    	}
    }
    stringBuffer.append(TEXT_579);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_580);
    stringBuffer.append(saveCheckIdsSb.toString());
    stringBuffer.append(TEXT_581);
    stringBuffer.append(modelRenderUtilName);
    stringBuffer.append(TEXT_582);
    stringBuffer.append(modelClassNameForValidate);
    stringBuffer.append(TEXT_583);
    }//end isApplied saveOutjson
    stringBuffer.append(TEXT_584);
    
/*****************************************************************
 * process image and file property delete file
/*****************************************************************/
    if(null!=fileAndImageProperties&&!fileAndImageProperties.isEmpty()){
    //String modelFileUploadPackageName=MdaHelper.getPackageQualifiedName(uml2Class,PKGSuffix.fileUpload);
    String modelFileUploadClassName=MdaHelper.getModelClassName(uml2Class,ModelNameSuffix.fileUpload);
    String modelFileUploadQualifiedClassName=MdaHelper.getModelQualifiedName(uml2Class,PKGSuffix.fileUpload,ModelNameSuffix.fileUpload);
    importManager.addImport(modelFileUploadQualifiedClassName);
    	for(Iterator<Property> it=fileAndImageProperties.iterator();it.hasNext();) {// image
    		Property property=it.next();
     		String propertyCapSafeName=NameHelper.getCapName(property);
     		//String propertyUncapSafeName=NameHelper.uncapSafeName(property);
    		String propertyGetAccessorName=ClassHelper.getGetAccessor(property);
    stringBuffer.append(TEXT_585);
    		String propertySetAccessorName="set"+ClassHelper.getAccessorName(property);
     		String propertyComment=TypeHelper.getDocumentationOrName(property);
    stringBuffer.append(TEXT_586);
    stringBuffer.append(propertyComment);
    stringBuffer.append(TEXT_587);
    stringBuffer.append(propertyCapSafeName);
    stringBuffer.append(TEXT_588);
    stringBuffer.append(modelCapName);
    stringBuffer.append(TEXT_589);
    stringBuffer.append(modelUncapName);
    stringBuffer.append(TEXT_590);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_591);
    stringBuffer.append(modelUncapName);
    stringBuffer.append(TEXT_592);
    stringBuffer.append(modelUncapName);
    stringBuffer.append(TEXT_593);
    stringBuffer.append(propertyGetAccessorName);
    stringBuffer.append(TEXT_594);
    stringBuffer.append(modelFileUploadClassName);
    stringBuffer.append(TEXT_595);
    stringBuffer.append(propertyCapSafeName);
    stringBuffer.append(TEXT_596);
    stringBuffer.append(modelUncapName);
    stringBuffer.append(TEXT_597);
    stringBuffer.append(propertySetAccessorName);
    stringBuffer.append(TEXT_598);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_599);
    stringBuffer.append(modelUncapName);
    stringBuffer.append(TEXT_600);
    	}
    }
    stringBuffer.append(TEXT_601);
    	if(FunctionStereotypeUtil.isApplied_deleteOutJson(uml2Class)){
    stringBuffer.append(TEXT_602);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_603);
    	}
    stringBuffer.append(TEXT_604);
    	if(FunctionStereotypeUtil.isApplied_deleteAllOutJson(uml2Class)){//isApplied deleteAllOutJson
    stringBuffer.append(TEXT_605);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_606);
    	}//isApplied deleteAllOutJson end
    stringBuffer.append(TEXT_607);
    
if(ServiceStereotypeUtil.isApplied_expExcel(uml2Class)){//isApplied importExcelFile
//model exportFactory 
String modelExportFactoryQualifiedName=MdaHelper.getModelQualifiedName(uml2Class,PKGSuffix.exportFactory,ModelNameSuffix.exportFactory);
//String modelExportFactoryPackageName=MdaHelper.getPackageQualifiedName(uml2Class,PKGSuffix.exportFactory);
String modelExportFactoryClassName=MdaHelper.getModelClassName(uml2Class,ModelNameSuffix.exportFactory);
importManager.addImport(modelExportFactoryQualifiedName);
//model excel export file name
//String ExcelExportTemplateFileCapName=PropertyNamedRuleKind.ExcelExportTemplateFileName.getRuleCapNamed(uml2Class);
//String ExcelExportTemplateFileUncapName=PropertyNamedRuleKind.ExcelExportTemplateFileName.getRuleUnCapNamed(uml2Class);

    stringBuffer.append(TEXT_608);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_609);
    stringBuffer.append(modelExportFactoryClassName);
    stringBuffer.append(TEXT_610);
    }//isApplied importExcelFile end
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

    		importManager.addImport("java.io.File");
    		importManager.addImport("java.io.IOException");
    		importManager.addImport("java.util.List");
    stringBuffer.append(TEXT_611);
    stringBuffer.append(WebUrlName.importExcelFileProcess.getValue());
    stringBuffer.append(TEXT_612);
    stringBuffer.append(modelCapName);
    stringBuffer.append(TEXT_613);
    stringBuffer.append(modelImportFactoryClassName);
    stringBuffer.append(TEXT_614);
    importManager.addImport("com.jeefuse.base.web.result.ResultMsg");
    stringBuffer.append(TEXT_615);
    stringBuffer.append(modelCapName);
    stringBuffer.append(TEXT_616);
    stringBuffer.append(modelServiceUnCapName);
    stringBuffer.append(TEXT_617);
    stringBuffer.append(MethodNamedRuleKind.importDatas.getRuleNamed(uml2Class));
    stringBuffer.append(TEXT_618);
    	}
    stringBuffer.append(TEXT_619);
    //code kind define
    List<Property> codeKindPropertiesList=EnumKindHelper.getPropertiesAppliedEnumKind(uml2Class);
    if(null!=codeKindPropertiesList&&codeKindPropertiesList.size()>0){
    	//importManager.addImport("java.util.Map");
    	for(Property property:codeKindPropertiesList){
    		String propertyGetAccessorName=ClassHelper.getGetAccessor(property);
    stringBuffer.append(TEXT_620);
    		Enumeration enumeration=EnumKindHelper.getAppliedEnumKindEnumeration(property);
    		if(null!=enumeration){
    			String modelEnumQualifiedName=MdaHelper.getModelQualifiedName(enumeration,PKGSuffix.enumeration,ModelNameSuffix.enumeration);
    			String modelEnumName=MdaHelper.getModelClassName(enumeration,ModelNameSuffix.enumeration);
    			String modelEnumSelectHtml=NamedUtil.getPropertyNamed(enumeration,PropertyNamedRuleKind.selectHtml);
    			importManager.addImport(modelEnumQualifiedName);
    stringBuffer.append(TEXT_621);
    stringBuffer.append(modelEnumSelectHtml);
    stringBuffer.append(TEXT_622);
    stringBuffer.append(modelEnumName);
    stringBuffer.append(TEXT_623);
    stringBuffer.append(propertyGetAccessorName);
    stringBuffer.append(TEXT_624);
    			String modelEnumJsoncapName=NamedUtil.getPropertyNamed(enumeration,PropertyNamedRuleKind.elementJsonNamed);
    stringBuffer.append(TEXT_625);
    stringBuffer.append(modelEnumJsoncapName);
    stringBuffer.append(TEXT_626);
    stringBuffer.append(modelEnumName);
    stringBuffer.append(TEXT_627);
    		}
    	}
    }
    stringBuffer.append(TEXT_628);
    if(null!=pageAccessAttrList){
     for(String str:pageAccessAttrList){
    stringBuffer.append(TEXT_629);
    stringBuffer.append(NameHelper.getCapName(str));
    stringBuffer.append(TEXT_630);
    if(str.endsWith("Json")){
    stringBuffer.append(TEXT_631);
    stringBuffer.append(str);
    stringBuffer.append(TEXT_632);
    }
    stringBuffer.append(TEXT_633);
    stringBuffer.append(str);
    stringBuffer.append(TEXT_634);
    	}
    stringBuffer.append(TEXT_635);
    }
    stringBuffer.append(TEXT_636);
    importStringBuffer.insert(importInsertionPoint, importManager.computeSortedImports());
    }
    stringBuffer.append(TEXT_637);
    return stringBuffer.toString();
  }
}
