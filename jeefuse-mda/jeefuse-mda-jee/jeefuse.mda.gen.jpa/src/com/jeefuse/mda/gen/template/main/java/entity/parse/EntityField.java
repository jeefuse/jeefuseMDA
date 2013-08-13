package com.jeefuse.mda.gen.template.main.java.entity.parse;

import net.taylor.mda.generator.parse.NameRuled.*;
import net.taylor.mda.generator.parse.NameRuled.className.*;
import java.util.ArrayList;
import net.taylor.mda.generator.parse.page.*;
import net.taylor.mda.generator.parse.stereotype.KeyLabelStereotypeHelper;
import net.taylor.mda.generator.parse.*;
import java.util.Iterator;
import java.util.List;
import net.taylor.mda.generator.parse.entity.*;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.*;
import net.taylor.mda.generator.util.*;
import org.eclipse.emf.codegen.util.*;

public class EntityField
{
  protected static String nl;
  public static synchronized EntityField create(String lineSeparator)
  {
    nl = lineSeparator;
    EntityField result = new EntityField();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "/*" + NL + " * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the \"License\")" + NL + " * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms." + NL + " * email:yonclv@gmail.com" + NL + " */" + NL + "package ";
  protected final String TEXT_3 = ";";
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * ";
  protected final String TEXT_6 = " Entity Field constants." + NL + " *" + NL + " * @author ";
  protected final String TEXT_7 = NL + " * @generated" + NL + " */" + NL + "public enum ";
  protected final String TEXT_8 = " implements ";
  protected final String TEXT_9 = "<";
  protected final String TEXT_10 = ">{";
  protected final String TEXT_11 = NL + "\t/**" + NL + "\t * ";
  protected final String TEXT_12 = "." + NL + "\t * @generated" + NL + "\t */" + NL + "\t";
  protected final String TEXT_13 = "(\"";
  protected final String TEXT_14 = "\", \"";
  protected final String TEXT_15 = "\",";
  protected final String TEXT_16 = ",";
  protected final String TEXT_17 = ")";
  protected final String TEXT_18 = ",";
  protected final String TEXT_19 = "//";
  protected final String TEXT_20 = " ";
  protected final String TEXT_21 = "\t";
  protected final String TEXT_22 = "\t";
  protected final String TEXT_23 = NL + "\t/**" + NL + "\t * ";
  protected final String TEXT_24 = "." + NL + "\t * @generated" + NL + "\t */" + NL + "\t";
  protected final String TEXT_25 = "//";
  protected final String TEXT_26 = "_";
  protected final String TEXT_27 = "(\"";
  protected final String TEXT_28 = ".";
  protected final String TEXT_29 = "\", \"";
  protected final String TEXT_30 = "\",";
  protected final String TEXT_31 = ",";
  protected final String TEXT_32 = "),//";
  protected final String TEXT_33 = NL + "\t/**" + NL + "\t * ";
  protected final String TEXT_34 = "." + NL + "\t * @generated" + NL + "\t */" + NL + "\t";
  protected final String TEXT_35 = "//";
  protected final String TEXT_36 = "_";
  protected final String TEXT_37 = "(\"";
  protected final String TEXT_38 = ".";
  protected final String TEXT_39 = "\", \"";
  protected final String TEXT_40 = "\",";
  protected final String TEXT_41 = ",";
  protected final String TEXT_42 = ")";
  protected final String TEXT_43 = ",";
  protected final String TEXT_44 = "// ";
  protected final String TEXT_45 = "\t";
  protected final String TEXT_46 = "\t";
  protected final String TEXT_47 = NL + "\t/**" + NL + "\t * ";
  protected final String TEXT_48 = "." + NL + "\t * @generated" + NL + "\t */" + NL + "\t";
  protected final String TEXT_49 = "//";
  protected final String TEXT_50 = "_";
  protected final String TEXT_51 = "(\"";
  protected final String TEXT_52 = ".";
  protected final String TEXT_53 = "\", \"";
  protected final String TEXT_54 = "\",";
  protected final String TEXT_55 = ",";
  protected final String TEXT_56 = "),//";
  protected final String TEXT_57 = " " + NL + "\t/**" + NL + "\t * ";
  protected final String TEXT_58 = "." + NL + "\t * @generated" + NL + "\t */" + NL + "\t";
  protected final String TEXT_59 = "//";
  protected final String TEXT_60 = "_";
  protected final String TEXT_61 = "(\"";
  protected final String TEXT_62 = ".";
  protected final String TEXT_63 = "\", \"";
  protected final String TEXT_64 = "\",";
  protected final String TEXT_65 = ",";
  protected final String TEXT_66 = ")";
  protected final String TEXT_67 = ",";
  protected final String TEXT_68 = "// ";
  protected final String TEXT_69 = NL + "\t;" + NL + "" + NL + "\t/** @generated */" + NL + "\tprivate String fieldName;" + NL + "\t/** @generated */" + NL + "\tprivate String fieldLabel;" + NL + "\t/** @generated */" + NL + "\tprivate int length;" + NL + "\t/** @generated */" + NL + "\tprivate boolean nullable;" + NL + "\t" + NL + "\t/** @generated */" + NL + "\tprivate ";
  protected final String TEXT_70 = "(String fieldName, String fieldLabel, int length, boolean nullable) {" + NL + "\t\tthis.fieldName = fieldName;" + NL + "\t\tthis.fieldLabel = fieldLabel;" + NL + "\t\tthis.length = length;" + NL + "\t\tthis.nullable = nullable;" + NL + "\t}" + NL + "\t" + NL + "\t/** @generated */" + NL + "\tpublic String getFieldName() {" + NL + "\t\treturn fieldName;" + NL + "\t}" + NL + "" + NL + "\t/** @generated */" + NL + "\tpublic String getFieldLabel() {" + NL + "\t\treturn fieldLabel;" + NL + "\t}" + NL + "\t" + NL + "\t/** @generated */" + NL + "\tpublic String getFieldLabelByName(String paramfieldName) {" + NL + "\t\t";
  protected final String TEXT_71 = " ";
  protected final String TEXT_72 = " = valueOfFieldName(paramfieldName);" + NL + "\t\tif (";
  protected final String TEXT_73 = " != null)" + NL + "\t\t\treturn ";
  protected final String TEXT_74 = ".getFieldName();" + NL + "\t\treturn null;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * 字段长度.不限为零." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic int getLength() {" + NL + "\t\treturn length;" + NL + "\t}" + NL + "" + NL + "\t/** @generated */" + NL + "\tpublic boolean isNullable() {" + NL + "\t\treturn nullable;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * 根据fieldName查找对象,若没有找到则返回null." + NL + "\t * " + NL + "\t * @param fieldName" + NL + "\t * @generated" + NL + "\t */" + NL + "\tstatic public ";
  protected final String TEXT_75 = " valueOfFieldName(String fieldName) {" + NL + "\t\tif (null == fieldName)" + NL + "\t\t\treturn null;" + NL + "\t\t";
  protected final String TEXT_76 = "[] ";
  protected final String TEXT_77 = "s = values();" + NL + "\t\tfor (";
  protected final String TEXT_78 = " ";
  protected final String TEXT_79 = " : ";
  protected final String TEXT_80 = "s) {" + NL + "\t\t\tif (";
  protected final String TEXT_81 = ".getFieldName().equals(fieldName))" + NL + "\t\t\t\treturn ";
  protected final String TEXT_82 = ";" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * 根据fieldLabel查找对象,若没有找到则返回null." + NL + "\t * " + NL + "\t * @param fieldComment" + NL + "\t * @generated" + NL + "\t */" + NL + "\tstatic public ";
  protected final String TEXT_83 = " valueOfFieldLabel(String fieldLabel) {" + NL + "\t\tif (null == fieldLabel)" + NL + "\t\t\treturn null;" + NL + "\t\t";
  protected final String TEXT_84 = "[] ";
  protected final String TEXT_85 = "s = values();" + NL + "\t\tfor (";
  protected final String TEXT_86 = " ";
  protected final String TEXT_87 = " : ";
  protected final String TEXT_88 = "s) {" + NL + "\t\t\tif (";
  protected final String TEXT_89 = ".getFieldLabel().equals(fieldLabel))" + NL + "\t\t\t\treturn ";
  protected final String TEXT_90 = ";" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "}";
  protected final String TEXT_91 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    Class uml2Class = (Class) argument;Package uml2Package = uml2Class.getPackage();
    
/*******clazz wrap********/	
UmlClassWrap clazzWrap=new UmlClassWrap(uml2Class);
String modelCommentName=clazzWrap.getCommentName();

//model field 
ClassNameDefineCommon entityFieldDefine=clazzWrap.getNameDefineEntityField();
String modelFieldClassName=entityFieldDefine.getClassName();
String modelFieldClassUncapName=entityFieldDefine.getClassUncapName();
String modelFieldPackageName=entityFieldDefine.getPackageQualifiedName();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(modelFieldPackageName);
    stringBuffer.append(TEXT_3);
    ImportManager importManager = ImportHelper.makeImportManager("");
    
//model entity define
ClassNameDefineCommon entityDefine=clazzWrap.getNameDefineEntity();
String modelEntityQualifiedName=entityDefine.getClassQualifiedName();
String modelEntityName=entityDefine.getClassCapName();
importManager.addImport(modelEntityQualifiedName);


//base field 
String baseFieldClassName=MdaHelper.getBriefClassName(Config.base_FieldQualifiedName);
importManager.addImport(Config.base_FieldQualifiedName);


    stringBuffer.append(TEXT_4);
    
StringBuffer importStringBuffer = stringBuffer;
int importInsertionPoint = stringBuffer.length();
importManager.addCompilationUnitImports(stringBuffer.toString());

    stringBuffer.append(TEXT_5);
    stringBuffer.append(modelCommentName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(System.getProperty("user.name"));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(modelFieldClassName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(baseFieldClassName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_10);
    List<Property> resultPropertyList=new ArrayList<Property>();
    List<Property> simplePropertyList=ClassHelper.getAllSimplePropertiesList(uml2Class,new ArrayList<Property>());
    List<Property> m2oPropertyList=EntityHelper.getAllManyToOneProperties(uml2Class,false);
    List<Property> o2oPropertyList=EntityHelper.getAllOneToOneProperties(uml2Class,false);
    resultPropertyList.addAll(simplePropertyList);
    resultPropertyList.addAll(m2oPropertyList);
    resultPropertyList.addAll(o2oPropertyList);
    int propertyCount=1;
    for (Iterator<Property> iter=resultPropertyList.iterator(); iter.hasNext();) { 
    	Property property = (Property)iter.next();
    	if (property.getType() !=null) {
    		String propertyUncapSafeName=NameHelper.uncapSafeName(property);
    		String propertyCommentName=TypeHelper.getDocumentationOrName(property);
    /********process simple property********/
    		if(ClassHelper.isSimple(property)){
    stringBuffer.append(TEXT_11);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(NameHelper.uncapSafeName(property));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(PageHelper.getMaxLength(property));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(!PageHelper.isRequired(property));
    stringBuffer.append(TEXT_17);
    if(iter.hasNext()){
    stringBuffer.append(TEXT_18);
    }
    stringBuffer.append(TEXT_19);
    stringBuffer.append(propertyCount++);
    stringBuffer.append(TEXT_20);
    		}
    /********process ontToOne property********/
    		else if(ClassHelper.isOneToOne(property)){
    			Type propertyType=property.getType();
    			Class relTargetClass=(Class)propertyType;
    			//String relTargetClassCommentName=TypeHelper.getDocumentationOrName(relTargetClass);
    			//model entity
    			//String relTargetClassEntityQualifiedName=MdaHelper.getEntityQualifiedName(relTargetClass);
    			//String relTargetClassEntityName=MdaHelper.getModelClassName(relTargetClass,ModelNameSuffix.Entity);
    			//String relTargetClassEntityUncapName=NameHelper.uncapName(relTargetClassEntityName);
    			//importManager.addImport(relTargetClassEntityQualifiedName);
    			//model get Accessor
    			//String relTargetClassGetAccessor=ClassHelper.getGetAccessor(property);
    			//rel list label
     			Property listLabelProperty=ViewListHelper.getProperty_listLabel(property);
     			String listLabelPropertyUncapSafeName=ViewListHelper.getViewListLabelRelPropertyName(property);
     			String listLabelPropertyComment=ViewListHelper.getViewListLabelRelPropertyName(property);
    			//String listLabelPropertyGetAccessorName=ViewListHelper.getViewListLabelRelPropertyGetAccessorName(property);
    			/******** property type id property ********/
     			Property propertyTypeIdProperty=EntityHelper.getIDProperty(relTargetClass);
     			String propertyTypeIdPropertyUncapSafeName=NameHelper.uncapSafeName(propertyTypeIdProperty);
    			//String propertyTypeIdPropertyGetAccessorName=ClassHelper.getGetAccessor(propertyTypeIdProperty);
    stringBuffer.append(TEXT_21);
    			//String propertyTypeIdPropertySetAccessorName="set"+ClassHelper.getAccessorName(propertyTypeIdProperty);
    stringBuffer.append(TEXT_22);
     			String propertyTypeIdPropertyComment=TypeHelper.getDocumentationOrName(propertyTypeIdProperty);
    			boolean isViewList=ViewListHelper.isApplyViewList(property);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_24);
    if(isViewList){
    stringBuffer.append(TEXT_25);
    }
    stringBuffer.append(NameHelper.uncapSafeName(property));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(propertyTypeIdPropertyComment);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(PageHelper.getMaxLength(propertyTypeIdProperty));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(!PageHelper.isRequired(propertyTypeIdProperty));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(propertyCount++);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_34);
    if(isViewList){
    stringBuffer.append(TEXT_35);
    }
    stringBuffer.append(NameHelper.uncapSafeName(property));
    stringBuffer.append(TEXT_36);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(listLabelPropertyComment);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(PageHelper.getMaxLength(listLabelProperty));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(!PageHelper.isRequired(listLabelProperty));
    stringBuffer.append(TEXT_42);
    if(iter.hasNext()){
    stringBuffer.append(TEXT_43);
    }
    stringBuffer.append(TEXT_44);
    stringBuffer.append(propertyCount++);
    		}
    /********process manyToOne property********/
    		else if(ClassHelper.isManyToOne(property)){
    			Type propertyType=property.getType();
    			Class relTargetClass=(Class)propertyType;
    			//String relTargetClassCommentName=TypeHelper.getDocumentationOrName(relTargetClass);
    			//model entity
    			//String relTargetClassEntityQualifiedName=MdaHelper.getEntityQualifiedName(relTargetClass);
    			//String relTargetClassEntityName=MdaHelper.getModelClassName(relTargetClass,ModelNameSuffix.Entity);
    			//String relTargetClassEntityUncapName=NameHelper.uncapName(relTargetClassEntityName);
    			//importManager.addImport(relTargetClassEntityQualifiedName);
    			//model get Accessor
    			//String relTargetClassGetAccessor=ClassHelper.getGetAccessor(property);
    			//rel list label
     			Property listLabelProperty=ViewListHelper.getProperty_listLabel(property);
     			String listLabelPropertyUncapSafeName=ViewListHelper.getViewListLabelRelPropertyName(property);
     			String listLabelPropertyComment=ViewListHelper.getViewListLabelRelPropertyName(property);
    			//String listLabelPropertyGetAccessorName=ViewListHelper.getViewListLabelRelPropertyGetAccessorName(property);
    			/******** property type id property ********/
     			Property propertyTypeIdProperty=EntityHelper.getIDProperty(relTargetClass);
     			String propertyTypeIdPropertyUncapSafeName=NameHelper.uncapSafeName(propertyTypeIdProperty);
    			//String propertyTypeIdPropertyGetAccessorName=ClassHelper.getGetAccessor(propertyTypeIdProperty);
    stringBuffer.append(TEXT_45);
    			//String propertyTypeIdPropertySetAccessorName="set"+ClassHelper.getAccessorName(propertyTypeIdProperty);
    stringBuffer.append(TEXT_46);
     			String propertyTypeIdPropertyComment=TypeHelper.getDocumentationOrName(propertyTypeIdProperty);
    			boolean isViewList=ViewListHelper.isApplyViewList(property);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_48);
    if(isViewList){
    stringBuffer.append(TEXT_49);
    }
    stringBuffer.append(NameHelper.uncapSafeName(property));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(propertyTypeIdPropertyComment);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(PageHelper.getMaxLength(propertyTypeIdProperty));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(!PageHelper.isRequired(propertyTypeIdProperty));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(propertyCount++);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_58);
    if(isViewList){
    stringBuffer.append(TEXT_59);
    }
    stringBuffer.append(NameHelper.uncapSafeName(property));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(listLabelPropertyComment);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(PageHelper.getMaxLength(listLabelProperty));
    stringBuffer.append(TEXT_65);
    stringBuffer.append(!PageHelper.isRequired(listLabelProperty));
    stringBuffer.append(TEXT_66);
    if(iter.hasNext()){
    stringBuffer.append(TEXT_67);
    }
    stringBuffer.append(TEXT_68);
    stringBuffer.append(propertyCount++);
    		}
    	}
    }
    stringBuffer.append(TEXT_69);
    stringBuffer.append(modelFieldClassName);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(modelFieldClassName);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(modelFieldClassUncapName);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(modelFieldClassUncapName);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(modelFieldClassUncapName);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(modelFieldClassName);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(modelFieldClassName);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(modelFieldClassUncapName);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(modelFieldClassName);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(modelFieldClassUncapName);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(modelFieldClassUncapName);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(modelFieldClassUncapName);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(modelFieldClassUncapName);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(modelFieldClassName);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(modelFieldClassName);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(modelFieldClassUncapName);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(modelFieldClassName);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(modelFieldClassUncapName);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(modelFieldClassUncapName);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(modelFieldClassUncapName);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(modelFieldClassUncapName);
    stringBuffer.append(TEXT_90);
    importStringBuffer.insert(importInsertionPoint, importManager.computeSortedImports());
    stringBuffer.append(TEXT_91);
    return stringBuffer.toString();
  }
}
