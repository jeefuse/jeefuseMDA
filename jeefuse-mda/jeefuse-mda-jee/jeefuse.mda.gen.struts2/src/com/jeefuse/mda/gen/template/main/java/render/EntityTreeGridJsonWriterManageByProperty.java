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

public class EntityTreeGridJsonWriterManageByProperty
{
  protected static String nl;
  public static synchronized EntityTreeGridJsonWriterManageByProperty create(String lineSeparator)
  {
    nl = lineSeparator;
    EntityTreeGridJsonWriterManageByProperty result = new EntityTreeGridJsonWriterManageByProperty();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "/*" + NL + " * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the \"License\")" + NL + " * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms." + NL + " * email:yonclv@gmail.com" + NL + " */" + NL + "package ";
  protected final String TEXT_2 = ";" + NL;
  protected final String TEXT_3 = NL + NL + "/**" + NL + " * 输出";
  protected final String TEXT_4 = " by ";
  protected final String TEXT_5 = " TreeFlexiGrid json格式数据." + NL + " * " + NL + " * @author ";
  protected final String TEXT_6 = NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_7 = " extends FlexidTreeGridJsonWriter<";
  protected final String TEXT_8 = "> {" + NL + "" + NL + "\t/** @generated */" + NL + "\tpublic ";
  protected final String TEXT_9 = "(List<TreeNodeGeneric<";
  protected final String TEXT_10 = ">> treeNodeList, long total) {" + NL + "\t\tsuper(treeNodeList, total);" + NL + "\t}" + NL + "" + NL + "\t/** @generated */" + NL + "\tpublic ";
  protected final String TEXT_11 = "(List<TreeNodeGeneric<";
  protected final String TEXT_12 = ">> treeNodeList, long total, boolean success, String message) {" + NL + "\t\tsuper(treeNodeList, total,  success,  message);" + NL + "\t}" + NL + "\t" + NL + "\t/** @generated */" + NL + "\t@Override" + NL + "\tprotected void writeJsonModel(JsonGenerator g, TreeNodeGeneric<";
  protected final String TEXT_13 = "> treeNode) throws JsonProcessingException, IOException {" + NL + "\t\t";
  protected final String TEXT_14 = " model = treeNode.getTargetObject();";
  protected final String TEXT_15 = NL + "\t\t";
  protected final String TEXT_16 = "//";
  protected final String TEXT_17 = "g.writeStringField(";
  protected final String TEXT_18 = ".";
  protected final String TEXT_19 = ".getFieldName(), model.get";
  protected final String TEXT_20 = "());//";
  protected final String TEXT_21 = " ";
  protected final String TEXT_22 = NL + "\t\t";
  protected final String TEXT_23 = "//";
  protected final String TEXT_24 = "g.";
  protected final String TEXT_25 = ";//";
  protected final String TEXT_26 = " ";
  protected final String TEXT_27 = NL + "\t\t// 关联";
  protected final String TEXT_28 = NL + "\t\t";
  protected final String TEXT_29 = "//";
  protected final String TEXT_30 = " ";
  protected final String TEXT_31 = " = model.";
  protected final String TEXT_32 = "();" + NL + "\t\t";
  protected final String TEXT_33 = "//";
  protected final String TEXT_34 = "g.writeObjectFieldStart(\"";
  protected final String TEXT_35 = "\");" + NL + "\t\t";
  protected final String TEXT_36 = "//";
  protected final String TEXT_37 = "g.writeStringField(\"";
  protected final String TEXT_38 = "\", null == ";
  protected final String TEXT_39 = " ? null : ";
  protected final String TEXT_40 = ".";
  protected final String TEXT_41 = "());//";
  protected final String TEXT_42 = " ";
  protected final String TEXT_43 = NL + "\t\t";
  protected final String TEXT_44 = "//";
  protected final String TEXT_45 = "g.writeEndObject();";
  protected final String TEXT_46 = NL + "\t\t";
  protected final String TEXT_47 = "//";
  protected final String TEXT_48 = "g.";
  protected final String TEXT_49 = "(\"";
  protected final String TEXT_50 = "_";
  protected final String TEXT_51 = "\", null == ";
  protected final String TEXT_52 = " ? null : ";
  protected final String TEXT_53 = ".";
  protected final String TEXT_54 = "());//";
  protected final String TEXT_55 = " ";
  protected final String TEXT_56 = NL + "\t\t// 关联";
  protected final String TEXT_57 = NL + "\t\t";
  protected final String TEXT_58 = "//";
  protected final String TEXT_59 = " ";
  protected final String TEXT_60 = " = model.";
  protected final String TEXT_61 = "();" + NL + "\t\t";
  protected final String TEXT_62 = "//";
  protected final String TEXT_63 = "g.writeObjectFieldStart(\"";
  protected final String TEXT_64 = "\");" + NL + "\t\t";
  protected final String TEXT_65 = "//";
  protected final String TEXT_66 = "g.writeStringField(\"";
  protected final String TEXT_67 = "\", null == ";
  protected final String TEXT_68 = " ? null : ";
  protected final String TEXT_69 = ".";
  protected final String TEXT_70 = "());//";
  protected final String TEXT_71 = " ";
  protected final String TEXT_72 = NL + "\t\t";
  protected final String TEXT_73 = "//";
  protected final String TEXT_74 = "g.writeEndObject();";
  protected final String TEXT_75 = NL + "\t\t";
  protected final String TEXT_76 = "//";
  protected final String TEXT_77 = "g.";
  protected final String TEXT_78 = "(\"";
  protected final String TEXT_79 = "_";
  protected final String TEXT_80 = "\", null == ";
  protected final String TEXT_81 = " ? null : ";
  protected final String TEXT_82 = ".";
  protected final String TEXT_83 = "());//";
  protected final String TEXT_84 = " ";
  protected final String TEXT_85 = NL + "\t\t// 树形属性" + NL + "\t\tg.writeStringField(TEXT, model.getText());" + NL + "\t\tg.writeBooleanField(COMPLETE, model.getComplete());" + NL + "\t\tg.writeBooleanField(HAS_CHILDREN, treeNode.hasChildrens());" + NL + "\t\tif (treeNode.hasChildrens()) {" + NL + "\t\t\tg.writeArrayFieldStart(CHILD_NODES);" + NL + "\t\t\tList<TreeNodeGeneric<";
  protected final String TEXT_86 = ">> treeNodeChildrens = treeNode.getChildrens();" + NL + "\t\t\tfor (TreeNodeGeneric<";
  protected final String TEXT_87 = "> childTreeNode : treeNodeChildrens) {" + NL + "\t\t\t\tg.writeStartObject();// write model data" + NL + "\t\t\t\twriteJsonModel(g, childTreeNode);" + NL + "\t\t\t\tg.writeEndObject();// write model data end" + NL + "\t\t\t}" + NL + "\t\t\tg.writeEndArray();" + NL + "\t\t}" + NL + "\t}" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    Property curProperty = (Property) argument;Package propertyPackage = curProperty.getNearestPackage();
    
/******property wrap*******/
UmlPropertyWrap propertyWrap=new UmlPropertyWrap(curProperty);
//String curPropertyUnCapName=propertyWrap.getUncapName();
String curPropertyComment=propertyWrap.getCommentName();
Class ownerClass=(Class)curProperty.getOwner();
UmlClassWrap clazzWrap=new UmlClassWrap(ownerClass);
String ownerClassCommentName=clazzWrap.getCommentName();

/******** clazz by property wrap ********/
UmlClassByPropertyWrap clazzByPropertyWrap=new UmlClassByPropertyWrap(curProperty);

/******** TreeGridJsonWriter by Property action define********/
ClassNameDefineByPropertyCommon flexiGridJsonWriteByProperty=clazzByPropertyWrap.getNameDefineTreeGridJsonWriterByProperty();
String resultMsgJsonWriterByPropertyPackageName=flexiGridJsonWriteByProperty.getPackageQualifiedName();
String resultMsgJsonWriterByPropertyClassName=flexiGridJsonWriteByProperty.getClassName();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(resultMsgJsonWriterByPropertyPackageName);
    stringBuffer.append(TEXT_2);
    ImportManager importManager = ImportHelper.makeImportManager("");
    importManager.addImport("java.io.IOException");
    importManager.addImport("java.util.List");
    importManager.addImport("org.codehaus.jackson.JsonGenerator");
    importManager.addImport("org.codehaus.jackson.JsonProcessingException");
    //importManager.addImport("com.jeefuse.base.modules.json.FlexidGridJsonWriter");
    //importManager.addImport("com.jeefuse.base.utils.page.Page");
    importManager.addImport("com.jeefuse.base.modules.json.FlexidTreeGridJsonWriter");
    importManager.addImport("com.jeefuse.base.modules.tree.renders.generic.TreeNodeGeneric");
    
//model entity define
ClassNameDefineCommon entityDefine=clazzWrap.getNameDefineEntity();
String modelEntityQualifiedName=entityDefine.getClassQualifiedName();
String modelEntityName=entityDefine.getClassCapName();
importManager.addImport(modelEntityQualifiedName);

//model field 
ClassNameDefineCommon entityFieldDefine=clazzWrap.getNameDefineEntityField();
String modelFieldQualifiedName=entityFieldDefine.getClassQualifiedName();
String modelFieldName=entityFieldDefine.getClassName();
importManager.addImport(modelFieldQualifiedName);


    
StringBuffer importStringBuffer = stringBuffer;
int importInsertionPoint = stringBuffer.length();
importManager.addCompilationUnitImports(stringBuffer.toString());

    stringBuffer.append(TEXT_3);
    stringBuffer.append(ownerClassCommentName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(curPropertyComment);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(System.getProperty("user.name"));
    stringBuffer.append(TEXT_6);
    stringBuffer.append(resultMsgJsonWriterByPropertyClassName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(resultMsgJsonWriterByPropertyClassName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(resultMsgJsonWriterByPropertyClassName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_14);
    List<Property> propertyList=EntityHelper.getAllSimpleProperties(ownerClass);
    int count=1;
    for(Property property:propertyList){
    	String propertyName=NameHelper.uncapSafeName(property);
    	//String propertyImportFeatureType=MdaHelper.getImportedFeatureType(property);
    	//String propertyGetMethod=ClassHelper.getGetAccessor(property);
    	String propertyCommentName=TypeHelper.getDocumentationOrName(property);
    	boolean isViewList=ViewListHelper.isApplyViewList(property);
    	if(property.getName().equals(curProperty.getName())){
    		isViewList=false;
    	}
    	if(TypeHelper.isDate(property)){
    		String propertyToDateTimeCapName=PropertyNamedRuleKind.dateToDateTimeStr.getRuleCapNamed(property);
    stringBuffer.append(TEXT_15);
    if(!isViewList){
    stringBuffer.append(TEXT_16);
    }
    stringBuffer.append(TEXT_17);
    stringBuffer.append(modelFieldName);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(propertyName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(propertyToDateTimeCapName);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(count++);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(propertyCommentName);
    	}else{
    		String propertyJacksonWriteMethod=JsonRenderHelper.getJacksonWriteRender(property,ownerClass);
    stringBuffer.append(TEXT_22);
    if(!isViewList&&!EntityHelper.isIDProperty(property)){
    stringBuffer.append(TEXT_23);
    }
    stringBuffer.append(TEXT_24);
    stringBuffer.append(propertyJacksonWriteMethod);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(count++);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(propertyCommentName);
    	}
    }
    /********process all M2OProperty start********/
    Iterator<Property> m2oPropertyList=EntityHelper.getAllManyToOneProperties(ownerClass,false).iterator();
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
    		if(property.getName().equals(curProperty.getName())){
    			isViewList=false;
    		}
    		if(isViewList){
    		importManager.addImport(relTargetClassEntityQualifiedName);
    		}
    stringBuffer.append(TEXT_27);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_28);
    if(!ViewListHelper.isApplyViewList(property)){
    stringBuffer.append(TEXT_29);
    }
    stringBuffer.append(relTargetClassEntityName);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(relTargetClassEntityUncapName);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(relTargetClassGetAccessor);
    stringBuffer.append(TEXT_32);
    if(!ViewListHelper.isApplyViewList(property)){
    stringBuffer.append(TEXT_33);
    }
    stringBuffer.append(TEXT_34);
    stringBuffer.append(relTargetClassEntityUncapName);
    stringBuffer.append(TEXT_35);
    if(!ViewListHelper.isApplyViewList(property)){
    stringBuffer.append(TEXT_36);
    }
    stringBuffer.append(TEXT_37);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(relTargetClassEntityUncapName);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(relTargetClassEntityUncapName);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(listLabelPropertyGetAccessorName);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(count++);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_43);
    if(!ViewListHelper.isApplyViewList(property)){
    stringBuffer.append(TEXT_44);
    }
    stringBuffer.append(TEXT_45);
    /*
    stringBuffer.append(TEXT_46);
    if(!ViewListHelper.isApplyViewList(property)){
    stringBuffer.append(TEXT_47);
    }
    stringBuffer.append(TEXT_48);
    stringBuffer.append(JsonRenderHelper.getJacksonWriteMethod(relTargetClass));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(relTargetClassEntityUncapName);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(relTargetClassEntityUncapName);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(listLabelPropertyGetAccessorName);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(count++);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(propertyCommentName);
    */
    }
    /********process all M2OProperty end********/
    /********process all O2OProperty start********/
    Iterator<Property> o2oPropertyList=EntityHelper.getAllOneToOneProperties(ownerClass,false).iterator();
    for (;o2oPropertyList.hasNext();){//process o2oPropertyList
    		Property property=o2oPropertyList.next();
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
    		if(property.getName().equals(curProperty.getName())){
    			isViewList=false;
    		}
    		if(isViewList){
    		importManager.addImport(relTargetClassEntityQualifiedName);
    		}
    stringBuffer.append(TEXT_56);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_57);
    if(!isViewList){
    stringBuffer.append(TEXT_58);
    }
    stringBuffer.append(relTargetClassEntityName);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(relTargetClassEntityUncapName);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(relTargetClassGetAccessor);
    stringBuffer.append(TEXT_61);
    if(!isViewList){
    stringBuffer.append(TEXT_62);
    }
    stringBuffer.append(TEXT_63);
    stringBuffer.append(relTargetClassEntityUncapName);
    stringBuffer.append(TEXT_64);
    if(!isViewList){
    stringBuffer.append(TEXT_65);
    }
    stringBuffer.append(TEXT_66);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(relTargetClassEntityUncapName);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(relTargetClassEntityUncapName);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(listLabelPropertyGetAccessorName);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(count++);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_72);
    if(!isViewList){
    stringBuffer.append(TEXT_73);
    }
    stringBuffer.append(TEXT_74);
    /*
    stringBuffer.append(TEXT_75);
    if(!isViewList){
    stringBuffer.append(TEXT_76);
    }
    stringBuffer.append(TEXT_77);
    stringBuffer.append(JsonRenderHelper.getJacksonWriteMethod(relTargetClass));
    stringBuffer.append(TEXT_78);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(relTargetClassEntityUncapName);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(relTargetClassEntityUncapName);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(listLabelPropertyGetAccessorName);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(count++);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(propertyCommentName);
    */
    }
    /********process all O2OProperty end********/
    stringBuffer.append(TEXT_85);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_87);
    importStringBuffer.insert(importInsertionPoint, importManager.computeSortedImports());
    return stringBuffer.toString();
  }
}
