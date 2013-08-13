package com.jeefuse.mda.gen.template.main.java.entity.rto;

import net.taylor.mda.generator.parse.NameRuled.nameRuled.*;
import net.taylor.mda.generator.parse.NameRuled.className.*;
import net.taylor.mda.generator.parse.NameRuled.*;
import net.taylor.mda.generator.parse.page.*;
import net.taylor.mda.generator.parse.*;
import java.util.Iterator;
import java.util.List;
import net.taylor.mda.generator.parse.entity.*;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.*;
import net.taylor.mda.generator.util.*;
import org.eclipse.emf.codegen.util.*;

public class EntityRTO
{
  protected static String nl;
  public static synchronized EntityRTO create(String lineSeparator)
  {
    nl = lineSeparator;
    EntityRTO result = new EntityRTO();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "/*" + NL + " * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the \"License\")" + NL + " * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms." + NL + " * email:yonclv@gmail.com" + NL + " */" + NL + "package ";
  protected final String TEXT_3 = ";";
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * ";
  protected final String TEXT_6 = " Entity RTO(Request transfer object)." + NL + " *" + NL + " * @author ";
  protected final String TEXT_7 = NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_8 = " implements GenericRTO<";
  protected final String TEXT_9 = ">, Serializable{" + NL + "\t/** @generated */" + NL + "\tprivate static final long serialVersionUID = 1L;";
  protected final String TEXT_10 = NL + "\t/**" + NL + "\t * ------------------------------------------------------------------------" + NL + "\t * ";
  protected final String TEXT_11 = NL + "\t * ------------------------------------------------------------------------" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_12 = " ";
  protected final String TEXT_13 = "() {" + NL + "\t\treturn ";
  protected final String TEXT_14 = ";" + NL + "\t}" + NL + "" + NL + "\t/** @generated */" + NL + "\tpublic void set";
  protected final String TEXT_15 = "(final ";
  protected final String TEXT_16 = " ";
  protected final String TEXT_17 = ") {" + NL + "\t\tthis.";
  protected final String TEXT_18 = " = ";
  protected final String TEXT_19 = ";" + NL + "\t}" + NL + "\t" + NL + "\t/** @generated */" + NL + "\tprivate ";
  protected final String TEXT_20 = " ";
  protected final String TEXT_21 = " = ";
  protected final String TEXT_22 = ";";
  protected final String TEXT_23 = NL + NL + "\t/** @generated */" + NL + "\tpublic String getId() {" + NL + "\t\treturn ";
  protected final String TEXT_24 = ";" + NL + "\t}" + NL + "\t" + NL + "\t/** @generated */" + NL + "\tpublic void setId(final String id) {" + NL + "\t\tthis.";
  protected final String TEXT_25 = " = id;" + NL + "\t}";
  protected final String TEXT_26 = "\t";
  protected final String TEXT_27 = NL + NL + "\t/**" + NL + "\t * ------------------------------------------------------------------------" + NL + "\t * ";
  protected final String TEXT_28 = NL + "\t * ------------------------------------------------------------------------" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_29 = " ";
  protected final String TEXT_30 = "() {";
  protected final String TEXT_31 = NL + "\t\tif (this.";
  protected final String TEXT_32 = " == null) {";
  protected final String TEXT_33 = NL + "\t\t\tthis.";
  protected final String TEXT_34 = " = new HashSet<";
  protected final String TEXT_35 = ">();";
  protected final String TEXT_36 = NL + "\t\t\tthis.";
  protected final String TEXT_37 = " = new ArrayList<";
  protected final String TEXT_38 = ">();";
  protected final String TEXT_39 = NL + "\t\t}";
  protected final String TEXT_40 = NL + "\t\tif (this.";
  protected final String TEXT_41 = " == null) {" + NL + "\t\t\tthis.";
  protected final String TEXT_42 = " = new ";
  protected final String TEXT_43 = "();        " + NL + "\t\t}";
  protected final String TEXT_44 = NL + "\t\treturn ";
  protected final String TEXT_45 = ";" + NL + "\t}" + NL + "" + NL + "\t/** @generated */" + NL + "\tpublic void set";
  protected final String TEXT_46 = "(final ";
  protected final String TEXT_47 = " ";
  protected final String TEXT_48 = ") {" + NL + "\t\tthis.";
  protected final String TEXT_49 = " = ";
  protected final String TEXT_50 = ";" + NL + "\t}" + NL + "\t" + NL + "\t/** @generated */" + NL + "\tprivate ";
  protected final String TEXT_51 = " ";
  protected final String TEXT_52 = " = ";
  protected final String TEXT_53 = ";";
  protected final String TEXT_54 = "\t" + NL + "\t" + NL + "\t/**" + NL + "\t * convert to date string for ";
  protected final String TEXT_55 = NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic String get";
  protected final String TEXT_56 = "() {" + NL + "\t\treturn ";
  protected final String TEXT_57 = ";" + NL + "\t}" + NL + "\t" + NL + "\t/** @generated */" + NL + "\tpublic void set";
  protected final String TEXT_58 = "(final String ";
  protected final String TEXT_59 = ") {" + NL + "\t\tthis.";
  protected final String TEXT_60 = " = ";
  protected final String TEXT_61 = ";" + NL + "\t}" + NL + "\t" + NL + "\t/** @generated */" + NL + "\tprivate String ";
  protected final String TEXT_62 = ";";
  protected final String TEXT_63 = NL + "\t";
  protected final String TEXT_64 = NL + NL + "\t/**" + NL + "\t * search ";
  protected final String TEXT_65 = " for ";
  protected final String TEXT_66 = NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic String get";
  protected final String TEXT_67 = "() {" + NL + "\t\treturn ";
  protected final String TEXT_68 = ";" + NL + "\t}" + NL + "\t" + NL + "\t/** @generated */" + NL + "\tpublic void set";
  protected final String TEXT_69 = "(final String ";
  protected final String TEXT_70 = ") {" + NL + "\t\tthis.";
  protected final String TEXT_71 = " = ";
  protected final String TEXT_72 = ";" + NL + "\t}" + NL + "\t" + NL + "\t/** @generated */" + NL + "\tprivate String ";
  protected final String TEXT_73 = " = null;";
  protected final String TEXT_74 = "\t";
  protected final String TEXT_75 = NL + "\t" + NL + "\t/**" + NL + "\t * search field two for ";
  protected final String TEXT_76 = NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic String get";
  protected final String TEXT_77 = "() {" + NL + "\t\treturn ";
  protected final String TEXT_78 = ";" + NL + "\t}" + NL + "\t" + NL + "\t/** @generated */" + NL + "\tpublic void set";
  protected final String TEXT_79 = "(final String ";
  protected final String TEXT_80 = ") {" + NL + "\t\tthis.";
  protected final String TEXT_81 = " = ";
  protected final String TEXT_82 = ";" + NL + "\t}" + NL + "\t" + NL + "\t/** @generated */" + NL + "\tprivate String ";
  protected final String TEXT_83 = " = null;";
  protected final String TEXT_84 = NL + NL + NL + "\t// ------------------------------------------------------------------------" + NL + "\t// RTO <==> model convert " + NL + "\t// ------------------------------------------------------------------------" + NL + "\t" + NL + "\t/**" + NL + "\t * 从请求中构造要更新的实体对象." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_85 = " getModifiedModel(";
  protected final String TEXT_86 = " oldModel) {";
  protected final String TEXT_87 = "\t";
  protected final String TEXT_88 = NL + "\t\t//oldModel.setId(this.";
  protected final String TEXT_89 = ");//";
  protected final String TEXT_90 = " ";
  protected final String TEXT_91 = NL + "\t\toldModel.setId(this.";
  protected final String TEXT_92 = ");//";
  protected final String TEXT_93 = " ";
  protected final String TEXT_94 = NL + "\t\t";
  protected final String TEXT_95 = "//";
  protected final String TEXT_96 = "oldModel.set";
  protected final String TEXT_97 = "(this.";
  protected final String TEXT_98 = ");//";
  protected final String TEXT_99 = " ";
  protected final String TEXT_100 = NL + "\t\t//oldModel.set";
  protected final String TEXT_101 = "(new ";
  protected final String TEXT_102 = "());//";
  protected final String TEXT_103 = " ";
  protected final String TEXT_104 = NL + "\t\toldModel.set";
  protected final String TEXT_105 = "(new ";
  protected final String TEXT_106 = "());//";
  protected final String TEXT_107 = " ";
  protected final String TEXT_108 = NL + "\t\t";
  protected final String TEXT_109 = "//";
  protected final String TEXT_110 = "oldModel.set";
  protected final String TEXT_111 = "(this.";
  protected final String TEXT_112 = ");//";
  protected final String TEXT_113 = " ";
  protected final String TEXT_114 = "\t";
  protected final String TEXT_115 = NL + "\t\t";
  protected final String TEXT_116 = "//";
  protected final String TEXT_117 = "//";
  protected final String TEXT_118 = "oldModel.set";
  protected final String TEXT_119 = "(this.";
  protected final String TEXT_120 = ");//";
  protected final String TEXT_121 = " //rel oto ";
  protected final String TEXT_122 = NL + "\t\t";
  protected final String TEXT_123 = "//";
  protected final String TEXT_124 = "oldModel.set";
  protected final String TEXT_125 = "(this.";
  protected final String TEXT_126 = ");//";
  protected final String TEXT_127 = " rel m2o ";
  protected final String TEXT_128 = NL + "\t\t";
  protected final String TEXT_129 = "//";
  protected final String TEXT_130 = "oldModel.set";
  protected final String TEXT_131 = "(this.";
  protected final String TEXT_132 = ");//";
  protected final String TEXT_133 = " rel otm ";
  protected final String TEXT_134 = NL + "\t\t";
  protected final String TEXT_135 = "//";
  protected final String TEXT_136 = "oldModel.set";
  protected final String TEXT_137 = "(this.";
  protected final String TEXT_138 = ");//";
  protected final String TEXT_139 = " rel mtm ";
  protected final String TEXT_140 = NL + "\t\treturn oldModel;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t *从请求中构造要保存的实体对象." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_141 = " getNewModel() {" + NL + "\t\t";
  protected final String TEXT_142 = " new";
  protected final String TEXT_143 = "=new ";
  protected final String TEXT_144 = "();";
  protected final String TEXT_145 = "\t";
  protected final String TEXT_146 = NL + "\t\t//new";
  protected final String TEXT_147 = ".setId(this.";
  protected final String TEXT_148 = ");//id auto generated ";
  protected final String TEXT_149 = NL + "\t\tnew";
  protected final String TEXT_150 = ".setId(this.";
  protected final String TEXT_151 = ");//id ";
  protected final String TEXT_152 = NL + "\t\t";
  protected final String TEXT_153 = "//";
  protected final String TEXT_154 = "new";
  protected final String TEXT_155 = ".set";
  protected final String TEXT_156 = "(this.";
  protected final String TEXT_157 = ");//id ";
  protected final String TEXT_158 = NL + "\t\tnew";
  protected final String TEXT_159 = ".set";
  protected final String TEXT_160 = "(new ";
  protected final String TEXT_161 = "());//";
  protected final String TEXT_162 = " ";
  protected final String TEXT_163 = NL + "\t\tnew";
  protected final String TEXT_164 = ".set";
  protected final String TEXT_165 = "(new ";
  protected final String TEXT_166 = "());//";
  protected final String TEXT_167 = " ";
  protected final String TEXT_168 = NL + "\t\t";
  protected final String TEXT_169 = "//";
  protected final String TEXT_170 = "new";
  protected final String TEXT_171 = ".set";
  protected final String TEXT_172 = "(this.";
  protected final String TEXT_173 = ");//";
  protected final String TEXT_174 = " ";
  protected final String TEXT_175 = NL + "\t\t";
  protected final String TEXT_176 = "//";
  protected final String TEXT_177 = "new";
  protected final String TEXT_178 = ".set";
  protected final String TEXT_179 = "(this.";
  protected final String TEXT_180 = ");//";
  protected final String TEXT_181 = " rel oto ";
  protected final String TEXT_182 = NL + "\t\t";
  protected final String TEXT_183 = "//";
  protected final String TEXT_184 = "new";
  protected final String TEXT_185 = ".set";
  protected final String TEXT_186 = "(this.";
  protected final String TEXT_187 = ");//";
  protected final String TEXT_188 = " rel m2o ";
  protected final String TEXT_189 = NL + "\t\t";
  protected final String TEXT_190 = "//";
  protected final String TEXT_191 = "new";
  protected final String TEXT_192 = ".set";
  protected final String TEXT_193 = "(this.";
  protected final String TEXT_194 = ");//";
  protected final String TEXT_195 = " rel otm ";
  protected final String TEXT_196 = NL + "\t\t";
  protected final String TEXT_197 = "//";
  protected final String TEXT_198 = "new";
  protected final String TEXT_199 = ".set";
  protected final String TEXT_200 = "(this.";
  protected final String TEXT_201 = ");//";
  protected final String TEXT_202 = " rel mtm ";
  protected final String TEXT_203 = NL + "\t\treturn new";
  protected final String TEXT_204 = ";" + NL + "\t}";
  protected final String TEXT_205 = NL + "\t/**" + NL + "\t * 用实体对象填充数据." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void setModel(";
  protected final String TEXT_206 = " model) {";
  protected final String TEXT_207 = NL + "\t\tthis.setId(model.";
  protected final String TEXT_208 = "());//id ";
  protected final String TEXT_209 = NL + "\t\tthis.set";
  protected final String TEXT_210 = "(model.";
  protected final String TEXT_211 = "());//";
  protected final String TEXT_212 = " ";
  protected final String TEXT_213 = NL + "\t}";
  protected final String TEXT_214 = "\t" + NL + "\t// ------------------------------------------------------------------------" + NL + "\t// Utils" + NL + "\t// ------------------------------------------------------------------------";
  protected final String TEXT_215 = NL;
  protected final String TEXT_216 = NL + "\t/** @generated */" + NL + "\t@Override" + NL + "\tpublic String toString() {" + NL + "\t\treturn ";
  protected final String TEXT_217 = ";" + NL + "\t}" + NL + "" + NL + "" + NL + "}";
  protected final String TEXT_218 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    Class uml2Class = (Class) argument;Package uml2Package = uml2Class.getPackage();
    
/*******clazz wrap********/	
UmlClassWrap clazzWrap=new UmlClassWrap(uml2Class);
String modelCommentName=clazzWrap.getCommentName();
//model RTO define
ClassNameDefineCommon rtoDefine=clazzWrap.getNameDefineRTO();
String modelRTOPackageName=rtoDefine.getPackageQualifiedName();
String modelRTOClassName=rtoDefine.getClassCapName();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(modelRTOPackageName);
    stringBuffer.append(TEXT_3);
    ImportManager importManager = ImportHelper.makeImportManager("");
    
//model entity define
ClassNameDefineCommon entityDefine=clazzWrap.getNameDefineEntity();
String modelEntityQualifiedName=entityDefine.getClassQualifiedName();
String modelEntityName=entityDefine.getClassCapName();
importManager.addImport(modelEntityQualifiedName);

//add imports
importManager.addImport(Config.base_GenericRTO);
importManager.addImport("java.io.Serializable");

    stringBuffer.append(TEXT_4);
    
StringBuffer importStringBuffer = stringBuffer;
int importInsertionPoint = stringBuffer.length();
importManager.addCompilationUnitImports(stringBuffer.toString());

    stringBuffer.append(TEXT_5);
    stringBuffer.append(modelCommentName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(System.getProperty("user.name"));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(modelRTOClassName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_9);
    
Property idProperty=EntityHelper.getIDProperty(uml2Class);
List<Property> listProperty=EntityHelper.getAllPropertyExcluedIdProperty(uml2Class);

    stringBuffer.append(TEXT_10);
    stringBuffer.append(TypeHelper.getDocumentationOrName(idProperty));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(MdaHelper.getImportedFeatureType(idProperty));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(ClassHelper.getGetAccessor(idProperty));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(NameHelper.uncapSafeName(idProperty));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(ClassHelper.getAccessorName(idProperty));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(MdaHelper.getImportedFeatureType(idProperty));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(NameHelper.uncapSafeName(idProperty));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(NameHelper.uncapSafeName(idProperty));
    stringBuffer.append(TEXT_18);
    stringBuffer.append(NameHelper.uncapSafeName(idProperty));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(MdaHelper.getImportedFeatureType(idProperty));
    stringBuffer.append(TEXT_20);
    stringBuffer.append(NameHelper.uncapSafeName(idProperty));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(TypeHelper.getDefaultValue(idProperty));
    stringBuffer.append(TEXT_22);
    if(!idProperty.getName().equals("id")){
    stringBuffer.append(TEXT_23);
    stringBuffer.append(NameHelper.uncapSafeName(idProperty));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(NameHelper.uncapSafeName(idProperty));
    stringBuffer.append(TEXT_25);
    }
    stringBuffer.append(TEXT_26);
    for (Iterator<Property> i=listProperty.iterator(); i.hasNext();) { Property property = (Property)i.next();
    if (property.getType() !=null) {
    stringBuffer.append(TEXT_27);
    stringBuffer.append(TypeHelper.getDocumentationOrName(property));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(MdaHelper.getImportedFeatureType(property));
    stringBuffer.append(TEXT_29);
    stringBuffer.append(ClassHelper.getGetAccessor(property));
    stringBuffer.append(TEXT_30);
    	if (property.getAssociation() != null && property.isMultivalued()) {
    stringBuffer.append(TEXT_31);
    stringBuffer.append(NameHelper.uncapSafeName(property));
    stringBuffer.append(TEXT_32);
    			if (property.getOpposite() == null || property.getOpposite().isMultivalued()) {
    			importManager.addImport("java.util.HashSet");
    stringBuffer.append(TEXT_33);
    stringBuffer.append(NameHelper.uncapSafeName(property));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(MdaHelper.getImportedType(property.getType()));
    stringBuffer.append(TEXT_35);
    			} else {
    				importManager.addImport("java.util.ArrayList");
    stringBuffer.append(TEXT_36);
    stringBuffer.append(NameHelper.uncapSafeName(property));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(MdaHelper.getImportedType(property.getType()));
    stringBuffer.append(TEXT_38);
    			}
    stringBuffer.append(TEXT_39);
    	}
    	else if (ClassHelper.isComposite(property)||ClassHelper.isOneToOne(property)||ClassHelper.isManyToOne(property)) {
    stringBuffer.append(TEXT_40);
    stringBuffer.append(NameHelper.uncapSafeName(property));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(NameHelper.uncapSafeName(property));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(MdaHelper.getImportedType(property.getType()));
    stringBuffer.append(TEXT_43);
    	}
    stringBuffer.append(TEXT_44);
    stringBuffer.append(NameHelper.uncapSafeName(property));
    stringBuffer.append(TEXT_45);
    stringBuffer.append(ClassHelper.getAccessorName(property));
    stringBuffer.append(TEXT_46);
    stringBuffer.append(MdaHelper.getImportedFeatureType(property));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(NameHelper.uncapSafeName(property));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(NameHelper.uncapSafeName(property));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(NameHelper.uncapSafeName(property));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(MdaHelper.getImportedFeatureType(property));
    stringBuffer.append(TEXT_51);
    stringBuffer.append(NameHelper.uncapSafeName(property));
    stringBuffer.append(TEXT_52);
    stringBuffer.append(TypeHelper.getDefaultValue(property));
    stringBuffer.append(TEXT_53);
    /**********************************************************
   process date
<%*********************************************************/
    	if(TypeHelper.isDate(property)){
    		//String propertyName=NameHelper.uncapSafeName(property);
    		String propertyToDateTimeCapName=PropertyNamedRuleKind.dateToDateTimeStr.getRuleCapNamed(property);
    		String propertyToDateTimeUncapName=PropertyNamedRuleKind.dateToDateTimeStr.getRuleUnCapNamed(property);
    		//importManager.addImport("com.jeefuse.base.utils.common.DateUtil");
    stringBuffer.append(TEXT_54);
    stringBuffer.append(TypeHelper.getDocumentationOrName(property));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(propertyToDateTimeCapName);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(propertyToDateTimeUncapName);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(propertyToDateTimeCapName);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(propertyToDateTimeUncapName);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(propertyToDateTimeUncapName);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(propertyToDateTimeUncapName);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(propertyToDateTimeUncapName);
    stringBuffer.append(TEXT_62);
    	}
    stringBuffer.append(TEXT_63);
    //process search
    	if(ViewSearchHelper.isSearch(property)){
    		String searchName=ViewSearchHelper.getSearchFieldName(property);
    		String searchCapName=NameHelper.getCapName(searchName);
    	if(!ViewSearchHelper.isSearchFieldMatchPropertyName(property)){
    		String SearchFieldLabel=ViewSearchHelper.getSearchFieldLabel(property);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(SearchFieldLabel);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(TypeHelper.getDocumentationOrName(property));
    stringBuffer.append(TEXT_66);
    stringBuffer.append(searchCapName);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(searchName);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(searchCapName);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(searchName);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(searchName);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(searchName);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(searchName);
    stringBuffer.append(TEXT_73);
    	}
    stringBuffer.append(TEXT_74);
    	if(ViewSearchHelper.hasSearchFieldTwoName(property)){
    		String searchTwoName=ViewSearchHelper.getSearchFieldTwoName(property);
    		String searchTwoCapName=NameHelper.getCapName(searchTwoName);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(TypeHelper.getDocumentationOrName(property));
    stringBuffer.append(TEXT_76);
    stringBuffer.append(searchTwoCapName);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(searchTwoName);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(searchTwoCapName);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(searchTwoName);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(searchTwoName);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(searchTwoName);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(searchTwoName);
    stringBuffer.append(TEXT_83);
    	}
    	}
    }
    }
    stringBuffer.append(TEXT_84);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_86);
    int codifiedModelCount=1;
    /********process simple property start********/
    stringBuffer.append(TEXT_87);
    List<Property> simpleList=ViewInputHelper.getViewInputPropertiesForSimple(uml2Class);
    for (Iterator<Property> i=simpleList.iterator(); i.hasNext();) { 
    	Property property = (Property)i.next();
    	String propertyName=NameHelper.uncapSafeName(property);
    	//String propertyAccessorName=ClassHelper.getAccessorName(property);
    	boolean isComment=false;
    	if(!ViewInputHelper.isViewInput(property)||ViewInputHelper.isViewInput_readonly(property)){
    		isComment=true;
    	}
    	//process id
    	if(EntityHelper.isIDProperty(property)){
    		if(EntityHelper.isIDUUID(property)){
    stringBuffer.append(TEXT_88);
    stringBuffer.append(propertyName);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(propertyName);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(codifiedModelCount++);
    		}else if(EntityHelper.isIDAssign(idProperty)){
    stringBuffer.append(TEXT_91);
    stringBuffer.append(propertyName);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(propertyName);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(codifiedModelCount++);
    		}else{
    stringBuffer.append(TEXT_94);
    if(isComment){
    stringBuffer.append(TEXT_95);
    }
    stringBuffer.append(TEXT_96);
    stringBuffer.append(ClassHelper.getAccessorName(idProperty));
    stringBuffer.append(TEXT_97);
    stringBuffer.append(propertyName);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(propertyName);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(codifiedModelCount++);
    		}
    	}else if(property.getType() !=null) {
    		String name = property.getName();
    		if (name.equalsIgnoreCase("createTime")||name.equalsIgnoreCase("createDate")){
    stringBuffer.append(TEXT_100);
    stringBuffer.append(ClassHelper.getAccessorName(property));
    stringBuffer.append(TEXT_101);
    stringBuffer.append(ImportHelper.getImportedName("java.util.Date"));
    stringBuffer.append(TEXT_102);
    stringBuffer.append(codifiedModelCount++);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(TypeHelper.getDocumentationOrName(property));
    		}else if (name.equalsIgnoreCase("updateTime")||name.equalsIgnoreCase("updateDate")){
    stringBuffer.append(TEXT_104);
    stringBuffer.append(ClassHelper.getAccessorName(property));
    stringBuffer.append(TEXT_105);
    stringBuffer.append(ImportHelper.getImportedName("java.util.Date"));
    stringBuffer.append(TEXT_106);
    stringBuffer.append(codifiedModelCount++);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(TypeHelper.getDocumentationOrName(property));
    		}else{
    stringBuffer.append(TEXT_108);
    if(isComment){
    stringBuffer.append(TEXT_109);
    }
    stringBuffer.append(TEXT_110);
    stringBuffer.append(ClassHelper.getAccessorName(property));
    stringBuffer.append(TEXT_111);
    stringBuffer.append(propertyName);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(codifiedModelCount++);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(TypeHelper.getDocumentationOrName(property));
    		}
     	}
    }
    /********process simple property end********/
    stringBuffer.append(TEXT_114);
    /********process o2oPropertyList start********/
    List<Property> o2oPropertyList=EntityHelper.getAllOneToOneProperties(uml2Class,false);
    for (Iterator<Property> iter=o2oPropertyList.iterator();iter.hasNext();){
    		Property property=iter.next();
    		String propertyName=NameHelper.uncapSafeName(property);
    		//String propertyAccessorName=ClassHelper.getAccessorName(property);
     		//String propertyCommentName=TypeHelper.getDocumentationOrName(property);
     		//String relPropertyUncapSafeName=NameHelper.uncapSafeName(property);
    		Type relPropertyType=property.getType();
    		Class relTargetClass=(Class)relPropertyType;
    		String relTargetClassCommentName=TypeHelper.getDocumentationOrName(relTargetClass);
    		//model entity
    		//String relTargetClassEntityQualifiedName=MdaHelper.getEntityQualifiedName(uml2Class);
    		//String relTargetClassEntityName=MdaHelper.getModelClassName(uml2Class,ModelNameSuffix.Entity);
    		//String relTargetClassEntityUncapName=NameHelper.uncapName(modelEntityName);
    		//importManager.addImport(relTargetClassEntityQualifiedName);
    		//model get Accessor
    		String propertyAccessorName=ClassHelper.getAccessorName(property);
    		//String relTargetClassGetAccessor=ClassHelper.getGetAccessor(property);
    		boolean isComment=true;
    		if(!ViewInputHelper.isViewInput(property)||ViewInputHelper.isApplyO2OSelect(property)||ViewInputHelper.isApplyO2OSelectPage(property)){
    			if(ViewInputHelper.isViewInput_readonly(property)){
    					isComment=false;
    			}
    		}
    stringBuffer.append(TEXT_115);
    if(isComment){
    stringBuffer.append(TEXT_116);
    }
    if(!ViewInputHelper.isViewInput(property)){
    stringBuffer.append(TEXT_117);
    }
    stringBuffer.append(TEXT_118);
    stringBuffer.append(propertyAccessorName);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(propertyName);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(codifiedModelCount++);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(relTargetClassCommentName);
    }
    /********process o2oPropertyList end********/
    /********process m2oPropertyList start********/
    List<Property> m2oPropertyList=EntityHelper.getAllManyToOneProperties(uml2Class,false);
    for (Iterator<Property> iter=m2oPropertyList.iterator();iter.hasNext();){
    		Property property=iter.next();
    		String propertyName=NameHelper.uncapSafeName(property);
     		//String relPropertyCommentName=TypeHelper.getDocumentationOrName(property);
     		//String relPropertyUncapSafeName=NameHelper.uncapSafeName(property);
    		Type relPropertyType=property.getType();
    		Class relTargetClass=(Class)relPropertyType;
    		String relTargetClassCommentName=TypeHelper.getDocumentationOrName(relTargetClass);
    		//model entity
    		//String relTargetClassEntityQualifiedName=MdaHelper.getEntityQualifiedName(uml2Class);
    		//String relTargetClassEntityName=MdaHelper.getModelClassName(uml2Class,ModelNameSuffix.Entity);
    		//String relTargetClassEntityUncapName=NameHelper.uncapName(modelEntityName);
    		//importManager.addImport(relTargetClassEntityQualifiedName);
    		//model get Accessor
    		String propertyAccessorName=ClassHelper.getAccessorName(property);
    		//String relTargetClassGetAccessor=ClassHelper.getGetAccessor(property);
    		boolean isComment=true;
    		if(ViewInputHelper.isViewInput(property)||ViewInputHelper.isApplyM2OSelect(property)||ViewInputHelper.isApplyM2OSelectPage(property)){
    			if(!ViewInputHelper.isViewInput_readonly(property)){
    					isComment=false;
    			}
    		}
    stringBuffer.append(TEXT_122);
    if(isComment){
    stringBuffer.append(TEXT_123);
    }
    stringBuffer.append(TEXT_124);
    stringBuffer.append(propertyAccessorName);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(propertyName);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(codifiedModelCount++);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(relTargetClassCommentName);
    }
    /********process m2oPropertyList end********/
    /********process otmProperties start********/
    List<Property> otmProperties=EntityHelper.getAllOneToManyProperties(uml2Class,false);
    for (Iterator<Property> iter=otmProperties.iterator();iter.hasNext();){
    		Property property=iter.next();
    		String propertyName=NameHelper.uncapSafeName(property);
     		//String relPropertyCommentName=TypeHelper.getDocumentationOrName(property);
     		//String relPropertyUncapSafeName=NameHelper.uncapSafeName(property);
    		Type relPropertyType=property.getType();
    		Class relTargetClass=(Class)relPropertyType;
    		String relTargetClassCommentName=TypeHelper.getDocumentationOrName(relTargetClass);
    		//model entity
    		//String relTargetClassEntityQualifiedName=MdaHelper.getEntityQualifiedName(uml2Class);
    		//String relTargetClassEntityName=MdaHelper.getModelClassName(uml2Class,ModelNameSuffix.Entity);
    		//String relTargetClassEntityUncapName=NameHelper.uncapName(modelEntityName);
    		//importManager.addImport(relTargetClassEntityQualifiedName);
    		//model get Accessor
    		String propertyAccessorName=ClassHelper.getAccessorName(property);
    		//String relTargetClassGetAccessor=ClassHelper.getGetAccessor(property);
    		boolean isComment=true;
    		if(ViewInputHelper.isViewInput(property)){
    			if(!ViewInputHelper.isViewInput_readonly(property)){
    					isComment=false;
    			}
    		}
    stringBuffer.append(TEXT_128);
    if(isComment){
    stringBuffer.append(TEXT_129);
    }
    stringBuffer.append(TEXT_130);
    stringBuffer.append(propertyAccessorName);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(propertyName);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(codifiedModelCount++);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(relTargetClassCommentName);
    }
    /********process otmProperties end********/
    /********process mtmProperties start********/
    List<Property> mtmProperties=EntityHelper.getAllManyToManyProperties(uml2Class,false);
    for (Iterator<Property> iter=mtmProperties.iterator();iter.hasNext();){
    		Property property=iter.next();
    		String propertyName=NameHelper.uncapSafeName(property);
     		//String relPropertyCommentName=TypeHelper.getDocumentationOrName(property);
     		//String relPropertyUncapSafeName=NameHelper.uncapSafeName(property);
    		Type relPropertyType=property.getType();
    		Class relTargetClass=(Class)relPropertyType;
    		String relTargetClassCommentName=TypeHelper.getDocumentationOrName(relTargetClass);
    		//model entity
    		//String relTargetClassEntityQualifiedName=MdaHelper.getEntityQualifiedName(uml2Class);
    		//String relTargetClassEntityName=MdaHelper.getModelClassName(uml2Class,ModelNameSuffix.Entity);
    		//String relTargetClassEntityUncapName=NameHelper.uncapName(modelEntityName);
    		//importManager.addImport(relTargetClassEntityQualifiedName);
    		//model get Accessor
    		String propertyAccessorName=ClassHelper.getAccessorName(property);
    		//String relTargetClassGetAccessor=ClassHelper.getGetAccessor(property);
    		boolean isComment=true;
    		if(ViewInputHelper.isViewInput(property)){
    			if(!ViewInputHelper.isViewInput_readonly(property)){
    					isComment=false;
    			}
    		}
    stringBuffer.append(TEXT_134);
    if(isComment){
    stringBuffer.append(TEXT_135);
    }
    stringBuffer.append(TEXT_136);
    stringBuffer.append(propertyAccessorName);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(propertyName);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(codifiedModelCount++);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(relTargetClassCommentName);
    }
    /********process mtmProperties end********/
    stringBuffer.append(TEXT_140);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_144);
    int newModelCount=1;
    /********process simple property start********/
    stringBuffer.append(TEXT_145);
    for (Iterator<Property> i=simpleList.iterator(); i.hasNext();) { 
    	Property property = (Property)i.next();
    	String name = property.getName();
    	String propertyName=NameHelper.uncapSafeName(property);
    	String propertyAccessorName=ClassHelper.getAccessorName(property);
     	String propertyCommentName=TypeHelper.getDocumentationOrName(property);
    	boolean isComment=false;
    	if(!ViewInputHelper.isViewInput(property)||ViewInputHelper.isViewInput_readonly(property)){
    		isComment=true;
    	}
    	//process id
    	if(EntityHelper.isIDProperty(property)){
    		if(EntityHelper.isIDUUID(property)){
    stringBuffer.append(TEXT_146);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(propertyName);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(newModelCount++);
    		}else if(EntityHelper.isIDAssign(idProperty)){
    stringBuffer.append(TEXT_149);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(propertyName);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(newModelCount++);
    		}else{
    stringBuffer.append(TEXT_152);
    if(isComment){
    stringBuffer.append(TEXT_153);
    }
    stringBuffer.append(TEXT_154);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(ClassHelper.getAccessorName(idProperty));
    stringBuffer.append(TEXT_156);
    stringBuffer.append(propertyName);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(newModelCount++);
    		}
    	}else if(property.getType() !=null) {
    		if (name.equalsIgnoreCase("createTime") ||name.equalsIgnoreCase("createDate")){
    stringBuffer.append(TEXT_158);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(propertyAccessorName);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(ImportHelper.getImportedName("java.util.Date"));
    stringBuffer.append(TEXT_161);
    stringBuffer.append(newModelCount++);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(propertyCommentName);
    		}else if(name.equalsIgnoreCase("updateTime") || name.equalsIgnoreCase("updateDate")){
    stringBuffer.append(TEXT_163);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(propertyAccessorName);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(ImportHelper.getImportedName("java.util.Date"));
    stringBuffer.append(TEXT_166);
    stringBuffer.append(newModelCount++);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(propertyCommentName);
    		}else{
    stringBuffer.append(TEXT_168);
    if(isComment){
    stringBuffer.append(TEXT_169);
    }
    stringBuffer.append(TEXT_170);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(propertyAccessorName);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(propertyName);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(newModelCount++);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(propertyCommentName);
    		}
     	}
    }
    /********process o2oPropertyList start********/
    for (Iterator<Property> iter=o2oPropertyList.iterator();iter.hasNext();){
    		Property property=iter.next();
    		String propertyName=NameHelper.uncapSafeName(property);
     		//String propertyCommentName=TypeHelper.getDocumentationOrName(property);
     		//String relPropertyUncapSafeName=NameHelper.uncapSafeName(property);
    		Type relPropertyType=property.getType();
    		Class relTargetClass=(Class)relPropertyType;
    		String relTargetClassCommentName=TypeHelper.getDocumentationOrName(relTargetClass);
    		//model entity
    		//String relTargetClassEntityQualifiedName=MdaHelper.getEntityQualifiedName(uml2Class);
    		//String relTargetClassEntityName=MdaHelper.getModelClassName(uml2Class,ModelNameSuffix.Entity);
    		//String relTargetClassEntityUncapName=NameHelper.uncapName(modelEntityName);
    		//importManager.addImport(relTargetClassEntityQualifiedName);
    		//model get Accessor
    		String propertyAccessorName=ClassHelper.getAccessorName(property);
    		//String relTargetClassGetAccessor=ClassHelper.getGetAccessor(property);
    		boolean isComment=true;
    		if(!ViewInputHelper.isViewInput(property)||ViewInputHelper.isApplyO2OSelect(property)||ViewInputHelper.isApplyO2OSelectPage(property)){
    			if(ViewInputHelper.isViewInput_readonly(property)){
    					isComment=false;
    			}
    		}
    stringBuffer.append(TEXT_175);
    if(isComment){
    stringBuffer.append(TEXT_176);
    }
    stringBuffer.append(TEXT_177);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(propertyAccessorName);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(propertyName);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(newModelCount++);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(relTargetClassCommentName);
    }
    /********process o2oPropertyList end********/
    /********process m2oPropertyList start********/
    for (Iterator<Property> iter=m2oPropertyList.iterator();iter.hasNext();){
    		Property property=iter.next();
    		String propertyName=NameHelper.uncapSafeName(property);
     		//String propertyCommentName=TypeHelper.getDocumentationOrName(property);
    		String propertyAccessorName=ClassHelper.getAccessorName(property);
     		//String relPropertyUncapSafeName=NameHelper.uncapSafeName(property);
    		Type relPropertyType=property.getType();
    		Class relTargetClass=(Class)relPropertyType;
    		String relTargetClassCommentName=TypeHelper.getDocumentationOrName(relTargetClass);
    		//model entity
    		//String relTargetClassEntityQualifiedName=MdaHelper.getEntityQualifiedName(uml2Class);
    		//String relTargetClassEntityName=MdaHelper.getModelClassName(uml2Class,ModelNameSuffix.Entity);
    		//String relTargetClassEntityUncapName=NameHelper.uncapName(modelEntityName);
    		//importManager.addImport(relTargetClassEntityQualifiedName);
    		//model get Accessor
    		//String relTargetClassGetAccessor=ClassHelper.getGetAccessor(property);
    		boolean isComment=true;
    		if(ViewInputHelper.isViewInput(property)||ViewInputHelper.isApplyM2OSelect(property)||ViewInputHelper.isApplyM2OSelectPage(property)){
    			if(!ViewInputHelper.isViewInput_readonly(property)){
    					isComment=false;
    			}
    		}
    stringBuffer.append(TEXT_182);
    if(isComment){
    stringBuffer.append(TEXT_183);
    }
    stringBuffer.append(TEXT_184);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(propertyAccessorName);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(propertyName);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(newModelCount++);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(relTargetClassCommentName);
    }
    /********process m2oPropertyList end********/
    /********process otmProperties start********/
    for (Iterator<Property> iter=otmProperties.iterator();iter.hasNext();){
    		Property property=iter.next();
    		String propertyName=NameHelper.uncapSafeName(property);
     		//String propertyCommentName=TypeHelper.getDocumentationOrName(property);
    		String propertyAccessorName=ClassHelper.getAccessorName(property);
     		//String relPropertyCommentName=TypeHelper.getDocumentationOrName(property);
     		//String relPropertyUncapSafeName=NameHelper.uncapSafeName(property);
    		Type relPropertyType=property.getType();
    		Class relTargetClass=(Class)relPropertyType;
    		String relTargetClassCommentName=TypeHelper.getDocumentationOrName(relTargetClass);
    		//model entity
    		//String relTargetClassEntityQualifiedName=MdaHelper.getEntityQualifiedName(uml2Class);
    		//String relTargetClassEntityName=MdaHelper.getModelClassName(uml2Class,ModelNameSuffix.Entity);
    		//String relTargetClassEntityUncapName=NameHelper.uncapName(modelEntityName);
    		//importManager.addImport(relTargetClassEntityQualifiedName);
    		//model get Accessor
    		//String relTargetClassGetAccessor=ClassHelper.getGetAccessor(property);
    		boolean isComment=true;
    		if(ViewInputHelper.isViewInput(property)){
    			if(!ViewInputHelper.isViewInput_readonly(property)){
    					isComment=false;
    			}
    		}
    stringBuffer.append(TEXT_189);
    if(isComment){
    stringBuffer.append(TEXT_190);
    }
    stringBuffer.append(TEXT_191);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(propertyAccessorName);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(propertyName);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(newModelCount++);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(relTargetClassCommentName);
    }
    /********process otmProperties end********/
    /********process mtmProperties start********/
    for (Iterator<Property> iter=mtmProperties.iterator();iter.hasNext();){
    		Property property=iter.next();
    		String propertyName=NameHelper.uncapSafeName(property);
     		//String propertyCommentName=TypeHelper.getDocumentationOrName(property);
    		String propertyAccessorName=ClassHelper.getAccessorName(property);
     		//String relPropertyCommentName=TypeHelper.getDocumentationOrName(property);
     		//String relPropertyUncapSafeName=NameHelper.uncapSafeName(property);
    		Type relPropertyType=property.getType();
    		Class relTargetClass=(Class)relPropertyType;
    		String relTargetClassCommentName=TypeHelper.getDocumentationOrName(relTargetClass);
    		//model entity
    		//String relTargetClassEntityQualifiedName=MdaHelper.getEntityQualifiedName(uml2Class);
    		//String relTargetClassEntityName=MdaHelper.getModelClassName(uml2Class,ModelNameSuffix.Entity);
    		//String relTargetClassEntityUncapName=NameHelper.uncapName(modelEntityName);
    		//importManager.addImport(relTargetClassEntityQualifiedName);
    		//model get Accessor
    		//String relTargetClassGetAccessor=ClassHelper.getGetAccessor(property);
    		boolean isComment=true;
    		if(ViewInputHelper.isViewInput(property)){
    			if(!ViewInputHelper.isViewInput_readonly(property)){
    					isComment=false;
    			}
    		}
    stringBuffer.append(TEXT_196);
    if(isComment){
    stringBuffer.append(TEXT_197);
    }
    stringBuffer.append(TEXT_198);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(propertyAccessorName);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(propertyName);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(newModelCount++);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(relTargetClassCommentName);
    }
    /********process mtmProperties end********/
    stringBuffer.append(TEXT_203);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_204);
    /**
    stringBuffer.append(TEXT_205);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_206);
    int setModelCount=1;
    stringBuffer.append(TEXT_207);
    stringBuffer.append(ClassHelper.getGetAccessor(idProperty));
    stringBuffer.append(TEXT_208);
    stringBuffer.append(setModelCount++);
    for(Iterator<Property> i=listProperty.iterator(); i.hasNext();) { 
    	Property property = (Property)i.next();
    	if (property.getType() !=null) {
    stringBuffer.append(TEXT_209);
    stringBuffer.append(ClassHelper.getAccessorName(property));
    stringBuffer.append(TEXT_210);
    stringBuffer.append(ClassHelper.getGetAccessor(property));
    stringBuffer.append(TEXT_211);
    stringBuffer.append(setModelCount++);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(TypeHelper.getDocumentationOrName(property));
    	}
    }
    stringBuffer.append(TEXT_213);
    **/
    stringBuffer.append(TEXT_214);
    
	//@Override
	//public String toString() {
	//	return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	//}

    stringBuffer.append(TEXT_215);
    importManager.addImport("org.apache.commons.lang.builder.ToStringBuilder");
    importManager.addImport("org.apache.commons.lang.builder.ToStringStyle");
    stringBuffer.append(TEXT_216);
    stringBuffer.append(GenHelper.genEntityToStringBuilder(uml2Class));
    stringBuffer.append(TEXT_217);
    importStringBuffer.insert(importInsertionPoint, importManager.computeSortedImports());
    stringBuffer.append(TEXT_218);
    return stringBuffer.toString();
  }
}
