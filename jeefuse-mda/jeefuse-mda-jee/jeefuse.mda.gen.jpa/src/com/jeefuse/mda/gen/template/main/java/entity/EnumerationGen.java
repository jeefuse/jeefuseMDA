package com.jeefuse.mda.gen.template.main.java.entity;

import net.taylor.mda.generator.parse.stereotype.*;
import net.taylor.mda.generator.parse.entity.*;
import net.taylor.mda.generator.parse.*;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.*;
import java.util.*;
import net.taylor.mda.generator.util.*;
import org.eclipse.emf.codegen.util.*;

public class EnumerationGen
{
  protected static String nl;
  public static synchronized EnumerationGen create(String lineSeparator)
  {
    nl = lineSeparator;
    EnumerationGen result = new EnumerationGen();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "/*" + NL + " * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the \"License\")" + NL + " * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms." + NL + " * email:yonclv@gmail.com" + NL + " */";
  protected final String TEXT_3 = NL + "package ";
  protected final String TEXT_4 = ";";
  protected final String TEXT_5 = NL;
  protected final String TEXT_6 = NL + NL + "/**" + NL + " * ";
  protected final String TEXT_7 = NL + " *" + NL + " * @author ";
  protected final String TEXT_8 = NL + " * @generated" + NL + " */";
  protected final String TEXT_9 = NL + "public enum ";
  protected final String TEXT_10 = "  implements KeyLabel{";
  protected final String TEXT_11 = NL + "\t/**" + NL + "\t * ";
  protected final String TEXT_12 = NL + "\t * @generated" + NL + "\t */" + NL + "\t";
  protected final String TEXT_13 = "(\"";
  protected final String TEXT_14 = "\",\"";
  protected final String TEXT_15 = "\")";
  protected final String TEXT_16 = ",";
  protected final String TEXT_17 = NL + "\t;" + NL + "" + NL + "\t/** @generated */" + NL + "\tprivate ";
  protected final String TEXT_18 = "(String key, String label) {" + NL + "\t\tthis.key = key;" + NL + "\t\tthis.label = label;" + NL + "\t}" + NL + "" + NL + "\t/** @generated */" + NL + "\tprivate final String key;" + NL + "\t/** @generated */" + NL + "\tprivate final String label;" + NL + "" + NL + "\t/** @generated */" + NL + "\tpublic String getKey() {" + NL + "\t\treturn key;" + NL + "\t}" + NL + "" + NL + "\t/** @generated */" + NL + "\tpublic String getLabel() {" + NL + "\t\treturn label;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * 根据key查找对象,若没有找到则返回null." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static ";
  protected final String TEXT_19 = " valueOfKey(String key) {" + NL + "\t\tif (null == key)" + NL + "\t\t\treturn null;" + NL + "\t\tfor (";
  protected final String TEXT_20 = " item : values()) {" + NL + "\t\t\tif (item.getKey().equals(key))" + NL + "\t\t\t\treturn item;" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * 根据label查找对象,若没有找到则返回null." + NL + "\t * @generated" + NL + "\t */" + NL + "\tstatic public ";
  protected final String TEXT_21 = " valueOfLabel(String label) {" + NL + "\t\tif (null == label)" + NL + "\t\t\treturn null;" + NL + "\t\tfor (";
  protected final String TEXT_22 = " item : values()) {" + NL + "\t\t\tif (item.getLabel().equals(label))" + NL + "\t\t\t\treturn item;" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}";
  protected final String TEXT_23 = "\t";
  protected final String TEXT_24 = NL + NL + "\t/**" + NL + "\t * 转化为以key为键,label为值的Map对象." + NL + "\t * @generated" + NL + "\t */" + NL + "\tstatic public Map<String, String> toMap;" + NL + "\t/** @generated */" + NL + "\tstatic {" + NL + "\t\ttoMap = new HashMap<String, String>();" + NL + "\t\tfor (";
  protected final String TEXT_25 = " item : values()) {" + NL + "\t\t\ttoMap.put(item.getKey(), item.getLabel());" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * 转化为以key为键,label为值并渲染为Html的Map对象." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tstatic public Map<String, String> toHtmlMap;" + NL + "\t/** @generated */" + NL + "\tstatic {" + NL + "\t\ttoHtmlMap = new HashMap<String, String>();" + NL + "\t\tfor (";
  protected final String TEXT_26 = " item : values()) {" + NL + "\t\t\ttoHtmlMap.put(item.getKey(), item.renderHtml());" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * 以key为键,label为值的Map对象转化为json字符串." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tstatic public String toHtmlJSON;" + NL + "\t/** @generated */" + NL + "\tstatic {" + NL + "\t\ttry {" + NL + "\t\t\ttoHtmlJSON = JsonUtil.mapper.writeValueAsString(toHtmlMap);" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\te.printStackTrace();" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * 转化为以key为键,label为值并渲染为Html Select标签." + NL + "\t * " + NL + "\t * @param checkKey" + NL + "\t *            已选择的键值" + NL + "\t * @generated" + NL + "\t */" + NL + "\tstatic public String toHtmlSelect(String checkKey) {" + NL + "\t\tStringBuilder sb = new StringBuilder();" + NL + "\t\tfor (";
  protected final String TEXT_27 = " item : values()) {" + NL + "\t\t\tsb.append(\" <option value=\\\"\" + item.getKey() + \"\\\"\");" + NL + "\t\t\tif (null != checkKey && item.getKey().equals(checkKey)) {" + NL + "\t\t\t\tsb.append(\" selected=\\\"selected\\\" \");" + NL + "\t\t\t}" + NL + "\t\t\tsb.append(renderStyle(item));" + NL + "\t\t\tsb.append(\">\");" + NL + "\t\t\tsb.append(item.getLabel());" + NL + "\t\t\tsb.append(\"</option>\");" + NL + "\t\t}" + NL + "\t\treturn sb.toString();" + NL + "\t}" + NL + "\t";
  protected final String TEXT_28 = NL + "\t" + NL + "\t\t/** @generated */" + NL + "\tpublic String renderHtml() {" + NL + "\t\treturn getRenderFont(this).renderHtml(this.getLabel());" + NL + "\t}" + NL + "" + NL + "\t/** @generated */" + NL + "\tstatic public String renderStyle(";
  protected final String TEXT_29 = " item) {" + NL + "\t\treturn getRenderFont(item).renderStyle();" + NL + "\t}" + NL + "" + NL + "\t/** @generated */" + NL + "\tstatic private HtmlFont getRenderFont(";
  protected final String TEXT_30 = " item) {" + NL + "\t\tswitch (item) {";
  protected final String TEXT_31 = NL + "\t\t\tcase ";
  protected final String TEXT_32 = ":" + NL + "\t\t\t\treturn HtmlFont.";
  protected final String TEXT_33 = ";";
  protected final String TEXT_34 = NL + "\t\t}" + NL + "\t\treturn HtmlFont.black;" + NL + "\t}" + NL + "\t" + NL + "}";
  protected final String TEXT_35 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    Enumeration uml2Enumeration = (Enumeration) argument;Package uml2Package = uml2Enumeration.getPackage();
    
String packageName=NameHelper.getQualifiedName(uml2Package);
String modelEnumPackageName=MdaHelper.getPackageQualifiedName(uml2Enumeration,PKGSuffix.enumeration);
String modelEnumName=MdaHelper.getModelClassName(uml2Enumeration,ModelNameSuffix.enumeration);


    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    ImportManager importManager=null;
    if (packageName != null) {
    importManager = ImportHelper.makeImportManager(modelEnumPackageName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(modelEnumPackageName);
    stringBuffer.append(TEXT_4);
    }else {
    importManager = ImportHelper.makeImportManager("");
    }
    stringBuffer.append(TEXT_5);
    
StringBuffer importStringBuffer = stringBuffer;
int importInsertionPoint = stringBuffer.length();
importManager.addCompilationUnitImports(stringBuffer.toString());

    stringBuffer.append(TEXT_6);
    stringBuffer.append(TypeHelper.getDocumentation(uml2Enumeration));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(System.getProperty("user.name"));
    stringBuffer.append(TEXT_8);
    importManager.addImport("com.jeefuse.base.modules.keyLabel.KeyLabel");
    stringBuffer.append(TEXT_9);
    stringBuffer.append(modelEnumName);
    stringBuffer.append(TEXT_10);
    for (Iterator<EnumerationLiteral> l=uml2Enumeration.getOwnedLiterals().iterator(); l.hasNext();) { 
    	EnumerationLiteral enumLiteral = (EnumerationLiteral)l.next();
    	String enumLiteralName=EnumerationHelper.getEnumLiteralID(enumLiteral);
    	String enumLiteralComment=TypeHelper.getDocumentation(enumLiteral);
    	String enumLiteralValue=EnumKindLiteralStereotypeUtil.getLiteralValue(enumLiteral);
    	String enumLiteralLable=EnumKindLiteralStereotypeUtil.getLiteralLable(enumLiteral);
    	//String enumLiteralColor=EnumKindLiteralStereotypeUtil.getLiteralValue(enumLiteral);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(enumLiteralComment);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(enumLiteralName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(enumLiteralValue);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(enumLiteralLable);
    stringBuffer.append(TEXT_15);
    if (l.hasNext()) {
    stringBuffer.append(TEXT_16);
    }
    }
    stringBuffer.append(TEXT_17);
    stringBuffer.append(modelEnumName);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(modelEnumName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(modelEnumName);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(modelEnumName);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(modelEnumName);
    stringBuffer.append(TEXT_22);
    importManager.addImport("java.util.Map");
    stringBuffer.append(TEXT_23);
    importManager.addImport("java.util.HashMap");
    importManager.addImport("com.jeefuse.base.modules.json.JsonUtil");
    stringBuffer.append(TEXT_24);
    stringBuffer.append(modelEnumName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(modelEnumName);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(modelEnumName);
    stringBuffer.append(TEXT_27);
    importManager.addImport("com.jeefuse.base.web.component.font.HtmlFont");
    stringBuffer.append(TEXT_28);
    stringBuffer.append(modelEnumName);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(modelEnumName);
    stringBuffer.append(TEXT_30);
    for (Iterator<EnumerationLiteral> l=uml2Enumeration.getOwnedLiterals().iterator(); l.hasNext();) {
    	EnumerationLiteral enumLiteral = (EnumerationLiteral)l.next();
    	String enumLiteralName=EnumerationHelper.getEnumLiteralID(enumLiteral);
    	//String enumLiteralComment=TypeHelper.getDocumentation(enumLiteral);
    	//String enumLiteralValue=EnumKindLiteralStereotypeUtil.getLiteralValue(enumLiteral);
    	//String enumLiteralLable=EnumKindLiteralStereotypeUtil.getLiteralLable(enumLiteral);
    	String enumLiteralColor=EnumKindLiteralStereotypeUtil.getLiteralColor(enumLiteral);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(enumLiteralName);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(enumLiteralColor);
    stringBuffer.append(TEXT_33);
    }
    stringBuffer.append(TEXT_34);
    importStringBuffer.insert(importInsertionPoint, importManager.computeSortedImports());
    stringBuffer.append(TEXT_35);
    return stringBuffer.toString();
  }
}
