package com.jeefuse.mda.gen.template.main.java.action;

import net.taylor.mda.generator.parse.NameRuled.nameRuled.*;
import net.taylor.mda.generator.parse.NameRuled.className.*;
import net.taylor.mda.generator.parse.NameRuled.*;
import net.taylor.mda.generator.parse.*;
import java.util.Iterator;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.*;
import net.taylor.mda.generator.util.*;
import net.taylor.mda.generator.parse.entity.*;
import org.eclipse.emf.codegen.util.*;

public class EntityStrutsXmlManageByProperty
{
  protected static String nl;
  public static synchronized EntityStrutsXmlManageByProperty create(String lineSeparator)
  {
    nl = lineSeparator;
    EntityStrutsXmlManageByProperty result = new EntityStrutsXmlManageByProperty();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + NL + "<!DOCTYPE struts PUBLIC \"-//Apache Software Foundation//DTD Struts Configuration 2.1//EN\"" + NL + "        \"http://struts.apache.org/dtds/struts-2.1.dtd\">" + NL + "<struts>" + NL + "    " + NL + "    <!-- ";
  protected final String TEXT_2 = " action manager by  ";
  protected final String TEXT_3 = " -->" + NL + "\t<package name=\"";
  protected final String TEXT_4 = "\" extends=\"system\" namespace=\"";
  protected final String TEXT_5 = "\">" + NL + "\t\t<default-class-ref class=\"";
  protected final String TEXT_6 = "\"/>" + NL + "\t\t<action name=\"manage\" method=\"manage\">" + NL + "            <result name=\"success\">";
  protected final String TEXT_7 = "</result>" + NL + "        </action>" + NL + "        <action name=\"input\" method=\"edit\">" + NL + "        \t<result name=\"success\">";
  protected final String TEXT_8 = "</result>" + NL + "        </action>" + NL + "        <action name=\"edit\" method=\"edit\">" + NL + "        \t<result name=\"success\">";
  protected final String TEXT_9 = "</result>" + NL + "        </action>" + NL + "        <action name=\"listOutJson\" method=\"listOutJson\"/>" + NL + "        <action name=\"saveOutJson\" method=\"saveOutJson\"/>" + NL + "        <action name=\"updateOutJson\" method=\"updateOutJson\"/>" + NL + "        <action name=\"deleteOutJson\" method=\"deleteOutJson\"/>" + NL + "        <action name=\"deleteAllOutJson\" method=\"deleteAllOutJson\"/>" + NL + "\t</package>" + NL + "\t" + NL + "</struts>";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    Property property = (Property) argument;Package propertyPackage = property.getNearestPackage();
    
/******property wrap*/
UmlPropertyWrap propertyWrap=new UmlPropertyWrap(property);
//String curPropertyUnCapName=propertyWrap.getUncapName();
String curPropertyComment=propertyWrap.getCommentName();
Class ownerClass=(Class)property.getOwner();

/*******clazz wrap********/
UmlClassWrap clazzWrap=new UmlClassWrap(ownerClass);
String ownerClassCommentName=clazzWrap.getCommentName();

/******** clazz by property wrap ********/
UmlClassByPropertyWrap clazzByPropertyWrap=new UmlClassByPropertyWrap(property);
String modelNamespace=clazzByPropertyWrap.getNamespace();

/******** clazz by Property action define********/
ClassNameDefineByPropertyCommon actionByProperty=clazzByPropertyWrap.getNameDefineActionByProperty();
String modelActionClassUncapName=actionByProperty.getClassUncapName();
String modelActionClassQualifiedName=actionByProperty.getClassQualifiedName();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(ownerClassCommentName);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(curPropertyComment);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(modelActionClassUncapName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(modelNamespace);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(modelActionClassQualifiedName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(clazzByPropertyWrap.getWebPath(NameRuledWebPathKind.jsp_manager));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(clazzByPropertyWrap.getWebPath(NameRuledWebPathKind.jsp_input));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(clazzByPropertyWrap.getWebPath(NameRuledWebPathKind.jsp_input));
    stringBuffer.append(TEXT_9);
    return stringBuffer.toString();
  }
}
