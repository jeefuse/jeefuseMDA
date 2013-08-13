package com.jeefuse.mda.gen.template.main.java.service;

import net.taylor.mda.generator.parse.NameRuled.nameRuled.*;
import net.taylor.mda.generator.parse.NameRuled.className.*;
import net.taylor.mda.generator.parse.NameRuled.*;
import java.util.List;
import net.taylor.mda.generator.parse.stereotype.*;
import net.taylor.mda.generator.parse.*;
import java.util.Iterator;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.*;
import net.taylor.mda.generator.util.*;
import net.taylor.mda.generator.parse.entity.*;
import org.eclipse.emf.codegen.util.*;

public class GenericService
{
  protected static String nl;
  public static synchronized GenericService create(String lineSeparator)
  {
    nl = lineSeparator;
    GenericService result = new GenericService();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "/*" + NL + " * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the \"License\")" + NL + " * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms." + NL + " * email:yonclv@gmail.com" + NL + " */" + NL + "package ";
  protected final String TEXT_2 = ";";
  protected final String TEXT_3 = NL + NL + "/**" + NL + " * ";
  protected final String TEXT_4 = " Entity CRUD service." + NL + " *" + NL + " * @author ";
  protected final String TEXT_5 = NL + " * @generated" + NL + " */" + NL + "public interface ";
  protected final String TEXT_6 = " extends ";
  protected final String TEXT_7 = "<";
  protected final String TEXT_8 = ", ";
  protected final String TEXT_9 = "> {" + NL;
  protected final String TEXT_10 = NL + "\t/**" + NL + "\t * 验证并保存对象." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_11 = " save(";
  protected final String TEXT_12 = " rto) throws ValidateViolationException;" + NL + "" + NL + "\t/**" + NL + "\t * 验证并更新对象." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_13 = " update(";
  protected final String TEXT_14 = " rto) throws ValidateViolationException ;" + NL + "\t" + NL + "\t/**" + NL + "\t * 根据属性值查找对象." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic List<";
  protected final String TEXT_15 = "> findByProperty(";
  protected final String TEXT_16 = " ";
  protected final String TEXT_17 = ", Object value);" + NL + "" + NL + "\t/**" + NL + "\t * 判断属性的值是否唯一." + NL + "\t *" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic boolean isPropertyUnique(";
  protected final String TEXT_18 = " ";
  protected final String TEXT_19 = ", Object newValue);" + NL + "\t" + NL + "\t/**" + NL + "\t * 根据请求参数查询." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Page<";
  protected final String TEXT_20 = "> find(Page<";
  protected final String TEXT_21 = "> page, ";
  protected final String TEXT_22 = " rto, Order[] orders);" + NL;
  protected final String TEXT_23 = "\t" + NL + "\t/**" + NL + "\t * 导入数据." + NL + "\t * " + NL + " \t * @generated" + NL + "\t */" + NL + "\tpublic ResultMsg<";
  protected final String TEXT_24 = "> ";
  protected final String TEXT_25 = "(List<";
  protected final String TEXT_26 = "> importList)throws Exception;" + NL;
  protected final String TEXT_27 = "\t";
  protected final String TEXT_28 = NL + "\t/**" + NL + "\t * 获取所有";
  protected final String TEXT_29 = "对象用于构造keyLabel,只获取key,label属性." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic List<KeyLabel> getAllForKeyLabel();";
  protected final String TEXT_30 = NL + NL + "\t/*****************************************************************" + NL + "\t * manage by ";
  protected final String TEXT_31 = "(";
  protected final String TEXT_32 = ")" + NL + "\t *****************************************************************/" + NL + "" + NL + "\t/**" + NL + "\t * 查询\"";
  protected final String TEXT_33 = "(";
  protected final String TEXT_34 = ")\"关联的\"";
  protected final String TEXT_35 = "(";
  protected final String TEXT_36 = ")\"." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Page<";
  protected final String TEXT_37 = "> findBy";
  protected final String TEXT_38 = "(String ";
  protected final String TEXT_39 = ",Page<";
  protected final String TEXT_40 = "> page, ";
  protected final String TEXT_41 = " rto, Order[] orders);" + NL + "" + NL + "\t/**" + NL + "\t * 查询\"";
  protected final String TEXT_42 = "(";
  protected final String TEXT_43 = ")\"关联的\"";
  protected final String TEXT_44 = "(";
  protected final String TEXT_45 = ")\"." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic List<";
  protected final String TEXT_46 = "> findBy";
  protected final String TEXT_47 = "(String ";
  protected final String TEXT_48 = ");" + NL + "\t" + NL + "\t/**" + NL + "\t * 保存\"";
  protected final String TEXT_49 = "(";
  protected final String TEXT_50 = ")\"关联的\"";
  protected final String TEXT_51 = "(";
  protected final String TEXT_52 = ")\"." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_53 = " saveBy";
  protected final String TEXT_54 = "(String ";
  protected final String TEXT_55 = ",";
  protected final String TEXT_56 = " rto);" + NL + "" + NL + "\t/**" + NL + "\t * 更新\"";
  protected final String TEXT_57 = "(";
  protected final String TEXT_58 = ")\"关联的\"";
  protected final String TEXT_59 = "(";
  protected final String TEXT_60 = ")\"." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_61 = " updateBy";
  protected final String TEXT_62 = "(String ";
  protected final String TEXT_63 = ",";
  protected final String TEXT_64 = " rto);" + NL + "" + NL + "\t/**" + NL + "\t * 删除所有\"";
  protected final String TEXT_65 = "(";
  protected final String TEXT_66 = ")\"关联的\"";
  protected final String TEXT_67 = "(";
  protected final String TEXT_68 = ")\"." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic int deleteAllBy";
  protected final String TEXT_69 = "(String ";
  protected final String TEXT_70 = ");" + NL + "\t" + NL + "\t";
  protected final String TEXT_71 = "\t";
  protected final String TEXT_72 = NL + "\t/**" + NL + "\t * 根据";
  protected final String TEXT_73 = "获取所有";
  protected final String TEXT_74 = "对象用于构造keyLabel,只获取key,label属性." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic List<KeyLabel> getAllForKeyLabelBy";
  protected final String TEXT_75 = "();";
  protected final String TEXT_76 = NL + NL + "}";
  protected final String TEXT_77 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    Class uml2Class = (Class) argument;Package uml2Package = uml2Class.getPackage();
    
UmlClassWrap clazzWrap=new UmlClassWrap(uml2Class);
String modelCommentName=clazzWrap.getCommentName();
//generic service
ClassNameDefineCommon serviceGenericDefine=clazzWrap.getNameDefineServiceGeneric();
String modelServiceGenericPackageName=serviceGenericDefine.getPackageQualifiedName();
String modelServiceGenericClassName=serviceGenericDefine.getClassCapName();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(modelServiceGenericPackageName);
    stringBuffer.append(TEXT_2);
    ImportManager importManager = ImportHelper.makeImportManager("");
    
// add imports
importManager.addImport("java.util.List");
importManager.addImport("com.jeefuse.base.modules.condition.order.Order");
importManager.addImport("com.jeefuse.base.utils.page.Page");
String baseServiceGenericClassName=MdaHelper.getBriefClassName(Config.base_ServiceGenericQualifiedName);
importManager.addImport(Config.base_ServiceGenericQualifiedName);

//model entity define
ClassNameDefineCommon entityDefine=clazzWrap.getNameDefineEntity();
String modelEntityQualifiedName=entityDefine.getClassQualifiedName();
String modelEntityName=entityDefine.getClassCapName();
importManager.addImport(modelEntityQualifiedName);

//model field 
ClassNameDefineCommon entityFieldDefine=clazzWrap.getNameDefineEntityField();
String modelFieldQualifiedName=entityFieldDefine.getClassQualifiedName();
String modelFieldName=entityFieldDefine.getClassName();
String modelFieldUncapName=entityFieldDefine.getClassUncapName();
importManager.addImport(modelFieldQualifiedName);

//model RTO define
ClassNameDefineCommon rtoDefine=clazzWrap.getNameDefineRTO();
String modelRTOQualifiedName=rtoDefine.getClassQualifiedName();
String modelRTOName=rtoDefine.getClassCapName();
importManager.addImport(modelRTOQualifiedName);

    
StringBuffer importStringBuffer = stringBuffer;
int importInsertionPoint = stringBuffer.length();
importManager.addCompilationUnitImports(stringBuffer.toString());

    stringBuffer.append(TEXT_3);
    stringBuffer.append(modelCommentName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(System.getProperty("user.name"));
    stringBuffer.append(TEXT_5);
    stringBuffer.append(modelServiceGenericClassName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(baseServiceGenericClassName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(EntityHelper.getIDPropertyImportType(uml2Class));
    stringBuffer.append(TEXT_9);
    importManager.addImport("com.jeefuse.base.exception.ValidateViolationException");
    stringBuffer.append(TEXT_10);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(modelRTOName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(modelRTOName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(modelFieldName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(modelFieldUncapName);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(modelFieldName);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(modelFieldUncapName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(modelRTOName);
    stringBuffer.append(TEXT_22);
    importManager.addImport("com.jeefuse.base.web.result.ResultMsg");
    stringBuffer.append(TEXT_23);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(MethodNamedRuleKind.importDatas.getRuleNamed(uml2Class));
    stringBuffer.append(TEXT_25);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_26);
    /********process keyLabel********/
    stringBuffer.append(TEXT_27);
    	if(KeyLabelStereotypeHelper.isApply(uml2Class)){
    		importManager.addImport("com.jeefuse.base.modules.keyLabel.KeyLabel");
    stringBuffer.append(TEXT_28);
    stringBuffer.append(modelCommentName);
    stringBuffer.append(TEXT_29);
    	}
    /********process M2OProperty start********/
    List<Property> M2OPropertyList=EntityHelper.getAllManyToOnePropertiesAndApplyManageByProperty(uml2Class,false);
    for (Iterator<Property> iter=M2OPropertyList.iterator();iter.hasNext();){
    		Property property=iter.next();
    		UmlClassByPropertyWrap named=new UmlClassByPropertyWrap(property);
     		String propertyName=NameHelper.getCapName(property);
     		String propertyUncapName=NameHelper.uncapSafeName(property);
    		String byPropertyValueCamelName=named.getClassByPropetyCapName();
    		//String byPropertyValueGetAccessor=named.getValueGetAccessor();
    stringBuffer.append(TEXT_30);
    stringBuffer.append(named.getComment());
    stringBuffer.append(TEXT_31);
    stringBuffer.append(propertyUncapName);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(named.getComment());
    stringBuffer.append(TEXT_33);
    stringBuffer.append(propertyUncapName);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(modelCommentName);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(propertyName);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(byPropertyValueCamelName);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(modelRTOName);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(named.getComment());
    stringBuffer.append(TEXT_42);
    stringBuffer.append(propertyUncapName);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(modelCommentName);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(propertyName);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(byPropertyValueCamelName);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(named.getComment());
    stringBuffer.append(TEXT_49);
    stringBuffer.append(propertyUncapName);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(modelCommentName);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(propertyName);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(byPropertyValueCamelName);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(modelRTOName);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(named.getComment());
    stringBuffer.append(TEXT_57);
    stringBuffer.append(propertyUncapName);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(modelCommentName);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(propertyName);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(byPropertyValueCamelName);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(modelRTOName);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(named.getComment());
    stringBuffer.append(TEXT_65);
    stringBuffer.append(propertyUncapName);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(modelCommentName);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(propertyName);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(byPropertyValueCamelName);
    stringBuffer.append(TEXT_70);
    /********process keyLabel********/
    stringBuffer.append(TEXT_71);
    	if(KeyLabelStereotypeHelper.isApply(uml2Class)){
    		importManager.addImport("com.jeefuse.base.modules.keyLabel.KeyLabel");
    stringBuffer.append(TEXT_72);
    stringBuffer.append(propertyName);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(modelCommentName);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(propertyName);
    stringBuffer.append(TEXT_75);
    	}
    }
    /********process M2OProperty end********/
    stringBuffer.append(TEXT_76);
    importStringBuffer.insert(importInsertionPoint, importManager.computeSortedImports());
    stringBuffer.append(TEXT_77);
    return stringBuffer.toString();
  }
}
