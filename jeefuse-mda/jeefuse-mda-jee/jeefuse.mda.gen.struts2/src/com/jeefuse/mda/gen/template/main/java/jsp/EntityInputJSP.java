package com.jeefuse.mda.gen.template.main.java.jsp;

import net.taylor.mda.generator.parse.NameRuled.nameRuled.*;
import net.taylor.mda.generator.parse.NameRuled.*;
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

public class EntityInputJSP
{
  protected static String nl;
  public static synchronized EntityInputJSP create(String lineSeparator)
  {
    nl = lineSeparator;
    EntityInputJSP result = new EntityInputJSP();
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
  protected final String TEXT_10 = "\" type=\"text/javascript\"></script>" + NL + "<script>" + NL + "\tvar ctx = '${ctx}';" + NL + "\tvar theme = '${theme}';" + NL + "\timportCssFile('sys|ui";
  protected final String TEXT_11 = "|flexiGrid";
  protected final String TEXT_12 = "|treeview";
  protected final String TEXT_13 = "', ctx, theme);" + NL + "\timportJsFile('jquery|ui|common|blockUI|form|validate";
  protected final String TEXT_14 = "|fckeditor";
  protected final String TEXT_15 = "|flexiGrid|comboGrid";
  protected final String TEXT_16 = "|treeview|combotree";
  protected final String TEXT_17 = "', ctx);" + NL + "\timportJsFile('";
  protected final String TEXT_18 = "', ctx);" + NL + "</script>" + NL + "</head>" + NL + "<body class=\"easyui-layout v-container\">" + NL + " \t<div region=\"center\" border=\"false\"><!-- center start -->";
  protected final String TEXT_19 = NL + "\t\t<div id=\"firstTabs\" class=\"v-tabs\"><!-- firstTabs start -->" + NL + "\t\t  <div title=\"基本信息\"  class=\"v-tab\"><!-- tab one  start -->";
  protected final String TEXT_20 = NL + " \t\t\t<form id=\"inputForm\" method=\"post\" class=\"v-form\">";
  protected final String TEXT_21 = NL + " \t\t\t\t<input type=\"hidden\" name=\"";
  protected final String TEXT_22 = "\" value=\"${mo.";
  protected final String TEXT_23 = "}\"/>";
  protected final String TEXT_24 = NL + " \t\t\t\t<!--<div id=\"inputInfo\" class=\"v-state-info\"></div>-->" + NL + "\t\t      \t<table>";
  protected final String TEXT_25 = NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_26 = "\t";
  protected final String TEXT_27 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_28 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_29 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_30 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_31 = "\">" + NL + "\t\t      \t\t\t\t${mo.";
  protected final String TEXT_32 = "}" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_33 = "\t";
  protected final String TEXT_34 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_35 = "\t\t\t\t\t\t";
  protected final String TEXT_36 = NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_37 = "\t";
  protected final String TEXT_38 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_39 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_40 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_41 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_42 = "\">" + NL + "\t\t      \t\t\t\t<c:choose>" + NL + "\t\t\t\t\t\t  \t \t<c:when test=\"${null==model.id}\">" + NL + "\t\t\t\t\t\t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_43 = "\" name=\"";
  protected final String TEXT_44 = "\" value=\"${mo.";
  protected final String TEXT_45 = "}\" class=\"";
  protected final String TEXT_46 = "\"/>" + NL + "\t\t\t\t\t\t \t    </c:when>" + NL + "\t\t\t\t\t\t   \t    <c:otherwise>" + NL + "\t\t\t\t\t\t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_47 = "\" name=\"";
  protected final String TEXT_48 = "\" value=\"${mo.";
  protected final String TEXT_49 = "}\" class=\"";
  protected final String TEXT_50 = " readonly\" readonly='readonly' />" + NL + "\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"oldId\" name=\"oldId\" value=\"${mo.";
  protected final String TEXT_51 = "}\"/>" + NL + "\t\t\t\t\t\t\t    </c:otherwise>" + NL + "\t\t\t\t\t\t\t</c:choose> " + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_52 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_53 = "\t\t\t\t\t\t";
  protected final String TEXT_54 = NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_55 = "\t";
  protected final String TEXT_56 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_57 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_58 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_59 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_60 = "\">" + NL + "\t\t\t\t\t\t\t <select name=\"";
  protected final String TEXT_61 = "\" id=\"";
  protected final String TEXT_62 = "\" class=\"text ";
  protected final String TEXT_63 = "readonly";
  protected final String TEXT_64 = "\" ";
  protected final String TEXT_65 = "readonly=\"readonly\"";
  protected final String TEXT_66 = ">" + NL + "\t\t\t\t\t\t\t     <option value=\"\" >无</option>" + NL + "\t\t\t\t\t\t\t     <s:property value=\"htmlSelectTree\" escape=\"false\"/>" + NL + "\t\t\t\t\t\t\t  </select>" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_67 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_68 = "\t\t\t\t\t\t";
  protected final String TEXT_69 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_70 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_71 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_72 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_73 = "\">";
  protected final String TEXT_74 = NL + "\t\t      \t\t\t\t${mo.";
  protected final String TEXT_75 = "}";
  protected final String TEXT_76 = NL + "\t\t      \t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_77 = "\" name=\"";
  protected final String TEXT_78 = "\" value=\"${mo.";
  protected final String TEXT_79 = "}\" class=\"";
  protected final String TEXT_80 = "\" />";
  protected final String TEXT_81 = NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_82 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_83 = "\t\t\t\t\t\t";
  protected final String TEXT_84 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_85 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_86 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_87 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_88 = "\">";
  protected final String TEXT_89 = NL + "\t\t      \t\t\t\t\t${mo.";
  protected final String TEXT_90 = "}";
  protected final String TEXT_91 = NL + "\t\t      \t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_92 = "\" name=\"";
  protected final String TEXT_93 = "\" value=\"${mo.";
  protected final String TEXT_94 = "}\" class=\"";
  protected final String TEXT_95 = "\" ";
  protected final String TEXT_96 = "readonly=\"readonly\"";
  protected final String TEXT_97 = "/>";
  protected final String TEXT_98 = "\t\t\t\t\t\t\t" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_99 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_100 = "\t\t\t\t\t\t";
  protected final String TEXT_101 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_102 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_103 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_104 = ":</label>" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_105 = NL + "\t\t\t\t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_106 = "\">" + NL + "\t\t\t\t\t\t\t <select  id=\"";
  protected final String TEXT_107 = "\" name=\"";
  protected final String TEXT_108 = "\" class=\"";
  protected final String TEXT_109 = "\" ";
  protected final String TEXT_110 = "readonly";
  protected final String TEXT_111 = "\" ";
  protected final String TEXT_112 = "readonly=\"readonly\"";
  protected final String TEXT_113 = ">" + NL + "\t\t\t\t\t\t\t     <s:property value=\"";
  protected final String TEXT_114 = "\" escape=\"false\"/>" + NL + "\t\t\t\t\t\t\t </select>" + NL + "\t\t\t\t\t\t</td>";
  protected final String TEXT_115 = NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_116 = "\">";
  protected final String TEXT_117 = NL + "\t\t      \t\t\t\t\t${mo.";
  protected final String TEXT_118 = "}";
  protected final String TEXT_119 = NL + "\t\t      \t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_120 = "\" name=\"";
  protected final String TEXT_121 = "\" value=\"${mo.";
  protected final String TEXT_122 = "}\" class=\"";
  protected final String TEXT_123 = "\" ";
  protected final String TEXT_124 = "readonly=\"readonly\"";
  protected final String TEXT_125 = "/>";
  protected final String TEXT_126 = "\t" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_127 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_128 = "\t\t\t\t\t\t";
  protected final String TEXT_129 = "\t";
  protected final String TEXT_130 = "\t";
  protected final String TEXT_131 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_132 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_133 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_134 = ":</label>" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_135 = NL + "\t\t\t\t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_136 = "\">" + NL + "\t\t\t\t\t\t\t ${";
  protected final String TEXT_137 = "}" + NL + "\t\t\t\t\t\t</td>";
  protected final String TEXT_138 = NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_139 = "\">";
  protected final String TEXT_140 = NL + "\t\t      \t\t\t\t\t${mo.";
  protected final String TEXT_141 = "}";
  protected final String TEXT_142 = NL + "\t\t      \t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_143 = "\" name=\"";
  protected final String TEXT_144 = "\" value=\"${mo.";
  protected final String TEXT_145 = "}\" class=\"";
  protected final String TEXT_146 = "\" ";
  protected final String TEXT_147 = "readonly=\"readonly\"";
  protected final String TEXT_148 = "/>";
  protected final String TEXT_149 = "\t" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_150 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_151 = "\t\t\t\t\t\t";
  protected final String TEXT_152 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_153 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_154 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_155 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_156 = "\">";
  protected final String TEXT_157 = NL + "\t\t      \t\t\t\t\t${mo.";
  protected final String TEXT_158 = "}";
  protected final String TEXT_159 = NL + "\t\t      \t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_160 = "\" name=\"";
  protected final String TEXT_161 = "\" value=\"${mo.";
  protected final String TEXT_162 = "}\" class=\"";
  protected final String TEXT_163 = "\" ";
  protected final String TEXT_164 = "readonly=\"readonly\"";
  protected final String TEXT_165 = "/>";
  protected final String TEXT_166 = "\t" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_167 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_168 = "\t\t\t\t\t\t";
  protected final String TEXT_169 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_170 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_171 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_172 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_173 = "\">";
  protected final String TEXT_174 = NL + "\t\t      \t\t\t\t\t${mo.";
  protected final String TEXT_175 = "}";
  protected final String TEXT_176 = NL + "\t\t      \t\t\t\t<textarea id=\"";
  protected final String TEXT_177 = "\" name=\"";
  protected final String TEXT_178 = "\"  class=\"";
  protected final String TEXT_179 = "\" >${mo.";
  protected final String TEXT_180 = "}</textarea>";
  protected final String TEXT_181 = "\t" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_182 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_183 = "\t\t\t\t\t\t";
  protected final String TEXT_184 = "\t\t";
  protected final String TEXT_185 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_186 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_187 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_188 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_189 = "\">";
  protected final String TEXT_190 = NL + "\t\t      \t\t\t\t\t${mo.";
  protected final String TEXT_191 = "}";
  protected final String TEXT_192 = NL + "\t\t      \t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_193 = "\" name=\"";
  protected final String TEXT_194 = "\" value=\"${mo.";
  protected final String TEXT_195 = "}\" class=\"";
  protected final String TEXT_196 = "\" />";
  protected final String TEXT_197 = "\t\t\t      \t\t" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_198 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_199 = "\t\t\t\t\t\t";
  protected final String TEXT_200 = "\t\t";
  protected final String TEXT_201 = "\t\t\t";
  protected final String TEXT_202 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_203 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_204 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_205 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_206 = "\">" + NL + "\t\t      \t\t\t\t<input type=\"file\" id=\"";
  protected final String TEXT_207 = "_file\" name=\"";
  protected final String TEXT_208 = "_file\"  onchange=\"";
  protected final String TEXT_209 = "Browse(this);\" size=\"50\" />" + NL + "<!--\t\t      \t\t\t\t<a href=\"javascript:";
  protected final String TEXT_210 = "Reset();\" class=\"easyui-linkbutton\" >重置</a>-->" + NL + "\t\t\t                <br/>\t\t\t\t" + NL + "\t\t      \t\t\t\t<div class=\"fileWrap\" style=\"width:160px;height: 155px;\">" + NL + "\t\t\t                \t<!-- uploaded image -->" + NL + "\t\t\t\t\t\t\t\t<div id=\"";
  protected final String TEXT_211 = "_file_uploaded\" class=\"item\">" + NL + "\t\t\t\t\t\t\t\t\t<c:if test=\"${null!=mo.";
  protected final String TEXT_212 = "}\">" + NL + "\t\t\t   \t\t\t\t\t\t\t\t${mo.";
  protected final String TEXT_213 = "}<span class=\"label\">已上传</span>" + NL + "\t\t\t   \t\t\t\t\t\t\t\t<a href=\"javascript:";
  protected final String TEXT_214 = "Del('${mo.";
  protected final String TEXT_215 = "}');\" class=\"remove\" >删除</a> " + NL + "\t\t\t   \t\t\t\t\t\t</c:if>" + NL + "\t\t\t   \t\t\t\t\t</div>" + NL + "\t   \t\t\t\t\t\t\t<div style=\"clear: both\"></div>" + NL + "\t   \t\t\t\t\t\t</div>  \t\t" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_216 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_217 = "\t\t\t\t\t\t";
  protected final String TEXT_218 = "\t\t";
  protected final String TEXT_219 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_220 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_221 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_222 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_223 = "\">" + NL + "\t\t      \t\t\t\t<input type=\"file\" id=\"";
  protected final String TEXT_224 = "_image\" name=\"";
  protected final String TEXT_225 = "_image\"  onchange=\"";
  protected final String TEXT_226 = "Browse(this);\" size=\"50\" />" + NL + "<!--\t\t      \t\t\t\t<a href=\"javascript:";
  protected final String TEXT_227 = "Reset();\" class=\"easyui-linkbutton\" >重置</a>-->" + NL + "\t\t      \t\t\t\t<br/>" + NL + "\t\t\t \t         \t<font color=\"green\">支持JPG,JPEG,GIF,BMP图片格式(宽:150px,高:140px) </font>" + NL + "\t\t\t                <br/>\t\t\t\t" + NL + "\t\t      \t\t\t\t<div class=\"imageWrap\" style=\"width:160px;height: 155px;\">" + NL + "\t\t\t                \t<!-- uploaded image -->" + NL + "\t\t\t\t\t\t\t\t<div id=\"";
  protected final String TEXT_228 = "_image_uploaded\" class=\"imageItem\">" + NL + "\t\t\t                    \t<c:choose>" + NL + "\t\t\t                    \t\t<c:when test=\"${null==mo.";
  protected final String TEXT_229 = "}\">" + NL + "\t\t\t\t\t\t\t\t\t\t\t<img id=\"";
  protected final String TEXT_230 = "_image_item_uploaded_preview\" src=\"${ctx}/resources/style/default/images/diningDefaultNoPicture.jpg\"  width=\"150px\" height=\"140px\" />" + NL + "\t\t\t\t\t\t        \t\t</c:when>" + NL + "\t\t\t   \t\t\t\t\t\t\t<c:otherwise>" + NL + "\t\t\t   \t\t\t\t\t\t\t\t<img id=\"";
  protected final String TEXT_231 = "_image_item_uploaded_preview\" src=\"${ctx}/${mo.";
  protected final String TEXT_232 = "}\"  width=\"150px\" height=\"140px\" /><br/>" + NL + "\t\t\t   \t\t\t\t\t\t\t\t<span class=\"label\">已上传</span>" + NL + "\t\t\t   \t\t\t\t\t\t\t\t<!-- <a href=\"javascript:";
  protected final String TEXT_233 = "Del('${mo.";
  protected final String TEXT_234 = "}');\" class=\"remove\" >删除</a> -->" + NL + "\t\t\t   \t\t\t\t\t\t\t</c:otherwise>" + NL + "\t\t\t\t\t\t\t\t\t</c:choose> " + NL + "\t\t\t   \t\t\t\t\t</div>" + NL + "\t\t\t   \t\t\t\t\t<div id=\"";
  protected final String TEXT_235 = "_image_browse\" class=\"imageItem\" style=\"display: none\">" + NL + "\t\t\t\t\t\t        \t<div id=\"";
  protected final String TEXT_236 = "_image_browse_preview\"></div>" + NL + "\t\t\t\t\t\t        \t<div class=\"bottom\">" + NL + "\t\t\t\t\t\t        \t\t<a class=\"remove\" href=\"javascript:void(0);\" onclick=\"";
  protected final String TEXT_237 = "PreviewRemove();\">删除</a>" + NL + "\t\t\t\t\t\t        \t</div>" + NL + "\t\t\t\t\t\t      \t</div>" + NL + "\t   \t\t\t\t\t\t\t<div style=\"clear: both\"></div>" + NL + "\t   \t\t\t\t\t\t</div>  \t\t" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_238 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_239 = "\t\t\t\t\t\t";
  protected final String TEXT_240 = "\t";
  protected final String TEXT_241 = "\t\t";
  protected final String TEXT_242 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_243 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_244 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_245 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t\t\t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_246 = "\">" + NL + "\t\t\t\t\t\t\t <input type=\"hidden\" id=\"";
  protected final String TEXT_247 = "_";
  protected final String TEXT_248 = "\" name=\"";
  protected final String TEXT_249 = ".";
  protected final String TEXT_250 = "\" value=\"${mo.";
  protected final String TEXT_251 = "_";
  protected final String TEXT_252 = "}\" class=\"text\" />" + NL + "\t\t\t\t\t\t\t <input type=\"text\" id=\"";
  protected final String TEXT_253 = "_";
  protected final String TEXT_254 = "\" name=\"";
  protected final String TEXT_255 = ".";
  protected final String TEXT_256 = "\" value=\"${mo.";
  protected final String TEXT_257 = ".";
  protected final String TEXT_258 = "}\" class=\"text\" />" + NL + "\t\t\t\t\t\t</td>";
  protected final String TEXT_259 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_260 = "\t\t\t\t\t\t";
  protected final String TEXT_261 = "\t";
  protected final String TEXT_262 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_263 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_264 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_265 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t\t\t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_266 = "\">";
  protected final String TEXT_267 = NL + "\t\t      \t\t\t\t\t${mo.";
  protected final String TEXT_268 = ".";
  protected final String TEXT_269 = "}";
  protected final String TEXT_270 = NL + "\t\t\t\t\t\t\t <input type=\"hidden\" id=\"";
  protected final String TEXT_271 = "_";
  protected final String TEXT_272 = "\" name=\"";
  protected final String TEXT_273 = ".";
  protected final String TEXT_274 = "\" value=\"${mo.";
  protected final String TEXT_275 = ".";
  protected final String TEXT_276 = "}\"/>" + NL + "\t\t\t\t\t\t\t <input type=\"text\" id=\"";
  protected final String TEXT_277 = "_";
  protected final String TEXT_278 = "\" name=\"";
  protected final String TEXT_279 = ".";
  protected final String TEXT_280 = "\" value=\"${mo.";
  protected final String TEXT_281 = ".";
  protected final String TEXT_282 = "}\"  class=\"text select\" onclick=\"";
  protected final String TEXT_283 = "();\"/>" + NL + "\t\t\t\t\t\t\t <img class=\"clear\" id=\"";
  protected final String TEXT_284 = "_";
  protected final String TEXT_285 = "_clear\" src=\"${ctx}/resources/style/default/tree/images/s.gif\" alt=\"清空\" onclick=\"javascript:relGlDiningSiteListForSelectClear();\" align=\"middle\"/>\t\t";
  protected final String TEXT_286 = "\t\t" + NL + "\t\t\t\t\t\t</td>";
  protected final String TEXT_287 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_288 = "\t\t\t\t\t\t";
  protected final String TEXT_289 = "\t";
  protected final String TEXT_290 = "\t";
  protected final String TEXT_291 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_292 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_293 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_294 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t\t\t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_295 = "\">" + NL + "\t\t\t\t\t\t\t <input type=\"hidden\" id=\"";
  protected final String TEXT_296 = "_";
  protected final String TEXT_297 = "\" name=\"";
  protected final String TEXT_298 = ".";
  protected final String TEXT_299 = "\" value=\"${mo.";
  protected final String TEXT_300 = "_";
  protected final String TEXT_301 = "}\" class=\"text\" />" + NL + "\t\t\t\t\t\t\t <input type=\"text\" id=\"";
  protected final String TEXT_302 = "_";
  protected final String TEXT_303 = "\" name=\"";
  protected final String TEXT_304 = ".";
  protected final String TEXT_305 = "\" value=\"${mo.";
  protected final String TEXT_306 = ".";
  protected final String TEXT_307 = "}\" class=\"text\" />" + NL + "\t\t\t\t\t\t</td>";
  protected final String TEXT_308 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_309 = "\t\t\t\t\t\t";
  protected final String TEXT_310 = "\t";
  protected final String TEXT_311 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_312 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_313 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_314 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t\t\t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_315 = "\">";
  protected final String TEXT_316 = NL + "\t\t      \t\t\t\t\t${mo.";
  protected final String TEXT_317 = ".";
  protected final String TEXT_318 = "}";
  protected final String TEXT_319 = NL + "\t\t\t\t\t\t\t <input type=\"hidden\" id=\"";
  protected final String TEXT_320 = "_";
  protected final String TEXT_321 = "\" name=\"";
  protected final String TEXT_322 = ".";
  protected final String TEXT_323 = "\" value=\"${mo.";
  protected final String TEXT_324 = ".";
  protected final String TEXT_325 = "}\" />" + NL + "\t\t\t\t\t\t\t <input type=\"text\" id=\"";
  protected final String TEXT_326 = "_";
  protected final String TEXT_327 = "\" name=\"";
  protected final String TEXT_328 = ".";
  protected final String TEXT_329 = "\" value=\"${mo.";
  protected final String TEXT_330 = ".";
  protected final String TEXT_331 = "}\"  class=\"text select\" readonly=\"readonly\" onclick=\"";
  protected final String TEXT_332 = "();\"/>" + NL + "\t\t\t\t\t\t\t <img class=\"clear\" id=\"";
  protected final String TEXT_333 = "_";
  protected final String TEXT_334 = "_clear\" src=\"${ctx}/resources/style/default/tree/images/s.gif\" alt=\"清空\" onclick=\"javascript:relGlDiningSiteListForSelectClear();\" align=\"middle\"/>\t\t";
  protected final String TEXT_335 = "\t" + NL + "\t\t\t\t\t\t</td>";
  protected final String TEXT_336 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_337 = "\t\t\t\t\t\t";
  protected final String TEXT_338 = "\t";
  protected final String TEXT_339 = "\t" + NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_340 = "\"></td>" + NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_341 = "\t";
  protected final String TEXT_342 = NL + "\t\t\t\t\t<tr>" + NL + "\t\t      \t\t\t<td colspan=\"";
  protected final String TEXT_343 = "\">" + NL + "\t\t      \t\t\t\t<div class=\"v-fieldset-wrap\">" + NL + "\t\t\t      \t\t\t\t<fieldset>" + NL + "\t\t\t\t\t              <legend>" + NL + "\t\t\t\t\t                 \t";
  protected final String TEXT_344 = ":" + NL + "\t\t\t\t\t              </legend>" + NL + "\t\t\t\t\t              <div class=\"v-fieldset-content\">" + NL + "\t\t\t\t\t                \t${";
  protected final String TEXT_345 = "}" + NL + "\t\t\t\t\t\t\t      </div>" + NL + "\t\t\t\t\t            </fieldset>" + NL + "\t\t      \t\t\t\t</div>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t</tr>";
  protected final String TEXT_346 = NL + "\t\t\t\t\t<tr>" + NL + "\t\t      \t\t\t<td colspan=\"";
  protected final String TEXT_347 = "\">" + NL + "\t\t      \t\t\t\t<div class=\"v-tree-wrap\">" + NL + "\t\t\t\t\t\t\t\t<div class=\"v-title\">";
  protected final String TEXT_348 = "：</div>" + NL + "\t\t\t\t\t\t\t\t<div class=\"v-content\" id=\"";
  protected final String TEXT_349 = "\" style=\"height:270px; width:350px; overflow: auto;\">" + NL + "\t\t\t\t\t\t\t\t</div>" + NL + "\t\t\t\t\t\t\t</div>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t</tr>";
  protected final String TEXT_350 = NL + "\t\t\t\t\t<tr>" + NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_351 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" ";
  protected final String TEXT_352 = "colspan=\"";
  protected final String TEXT_353 = "\"";
  protected final String TEXT_354 = ">" + NL + "\t\t\t \t         \t <input type=\"file\" id=\"uploadImage_";
  protected final String TEXT_355 = "\" name=\"uploadImage_";
  protected final String TEXT_356 = "\" size=\"35\"/><br/>" + NL + "\t\t\t \t         \t <div id=\"previewImageWrap_";
  protected final String TEXT_357 = "\">" + NL + "\t\t\t \t         \t \t<img id=\"previewImage_";
  protected final String TEXT_358 = "\" src=\"\"/>" + NL + "\t\t\t \t         \t </div>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t</tr>";
  protected final String TEXT_359 = NL + "\t\t\t\t\t<tr>" + NL + "\t\t\t\t       <td class=\"label\">" + NL + "\t\t\t\t       \t\t<label>";
  protected final String TEXT_360 = ":</label>" + NL + "\t\t\t\t       </td>" + NL + "\t\t\t\t       <td class=\"field\" ";
  protected final String TEXT_361 = "colspan=\"";
  protected final String TEXT_362 = "\"";
  protected final String TEXT_363 = ">" + NL + "\t\t\t\t\t   \t\t<input type=\"file\" id=\"";
  protected final String TEXT_364 = "\" name=\"";
  protected final String TEXT_365 = "\" size=\"35\" onchange=\"goolov.validete.file(this);\"/>" + NL + "\t\t\t\t   \t   </td>" + NL + "\t\t\t\t   \t</tr>";
  protected final String TEXT_366 = NL + "\t\t\t\t\t<tr>" + NL + "\t\t\t\t\t  <td colspan=\"";
  protected final String TEXT_367 = "\">" + NL + "\t\t\t\t\t  \t<div class=\"v-section-wrap\">" + NL + "\t\t\t\t\t  \t\t<div class=\"v-title\">";
  protected final String TEXT_368 = ":</div>" + NL + "\t\t\t\t\t  \t\t<div class=\"v-content\" style=\"margin: 0px auto;width:95%\">" + NL + "\t\t\t\t\t  \t\t\t<input type=\"hidden\" id=\"";
  protected final String TEXT_369 = "\" name=\"";
  protected final String TEXT_370 = "\"/>" + NL + "\t\t\t\t\t  \t\t\t<textarea style=\"width:100%;\"  id=\"fck_";
  protected final String TEXT_371 = "\">" + NL + "\t\t\t\t\t      \t\t  ${mo.";
  protected final String TEXT_372 = "}" + NL + "\t\t\t\t\t   \t\t\t</textarea>" + NL + "\t\t\t\t\t\t\t  \t<script type=\"text/javascript\">" + NL + "\t\t\t\t\t\t             var oFCKeditor = new FCKeditor('fck_";
  protected final String TEXT_373 = "') ; " + NL + "\t\t\t\t\t                 oFCKeditor.BasePath\t= '${ctx}/resources/fckeditor/' ;" + NL + "\t\t\t\t\t                 oFCKeditor.Config[\"CustomConfigurationsPath\"]=\"${ctx}/resources/fckeditor/customConfig.js\";" + NL + "\t\t\t\t\t\t             oFCKeditor.ToolbarSet='goolovEdit';" + NL + "\t\t\t\t\t\t             oFCKeditor.Config[\"TabSpaces\"]=2;" + NL + "\t\t\t\t\t\t             oFCKeditor.Config[\"LinkUpload\"] = false;" + NL + "\t\t\t\t\t\t             oFCKeditor.Config[\"ImageUpload\"] = true;" + NL + "\t\t\t\t\t\t             oFCKeditor.Config[\"FlashUpload\"] = false;" + NL + "\t\t\t\t\t\t             oFCKeditor.Height\t= 350;" + NL + "\t\t\t\t\t                 oFCKeditor.ReplaceTextarea(); " + NL + "\t\t\t\t\t            </script>" + NL + "\t\t\t\t\t          </div>" + NL + "\t\t\t\t\t  \t </div>" + NL + "\t\t\t\t\t  </td>" + NL + "\t\t\t\t   </tr>\t      ";
  protected final String TEXT_374 = NL + "\t\t\t\t</table>" + NL + "\t\t\t  </form>";
  protected final String TEXT_375 = NL + "\t\t\t</div><!-- tab one end -->";
  protected final String TEXT_376 = NL + "\t  \t\t<div title=\"";
  protected final String TEXT_377 = "\"><!--";
  protected final String TEXT_378 = " tab start-->" + NL + "\t\t  \t\t<div class=\"v-fckeditor\">" + NL + "\t\t  \t\t\t<input type=\"hidden\" id=\"";
  protected final String TEXT_379 = "\" name=\"";
  protected final String TEXT_380 = "\"/>" + NL + "\t\t  \t\t\t<textarea style=\"width: 90%;\"  id=\"fck_";
  protected final String TEXT_381 = "\">" + NL + "\t\t      \t\t  ${mo.";
  protected final String TEXT_382 = "}" + NL + "\t\t   \t\t\t</textarea>" + NL + "\t\t\t\t  \t<script type=\"text/javascript\">" + NL + "\t\t\t             var oFCKeditor = new FCKeditor('fck_";
  protected final String TEXT_383 = "') ; " + NL + "\t\t                 oFCKeditor.BasePath\t= '${ctx}/resources/fckeditor/' ;" + NL + "\t\t                 oFCKeditor.Config[\"CustomConfigurationsPath\"]=\"${ctx}/resources/fckeditor/customConfig.js\";" + NL + "\t\t\t             oFCKeditor.ToolbarSet='goolovEditTab';" + NL + "\t\t\t             oFCKeditor.Config[\"TabSpaces\"]=2;" + NL + "\t\t\t             oFCKeditor.Config[\"LinkUpload\"] = false;" + NL + "\t\t\t             oFCKeditor.Config[\"ImageUpload\"] = true;" + NL + "\t\t\t             oFCKeditor.Config[\"FlashUpload\"] = false;" + NL + "\t\t\t             oFCKeditor.Height\t= ";
  protected final String TEXT_384 = "-130;" + NL + "\t\t                 oFCKeditor.ReplaceTextarea(); " + NL + "\t\t            </script>" + NL + "\t\t          </div>" + NL + "\t\t\t</div><!--";
  protected final String TEXT_385 = " tab end-->";
  protected final String TEXT_386 = "\t\t\t";
  protected final String TEXT_387 = NL + "\t\t\t<div title=\"";
  protected final String TEXT_388 = "\"  class=\"v-tab\"><!--";
  protected final String TEXT_389 = " tab start-->" + NL + "\t\t\t\t<div class=\"v-section-wrap\">" + NL + "\t\t\t\t\t<div class='v-title'>选择";
  protected final String TEXT_390 = "：</div>" + NL + "\t\t\t\t\t<div class=\"v-content\">" + NL + "\t\t\t\t\t\t${";
  protected final String TEXT_391 = "}" + NL + "\t\t\t\t\t</div>" + NL + "\t\t\t\t</div>" + NL + "\t\t\t</div><!--";
  protected final String TEXT_392 = " tab end-->";
  protected final String TEXT_393 = NL + "\t\t\t<div title=\"";
  protected final String TEXT_394 = "\"   class=\"v-tab\"><!--";
  protected final String TEXT_395 = " tab start-->" + NL + "\t\t\t\t\t<div class=\"v-tree-wrap\">" + NL + "\t\t\t\t\t\t<div class=\"v-title\">选择";
  protected final String TEXT_396 = "：</div>" + NL + "\t\t\t\t\t\t<div class=\"v-content\" id=\"";
  protected final String TEXT_397 = "\" style=\"height:270px; width:350px; overflow: auto;\">" + NL + "\t\t\t\t\t\t</div>" + NL + "\t\t\t\t\t</div>" + NL + "\t\t\t</div><!--";
  protected final String TEXT_398 = " tab end-->";
  protected final String TEXT_399 = "\t\t\t\t\t\t" + NL + "\t\t  </div><!-- firstTabs end -->";
  protected final String TEXT_400 = NL + "\t\t</div><!-- center end -->" + NL + "\t\t<div region=\"south\" border=\"false\" style=\"height:50px;\"><!-- south start-->" + NL + "\t\t\t<div class=\"v-buttons\"><!-- v-buttons start -->" + NL + "\t\t  \t \t<c:choose>" + NL + "\t\t\t  \t\t<c:when test=\"${null==model.id}\">" + NL + "\t\t\t   \t\t\t<a href=\"javascript:newWinSaveData();\" class=\"easyui-linkbutton\">新增</a>" + NL + "\t\t\t   \t\t\t<a href=\"javascript:resetData();\" class=\"easyui-linkbutton\" >重置</a>" + NL + "\t\t\t   \t\t\t<a href=\"javascript:newWinClose();\" class=\"easyui-linkbutton\" >关闭</a>" + NL + "\t\t\t \t\t</c:when>" + NL + "\t\t\t   \t\t<c:otherwise>" + NL + "\t\t   \t\t\t\t<a href=\"javascript:editWinUpdateData();\" class=\"easyui-linkbutton\" >更新</a>" + NL + "\t\t\t\t\t\t<a href=\"javascript:resetData();\" class=\"easyui-linkbutton\" >重置</a>" + NL + "\t\t\t\t\t\t<a href=\"javascript:editWinClose();\" class=\"easyui-linkbutton\" >关闭</a>" + NL + "\t\t\t\t\t</c:otherwise>" + NL + "\t\t\t   </c:choose> " + NL + "\t\t\t</div><!-- v-buttons end-->" + NL + "\t\t</div><!--\tsouth end -->" + NL + "</body>" + NL + "</html>";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    Class uml2Class = (Class) argument;Package uml2Package = uml2Class.getPackage();
    
UmlClassWrap clazzWrap=new UmlClassWrap(uml2Class);
String modelCommentName=TypeHelper.getDocumentationOrName(uml2Class);
/*******input content*********/
List<Property> contentPropertyList=ViewInputHelper.getViewInputContent(uml2Class);
List<Property> contentTabPropertyList=ViewInputHelper.getViewInputContentTab(uml2Class);
boolean needFck=false;
if(!contentPropertyList.isEmpty()||!contentTabPropertyList.isEmpty()){
	needFck=true;
}
List<Property> m2oAndO2OProperty=ViewInputHelper.getApplyM2OAndO2OSelect(uml2Class);
boolean needm2oAndO2OComboGrid=false;
if(!m2oAndO2OProperty.isEmpty()||!m2oAndO2OProperty.isEmpty()){
	needm2oAndO2OComboGrid=true;
}
List<Property> m2oAndO2OSelectTreeList=ViewInputHelper.getApplyM2OSelectTree(uml2Class);
boolean m2oAndO2OSelectTree=false;
if(null!=m2oAndO2OSelectTreeList&&!m2oAndO2OSelectTreeList.isEmpty()){
	m2oAndO2OSelectTree=true;
}
//model input js Path
String modelInputJsPath=clazzWrap.getWebPath(NameRuledWebPathKind.js_input);;
String jspScriptStart="<%@";
String jspScriptEnd="%"+">";

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
    if(needm2oAndO2OComboGrid){
    stringBuffer.append(TEXT_11);
    }
    if(m2oAndO2OSelectTree){
    stringBuffer.append(TEXT_12);
    }
    stringBuffer.append(TEXT_13);
    if(needFck){
    stringBuffer.append(TEXT_14);
    }
    if(needm2oAndO2OComboGrid){
    stringBuffer.append(TEXT_15);
    }
    if(m2oAndO2OSelectTree){
    stringBuffer.append(TEXT_16);
    }
    stringBuffer.append(TEXT_17);
    stringBuffer.append(modelInputJsPath);
    stringBuffer.append(TEXT_18);
    List<Property> tabsList=ViewInputHelper.getTabsProperty(uml2Class);
    if(!tabsList.isEmpty()||!contentTabPropertyList.isEmpty()){
    stringBuffer.append(TEXT_19);
    }
    stringBuffer.append(TEXT_20);
    Property idProperty=EntityHelper.getIDProperty(uml2Class);
    String idPropertyUncapSafeName=NameHelper.uncapSafeName(idProperty);
    if(EntityHelper.isIDAuto(idProperty)||EntityHelper.isIDUUID(idProperty)){
    	//if(!ViewInputHelper.isViewInput(idProperty)){
    stringBuffer.append(TEXT_21);
    stringBuffer.append(idPropertyUncapSafeName);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(idPropertyUncapSafeName);
    stringBuffer.append(TEXT_23);
    	//}
    }
    stringBuffer.append(TEXT_24);
    
boolean needDoubleCols=ViewInputHelper.isNeedTableDoubleCols(uml2Class);//needDoubleTDCols
int trIncludeTd=needDoubleCols?4:2;
int tdCount=0;
int needTd=2;
//simple Input Property
//List<Property> simpleInputProperty=ViewInputHelper.getSimpleInputProperty(uml2Class);

    
	/*****************************************************************
	 * proccess id property
	/*****************************************************************/
	if(EntityHelper.isIDAuto(idProperty)||EntityHelper.isIDUUID(idProperty)){
		if(ViewInputHelper.isViewInput(idProperty)){
 			String propertyCommentName=TypeHelper.getDocumentationOrName(idProperty);
 			//String propertyUncapSafeName=NameHelper.uncapSafeName(idProperty);
 			//String propertyStyleClass=ViewInputHelper.getStyleClass(idProperty);
			needTd=2>trIncludeTd?trIncludeTd:2;

    			if(tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_25);
    			}
    stringBuffer.append(TEXT_26);
    			if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_27);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_28);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    			}
    stringBuffer.append(TEXT_29);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(NameHelper.uncapSafeName(idProperty));
    stringBuffer.append(TEXT_32);
    			tdCount+=needTd;
    stringBuffer.append(TEXT_33);
    			if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_34);
    			}
    stringBuffer.append(TEXT_35);
    		}
    	}else if(EntityHelper.isIDAssign(idProperty)){
 		String propertyCommentName=TypeHelper.getDocumentationOrName(idProperty);
 		String propertyUncapSafeName=NameHelper.uncapSafeName(idProperty);
 		String propertyStyleClass=ViewInputHelper.getStyleClass(idProperty);

    			if(tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_36);
    			}
    stringBuffer.append(TEXT_37);
    				needTd=2>trIncludeTd?trIncludeTd:2;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_38);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_39);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    stringBuffer.append(TEXT_40);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(propertyStyleClass);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(propertyStyleClass);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_51);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_52);
    				}
    stringBuffer.append(TEXT_53);
    	}
    
	/*****************************************************************
	 * property simple input start
	/*****************************************************************/
	List<Property> simpleInputProperty=ViewInputHelper.getSimpleInputProperty(uml2Class);
	for(Iterator<Property> iter=simpleInputProperty.iterator();iter.hasNext();){
			Property property=iter.next();
			String propertyCommentName=TypeHelper.getDocumentationOrName(property);
 			String propertyUncapSafeName=NameHelper.uncapSafeName(property);
 			String propertyStyleClass=ViewInputHelper.getStyleClass(property);

    			if(tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_54);
    			}
    stringBuffer.append(TEXT_55);
    	/********process parentId Property start********/
    			if (TreeStereotypeHelper.isParentIdProperty(property)) {// text
    				needTd=2>trIncludeTd?trIncludeTd:2;
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
    if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_63);
    }
    stringBuffer.append(TEXT_64);
    if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_65);
    }
    stringBuffer.append(TEXT_66);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_67);
    				}
    stringBuffer.append(TEXT_68);
    				continue;
    			}
    	/********process parentId Property end********/
    	/********process text********/
    			if (ViewInputHelper.isViewInputText(property)) {// text
    				needTd=2>trIncludeTd?trIncludeTd:2;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_69);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_70);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    stringBuffer.append(TEXT_71);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_73);
    				if(	ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_74);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_75);
    				}else{
    stringBuffer.append(TEXT_76);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(propertyStyleClass);
    stringBuffer.append(TEXT_80);
    				}
    stringBuffer.append(TEXT_81);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_82);
    				}
    stringBuffer.append(TEXT_83);
    				continue;
    			}
    	/********process title********/
    			if (ViewInputHelper.isViewInputTitle(property)) {// title
    				needTd=4>trIncludeTd?trIncludeTd:4;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_84);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_85);
    					tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    stringBuffer.append(TEXT_86);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_88);
    if(						ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_89);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_90);
    							}else{
    stringBuffer.append(TEXT_91);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(propertyStyleClass);
    stringBuffer.append(TEXT_95);
    if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_96);
    }
    stringBuffer.append(TEXT_97);
    							}
    stringBuffer.append(TEXT_98);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_99);
    				}
    stringBuffer.append(TEXT_100);
    				continue;
    			}
    	/********process select********/
    			if (ViewInputHelper.isViewInputSelect(property)) {// select
    				needTd=2>trIncludeTd?trIncludeTd:2;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_101);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_102);
    					tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    stringBuffer.append(TEXT_103);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_104);
    				Enumeration enumeration=EnumKindHelper.getAppliedEnumKindEnumeration(property);
    				if(null!=enumeration){
    					//String modelEnumQualifiedName=MdaHelper.getModelQualifiedName(enumeration,PKGSuffix.enumeration,ModelNameSuffix.enumeration);
    					//String modelEnumName=MdaHelper.getModelClassName(enumeration,ModelNameSuffix.enumeration);
    					String modelEnumSelectHtml=NamedUtil.getPropertyNamed(enumeration,PropertyNamedRuleKind.selectHtml);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(propertyStyleClass);
    stringBuffer.append(TEXT_109);
    if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_110);
    }
    stringBuffer.append(TEXT_111);
    if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_112);
    }
    stringBuffer.append(TEXT_113);
    stringBuffer.append(modelEnumSelectHtml);
    stringBuffer.append(TEXT_114);
    				}else{
    stringBuffer.append(TEXT_115);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_116);
    if(						ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_117);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_118);
    							}else{
    stringBuffer.append(TEXT_119);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(propertyStyleClass);
    stringBuffer.append(TEXT_123);
    if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_124);
    }
    stringBuffer.append(TEXT_125);
    							}
    stringBuffer.append(TEXT_126);
    				}
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_127);
    				}
    stringBuffer.append(TEXT_128);
    				continue;
    			}
    stringBuffer.append(TEXT_129);
    	/********process radio********/
    stringBuffer.append(TEXT_130);
    			if (ViewInputHelper.isViewInputRadio(property)) {// radio
    				needTd=4>trIncludeTd?trIncludeTd:4;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_131);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_132);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    stringBuffer.append(TEXT_133);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_134);
    				Enumeration enumeration=EnumKindHelper.getAppliedEnumKindEnumeration(property);
    				if(null!=enumeration){
    						String propertyRadioGroup=NamedUtil.getPropertyNamed(enumeration,PropertyNamedRuleKind.inputRadioGroup);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(propertyRadioGroup);
    stringBuffer.append(TEXT_137);
    				}else{
    stringBuffer.append(TEXT_138);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_139);
    if(						ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_140);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_141);
    							}else{
    stringBuffer.append(TEXT_142);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(propertyStyleClass);
    stringBuffer.append(TEXT_146);
    if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_147);
    }
    stringBuffer.append(TEXT_148);
    							}
    stringBuffer.append(TEXT_149);
    				}
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_150);
    				}
    stringBuffer.append(TEXT_151);
    				continue;
    			}
    	/********process datePicker********/
    			if (ViewInputHelper.isViewInputDatePicker(property)) {// datePicker
    				//String propertyToDateTimeCapName=PropertyNamedRuleKind.dateToDateTimeStr.getRuleCapNamed(property);
    				String propertyToDateTimeUncapName=PropertyNamedRuleKind.dateToDateTimeStr.getRuleUnCapNamed(property);
    				needTd=2>trIncludeTd?trIncludeTd:2;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_152);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_153);
    					tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    stringBuffer.append(TEXT_154);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_156);
    				if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_157);
    stringBuffer.append(propertyToDateTimeUncapName);
    stringBuffer.append(TEXT_158);
    							}else{
    stringBuffer.append(TEXT_159);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(propertyStyleClass);
    stringBuffer.append(TEXT_163);
    if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_164);
    }
    stringBuffer.append(TEXT_165);
    							}
    stringBuffer.append(TEXT_166);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_167);
    				}
    stringBuffer.append(TEXT_168);
    				continue;
    				}
    	/********process texttarea********/
    			if (ViewInputHelper.isViewInputTextarea(property)) {// texttarea 
    				needTd=4>trIncludeTd?trIncludeTd:4;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_169);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_170);
    					tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    stringBuffer.append(TEXT_171);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_173);
    if(						ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_174);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_175);
    							}else{
    stringBuffer.append(TEXT_176);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(propertyStyleClass);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_180);
    							}
    stringBuffer.append(TEXT_181);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_182);
    				}
    stringBuffer.append(TEXT_183);
    				continue;
    			}	
    stringBuffer.append(TEXT_184);
    	/********process checkbox********/
    			if (ViewInputHelper.isViewInputCheckbox(property)) {// checkbox
    				needTd=4>trIncludeTd?trIncludeTd:4;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_185);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_186);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    stringBuffer.append(TEXT_187);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_189);
    if(						ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_190);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_191);
    							}else{
    stringBuffer.append(TEXT_192);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(propertyStyleClass);
    stringBuffer.append(TEXT_196);
    							}
    stringBuffer.append(TEXT_197);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_198);
    				}
    stringBuffer.append(TEXT_199);
    				continue;
    			}
    stringBuffer.append(TEXT_200);
    	/********process file********/
    stringBuffer.append(TEXT_201);
    			if (FileStereotypeHelper.isProperty_File(property)) {// file
    				needTd=4>trIncludeTd?trIncludeTd:4;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_202);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_203);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    stringBuffer.append(TEXT_204);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(idPropertyUncapSafeName);
    stringBuffer.append(TEXT_215);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_216);
    				}
    stringBuffer.append(TEXT_217);
    				continue;
    			}		
    	/********process image********/
    stringBuffer.append(TEXT_218);
    			if (FileStereotypeHelper.isProperty_Image(property)) {// image
    				needTd=4>trIncludeTd?trIncludeTd:4;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_219);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_220);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    stringBuffer.append(TEXT_221);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(idPropertyUncapSafeName);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_237);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_238);
    				}
    stringBuffer.append(TEXT_239);
    				continue;
    			}
    	/********process content********/
    stringBuffer.append(TEXT_240);
    //			if (ViewInputHelper.isViewInputContent(property)) {// content
    //			}
    
/*****************************************************************
 * process rel 
/*****************************************************************/

    /********process M2OSelect********/
    stringBuffer.append(TEXT_241);
    			if (ViewInputHelper.isApplyM2OSelect(property)) {//M2OSelect
    				Class propertyType = (Class) property.getType();
    				String propertyTypeComment = TypeHelper.getDocumentationOrName(propertyType);
     				Property propertyTypeIdProperty=EntityHelper.getIDProperty(propertyType);
     				String propertyTypeIdPropertyUncapSafeName=NameHelper.uncapSafeName(propertyTypeIdProperty);
     				String listLabelPropertyUncapSafeName=ViewListHelper.getViewListLabelRelPropertyName(property);
    				needTd=2>trIncludeTd?trIncludeTd:2;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_242);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_243);
    					tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    				//String m2oSelectHtml=NamedUtil.getPropertyNamed(property,PropertyNamedRuleKind.selectHtml);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(propertyTypeComment);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_258);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_259);
    				}
    stringBuffer.append(TEXT_260);
    				continue;
    			}	
    stringBuffer.append(TEXT_261);
    	/********process M2OSelectPage********/
    			if (ViewInputHelper.isApplyM2OSelectPage(property)) {//M2OSelectPage
    				Class propertyType = (Class) property.getType();
    				String propertyTypeComment = TypeHelper.getDocumentationOrName(propertyType);
     				Property propertyTypeIdProperty=EntityHelper.getIDProperty(propertyType);
     				String propertyTypeIdPropertyUncapSafeName=NameHelper.uncapSafeName(propertyTypeIdProperty);
    				//rel list label
     				String listLabelPropertyUncapSafeName=ViewListHelper.getViewListLabelRelPropertyName(property);
     				String listLabelPropertyComment=ViewListHelper.getViewListLabelRelPropertyComment(property);
    				String relM2OAndO2OSelectPage=NamedUtil.getPropertyNamedUncap(propertyType,PropertyNamedRuleKind.relM2OAndO2OSelectPage);
    				needTd=2>trIncludeTd?trIncludeTd:2;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_262);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_263);
    					tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    stringBuffer.append(TEXT_264);
    stringBuffer.append(propertyTypeComment);
    stringBuffer.append(listLabelPropertyComment);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_266);
    							if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_267);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_269);
    							}else{
    stringBuffer.append(TEXT_270);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_272);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_277);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_278);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(relM2OAndO2OSelectPage);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_284);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_285);
    							}
    stringBuffer.append(TEXT_286);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_287);
    				}
    stringBuffer.append(TEXT_288);
    				continue;
    			}
    stringBuffer.append(TEXT_289);
    	/********process O2OSelect********/
    			if (ViewInputHelper.isApplyO2OSelect(property)) {//O2OSelect
    stringBuffer.append(TEXT_290);
    				Class propertyType = (Class) property.getType();
    				String propertyTypeComment = TypeHelper.getDocumentationOrName(propertyType);
     				Property propertyTypeIdProperty=EntityHelper.getIDProperty(propertyType);
     				String propertyTypeIdPropertyUncapSafeName=NameHelper.uncapSafeName(propertyTypeIdProperty);
     				String listLabelPropertyUncapSafeName=ViewListHelper.getViewListLabelRelPropertyName(property);
    				needTd=2>trIncludeTd?trIncludeTd:2;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_291);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_292);
    					tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    				String O2OSelectHtml=NamedUtil.getPropertyNamed(property,PropertyNamedRuleKind.selectHtml);
    stringBuffer.append(TEXT_293);
    stringBuffer.append(propertyTypeComment);
    stringBuffer.append(TEXT_294);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_296);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_297);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_298);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_299);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_301);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_302);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_304);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_305);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_306);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_307);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_308);
    				}
    stringBuffer.append(TEXT_309);
    				continue;
    			}	
    stringBuffer.append(TEXT_310);
    	/********process O2OSelectPage********/
    			if (ViewInputHelper.isApplyO2OSelectPage(property)) {//O2OSelectPage
    				Class propertyType = (Class) property.getType();
    				String propertyTypeComment = TypeHelper.getDocumentationOrName(propertyType);
     				Property propertyTypeIdProperty=EntityHelper.getIDProperty(propertyType);
     				String propertyTypeIdPropertyUncapSafeName=NameHelper.uncapSafeName(propertyTypeIdProperty);
     				String listLabelPropertyUncapSafeName=ViewListHelper.getViewListLabelRelPropertyName(property);
     				String listLabelPropertyComment=ViewListHelper.getViewListLabelRelPropertyComment(property);
    				String relM2OAndO2OSelectPage=NamedUtil.getPropertyNamedUncap(propertyType,PropertyNamedRuleKind.relM2OAndO2OSelectPage);
    				needTd=2>trIncludeTd?trIncludeTd:2;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_311);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_312);
    					tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    stringBuffer.append(TEXT_313);
    stringBuffer.append(propertyTypeComment);
    stringBuffer.append(listLabelPropertyComment);
    stringBuffer.append(TEXT_314);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_315);
    							if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_316);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_317);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_318);
    							}else{
    stringBuffer.append(TEXT_319);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_320);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_321);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_322);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_323);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_324);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_325);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_326);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_327);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_328);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_329);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_330);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(relM2OAndO2OSelectPage);
    stringBuffer.append(TEXT_332);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_333);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_334);
    							}
    stringBuffer.append(TEXT_335);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_336);
    				}
    stringBuffer.append(TEXT_337);
    				continue;
    			}
    stringBuffer.append(TEXT_338);
    	}
    	if (tdCount%trIncludeTd!=0){
    stringBuffer.append(TEXT_339);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_340);
    	}
    
	/*****************************************************************
	 * property simple input end
	/*****************************************************************/

    stringBuffer.append(TEXT_341);
    
/*****************************************************************
 * rel property
/*****************************************************************/
//List<Property> M2OSelectList=ViewInputHelper.getApplyM2OSelect(uml2Class);
//List<Property> O2OSelectList=ViewInputHelper.getApplyO2OSelect(uml2Class);

//List<Property> M2OSelectPageList=ViewInputHelper.getApplyM2OSelectPage(uml2Class);
//List<Property> O2OSelectPageList=ViewInputHelper.getApplyO2OSelectPage(uml2Class);

//List<Property> O2MManagerPageList=ViewInputHelper.getApplyO2MManagerPage(uml2Class);

List<Property> M2MCheckboxsList=ViewInputHelper.getApplyM2MCheckboxs(uml2Class);
//List<Property> M2MCheckboxsTabList=ViewInputHelper.getApplyM2MCheckboxsTab(uml2Class);

List<Property> M2MCheckboxsTreeList=ViewInputHelper.getApplyM2MCheckboxsTree(uml2Class);
//List<Property> M2MCheckboxsTreeTabList=ViewInputHelper.getApplyM2MCheckboxsTreeTab(uml2Class);

/*****************************************************************
 * rel M2MCheckboxs M2MCheckboxsTree properties
/*****************************************************************/

    /********process M2MCheckboxs properties********/
    if(null!=M2MCheckboxsList&&M2MCheckboxsList.size()>0){
    	for(Property property:M2MCheckboxsList){
     			String propertyCommentName=TypeHelper.getDocumentationOrName(property);
     			//String propertyUncapSafeName=NameHelper.uncapSafeName(property);
     			//String propertyStyleClass=ViewInputHelper.getStyleClass(property);
    			Type propertyType=property.getType();
    			Class relTargetClass=(Class)propertyType;
    			String relPropertyCheckboxs=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relCheckboxs);
    stringBuffer.append(TEXT_342);
    stringBuffer.append(trIncludeTd);
    stringBuffer.append(TEXT_343);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_344);
    stringBuffer.append(relPropertyCheckboxs);
    stringBuffer.append(TEXT_345);
    		}
    }
    /********process M2MCheckboxsTree properties********/
    if(null!=M2MCheckboxsTreeList&&M2MCheckboxsTreeList.size()>0){
    	for(Property property:M2MCheckboxsTreeList){
     			String propertyCommentName=TypeHelper.getDocumentationOrName(property);
     			String propertyUncapSafeName=NameHelper.uncapSafeName(property);
     			String propertyStyleClass=ViewInputHelper.getStyleClass(property);
    			Type propertyType=property.getType();
    			Class relTargetClass=(Class)propertyType;
    			String relPropertyCheckTreeDomId=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relCheckTreeDomId);
    stringBuffer.append(TEXT_346);
    stringBuffer.append(trIncludeTd);
    stringBuffer.append(TEXT_347);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_348);
    stringBuffer.append(relPropertyCheckTreeDomId);
    stringBuffer.append(TEXT_349);
    		}
    }
    
/*****************************************************************
 * process image file content properties
/*****************************************************************/

    /********process image properties********/
    /*List<Property> imagePropertyList=ViewInputHelper.getViewInputImage(uml2Class);
    if(null!=imagePropertyList&&imagePropertyList.size()>0){
    	for(Property property:imagePropertyList){
     			String propertyCommentName=TypeHelper.getDocumentationOrName(property);
     			String propertyUncapSafeName=NameHelper.uncapSafeName(property);
     			//String propertyStyleClass=ViewInputHelper.getStyleClass(property);
    stringBuffer.append(TEXT_350);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_351);
    if(trIncludeTd-1>1){
    stringBuffer.append(TEXT_352);
    stringBuffer.append(trIncludeTd-1);
    stringBuffer.append(TEXT_353);
    }
    stringBuffer.append(TEXT_354);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_355);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_356);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_357);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_358);
    		}
    }*/
    /********process file properties********/
    List<Property> filePropertyList=ViewInputHelper.getViewInputFile(uml2Class);
    if(null!=filePropertyList&&filePropertyList.size()>0){
    	for(Property property:filePropertyList){
     			String propertyCommentName=TypeHelper.getDocumentationOrName(property);
     			String propertyUncapSafeName=NameHelper.uncapSafeName(property);
     			//String propertyStyleClass=ViewInputHelper.getStyleClass(property);
    stringBuffer.append(TEXT_359);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_360);
    if(trIncludeTd-1>1){
    stringBuffer.append(TEXT_361);
    stringBuffer.append(trIncludeTd-1);
    stringBuffer.append(TEXT_362);
    }
    stringBuffer.append(TEXT_363);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_364);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_365);
    	}
    }
    /********process content properties********/
    if(null!=contentPropertyList&&contentPropertyList.size()>0){
    for(Property property:contentPropertyList){
     			String propertyCommentName=TypeHelper.getDocumentationOrName(property);
     			String propertyUncapSafeName=NameHelper.uncapSafeName(property);
     			//String propertyStyleClass=ViewInputHelper.getStyleClass(property);
    stringBuffer.append(TEXT_366);
    stringBuffer.append(trIncludeTd);
    stringBuffer.append(TEXT_367);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_368);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_369);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_370);
    stringBuffer.append(NameHelper.getUncapName(property));
    stringBuffer.append(TEXT_371);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_372);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_373);
    }}
    stringBuffer.append(TEXT_374);
    if(!tabsList.isEmpty()||!contentTabPropertyList.isEmpty()){
    stringBuffer.append(TEXT_375);
    	for(Iterator<Property> iter=contentTabPropertyList.iterator();iter.hasNext();){
    			Property property=iter.next();
     			String propertyCommentName=TypeHelper.getDocumentationOrName(property);
     			String propertyUncapSafeName=NameHelper.uncapSafeName(property);
     			//String propertyStyleClass=ViewInputHelper.getStyleClass(property);
    			String propertyCapConmentName=TypeHelper.getDocumentationOrName(property);
    stringBuffer.append(TEXT_376);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_377);
    stringBuffer.append(propertyCapConmentName);
    stringBuffer.append(TEXT_378);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_379);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_380);
    stringBuffer.append(NameHelper.getUncapName(property));
    stringBuffer.append(TEXT_381);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_382);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_383);
    stringBuffer.append(PageHelper.getWinHeight(uml2Class));
    stringBuffer.append(TEXT_384);
    stringBuffer.append(propertyCapConmentName);
    stringBuffer.append(TEXT_385);
    	}
    stringBuffer.append(TEXT_386);
    	for(Iterator<Property> iter=tabsList.iterator();iter.hasNext();){
    		Property property=iter.next();
    		if(ClassHelper.isSimple(property))continue;
    		//String propertyCapName=NameHelper.getCapName(property);
    		String propertyCapConmentName=TypeHelper.getDocumentationOrName(property);
    		//String propertyName=NameHelper.uncapSafeName(property);
    		Type propertyType=property.getType();
    		Class relTargetClass=null;
    		if(ModelStereoTypeHelper.isApplyModel_M2M(propertyType)||ModelStereoTypeHelper.isApplyModel_M2mWithId(propertyType)){
    			Class relUml2Class=(Class)propertyType;
    			relTargetClass=ModelHelper.getRelTargetClass(relUml2Class,uml2Class);
    		}
    		String relTargetClassCommentName=TypeHelper.getDocumentationOrName(relTargetClass);
    		String relPropertyCheckboxs=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relCheckboxs);
    		if (ViewInputHelper.isApplyM2MCheckboxsTab(property)) {//M2OSelect
    stringBuffer.append(TEXT_387);
    stringBuffer.append(propertyCapConmentName);
    stringBuffer.append(TEXT_388);
    stringBuffer.append(propertyCapConmentName);
    stringBuffer.append(TEXT_389);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_390);
    stringBuffer.append(relPropertyCheckboxs);
    stringBuffer.append(TEXT_391);
    stringBuffer.append(propertyCapConmentName);
    stringBuffer.append(TEXT_392);
    		}
    		if (ViewInputHelper.isApplyM2MCheckboxsTreeTab(property)) {//M2OSelectPage
    			String relPropertyShowCheckTreeJson=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relShowCheckTreeJson);
    stringBuffer.append(TEXT_393);
    stringBuffer.append(propertyCapConmentName);
    stringBuffer.append(TEXT_394);
    stringBuffer.append(propertyCapConmentName);
    stringBuffer.append(TEXT_395);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_396);
    stringBuffer.append(relPropertyShowCheckTreeJson);
    stringBuffer.append(TEXT_397);
    stringBuffer.append(propertyCapConmentName);
    stringBuffer.append(TEXT_398);
    		}
    	}
    stringBuffer.append(TEXT_399);
    }
    stringBuffer.append(TEXT_400);
    return stringBuffer.toString();
  }
}
