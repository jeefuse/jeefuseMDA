package com.jeefuse.mda.gen.template.main.java.service;

import net.taylor.mda.generator.parse.NameRuled.nameRuled.*;
import net.taylor.mda.generator.parse.NameRuled.*;
import net.taylor.mda.generator.parse.stereotype.*;
import net.taylor.mda.generator.parse.*;
import java.util.List;
import java.util.Iterator;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.*;
import net.taylor.mda.generator.util.*;
import net.taylor.mda.generator.parse.entity.*;
import org.eclipse.emf.codegen.util.*;

public class GenericServiceFacade
{
  protected static String nl;
  public static synchronized GenericServiceFacade create(String lineSeparator)
  {
    nl = lineSeparator;
    GenericServiceFacade result = new GenericServiceFacade();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "/*" + NL + " * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the \"License\")" + NL + " * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms." + NL + " * email:yonclv@gmail.com" + NL + " */" + NL + "package ";
  protected final String TEXT_3 = ";";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * ";
  protected final String TEXT_5 = "服务Facade." + NL + " *" + NL + " * @author ";
  protected final String TEXT_6 = NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_7 = "{" + NL;
  protected final String TEXT_8 = NL + NL + "\t/*****************************************************************" + NL + "\t * ";
  protected final String TEXT_9 = " service" + NL + "\t *****************************************************************/";
  protected final String TEXT_10 = NL + NL + "\t/**" + NL + "\t * 按主键id获取";
  protected final String TEXT_11 = "对象." + NL + "\t * @generated" + NL + "\t */" + NL + "\tstatic public ";
  protected final String TEXT_12 = " get";
  protected final String TEXT_13 = "(";
  protected final String TEXT_14 = " id){" + NL + "\t\treturn ";
  protected final String TEXT_15 = ".get";
  protected final String TEXT_16 = "().get(id);" + NL + "\t}";
  protected final String TEXT_17 = "\t ";
  protected final String TEXT_18 = NL + NL + "\t/**" + NL + "\t * 获取所有";
  protected final String TEXT_19 = "用于构造tree,只获取id,parentId,displayName属性." + NL + "\t * @generated" + NL + "\t */" + NL + "\tstatic public List<TreeViewItem> getAll";
  protected final String TEXT_20 = "ForTreeview() {" + NL + "\t\treturn ";
  protected final String TEXT_21 = ".get";
  protected final String TEXT_22 = "().getAllForTreeview(null);" + NL + "\t}";
  protected final String TEXT_23 = NL + NL + "\t/**" + NL + "\t * 获取";
  protected final String TEXT_24 = "关联的";
  protected final String TEXT_25 = "Id例表." + NL + " \t * @generated" + NL + "\t */" + NL + "\tstatic public List<String> getRel";
  protected final String TEXT_26 = "IdsBy";
  protected final String TEXT_27 = "Id(String ";
  protected final String TEXT_28 = "){" + NL + "\t\treturn ";
  protected final String TEXT_29 = ".get";
  protected final String TEXT_30 = "().getRel";
  protected final String TEXT_31 = "IdsBy";
  protected final String TEXT_32 = "Id(";
  protected final String TEXT_33 = ");" + NL + "\t}";
  protected final String TEXT_34 = NL + NL + "\t/**" + NL + "\t * 获取";
  protected final String TEXT_35 = "关联的";
  protected final String TEXT_36 = "Id例表." + NL + " \t * @generated" + NL + "\t */" + NL + "\tstatic public List<String> getRel";
  protected final String TEXT_37 = "IdsBy";
  protected final String TEXT_38 = "Id(String ";
  protected final String TEXT_39 = "){" + NL + "\t\treturn ";
  protected final String TEXT_40 = ".get";
  protected final String TEXT_41 = "().getRel";
  protected final String TEXT_42 = "IdsBy";
  protected final String TEXT_43 = "Id(";
  protected final String TEXT_44 = ");" + NL + "\t}";
  protected final String TEXT_45 = "\t\t\t" + NL + "" + NL + "\t/**" + NL + "\t * 获取所有";
  protected final String TEXT_46 = "对象用于构造keyLabel,只获取key,label属性." + NL + "\t * @generated" + NL + "\t */" + NL + "\tstatic public  List<KeyLabel> ";
  protected final String TEXT_47 = "() {" + NL + "\t\treturn ";
  protected final String TEXT_48 = ".get";
  protected final String TEXT_49 = "().getAllForKeyLabel();" + NL + "\t}";
  protected final String TEXT_50 = NL + "}";
  protected final String TEXT_51 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    Package uml2Package = (Package) argument;
    
String packageName=NameHelper.getQualifiedName(uml2Package);
String modelCommentName=TypeHelper.getDocumentation(uml2Package);
if(Config.defaultDocumentComments.equals(modelCommentName)){
	modelCommentName=MdaHelper.getBriefClassName(packageName);
}
//packageServiceFacade define
String packageServiceFacadePackageName=MdaHelper.getPackageQualifiedName(uml2Package,PKGSuffix.serviceFacade);
String packageServiceFacadeClassName=MdaHelper.getPackageClassName(uml2Package,ModelNameSuffix.serviceFacade);
//String packageServiceFacadeQualifiedName=packageServiceFactoryPackageName+"."+packageServiceFactoryClassName;



    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(packageServiceFacadePackageName);
    stringBuffer.append(TEXT_3);
    ImportManager importManager = ImportHelper.makeImportManager("");
    
// add imports
//importManager.addImport("java.util.Collection");
//add springContextUtils 
String springContextUtilsClassName=MdaHelper.getBriefClassName(Config.base_SpringContextUtils);

//packageServiceFacotry define
String packageServiceFactoryPackageName=MdaHelper.getPackageQualifiedName(uml2Package,PKGSuffix.serviceFactory);
String packageServiceFactoryClassName=MdaHelper.getPackageClassName(uml2Package,ModelNameSuffix.serviceFactory);
//String packageServiceFactoryQualifiedName=packageServiceFactoryPackageName+"."+packageServiceFactoryClassName;



    
StringBuffer importStringBuffer = stringBuffer;
int importInsertionPoint = stringBuffer.length();
importManager.addCompilationUnitImports(stringBuffer.toString());

    stringBuffer.append(TEXT_4);
    stringBuffer.append(modelCommentName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(System.getProperty("user.name"));
    stringBuffer.append(TEXT_6);
    stringBuffer.append(packageServiceFacadeClassName);
    stringBuffer.append(TEXT_7);
    List<org.eclipse.uml2.uml.Class> uml2ClassList=PackageHelper.getJoinServiceFactoryClass(uml2Package);
    for(org.eclipse.uml2.uml.Class uml2Class:uml2ClassList){
    
String uml2ClassCommentName=TypeHelper.getDocumentationOrName(uml2Class);
String modelServiceGenericClassName=MdaHelper.getModelClassName(uml2Class,ModelNameSuffix.serviceGeneric);
//String modelServiceGenericImplClassName=MdaHelper.getModelClassName(uml2Class,ModelNameSuffix.serviceGenericImpl);
//String modelServiceGenericImplUncapClassName=NameHelper.uncapName(modelServiceGenericImplClassName);
//model entity
String modelEntityQualifiedName=MdaHelper.getEntityQualifiedName(uml2Class);
String modelEntityName=MdaHelper.getModelClassName(uml2Class,ModelNameSuffix.Entity);

    stringBuffer.append(TEXT_8);
    stringBuffer.append(uml2ClassCommentName);
    stringBuffer.append(TEXT_9);
    if(!ModelStereoTypeHelper.isApplyModel_M2mWithId(uml2Class)){
    importManager.addImport(modelEntityQualifiedName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(EntityHelper.getIDPropertyImportType(uml2Class));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(packageServiceFactoryClassName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(modelServiceGenericClassName);
    stringBuffer.append(TEXT_16);
    }
    stringBuffer.append(TEXT_17);
    if(ModelStereoTypeHelper.isApplyModel_Tree(uml2Class)){
    		importManager.addImport("java.util.List");
    		importManager.addImport("com.jeefuse.base.modules.tree.renders.treeview.TreeViewItem");
    stringBuffer.append(TEXT_18);
    stringBuffer.append(uml2ClassCommentName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(packageServiceFactoryClassName);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(modelServiceGenericClassName);
    stringBuffer.append(TEXT_22);
    }
    if(ModelStereoTypeHelper.isApplyModel_M2mWithId(uml2Class)){
    		/********rel first entity********/
    		List<Property> propertyList=EntityHelper.getAllOneToManyProperties(uml2Class,false);
    		Property firstProperty=propertyList.get(0);
    		Class firstPropertyClass=(Class)firstProperty.getType();
    		String firstPropertyModelCapName=NameHelper.getCapName(firstPropertyClass);
    		String firstPropertyModelUncapName=NameHelper.getUncapName(firstPropertyClass);
    		String firstPropertyModelCommentName=TypeHelper.getDocumentationOrName(firstPropertyClass);
    		//importManager.addImport(firstPropertyEntityQualifiedName);
    		/********rel second entity********/
    		Property secondProperty=propertyList.get(1);
    		Class  secondPropertyClass=(Class)secondProperty.getType();
    		String secondPropertyModelCapName=NameHelper.getCapName(firstPropertyClass);
    		String secondPropertyModelUncapName=NameHelper.getUncapName(firstPropertyClass);
    		String secondPropertyModelCommentName=TypeHelper.getDocumentationOrName(secondPropertyClass);
    		//importManager.addImport(secondPropertyEntityQualifiedName);
    		//ower
    		String owerClassCapName=firstPropertyModelCapName;
    		String owerClassUncapName=firstPropertyModelUncapName;
    		String owerClassCommentName=firstPropertyModelCommentName;
    		String owerClassId=owerClassCapName+"Id";
    		//rel
    		String relClassCapName=secondPropertyModelCapName;
    		String relClassUncapName=secondPropertyModelUncapName;
    		String relClassIds=secondPropertyModelCapName+"Ids";
    		String relClassId=relClassCapName+"Id";
    		String relClassCommentName=secondPropertyModelCommentName;
    stringBuffer.append(TEXT_23);
    stringBuffer.append(firstPropertyModelCommentName);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(secondPropertyModelCommentName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(relClassCapName);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(owerClassCapName);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(owerClassId);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(packageServiceFactoryClassName);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(modelServiceGenericClassName);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(relClassCapName);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(owerClassCapName);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(owerClassId);
    stringBuffer.append(TEXT_33);
    		//ower
    		owerClassCapName=secondPropertyModelCapName;
    		owerClassUncapName=secondPropertyModelUncapName;
    		owerClassCommentName=secondPropertyModelCommentName;
    		owerClassId=owerClassCapName+"Id";
    		//rel
    		relClassCapName=firstPropertyModelCapName;
    		relClassUncapName=firstPropertyModelUncapName;
    		relClassCommentName=firstPropertyModelCommentName;
    		relClassId=relClassCapName+"Id";
    		relClassIds=firstPropertyModelCapName+"Ids";
    stringBuffer.append(TEXT_34);
    stringBuffer.append(firstPropertyModelCommentName);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(secondPropertyModelCommentName);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(relClassCapName);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(owerClassCapName);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(owerClassId);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(packageServiceFactoryClassName);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(modelServiceGenericClassName);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(relClassCapName);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(owerClassCapName);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(owerClassId);
    stringBuffer.append(TEXT_44);
    }
    	if(KeyLabelStereotypeHelper.isApply(uml2Class)){
    		UmlClassWrap clazzWrap=new UmlClassWrap(uml2Class);
    		importManager.addImport("com.jeefuse.base.modules.keyLabel.KeyLabel");
    		String classGetAllForKeyLabel=clazzWrap.getNamedRuleProperty(PropertyNamedRuleKind.getAllForKeyLabel);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(uml2ClassCommentName);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(classGetAllForKeyLabel);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(packageServiceFactoryClassName);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(modelServiceGenericClassName);
    stringBuffer.append(TEXT_49);
    	}
    }
    stringBuffer.append(TEXT_50);
    importStringBuffer.insert(importInsertionPoint, importManager.computeSortedImports());
    stringBuffer.append(TEXT_51);
    return stringBuffer.toString();
  }
}
