package com.jeefuse.mda.gen.template.main.java.render;

import net.taylor.mda.generator.parse.NameRuled.className.*;
import net.taylor.mda.generator.parse.NameRuled.*;
import java.util.List;
import net.taylor.mda.generator.parse.*;
import net.taylor.mda.generator.parse.entity.*;
import java.util.Iterator;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.*;
import net.taylor.mda.generator.util.*;
import org.eclipse.emf.codegen.util.*;

public class EntityRenderUtilManageByProperty
{
  protected static String nl;
  public static synchronized EntityRenderUtilManageByProperty create(String lineSeparator)
  {
    nl = lineSeparator;
    EntityRenderUtilManageByProperty result = new EntityRenderUtilManageByProperty();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "/*" + NL + " * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the \"License\")" + NL + " * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms." + NL + " * email:yonclv@gmail.com" + NL + " */" + NL + "package ";
  protected final String TEXT_2 = ";";
  protected final String TEXT_3 = NL + NL + "/**" + NL + " * ";
  protected final String TEXT_4 = " by ";
  protected final String TEXT_5 = " render util." + NL + " * " + NL + " * @author ";
  protected final String TEXT_6 = NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_7 = "  {" + NL + "" + NL + "\t/**" + NL + "\t * 输出 ";
  protected final String TEXT_8 = " by ";
  protected final String TEXT_9 = " ResultMsg json对象格式数据." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tstatic public void jsonResultMsgBy";
  protected final String TEXT_10 = "(boolean success, ";
  protected final String TEXT_11 = " model, String message) {" + NL + "\t\tResultJsonWriter<";
  protected final String TEXT_12 = "> jsonWriter=new ";
  protected final String TEXT_13 = "(success, model, message);" + NL + "\t\tRenderUtil.renderJson(jsonWriter);" + NL + "\t}";
  protected final String TEXT_14 = NL + "\t/**" + NL + "\t * 输出 ";
  protected final String TEXT_15 = " by ";
  protected final String TEXT_16 = " ResultMsg html对象格式数据." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static void htmlResultMsgBy";
  protected final String TEXT_17 = "(boolean success, ";
  protected final String TEXT_18 = " model, String message) {" + NL + "\t\tResultJsonWriter<GlDiningMenu> jsonWriter = new ";
  protected final String TEXT_19 = "(success, model, message);" + NL + "\t\tRenderUtil.renderHtml(jsonWriter);" + NL + "\t}" + NL + "\t";
  protected final String TEXT_20 = NL + "\t/**" + NL + "\t * 输出";
  protected final String TEXT_21 = " by ";
  protected final String TEXT_22 = " FlexiGrid json对象格式数据." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tstatic public void jsonFlexiGridBy";
  protected final String TEXT_23 = "(int pageNo, long total, List<";
  protected final String TEXT_24 = "> items) {" + NL + "\t\tFlexidGridJsonWriter<";
  protected final String TEXT_25 = "> jsonWriter = new ";
  protected final String TEXT_26 = "(pageNo, total, items);" + NL + "\t\tRenderUtil.renderJson(jsonWriter);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * 输出";
  protected final String TEXT_27 = " by ";
  protected final String TEXT_28 = " FlexiGrid json对象格式数据." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tstatic public void jsonFlexiGridBy";
  protected final String TEXT_29 = "(Page<";
  protected final String TEXT_30 = "> page) {" + NL + "\t\tjsonFlexiGridBy";
  protected final String TEXT_31 = "(page.getPageNo(), page.getTotalCount(), page.getResult());" + NL + "\t}" + NL + "\t";
  protected final String TEXT_32 = NL + "\t/**" + NL + "\t * 输出";
  protected final String TEXT_33 = " by ";
  protected final String TEXT_34 = " FlexiTreeGrid json对象格式数据." + NL + "\t * " + NL + "\t */" + NL + "\tpublic static void jsonFlexiTreeGridBy";
  protected final String TEXT_35 = "(long totalCount, List<";
  protected final String TEXT_36 = "> items) {" + NL + "\t\tTreeNodeGeneric<";
  protected final String TEXT_37 = "> treeNode = TreeNodeGenericConstructUtil.constructTreeNode(items);" + NL + "\t\tJsonWriter jsonWriter = new ";
  protected final String TEXT_38 = "(treeNode.getChildrens(), totalCount);" + NL + "\t\tRenderUtil.renderJson(jsonWriter);" + NL + "\t}";
  protected final String TEXT_39 = NL + "\t\t" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    Property curProperty = (Property) argument;Package propertyPackage = curProperty.getNearestPackage();
    
/******property wrap*******/
UmlPropertyWrap propertyWrap=new UmlPropertyWrap(curProperty);
String curPropertyCapName=propertyWrap.getCapName();
//String curPropertyUnCapName=propertyWrap.getUncapName();
String curPropertyComment=propertyWrap.getCommentName();
Class ownerClass=(Class)curProperty.getOwner();
UmlClassWrap clazzWrap=new UmlClassWrap(ownerClass);
String ownerClassCommentName=clazzWrap.getCommentName();

/******** clazz by property wrap ********/
UmlClassByPropertyWrap clazzByPropertyWrap=new UmlClassByPropertyWrap(curProperty);

/******** clazz by Property action define********/
ClassNameDefineByPropertyCommon renderUtilByProperty=clazzByPropertyWrap.getNameDefineRenderUtilByProperty();
String renderUtilPackageName=renderUtilByProperty.getPackageQualifiedName();
String renderUtilClassName=renderUtilByProperty.getClassName();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(renderUtilPackageName);
    stringBuffer.append(TEXT_2);
    ImportManager	importManager = ImportHelper.makeImportManager("");
    importManager.addImport("java.util.List");
    //importManager.addImport("com.jeefuse.base.modules.json.JsonWriter");
    importManager.addImport("com.jeefuse.base.utils.page.Page");
    importManager.addImport("com.jeefuse.base.web.utils.RenderUtil");
    //importManager.addImport("com.jeefuse.base.web.result.ResultMsg");
    importManager.addImport("com.jeefuse.base.modules.json.ResultJsonWriter");
    importManager.addImport("com.jeefuse.base.modules.json.FlexidGridJsonWriter");
    
//model entity define
ClassNameDefineCommon entityDefine=clazzWrap.getNameDefineEntity();
String modelEntityQualifiedName=entityDefine.getClassQualifiedName();
String modelEntityName=entityDefine.getClassCapName();
importManager.addImport(modelEntityQualifiedName);

// flexiGridJsonWriter by Property  define
ClassNameDefineByPropertyCommon flexiGridJsonWriterByProperty=clazzByPropertyWrap.getNameDefineFlexiGridJsonWriterByProperty();
String flexiGridJsonWriterByPropertyClassName=flexiGridJsonWriterByProperty.getClassName();
String flexiGridJsonWriterByPropertyClassQualifiedName=flexiGridJsonWriterByProperty.getClassQualifiedName();
importManager.addImport(flexiGridJsonWriterByPropertyClassQualifiedName);

//  ResultJsonWriter by property define
ClassNameDefineByPropertyCommon resultMsgJsonWriterByProperty=clazzByPropertyWrap.getNameDefineResultMsgJsonWriterByProperty();
String resultMsgJsonWriterByPropertyClassName=resultMsgJsonWriterByProperty.getClassName();
String resultMsgJsonWriterByPropertyQualifiedName=resultMsgJsonWriterByProperty.getClassQualifiedName();
importManager.addImport(resultMsgJsonWriterByPropertyQualifiedName);


    
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
    stringBuffer.append(renderUtilClassName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(curPropertyComment);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(curPropertyCapName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(resultMsgJsonWriterByPropertyClassName);
    stringBuffer.append(TEXT_13);
    /********is apply tree********/
    if(ModelStereoTypeHelper.isApplyModel_Tree(ownerClass)){
    importManager.addImport("com.jeefuse.base.modules.json.FlexidTreeGridJsonWriter");
    importManager.addImport("com.jeefuse.base.modules.tree.renders.generic.TreeNodeGeneric");
    stringBuffer.append(TEXT_14);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(curPropertyComment);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(curPropertyCapName);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(resultMsgJsonWriterByPropertyClassName);
    stringBuffer.append(TEXT_19);
    }
    stringBuffer.append(TEXT_20);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(curPropertyComment);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(curPropertyCapName);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(flexiGridJsonWriterByPropertyClassName);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(curPropertyComment);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(curPropertyCapName);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(curPropertyCapName);
    stringBuffer.append(TEXT_31);
    /********is apply tree********/
    if(ModelStereoTypeHelper.isApplyModel_Tree(ownerClass)){
    
// model treeGridJsonWriter By Property
ClassNameDefineByPropertyCommon treeGridJsonWriterByProperty=clazzByPropertyWrap.getNameDefineTreeGridJsonWriterByProperty();
String treeGridJsonWriterByPropertyQualifiedName=treeGridJsonWriterByProperty.getClassQualifiedName();
String treeGridJsonWriterByPropertyClassName=treeGridJsonWriterByProperty.getClassName();
importManager.addImport(treeGridJsonWriterByPropertyQualifiedName);

    stringBuffer.append(TEXT_32);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(curPropertyComment);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(curPropertyCapName);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(treeGridJsonWriterByPropertyClassName);
    stringBuffer.append(TEXT_38);
    }
    stringBuffer.append(TEXT_39);
    importStringBuffer.insert(importInsertionPoint, importManager.computeSortedImports());
    return stringBuffer.toString();
  }
}
