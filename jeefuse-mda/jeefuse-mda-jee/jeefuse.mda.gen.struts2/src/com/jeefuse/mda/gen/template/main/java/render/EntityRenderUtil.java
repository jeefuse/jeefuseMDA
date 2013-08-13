package com.jeefuse.mda.gen.template.main.java.render;

import net.taylor.mda.generator.parse.NameRuled.className.*;
import net.taylor.mda.generator.parse.NameRuled.*;
import net.taylor.mda.generator.parse.stereotype.*;
import java.util.List;
import net.taylor.mda.generator.parse.*;
import net.taylor.mda.generator.parse.entity.*;
import java.util.Iterator;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.*;
import net.taylor.mda.generator.util.*;
import org.eclipse.emf.codegen.util.*;

public class EntityRenderUtil
{
  protected static String nl;
  public static synchronized EntityRenderUtil create(String lineSeparator)
  {
    nl = lineSeparator;
    EntityRenderUtil result = new EntityRenderUtil();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "/*" + NL + " * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the \"License\")" + NL + " * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms." + NL + " * email:yonclv@gmail.com" + NL + " */" + NL + "package ";
  protected final String TEXT_2 = ";" + NL;
  protected final String TEXT_3 = NL + NL + "/**" + NL + " * ";
  protected final String TEXT_4 = " render util." + NL + " * " + NL + " * @author ";
  protected final String TEXT_5 = NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = "  {" + NL + "" + NL + "\t/**" + NL + "\t * 输出 ";
  protected final String TEXT_7 = " ResultMsg json对象格式数据." + NL + "\t * @generated" + NL + "\t */" + NL + "\tstatic public void jsonResultMsg(boolean success, ";
  protected final String TEXT_8 = " model, String message) {" + NL + "\t\tResultJsonWriter<";
  protected final String TEXT_9 = "> jsonWriter=new ";
  protected final String TEXT_10 = "(success, model, message);" + NL + "\t\tRenderUtil.renderJson(jsonWriter);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * 输出";
  protected final String TEXT_11 = " FlexiGrid json对象格式数据." + NL + "\t * @generated" + NL + "\t */" + NL + "\tstatic public void jsonFlexiGrid(int pageNo, long total, List<";
  protected final String TEXT_12 = "> items) {" + NL + "\t\tFlexidGridJsonWriter<";
  protected final String TEXT_13 = "> jsonWriter = new ";
  protected final String TEXT_14 = "(pageNo, total, items);" + NL + "\t\tRenderUtil.renderJson(jsonWriter);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * 输出";
  protected final String TEXT_15 = " FlexiGrid json对象格式数据." + NL + "\t * @generated" + NL + "\t */" + NL + "\tstatic public void jsonFlexiGrid(Page<";
  protected final String TEXT_16 = "> page) {" + NL + "\t\tjsonFlexiGrid(page.getPageNo(), page.getTotalCount(), page.getResult());" + NL + "\t}" + NL + "\t";
  protected final String TEXT_17 = NL + "\t/**" + NL + "\t * 输出";
  protected final String TEXT_18 = " FlexiTreeGrid json对象格式数据." + NL + "\t * " + NL + "\t */" + NL + "\tpublic static void jsonFlexiTreeGrid(long totalCount, List<";
  protected final String TEXT_19 = "> items) {" + NL + "\t\tTreeNodeGeneric<";
  protected final String TEXT_20 = "> treeNode = TreeNodeGenericConstructUtil.constructTreeNode(items);" + NL + "\t\tJsonWriter jsonWriter = new ";
  protected final String TEXT_21 = "(treeNode.getChildrens(), totalCount);" + NL + "\t\tRenderUtil.renderJson(jsonWriter);" + NL + "\t}";
  protected final String TEXT_22 = NL;
  protected final String TEXT_23 = NL + "\t/**" + NL + "\t * 输出 ";
  protected final String TEXT_24 = " ResultMsg json对象格式数据." + NL + "\t * @generated" + NL + "\t */" + NL + "\tstatic public void htmlResultMsg(boolean success, ";
  protected final String TEXT_25 = " model, String message) {" + NL + "\t\tResultJsonWriter<";
  protected final String TEXT_26 = "> jsonWriter=new ";
  protected final String TEXT_27 = "(success, model, message);" + NL + "\t\tRenderUtil.renderHtml(jsonWriter);" + NL + "\t}";
  protected final String TEXT_28 = NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    Class uml2Class = (Class) argument;Package uml2Package = uml2Class.getPackage();
    
/*******clazz wrap********/	
UmlClassWrap clazzWrap=new UmlClassWrap(uml2Class);

// model RenderUtil define
ClassNameDefineCommon renderUtilDefine=clazzWrap.getNameDefineRenderUtil();
String modelRenderUtilPackageName=renderUtilDefine.getPackageQualifiedName();
String modelRenderUtilClassName=renderUtilDefine.getClassCapName();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(modelRenderUtilPackageName);
    stringBuffer.append(TEXT_2);
    ImportManager importManager = ImportHelper.makeImportManager("");
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
//String modelEntityUncapName=entityDefine.getClassUncapName();
importManager.addImport(modelEntityQualifiedName);


//model FlexiGridJsonWrite define
ClassNameDefineCommon flexiGridJsonWriteDefine=clazzWrap.getNameDefineFlexiGridJsonWrite();
String flexiGridJsonWriteQualifiedName=flexiGridJsonWriteDefine.getClassQualifiedName();
String flexiGridJsonWriteClassName=flexiGridJsonWriteDefine.getClassCapName();
//String flexiGridJsonWriteClassUncapName=flexiGridJsonWriteDefine.getClassCapName();
importManager.addImport(flexiGridJsonWriteQualifiedName);

// model ResultJsonWrite define
ClassNameDefineCommon resultMsgJsonWriterDefine=clazzWrap.getNameDefineResultMsgJsonWriter();
String resultMsgJsonWriterQualifiedName=resultMsgJsonWriterDefine.getClassQualifiedName();
String resultMsgJsonWriterClassName=resultMsgJsonWriterDefine.getClassCapName();
//String resultMsgJsonWriterClassUncapName=resultMsgJsonWriterDefine.getClassCapName();
importManager.addImport(resultMsgJsonWriterQualifiedName);

    
StringBuffer importStringBuffer = stringBuffer;
int importInsertionPoint = stringBuffer.length();
importManager.addCompilationUnitImports(stringBuffer.toString());

    stringBuffer.append(TEXT_3);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(System.getProperty("user.name"));
    stringBuffer.append(TEXT_5);
    stringBuffer.append(modelRenderUtilClassName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(resultMsgJsonWriterClassName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(flexiGridJsonWriteClassName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_16);
    /********is apply tree********/
    if(ModelStereoTypeHelper.isApplyModel_Tree(uml2Class)){
    importManager.addImport("com.jeefuse.base.modules.tree.renders.generic.TreeNodeGenericConstructUtil");
    importManager.addImport("com.jeefuse.base.modules.tree.renders.generic.TreeNodeGeneric");
    importManager.addImport("com.jeefuse.base.modules.json.JsonWriter");
    
// model FlexiGridJsonWrite
String modelQualifiedNameForTreeGridJsonWriter=MdaHelper.getModelQualifiedName(uml2Class,PKGSuffix.TreeGridJsonWriter,ModelNameSuffix.TreeGridJsonWriter);
String modelClassNameForTreeGridJsonWriter=MdaHelper.getModelClassName(uml2Class,ModelNameSuffix.TreeGridJsonWriter);
importManager.addImport(modelQualifiedNameForTreeGridJsonWriter);

    stringBuffer.append(TEXT_17);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(modelClassNameForTreeGridJsonWriter);
    stringBuffer.append(TEXT_21);
    }
    stringBuffer.append(TEXT_22);
    if(FileStereotypeHelper.isClass_file(uml2Class)||FileStereotypeHelper.isClass_Image(uml2Class)){//应用了File or Image
    stringBuffer.append(TEXT_23);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(resultMsgJsonWriterClassName);
    stringBuffer.append(TEXT_27);
    }
    stringBuffer.append(TEXT_28);
    importStringBuffer.insert(importInsertionPoint, importManager.computeSortedImports());
    return stringBuffer.toString();
  }
}
