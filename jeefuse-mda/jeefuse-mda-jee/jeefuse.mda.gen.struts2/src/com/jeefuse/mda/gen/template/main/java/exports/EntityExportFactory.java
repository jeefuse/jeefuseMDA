package com.jeefuse.mda.gen.template.main.java.exports;

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

public class EntityExportFactory
{
  protected static String nl;
  public static synchronized EntityExportFactory create(String lineSeparator)
  {
    nl = lineSeparator;
    EntityExportFactory result = new EntityExportFactory();
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
  protected final String TEXT_7 = " 数据导入工厂." + NL + " *" + NL + " * @author ";
  protected final String TEXT_8 = NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_9 = " {" + NL + "\t/** @generated */" + NL + "\tprivate static final String ";
  protected final String TEXT_10 = "= \"";
  protected final String TEXT_11 = "数据Excel导出文件\";" + NL + "" + NL + "\t/** @generated */" + NL + "\tpublic static String get";
  protected final String TEXT_12 = "() {";
  protected final String TEXT_13 = NL + "\t\tDateFormat format = new SimpleDateFormat(\"yyyy-MM-dd-HH:mm\");" + NL + "\t\treturn ";
  protected final String TEXT_14 = " + format.format(new Date());" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * 导出pdf文件." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static void pdfExport(HttpServletRequest request, HttpServletResponse response, String exportFileName," + NL + "\t\t\t";
  protected final String TEXT_15 = "[] ";
  protected final String TEXT_16 = ", Collection<";
  protected final String TEXT_17 = "> items) throws Exception {" + NL + "\t\tModelExportFactory.createPdfExport(request, response, exportFileName, ";
  protected final String TEXT_18 = ", items," + NL + "\t\t\t\tnew DefaultPropertyValueGet<";
  protected final String TEXT_19 = ">()).export();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * 导出pdf文件." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static void pdfExport(HttpServletRequest request, HttpServletResponse response,";
  protected final String TEXT_20 = "[] ";
  protected final String TEXT_21 = ", Collection<";
  protected final String TEXT_22 = "> items) throws Exception {" + NL + "\t\tpdfExport(request, response, ";
  protected final String TEXT_23 = ", ";
  protected final String TEXT_24 = ", items);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * 导出";
  protected final String TEXT_25 = "所有字段数据." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static void pdfExportAllField(HttpServletRequest request, HttpServletResponse response," + NL + "\t\t\tString exportFileName, Collection<";
  protected final String TEXT_26 = "> items) throws Exception {" + NL + "\t\tpdfExport(request, response, exportFileName, ";
  protected final String TEXT_27 = ".values(), items);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * 导出excel文件." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static void excelExport(HttpServletResponse response,";
  protected final String TEXT_28 = "[] ";
  protected final String TEXT_29 = ", Collection<";
  protected final String TEXT_30 = "> items) throws Exception {" + NL + "\t\tModelExportFactory.createExcelExport(response, ";
  protected final String TEXT_31 = ", ";
  protected final String TEXT_32 = ", items, new DefaultPropertyValueGet<";
  protected final String TEXT_33 = ">())" + NL + "\t\t\t\t.export();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * 导出";
  protected final String TEXT_34 = "所有字段数据." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static void excelExportAllField(HttpServletResponse response,Collection<";
  protected final String TEXT_35 = "> items)" + NL + "\t\t\tthrows Exception {" + NL + "\t\texcelExport(response,";
  protected final String TEXT_36 = ".values(),items);" + NL + "\t}" + NL + "" + NL + "}";
  protected final String TEXT_37 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    Class uml2Class = (Class) argument;Package uml2Package = uml2Class.getPackage();
    
/*******clazz wrap********/	
UmlClassWrap clazzWrap=new UmlClassWrap(uml2Class);
String modelCommentName=clazzWrap.getCommentName();

//model exportFactory 
ClassNameDefineCommon exportFactoryDefine=clazzWrap.getNameDefineExportFactory();
String modelExportFactoryPackageName=exportFactoryDefine.getPackageQualifiedName();
String modelExportFactoryClassName=exportFactoryDefine.getClassName();


    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(modelExportFactoryPackageName);
    stringBuffer.append(TEXT_3);
    ImportManager importManager = ImportHelper.makeImportManager("");
    importManager.addImport("java.util.Collection");
    importManager.addImport("javax.servlet.http.HttpServletRequest");
    importManager.addImport("javax.servlet.http.HttpServletResponse");
    importManager.addImport("com.jeefuse.base.modules.export.ModelExportFactory");
    importManager.addImport("com.jeefuse.base.model.parse.DefaultPropertyValueGet");
    stringBuffer.append(TEXT_4);
    
//model entity define
ClassNameDefineCommon entityDefine=clazzWrap.getNameDefineEntity();
String modelEntityQualifiedName=entityDefine.getClassQualifiedName();
String modelEntityName=entityDefine.getClassCapName();
importManager.addImport(modelEntityQualifiedName);

//model service define
ClassNameDefineCommon serviceDefine=clazzWrap.getNameDefineService();
String modelServiceQualifiedName=serviceDefine.getClassQualifiedName();
importManager.addImport(modelServiceQualifiedName);

//model field 
ClassNameDefineCommon entityFieldDefine=clazzWrap.getNameDefineEntityField();
String modelFieldQualifiedName=entityFieldDefine.getClassQualifiedName();
String modelFieldName=entityFieldDefine.getClassCapName();
String modelFieldUncapName=entityFieldDefine.getClassUncapName();
importManager.addImport(modelFieldQualifiedName);

//model propertyValueGet
//ClassNameDefineCommon entityPropertyValueGetDefine=clazzWrap.getNameDefineEntityPropertyValueGet();
//String modelPropertyValueGetQualifiedName=entityPropertyValueGetDefine.getClassQualifiedName();
//String modelPropertyValueGetClassName=entityPropertyValueGetDefine.getClassCapName();
//importManager.addImport(modelPropertyValueGetQualifiedName);

//model excel export file name
String ExcelExportTemplateFileCapName=clazzWrap.getNamedRuleProperty(PropertyNamedRuleKind.ExcelExportTemplateFileName);
String ExcelExportTemplateFileUncapName=clazzWrap.getNamedRuleProperty(PropertyNamedRuleKind.ExcelExportTemplateFileName);


    stringBuffer.append(TEXT_5);
    
StringBuffer importStringBuffer = stringBuffer;
int importInsertionPoint = stringBuffer.length();
importManager.addCompilationUnitImports(stringBuffer.toString());

    stringBuffer.append(TEXT_6);
    stringBuffer.append(modelCommentName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(System.getProperty("user.name"));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(modelExportFactoryClassName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(ExcelExportTemplateFileUncapName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(modelCommentName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(ExcelExportTemplateFileCapName);
    stringBuffer.append(TEXT_12);
    //importManager.addImport("com.jeefuse.base.utils.common.DateUtil");
    importManager.addImport("java.text.DateFormat");
    importManager.addImport("java.text.SimpleDateFormat");
    importManager.addImport("java.util.Date");
    stringBuffer.append(TEXT_13);
    stringBuffer.append(ExcelExportTemplateFileUncapName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(modelFieldName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(modelFieldUncapName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(modelFieldUncapName);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(modelFieldName);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(modelFieldUncapName);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(ExcelExportTemplateFileUncapName);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(modelFieldUncapName);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(modelCommentName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(modelFieldName);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(modelFieldName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(modelFieldUncapName);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(ExcelExportTemplateFileUncapName);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(modelFieldUncapName);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(modelCommentName);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(modelFieldName);
    stringBuffer.append(TEXT_36);
    importStringBuffer.insert(importInsertionPoint, importManager.computeSortedImports());
    stringBuffer.append(TEXT_37);
    return stringBuffer.toString();
  }
}
