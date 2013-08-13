package com.jeefuse.mda.gen.template.main.java.jsp;

import net.taylor.mda.generator.parse.stereotype.*;
import java.util.ArrayList;
import net.taylor.mda.generator.parse.entity.*;
import net.taylor.mda.generator.parse.*;
import java.util.Iterator;
import java.util.List;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.*;
import net.taylor.mda.generator.util.*;
import net.taylor.mda.generator.parse.entity.*;
import net.taylor.mda.generator.parse.page.*;
import org.eclipse.emf.codegen.util.*;

public class EntityGallaryADJSP
{
  protected static String nl;
  public static synchronized EntityGallaryADJSP create(String lineSeparator)
  {
    nl = lineSeparator;
    EntityGallaryADJSP result = new EntityGallaryADJSP();
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
  protected final String TEXT_10 = "\" type=\"text/javascript\"></script>" + NL + "<script>" + NL + "\tvar ctx = '${ctx}';" + NL + "\tvar theme = '${theme}';" + NL + "\timportCssFile('sys|ui|adgallery', ctx, theme);" + NL + "\timportJsFile('jquery|ui|common|adgallery', ctx);" + NL + "</script>" + NL + "</head>" + NL + "<body class=\"easyui-layout v-container\">" + NL + " \t<div region=\"center\" border=\"false\" ><!-- center start -->" + NL + " \t\t<div id=\"gallery\" class=\"ad-gallery\">" + NL + "\t\t  <div class=\"ad-image-wrapper\">" + NL + "\t\t  </div>" + NL + "\t\t  <div class=\"ad-controls\">" + NL + "\t\t  </div>" + NL + "\t\t  <div class=\"ad-nav\">" + NL + "\t\t    <div class=\"ad-thumbs\">" + NL + "\t\t      <ul class=\"ad-thumb-list\">" + NL + "\t\t      <s:iterator value=\"";
  protected final String TEXT_11 = "List\" var=\"item\">" + NL + "\t\t\t\t  <li>" + NL + "\t\t             <a href=\"${ctx}/${item.path}\">" + NL + "\t\t               \t<img src=\"${ctx}/${item.";
  protected final String TEXT_12 = "}\"";
  protected final String TEXT_13 = " title=\"${item.";
  protected final String TEXT_14 = "}\"";
  protected final String TEXT_15 = " longdesc=\"${item.";
  protected final String TEXT_16 = "}\" alt=\"${item.";
  protected final String TEXT_17 = "}\"";
  protected final String TEXT_18 = " width=\"90px\" height=\"60px\" class=\"thumbnail\"/>" + NL + "\t\t             </a>" + NL + "\t\t          </li>" + NL + "\t\t      </s:iterator>" + NL + "\t\t      </ul>" + NL + "\t\t    </div>" + NL + "\t\t  </div>" + NL + "\t\t</div>" + NL + " \t</div><!-- center end -->" + NL + "<script type=\"text/javascript\">" + NL + "$(document).ready(function() {" + NL + "    var galleries = $('.ad-gallery').adGallery({" + NL + "    \t  //loader_image: 'loader.gif'," + NL + "    \t  //width: 600, // Width of the image, set to false and it will read the CSS width" + NL + "    \t//  height: 400, // Height of the image, set to false and it will read the CSS height" + NL + "    \t  thumb_opacity: 0.6, // Opacity that the thumbs fades to/from, (1 removes fade effect)" + NL + "    \t                      // Note that this effect combined with other effects might be resource intensive" + NL + "    \t                      // and make animations lag" + NL + "    \t  start_at_index: 0, // Which image should be displayed at first? 0 is the first image" + NL + "    \t  //description_wrapper: $('#descriptions'), // Either false or a jQuery object, if you want the image descriptions" + NL + "    \t                                           // to be placed somewhere else than on top of the image" + NL + "    \t  animate_first_image: false, // Should first image just be displayed, or animated in?" + NL + "    \t  animation_speed: 400, // Which ever effect is used to switch images, how long should it take?" + NL + "    \t  display_next_and_prev: true, // Can you navigate by clicking on the left/right on the image?" + NL + "    \t  display_back_and_forward: true, // Are you allowed to scroll the thumb list?" + NL + "    \t  scroll_jump: 0, // If 0, it jumps the width of the container" + NL + "    \t  slideshow: {" + NL + "    \t    enable: true," + NL + "    \t    autostart: true," + NL + "    \t    speed: 3000," + NL + "    \t    start_label: 'Start'," + NL + "    \t    stop_label: 'Stop'," + NL + "    \t    stop_on_scroll: true, // Should the slideshow stop if the user scrolls the thumb list?" + NL + "    \t    countdown_prefix: '(', // Wrap around the countdown" + NL + "    \t    countdown_sufix: ')'," + NL + "    \t    onStart: function() {// Do something wild when the slideshow starts" + NL + "    \t    }," + NL + "    \t    onStop: function() {// Do something wild when the slideshow stops" + NL + "    \t    }" + NL + "    \t  }," + NL + "    \t  enable_keyboard_move: true, // Move to next/previous image with keyboard arrows?" + NL + "    \t  cycle: false // If set to false, you can't go from the last image to the first, and vice versa" + NL + "    \t  // All callbacks has the AdGallery objects as 'this' reference" + NL + "    \t});" + NL + "" + NL + "    \t// Change effect on the fly" + NL + "    \tgalleries[0].settings.effect = 'fade';" + NL + "" + NL + "//    $('#switch-effect').change(" + NL + "//      function() {" + NL + "//        galleries[0].settings.effect = $(this).val();" + NL + "//        return false;" + NL + "//      }" + NL + "//    );" + NL + "});" + NL + "</script>" + NL + "</body>" + NL + "</html>";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    Class uml2Class = (Class) argument;Package uml2Package = uml2Class.getPackage();
    
String modelCapName=NameHelper.getCapName(uml2Class);
String modelCommentName=TypeHelper.getDocumentationOrName(uml2Class);
String jspScriptStart="<%@";
String jspScriptEnd="%"+">";
int tabindex=0;

    	Property propertyFileSavePath=FileStereotypeHelper.getProperty_FileSavePath(uml2Class);
    	String propertyFileSavePathUncapSafeName=NameHelper.uncapSafeName(propertyFileSavePath);
    	Property propertyTitle=PropertyStereotypeHelper.getProperty_Title(uml2Class);
    	String propertyTitleUncapSafeName=NameHelper.uncapSafeName(propertyTitle);
    	Property propertyIntro=PropertyStereotypeHelper.getProperty_Intro(uml2Class);
    	String propertyIntroUncapSafeName=NameHelper.uncapSafeName(propertyIntro);
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
    stringBuffer.append(modelCapName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(propertyFileSavePathUncapSafeName);
    stringBuffer.append(TEXT_12);
    if(null!=propertyTitleUncapSafeName){
    stringBuffer.append(TEXT_13);
    stringBuffer.append(propertyTitleUncapSafeName);
    stringBuffer.append(TEXT_14);
    }
    if(null!=propertyIntroUncapSafeName){
    stringBuffer.append(TEXT_15);
    stringBuffer.append(propertyIntroUncapSafeName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(propertyIntroUncapSafeName);
    stringBuffer.append(TEXT_17);
    }
    stringBuffer.append(TEXT_18);
    return stringBuffer.toString();
  }
}
