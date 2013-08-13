package com.jeefuse.mda.gen.template.main.java.jsp;

import net.taylor.mda.generator.parse.NameRuled.*;
import java.util.ArrayList;
import net.taylor.mda.generator.parse.NameRuled.nameRuled.NameRuledWebPathKind;
import net.taylor.mda.generator.parse.entity.*;
import net.taylor.mda.generator.parse.*;
import java.util.Iterator;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.*;
import net.taylor.mda.generator.util.*;
import net.taylor.mda.generator.parse.page.*;
import org.eclipse.emf.codegen.util.*;

public class EntityImportExcelJsp
{
  protected static String nl;
  public static synchronized EntityImportExcelJsp create(String lineSeparator)
  {
    nl = lineSeparator;
    EntityImportExcelJsp result = new EntityImportExcelJsp();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = " page contentType=\"text/html;charset=UTF-8\" ";
  protected final String TEXT_3 = NL;
  protected final String TEXT_4 = " include file=\"/common/taglibs.jsp\" ";
  protected final String TEXT_5 = NL + "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">" + NL + "<html xmlns=\"http://www.w3.org/1999/xhtml\">" + NL + "<head>" + NL + "<title>";
  protected final String TEXT_6 = " Input</title>";
  protected final String TEXT_7 = NL;
  protected final String TEXT_8 = " include file=\"/common/meta.jsp\" ";
  protected final String TEXT_9 = NL + "<script src=\"";
  protected final String TEXT_10 = "\" type=\"text/javascript\"></script>" + NL + "<script>" + NL + "\tvar ctx = '${ctx}';" + NL + "\tvar theme = '${theme}';" + NL + "\timportCssFile('sys|ui', ctx, theme);" + NL + "\timportJsFile('jquery|blockUI|ui|common|form|validate', ctx);" + NL + "</script>" + NL + "</head>" + NL + "<body class=\"easyui-layout\">" + NL + " \t<div id=\"first-box\" class=\"v-box\" region=\"center\" border=\"false\">" + NL + " \t\t<!--<div id=\"inputInfo\" class=\"v-state-info\"></div>-->" + NL + " \t\t<div class=\"v-form\">" + NL + " \t\t\t<form id=\"inputForm\" method=\"post\">" + NL + "\t\t      \t<table>" + NL + "\t\t      \t\t<tr>" + NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_11 = "数据Excel导入文件:</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t</tr>" + NL + "\t\t      \t\t<tr>" + NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<input type=\"file\" id=\"file\" name=\"file\" size=\"50\" class=\"required\" onchange=\"goolov.validete.file(this,'xls');\"/>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t</tr>" + NL + "\t\t\t\t</table>" + NL + "\t\t\t</form>" + NL + "\t\t\t<div class=\"v-buttons\">" + NL + "\t\t\t\t\t<a href=\"javascript:void(0)\" onclick=\"importProcess();\"  class=\"easyui-linkbutton\" icon=\"icon-save\" >执行导入</a>" + NL + "\t\t\t\t   \t<a href=\"javascript:closeAndRefresh();\" class=\"easyui-linkbutton\" >关闭并刷新</a>" + NL + "\t\t\t</div>" + NL + "\t\t</div>" + NL + "\t</div>" + NL + "<script type=\"text/javascript\">" + NL + "\t$(document).ready(function() {" + NL + "              var validator=$(\"#inputForm\").validate();" + NL + "\t\t\t  $('#inputForm').submit(function() { " + NL + "\t\t\t  \t        $(this).ajaxSubmit({" + NL + "\t\t\t\t\t\t\t type : 'post'," + NL + "\t\t\t\t\t\t\t dataType:'html', " + NL + "\t\t\t\t\t\t\t url:ctx+'";
  protected final String TEXT_12 = "'," + NL + "\t\t\t\t\t\t\t beforeSubmit:function(formData, jqForm, options) {" + NL + "\t\t\t\t\t\t\t\t    if(validator.numberOfInvalids()>0){" + NL + "\t\t\t\t\t\t\t\t\t    return false;" + NL + "\t\t\t\t\t\t\t\t    }" + NL + "\t\t\t\t\t\t\t\t    $.growl.waiting('导入数据中...');" + NL + "\t\t\t\t\t\t\t }," + NL + "\t\t\t\t\t\t     success:function(result, statusText, xhr, $form) {" + NL + "\t\t\t\t\t\t     \t\t$.growl.unwaiting();" + NL + "\t\t\t\t\t\t\t\t\tgoolov.msgbox.info('友情提示',result);" + NL + "\t\t\t\t\t\t\t }," + NL + "\t\t\t\t\t\t\t error:function(request,status,errorThrown) {" + NL + "\t\t\t\t\t\t\t \t$.growl.unwaiting();" + NL + "\t\t\t\t\t\t\t\t$.msgbox.error();" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}); " + NL + "\t\t\t\t        return false; " + NL + "\t\t\t    }); " + NL + "\t});" + NL + "\tfunction importProcess(){" + NL + "\t\t$(\"#inputForm\").submit();" + NL + "\t}" + NL + "\tfunction closeAndRefresh(){" + NL + "\t\twindow.parent.importExcelWinCloseAndRefresh();" + NL + "\t}" + NL + "</script>" + NL + "</body>" + NL + "</html>";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    Class uml2Class = (Class) argument;Package uml2Package = uml2Class.getPackage();
    
UmlClassWrap clazzWrap=new UmlClassWrap(uml2Class);
String packageName=NameHelper.getQualifiedName(uml2Package);
String modelCapName=NameHelper.getCapName(uml2Class);
String modelUncapName=NameHelper.getUncapName(uml2Class);
String modelCommentName=TypeHelper.getDocumentationOrName(uml2Class);
String modelInputJsPath=clazzWrap.getWebPath(NameRuledWebPathKind.js_input);
String jspScriptStart="<%@";
String jspScriptEnd="%"+">";
int tabindex=0;

    stringBuffer.append(TEXT_1);
    stringBuffer.append(jspScriptStart);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(jspScriptEnd);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(jspScriptStart);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(jspScriptEnd);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(modelCommentName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(jspScriptStart);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(jspScriptEnd);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(Config.web_resources_js_include);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(modelCommentName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(clazzWrap.getUrl(WebUrlName.importExcelFileProcess));
    stringBuffer.append(TEXT_12);
    return stringBuffer.toString();
  }
}
