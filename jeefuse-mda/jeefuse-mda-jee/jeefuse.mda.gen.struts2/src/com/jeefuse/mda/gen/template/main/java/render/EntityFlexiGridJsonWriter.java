package com.jeefuse.mda.gen.template.main.java.render;

import net.taylor.mda.generator.parse.NameRuled.nameRuled.*;
import net.taylor.mda.generator.parse.NameRuled.className.*;
import net.taylor.mda.generator.parse.NameRuled.*;
import java.util.List;
import net.taylor.mda.generator.parse.*;
import net.taylor.mda.generator.parse.page.*;
import net.taylor.mda.generator.parse.entity.*;
import java.util.Iterator;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.*;
import net.taylor.mda.generator.util.*;
import org.eclipse.emf.codegen.util.*;

public class EntityFlexiGridJsonWriter
{
  protected static String nl;
  public static synchronized EntityFlexiGridJsonWriter create(String lineSeparator)
  {
    nl = lineSeparator;
    EntityFlexiGridJsonWriter result = new EntityFlexiGridJsonWriter();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "/*" + NL + " * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the \"License\")" + NL + " * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms." + NL + " * email:yonclv@gmail.com" + NL + " */" + NL + "package ";
  protected final String TEXT_3 = ";";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * 输出";
  protected final String TEXT_5 = "  FlexiGrid json格式数据." + NL + " * " + NL + " * @author ";
  protected final String TEXT_6 = NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_7 = " extends FlexidGridJsonWriter<";
  protected final String TEXT_8 = "> {" + NL + "" + NL + "\t/** @generated */" + NL + "\tpublic ";
  protected final String TEXT_9 = "(Page<";
  protected final String TEXT_10 = "> page) {" + NL + "\t\t\tsuper(page);" + NL + "\t}" + NL + "" + NL + "\t/** @generated */" + NL + "\tpublic ";
  protected final String TEXT_11 = "(int pageNo, long total, List<";
  protected final String TEXT_12 = "> items) {" + NL + "\t\tsuper(pageNo, total, items);" + NL + "\t}" + NL + "" + NL + "\t/** @generated */" + NL + "\t@Override" + NL + "\tprotected void writeJsonModel(JsonGenerator g, ";
  protected final String TEXT_13 = " model) throws JsonProcessingException, IOException {";
  protected final String TEXT_14 = NL + "\t\t";
  protected final String TEXT_15 = "//";
  protected final String TEXT_16 = "g.writeStringField(";
  protected final String TEXT_17 = ".";
  protected final String TEXT_18 = ".getFieldName(), model.get";
  protected final String TEXT_19 = "());//";
  protected final String TEXT_20 = " ";
  protected final String TEXT_21 = NL + "\t\t";
  protected final String TEXT_22 = "//";
  protected final String TEXT_23 = "g.";
  protected final String TEXT_24 = ";//";
  protected final String TEXT_25 = " ";
  protected final String TEXT_26 = NL + "\t\t// 关联";
  protected final String TEXT_27 = NL + "\t\t";
  protected final String TEXT_28 = "//";
  protected final String TEXT_29 = " ";
  protected final String TEXT_30 = " = model.";
  protected final String TEXT_31 = "();" + NL + "\t\t";
  protected final String TEXT_32 = "//";
  protected final String TEXT_33 = "g.writeObjectFieldStart(\"";
  protected final String TEXT_34 = "\");" + NL + "\t\t";
  protected final String TEXT_35 = "//";
  protected final String TEXT_36 = "g.writeStringField(\"";
  protected final String TEXT_37 = "\", null == ";
  protected final String TEXT_38 = " ? null : ";
  protected final String TEXT_39 = ".";
  protected final String TEXT_40 = "());//";
  protected final String TEXT_41 = " ";
  protected final String TEXT_42 = NL + "\t\t";
  protected final String TEXT_43 = "//";
  protected final String TEXT_44 = "g.writeEndObject();";
  protected final String TEXT_45 = NL + "\t\t";
  protected final String TEXT_46 = "//";
  protected final String TEXT_47 = "g.";
  protected final String TEXT_48 = "(\"";
  protected final String TEXT_49 = "_";
  protected final String TEXT_50 = "\", null == ";
  protected final String TEXT_51 = " ? null : ";
  protected final String TEXT_52 = ".";
  protected final String TEXT_53 = "());//";
  protected final String TEXT_54 = " ";
  protected final String TEXT_55 = NL + "\t\t// 关联";
  protected final String TEXT_56 = NL + "\t\t";
  protected final String TEXT_57 = "//";
  protected final String TEXT_58 = " ";
  protected final String TEXT_59 = " = model.";
  protected final String TEXT_60 = "();" + NL + "\t\t";
  protected final String TEXT_61 = "//";
  protected final String TEXT_62 = "g.writeObjectFieldStart(\"";
  protected final String TEXT_63 = "\");" + NL + "\t\t";
  protected final String TEXT_64 = "//";
  protected final String TEXT_65 = "g.writeStringField(\"";
  protected final String TEXT_66 = "\", null == ";
  protected final String TEXT_67 = " ? null : ";
  protected final String TEXT_68 = ".";
  protected final String TEXT_69 = "());//";
  protected final String TEXT_70 = " ";
  protected final String TEXT_71 = NL + "\t\t";
  protected final String TEXT_72 = "//";
  protected final String TEXT_73 = "g.writeEndObject();";
  protected final String TEXT_74 = NL + "\t\t";
  protected final String TEXT_75 = "//";
  protected final String TEXT_76 = "g.";
  protected final String TEXT_77 = "(\"";
  protected final String TEXT_78 = "_";
  protected final String TEXT_79 = "\", null == ";
  protected final String TEXT_80 = " ? null : ";
  protected final String TEXT_81 = ".";
  protected final String TEXT_82 = "());//";
  protected final String TEXT_83 = " ";
  protected final String TEXT_84 = NL + "\t}" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    Class uml2Class = (Class) argument;Package uml2Package = uml2Class.getPackage();
    
/*******clazz wrap********/	
UmlClassWrap clazzWrap=new UmlClassWrap(uml2Class);

//model FlexiGridJsonWrite define
ClassNameDefineCommon flexiGridJsonWriteDefine=clazzWrap.getNameDefineFlexiGridJsonWrite();
String flexiGridJsonWritePackage=flexiGridJsonWriteDefine.getPackageQualifiedName();
String flexiGridJsonWriteClassName=flexiGridJsonWriteDefine.getClassCapName();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(flexiGridJsonWritePackage);
    stringBuffer.append(TEXT_3);
    ImportManager importManager = ImportHelper.makeImportManager("");
    importManager.addImport("java.io.IOException");
    importManager.addImport("java.util.List");
    importManager.addImport("org.codehaus.jackson.JsonGenerator");
    importManager.addImport("org.codehaus.jackson.JsonProcessingException");
    importManager.addImport("com.jeefuse.base.modules.json.FlexidGridJsonWriter");
    importManager.addImport("com.jeefuse.base.utils.page.Page");
    
//model entity define
ClassNameDefineCommon entityDefine=clazzWrap.getNameDefineEntity();
String modelEntityQualifiedName=entityDefine.getClassQualifiedName();
String modelEntityName=entityDefine.getClassCapName();
importManager.addImport(modelEntityQualifiedName);

//model field 
ClassNameDefineCommon entityFieldDefine=clazzWrap.getNameDefineEntityField();
String modelFieldQualifiedName=entityFieldDefine.getClassQualifiedName();
String modelFieldClassName=entityFieldDefine.getClassCapName();
importManager.addImport(modelFieldQualifiedName);

//model RTO define
ClassNameDefineCommon rtoDefine=clazzWrap.getNameDefineRTO();
String modelRTOQualifiedName=rtoDefine.getClassQualifiedName();
importManager.addImport(modelRTOQualifiedName);


    
StringBuffer importStringBuffer = stringBuffer;
int importInsertionPoint = stringBuffer.length();
importManager.addCompilationUnitImports(stringBuffer.toString());

    stringBuffer.append(TEXT_4);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(System.getProperty("user.name"));
    stringBuffer.append(TEXT_6);
    stringBuffer.append(flexiGridJsonWriteClassName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(flexiGridJsonWriteClassName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(flexiGridJsonWriteClassName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_13);
    List<Property> propertyList=EntityHelper.getAllSimpleProperties(uml2Class);
    int count=1;
    for(Property property:propertyList){
    	String propertyName=NameHelper.uncapSafeName(property);
    	//String propertyImportFeatureType=MdaHelper.getImportedFeatureType(property);
    	//String propertyGetMethod=ClassHelper.getGetAccessor(property);
    	String propertyCommentName=TypeHelper.getDocumentationOrName(property);
    	if(TypeHelper.isDate(property)){
    		String propertyToDateTimeCapName=PropertyNamedRuleKind.dateToDateTimeStr.getRuleCapNamed(property);
    stringBuffer.append(TEXT_14);
    if(!ViewListHelper.isApplyViewList(property)){
    stringBuffer.append(TEXT_15);
    }
    stringBuffer.append(TEXT_16);
    stringBuffer.append(modelFieldClassName);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(propertyName);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(propertyToDateTimeCapName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(count++);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(propertyCommentName);
    	}else{
    		String propertyJacksonWriteMethod=JsonRenderHelper.getJacksonWriteRender(property,uml2Class);
    stringBuffer.append(TEXT_21);
    if(!ViewListHelper.isApplyViewList(property)&&!EntityHelper.isIDProperty(property)){
    stringBuffer.append(TEXT_22);
    }
    stringBuffer.append(TEXT_23);
    stringBuffer.append(propertyJacksonWriteMethod);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(count++);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(propertyCommentName);
    	}
    }
    /********process all M2OProperty start********/
    Iterator<Property> m2oPropertyList=EntityHelper.getAllManyToOneProperties(uml2Class,false).iterator();
    for (;m2oPropertyList.hasNext();){//process m2oPropertyList
    		Property property=m2oPropertyList.next();
     		String propertyCommentName=TypeHelper.getDocumentationOrName(property);
     		//String propertyUncapSafeName=NameHelper.uncapSafeName(property);
    		Type propertyType=property.getType();
    		Class relTargetClass=(Class)propertyType;
    		String relTargetClassCommentName=TypeHelper.getDocumentationOrName(relTargetClass);
    		//model entity
    		String relTargetClassEntityQualifiedName=MdaHelper.getEntityQualifiedName(relTargetClass);
    		String relTargetClassEntityName=MdaHelper.getModelClassName(relTargetClass,ModelNameSuffix.Entity);
    		String relTargetClassEntityUncapName=NameHelper.uncapName(relTargetClassEntityName);
    		//model get Accessor
    		String relTargetClassGetAccessor=ClassHelper.getGetAccessor(property);
    		//rel list label
     		String listLabelPropertyUncapSafeName=ViewListHelper.getViewListLabelRelPropertyName(property);
     		//String listLabelPropertyComment=ViewListHelper.getViewListLabelRelPropertyName(property);
    		String listLabelPropertyGetAccessorName=ViewListHelper.getViewListLabelRelPropertyGetAccessorName(property);
    		boolean isViewList=ViewListHelper.isApplyViewList(property);
    		if(isViewList){
    		importManager.addImport(relTargetClassEntityQualifiedName);
    		}
    stringBuffer.append(TEXT_26);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_27);
    if(!ViewListHelper.isApplyViewList(property)){
    stringBuffer.append(TEXT_28);
    }
    stringBuffer.append(relTargetClassEntityName);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(relTargetClassEntityUncapName);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(relTargetClassGetAccessor);
    stringBuffer.append(TEXT_31);
    if(!ViewListHelper.isApplyViewList(property)){
    stringBuffer.append(TEXT_32);
    }
    stringBuffer.append(TEXT_33);
    stringBuffer.append(relTargetClassEntityUncapName);
    stringBuffer.append(TEXT_34);
    if(!ViewListHelper.isApplyViewList(property)){
    stringBuffer.append(TEXT_35);
    }
    stringBuffer.append(TEXT_36);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(relTargetClassEntityUncapName);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(relTargetClassEntityUncapName);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(listLabelPropertyGetAccessorName);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(count++);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_42);
    if(!ViewListHelper.isApplyViewList(property)){
    stringBuffer.append(TEXT_43);
    }
    stringBuffer.append(TEXT_44);
    /*
    stringBuffer.append(TEXT_45);
    if(!ViewListHelper.isApplyViewList(property)){
    stringBuffer.append(TEXT_46);
    }
    stringBuffer.append(TEXT_47);
    stringBuffer.append(JsonRenderHelper.getJacksonWriteMethod(relTargetClass));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(relTargetClassEntityUncapName);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(relTargetClassEntityUncapName);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(listLabelPropertyGetAccessorName);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(count++);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(propertyCommentName);
    */
    }
    /********process all M2OProperty end********/
    /********process all O2OProperty start********/
    Iterator<Property> o2oPropertyList=EntityHelper.getAllOneToOneProperties(uml2Class,false).iterator();
    for (;o2oPropertyList.hasNext();){//process o2oPropertyList
    		Property property=o2oPropertyList.next();
     		String propertyCommentName=TypeHelper.getDocumentationOrName(property);
    		Type propertyType=property.getType();
    		Class relTargetClass=(Class)propertyType;
    		String relTargetClassCommentName=TypeHelper.getDocumentationOrName(relTargetClass);
    		//model entity
    		String relTargetClassEntityQualifiedName=MdaHelper.getEntityQualifiedName(relTargetClass);
    		String relTargetClassEntityName=MdaHelper.getModelClassName(relTargetClass,ModelNameSuffix.Entity);
    		String relTargetClassEntityUncapName=NameHelper.uncapName(relTargetClassEntityName);
    		//model get Accessor
    		String relTargetClassGetAccessor=ClassHelper.getGetAccessor(property);
    		//rel list label
     		String listLabelPropertyUncapSafeName=ViewListHelper.getViewListLabelRelPropertyName(property);
     		//String listLabelPropertyComment=ViewListHelper.getViewListLabelRelPropertyName(property);
    		String listLabelPropertyGetAccessorName=ViewListHelper.getViewListLabelRelPropertyGetAccessorName(property);
    		boolean isViewList=ViewListHelper.isApplyViewList(property);
    		if(isViewList){
    		importManager.addImport(relTargetClassEntityQualifiedName);
    		}
    stringBuffer.append(TEXT_55);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_56);
    if(!isViewList){
    stringBuffer.append(TEXT_57);
    }
    stringBuffer.append(relTargetClassEntityName);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(relTargetClassEntityUncapName);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(relTargetClassGetAccessor);
    stringBuffer.append(TEXT_60);
    if(!isViewList){
    stringBuffer.append(TEXT_61);
    }
    stringBuffer.append(TEXT_62);
    stringBuffer.append(relTargetClassEntityUncapName);
    stringBuffer.append(TEXT_63);
    if(!isViewList){
    stringBuffer.append(TEXT_64);
    }
    stringBuffer.append(TEXT_65);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(relTargetClassEntityUncapName);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(relTargetClassEntityUncapName);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(listLabelPropertyGetAccessorName);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(count++);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_71);
    if(!isViewList){
    stringBuffer.append(TEXT_72);
    }
    stringBuffer.append(TEXT_73);
    /*
    stringBuffer.append(TEXT_74);
    if(!isViewList){
    stringBuffer.append(TEXT_75);
    }
    stringBuffer.append(TEXT_76);
    stringBuffer.append(JsonRenderHelper.getJacksonWriteMethod(relTargetClass));
    stringBuffer.append(TEXT_77);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(relTargetClassEntityUncapName);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(relTargetClassEntityUncapName);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(listLabelPropertyGetAccessorName);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(count++);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(propertyCommentName);
    */
    }
    /********process all O2OProperty end********/
    stringBuffer.append(TEXT_84);
    importStringBuffer.insert(importInsertionPoint, importManager.computeSortedImports());
    return stringBuffer.toString();
  }
}
