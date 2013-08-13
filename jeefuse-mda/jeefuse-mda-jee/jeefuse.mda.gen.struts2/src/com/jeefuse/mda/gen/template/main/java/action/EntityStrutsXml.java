package com.jeefuse.mda.gen.template.main.java.action;

import net.taylor.mda.generator.parse.NameRuled.nameRuled.*;
import net.taylor.mda.generator.parse.NameRuled.className.*;
import net.taylor.mda.generator.parse.NameRuled.*;
import net.taylor.mda.generator.parse.stereotype.*;
import net.taylor.mda.generator.parse.*;
import java.util.Iterator;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.*;
import net.taylor.mda.generator.parse.entity.*;
import org.eclipse.emf.codegen.util.*;

public class EntityStrutsXml
{
  protected static String nl;
  public static synchronized EntityStrutsXml create(String lineSeparator)
  {
    nl = lineSeparator;
    EntityStrutsXml result = new EntityStrutsXml();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + NL + "<!DOCTYPE struts PUBLIC \"-//Apache Software Foundation//DTD Struts Configuration 2.1//EN\"" + NL + "        \"http://struts.apache.org/dtds/struts-2.1.dtd\">" + NL + "<struts>" + NL + "    " + NL + "\t<!-- ";
  protected final String TEXT_2 = " action manager-->" + NL + "\t<package name=\"";
  protected final String TEXT_3 = "\" extends=\"system\"  namespace=\"";
  protected final String TEXT_4 = "\">" + NL + "        <default-class-ref class=\"";
  protected final String TEXT_5 = "\"/>" + NL + "        ";
  protected final String TEXT_6 = "        " + NL + "        <action name=\"manage\" method=\"manage\">" + NL + "            <result name=\"success\">";
  protected final String TEXT_7 = "</result>" + NL + "        </action>";
  protected final String TEXT_8 = NL + "        <action name=\"input\" method=\"edit\">" + NL + "        \t<result name=\"success\">";
  protected final String TEXT_9 = "</result>" + NL + "        </action>";
  protected final String TEXT_10 = "     " + NL + "        <action name=\"edit\" method=\"edit\">" + NL + "        \t<result name=\"success\">";
  protected final String TEXT_11 = "</result>" + NL + "        </action>";
  protected final String TEXT_12 = NL + "        <action name=\"getOutJson\" method=\"getOutJson\"/>";
  protected final String TEXT_13 = NL + "        <action name=\"listOutJson\" method=\"listOutJson\"/>";
  protected final String TEXT_14 = "  ";
  protected final String TEXT_15 = NL + "\t\t<action name=\"listTreeOutJson\" method=\"listTreeOutJson\"/>";
  protected final String TEXT_16 = NL + "\t\t<action name=\"saveOutJson\" method=\"saveOutJson\"/>";
  protected final String TEXT_17 = NL + "\t\t<action name=\"updateOutJson\" method=\"saveOutJson\"/>";
  protected final String TEXT_18 = NL + "        <action name=\"deleteOutJson\" method=\"deleteOutJson\"/>" + NL + "        <action name=\"deleteDescendantOutJson\" method=\"deleteDescendantOutJson\"/>";
  protected final String TEXT_19 = NL + "        <action name=\"deleteAllOutJson\" method=\"deleteAllOutJson\"/>";
  protected final String TEXT_20 = "\t\t" + NL + "        <action name=\"saveOutJson\" method=\"saveOutJson\"/>" + NL + "        <action name=\"updateOutJson\" method=\"updateOutJson\"/>";
  protected final String TEXT_21 = NL + "        <action name=\"deleteOutJson\" method=\"deleteOutJson\"/>";
  protected final String TEXT_22 = NL + "        <action name=\"deleteAllOutJson\" method=\"deleteAllOutJson\"/>";
  protected final String TEXT_23 = NL + "\t\t<!-- export excel file  -->" + NL + "        <action name=\"exportExcelFile\" method=\"exportExcelFile\"/>";
  protected final String TEXT_24 = "        ";
  protected final String TEXT_25 = NL + "\t\t<!-- import excel file data -->" + NL + "        <action name=\"importExcelFileProcess\" method=\"";
  protected final String TEXT_26 = "\"/>";
  protected final String TEXT_27 = NL + "\t\t<action name=\"listForSelect\" method=\"listForSelect\">" + NL + "        \t<result name=\"success\">";
  protected final String TEXT_28 = "</result>" + NL + "        </action>" + NL + "        <action name=\"listForSelectOutJson\" method=\"listOutJson\"/>";
  protected final String TEXT_29 = NL + "\t\t<!--photo Gallery-->" + NL + "        <action name=\"gallaryView\" method=\"gallaryView\">" + NL + "        \t<result name=\"success\">";
  protected final String TEXT_30 = "</result>" + NL + "        </action>";
  protected final String TEXT_31 = NL + "\t</package>" + NL + "\t" + NL + "</struts>";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    Class uml2Class = (Class) argument;Package uml2Package = uml2Class.getPackage();
    
UmlClassWrap clazzWrap=new UmlClassWrap(uml2Class);
String modelUrlNamespace=clazzWrap.getNamespace();
String modelUncapName=clazzWrap.getUncapName();
String modelCommentName=clazzWrap.getCommentName();
//action define
ClassNameDefineCommon actionDefine=clazzWrap.getNameDefineAction();
String modelActionQualifiedName=actionDefine.getClassQualifiedName();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(modelCommentName);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(modelUncapName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(modelUrlNamespace);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(modelActionQualifiedName);
    stringBuffer.append(TEXT_5);
    if(FunctionStereotypeUtil.isApplied_manage(uml2Class)){
    stringBuffer.append(TEXT_6);
    stringBuffer.append(clazzWrap.getWebPath(NameRuledWebPathKind.jsp_manager));
    stringBuffer.append(TEXT_7);
    }
    if(FunctionStereotypeUtil.isApplied_input(uml2Class)){
    stringBuffer.append(TEXT_8);
    stringBuffer.append(clazzWrap.getWebPath(NameRuledWebPathKind.jsp_input));
    stringBuffer.append(TEXT_9);
    }
    if(FunctionStereotypeUtil.isApplied_edit(uml2Class)){
    stringBuffer.append(TEXT_10);
    stringBuffer.append(clazzWrap.getWebPath(NameRuledWebPathKind.jsp_input));
    stringBuffer.append(TEXT_11);
    }
    if(FunctionStereotypeUtil.isApplied_getOutJson(uml2Class)){
    stringBuffer.append(TEXT_12);
    }
    if(FunctionStereotypeUtil.isApplied_listOutJson(uml2Class)){
    stringBuffer.append(TEXT_13);
    }
    stringBuffer.append(TEXT_14);
    /********is apply tree********/
    if(ModelStereoTypeHelper.isApplyModel_Tree(uml2Class)){
    stringBuffer.append(TEXT_15);
    	if(FunctionStereotypeUtil.isApplied_saveOutJson(uml2Class)){
    stringBuffer.append(TEXT_16);
    	}
    	if(FunctionStereotypeUtil.isApplied_saveOutJson(uml2Class)){
    stringBuffer.append(TEXT_17);
    	}
    	if(FunctionStereotypeUtil.isApplied_deleteOutJson(uml2Class)){
    stringBuffer.append(TEXT_18);
    	}
    	if(FunctionStereotypeUtil.isApplied_deleteAllOutJson(uml2Class)){
    stringBuffer.append(TEXT_19);
    	}
    }else{
    	if(FunctionStereotypeUtil.isApplied_saveOutJson(uml2Class)){
    stringBuffer.append(TEXT_20);
    	}
    	if(FunctionStereotypeUtil.isApplied_deleteOutJson(uml2Class)){
    stringBuffer.append(TEXT_21);
    	}
    	if(FunctionStereotypeUtil.isApplied_deleteAllOutJson(uml2Class)){
    stringBuffer.append(TEXT_22);
    	}
    }
    	if(ServiceStereotypeUtil.isApplied_expExcel(uml2Class)){
    stringBuffer.append(TEXT_23);
    	}
    stringBuffer.append(TEXT_24);
    	if(ServiceStereotypeUtil.isApplied_impExcel(uml2Class)){
    stringBuffer.append(TEXT_25);
    stringBuffer.append(WebUrlName.importExcelFileProcess.getValue());
    stringBuffer.append(TEXT_26);
    	}
    /********is apply listForSelect********/
    if(ModelStereoTypeHelper.isApplyModel_ListForSelect(uml2Class)){
    stringBuffer.append(TEXT_27);
    stringBuffer.append(clazzWrap.getWebPath(NameRuledWebPathKind.jsp_listForSelect));
    stringBuffer.append(TEXT_28);
    }
    /********is apply image********/
    if(FileStereotypeHelper.isClass_Image(uml2Class)){
    stringBuffer.append(TEXT_29);
    stringBuffer.append(clazzWrap.getWebPath(NameRuledWebPathKind.jsp_galleryAD));
    stringBuffer.append(TEXT_30);
    }
    stringBuffer.append(TEXT_31);
    return stringBuffer.toString();
  }
}
