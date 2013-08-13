package com.jeefuse.mda.gen.template.main.java.jsp;

import net.taylor.mda.generator.parse.NameRuled.*;
import net.taylor.mda.generator.parse.NameRuled.nameRuled.*;
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

public class EntitManagerJSPProxy
{
  protected static String nl;
  public static synchronized EntitManagerJSPProxy create(String lineSeparator)
  {
    nl = lineSeparator;
    EntitManagerJSPProxy result = new EntitManagerJSPProxy();
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
  protected final String TEXT_19 = NL + NL + "</head>" + NL + "<body id=\"container\" class=\"v-container\">" + NL + "    <div id=\"header\" region=\"north\" split=\"false\" border=\"false\"  class=\"v-header\"><!-- header start -->" + NL + "\t\t<div id=\"firstTitle\" class=\"v-title\"></div>" + NL + "\t\t" + NL + "\t\t<div id=\"firstToolbar\" class=\"v-toolbar\"><!-- v-toolbar start -->";
  protected final String TEXT_20 = NL + "\t\t\t<a href=\"javascript:newData();\" class=\" l-btn l-btn-plain\" >" + NL + "\t\t\t\t<span class=\"l-btn-left\"><span  class=\"l-btn-text icon-add\">新增</span></span>" + NL + "\t\t\t</a>";
  protected final String TEXT_21 = NL + "\t\t\t<a href=\"javascript:editData()\" class=\" l-btn l-btn-plain\" >" + NL + "\t\t\t\t<span class=\"l-btn-left\"><span  class=\"l-btn-text icon-form-edit\">编辑</span></span>" + NL + "\t\t\t</a>";
  protected final String TEXT_22 = NL + "\t\t\t<a href=\"javascript:delData();\" class=\" l-btn l-btn-plain\" >" + NL + "\t\t\t\t<span class=\"l-btn-left\"><span  class=\"l-btn-text icon-remove\">删除</span></span>" + NL + "\t\t\t</a>" + NL + "\t\t\t<a href=\"javascript:delDescendantData();\" class=\" l-btn l-btn-plain\" >" + NL + "\t\t\t\t<span class=\"l-btn-left\"><span  class=\"l-btn-text icon-remove\">删除及其子节点</span></span>" + NL + "\t\t\t</a>";
  protected final String TEXT_23 = NL + "\t\t\t<a href=\"javascript:delAllData();\" class=\" l-btn l-btn-plain\" >" + NL + "\t\t\t\t<span class=\"l-btn-left\"><span  class=\"l-btn-text icon-remove\">删除所有</span></span>" + NL + "\t\t\t</a>";
  protected final String TEXT_24 = NL + "\t\t\t<a href=\"javascript:refresh()\" class=\" l-btn l-btn-plain\" >" + NL + "\t\t\t\t<span class=\"l-btn-left\"><span  class=\"l-btn-text icon-reload\">刷新</span></span>" + NL + "\t\t\t</a>" + NL + "\t\t\t<a href=\"javascript:clear()\" class=\" l-btn l-btn-plain\" >" + NL + "\t\t\t\t<span class=\"l-btn-left\"><span  class=\"l-btn-text icon-reset\">重置</span></span>" + NL + "\t\t\t</a>";
  protected final String TEXT_25 = NL + "\t\t\t<a href=\"javascript:exportExcel();\" class=\" l-btn l-btn-plain\" >" + NL + "\t\t\t\t<span class=\"l-btn-left\"><span  class=\"l-btn-text icon-excel\">导出EXCEL</span></span>" + NL + "\t\t\t</a>";
  protected final String TEXT_26 = NL + "\t\t\t<a href=\"javascript:importExcel();\" class=\" l-btn l-btn-plain\" >" + NL + "\t\t\t\t<span class=\"l-btn-left\"><span  class=\"l-btn-text icon-excel\">导入EXCEL</span></span>" + NL + "\t\t\t</a>";
  protected final String TEXT_27 = NL + "\t\t</div><!-- v-toolbar end -->" + NL + "\t\t" + NL + "\t\t<div id=\"firstSearch\" class=\"v-search\"><!-- first-search -->";
  protected final String TEXT_28 = "\t\t";
  protected final String TEXT_29 = NL + "\t\t   <form id=\"firstSearchForm\">";
  protected final String TEXT_30 = NL + "\t\t\t\t<input type=\"hidden\" id=\"parentId\" name=\"parentId\"/>";
  protected final String TEXT_31 = "   " + NL + "\t\t\t\t<table>";
  protected final String TEXT_32 = "\t\t\t\t";
  protected final String TEXT_33 = NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_34 = "\t";
  protected final String TEXT_35 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_36 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_37 = NL + "\t\t\t\t\t\t<td>" + NL + "\t\t\t\t\t\t\t <label>";
  protected final String TEXT_38 = ":</label>\t" + NL + "\t\t\t\t\t\t</td>" + NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_39 = "\">" + NL + "\t\t\t\t\t\t\t ${propertySearchRadios}" + NL + "\t\t\t\t\t\t</td>";
  protected final String TEXT_40 = "\t";
  protected final String TEXT_41 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_42 = "\t\t\t\t\t\t";
  protected final String TEXT_43 = "\t";
  protected final String TEXT_44 = NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_45 = "\t";
  protected final String TEXT_46 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_47 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_48 = NL + "\t\t\t\t\t\t<td>" + NL + "\t\t\t\t\t\t\t <label>";
  protected final String TEXT_49 = ":</label>\t" + NL + "\t\t\t\t\t\t</td>" + NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_50 = "\">" + NL + "\t\t\t\t\t\t\t ${propertySearchCheckboxs}" + NL + "\t\t\t\t\t\t</td>";
  protected final String TEXT_51 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_52 = "\t\t\t\t\t\t";
  protected final String TEXT_53 = "\t";
  protected final String TEXT_54 = NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_55 = "\t";
  protected final String TEXT_56 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_57 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_58 = NL + NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_59 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_60 = "\">" + NL + "\t\t      \t\t\t\t<select  id=\"";
  protected final String TEXT_61 = "\" name=\"";
  protected final String TEXT_62 = "\" class=\"text\">" + NL + "\t\t\t\t\t\t\t     <s:property value=\"";
  protected final String TEXT_63 = "\" escape=\"false\"/>" + NL + "\t\t\t\t\t\t\t </select>" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_64 = NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_65 = "\t";
  protected final String TEXT_66 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_67 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_68 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>开始";
  protected final String TEXT_69 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\">" + NL + "\t\t      \t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_70 = "\" name=\"";
  protected final String TEXT_71 = "\" value=\"${param.";
  protected final String TEXT_72 = "}\"   class=\"dateCN\"/>" + NL + "\t\t      \t\t\t</td>" + NL + "" + NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>结束";
  protected final String TEXT_73 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_74 = "\">" + NL + "\t\t      \t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_75 = "\" name=\"";
  protected final String TEXT_76 = "\" value=\"${param.";
  protected final String TEXT_77 = "}\"  class=\"dateCN\" />" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_78 = NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_79 = "\t";
  protected final String TEXT_80 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_81 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_82 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_83 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_84 = "\">" + NL + "\t\t      \t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_85 = "\" name=\"";
  protected final String TEXT_86 = "\" value=\"${param.";
  protected final String TEXT_87 = "}\"  class=\"text\" />" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_88 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_89 = "\t\t\t\t\t\t";
  protected final String TEXT_90 = "\t";
  protected final String TEXT_91 = NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_92 = "\t";
  protected final String TEXT_93 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_94 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_95 = NL + "\t\t\t\t\t\t<td>" + NL + "\t\t\t\t\t\t\t<div class=\"v-buttons\">" + NL + "\t\t\t\t\t\t\t\t\t<a href=\"javascript:firstSearch();\" class=\"easyui-linkbutton\" icon=\"icon-search\" > 查 询</a>" + NL + "\t\t\t\t\t\t\t</div>" + NL + "\t\t\t\t\t\t</td>";
  protected final String TEXT_96 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_97 = "\t" + NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_98 = "\"></td>" + NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_99 = "\t" + NL + "\t\t\t\t</table>" + NL + "\t\t\t</form>";
  protected final String TEXT_100 = NL + "\t\t</div><!-- first-search End-->" + NL + "     </div><!-- header end -->" + NL;
  protected final String TEXT_101 = NL + "     <!-- category start -->" + NL + "     <div id=\"category\" region=\"west\"  border=\"true\" style=\"width:210px;\">" + NL + "\t\t\t<div class=\"v-title v-title-panel\">";
  protected final String TEXT_102 = "树</div>" + NL + "\t\t\t<div id=\"firstTree\" class=\"v-tree\" ></div>" + NL + "     </div><!-- category end -->";
  protected final String TEXT_103 = "   " + NL + "" + NL + "     <!-- center start -->" + NL + "\t <div id=\"center\" region=\"center\"  border=\"true\">" + NL + "   \t\t<div id=\"firstContent\" class=\"v-content\">" + NL + "\t\t\t<div id=\"dataGrid\"  style=\"display:none;\"></div>" + NL + "\t\t</div>" + NL + "\t</div><!-- center end -->";
  protected final String TEXT_104 = "\t" + NL + "\t<!-- 导入Excel文件数据窗口 -->" + NL + "\t<div id=\"importExcelWin\"  title=\"导入Excel文件数据\" style=\"width:0px;height:0px;\"> " + NL + "\t\t<div class=\"v-section-wrap\">" + NL + "\t\t\t<div class=\"hd\">" + NL + "\t\t\t\t<span class=\"title\">导入Excel文件数据</span>" + NL + "\t\t\t</div>" + NL + "\t\t\t<div class=\"bd\">" + NL + "\t\t\t\t<form id=\"importExcelForm\" method=\"post\" class=\"v-form\">" + NL + "\t\t\t      \t<table>" + NL + "\t\t\t      \t\t<tr>" + NL + "\t\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t\t      \t\t\t\t<label>选择Excel导入文件:</label>" + NL + "\t\t\t      \t\t\t</td>" + NL + "\t\t\t      \t\t</tr>" + NL + "\t\t\t      \t\t<tr>" + NL + "\t\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t\t      \t\t\t\t<input type=\"file\" id=\"file\" name=\"file\" size=\"50\" class=\"required\" onchange=\"goolov.validete.file(this,'xls');\"/>" + NL + "\t\t\t      \t\t\t</td>" + NL + "\t\t\t      \t\t</tr>" + NL + "\t\t\t\t\t</table>" + NL + "\t\t\t\t</form>" + NL + "\t\t\t\t<div class=\"v-buttons\">" + NL + "\t\t\t\t\t\t<a href=\"javascript:void(0)\" onclick=\"importExcelSubmit();\"  class=\"easyui-linkbutton\" icon=\"icon-excel-imp\" >执行导入</a>" + NL + "\t\t\t\t\t   \t<a href=\"javascript:importExcelWinClose();\" class=\"easyui-linkbutton\" >关闭</a>" + NL + "\t\t\t\t</div>" + NL + "\t\t\t</div>" + NL + "\t\t</div>" + NL + "\t</div>";
  protected final String TEXT_105 = "\t\t\t\t\t\t" + NL + "</body>" + NL + "</html>";
  protected final String TEXT_106 = " page contentType=\"text/html;charset=UTF-8\" ";
  protected final String TEXT_107 = NL;
  protected final String TEXT_108 = " include file=\"/common/taglibs.jsp\" ";
  protected final String TEXT_109 = NL + "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">" + NL + "<html xmlns=\"http://www.w3.org/1999/xhtml\">" + NL + "<head>" + NL + "<title>";
  protected final String TEXT_110 = "管理</title>";
  protected final String TEXT_111 = NL;
  protected final String TEXT_112 = " include file=\"/common/meta.jsp\" ";
  protected final String TEXT_113 = NL + "<script src=\"";
  protected final String TEXT_114 = "\" type=\"text/javascript\"></script>" + NL + "<script>" + NL + "\tvar ctx = '${ctx}';" + NL + "\tvar theme = '${theme}';";
  protected final String TEXT_115 = NL + "\tvar ";
  protected final String TEXT_116 = "=";
  protected final String TEXT_117 = ".toHtmlJSON";
  protected final String TEXT_118 = ";";
  protected final String TEXT_119 = NL + "\timportCssFile('sys|ui|flexiGrid|contextmenu";
  protected final String TEXT_120 = "|datePicker";
  protected final String TEXT_121 = "', ctx, theme);" + NL + "\timportJsFile('jquery|blockUI|common|ui|flexiGrid|validate|contextmenu";
  protected final String TEXT_122 = "|datePicker";
  protected final String TEXT_123 = "|form";
  protected final String TEXT_124 = "', ctx);" + NL + "\timportJsFile('";
  protected final String TEXT_125 = "', ctx);" + NL + "</script>" + NL + "" + NL + "</head>" + NL + "<body id=\"container\" class=\"v-container\">" + NL + "\t<div id=\"header\" region=\"north\" split=\"false\" border=\"false\"  class=\"v-header\"><!-- header start -->" + NL + "\t\t<div id=\"first-title\" class=\"v-title\">" + NL + "\t\t\t" + NL + "\t\t</div>" + NL + "\t\t" + NL + "\t\t<div id=\"first-toolbar\" class=\"v-toolbar\"><!-- v-toolbar start -->" + NL + "\t\t\t<div class=\"v-menu\">";
  protected final String TEXT_126 = NL + "\t\t\t\t<a href=\"javascript:newData()\" class=\" l-btn l-btn-plain\" >" + NL + "\t\t\t\t\t<span class=\"l-btn-left\"><span  class=\"l-btn-text icon-add\">新增</span></span>" + NL + "\t\t\t\t</a>";
  protected final String TEXT_127 = NL + "\t\t\t\t<a href=\"javascript:editData()\" class=\" l-btn l-btn-plain\" >" + NL + "\t\t\t\t\t<span class=\"l-btn-left\"><span  class=\"l-btn-text icon-form-edit\">编辑</span></span>" + NL + "\t\t\t\t</a>";
  protected final String TEXT_128 = NL + "\t\t\t\t<a href=\"javascript:delData();\" class=\" l-btn l-btn-plain\" >" + NL + "\t\t\t\t\t<span class=\"l-btn-left\"><span  class=\"l-btn-text icon-remove\">删除</span></span>" + NL + "\t\t\t\t</a>";
  protected final String TEXT_129 = NL + "\t\t\t\t<a href=\"javascript:delAllData();\" class=\" l-btn l-btn-plain\" >" + NL + "\t\t\t\t\t<span class=\"l-btn-left\"><span  class=\"l-btn-text icon-remove\">删除所有</span></span>" + NL + "\t\t\t\t</a>";
  protected final String TEXT_130 = NL + "\t\t\t\t<a href=\"javascript:refresh()\" class=\" l-btn l-btn-plain\" >" + NL + "\t\t\t\t\t<span class=\"l-btn-left\"><span  class=\"l-btn-text icon-reload\">刷新</span></span>" + NL + "\t\t\t\t</a>" + NL + "\t\t\t\t<a href=\"javascript:clear()\" class=\" l-btn l-btn-plain\" >" + NL + "\t\t\t\t\t<span class=\"l-btn-left\"><span  class=\"l-btn-text icon-reset\">重置</span></span>" + NL + "\t\t\t\t</a>";
  protected final String TEXT_131 = NL + "\t\t\t\t<a href=\"javascript:exportExcel();\" class=\" l-btn l-btn-plain\" >" + NL + "\t\t\t\t\t<span class=\"l-btn-left\"><span  class=\"l-btn-text icon-excel\">导出EXCEL</span></span>" + NL + "\t\t\t\t</a>";
  protected final String TEXT_132 = NL + "\t\t\t\t<a href=\"javascript:importExcel();\" class=\" l-btn l-btn-plain\" >" + NL + "\t\t\t\t\t<span class=\"l-btn-left\"><span  class=\"l-btn-text icon-excel\">导入EXCEL</span></span>" + NL + "\t\t\t\t</a>";
  protected final String TEXT_133 = NL + "\t\t\t</div>" + NL + "\t\t</div><!-- v-toolbar end -->" + NL + "\t\t" + NL + "\t\t<div id=\"first-search\" class=\"v-search\"><!-- first-search -->";
  protected final String TEXT_134 = "\t\t";
  protected final String TEXT_135 = NL + "\t\t   <form id=\"firstSearchForm\">";
  protected final String TEXT_136 = "\t";
  protected final String TEXT_137 = NL + "\t\t\t\t<input type=\"hidden\" id=\"";
  protected final String TEXT_138 = "_";
  protected final String TEXT_139 = "\" name=\"";
  protected final String TEXT_140 = ".";
  protected final String TEXT_141 = "\"/>";
  protected final String TEXT_142 = "\t" + NL + "\t\t\t\t<table>" + NL;
  protected final String TEXT_143 = "\t\t\t\t";
  protected final String TEXT_144 = NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_145 = "\t";
  protected final String TEXT_146 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_147 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_148 = NL + "\t\t\t\t\t\t<td>" + NL + "\t\t\t\t\t\t\t <label>";
  protected final String TEXT_149 = ":</label>\t" + NL + "\t\t\t\t\t\t</td>" + NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_150 = "\">" + NL + "\t\t\t\t\t\t\t ${propertySearchRadios}" + NL + "\t\t\t\t\t\t</td>";
  protected final String TEXT_151 = "\t";
  protected final String TEXT_152 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_153 = "\t\t\t\t\t\t";
  protected final String TEXT_154 = "\t";
  protected final String TEXT_155 = NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_156 = "\t";
  protected final String TEXT_157 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_158 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_159 = NL + "\t\t\t\t\t\t<td>" + NL + "\t\t\t\t\t\t\t <label>";
  protected final String TEXT_160 = ":</label>\t" + NL + "\t\t\t\t\t\t</td>" + NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_161 = "\">" + NL + "\t\t\t\t\t\t\t ${propertySearchCheckboxs}" + NL + "\t\t\t\t\t\t</td>";
  protected final String TEXT_162 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_163 = "\t\t\t\t\t\t";
  protected final String TEXT_164 = "\t";
  protected final String TEXT_165 = NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_166 = "\t";
  protected final String TEXT_167 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_168 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_169 = NL + NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_170 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_171 = "\">" + NL + "\t\t      \t\t\t\t<select  id=\"";
  protected final String TEXT_172 = "\" name=\"";
  protected final String TEXT_173 = "\" class=\"text\">" + NL + "\t\t\t\t\t\t\t     <option value=\"\" >所有</option>" + NL + "\t\t\t\t\t\t\t     <s:property value=\"";
  protected final String TEXT_174 = "\" escape=\"false\"/>" + NL + "\t\t\t\t\t\t\t </select>" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_175 = NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_176 = "\t";
  protected final String TEXT_177 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_178 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_179 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>开始";
  protected final String TEXT_180 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\">" + NL + "\t\t      \t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_181 = "\" name=\"";
  protected final String TEXT_182 = "\" value=\"${param.";
  protected final String TEXT_183 = "}\"  class=\"dateCN\"/>" + NL + "\t\t      \t\t\t</td>" + NL + "" + NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>结束";
  protected final String TEXT_184 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_185 = "\">" + NL + "\t\t      \t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_186 = "\" name=\"";
  protected final String TEXT_187 = "\" value=\"${param.";
  protected final String TEXT_188 = "}\"   class=\"dateCN\"/>" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_189 = NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_190 = "\t";
  protected final String TEXT_191 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_192 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_193 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_194 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_195 = "\">" + NL + "\t\t      \t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_196 = "\" name=\"";
  protected final String TEXT_197 = "\" value=\"${param.";
  protected final String TEXT_198 = "}\"  class=\"text\"/>" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_199 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_200 = "\t\t\t\t\t\t";
  protected final String TEXT_201 = "\t";
  protected final String TEXT_202 = NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_203 = "\t";
  protected final String TEXT_204 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_205 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_206 = NL + "\t\t\t\t\t\t<td>" + NL + "\t\t\t\t\t\t\t<div class=\"v-buttons\">" + NL + "\t\t\t\t\t\t\t\t<a href=\"javascript:firstSearch();\" class=\"easyui-linkbutton\" icon=\"icon-search\" > 查 询</a>" + NL + "\t\t\t\t\t\t\t</div>" + NL + "\t\t\t\t\t\t</td>";
  protected final String TEXT_207 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_208 = "\t" + NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_209 = "\"></td>" + NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_210 = "\t" + NL + "\t\t\t\t</table>" + NL + "\t\t\t</form>";
  protected final String TEXT_211 = NL + "\t\t</div><!-- first-search End-->" + NL + "\t</div><!-- header end -->\t";
  protected final String TEXT_212 = "\t";
  protected final String TEXT_213 = "\t";
  protected final String TEXT_214 = NL + "\t<!-- category start -->" + NL + "\t<div id=\"category\" region=\"west\"  border=\"true\" class=\"v-category\">" + NL + "<!--    \t\t<div class=\"v-title v-title-panel\">";
  protected final String TEXT_215 = "树</div>-->" + NL + "    \t\t<div id=\"firstTree\" class=\"v-tree\" ></div>" + NL + "    </div><!-- cate end -->\t";
  protected final String TEXT_216 = "\t" + NL + "" + NL + "\t<div id=\"center\" region=\"center\"  border=\"true\">" + NL + "   \t\t<div id=\"first-content\">" + NL + "\t\t\t<div id=\"dataGrid\"  style=\"display:none;\"></div>" + NL + "\t\t</div>" + NL + "\t</div><!-- center end -->\t" + NL;
  protected final String TEXT_217 = "\t" + NL + "\t<!-- 导入Excel文件数据窗口 -->" + NL + "\t<div id=\"importExcelWin\"  title=\"导入Excel文件数据\" style=\"width:0px;height:0px;\"> " + NL + "\t\t<div class=\"v-section-wrap\">" + NL + "\t\t\t<div class=\"hd\">" + NL + "\t\t\t\t<span class=\"title\">导入Excel文件数据</span>" + NL + "\t\t\t</div>" + NL + "\t\t\t<div class=\"bd\">" + NL + "\t\t\t\t<form id=\"importExcelForm\" method=\"post\" class=\"v-form\">" + NL + "\t\t\t      \t<table>" + NL + "\t\t\t      \t\t<tr>" + NL + "\t\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t\t      \t\t\t\t<label>选择Excel导入文件:</label>" + NL + "\t\t\t      \t\t\t</td>" + NL + "\t\t\t      \t\t</tr>" + NL + "\t\t\t      \t\t<tr>" + NL + "\t\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t\t      \t\t\t\t<input type=\"file\" id=\"file\" name=\"file\" size=\"50\" class=\"required\" onchange=\"goolov.validete.file(this,'xls');\"/>" + NL + "\t\t\t      \t\t\t</td>" + NL + "\t\t\t      \t\t</tr>" + NL + "\t\t\t\t\t</table>" + NL + "\t\t\t\t</form>" + NL + "\t\t\t\t<div class=\"v-buttons\">" + NL + "\t\t\t\t\t\t<a href=\"javascript:void(0)\" onclick=\"importExcelSubmit();\"  class=\"easyui-linkbutton\" icon=\"icon-excel-imp\" >执行导入</a>" + NL + "\t\t\t\t\t   \t<a href=\"javascript:importExcelWinClose();\" class=\"easyui-linkbutton\" >关闭</a>" + NL + "\t\t\t\t</div>" + NL + "\t\t\t</div>" + NL + "\t\t</div>" + NL + "\t</div>";
  protected final String TEXT_218 = "\t\t\t\t\t\t" + NL + "</body>" + NL + "</html>";
  protected final String TEXT_219 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    Class uml2Class_proxy = (Class) argument;
    //Package uml2Package_proxy = uml2Class_proxy.getPackage();
    if(ModelStereoTypeHelper.isApplyModel_Tree(uml2Class_proxy)){//应用了tree
    Class uml2Class = (Class) argument;Package uml2Package = uml2Class.getPackage();
    
UmlClassWrap clazzWrap=new UmlClassWrap(uml2Class);
String modelCommentName=TypeHelper.getDocumentationOrName(uml2Class);
String modelManagerJsPath=clazzWrap.getWebPath(NameRuledWebPathKind.js_manager);
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
    stringBuffer.append(modelCommentName);
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
    stringBuffer.append(modelManagerJsPath);
    stringBuffer.append(TEXT_18);
    
List<Property> searchPropertyList=ViewSearchHelper.getSearchTextFieldPropertiesFromSimple(uml2Class);
List<Property> radioPropertyList=ViewSearchHelper.getSearchRadioFieldPropertiesFromSimple(uml2Class);
List<Property> checkboxPropertyList=ViewSearchHelper.getSearchCheckboxFieldPropertiesFromSimple(uml2Class);
int trIncludeTd=8;
//int searchTextTrNum=(searchPropertyList.size()%8)==0?(searchPropertyList.size()/8):(searchPropertyList.size()/8)+1;
//int searchRadioTrNum=radioPropertyList.size();
//int searchCheckboxTrNum=checkboxPropertyList.size();

    stringBuffer.append(TEXT_19);
    if(FunctionStereotypeUtil.isApplied_input(uml2Class)){
    stringBuffer.append(TEXT_20);
    }
    if(FunctionStereotypeUtil.isApplied_edit(uml2Class)){
    stringBuffer.append(TEXT_21);
    }
    	if(FunctionStereotypeUtil.isApplied_deleteOutJson(uml2Class)){
    stringBuffer.append(TEXT_22);
    }
    if(FunctionStereotypeUtil.isApplied_deleteAllOutJson(uml2Class)){
    stringBuffer.append(TEXT_23);
    }
    stringBuffer.append(TEXT_24);
    if(ServiceStereotypeUtil.isApplied_expExcel(uml2Class)){
    stringBuffer.append(TEXT_25);
    }
    if(ServiceStereotypeUtil.isApplied_impExcel(uml2Class)){
    stringBuffer.append(TEXT_26);
    }
    stringBuffer.append(TEXT_27);
    
/*****************************************************************
 * process search
/*****************************************************************/

    stringBuffer.append(TEXT_28);
    
if((null!=searchPropertyList&&searchPropertyList.size()>0)||radioPropertyList.size()>0||checkboxPropertyList.size()>0){
int tdCount=0;
int needTd=2;

    stringBuffer.append(TEXT_29);
    	if(TreeStereotypeHelper.getValue_treeListStyle(uml2Class).equalsIgnoreCase("treeGrid")){
    	}else{
    stringBuffer.append(TEXT_30);
    	}
    stringBuffer.append(TEXT_31);
    
/*****************************************************************
 * process radio property search 
/*****************************************************************/

    stringBuffer.append(TEXT_32);
    for (int i=0;i<radioPropertyList.size();i++){
    	Property property=radioPropertyList.get(i);
     	String propertyCommentName=TypeHelper.getDocumentationOrName(property);
     	//String propertyUncapSafeName=NameHelper.uncapSafeName(property);
    	//String propertySearchRadios=NamedUtil.getPropertyNamed(property,PropertyNamedRuleKind.searchRadios);
    	needTd=8;
    			if(tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_33);
    			}
    stringBuffer.append(TEXT_34);
    			if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_35);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_36);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    			}
    stringBuffer.append(TEXT_37);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_39);
    			tdCount+=needTd;
    stringBuffer.append(TEXT_40);
    			if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_41);
    			}
    stringBuffer.append(TEXT_42);
    }
    
/*****************************************************************
 * process checkboxPropertyList search 
/*****************************************************************/

    stringBuffer.append(TEXT_43);
    for (int i=0;i<checkboxPropertyList.size();i++){
    	Property property=checkboxPropertyList.get(i);
     	String propertyCommentName=TypeHelper.getDocumentationOrName(property);
     	//String propertyUncapSafeName=NameHelper.uncapSafeName(property);
    	//String propertySearchCheckboxs=NamedUtil.getPropertyNamed(property,PropertyNamedRuleKind.searchCheckboxs);
    	needTd=8;
    			if(tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_44);
    			}
    stringBuffer.append(TEXT_45);
    			if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_46);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_47);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    			}
    stringBuffer.append(TEXT_48);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_50);
    			tdCount+=needTd;
    			if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_51);
    			}
    stringBuffer.append(TEXT_52);
    }
    
/*****************************************************************
 * process searchPropertyList search 
/*****************************************************************/

    stringBuffer.append(TEXT_53);
    for (int i=0;i<searchPropertyList.size();i++){
    	Property property=searchPropertyList.get(i);
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
    stringBuffer.append(TEXT_54);
    			}
    stringBuffer.append(TEXT_55);
    			if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_56);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_57);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    			}
    stringBuffer.append(TEXT_58);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(modelEnumSelectHtml);
    stringBuffer.append(TEXT_63);
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
    stringBuffer.append(TEXT_64);
    			}
    stringBuffer.append(TEXT_65);
    			if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_66);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_67);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    			}
    stringBuffer.append(TEXT_68);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(dateSearchStartUncapSafeName);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(dateSearchStartUncapSafeName);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(dateSearchStartUncapSafeName);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(needTd-3);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(dateSearchEndNameUncapSafeName);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(dateSearchEndNameUncapSafeName);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(dateSearchEndNameUncapSafeName);
    stringBuffer.append(TEXT_77);
    			tdCount+=needTd;
    	}else{//process text
    			needTd=2;
    			if(tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_78);
    			}
    stringBuffer.append(TEXT_79);
    			if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_80);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_81);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    			}
    stringBuffer.append(TEXT_82);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_87);
    			tdCount+=needTd;
    	}
    			if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_88);
    			}
    stringBuffer.append(TEXT_89);
    }
    
/*****************************************************************
 * process  search button 
/*****************************************************************/

    stringBuffer.append(TEXT_90);
    	needTd=1;
    			if(tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_91);
    			}
    stringBuffer.append(TEXT_92);
    			if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_93);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_94);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    			}
    stringBuffer.append(TEXT_95);
    			tdCount+=needTd;
    	if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_96);
    	}
    	if (tdCount%trIncludeTd!=0){
    stringBuffer.append(TEXT_97);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_98);
    	}
    stringBuffer.append(TEXT_99);
    }
    stringBuffer.append(TEXT_100);
    	if(TreeStereotypeHelper.getValue_treeListStyle(uml2Class).equalsIgnoreCase("treeGrid")){
    	}else{
    stringBuffer.append(TEXT_101);
    stringBuffer.append(modelCommentName);
    stringBuffer.append(TEXT_102);
    	}
    stringBuffer.append(TEXT_103);
    if(ServiceStereotypeUtil.isApplied_impExcel(uml2Class)){
    stringBuffer.append(TEXT_104);
    }
    stringBuffer.append(TEXT_105);
    }else{//只应用了Entity
    Class uml2Class = (Class) argument;Package uml2Package = uml2Class.getPackage();
    
UmlClassWrap clazzWrap=new UmlClassWrap(uml2Class);
String modelCommentName=TypeHelper.getDocumentationOrName(uml2Class);
String modelManagerJsPath=clazzWrap.getWebPath(NameRuledWebPathKind.js_manager);
String jspScriptStart="<%@";
String jspScriptEnd="%"+">";
String jspScriptAssign="<%=";
boolean isImpExcel=false;//是否导入excel
if(ServiceStereotypeUtil.isApplied_impExcel(uml2Class)){
	isImpExcel=true;
}

    stringBuffer.append(jspScriptStart);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(jspScriptEnd);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(jspScriptStart);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(jspScriptEnd);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(modelCommentName);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(jspScriptStart);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(jspScriptEnd);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(Config.web_resources_js_include);
    stringBuffer.append(TEXT_114);
    List<Property> codeKindPropertiesList=EnumKindHelper.getPropertiesAppliedEnumKind(uml2Class);
    if(null!=codeKindPropertiesList&&codeKindPropertiesList.size()>0){
    	for(Property property:codeKindPropertiesList){
    		Enumeration enumeration=EnumKindHelper.getAppliedEnumKindEnumeration(property);
    		if(null!=enumeration){
    			String modelEnumJsoncapName=NamedUtil.getPropertyNamed(enumeration,PropertyNamedRuleKind.elementJsonNamed);
    			String modelEnumQualifiedName=MdaHelper.getModelQualifiedName(enumeration,PKGSuffix.enumeration,ModelNameSuffix.enumeration);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(modelEnumJsoncapName);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(jspScriptAssign);
    stringBuffer.append(modelEnumQualifiedName);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(jspScriptEnd);
    stringBuffer.append(TEXT_118);
    		}
    	}
    }
    List<Property> datePickerList=ViewInputHelper.getViewInputDatePicker(uml2Class);
    stringBuffer.append(TEXT_119);
    if(!datePickerList.isEmpty()){
    stringBuffer.append(TEXT_120);
    }
    stringBuffer.append(TEXT_121);
    if(!datePickerList.isEmpty()){
    stringBuffer.append(TEXT_122);
    }
    if(isImpExcel){
    stringBuffer.append(TEXT_123);
    }
    stringBuffer.append(TEXT_124);
    stringBuffer.append(modelManagerJsPath);
    stringBuffer.append(TEXT_125);
    if(FunctionStereotypeUtil.isApplied_input(uml2Class)){
    stringBuffer.append(TEXT_126);
    }
    if(FunctionStereotypeUtil.isApplied_edit(uml2Class)){
    stringBuffer.append(TEXT_127);
    }
    	if(FunctionStereotypeUtil.isApplied_deleteOutJson(uml2Class)){
    stringBuffer.append(TEXT_128);
    	}
    	if(FunctionStereotypeUtil.isApplied_deleteAllOutJson(uml2Class)){
    stringBuffer.append(TEXT_129);
    	}
    stringBuffer.append(TEXT_130);
    if(ServiceStereotypeUtil.isApplied_expExcel(uml2Class)){
    stringBuffer.append(TEXT_131);
    }
    if(ServiceStereotypeUtil.isApplied_impExcel(uml2Class)){
    stringBuffer.append(TEXT_132);
    }
    stringBuffer.append(TEXT_133);
    
/*****************************************************************
 * process search
/*****************************************************************/

    stringBuffer.append(TEXT_134);
    
List<Property> searchPropertyList=ViewSearchHelper.getSearchTextFieldPropertiesFromSimple(uml2Class);
List<Property> radioPropertyList=ViewSearchHelper.getSearchRadioFieldPropertiesFromSimple(uml2Class);
List<Property> checkboxPropertyList=ViewSearchHelper.getSearchCheckboxFieldPropertiesFromSimple(uml2Class);
if((null!=searchPropertyList&&searchPropertyList.size()>0)||radioPropertyList.size()>0||checkboxPropertyList.size()>0){
int trIncludeTd=8;
int tdCount=0;
int needTd=2;

    stringBuffer.append(TEXT_135);
    
/*****************************************************************
 * process Property category
/*****************************************************************/

    if(PropertyStereotypeHelper.hasProperty_Category(uml2Class)){
    	Property property=PropertyStereotypeHelper.getProperty_Category(uml2Class);
    stringBuffer.append(TEXT_136);
    	Class propertyType = (Class) property.getType();
    	//String propertyTypeComment = TypeHelper.getDocumentationOrName(propertyType);
    	String propertyTypeCapName = NameHelper.getCapName(propertyType);
    	//String propertyTypeUncapName = NameHelper.getUncapName(propertyType);
     	Property propertyTypeIdProperty=EntityHelper.getIDProperty(propertyType);
     	String propertyTypeIdPropertyUncapSafeName=NameHelper.uncapSafeName(propertyTypeIdProperty);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(propertyTypeCapName);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(propertyTypeCapName);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_141);
    }
    stringBuffer.append(TEXT_142);
    
/*****************************************************************
 * process radio property search 
/*****************************************************************/

    stringBuffer.append(TEXT_143);
    for (int i=0;i<radioPropertyList.size();i++){
    	Property property=radioPropertyList.get(i);
     	String propertyCommentName=TypeHelper.getDocumentationOrName(property);
     //	String propertyUncapSafeName=NameHelper.uncapSafeName(property);
    	//String propertySearchRadios=NamedUtil.getPropertyNamed(property,PropertyNamedRuleKind.searchRadios);
    	needTd=8;
    			if(tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_144);
    			}
    stringBuffer.append(TEXT_145);
    			if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_146);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_147);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    			}
    stringBuffer.append(TEXT_148);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_150);
    			tdCount+=needTd;
    stringBuffer.append(TEXT_151);
    			if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_152);
    			}
    stringBuffer.append(TEXT_153);
    }
    
/*****************************************************************
 * process checkboxPropertyList search 
/*****************************************************************/

    stringBuffer.append(TEXT_154);
    for (int i=0;i<checkboxPropertyList.size();i++){
    	Property property=checkboxPropertyList.get(i);
     	String propertyCommentName=TypeHelper.getDocumentationOrName(property);
     	//String propertyUncapSafeName=NameHelper.uncapSafeName(property);
    	//String propertySearchCheckboxs=NamedUtil.getPropertyNamed(property,PropertyNamedRuleKind.searchCheckboxs);
    	needTd=8;
    			if(tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_155);
    			}
    stringBuffer.append(TEXT_156);
    			if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_157);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_158);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    			}
    stringBuffer.append(TEXT_159);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_161);
    			tdCount+=needTd;
    			if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_162);
    			}
    stringBuffer.append(TEXT_163);
    }
    
/*****************************************************************
 * process searchPropertyList search 
/*****************************************************************/

    stringBuffer.append(TEXT_164);
    for (int i=0;i<searchPropertyList.size();i++){
    	Property property=searchPropertyList.get(i);
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
    stringBuffer.append(TEXT_165);
    			}
    stringBuffer.append(TEXT_166);
    			if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_167);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_168);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    			}
    stringBuffer.append(TEXT_169);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(modelEnumSelectHtml);
    stringBuffer.append(TEXT_174);
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
    stringBuffer.append(TEXT_175);
    			}
    stringBuffer.append(TEXT_176);
    			if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_177);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_178);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    			}
    stringBuffer.append(TEXT_179);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(dateSearchStartUncapSafeName);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(dateSearchStartUncapSafeName);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(dateSearchStartUncapSafeName);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(needTd-3);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(dateSearchEndNameUncapSafeName);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(dateSearchEndNameUncapSafeName);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(dateSearchEndNameUncapSafeName);
    stringBuffer.append(TEXT_188);
    			tdCount+=needTd;
    	}else{//process text
    			needTd=2;
    			if(tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_189);
    			}
    stringBuffer.append(TEXT_190);
    			if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_191);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_192);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    			}
    stringBuffer.append(TEXT_193);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_198);
    			tdCount+=needTd;
    	}
    			if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_199);
    			}
    stringBuffer.append(TEXT_200);
    }
    
/*****************************************************************
 * process  search button 
/*****************************************************************/

    stringBuffer.append(TEXT_201);
    	needTd=1;
    			if(tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_202);
    			}
    stringBuffer.append(TEXT_203);
    			if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_204);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_205);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    			}
    stringBuffer.append(TEXT_206);
    			tdCount+=needTd;
    	if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_207);
    	}
    	if (tdCount%trIncludeTd!=0){
    stringBuffer.append(TEXT_208);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_209);
    	}
    stringBuffer.append(TEXT_210);
    }
    stringBuffer.append(TEXT_211);
    
/*****************************************************************
 * process Property category
/*****************************************************************/

    stringBuffer.append(TEXT_212);
    if(PropertyStereotypeHelper.hasProperty_Category(uml2Class)){
    	Property property=PropertyStereotypeHelper.getProperty_Category(uml2Class);
    stringBuffer.append(TEXT_213);
    	Class propertyType = (Class) property.getType();
    	String propertyTypeComment = TypeHelper.getDocumentationOrName(propertyType);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(propertyTypeComment);
    stringBuffer.append(TEXT_215);
    }
    stringBuffer.append(TEXT_216);
    if(ServiceStereotypeUtil.isApplied_impExcel(uml2Class)){
    stringBuffer.append(TEXT_217);
    }
    stringBuffer.append(TEXT_218);
    }
    stringBuffer.append(TEXT_219);
    return stringBuffer.toString();
  }
}
