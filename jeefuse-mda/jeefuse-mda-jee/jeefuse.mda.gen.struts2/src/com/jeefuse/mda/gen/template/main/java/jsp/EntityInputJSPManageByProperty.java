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

public class EntityInputJSPManageByProperty
{
  protected static String nl;
  public static synchronized EntityInputJSPManageByProperty create(String lineSeparator)
  {
    nl = lineSeparator;
    EntityInputJSPManageByProperty result = new EntityInputJSPManageByProperty();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = " page contentType=\"text/html;charset=UTF-8\" ";
  protected final String TEXT_3 = NL;
  protected final String TEXT_4 = " include file=\"/common/taglibs.jsp\" ";
  protected final String TEXT_5 = NL + "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">" + NL + "<html xmlns=\"http://www.w3.org/1999/xhtml\">" + NL + "<head>" + NL + "<title>";
  protected final String TEXT_6 = " 编辑</title>";
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
  protected final String TEXT_29 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label class=\"requied\">";
  protected final String TEXT_30 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_31 = "\">" + NL + "\t\t      \t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_32 = "Id\" name=\"";
  protected final String TEXT_33 = ".";
  protected final String TEXT_34 = "\" value=\"${mo.";
  protected final String TEXT_35 = ".";
  protected final String TEXT_36 = "}\" class=\"text\" readonly=\"readonly\"/>" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_37 = "\t";
  protected final String TEXT_38 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_39 = "\t";
  protected final String TEXT_40 = NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_41 = "\t";
  protected final String TEXT_42 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_43 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_44 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_45 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_46 = "\">" + NL + "\t\t      \t\t\t\t${mo.";
  protected final String TEXT_47 = "}" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_48 = "\t";
  protected final String TEXT_49 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_50 = "\t\t\t\t\t\t";
  protected final String TEXT_51 = NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_52 = "\t";
  protected final String TEXT_53 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_54 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_55 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_56 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_57 = "\">" + NL + "\t\t      \t\t\t\t<c:choose>" + NL + "\t\t\t\t\t\t  \t \t<c:when test=\"${null==model.id}\">" + NL + "\t\t\t\t\t\t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_58 = "\" name=\"";
  protected final String TEXT_59 = "\" value=\"${mo.";
  protected final String TEXT_60 = "}\" class=\"";
  protected final String TEXT_61 = "\"/>" + NL + "\t\t\t\t\t\t \t    </c:when>" + NL + "\t\t\t\t\t\t   \t    <c:otherwise>" + NL + "\t\t\t\t\t\t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_62 = "\" name=\"";
  protected final String TEXT_63 = "\" value=\"${mo.";
  protected final String TEXT_64 = "}\" class=\"";
  protected final String TEXT_65 = " readonly\" readonly='readonly' />" + NL + "\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"oldId\" name=\"oldId\" value=\"${mo.";
  protected final String TEXT_66 = "}\"/>" + NL + "\t\t\t\t\t\t\t    </c:otherwise>" + NL + "\t\t\t\t\t\t\t</c:choose> " + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_67 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_68 = "\t\t\t\t\t\t";
  protected final String TEXT_69 = NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_70 = "\t";
  protected final String TEXT_71 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_72 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_73 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_74 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_75 = "\">" + NL + "\t\t\t\t\t\t\t <select name=\"";
  protected final String TEXT_76 = "\" id=\"";
  protected final String TEXT_77 = "\" class=\"text ";
  protected final String TEXT_78 = "readonly";
  protected final String TEXT_79 = "\" ";
  protected final String TEXT_80 = "readonly=\"readonly\"";
  protected final String TEXT_81 = ">" + NL + "\t\t\t\t\t\t\t     <option value=\"\" >无</option>" + NL + "\t\t\t\t\t\t\t     <s:property value=\"htmlSelectTree\" escape=\"false\"/>" + NL + "\t\t\t\t\t\t\t  </select>" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_82 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_83 = "\t\t\t\t\t\t";
  protected final String TEXT_84 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_85 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_86 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_87 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_88 = "\">";
  protected final String TEXT_89 = NL + "\t\t      \t\t\t\t${mo.";
  protected final String TEXT_90 = "}";
  protected final String TEXT_91 = NL + "\t\t      \t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_92 = "\" name=\"";
  protected final String TEXT_93 = "\" value=\"${mo.";
  protected final String TEXT_94 = "}\" class=\"";
  protected final String TEXT_95 = "\" />";
  protected final String TEXT_96 = NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_97 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_98 = "\t\t\t\t\t\t";
  protected final String TEXT_99 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_100 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_101 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_102 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_103 = "\">";
  protected final String TEXT_104 = NL + "\t\t      \t\t\t\t\t${mo.";
  protected final String TEXT_105 = "}";
  protected final String TEXT_106 = NL + "\t\t      \t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_107 = "\" name=\"";
  protected final String TEXT_108 = "\" value=\"${mo.";
  protected final String TEXT_109 = "}\" class=\"";
  protected final String TEXT_110 = "\" ";
  protected final String TEXT_111 = "readonly=\"readonly\"";
  protected final String TEXT_112 = "/>";
  protected final String TEXT_113 = "\t\t\t\t\t\t\t" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_114 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_115 = "\t\t\t\t\t\t";
  protected final String TEXT_116 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_117 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_118 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_119 = ":</label>" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_120 = NL + "\t\t\t\t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_121 = "\">" + NL + "\t\t\t\t\t\t\t <select  id=\"";
  protected final String TEXT_122 = "\" name=\"";
  protected final String TEXT_123 = "\" class=\"";
  protected final String TEXT_124 = " class=\"text ";
  protected final String TEXT_125 = "readonly";
  protected final String TEXT_126 = "\" ";
  protected final String TEXT_127 = "readonly=\"readonly\"";
  protected final String TEXT_128 = ">" + NL + "\t\t\t\t\t\t\t     <s:property value=\"";
  protected final String TEXT_129 = "\" escape=\"false\"/>" + NL + "\t\t\t\t\t\t\t </select>" + NL + "\t\t\t\t\t\t</td>";
  protected final String TEXT_130 = NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_131 = "\">";
  protected final String TEXT_132 = NL + "\t\t      \t\t\t\t\t${mo.";
  protected final String TEXT_133 = "}";
  protected final String TEXT_134 = NL + "\t\t      \t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_135 = "\" name=\"";
  protected final String TEXT_136 = "\" value=\"${mo.";
  protected final String TEXT_137 = "}\" class=\"";
  protected final String TEXT_138 = "\" ";
  protected final String TEXT_139 = "readonly=\"readonly\"";
  protected final String TEXT_140 = "/>";
  protected final String TEXT_141 = "\t" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_142 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_143 = "\t\t\t\t\t\t";
  protected final String TEXT_144 = "\t";
  protected final String TEXT_145 = "\t";
  protected final String TEXT_146 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_147 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_148 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_149 = ":</label>" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_150 = NL + "\t\t\t\t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_151 = "\">" + NL + "\t\t\t\t\t\t\t ${";
  protected final String TEXT_152 = "}" + NL + "\t\t\t\t\t\t</td>";
  protected final String TEXT_153 = NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_154 = "\">";
  protected final String TEXT_155 = NL + "\t\t      \t\t\t\t\t${mo.";
  protected final String TEXT_156 = "}";
  protected final String TEXT_157 = NL + "\t\t      \t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_158 = "\" name=\"";
  protected final String TEXT_159 = "\" value=\"${mo.";
  protected final String TEXT_160 = "}\" class=\"";
  protected final String TEXT_161 = "\" ";
  protected final String TEXT_162 = "readonly=\"readonly\"";
  protected final String TEXT_163 = "/>";
  protected final String TEXT_164 = "\t" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_165 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_166 = "\t\t\t\t\t\t";
  protected final String TEXT_167 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_168 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_169 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_170 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_171 = "\">";
  protected final String TEXT_172 = NL + "\t\t      \t\t\t\t\t${mo.";
  protected final String TEXT_173 = "}";
  protected final String TEXT_174 = NL + "\t\t      \t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_175 = "\" name=\"";
  protected final String TEXT_176 = "\" value=\"${mo.";
  protected final String TEXT_177 = "}\" class=\"";
  protected final String TEXT_178 = "\" ";
  protected final String TEXT_179 = "readonly=\"readonly\"";
  protected final String TEXT_180 = "/>";
  protected final String TEXT_181 = "\t" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_182 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_183 = "\t\t\t\t\t\t";
  protected final String TEXT_184 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_185 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_186 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_187 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_188 = "\">";
  protected final String TEXT_189 = NL + "\t\t      \t\t\t\t\t${mo.";
  protected final String TEXT_190 = "}";
  protected final String TEXT_191 = NL + "\t\t      \t\t\t\t<textarea id=\"";
  protected final String TEXT_192 = "\" name=\"";
  protected final String TEXT_193 = "\"  class=\"";
  protected final String TEXT_194 = "\" >${mo.";
  protected final String TEXT_195 = "}</textarea>";
  protected final String TEXT_196 = "\t" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_197 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_198 = "\t\t\t\t\t\t";
  protected final String TEXT_199 = "\t\t";
  protected final String TEXT_200 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_201 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_202 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_203 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_204 = "\">";
  protected final String TEXT_205 = NL + "\t\t      \t\t\t\t\t${mo.";
  protected final String TEXT_206 = "}";
  protected final String TEXT_207 = NL + "\t\t      \t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_208 = "\" name=\"";
  protected final String TEXT_209 = "\" value=\"${mo.";
  protected final String TEXT_210 = "}\" class=\"";
  protected final String TEXT_211 = "\" />";
  protected final String TEXT_212 = "\t\t\t      \t\t" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_213 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_214 = "\t\t\t\t\t\t";
  protected final String TEXT_215 = "\t\t";
  protected final String TEXT_216 = "\t\t\t";
  protected final String TEXT_217 = "\t\t";
  protected final String TEXT_218 = "\t";
  protected final String TEXT_219 = "\t\t";
  protected final String TEXT_220 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_221 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_222 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_223 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t\t\t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_224 = "\">" + NL + "\t\t\t\t\t\t\t <input type=\"hidden\" id=\"";
  protected final String TEXT_225 = "_";
  protected final String TEXT_226 = "\" name=\"";
  protected final String TEXT_227 = ".";
  protected final String TEXT_228 = "\" value=\"${mo.";
  protected final String TEXT_229 = ".";
  protected final String TEXT_230 = "}\" class=\"text\" />" + NL + "\t\t\t\t\t\t\t <input type=\"text\" id=\"";
  protected final String TEXT_231 = "_";
  protected final String TEXT_232 = "\" name=\"";
  protected final String TEXT_233 = ".";
  protected final String TEXT_234 = "\" value=\"${mo.";
  protected final String TEXT_235 = ".";
  protected final String TEXT_236 = "}\" class=\"text\" />" + NL + "\t\t\t\t\t\t</td>";
  protected final String TEXT_237 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_238 = "\t\t\t\t\t\t";
  protected final String TEXT_239 = "\t";
  protected final String TEXT_240 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_241 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_242 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_243 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t\t\t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_244 = "\">";
  protected final String TEXT_245 = NL + "\t\t      \t\t\t\t\t${mo.";
  protected final String TEXT_246 = ".";
  protected final String TEXT_247 = "}";
  protected final String TEXT_248 = NL + "\t\t\t\t\t\t\t <input type=\"text\" id=\"";
  protected final String TEXT_249 = "_";
  protected final String TEXT_250 = "\" name=\"";
  protected final String TEXT_251 = ".";
  protected final String TEXT_252 = "\" value=\"${mo.";
  protected final String TEXT_253 = ".";
  protected final String TEXT_254 = "}\" class=\"";
  protected final String TEXT_255 = "\" ";
  protected final String TEXT_256 = "readonly=\"readonly\"";
  protected final String TEXT_257 = "/>";
  protected final String TEXT_258 = "\t\t" + NL + "\t\t\t\t\t\t</td>";
  protected final String TEXT_259 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_260 = "\t\t\t\t\t\t";
  protected final String TEXT_261 = "\t";
  protected final String TEXT_262 = "\t";
  protected final String TEXT_263 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_264 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_265 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_266 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t\t\t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_267 = "\">" + NL + "\t\t\t\t\t\t\t <input type=\"hidden\" id=\"";
  protected final String TEXT_268 = "_";
  protected final String TEXT_269 = "\" name=\"";
  protected final String TEXT_270 = ".";
  protected final String TEXT_271 = "\" value=\"${mo.";
  protected final String TEXT_272 = "_";
  protected final String TEXT_273 = "}\" class=\"text\" />" + NL + "\t\t\t\t\t\t\t <input type=\"text\" id=\"";
  protected final String TEXT_274 = "_";
  protected final String TEXT_275 = "\" name=\"";
  protected final String TEXT_276 = ".";
  protected final String TEXT_277 = "\" value=\"${mo.";
  protected final String TEXT_278 = ".";
  protected final String TEXT_279 = "}\" class=\"text\" />" + NL + "\t\t\t\t\t\t</td>";
  protected final String TEXT_280 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_281 = "\t\t\t\t\t\t";
  protected final String TEXT_282 = "\t";
  protected final String TEXT_283 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_284 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_285 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_286 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t\t\t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_287 = "\">";
  protected final String TEXT_288 = NL + "\t\t      \t\t\t\t\t${mo.";
  protected final String TEXT_289 = ".";
  protected final String TEXT_290 = "}";
  protected final String TEXT_291 = NL + "\t\t\t\t\t\t\t <input type=\"text\" id=\"";
  protected final String TEXT_292 = "_";
  protected final String TEXT_293 = "\" name=\"";
  protected final String TEXT_294 = ".";
  protected final String TEXT_295 = "\" value=\"${mo.";
  protected final String TEXT_296 = ".";
  protected final String TEXT_297 = "}\" class=\"";
  protected final String TEXT_298 = "\" ";
  protected final String TEXT_299 = "readonly=\"readonly\"";
  protected final String TEXT_300 = "/>";
  protected final String TEXT_301 = "\t" + NL + "\t\t\t\t\t\t</td>";
  protected final String TEXT_302 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_303 = "\t\t\t\t\t\t";
  protected final String TEXT_304 = "\t";
  protected final String TEXT_305 = "\t" + NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_306 = "\"></td>" + NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_307 = "\t";
  protected final String TEXT_308 = NL + "\t\t\t\t\t<tr>" + NL + "\t\t      \t\t\t<td colspan=\"";
  protected final String TEXT_309 = "\">" + NL + "\t\t      \t\t\t\t<div class=\"v-fieldset-wrap\">" + NL + "\t\t\t      \t\t\t\t<fieldset>" + NL + "\t\t\t\t\t              <legend>" + NL + "\t\t\t\t\t                 \t";
  protected final String TEXT_310 = ":" + NL + "\t\t\t\t\t              </legend>" + NL + "\t\t\t\t\t              <div class=\"v-fieldset-content\">" + NL + "\t\t\t\t\t                \t${";
  protected final String TEXT_311 = "}" + NL + "\t\t\t\t\t\t\t      </div>" + NL + "\t\t\t\t\t            </fieldset>" + NL + "\t\t      \t\t\t\t</div>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t</tr>";
  protected final String TEXT_312 = NL + "\t\t\t\t\t<tr>" + NL + "\t\t      \t\t\t<td colspan=\"";
  protected final String TEXT_313 = "\">" + NL + "\t\t      \t\t\t\t<div class=\"v-tree-wrap\">" + NL + "\t\t\t\t\t\t\t\t<div class=\"v-title\">";
  protected final String TEXT_314 = "：</div>" + NL + "\t\t\t\t\t\t\t\t<div class=\"v-content\" id=\"";
  protected final String TEXT_315 = "\" style=\"height:270px; width:350px; overflow: auto;\">" + NL + "\t\t\t\t\t\t\t\t</div>" + NL + "\t\t\t\t\t\t\t</div>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t</tr>";
  protected final String TEXT_316 = NL + "\t\t\t\t\t<tr>" + NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_317 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" ";
  protected final String TEXT_318 = "colspan=\"";
  protected final String TEXT_319 = "\"";
  protected final String TEXT_320 = ">" + NL + "\t\t\t \t         \t <input type=\"file\" id=\"uploadImage_";
  protected final String TEXT_321 = "\" name=\"uploadImage_";
  protected final String TEXT_322 = "\" size=\"35\"/><br/>" + NL + "\t\t\t \t         \t <div id=\"previewImageWrap_";
  protected final String TEXT_323 = "\">" + NL + "\t\t\t \t         \t \t<img id=\"previewImage_";
  protected final String TEXT_324 = "\" src=\"\"/>" + NL + "\t\t\t \t         \t </div>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t</tr>";
  protected final String TEXT_325 = NL + "\t\t\t\t\t<tr>" + NL + "\t\t\t\t       <td class=\"label\">" + NL + "\t\t\t\t       \t\t<label>";
  protected final String TEXT_326 = ":</label>" + NL + "\t\t\t\t       </td>" + NL + "\t\t\t\t       <td class=\"field\" ";
  protected final String TEXT_327 = "colspan=\"";
  protected final String TEXT_328 = "\"";
  protected final String TEXT_329 = ">" + NL + "\t\t\t\t\t   \t\t<input type=\"file\" id=\"";
  protected final String TEXT_330 = "\" name=\"";
  protected final String TEXT_331 = "\" size=\"35\" onchange=\"goolov.validete.file(this);\"/>" + NL + "\t\t\t\t   \t   </td>" + NL + "\t\t\t\t   \t</tr>";
  protected final String TEXT_332 = NL + "\t\t\t\t\t<tr>" + NL + "\t\t\t\t\t  <td colspan=\"";
  protected final String TEXT_333 = "\">" + NL + "\t\t\t\t\t  \t<div class=\"v-section-wrap\">" + NL + "\t\t\t\t\t  \t\t<div class=\"v-title\">";
  protected final String TEXT_334 = ":</div>" + NL + "\t\t\t\t\t  \t\t<div class=\"v-content\">" + NL + "\t\t\t\t\t  \t\t\t<input type=\"hidden\" id=\"";
  protected final String TEXT_335 = "\" name=\"";
  protected final String TEXT_336 = "\"/>" + NL + "\t\t\t\t\t  \t\t\t<textarea style=\"width:98%;\"  id=\"fck_";
  protected final String TEXT_337 = "\">" + NL + "\t\t\t\t\t      \t\t  ${mo.";
  protected final String TEXT_338 = "}" + NL + "\t\t\t\t\t   \t\t\t</textarea>" + NL + "\t\t\t\t\t\t\t  \t<script type=\"text/javascript\">" + NL + "\t\t\t\t\t\t             var oFCKeditor = new FCKeditor('fck_";
  protected final String TEXT_339 = "') ; " + NL + "\t\t\t\t\t                 oFCKeditor.BasePath\t= '${ctx}/resources/fckeditor/' ;" + NL + "\t\t\t\t\t                 oFCKeditor.Config[\"CustomConfigurationsPath\"]=\"${ctx}/resources/fckeditor/customConfig.js\";" + NL + "\t\t\t\t\t\t             oFCKeditor.ToolbarSet='goolovEdit';" + NL + "\t\t\t\t\t\t             oFCKeditor.Config[\"TabSpaces\"]=2;" + NL + "\t\t\t\t\t\t             oFCKeditor.Config[\"LinkUpload\"] = false;" + NL + "\t\t\t\t\t\t             oFCKeditor.Config[\"ImageUpload\"] = true;" + NL + "\t\t\t\t\t\t             oFCKeditor.Config[\"FlashUpload\"] = false;" + NL + "\t\t\t\t\t\t             oFCKeditor.Height\t= 350;" + NL + "\t\t\t\t\t                 oFCKeditor.ReplaceTextarea(); " + NL + "\t\t\t\t\t            </script>" + NL + "\t\t\t\t\t          </div>" + NL + "\t\t\t\t\t  \t </div>" + NL + "\t\t\t\t\t  </td>" + NL + "\t\t\t\t   </tr>\t      ";
  protected final String TEXT_340 = NL + "\t\t\t\t</table>" + NL + "\t\t\t  </form>";
  protected final String TEXT_341 = NL + "\t\t\t</div><!-- tab one end -->";
  protected final String TEXT_342 = NL + "\t  \t\t<div title=\"";
  protected final String TEXT_343 = "\"><!--";
  protected final String TEXT_344 = " tab start-->" + NL + "\t\t  \t\t<div class=\"v-fckeditor\">" + NL + "\t\t  \t\t\t<input type=\"hidden\" id=\"";
  protected final String TEXT_345 = "\" name=\"";
  protected final String TEXT_346 = "\"/>" + NL + "\t\t  \t\t\t<textarea style=\"width: 90%;\"  id=\"fck_";
  protected final String TEXT_347 = "\">" + NL + "\t\t      \t\t  ${mo.";
  protected final String TEXT_348 = "}" + NL + "\t\t   \t\t\t</textarea>" + NL + "\t\t\t\t  \t<script type=\"text/javascript\">" + NL + "\t\t\t             var oFCKeditor = new FCKeditor('fck_";
  protected final String TEXT_349 = "') ; " + NL + "\t\t                 oFCKeditor.BasePath\t= '${ctx}/resources/fckeditor/' ;" + NL + "\t\t                 oFCKeditor.Config[\"CustomConfigurationsPath\"]=\"${ctx}/resources/fckeditor/customConfig.js\";" + NL + "\t\t\t             oFCKeditor.ToolbarSet='goolovEditTab';" + NL + "\t\t\t             oFCKeditor.Config[\"TabSpaces\"]=2;" + NL + "\t\t\t             oFCKeditor.Config[\"LinkUpload\"] = false;" + NL + "\t\t\t             oFCKeditor.Config[\"ImageUpload\"] = true;" + NL + "\t\t\t             oFCKeditor.Config[\"FlashUpload\"] = false;" + NL + "\t\t\t             oFCKeditor.Height\t= ";
  protected final String TEXT_350 = "-130;" + NL + "\t\t                 oFCKeditor.ReplaceTextarea(); " + NL + "\t\t            </script>" + NL + "\t\t          </div>" + NL + "\t\t\t</div><!--";
  protected final String TEXT_351 = " tab end-->";
  protected final String TEXT_352 = "\t\t\t";
  protected final String TEXT_353 = NL + "\t\t\t<div title=\"";
  protected final String TEXT_354 = "\"  class=\"v-tab\"><!--";
  protected final String TEXT_355 = " tab start-->" + NL + "\t\t\t\t<div class=\"v-section-wrap\">" + NL + "\t\t\t\t\t<div class='v-title'>选择";
  protected final String TEXT_356 = "：</div>" + NL + "\t\t\t\t\t<div class=\"v-content\">" + NL + "\t\t\t\t\t\t${";
  protected final String TEXT_357 = "}" + NL + "\t\t\t\t\t</div>" + NL + "\t\t\t\t</div>" + NL + "\t\t\t</div><!--";
  protected final String TEXT_358 = " tab end-->";
  protected final String TEXT_359 = NL + "\t\t\t<div title=\"";
  protected final String TEXT_360 = "\"   class=\"v-tab\"><!--";
  protected final String TEXT_361 = " tab start-->" + NL + "\t\t\t\t\t<div class=\"v-tree-wrap\">" + NL + "\t\t\t\t\t\t<div class=\"v-title\">选择";
  protected final String TEXT_362 = "：</div>" + NL + "\t\t\t\t\t\t<div class=\"v-content\" id=\"";
  protected final String TEXT_363 = "\" style=\"height:270px; width:350px; overflow: auto;\">" + NL + "\t\t\t\t\t\t</div>" + NL + "\t\t\t\t\t</div>" + NL + "\t\t\t</div><!--";
  protected final String TEXT_364 = " tab end-->";
  protected final String TEXT_365 = "\t\t\t\t\t\t" + NL + "\t\t  </div><!-- firstTabs end -->";
  protected final String TEXT_366 = NL + "\t\t</div><!-- center end -->" + NL + "\t\t<div region=\"south\" border=\"false\" style=\"height:50px;\"><!-- south start-->" + NL + "\t\t\t<div class=\"v-buttons\"><!-- v-buttons start -->" + NL + "\t\t  \t \t<c:choose>" + NL + "\t\t\t  \t \t<c:when test=\"${null==model.id}\">" + NL + "\t\t\t\t   \t\t\t<a href=\"javascript:newWinSaveData();\" class=\"easyui-linkbutton\">新增</a>" + NL + "\t\t\t\t   \t\t\t<a href=\"javascript:resetData();\" class=\"easyui-linkbutton\" >重置</a>" + NL + "\t\t\t\t   \t\t\t<a href=\"javascript:newWinClose();\" class=\"easyui-linkbutton\" >关闭</a>" + NL + "\t\t\t\t   \t\t\t<a href=\"javascript:newWinCloseAndRefresh();\" class=\"easyui-linkbutton\" >关闭并刷新</a>" + NL + "\t\t\t \t  \t</c:when>" + NL + "\t\t\t   \t\t<c:otherwise>" + NL + "\t\t\t\t   \t\t\t<a href=\"javascript:editWinUpdateData();\" class=\"easyui-linkbutton\" >更新</a>" + NL + "\t\t\t\t\t\t\t<a href=\"javascript:resetData();\" class=\"easyui-linkbutton\" >重置</a>" + NL + "\t\t\t\t\t\t\t<a href=\"javascript:editWinClose();\" class=\"easyui-linkbutton\" >关闭</a>" + NL + "\t\t\t\t\t\t\t<a href=\"javascript:editWinCloseAndRefresh();\" class=\"easyui-linkbutton\" >关闭并刷新</a>" + NL + "\t\t\t\t\t</c:otherwise>" + NL + "\t\t\t\t</c:choose> " + NL + "\t\t\t</div><!-- v-buttons end-->" + NL + "\t\t</div><!--\tsouth end -->" + NL + "</body>" + NL + "</html>";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    Property curProperty = (Property) argument;Package uml2Package = curProperty.getNearestPackage();
    Class ownerClass=(Class)curProperty.getOwner();
    String ownerClassCommentName=TypeHelper.getDocumentationOrName(ownerClass);
    Property ownerClassIdProperty=EntityHelper.getIDProperty(ownerClass);
    String ownerClassIdPropertyName=NameHelper.uncapSafeName(ownerClassIdProperty);
    UmlClassByPropertyWrap named=new UmlClassByPropertyWrap(curProperty);
    Class uml2Class=ownerClass;
    
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
String modelInputJsPath=named.getWebPath(NameRuledWebPathKind.js_input);
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
    stringBuffer.append(ownerClassCommentName);
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
    List<Property> tabsList=ViewInputHelper.getTabsProperty(ownerClass);
    if(null!=tabsList&&!tabsList.isEmpty()){
    stringBuffer.append(TEXT_19);
    }
    stringBuffer.append(TEXT_20);
    Property idProperty=EntityHelper.getIDProperty(ownerClass);
    if(EntityHelper.isIDAuto(idProperty)||EntityHelper.isIDUUID(idProperty)){
    	if(!ViewInputHelper.isViewInput(idProperty)){
    stringBuffer.append(TEXT_21);
    stringBuffer.append(NameHelper.uncapSafeName(idProperty));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(NameHelper.uncapSafeName(idProperty));
    stringBuffer.append(TEXT_23);
    	}
    }
    stringBuffer.append(TEXT_24);
    
boolean needDoubleCols=ViewInputHelper.isNeedTableDoubleCols(ownerClass);//needDoubleTDCols
int trIncludeTd=needDoubleCols?4:2;
int tdCount=0;
int needTd=2;
//simple Input Property
//List<Property> simpleInputProperty=ViewInputHelper.getSimpleInputProperty(uml2Class);

    /********process select property type clazz********/
    if(!ClassHelper.isSimple(curProperty)){
    Class relClass = (Class) curProperty.getType();Package relPackage = relClass.getPackage();
    String relClassCommentName=TypeHelper.getDocumentationOrName(relClass);
    Property relClassOppositeProperty=curProperty.getOpposite();
    String relClassOppositePropertyName=NameHelper.uncapSafeName(relClassOppositeProperty);
    			if(tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_25);
    			}
    stringBuffer.append(TEXT_26);
    			needTd=2>trIncludeTd?trIncludeTd:2;
    			if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_27);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_28);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    			}				
    stringBuffer.append(TEXT_29);
    stringBuffer.append(ownerClassCommentName);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(relClassOppositePropertyName);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(relClassOppositePropertyName);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(ownerClassIdPropertyName);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(relClassOppositePropertyName);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(ownerClassIdPropertyName);
    stringBuffer.append(TEXT_36);
    				tdCount+=needTd;
    stringBuffer.append(TEXT_37);
    			if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_38);
    			}
    }
    stringBuffer.append(TEXT_39);
    
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
    stringBuffer.append(TEXT_40);
    			}
    stringBuffer.append(TEXT_41);
    			if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_42);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_43);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    			}
    stringBuffer.append(TEXT_44);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(NameHelper.uncapSafeName(idProperty));
    stringBuffer.append(TEXT_47);
    			tdCount+=needTd;
    stringBuffer.append(TEXT_48);
    			if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_49);
    			}
    stringBuffer.append(TEXT_50);
    		}
    	}else if(EntityHelper.isIDAssign(idProperty)){
 		String propertyCommentName=TypeHelper.getDocumentationOrName(idProperty);
 		String propertyUncapSafeName=NameHelper.uncapSafeName(idProperty);
 		String propertyStyleClass=ViewInputHelper.getStyleClass(idProperty);

    			if(tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_51);
    			}
    stringBuffer.append(TEXT_52);
    				needTd=2>trIncludeTd?trIncludeTd:2;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_53);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_54);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    stringBuffer.append(TEXT_55);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(propertyStyleClass);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(propertyStyleClass);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_66);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_67);
    				}
    stringBuffer.append(TEXT_68);
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

    			if(property.getName().equals(curProperty.getName())){
    				continue;
    			}
    			if(tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_69);
    			}
    stringBuffer.append(TEXT_70);
    	/********process parentId Property start********/
    			if (TreeStereotypeHelper.isParentIdProperty(property)) {// text
    				needTd=2>trIncludeTd?trIncludeTd:2;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_71);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_72);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    stringBuffer.append(TEXT_73);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_77);
    if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_78);
    }
    stringBuffer.append(TEXT_79);
    if(ViewInputHelper.isViewInput_readonly(property)){
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
    	/********process parentId Property end********/
    	/********process text********/
    			if (ViewInputHelper.isViewInputText(property)) {// text
    				needTd=2>trIncludeTd?trIncludeTd:2;
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
    				if(	ViewInputHelper.isViewInput_readonly(property)){
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
    				}
    stringBuffer.append(TEXT_96);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_97);
    				}
    stringBuffer.append(TEXT_98);
    				continue;
    			}
    	/********process title********/
    			if (ViewInputHelper.isViewInputTitle(property)) {// title
    				needTd=4>trIncludeTd?trIncludeTd:4;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_99);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_100);
    					tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    stringBuffer.append(TEXT_101);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_103);
    if(						ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_104);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_105);
    							}else{
    stringBuffer.append(TEXT_106);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(propertyStyleClass);
    stringBuffer.append(TEXT_110);
    if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_111);
    }
    stringBuffer.append(TEXT_112);
    							}
    stringBuffer.append(TEXT_113);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_114);
    				}
    stringBuffer.append(TEXT_115);
    				continue;
    			}
    	/********process select********/
    			if (ViewInputHelper.isViewInputSelect(property)) {// select
    				needTd=2>trIncludeTd?trIncludeTd:2;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_116);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_117);
    					tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    stringBuffer.append(TEXT_118);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_119);
    				Enumeration enumeration=EnumKindHelper.getAppliedEnumKindEnumeration(property);
    				if(null!=enumeration){
    					String modelEnumQualifiedName=MdaHelper.getModelQualifiedName(enumeration,PKGSuffix.enumeration,ModelNameSuffix.enumeration);
    					String modelEnumName=MdaHelper.getModelClassName(enumeration,ModelNameSuffix.enumeration);
    					String modelEnumSelectHtml=NamedUtil.getPropertyNamed(enumeration,PropertyNamedRuleKind.selectHtml);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(propertyStyleClass);
    stringBuffer.append(TEXT_124);
    if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_125);
    }
    stringBuffer.append(TEXT_126);
    if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_127);
    }
    stringBuffer.append(TEXT_128);
    stringBuffer.append(modelEnumSelectHtml);
    stringBuffer.append(TEXT_129);
    				}else{
    stringBuffer.append(TEXT_130);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_131);
    if(						ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_132);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_133);
    							}else{
    stringBuffer.append(TEXT_134);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(propertyStyleClass);
    stringBuffer.append(TEXT_138);
    if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_139);
    }
    stringBuffer.append(TEXT_140);
    							}
    stringBuffer.append(TEXT_141);
    				}
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_142);
    				}
    stringBuffer.append(TEXT_143);
    				continue;
    			}
    stringBuffer.append(TEXT_144);
    	/********process radio********/
    stringBuffer.append(TEXT_145);
    			if (ViewInputHelper.isViewInputRadio(property)) {// radio
    				needTd=4>trIncludeTd?trIncludeTd:4;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_146);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_147);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    stringBuffer.append(TEXT_148);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_149);
    				Enumeration enumeration=EnumKindHelper.getAppliedEnumKindEnumeration(property);
    				if(null!=enumeration){
    						String propertyRadioGroup=NamedUtil.getPropertyNamed(enumeration,PropertyNamedRuleKind.inputRadioGroup);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(propertyRadioGroup);
    stringBuffer.append(TEXT_152);
    				}else{
    stringBuffer.append(TEXT_153);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_154);
    if(						ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_155);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_156);
    							}else{
    stringBuffer.append(TEXT_157);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(propertyStyleClass);
    stringBuffer.append(TEXT_161);
    if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_162);
    }
    stringBuffer.append(TEXT_163);
    							}
    stringBuffer.append(TEXT_164);
    				}
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_165);
    				}
    stringBuffer.append(TEXT_166);
    				continue;
    			}
    	/********process datePicker********/
    			if (ViewInputHelper.isViewInputDatePicker(property)) {// datePicker
    				String propertyToDateTimeCapName=PropertyNamedRuleKind.dateToDateTimeStr.getRuleCapNamed(property);
    				String propertyToDateTimeUncapName=PropertyNamedRuleKind.dateToDateTimeStr.getRuleUnCapNamed(property);
    				needTd=2>trIncludeTd?trIncludeTd:2;
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
    if(						ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_172);
    stringBuffer.append(propertyToDateTimeUncapName);
    stringBuffer.append(TEXT_173);
    							}else{
    stringBuffer.append(TEXT_174);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(propertyStyleClass);
    stringBuffer.append(TEXT_178);
    if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_179);
    }
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
    	/********process texttarea********/
    			if (ViewInputHelper.isViewInputTextarea(property)) {// texttarea 
    				needTd=4>trIncludeTd?trIncludeTd:4;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_184);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_185);
    					tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    stringBuffer.append(TEXT_186);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_188);
    if(						ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_189);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_190);
    							}else{
    stringBuffer.append(TEXT_191);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(propertyStyleClass);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_195);
    							}
    stringBuffer.append(TEXT_196);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_197);
    				}
    stringBuffer.append(TEXT_198);
    				continue;
    			}	
    stringBuffer.append(TEXT_199);
    	/********process checkbox********/
    			if (ViewInputHelper.isViewInputCheckbox(property)) {// checkbox
    				needTd=4>trIncludeTd?trIncludeTd:4;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_200);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_201);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    stringBuffer.append(TEXT_202);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_204);
    if(						ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_205);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_206);
    							}else{
    stringBuffer.append(TEXT_207);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(propertyStyleClass);
    stringBuffer.append(TEXT_211);
    							}
    stringBuffer.append(TEXT_212);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_213);
    				}
    stringBuffer.append(TEXT_214);
    				continue;
    			}
    stringBuffer.append(TEXT_215);
    	/********process file********/
    stringBuffer.append(TEXT_216);
    //			if (isViewInputFile(property)) {// file
    //			}		
    	/********process image********/
    stringBuffer.append(TEXT_217);
    //			if (isViewInputImage(property)) {// image
    //			}			
    	/********process content********/
    stringBuffer.append(TEXT_218);
    //			if (isViewInputContent(property)) {// content
    //			}
    
/*****************************************************************
 * process rel 
/*****************************************************************/

    /********process M2OSelect********/
    stringBuffer.append(TEXT_219);
    			if (ViewInputHelper.isApplyM2OSelect(property)) {//M2OSelect
    				Class propertyType = (Class) property.getType();
    				String propertyTypeComment = TypeHelper.getDocumentationOrName(propertyType);
     				Property propertyTypeIdProperty=EntityHelper.getIDProperty(propertyType);
     				String propertyTypeIdPropertyUncapSafeName=NameHelper.uncapSafeName(propertyTypeIdProperty);
     				String listLabelPropertyUncapSafeName=ViewListHelper.getViewListLabelRelPropertyName(property);
    				needTd=2>trIncludeTd?trIncludeTd:2;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_220);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_221);
    					tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    				//String m2oSelectHtml=NamedUtil.getPropertyNamed(property,PropertyNamedRuleKind.selectHtml);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(propertyTypeComment);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_236);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_237);
    				}
    stringBuffer.append(TEXT_238);
    				continue;
    			}	
    stringBuffer.append(TEXT_239);
    	/********process M2OSelectPage********/
    			if (ViewInputHelper.isApplyM2OSelectPage(property)) {//M2OSelectPage
    				Class propertyType = (Class) property.getType();
    				String propertyTypeComment = TypeHelper.getDocumentationOrName(propertyType);
     				Property propertyTypeIdProperty=EntityHelper.getIDProperty(propertyType);
     				String propertyTypeIdPropertyUncapSafeName=NameHelper.uncapSafeName(propertyTypeIdProperty);
    				needTd=2>trIncludeTd?trIncludeTd:2;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_240);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_241);
    					tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    stringBuffer.append(TEXT_242);
    stringBuffer.append(propertyTypeComment);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_244);
    							if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_245);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_247);
    							}else{
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
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(propertyStyleClass);
    stringBuffer.append(TEXT_255);
    if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_256);
    }
    stringBuffer.append(TEXT_257);
    							}
    stringBuffer.append(TEXT_258);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_259);
    				}
    stringBuffer.append(TEXT_260);
    				continue;
    			}
    stringBuffer.append(TEXT_261);
    	/********process O2OSelect********/
    			if (ViewInputHelper.isApplyO2OSelect(property)) {//O2OSelect
    stringBuffer.append(TEXT_262);
    				Class propertyType = (Class) property.getType();
    				String propertyTypeComment = TypeHelper.getDocumentationOrName(propertyType);
     				Property propertyTypeIdProperty=EntityHelper.getIDProperty(propertyType);
     				String propertyTypeIdPropertyUncapSafeName=NameHelper.uncapSafeName(propertyTypeIdProperty);
     				String listLabelPropertyUncapSafeName=ViewListHelper.getViewListLabelRelPropertyName(property);
    				needTd=2>trIncludeTd?trIncludeTd:2;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_263);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_264);
    					tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    				String O2OSelectHtml=NamedUtil.getPropertyNamed(property,PropertyNamedRuleKind.selectHtml);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(propertyTypeComment);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_272);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_277);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_278);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_279);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_280);
    				}
    stringBuffer.append(TEXT_281);
    				continue;
    			}	
    stringBuffer.append(TEXT_282);
    	/********process O2OSelectPage********/
    			if (ViewInputHelper.isApplyO2OSelectPage(property)) {//O2OSelectPage
    				Class propertyType = (Class) property.getType();
    				String propertyTypeComment = TypeHelper.getDocumentationOrName(propertyType);
     				Property propertyTypeIdProperty=EntityHelper.getIDProperty(propertyType);
     				String propertyTypeIdPropertyUncapSafeName=NameHelper.uncapSafeName(propertyTypeIdProperty);
    				needTd=2>trIncludeTd?trIncludeTd:2;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_283);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_284);
    					tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    stringBuffer.append(TEXT_285);
    stringBuffer.append(propertyTypeComment);
    stringBuffer.append(TEXT_286);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_287);
    							if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_288);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_289);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_290);
    							}else{
    stringBuffer.append(TEXT_291);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_292);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_293);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_294);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_296);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_297);
    stringBuffer.append(propertyStyleClass);
    stringBuffer.append(TEXT_298);
    if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_299);
    }
    stringBuffer.append(TEXT_300);
    							}
    stringBuffer.append(TEXT_301);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_302);
    				}
    stringBuffer.append(TEXT_303);
    				continue;
    			}
    stringBuffer.append(TEXT_304);
    	}
    	if (tdCount%trIncludeTd!=0){
    stringBuffer.append(TEXT_305);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_306);
    	}
    
	/*****************************************************************
	 * property simple input end
	/*****************************************************************/

    stringBuffer.append(TEXT_307);
    
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
     			String propertyUncapSafeName=NameHelper.uncapSafeName(property);
     			String propertyStyleClass=ViewInputHelper.getStyleClass(property);
    			Type propertyType=property.getType();
    			Class relTargetClass=(Class)propertyType;
    			String relPropertyCheckboxs=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relCheckboxs);
    stringBuffer.append(TEXT_308);
    stringBuffer.append(trIncludeTd);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(relPropertyCheckboxs);
    stringBuffer.append(TEXT_311);
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
    stringBuffer.append(TEXT_312);
    stringBuffer.append(trIncludeTd);
    stringBuffer.append(TEXT_313);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_314);
    stringBuffer.append(relPropertyCheckTreeDomId);
    stringBuffer.append(TEXT_315);
    		}
    }
    
/*****************************************************************
 * process image file content properties
/*****************************************************************/

    /********process image properties********/
    List<Property> imagePropertyList=ViewInputHelper.getViewInputImage(uml2Class);
    if(null!=imagePropertyList&&imagePropertyList.size()>0){
    	for(Property property:imagePropertyList){
     			String propertyCommentName=TypeHelper.getDocumentationOrName(property);
     			String propertyUncapSafeName=NameHelper.uncapSafeName(property);
     			//String propertyStyleClass=ViewInputHelper.getStyleClass(property);
    stringBuffer.append(TEXT_316);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_317);
    if(trIncludeTd-1>1){
    stringBuffer.append(TEXT_318);
    stringBuffer.append(trIncludeTd-1);
    stringBuffer.append(TEXT_319);
    }
    stringBuffer.append(TEXT_320);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_321);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_322);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_323);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_324);
    		}
    }
    /********process file properties********/
    List<Property> filePropertyList=ViewInputHelper.getViewInputFile(uml2Class);
    if(null!=filePropertyList&&filePropertyList.size()>0){
    	for(Property property:filePropertyList){
     			String propertyCommentName=TypeHelper.getDocumentationOrName(property);
     			String propertyUncapSafeName=NameHelper.uncapSafeName(property);
     			//String propertyStyleClass=ViewInputHelper.getStyleClass(property);
    stringBuffer.append(TEXT_325);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_326);
    if(trIncludeTd-1>1){
    stringBuffer.append(TEXT_327);
    stringBuffer.append(trIncludeTd-1);
    stringBuffer.append(TEXT_328);
    }
    stringBuffer.append(TEXT_329);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_330);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_331);
    	}
    }
    /********process content properties********/
    if(null!=contentPropertyList&&contentPropertyList.size()>0){
    for(Property property:contentPropertyList){
     			String propertyCommentName=TypeHelper.getDocumentationOrName(property);
     			String propertyUncapSafeName=NameHelper.uncapSafeName(property);
     			//String propertyStyleClass=ViewInputHelper.getStyleClass(property);
    stringBuffer.append(TEXT_332);
    stringBuffer.append(trIncludeTd);
    stringBuffer.append(TEXT_333);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_334);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_335);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_336);
    stringBuffer.append(NameHelper.getUncapName(property));
    stringBuffer.append(TEXT_337);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_339);
    }}
    stringBuffer.append(TEXT_340);
    if(!tabsList.isEmpty()||!contentTabPropertyList.isEmpty()){
    stringBuffer.append(TEXT_341);
    	for(Iterator<Property> iter=contentTabPropertyList.iterator();iter.hasNext();){
    			Property property=iter.next();
     			String propertyCommentName=TypeHelper.getDocumentationOrName(property);
     			String propertyUncapSafeName=NameHelper.uncapSafeName(property);
     			//String propertyStyleClass=ViewInputHelper.getStyleClass(property);
    			String propertyCapConmentName=TypeHelper.getDocumentationOrName(property);
    stringBuffer.append(TEXT_342);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_343);
    stringBuffer.append(propertyCapConmentName);
    stringBuffer.append(TEXT_344);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_345);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_346);
    stringBuffer.append(NameHelper.getUncapName(property));
    stringBuffer.append(TEXT_347);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_348);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_349);
    stringBuffer.append(PageHelper.getWinHeight(uml2Class));
    stringBuffer.append(TEXT_350);
    stringBuffer.append(propertyCapConmentName);
    stringBuffer.append(TEXT_351);
    	}
    stringBuffer.append(TEXT_352);
    	for(Iterator<Property> iter=tabsList.iterator();iter.hasNext();){
    		Property property=iter.next();
    		if(ClassHelper.isSimple(property))continue;
    		String propertyCapName=NameHelper.getCapName(property);
    		String propertyCapConmentName=TypeHelper.getDocumentationOrName(property);
    		String propertyName=NameHelper.uncapSafeName(property);
    		Type propertyType=property.getType();
    		Class relTargetClass=null;
    		if(ModelStereoTypeHelper.isApplyModel_M2M(propertyType)||ModelStereoTypeHelper.isApplyModel_M2mWithId(propertyType)){
    			Class relUml2Class=(Class)propertyType;
    			relTargetClass=ModelHelper.getRelTargetClass(relUml2Class,uml2Class);
    		}
    		String relTargetClassCommentName=TypeHelper.getDocumentationOrName(relTargetClass);
    		String relPropertyCheckboxs=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relCheckboxs);
    		if (ViewInputHelper.isApplyM2MCheckboxsTab(property)) {//M2OSelect
    stringBuffer.append(TEXT_353);
    stringBuffer.append(propertyCapConmentName);
    stringBuffer.append(TEXT_354);
    stringBuffer.append(propertyCapConmentName);
    stringBuffer.append(TEXT_355);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_356);
    stringBuffer.append(relPropertyCheckboxs);
    stringBuffer.append(TEXT_357);
    stringBuffer.append(propertyCapConmentName);
    stringBuffer.append(TEXT_358);
    		}
    		if (ViewInputHelper.isApplyM2MCheckboxsTreeTab(property)) {//M2OSelectPage
    			String relPropertyShowCheckTreeJson=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relShowCheckTreeJson);
    stringBuffer.append(TEXT_359);
    stringBuffer.append(propertyCapConmentName);
    stringBuffer.append(TEXT_360);
    stringBuffer.append(propertyCapConmentName);
    stringBuffer.append(TEXT_361);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_362);
    stringBuffer.append(relPropertyShowCheckTreeJson);
    stringBuffer.append(TEXT_363);
    stringBuffer.append(propertyCapConmentName);
    stringBuffer.append(TEXT_364);
    		}
    	}
    stringBuffer.append(TEXT_365);
    }
    stringBuffer.append(TEXT_366);
    return stringBuffer.toString();
  }
}
