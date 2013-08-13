package com.jeefuse.mda.gen.template.main.java.jsp;

import net.taylor.mda.generator.parse.NameRuled.nameRuled.*;
import net.taylor.mda.generator.parse.NameRuled.*;
import java.util.ArrayList;
import net.taylor.mda.generator.parse.stereotype.*;
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

public class EntitManagerJSPProxyManageByProperty
{
  protected static String nl;
  public static synchronized EntitManagerJSPProxyManageByProperty create(String lineSeparator)
  {
    nl = lineSeparator;
    EntitManagerJSPProxyManageByProperty result = new EntitManagerJSPProxyManageByProperty();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = " page contentType=\"text/html;charset=UTF-8\" ";
  protected final String TEXT_3 = NL;
  protected final String TEXT_4 = " include file=\"/common/taglibs.jsp\" ";
  protected final String TEXT_5 = NL + "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">" + NL + "<html xmlns=\"http://www.w3.org/1999/xhtml\">" + NL + "<head>" + NL + "<title>";
  protected final String TEXT_6 = "管理</title>";
  protected final String TEXT_7 = NL;
  protected final String TEXT_8 = " include file=\"/common/meta.jsp\" ";
  protected final String TEXT_9 = NL + "<script src=\"";
  protected final String TEXT_10 = "\" type=\"text/javascript\"></script>" + NL + "<script>" + NL + "\tvar ctx = '${ctx}';" + NL + "\tvar theme = '${theme}';";
  protected final String TEXT_11 = NL + "\tvar ";
  protected final String TEXT_12 = "=";
  protected final String TEXT_13 = ".toHtmlJSON";
  protected final String TEXT_14 = ";";
  protected final String TEXT_15 = NL + "\timportCssFile('sys|ui|flexiGrid|treeview|contextmenu', ctx, theme);" + NL + "\timportJsFile('jquery|common|blockUI|ui|flexiTreeGrid|treeview|validate|contextmenu";
  protected final String TEXT_16 = "|form";
  protected final String TEXT_17 = "',ctx);" + NL + "\timportJsFile('";
  protected final String TEXT_18 = "', ctx);" + NL + "</script>";
  protected final String TEXT_19 = NL + NL + "</head>" + NL + "<body id=\"container\" class=\"v-container\">" + NL + "    <div id=\"header\" region=\"north\" split=\"false\" border=\"false\"  class=\"v-header\"><!-- header start -->" + NL + "\t\t<div id=\"firstTitle\" class=\"v-title\"></div>" + NL + "\t\t" + NL + "\t\t<div id=\"firstToolbar\" class=\"v-toolbar\"><!-- v-toolbar start -->" + NL + "\t\t\t<a href=\"javascript:newData();\" class=\" l-btn l-btn-plain\" >" + NL + "\t\t\t\t<span class=\"l-btn-left\"><span  class=\"l-btn-text icon-add\">新增</span></span>" + NL + "\t\t\t</a>" + NL + "\t\t\t<a href=\"javascript:editData()\" class=\" l-btn l-btn-plain\" >" + NL + "\t\t\t\t<span class=\"l-btn-left\"><span  class=\"l-btn-text icon-form-edit\">编辑</span></span>" + NL + "\t\t\t</a>" + NL + "\t\t\t<a href=\"javascript:delData();\" class=\" l-btn l-btn-plain\" >" + NL + "\t\t\t\t<span class=\"l-btn-left\"><span  class=\"l-btn-text icon-remove\">删除</span></span>" + NL + "\t\t\t</a>" + NL + "\t\t\t<a href=\"javascript:delDescendantData();\" class=\" l-btn l-btn-plain\" >" + NL + "\t\t\t\t<span class=\"l-btn-left\"><span  class=\"l-btn-text icon-remove\">删除及其子节点</span></span>" + NL + "\t\t\t</a>" + NL + "\t\t\t<a href=\"javascript:delAllData();\" class=\" l-btn l-btn-plain\" >" + NL + "\t\t\t\t<span class=\"l-btn-left\"><span  class=\"l-btn-text icon-remove\">删除所有</span></span>" + NL + "\t\t\t</a>" + NL + "\t\t\t<a href=\"javascript:refresh()\" class=\" l-btn l-btn-plain\" >" + NL + "\t\t\t\t<span class=\"l-btn-left\"><span  class=\"l-btn-text icon-reload\">刷新</span></span>" + NL + "\t\t\t</a>" + NL + "\t\t\t<a href=\"javascript:clear()\" class=\" l-btn l-btn-plain\" >" + NL + "\t\t\t\t<span class=\"l-btn-left\"><span  class=\"l-btn-text icon-reset\">重置</span></span>" + NL + "\t\t\t</a>";
  protected final String TEXT_20 = NL + "\t\t\t<a href=\"javascript:exportExcel();\" class=\" l-btn l-btn-plain\" >" + NL + "\t\t\t\t<span class=\"l-btn-left\"><span  class=\"l-btn-text icon-excel\">导出EXCEL</span></span>" + NL + "\t\t\t</a>";
  protected final String TEXT_21 = NL + "\t\t\t<a href=\"javascript:importExcel();\" class=\" l-btn l-btn-plain\" >" + NL + "\t\t\t\t<span class=\"l-btn-left\"><span  class=\"l-btn-text icon-excel\">导入EXCEL</span></span>" + NL + "\t\t\t</a>";
  protected final String TEXT_22 = NL + "\t\t</div><!-- v-toolbar end -->" + NL + "\t\t" + NL + "\t\t<div id=\"firstSearch\" class=\"v-search\"><!-- first-search -->";
  protected final String TEXT_23 = "\t\t";
  protected final String TEXT_24 = NL + "\t\t   <form id=\"firstSearchForm\">";
  protected final String TEXT_25 = NL + "\t\t\t\t<input type=\"hidden\" id=\"parentId\" name=\"parentId\"/>";
  protected final String TEXT_26 = "   " + NL + "\t\t\t\t<table>";
  protected final String TEXT_27 = "\t\t\t\t";
  protected final String TEXT_28 = NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_29 = "\t";
  protected final String TEXT_30 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_31 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_32 = NL + "\t\t\t\t\t\t<td>" + NL + "\t\t\t\t\t\t\t <label>";
  protected final String TEXT_33 = ":</label>\t" + NL + "\t\t\t\t\t\t</td>" + NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_34 = "\">" + NL + "\t\t\t\t\t\t\t ${propertySearchRadios}" + NL + "\t\t\t\t\t\t</td>";
  protected final String TEXT_35 = "\t";
  protected final String TEXT_36 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_37 = "\t\t\t\t\t\t";
  protected final String TEXT_38 = "\t";
  protected final String TEXT_39 = NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_40 = "\t";
  protected final String TEXT_41 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_42 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_43 = NL + "\t\t\t\t\t\t<td>" + NL + "\t\t\t\t\t\t\t <label>";
  protected final String TEXT_44 = ":</label>\t" + NL + "\t\t\t\t\t\t</td>" + NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_45 = "\">" + NL + "\t\t\t\t\t\t\t ${propertySearchCheckboxs}" + NL + "\t\t\t\t\t\t</td>";
  protected final String TEXT_46 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_47 = "\t\t\t\t\t\t";
  protected final String TEXT_48 = "\t";
  protected final String TEXT_49 = NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_50 = "\t";
  protected final String TEXT_51 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_52 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_53 = NL + NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_54 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_55 = "\">" + NL + "\t\t      \t\t\t\t<select  id=\"";
  protected final String TEXT_56 = "\" name=\"";
  protected final String TEXT_57 = "\" class=\"text\">" + NL + "\t\t\t\t\t\t\t     <s:property value=\"";
  protected final String TEXT_58 = "\" escape=\"false\"/>" + NL + "\t\t\t\t\t\t\t </select>" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_59 = NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_60 = "\t";
  protected final String TEXT_61 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_62 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_63 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>开始";
  protected final String TEXT_64 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\">" + NL + "\t\t      \t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_65 = "\" name=\"";
  protected final String TEXT_66 = "\" value=\"${param.";
  protected final String TEXT_67 = "}\"   class=\"dateCN\"/>" + NL + "\t\t      \t\t\t</td>" + NL + "" + NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>结束";
  protected final String TEXT_68 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_69 = "\">" + NL + "\t\t      \t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_70 = "\" name=\"";
  protected final String TEXT_71 = "\" value=\"${param.";
  protected final String TEXT_72 = "}\"   class=\"dateCN\"/>" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_73 = NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_74 = "\t";
  protected final String TEXT_75 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_76 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_77 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_78 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_79 = "\">" + NL + "\t\t      \t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_80 = "\" name=\"";
  protected final String TEXT_81 = "\" value=\"${param.";
  protected final String TEXT_82 = "}\"   class=\"text\"/>" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_83 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_84 = "\t\t\t\t\t\t";
  protected final String TEXT_85 = "\t";
  protected final String TEXT_86 = NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_87 = "\t";
  protected final String TEXT_88 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_89 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_90 = NL + "\t\t\t\t\t\t<td>" + NL + "\t\t\t\t\t\t\t<div class=\"v-buttons\">" + NL + "\t\t\t\t\t\t\t\t\t<a href=\"javascript:firstSearch();\" class=\"easyui-linkbutton\" icon=\"icon-search\" > 查 询</a>" + NL + "\t\t\t\t\t\t\t</div>" + NL + "\t\t\t\t\t\t</td>";
  protected final String TEXT_91 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_92 = "\t" + NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_93 = "\"></td>" + NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_94 = "\t" + NL + "\t\t\t\t</table>" + NL + "\t\t\t</form>";
  protected final String TEXT_95 = NL + "\t\t</div><!-- first-search End-->" + NL + "     </div><!-- header end -->" + NL + "     ";
  protected final String TEXT_96 = NL + "     <!-- category start -->" + NL + "     <div id=\"category\" region=\"west\"  border=\"true\" style=\"width:210px;\">" + NL + "\t\t\t<div class=\"v-title v-title-panel\">";
  protected final String TEXT_97 = "树</div>" + NL + "\t\t\t<div id=\"firstTree\" class=\"v-tree\" ></div>" + NL + "     </div><!-- category end -->";
  protected final String TEXT_98 = "   " + NL + " " + NL + "     <!-- center start -->" + NL + "\t <div id=\"center\" region=\"center\"  border=\"true\">" + NL + "   \t\t<div id=\"firstContent\" class=\"v-content\">" + NL + "\t\t\t<div id=\"dataGrid\"  style=\"display:none;\"></div>" + NL + "\t\t</div>" + NL + "\t</div><!-- center end -->\t\t\t\t\t\t" + NL + "</body>" + NL + "</html>";
  protected final String TEXT_99 = " page contentType=\"text/html;charset=UTF-8\" ";
  protected final String TEXT_100 = NL;
  protected final String TEXT_101 = " include file=\"/common/taglibs.jsp\" ";
  protected final String TEXT_102 = NL + "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">" + NL + "<html xmlns=\"http://www.w3.org/1999/xhtml\">" + NL + "<head>" + NL + "<title>";
  protected final String TEXT_103 = "管理</title>";
  protected final String TEXT_104 = NL;
  protected final String TEXT_105 = " include file=\"/common/meta.jsp\" ";
  protected final String TEXT_106 = NL + "<script src=\"";
  protected final String TEXT_107 = "\" type=\"text/javascript\"></script>" + NL + "<script>" + NL + "\tvar ctx = '${ctx}';" + NL + "\tvar theme = '${theme}';";
  protected final String TEXT_108 = NL + "\tvar ";
  protected final String TEXT_109 = "=";
  protected final String TEXT_110 = ".toHtmlJSON";
  protected final String TEXT_111 = ";";
  protected final String TEXT_112 = NL + "\timportCssFile('sys|ui|flexiGrid|contextmenu";
  protected final String TEXT_113 = "|datePicker";
  protected final String TEXT_114 = "', ctx, theme);" + NL + "\timportJsFile('jquery|blockUI|common|ui|flexiGrid|validate|contextmenu";
  protected final String TEXT_115 = "|datePicker";
  protected final String TEXT_116 = "', ctx);" + NL + "\timportJsFile('";
  protected final String TEXT_117 = "', ctx);" + NL + "</script>" + NL + "" + NL + "</head>" + NL + "<body id=\"container\" class=\"v-container\">" + NL + "\t<div id=\"header\" region=\"north\" split=\"false\" border=\"false\"  class=\"v-header\"><!-- header start -->" + NL + "\t\t<div id=\"first-title\" class=\"v-title\">" + NL + "\t\t\t" + NL + "\t\t</div>" + NL + "\t\t" + NL + "\t\t<div id=\"first-toolbar\" class=\"v-toolbar\"><!-- v-toolbar start -->" + NL + "\t\t\t<a href=\"javascript:newData();\" class=\" l-btn l-btn-plain\" >" + NL + "\t\t\t\t<span class=\"l-btn-left\"><span  class=\"l-btn-text icon-add\">新增</span></span>" + NL + "\t\t\t</a>" + NL + "\t\t\t<a href=\"javascript:editData()\" class=\" l-btn l-btn-plain\" >" + NL + "\t\t\t\t<span class=\"l-btn-left\"><span  class=\"l-btn-text icon-form-edit\">编辑</span></span>" + NL + "\t\t\t</a>" + NL + "\t\t\t<a href=\"javascript:delData();\" class=\" l-btn l-btn-plain\" >" + NL + "\t\t\t\t<span class=\"l-btn-left\"><span  class=\"l-btn-text icon-remove\">删除</span></span>" + NL + "\t\t\t</a>" + NL + "\t\t\t<a href=\"javascript:delAllData();\" class=\" l-btn l-btn-plain\" >" + NL + "\t\t\t\t<span class=\"l-btn-left\"><span  class=\"l-btn-text icon-remove\">删除所有</span></span>" + NL + "\t\t\t</a>" + NL + "\t\t\t<a href=\"javascript:refresh()\" class=\" l-btn l-btn-plain\" >" + NL + "\t\t\t\t<span class=\"l-btn-left\"><span  class=\"l-btn-text icon-reload\">刷新</span></span>" + NL + "\t\t\t</a>" + NL + "\t\t\t<a href=\"javascript:clear()\" class=\" l-btn l-btn-plain\" >" + NL + "\t\t\t\t<span class=\"l-btn-left\"><span  class=\"l-btn-text icon-reset\">重置</span></span>" + NL + "\t\t\t</a>" + NL + "\t\t</div><!-- v-toolbar end -->" + NL + "\t\t" + NL + "\t\t<div id=\"first-search\" class=\"v-search\"><!-- first-search -->";
  protected final String TEXT_118 = NL + "\t\t   <form id=\"firstSearchForm\">" + NL + "\t\t\t\t<table>";
  protected final String TEXT_119 = "\t";
  protected final String TEXT_120 = NL + "\t\t\t<input type=\"hidden\" id=\"";
  protected final String TEXT_121 = "_";
  protected final String TEXT_122 = "\" name=\"";
  protected final String TEXT_123 = ".";
  protected final String TEXT_124 = "\"/>";
  protected final String TEXT_125 = "\t" + NL;
  protected final String TEXT_126 = "\t\t\t\t";
  protected final String TEXT_127 = NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_128 = "\t";
  protected final String TEXT_129 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_130 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_131 = NL + "\t\t\t\t\t\t<td>" + NL + "\t\t\t\t\t\t\t <label>";
  protected final String TEXT_132 = ":</label>\t" + NL + "\t\t\t\t\t\t</td>" + NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_133 = "\">" + NL + "\t\t\t\t\t\t\t ${propertySearchRadios}" + NL + "\t\t\t\t\t\t</td>";
  protected final String TEXT_134 = "\t";
  protected final String TEXT_135 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_136 = "\t\t\t\t\t\t";
  protected final String TEXT_137 = "\t";
  protected final String TEXT_138 = NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_139 = "\t";
  protected final String TEXT_140 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_141 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_142 = NL + "\t\t\t\t\t\t<td>" + NL + "\t\t\t\t\t\t\t <label>";
  protected final String TEXT_143 = ":</label>\t" + NL + "\t\t\t\t\t\t</td>" + NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_144 = "\">" + NL + "\t\t\t\t\t\t\t ${propertySearchCheckboxs}" + NL + "\t\t\t\t\t\t</td>";
  protected final String TEXT_145 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_146 = "\t\t\t\t\t\t";
  protected final String TEXT_147 = "\t";
  protected final String TEXT_148 = NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_149 = "\t";
  protected final String TEXT_150 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_151 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_152 = NL + NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_153 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_154 = "\">" + NL + "\t\t      \t\t\t\t<select  id=\"";
  protected final String TEXT_155 = "\" name=\"";
  protected final String TEXT_156 = "\" class=\"text\">" + NL + "\t\t\t\t\t\t\t     <option value=\"\" >所有</option>" + NL + "\t\t\t\t\t\t\t     <s:property value=\"";
  protected final String TEXT_157 = "\" escape=\"false\"/>" + NL + "\t\t\t\t\t\t\t </select>" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_158 = NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_159 = "\t";
  protected final String TEXT_160 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_161 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_162 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>开始";
  protected final String TEXT_163 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\">" + NL + "\t\t      \t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_164 = "\" name=\"";
  protected final String TEXT_165 = "\" value=\"${param.";
  protected final String TEXT_166 = "}\"   class=\"dateCN\"/>" + NL + "\t\t      \t\t\t</td>" + NL + "" + NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>结束";
  protected final String TEXT_167 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_168 = "\">" + NL + "\t\t      \t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_169 = "\" name=\"";
  protected final String TEXT_170 = "\" value=\"${param.";
  protected final String TEXT_171 = "}\"   class=\"dateCN\"/>" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_172 = NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_173 = "\t";
  protected final String TEXT_174 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_175 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_176 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_177 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_178 = "\">" + NL + "\t\t      \t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_179 = "\" name=\"";
  protected final String TEXT_180 = "\" value=\"${param.";
  protected final String TEXT_181 = "}\"  class=\"text\" />" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_182 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_183 = "\t\t\t\t\t\t";
  protected final String TEXT_184 = "\t";
  protected final String TEXT_185 = NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_186 = "\t";
  protected final String TEXT_187 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_188 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_189 = NL + "\t\t\t\t\t\t<td>" + NL + "\t\t\t\t\t\t\t<div class=\"v-buttons\">" + NL + "\t\t\t\t\t\t\t\t<a href=\"javascript:firstSearch();\" class=\"easyui-linkbutton\" icon=\"icon-search\" > 查 询</a>" + NL + "\t\t\t\t\t\t\t</div>" + NL + "\t\t\t\t\t\t</td>";
  protected final String TEXT_190 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_191 = "\t" + NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_192 = "\"></td>" + NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_193 = "\t" + NL + "\t\t\t\t</table>" + NL + "\t\t\t</form>";
  protected final String TEXT_194 = NL + "\t\t</div><!-- first-search End-->" + NL + "\t</div><!-- header end -->" + NL + "\t\t\t" + NL + "\t<div id=\"center\" region=\"center\"  border=\"true\">" + NL + "   \t\t<div id=\"first-content\">" + NL + "\t\t\t<div id=\"dataGrid\"  style=\"display:none;\"></div>" + NL + "\t\t</div>" + NL + "\t</div><!-- center end -->\t\t\t\t\t\t" + NL + "</body>" + NL + "</html>";
  protected final String TEXT_195 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    Property uml2Property_proxy = (Property) argument;
    Class uml2Class_proxy = (Class) uml2Property_proxy.getOwner();
    if(ModelStereoTypeHelper.isApplyModel_Tree(uml2Class_proxy)){/*应用了tree*/
    Property curProperty = (Property) argument;Package O2MManagePropertyPackage = curProperty.getNearestPackage();
    Class ownerClass=(Class)curProperty.getOwner();
    //String ownerClassCapName=NameHelper.getCapName(ownerClass);
    //String ownerClassUncapName=NameHelper.getUncapName(ownerClass);
    String ownerClassCommentName=TypeHelper.getDocumentationOrName(ownerClass);
    //Property ownerClassIdProperty=EntityHelper.getIDProperty(ownerClass);
    //String ownerClassIdPropertyName=NameHelper.uncapSafeName(ownerClassIdProperty);
    //String ownerClassIdPropertyGetter=ClassHelper.getGetAccessor(ownerClassIdProperty);
    UmlClassByPropertyWrap named=new UmlClassByPropertyWrap(curProperty);
    Class uml2Class=ownerClass;
    
String jspScriptStart="<%@";
String jspScriptEnd="%"+">";
String jspScriptAssign="<%=";
boolean isImpExcel=false;//是否导入excel
if(ServiceStereotypeUtil.isApplied_impExcel(uml2Class)){
	isImpExcel=true;
}

    stringBuffer.append(TEXT_1);
    stringBuffer.append(jspScriptStart);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(jspScriptEnd);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(jspScriptStart);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(jspScriptEnd);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(ownerClassCommentName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(jspScriptStart);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(jspScriptEnd);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(Config.web_resources_js_include);
    stringBuffer.append(TEXT_10);
    List<Property> codeKindPropertiesList=EnumKindHelper.getPropertiesAppliedEnumKind(uml2Class);
    if(null!=codeKindPropertiesList&&codeKindPropertiesList.size()>0){
    	for(Property property:codeKindPropertiesList){
    		Enumeration enumeration=EnumKindHelper.getAppliedEnumKindEnumeration(property);
    		if(null!=enumeration){
    			String modelEnumJsoncapName=NamedUtil.getPropertyNamed(enumeration,PropertyNamedRuleKind.elementJsonNamed);
    			String modelEnumQualifiedName=MdaHelper.getModelQualifiedName(enumeration,PKGSuffix.enumeration,ModelNameSuffix.enumeration);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(modelEnumJsoncapName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(jspScriptAssign);
    stringBuffer.append(modelEnumQualifiedName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(jspScriptEnd);
    stringBuffer.append(TEXT_14);
    		}
    	}
    }
    stringBuffer.append(TEXT_15);
    if(isImpExcel){
    stringBuffer.append(TEXT_16);
    }
    stringBuffer.append(TEXT_17);
    stringBuffer.append(named.getWebPath(NameRuledWebPathKind.js_manager));
    stringBuffer.append(TEXT_18);
    
List<Property> searchPropertyList=ViewSearchHelper.getSearchTextFieldPropertiesFromSimple(uml2Class);
List<Property> radioPropertyList=ViewSearchHelper.getSearchRadioFieldPropertiesFromSimple(uml2Class);
List<Property> checkboxPropertyList=ViewSearchHelper.getSearchCheckboxFieldPropertiesFromSimple(uml2Class);
int trIncludeTd=8;
//int searchTextTrNum=(searchPropertyList.size()%8)==0?(searchPropertyList.size()/8):(searchPropertyList.size()/8)+1;
//int searchRadioTrNum=radioPropertyList.size();
//int searchCheckboxTrNum=checkboxPropertyList.size();

    stringBuffer.append(TEXT_19);
    if(ServiceStereotypeUtil.isApplied_expExcel(uml2Class)){
    stringBuffer.append(TEXT_20);
    }
    if(ServiceStereotypeUtil.isApplied_impExcel(uml2Class)){
    stringBuffer.append(TEXT_21);
    }
    stringBuffer.append(TEXT_22);
    
/*****************************************************************
 * process search
/*****************************************************************/

    stringBuffer.append(TEXT_23);
    
if((null!=searchPropertyList&&searchPropertyList.size()>0)||radioPropertyList.size()>0||checkboxPropertyList.size()>0){
int tdCount=0;
int needTd=2;

    stringBuffer.append(TEXT_24);
    	if(TreeStereotypeHelper.getValue_treeListStyle(uml2Class).equalsIgnoreCase("treeGrid")){
    	}else{
    stringBuffer.append(TEXT_25);
    	}
    stringBuffer.append(TEXT_26);
    
/*****************************************************************
 * process radio property search 
/*****************************************************************/

    stringBuffer.append(TEXT_27);
    for (int i=0;i<radioPropertyList.size();i++){
    	Property property=radioPropertyList.get(i);
     	String propertyCommentName=TypeHelper.getDocumentationOrName(property);
     	//String propertyUncapSafeName=NameHelper.uncapSafeName(property);
    	//String propertySearchRadios=NamedUtil.getPropertyNamed(property,PropertyNamedRuleKind.searchRadios);
    	needTd=8;
    			if(tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_28);
    			}
    stringBuffer.append(TEXT_29);
    			if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_30);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_31);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    			}
    stringBuffer.append(TEXT_32);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_34);
    			tdCount+=needTd;
    stringBuffer.append(TEXT_35);
    			if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_36);
    			}
    stringBuffer.append(TEXT_37);
    }
    
/*****************************************************************
 * process checkboxPropertyList search 
/*****************************************************************/

    stringBuffer.append(TEXT_38);
    for (int i=0;i<checkboxPropertyList.size();i++){
    	Property property=checkboxPropertyList.get(i);
     	String propertyCommentName=TypeHelper.getDocumentationOrName(property);
     	//String propertyUncapSafeName=NameHelper.uncapSafeName(property);
    	//String propertySearchCheckboxs=NamedUtil.getPropertyNamed(property,PropertyNamedRuleKind.searchCheckboxs);
    	needTd=8;
    			if(tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_39);
    			}
    stringBuffer.append(TEXT_40);
    			if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_41);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_42);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    			}
    stringBuffer.append(TEXT_43);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_45);
    			tdCount+=needTd;
    			if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_46);
    			}
    stringBuffer.append(TEXT_47);
    }
    
/*****************************************************************
 * process searchPropertyList search 
/*****************************************************************/

    stringBuffer.append(TEXT_48);
    for (int i=0;i<searchPropertyList.size();i++){
    	Property property=searchPropertyList.get(i);
    	if(property.getName().equals(curProperty.getName())){
    		continue;
    	}
     	String propertyCommentName=TypeHelper.getDocumentationOrName(property);
     	String propertyUncapSafeName=NameHelper.uncapSafeName(property);
    	if(EnumKindHelper.isAppliedEnumKind(property)){//process enumKind
    		Enumeration enumeration=EnumKindHelper.getAppliedEnumKindEnumeration(property);
    		if(null!=enumeration){
    			//String modelEnumQualifiedName=MdaHelper.getModelQualifiedName(enumeration,PKGSuffix.enumeration,ModelNameSuffix.enumeration);
    			//String modelEnumName=MdaHelper.getModelClassName(enumeration,ModelNameSuffix.enumeration);
    			String modelEnumSelectHtml=NamedUtil.getPropertyNamed(enumeration,PropertyNamedRuleKind.selectHtml);
    			if(ViewInputHelper.isViewInputSelect(property)){//process select
    			needTd=2;
    			if(tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_49);
    			}
    stringBuffer.append(TEXT_50);
    			if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_51);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_52);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    			}
    stringBuffer.append(TEXT_53);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(modelEnumSelectHtml);
    stringBuffer.append(TEXT_58);
    			tdCount+=needTd;
    			}
    			if(ViewInputHelper.isViewInputRadio(property)){//process radio
    				radioPropertyList.add(property);
    			}
    			if(ViewInputHelper.isViewInputCheckbox(property)){//process radio
    				checkboxPropertyList.add(property);
    			}
    		}
    	}else if(ViewInputHelper.isViewInputDatePicker(property)){//process datePicker
    		String dateSearchStartName=NamedUtil.getPropertyNamed(property,PropertyNamedRuleKind.dateSearchStartName);
     		String dateSearchStartUncapSafeName=NameHelper.uncapName(dateSearchStartName);
    		String dateSearchEndName=NamedUtil.getPropertyNamed(property,PropertyNamedRuleKind.dateSearchEndName);
     		String dateSearchEndNameUncapSafeName=NameHelper.uncapName(dateSearchEndName);
    			needTd=4;
    			if(tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_59);
    			}
    stringBuffer.append(TEXT_60);
    			if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_61);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_62);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    			}
    stringBuffer.append(TEXT_63);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(dateSearchStartUncapSafeName);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(dateSearchStartUncapSafeName);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(dateSearchStartUncapSafeName);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(needTd-3);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(dateSearchEndNameUncapSafeName);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(dateSearchEndNameUncapSafeName);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(dateSearchEndNameUncapSafeName);
    stringBuffer.append(TEXT_72);
    			tdCount+=needTd;
    	}else{//process text
    			needTd=2;
    			if(tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_73);
    			}
    stringBuffer.append(TEXT_74);
    			if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_75);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_76);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    			}
    stringBuffer.append(TEXT_77);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_82);
    			tdCount+=needTd;
    	}
    			if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_83);
    			}
    stringBuffer.append(TEXT_84);
    }
    
/*****************************************************************
 * process  search button 
/*****************************************************************/

    stringBuffer.append(TEXT_85);
    	needTd=1;
    			if(tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_86);
    			}
    stringBuffer.append(TEXT_87);
    			if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_88);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_89);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    			}
    stringBuffer.append(TEXT_90);
    			tdCount+=needTd;
    	if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_91);
    	}
    	if (tdCount%trIncludeTd!=0){
    stringBuffer.append(TEXT_92);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_93);
    	}
    stringBuffer.append(TEXT_94);
    }
    stringBuffer.append(TEXT_95);
    	if(TreeStereotypeHelper.getValue_treeListStyle(uml2Class).equalsIgnoreCase("treeGrid")){
    	}else{
    stringBuffer.append(TEXT_96);
    stringBuffer.append(ownerClassCommentName);
    stringBuffer.append(TEXT_97);
    	}
    stringBuffer.append(TEXT_98);
    }else{/*只应用了Entity*/
    Property curProperty = (Property) argument;Package O2MManagePropertyPackage = curProperty.getNearestPackage();
    Class ownerClass=(Class)curProperty.getOwner();
    //String ownerClassCapName=NameHelper.getCapName(ownerClass);
    //String ownerClassUncapName=NameHelper.getUncapName(ownerClass);
    String ownerClassCommentName=TypeHelper.getDocumentationOrName(ownerClass);
    //Property ownerClassIdProperty=EntityHelper.getIDProperty(ownerClass);
    //String ownerClassIdPropertyName=NameHelper.uncapSafeName(ownerClassIdProperty);
    //String ownerClassIdPropertyGetter=ClassHelper.getGetAccessor(ownerClassIdProperty);
    UmlClassByPropertyWrap named=new UmlClassByPropertyWrap(curProperty);
    Class relClass=ownerClass;
    String jspScriptStart="<%@";
String jspScriptEnd="%"+">";
String jspScriptAssign="<%=";

    stringBuffer.append(jspScriptStart);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(jspScriptEnd);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(jspScriptStart);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(jspScriptEnd);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(ownerClassCommentName);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(jspScriptStart);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(jspScriptEnd);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(Config.web_resources_js_include);
    stringBuffer.append(TEXT_107);
    List<Property> codeKindPropertiesList=EnumKindHelper.getPropertiesAppliedEnumKind(relClass);
    if(null!=codeKindPropertiesList&&codeKindPropertiesList.size()>0){
    	for(Property property:codeKindPropertiesList){
    		Enumeration enumeration=EnumKindHelper.getAppliedEnumKindEnumeration(property);
    		if(null!=enumeration){
    			String modelEnumJsoncapName=NamedUtil.getPropertyNamed(enumeration,PropertyNamedRuleKind.elementJsonNamed);
    			String modelEnumQualifiedName=MdaHelper.getModelQualifiedName(enumeration,PKGSuffix.enumeration,ModelNameSuffix.enumeration);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(modelEnumJsoncapName);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(jspScriptAssign);
    stringBuffer.append(modelEnumQualifiedName);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(jspScriptEnd);
    stringBuffer.append(TEXT_111);
    		}
    	}
    }
    List<Property> datePickerList=ViewInputHelper.getViewInputDatePicker(ownerClass);
    stringBuffer.append(TEXT_112);
    if(!datePickerList.isEmpty()){
    stringBuffer.append(TEXT_113);
    }
    stringBuffer.append(TEXT_114);
    if(!datePickerList.isEmpty()){
    stringBuffer.append(TEXT_115);
    }
    stringBuffer.append(TEXT_116);
    stringBuffer.append(named.getWebPath(NameRuledWebPathKind.js_manager));
    stringBuffer.append(TEXT_117);
    //process search properties
List<Property> searchPropertyList=ViewSearchHelper.getSearchTextFieldPropertiesFromSimple(relClass);
List<Property> radioPropertyList=ViewSearchHelper.getSearchRadioFieldPropertiesFromSimple(relClass);
List<Property> checkboxPropertyList=ViewSearchHelper.getSearchCheckboxFieldPropertiesFromSimple(relClass);
if((null!=searchPropertyList&&searchPropertyList.size()>0)||radioPropertyList.size()>0||checkboxPropertyList.size()>0){
int trIncludeTd=8;
int tdCount=0;
int needTd=2;

    stringBuffer.append(TEXT_118);
    
/*****************************************************************
 * process Property category
/*****************************************************************/

    if(PropertyStereotypeHelper.hasProperty_Category(relClass)){
    	Property property=PropertyStereotypeHelper.getProperty_Category(relClass);
    stringBuffer.append(TEXT_119);
    	Class propertyType = (Class) property.getType();
    	//String propertyTypeComment = TypeHelper.getDocumentationOrName(propertyType);
    	String propertyTypeCapName = NameHelper.getCapName(propertyType);
    	//String propertyTypeUncapName = NameHelper.getUncapName(propertyType);
     	Property propertyTypeIdProperty=EntityHelper.getIDProperty(propertyType);
     	String propertyTypeIdPropertyUncapSafeName=NameHelper.uncapSafeName(propertyTypeIdProperty);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(propertyTypeCapName);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(propertyTypeCapName);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_124);
    }
    stringBuffer.append(TEXT_125);
    
/*****************************************************************
 * process radio property search 
/*****************************************************************/

    stringBuffer.append(TEXT_126);
    for (int i=0;i<radioPropertyList.size();i++){
    	Property property=radioPropertyList.get(i);
     	String propertyCommentName=TypeHelper.getDocumentationOrName(property);
     	//String propertyUncapSafeName=NameHelper.uncapSafeName(property);
    	//String propertySearchRadios=NamedUtil.getPropertyNamed(property,PropertyNamedRuleKind.searchRadios);
    	needTd=8;
    			if(tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_127);
    			}
    stringBuffer.append(TEXT_128);
    			if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_129);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_130);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    			}
    stringBuffer.append(TEXT_131);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_133);
    			tdCount+=needTd;
    stringBuffer.append(TEXT_134);
    			if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_135);
    			}
    stringBuffer.append(TEXT_136);
    }
    
/*****************************************************************
 * process checkboxPropertyList search 
/*****************************************************************/

    stringBuffer.append(TEXT_137);
    for (int i=0;i<checkboxPropertyList.size();i++){
    	Property property=checkboxPropertyList.get(i);
     	String propertyCommentName=TypeHelper.getDocumentationOrName(property);
     	//String propertyUncapSafeName=NameHelper.uncapSafeName(property);
    	//String propertySearchCheckboxs=NamedUtil.getPropertyNamed(property,PropertyNamedRuleKind.searchCheckboxs);
    	needTd=8;
    			if(tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_138);
    			}
    stringBuffer.append(TEXT_139);
    			if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_140);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_141);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    			}
    stringBuffer.append(TEXT_142);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_144);
    			tdCount+=needTd;
    			if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_145);
    			}
    stringBuffer.append(TEXT_146);
    }
    
/*****************************************************************
 * process searchPropertyList search 
/*****************************************************************/

    stringBuffer.append(TEXT_147);
    for (int i=0;i<searchPropertyList.size();i++){
    	Property property=searchPropertyList.get(i);
    	if(property.getName().equals(curProperty.getName())){
    		continue;
    	}
     	String propertyCommentName=TypeHelper.getDocumentationOrName(property);
     	String propertyUncapSafeName=NameHelper.uncapSafeName(property);
    	if(EnumKindHelper.isAppliedEnumKind(property)){//process enumKind
    		Enumeration enumeration=EnumKindHelper.getAppliedEnumKindEnumeration(property);
    		if(null!=enumeration){
    			//String modelEnumQualifiedName=MdaHelper.getModelQualifiedName(enumeration,PKGSuffix.enumeration,ModelNameSuffix.enumeration);
    			//String modelEnumName=MdaHelper.getModelClassName(enumeration,ModelNameSuffix.enumeration);
    			String modelEnumSelectHtml=NamedUtil.getPropertyNamed(enumeration,PropertyNamedRuleKind.selectHtml);
    			if(ViewInputHelper.isViewInputSelect(property)){//process select
    			needTd=2;
    			if(tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_148);
    			}
    stringBuffer.append(TEXT_149);
    			if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_150);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_151);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    			}
    stringBuffer.append(TEXT_152);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(modelEnumSelectHtml);
    stringBuffer.append(TEXT_157);
    			tdCount+=needTd;
    			}
    			if(ViewInputHelper.isViewInputRadio(property)){//process radio
    				radioPropertyList.add(property);
    			}
    			if(ViewInputHelper.isViewInputCheckbox(property)){//process radio
    				checkboxPropertyList.add(property);
    			}
    		}
    	}else if(ViewInputHelper.isViewInputDatePicker(property)){//process datePicker
    		String dateSearchStartName=NamedUtil.getPropertyNamed(property,PropertyNamedRuleKind.dateSearchStartName);
     		String dateSearchStartUncapSafeName=NameHelper.uncapName(dateSearchStartName);
    		String dateSearchEndName=NamedUtil.getPropertyNamed(property,PropertyNamedRuleKind.dateSearchEndName);
     		String dateSearchEndNameUncapSafeName=NameHelper.uncapName(dateSearchEndName);
    			needTd=4;
    			if(tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_158);
    			}
    stringBuffer.append(TEXT_159);
    			if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_160);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_161);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    			}
    stringBuffer.append(TEXT_162);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(dateSearchStartUncapSafeName);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(dateSearchStartUncapSafeName);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(dateSearchStartUncapSafeName);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(needTd-3);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(dateSearchEndNameUncapSafeName);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(dateSearchEndNameUncapSafeName);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(dateSearchEndNameUncapSafeName);
    stringBuffer.append(TEXT_171);
    			tdCount+=needTd;
    	}else{//process text
    			needTd=2;
    			if(tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_172);
    			}
    stringBuffer.append(TEXT_173);
    			if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_174);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_175);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    			}
    stringBuffer.append(TEXT_176);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_181);
    			tdCount+=needTd;
    	}
    			if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_182);
    			}
    stringBuffer.append(TEXT_183);
    }
    
/*****************************************************************
 * process  search button 
/*****************************************************************/

    stringBuffer.append(TEXT_184);
    	needTd=1;
    			if(tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_185);
    			}
    stringBuffer.append(TEXT_186);
    			if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_187);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_188);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    			}
    stringBuffer.append(TEXT_189);
    			tdCount+=needTd;
    	if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_190);
    	}
    	if (tdCount%trIncludeTd!=0){
    stringBuffer.append(TEXT_191);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_192);
    	}
    stringBuffer.append(TEXT_193);
    }
    stringBuffer.append(TEXT_194);
    }
    stringBuffer.append(TEXT_195);
    return stringBuffer.toString();
  }
}
