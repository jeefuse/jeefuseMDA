package com.jeefuse.mda.gen.template.main.java.entity.validate;

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

public class EntityValidate
{
  protected static String nl;
  public static synchronized EntityValidate create(String lineSeparator)
  {
    nl = lineSeparator;
    EntityValidate result = new EntityValidate();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "/*" + NL + " * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the \"License\")" + NL + " * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms." + NL + " * email:yonclv@gmail.com" + NL + " */" + NL + "package ";
  protected final String TEXT_3 = ";";
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = NL + "/**" + NL + " * ";
  protected final String TEXT_6 = "  validate." + NL + " *" + NL + " * @author ";
  protected final String TEXT_7 = NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_8 = " {" + NL + "" + NL + "\tprivate static ClassValidator<";
  protected final String TEXT_9 = "> classValidator = new ClassValidator<";
  protected final String TEXT_10 = ">(";
  protected final String TEXT_11 = ".class);" + NL + "" + NL + "\t/**" + NL + "\t * 验证User对象,返回约束违反错误集合." + NL + "\t * " + NL + "\t */" + NL + "\tstatic public InvalidValue[] validate(";
  protected final String TEXT_12 = " ";
  protected final String TEXT_13 = ") {" + NL + "\t\tInvalidValue[] invalidValues = classValidator.getInvalidValues(";
  protected final String TEXT_14 = ");" + NL + "\t\treturn invalidValues;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * 验证[";
  protected final String TEXT_15 = "]对象,若出现约束违反错误则抛出ValidateViolationException异常." + NL + "\t * " + NL + "\t */" + NL + "\tstatic public void validateWithException(";
  protected final String TEXT_16 = " ";
  protected final String TEXT_17 = ") throws ValidateViolationException {" + NL + "\t\tInvalidValue[] invalidValues = validate(";
  protected final String TEXT_18 = ");" + NL + "\t\tif (invalidValues.length > 0) {" + NL + "\t\t\tList<String> errors = new ArrayList<String>();" + NL + "\t\t\tfor (InvalidValue invalidValue : invalidValues) {" + NL + "\t\t\t\t";
  protected final String TEXT_19 = " ";
  protected final String TEXT_20 = " = ";
  protected final String TEXT_21 = ".valueOfFieldName(invalidValue.getPropertyName());" + NL + "\t\t\t\tif (null != ";
  protected final String TEXT_22 = ") {" + NL + "\t\t\t\t\terrors.add(";
  protected final String TEXT_23 = ".getFieldLabel() + \": \" + invalidValue.getMessage());" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\terrors.add(invalidValue.getMessage());" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\tthrow new ValidateViolationException(errors);" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * 验证[";
  protected final String TEXT_24 = "]对象属性,返回约束违反集合." + NL + "\t * " + NL + "\t */" + NL + "\tstatic public InvalidValue[] validateProperty(";
  protected final String TEXT_25 = " ";
  protected final String TEXT_26 = ", ";
  protected final String TEXT_27 = " ";
  protected final String TEXT_28 = ") {" + NL + "\t\tInvalidValue[] invalidValues = classValidator.getInvalidValues(";
  protected final String TEXT_29 = ", ";
  protected final String TEXT_30 = ".getFieldName());" + NL + "\t\treturn invalidValues;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * 验证[";
  protected final String TEXT_31 = "]对象属性,若出现异常则抛出ValidateViolationException异常." + NL + "\t * " + NL + "\t */" + NL + "\tstatic public void validatePropertyWithException(";
  protected final String TEXT_32 = " ";
  protected final String TEXT_33 = ", ";
  protected final String TEXT_34 = " ";
  protected final String TEXT_35 = ") throws ValidateViolationException {" + NL + "\t\tInvalidValue[] invalidValues = validateProperty(";
  protected final String TEXT_36 = ", ";
  protected final String TEXT_37 = ");" + NL + "\t\tif (invalidValues.length > 0) {" + NL + "\t\t\tList<String> errors = new ArrayList<String>();" + NL + "\t\t\tfor (InvalidValue invalidValue : invalidValues) {" + NL + "\t\t\t\terrors.add(";
  protected final String TEXT_38 = ".getFieldLabel() + \": \" + invalidValue.getMessage());" + NL + "\t\t\t}" + NL + "\t\t\tthrow new ValidateViolationException(errors);" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * 获取[";
  protected final String TEXT_39 = "]验证失败信息." + NL + "\t */" + NL + "\tstatic public String getValidateMessage(InvalidValue[] invalidValues, String newLineChar) {" + NL + "\t\tif (invalidValues.length > 0) {" + NL + "\t\t\tStringBuilder sb = new StringBuilder();" + NL + "\t\t\tfor (InvalidValue invalidValue : invalidValues) {" + NL + "\t\t\t\t";
  protected final String TEXT_40 = " ";
  protected final String TEXT_41 = " = ";
  protected final String TEXT_42 = ".valueOfFieldName(invalidValue.getPropertyName());" + NL + "\t\t\t\tif (null != ";
  protected final String TEXT_43 = ") {" + NL + "\t\t\t\t\tsb.append(";
  protected final String TEXT_44 = ".getFieldLabel() + \": \" + invalidValue.getMessage());" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tsb.append(invalidValue.getMessage());" + NL + "\t\t\t\t}" + NL + "\t\t\t\tsb.append(null == newLineChar ? \"\\n\" : newLineChar);" + NL + "\t\t\t}" + NL + "\t\t\treturn sb.toString();" + NL + "\t\t}" + NL + "\t\treturn \"\";" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * 获取[";
  protected final String TEXT_45 = "]验证失败信息.设置换行符为<code><</code>br/>." + NL + "\t */" + NL + "\tpublic static String getValidateMessageWithHtmlBR(InvalidValue[] invalidValues) {" + NL + "\t\treturn getValidateMessage(invalidValues, \"<br/>\");" + NL + "\t}" + NL + "}";
  protected final String TEXT_46 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    Class uml2Class = (Class) argument;Package uml2Package = uml2Class.getPackage();
    
/*******clazz wrap********/	
UmlClassWrap clazzWrap=new UmlClassWrap(uml2Class);
String modelCommentName=clazzWrap.getCommentName();

//model validate
ClassNameDefineCommon validateDefine=clazzWrap.getNameDefineValidate();
String modelValidateDefinePackageName=validateDefine.getPackageQualifiedName();
String modelValidateDefineClassName=validateDefine.getClassCapName();


    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(modelValidateDefinePackageName);
    stringBuffer.append(TEXT_3);
    ImportManager importManager = ImportHelper.makeImportManager("");
    importManager.addImport("java.util.ArrayList");
    importManager.addImport("java.util.List");
    importManager.addImport("org.hibernate.validator.ClassValidator");
    importManager.addImport("org.hibernate.validator.InvalidValue");
    importManager.addImport("com.jeefuse.base.exception.ValidateViolationException");
    
//model entity define
ClassNameDefineCommon entityDefine=clazzWrap.getNameDefineEntity();
String modelEntityQualifiedName=entityDefine.getClassQualifiedName();
String modelEntityName=entityDefine.getClassCapName();
String modelEntityUncapName=entityDefine.getClassUncapName();
importManager.addImport(modelEntityQualifiedName);


//model field 
ClassNameDefineCommon entityFieldDefine=clazzWrap.getNameDefineEntityField();
String modelFieldQualifiedName=entityFieldDefine.getClassQualifiedName();
String modelFieldName=entityFieldDefine.getClassName();
String modelFieldUncapName=entityFieldDefine.getClassUncapName();
importManager.addImport(modelFieldQualifiedName);


    stringBuffer.append(TEXT_4);
    
StringBuffer importStringBuffer = stringBuffer;
int importInsertionPoint = stringBuffer.length();
importManager.addCompilationUnitImports(stringBuffer.toString());

    stringBuffer.append(TEXT_5);
    stringBuffer.append(modelCommentName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(System.getProperty("user.name"));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(modelValidateDefineClassName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(modelEntityUncapName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(modelEntityUncapName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(modelCommentName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(modelEntityUncapName);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(modelEntityUncapName);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(modelFieldName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(modelFieldUncapName);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(modelFieldName);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(modelFieldUncapName);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(modelFieldUncapName);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(modelCommentName);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(modelEntityUncapName);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(modelFieldName);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(modelFieldUncapName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(modelEntityUncapName);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(modelFieldUncapName);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(modelCommentName);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(modelEntityUncapName);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(modelFieldName);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(modelFieldUncapName);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(modelEntityUncapName);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(modelFieldUncapName);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(modelFieldUncapName);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(modelCommentName);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(modelFieldName);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(modelFieldUncapName);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(modelFieldName);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(modelFieldUncapName);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(modelFieldUncapName);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(modelCommentName);
    stringBuffer.append(TEXT_45);
    importStringBuffer.insert(importInsertionPoint, importManager.computeSortedImports());
    stringBuffer.append(TEXT_46);
    return stringBuffer.toString();
  }
}
