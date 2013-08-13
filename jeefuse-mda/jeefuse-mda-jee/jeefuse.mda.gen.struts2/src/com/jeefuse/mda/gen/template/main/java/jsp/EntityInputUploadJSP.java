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

public class EntityInputUploadJSP
{
  protected static String nl;
  public static synchronized EntityInputUploadJSP create(String lineSeparator)
  {
    nl = lineSeparator;
    EntityInputUploadJSP result = new EntityInputUploadJSP();
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
  protected final String TEXT_10 = "\" type=\"text/javascript\"></script>" + NL + "<script>" + NL + "\tvar ctx = '${ctx}';" + NL + "\tvar theme = '${theme}';" + NL + "\timportCssFile('sys|ui', ctx, theme);" + NL + "\timportJsFile('jquery|blockUI|ui|common|form|validate";
  protected final String TEXT_11 = "|fckeditor";
  protected final String TEXT_12 = "', ctx);" + NL + "\timportJsFile('";
  protected final String TEXT_13 = "', ctx);" + NL + "</script>" + NL + "</head>" + NL + "<body class=\"easyui-layout v-container\">" + NL + " \t<div region=\"center\" border=\"false\"><!-- center start -->";
  protected final String TEXT_14 = NL + "\t\t<div id=\"firstTabs\" class=\"v-tabs\"><!-- firstTabs start -->" + NL + "\t\t  <div title=\"基本信息\"  class=\"v-tab\"><!-- tab one  start -->";
  protected final String TEXT_15 = NL + " \t\t\t<form id=\"inputForm\" method=\"post\" class=\"v-form\">";
  protected final String TEXT_16 = NL + " \t\t\t\t<input type=\"hidden\" name=\"";
  protected final String TEXT_17 = "\" value=\"${mo.";
  protected final String TEXT_18 = "}\"/>";
  protected final String TEXT_19 = NL + " \t\t\t\t<!--<div id=\"inputInfo\" class=\"v-state-info\"></div>-->" + NL + "\t\t      \t<table>";
  protected final String TEXT_20 = NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_21 = "\t";
  protected final String TEXT_22 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_23 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_24 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_25 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_26 = "\">" + NL + "\t\t      \t\t\t\t${mo.";
  protected final String TEXT_27 = "}" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_28 = "\t";
  protected final String TEXT_29 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_30 = "\t\t\t\t\t\t";
  protected final String TEXT_31 = NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_32 = "\t";
  protected final String TEXT_33 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_34 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_35 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_36 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_37 = "\">" + NL + "\t\t      \t\t\t\t<c:choose>" + NL + "\t\t\t\t\t\t  \t \t<c:when test=\"${null==model.id}\">" + NL + "\t\t\t\t\t\t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_38 = "\" name=\"";
  protected final String TEXT_39 = "\" value=\"${mo.";
  protected final String TEXT_40 = "}\" class=\"";
  protected final String TEXT_41 = "\"/>" + NL + "\t\t\t\t\t\t \t    </c:when>" + NL + "\t\t\t\t\t\t   \t    <c:otherwise>" + NL + "\t\t\t\t\t\t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_42 = "\" name=\"";
  protected final String TEXT_43 = "\" value=\"${mo.";
  protected final String TEXT_44 = "}\" class=\"";
  protected final String TEXT_45 = " readonly\" readonly='readonly' />" + NL + "\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"oldId\" name=\"oldId\" value=\"${mo.";
  protected final String TEXT_46 = "}\"/>" + NL + "\t\t\t\t\t\t\t    </c:otherwise>" + NL + "\t\t\t\t\t\t\t</c:choose> " + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_47 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_48 = "\t\t\t\t\t\t";
  protected final String TEXT_49 = NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_50 = "\t";
  protected final String TEXT_51 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_52 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_53 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_54 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_55 = "\">" + NL + "\t\t\t\t\t\t\t <select name=\"";
  protected final String TEXT_56 = "\" id=\"";
  protected final String TEXT_57 = "\" class=\"text ";
  protected final String TEXT_58 = "readonly";
  protected final String TEXT_59 = "\" ";
  protected final String TEXT_60 = "readonly=\"readonly\"";
  protected final String TEXT_61 = ">" + NL + "\t\t\t\t\t\t\t     <option value=\"\" >无</option>" + NL + "\t\t\t\t\t\t\t     <s:property value=\"htmlSelectTree\" escape=\"false\"/>" + NL + "\t\t\t\t\t\t\t  </select>" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_62 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_63 = "\t\t\t\t\t\t";
  protected final String TEXT_64 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_65 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_66 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_67 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_68 = "\">";
  protected final String TEXT_69 = NL + "\t\t      \t\t\t\t${mo.";
  protected final String TEXT_70 = "}";
  protected final String TEXT_71 = NL + "\t\t      \t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_72 = "\" name=\"";
  protected final String TEXT_73 = "\" value=\"${mo.";
  protected final String TEXT_74 = "}\" class=\"";
  protected final String TEXT_75 = "\" />";
  protected final String TEXT_76 = NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_77 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_78 = "\t\t\t\t\t\t";
  protected final String TEXT_79 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_80 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_81 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_82 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_83 = "\">";
  protected final String TEXT_84 = NL + "\t\t      \t\t\t\t\t${mo.";
  protected final String TEXT_85 = "}";
  protected final String TEXT_86 = NL + "\t\t      \t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_87 = "\" name=\"";
  protected final String TEXT_88 = "\" value=\"${mo.";
  protected final String TEXT_89 = "}\" class=\"";
  protected final String TEXT_90 = "\" ";
  protected final String TEXT_91 = "readonly=\"readonly\"";
  protected final String TEXT_92 = "/>";
  protected final String TEXT_93 = "\t\t\t\t\t\t\t" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_94 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_95 = "\t\t\t\t\t\t";
  protected final String TEXT_96 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_97 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_98 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_99 = ":</label>" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_100 = NL + "\t\t\t\t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_101 = "\">" + NL + "\t\t\t\t\t\t\t <select  id=\"";
  protected final String TEXT_102 = "\" name=\"";
  protected final String TEXT_103 = "\" class=\"";
  protected final String TEXT_104 = " class=\"text ";
  protected final String TEXT_105 = "readonly";
  protected final String TEXT_106 = "\" ";
  protected final String TEXT_107 = "readonly=\"readonly\"";
  protected final String TEXT_108 = ">" + NL + "\t\t\t\t\t\t\t     <s:property value=\"";
  protected final String TEXT_109 = "\" escape=\"false\"/>" + NL + "\t\t\t\t\t\t\t </select>" + NL + "\t\t\t\t\t\t</td>";
  protected final String TEXT_110 = NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_111 = "\">";
  protected final String TEXT_112 = NL + "\t\t      \t\t\t\t\t${mo.";
  protected final String TEXT_113 = "}";
  protected final String TEXT_114 = NL + "\t\t      \t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_115 = "\" name=\"";
  protected final String TEXT_116 = "\" value=\"${mo.";
  protected final String TEXT_117 = "}\" class=\"";
  protected final String TEXT_118 = "\" ";
  protected final String TEXT_119 = "readonly=\"readonly\"";
  protected final String TEXT_120 = "/>";
  protected final String TEXT_121 = "\t" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_122 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_123 = "\t\t\t\t\t\t";
  protected final String TEXT_124 = "\t";
  protected final String TEXT_125 = "\t";
  protected final String TEXT_126 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_127 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_128 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_129 = ":</label>" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_130 = NL + "\t\t\t\t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_131 = "\">" + NL + "\t\t\t\t\t\t\t ${";
  protected final String TEXT_132 = "}" + NL + "\t\t\t\t\t\t</td>";
  protected final String TEXT_133 = NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_134 = "\">";
  protected final String TEXT_135 = NL + "\t\t      \t\t\t\t\t${mo.";
  protected final String TEXT_136 = "}";
  protected final String TEXT_137 = NL + "\t\t      \t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_138 = "\" name=\"";
  protected final String TEXT_139 = "\" value=\"${mo.";
  protected final String TEXT_140 = "}\" class=\"";
  protected final String TEXT_141 = "\" ";
  protected final String TEXT_142 = "readonly=\"readonly\"";
  protected final String TEXT_143 = "/>";
  protected final String TEXT_144 = "\t" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_145 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_146 = "\t\t\t\t\t\t";
  protected final String TEXT_147 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_148 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_149 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_150 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_151 = "\">";
  protected final String TEXT_152 = NL + "\t\t      \t\t\t\t\t${mo.";
  protected final String TEXT_153 = "}";
  protected final String TEXT_154 = NL + "\t\t      \t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_155 = "\" name=\"";
  protected final String TEXT_156 = "\" value=\"${mo.";
  protected final String TEXT_157 = "}\" class=\"";
  protected final String TEXT_158 = "\" ";
  protected final String TEXT_159 = "readonly=\"readonly\"";
  protected final String TEXT_160 = "/>";
  protected final String TEXT_161 = "\t" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_162 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_163 = "\t\t\t\t\t\t";
  protected final String TEXT_164 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_165 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_166 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_167 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_168 = "\">";
  protected final String TEXT_169 = NL + "\t\t      \t\t\t\t\t${mo.";
  protected final String TEXT_170 = "}";
  protected final String TEXT_171 = NL + "\t\t      \t\t\t\t<textarea id=\"";
  protected final String TEXT_172 = "\" name=\"";
  protected final String TEXT_173 = "\"  class=\"";
  protected final String TEXT_174 = "\" >${mo.";
  protected final String TEXT_175 = "}</textarea>";
  protected final String TEXT_176 = "\t" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_177 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_178 = "\t\t\t\t\t\t";
  protected final String TEXT_179 = "\t\t";
  protected final String TEXT_180 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_181 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_182 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_183 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_184 = "\">";
  protected final String TEXT_185 = NL + "\t\t      \t\t\t\t\t${mo.";
  protected final String TEXT_186 = "}";
  protected final String TEXT_187 = NL + "\t\t      \t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_188 = "\" name=\"";
  protected final String TEXT_189 = "\" value=\"${mo.";
  protected final String TEXT_190 = "}\" class=\"";
  protected final String TEXT_191 = "\" />";
  protected final String TEXT_192 = "\t\t\t      \t\t" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_193 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_194 = "\t\t\t\t\t\t";
  protected final String TEXT_195 = "\t\t";
  protected final String TEXT_196 = "\t\t\t";
  protected final String TEXT_197 = "\t\t";
  protected final String TEXT_198 = "\t";
  protected final String TEXT_199 = "\t\t";
  protected final String TEXT_200 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_201 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_202 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_203 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t\t\t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_204 = "\">" + NL + "\t\t\t\t\t\t\t <select  id=\"";
  protected final String TEXT_205 = "_";
  protected final String TEXT_206 = "\" name=\"";
  protected final String TEXT_207 = ".";
  protected final String TEXT_208 = "\" ";
  protected final String TEXT_209 = "readonly=\"readonly\"";
  protected final String TEXT_210 = ">" + NL + "\t\t\t\t\t\t\t     <s:property value=\"";
  protected final String TEXT_211 = "\" escape=\"false\"/>" + NL + "\t\t\t\t\t\t\t </select>" + NL + "\t\t\t\t\t\t</td>";
  protected final String TEXT_212 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_213 = "\t\t\t\t\t\t";
  protected final String TEXT_214 = "\t";
  protected final String TEXT_215 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_216 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_217 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_218 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t\t\t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_219 = "\">";
  protected final String TEXT_220 = NL + "\t\t      \t\t\t\t\t${mo.";
  protected final String TEXT_221 = ".";
  protected final String TEXT_222 = "}";
  protected final String TEXT_223 = NL + "\t\t\t\t\t\t\t <input type=\"text\" id=\"";
  protected final String TEXT_224 = "_";
  protected final String TEXT_225 = "\" name=\"";
  protected final String TEXT_226 = ".";
  protected final String TEXT_227 = "\" value=\"${mo.";
  protected final String TEXT_228 = ".";
  protected final String TEXT_229 = "}\" class=\"";
  protected final String TEXT_230 = "\" ";
  protected final String TEXT_231 = "readonly=\"readonly\"";
  protected final String TEXT_232 = "/>";
  protected final String TEXT_233 = "\t\t" + NL + "\t\t\t\t\t\t</td>";
  protected final String TEXT_234 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_235 = "\t\t\t\t\t\t";
  protected final String TEXT_236 = "\t";
  protected final String TEXT_237 = "\t";
  protected final String TEXT_238 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_239 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_240 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_241 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t\t\t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_242 = "\">" + NL + "\t\t\t\t\t\t\t <select  id=\"";
  protected final String TEXT_243 = "_";
  protected final String TEXT_244 = "\" name=\"";
  protected final String TEXT_245 = ".";
  protected final String TEXT_246 = "\" ";
  protected final String TEXT_247 = "readonly=\"readonly\"";
  protected final String TEXT_248 = ">" + NL + "\t\t\t\t\t\t\t     <s:property value=\"";
  protected final String TEXT_249 = "\" escape=\"false\"/>" + NL + "\t\t\t\t\t\t\t </select>" + NL + "\t\t\t\t\t\t</td>";
  protected final String TEXT_250 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_251 = "\t\t\t\t\t\t";
  protected final String TEXT_252 = "\t";
  protected final String TEXT_253 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_254 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_255 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_256 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t\t\t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_257 = "\">";
  protected final String TEXT_258 = NL + "\t\t      \t\t\t\t\t${mo.";
  protected final String TEXT_259 = ".";
  protected final String TEXT_260 = "}";
  protected final String TEXT_261 = NL + "\t\t\t\t\t\t\t <input type=\"text\" id=\"";
  protected final String TEXT_262 = "_";
  protected final String TEXT_263 = "\" name=\"";
  protected final String TEXT_264 = ".";
  protected final String TEXT_265 = "\" value=\"${mo.";
  protected final String TEXT_266 = ".";
  protected final String TEXT_267 = "}\" class=\"";
  protected final String TEXT_268 = "\" ";
  protected final String TEXT_269 = "readonly=\"readonly\"";
  protected final String TEXT_270 = "/>";
  protected final String TEXT_271 = "\t" + NL + "\t\t\t\t\t\t</td>";
  protected final String TEXT_272 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_273 = "\t\t\t\t\t\t";
  protected final String TEXT_274 = "\t";
  protected final String TEXT_275 = "\t" + NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_276 = "\"></td>" + NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_277 = "\t";
  protected final String TEXT_278 = NL + "\t\t\t\t\t<tr>" + NL + "\t\t      \t\t\t<td colspan=\"";
  protected final String TEXT_279 = "\">" + NL + "\t\t      \t\t\t\t<div class=\"v-fieldset-wrap\">" + NL + "\t\t\t      \t\t\t\t<fieldset>" + NL + "\t\t\t\t\t              <legend>" + NL + "\t\t\t\t\t                 \t";
  protected final String TEXT_280 = ":" + NL + "\t\t\t\t\t              </legend>" + NL + "\t\t\t\t\t              <div class=\"v-fieldset-content\">" + NL + "\t\t\t\t\t                \t${";
  protected final String TEXT_281 = "}" + NL + "\t\t\t\t\t\t\t      </div>" + NL + "\t\t\t\t\t            </fieldset>" + NL + "\t\t      \t\t\t\t</div>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t</tr>";
  protected final String TEXT_282 = NL + "\t\t\t\t\t<tr>" + NL + "\t\t      \t\t\t<td colspan=\"";
  protected final String TEXT_283 = "\">" + NL + "\t\t      \t\t\t\t<div class=\"v-tree-wrap\">" + NL + "\t\t\t\t\t\t\t\t<div class=\"v-title\">";
  protected final String TEXT_284 = "：</div>" + NL + "\t\t\t\t\t\t\t\t<div class=\"v-content\" id=\"";
  protected final String TEXT_285 = "\" style=\"height:270px; width:350px; overflow: auto;\">" + NL + "\t\t\t\t\t\t\t\t</div>" + NL + "\t\t\t\t\t\t\t</div>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t</tr>";
  protected final String TEXT_286 = NL + "\t\t\t\t\t<tr>" + NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_287 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" ";
  protected final String TEXT_288 = "colspan=\"";
  protected final String TEXT_289 = "\"";
  protected final String TEXT_290 = ">" + NL + "\t\t\t \t         \t <input type=\"file\" id=\"uploadImage_";
  protected final String TEXT_291 = "\" name=\"uploadImage_";
  protected final String TEXT_292 = "\" size=\"35\"/><br/>" + NL + "\t\t\t \t         \t <div id=\"previewImageWrap_";
  protected final String TEXT_293 = "\">" + NL + "\t\t\t \t         \t \t<img id=\"previewImage_";
  protected final String TEXT_294 = "\" src=\"\"/>" + NL + "\t\t\t \t         \t </div>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t</tr>";
  protected final String TEXT_295 = NL + "\t\t\t\t\t<tr>\t" + NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>上传图片:</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" ";
  protected final String TEXT_296 = "colspan=\"";
  protected final String TEXT_297 = "\"";
  protected final String TEXT_298 = ">" + NL + "\t\t      \t\t\t\t<input id=\"path_fileInput\" name=\"path_fileInput\" type=\"file\" />\t\t\t" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>" + NL + "\t\t\t\t\t\t<td ";
  protected final String TEXT_299 = "colspan=\"";
  protected final String TEXT_300 = "\"";
  protected final String TEXT_301 = ">" + NL + "\t\t\t\t\t\t\t<div class=\"v-image-wrap\">" + NL + "\t\t\t\t\t\t\t\t<div class='v-title'>";
  protected final String TEXT_302 = "可选多个图片(建议图片大小600px*350px)：";
  protected final String TEXT_303 = "</div>" + NL + "\t\t\t\t\t\t\t\t<div id=\"path_fileInput_queue\" class=\"v-image-queue\">" + NL + "\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t</div>" + NL + "\t\t\t\t\t\t\t</div>" + NL + "\t\t\t\t\t\t</td>" + NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_304 = NL + "\t\t\t\t\t<tr>" + NL + "\t\t\t\t       <td class=\"label\">" + NL + "\t\t\t\t       \t\t<label>";
  protected final String TEXT_305 = ":</label>" + NL + "\t\t\t\t       </td>" + NL + "\t\t\t\t       <td class=\"field\" ";
  protected final String TEXT_306 = "colspan=\"";
  protected final String TEXT_307 = "\"";
  protected final String TEXT_308 = ">" + NL + "\t\t\t\t\t   \t\t<input type=\"file\" id=\"";
  protected final String TEXT_309 = "\" name=\"";
  protected final String TEXT_310 = "\" size=\"35\" onchange=\"goolov.validete.file(this);\"/>" + NL + "\t\t\t\t   \t   </td>" + NL + "\t\t\t\t   \t</tr>";
  protected final String TEXT_311 = NL + "\t\t\t\t\t<tr>" + NL + "\t\t\t\t\t  <td colspan=\"";
  protected final String TEXT_312 = "\">" + NL + "\t\t\t\t\t  \t<div class=\"v-section-wrap\">" + NL + "\t\t\t\t\t  \t\t<div class=\"v-title\">";
  protected final String TEXT_313 = ":</div>" + NL + "\t\t\t\t\t  \t\t<div class=\"v-content\">" + NL + "\t\t\t\t\t  \t\t\t<input type=\"hidden\" id=\"";
  protected final String TEXT_314 = "\" name=\"";
  protected final String TEXT_315 = "\"/>" + NL + "\t\t\t\t\t  \t\t\t<textarea style=\"width:98%;\"  id=\"fck_";
  protected final String TEXT_316 = "\">" + NL + "\t\t\t\t\t      \t\t  ${mo.";
  protected final String TEXT_317 = "}" + NL + "\t\t\t\t\t   \t\t\t</textarea>" + NL + "\t\t\t\t\t\t\t  \t<script type=\"text/javascript\">" + NL + "\t\t\t\t\t\t             var oFCKeditor = new FCKeditor('fck_";
  protected final String TEXT_318 = "') ; " + NL + "\t\t\t\t\t                 oFCKeditor.BasePath\t= '${ctx}/resources/fckeditor/' ;" + NL + "\t\t\t\t\t                 oFCKeditor.Config[\"CustomConfigurationsPath\"]=\"${ctx}/resources/fckeditor/customConfig.js\";" + NL + "\t\t\t\t\t\t             oFCKeditor.ToolbarSet='goolovEdit';" + NL + "\t\t\t\t\t\t             oFCKeditor.Config[\"TabSpaces\"]=2;" + NL + "\t\t\t\t\t\t             oFCKeditor.Config[\"LinkUpload\"] = false;" + NL + "\t\t\t\t\t\t             oFCKeditor.Config[\"ImageUpload\"] = true;" + NL + "\t\t\t\t\t\t             oFCKeditor.Config[\"FlashUpload\"] = false;" + NL + "\t\t\t\t\t\t             oFCKeditor.Height\t= 350;" + NL + "\t\t\t\t\t                 oFCKeditor.ReplaceTextarea(); " + NL + "\t\t\t\t\t            </script>" + NL + "\t\t\t\t\t          </div>" + NL + "\t\t\t\t\t  \t </div>" + NL + "\t\t\t\t\t  </td>" + NL + "\t\t\t\t   </tr>\t      ";
  protected final String TEXT_319 = NL + "\t\t\t\t</table>" + NL + "\t\t\t  </form>";
  protected final String TEXT_320 = NL + "\t\t\t</div><!-- tab one end -->";
  protected final String TEXT_321 = NL + "\t  \t\t<div title=\"";
  protected final String TEXT_322 = "\"><!--";
  protected final String TEXT_323 = " tab start-->" + NL + "\t\t  \t\t<div class=\"v-fckeditor\">" + NL + "\t\t  \t\t\t<input type=\"hidden\" id=\"";
  protected final String TEXT_324 = "\" name=\"";
  protected final String TEXT_325 = "\"/>" + NL + "\t\t  \t\t\t<textarea style=\"width: 90%;\"  id=\"fck_";
  protected final String TEXT_326 = "\">" + NL + "\t\t      \t\t  ${mo.";
  protected final String TEXT_327 = "}" + NL + "\t\t   \t\t\t</textarea>" + NL + "\t\t\t\t  \t<script type=\"text/javascript\">" + NL + "\t\t\t             var oFCKeditor = new FCKeditor('fck_";
  protected final String TEXT_328 = "') ; " + NL + "\t\t                 oFCKeditor.BasePath\t= '${ctx}/resources/fckeditor/' ;" + NL + "\t\t                 oFCKeditor.Config[\"CustomConfigurationsPath\"]=\"${ctx}/resources/fckeditor/customConfig.js\";" + NL + "\t\t\t             oFCKeditor.ToolbarSet='goolovEditTab';" + NL + "\t\t\t             oFCKeditor.Config[\"TabSpaces\"]=2;" + NL + "\t\t\t             oFCKeditor.Config[\"LinkUpload\"] = false;" + NL + "\t\t\t             oFCKeditor.Config[\"ImageUpload\"] = true;" + NL + "\t\t\t             oFCKeditor.Config[\"FlashUpload\"] = false;" + NL + "\t\t\t             oFCKeditor.Height\t= ";
  protected final String TEXT_329 = "-130;" + NL + "\t\t                 oFCKeditor.ReplaceTextarea(); " + NL + "\t\t            </script>" + NL + "\t\t          </div>" + NL + "\t\t\t</div><!--";
  protected final String TEXT_330 = " tab end-->";
  protected final String TEXT_331 = "\t\t\t";
  protected final String TEXT_332 = NL + "\t\t\t<div title=\"";
  protected final String TEXT_333 = "\"  class=\"v-tab\"><!--";
  protected final String TEXT_334 = " tab start-->" + NL + "\t\t\t\t<div class=\"v-section-wrap\">" + NL + "\t\t\t\t\t<div class='v-title'>选择";
  protected final String TEXT_335 = "：</div>" + NL + "\t\t\t\t\t<div class=\"v-content\">" + NL + "\t\t\t\t\t\t${";
  protected final String TEXT_336 = "}" + NL + "\t\t\t\t\t</div>" + NL + "\t\t\t\t</div>" + NL + "\t\t\t</div><!--";
  protected final String TEXT_337 = " tab end-->";
  protected final String TEXT_338 = NL + "\t\t\t<div title=\"";
  protected final String TEXT_339 = "\"   class=\"v-tab\"><!--";
  protected final String TEXT_340 = " tab start-->" + NL + "\t\t\t\t\t<div class=\"v-tree-wrap\">" + NL + "\t\t\t\t\t\t<div class=\"v-title\">选择";
  protected final String TEXT_341 = "：</div>" + NL + "\t\t\t\t\t\t<div class=\"v-content\" id=\"";
  protected final String TEXT_342 = "\" style=\"height:270px; width:350px; overflow: auto;\">" + NL + "\t\t\t\t\t\t</div>" + NL + "\t\t\t\t\t</div>" + NL + "\t\t\t</div><!--";
  protected final String TEXT_343 = " tab end-->";
  protected final String TEXT_344 = "\t\t\t\t\t\t" + NL + "\t\t  </div><!-- firstTabs end -->";
  protected final String TEXT_345 = NL + "\t\t</div><!-- center end -->" + NL + "\t\t<div region=\"south\" border=\"false\" style=\"height:50px;\"><!-- south start-->" + NL + "\t\t   \t<div class=\"v-buttons\">" + NL + "\t   \t\t\t<a href=\"javascript:uploadImage();\" class=\"easyui-linkbutton\">上传图片</a>" + NL + "\t   \t\t\t<a href=\"javascript:uploadClearQueue();\" class=\"easyui-linkbutton\">清除队列</a>" + NL + "\t   \t\t\t<a href=\"javascript:resetData();\" class=\"easyui-linkbutton\" >重置</a>" + NL + "\t   \t\t\t<a href=\"javascript:newWinClose();\" class=\"easyui-linkbutton\" >关闭</a>" + NL + "\t\t\t</div><!-- v-buttons end-->" + NL + "\t</div><!--\tsouth end -->" + NL + "</body>" + NL + "</html>";

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
//model input js Path
String modelInputJsPath=clazzWrap.getWebPath(NameRuledWebPathKind.js_input);
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
    if(needFck){
    stringBuffer.append(TEXT_11);
    }
    stringBuffer.append(TEXT_12);
    stringBuffer.append(modelInputJsPath);
    stringBuffer.append(TEXT_13);
    List<Property> tabsList=ViewInputHelper.getTabsProperty(uml2Class);
    if(!tabsList.isEmpty()||!contentTabPropertyList.isEmpty()){
    stringBuffer.append(TEXT_14);
    }
    stringBuffer.append(TEXT_15);
    Property idProperty=EntityHelper.getIDProperty(uml2Class);
    if(EntityHelper.isIDAuto(idProperty)||EntityHelper.isIDUUID(idProperty)){
    	//if(!ViewInputHelper.isViewInput(idProperty)){
    stringBuffer.append(TEXT_16);
    stringBuffer.append(NameHelper.uncapSafeName(idProperty));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(NameHelper.uncapSafeName(idProperty));
    stringBuffer.append(TEXT_18);
    	//}
    }
    stringBuffer.append(TEXT_19);
    
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
    stringBuffer.append(TEXT_20);
    			}
    stringBuffer.append(TEXT_21);
    			if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_22);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_23);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    			}
    stringBuffer.append(TEXT_24);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(NameHelper.uncapSafeName(idProperty));
    stringBuffer.append(TEXT_27);
    			tdCount+=needTd;
    stringBuffer.append(TEXT_28);
    			if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_29);
    			}
    stringBuffer.append(TEXT_30);
    		}
    	}else if(EntityHelper.isIDAssign(idProperty)){
 		String propertyCommentName=TypeHelper.getDocumentationOrName(idProperty);
 		String propertyUncapSafeName=NameHelper.uncapSafeName(idProperty);
 		String propertyStyleClass=ViewInputHelper.getStyleClass(idProperty);

    			if(tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_31);
    			}
    stringBuffer.append(TEXT_32);
    				needTd=2>trIncludeTd?trIncludeTd:2;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_33);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_34);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    stringBuffer.append(TEXT_35);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(propertyStyleClass);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(propertyStyleClass);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_46);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_47);
    				}
    stringBuffer.append(TEXT_48);
    	}
    
	/*****************************************************************
	 * property simple input start
	/*****************************************************************/
	List<Property> simpleInputProperty=ViewInputHelper.getFileSimpleInputProperty(uml2Class);
	for(Iterator<Property> iter=simpleInputProperty.iterator();iter.hasNext();){
			Property property=iter.next();
			String propertyCommentName=TypeHelper.getDocumentationOrName(property);
 			String propertyUncapSafeName=NameHelper.uncapSafeName(property);
 			String propertyStyleClass=ViewInputHelper.getStyleClass(property);
 			//filter file attribute property
 			

    			if(tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_49);
    			}
    stringBuffer.append(TEXT_50);
    	/********process parentId Property start********/
    			if (TreeStereotypeHelper.isParentIdProperty(property)) {// text
    				needTd=2>trIncludeTd?trIncludeTd:2;
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
    if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_58);
    }
    stringBuffer.append(TEXT_59);
    if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_60);
    }
    stringBuffer.append(TEXT_61);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_62);
    				}
    stringBuffer.append(TEXT_63);
    				continue;
    			}
    	/********process parentId Property end********/
    	/********process text********/
    			if (ViewInputHelper.isViewInputText(property)) {// text
    				needTd=2>trIncludeTd?trIncludeTd:2;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_64);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_65);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    stringBuffer.append(TEXT_66);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_68);
    				if(	ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_69);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_70);
    				}else{
    stringBuffer.append(TEXT_71);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(propertyStyleClass);
    stringBuffer.append(TEXT_75);
    				}
    stringBuffer.append(TEXT_76);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_77);
    				}
    stringBuffer.append(TEXT_78);
    				continue;
    			}
    	/********process title********/
    			if (ViewInputHelper.isViewInputTitle(property)) {// title
    				needTd=4>trIncludeTd?trIncludeTd:4;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_79);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_80);
    					tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    stringBuffer.append(TEXT_81);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_83);
    if(						ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_84);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_85);
    							}else{
    stringBuffer.append(TEXT_86);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(propertyStyleClass);
    stringBuffer.append(TEXT_90);
    if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_91);
    }
    stringBuffer.append(TEXT_92);
    							}
    stringBuffer.append(TEXT_93);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_94);
    				}
    stringBuffer.append(TEXT_95);
    				continue;
    			}
    	/********process select********/
    			if (ViewInputHelper.isViewInputSelect(property)) {// select
    				needTd=2>trIncludeTd?trIncludeTd:2;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_96);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_97);
    					tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    stringBuffer.append(TEXT_98);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_99);
    				Enumeration enumeration=EnumKindHelper.getAppliedEnumKindEnumeration(property);
    				if(null!=enumeration){
    					//String modelEnumQualifiedName=MdaHelper.getModelQualifiedName(enumeration,PKGSuffix.enumeration,ModelNameSuffix.enumeration);
    					//String modelEnumName=MdaHelper.getModelClassName(enumeration,ModelNameSuffix.enumeration);
    					String modelEnumSelectHtml=NamedUtil.getPropertyNamed(enumeration,PropertyNamedRuleKind.selectHtml);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(propertyStyleClass);
    stringBuffer.append(TEXT_104);
    if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_105);
    }
    stringBuffer.append(TEXT_106);
    if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_107);
    }
    stringBuffer.append(TEXT_108);
    stringBuffer.append(modelEnumSelectHtml);
    stringBuffer.append(TEXT_109);
    				}else{
    stringBuffer.append(TEXT_110);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_111);
    if(						ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_112);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_113);
    							}else{
    stringBuffer.append(TEXT_114);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(propertyStyleClass);
    stringBuffer.append(TEXT_118);
    if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_119);
    }
    stringBuffer.append(TEXT_120);
    							}
    stringBuffer.append(TEXT_121);
    				}
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_122);
    				}
    stringBuffer.append(TEXT_123);
    				continue;
    			}
    stringBuffer.append(TEXT_124);
    	/********process radio********/
    stringBuffer.append(TEXT_125);
    			if (ViewInputHelper.isViewInputRadio(property)) {// radio
    				needTd=4>trIncludeTd?trIncludeTd:4;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_126);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_127);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    stringBuffer.append(TEXT_128);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_129);
    				Enumeration enumeration=EnumKindHelper.getAppliedEnumKindEnumeration(property);
    				if(null!=enumeration){
    						String propertyRadioGroup=NamedUtil.getPropertyNamed(enumeration,PropertyNamedRuleKind.inputRadioGroup);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(propertyRadioGroup);
    stringBuffer.append(TEXT_132);
    				}else{
    stringBuffer.append(TEXT_133);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_134);
    				if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_135);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_136);
    							}else{
    stringBuffer.append(TEXT_137);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(propertyStyleClass);
    stringBuffer.append(TEXT_141);
    if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_142);
    }
    stringBuffer.append(TEXT_143);
    							}
    stringBuffer.append(TEXT_144);
    				}
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_145);
    				}
    stringBuffer.append(TEXT_146);
    				continue;
    			}
    	/********process datePicker********/
    			if (ViewInputHelper.isViewInputDatePicker(property)) {// datePicker
    				//String propertyToDateTimeCapName=PropertyNamedRuleKind.dateToDateTimeStr.getRuleCapNamed(property);
    				String propertyToDateTimeUncapName=PropertyNamedRuleKind.dateToDateTimeStr.getRuleUnCapNamed(property);
    				needTd=2>trIncludeTd?trIncludeTd:2;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_147);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_148);
    					tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    stringBuffer.append(TEXT_149);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_151);
    if(						ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_152);
    stringBuffer.append(propertyToDateTimeUncapName);
    stringBuffer.append(TEXT_153);
    							}else{
    stringBuffer.append(TEXT_154);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(propertyStyleClass);
    stringBuffer.append(TEXT_158);
    if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_159);
    }
    stringBuffer.append(TEXT_160);
    							}
    stringBuffer.append(TEXT_161);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_162);
    				}
    stringBuffer.append(TEXT_163);
    				continue;
    				}
    	/********process texttarea********/
    			if (ViewInputHelper.isViewInputTextarea(property)) {// texttarea 
    				needTd=4>trIncludeTd?trIncludeTd:4;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_164);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_165);
    					tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    stringBuffer.append(TEXT_166);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_168);
    if(						ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_169);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_170);
    							}else{
    stringBuffer.append(TEXT_171);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(propertyStyleClass);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_175);
    							}
    stringBuffer.append(TEXT_176);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_177);
    				}
    stringBuffer.append(TEXT_178);
    				continue;
    			}	
    stringBuffer.append(TEXT_179);
    	/********process checkbox********/
    			if (ViewInputHelper.isViewInputCheckbox(property)) {// checkbox
    				needTd=4>trIncludeTd?trIncludeTd:4;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_180);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_181);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    stringBuffer.append(TEXT_182);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_184);
    if(						ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_185);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_186);
    							}else{
    stringBuffer.append(TEXT_187);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(propertyStyleClass);
    stringBuffer.append(TEXT_191);
    							}
    stringBuffer.append(TEXT_192);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_193);
    				}
    stringBuffer.append(TEXT_194);
    				continue;
    			}
    stringBuffer.append(TEXT_195);
    	/********process file********/
    stringBuffer.append(TEXT_196);
    //			if (isViewInputFile(property)) {// file
    //			}		
    	/********process image********/
    stringBuffer.append(TEXT_197);
    //			if (isViewInputImage(property)) {// image
    //			}			
    	/********process content********/
    stringBuffer.append(TEXT_198);
    //			if (isViewInputContent(property)) {// content
    //			}
    
/*****************************************************************
 * process rel 
/*****************************************************************/

    /********process M2OSelect********/
    stringBuffer.append(TEXT_199);
    			if (ViewInputHelper.isApplyM2OSelect(property)) {//M2OSelect
    				Class propertyType = (Class) property.getType();
    				String propertyTypeComment = TypeHelper.getDocumentationOrName(propertyType);
     				Property propertyTypeIdProperty=EntityHelper.getIDProperty(propertyType);
     				String propertyTypeIdPropertyUncapSafeName=NameHelper.uncapSafeName(propertyTypeIdProperty);
    				needTd=2>trIncludeTd?trIncludeTd:2;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_200);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_201);
    					tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    				String m2oSelectHtml=NamedUtil.getPropertyNamed(property,PropertyNamedRuleKind.selectHtml);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(propertyTypeComment);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_208);
    if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_209);
    }
    stringBuffer.append(TEXT_210);
    stringBuffer.append(m2oSelectHtml);
    stringBuffer.append(TEXT_211);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_212);
    				}
    stringBuffer.append(TEXT_213);
    				continue;
    			}	
    stringBuffer.append(TEXT_214);
    	/********process M2OSelectPage********/
    			if (ViewInputHelper.isApplyM2OSelectPage(property)) {//M2OSelectPage
    				Class propertyType = (Class) property.getType();
    				String propertyTypeComment = TypeHelper.getDocumentationOrName(propertyType);
     				Property propertyTypeIdProperty=EntityHelper.getIDProperty(propertyType);
     				String propertyTypeIdPropertyUncapSafeName=NameHelper.uncapSafeName(propertyTypeIdProperty);
    				needTd=2>trIncludeTd?trIncludeTd:2;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_215);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_216);
    					tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    stringBuffer.append(TEXT_217);
    stringBuffer.append(propertyTypeComment);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_219);
    							if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_220);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_222);
    							}else{
    stringBuffer.append(TEXT_223);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(propertyStyleClass);
    stringBuffer.append(TEXT_230);
    if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_231);
    }
    stringBuffer.append(TEXT_232);
    							}
    stringBuffer.append(TEXT_233);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_234);
    				}
    stringBuffer.append(TEXT_235);
    				continue;
    			}
    stringBuffer.append(TEXT_236);
    	/********process O2OSelect********/
    			if (ViewInputHelper.isApplyO2OSelect(property)) {//O2OSelect
    stringBuffer.append(TEXT_237);
    				Class propertyType = (Class) property.getType();
    				String propertyTypeComment = TypeHelper.getDocumentationOrName(propertyType);
     				Property propertyTypeIdProperty=EntityHelper.getIDProperty(propertyType);
     				String propertyTypeIdPropertyUncapSafeName=NameHelper.uncapSafeName(propertyTypeIdProperty);
    				needTd=2>trIncludeTd?trIncludeTd:2;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_238);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_239);
    					tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    				String O2OSelectHtml=NamedUtil.getPropertyNamed(property,PropertyNamedRuleKind.selectHtml);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(propertyTypeComment);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_246);
    if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_247);
    }
    stringBuffer.append(TEXT_248);
    stringBuffer.append(O2OSelectHtml);
    stringBuffer.append(TEXT_249);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_250);
    				}
    stringBuffer.append(TEXT_251);
    				continue;
    			}	
    stringBuffer.append(TEXT_252);
    	/********process O2OSelectPage********/
    			if (ViewInputHelper.isApplyO2OSelectPage(property)) {//O2OSelectPage
    				Class propertyType = (Class) property.getType();
    				String propertyTypeComment = TypeHelper.getDocumentationOrName(propertyType);
     				Property propertyTypeIdProperty=EntityHelper.getIDProperty(propertyType);
     				String propertyTypeIdPropertyUncapSafeName=NameHelper.uncapSafeName(propertyTypeIdProperty);
    				needTd=2>trIncludeTd?trIncludeTd:2;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_253);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_254);
    					tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    stringBuffer.append(TEXT_255);
    stringBuffer.append(propertyTypeComment);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_257);
    							if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_258);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_260);
    							}else{
    stringBuffer.append(TEXT_261);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(propertyStyleClass);
    stringBuffer.append(TEXT_268);
    if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_269);
    }
    stringBuffer.append(TEXT_270);
    							}
    stringBuffer.append(TEXT_271);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_272);
    				}
    stringBuffer.append(TEXT_273);
    				continue;
    			}
    stringBuffer.append(TEXT_274);
    	}
    	if (tdCount%trIncludeTd!=0){
    stringBuffer.append(TEXT_275);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_276);
    	}
    
	/*****************************************************************
	 * property simple input end
	/*****************************************************************/

    stringBuffer.append(TEXT_277);
    
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
 * process rel M2MCheckboxs properties
/*****************************************************************/

    if(null!=M2MCheckboxsList&&M2MCheckboxsList.size()>0){
    	for(Property property:M2MCheckboxsList){
     			String propertyCommentName=TypeHelper.getDocumentationOrName(property);
     			//String propertyUncapSafeName=NameHelper.uncapSafeName(property);
     			//String propertyStyleClass=ViewInputHelper.getStyleClass(property);
    			Type propertyType=property.getType();
    			Class relTargetClass=(Class)propertyType;
    			String relPropertyCheckboxs=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relCheckboxs);
    stringBuffer.append(TEXT_278);
    stringBuffer.append(trIncludeTd);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(relPropertyCheckboxs);
    stringBuffer.append(TEXT_281);
    		}
    }
    
/*****************************************************************
 * process M2MCheckboxsTree properties
/*****************************************************************/

    if(null!=M2MCheckboxsTreeList&&M2MCheckboxsTreeList.size()>0){
    	for(Property property:M2MCheckboxsTreeList){
     			String propertyCommentName=TypeHelper.getDocumentationOrName(property);
     			//String propertyUncapSafeName=NameHelper.uncapSafeName(property);
     			//String propertyStyleClass=ViewInputHelper.getStyleClass(property);
    			Type propertyType=property.getType();
    			Class relTargetClass=(Class)propertyType;
    			String relPropertyCheckTreeDomId=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relCheckTreeDomId);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(trIncludeTd);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_284);
    stringBuffer.append(relPropertyCheckTreeDomId);
    stringBuffer.append(TEXT_285);
    		}
    }
    
/*****************************************************************
 * process image file properties
/*****************************************************************/

    /*List<Property> imagePropertyList=ViewInputHelper.getViewInputImage(uml2Class);
    if(null!=imagePropertyList&&imagePropertyList.size()>0){
    	for(Property property:imagePropertyList){
     			String propertyCommentName=TypeHelper.getDocumentationOrName(property);
     			String propertyUncapSafeName=NameHelper.uncapSafeName(property);
     			//String propertyStyleClass=ViewInputHelper.getStyleClass(property);
    stringBuffer.append(TEXT_286);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_287);
    if(trIncludeTd-1>1){
    stringBuffer.append(TEXT_288);
    stringBuffer.append(trIncludeTd-1);
    stringBuffer.append(TEXT_289);
    }
    stringBuffer.append(TEXT_290);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_291);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_292);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_293);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_294);
    		}
    }*/
    
/*****************************************************************
 * process image  uploadify
/*****************************************************************/

    /*List<Property> imagePropertyList=ViewInputHelper.getViewInputImage(uml2Class);
    if(null!=imagePropertyList&&imagePropertyList.size()>0){
    	for(Property property:imagePropertyList){
     			String propertyCommentName=TypeHelper.getDocumentationOrName(property);
    stringBuffer.append(TEXT_295);
    if(trIncludeTd-1>1){
    stringBuffer.append(TEXT_296);
    stringBuffer.append(trIncludeTd-1);
    stringBuffer.append(TEXT_297);
    }
    stringBuffer.append(TEXT_298);
    if(trIncludeTd>1){
    stringBuffer.append(TEXT_299);
    stringBuffer.append(trIncludeTd);
    stringBuffer.append(TEXT_300);
    }
    stringBuffer.append(TEXT_301);
    if(FileStereotypeHelper.isApplyModelFile(uml2Class)){
    stringBuffer.append(TEXT_302);
    }
    stringBuffer.append(TEXT_303);
    		}
    }*/
    
/*****************************************************************
 * process file properties
/*****************************************************************/

    /*List<Property> filePropertyList=ViewInputHelper.getViewInputFile(uml2Class);
    if(null!=filePropertyList&&filePropertyList.size()>0){
    	for(Property property:filePropertyList){
     			String propertyCommentName=TypeHelper.getDocumentationOrName(property);
     			String propertyUncapSafeName=NameHelper.uncapSafeName(property);
     			//String propertyStyleClass=ViewInputHelper.getStyleClass(property);
    stringBuffer.append(TEXT_304);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_305);
    if(trIncludeTd-1>1){
    stringBuffer.append(TEXT_306);
    stringBuffer.append(trIncludeTd-1);
    stringBuffer.append(TEXT_307);
    }
    stringBuffer.append(TEXT_308);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_310);
    	}
    }*/
    
/*****************************************************************
 * process content properties
/*****************************************************************/

    if(null!=contentPropertyList&&contentPropertyList.size()>0){
    for(Property property:contentPropertyList){
     			String propertyCommentName=TypeHelper.getDocumentationOrName(property);
     			String propertyUncapSafeName=NameHelper.uncapSafeName(property);
     			//String propertyStyleClass=ViewInputHelper.getStyleClass(property);
    stringBuffer.append(TEXT_311);
    stringBuffer.append(trIncludeTd);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_313);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_314);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_315);
    stringBuffer.append(NameHelper.getUncapName(property));
    stringBuffer.append(TEXT_316);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_317);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_318);
    }}
    stringBuffer.append(TEXT_319);
    if(!tabsList.isEmpty()||!contentTabPropertyList.isEmpty()){
    stringBuffer.append(TEXT_320);
    	for(Iterator<Property> iter=contentTabPropertyList.iterator();iter.hasNext();){
    			Property property=iter.next();
     			String propertyCommentName=TypeHelper.getDocumentationOrName(property);
     			String propertyUncapSafeName=NameHelper.uncapSafeName(property);
     			//String propertyStyleClass=ViewInputHelper.getStyleClass(property);
    			String propertyCapConmentName=TypeHelper.getDocumentationOrName(property);
    stringBuffer.append(TEXT_321);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_322);
    stringBuffer.append(propertyCapConmentName);
    stringBuffer.append(TEXT_323);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_324);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_325);
    stringBuffer.append(NameHelper.getUncapName(property));
    stringBuffer.append(TEXT_326);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_327);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_328);
    stringBuffer.append(PageHelper.getWinHeight(uml2Class));
    stringBuffer.append(TEXT_329);
    stringBuffer.append(propertyCapConmentName);
    stringBuffer.append(TEXT_330);
    	}
    stringBuffer.append(TEXT_331);
    	for(Iterator<Property> iter=tabsList.iterator();iter.hasNext();){
    		Property property=iter.next();
    		//String propertyCapName=NameHelper.getCapName(property);
    		String propertyCapConmentName=TypeHelper.getDocumentationOrName(property);
    		//String propertyName=NameHelper.uncapSafeName(property);
    		Type propertyType=property.getType();
    		Class relTargetClass=(Class)propertyType;
    		if(ModelStereoTypeHelper.isApplyModel_M2M(propertyType)||ModelStereoTypeHelper.isApplyModel_M2mWithId(propertyType)){
    			Class relUml2Class=(Class)propertyType;
    			relTargetClass=ModelHelper.getRelTargetClass(relUml2Class,uml2Class);
    		}
    		String relTargetClassCommentName=TypeHelper.getDocumentationOrName(relTargetClass);
    		String relPropertyCheckboxs=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relCheckboxs);
    		if (ViewInputHelper.isApplyM2MCheckboxsTab(property)) {//M2OSelect
    stringBuffer.append(TEXT_332);
    stringBuffer.append(propertyCapConmentName);
    stringBuffer.append(TEXT_333);
    stringBuffer.append(propertyCapConmentName);
    stringBuffer.append(TEXT_334);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_335);
    stringBuffer.append(relPropertyCheckboxs);
    stringBuffer.append(TEXT_336);
    stringBuffer.append(propertyCapConmentName);
    stringBuffer.append(TEXT_337);
    		}
    		if (ViewInputHelper.isApplyM2MCheckboxsTreeTab(property)) {//M2OSelectPage
    			String relPropertyShowCheckTreeJson=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relShowCheckTreeJson);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(propertyCapConmentName);
    stringBuffer.append(TEXT_339);
    stringBuffer.append(propertyCapConmentName);
    stringBuffer.append(TEXT_340);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_341);
    stringBuffer.append(relPropertyShowCheckTreeJson);
    stringBuffer.append(TEXT_342);
    stringBuffer.append(propertyCapConmentName);
    stringBuffer.append(TEXT_343);
    		}
    	}
    stringBuffer.append(TEXT_344);
    }
    stringBuffer.append(TEXT_345);
    return stringBuffer.toString();
  }
}
