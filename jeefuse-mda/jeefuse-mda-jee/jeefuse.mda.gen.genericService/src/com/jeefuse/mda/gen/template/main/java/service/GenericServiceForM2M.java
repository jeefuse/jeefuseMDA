package com.jeefuse.mda.gen.template.main.java.service;

import net.taylor.mda.generator.parse.NameRuled.nameRuled.*;
import net.taylor.mda.generator.parse.NameRuled.className.*;
import net.taylor.mda.generator.parse.NameRuled.*;
import net.taylor.mda.generator.parse.*;
import java.util.List;
import java.util.Iterator;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.*;
import net.taylor.mda.generator.util.*;
import net.taylor.mda.generator.parse.entity.*;
import org.eclipse.emf.codegen.util.*;

public class GenericServiceForM2M
{
  protected static String nl;
  public static synchronized GenericServiceForM2M create(String lineSeparator)
  {
    nl = lineSeparator;
    GenericServiceForM2M result = new GenericServiceForM2M();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "/*" + NL + " * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the \"License\")" + NL + " * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms." + NL + " * email:yonclv@gmail.com" + NL + " */" + NL + "package ";
  protected final String TEXT_2 = ";";
  protected final String TEXT_3 = NL;
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * ";
  protected final String TEXT_5 = " service." + NL + " *" + NL + " * @author ";
  protected final String TEXT_6 = NL + " * @generated" + NL + " */" + NL + "public interface ";
  protected final String TEXT_7 = " extends ";
  protected final String TEXT_8 = "<";
  protected final String TEXT_9 = ", ";
  protected final String TEXT_10 = "> {" + NL;
  protected final String TEXT_11 = NL + "\t" + NL + "\t/*****************************************************************" + NL + "\t * ";
  protected final String TEXT_12 = " rel ";
  protected final String TEXT_13 = NL + "\t *****************************************************************/" + NL + "\t" + NL + "\t/**" + NL + "\t * 判断";
  protected final String TEXT_14 = " 是否有";
  protected final String TEXT_15 = "." + NL + " \t * @generated" + NL + "\t */" + NL + "\tpublic boolean is";
  protected final String TEXT_16 = "HasRel";
  protected final String TEXT_17 = "(String ";
  protected final String TEXT_18 = "Id, String ";
  protected final String TEXT_19 = "Id);" + NL + "" + NL + "\t/**" + NL + "\t * 删除";
  protected final String TEXT_20 = "所有关联";
  protected final String TEXT_21 = ",并保存新的关联";
  protected final String TEXT_22 = "." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void check";
  protected final String TEXT_23 = "Rel";
  protected final String TEXT_24 = "(final ";
  protected final String TEXT_25 = " ";
  protected final String TEXT_26 = ", String... ";
  protected final String TEXT_27 = "Ids);" + NL + "" + NL + "\t/**" + NL + "\t * 获取";
  protected final String TEXT_28 = "关联的";
  protected final String TEXT_29 = "Id例表." + NL + " \t * @generated" + NL + "\t */" + NL + "\tpublic List<String> getRel";
  protected final String TEXT_30 = "IdsBy";
  protected final String TEXT_31 = "Id(String ";
  protected final String TEXT_32 = "Id);" + NL + "" + NL + "\t/*****************************************************************" + NL + "\t * ";
  protected final String TEXT_33 = " rel ";
  protected final String TEXT_34 = " /" + NL + "\t *****************************************************************/" + NL + "\t" + NL + "\t/**" + NL + "\t * 判断";
  protected final String TEXT_35 = " 是否有";
  protected final String TEXT_36 = "." + NL + " \t * @generated" + NL + "\t */" + NL + "\tpublic boolean is";
  protected final String TEXT_37 = "HasRel";
  protected final String TEXT_38 = "(String ";
  protected final String TEXT_39 = "Id, String ";
  protected final String TEXT_40 = "Id);" + NL + "" + NL + "\t/**" + NL + "\t * 删除";
  protected final String TEXT_41 = "所有关联";
  protected final String TEXT_42 = ",并保存新的关联";
  protected final String TEXT_43 = "." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void check";
  protected final String TEXT_44 = "Rel";
  protected final String TEXT_45 = "(final ";
  protected final String TEXT_46 = " ";
  protected final String TEXT_47 = ", String... ";
  protected final String TEXT_48 = "Ids);" + NL + "" + NL + "\t/**" + NL + "\t * 获取";
  protected final String TEXT_49 = "关联的";
  protected final String TEXT_50 = "Id例表." + NL + " \t * @generated" + NL + "\t */" + NL + "\tpublic List<String> getRel";
  protected final String TEXT_51 = "IdsBy";
  protected final String TEXT_52 = "Id(String ";
  protected final String TEXT_53 = "Id);" + NL + "\t" + NL + "}";
  protected final String TEXT_54 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    Class uml2Class = (Class) argument;Package uml2Package = uml2Class.getPackage();
    
/*******clazz wrap********/	
UmlClassWrap clazzWrap=new UmlClassWrap(uml2Class);
String modelCommentName=clazzWrap.getCommentName();

//rel generic service
ClassNameDefineCommon serviceDefine=clazzWrap.getNameDefineServiceGeneric();
String modelServiceGenericPackageName=serviceDefine.getPackageQualifiedName();
String modelServiceGenericClassName=serviceDefine.getClassCapName();


    stringBuffer.append(TEXT_1);
    stringBuffer.append(modelServiceGenericPackageName);
    stringBuffer.append(TEXT_2);
    ImportManager importManager = ImportHelper.makeImportManager("");
    
// add imports
importManager.addImport("java.util.List");
importManager.addImport("com.jeefuse.base.modules.condition.order.Order");
importManager.addImport("com.jeefuse.base.utils.page.Page");
importManager.addImport(Config.base_ServiceGenericQualifiedName);
String baseServiceGenericClassName=MdaHelper.getBriefClassName(Config.base_ServiceGenericQualifiedName);

//model entity define
ClassNameDefineCommon entityDefine=clazzWrap.getNameDefineEntity();
String modelEntityQualifiedName=entityDefine.getClassQualifiedName();
String modelEntityName=entityDefine.getClassCapName();
importManager.addImport(modelEntityQualifiedName);

//model field 
ClassNameDefineCommon entityFieldDefine=clazzWrap.getNameDefineEntityField();
String modelFieldQualifiedName=entityFieldDefine.getClassQualifiedName();
importManager.addImport(modelFieldQualifiedName);

//model propertyValueGet 
ClassNameDefineCommon propertyValueGetDefine=clazzWrap.getNameDefineEntityPropertyValueGet();
String propertyValueGetQualifiedName=propertyValueGetDefine.getClassQualifiedName();
importManager.addImport(propertyValueGetQualifiedName);

//model RTO define
ClassNameDefineCommon rtoDefine=clazzWrap.getNameDefineRTO();
String modelRTOQualifiedName=rtoDefine.getClassQualifiedName();
importManager.addImport(modelRTOQualifiedName);

    stringBuffer.append(TEXT_3);
    
StringBuffer importStringBuffer = stringBuffer;
int importInsertionPoint = stringBuffer.length();
importManager.addCompilationUnitImports(stringBuffer.toString());

    stringBuffer.append(TEXT_4);
    stringBuffer.append(modelCommentName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(System.getProperty("user.name"));
    stringBuffer.append(TEXT_6);
    stringBuffer.append(modelServiceGenericClassName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(baseServiceGenericClassName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(EntityHelper.getIDPropertyImportType(uml2Class));
    stringBuffer.append(TEXT_10);
    /********rel first entity********/
    List<Property> propertyList=EntityHelper.getAllOneToManyProperties(uml2Class,false);
    Property firstProperty=propertyList.get(0);
    Class firstPropertyClass=(Class)firstProperty.getType();
    String firstPropertyModelCapName=NameHelper.getCapName(firstPropertyClass);
    String firstPropertyModelUncapName=NameHelper.getUncapName(firstPropertyClass);
    String firstPropertyModelCommentName=TypeHelper.getDocumentationOrName(firstPropertyClass);
    String firstPropertyEntityQualifiedName=MdaHelper.getEntityQualifiedName(firstPropertyClass);
    importManager.addImport(firstPropertyEntityQualifiedName);
    /********rel second entity********/
    Property secondProperty=propertyList.get(1);
    Class  secondPropertyClass=(Class)secondProperty.getType();
    String secondPropertyModelCapName=NameHelper.getCapName(firstPropertyClass);
    String secondPropertyModelUncapName=NameHelper.getUncapName(firstPropertyClass);
    String secondPropertyModelCommentName=TypeHelper.getDocumentationOrName(secondPropertyClass);
    String secondPropertyEntityQualifiedName=MdaHelper.getEntityQualifiedName(secondPropertyClass);
    importManager.addImport(secondPropertyEntityQualifiedName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(firstPropertyModelCommentName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(secondPropertyModelCommentName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(firstPropertyModelCommentName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(secondPropertyModelCommentName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(firstPropertyModelCapName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(secondPropertyModelCapName);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(firstPropertyModelUncapName);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(secondPropertyModelUncapName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(firstPropertyModelCommentName);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(secondPropertyModelCommentName);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(secondPropertyModelCommentName);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(firstPropertyModelCapName);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(secondPropertyModelCapName);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(firstPropertyModelCapName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(firstPropertyModelUncapName);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(secondPropertyModelUncapName);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(firstPropertyModelCommentName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(secondPropertyModelCommentName);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(secondPropertyModelCapName);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(firstPropertyModelCapName);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(firstPropertyModelUncapName);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(secondPropertyModelCommentName);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(firstPropertyModelCommentName);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(secondPropertyModelCommentName);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(firstPropertyModelCommentName);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(secondPropertyModelCapName);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(firstPropertyModelCapName);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(secondPropertyModelUncapName);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(firstPropertyModelUncapName);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(secondPropertyModelCommentName);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(firstPropertyModelCommentName);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(firstPropertyModelCommentName);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(secondPropertyModelCapName);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(firstPropertyModelCapName);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(secondPropertyModelCapName);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(secondPropertyModelUncapName);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(firstPropertyModelUncapName);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(secondPropertyModelCommentName);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(firstPropertyModelCommentName);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(secondPropertyModelCapName);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(firstPropertyModelCapName);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(firstPropertyModelUncapName);
    stringBuffer.append(TEXT_53);
    importStringBuffer.insert(importInsertionPoint, importManager.computeSortedImports());
    stringBuffer.append(TEXT_54);
    return stringBuffer.toString();
  }
}
