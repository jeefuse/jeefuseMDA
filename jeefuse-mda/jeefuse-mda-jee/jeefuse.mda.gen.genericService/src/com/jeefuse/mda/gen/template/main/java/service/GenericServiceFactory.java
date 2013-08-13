package com.jeefuse.mda.gen.template.main.java.service;

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

public class GenericServiceFactory
{
  protected static String nl;
  public static synchronized GenericServiceFactory create(String lineSeparator)
  {
    nl = lineSeparator;
    GenericServiceFactory result = new GenericServiceFactory();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "/*" + NL + " * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the \"License\")" + NL + " * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms." + NL + " * email:yonclv@gmail.com" + NL + " */" + NL + "package ";
  protected final String TEXT_3 = ";";
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * ";
  protected final String TEXT_6 = "服务工厂." + NL + " *" + NL + " * @author ";
  protected final String TEXT_7 = NL + " * @generated" + NL + " */" + NL + "public abstract class ";
  protected final String TEXT_8 = "{" + NL;
  protected final String TEXT_9 = NL + "\t/**" + NL + "\t * 获取";
  protected final String TEXT_10 = " CRUD 服务." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic final static ";
  protected final String TEXT_11 = " get";
  protected final String TEXT_12 = "() {" + NL + "\t\treturn (";
  protected final String TEXT_13 = ") ";
  protected final String TEXT_14 = ".getBean(";
  protected final String TEXT_15 = ".SERVICE_ID);" + NL + "\t}" + NL;
  protected final String TEXT_16 = NL + "\t" + NL + "}";
  protected final String TEXT_17 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    Package uml2Package = (Package) argument;
    
String packageName=NameHelper.getQualifiedName(uml2Package);
String modelCommentName=TypeHelper.getDocumentation(uml2Package);
if(Config.defaultDocumentComments.equals(modelCommentName)){
	modelCommentName=MdaHelper.getBriefClassName(packageName);
}
//packageServiceFacotry define
UmlPackageWrap umlPackageWrap=new UmlPackageWrap(uml2Package);
String packageServiceFactoryPackageName=umlPackageWrap.getServiceFactoryPackageName();
String packageServiceFactoryClassName=umlPackageWrap.getServiceFactoryClassName();
//String packageServiceFactoryClassQualifiedName=umlPackageWrap.getServiceFactoryClassQualifiedName();

//add springContextUtils 
String base_SpringContextUtils=Config.base_SpringContextUtils;
String springContextUtilsClassName=MdaHelper.getBriefClassName(base_SpringContextUtils);


    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(packageServiceFactoryPackageName);
    stringBuffer.append(TEXT_3);
    ImportManager importManager = ImportHelper.makeImportManager("");
    
// add imports
//importManager.addImport("java.util.Collection");
//add custom imports
importManager.addImport(base_SpringContextUtils);

    stringBuffer.append(TEXT_4);
    
StringBuffer importStringBuffer = stringBuffer;
int importInsertionPoint = stringBuffer.length();
importManager.addCompilationUnitImports(stringBuffer.toString());

    stringBuffer.append(TEXT_5);
    stringBuffer.append(modelCommentName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(System.getProperty("user.name"));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(packageServiceFactoryClassName);
    stringBuffer.append(TEXT_8);
    List<org.eclipse.uml2.uml.Class> uml2ClassList=PackageHelper.getJoinServiceFactoryClass(uml2Package);
    for(org.eclipse.uml2.uml.Class uml2Class:uml2ClassList){
    
String modelServiceGenericClassName=MdaHelper.getModelClassName(uml2Class,ModelNameSuffix.serviceGeneric);
String modelServiceGenericImplClassName=MdaHelper.getModelClassName(uml2Class,ModelNameSuffix.serviceGenericImpl);
String modelServiceGenericImplQualifiedClassName=MdaHelper.getModelQualifiedName(uml2Class,PKGSuffix.serviceGenericImpl,ModelNameSuffix.serviceGenericImpl);
//String modelServiceGenericImplUncapClassName=NameHelper.uncapName(modelServiceGenericImplClassName);
String uml2ClassCommentName=TypeHelper.getDocumentationOrName(uml2Class);
importManager.addImport(modelServiceGenericImplQualifiedClassName);

    stringBuffer.append(TEXT_9);
    stringBuffer.append(uml2ClassCommentName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(modelServiceGenericClassName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(modelServiceGenericClassName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(modelServiceGenericClassName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(springContextUtilsClassName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(modelServiceGenericImplClassName);
    stringBuffer.append(TEXT_15);
    }
    stringBuffer.append(TEXT_16);
    importStringBuffer.insert(importInsertionPoint, importManager.computeSortedImports());
    stringBuffer.append(TEXT_17);
    return stringBuffer.toString();
  }
}
