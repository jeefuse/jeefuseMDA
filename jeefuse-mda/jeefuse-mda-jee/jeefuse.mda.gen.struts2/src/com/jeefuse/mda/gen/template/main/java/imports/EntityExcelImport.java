package com.jeefuse.mda.gen.template.main.java.imports;

import net.taylor.mda.generator.parse.NameRuled.className.*;
import net.taylor.mda.generator.parse.NameRuled.*;
import java.util.ArrayList;
import net.taylor.mda.generator.parse.entity.*;
import net.taylor.mda.generator.parse.*;
import java.util.Iterator;
import java.util.List;
import net.taylor.mda.generator.parse.entity.*;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.*;
import net.taylor.mda.generator.util.*;
import org.eclipse.emf.codegen.util.*;

public class EntityExcelImport
{
  protected static String nl;
  public static synchronized EntityExcelImport create(String lineSeparator)
  {
    nl = lineSeparator;
    EntityExcelImport result = new EntityExcelImport();
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
  protected final String TEXT_7 = " excel导入." + NL + " *" + NL + " * @author ";
  protected final String TEXT_8 = NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_9 = " extends ";
  protected final String TEXT_10 = "<";
  protected final String TEXT_11 = ">{" + NL + "" + NL + "\t/**" + NL + "\t * construct ";
  protected final String TEXT_12 = " with inputStream." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_13 = "(InputStream is) throws IOException {" + NL + "\t\tsuper(is);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * populate model." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\t@Override" + NL + "\tprotected ";
  protected final String TEXT_14 = " readExcelToModel(Row row, String[] columnNames) {" + NL + "\t\tif (row == null)" + NL + "\t\t\treturn null;" + NL + "\t\t";
  protected final String TEXT_15 = " model = new ";
  protected final String TEXT_16 = "();" + NL + "\t\tint cellLenght = columnNames.length;" + NL + "\t\tCell cell = null;" + NL + "\t\tfor (int i = 0; i < cellLenght; i++) {" + NL + "\t\t\tcell = row.getCell(i);" + NL + "\t\t\tString columnName = columnNames[i];";
  protected final String TEXT_17 = NL + "\t\t\t";
  protected final String TEXT_18 = " ";
  protected final String TEXT_19 = " = ";
  protected final String TEXT_20 = ".valueOfFieldLabel(columnName);" + NL + "\t\t\tif (null == ";
  protected final String TEXT_21 = ") {" + NL + "\t\t\t\t";
  protected final String TEXT_22 = " = ";
  protected final String TEXT_23 = ".valueOfFieldName(columnName);" + NL + "\t\t\t}" + NL + "\t\t\tif (null == ";
  protected final String TEXT_24 = ")" + NL + "\t\t\t\tthrow new DataNoExistException(\"无效例名:\" + columnName);" + NL + "\t\t\tsetModelData(model, cell, ";
  protected final String TEXT_25 = ");" + NL + "\t\t\tInvalidValue[] invalidValues = ";
  protected final String TEXT_26 = ".validateProperty(model, ";
  protected final String TEXT_27 = ");" + NL + "\t\t\tif (invalidValues.length > 0) {" + NL + "\t\t\t\tList<String> errors = new ArrayList<String>();" + NL + "\t\t\t\tfor (InvalidValue invalidValue : invalidValues) {" + NL + "\t\t\t\t\terrors.add(";
  protected final String TEXT_28 = ".getFieldLabel() + \": \" + invalidValue.getMessage());" + NL + "\t\t\t\t}" + NL + "\t\t\t\tthrow new ValidateViolationException(\"第\" + (cell.getRowIndex() + 1) + \"行,第\"" + NL + "\t\t\t\t\t\t+ (cell.getColumnIndex() + 1) + \"例输入错误!\", errors);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn model;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * populate model property value." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void setModelData(";
  protected final String TEXT_29 = " model, Cell cell, ";
  protected final String TEXT_30 = " ";
  protected final String TEXT_31 = ") {" + NL + "\t\tswitch (";
  protected final String TEXT_32 = ") {";
  protected final String TEXT_33 = NL + "\t\tcase ";
  protected final String TEXT_34 = ":";
  protected final String TEXT_35 = NL + "\t\t\t";
  protected final String TEXT_36 = " ";
  protected final String TEXT_37 = " = ";
  protected final String TEXT_38 = ".valueOfLabel(ExcelCheck.";
  protected final String TEXT_39 = "(cell));" + NL + "\t\t\tif (null != ";
  protected final String TEXT_40 = ") {" + NL + "\t\t\t\tmodel.set";
  protected final String TEXT_41 = "(";
  protected final String TEXT_42 = ".getKey());//";
  protected final String TEXT_43 = " ";
  protected final String TEXT_44 = NL + "\t\t\t} else {" + NL + "\t\t\t\tmodel.set";
  protected final String TEXT_45 = "(null);" + NL + "\t\t\t}";
  protected final String TEXT_46 = NL + "\t\t\t model.set";
  protected final String TEXT_47 = "(ExcelCheck.";
  protected final String TEXT_48 = "(cell));//";
  protected final String TEXT_49 = " ";
  protected final String TEXT_50 = NL + "\t\t\t break;";
  protected final String TEXT_51 = "\t" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "}";
  protected final String TEXT_52 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    Class uml2Class = (Class) argument;Package uml2Package = uml2Class.getPackage();
    
/*******clazz wrap********/	
UmlClassWrap clazzWrap=new UmlClassWrap(uml2Class);
String modelCommentName=clazzWrap.getCommentName();

//model excelImport define
ClassNameDefineCommon importExcel=clazzWrap.getNameDefineImportExcel();
String modelExcelImportPackageName=importExcel.getPackageQualifiedName();
String modelExcelImportClassName=importExcel.getClassCapName();


    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(modelExcelImportPackageName);
    stringBuffer.append(TEXT_3);
    ImportManager importManager = ImportHelper.makeImportManager("");
    stringBuffer.append(TEXT_4);
    
//add imports
importManager.addImport("java.io.IOException");
importManager.addImport("java.io.InputStream");
importManager.addImport("org.apache.poi.ss.usermodel.Cell");
importManager.addImport("org.apache.poi.ss.usermodel.Row");
//add custom imports
importManager.addImport(Config.base_ExcelCheck);
importManager.addImport(Config.base_AbstractModelExcelImport);
importManager.addImport(Config.base_Exception_DataNoExistException);
//Abastract Model Excel ClassName
String base_AbastractModelExcelClassName=MdaHelper.getBriefClassName(Config.base_AbstractModelExcelImport);


//model validate
ClassNameDefineCommon validateDefine=clazzWrap.getNameDefineValidate();
//String modelValidateDefinePackageName=validateDefine.getPackageQualifiedName();
String modelValidateDefineClassName=validateDefine.getClassCapName();
String modelValidateDefineClassQualifiedName=validateDefine.getClassQualifiedName();
importManager.addImport(modelValidateDefineClassQualifiedName);


//model field 
ClassNameDefineCommon entityFieldDefine=clazzWrap.getNameDefineEntityField();
String modelFieldQualifiedName=entityFieldDefine.getClassQualifiedName();
String modelFieldName=entityFieldDefine.getClassName();
String modelFieldUncapName=entityFieldDefine.getClassUncapName();
importManager.addImport(modelFieldQualifiedName);


//model entity define
ClassNameDefineCommon entityDefine=clazzWrap.getNameDefineEntity();
String modelEntityQualifiedName=entityDefine.getClassQualifiedName();
String modelEntityName=entityDefine.getClassCapName();
importManager.addImport(modelEntityQualifiedName);


    stringBuffer.append(TEXT_5);
    
StringBuffer importStringBuffer = stringBuffer;
int importInsertionPoint = stringBuffer.length();
importManager.addCompilationUnitImports(stringBuffer.toString());

    stringBuffer.append(TEXT_6);
    stringBuffer.append(modelCommentName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(System.getProperty("user.name"));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(modelExcelImportClassName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(base_AbastractModelExcelClassName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(modelExcelImportClassName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(modelExcelImportClassName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_16);
    importManager.addImport("java.util.ArrayList");
    importManager.addImport("java.util.List");
    importManager.addImport("org.hibernate.validator.InvalidValue");
    importManager.addImport("com.jeefuse.base.exception.ValidateViolationException");
    stringBuffer.append(TEXT_17);
    stringBuffer.append(modelFieldName);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(modelFieldUncapName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(modelFieldName);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(modelFieldUncapName);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(modelFieldUncapName);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(modelFieldName);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(modelFieldUncapName);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(modelFieldUncapName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(modelValidateDefineClassName);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(modelFieldUncapName);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(modelFieldUncapName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(modelFieldName);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(modelFieldUncapName);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(modelFieldUncapName);
    stringBuffer.append(TEXT_32);
    List<Property> listProperty=ClassHelper.getAllSimplePropertiesList(uml2Class,new ArrayList<Property>());int propertyCount=1;
    for (Iterator<Property> i=listProperty.iterator(); i.hasNext();) { Property property = (Property)i.next();
    	if (property.getType() !=null) {
    		//String propertyUncapSafeName=NameHelper.uncapSafeName(property);
      	//String propertyGetAccessor=ClassHelper.getGetAccessor(property);
    		String propretyGetAccessorName=ClassHelper.getAccessorName(property);
      	String propertyCommentName=TypeHelper.getDocumentationOrName(property);
    		Enumeration enumeration=EnumKindHelper.getAppliedEnumKindEnumeration(property);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(NameHelper.uncapSafeName(property));
    stringBuffer.append(TEXT_34);
    		if(null!=enumeration){
    			String modelEnumQualifiedName=MdaHelper.getModelQualifiedName(enumeration,PKGSuffix.enumeration,ModelNameSuffix.enumeration);
    			String modelEnumName=MdaHelper.getModelClassName(enumeration,ModelNameSuffix.enumeration);
    			String modelEnumNameUncap=NameHelper.uncapName(modelEnumName);
    			importManager.addImport(modelEnumQualifiedName);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(modelEnumName);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(modelEnumNameUncap);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(modelEnumName);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(ExcelImportHelper.getExcelCheckString(property.getType()));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(modelEnumNameUncap);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(propretyGetAccessorName);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(modelEnumNameUncap);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(propertyCount++);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(propretyGetAccessorName);
    stringBuffer.append(TEXT_45);
    		}else{
    stringBuffer.append(TEXT_46);
    stringBuffer.append(propretyGetAccessorName);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(ExcelImportHelper.getExcelCheckString(property.getType()));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(propertyCount++);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(propertyCommentName);
    		}
    stringBuffer.append(TEXT_50);
    }}
    stringBuffer.append(TEXT_51);
    importStringBuffer.insert(importInsertionPoint, importManager.computeSortedImports());
    stringBuffer.append(TEXT_52);
    return stringBuffer.toString();
  }
}
