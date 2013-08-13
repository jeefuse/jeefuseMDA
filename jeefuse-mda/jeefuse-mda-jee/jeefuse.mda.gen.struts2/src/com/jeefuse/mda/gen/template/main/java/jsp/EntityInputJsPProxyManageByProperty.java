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

public class EntityInputJsPProxyManageByProperty
{
  protected static String nl;
  public static synchronized EntityInputJsPProxyManageByProperty create(String lineSeparator)
  {
    nl = lineSeparator;
    EntityInputJsPProxyManageByProperty result = new EntityInputJsPProxyManageByProperty();
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
  protected final String TEXT_24 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label class=\"requied\">";
  protected final String TEXT_25 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_26 = "\">" + NL + "\t\t      \t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_27 = "Id\" name=\"";
  protected final String TEXT_28 = ".";
  protected final String TEXT_29 = "\" value=\"${model.";
  protected final String TEXT_30 = ".";
  protected final String TEXT_31 = "}\" class=\"text\" readonly=\"readonly\"/>" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_32 = "\t";
  protected final String TEXT_33 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_34 = NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_35 = "\t";
  protected final String TEXT_36 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_37 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_38 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_39 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_40 = "\">" + NL + "\t\t      \t\t\t\t${mo.";
  protected final String TEXT_41 = "}" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_42 = "\t";
  protected final String TEXT_43 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_44 = "\t\t\t\t\t\t";
  protected final String TEXT_45 = NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_46 = "\t";
  protected final String TEXT_47 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_48 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_49 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_50 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_51 = "\">" + NL + "\t\t      \t\t\t\t<c:choose>" + NL + "\t\t\t\t\t\t  \t \t<c:when test=\"${null==model.id}\">" + NL + "\t\t\t\t\t\t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_52 = "\" name=\"";
  protected final String TEXT_53 = "\" value=\"${mo.";
  protected final String TEXT_54 = "}\" class=\"";
  protected final String TEXT_55 = "\"/>" + NL + "\t\t\t\t\t\t \t    </c:when>" + NL + "\t\t\t\t\t\t   \t    <c:otherwise>" + NL + "\t\t\t\t\t\t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_56 = "\" name=\"";
  protected final String TEXT_57 = "\" value=\"${mo.";
  protected final String TEXT_58 = "}\" class=\"";
  protected final String TEXT_59 = " readonly\" readonly='readonly' />" + NL + "\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"oldId\" name=\"oldId\" value=\"${mo.";
  protected final String TEXT_60 = "}\"/>" + NL + "\t\t\t\t\t\t\t    </c:otherwise>" + NL + "\t\t\t\t\t\t\t</c:choose> " + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_61 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_62 = "\t\t\t\t\t\t";
  protected final String TEXT_63 = NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_64 = "\t";
  protected final String TEXT_65 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_66 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_67 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_68 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_69 = "\">" + NL + "\t\t\t\t\t\t\t <select name=\"";
  protected final String TEXT_70 = "\" id=\"";
  protected final String TEXT_71 = "\" class=\"text ";
  protected final String TEXT_72 = "readonly";
  protected final String TEXT_73 = "\" ";
  protected final String TEXT_74 = "readonly=\"readonly\"";
  protected final String TEXT_75 = ">" + NL + "\t\t\t\t\t\t\t     <option value=\"\" >无</option>" + NL + "\t\t\t\t\t\t\t     <s:property value=\"htmlSelectTree\" escape=\"false\"/>" + NL + "\t\t\t\t\t\t\t  </select>" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_76 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_77 = "\t\t\t\t\t\t";
  protected final String TEXT_78 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_79 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_80 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_81 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_82 = "\">";
  protected final String TEXT_83 = NL + "\t\t      \t\t\t\t${mo.";
  protected final String TEXT_84 = "}";
  protected final String TEXT_85 = NL + "\t\t      \t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_86 = "\" name=\"";
  protected final String TEXT_87 = "\" value=\"${mo.";
  protected final String TEXT_88 = "}\" class=\"";
  protected final String TEXT_89 = "\" />";
  protected final String TEXT_90 = NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_91 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_92 = "\t\t\t\t\t\t";
  protected final String TEXT_93 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_94 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_95 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_96 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_97 = "\">";
  protected final String TEXT_98 = NL + "\t\t      \t\t\t\t\t${mo.";
  protected final String TEXT_99 = "}";
  protected final String TEXT_100 = NL + "\t\t      \t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_101 = "\" name=\"";
  protected final String TEXT_102 = "\" value=\"${mo.";
  protected final String TEXT_103 = "}\" class=\"";
  protected final String TEXT_104 = "\" ";
  protected final String TEXT_105 = "readonly=\"readonly\"";
  protected final String TEXT_106 = "/>";
  protected final String TEXT_107 = "\t\t\t\t\t\t\t" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_108 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_109 = "\t\t\t\t\t\t";
  protected final String TEXT_110 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_111 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_112 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_113 = ":</label>" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_114 = NL + "\t\t\t\t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_115 = "\">" + NL + "\t\t\t\t\t\t\t <select  id=\"";
  protected final String TEXT_116 = "\" name=\"";
  protected final String TEXT_117 = "\" class=\"";
  protected final String TEXT_118 = " class=\"text ";
  protected final String TEXT_119 = "readonly";
  protected final String TEXT_120 = "\" ";
  protected final String TEXT_121 = "readonly=\"readonly\"";
  protected final String TEXT_122 = ">" + NL + "\t\t\t\t\t\t\t     <s:property value=\"";
  protected final String TEXT_123 = "\" escape=\"false\"/>" + NL + "\t\t\t\t\t\t\t </select>" + NL + "\t\t\t\t\t\t</td>";
  protected final String TEXT_124 = NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_125 = "\">";
  protected final String TEXT_126 = NL + "\t\t      \t\t\t\t\t${mo.";
  protected final String TEXT_127 = "}";
  protected final String TEXT_128 = NL + "\t\t      \t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_129 = "\" name=\"";
  protected final String TEXT_130 = "\" value=\"${mo.";
  protected final String TEXT_131 = "}\" class=\"";
  protected final String TEXT_132 = "\" ";
  protected final String TEXT_133 = "readonly=\"readonly\"";
  protected final String TEXT_134 = "/>";
  protected final String TEXT_135 = "\t" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_136 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_137 = "\t\t\t\t\t\t";
  protected final String TEXT_138 = "\t";
  protected final String TEXT_139 = "\t";
  protected final String TEXT_140 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_141 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_142 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_143 = ":</label>" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_144 = NL + "\t\t\t\t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_145 = "\">" + NL + "\t\t\t\t\t\t\t ${";
  protected final String TEXT_146 = "}" + NL + "\t\t\t\t\t\t</td>";
  protected final String TEXT_147 = NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_148 = "\">";
  protected final String TEXT_149 = NL + "\t\t      \t\t\t\t\t${mo.";
  protected final String TEXT_150 = "}";
  protected final String TEXT_151 = NL + "\t\t      \t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_152 = "\" name=\"";
  protected final String TEXT_153 = "\" value=\"${mo.";
  protected final String TEXT_154 = "}\" class=\"";
  protected final String TEXT_155 = "\" ";
  protected final String TEXT_156 = "readonly=\"readonly\"";
  protected final String TEXT_157 = "/>";
  protected final String TEXT_158 = "\t" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_159 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_160 = "\t\t\t\t\t\t";
  protected final String TEXT_161 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_162 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_163 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_164 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_165 = "\">";
  protected final String TEXT_166 = NL + "\t\t      \t\t\t\t\t${mo.";
  protected final String TEXT_167 = "}";
  protected final String TEXT_168 = NL + "\t\t      \t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_169 = "\" name=\"";
  protected final String TEXT_170 = "\" value=\"${mo.";
  protected final String TEXT_171 = "}\" class=\"";
  protected final String TEXT_172 = "\" ";
  protected final String TEXT_173 = "readonly=\"readonly\"";
  protected final String TEXT_174 = "/>";
  protected final String TEXT_175 = "\t" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_176 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_177 = "\t\t\t\t\t\t";
  protected final String TEXT_178 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_179 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_180 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_181 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_182 = "\">";
  protected final String TEXT_183 = NL + "\t\t      \t\t\t\t\t${mo.";
  protected final String TEXT_184 = "}";
  protected final String TEXT_185 = NL + "\t\t      \t\t\t\t<textarea id=\"";
  protected final String TEXT_186 = "\" name=\"";
  protected final String TEXT_187 = "\"  class=\"";
  protected final String TEXT_188 = "\" >${mo.";
  protected final String TEXT_189 = "}</textarea>";
  protected final String TEXT_190 = "\t" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_191 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_192 = "\t\t\t\t\t\t";
  protected final String TEXT_193 = "\t\t";
  protected final String TEXT_194 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_195 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_196 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_197 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_198 = "\">";
  protected final String TEXT_199 = NL + "\t\t      \t\t\t\t\t${mo.";
  protected final String TEXT_200 = "}";
  protected final String TEXT_201 = NL + "\t\t      \t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_202 = "\" name=\"";
  protected final String TEXT_203 = "\" value=\"${mo.";
  protected final String TEXT_204 = "}\" class=\"";
  protected final String TEXT_205 = "\" />";
  protected final String TEXT_206 = "\t\t\t      \t\t" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_207 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_208 = "\t\t\t\t\t\t";
  protected final String TEXT_209 = "\t\t";
  protected final String TEXT_210 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_211 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_212 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_213 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t\t\t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_214 = "\">" + NL + "\t\t\t\t\t\t\t <select  id=\"";
  protected final String TEXT_215 = "_";
  protected final String TEXT_216 = "\" name=\"";
  protected final String TEXT_217 = ".";
  protected final String TEXT_218 = "\" ";
  protected final String TEXT_219 = "readonly=\"readonly\"";
  protected final String TEXT_220 = ">" + NL + "\t\t\t\t\t\t\t     <s:property value=\"";
  protected final String TEXT_221 = "\" escape=\"false\"/>" + NL + "\t\t\t\t\t\t\t </select>" + NL + "\t\t\t\t\t\t</td>";
  protected final String TEXT_222 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_223 = "\t\t\t\t\t\t";
  protected final String TEXT_224 = "\t";
  protected final String TEXT_225 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_226 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_227 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_228 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t\t\t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_229 = "\">";
  protected final String TEXT_230 = NL + "\t\t      \t\t\t\t\t${mo.";
  protected final String TEXT_231 = ".";
  protected final String TEXT_232 = "}";
  protected final String TEXT_233 = NL + "\t\t\t\t\t\t\t <input type=\"text\" id=\"";
  protected final String TEXT_234 = "_";
  protected final String TEXT_235 = "\" name=\"";
  protected final String TEXT_236 = ".";
  protected final String TEXT_237 = "\" value=\"${mo.";
  protected final String TEXT_238 = ".";
  protected final String TEXT_239 = "}\" class=\"";
  protected final String TEXT_240 = "\" ";
  protected final String TEXT_241 = "readonly=\"readonly\"";
  protected final String TEXT_242 = "/>";
  protected final String TEXT_243 = "\t\t" + NL + "\t\t\t\t\t\t</td>";
  protected final String TEXT_244 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_245 = "\t\t\t\t\t\t";
  protected final String TEXT_246 = "\t";
  protected final String TEXT_247 = "\t";
  protected final String TEXT_248 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_249 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_250 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_251 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t\t\t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_252 = "\">" + NL + "\t\t\t\t\t\t\t <select  id=\"";
  protected final String TEXT_253 = "_";
  protected final String TEXT_254 = "\" name=\"";
  protected final String TEXT_255 = ".";
  protected final String TEXT_256 = "\" ";
  protected final String TEXT_257 = "readonly=\"readonly\"";
  protected final String TEXT_258 = ">" + NL + "\t\t\t\t\t\t\t     <s:property value=\"";
  protected final String TEXT_259 = "\" escape=\"false\"/>" + NL + "\t\t\t\t\t\t\t </select>" + NL + "\t\t\t\t\t\t</td>";
  protected final String TEXT_260 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_261 = "\t\t\t\t\t\t";
  protected final String TEXT_262 = "\t";
  protected final String TEXT_263 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_264 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_265 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_266 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t\t\t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_267 = "\">";
  protected final String TEXT_268 = NL + "\t\t      \t\t\t\t\t${mo.";
  protected final String TEXT_269 = ".";
  protected final String TEXT_270 = "}";
  protected final String TEXT_271 = NL + "\t\t\t\t\t\t\t <input type=\"text\" id=\"";
  protected final String TEXT_272 = "_";
  protected final String TEXT_273 = "\" name=\"";
  protected final String TEXT_274 = ".";
  protected final String TEXT_275 = "\" value=\"${mo.";
  protected final String TEXT_276 = ".";
  protected final String TEXT_277 = "}\" class=\"";
  protected final String TEXT_278 = "\" ";
  protected final String TEXT_279 = "readonly=\"readonly\"";
  protected final String TEXT_280 = "/>";
  protected final String TEXT_281 = "\t" + NL + "\t\t\t\t\t\t</td>";
  protected final String TEXT_282 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_283 = "\t\t\t\t\t\t";
  protected final String TEXT_284 = "\t";
  protected final String TEXT_285 = "\t" + NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_286 = "\"></td>" + NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_287 = "\t";
  protected final String TEXT_288 = NL + "\t\t\t\t\t<tr>" + NL + "\t\t      \t\t\t<td colspan=\"";
  protected final String TEXT_289 = "\">" + NL + "\t\t      \t\t\t\t<div class=\"v-fieldset-wrap\">" + NL + "\t\t\t      \t\t\t\t<fieldset>" + NL + "\t\t\t\t\t              <legend>" + NL + "\t\t\t\t\t                 \t";
  protected final String TEXT_290 = ":" + NL + "\t\t\t\t\t              </legend>" + NL + "\t\t\t\t\t              <div class=\"v-fieldset-content\">" + NL + "\t\t\t\t\t                \t${";
  protected final String TEXT_291 = "}" + NL + "\t\t\t\t\t\t\t      </div>" + NL + "\t\t\t\t\t            </fieldset>" + NL + "\t\t      \t\t\t\t</div>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t</tr>";
  protected final String TEXT_292 = NL + "\t\t\t\t\t<tr>" + NL + "\t\t      \t\t\t<td colspan=\"";
  protected final String TEXT_293 = "\">" + NL + "\t\t      \t\t\t\t<div class=\"v-tree-wrap\">" + NL + "\t\t\t\t\t\t\t\t<div class=\"v-title\">";
  protected final String TEXT_294 = "：</div>" + NL + "\t\t\t\t\t\t\t\t<div class=\"v-content\" id=\"";
  protected final String TEXT_295 = "\" style=\"height:270px; width:350px; overflow: auto;\">" + NL + "\t\t\t\t\t\t\t\t</div>" + NL + "\t\t\t\t\t\t\t</div>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t</tr>";
  protected final String TEXT_296 = NL + "\t\t\t\t\t<tr>" + NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_297 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" ";
  protected final String TEXT_298 = "colspan=\"";
  protected final String TEXT_299 = "\"";
  protected final String TEXT_300 = ">" + NL + "\t\t\t \t         \t <input type=\"file\" id=\"uploadImage_";
  protected final String TEXT_301 = "\" name=\"uploadImage_";
  protected final String TEXT_302 = "\" size=\"35\"/><br/>" + NL + "\t\t\t \t         \t <div id=\"previewImageWrap_";
  protected final String TEXT_303 = "\">" + NL + "\t\t\t \t         \t \t<img id=\"previewImage_";
  protected final String TEXT_304 = "\" src=\"\"/>" + NL + "\t\t\t \t         \t </div>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t</tr>";
  protected final String TEXT_305 = NL + "\t\t\t\t\t<tr>" + NL + "\t\t\t\t       <td class=\"label\">" + NL + "\t\t\t\t       \t\t<label>";
  protected final String TEXT_306 = ":</label>" + NL + "\t\t\t\t       </td>" + NL + "\t\t\t\t       <td class=\"field\" ";
  protected final String TEXT_307 = "colspan=\"";
  protected final String TEXT_308 = "\"";
  protected final String TEXT_309 = ">" + NL + "\t\t\t\t\t   \t\t<input type=\"file\" id=\"";
  protected final String TEXT_310 = "\" name=\"";
  protected final String TEXT_311 = "\" size=\"35\" onchange=\"goolov.validete.file(this);\"/>" + NL + "\t\t\t\t   \t   </td>" + NL + "\t\t\t\t   \t</tr>";
  protected final String TEXT_312 = NL + "\t\t\t\t\t<tr>" + NL + "\t\t\t\t\t  <td colspan=\"";
  protected final String TEXT_313 = "\">" + NL + "\t\t\t\t\t  \t<div class=\"v-section-wrap\">" + NL + "\t\t\t\t\t  \t\t<div class=\"v-title\">";
  protected final String TEXT_314 = ":</div>" + NL + "\t\t\t\t\t  \t\t<div class=\"v-content\">" + NL + "\t\t\t\t\t  \t\t\t<input type=\"hidden\" id=\"";
  protected final String TEXT_315 = "\" name=\"";
  protected final String TEXT_316 = "\"/>" + NL + "\t\t\t\t\t  \t\t\t<textarea style=\"width:98%;\"  id=\"fck_";
  protected final String TEXT_317 = "\">" + NL + "\t\t\t\t\t      \t\t  ${mo.";
  protected final String TEXT_318 = "}" + NL + "\t\t\t\t\t   \t\t\t</textarea>" + NL + "\t\t\t\t\t\t\t  \t<script type=\"text/javascript\">" + NL + "\t\t\t\t\t\t             var oFCKeditor = new FCKeditor('fck_";
  protected final String TEXT_319 = "') ; " + NL + "\t\t\t\t\t                 oFCKeditor.BasePath\t= '${ctx}/resources/fckeditor/' ;" + NL + "\t\t\t\t\t                 oFCKeditor.Config[\"CustomConfigurationsPath\"]=\"${ctx}/resources/fckeditor/customConfig.js\";" + NL + "\t\t\t\t\t\t             oFCKeditor.ToolbarSet='goolovEdit';" + NL + "\t\t\t\t\t\t             oFCKeditor.Config[\"TabSpaces\"]=2;" + NL + "\t\t\t\t\t\t             oFCKeditor.Config[\"LinkUpload\"] = false;" + NL + "\t\t\t\t\t\t             oFCKeditor.Config[\"ImageUpload\"] = true;" + NL + "\t\t\t\t\t\t             oFCKeditor.Config[\"FlashUpload\"] = false;" + NL + "\t\t\t\t\t\t             oFCKeditor.Height\t= 350;" + NL + "\t\t\t\t\t                 oFCKeditor.ReplaceTextarea(); " + NL + "\t\t\t\t\t            </script>" + NL + "\t\t\t\t\t          </div>" + NL + "\t\t\t\t\t  \t </div>" + NL + "\t\t\t\t\t  </td>" + NL + "\t\t\t\t   </tr>\t      ";
  protected final String TEXT_320 = NL + "\t\t\t\t\t<tr>\t" + NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>保存路径:</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_321 = "colspan=\"";
  protected final String TEXT_322 = "\"";
  protected final String TEXT_323 = "\">" + NL + "\t\t      \t\t\t\t${mo.";
  protected final String TEXT_324 = "}\t\t\t\t\t\t\t" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>" + NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>文件类型:</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"1\">" + NL + "\t\t      \t\t\t\t${mo.";
  protected final String TEXT_325 = "}\t\t\t\t\t\t" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>大小:</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_326 = "colspan=\"";
  protected final String TEXT_327 = "\"";
  protected final String TEXT_328 = "\">" + NL + "\t\t      \t\t\t\t${mo.";
  protected final String TEXT_329 = "}Byte" + NL + "\t\t      \t\t\t</td>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t</tr>\t\t\t\t\t\t" + NL + "\t\t\t\t\t<tr>\t" + NL + "\t\t      \t\t\t<td colspan=\"";
  protected final String TEXT_330 = "colspan=\"";
  protected final String TEXT_331 = "\"";
  protected final String TEXT_332 = "\">" + NL + "\t\t      \t\t\t\t<div class=\"v-image-wrap\">" + NL + "\t\t\t\t\t\t\t\t<div class='v-title'>图片：</div>" + NL + "\t\t\t\t\t\t\t\t<div class=\"v-image\" style=\"width:85%\">" + NL + "\t\t\t\t\t\t\t\t\t<img src=\"${ctx}/${mo.";
  protected final String TEXT_333 = "}\" alt=\"图片\" />" + NL + "\t\t\t\t\t\t\t\t</div>" + NL + "\t\t\t\t\t\t\t</div>" + NL + "\t\t      \t\t\t</td>\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_334 = NL + "\t\t\t\t\t<tr>\t" + NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>保存路径:</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_335 = "colspan=\"";
  protected final String TEXT_336 = "\"";
  protected final String TEXT_337 = "\">" + NL + "\t\t      \t\t\t\t${mo.";
  protected final String TEXT_338 = "}\t\t\t\t\t\t\t" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>" + NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>文件类型:</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"1\">" + NL + "\t\t      \t\t\t\t${mo.";
  protected final String TEXT_339 = "}\t\t\t\t\t\t" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>大小:</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_340 = "colspan=\"";
  protected final String TEXT_341 = "\"";
  protected final String TEXT_342 = "\">" + NL + "\t\t      \t\t\t\t${mo.";
  protected final String TEXT_343 = "}Byte" + NL + "\t\t      \t\t\t</td>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t</tr>\t\t\t\t\t\t";
  protected final String TEXT_344 = NL + "\t\t\t\t</table>" + NL + "\t\t\t  </form>";
  protected final String TEXT_345 = NL + "\t\t\t</div><!-- tab one end -->";
  protected final String TEXT_346 = NL + "\t  \t\t<div title=\"";
  protected final String TEXT_347 = "\"><!--";
  protected final String TEXT_348 = " tab start-->" + NL + "\t\t  \t\t<div class=\"v-fckeditor\">" + NL + "\t\t  \t\t\t<input type=\"hidden\" id=\"";
  protected final String TEXT_349 = "\" name=\"";
  protected final String TEXT_350 = "\"/>" + NL + "\t\t  \t\t\t<textarea style=\"width: 90%;\"  id=\"fck_";
  protected final String TEXT_351 = "\">" + NL + "\t\t      \t\t  ${mo.";
  protected final String TEXT_352 = "}" + NL + "\t\t   \t\t\t</textarea>" + NL + "\t\t\t\t  \t<script type=\"text/javascript\">" + NL + "\t\t\t             var oFCKeditor = new FCKeditor('fck_";
  protected final String TEXT_353 = "') ; " + NL + "\t\t                 oFCKeditor.BasePath\t= '${ctx}/resources/fckeditor/' ;" + NL + "\t\t                 oFCKeditor.Config[\"CustomConfigurationsPath\"]=\"${ctx}/resources/fckeditor/customConfig.js\";" + NL + "\t\t\t             oFCKeditor.ToolbarSet='goolovEditTab';" + NL + "\t\t\t             oFCKeditor.Config[\"TabSpaces\"]=2;" + NL + "\t\t\t             oFCKeditor.Config[\"LinkUpload\"] = false;" + NL + "\t\t\t             oFCKeditor.Config[\"ImageUpload\"] = true;" + NL + "\t\t\t             oFCKeditor.Config[\"FlashUpload\"] = false;" + NL + "\t\t\t             oFCKeditor.Height\t= ";
  protected final String TEXT_354 = "-130;" + NL + "\t\t                 oFCKeditor.ReplaceTextarea(); " + NL + "\t\t            </script>" + NL + "\t\t          </div>" + NL + "\t\t\t</div><!--";
  protected final String TEXT_355 = " tab end-->";
  protected final String TEXT_356 = "\t\t\t";
  protected final String TEXT_357 = NL + "\t\t\t<div title=\"";
  protected final String TEXT_358 = "\"  class=\"v-tab\"><!--";
  protected final String TEXT_359 = " tab start-->" + NL + "\t\t\t\t<div class=\"v-section-wrap\">" + NL + "\t\t\t\t\t<div class='v-title'>选择";
  protected final String TEXT_360 = "：</div>" + NL + "\t\t\t\t\t<div class=\"v-content\">" + NL + "\t\t\t\t\t\t${";
  protected final String TEXT_361 = "}" + NL + "\t\t\t\t\t</div>" + NL + "\t\t\t\t</div>" + NL + "\t\t\t</div><!--";
  protected final String TEXT_362 = " tab end-->";
  protected final String TEXT_363 = NL + "\t\t\t<div title=\"";
  protected final String TEXT_364 = "\"   class=\"v-tab\"><!--";
  protected final String TEXT_365 = " tab start-->" + NL + "\t\t\t\t\t<div class=\"v-tree-wrap\">" + NL + "\t\t\t\t\t\t<div class=\"v-title\">选择";
  protected final String TEXT_366 = "：</div>" + NL + "\t\t\t\t\t\t<div class=\"v-content\" id=\"";
  protected final String TEXT_367 = "\" style=\"height:270px; width:350px; overflow: auto;\">" + NL + "\t\t\t\t\t\t</div>" + NL + "\t\t\t\t\t</div>" + NL + "\t\t\t</div><!--";
  protected final String TEXT_368 = " tab end-->";
  protected final String TEXT_369 = "\t\t\t\t\t\t" + NL + "\t\t  </div><!-- firstTabs end -->";
  protected final String TEXT_370 = NL + "\t\t</div><!-- center end -->" + NL + "\t\t<div region=\"south\" border=\"false\" style=\"height:50px;\"><!-- south start-->" + NL + "\t\t\t<div class=\"v-buttons\"><!-- v-buttons start -->" + NL + "   \t\t\t\t<a href=\"javascript:editWinUpdateData();\" class=\"easyui-linkbutton\" >更新</a>" + NL + "\t\t\t\t<a href=\"javascript:resetData();\" class=\"easyui-linkbutton\" >重置</a>" + NL + "\t\t\t\t<a href=\"javascript:editWinClose();\" class=\"easyui-linkbutton\" >关闭</a>" + NL + "\t\t\t</div><!-- v-buttons end-->" + NL + "\t\t</div><!--\tsouth end -->" + NL + "</body>" + NL + "</html>";
  protected final String TEXT_371 = NL;
  protected final String TEXT_372 = " page contentType=\"text/html;charset=UTF-8\" ";
  protected final String TEXT_373 = NL;
  protected final String TEXT_374 = " include file=\"/common/taglibs.jsp\" ";
  protected final String TEXT_375 = NL + "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">" + NL + "<html xmlns=\"http://www.w3.org/1999/xhtml\">" + NL + "<head>" + NL + "<title>";
  protected final String TEXT_376 = " 编辑</title>";
  protected final String TEXT_377 = NL;
  protected final String TEXT_378 = " include file=\"/common/meta.jsp\" ";
  protected final String TEXT_379 = NL + "<script src=\"";
  protected final String TEXT_380 = "\" type=\"text/javascript\"></script>" + NL + "<script>" + NL + "\tvar ctx = '${ctx}';" + NL + "\tvar theme = '${theme}';" + NL + "\timportCssFile('sys|ui";
  protected final String TEXT_381 = "|flexiGrid";
  protected final String TEXT_382 = "|treeview";
  protected final String TEXT_383 = "', ctx, theme);" + NL + "\timportJsFile('jquery|ui|common|blockUI|form|validate";
  protected final String TEXT_384 = "|fckeditor";
  protected final String TEXT_385 = "|flexiGrid|comboGrid";
  protected final String TEXT_386 = "|treeview|combotree";
  protected final String TEXT_387 = "', ctx);" + NL + "\timportJsFile('";
  protected final String TEXT_388 = "', ctx);" + NL + "</script>" + NL + "</head>" + NL + "<body class=\"easyui-layout v-container\">" + NL + " \t<div region=\"center\" border=\"false\"><!-- center start -->";
  protected final String TEXT_389 = NL + "\t\t<div id=\"firstTabs\" class=\"v-tabs\"><!-- firstTabs start -->" + NL + "\t\t  <div title=\"基本信息\"  class=\"v-tab\"><!-- tab one  start -->";
  protected final String TEXT_390 = NL + " \t\t\t<form id=\"inputForm\" method=\"post\" class=\"v-form\">";
  protected final String TEXT_391 = NL + " \t\t\t\t<input type=\"hidden\" name=\"";
  protected final String TEXT_392 = "\" value=\"${mo.";
  protected final String TEXT_393 = "}\"/>";
  protected final String TEXT_394 = NL + " \t\t\t\t<!--<div id=\"inputInfo\" class=\"v-state-info\"></div>-->" + NL + "\t\t      \t<table>";
  protected final String TEXT_395 = NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_396 = "\t";
  protected final String TEXT_397 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_398 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_399 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label class=\"requied\">";
  protected final String TEXT_400 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_401 = "\">" + NL + "\t\t      \t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_402 = "Id\" name=\"";
  protected final String TEXT_403 = ".";
  protected final String TEXT_404 = "\" value=\"${mo.";
  protected final String TEXT_405 = ".";
  protected final String TEXT_406 = "}\" class=\"text\" readonly=\"readonly\"/>" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_407 = "\t";
  protected final String TEXT_408 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_409 = "\t";
  protected final String TEXT_410 = NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_411 = "\t";
  protected final String TEXT_412 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_413 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_414 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_415 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_416 = "\">" + NL + "\t\t      \t\t\t\t${mo.";
  protected final String TEXT_417 = "}" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_418 = "\t";
  protected final String TEXT_419 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_420 = "\t\t\t\t\t\t";
  protected final String TEXT_421 = NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_422 = "\t";
  protected final String TEXT_423 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_424 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_425 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_426 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_427 = "\">" + NL + "\t\t      \t\t\t\t<c:choose>" + NL + "\t\t\t\t\t\t  \t \t<c:when test=\"${null==model.id}\">" + NL + "\t\t\t\t\t\t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_428 = "\" name=\"";
  protected final String TEXT_429 = "\" value=\"${mo.";
  protected final String TEXT_430 = "}\" class=\"";
  protected final String TEXT_431 = "\"/>" + NL + "\t\t\t\t\t\t \t    </c:when>" + NL + "\t\t\t\t\t\t   \t    <c:otherwise>" + NL + "\t\t\t\t\t\t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_432 = "\" name=\"";
  protected final String TEXT_433 = "\" value=\"${mo.";
  protected final String TEXT_434 = "}\" class=\"";
  protected final String TEXT_435 = " readonly\" readonly='readonly' />" + NL + "\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"oldId\" name=\"oldId\" value=\"${mo.";
  protected final String TEXT_436 = "}\"/>" + NL + "\t\t\t\t\t\t\t    </c:otherwise>" + NL + "\t\t\t\t\t\t\t</c:choose> " + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_437 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_438 = "\t\t\t\t\t\t";
  protected final String TEXT_439 = NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_440 = "\t";
  protected final String TEXT_441 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_442 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_443 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_444 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_445 = "\">" + NL + "\t\t\t\t\t\t\t <select name=\"";
  protected final String TEXT_446 = "\" id=\"";
  protected final String TEXT_447 = "\" class=\"text ";
  protected final String TEXT_448 = "readonly";
  protected final String TEXT_449 = "\" ";
  protected final String TEXT_450 = "readonly=\"readonly\"";
  protected final String TEXT_451 = ">" + NL + "\t\t\t\t\t\t\t     <option value=\"\" >无</option>" + NL + "\t\t\t\t\t\t\t     <s:property value=\"htmlSelectTree\" escape=\"false\"/>" + NL + "\t\t\t\t\t\t\t  </select>" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_452 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_453 = "\t\t\t\t\t\t";
  protected final String TEXT_454 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_455 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_456 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_457 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_458 = "\">";
  protected final String TEXT_459 = NL + "\t\t      \t\t\t\t${mo.";
  protected final String TEXT_460 = "}";
  protected final String TEXT_461 = NL + "\t\t      \t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_462 = "\" name=\"";
  protected final String TEXT_463 = "\" value=\"${mo.";
  protected final String TEXT_464 = "}\" class=\"";
  protected final String TEXT_465 = "\" />";
  protected final String TEXT_466 = NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_467 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_468 = "\t\t\t\t\t\t";
  protected final String TEXT_469 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_470 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_471 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_472 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_473 = "\">";
  protected final String TEXT_474 = NL + "\t\t      \t\t\t\t\t${mo.";
  protected final String TEXT_475 = "}";
  protected final String TEXT_476 = NL + "\t\t      \t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_477 = "\" name=\"";
  protected final String TEXT_478 = "\" value=\"${mo.";
  protected final String TEXT_479 = "}\" class=\"";
  protected final String TEXT_480 = "\" ";
  protected final String TEXT_481 = "readonly=\"readonly\"";
  protected final String TEXT_482 = "/>";
  protected final String TEXT_483 = "\t\t\t\t\t\t\t" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_484 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_485 = "\t\t\t\t\t\t";
  protected final String TEXT_486 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_487 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_488 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_489 = ":</label>" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_490 = NL + "\t\t\t\t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_491 = "\">" + NL + "\t\t\t\t\t\t\t <select  id=\"";
  protected final String TEXT_492 = "\" name=\"";
  protected final String TEXT_493 = "\" class=\"";
  protected final String TEXT_494 = " class=\"text ";
  protected final String TEXT_495 = "readonly";
  protected final String TEXT_496 = "\" ";
  protected final String TEXT_497 = "readonly=\"readonly\"";
  protected final String TEXT_498 = ">" + NL + "\t\t\t\t\t\t\t     <s:property value=\"";
  protected final String TEXT_499 = "\" escape=\"false\"/>" + NL + "\t\t\t\t\t\t\t </select>" + NL + "\t\t\t\t\t\t</td>";
  protected final String TEXT_500 = NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_501 = "\">";
  protected final String TEXT_502 = NL + "\t\t      \t\t\t\t\t${mo.";
  protected final String TEXT_503 = "}";
  protected final String TEXT_504 = NL + "\t\t      \t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_505 = "\" name=\"";
  protected final String TEXT_506 = "\" value=\"${mo.";
  protected final String TEXT_507 = "}\" class=\"";
  protected final String TEXT_508 = "\" ";
  protected final String TEXT_509 = "readonly=\"readonly\"";
  protected final String TEXT_510 = "/>";
  protected final String TEXT_511 = "\t" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_512 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_513 = "\t\t\t\t\t\t";
  protected final String TEXT_514 = "\t";
  protected final String TEXT_515 = "\t";
  protected final String TEXT_516 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_517 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_518 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_519 = ":</label>" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_520 = NL + "\t\t\t\t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_521 = "\">" + NL + "\t\t\t\t\t\t\t ${";
  protected final String TEXT_522 = "}" + NL + "\t\t\t\t\t\t</td>";
  protected final String TEXT_523 = NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_524 = "\">";
  protected final String TEXT_525 = NL + "\t\t      \t\t\t\t\t${mo.";
  protected final String TEXT_526 = "}";
  protected final String TEXT_527 = NL + "\t\t      \t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_528 = "\" name=\"";
  protected final String TEXT_529 = "\" value=\"${mo.";
  protected final String TEXT_530 = "}\" class=\"";
  protected final String TEXT_531 = "\" ";
  protected final String TEXT_532 = "readonly=\"readonly\"";
  protected final String TEXT_533 = "/>";
  protected final String TEXT_534 = "\t" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_535 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_536 = "\t\t\t\t\t\t";
  protected final String TEXT_537 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_538 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_539 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_540 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_541 = "\">";
  protected final String TEXT_542 = NL + "\t\t      \t\t\t\t\t${mo.";
  protected final String TEXT_543 = "}";
  protected final String TEXT_544 = NL + "\t\t      \t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_545 = "\" name=\"";
  protected final String TEXT_546 = "\" value=\"${mo.";
  protected final String TEXT_547 = "}\" class=\"";
  protected final String TEXT_548 = "\" ";
  protected final String TEXT_549 = "readonly=\"readonly\"";
  protected final String TEXT_550 = "/>";
  protected final String TEXT_551 = "\t" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_552 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_553 = "\t\t\t\t\t\t";
  protected final String TEXT_554 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_555 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_556 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_557 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_558 = "\">";
  protected final String TEXT_559 = NL + "\t\t      \t\t\t\t\t${mo.";
  protected final String TEXT_560 = "}";
  protected final String TEXT_561 = NL + "\t\t      \t\t\t\t<textarea id=\"";
  protected final String TEXT_562 = "\" name=\"";
  protected final String TEXT_563 = "\"  class=\"";
  protected final String TEXT_564 = "\" >${mo.";
  protected final String TEXT_565 = "}</textarea>";
  protected final String TEXT_566 = "\t" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_567 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_568 = "\t\t\t\t\t\t";
  protected final String TEXT_569 = "\t\t";
  protected final String TEXT_570 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_571 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_572 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_573 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_574 = "\">";
  protected final String TEXT_575 = NL + "\t\t      \t\t\t\t\t${mo.";
  protected final String TEXT_576 = "}";
  protected final String TEXT_577 = NL + "\t\t      \t\t\t\t<input type=\"text\" id=\"";
  protected final String TEXT_578 = "\" name=\"";
  protected final String TEXT_579 = "\" value=\"${mo.";
  protected final String TEXT_580 = "}\" class=\"";
  protected final String TEXT_581 = "\" />";
  protected final String TEXT_582 = "\t\t\t      \t\t" + NL + "\t\t      \t\t\t</td>";
  protected final String TEXT_583 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_584 = "\t\t\t\t\t\t";
  protected final String TEXT_585 = "\t\t";
  protected final String TEXT_586 = "\t\t\t";
  protected final String TEXT_587 = "\t\t";
  protected final String TEXT_588 = "\t";
  protected final String TEXT_589 = "\t\t";
  protected final String TEXT_590 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_591 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_592 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_593 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t\t\t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_594 = "\">" + NL + "\t\t\t\t\t\t\t <input type=\"hidden\" id=\"";
  protected final String TEXT_595 = "_";
  protected final String TEXT_596 = "\" name=\"";
  protected final String TEXT_597 = ".";
  protected final String TEXT_598 = "\" value=\"${mo.";
  protected final String TEXT_599 = ".";
  protected final String TEXT_600 = "}\" class=\"text\" />" + NL + "\t\t\t\t\t\t\t <input type=\"text\" id=\"";
  protected final String TEXT_601 = "_";
  protected final String TEXT_602 = "\" name=\"";
  protected final String TEXT_603 = ".";
  protected final String TEXT_604 = "\" value=\"${mo.";
  protected final String TEXT_605 = ".";
  protected final String TEXT_606 = "}\" class=\"text\" />" + NL + "\t\t\t\t\t\t</td>";
  protected final String TEXT_607 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_608 = "\t\t\t\t\t\t";
  protected final String TEXT_609 = "\t";
  protected final String TEXT_610 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_611 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_612 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_613 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t\t\t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_614 = "\">";
  protected final String TEXT_615 = NL + "\t\t      \t\t\t\t\t${mo.";
  protected final String TEXT_616 = ".";
  protected final String TEXT_617 = "}";
  protected final String TEXT_618 = NL + "\t\t\t\t\t\t\t <input type=\"text\" id=\"";
  protected final String TEXT_619 = "_";
  protected final String TEXT_620 = "\" name=\"";
  protected final String TEXT_621 = ".";
  protected final String TEXT_622 = "\" value=\"${mo.";
  protected final String TEXT_623 = ".";
  protected final String TEXT_624 = "}\" class=\"";
  protected final String TEXT_625 = "\" ";
  protected final String TEXT_626 = "readonly=\"readonly\"";
  protected final String TEXT_627 = "/>";
  protected final String TEXT_628 = "\t\t" + NL + "\t\t\t\t\t\t</td>";
  protected final String TEXT_629 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_630 = "\t\t\t\t\t\t";
  protected final String TEXT_631 = "\t";
  protected final String TEXT_632 = "\t";
  protected final String TEXT_633 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_634 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_635 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_636 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t\t\t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_637 = "\">" + NL + "\t\t\t\t\t\t\t <input type=\"hidden\" id=\"";
  protected final String TEXT_638 = "_";
  protected final String TEXT_639 = "\" name=\"";
  protected final String TEXT_640 = ".";
  protected final String TEXT_641 = "\" value=\"${mo.";
  protected final String TEXT_642 = "_";
  protected final String TEXT_643 = "}\" class=\"text\" />" + NL + "\t\t\t\t\t\t\t <input type=\"text\" id=\"";
  protected final String TEXT_644 = "_";
  protected final String TEXT_645 = "\" name=\"";
  protected final String TEXT_646 = ".";
  protected final String TEXT_647 = "\" value=\"${mo.";
  protected final String TEXT_648 = ".";
  protected final String TEXT_649 = "}\" class=\"text\" />" + NL + "\t\t\t\t\t\t</td>";
  protected final String TEXT_650 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_651 = "\t\t\t\t\t\t";
  protected final String TEXT_652 = "\t";
  protected final String TEXT_653 = NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_654 = "\"></td>" + NL + "\t\t\t\t\t</tr>" + NL + "\t\t\t\t\t<tr>";
  protected final String TEXT_655 = NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_656 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t\t\t\t\t<td class=\"field\" colspan=\"";
  protected final String TEXT_657 = "\">";
  protected final String TEXT_658 = NL + "\t\t      \t\t\t\t\t${mo.";
  protected final String TEXT_659 = ".";
  protected final String TEXT_660 = "}";
  protected final String TEXT_661 = NL + "\t\t\t\t\t\t\t <input type=\"text\" id=\"";
  protected final String TEXT_662 = "_";
  protected final String TEXT_663 = "\" name=\"";
  protected final String TEXT_664 = ".";
  protected final String TEXT_665 = "\" value=\"${mo.";
  protected final String TEXT_666 = ".";
  protected final String TEXT_667 = "}\" class=\"";
  protected final String TEXT_668 = "\" ";
  protected final String TEXT_669 = "readonly=\"readonly\"";
  protected final String TEXT_670 = "/>";
  protected final String TEXT_671 = "\t" + NL + "\t\t\t\t\t\t</td>";
  protected final String TEXT_672 = NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_673 = "\t\t\t\t\t\t";
  protected final String TEXT_674 = "\t";
  protected final String TEXT_675 = "\t" + NL + "\t\t\t\t\t\t<td colspan=\"";
  protected final String TEXT_676 = "\"></td>" + NL + "\t\t\t\t\t</tr>";
  protected final String TEXT_677 = "\t";
  protected final String TEXT_678 = NL + "\t\t\t\t\t<tr>" + NL + "\t\t      \t\t\t<td colspan=\"";
  protected final String TEXT_679 = "\">" + NL + "\t\t      \t\t\t\t<div class=\"v-fieldset-wrap\">" + NL + "\t\t\t      \t\t\t\t<fieldset>" + NL + "\t\t\t\t\t              <legend>" + NL + "\t\t\t\t\t                 \t";
  protected final String TEXT_680 = ":" + NL + "\t\t\t\t\t              </legend>" + NL + "\t\t\t\t\t              <div class=\"v-fieldset-content\">" + NL + "\t\t\t\t\t                \t${";
  protected final String TEXT_681 = "}" + NL + "\t\t\t\t\t\t\t      </div>" + NL + "\t\t\t\t\t            </fieldset>" + NL + "\t\t      \t\t\t\t</div>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t</tr>";
  protected final String TEXT_682 = NL + "\t\t\t\t\t<tr>" + NL + "\t\t      \t\t\t<td colspan=\"";
  protected final String TEXT_683 = "\">" + NL + "\t\t      \t\t\t\t<div class=\"v-tree-wrap\">" + NL + "\t\t\t\t\t\t\t\t<div class=\"v-title\">";
  protected final String TEXT_684 = "：</div>" + NL + "\t\t\t\t\t\t\t\t<div class=\"v-content\" id=\"";
  protected final String TEXT_685 = "\" style=\"height:270px; width:350px; overflow: auto;\">" + NL + "\t\t\t\t\t\t\t\t</div>" + NL + "\t\t\t\t\t\t\t</div>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t</tr>";
  protected final String TEXT_686 = NL + "\t\t\t\t\t<tr>" + NL + "\t\t      \t\t\t<td class=\"label\">" + NL + "\t\t      \t\t\t\t<label>";
  protected final String TEXT_687 = ":</label>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t\t<td class=\"field\" ";
  protected final String TEXT_688 = "colspan=\"";
  protected final String TEXT_689 = "\"";
  protected final String TEXT_690 = ">" + NL + "\t\t\t \t         \t <input type=\"file\" id=\"uploadImage_";
  protected final String TEXT_691 = "\" name=\"uploadImage_";
  protected final String TEXT_692 = "\" size=\"35\"/><br/>" + NL + "\t\t\t \t         \t <div id=\"previewImageWrap_";
  protected final String TEXT_693 = "\">" + NL + "\t\t\t \t         \t \t<img id=\"previewImage_";
  protected final String TEXT_694 = "\" src=\"\"/>" + NL + "\t\t\t \t         \t </div>" + NL + "\t\t      \t\t\t</td>" + NL + "\t\t      \t\t</tr>";
  protected final String TEXT_695 = NL + "\t\t\t\t\t<tr>" + NL + "\t\t\t\t       <td class=\"label\">" + NL + "\t\t\t\t       \t\t<label>";
  protected final String TEXT_696 = ":</label>" + NL + "\t\t\t\t       </td>" + NL + "\t\t\t\t       <td class=\"field\" ";
  protected final String TEXT_697 = "colspan=\"";
  protected final String TEXT_698 = "\"";
  protected final String TEXT_699 = ">" + NL + "\t\t\t\t\t   \t\t<input type=\"file\" id=\"";
  protected final String TEXT_700 = "\" name=\"";
  protected final String TEXT_701 = "\" size=\"35\" onchange=\"goolov.validete.file(this);\"/>" + NL + "\t\t\t\t   \t   </td>" + NL + "\t\t\t\t   \t</tr>";
  protected final String TEXT_702 = NL + "\t\t\t\t\t<tr>" + NL + "\t\t\t\t\t  <td colspan=\"";
  protected final String TEXT_703 = "\">" + NL + "\t\t\t\t\t  \t<div class=\"v-section-wrap\">" + NL + "\t\t\t\t\t  \t\t<div class=\"v-title\">";
  protected final String TEXT_704 = ":</div>" + NL + "\t\t\t\t\t  \t\t<div class=\"v-content\">" + NL + "\t\t\t\t\t  \t\t\t<input type=\"hidden\" id=\"";
  protected final String TEXT_705 = "\" name=\"";
  protected final String TEXT_706 = "\"/>" + NL + "\t\t\t\t\t  \t\t\t<textarea style=\"width:98%;\"  id=\"fck_";
  protected final String TEXT_707 = "\">" + NL + "\t\t\t\t\t      \t\t  ${mo.";
  protected final String TEXT_708 = "}" + NL + "\t\t\t\t\t   \t\t\t</textarea>" + NL + "\t\t\t\t\t\t\t  \t<script type=\"text/javascript\">" + NL + "\t\t\t\t\t\t             var oFCKeditor = new FCKeditor('fck_";
  protected final String TEXT_709 = "') ; " + NL + "\t\t\t\t\t                 oFCKeditor.BasePath\t= '${ctx}/resources/fckeditor/' ;" + NL + "\t\t\t\t\t                 oFCKeditor.Config[\"CustomConfigurationsPath\"]=\"${ctx}/resources/fckeditor/customConfig.js\";" + NL + "\t\t\t\t\t\t             oFCKeditor.ToolbarSet='goolovEdit';" + NL + "\t\t\t\t\t\t             oFCKeditor.Config[\"TabSpaces\"]=2;" + NL + "\t\t\t\t\t\t             oFCKeditor.Config[\"LinkUpload\"] = false;" + NL + "\t\t\t\t\t\t             oFCKeditor.Config[\"ImageUpload\"] = true;" + NL + "\t\t\t\t\t\t             oFCKeditor.Config[\"FlashUpload\"] = false;" + NL + "\t\t\t\t\t\t             oFCKeditor.Height\t= 350;" + NL + "\t\t\t\t\t                 oFCKeditor.ReplaceTextarea(); " + NL + "\t\t\t\t\t            </script>" + NL + "\t\t\t\t\t          </div>" + NL + "\t\t\t\t\t  \t </div>" + NL + "\t\t\t\t\t  </td>" + NL + "\t\t\t\t   </tr>\t      ";
  protected final String TEXT_710 = NL + "\t\t\t\t</table>" + NL + "\t\t\t  </form>";
  protected final String TEXT_711 = NL + "\t\t\t</div><!-- tab one end -->";
  protected final String TEXT_712 = NL + "\t  \t\t<div title=\"";
  protected final String TEXT_713 = "\"><!--";
  protected final String TEXT_714 = " tab start-->" + NL + "\t\t  \t\t<div class=\"v-fckeditor\">" + NL + "\t\t  \t\t\t<input type=\"hidden\" id=\"";
  protected final String TEXT_715 = "\" name=\"";
  protected final String TEXT_716 = "\"/>" + NL + "\t\t  \t\t\t<textarea style=\"width: 90%;\"  id=\"fck_";
  protected final String TEXT_717 = "\">" + NL + "\t\t      \t\t  ${mo.";
  protected final String TEXT_718 = "}" + NL + "\t\t   \t\t\t</textarea>" + NL + "\t\t\t\t  \t<script type=\"text/javascript\">" + NL + "\t\t\t             var oFCKeditor = new FCKeditor('fck_";
  protected final String TEXT_719 = "') ; " + NL + "\t\t                 oFCKeditor.BasePath\t= '${ctx}/resources/fckeditor/' ;" + NL + "\t\t                 oFCKeditor.Config[\"CustomConfigurationsPath\"]=\"${ctx}/resources/fckeditor/customConfig.js\";" + NL + "\t\t\t             oFCKeditor.ToolbarSet='goolovEditTab';" + NL + "\t\t\t             oFCKeditor.Config[\"TabSpaces\"]=2;" + NL + "\t\t\t             oFCKeditor.Config[\"LinkUpload\"] = false;" + NL + "\t\t\t             oFCKeditor.Config[\"ImageUpload\"] = true;" + NL + "\t\t\t             oFCKeditor.Config[\"FlashUpload\"] = false;" + NL + "\t\t\t             oFCKeditor.Height\t= ";
  protected final String TEXT_720 = "-130;" + NL + "\t\t                 oFCKeditor.ReplaceTextarea(); " + NL + "\t\t            </script>" + NL + "\t\t          </div>" + NL + "\t\t\t</div><!--";
  protected final String TEXT_721 = " tab end-->";
  protected final String TEXT_722 = "\t\t\t";
  protected final String TEXT_723 = NL + "\t\t\t<div title=\"";
  protected final String TEXT_724 = "\"  class=\"v-tab\"><!--";
  protected final String TEXT_725 = " tab start-->" + NL + "\t\t\t\t<div class=\"v-section-wrap\">" + NL + "\t\t\t\t\t<div class='v-title'>选择";
  protected final String TEXT_726 = "：</div>" + NL + "\t\t\t\t\t<div class=\"v-content\">" + NL + "\t\t\t\t\t\t${";
  protected final String TEXT_727 = "}" + NL + "\t\t\t\t\t</div>" + NL + "\t\t\t\t</div>" + NL + "\t\t\t</div><!--";
  protected final String TEXT_728 = " tab end-->";
  protected final String TEXT_729 = NL + "\t\t\t<div title=\"";
  protected final String TEXT_730 = "\"   class=\"v-tab\"><!--";
  protected final String TEXT_731 = " tab start-->" + NL + "\t\t\t\t\t<div class=\"v-tree-wrap\">" + NL + "\t\t\t\t\t\t<div class=\"v-title\">选择";
  protected final String TEXT_732 = "：</div>" + NL + "\t\t\t\t\t\t<div class=\"v-content\" id=\"";
  protected final String TEXT_733 = "\" style=\"height:270px; width:350px; overflow: auto;\">" + NL + "\t\t\t\t\t\t</div>" + NL + "\t\t\t\t\t</div>" + NL + "\t\t\t</div><!--";
  protected final String TEXT_734 = " tab end-->";
  protected final String TEXT_735 = "\t\t\t\t\t\t" + NL + "\t\t  </div><!-- firstTabs end -->";
  protected final String TEXT_736 = NL + "\t\t</div><!-- center end -->" + NL + "\t\t<div region=\"south\" border=\"false\" style=\"height:50px;\"><!-- south start-->" + NL + "\t\t\t<div class=\"v-buttons\"><!-- v-buttons start -->" + NL + "\t\t  \t \t<c:choose>" + NL + "\t\t\t  \t \t<c:when test=\"${null==model.id}\">" + NL + "\t\t\t\t   \t\t\t<a href=\"javascript:newWinSaveData();\" class=\"easyui-linkbutton\">新增</a>" + NL + "\t\t\t\t   \t\t\t<a href=\"javascript:resetData();\" class=\"easyui-linkbutton\" >重置</a>" + NL + "\t\t\t\t   \t\t\t<a href=\"javascript:newWinClose();\" class=\"easyui-linkbutton\" >关闭</a>" + NL + "\t\t\t\t   \t\t\t<a href=\"javascript:newWinCloseAndRefresh();\" class=\"easyui-linkbutton\" >关闭并刷新</a>" + NL + "\t\t\t \t  \t</c:when>" + NL + "\t\t\t   \t\t<c:otherwise>" + NL + "\t\t\t\t   \t\t\t<a href=\"javascript:editWinUpdateData();\" class=\"easyui-linkbutton\" >更新</a>" + NL + "\t\t\t\t\t\t\t<a href=\"javascript:resetData();\" class=\"easyui-linkbutton\" >重置</a>" + NL + "\t\t\t\t\t\t\t<a href=\"javascript:editWinClose();\" class=\"easyui-linkbutton\" >关闭</a>" + NL + "\t\t\t\t\t\t\t<a href=\"javascript:editWinCloseAndRefresh();\" class=\"easyui-linkbutton\" >关闭并刷新</a>" + NL + "\t\t\t\t\t</c:otherwise>" + NL + "\t\t\t\t</c:choose> " + NL + "\t\t\t</div><!-- v-buttons end-->" + NL + "\t\t</div><!--\tsouth end -->" + NL + "</body>" + NL + "</html>";
  protected final String TEXT_737 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    Property uml2Property_proxy = (Property) argument;
    Class uml2Class_proxy = (Class) uml2Property_proxy.getOwner();
     if(FileStereotypeHelper.isClass_file(uml2Class_proxy)||FileStereotypeHelper.isClass_Image(uml2Class_proxy)){//应用了File or Image
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

    /********process select property type clazz********/
    if(!ClassHelper.isSimple(curProperty)){
    Class relClass = (Class) curProperty.getType();Package relPackage = relClass.getPackage();
    String relClassCommentName=TypeHelper.getDocumentationOrName(relClass);
    Property relClassOppositeProperty=curProperty.getOpposite();
    String relClassOppositePropertyName=NameHelper.uncapSafeName(relClassOppositeProperty);
    			if(tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_20);
    			}
    stringBuffer.append(TEXT_21);
    			needTd=2>trIncludeTd?trIncludeTd:2;
    			if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_22);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_23);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    			}				
    stringBuffer.append(TEXT_24);
    stringBuffer.append(ownerClassCommentName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(relClassOppositePropertyName);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(relClassOppositePropertyName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(ownerClassIdPropertyName);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(relClassOppositePropertyName);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(ownerClassIdPropertyName);
    stringBuffer.append(TEXT_31);
    				tdCount+=needTd;
    stringBuffer.append(TEXT_32);
    			if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_33);
    			}
    }
    
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
    stringBuffer.append(TEXT_34);
    			}
    stringBuffer.append(TEXT_35);
    			if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_36);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_37);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    			}
    stringBuffer.append(TEXT_38);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(NameHelper.uncapSafeName(idProperty));
    stringBuffer.append(TEXT_41);
    			tdCount+=needTd;
    stringBuffer.append(TEXT_42);
    			if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_43);
    			}
    stringBuffer.append(TEXT_44);
    		}
    	}else if(EntityHelper.isIDAssign(idProperty)){
 		String propertyCommentName=TypeHelper.getDocumentationOrName(idProperty);
 		String propertyUncapSafeName=NameHelper.uncapSafeName(idProperty);
 		String propertyStyleClass=ViewInputHelper.getStyleClass(idProperty);

    			if(tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_45);
    			}
    stringBuffer.append(TEXT_46);
    				needTd=2>trIncludeTd?trIncludeTd:2;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_47);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_48);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    stringBuffer.append(TEXT_49);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(propertyStyleClass);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(propertyStyleClass);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_60);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_61);
    				}
    stringBuffer.append(TEXT_62);
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
    stringBuffer.append(TEXT_63);
    			}
    stringBuffer.append(TEXT_64);
    	/********process parentId Property start********/
    			if (TreeStereotypeHelper.isParentIdProperty(property)) {// text
    				needTd=2>trIncludeTd?trIncludeTd:2;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_65);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_66);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    stringBuffer.append(TEXT_67);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_71);
    if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_72);
    }
    stringBuffer.append(TEXT_73);
    if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_74);
    }
    stringBuffer.append(TEXT_75);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_76);
    				}
    stringBuffer.append(TEXT_77);
    				continue;
    			}
    	/********process parentId Property end********/
    	/********process text********/
    			if (ViewInputHelper.isViewInputText(property)) {// text
    				needTd=2>trIncludeTd?trIncludeTd:2;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_78);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_79);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    stringBuffer.append(TEXT_80);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_82);
    				if(	ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_83);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_84);
    				}else{
    stringBuffer.append(TEXT_85);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(propertyStyleClass);
    stringBuffer.append(TEXT_89);
    				}
    stringBuffer.append(TEXT_90);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_91);
    				}
    stringBuffer.append(TEXT_92);
    				continue;
    			}
    	/********process title********/
    			if (ViewInputHelper.isViewInputTitle(property)) {// title
    				needTd=4>trIncludeTd?trIncludeTd:4;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_93);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_94);
    					tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    stringBuffer.append(TEXT_95);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_97);
    if(						ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_98);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_99);
    							}else{
    stringBuffer.append(TEXT_100);
    stringBuffer.append(propertyUncapSafeName);
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
    							}
    stringBuffer.append(TEXT_107);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_108);
    				}
    stringBuffer.append(TEXT_109);
    				continue;
    			}
    	/********process select********/
    			if (ViewInputHelper.isViewInputSelect(property)) {// select
    				needTd=2>trIncludeTd?trIncludeTd:2;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_110);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_111);
    					tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    stringBuffer.append(TEXT_112);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_113);
    				Enumeration enumeration=EnumKindHelper.getAppliedEnumKindEnumeration(property);
    				if(null!=enumeration){
    					String modelEnumQualifiedName=MdaHelper.getModelQualifiedName(enumeration,PKGSuffix.enumeration,ModelNameSuffix.enumeration);
    					String modelEnumName=MdaHelper.getModelClassName(enumeration,ModelNameSuffix.enumeration);
    					String modelEnumSelectHtml=NamedUtil.getPropertyNamed(enumeration,PropertyNamedRuleKind.selectHtml);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(needTd-1);
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
    if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_121);
    }
    stringBuffer.append(TEXT_122);
    stringBuffer.append(modelEnumSelectHtml);
    stringBuffer.append(TEXT_123);
    				}else{
    stringBuffer.append(TEXT_124);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_125);
    if(						ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_126);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_127);
    							}else{
    stringBuffer.append(TEXT_128);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(propertyStyleClass);
    stringBuffer.append(TEXT_132);
    if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_133);
    }
    stringBuffer.append(TEXT_134);
    							}
    stringBuffer.append(TEXT_135);
    				}
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_136);
    				}
    stringBuffer.append(TEXT_137);
    				continue;
    			}
    stringBuffer.append(TEXT_138);
    	/********process radio********/
    stringBuffer.append(TEXT_139);
    			if (ViewInputHelper.isViewInputRadio(property)) {// radio
    				needTd=4>trIncludeTd?trIncludeTd:4;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_140);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_141);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    stringBuffer.append(TEXT_142);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_143);
    				Enumeration enumeration=EnumKindHelper.getAppliedEnumKindEnumeration(property);
    				if(null!=enumeration){
    						String propertyRadioGroup=NamedUtil.getPropertyNamed(enumeration,PropertyNamedRuleKind.inputRadioGroup);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(propertyRadioGroup);
    stringBuffer.append(TEXT_146);
    				}else{
    stringBuffer.append(TEXT_147);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_148);
    if(						ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_149);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_150);
    							}else{
    stringBuffer.append(TEXT_151);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(propertyStyleClass);
    stringBuffer.append(TEXT_155);
    if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_156);
    }
    stringBuffer.append(TEXT_157);
    							}
    stringBuffer.append(TEXT_158);
    				}
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_159);
    				}
    stringBuffer.append(TEXT_160);
    				continue;
    			}
    	/********process datePicker********/
    			if (ViewInputHelper.isViewInputDatePicker(property)) {// datePicker
    				String propertyToDateTimeCapName=PropertyNamedRuleKind.dateToDateTimeStr.getRuleCapNamed(property);
    				String propertyToDateTimeUncapName=PropertyNamedRuleKind.dateToDateTimeStr.getRuleUnCapNamed(property);
    				needTd=2>trIncludeTd?trIncludeTd:2;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_161);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_162);
    					tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    stringBuffer.append(TEXT_163);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_165);
    if(						ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_166);
    stringBuffer.append(propertyToDateTimeUncapName);
    stringBuffer.append(TEXT_167);
    							}else{
    stringBuffer.append(TEXT_168);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(propertyStyleClass);
    stringBuffer.append(TEXT_172);
    if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_173);
    }
    stringBuffer.append(TEXT_174);
    							}
    stringBuffer.append(TEXT_175);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_176);
    				}
    stringBuffer.append(TEXT_177);
    				continue;
    				}
    	/********process texttarea********/
    			if (ViewInputHelper.isViewInputTextarea(property)) {// texttarea 
    				needTd=4>trIncludeTd?trIncludeTd:4;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_178);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_179);
    					tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    stringBuffer.append(TEXT_180);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_182);
    if(						ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_183);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_184);
    							}else{
    stringBuffer.append(TEXT_185);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(propertyStyleClass);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_189);
    							}
    stringBuffer.append(TEXT_190);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_191);
    				}
    stringBuffer.append(TEXT_192);
    				continue;
    			}	
    stringBuffer.append(TEXT_193);
    	/********process checkbox********/
    			if (ViewInputHelper.isViewInputCheckbox(property)) {// checkbox
    				needTd=4>trIncludeTd?trIncludeTd:4;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_194);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_195);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    stringBuffer.append(TEXT_196);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_198);
    if(						ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_199);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_200);
    							}else{
    stringBuffer.append(TEXT_201);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(propertyStyleClass);
    stringBuffer.append(TEXT_205);
    							}
    stringBuffer.append(TEXT_206);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_207);
    				}
    stringBuffer.append(TEXT_208);
    				continue;
    			}
    
/*****************************************************************
 * process rel 
/*****************************************************************/

    /********process M2OSelect********/
    stringBuffer.append(TEXT_209);
    			if (ViewInputHelper.isApplyM2OSelect(property)) {//M2OSelect
    				Class propertyType = (Class) property.getType();
    				String propertyTypeComment = TypeHelper.getDocumentationOrName(propertyType);
     				Property propertyTypeIdProperty=EntityHelper.getIDProperty(propertyType);
     				String propertyTypeIdPropertyUncapSafeName=NameHelper.uncapSafeName(propertyTypeIdProperty);
    				needTd=2>trIncludeTd?trIncludeTd:2;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_210);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_211);
    					tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    				String m2oSelectHtml=NamedUtil.getPropertyNamed(property,PropertyNamedRuleKind.selectHtml);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(propertyTypeComment);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_218);
    if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_219);
    }
    stringBuffer.append(TEXT_220);
    stringBuffer.append(m2oSelectHtml);
    stringBuffer.append(TEXT_221);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_222);
    				}
    stringBuffer.append(TEXT_223);
    				continue;
    			}	
    stringBuffer.append(TEXT_224);
    	/********process M2OSelectPage********/
    			if (ViewInputHelper.isApplyM2OSelectPage(property)) {//M2OSelectPage
    				Class propertyType = (Class) property.getType();
    				String propertyTypeComment = TypeHelper.getDocumentationOrName(propertyType);
     				Property propertyTypeIdProperty=EntityHelper.getIDProperty(propertyType);
     				String propertyTypeIdPropertyUncapSafeName=NameHelper.uncapSafeName(propertyTypeIdProperty);
    				needTd=2>trIncludeTd?trIncludeTd:2;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_225);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_226);
    					tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    stringBuffer.append(TEXT_227);
    stringBuffer.append(propertyTypeComment);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_229);
    							if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_230);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_232);
    							}else{
    stringBuffer.append(TEXT_233);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(propertyStyleClass);
    stringBuffer.append(TEXT_240);
    if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_241);
    }
    stringBuffer.append(TEXT_242);
    							}
    stringBuffer.append(TEXT_243);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_244);
    				}
    stringBuffer.append(TEXT_245);
    				continue;
    			}
    stringBuffer.append(TEXT_246);
    	/********process O2OSelect********/
    			if (ViewInputHelper.isApplyO2OSelect(property)) {//O2OSelect
    stringBuffer.append(TEXT_247);
    				Class propertyType = (Class) property.getType();
    				String propertyTypeComment = TypeHelper.getDocumentationOrName(propertyType);
     				Property propertyTypeIdProperty=EntityHelper.getIDProperty(propertyType);
     				String propertyTypeIdPropertyUncapSafeName=NameHelper.uncapSafeName(propertyTypeIdProperty);
    				needTd=2>trIncludeTd?trIncludeTd:2;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_248);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_249);
    					tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    				String O2OSelectHtml=NamedUtil.getPropertyNamed(property,PropertyNamedRuleKind.selectHtml);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(propertyTypeComment);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_256);
    if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_257);
    }
    stringBuffer.append(TEXT_258);
    stringBuffer.append(O2OSelectHtml);
    stringBuffer.append(TEXT_259);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_260);
    				}
    stringBuffer.append(TEXT_261);
    				continue;
    			}	
    stringBuffer.append(TEXT_262);
    	/********process O2OSelectPage********/
    			if (ViewInputHelper.isApplyO2OSelectPage(property)) {//O2OSelectPage
    				Class propertyType = (Class) property.getType();
    				String propertyTypeComment = TypeHelper.getDocumentationOrName(propertyType);
     				Property propertyTypeIdProperty=EntityHelper.getIDProperty(propertyType);
     				String propertyTypeIdPropertyUncapSafeName=NameHelper.uncapSafeName(propertyTypeIdProperty);
    				needTd=2>trIncludeTd?trIncludeTd:2;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_263);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_264);
    					tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    stringBuffer.append(TEXT_265);
    stringBuffer.append(propertyTypeComment);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_267);
    							if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_268);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_270);
    							}else{
    stringBuffer.append(TEXT_271);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_272);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_277);
    stringBuffer.append(propertyStyleClass);
    stringBuffer.append(TEXT_278);
    if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_279);
    }
    stringBuffer.append(TEXT_280);
    							}
    stringBuffer.append(TEXT_281);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_282);
    				}
    stringBuffer.append(TEXT_283);
    				continue;
    			}
    stringBuffer.append(TEXT_284);
    	}
    	if (tdCount%trIncludeTd!=0){
    stringBuffer.append(TEXT_285);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_286);
    	}
    
	/*****************************************************************
	 * property simple input end
	/*****************************************************************/

    stringBuffer.append(TEXT_287);
    
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
    stringBuffer.append(TEXT_288);
    stringBuffer.append(trIncludeTd);
    stringBuffer.append(TEXT_289);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_290);
    stringBuffer.append(relPropertyCheckboxs);
    stringBuffer.append(TEXT_291);
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
    stringBuffer.append(TEXT_292);
    stringBuffer.append(trIncludeTd);
    stringBuffer.append(TEXT_293);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_294);
    stringBuffer.append(relPropertyCheckTreeDomId);
    stringBuffer.append(TEXT_295);
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
    stringBuffer.append(TEXT_296);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_297);
    if(trIncludeTd-1>1){
    stringBuffer.append(TEXT_298);
    stringBuffer.append(trIncludeTd-1);
    stringBuffer.append(TEXT_299);
    }
    stringBuffer.append(TEXT_300);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_301);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_302);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_304);
    		}
    }*/
    /********process file properties********/
    /*List<Property> filePropertyList=ViewInputHelper.getViewInputFile(uml2Class);
    if(null!=filePropertyList&&filePropertyList.size()>0){
    	for(Property property:filePropertyList){
     			String propertyCommentName=TypeHelper.getDocumentationOrName(property);
     			String propertyUncapSafeName=NameHelper.uncapSafeName(property);
     			//String propertyStyleClass=ViewInputHelper.getStyleClass(property);
    stringBuffer.append(TEXT_305);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_306);
    if(trIncludeTd-1>1){
    stringBuffer.append(TEXT_307);
    stringBuffer.append(trIncludeTd-1);
    stringBuffer.append(TEXT_308);
    }
    stringBuffer.append(TEXT_309);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_311);
    	}
    }*/
    /********process content properties********/
    if(null!=contentPropertyList&&contentPropertyList.size()>0){
    for(Property property:contentPropertyList){
     			String propertyCommentName=TypeHelper.getDocumentationOrName(property);
     			String propertyUncapSafeName=NameHelper.uncapSafeName(property);
     			//String propertyStyleClass=ViewInputHelper.getStyleClass(property);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(trIncludeTd);
    stringBuffer.append(TEXT_313);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_314);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_315);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_316);
    stringBuffer.append(NameHelper.getUncapName(property));
    stringBuffer.append(TEXT_317);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_318);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_319);
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
    stringBuffer.append(TEXT_320);
    if(trIncludeTd-1>1){
    stringBuffer.append(TEXT_321);
    stringBuffer.append(trIncludeTd-1);
    stringBuffer.append(TEXT_322);
    }
    stringBuffer.append(TEXT_323);
    stringBuffer.append(propertyFileFileSavePathUncapSafeName);
    stringBuffer.append(TEXT_324);
    stringBuffer.append(propertyFileFileTypeUncapSafeName);
    stringBuffer.append(TEXT_325);
    if(trIncludeTd-3>1){
    stringBuffer.append(TEXT_326);
    stringBuffer.append(trIncludeTd-3);
    stringBuffer.append(TEXT_327);
    }
    stringBuffer.append(TEXT_328);
    stringBuffer.append(propertyFileFileSizeUncapSafeName);
    stringBuffer.append(TEXT_329);
    if(trIncludeTd>1){
    stringBuffer.append(TEXT_330);
    stringBuffer.append(trIncludeTd);
    stringBuffer.append(TEXT_331);
    }
    stringBuffer.append(TEXT_332);
    stringBuffer.append(propertyFileFileSavePathUncapSafeName);
    stringBuffer.append(TEXT_333);
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
    stringBuffer.append(TEXT_334);
    if(trIncludeTd-1>1){
    stringBuffer.append(TEXT_335);
    stringBuffer.append(trIncludeTd-1);
    stringBuffer.append(TEXT_336);
    }
    stringBuffer.append(TEXT_337);
    stringBuffer.append(propertyFileFileSavePathUncapSafeName);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(propertyFileFileTypeUncapSafeName);
    stringBuffer.append(TEXT_339);
    if(trIncludeTd-3>1){
    stringBuffer.append(TEXT_340);
    stringBuffer.append(trIncludeTd-3);
    stringBuffer.append(TEXT_341);
    }
    stringBuffer.append(TEXT_342);
    stringBuffer.append(propertyFileFileSizeUncapSafeName);
    stringBuffer.append(TEXT_343);
    }
    stringBuffer.append(TEXT_344);
    if(!tabsList.isEmpty()||!contentTabPropertyList.isEmpty()){
    stringBuffer.append(TEXT_345);
    	for(Iterator<Property> iter=contentTabPropertyList.iterator();iter.hasNext();){
    			Property property=iter.next();
     			String propertyCommentName=TypeHelper.getDocumentationOrName(property);
     			String propertyUncapSafeName=NameHelper.uncapSafeName(property);
     			//String propertyStyleClass=ViewInputHelper.getStyleClass(property);
    			String propertyCapConmentName=TypeHelper.getDocumentationOrName(property);
    stringBuffer.append(TEXT_346);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_347);
    stringBuffer.append(propertyCapConmentName);
    stringBuffer.append(TEXT_348);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_349);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_350);
    stringBuffer.append(NameHelper.getUncapName(property));
    stringBuffer.append(TEXT_351);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_352);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_353);
    stringBuffer.append(PageHelper.getWinHeight(uml2Class));
    stringBuffer.append(TEXT_354);
    stringBuffer.append(propertyCapConmentName);
    stringBuffer.append(TEXT_355);
    	}
    stringBuffer.append(TEXT_356);
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
    stringBuffer.append(TEXT_357);
    stringBuffer.append(propertyCapConmentName);
    stringBuffer.append(TEXT_358);
    stringBuffer.append(propertyCapConmentName);
    stringBuffer.append(TEXT_359);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_360);
    stringBuffer.append(relPropertyCheckboxs);
    stringBuffer.append(TEXT_361);
    stringBuffer.append(propertyCapConmentName);
    stringBuffer.append(TEXT_362);
    		}
    		if (ViewInputHelper.isApplyM2MCheckboxsTreeTab(property)) {//M2OSelectPage
    			String relPropertyShowCheckTreeJson=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relShowCheckTreeJson);
    stringBuffer.append(TEXT_363);
    stringBuffer.append(propertyCapConmentName);
    stringBuffer.append(TEXT_364);
    stringBuffer.append(propertyCapConmentName);
    stringBuffer.append(TEXT_365);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_366);
    stringBuffer.append(relPropertyShowCheckTreeJson);
    stringBuffer.append(TEXT_367);
    stringBuffer.append(propertyCapConmentName);
    stringBuffer.append(TEXT_368);
    		}
    	}
    stringBuffer.append(TEXT_369);
    }
    stringBuffer.append(TEXT_370);
    }
    else{//只应用了Entity
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

    stringBuffer.append(TEXT_371);
    stringBuffer.append(jspScriptStart);
    stringBuffer.append(TEXT_372);
    stringBuffer.append(jspScriptEnd);
    stringBuffer.append(TEXT_373);
    stringBuffer.append(jspScriptStart);
    stringBuffer.append(TEXT_374);
    stringBuffer.append(jspScriptEnd);
    stringBuffer.append(TEXT_375);
    stringBuffer.append(ownerClassCommentName);
    stringBuffer.append(TEXT_376);
    stringBuffer.append(TEXT_377);
    stringBuffer.append(jspScriptStart);
    stringBuffer.append(TEXT_378);
    stringBuffer.append(jspScriptEnd);
    stringBuffer.append(TEXT_379);
    stringBuffer.append(Config.web_resources_js_include);
    stringBuffer.append(TEXT_380);
    if(needm2oAndO2OComboGrid){
    stringBuffer.append(TEXT_381);
    }
    if(m2oAndO2OSelectTree){
    stringBuffer.append(TEXT_382);
    }
    stringBuffer.append(TEXT_383);
    if(needFck){
    stringBuffer.append(TEXT_384);
    }
    if(needm2oAndO2OComboGrid){
    stringBuffer.append(TEXT_385);
    }
    if(m2oAndO2OSelectTree){
    stringBuffer.append(TEXT_386);
    }
    stringBuffer.append(TEXT_387);
    stringBuffer.append(modelInputJsPath);
    stringBuffer.append(TEXT_388);
    List<Property> tabsList=ViewInputHelper.getTabsProperty(ownerClass);
    if(null!=tabsList&&!tabsList.isEmpty()){
    stringBuffer.append(TEXT_389);
    }
    stringBuffer.append(TEXT_390);
    Property idProperty=EntityHelper.getIDProperty(ownerClass);
    if(EntityHelper.isIDAuto(idProperty)||EntityHelper.isIDUUID(idProperty)){
    	if(!ViewInputHelper.isViewInput(idProperty)){
    stringBuffer.append(TEXT_391);
    stringBuffer.append(NameHelper.uncapSafeName(idProperty));
    stringBuffer.append(TEXT_392);
    stringBuffer.append(NameHelper.uncapSafeName(idProperty));
    stringBuffer.append(TEXT_393);
    	}
    }
    stringBuffer.append(TEXT_394);
    
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
    stringBuffer.append(TEXT_395);
    			}
    stringBuffer.append(TEXT_396);
    			needTd=2>trIncludeTd?trIncludeTd:2;
    			if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_397);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_398);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    			}				
    stringBuffer.append(TEXT_399);
    stringBuffer.append(ownerClassCommentName);
    stringBuffer.append(TEXT_400);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_401);
    stringBuffer.append(relClassOppositePropertyName);
    stringBuffer.append(TEXT_402);
    stringBuffer.append(relClassOppositePropertyName);
    stringBuffer.append(TEXT_403);
    stringBuffer.append(ownerClassIdPropertyName);
    stringBuffer.append(TEXT_404);
    stringBuffer.append(relClassOppositePropertyName);
    stringBuffer.append(TEXT_405);
    stringBuffer.append(ownerClassIdPropertyName);
    stringBuffer.append(TEXT_406);
    				tdCount+=needTd;
    stringBuffer.append(TEXT_407);
    			if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_408);
    			}
    }
    stringBuffer.append(TEXT_409);
    
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
    stringBuffer.append(TEXT_410);
    			}
    stringBuffer.append(TEXT_411);
    			if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_412);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_413);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    			}
    stringBuffer.append(TEXT_414);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_415);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_416);
    stringBuffer.append(NameHelper.uncapSafeName(idProperty));
    stringBuffer.append(TEXT_417);
    			tdCount+=needTd;
    stringBuffer.append(TEXT_418);
    			if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_419);
    			}
    stringBuffer.append(TEXT_420);
    		}
    	}else if(EntityHelper.isIDAssign(idProperty)){
 		String propertyCommentName=TypeHelper.getDocumentationOrName(idProperty);
 		String propertyUncapSafeName=NameHelper.uncapSafeName(idProperty);
 		String propertyStyleClass=ViewInputHelper.getStyleClass(idProperty);

    			if(tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_421);
    			}
    stringBuffer.append(TEXT_422);
    				needTd=2>trIncludeTd?trIncludeTd:2;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_423);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_424);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    stringBuffer.append(TEXT_425);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_426);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_427);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_428);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_429);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_430);
    stringBuffer.append(propertyStyleClass);
    stringBuffer.append(TEXT_431);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_432);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_433);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_434);
    stringBuffer.append(propertyStyleClass);
    stringBuffer.append(TEXT_435);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_436);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_437);
    				}
    stringBuffer.append(TEXT_438);
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
    stringBuffer.append(TEXT_439);
    			}
    stringBuffer.append(TEXT_440);
    	/********process parentId Property start********/
    			if (TreeStereotypeHelper.isParentIdProperty(property)) {// text
    				needTd=2>trIncludeTd?trIncludeTd:2;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_441);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_442);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    stringBuffer.append(TEXT_443);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_444);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_445);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_446);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_447);
    if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_448);
    }
    stringBuffer.append(TEXT_449);
    if(ViewInputHelper.isViewInput_readonly(property)){
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
    	/********process parentId Property end********/
    	/********process text********/
    			if (ViewInputHelper.isViewInputText(property)) {// text
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
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_458);
    				if(	ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_459);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_460);
    				}else{
    stringBuffer.append(TEXT_461);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_462);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_463);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_464);
    stringBuffer.append(propertyStyleClass);
    stringBuffer.append(TEXT_465);
    				}
    stringBuffer.append(TEXT_466);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_467);
    				}
    stringBuffer.append(TEXT_468);
    				continue;
    			}
    	/********process title********/
    			if (ViewInputHelper.isViewInputTitle(property)) {// title
    				needTd=4>trIncludeTd?trIncludeTd:4;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_469);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_470);
    					tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    stringBuffer.append(TEXT_471);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_472);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_473);
    if(						ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_474);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_475);
    							}else{
    stringBuffer.append(TEXT_476);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_477);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_478);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_479);
    stringBuffer.append(propertyStyleClass);
    stringBuffer.append(TEXT_480);
    if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_481);
    }
    stringBuffer.append(TEXT_482);
    							}
    stringBuffer.append(TEXT_483);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_484);
    				}
    stringBuffer.append(TEXT_485);
    				continue;
    			}
    	/********process select********/
    			if (ViewInputHelper.isViewInputSelect(property)) {// select
    				needTd=2>trIncludeTd?trIncludeTd:2;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_486);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_487);
    					tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    stringBuffer.append(TEXT_488);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_489);
    				Enumeration enumeration=EnumKindHelper.getAppliedEnumKindEnumeration(property);
    				if(null!=enumeration){
    					String modelEnumQualifiedName=MdaHelper.getModelQualifiedName(enumeration,PKGSuffix.enumeration,ModelNameSuffix.enumeration);
    					String modelEnumName=MdaHelper.getModelClassName(enumeration,ModelNameSuffix.enumeration);
    					String modelEnumSelectHtml=NamedUtil.getPropertyNamed(enumeration,PropertyNamedRuleKind.selectHtml);
    stringBuffer.append(TEXT_490);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_491);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_492);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_493);
    stringBuffer.append(propertyStyleClass);
    stringBuffer.append(TEXT_494);
    if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_495);
    }
    stringBuffer.append(TEXT_496);
    if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_497);
    }
    stringBuffer.append(TEXT_498);
    stringBuffer.append(modelEnumSelectHtml);
    stringBuffer.append(TEXT_499);
    				}else{
    stringBuffer.append(TEXT_500);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_501);
    if(						ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_502);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_503);
    							}else{
    stringBuffer.append(TEXT_504);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_505);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_506);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_507);
    stringBuffer.append(propertyStyleClass);
    stringBuffer.append(TEXT_508);
    if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_509);
    }
    stringBuffer.append(TEXT_510);
    							}
    stringBuffer.append(TEXT_511);
    				}
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_512);
    				}
    stringBuffer.append(TEXT_513);
    				continue;
    			}
    stringBuffer.append(TEXT_514);
    	/********process radio********/
    stringBuffer.append(TEXT_515);
    			if (ViewInputHelper.isViewInputRadio(property)) {// radio
    				needTd=4>trIncludeTd?trIncludeTd:4;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_516);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_517);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    stringBuffer.append(TEXT_518);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_519);
    				Enumeration enumeration=EnumKindHelper.getAppliedEnumKindEnumeration(property);
    				if(null!=enumeration){
    						String propertyRadioGroup=NamedUtil.getPropertyNamed(enumeration,PropertyNamedRuleKind.inputRadioGroup);
    stringBuffer.append(TEXT_520);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_521);
    stringBuffer.append(propertyRadioGroup);
    stringBuffer.append(TEXT_522);
    				}else{
    stringBuffer.append(TEXT_523);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_524);
    if(						ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_525);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_526);
    							}else{
    stringBuffer.append(TEXT_527);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_528);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_529);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_530);
    stringBuffer.append(propertyStyleClass);
    stringBuffer.append(TEXT_531);
    if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_532);
    }
    stringBuffer.append(TEXT_533);
    							}
    stringBuffer.append(TEXT_534);
    				}
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_535);
    				}
    stringBuffer.append(TEXT_536);
    				continue;
    			}
    	/********process datePicker********/
    			if (ViewInputHelper.isViewInputDatePicker(property)) {// datePicker
    				String propertyToDateTimeCapName=PropertyNamedRuleKind.dateToDateTimeStr.getRuleCapNamed(property);
    				String propertyToDateTimeUncapName=PropertyNamedRuleKind.dateToDateTimeStr.getRuleUnCapNamed(property);
    				needTd=2>trIncludeTd?trIncludeTd:2;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_537);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_538);
    					tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    stringBuffer.append(TEXT_539);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_540);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_541);
    if(						ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_542);
    stringBuffer.append(propertyToDateTimeUncapName);
    stringBuffer.append(TEXT_543);
    							}else{
    stringBuffer.append(TEXT_544);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_545);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_546);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_547);
    stringBuffer.append(propertyStyleClass);
    stringBuffer.append(TEXT_548);
    if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_549);
    }
    stringBuffer.append(TEXT_550);
    							}
    stringBuffer.append(TEXT_551);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_552);
    				}
    stringBuffer.append(TEXT_553);
    				continue;
    				}
    	/********process texttarea********/
    			if (ViewInputHelper.isViewInputTextarea(property)) {// texttarea 
    				needTd=4>trIncludeTd?trIncludeTd:4;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_554);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_555);
    					tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    stringBuffer.append(TEXT_556);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_557);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_558);
    if(						ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_559);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_560);
    							}else{
    stringBuffer.append(TEXT_561);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_562);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_563);
    stringBuffer.append(propertyStyleClass);
    stringBuffer.append(TEXT_564);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_565);
    							}
    stringBuffer.append(TEXT_566);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_567);
    				}
    stringBuffer.append(TEXT_568);
    				continue;
    			}	
    stringBuffer.append(TEXT_569);
    	/********process checkbox********/
    			if (ViewInputHelper.isViewInputCheckbox(property)) {// checkbox
    				needTd=4>trIncludeTd?trIncludeTd:4;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_570);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_571);
    						tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    stringBuffer.append(TEXT_572);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_573);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_574);
    if(						ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_575);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_576);
    							}else{
    stringBuffer.append(TEXT_577);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_578);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_579);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_580);
    stringBuffer.append(propertyStyleClass);
    stringBuffer.append(TEXT_581);
    							}
    stringBuffer.append(TEXT_582);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_583);
    				}
    stringBuffer.append(TEXT_584);
    				continue;
    			}
    stringBuffer.append(TEXT_585);
    	/********process file********/
    stringBuffer.append(TEXT_586);
    //			if (isViewInputFile(property)) {// file
    //			}		
    	/********process image********/
    stringBuffer.append(TEXT_587);
    //			if (isViewInputImage(property)) {// image
    //			}			
    	/********process content********/
    stringBuffer.append(TEXT_588);
    //			if (isViewInputContent(property)) {// content
    //			}
    
/*****************************************************************
 * process rel 
/*****************************************************************/

    /********process M2OSelect********/
    stringBuffer.append(TEXT_589);
    			if (ViewInputHelper.isApplyM2OSelect(property)) {//M2OSelect
    				Class propertyType = (Class) property.getType();
    				String propertyTypeComment = TypeHelper.getDocumentationOrName(propertyType);
     				Property propertyTypeIdProperty=EntityHelper.getIDProperty(propertyType);
     				String propertyTypeIdPropertyUncapSafeName=NameHelper.uncapSafeName(propertyTypeIdProperty);
     				String listLabelPropertyUncapSafeName=ViewListHelper.getViewListLabelRelPropertyName(property);
    				needTd=2>trIncludeTd?trIncludeTd:2;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_590);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_591);
    					tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    				//String m2oSelectHtml=NamedUtil.getPropertyNamed(property,PropertyNamedRuleKind.selectHtml);
    stringBuffer.append(TEXT_592);
    stringBuffer.append(propertyTypeComment);
    stringBuffer.append(TEXT_593);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_594);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_595);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_596);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_597);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_598);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_599);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_600);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_601);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_602);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_603);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_604);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_605);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_606);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_607);
    				}
    stringBuffer.append(TEXT_608);
    				continue;
    			}	
    stringBuffer.append(TEXT_609);
    	/********process M2OSelectPage********/
    			if (ViewInputHelper.isApplyM2OSelectPage(property)) {//M2OSelectPage
    				Class propertyType = (Class) property.getType();
    				String propertyTypeComment = TypeHelper.getDocumentationOrName(propertyType);
     				Property propertyTypeIdProperty=EntityHelper.getIDProperty(propertyType);
     				String propertyTypeIdPropertyUncapSafeName=NameHelper.uncapSafeName(propertyTypeIdProperty);
    				needTd=2>trIncludeTd?trIncludeTd:2;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_610);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_611);
    					tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    stringBuffer.append(TEXT_612);
    stringBuffer.append(propertyTypeComment);
    stringBuffer.append(TEXT_613);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_614);
    							if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_615);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_616);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_617);
    							}else{
    stringBuffer.append(TEXT_618);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_619);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_620);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_621);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_622);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_623);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_624);
    stringBuffer.append(propertyStyleClass);
    stringBuffer.append(TEXT_625);
    if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_626);
    }
    stringBuffer.append(TEXT_627);
    							}
    stringBuffer.append(TEXT_628);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_629);
    				}
    stringBuffer.append(TEXT_630);
    				continue;
    			}
    stringBuffer.append(TEXT_631);
    	/********process O2OSelect********/
    			if (ViewInputHelper.isApplyO2OSelect(property)) {//O2OSelect
    stringBuffer.append(TEXT_632);
    				Class propertyType = (Class) property.getType();
    				String propertyTypeComment = TypeHelper.getDocumentationOrName(propertyType);
     				Property propertyTypeIdProperty=EntityHelper.getIDProperty(propertyType);
     				String propertyTypeIdPropertyUncapSafeName=NameHelper.uncapSafeName(propertyTypeIdProperty);
     				String listLabelPropertyUncapSafeName=ViewListHelper.getViewListLabelRelPropertyName(property);
    				needTd=2>trIncludeTd?trIncludeTd:2;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_633);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_634);
    					tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    				String O2OSelectHtml=NamedUtil.getPropertyNamed(property,PropertyNamedRuleKind.selectHtml);
    stringBuffer.append(TEXT_635);
    stringBuffer.append(propertyTypeComment);
    stringBuffer.append(TEXT_636);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_637);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_638);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_639);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_640);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_641);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_642);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_643);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_644);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_645);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_646);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_647);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_648);
    stringBuffer.append(listLabelPropertyUncapSafeName);
    stringBuffer.append(TEXT_649);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_650);
    				}
    stringBuffer.append(TEXT_651);
    				continue;
    			}	
    stringBuffer.append(TEXT_652);
    	/********process O2OSelectPage********/
    			if (ViewInputHelper.isApplyO2OSelectPage(property)) {//O2OSelectPage
    				Class propertyType = (Class) property.getType();
    				String propertyTypeComment = TypeHelper.getDocumentationOrName(propertyType);
     				Property propertyTypeIdProperty=EntityHelper.getIDProperty(propertyType);
     				String propertyTypeIdPropertyUncapSafeName=NameHelper.uncapSafeName(propertyTypeIdProperty);
    				needTd=2>trIncludeTd?trIncludeTd:2;
    				if(tdCount%trIncludeTd+needTd>trIncludeTd){
    stringBuffer.append(TEXT_653);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_654);
    					tdCount+=trIncludeTd-(tdCount%trIncludeTd);
    				}
    stringBuffer.append(TEXT_655);
    stringBuffer.append(propertyTypeComment);
    stringBuffer.append(TEXT_656);
    stringBuffer.append(needTd-1);
    stringBuffer.append(TEXT_657);
    							if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_658);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_659);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_660);
    							}else{
    stringBuffer.append(TEXT_661);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_662);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_663);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_664);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_665);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_666);
    stringBuffer.append(propertyTypeIdPropertyUncapSafeName);
    stringBuffer.append(TEXT_667);
    stringBuffer.append(propertyStyleClass);
    stringBuffer.append(TEXT_668);
    if(ViewInputHelper.isViewInput_readonly(property)){
    stringBuffer.append(TEXT_669);
    }
    stringBuffer.append(TEXT_670);
    							}
    stringBuffer.append(TEXT_671);
    				tdCount+=needTd;
    				if (tdCount%trIncludeTd==0){
    stringBuffer.append(TEXT_672);
    				}
    stringBuffer.append(TEXT_673);
    				continue;
    			}
    stringBuffer.append(TEXT_674);
    	}
    	if (tdCount%trIncludeTd!=0){
    stringBuffer.append(TEXT_675);
    stringBuffer.append(trIncludeTd-(tdCount%trIncludeTd));
    stringBuffer.append(TEXT_676);
    	}
    
	/*****************************************************************
	 * property simple input end
	/*****************************************************************/

    stringBuffer.append(TEXT_677);
    
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
    stringBuffer.append(TEXT_678);
    stringBuffer.append(trIncludeTd);
    stringBuffer.append(TEXT_679);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_680);
    stringBuffer.append(relPropertyCheckboxs);
    stringBuffer.append(TEXT_681);
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
    stringBuffer.append(TEXT_682);
    stringBuffer.append(trIncludeTd);
    stringBuffer.append(TEXT_683);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_684);
    stringBuffer.append(relPropertyCheckTreeDomId);
    stringBuffer.append(TEXT_685);
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
    stringBuffer.append(TEXT_686);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_687);
    if(trIncludeTd-1>1){
    stringBuffer.append(TEXT_688);
    stringBuffer.append(trIncludeTd-1);
    stringBuffer.append(TEXT_689);
    }
    stringBuffer.append(TEXT_690);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_691);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_692);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_693);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_694);
    		}
    }
    /********process file properties********/
    List<Property> filePropertyList=ViewInputHelper.getViewInputFile(uml2Class);
    if(null!=filePropertyList&&filePropertyList.size()>0){
    	for(Property property:filePropertyList){
     			String propertyCommentName=TypeHelper.getDocumentationOrName(property);
     			String propertyUncapSafeName=NameHelper.uncapSafeName(property);
     			//String propertyStyleClass=ViewInputHelper.getStyleClass(property);
    stringBuffer.append(TEXT_695);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_696);
    if(trIncludeTd-1>1){
    stringBuffer.append(TEXT_697);
    stringBuffer.append(trIncludeTd-1);
    stringBuffer.append(TEXT_698);
    }
    stringBuffer.append(TEXT_699);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_700);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_701);
    	}
    }
    /********process content properties********/
    if(null!=contentPropertyList&&contentPropertyList.size()>0){
    for(Property property:contentPropertyList){
     			String propertyCommentName=TypeHelper.getDocumentationOrName(property);
     			String propertyUncapSafeName=NameHelper.uncapSafeName(property);
     			//String propertyStyleClass=ViewInputHelper.getStyleClass(property);
    stringBuffer.append(TEXT_702);
    stringBuffer.append(trIncludeTd);
    stringBuffer.append(TEXT_703);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_704);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_705);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_706);
    stringBuffer.append(NameHelper.getUncapName(property));
    stringBuffer.append(TEXT_707);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_708);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_709);
    }}
    stringBuffer.append(TEXT_710);
    if(!tabsList.isEmpty()||!contentTabPropertyList.isEmpty()){
    stringBuffer.append(TEXT_711);
    	for(Iterator<Property> iter=contentTabPropertyList.iterator();iter.hasNext();){
    			Property property=iter.next();
     			String propertyCommentName=TypeHelper.getDocumentationOrName(property);
     			String propertyUncapSafeName=NameHelper.uncapSafeName(property);
     			//String propertyStyleClass=ViewInputHelper.getStyleClass(property);
    			String propertyCapConmentName=TypeHelper.getDocumentationOrName(property);
    stringBuffer.append(TEXT_712);
    stringBuffer.append(propertyCommentName);
    stringBuffer.append(TEXT_713);
    stringBuffer.append(propertyCapConmentName);
    stringBuffer.append(TEXT_714);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_715);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_716);
    stringBuffer.append(NameHelper.getUncapName(property));
    stringBuffer.append(TEXT_717);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_718);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_719);
    stringBuffer.append(PageHelper.getWinHeight(uml2Class));
    stringBuffer.append(TEXT_720);
    stringBuffer.append(propertyCapConmentName);
    stringBuffer.append(TEXT_721);
    	}
    stringBuffer.append(TEXT_722);
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
    stringBuffer.append(TEXT_723);
    stringBuffer.append(propertyCapConmentName);
    stringBuffer.append(TEXT_724);
    stringBuffer.append(propertyCapConmentName);
    stringBuffer.append(TEXT_725);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_726);
    stringBuffer.append(relPropertyCheckboxs);
    stringBuffer.append(TEXT_727);
    stringBuffer.append(propertyCapConmentName);
    stringBuffer.append(TEXT_728);
    		}
    		if (ViewInputHelper.isApplyM2MCheckboxsTreeTab(property)) {//M2OSelectPage
    			String relPropertyShowCheckTreeJson=NamedUtil.getPropertyNamed(relTargetClass,PropertyNamedRuleKind.relShowCheckTreeJson);
    stringBuffer.append(TEXT_729);
    stringBuffer.append(propertyCapConmentName);
    stringBuffer.append(TEXT_730);
    stringBuffer.append(propertyCapConmentName);
    stringBuffer.append(TEXT_731);
    stringBuffer.append(relTargetClassCommentName);
    stringBuffer.append(TEXT_732);
    stringBuffer.append(relPropertyShowCheckTreeJson);
    stringBuffer.append(TEXT_733);
    stringBuffer.append(propertyCapConmentName);
    stringBuffer.append(TEXT_734);
    		}
    	}
    stringBuffer.append(TEXT_735);
    }
    stringBuffer.append(TEXT_736);
    }
    stringBuffer.append(TEXT_737);
    return stringBuffer.toString();
  }
}
