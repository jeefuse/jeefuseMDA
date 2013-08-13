package com.jeefuse.mda.gen.template.main.java.imports;

import net.taylor.mda.generator.parse.NameRuled.nameRuled.*;
import net.taylor.mda.generator.parse.NameRuled.className.*;
import net.taylor.mda.generator.parse.NameRuled.*;
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

public class EntityImportFactory
{
  protected static String nl;
  public static synchronized EntityImportFactory create(String lineSeparator)
  {
    nl = lineSeparator;
    EntityImportFactory result = new EntityImportFactory();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "/*" + NL + " * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the \"License\")" + NL + " * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms." + NL + " * email:yonclv@gmail.com" + NL + " */" + NL + "package ";
  protected final String TEXT_3 = ";";
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * ";
  protected final String TEXT_6 = " 数据导入工厂." + NL + " *" + NL + " * @author ";
  protected final String TEXT_7 = NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_8 = " {";
  protected final String TEXT_9 = NL + "\tpublic static final String ";
  protected final String TEXT_10 = " = \"";
  protected final String TEXT_11 = "\";" + NL + "\tpublic static final String ";
  protected final String TEXT_12 = " =  ";
  protected final String TEXT_13 = ".class.getResource(\"\").getPath();" + NL + "\tpublic static final String ";
  protected final String TEXT_14 = " = ";
  protected final String TEXT_15 = "+ ";
  protected final String TEXT_16 = ";" + NL + "\tpublic static final String ";
  protected final String TEXT_17 = " = \"";
  protected final String TEXT_18 = "\";" + NL + "\t" + NL + "\t/**" + NL + "\t * excel文件流转化为 ";
  protected final String TEXT_19 = " List." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static List<";
  protected final String TEXT_20 = "> excelToModel(InputStream is) throws IOException {" + NL + "\t\t";
  protected final String TEXT_21 = " excelImport = new ";
  protected final String TEXT_22 = "(is);" + NL + "\t\tList<";
  protected final String TEXT_23 = "> importList = excelImport.importToModel();" + NL + "\t\treturn importList;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * excel文件导入." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static List<";
  protected final String TEXT_24 = "> excelToModel(File file) throws IOException {" + NL + "\t\tInputStream fis = new FileInputStream(file);" + NL + "\t\treturn excelToModel(fis);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * 创建Excel导入文件模板." + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static synchronized File createExcelImportTemplateFile(String filePath,boolean isRecreate) {" + NL + "\t\tFile file = new File(filePath);" + NL + "\t\tif (!file.exists() || isRecreate) {" + NL + "\t\t\tOutputStream fileOS = null;" + NL + "\t\t\ttry {" + NL + "\t\t\t\tfileOS = new FileOutputStream(file);" + NL + "\t\t\t\tModelImportFactory.outExcelImportTemplateStream(fileOS, ";
  protected final String TEXT_25 = ".values()," + NL + "\t\t\t\t\t\t";
  protected final String TEXT_26 = ");" + NL + "\t\t\t\tfileOS.flush();" + NL + "\t\t\t} catch (IOException e) {" + NL + "\t\t\t\te.printStackTrace();" + NL + "\t\t\t} finally {" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\tif (null != fileOS) {" + NL + "\t\t\t\t\t\tfileOS.close();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t} catch (IOException e) {" + NL + "\t\t\t\t\te.printStackTrace();" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn file;" + NL + "\t}" + NL + "" + NL + "" + NL + "\t/**" + NL + "\t * 获取Excel导入文件模板." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static File getExcelImportTemplateFile() {" + NL + "\t\tFile file = new File(";
  protected final String TEXT_27 = ");" + NL + "\t\treturn file;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * 测试创建Excel导入文件模板." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static void main(String[] args) throws IOException {" + NL + "\t\t// create excel import file template" + NL + "\t\tFile file = createExcelImportTemplateFile(";
  protected final String TEXT_28 = ", false);" + NL + "\t\tSystem.out.println(\"file is exists:\" + file.exists() + \" filePath:\" + file.getAbsolutePath());" + NL + "" + NL + "\t\t// excute import excel File to model" + NL + "\t\tList<";
  protected final String TEXT_29 = "> ";
  protected final String TEXT_30 = "List = excelToModel(file);" + NL + "\t\tSystem.out.println(\"imports ";
  protected final String TEXT_31 = " size:\" + ";
  protected final String TEXT_32 = "List.size());" + NL + "\t}" + NL + "" + NL + "}";
  protected final String TEXT_33 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    Class uml2Class = (Class) argument;Package uml2Package = uml2Class.getPackage();
    
/*******clazz wrap********/	
UmlClassWrap clazzWrap=new UmlClassWrap(uml2Class);
String modelCommentName=clazzWrap.getCommentName();

//model importFactory
ClassNameDefineCommon importFactoryDefine=clazzWrap.getNameDefineImportFactory();
String modelImportFactoryPackageName=importFactoryDefine.getPackageQualifiedName();
String modelImportFactoryClassName=importFactoryDefine.getClassCapName();


    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(modelImportFactoryPackageName);
    stringBuffer.append(TEXT_3);
    ImportManager importManager = ImportHelper.makeImportManager("");
    stringBuffer.append(TEXT_4);
    
//add imports
importManager.addImport("java.util.List");
importManager.addImport("java.io.InputStream");
importManager.addImport("java.io.File");
importManager.addImport("java.io.FileInputStream");
importManager.addImport("java.io.FileOutputStream");
importManager.addImport("java.io.IOException");
importManager.addImport("java.io.OutputStream");
importManager.addImport("com.jeefuse.base.modules.imports.ModelImportFactory");

//model excelImport
ClassNameDefineCommon imprtExcelDefine=clazzWrap.getNameDefineImportExcel();
String modelExcelImportQualifiedName=imprtExcelDefine.getClassQualifiedName();
String modelExcelImportClassName=imprtExcelDefine.getClassCapName();
importManager.addImport(modelExcelImportQualifiedName);

//model entity define
ClassNameDefineCommon entityDefine=clazzWrap.getNameDefineEntity();
String modelEntityQualifiedName=entityDefine.getClassQualifiedName();
String modelEntityName=entityDefine.getClassCapName();
String modelEntityUncapName=entityDefine.getClassUncapName();
importManager.addImport(modelEntityQualifiedName);

//model field 
ClassNameDefineCommon entityFieldDefine=clazzWrap.getNameDefineEntityField();
String modelFieldQualifiedName=entityFieldDefine.getClassQualifiedName();
String modelFieldClassName=entityFieldDefine.getClassName();
importManager.addImport(modelFieldQualifiedName);



    
StringBuffer importStringBuffer = stringBuffer;
int importInsertionPoint = stringBuffer.length();
importManager.addCompilationUnitImports(stringBuffer.toString());

    stringBuffer.append(TEXT_5);
    stringBuffer.append(modelCommentName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(System.getProperty("user.name"));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(modelImportFactoryClassName);
    stringBuffer.append(TEXT_8);
    	String modelExcelImportTemplateFileName=clazzWrap.getNamedRuleProperty(PropertyNamedRuleKind.ExcelImportTemplateFileName);
    	//String modelExcelImportTemplateFileNameValue=clazzWrap.getNamedRuleProperty(PropertyNamedRuleKind.ExcelImportTemplateFileNameValue);
    	String modelExcelImportTemplateFileNameValue=modelCommentName+"导入Excel模板文件.xml";
    	String modelExcelImportTemplateDir=clazzWrap.getNamedRuleProperty(PropertyNamedRuleKind.ExcelImportTemplateDir);
    	String modelExcelImportTemplateFilePath=clazzWrap.getNamedRuleProperty(PropertyNamedRuleKind.ExcelImportTemplateFilePath);
    	String modelExcelImportTemplateCaption=clazzWrap.getNamedRuleProperty(PropertyNamedRuleKind.ExcelImportTemplateCaption);
    	String modelExcelImportTemplateCaptionValue=modelCommentName+"数据Excel导入";
    stringBuffer.append(TEXT_9);
    stringBuffer.append(modelExcelImportTemplateFileName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(modelExcelImportTemplateFileNameValue);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(modelExcelImportTemplateDir);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(modelImportFactoryClassName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(modelExcelImportTemplateFilePath);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(modelExcelImportTemplateDir);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(modelExcelImportTemplateFileName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(modelExcelImportTemplateCaption);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(modelExcelImportTemplateCaptionValue);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(modelExcelImportClassName);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(modelExcelImportClassName);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(modelFieldClassName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(modelExcelImportTemplateCaption);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(modelExcelImportTemplateFilePath);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(modelExcelImportTemplateFilePath);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(modelEntityUncapName);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(modelEntityUncapName);
    stringBuffer.append(TEXT_32);
    importStringBuffer.insert(importInsertionPoint, importManager.computeSortedImports());
    stringBuffer.append(TEXT_33);
    return stringBuffer.toString();
  }
}
