package com.jeefuse.mda.gen.template.main.java.entity.parse;

import net.taylor.mda.generator.parse.NameRuled.*;
import net.taylor.mda.generator.parse.NameRuled.className.*;
import net.taylor.mda.generator.parse.page.*;
import java.util.ArrayList;
import net.taylor.mda.generator.parse.*;
import java.util.Iterator;
import java.util.List;
import net.taylor.mda.generator.parse.entity.*;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.*;
import net.taylor.mda.generator.util.*;
import org.eclipse.emf.codegen.util.*;

public class EntityPropertyValueGet
{
  protected static String nl;
  public static synchronized EntityPropertyValueGet create(String lineSeparator)
  {
    nl = lineSeparator;
    EntityPropertyValueGet result = new EntityPropertyValueGet();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "/*" + NL + " * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the \"License\")" + NL + " * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms." + NL + " * email:yonclv@gmail.com" + NL + " */" + NL + "package ";
  protected final String TEXT_3 = ";";
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = NL;
  protected final String TEXT_6 = NL + NL + "/**" + NL + " * ";
  protected final String TEXT_7 = " 属性值获取." + NL + " *" + NL + " * @author ";
  protected final String TEXT_8 = NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_9 = " implements ";
  protected final String TEXT_10 = "<";
  protected final String TEXT_11 = ">{" + NL + "" + NL + "\t/**" + NL + "\t * ";
  protected final String TEXT_12 = " 属性值获取.该方法用于根据属性名直接获取对象的属性值." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Object getValue(";
  protected final String TEXT_13 = " model, String propertyName) throws DataNoExistException {" + NL + "\t\tif (null == model)" + NL + "\t\t\treturn null;" + NL + "\t\t";
  protected final String TEXT_14 = " ";
  protected final String TEXT_15 = " = ";
  protected final String TEXT_16 = ".valueOfFieldName(propertyName);" + NL + "\t\tif (null == ";
  protected final String TEXT_17 = ")" + NL + "\t\t\tthrow new DataNoExistException(\"无效字段:\" + propertyName);" + NL + "\t\tswitch (";
  protected final String TEXT_18 = ") {";
  protected final String TEXT_19 = NL + "\t\tcase ";
  protected final String TEXT_20 = "://";
  protected final String TEXT_21 = " ";
  protected final String TEXT_22 = NL + "\t\t\t";
  protected final String TEXT_23 = " ";
  protected final String TEXT_24 = " = ";
  protected final String TEXT_25 = ".valueOfKey(model.";
  protected final String TEXT_26 = "());" + NL + "\t\t\tif (null != ";
  protected final String TEXT_27 = ") {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_28 = ".getLabel();" + NL + "\t\t\t} else {" + NL + "\t\t\t\treturn model.";
  protected final String TEXT_29 = "();" + NL + "\t\t\t}";
  protected final String TEXT_30 = NL + "\t\t\treturn model.";
  protected final String TEXT_31 = "();";
  protected final String TEXT_32 = "\t";
  protected final String TEXT_33 = "\t";
  protected final String TEXT_34 = "\t";
  protected final String TEXT_35 = NL + "\t\t";
  protected final String TEXT_36 = "//";
  protected final String TEXT_37 = "case ";
  protected final String TEXT_38 = "_";
  protected final String TEXT_39 = "://";
  protected final String TEXT_40 = " 关联";
  protected final String TEXT_41 = NL + "\t\t\t";
  protected final String TEXT_42 = "//";
  protected final String TEXT_43 = "return (null == model.";
  protected final String TEXT_44 = "() ? null : model.";
  protected final String TEXT_45 = "().";
  protected final String TEXT_46 = "());" + NL + "\t\t";
  protected final String TEXT_47 = "//";
  protected final String TEXT_48 = "case ";
  protected final String TEXT_49 = "_";
  protected final String TEXT_50 = "://";
  protected final String TEXT_51 = NL + "\t\t\t";
  protected final String TEXT_52 = "//";
  protected final String TEXT_53 = "return (null == model.";
  protected final String TEXT_54 = "() ? null : model.";
  protected final String TEXT_55 = "().";
  protected final String TEXT_56 = "());";
  protected final String TEXT_57 = "\t";
  protected final String TEXT_58 = "\t";
  protected final String TEXT_59 = NL + "\t\t";
  protected final String TEXT_60 = "//";
  protected final String TEXT_61 = "case ";
  protected final String TEXT_62 = "_";
  protected final String TEXT_63 = "://";
  protected final String TEXT_64 = " 关联";
  protected final String TEXT_65 = NL + "\t\t\t";
  protected final String TEXT_66 = "//";
  protected final String TEXT_67 = "return (null == model.";
  protected final String TEXT_68 = "() ? null : model.";
  protected final String TEXT_69 = "().";
  protected final String TEXT_70 = "());" + NL + "\t\t";
  protected final String TEXT_71 = "//";
  protected final String TEXT_72 = "case ";
  protected final String TEXT_73 = "_";
  protected final String TEXT_74 = "://";
  protected final String TEXT_75 = NL + "\t\t\t";
  protected final String TEXT_76 = "//";
  protected final String TEXT_77 = "return (null == model.";
  protected final String TEXT_78 = "() ? null : model.";
  protected final String TEXT_79 = "().";
  protected final String TEXT_80 = "());";
  protected final String TEXT_81 = NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "\t" + NL + "}";
  protected final String TEXT_82 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    Class uml2Class = (Class) argument;Package uml2Package = uml2Class.getPackage();
    
UmlClassWrap clazzWrap=new UmlClassWrap(uml2Class);
String modelCommentName=clazzWrap.getCommentName();

//model propertyValueGet 
ClassNameDefineCommon propertyValueGetDefine=clazzWrap.getNameDefineEntityPropertyValueGet();
String propertyValueGetClassName=propertyValueGetDefine.getClassName();
String modelPropertyValueGetPackageName=propertyValueGetDefine.getPackageQualifiedName();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(modelPropertyValueGetPackageName);
    stringBuffer.append(TEXT_3);
    ImportManager importManager = ImportHelper.makeImportManager("");
    stringBuffer.append(TEXT_4);
    
//imports 
String base_propertyValueGetClassName=MdaHelper.getBriefClassName(Config.base_PropertyValueGetClassName);
importManager.addImport(Config.base_PropertyValueGetClassName);
importManager.addImport(Config.base_Exception_DataNoExistException);

//model entity define
ClassNameDefineCommon entityDefine=clazzWrap.getNameDefineEntity();
String modelEntityQualifiedName=entityDefine.getClassQualifiedName();
String modelEntityName=entityDefine.getClassCapName();
importManager.addImport(modelEntityQualifiedName);

//model field 
ClassNameDefineCommon entityFieldDefine=clazzWrap.getNameDefineEntityField();
String modelFieldQualifiedName=entityFieldDefine.getClassQualifiedName();
String modelFieldClassName=entityFieldDefine.getClassName();
String modelFieldUncapName=entityFieldDefine.getClassUncapName();
importManager.addImport(modelFieldQualifiedName);


    stringBuffer.append(TEXT_5);
    
StringBuffer importStringBuffer = stringBuffer;
int importInsertionPoint = stringBuffer.length();
importManager.addCompilationUnitImports(stringBuffer.toString());

    stringBuffer.append(TEXT_6);
    stringBuffer.append(modelCommentName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(System.getProperty("user.name"));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(propertyValueGetClassName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(base_propertyValueGetClassName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(modelCommentName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(modelFieldClassName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(modelFieldUncapName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(modelFieldClassName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(modelFieldUncapName);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(modelFieldUncapName);
    stringBuffer.append(TEXT_18);
    List<Property> simpleListProperty=ClassHelper.getAllSimplePropertiesList(uml2Class,new ArrayList<Property>());
    int propertyCount=1;
    for (Iterator<Property> i=simpleListProperty.iterator(); i.hasNext();) { 
    	Property property = (Property)i.next();
    	if(property.getType() !=null) {
    		String propertyUncapSafeName=NameHelper.uncapSafeName(property);
    		String propertyCommentName=TypeHelper.getDocumentationOrName(property);
    		String propertyGetAccessor=ClassHelper.getGetAccessor(property);
    		//String propretyGetAccessorName=ClassHelper.getAccessorName(property);
    		Enumeration enumeration=EnumKindHelper.getAppliedEnumKindEnumeration(property);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(propertyCount++);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(propertyCommentName);
    		if(null!=enumeration){
    			String modelEnumQualifiedName=MdaHelper.getModelQualifiedName(enumeration,PKGSuffix.enumeration,ModelNameSuffix.enumeration);
    			String modelEnumName=MdaHelper.getModelClassName(enumeration,ModelNameSuffix.enumeration);
    			String modelEnumNameUncap=NameHelper.uncapName(modelEnumName);
    			importManager.addImport(modelEnumQualifiedName);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(modelEnumName);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(modelEnumNameUncap);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(modelEnumName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(propertyGetAccessor);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(modelEnumNameUncap);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(modelEnumNameUncap);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(propertyGetAccessor);
    stringBuffer.append(TEXT_29);
    		}else{
    stringBuffer.append(TEXT_30);
    stringBuffer.append(propertyGetAccessor);
    stringBuffer.append(TEXT_31);
    		}
    	}
    }
    stringBuffer.append(TEXT_32);
    /********process all M2OProperty start********/
    Iterator<Property> m2oPropertyList=EntityHelper.getAllManyToOneProperties(uml2Class,false).iterator();
    for (;m2oPropertyList.hasNext();){//process m2oPropertyList
    		Property property=m2oPropertyList.next();
     		String propertyCommentName=TypeHelper.getDocumentationOrName(property);
     		String propertyUncapSafeName=NameHelper.uncapSafeName(property);
    		Type propertyType=property.getType();
    		Class relTargetClass=(Class)propertyType;
    		String relTargetClassCommentName=TypeHelper.getDocumentationOrName(relTargetClass);
    		/******** model entity********/
    		String relTargetClassEntityQualifiedName=MdaHelper.getEntityQualifiedName(relTargetClass);
    		String relTargetClassEntityName=MdaHelper.getModelClassName(relTargetClass,ModelNameSuffix.Entity);
    		String relTargetClassEntityUncapName=NameHelper.uncapName(relTargetClassEntityName);
    		//model get Accessor
    		String relTargetClassGetAccessor=ClassHelper.getGetAccessor(property);
    		/******** rel list label********/
     		String listLabelPropertyUncapSafeName=ViewListHelper.getViewListLabelRelPropertyName(property);
     		String listLabelPropertyComment=ViewListHelper.getViewListLabelRelPropertyName(property);
    		String listLabelPropertyGetAccessorName=ViewListHelper.getViewListLabelRelPropertyGetAccessorName(property);
    		boolean isViewList=ViewListHelper.isApplyViewList(property);
    		/******** property type id property ********/
     		Property propertyTypeIdProperty=EntityHelper.getIDProperty(relTargetClass);
     		String propertyTypeIdPropertyUncapSafeName=NameHelper.uncapSafeName(propertyTypeIdProperty);
    		String propertyTypeIdPropertyGetAccessorName=ClassHelper.getGetAccessor(propertyTypeIdProperty);
    stringBuffer.append(TEXT_33);
    		String propertyTypeIdPropertySetAccessorName="set"+ClassHelper.getAccessorName(propertyTypeIdProperty);
    stringBuffer.append(TEXT_34);
     		String propertyTypeIdPropertyComment=TypeHelper.getDocumentationOrName(propertyTypeIdProperty);
    		/********is view list********/
    		if(isViewList){
    		//importManager.addImport(relTargetClassEntityQualifiedName);
    		}
    stringBuffer.append(TEXT_35);
    if(isViewList){
    stringBuffer.append(TEXT_36);
    }
    stringBuffer.append(TEXT_37);
    stringBuffer.append(NameHelper.uncapSafeName(property));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(propertyCount++);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_41);
    if(isViewList){
    stringBuffer.append(TEXT_42);
    }
    stringBuffer.append(TEXT_43);
    stringBuffer.append(relTargetClassGetAccessor);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(relTargetClassGetAccessor);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(propertyTypeIdPropertyGetAccessorName);
    stringBuffer.append(TEXT_46);
    if(isViewList){
    stringBuffer.append(TEXT_47);
    }
    stringBuffer.append(TEXT_48);
    stringBuffer.append(NameHelper.uncapSafeName(property));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_51);
    if(isViewList){
    stringBuffer.append(TEXT_52);
    }
    stringBuffer.append(TEXT_53);
    stringBuffer.append(relTargetClassGetAccessor);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(relTargetClassGetAccessor);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(listLabelPropertyGetAccessorName);
    stringBuffer.append(TEXT_56);
    }
    /********process all M2OProperty end********/
    /********process all O2OProperty start********/
    Iterator<Property> o2oPropertyList=EntityHelper.getAllOneToOneProperties(uml2Class,false).iterator();
    for (;o2oPropertyList.hasNext();){//process o2oPropertyList
    		Property property=o2oPropertyList.next();
     		String propertyCommentName=TypeHelper.getDocumentationOrName(property);
     		String propertyUncapSafeName=NameHelper.uncapSafeName(property);
    		Type propertyType=property.getType();
    		Class relTargetClass=(Class)propertyType;
    		String relTargetClassCommentName=TypeHelper.getDocumentationOrName(relTargetClass);
    		//model entity
    		String relTargetClassEntityQualifiedName=MdaHelper.getEntityQualifiedName(relTargetClass);
    		String relTargetClassEntityName=MdaHelper.getModelClassName(relTargetClass,ModelNameSuffix.Entity);
    		String relTargetClassEntityUncapName=NameHelper.uncapName(relTargetClassEntityName);
    		importManager.addImport(relTargetClassEntityQualifiedName);
    		//model get Accessor
    		String relTargetClassGetAccessor=ClassHelper.getGetAccessor(property);
    		//rel list label
     		String listLabelPropertyUncapSafeName=ViewListHelper.getViewListLabelRelPropertyName(property);
     		String listLabelPropertyComment=ViewListHelper.getViewListLabelRelPropertyName(property);
    		String listLabelPropertyGetAccessorName=ViewListHelper.getViewListLabelRelPropertyGetAccessorName(property);
    		/******** property type id property ********/
     		Property propertyTypeIdProperty=EntityHelper.getIDProperty(relTargetClass);
     		String propertyTypeIdPropertyUncapSafeName=NameHelper.uncapSafeName(propertyTypeIdProperty);
    		String propertyTypeIdPropertyGetAccessorName=ClassHelper.getGetAccessor(propertyTypeIdProperty);
    stringBuffer.append(TEXT_57);
    		String propertyTypeIdPropertySetAccessorName="set"+ClassHelper.getAccessorName(propertyTypeIdProperty);
    stringBuffer.append(TEXT_58);
     		String propertyTypeIdPropertyComment=TypeHelper.getDocumentationOrName(propertyTypeIdProperty);
    		boolean isViewList=ViewListHelper.isApplyViewList(property);
    		/********is view list********/
    		if(isViewList){
    		//importManager.addImport(relTargetClassEntityQualifiedName);
    		}
    stringBuffer.append(TEXT_59);
    if(isViewList){
    stringBuffer.append(TEXT_60);
    }
    stringBuffer.append(TEXT_61);
    stringBuffer.append(NameHelper.uncapSafeName(property));
    stringBuffer.append(TEXT_62);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(propertyCount++);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_65);
    if(isViewList){
    stringBuffer.append(TEXT_66);
    }
    stringBuffer.append(TEXT_67);
    stringBuffer.append(relTargetClassGetAccessor);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(relTargetClassGetAccessor);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(propertyTypeIdPropertyGetAccessorName);
    stringBuffer.append(TEXT_70);
    if(isViewList){
    stringBuffer.append(TEXT_71);
    }
    stringBuffer.append(TEXT_72);
    stringBuffer.append(NameHelper.uncapSafeName(property));
    stringBuffer.append(TEXT_73);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_75);
    if(isViewList){
    stringBuffer.append(TEXT_76);
    }
    stringBuffer.append(TEXT_77);
    stringBuffer.append(relTargetClassGetAccessor);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(relTargetClassGetAccessor);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(listLabelPropertyGetAccessorName);
    stringBuffer.append(TEXT_80);
    }
    stringBuffer.append(TEXT_81);
    importStringBuffer.insert(importInsertionPoint, importManager.computeSortedImports());
    stringBuffer.append(TEXT_82);
    return stringBuffer.toString();
  }
}
