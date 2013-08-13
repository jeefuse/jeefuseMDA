package com.jeefuse.mda.gen.template.main.java.file;

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

public class EntityUploadFileRule
{
  protected static String nl;
  public static synchronized EntityUploadFileRule create(String lineSeparator)
  {
    nl = lineSeparator;
    EntityUploadFileRule result = new EntityUploadFileRule();
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
  protected final String TEXT_7 = " 上传规则." + NL + " *" + NL + " * @author ";
  protected final String TEXT_8 = NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_9 = " {" + NL + "\t/**" + NL + "\t * 获取 ";
  protected final String TEXT_10 = "上传文件规则." + NL + "\t */" + NL + "\tpublic static UploadFileRule getUploadFileRule(HttpServletRequest request, String userId) {" + NL + "\t\tUploadFileRule uploadFileRule = UploadFileFactory.getUploadFileRule(request,userId, UploadFileType.image);" + NL + "\t\tString[] exts = { \"jpg\", \"gif\", \"jpeg\", \"png\", \"bmp\" };" + NL + "\t\tuploadFileRule.setAcceptExtentionType(exts);" + NL + "\t\tuploadFileRule.setAcceptFileSize(Constants.DEFAULT_UPLOAD_IMAGE_SIZE);" + NL + "\t\treturn uploadFileRule;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * 上传";
  protected final String TEXT_11 = "文件." + NL + "\t */" + NL + "\tpublic static List<UploadFile> uploadFiles(HttpServletRequest request, String userId) {" + NL + "\t\tUploadFileRule fileRule = getUploadFileRule(request,userId);" + NL + "\t\treturn StrutsWebFileUtil.uploadFile(fileRule, request, true);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * 删除";
  protected final String TEXT_12 = "文件." + NL + "\t */" + NL + "\tpublic static void deleteFile(String relativeSavePath, HttpServletRequest request, String userId) {" + NL + "\t\tUploadFileRule fileRule = getUploadFileRule(request,userId);" + NL + "\t\tStrutsWebFileUtil.deleteFile(fileRule, relativeSavePath);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * 删除";
  protected final String TEXT_13 = "文件." + NL + "\t */" + NL + "\tpublic static void deleteFile(String savePath) {" + NL + "\t\tStrutsWebFileUtil.deleteFile(savePath);" + NL + "\t}" + NL + "\t" + NL + "}";
  protected final String TEXT_14 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    Class uml2Class = (Class) argument;Package uml2Package = uml2Class.getPackage();
    
/*******clazz wrap********/	
UmlClassWrap clazzWrap=new UmlClassWrap(uml2Class);
String modelCommentName=clazzWrap.getCommentName();
//String modelCapName=clazzWrap.getCapName();

//model exportFileUpload
ClassNameDefineCommon exportFileUploadDefine=clazzWrap.getNameDefineFileUpload();
String modelFileUploadPackageName=exportFileUploadDefine.getPackageQualifiedName();
String modelFileUploadClassName=exportFileUploadDefine.getClassCapName();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(modelFileUploadPackageName);
    stringBuffer.append(TEXT_3);
    ImportManager importManager = ImportHelper.makeImportManager("");
    importManager.addImport("java.util.Collection");
    importManager.addImport("javax.servlet.http.HttpServletRequest");
    importManager.addImport("javax.servlet.http.HttpServletResponse");
    importManager.addImport("javax.servlet.http.HttpServletRequest");
    importManager.addImport("com.jeefuse.base.config.Constants");
    importManager.addImport("com.jeefuse.base.web.uploadFile.UploadFile");
    importManager.addImport("com.jeefuse.base.web.uploadFile.UploadFileFactory");
    importManager.addImport("com.jeefuse.base.web.uploadFile.UploadFileRule");
    importManager.addImport("com.jeefuse.base.web.uploadFile.UploadFileType");
    importManager.addImport("com.jeefuse.base.web.uploadFile.StrutsWebFileUtil");
    importManager.addImport("com.jeefuse.system.security.service.spring.SecurityHolder");
    importManager.addImport("org.springframework.util.Assert");
    stringBuffer.append(TEXT_4);
    
// add imports
importManager.addImport(Config.base_ModelExportFactory);

    stringBuffer.append(TEXT_5);
    
StringBuffer importStringBuffer = stringBuffer;
int importInsertionPoint = stringBuffer.length();
importManager.addCompilationUnitImports(stringBuffer.toString());

    stringBuffer.append(TEXT_6);
    stringBuffer.append(modelCommentName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(System.getProperty("user.name"));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(modelFileUploadClassName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(modelCommentName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(modelCommentName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(modelCommentName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(modelCommentName);
    stringBuffer.append(TEXT_13);
    importStringBuffer.insert(importInsertionPoint, importManager.computeSortedImports());
    stringBuffer.append(TEXT_14);
    return stringBuffer.toString();
  }
}
