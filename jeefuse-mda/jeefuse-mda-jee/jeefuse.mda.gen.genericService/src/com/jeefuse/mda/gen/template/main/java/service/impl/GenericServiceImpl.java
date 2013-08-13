package com.jeefuse.mda.gen.template.main.java.service.impl;

import net.taylor.mda.generator.parse.NameRuled.nameRuled.*;
import net.taylor.mda.generator.parse.NameRuled.*;
import net.taylor.mda.generator.parse.NameRuled.className.*;
import net.taylor.mda.generator.parse.NameRuled.*;
import net.taylor.mda.generator.parse.stereotype.*;
import java.util.List;
import net.taylor.mda.generator.parse.page.*;
import net.taylor.mda.generator.parse.*;
import java.util.Iterator;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.*;
import net.taylor.mda.generator.util.*;
import net.taylor.mda.generator.parse.entity.*;
import org.eclipse.emf.codegen.util.*;

public class GenericServiceImpl
{
  protected static String nl;
  public static synchronized GenericServiceImpl create(String lineSeparator)
  {
    nl = lineSeparator;
    GenericServiceImpl result = new GenericServiceImpl();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "/*" + NL + " * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the \"License\")" + NL + " * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms." + NL + " * email:yonclv@gmail.com" + NL + " */" + NL + "package ";
  protected final String TEXT_2 = ";";
  protected final String TEXT_3 = NL;
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * ";
  protected final String TEXT_5 = " Entity CRUD service impl." + NL + " *" + NL + " * @author ";
  protected final String TEXT_6 = NL + " * @generated" + NL + " */" + NL + "@";
  protected final String TEXT_7 = "(value=\"";
  protected final String TEXT_8 = "\")" + NL + "public class ";
  protected final String TEXT_9 = " extends ";
  protected final String TEXT_10 = "<";
  protected final String TEXT_11 = ", ";
  protected final String TEXT_12 = "> implements ";
  protected final String TEXT_13 = "{" + NL + "\tpublic final static String SERVICE_ID = \"";
  protected final String TEXT_14 = "\";" + NL + "\t" + NL + "\t/** " + NL + "\t * ";
  protected final String TEXT_15 = " constructor with set ";
  protected final String TEXT_16 = " entity Class." + NL + "\t * @generated " + NL + "\t */" + NL + "\t@Autowired" + NL + "\tpublic ";
  protected final String TEXT_17 = "(";
  protected final String TEXT_18 = " ";
  protected final String TEXT_19 = ") {" + NL + "\t\tsuper(";
  protected final String TEXT_20 = ", ";
  protected final String TEXT_21 = ".class);" + NL + "\t}" + NL;
  protected final String TEXT_22 = "\t" + NL + "\t/**" + NL + "\t * 保存对象." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\t@Transactional" + NL + "\tpublic ";
  protected final String TEXT_23 = " save(";
  protected final String TEXT_24 = " rto) throws ValidateViolationException {" + NL + "\t\t";
  protected final String TEXT_25 = " newModel = rto.getNewModel();" + NL + "\t\thibernateDao.save(newModel);" + NL + "\t\treturn newModel;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * 更新对象." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\t@Transactional" + NL + "\tpublic ";
  protected final String TEXT_26 = " update(";
  protected final String TEXT_27 = " rto) throws ValidateViolationException {";
  protected final String TEXT_28 = NL + "\t\tAppAssert.isNotblank(rto.getId(), \"ID不能为空!\");";
  protected final String TEXT_29 = "\t\t" + NL + "\t\t//for assign id" + NL + "\t\tAppAssert.isNotblank(rto.getOldId(), \"更新ID不能为空!\");" + NL + "\t\tif(!rto.getId().equals(rto.getOldId()))" + NL + "\t\t\tthrow new InvalidDataException(\"ID不能更改!\");";
  protected final String TEXT_30 = NL + "\t\t";
  protected final String TEXT_31 = " oldModel = get(rto.getId());" + NL + "\t\tAppAssert.notNull(oldModel, \"您更新的对象不存在!\");" + NL + "\t\t";
  protected final String TEXT_32 = " newModel = rto.getModifiedModel(oldModel);" + NL + "\t\t// hibernateDao.update(newModel);//in session will auto update it." + NL + "\t\treturn newModel;" + NL + "\t}" + NL + "\t" + NL + "\t/** @generated*/" + NL + "\tpublic List<";
  protected final String TEXT_33 = "> findByProperty(";
  protected final String TEXT_34 = " ";
  protected final String TEXT_35 = ", Object value){" + NL + "\t\treturn findByProperty(";
  protected final String TEXT_36 = ".getFieldName(), value);" + NL + "\t}" + NL + "" + NL + "\t/** @generated*/" + NL + "\tpublic boolean isPropertyUnique(";
  protected final String TEXT_37 = " ";
  protected final String TEXT_38 = ", Object newValue){" + NL + "\t\tObject m = findUniqueByProperty(";
  protected final String TEXT_39 = ".getFieldName(), newValue);" + NL + "\t\treturn (m == null);" + NL + "\t}" + NL + "\t" + NL + "\t/** @generated*/" + NL + "\tpublic Page<";
  protected final String TEXT_40 = "> find(Page<";
  protected final String TEXT_41 = "> page, ";
  protected final String TEXT_42 = " rto, Order[] orders) {" + NL + "\t\tCondition condition = Condition.and();";
  protected final String TEXT_43 = NL + "\t\tif (StringUtils.isNotBlank(rto.get";
  protected final String TEXT_44 = "())) {//";
  protected final String TEXT_45 = " ";
  protected final String TEXT_46 = "\t\t";
  protected final String TEXT_47 = "\t";
  protected final String TEXT_48 = "\t" + NL + "\t\t\tDate ";
  protected final String TEXT_49 = " = DateUtil.getDayStart(DateUtil.parseDate(rto.get";
  protected final String TEXT_50 = "()));" + NL + "\t\t\tcondition.addGe(";
  protected final String TEXT_51 = ".";
  protected final String TEXT_52 = ".getFieldName(), ";
  protected final String TEXT_53 = ");" + NL + "\t\t}" + NL + "\t\tif (StringUtils.isNotBlank(rto.get";
  protected final String TEXT_54 = "())) {" + NL + "\t\t\tDate ";
  protected final String TEXT_55 = " = DateUtil.getDayEnd(DateUtil.parseDate(rto.get";
  protected final String TEXT_56 = "()));" + NL + "\t\t\tcondition.addLe(";
  protected final String TEXT_57 = ".";
  protected final String TEXT_58 = ".getFieldName(), ";
  protected final String TEXT_59 = ");" + NL + "\t\t}";
  protected final String TEXT_60 = NL + "\t\tcondition.";
  protected final String TEXT_61 = ";//";
  protected final String TEXT_62 = " ";
  protected final String TEXT_63 = NL + "\t\treturn hibernateDao.find(entityClass, page, condition, orders);";
  protected final String TEXT_64 = NL + "\t\treturn hibernateDao.find(entityClass, page, condition, orders);";
  protected final String TEXT_65 = NL + "\t}" + NL + "\t";
  protected final String TEXT_66 = NL + "\t/** @generated */" + NL + "\t@Transactional" + NL + "\tpublic ResultMsg<";
  protected final String TEXT_67 = "> ";
  protected final String TEXT_68 = "(List<";
  protected final String TEXT_69 = "> importList) throws Exception{" + NL + "\t\tResultMsg<";
  protected final String TEXT_70 = "> result = new ResultMsg<";
  protected final String TEXT_71 = ">();" + NL + "\t\tif(null==importList||importList.isEmpty()){" + NL + "\t\t\tresult.setMessage(\"无记录导入\");" + NL + "\t\t\treturn result;" + NL + "\t\t}" + NL + "\t\tList<";
  protected final String TEXT_72 = "> addList = new ArrayList<";
  protected final String TEXT_73 = ">();" + NL + "\t\tList<";
  protected final String TEXT_74 = "> updateList = new ArrayList<";
  protected final String TEXT_75 = ">();" + NL + "\t\tfor (";
  protected final String TEXT_76 = " ";
  protected final String TEXT_77 = " : importList) {" + NL + "\t\t\tif (StringUtils.isBlank(";
  protected final String TEXT_78 = ".getId())) {" + NL + "\t\t\t\t";
  protected final String TEXT_79 = " .setId(null);" + NL + "\t\t\t\taddList.add(";
  protected final String TEXT_80 = " );" + NL + "\t\t\t} else {" + NL + "\t\t\t\t";
  protected final String TEXT_81 = " oldModel = get(";
  protected final String TEXT_82 = ".getId());" + NL + "\t\t\t\tif (null == oldModel) {" + NL + "\t\t\t\t\taddList.add(";
  protected final String TEXT_83 = ");" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tPropertyUtils.copyProperties(oldModel, ";
  protected final String TEXT_84 = ");" + NL + "\t\t\t\t\tupdateList.add(oldModel);" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tStringBuilder msgSb = new StringBuilder(\"\");" + NL + "\t\tint addCount = 0;" + NL + "\t\tif (!addList.isEmpty()) {" + NL + "\t\t\thibernateDao.save(addList);" + NL + "\t\t\taddCount = addList.size();" + NL + "\t\t}" + NL + "\t\tint updateCount = 0;" + NL + "\t\tif (!updateList.isEmpty()) {" + NL + "\t\t\thibernateDao.update(updateList);" + NL + "\t\t\tupdateCount = updateList.size();" + NL + "\t\t}" + NL + "\t\tmsgSb.append(\"共成功导入\" + (addCount+updateCount) + \"项记录!\");" + NL + "\t\tif(addCount!=0){" + NL + "\t\t\tmsgSb.append(\" 新增:\"+addCount+\"项.\");" + NL + "\t\t}" + NL + "\t\tif(updateCount!=0){" + NL + "\t\t\tmsgSb.append(\" 更新:\"+updateCount+\"项.\");" + NL + "\t\t}" + NL + "\t\tresult.setMessage(msgSb.toString());" + NL + "\t\treturn result;" + NL + "\t}";
  protected final String TEXT_85 = "\t";
  protected final String TEXT_86 = "\t\t\t";
  protected final String TEXT_87 = "\t";
  protected final String TEXT_88 = "\t\t" + NL + "" + NL + "\t/**" + NL + "\t * 获取所有";
  protected final String TEXT_89 = "对象用于构造keyLabel,只获取key,label属性." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic List<KeyLabel> getAllForKeyLabel(){" + NL + "\t\tfinal String hql = \"select new ";
  protected final String TEXT_90 = "(m.";
  protected final String TEXT_91 = ",m.";
  protected final String TEXT_92 = ") from ";
  protected final String TEXT_93 = " m\";" + NL + "\t\treturn hibernateDao.createQuery(hql).list();" + NL + "\t}";
  protected final String TEXT_94 = NL + NL + "\t@SuppressWarnings(\"unchecked\")" + NL + "\tpublic List<";
  protected final String TEXT_95 = "> getGallaryList(Order[] orders) {" + NL + "\t\tfinal String hql = \"select new ";
  protected final String TEXT_96 = "(";
  protected final String TEXT_97 = ") from ";
  protected final String TEXT_98 = " m\";" + NL + "\t\tStringBuilder hqlsb = new StringBuilder(hql);" + NL + "\t\tif (null != orders) {" + NL + "\t\t\thqlsb.append(\" order by \");" + NL + "\t\t\tint loop = orders.length;" + NL + "\t\t\tfor (int i = 0; i < loop; i++) {" + NL + "\t\t\t\tif(i==0){" + NL + "\t\t\t\t\thqlsb.append(\",\");" + NL + "\t\t\t\t}" + NL + "\t\t\t\thqlsb.append(orders[i].toSql());" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn hibernateDao.createQuery(hqlsb.toString()).list();" + NL + "\t}";
  protected final String TEXT_99 = "\t";
  protected final String TEXT_100 = "\t";
  protected final String TEXT_101 = "\t";
  protected final String TEXT_102 = NL + NL + "\t/*****************************************************************" + NL + "\t * manage by ";
  protected final String TEXT_103 = NL + "\t *****************************************************************/" + NL + "" + NL + "\t/**" + NL + "\t * 查询\"";
  protected final String TEXT_104 = "(";
  protected final String TEXT_105 = ")\"关联的\"";
  protected final String TEXT_106 = "(";
  protected final String TEXT_107 = ")\"." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Page<";
  protected final String TEXT_108 = "> findBy";
  protected final String TEXT_109 = "(String ";
  protected final String TEXT_110 = ",Page<";
  protected final String TEXT_111 = "> page, ";
  protected final String TEXT_112 = " rto, Order[] orders) {";
  protected final String TEXT_113 = NL + "\t\tAppAssert.notNull(";
  protected final String TEXT_114 = ", \"未指定";
  protected final String TEXT_115 = "!\");" + NL + "\t\tCondition condition = Condition.and();" + NL + "\t\tcondition.addEq(\"";
  protected final String TEXT_116 = "\", ";
  protected final String TEXT_117 = ");";
  protected final String TEXT_118 = NL + "\t\tif (StringUtils.isNotBlank(rto.get";
  protected final String TEXT_119 = "())) {//";
  protected final String TEXT_120 = " ";
  protected final String TEXT_121 = "\t\t";
  protected final String TEXT_122 = "\t";
  protected final String TEXT_123 = "\t" + NL + "\t\t\tDate ";
  protected final String TEXT_124 = " = DateUtil.getDayStart(DateUtil.parseDate(rto.get";
  protected final String TEXT_125 = "()));" + NL + "\t\t\tcondition.addGe(";
  protected final String TEXT_126 = ".";
  protected final String TEXT_127 = ".getFieldName(), ";
  protected final String TEXT_128 = ");" + NL + "\t\t}" + NL + "\t\tif (StringUtils.isNotBlank(rto.get";
  protected final String TEXT_129 = "())) {" + NL + "\t\t\tDate ";
  protected final String TEXT_130 = " = DateUtil.getDayEnd(DateUtil.parseDate(rto.get";
  protected final String TEXT_131 = "()));" + NL + "\t\t\tcondition.addLe(";
  protected final String TEXT_132 = ".";
  protected final String TEXT_133 = ".getFieldName(), ";
  protected final String TEXT_134 = ");" + NL + "\t\t}";
  protected final String TEXT_135 = NL + "\t\tcondition.";
  protected final String TEXT_136 = ";//";
  protected final String TEXT_137 = " ";
  protected final String TEXT_138 = NL + "\t\treturn hibernateDao.find(entityClass, page, condition, orders);";
  protected final String TEXT_139 = NL + "\t\treturn hibernateDao.find(entityClass, page, condition, orders);";
  protected final String TEXT_140 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * 查询\"";
  protected final String TEXT_141 = "(";
  protected final String TEXT_142 = ")\"关联的\"";
  protected final String TEXT_143 = "(";
  protected final String TEXT_144 = ")\"." + NL + "\t * " + NL + "\t */" + NL + "\tpublic List<";
  protected final String TEXT_145 = "> findBy";
  protected final String TEXT_146 = "(String ";
  protected final String TEXT_147 = ") {" + NL + "\t\tAppAssert.notNull(";
  protected final String TEXT_148 = ", \"未指定";
  protected final String TEXT_149 = "!\");" + NL + "\t\tCondition condition = Condition.and();" + NL + "\t\tcondition.addEq(\"";
  protected final String TEXT_150 = "\", ";
  protected final String TEXT_151 = ");" + NL + "\t\treturn hibernateDao.find(entityClass, condition);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * 保存\"";
  protected final String TEXT_152 = "(";
  protected final String TEXT_153 = ")\"关联的\"";
  protected final String TEXT_154 = "(";
  protected final String TEXT_155 = ")\"." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\t@Transactional" + NL + "\tpublic ";
  protected final String TEXT_156 = " saveBy";
  protected final String TEXT_157 = "(String ";
  protected final String TEXT_158 = ",";
  protected final String TEXT_159 = " rto) {" + NL + "\t\tAppAssert.notNull(";
  protected final String TEXT_160 = ", \"未指定";
  protected final String TEXT_161 = "!\");" + NL + "\t\t";
  protected final String TEXT_162 = " newModel=rto.getNewModel();" + NL + "\t\tnewModel.";
  protected final String TEXT_163 = "(";
  protected final String TEXT_164 = ");" + NL + "\t\thibernateDao.save(newModel);" + NL + "\t\treturn newModel;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * 更新\"";
  protected final String TEXT_165 = "(";
  protected final String TEXT_166 = ")\"关联的\"";
  protected final String TEXT_167 = "(";
  protected final String TEXT_168 = ")\"." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\t@Transactional" + NL + "\tpublic ";
  protected final String TEXT_169 = " updateBy";
  protected final String TEXT_170 = "(String ";
  protected final String TEXT_171 = ",";
  protected final String TEXT_172 = " rto) {" + NL + "\t\tAppAssert.notNull(";
  protected final String TEXT_173 = ", \"未指定";
  protected final String TEXT_174 = "!\");" + NL + "\t\t";
  protected final String TEXT_175 = " old";
  protected final String TEXT_176 = " = get(rto.getId());" + NL + "\t\tAppAssert.notNull(old";
  protected final String TEXT_177 = ", \"您更新的记录不存在!\");" + NL + "\t\t";
  protected final String TEXT_178 = " newModel = rto.getModifiedModel(old";
  protected final String TEXT_179 = ");" + NL + "\t\tnewModel.";
  protected final String TEXT_180 = "(";
  protected final String TEXT_181 = ");" + NL + "\t\t// hibernateDao.save(";
  protected final String TEXT_182 = ");//in session will auto update" + NL + "\t\treturn newModel;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * 删除所有\"";
  protected final String TEXT_183 = "(";
  protected final String TEXT_184 = ")\"关联的\"";
  protected final String TEXT_185 = "(";
  protected final String TEXT_186 = ")\"." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\t@Transactional" + NL + "\tpublic int deleteAllBy";
  protected final String TEXT_187 = "(String ";
  protected final String TEXT_188 = ") {" + NL + "\t\tAppAssert.notNull(";
  protected final String TEXT_189 = ", \"未指定";
  protected final String TEXT_190 = "!\");" + NL + "\t\tfinal String hql = \"delete from \" + entityClass.getName() + \" m where m.";
  protected final String TEXT_191 = "=?\";" + NL + "\t\treturn hibernateDao.executeUpdate(hql, ";
  protected final String TEXT_192 = ");" + NL + "\t}" + NL + "\t" + NL + "\t";
  protected final String TEXT_193 = "\t\t\t";
  protected final String TEXT_194 = "\t";
  protected final String TEXT_195 = "\t\t" + NL + "\t/**" + NL + "\t * 根据";
  protected final String TEXT_196 = "获取所有";
  protected final String TEXT_197 = "对象用于构造keyLabel,只获取key,label属性." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic List<KeyLabel> getAllForKeyLabelBy";
  protected final String TEXT_198 = "(String ";
  protected final String TEXT_199 = "){" + NL + "\t\tAppAssert.notNull(";
  protected final String TEXT_200 = ", \"未指定";
  protected final String TEXT_201 = "!\");" + NL + "\t\tfinal String hql = \"select new ";
  protected final String TEXT_202 = "(m.";
  protected final String TEXT_203 = ",m.";
  protected final String TEXT_204 = ") from ";
  protected final String TEXT_205 = " m where m.";
  protected final String TEXT_206 = "=?\";" + NL + "\t\treturn hibernateDao.find(hql,";
  protected final String TEXT_207 = ");" + NL + "\t}";
  protected final String TEXT_208 = "\t" + NL + "" + NL + "}";
  protected final String TEXT_209 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    Class uml2Class = (Class) argument;Package uml2Package = uml2Class.getPackage();
    
UmlClassWrap clazzWrap=new UmlClassWrap(uml2Class);
String modelCommentName=clazzWrap.getCommentName();

//generic service impl
ClassNameDefineCommon serviceGenericImplDefine=clazzWrap.getNameDefineServiceGenericImpl();
String serviceGenericImplClassName=serviceGenericImplDefine.getClassCapName();
String serviceGenericImplUncapClassName=serviceGenericImplDefine.getClassUncapName();
String serviceGenericImplPackageName=serviceGenericImplDefine.getPackageQualifiedName();


    stringBuffer.append(TEXT_1);
    stringBuffer.append(serviceGenericImplPackageName);
    stringBuffer.append(TEXT_2);
    ImportManager importManager = ImportHelper.makeImportManager("");
    
// add imports
importManager.addImport("java.util.List");
importManager.addImport("org.springframework.beans.factory.annotation.Autowired");
importManager.addImport("com.jeefuse.base.modules.condition.order.Order");
importManager.addImport("com.jeefuse.base.utils.page.Page");
importManager.addImport("com.jeefuse.base.modules.condition.criteria.Condition");
//importManager.addImport("org.springframework.util.Assert");
importManager.addImport(Config.base_ServiceGenericImplQualifiedName);
String baseServiceGenericImplClassName=MdaHelper.getBriefClassName(Config.base_ServiceGenericImplQualifiedName);

//base
String baseHibernateDaoName=ImportHelper.getImportedName(Config.base_HibernateDao);
String baseHibernateDaoUncapName=NameHelper.uncapName(baseHibernateDaoName);

//model RTO define
ClassNameDefineCommon rtoDefine=clazzWrap.getNameDefineRTO();
String modelRTOQualifiedName=rtoDefine.getClassQualifiedName();
String modelRTOName=rtoDefine.getClassCapName();
importManager.addImport(modelRTOQualifiedName);

//model entity define
ClassNameDefineCommon entityDefine=clazzWrap.getNameDefineEntity();
String modelEntityQualifiedName=entityDefine.getClassQualifiedName();
String modelEntityName=entityDefine.getClassCapName();
String modelEntityUncapName=entityDefine.getClassUncapName();
importManager.addImport(modelEntityQualifiedName);

//model field 
ClassNameDefineCommon entityFieldDefine=clazzWrap.getNameDefineEntityField();
String modelFieldQualifiedName=entityFieldDefine.getClassQualifiedName();
String modelFieldName=entityFieldDefine.getClassName();
String modelFieldUncapName=entityFieldDefine.getClassUncapName();
importManager.addImport(modelFieldQualifiedName);

// generic service
ClassNameDefineCommon serviceGenericDefine=clazzWrap.getNameDefineServiceGeneric();
String modelServiceGenericQualifiedName=serviceGenericDefine.getClassQualifiedName();
String modelServiceGenericClassName=serviceGenericDefine.getClassCapName();
importManager.addImport(modelServiceGenericQualifiedName);

    stringBuffer.append(TEXT_3);
    
StringBuffer importStringBuffer = stringBuffer;
int importInsertionPoint = stringBuffer.length();
importManager.addCompilationUnitImports(stringBuffer.toString());

    stringBuffer.append(TEXT_4);
    stringBuffer.append(modelCommentName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(System.getProperty("user.name"));
    stringBuffer.append(TEXT_6);
    stringBuffer.append(ImportHelper.getImportedName("org.springframework.stereotype.Service"));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(serviceGenericImplUncapClassName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(serviceGenericImplClassName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(baseServiceGenericImplClassName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(EntityHelper.getIDPropertyImportType(uml2Class));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(modelServiceGenericClassName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(serviceGenericImplUncapClassName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(serviceGenericImplClassName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(serviceGenericImplClassName);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(baseHibernateDaoName);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(baseHibernateDaoUncapName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(baseHibernateDaoUncapName);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_21);
    importManager.addImport("com.jeefuse.base.exception.ValidateViolationException");
    importManager.addImport("org.springframework.transaction.annotation.Transactional");
    stringBuffer.append(TEXT_22);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(modelRTOName);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(modelRTOName);
    stringBuffer.append(TEXT_27);
    importManager.addImport("com.jeefuse.base.exception.AppAssert");
    stringBuffer.append(TEXT_28);
    /*if(EntityHelper.hasIdAssign(uml2Class)){
    stringBuffer.append(TEXT_29);
    }*/
    stringBuffer.append(TEXT_30);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(modelFieldName);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(modelFieldUncapName);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(modelFieldUncapName);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(modelFieldName);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(modelFieldUncapName);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(modelFieldUncapName);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(modelRTOName);
    stringBuffer.append(TEXT_42);
    List<Property> searchList=ViewSearchHelper.getSearchTextFieldPropertiesFromSimple(uml2Class);
    if(null!=searchList&&searchList.size()>0){
    	int countNum=1;
    	for(Property property:searchList){
    		String propertyUncapSafeName=NameHelper.uncapSafeName(property);
    		String propertyCommentName=TypeHelper.getDocumentationOrName(property);
    /********process date property********/
    		if(TypeHelper.isDate(property)&&ViewSearchHelper.isBetweenOperator(property)){
    			//String operatorStr=ViewSearchHelper.getSearchOperator(property);
    			String searchFieldName=ViewSearchHelper.getSearchFieldName(property);
    			String searchFieldCapName=NameHelper.getCapName(searchFieldName);
    			String searchFieldTwoName=ViewSearchHelper.getSearchFieldTwoName(property);
    			String searchFieldTwoCapName=NameHelper.getCapName(searchFieldTwoName);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(searchFieldCapName);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(countNum++);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(propertyCommentName);
    		importManager.addImport("java.util.Date");
    stringBuffer.append(TEXT_46);
    		importManager.addImport("com.jeefuse.base.utils.common.DateUtil");
    stringBuffer.append(TEXT_47);
    		importManager.addImport("org.apache.commons.lang.xwork.StringUtils");
    stringBuffer.append(TEXT_48);
    stringBuffer.append(searchFieldName);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(searchFieldCapName);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(modelFieldName);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(searchFieldName);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(searchFieldTwoCapName);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(searchFieldTwoName);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(searchFieldTwoCapName);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(modelFieldName);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(searchFieldTwoName);
    stringBuffer.append(TEXT_59);
    		}
    /********process common property********/
    		else{
    stringBuffer.append(TEXT_60);
    stringBuffer.append(ViewSearchHelper.getSearchFieldRtoCondition(property, modelFieldName, "rto"));
    stringBuffer.append(TEXT_61);
    stringBuffer.append(countNum++);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(propertyCommentName);
    		}
     	}
    stringBuffer.append(TEXT_63);
    }else{
    stringBuffer.append(TEXT_64);
    }
    stringBuffer.append(TEXT_65);
    importManager.addImport("com.jeefuse.base.web.result.ResultMsg");
    importManager.addImport("java.lang.StringBuilder");
    importManager.addImport("java.util.ArrayList");
    importManager.addImport("org.apache.commons.lang.xwork.StringUtils");
    importManager.addImport("org.apache.commons.beanutils.PropertyUtils");
    stringBuffer.append(TEXT_66);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(MethodNamedRuleKind.importDatas.getRuleNamed(uml2Class));
    stringBuffer.append(TEXT_68);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(modelEntityUncapName);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(modelEntityUncapName);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(modelEntityUncapName);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(modelEntityUncapName);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(modelEntityUncapName);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(modelEntityUncapName);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(modelEntityUncapName);
    stringBuffer.append(TEXT_84);
    
/*****************************************************************
 * apply keyLabel start
/*****************************************************************/

    stringBuffer.append(TEXT_85);
    	if(KeyLabelStereotypeHelper.isApply(uml2Class)){
    		importManager.addImport("com.jeefuse.base.modules.keyLabel.KeyLabel");
    		Property listKeyProperty=KeyLabelStereotypeHelper.getProperty_liskKey(uml2Class);
    stringBuffer.append(TEXT_86);
    		String listKeyPropertyName=NameHelper.uncapSafeName(listKeyProperty);
    		Property listLabelProperty=KeyLabelStereotypeHelper.getProperty_listLabel(uml2Class);
    stringBuffer.append(TEXT_87);
    		String listLabelPropertyName=NameHelper.uncapSafeName(listLabelProperty);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(modelCommentName);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(listKeyPropertyName);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(listLabelPropertyName);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_93);
    	}
    
/*****************************************************************
 * apply keyLabel end
/*****************************************************************/

    
/*****************************************************************
 * 构造gallary start
/*****************************************************************/

    if(FileStereotypeHelper.isClass_Image(uml2Class)){
    	//Property propertyFileSavePath=FileStereotypeHelper.getPropertyApplyFileSavePath(uml2Class);
    	//Property propertyTitle=PropertyStereotypeHelper.getPropertyApplyTitle(uml2Class);
    	//Property propertyIntro=PropertyStereotypeHelper.getPropertyApplyIntro(uml2Class);
    	//Property propertyContent=PropertyStereotypeHelper.getPropertyApplyContent(uml2Class);
    	String gallaryListContructArgs=FileStereotypeHelper.getGallaryListContructArgsForHql(uml2Class);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(gallaryListContructArgs);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_98);
    	}
    stringBuffer.append(TEXT_99);
    
/*****************************************************************
 * 构造gallary end
/*****************************************************************/

    stringBuffer.append(TEXT_100);
    /********process M2OPropertyList start********/
    stringBuffer.append(TEXT_101);
    List<Property> M2OPropertyList=EntityHelper.getAllManyToOnePropertiesAndApplyManageByProperty(uml2Class,false);
    for (Iterator<Property> iter=M2OPropertyList.iterator();iter.hasNext();){
    		Property property=iter.next();
     		//String propertyComment=TypeHelper.getDocumentationOrName(property);
    		//String propertyGet=ClassHelper.getGetAccessor(property);
     		String propertyUncapName=NameHelper.uncapSafeName(property);
     		String propertyName=NameHelper.getCapName(property);
    		UmlClassByPropertyWrap named=new UmlClassByPropertyWrap(property);
    		String byPropertyValue=named.getValueName();
    		String byPropertyValueCamelName=named.getValueNameWithUnderLine();
    		//String byPropertyValueGetAccessor=named.getValueGetAccessor();
    stringBuffer.append(TEXT_102);
    stringBuffer.append(named.getComment());
    stringBuffer.append(TEXT_103);
    stringBuffer.append(named.getComment());
    stringBuffer.append(TEXT_104);
    stringBuffer.append(propertyUncapName);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(modelCommentName);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(propertyName);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(byPropertyValueCamelName);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(modelRTOName);
    stringBuffer.append(TEXT_112);
    		importManager.addImport("com.jeefuse.base.exception.AppAssert");
    stringBuffer.append(TEXT_113);
    stringBuffer.append(byPropertyValueCamelName);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(named.getComment());
    stringBuffer.append(TEXT_115);
    stringBuffer.append(byPropertyValue);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(byPropertyValueCamelName);
    stringBuffer.append(TEXT_117);
    List<Property> O2MSearchList=ViewSearchHelper.getSearchTextFieldPropertiesFromSimple(uml2Class);
    if(null!=O2MSearchList&&O2MSearchList.size()>0){
    	int countNum=1;
    	for(Property searchProperty:O2MSearchList){
    		if(property.getName().equals(searchProperty.getName()))continue;
    		String propertyUncapSafeName=NameHelper.uncapSafeName(searchProperty);
    		String propertyCommentName=TypeHelper.getDocumentationOrName(searchProperty);
    /********process date property********/
    		if(TypeHelper.isDate(searchProperty)&&ViewSearchHelper.isBetweenOperator(searchProperty)){
    			//String operatorStr=ViewSearchHelper.getSearchOperator(searchProperty);
    			String searchFieldName=ViewSearchHelper.getSearchFieldName(searchProperty);
    			String searchFieldCapName=NameHelper.getCapName(searchFieldName);
    			String searchFieldTwoName=ViewSearchHelper.getSearchFieldTwoName(searchProperty);
    			String searchFieldTwoCapName=NameHelper.getCapName(searchFieldTwoName);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(searchFieldCapName);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(countNum++);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(propertyCommentName);
    		importManager.addImport("java.util.Date");
    stringBuffer.append(TEXT_121);
    		importManager.addImport("com.jeefuse.base.utils.common.DateUtil");
    stringBuffer.append(TEXT_122);
    		importManager.addImport("org.apache.commons.lang.xwork.StringUtils");
    stringBuffer.append(TEXT_123);
    stringBuffer.append(searchFieldName);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(searchFieldCapName);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(modelFieldName);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(searchFieldName);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(searchFieldTwoCapName);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(searchFieldTwoName);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(searchFieldTwoCapName);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(modelFieldName);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(searchFieldTwoName);
    stringBuffer.append(TEXT_134);
    		}
    /********process common property********/
    		else{
    stringBuffer.append(TEXT_135);
    stringBuffer.append(ViewSearchHelper.getSearchFieldRtoCondition(searchProperty, modelFieldName, "rto"));
    stringBuffer.append(TEXT_136);
    stringBuffer.append(countNum++);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(propertyCommentName);
    		}
     }
    stringBuffer.append(TEXT_138);
    }else{
    stringBuffer.append(TEXT_139);
    }
    stringBuffer.append(TEXT_140);
    stringBuffer.append(named.getComment());
    stringBuffer.append(TEXT_141);
    stringBuffer.append(propertyUncapName);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(modelCommentName);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(propertyName);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(byPropertyValueCamelName);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(byPropertyValueCamelName);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(named.getComment());
    stringBuffer.append(TEXT_149);
    stringBuffer.append(byPropertyValue);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(byPropertyValueCamelName);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(named.getComment());
    stringBuffer.append(TEXT_152);
    stringBuffer.append(propertyUncapName);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(modelCommentName);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(propertyName);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(byPropertyValueCamelName);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(modelRTOName);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(byPropertyValueCamelName);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(named.getComment());
    stringBuffer.append(TEXT_161);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(named.getSetValueMethod());
    stringBuffer.append(TEXT_163);
    stringBuffer.append(byPropertyValueCamelName);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(named.getComment());
    stringBuffer.append(TEXT_165);
    stringBuffer.append(propertyUncapName);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(modelCommentName);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(propertyName);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(byPropertyValueCamelName);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(modelRTOName);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(byPropertyValueCamelName);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(named.getComment());
    stringBuffer.append(TEXT_174);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(named.getSetValueMethod());
    stringBuffer.append(TEXT_180);
    stringBuffer.append(byPropertyValueCamelName);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(modelEntityUncapName);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(named.getComment());
    stringBuffer.append(TEXT_183);
    stringBuffer.append(propertyUncapName);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(modelCommentName);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(propertyName);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(byPropertyValueCamelName);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(byPropertyValueCamelName);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(named.getComment());
    stringBuffer.append(TEXT_190);
    stringBuffer.append(byPropertyValue);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(byPropertyValueCamelName);
    stringBuffer.append(TEXT_192);
    	if(KeyLabelStereotypeHelper.isApply(uml2Class)){
    		importManager.addImport("com.jeefuse.base.modules.keyLabel.KeyLabel");
    		Property listKeyProperty=KeyLabelStereotypeHelper.getProperty_liskKey(uml2Class);
    stringBuffer.append(TEXT_193);
    		String listKeyPropertyName=NameHelper.uncapSafeName(listKeyProperty);
    		Property listLabelProperty=KeyLabelStereotypeHelper.getProperty_listLabel(uml2Class);
    stringBuffer.append(TEXT_194);
    		String listLabelPropertyName=NameHelper.uncapSafeName(listLabelProperty);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(propertyName);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(modelCommentName);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(propertyName);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(byPropertyValueCamelName);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(byPropertyValueCamelName);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(named.getComment());
    stringBuffer.append(TEXT_201);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(listKeyPropertyName);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(listLabelPropertyName);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(byPropertyValue);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(byPropertyValueCamelName);
    stringBuffer.append(TEXT_207);
    	}
    }
    /********process M2OPropertyList end********/
    stringBuffer.append(TEXT_208);
    importStringBuffer.insert(importInsertionPoint, importManager.computeSortedImports());
    stringBuffer.append(TEXT_209);
    return stringBuffer.toString();
  }
}
