package com.jeefuse.mda.gen.template.main.java.jsp;

import net.taylor.mda.generator.parse.NameRuled.nameRuled.*;
import net.taylor.mda.generator.parse.NameRuled.*;
import net.taylor.mda.generator.parse.stereotype.*;
import net.taylor.mda.generator.parse.page.*;
import java.util.List;
import java.util.ArrayList;
import net.taylor.mda.generator.parse.*;
import net.taylor.mda.generator.parse.entity.*;
import java.util.Iterator;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.*;
import net.taylor.mda.generator.util.*;
import org.eclipse.emf.codegen.util.*;

public class EntityInputJsPProxy
{
  protected static String nl;
  public static synchronized EntityInputJsPProxy create(String lineSeparator)
  {
    nl = lineSeparator;
    EntityInputJsPProxy result = new EntityInputJsPProxy();
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
  protected final String TEXT_10 = "\" type=\"text/javascript\"></script>" + NL + "<script>" + NL + "\tvar ctx = '${ctx}';" + NL + "\tvar theme = '${theme}';" + NL + "\timportCssFile('sys|ui', ctx, theme);" + NL + "\timportJsFile('jquery|ui|common|blockUI|form|validate";
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
  protected final String TEXT_196 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_197 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_198 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_199 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t\t\t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_200 = "\">" + NL + "\t\t\t\t\t\t\t <select  id=\"";
  protected final String TEXT_201 = "_";
  protected final String TEXT_202 = "\" name=\"";
  protected final String TEXT_203 = ".";
  protected final String TEXT_204 = "\" ";
  protected final String TEXT_205 = "readonly=\"readonly\"";
  protected final String TEXT_206 = ">" + NL + "\t\t\t\t\t\t\t     <s:property value=\"";
  protected final String TEXT_207 = "\" escape=\"false\"/>" + NL + "\t\t\t\t\t\t\t </select>" + NL + "\t\t\t\t\t\t</td>";
  protected final String TEXT_208 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_209 = "\t\t\t\t\t\t";
  protected final String TEXT_210 = "\t";
  protected final String TEXT_211 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_212 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_213 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_214 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t\t\t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_215 = "\">";
  protected final String TEXT_216 = NL + "\t\t      \t\t\t\t\t${mo.";
  protected final String TEXT_217 = ".";
  protected final String TEXT_218 = "}";
  protected final String TEXT_219 = NL + "\t\t\t\t\t\t\t <input type=\"text\" id=\"";
  protected final String TEXT_220 = "_";
  protected final String TEXT_221 = "\" name=\"";
  protected final String TEXT_222 = ".";
  protected final String TEXT_223 = "\" value=\"${mo.";
  protected final String TEXT_224 = ".";
  protected final String TEXT_225 = "}\" class=\"";
  protected final String TEXT_226 = "\" ";
  protected final String TEXT_227 = "readonly=\"readonly\"";
  protected final String TEXT_228 = "/>";
  protected final String TEXT_229 = "\t\t" + NL + "\t\t\t\t\t\t</td>";
  protected final String TEXT_230 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_231 = "\t\t\t\t\t\t";
  protected final String TEXT_232 = "\t";
  protected final String TEXT_233 = "\t";
  protected final String TEXT_234 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_235 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_236 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_237 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t\t\t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_238 = "\">" + NL + "\t\t\t\t\t\t\t <select  id=\"";
  protected final String TEXT_239 = "_";
  protected final String TEXT_240 = "\" name=\"";
  protected final String TEXT_241 = ".";
  protected final String TEXT_242 = "\" ";
  protected final String TEXT_243 = "readonly=\"readonly\"";
  protected final String TEXT_244 = ">" + NL + "\t\t\t\t\t\t\t     <s:property value=\"";
  protected final String TEXT_245 = "\" escape=\"false\"/>" + NL + "\t\t\t\t\t\t\t </select>" + NL + "\t\t\t\t\t\t</td>";
  protected final String TEXT_246 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_247 = "\t\t\t\t\t\t";
  protected final String TEXT_248 = "\t";
  protected final String TEXT_249 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_250 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_251 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_252 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t\t\t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_253 = "\">";
  protected final String TEXT_254 = NL + "\t\t      \t\t\t\t\t${mo.";
  protected final String TEXT_255 = ".";
  protected final String TEXT_256 = "}";
  protected final String TEXT_257 = NL + "\t\t\t\t\t\t\t <input type=\"text\" id=\"";
  protected final String TEXT_258 = "_";
  protected final String TEXT_259 = "\" name=\"";
  protected final String TEXT_260 = ".";
  protected final String TEXT_261 = "\" value=\"${mo.";
  protected final String TEXT_262 = ".";
  protected final String TEXT_263 = "}\" class=\"";
  protected final String TEXT_264 = "\" ";
  protected final String TEXT_265 = "readonly=\"readonly\"";
  protected final String TEXT_266 = "/>";
  protected final String TEXT_267 = "\t" + NL + "\t\t\t\t\t\t</td>";
  protected final String TEXT_268 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_269 = "\t\t\t\t\t\t";
  protected final String TEXT_270 = "\t";
  protected final String TEXT_271 = "\t" + NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_272 = "\"></td>" + NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_273 = "\t";
  protected final String TEXT_274 = NL + "\t\t\t\t\t<tr>" + NL + "\t\t      \t\t\t<td colspan=\"";
  protected final String TEXT_275 = "\">" + NL + "\t\t      \t\t\t\t<div class=\"v-fieldset-wrap\">" + NL + "\t\t\t      \t\t\t\t<fieldset>" + NL + "\t\t\t\t\t              <legend>" + NL + "\t\t\t\t\t                 \t";
  protected final String TEXT_276 = ":" + NL + "\t\t\t\t\t              </legend>" + NL + "\t\t\t\t\t              <div class=\"v-fieldset-content\">" + NL + "\t\t\t\t\t                \t${";
  protected final String TEXT_277 = "}" + NL + "\t\t\t\t\t\t\t      </div>" + NL + "\t\t\t\t\t            </fieldset>" + NL + "\t\t      \t\t\t\t</div>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t</tr>";
  protected final String TEXT_278 = NL + "\t\t\t\t\t<tr>" + NL + "\t\t      \t\t\t<td colspan=\"";
  protected final String TEXT_279 = "\">" + NL + "\t\t      \t\t\t\t<div class=\"v-tree-wrap\">" + NL + "\t\t\t\t\t\t\t\t<div class=\"v-title\">";
  protected final String TEXT_280 = "：</div>" + NL + "\t\t\t\t\t\t\t\t<div class=\"v-content\" id=\"";
  protected final String TEXT_281 = "\" style=\"height:270px; width:350px; overflow: auto;\">" + NL + "\t\t\t\t\t\t\t\t</div>" + NL + "\t\t\t\t\t\t\t</div>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t</tr>";
  protected final String TEXT_282 = NL + "\t\t\t\t\t<tr>" + NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_283 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" ";
  protected final String TEXT_284 = "colspan=\"";
  protected final String TEXT_285 = "\"";
  protected final String TEXT_286 = ">" + NL + "\t\t\t \t         \t <input type=\"file\" id=\"path_fileInput\" name=\"uploadImage_";
  protected final String TEXT_287 = "\" size=\"35\"/><br/>" + NL + "\t\t\t \t         \t <tr>\t" + NL + "\t\t\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t\t\t      \t\t\t\t<label>上传图片:</label>" + NL + "\t\t\t\t      \t\t\t</td>" + NL + "\t\t\t\t      \t\t\t<td class=\"field\" colspan=\"3\">" + NL + "\t\t\t\t      \t\t\t\t<input id=\"path_fileInput\" name=\"path_fileInput\" type=\"file\" />\t\t\t" + NL + "\t\t\t\t      \t\t\t</td>" + NL + "\t\t\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t\t\t<tr>" + NL + "\t\t\t\t\t\t\t\t<td colspan=\"4\">" + NL + "\t\t\t\t\t\t\t\t\t<div class=\"v-image-wrap\">" + NL + "\t\t\t\t\t\t\t\t\t\t<div class='v-title'>可选多个图片(建议图片大小600px*350px)：</div>" + NL + "\t\t\t\t\t\t\t\t\t\t<div id=\"path_fileInput_queue\" class=\"v-image-queue\">" + NL + "\t\t\t\t\t\t\t\t\t\t\t&nbsp;" + NL + "\t\t\t\t\t\t\t\t\t\t</div>" + NL + "\t\t\t\t\t\t\t\t\t</div>" + NL + "\t\t\t\t\t\t\t\t</td>" + NL + "\t\t\t\t\t\t\t</tr>\t" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t</tr>";
  protected final String TEXT_288 = NL + "\t\t\t\t\t<tr>" + NL + "\t\t\t\t       <td class=\"label\">" + NL + "\t\t\t\t       \t\t<label>";
  protected final String TEXT_289 = ":</label>" + NL + "\t\t\t\t       </td>" + NL + "\t\t\t\t       <td class=\"field\" ";
  protected final String TEXT_290 = "colspan=\"";
  protected final String TEXT_291 = "\"";
  protected final String TEXT_292 = ">" + NL + "\t\t\t\t\t   \t\t<input type=\"file\" id=\"";
  protected final String TEXT_293 = "\" name=\"";
  protected final String TEXT_294 = "\" size=\"35\" onchange=\"goolov.validete.file(this);\"/>" + NL + "\t\t\t\t   \t   </td>" + NL + "\t\t\t\t   \t</tr>";
  protected final String TEXT_295 = NL + "\t\t\t\t\t<tr>" + NL + "\t\t\t\t\t  <td colspan=\"";
  protected final String TEXT_296 = "\">" + NL + "\t\t\t\t\t  \t<div class=\"v-section-wrap\">" + NL + "\t\t\t\t\t  \t\t<div class=\"v-title\">";
  protected final String TEXT_297 = ":</div>" + NL + "\t\t\t\t\t  \t\t<div class=\"v-content\">" + NL + "\t\t\t\t\t  \t\t\t<input type=\"hidden\" id=\"";
  protected final String TEXT_298 = "\" name=\"";
  protected final String TEXT_299 = "\"/>" + NL + "\t\t\t\t\t  \t\t\t<textarea style=\"width:98%;\"  id=\"fck_";
  protected final String TEXT_300 = "\">" + NL + "\t\t\t\t\t      \t\t  ${mo.";
  protected final String TEXT_301 = "}" + NL + "\t\t\t\t\t   \t\t\t</textarea>" + NL + "\t\t\t\t\t\t\t  \t<script type=\"text/javascript\">" + NL + "\t\t\t\t\t\t             var oFCKeditor = new FCKeditor('fck_";
  protected final String TEXT_302 = "') ; " + NL + "\t\t\t\t\t                 oFCKeditor.BasePath\t= '${ctx}/resources/fckeditor/' ;" + NL + "\t\t\t\t\t                 oFCKeditor.Config[\"CustomConfigurationsPath\"]=\"${ctx}/resources/fckeditor/customConfig.js\";" + NL + "\t\t\t\t\t\t             oFCKeditor.ToolbarSet='goolovEdit';" + NL + "\t\t\t\t\t\t             oFCKeditor.Config[\"TabSpaces\"]=2;" + NL + "\t\t\t\t\t\t             oFCKeditor.Config[\"LinkUpload\"] = false;" + NL + "\t\t\t\t\t\t             oFCKeditor.Config[\"ImageUpload\"] = true;" + NL + "\t\t\t\t\t\t             oFCKeditor.Config[\"FlashUpload\"] = false;" + NL + "\t\t\t\t\t\t             oFCKeditor.Height\t= 350;" + NL + "\t\t\t\t\t                 oFCKeditor.ReplaceTextarea(); " + NL + "\t\t\t\t\t            </script>" + NL + "\t\t\t\t\t          </div>" + NL + "\t\t\t\t\t  \t </div>" + NL + "\t\t\t\t\t  </td>" + NL + "\t\t\t\t   </tr>\t      ";
  protected final String TEXT_303 = NL + "\t\t\t\t\t<tr>\t" + NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>保存路径:</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_304 = "colspan=\"";
  protected final String TEXT_305 = "\"";
  protected final String TEXT_306 = "\">" + NL + "\t\t      \t\t\t\t${mo.";
  protected final String TEXT_307 = "}\t\t\t\t\t\t\t" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>" + NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>文件类型:</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"1\">" + NL + "\t\t      \t\t\t\t${mo.";
  protected final String TEXT_308 = "}\t\t\t\t\t\t" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>大小:</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_309 = "colspan=\"";
  protected final String TEXT_310 = "\"";
  protected final String TEXT_311 = "\">" + NL + "\t\t      \t\t\t\t${mo.";
  protected final String TEXT_312 = "}Byte" + NL + "\t\t      \t\t\t</td>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t</tr>\t\t\t\t\t\t";
  protected final String TEXT_313 = NL + "\t\t\t\t\t<tr>\t" + NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>保存路径:</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_314 = "colspan=\"";
  protected final String TEXT_315 = "\"";
  protected final String TEXT_316 = "\">" + NL + "\t\t      \t\t\t\t${mo.";
  protected final String TEXT_317 = "}\t\t\t\t\t\t\t" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>" + NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>文件类型:</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"1\">" + NL + "\t\t      \t\t\t\t${mo.";
  protected final String TEXT_318 = "}\t\t\t\t\t\t" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>大小:</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_319 = "colspan=\"";
  protected final String TEXT_320 = "\"";
  protected final String TEXT_321 = "\">" + NL + "\t\t      \t\t\t\t${mo.";
  protected final String TEXT_322 = "}Byte" + NL + "\t\t      \t\t\t</td>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>\t" + NL + "\t\t      \t\t\t<td colspan=\"";
  protected final String TEXT_323 = "colspan=\"";
  protected final String TEXT_324 = "\"";
  protected final String TEXT_325 = "\">" + NL + "\t\t      \t\t\t\t<div class=\"v-image-wrap\">" + NL + "\t\t\t\t\t\t\t\t<div class='v-title'>图片：</div>" + NL + "\t\t\t\t\t\t\t\t<div class=\"v-image\" style=\"width:85%\">" + NL + "\t\t\t\t\t\t\t\t\t<img src=\"${ctx}/${mo.";
  protected final String TEXT_326 = "}\" alt=\"图片\" />" + NL + "\t\t\t\t\t\t\t\t</div>" + NL + "\t\t\t\t\t\t\t</div>" + NL + "\t\t      \t\t\t</td>\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t</tr>\t\t\t\t\t\t";
  protected final String TEXT_327 = NL + "\t\t\t\t</table>" + NL + "\t\t\t  </form>";
  protected final String TEXT_328 = NL + "\t\t\t</div><!-- tab one end -->";
  protected final String TEXT_329 = NL + "\t  \t\t<div title=\"";
  protected final String TEXT_330 = "\"><!--";
  protected final String TEXT_331 = " tab start-->" + NL + "\t\t  \t\t<div class=\"v-fckeditor\">" + NL + "\t\t  \t\t\t<input type=\"hidden\" id=\"";
  protected final String TEXT_332 = "\" name=\"";
  protected final String TEXT_333 = "\"/>" + NL + "\t\t  \t\t\t<textarea style=\"width: 90%;\"  id=\"fck_";
  protected final String TEXT_334 = "\">" + NL + "\t\t      \t\t  ${mo.";
  protected final String TEXT_335 = "}" + NL + "\t\t   \t\t\t</textarea>" + NL + "\t\t\t\t  \t<script type=\"text/javascript\">" + NL + "\t\t\t             var oFCKeditor = new FCKeditor('fck_";
  protected final String TEXT_336 = "') ; " + NL + "\t\t                 oFCKeditor.BasePath\t= '${ctx}/resources/fckeditor/' ;" + NL + "\t\t                 oFCKeditor.Config[\"CustomConfigurationsPath\"]=\"${ctx}/resources/fckeditor/customConfig.js\";" + NL + "\t\t\t             oFCKeditor.ToolbarSet='goolovEditTab';" + NL + "\t\t\t             oFCKeditor.Config[\"TabSpaces\"]=2;" + NL + "\t\t\t             oFCKeditor.Config[\"LinkUpload\"] = false;" + NL + "\t\t\t             oFCKeditor.Config[\"ImageUpload\"] = true;" + NL + "\t\t\t             oFCKeditor.Config[\"FlashUpload\"] = false;" + NL + "\t\t\t             oFCKeditor.Height\t= ";
  protected final String TEXT_337 = "-130;" + NL + "\t\t                 oFCKeditor.ReplaceTextarea(); " + NL + "\t\t            </script>" + NL + "\t\t          </div>" + NL + "\t\t\t</div><!--";
  protected final String TEXT_338 = " tab end-->";
  protected final String TEXT_339 = "\t\t\t";
  protected final String TEXT_340 = NL + "\t\t\t<div title=\"";
  protected final String TEXT_341 = "\"  class=\"v-tab\"><!--";
  protected final String TEXT_342 = " tab start-->" + NL + "\t\t\t\t<div class=\"v-section-wrap\">" + NL + "\t\t\t\t\t<div class='v-title'>选择";
  protected final String TEXT_343 = "：</div>" + NL + "\t\t\t\t\t<div class=\"v-content\">" + NL + "\t\t\t\t\t\t${";
  protected final String TEXT_344 = "}" + NL + "\t\t\t\t\t</div>" + NL + "\t\t\t\t</div>" + NL + "\t\t\t</div><!--";
  protected final String TEXT_345 = " tab end-->";
  protected final String TEXT_346 = NL + "\t\t\t<div title=\"";
  protected final String TEXT_347 = "\"   class=\"v-tab\"><!--";
  protected final String TEXT_348 = " tab start-->" + NL + "\t\t\t\t\t<div class=\"v-tree-wrap\">" + NL + "\t\t\t\t\t\t<div class=\"v-title\">选择";
  protected final String TEXT_349 = "：</div>" + NL + "\t\t\t\t\t\t<div class=\"v-content\" id=\"";
  protected final String TEXT_350 = "\" style=\"height:270px; width:350px; overflow: auto;\">" + NL + "\t\t\t\t\t\t</div>" + NL + "\t\t\t\t\t</div>" + NL + "\t\t\t</div><!--";
  protected final String TEXT_351 = " tab end-->";
  protected final String TEXT_352 = "\t\t\t\t\t\t" + NL + "\t\t  </div><!-- firstTabs end -->";
  protected final String TEXT_353 = NL + "\t\t</div><!-- center end -->" + NL + "\t\t<div region=\"south\" border=\"false\" style=\"height:50px;\"><!-- south start-->" + NL + "\t\t\t<div class=\"v-buttons\"><!-- v-buttons start -->" + NL + "   \t\t\t\t<a href=\"javascript:editWinUpdateData();\" class=\"easyui-linkbutton\" >更新</a>" + NL + "\t\t\t\t<a href=\"javascript:resetData();\" class=\"easyui-linkbutton\" >重置</a>" + NL + "\t\t\t\t<a href=\"javascript:editWinClose();\" class=\"easyui-linkbutton\" >关闭</a>" + NL + "\t\t\t</div><!-- v-buttons end-->" + NL + "\t\t</div><!--\tsouth end -->" + NL + "</body>" + NL + "</html>";
  protected final String TEXT_354 = NL;
  protected final String TEXT_355 = " page contentType=\"text/html;charset=UTF-8\" ";
  protected final String TEXT_356 = NL;
  protected final String TEXT_357 = " include file=\"/common/taglibs.jsp\" ";
  protected final String TEXT_358 = NL + "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">" + NL + "<html xmlns=\"http://www.w3.org/1999/xhtml\">" + NL + "<head>" + NL + "<title>";
  protected final String TEXT_359 = " Input</title>";
  protected final String TEXT_360 = NL;
  protected final String TEXT_361 = " include file=\"/common/meta.jsp\" ";
  protected final String TEXT_362 = NL + "<script src=\"";
  protected final String TEXT_363 = "\" type=\"text/javascript\"></script>" + NL + "<script>" + NL + "\tvar ctx = '${ctx}';" + NL + "\tvar theme = '${theme}';" + NL + "\timportCssFile('sys|ui";
  protected final String TEXT_364 = "|flexiGrid";
  protected final String TEXT_365 = "|treeview";
  protected final String TEXT_366 = "', ctx, theme);" + NL + "\timportJsFile('jquery|ui|common|blockUI|form|validate";
  protected final String TEXT_367 = "|fckeditor";
  protected final String TEXT_368 = "|flexiGrid|comboGrid";
  protected final String TEXT_369 = "|treeview|combotree";
  protected final String TEXT_370 = "', ctx);" + NL + "\timportJsFile('";
  protected final String TEXT_371 = "', ctx);" + NL + "</script>" + NL + "</head>" + NL + "<body class=\"easyui-layout v-container\">" + NL + " \t<div region=\"center\" border=\"false\"><!-- center start -->";
  protected final String TEXT_372 = NL + "\t\t<div id=\"firstTabs\" class=\"v-tabs\"><!-- firstTabs start -->" + NL + "\t\t  <div title=\"基本信息\"  class=\"v-tab\"><!-- tab one  start -->";
  protected final String TEXT_373 = NL + " \t\t\t<form id=\"inputForm\" method=\"post\" class=\"v-form\">";
  protected final String TEXT_374 = NL + " \t\t\t\t<input type=\"hidden\" name=\"";
  protected final String TEXT_375 = "\" value=\"${mo.";
  protected final String TEXT_376 = "}\"/>";
  protected final String TEXT_377 = NL + " \t\t\t\t<!--<div id=\"inputInfo\" class=\"v-state-info\"></div>-->" + NL + "\t\t      \t<table>";
  protected final String TEXT_378 = NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_379 = "\t";
  protected final String TEXT_380 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_381 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_382 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_383 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_384 = "\">" + NL + "\t\t      \t\t\t\t${mo.";
  protected final String TEXT_385 = "}" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_386 = "\t";
  protected final String TEXT_387 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_388 = "\t\t\t\t\t\t";
  protected final String TEXT_389 = NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_390 = "\t";
  protected final String TEXT_391 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_392 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_393 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_394 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_395 = "\">" + NL + "\t\t      \t\t\t\t<c:choose>" + NL + "\t\t\t\t\t\t  \t \t<c:when test=\"${null==model.id}\">" + NL + "\t\t\t\t\t\t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_396 = "\" name=\"";
  protected final String TEXT_397 = "\" value=\"${mo.";
  protected final String TEXT_398 = "}\" class=\"";
  protected final String TEXT_399 = "\"/>" + NL + "\t\t\t\t\t\t \t    </c:when>" + NL + "\t\t\t\t\t\t   \t    <c:otherwise>" + NL + "\t\t\t\t\t\t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_400 = "\" name=\"";
  protected final String TEXT_401 = "\" value=\"${mo.";
  protected final String TEXT_402 = "}\" class=\"";
  protected final String TEXT_403 = " readonly\" readonly='readonly' />" + NL + "\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"oldId\" name=\"oldId\" value=\"${mo.";
  protected final String TEXT_404 = "}\"/>" + NL + "\t\t\t\t\t\t\t    </c:otherwise>" + NL + "\t\t\t\t\t\t\t</c:choose> " + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_405 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_406 = "\t\t\t\t\t\t";
  protected final String TEXT_407 = NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_408 = "\t";
  protected final String TEXT_409 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_410 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_411 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_412 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_413 = "\">" + NL + "\t\t\t\t\t\t\t <select name=\"";
  protected final String TEXT_414 = "\" id=\"";
  protected final String TEXT_415 = "\" class=\"text ";
  protected final String TEXT_416 = "readonly";
  protected final String TEXT_417 = "\" ";
  protected final String TEXT_418 = "readonly=\"readonly\"";
  protected final String TEXT_419 = ">" + NL + "\t\t\t\t\t\t\t     <option value=\"\" >无</option>" + NL + "\t\t\t\t\t\t\t     <s:property value=\"htmlSelectTree\" escape=\"false\"/>" + NL + "\t\t\t\t\t\t\t  </select>" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_420 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_421 = "\t\t\t\t\t\t";
  protected final String TEXT_422 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_423 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_424 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_425 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_426 = "\">";
  protected final String TEXT_427 = NL + "\t\t      \t\t\t\t${mo.";
  protected final String TEXT_428 = "}";
  protected final String TEXT_429 = NL + "\t\t      \t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_430 = "\" name=\"";
  protected final String TEXT_431 = "\" value=\"${mo.";
  protected final String TEXT_432 = "}\" class=\"";
  protected final String TEXT_433 = "\" />";
  protected final String TEXT_434 = NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_435 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_436 = "\t\t\t\t\t\t";
  protected final String TEXT_437 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_438 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_439 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_440 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_441 = "\">";
  protected final String TEXT_442 = NL + "\t\t      \t\t\t\t\t${mo.";
  protected final String TEXT_443 = "}";
  protected final String TEXT_444 = NL + "\t\t      \t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_445 = "\" name=\"";
  protected final String TEXT_446 = "\" value=\"${mo.";
  protected final String TEXT_447 = "}\" class=\"";
  protected final String TEXT_448 = "\" ";
  protected final String TEXT_449 = "readonly=\"readonly\"";
  protected final String TEXT_450 = "/>";
  protected final String TEXT_451 = "\t\t\t\t\t\t\t" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_452 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_453 = "\t\t\t\t\t\t";
  protected final String TEXT_454 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_455 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_456 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_457 = ":</label>" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_458 = NL + "\t\t\t\t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_459 = "\">" + NL + "\t\t\t\t\t\t\t <select  id=\"";
  protected final String TEXT_460 = "\" name=\"";
  protected final String TEXT_461 = "\" class=\"";
  protected final String TEXT_462 = "\" ";
  protected final String TEXT_463 = "readonly";
  protected final String TEXT_464 = "\" ";
  protected final String TEXT_465 = "readonly=\"readonly\"";
  protected final String TEXT_466 = ">" + NL + "\t\t\t\t\t\t\t     <s:property value=\"";
  protected final String TEXT_467 = "\" escape=\"false\"/>" + NL + "\t\t\t\t\t\t\t </select>" + NL + "\t\t\t\t\t\t</td>";
  protected final String TEXT_468 = NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_469 = "\">";
  protected final String TEXT_470 = NL + "\t\t      \t\t\t\t\t${mo.";
  protected final String TEXT_471 = "}";
  protected final String TEXT_472 = NL + "\t\t      \t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_473 = "\" name=\"";
  protected final String TEXT_474 = "\" value=\"${mo.";
  protected final String TEXT_475 = "}\" class=\"";
  protected final String TEXT_476 = "\" ";
  protected final String TEXT_477 = "readonly=\"readonly\"";
  protected final String TEXT_478 = "/>";
  protected final String TEXT_479 = "\t" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_480 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_481 = "\t\t\t\t\t\t";
  protected final String TEXT_482 = "\t";
  protected final String TEXT_483 = "\t";
  protected final String TEXT_484 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_485 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_486 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_487 = ":</label>" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_488 = NL + "\t\t\t\t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_489 = "\">" + NL + "\t\t\t\t\t\t\t ${";
  protected final String TEXT_490 = "}" + NL + "\t\t\t\t\t\t</td>";
  protected final String TEXT_491 = NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_492 = "\">";
  protected final String TEXT_493 = NL + "\t\t      \t\t\t\t\t${mo.";
  protected final String TEXT_494 = "}";
  protected final String TEXT_495 = NL + "\t\t      \t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_496 = "\" name=\"";
  protected final String TEXT_497 = "\" value=\"${mo.";
  protected final String TEXT_498 = "}\" class=\"";
  protected final String TEXT_499 = "\" ";
  protected final String TEXT_500 = "readonly=\"readonly\"";
  protected final String TEXT_501 = "/>";
  protected final String TEXT_502 = "\t" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_503 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_504 = "\t\t\t\t\t\t";
  protected final String TEXT_505 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_506 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_507 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_508 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_509 = "\">";
  protected final String TEXT_510 = NL + "\t\t      \t\t\t\t\t${mo.";
  protected final String TEXT_511 = "}";
  protected final String TEXT_512 = NL + "\t\t      \t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_513 = "\" name=\"";
  protected final String TEXT_514 = "\" value=\"${mo.";
  protected final String TEXT_515 = "}\" class=\"";
  protected final String TEXT_516 = "\" ";
  protected final String TEXT_517 = "readonly=\"readonly\"";
  protected final String TEXT_518 = "/>";
  protected final String TEXT_519 = "\t" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_520 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_521 = "\t\t\t\t\t\t";
  protected final String TEXT_522 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_523 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_524 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_525 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_526 = "\">";
  protected final String TEXT_527 = NL + "\t\t      \t\t\t\t\t${mo.";
  protected final String TEXT_528 = "}";
  protected final String TEXT_529 = NL + "\t\t      \t\t\t\t<textarea id=\"";
  protected final String TEXT_530 = "\" name=\"";
  protected final String TEXT_531 = "\"  class=\"";
  protected final String TEXT_532 = "\" >${mo.";
  protected final String TEXT_533 = "}</textarea>";
  protected final String TEXT_534 = "\t" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_535 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_536 = "\t\t\t\t\t\t";
  protected final String TEXT_537 = "\t\t";
  protected final String TEXT_538 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_539 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_540 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_541 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_542 = "\">";
  protected final String TEXT_543 = NL + "\t\t      \t\t\t\t\t${mo.";
  protected final String TEXT_544 = "}";
  protected final String TEXT_545 = NL + "\t\t      \t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_546 = "\" name=\"";
  protected final String TEXT_547 = "\" value=\"${mo.";
  protected final String TEXT_548 = "}\" class=\"";
  protected final String TEXT_549 = "\" />";
  protected final String TEXT_550 = "\t\t\t      \t\t" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_551 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_552 = "\t\t\t\t\t\t";
  protected final String TEXT_553 = "\t\t";
  protected final String TEXT_554 = "\t\t\t";
  protected final String TEXT_555 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_556 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_557 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_558 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_559 = "\">" + NL + "\t\t      \t\t\t\t<input type=\"file\" id=\"";
  protected final String TEXT_560 = "_file\" name=\"";
  protected final String TEXT_561 = "_file\"  onchange=\"";
  protected final String TEXT_562 = "Browse(this);\" size=\"50\" />" + NL + "<!--\t\t      \t\t\t\t<a href=\"javascript:";
  protected final String TEXT_563 = "Reset();\" class=\"easyui-linkbutton\" >重置</a>-->" + NL + "\t\t\t                <br/>\t\t\t\t" + NL + "\t\t      \t\t\t\t<div class=\"fileWrap\" style=\"width:160px;height: 155px;\">" + NL + "\t\t\t                \t<!-- uploaded image -->" + NL + "\t\t\t\t\t\t\t\t<div id=\"";
  protected final String TEXT_564 = "_file_uploaded\" class=\"item\">" + NL + "\t\t\t\t\t\t\t\t\t<c:if test=\"${null!=mo.";
  protected final String TEXT_565 = "}\">" + NL + "\t\t\t   \t\t\t\t\t\t\t\t${mo.";
  protected final String TEXT_566 = "}<span class=\"label\">已上传</span>" + NL + "\t\t\t   \t\t\t\t\t\t\t\t<a href=\"javascript:";
  protected final String TEXT_567 = "Del('${mo.";
  protected final String TEXT_568 = "}');\" class=\"remove\" >删除</a> " + NL + "\t\t\t   \t\t\t\t\t\t</c:if>" + NL + "\t\t\t   \t\t\t\t\t</div>" + NL + "\t   \t\t\t\t\t\t\t<div style=\"clear: both\"></div>" + NL + "\t   \t\t\t\t\t\t</div>  \t\t" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_569 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_570 = "\t\t\t\t\t\t";
  protected final String TEXT_571 = "\t\t";
  protected final String TEXT_572 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_573 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_574 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_575 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_576 = "\">" + NL + "\t\t      \t\t\t\t<input type=\"file\" id=\"";
  protected final String TEXT_577 = "_image\" name=\"";
  protected final String TEXT_578 = "_image\"  onchange=\"";
  protected final String TEXT_579 = "Browse(this);\" size=\"50\" />" + NL + "<!--\t\t      \t\t\t\t<a href=\"javascript:";
  protected final String TEXT_580 = "Reset();\" class=\"easyui-linkbutton\" >重置</a>-->" + NL + "\t\t      \t\t\t\t<br/>" + NL + "\t\t\t \t         \t<font color=\"green\">支持JPG,JPEG,GIF,BMP图片格式(宽:150px,高:140px) </font>" + NL + "\t\t\t                <br/>\t\t\t\t" + NL + "\t\t      \t\t\t\t<div class=\"imageWrap\" style=\"width:160px;height: 155px;\">" + NL + "\t\t\t                \t<!-- uploaded image -->" + NL + "\t\t\t\t\t\t\t\t<div id=\"";
  protected final String TEXT_581 = "_image_uploaded\" class=\"imageItem\">" + NL + "\t\t\t                    \t<c:choose>" + NL + "\t\t\t                    \t\t<c:when test=\"${null==mo.";
  protected final String TEXT_582 = "}\">" + NL + "\t\t\t\t\t\t\t\t\t\t\t<img id=\"";
  protected final String TEXT_583 = "_image_item_uploaded_preview\" src=\"${ctx}/resources/style/default/images/diningDefaultNoPicture.jpg\"  width=\"150px\" height=\"140px\" />" + NL + "\t\t\t\t\t\t        \t\t</c:when>" + NL + "\t\t\t   \t\t\t\t\t\t\t<c:otherwise>" + NL + "\t\t\t   \t\t\t\t\t\t\t\t<img id=\"";
  protected final String TEXT_584 = "_image_item_uploaded_preview\" src=\"${ctx}/${mo.";
  protected final String TEXT_585 = "}\"  width=\"150px\" height=\"140px\" /><br/>" + NL + "\t\t\t   \t\t\t\t\t\t\t\t<span class=\"label\">已上传</span>" + NL + "\t\t\t   \t\t\t\t\t\t\t\t<!-- <a href=\"javascript:";
  protected final String TEXT_586 = "Del('${mo.";
  protected final String TEXT_587 = "}');\" class=\"remove\" >删除</a> -->" + NL + "\t\t\t   \t\t\t\t\t\t\t</c:otherwise>" + NL + "\t\t\t\t\t\t\t\t\t</c:choose> " + NL + "\t\t\t   \t\t\t\t\t</div>" + NL + "\t\t\t   \t\t\t\t\t<div id=\"";
  protected final String TEXT_588 = "_image_browse\" class=\"imageItem\" style=\"display: none\">" + NL + "\t\t\t\t\t\t        \t<div id=\"";
  protected final String TEXT_589 = "_image_browse_preview\"></div>" + NL + "\t\t\t\t\t\t        \t<div class=\"bottom\">" + NL + "\t\t\t\t\t\t        \t\t<a class=\"remove\" href=\"javascript:void(0);\" onclick=\"";
  protected final String TEXT_590 = "PreviewRemove();\">删除</a>" + NL + "\t\t\t\t\t\t        \t</div>" + NL + "\t\t\t\t\t\t      \t</div>" + NL + "\t   \t\t\t\t\t\t\t<div style=\"clear: both\"></div>" + NL + "\t   \t\t\t\t\t\t</div>  \t\t" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_591 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_592 = "\t\t\t\t\t\t";
  protected final String TEXT_593 = "\t";
  protected final String TEXT_594 = "\t\t";
  protected final String TEXT_595 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_596 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_597 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_598 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t\t\t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_599 = "\">" + NL + "\t\t\t\t\t\t\t <input type=\"hidden\" id=\"";
  protected final String TEXT_600 = "_";
  protected final String TEXT_601 = "\" name=\"";
  protected final String TEXT_602 = ".";
  protected final String TEXT_603 = "\" value=\"${mo.";
  protected final String TEXT_604 = "_";
  protected final String TEXT_605 = "}\" class=\"text\" />" + NL + "\t\t\t\t\t\t\t <input type=\"text\" id=\"";
  protected final String TEXT_606 = "_";
  protected final String TEXT_607 = "\" name=\"";
  protected final String TEXT_608 = ".";
  protected final String TEXT_609 = "\" value=\"${mo.";
  protected final String TEXT_610 = ".";
  protected final String TEXT_611 = "}\" class=\"text\" />" + NL + "\t\t\t\t\t\t</td>";
  protected final String TEXT_612 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_613 = "\t\t\t\t\t\t";
  protected final String TEXT_614 = "\t";
  protected final String TEXT_615 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_616 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_617 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_618 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t\t\t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_619 = "\">";
  protected final String TEXT_620 = NL + "\t\t      \t\t\t\t\t${mo.";
  protected final String TEXT_621 = ".";
  protected final String TEXT_622 = "}";
  protected final String TEXT_623 = NL + "\t\t\t\t\t\t\t <input type=\"hidden\" id=\"";
  protected final String TEXT_624 = "_";
  protected final String TEXT_625 = "\" name=\"";
  protected final String TEXT_626 = ".";
  protected final String TEXT_627 = "\" value=\"${mo.";
  protected final String TEXT_628 = ".";
  protected final String TEXT_629 = "}\"/>" + NL + "\t\t\t\t\t\t\t <input type=\"text\" id=\"";
  protected final String TEXT_630 = "_";
  protected final String TEXT_631 = "\" name=\"";
  protected final String TEXT_632 = ".";
  protected final String TEXT_633 = "\" value=\"${mo.";
  protected final String TEXT_634 = ".";
  protected final String TEXT_635 = "}\"  class=\"text select\" onclick=\"";
  protected final String TEXT_636 = "();\"/>" + NL + "\t\t\t\t\t\t\t <img class=\"clear\" id=\"";
  protected final String TEXT_637 = "_";
  protected final String TEXT_638 = "_clear\" src=\"${ctx}/resources/style/default/tree/images/s.gif\" alt=\"清空\" onclick=\"javascript:relGlDiningSiteListForSelectClear();\" align=\"middle\"/>\t\t";
  protected final String TEXT_639 = "\t\t" + NL + "\t\t\t\t\t\t</td>";
  protected final String TEXT_640 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_641 = "\t\t\t\t\t\t";
  protected final String TEXT_642 = "\t";
  protected final String TEXT_643 = "\t";
  protected final String TEXT_644 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_645 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_646 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_647 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t\t\t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_648 = "\">" + NL + "\t\t\t\t\t\t\t <input type=\"hidden\" id=\"";
  protected final String TEXT_649 = "_";
  protected final String TEXT_650 = "\" name=\"";
  protected final String TEXT_651 = ".";
  protected final String TEXT_652 = "\" value=\"${mo.";
  protected final String TEXT_653 = "_";
  protected final String TEXT_654 = "}\" class=\"text\" />" + NL + "\t\t\t\t\t\t\t <input type=\"text\" id=\"";
  protected final String TEXT_655 = "_";
  protected final String TEXT_656 = "\" name=\"";
  protected final String TEXT_657 = ".";
  protected final String TEXT_658 = "\" value=\"${mo.";
  protected final String TEXT_659 = ".";
  protected final String TEXT_660 = "}\" class=\"text\" />" + NL + "\t\t\t\t\t\t</td>";
  protected final String TEXT_661 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_662 = "\t\t\t\t\t\t";
  protected final String TEXT_663 = "\t";
  protected final String TEXT_664 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_665 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_666 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_667 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t\t\t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_668 = "\">";
  protected final String TEXT_669 = NL + "\t\t      \t\t\t\t\t${mo.";
  protected final String TEXT_670 = ".";
  protected final String TEXT_671 = "}";
  protected final String TEXT_672 = NL + "\t\t\t\t\t\t\t <input type=\"hidden\" id=\"";
  protected final String TEXT_673 = "_";
  protected final String TEXT_674 = "\" name=\"";
  protected final String TEXT_675 = ".";
  protected final String TEXT_676 = "\" value=\"${mo.";
  protected final String TEXT_677 = ".";
  protected final String TEXT_678 = "}\" />" + NL + "\t\t\t\t\t\t\t <input type=\"text\" id=\"";
  protected final String TEXT_679 = "_";
  protected final String TEXT_680 = "\" name=\"";
  protected final String TEXT_681 = ".";
  protected final String TEXT_682 = "\" value=\"${mo.";
  protected final String TEXT_683 = ".";
  protected final String TEXT_684 = "}\"  class=\"text select\" readonly=\"readonly\" onclick=\"";
  protected final String TEXT_685 = "();\"/>" + NL + "\t\t\t\t\t\t\t <img class=\"clear\" id=\"";
  protected final String TEXT_686 = "_";
  protected final String TEXT_687 = "_clear\" src=\"${ctx}/resources/style/default/tree/images/s.gif\" alt=\"清空\" onclick=\"javascript:relGlDiningSiteListForSelectClear();\" align=\"middle\"/>\t\t";
  protected final String TEXT_688 = "\t" + NL + "\t\t\t\t\t\t</td>";
  protected final String TEXT_689 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_690 = "\t\t\t\t\t\t";
  protected final String TEXT_691 = "\t";
  protected final String TEXT_692 = "\t" + NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_693 = "\"></td>" + NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_694 = "\t";
  protected final String TEXT_695 = NL + "\t\t\t\t\t<tr>" + NL + "\t\t      \t\t\t<td colspan=\"";
  protected final String TEXT_696 = "\">" + NL + "\t\t      \t\t\t\t<div class=\"v-fieldset-wrap\">" + NL + "\t\t\t      \t\t\t\t<fieldset>" + NL + "\t\t\t\t\t              <legend>" + NL + "\t\t\t\t\t                 \t";
  protected final String TEXT_697 = ":" + NL + "\t\t\t\t\t              </legend>" + NL + "\t\t\t\t\t              <div class=\"v-fieldset-content\">" + NL + "\t\t\t\t\t                \t${";
  protected final String TEXT_698 = "}" + NL + "\t\t\t\t\t\t\t      </div>" + NL + "\t\t\t\t\t            </fieldset>" + NL + "\t\t      \t\t\t\t</div>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t</tr>";
  protected final String TEXT_699 = NL + "\t\t\t\t\t<tr>" + NL + "\t\t      \t\t\t<td colspan=\"";
  protected final String TEXT_700 = "\">" + NL + "\t\t      \t\t\t\t<div class=\"v-tree-wrap\">" + NL + "\t\t\t\t\t\t\t\t<div class=\"v-title\">";
  protected final String TEXT_701 = "：</div>" + NL + "\t\t\t\t\t\t\t\t<div class=\"v-content\" id=\"";
  protected final String TEXT_702 = "\" style=\"height:270px; width:350px; overflow: auto;\">" + NL + "\t\t\t\t\t\t\t\t</div>" + NL + "\t\t\t\t\t\t\t</div>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t</tr>";
  protected final String TEXT_703 = NL + "\t\t\t\t\t<tr>" + NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_704 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" ";
  protected final String TEXT_705 = "colspan=\"";
  protected final String TEXT_706 = "\"";
  protected final String TEXT_707 = ">" + NL + "\t\t\t \t         \t <input type=\"file\" id=\"uploadImage_";
  protected final String TEXT_708 = "\" name=\"uploadImage_";
  protected final String TEXT_709 = "\" size=\"35\"/><br/>" + NL + "\t\t\t \t         \t <div id=\"previewImageWrap_";
  protected final String TEXT_710 = "\">" + NL + "\t\t\t \t         \t \t<img id=\"previewImage_";
  protected final String TEXT_711 = "\" src=\"\"/>" + NL + "\t\t\t \t         \t </div>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t</tr>";
  protected final String TEXT_712 = NL + "\t\t\t\t\t<tr>" + NL + "\t\t\t\t       <td class=\"label\">" + NL + "\t\t\t\t       \t\t<label>";
  protected final String TEXT_713 = ":</label>" + NL + "\t\t\t\t       </td>" + NL + "\t\t\t\t       <td class=\"field\" ";
  protected final String TEXT_714 = "colspan=\"";
  protected final String TEXT_715 = "\"";
  protected final String TEXT_716 = ">" + NL + "\t\t\t\t\t   \t\t<input type=\"file\" id=\"";
  protected final String TEXT_717 = "\" name=\"";
  protected final String TEXT_718 = "\" size=\"35\" onchange=\"goolov.validete.file(this);\"/>" + NL + "\t\t\t\t   \t   </td>" + NL + "\t\t\t\t   \t</tr>";
  protected final String TEXT_719 = NL + "\t\t\t\t\t<tr>" + NL + "\t\t\t\t\t  <td colspan=\"";
  protected final String TEXT_720 = "\">" + NL + "\t\t\t\t\t  \t<div class=\"v-section-wrap\">" + NL + "\t\t\t\t\t  \t\t<div class=\"v-title\">";
  protected final String TEXT_721 = ":</div>" + NL + "\t\t\t\t\t  \t\t<div class=\"v-content\" style=\"margin: 0px auto;width:95%\">" + NL + "\t\t\t\t\t  \t\t\t<input type=\"hidden\" id=\"";
  protected final String TEXT_722 = "\" name=\"";
  protected final String TEXT_723 = "\"/>" + NL + "\t\t\t\t\t  \t\t\t<textarea style=\"width:100%;\"  id=\"fck_";
  protected final String TEXT_724 = "\">" + NL + "\t\t\t\t\t      \t\t  ${mo.";
  protected final String TEXT_725 = "}" + NL + "\t\t\t\t\t   \t\t\t</textarea>" + NL + "\t\t\t\t\t\t\t  \t<script type=\"text/javascript\">" + NL + "\t\t\t\t\t\t             var oFCKeditor = new FCKeditor('fck_";
  protected final String TEXT_726 = "') ; " + NL + "\t\t\t\t\t                 oFCKeditor.BasePath\t= '${ctx}/resources/fckeditor/' ;" + NL + "\t\t\t\t\t                 oFCKeditor.Config[\"CustomConfigurationsPath\"]=\"${ctx}/resources/fckeditor/customConfig.js\";" + NL + "\t\t\t\t\t\t             oFCKeditor.ToolbarSet='goolovEdit';" + NL + "\t\t\t\t\t\t             oFCKeditor.Config[\"TabSpaces\"]=2;" + NL + "\t\t\t\t\t\t             oFCKeditor.Config[\"LinkUpload\"] = false;" + NL + "\t\t\t\t\t\t             oFCKeditor.Config[\"ImageUpload\"] = true;" + NL + "\t\t\t\t\t\t             oFCKeditor.Config[\"FlashUpload\"] = false;" + NL + "\t\t\t\t\t\t             oFCKeditor.Height\t= 350;" + NL + "\t\t\t\t\t                 oFCKeditor.ReplaceTextarea(); " + NL + "\t\t\t\t\t            </script>" + NL + "\t\t\t\t\t          </div>" + NL + "\t\t\t\t\t  \t </div>" + NL + "\t\t\t\t\t  </td>" + NL + "\t\t\t\t   </tr>\t      ";
  protected final String TEXT_727 = NL + "\t\t\t\t</table>" + NL + "\t\t\t  </form>";
  protected final String TEXT_728 = NL + "\t\t\t</div><!-- tab one end -->";
  protected final String TEXT_729 = NL + "\t  \t\t<div title=\"";
  protected final String TEXT_730 = "\"><!--";
  protected final String TEXT_731 = " tab start-->" + NL + "\t\t  \t\t<div class=\"v-fckeditor\">" + NL + "\t\t  \t\t\t<input type=\"hidden\" id=\"";
  protected final String TEXT_732 = "\" name=\"";
  protected final String TEXT_733 = "\"/>" + NL + "\t\t  \t\t\t<textarea style=\"width: 90%;\"  id=\"fck_";
  protected final String TEXT_734 = "\">" + NL + "\t\t      \t\t  ${mo.";
  protected final String TEXT_735 = "}" + NL + "\t\t   \t\t\t</textarea>" + NL + "\t\t\t\t  \t<script type=\"text/javascript\">" + NL + "\t\t\t             var oFCKeditor = new FCKeditor('fck_";
  protected final String TEXT_736 = "') ; " + NL + "\t\t                 oFCKeditor.BasePath\t= '${ctx}/resources/fckeditor/' ;" + NL + "\t\t                 oFCKeditor.Config[\"CustomConfigurationsPath\"]=\"${ctx}/resources/fckeditor/customConfig.js\";" + NL + "\t\t\t             oFCKeditor.ToolbarSet='goolovEditTab';" + NL + "\t\t\t             oFCKeditor.Config[\"TabSpaces\"]=2;" + NL + "\t\t\t             oFCKeditor.Config[\"LinkUpload\"] = false;" + NL + "\t\t\t             oFCKeditor.Config[\"ImageUpload\"] = true;" + NL + "\t\t\t             oFCKeditor.Config[\"FlashUpload\"] = false;" + NL + "\t\t\t             oFCKeditor.Height\t= ";
  protected final String TEXT_737 = "-130;" + NL + "\t\t                 oFCKeditor.ReplaceTextarea(); " + NL + "\t\t            </script>" + NL + "\t\t          </div>" + NL + "\t\t\t</div><!--";
  protected final String TEXT_738 = " tab end-->";
  protected final String TEXT_739 = "\t\t\t";
  protected final String TEXT_740 = NL + "\t\t\t<div title=\"";
  protected final String TEXT_741 = "\"  class=\"v-tab\"><!--";
  protected final String TEXT_742 = " tab start-->" + NL + "\t\t\t\t<div class=\"v-section-wrap\">" + NL + "\t\t\t\t\t<div class='v-title'>选择";
  protected final String TEXT_743 = "：</div>" + NL + "\t\t\t\t\t<div class=\"v-content\">" + NL + "\t\t\t\t\t\t${";
  protected final String TEXT_744 = "}" + NL + "\t\t\t\t\t</div>" + NL + "\t\t\t\t</div>" + NL + "\t\t\t</div><!--";
  protected final String TEXT_745 = " tab end-->";
  protected final String TEXT_746 = NL + "\t\t\t<div title=\"";
  protected final String TEXT_747 = "\"   class=\"v-tab\"><!--";
  protected final String TEXT_748 = " tab start-->" + NL + "\t\t\t\t\t<div class=\"v-tree-wrap\">" + NL + "\t\t\t\t\t\t<div class=\"v-title\">选择";
  protected final String TEXT_749 = "：</div>" + NL + "\t\t\t\t\t\t<div class=\"v-content\" id=\"";
  protected final String TEXT_750 = "\" style=\"height:270px; width:350px; overflow: auto;\">" + NL + "\t\t\t\t\t\t</div>" + NL + "\t\t\t\t\t</div>" + NL + "\t\t\t</div><!--";
  protected final String TEXT_751 = " tab end-->";
  protected final String TEXT_752 = "\t\t\t\t\t\t" + NL + "\t\t  </div><!-- firstTabs end -->";
  protected final String TEXT_753 = NL + "\t\t</div><!-- center end -->" + NL + "\t\t<div region=\"south\" border=\"false\" style=\"height:50px;\"><!-- south start-->" + NL + "\t\t\t<div class=\"v-buttons\"><!-- v-buttons start -->" + NL + "\t\t  \t \t<c:choose>" + NL + "\t\t\t  \t\t<c:when test=\"${null==model.id}\">" + NL + "\t\t\t   \t\t\t<a href=\"javascript:newWinSaveData();\" class=\"easyui-linkbutton\">新增</a>" + NL + "\t\t\t   \t\t\t<a href=\"javascript:resetData();\" class=\"easyui-linkbutton\" >重置</a>" + NL + "\t\t\t   \t\t\t<a href=\"javascript:newWinClose();\" class=\"easyui-linkbutton\" >关闭</a>" + NL + "\t\t\t \t\t</c:when>" + NL + "\t\t\t   \t\t<c:otherwise>" + NL + "\t\t   \t\t\t\t<a href=\"javascript:editWinUpdateData();\" class=\"easyui-linkbutton\" >更新</a>" + NL + "\t\t\t\t\t\t<a href=\"javascript:resetData();\" class=\"easyui-linkbutton\" >重置</a>" + NL + "\t\t\t\t\t\t<a href=\"javascript:editWinClose();\" class=\"easyui-linkbutton\" >关闭</a>" + NL + "\t\t\t\t\t</c:otherwise>" + NL + "\t\t\t   </c:choose> " + NL + "\t\t\t</div><!-- v-buttons end-->" + NL + "\t\t</div><!--\tsouth end -->" + NL + "</body>" + NL + "</html>";
  protected final String TEXT_754 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    Class uml2Class_proxy = (Class) argument;
    //Package uml2Package_proxy = uml2Class_proxy.getPackage();
     if(FileStereotypeHelper.isClass_file(uml2Class_proxy)||FileStereotypeHelper.isClass_Image(uml2Class_proxy)){//应用了File or Image
    Class uml2Class = (Class) argument;Package uml2Package = uml2Class.getPackage();
    
UmlClassWrap clazzWrap=new UmlClassWrap(uml2Class);
String packageName=NameHelper.getQualifiedName(uml2Package);
String modelCapName=NameHelper.getCapName(uml2Class);
String modelUncapName=NameHelper.getUncapName(uml2Class);
String modelCommentName=TypeHelper.getDocumentationOrName(uml2Class);
/*******input content*********/
List<Property> contentPropertyList=ViewInputHelper.getViewInputContent(uml2Class);
List<Property> contentTabPropertyList=ViewInputHelper.getViewInputContentTab(uml2Class);
boolean needFck=false;
if(!contentPropertyList.isEmpty()||!contentTabPropertyList.isEmpty()){
	needFck=true;
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
    					String modelEnumQualifiedName=MdaHelper.getModelQualifiedName(enumeration,PKGSuffix.enumeration,ModelNameSuffix.enumeration);
    					String modelEnumName=MdaHelper.getModelClassName(enumeration,ModelNameSuffix.enumeration);
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
    if(						ViewInputHelper.isViewInput_readonly(property)){
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
    				String propertyToDateTimeCapName=PropertyNamedRuleKind.dateToDateTimeStr.getRuleCapNamed(property);
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
    
/*****************************************************************
 * process rel 
/*****************************************************************/

    /********process M2OSelect********/
    stringBuffer.append(TEXT_195);
    			if (ViewInputHelper.isApplyM2OSelect(property)) {//M2OSelect
    				Class propertyType = (Class) property.getType();
    				String propertyTypeComment = TypeHelper.getDocumentationOrName(propertyType);
     				Property propertyTypeIdProperty=EntityHelper.getIDProperty(propertyType);
     				String propertyTypeIdPropertyUncapSafeName=NameHelper.uncapSafeName(propertyTypeIdProperty);
    				needTd=2>trIncludeTd?trIncludeTd:2;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_196);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_197);
    					tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    				String m2oSelectHtml=NamedUtil.getPropertyNamed(property,PropertyNamedRuleKind.selectHtml);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(propertyTypeComment);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_204);
    if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_205);
    }
    stringBuffer.append(TEXT_206);
    stringBuffer.append(m2oSelectHtml);
    stringBuffer.append(TEXT_207);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_208);
    				}
    stringBuffer.append(TEXT_209);
    				continue;
    			}	
    stringBuffer.append(TEXT_210);
    	/********process M2OSelectPage********/
    			if (ViewInputHelper.isApplyM2OSelectPage(property)) {//M2OSelectPage
    				Class propertyType = (Class) property.getType();
    				String propertyTypeComment = TypeHelper.getDocumentationOrName(propertyType);
     				Property propertyTypeIdProperty=EntityHelper.getIDProperty(propertyType);
     				String propertyTypeIdPropertyUncapSafeName=NameHelper.uncapSafeName(propertyTypeIdProperty);
    				needTd=2>trIncludeTd?trIncludeTd:2;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_211);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_212);
    					tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    stringBuffer.append(TEXT_213);
    stringBuffer.append(propertyTypeComment);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_215);
    							if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_216);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_218);
    							}else{
    stringBuffer.append(TEXT_219);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(propertyStyleClass);
    stringBuffer.append(TEXT_226);
    if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_227);
    }
    stringBuffer.append(TEXT_228);
    							}
    stringBuffer.append(TEXT_229);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_230);
    				}
    stringBuffer.append(TEXT_231);
    				continue;
    			}
    stringBuffer.append(TEXT_232);
    	/********process O2OSelect********/
    			if (ViewInputHelper.isApplyO2OSelect(property)) {//O2OSelect
    stringBuffer.append(TEXT_233);
    				Class propertyType = (Class) property.getType();
    				String propertyTypeComment = TypeHelper.getDocumentationOrName(propertyType);
     				Property propertyTypeIdProperty=EntityHelper.getIDProperty(propertyType);
     				String propertyTypeIdPropertyUncapSafeName=NameHelper.uncapSafeName(propertyTypeIdProperty);
    				needTd=2>trIncludeTd?trIncludeTd:2;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_234);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_235);
    					tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    				String O2OSelectHtml=NamedUtil.getPropertyNamed(property,PropertyNamedRuleKind.selectHtml);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(propertyTypeComment);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_242);
    if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_243);
    }
    stringBuffer.append(TEXT_244);
    stringBuffer.append(O2OSelectHtml);
    stringBuffer.append(TEXT_245);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_246);
    				}
    stringBuffer.append(TEXT_247);
    				continue;
    			}	
    stringBuffer.append(TEXT_248);
    	/********process O2OSelectPage********/
    			if (ViewInputHelper.isApplyO2OSelectPage(property)) {//O2OSelectPage
    				Class propertyType = (Class) property.getType();
    				String propertyTypeComment = TypeHelper.getDocumentationOrName(propertyType);
     				Property propertyTypeIdProperty=EntityHelper.getIDProperty(propertyType);
     				String propertyTypeIdPropertyUncapSafeName=NameHelper.uncapSafeName(propertyTypeIdProperty);
    				needTd=2>trIncludeTd?trIncludeTd:2;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_249);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_250);
    					tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    stringBuffer.append(TEXT_251);
    stringBuffer.append(propertyTypeComment);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_253);
    							if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_254);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_256);
    							}else{
    stringBuffer.append(TEXT_257);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_258);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(propertyStyleClass);
    stringBuffer.append(TEXT_264);
    if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_265);
    }
    stringBuffer.append(TEXT_266);
    							}
    stringBuffer.append(TEXT_267);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_268);
    				}
    stringBuffer.append(TEXT_269);
    				continue;
    			}
    stringBuffer.append(TEXT_270);
    	}
    	if (tdCount%trIncludeTd!=0){
    stringBuffer.append(TEXT_271);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_272);
    	}
    
	/*****************************************************************
	 * property simple input end
	/*****************************************************************/

    stringBuffer.append(TEXT_273);
    
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
    stringBuffer.append(TEXT_274);
    stringBuffer.append(trIncludeTd);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(relPropertyCheckboxs);
    stringBuffer.append(TEXT_277);
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
    stringBuffer.append(TEXT_278);
    stringBuffer.append(trIncludeTd);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(relPropertyCheckTreeDomId);
    stringBuffer.append(TEXT_281);
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
    stringBuffer.append(TEXT_282);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_283);
    if(trIncludeTd-1>1){
    stringBuffer.append(TEXT_284);
    stringBuffer.append(trIncludeTd-1);
    stringBuffer.append(TEXT_285);
    }
    stringBuffer.append(TEXT_286);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_287);
    		}
    }*/
    /********process file properties********/
    /*List<Property> filePropertyList=ViewInputHelper.getViewInputFile(uml2Class);
    if(null!=filePropertyList&&filePropertyList.size()>0){
    	for(Property property:filePropertyList){
     			String propertyCommentName=TypeHelper.getDocumentationOrName(property);
     			String propertyUncapSafeName=NameHelper.uncapSafeName(property);
     			//String propertyStyleClass=ViewInputHelper.getStyleClass(property);
    stringBuffer.append(TEXT_288);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_289);
    if(trIncludeTd-1>1){
    stringBuffer.append(TEXT_290);
    stringBuffer.append(trIncludeTd-1);
    stringBuffer.append(TEXT_291);
    }
    stringBuffer.append(TEXT_292);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_293);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_294);
    	}
    }*/
    /********process content properties********/
    if(null!=contentPropertyList&&contentPropertyList.size()>0){
    for(Property property:contentPropertyList){
     			String propertyCommentName=TypeHelper.getDocumentationOrName(property);
     			String propertyUncapSafeName=NameHelper.uncapSafeName(property);
     			//String propertyStyleClass=ViewInputHelper.getStyleClass(property);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(trIncludeTd);
    stringBuffer.append(TEXT_296);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_297);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_298);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_299);
    stringBuffer.append(NameHelper.getUncapName(property));
    stringBuffer.append(TEXT_300);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_301);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_302);
    }}
    
/*****************************************************************
 * process image and file
/*****************************************************************/

    if(FileStereotypeHelper.isClass_file(uml2Class)){
     			//String propertyCommentName=TypeHelper.getDocumentationOrName(property);
     			//String propertyUncapSafeName=NameHelper.uncapSafeName(property);
     			//String propertyStyleClass=ViewInputHelper.getStyleClass(property);
    			Property propertyFileExtention=FileStereotypeHelper.getProperty_FileExtention(uml2Class);
     			String propertyFileExtentionUncapSafeName=NameHelper.uncapSafeName(propertyFileExtention);
    			Property propertyFileApplyFileName=FileStereotypeHelper.getProperty_FileName(uml2Class);
    			String propertyFileApplyFileNameUncapSafeName=NameHelper.uncapSafeName(propertyFileApplyFileName);
    			Property propertyFileFileSavePath=FileStereotypeHelper.getProperty_FileSavePath(uml2Class);
    			String propertyFileFileSavePathUncapSafeName=NameHelper.uncapSafeName(propertyFileFileSavePath);
    			Property propertyFileFileSize=FileStereotypeHelper.getProperty_FileSize(uml2Class);
    			String propertyFileFileSizeUncapSafeName=NameHelper.uncapSafeName(propertyFileFileSize);
    			Property propertyFileFileType=FileStereotypeHelper.getProperty_FileType(uml2Class);
    			String propertyFileFileTypeUncapSafeName=NameHelper.uncapSafeName(propertyFileFileType);
    stringBuffer.append(TEXT_303);
    if(trIncludeTd-1>1){
    stringBuffer.append(TEXT_304);
    stringBuffer.append(trIncludeTd-1);
    stringBuffer.append(TEXT_305);
    }
    stringBuffer.append(TEXT_306);
    stringBuffer.append(propertyFileFileSavePathUncapSafeName);
    stringBuffer.append(TEXT_307);
    stringBuffer.append(propertyFileFileTypeUncapSafeName);
    stringBuffer.append(TEXT_308);
    if(trIncludeTd-3>1){
    stringBuffer.append(TEXT_309);
    stringBuffer.append(trIncludeTd-3);
    stringBuffer.append(TEXT_310);
    }
    stringBuffer.append(TEXT_311);
    stringBuffer.append(propertyFileFileSizeUncapSafeName);
    stringBuffer.append(TEXT_312);
    }else if(FileStereotypeHelper.isClass_Image(uml2Class)){
    			Property propertyFileExtention=FileStereotypeHelper.getProperty_FileExtention(uml2Class);
     			String propertyFileExtentionUncapSafeName=NameHelper.uncapSafeName(propertyFileExtention);
    			Property propertyFileApplyFileName=FileStereotypeHelper.getProperty_FileName(uml2Class);
    			String propertyFileApplyFileNameUncapSafeName=NameHelper.uncapSafeName(propertyFileApplyFileName);
    			Property propertyFileFileSavePath=FileStereotypeHelper.getProperty_FileSavePath(uml2Class);
    			String propertyFileFileSavePathUncapSafeName=NameHelper.uncapSafeName(propertyFileFileSavePath);
    			Property propertyFileFileSize=FileStereotypeHelper.getProperty_FileSize(uml2Class);
    			String propertyFileFileSizeUncapSafeName=NameHelper.uncapSafeName(propertyFileFileSize);
    			Property propertyFileFileType=FileStereotypeHelper.getProperty_FileType(uml2Class);
    			String propertyFileFileTypeUncapSafeName=NameHelper.uncapSafeName(propertyFileFileType);
    stringBuffer.append(TEXT_313);
    if(trIncludeTd-1>1){
    stringBuffer.append(TEXT_314);
    stringBuffer.append(trIncludeTd-1);
    stringBuffer.append(TEXT_315);
    }
    stringBuffer.append(TEXT_316);
    stringBuffer.append(propertyFileFileSavePathUncapSafeName);
    stringBuffer.append(TEXT_317);
    stringBuffer.append(propertyFileFileTypeUncapSafeName);
    stringBuffer.append(TEXT_318);
    if(trIncludeTd-3>1){
    stringBuffer.append(TEXT_319);
    stringBuffer.append(trIncludeTd-3);
    stringBuffer.append(TEXT_320);
    }
    stringBuffer.append(TEXT_321);
    stringBuffer.append(propertyFileFileSizeUncapSafeName);
    stringBuffer.append(TEXT_322);
    if(trIncludeTd>1){
    stringBuffer.append(TEXT_323);
    stringBuffer.append(trIncludeTd);
    stringBuffer.append(TEXT_324);
    }
    stringBuffer.append(TEXT_325);
    stringBuffer.append(propertyFileFileSavePathUncapSafeName);
    stringBuffer.append(TEXT_326);
    }
    stringBuffer.append(TEXT_327);
    if(!tabsList.isEmpty()||!contentTabPropertyList.isEmpty()){
    stringBuffer.append(TEXT_328);
    	for(Iterator<Property> iter=contentTabPropertyList.iterator();iter.hasNext();){
    			Property property=iter.next();
     			String propertyCommentName=TypeHelper.getDocumentationOrName(property);
     			String propertyUncapSafeName=NameHelper.uncapSafeName(property);
     			//String propertyStyleClass=ViewInputHelper.getStyleClass(property);
    			String propertyCapConmentName=TypeHelper.getDocumentationOrName(property);
    stringBuffer.append(TEXT_329);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_330);
    stringBuffer.append(propertyCapConmentName);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_332);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_333);
    stringBuffer.append(NameHelper.getUncapName(property));
    stringBuffer.append(TEXT_334);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_335);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_336);
    stringBuffer.append(PageHelper.getWinHeight(uml2Class));
    stringBuffer.append(TEXT_337);
    stringBuffer.append(propertyCapConmentName);
    stringBuffer.append(TEXT_338);
    	}
    stringBuffer.append(TEXT_339);
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
    stringBuffer.append(TEXT_340);
    stringBuffer.append(propertyCapConmentName);
    stringBuffer.append(TEXT_341);
    stringBuffer.append(propertyCapConmentName);
    stringBuffer.append(TEXT_342);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_343);
    stringBuffer.append(relPropertyCheckboxs);
    stringBuffer.append(TEXT_344);
    stringBuffer.append(propertyCapConmentName);
    stringBuffer.append(TEXT_345);
    		}
    		if (ViewInputHelper.isApplyM2MCheckboxsTreeTab(property)) {//M2OSelectPage
    			String relPropertyShowCheckTreeJson=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relShowCheckTreeJson);
    stringBuffer.append(TEXT_346);
    stringBuffer.append(propertyCapConmentName);
    stringBuffer.append(TEXT_347);
    stringBuffer.append(propertyCapConmentName);
    stringBuffer.append(TEXT_348);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_349);
    stringBuffer.append(relPropertyShowCheckTreeJson);
    stringBuffer.append(TEXT_350);
    stringBuffer.append(propertyCapConmentName);
    stringBuffer.append(TEXT_351);
    		}
    	}
    stringBuffer.append(TEXT_352);
    }
    stringBuffer.append(TEXT_353);
    }
    else{//只应用了Entity
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

    stringBuffer.append(TEXT_354);
    stringBuffer.append(jspScriptStart);
    stringBuffer.append(TEXT_355);
    stringBuffer.append(jspScriptEnd);
    stringBuffer.append(TEXT_356);
    stringBuffer.append(jspScriptStart);
    stringBuffer.append(TEXT_357);
    stringBuffer.append(jspScriptEnd);
    stringBuffer.append(TEXT_358);
    stringBuffer.append(modelCommentName);
    stringBuffer.append(TEXT_359);
    stringBuffer.append(TEXT_360);
    stringBuffer.append(jspScriptStart);
    stringBuffer.append(TEXT_361);
    stringBuffer.append(jspScriptEnd);
    stringBuffer.append(TEXT_362);
    stringBuffer.append(Config.web_resources_js_include);
    stringBuffer.append(TEXT_363);
    if(needm2oAndO2OComboGrid){
    stringBuffer.append(TEXT_364);
    }
    if(m2oAndO2OSelectTree){
    stringBuffer.append(TEXT_365);
    }
    stringBuffer.append(TEXT_366);
    if(needFck){
    stringBuffer.append(TEXT_367);
    }
    if(needm2oAndO2OComboGrid){
    stringBuffer.append(TEXT_368);
    }
    if(m2oAndO2OSelectTree){
    stringBuffer.append(TEXT_369);
    }
    stringBuffer.append(TEXT_370);
    stringBuffer.append(modelInputJsPath);
    stringBuffer.append(TEXT_371);
    List<Property> tabsList=ViewInputHelper.getTabsProperty(uml2Class);
    if(!tabsList.isEmpty()||!contentTabPropertyList.isEmpty()){
    stringBuffer.append(TEXT_372);
    }
    stringBuffer.append(TEXT_373);
    Property idProperty=EntityHelper.getIDProperty(uml2Class);
    String idPropertyUncapSafeName=NameHelper.uncapSafeName(idProperty);
    if(EntityHelper.isIDAuto(idProperty)||EntityHelper.isIDUUID(idProperty)){
    	//if(!ViewInputHelper.isViewInput(idProperty)){
    stringBuffer.append(TEXT_374);
    stringBuffer.append(idPropertyUncapSafeName);
    stringBuffer.append(TEXT_375);
    stringBuffer.append(idPropertyUncapSafeName);
    stringBuffer.append(TEXT_376);
    	//}
    }
    stringBuffer.append(TEXT_377);
    
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
    stringBuffer.append(TEXT_378);
    			}
    stringBuffer.append(TEXT_379);
    			if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_380);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_381);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    			}
    stringBuffer.append(TEXT_382);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_383);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_384);
    stringBuffer.append(NameHelper.uncapSafeName(idProperty));
    stringBuffer.append(TEXT_385);
    			tdCount+=needTd;
    stringBuffer.append(TEXT_386);
    			if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_387);
    			}
    stringBuffer.append(TEXT_388);
    		}
    	}else if(EntityHelper.isIDAssign(idProperty)){
 		String propertyCommentName=TypeHelper.getDocumentationOrName(idProperty);
 		String propertyUncapSafeName=NameHelper.uncapSafeName(idProperty);
 		String propertyStyleClass=ViewInputHelper.getStyleClass(idProperty);

    			if(tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_389);
    			}
    stringBuffer.append(TEXT_390);
    				needTd=2>trIncludeTd?trIncludeTd:2;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_391);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_392);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    stringBuffer.append(TEXT_393);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_394);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_395);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_396);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_397);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_398);
    stringBuffer.append(propertyStyleClass);
    stringBuffer.append(TEXT_399);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_400);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_401);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_402);
    stringBuffer.append(propertyStyleClass);
    stringBuffer.append(TEXT_403);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_404);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_405);
    				}
    stringBuffer.append(TEXT_406);
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
    stringBuffer.append(TEXT_407);
    			}
    stringBuffer.append(TEXT_408);
    	/********process parentId Property start********/
    			if (TreeStereotypeHelper.isParentIdProperty(property)) {// text
    				needTd=2>trIncludeTd?trIncludeTd:2;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_409);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_410);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    stringBuffer.append(TEXT_411);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_412);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_413);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_414);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_415);
    if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_416);
    }
    stringBuffer.append(TEXT_417);
    if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_418);
    }
    stringBuffer.append(TEXT_419);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_420);
    				}
    stringBuffer.append(TEXT_421);
    				continue;
    			}
    	/********process parentId Property end********/
    	/********process text********/
    			if (ViewInputHelper.isViewInputText(property)) {// text
    				needTd=2>trIncludeTd?trIncludeTd:2;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_422);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_423);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    stringBuffer.append(TEXT_424);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_425);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_426);
    				if(	ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_427);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_428);
    				}else{
    stringBuffer.append(TEXT_429);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_430);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_431);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_432);
    stringBuffer.append(propertyStyleClass);
    stringBuffer.append(TEXT_433);
    				}
    stringBuffer.append(TEXT_434);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_435);
    				}
    stringBuffer.append(TEXT_436);
    				continue;
    			}
    	/********process title********/
    			if (ViewInputHelper.isViewInputTitle(property)) {// title
    				needTd=4>trIncludeTd?trIncludeTd:4;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_437);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_438);
    					tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    stringBuffer.append(TEXT_439);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_440);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_441);
    if(						ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_442);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_443);
    							}else{
    stringBuffer.append(TEXT_444);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_445);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_446);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_447);
    stringBuffer.append(propertyStyleClass);
    stringBuffer.append(TEXT_448);
    if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_449);
    }
    stringBuffer.append(TEXT_450);
    							}
    stringBuffer.append(TEXT_451);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_452);
    				}
    stringBuffer.append(TEXT_453);
    				continue;
    			}
    	/********process select********/
    			if (ViewInputHelper.isViewInputSelect(property)) {// select
    				needTd=2>trIncludeTd?trIncludeTd:2;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_454);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_455);
    					tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    stringBuffer.append(TEXT_456);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_457);
    				Enumeration enumeration=EnumKindHelper.getAppliedEnumKindEnumeration(property);
    				if(null!=enumeration){
    					//String modelEnumQualifiedName=MdaHelper.getModelQualifiedName(enumeration,PKGSuffix.enumeration,ModelNameSuffix.enumeration);
    					//String modelEnumName=MdaHelper.getModelClassName(enumeration,ModelNameSuffix.enumeration);
    					String modelEnumSelectHtml=NamedUtil.getPropertyNamed(enumeration,PropertyNamedRuleKind.selectHtml);
    stringBuffer.append(TEXT_458);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_459);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_460);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_461);
    stringBuffer.append(propertyStyleClass);
    stringBuffer.append(TEXT_462);
    if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_463);
    }
    stringBuffer.append(TEXT_464);
    if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_465);
    }
    stringBuffer.append(TEXT_466);
    stringBuffer.append(modelEnumSelectHtml);
    stringBuffer.append(TEXT_467);
    				}else{
    stringBuffer.append(TEXT_468);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_469);
    if(						ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_470);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_471);
    							}else{
    stringBuffer.append(TEXT_472);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_473);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_474);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_475);
    stringBuffer.append(propertyStyleClass);
    stringBuffer.append(TEXT_476);
    if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_477);
    }
    stringBuffer.append(TEXT_478);
    							}
    stringBuffer.append(TEXT_479);
    				}
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_480);
    				}
    stringBuffer.append(TEXT_481);
    				continue;
    			}
    stringBuffer.append(TEXT_482);
    	/********process radio********/
    stringBuffer.append(TEXT_483);
    			if (ViewInputHelper.isViewInputRadio(property)) {// radio
    				needTd=4>trIncludeTd?trIncludeTd:4;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_484);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_485);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    stringBuffer.append(TEXT_486);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_487);
    				Enumeration enumeration=EnumKindHelper.getAppliedEnumKindEnumeration(property);
    				if(null!=enumeration){
    						String propertyRadioGroup=NamedUtil.getPropertyNamed(enumeration,PropertyNamedRuleKind.inputRadioGroup);
    stringBuffer.append(TEXT_488);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_489);
    stringBuffer.append(propertyRadioGroup);
    stringBuffer.append(TEXT_490);
    				}else{
    stringBuffer.append(TEXT_491);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_492);
    if(						ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_493);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_494);
    							}else{
    stringBuffer.append(TEXT_495);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_496);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_497);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_498);
    stringBuffer.append(propertyStyleClass);
    stringBuffer.append(TEXT_499);
    if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_500);
    }
    stringBuffer.append(TEXT_501);
    							}
    stringBuffer.append(TEXT_502);
    				}
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_503);
    				}
    stringBuffer.append(TEXT_504);
    				continue;
    			}
    	/********process datePicker********/
    			if (ViewInputHelper.isViewInputDatePicker(property)) {// datePicker
    				//String propertyToDateTimeCapName=PropertyNamedRuleKind.dateToDateTimeStr.getRuleCapNamed(property);
    				String propertyToDateTimeUncapName=PropertyNamedRuleKind.dateToDateTimeStr.getRuleUnCapNamed(property);
    				needTd=2>trIncludeTd?trIncludeTd:2;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_505);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_506);
    					tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    stringBuffer.append(TEXT_507);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_508);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_509);
    				if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_510);
    stringBuffer.append(propertyToDateTimeUncapName);
    stringBuffer.append(TEXT_511);
    							}else{
    stringBuffer.append(TEXT_512);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_513);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_514);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_515);
    stringBuffer.append(propertyStyleClass);
    stringBuffer.append(TEXT_516);
    if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_517);
    }
    stringBuffer.append(TEXT_518);
    							}
    stringBuffer.append(TEXT_519);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_520);
    				}
    stringBuffer.append(TEXT_521);
    				continue;
    				}
    	/********process texttarea********/
    			if (ViewInputHelper.isViewInputTextarea(property)) {// texttarea 
    				needTd=4>trIncludeTd?trIncludeTd:4;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_522);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_523);
    					tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    stringBuffer.append(TEXT_524);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_525);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_526);
    if(						ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_527);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_528);
    							}else{
    stringBuffer.append(TEXT_529);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_530);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_531);
    stringBuffer.append(propertyStyleClass);
    stringBuffer.append(TEXT_532);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_533);
    							}
    stringBuffer.append(TEXT_534);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_535);
    				}
    stringBuffer.append(TEXT_536);
    				continue;
    			}	
    stringBuffer.append(TEXT_537);
    	/********process checkbox********/
    			if (ViewInputHelper.isViewInputCheckbox(property)) {// checkbox
    				needTd=4>trIncludeTd?trIncludeTd:4;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_538);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_539);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    stringBuffer.append(TEXT_540);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_541);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_542);
    if(						ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_543);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_544);
    							}else{
    stringBuffer.append(TEXT_545);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_546);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_547);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_548);
    stringBuffer.append(propertyStyleClass);
    stringBuffer.append(TEXT_549);
    							}
    stringBuffer.append(TEXT_550);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_551);
    				}
    stringBuffer.append(TEXT_552);
    				continue;
    			}
    stringBuffer.append(TEXT_553);
    	/********process file********/
    stringBuffer.append(TEXT_554);
    			if (FileStereotypeHelper.isProperty_File(property)) {// file
    				needTd=4>trIncludeTd?trIncludeTd:4;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_555);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_556);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    stringBuffer.append(TEXT_557);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_558);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_559);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_560);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_561);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_562);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_563);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_564);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_565);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_566);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_567);
    stringBuffer.append(idPropertyUncapSafeName);
    stringBuffer.append(TEXT_568);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_569);
    				}
    stringBuffer.append(TEXT_570);
    				continue;
    			}		
    	/********process image********/
    stringBuffer.append(TEXT_571);
    			if (FileStereotypeHelper.isProperty_Image(property)) {// image
    				needTd=4>trIncludeTd?trIncludeTd:4;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_572);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_573);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    stringBuffer.append(TEXT_574);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_575);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_576);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_577);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_578);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_579);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_580);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_581);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_582);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_583);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_584);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_585);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_586);
    stringBuffer.append(idPropertyUncapSafeName);
    stringBuffer.append(TEXT_587);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_588);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_589);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_590);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_591);
    				}
    stringBuffer.append(TEXT_592);
    				continue;
    			}
    	/********process content********/
    stringBuffer.append(TEXT_593);
    //			if (ViewInputHelper.isViewInputContent(property)) {// content
    //			}
    
/*****************************************************************
 * process rel 
/*****************************************************************/

    /********process M2OSelect********/
    stringBuffer.append(TEXT_594);
    			if (ViewInputHelper.isApplyM2OSelect(property)) {//M2OSelect
    				Class propertyType = (Class) property.getType();
    				String propertyTypeComment = TypeHelper.getDocumentationOrName(propertyType);
     				Property propertyTypeIdProperty=EntityHelper.getIDProperty(propertyType);
     				String propertyTypeIdPropertyUncapSafeName=NameHelper.uncapSafeName(propertyTypeIdProperty);
     				String listLabelPropertyUncapSafeName=ViewListHelper.getViewListLabelRelPropertyName(property);
    				needTd=2>trIncludeTd?trIncludeTd:2;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_595);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_596);
    					tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    				//String m2oSelectHtml=NamedUtil.getPropertyNamed(property,PropertyNamedRuleKind.selectHtml);
    stringBuffer.append(TEXT_597);
    stringBuffer.append(propertyTypeComment);
    stringBuffer.append(TEXT_598);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_599);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_600);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_601);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_602);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_603);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_604);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_605);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_606);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_607);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_608);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_609);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_610);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_611);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_612);
    				}
    stringBuffer.append(TEXT_613);
    				continue;
    			}	
    stringBuffer.append(TEXT_614);
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
    stringBuffer.append(TEXT_615);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_616);
    					tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    stringBuffer.append(TEXT_617);
    stringBuffer.append(propertyTypeComment);
    stringBuffer.append(listLabelPropertyComment);
    stringBuffer.append(TEXT_618);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_619);
    							if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_620);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_621);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_622);
    							}else{
    stringBuffer.append(TEXT_623);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_624);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_625);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_626);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_627);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_628);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_629);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_630);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_631);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_632);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_633);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_634);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_635);
    stringBuffer.append(relM2OAndO2OSelectPage);
    stringBuffer.append(TEXT_636);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_637);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_638);
    							}
    stringBuffer.append(TEXT_639);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_640);
    				}
    stringBuffer.append(TEXT_641);
    				continue;
    			}
    stringBuffer.append(TEXT_642);
    	/********process O2OSelect********/
    			if (ViewInputHelper.isApplyO2OSelect(property)) {//O2OSelect
    stringBuffer.append(TEXT_643);
    				Class propertyType = (Class) property.getType();
    				String propertyTypeComment = TypeHelper.getDocumentationOrName(propertyType);
     				Property propertyTypeIdProperty=EntityHelper.getIDProperty(propertyType);
     				String propertyTypeIdPropertyUncapSafeName=NameHelper.uncapSafeName(propertyTypeIdProperty);
     				String listLabelPropertyUncapSafeName=ViewListHelper.getViewListLabelRelPropertyName(property);
    				needTd=2>trIncludeTd?trIncludeTd:2;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_644);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_645);
    					tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    				String O2OSelectHtml=NamedUtil.getPropertyNamed(property,PropertyNamedRuleKind.selectHtml);
    stringBuffer.append(TEXT_646);
    stringBuffer.append(propertyTypeComment);
    stringBuffer.append(TEXT_647);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_648);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_649);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_650);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_651);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_652);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_653);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_654);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_655);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_656);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_657);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_658);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_659);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_660);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_661);
    				}
    stringBuffer.append(TEXT_662);
    				continue;
    			}	
    stringBuffer.append(TEXT_663);
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
    stringBuffer.append(TEXT_664);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_665);
    					tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    stringBuffer.append(TEXT_666);
    stringBuffer.append(propertyTypeComment);
    stringBuffer.append(listLabelPropertyComment);
    stringBuffer.append(TEXT_667);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_668);
    							if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_669);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_670);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_671);
    							}else{
    stringBuffer.append(TEXT_672);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_673);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_674);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_675);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_676);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_677);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_678);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_679);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_680);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_681);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_682);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_683);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_684);
    stringBuffer.append(relM2OAndO2OSelectPage);
    stringBuffer.append(TEXT_685);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_686);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_687);
    							}
    stringBuffer.append(TEXT_688);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_689);
    				}
    stringBuffer.append(TEXT_690);
    				continue;
    			}
    stringBuffer.append(TEXT_691);
    	}
    	if (tdCount%trIncludeTd!=0){
    stringBuffer.append(TEXT_692);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_693);
    	}
    
	/*****************************************************************
	 * property simple input end
	/*****************************************************************/

    stringBuffer.append(TEXT_694);
    
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
    stringBuffer.append(TEXT_695);
    stringBuffer.append(trIncludeTd);
    stringBuffer.append(TEXT_696);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_697);
    stringBuffer.append(relPropertyCheckboxs);
    stringBuffer.append(TEXT_698);
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
    stringBuffer.append(TEXT_699);
    stringBuffer.append(trIncludeTd);
    stringBuffer.append(TEXT_700);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_701);
    stringBuffer.append(relPropertyCheckTreeDomId);
    stringBuffer.append(TEXT_702);
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
    stringBuffer.append(TEXT_703);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_704);
    if(trIncludeTd-1>1){
    stringBuffer.append(TEXT_705);
    stringBuffer.append(trIncludeTd-1);
    stringBuffer.append(TEXT_706);
    }
    stringBuffer.append(TEXT_707);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_708);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_709);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_710);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_711);
    		}
    }*/
    /********process file properties********/
    List<Property> filePropertyList=ViewInputHelper.getViewInputFile(uml2Class);
    if(null!=filePropertyList&&filePropertyList.size()>0){
    	for(Property property:filePropertyList){
     			String propertyCommentName=TypeHelper.getDocumentationOrName(property);
     			String propertyUncapSafeName=NameHelper.uncapSafeName(property);
     			//String propertyStyleClass=ViewInputHelper.getStyleClass(property);
    stringBuffer.append(TEXT_712);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_713);
    if(trIncludeTd-1>1){
    stringBuffer.append(TEXT_714);
    stringBuffer.append(trIncludeTd-1);
    stringBuffer.append(TEXT_715);
    }
    stringBuffer.append(TEXT_716);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_717);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_718);
    	}
    }
    /********process content properties********/
    if(null!=contentPropertyList&&contentPropertyList.size()>0){
    for(Property property:contentPropertyList){
     			String propertyCommentName=TypeHelper.getDocumentationOrName(property);
     			String propertyUncapSafeName=NameHelper.uncapSafeName(property);
     			//String propertyStyleClass=ViewInputHelper.getStyleClass(property);
    stringBuffer.append(TEXT_719);
    stringBuffer.append(trIncludeTd);
    stringBuffer.append(TEXT_720);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_721);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_722);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_723);
    stringBuffer.append(NameHelper.getUncapName(property));
    stringBuffer.append(TEXT_724);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_725);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_726);
    }}
    stringBuffer.append(TEXT_727);
    if(!tabsList.isEmpty()||!contentTabPropertyList.isEmpty()){
    stringBuffer.append(TEXT_728);
    	for(Iterator<Property> iter=contentTabPropertyList.iterator();iter.hasNext();){
    			Property property=iter.next();
     			String propertyCommentName=TypeHelper.getDocumentationOrName(property);
     			String propertyUncapSafeName=NameHelper.uncapSafeName(property);
     			//String propertyStyleClass=ViewInputHelper.getStyleClass(property);
    			String propertyCapConmentName=TypeHelper.getDocumentationOrName(property);
    stringBuffer.append(TEXT_729);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_730);
    stringBuffer.append(propertyCapConmentName);
    stringBuffer.append(TEXT_731);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_732);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_733);
    stringBuffer.append(NameHelper.getUncapName(property));
    stringBuffer.append(TEXT_734);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_735);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_736);
    stringBuffer.append(PageHelper.getWinHeight(uml2Class));
    stringBuffer.append(TEXT_737);
    stringBuffer.append(propertyCapConmentName);
    stringBuffer.append(TEXT_738);
    	}
    stringBuffer.append(TEXT_739);
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
    stringBuffer.append(TEXT_740);
    stringBuffer.append(propertyCapConmentName);
    stringBuffer.append(TEXT_741);
    stringBuffer.append(propertyCapConmentName);
    stringBuffer.append(TEXT_742);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_743);
    stringBuffer.append(relPropertyCheckboxs);
    stringBuffer.append(TEXT_744);
    stringBuffer.append(propertyCapConmentName);
    stringBuffer.append(TEXT_745);
    		}
    		if (ViewInputHelper.isApplyM2MCheckboxsTreeTab(property)) {//M2OSelectPage
    			String relPropertyShowCheckTreeJson=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relShowCheckTreeJson);
    stringBuffer.append(TEXT_746);
    stringBuffer.append(propertyCapConmentName);
    stringBuffer.append(TEXT_747);
    stringBuffer.append(propertyCapConmentName);
    stringBuffer.append(TEXT_748);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_749);
    stringBuffer.append(relPropertyShowCheckTreeJson);
    stringBuffer.append(TEXT_750);
    stringBuffer.append(propertyCapConmentName);
    stringBuffer.append(TEXT_751);
    		}
    	}
    stringBuffer.append(TEXT_752);
    }
    stringBuffer.append(TEXT_753);
    }
    stringBuffer.append(TEXT_754);
    return stringBuffer.toString();
  }
}
