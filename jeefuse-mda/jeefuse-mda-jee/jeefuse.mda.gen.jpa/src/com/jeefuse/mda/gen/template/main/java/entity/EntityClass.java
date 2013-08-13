package com.jeefuse.mda.gen.template.main.java.entity;

import net.taylor.mda.generator.parse.NameRuled.nameRuled.*;
import net.taylor.mda.generator.parse.NameRuled.className.*;
import net.taylor.mda.generator.parse.NameRuled.*;
import net.taylor.mda.generator.parse.stereotype.*;
import net.taylor.mda.generator.parse.*;
import java.util.Iterator;
import java.util.List;
import net.taylor.mda.generator.parse.entity.*;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.*;
import net.taylor.mda.generator.util.*;
import org.eclipse.emf.codegen.util.*;

public class EntityClass
{
  protected static String nl;
  public static synchronized EntityClass create(String lineSeparator)
  {
    nl = lineSeparator;
    EntityClass result = new EntityClass();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "/*" + NL + " * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the \"License\")" + NL + " * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms." + NL + " * email:yonclv@gmail.com" + NL + " */" + NL + "package ";
  protected final String TEXT_3 = ";";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * ";
  protected final String TEXT_5 = " Entity define." + NL + " *" + NL + " * @author ";
  protected final String TEXT_6 = NL + " * @generated" + NL + " */";
  protected final String TEXT_7 = NL;
  protected final String TEXT_8 = NL;
  protected final String TEXT_9 = NL + "public class ";
  protected final String TEXT_10 = " {" + NL + "\t/** @generated */" + NL + "\tprivate static final long serialVersionUID = 1L;" + NL + "" + NL + "\t/** @generated */" + NL + "\tpublic ";
  protected final String TEXT_11 = "() {" + NL + "\t}";
  protected final String TEXT_12 = "\t";
  protected final String TEXT_13 = "\t";
  protected final String TEXT_14 = "\t";
  protected final String TEXT_15 = "\t\t\t";
  protected final String TEXT_16 = "\t\t\t";
  protected final String TEXT_17 = "\t\t\t";
  protected final String TEXT_18 = NL + NL + "\t/**" + NL + "\t * using for treeView." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_19 = "(String id, String listLabel, String parentId) {" + NL + "\t\tthis.";
  protected final String TEXT_20 = " = id;" + NL + "\t\tthis.";
  protected final String TEXT_21 = " = listLabel;" + NL + "\t\t";
  protected final String TEXT_22 = " curParent = new ";
  protected final String TEXT_23 = "();" + NL + "\t\tcurParent.";
  protected final String TEXT_24 = "(parentId);" + NL + "\t\tthis.parent = curParent;" + NL + "\t}";
  protected final String TEXT_25 = "\t";
  protected final String TEXT_26 = "\t\t\t";
  protected final String TEXT_27 = "\t\t\t";
  protected final String TEXT_28 = "\t";
  protected final String TEXT_29 = "\t";
  protected final String TEXT_30 = "\t";
  protected final String TEXT_31 = "\t";
  protected final String TEXT_32 = "\t" + NL + "" + NL + "\t/**" + NL + "\t * 构造keyLabel,只获取key,label属性." + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_33 = "(String listKey, String listLabel) {" + NL + "\t\tthis.";
  protected final String TEXT_34 = " = listKey;" + NL + "\t\tthis.";
  protected final String TEXT_35 = " = listLabel;" + NL + "\t}";
  protected final String TEXT_36 = "\t";
  protected final String TEXT_37 = NL + "\t/**" + NL + "\t * 构造gallary,只获取";
  protected final String TEXT_38 = "属性." + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_39 = "(";
  protected final String TEXT_40 = ") {";
  protected final String TEXT_41 = NL + "\t\t\tthis.";
  protected final String TEXT_42 = " = ";
  protected final String TEXT_43 = ";";
  protected final String TEXT_44 = NL + "\t\t\tthis.";
  protected final String TEXT_45 = " = ";
  protected final String TEXT_46 = ";";
  protected final String TEXT_47 = NL + "\t\t\tthis.";
  protected final String TEXT_48 = " = ";
  protected final String TEXT_49 = ";";
  protected final String TEXT_50 = NL + "\t}";
  protected final String TEXT_51 = "\t";
  protected final String TEXT_52 = NL + NL + "\t/**" + NL + "\t * ------------------------------------------------------------------------" + NL + "\t * ";
  protected final String TEXT_53 = NL + "\t * ------------------------------------------------------------------------" + NL + "\t * @generated" + NL + "\t */" + NL + "\t@";
  protected final String TEXT_54 = NL + "\t@";
  protected final String TEXT_55 = "(generator = \"hibernate-uuid\")" + NL + "\t@";
  protected final String TEXT_56 = "(strategy = \"uuid\", name = \"hibernate-uuid\")" + NL + "\t";
  protected final String TEXT_57 = NL + "\tpublic ";
  protected final String TEXT_58 = " ";
  protected final String TEXT_59 = "() {" + NL + "\t\treturn ";
  protected final String TEXT_60 = ";" + NL + "\t}";
  protected final String TEXT_61 = NL + NL + "\t/**" + NL + "\t * ------------------------------------------------------------------------" + NL + "\t * ";
  protected final String TEXT_62 = NL + "\t * ------------------------------------------------------------------------" + NL + "\t * @generated" + NL + "\t */" + NL + "\t@";
  protected final String TEXT_63 = NL + "\t@";
  protected final String TEXT_64 = "(generator = \"";
  protected final String TEXT_65 = "Generator\")     " + NL + "\t@";
  protected final String TEXT_66 = "(name = \"";
  protected final String TEXT_67 = "Generator\", strategy = \"assigned\")" + NL + "\t";
  protected final String TEXT_68 = NL + "\tpublic ";
  protected final String TEXT_69 = " ";
  protected final String TEXT_70 = "() {" + NL + "\t\treturn ";
  protected final String TEXT_71 = ";" + NL + "\t}";
  protected final String TEXT_72 = NL + NL + "\t/** @generated */";
  protected final String TEXT_73 = NL + "\t";
  protected final String TEXT_74 = NL + "\tpublic ";
  protected final String TEXT_75 = " ";
  protected final String TEXT_76 = "() {" + NL + "\t\treturn ";
  protected final String TEXT_77 = ";" + NL + "\t}";
  protected final String TEXT_78 = NL + NL + "\t/** @generated */" + NL + "\tpublic void set";
  protected final String TEXT_79 = "(final ";
  protected final String TEXT_80 = " ";
  protected final String TEXT_81 = ") {" + NL + "\t\tthis.";
  protected final String TEXT_82 = " = ";
  protected final String TEXT_83 = ";" + NL + "\t}" + NL + "\t" + NL + "\t/** @generated */" + NL + "\tprivate ";
  protected final String TEXT_84 = " ";
  protected final String TEXT_85 = " = ";
  protected final String TEXT_86 = ";";
  protected final String TEXT_87 = NL + NL + "\t/** @generated */" + NL + "\t@Transient" + NL + "\tpublic String getId() {" + NL + "\t\treturn ";
  protected final String TEXT_88 = ";" + NL + "\t}" + NL + "\t" + NL + "\t/** @generated */" + NL + "\t@Transient" + NL + "\tpublic void setId(final String id) {" + NL + "\t\tthis.";
  protected final String TEXT_89 = " = id;" + NL + "\t}";
  protected final String TEXT_90 = NL + NL + "\t/**" + NL + "\t * ------------------------------------------------------------------------" + NL + "\t * ";
  protected final String TEXT_91 = NL + "\t * ------------------------------------------------------------------------" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_92 = NL + "\t";
  protected final String TEXT_93 = NL + "\tpublic ";
  protected final String TEXT_94 = " ";
  protected final String TEXT_95 = "() {";
  protected final String TEXT_96 = NL + "\t\tif (this.";
  protected final String TEXT_97 = " == null) {";
  protected final String TEXT_98 = NL + "\t\t\tthis.";
  protected final String TEXT_99 = " = new HashSet<";
  protected final String TEXT_100 = ">();";
  protected final String TEXT_101 = NL + "\t\t\tthis.";
  protected final String TEXT_102 = " = new ArrayList<";
  protected final String TEXT_103 = ">();";
  protected final String TEXT_104 = NL + "\t\t}";
  protected final String TEXT_105 = NL + "\t\tif (this.";
  protected final String TEXT_106 = " == null) {" + NL + "\t\t\tthis.";
  protected final String TEXT_107 = " = new ";
  protected final String TEXT_108 = "();        " + NL + "\t\t}";
  protected final String TEXT_109 = NL + "\t\treturn ";
  protected final String TEXT_110 = ";" + NL + "\t}" + NL + "" + NL + "\t/** @generated */" + NL + "\tpublic void set";
  protected final String TEXT_111 = "(final ";
  protected final String TEXT_112 = " ";
  protected final String TEXT_113 = ") {" + NL + "\t\tthis.";
  protected final String TEXT_114 = " = ";
  protected final String TEXT_115 = ";" + NL + "\t}";
  protected final String TEXT_116 = NL + NL + "\t/** @generated */";
  protected final String TEXT_117 = NL + "\t@Transient";
  protected final String TEXT_118 = NL + "\tpublic boolean is";
  protected final String TEXT_119 = "() {" + NL + "\t\treturn ";
  protected final String TEXT_120 = ".";
  protected final String TEXT_121 = ".equals(";
  protected final String TEXT_122 = ".valueOfKey(";
  protected final String TEXT_123 = "));" + NL + "\t}";
  protected final String TEXT_124 = "\t";
  protected final String TEXT_125 = NL + NL + "\t/**" + NL + "\t * ------------------------------------------------------------------------" + NL + "\t * convert to date string for ";
  protected final String TEXT_126 = NL + "\t * ------------------------------------------------------------------------" + NL + "\t * @generated" + NL + "\t */" + NL + "\t@Transient" + NL + "\tpublic String get";
  protected final String TEXT_127 = "() {" + NL + "\t\treturn DateUtil.formatDateTimeSecond(";
  protected final String TEXT_128 = ");" + NL + "\t}";
  protected final String TEXT_129 = NL + "\t/** @generated */";
  protected final String TEXT_130 = NL + "\t@Transient";
  protected final String TEXT_131 = NL + "\tpublic boolean is";
  protected final String TEXT_132 = "() {" + NL + "\t\treturn ";
  protected final String TEXT_133 = ".";
  protected final String TEXT_134 = ".equals(";
  protected final String TEXT_135 = ");" + NL + "\t}";
  protected final String TEXT_136 = NL + NL + "\t/** @generated */" + NL + "\tprivate ";
  protected final String TEXT_137 = " ";
  protected final String TEXT_138 = " = ";
  protected final String TEXT_139 = ";";
  protected final String TEXT_140 = "\t";
  protected final String TEXT_141 = "\t";
  protected final String TEXT_142 = "\t";
  protected final String TEXT_143 = "\t\t\t";
  protected final String TEXT_144 = "\t";
  protected final String TEXT_145 = "\t\t\t";
  protected final String TEXT_146 = "\t\t\t";
  protected final String TEXT_147 = "\t" + NL + "\t/******************************************************************" + NL + "\t * use for treeview" + NL + "\t *******************************************************************/" + NL + "\t\t" + NL + "\t/**" + NL + "\t * ------------------------------------------------------------------------" + NL + "\t * 上级 " + NL + "\t * ------------------------------------------------------------------------" + NL + "\t * @generated" + NL + "\t */" + NL + "\t@ManyToOne(fetch = FetchType.LAZY)";
  protected final String TEXT_148 = NL + "\t@JoinColumn(name = \"";
  protected final String TEXT_149 = "\")" + NL + "\tpublic ";
  protected final String TEXT_150 = " getParent() {" + NL + "\t\treturn parent;" + NL + "\t}" + NL + "" + NL + "\t/** @generated */" + NL + "\tpublic void setParent(final ";
  protected final String TEXT_151 = " parent) {" + NL + "\t\tthis.parent = parent;" + NL + "\t}" + NL + "" + NL + "\t/** @generated */" + NL + "\tprivate ";
  protected final String TEXT_152 = " parent = null;" + NL + "\t" + NL + "" + NL + "\t/** @generated */" + NL + "\t@Transient" + NL + "\tpublic boolean getComplete() {" + NL + "\t\treturn true;" + NL + "\t}" + NL + "" + NL + "\t/** @generated */" + NL + "\t@Transient" + NL + "\tpublic boolean getIsexpand() {" + NL + "\t\treturn true;" + NL + "\t}" + NL + "\t" + NL + "\t/** @generated */" + NL + "\t@Transient" + NL + "\tpublic String getValue() {" + NL + "\t\treturn this.";
  protected final String TEXT_153 = "();" + NL + "\t}" + NL + "\t" + NL + "\t/** @generated */" + NL + "\t@Transient" + NL + "\tpublic String getText() {" + NL + "\t\treturn this.";
  protected final String TEXT_154 = "();" + NL + "\t}" + NL + "" + NL + "\t/** @generated */" + NL + "\t@Transient" + NL + "\tpublic String getParentId() {" + NL + "\t\tif (null != this.getParent())" + NL + "\t\t\treturn this.getParent().";
  protected final String TEXT_155 = "();" + NL + "\t\treturn null;" + NL + "\t}" + NL + "\t" + NL + "\t/** @generated */" + NL + "\t@Transient" + NL + "\tpublic void setParentId(String parentId) {";
  protected final String TEXT_156 = "\t" + NL + "\t\tif(StringUtils.isNotBlank(parentId)){" + NL + "\t\t\t";
  protected final String TEXT_157 = " curParent = new ";
  protected final String TEXT_158 = "();" + NL + "\t\t\tcurParent.";
  protected final String TEXT_159 = "(parentId);" + NL + "\t\t\tthis.setParent(curParent);" + NL + "\t\t}else{" + NL + "\t\t\tthis.setParent(null);" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_160 = "\t\t\t";
  protected final String TEXT_161 = "\t";
  protected final String TEXT_162 = "\t";
  protected final String TEXT_163 = "\t";
  protected final String TEXT_164 = "\t";
  protected final String TEXT_165 = "\t" + NL + "" + NL + "\t/******************************************************************" + NL + "\t * use for keyLabel" + NL + "\t *******************************************************************/" + NL + "" + NL + "\t/** @generated */" + NL + "\t@Transient" + NL + "\tpublic String getKey() {" + NL + "\t\treturn this.";
  protected final String TEXT_166 = "();" + NL + "\t}" + NL + "\t" + NL + "\t/** @generated */" + NL + "\t@Transient" + NL + "\tpublic String getLabel() {" + NL + "\t\treturn this.";
  protected final String TEXT_167 = "();" + NL + "\t}";
  protected final String TEXT_168 = "\t" + NL + "\t// ------------------------------------------------------------------------" + NL + "\t// Utils" + NL + "\t// ------------------------------------------------------------------------" + NL;
  protected final String TEXT_169 = NL + "\t/** @generated */" + NL + "\t@Override" + NL + "\tpublic String toString() {" + NL + "\t\treturn ";
  protected final String TEXT_170 = ";" + NL + "\t}";
  protected final String TEXT_171 = NL + "\t" + NL + "\t/** @generated */" + NL + "\t@Override" + NL + "\tpublic int hashCode() {" + NL + "\t\tfinal int PRIME = 31;" + NL + "\t\tint result = 1;" + NL + "\t\tresult = PRIME * result + (";
  protected final String TEXT_172 = " == null? super.hashCode() : ";
  protected final String TEXT_173 = ".hashCode());" + NL + "\t\treturn result;" + NL + "\t}" + NL + "" + NL + "\t/** @generated */" + NL + "\t@Override" + NL + "\tpublic boolean equals(Object obj) {" + NL + "\t\tif (this == obj)" + NL + "\t\t\treturn true;" + NL + "\t\tif (obj == null)" + NL + "\t\t\treturn false;" + NL + "\t\tif (!(obj instanceof ";
  protected final String TEXT_174 = "))" + NL + "\t\t\treturn false;" + NL + "\t\tfinal ";
  protected final String TEXT_175 = " other = (";
  protected final String TEXT_176 = ") obj;" + NL + "\t\tif (";
  protected final String TEXT_177 = " == null) {" + NL + "\t\t\tif (other.getId() != null)" + NL + "\t\t\t\treturn false;" + NL + "\t\t} else if (!";
  protected final String TEXT_178 = ".equals(other.getId()))" + NL + "\t\t\treturn false;" + NL + "\t\treturn true;" + NL + "\t}\t";
  protected final String TEXT_179 = NL + "}";
  protected final String TEXT_180 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    Class uml2Class = (Class) argument;Package uml2Package = uml2Class.getPackage();
    
/*******clazz wrap********/	
UmlClassWrap clazzWrap=new UmlClassWrap(uml2Class);
String modelCommentName=clazzWrap.getCommentName();
String modelUncapName=clazzWrap.getUncapName();

//model entity define
ClassNameDefineCommon entityDefine=clazzWrap.getNameDefineEntity();
String modelEntityPackage=entityDefine.getPackageQualifiedName();
String modelEntityName=entityDefine.getClassCapName();


    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(modelEntityPackage);
    stringBuffer.append(TEXT_3);
    ImportManager importManager = ImportHelper.makeImportManager("");
    
StringBuffer importStringBuffer = stringBuffer;
int importInsertionPoint = stringBuffer.length();
importManager.addCompilationUnitImports(stringBuffer.toString());

    stringBuffer.append(TEXT_4);
    stringBuffer.append(modelCommentName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(System.getProperty("user.name"));
    stringBuffer.append(TEXT_6);
    if (StereotypeHelper.hasStereotypes(uml2Class)) {
    stringBuffer.append(TEXT_7);
    stringBuffer.append(ModelStereoTypeHelper.getEntityStereoType(uml2Class));
    }
    if (StereotypeHelper.isStereotypeApplied(uml2Class, StereotypeHelper.ENTITY) && ClassHelper.isRoot(uml2Class)) {
    stringBuffer.append(TEXT_8);
    stringBuffer.append(ClassHelper.getInheritance(uml2Class));
    }
    stringBuffer.append(TEXT_9);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(ExtendHelper.getImplementsIdEntityAndImplementsSerialize(uml2Class));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_11);
    
/*****************************************************************
 * id property
/*****************************************************************/

    		Property idProperty=TreeStereotypeHelper.getProperty_id(uml2Class);
    stringBuffer.append(TEXT_12);
    		String idPropertyName=NameHelper.uncapSafeName(idProperty);
    		/********id property accessor ********/
    		//String idPropertyGetAccessorName=ClassHelper.getGetAccessor(idProperty);
    stringBuffer.append(TEXT_13);
    		String idPropertySetAccessorName="set"+ClassHelper.getAccessorName(idProperty);
    stringBuffer.append(TEXT_14);
    
/*****************************************************************
 * process implement treeView start
/*****************************************************************/

    	if(TreeStereotypeHelper.isApply(uml2Class)){
    		importManager.addImport("com.jeefuse.base.modules.tree.renders.treeview.TreeViewItem");
    		Property listLabelProperty=TreeStereotypeHelper.getProperty_listLabel(uml2Class);
    stringBuffer.append(TEXT_15);
    		String listLabelPropertyName=NameHelper.uncapSafeName(listLabelProperty);
    		//Property layerCodeProperty=TreeStereotypeHelper.getProperty_layerCode(uml2Class);
    stringBuffer.append(TEXT_16);
    		//String layerCodePropertyName=NameHelper.uncapSafeName(layerCodeProperty);
    		//Property parentIdProperty=TreeStereotypeHelper.getProperty_parentId(uml2Class);
    stringBuffer.append(TEXT_17);
    		//String parentIdPropertyName=NameHelper.uncapSafeName(parentIdProperty);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(idPropertyName);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(listLabelPropertyName);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(idPropertySetAccessorName);
    stringBuffer.append(TEXT_24);
    	}
    stringBuffer.append(TEXT_25);
    /********process implement treeView end********/
    /********process implement keyLabel start********/
    	if(KeyLabelStereotypeHelper.isApply(uml2Class)){
    		importManager.addImport("com.jeefuse.base.modules.keyLabel.KeyLabel");
    		//String classGetAllForKeyLabel=clazzWrap.getPropertyNamedRuleKind(PropertyNamedRuleKind.getAllForKeyLabel);
    stringBuffer.append(TEXT_26);
    		Property listKeyProperty=KeyLabelStereotypeHelper.getProperty_liskKey(uml2Class);
    stringBuffer.append(TEXT_27);
    		String listKeyPropertyName=NameHelper.uncapSafeName(listKeyProperty);
    		//String listKeyPropertyGetAccessorName=ClassHelper.getGetAccessor(listKeyProperty);
    stringBuffer.append(TEXT_28);
    		//String listKeyPropertySetAccessorName="set"+ClassHelper.getAccessorName(listKeyProperty);
    stringBuffer.append(TEXT_29);
    		Property listLabelProperty=KeyLabelStereotypeHelper.getProperty_listLabel(uml2Class);
    stringBuffer.append(TEXT_30);
    		String listLabelPropertyName=NameHelper.uncapSafeName(listLabelProperty);
    		//String listLabelPropertyGetAccessorName=ClassHelper.getGetAccessor(listLabelProperty);
    stringBuffer.append(TEXT_31);
    		//String listLabelPropertySetAccessorName="set"+ClassHelper.getAccessorName(listLabelProperty);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(listKeyPropertyName);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(listLabelPropertyName);
    stringBuffer.append(TEXT_35);
    	}
    stringBuffer.append(TEXT_36);
    /********process implement keyLabel end********/
    
/*****************************************************************
 * process implement image 
/*****************************************************************/

    if(FileStereotypeHelper.isClass_file(uml2Class)||FileStereotypeHelper.isClass_Image(uml2Class)){
    	//Property propertyFileSavePath=FileStereotypeHelper.getProperty_FileSavePath(uml2Class);
    	Property propertyFileVisitPath=FileStereotypeHelper.getProperty_visitPath(uml2Class);
    	Property propertyTitle=PropertyStereotypeHelper.getProperty_Title(uml2Class);
    	Property propertyIntro=PropertyStereotypeHelper.getProperty_Intro(uml2Class);
    	//Property propertyContent=PropertyStereotypeHelper.getProperty_Content(uml2Class);
    	String gallaryListContructArgs=FileStereotypeHelper.getGallaryListContructArgs(uml2Class);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(gallaryListContructArgs);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(gallaryListContructArgs);
    stringBuffer.append(TEXT_40);
    		if(null!=propertyFileVisitPath){
    			String propertyUncapSafeName=NameHelper.uncapSafeName(propertyFileVisitPath);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_43);
    		}
    		if(null!=propertyTitle){
    			String propertyUncapSafeName=NameHelper.uncapSafeName(propertyTitle);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_46);
    		}
    		if(null!=propertyIntro){
    			String propertyUncapSafeName=NameHelper.uncapSafeName(propertyIntro);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(propertyUncapSafeName);
    stringBuffer.append(TEXT_49);
    		}
    stringBuffer.append(TEXT_50);
    	}
    stringBuffer.append(TEXT_51);
    /********process implement image end********/
    /********process  id propperty start****************/
    
List<Property> listProperty=EntityHelper.getOwnAllPropertyExcluedIdProperty(uml2Class);
if(EntityHelper.isIDUUID(idProperty)){

    stringBuffer.append(TEXT_52);
    stringBuffer.append(TypeHelper.getDocumentationOrName(idProperty));
    stringBuffer.append(TEXT_53);
    stringBuffer.append(ImportHelper.getImportedName(StereotypeHelper.ID));
    stringBuffer.append(TEXT_54);
    stringBuffer.append(ImportHelper.getImportedName(StereotypeHelper.GENERATED_VALUE));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(ImportHelper.getImportedName(StereotypeHelper.annotations_GenericGenerator));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(StereotypeHelper.getAnnotation(idProperty,StereotypeHelper.COLUMN));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(MdaHelper.getImportedFeatureType(idProperty));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(ClassHelper.getGetAccessor(idProperty));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(NameHelper.uncapSafeName(idProperty));
    stringBuffer.append(TEXT_60);
    }else if(EntityHelper.isIDAssign(idProperty)){
    stringBuffer.append(TEXT_61);
    stringBuffer.append(TypeHelper.getDocumentationOrName(idProperty));
    stringBuffer.append(TEXT_62);
    stringBuffer.append(ImportHelper.getImportedName(StereotypeHelper.ID));
    stringBuffer.append(TEXT_63);
    stringBuffer.append(ImportHelper.getImportedName(StereotypeHelper.GENERATED_VALUE));
    stringBuffer.append(TEXT_64);
    stringBuffer.append(modelUncapName);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(ImportHelper.getImportedName(StereotypeHelper.annotations_GenericGenerator));
    stringBuffer.append(TEXT_66);
    stringBuffer.append(modelUncapName);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(StereotypeHelper.getAnnotation(idProperty,StereotypeHelper.COLUMN));
    stringBuffer.append(TEXT_68);
    stringBuffer.append(MdaHelper.getImportedFeatureType(idProperty));
    stringBuffer.append(TEXT_69);
    stringBuffer.append(ClassHelper.getGetAccessor(idProperty));
    stringBuffer.append(TEXT_70);
    stringBuffer.append(NameHelper.uncapSafeName(idProperty));
    stringBuffer.append(TEXT_71);
    }else{
    	//listProperty.add(0,idProperty);
    stringBuffer.append(TEXT_72);
    	if (StereotypeHelper.hasStereotypes(idProperty)) {
    stringBuffer.append(TEXT_73);
    stringBuffer.append(ModelStereoTypeHelper.getEntityPropertyStereoType(idProperty,true));
    	}
    stringBuffer.append(TEXT_74);
    stringBuffer.append(MdaHelper.getImportedFeatureType(idProperty));
    stringBuffer.append(TEXT_75);
    stringBuffer.append(ClassHelper.getGetAccessor(idProperty));
    stringBuffer.append(TEXT_76);
    stringBuffer.append(NameHelper.uncapSafeName(idProperty));
    stringBuffer.append(TEXT_77);
    }
    stringBuffer.append(TEXT_78);
    stringBuffer.append(ClassHelper.getAccessorName(idProperty));
    stringBuffer.append(TEXT_79);
    stringBuffer.append(MdaHelper.getImportedFeatureType(idProperty));
    stringBuffer.append(TEXT_80);
    stringBuffer.append(NameHelper.uncapSafeName(idProperty));
    stringBuffer.append(TEXT_81);
    stringBuffer.append(NameHelper.uncapSafeName(idProperty));
    stringBuffer.append(TEXT_82);
    stringBuffer.append(NameHelper.uncapSafeName(idProperty));
    stringBuffer.append(TEXT_83);
    stringBuffer.append(MdaHelper.getImportedFeatureType(idProperty));
    stringBuffer.append(TEXT_84);
    stringBuffer.append(NameHelper.uncapSafeName(idProperty));
    stringBuffer.append(TEXT_85);
    stringBuffer.append(TypeHelper.getDefaultValue(idProperty));
    stringBuffer.append(TEXT_86);
    if(!idProperty.getName().equals("id")){
    	importManager.addImport("javax.persistence.Transient");
    stringBuffer.append(TEXT_87);
    stringBuffer.append(NameHelper.uncapSafeName(idProperty));
    stringBuffer.append(TEXT_88);
    stringBuffer.append(NameHelper.uncapSafeName(idProperty));
    stringBuffer.append(TEXT_89);
    }
    /********process  id propperty end****************/
    
/*****************************************************************
 * process non id propperty start
/*****************************************************************/

    for (Iterator<Property> i=listProperty.iterator(); i.hasNext();) { 
    	Property property = (Property)i.next();
    	if(TreeStereotypeHelper.isParentIdProperty(property)){
    		continue;
    	}
    	if (property.getType() !=null) {
    		//String propertyCapName=NameHelper.getCapName(property);
    		//String propertyConmentName=TypeHelper.getDocumentationOrName(property);
    		String propertyName=NameHelper.uncapSafeName(property);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(TypeHelper.getDocumentationOrName(property));
    stringBuffer.append(TEXT_91);
    		if (StereotypeHelper.hasStereotypes(property)) {
    stringBuffer.append(TEXT_92);
    stringBuffer.append(ModelStereoTypeHelper.getEntityPropertyStereoType(property,true));
    		}
    stringBuffer.append(TEXT_93);
    stringBuffer.append(MdaHelper.getImportedFeatureType(property));
    stringBuffer.append(TEXT_94);
    stringBuffer.append(ClassHelper.getGetAccessor(property));
    stringBuffer.append(TEXT_95);
    		if (property.getAssociation() != null && property.isMultivalued()) {
    stringBuffer.append(TEXT_96);
    stringBuffer.append(propertyName);
    stringBuffer.append(TEXT_97);
    			if (property.getOpposite() == null || property.getOpposite().isMultivalued()) {
    				importManager.addImport("java.util.HashSet");
    stringBuffer.append(TEXT_98);
    stringBuffer.append(propertyName);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(MdaHelper.getImportedType(property.getType()));
    stringBuffer.append(TEXT_100);
    			}else {
    				importManager.addImport("java.util.ArrayList");
    stringBuffer.append(TEXT_101);
    stringBuffer.append(propertyName);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(MdaHelper.getImportedType(property.getType()));
    stringBuffer.append(TEXT_103);
    		}
    stringBuffer.append(TEXT_104);
    	}
    	/*if (ClassHelper.isComposite(property)) {
    stringBuffer.append(TEXT_105);
    stringBuffer.append(propertyName);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(propertyName);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(MdaHelper.getImportedType(property.getType()));
    stringBuffer.append(TEXT_108);
    	}*/
    stringBuffer.append(TEXT_109);
    stringBuffer.append(propertyName);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(ClassHelper.getAccessorName(property));
    stringBuffer.append(TEXT_111);
    stringBuffer.append(MdaHelper.getImportedFeatureType(property));
    stringBuffer.append(TEXT_112);
    stringBuffer.append(propertyName);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(propertyName);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(propertyName);
    stringBuffer.append(TEXT_115);
    }
    //process apply enumKind
    /*if(EnumKindHelper.isAppliedEnumKind(property)){
    	Enumeration enumeration=EnumKindHelper.getAppliedEnumKindEnumeration(property);
    	if(null!=enumeration){
    			String modelEnumQualifiedName=MdaHelper.getModelQualifiedName(enumeration,PKGSuffix.enumeration,ModelNameSuffix.enumeration);
    			String modelEnumName=MdaHelper.getModelClassName(enumeration,ModelNameSuffix.enumeration);
    			importManager.addImport(modelEnumQualifiedName);
    		for (Iterator<EnumerationLiteral> l=enumeration.getOwnedLiterals().iterator(); l.hasNext();) { 
    			EnumerationLiteral enumLiteral = (EnumerationLiteral)l.next();
    stringBuffer.append(TEXT_116);
    			if (StereotypeHelper.isStereotypeApplied(uml2Class, StereotypeHelper.ENTITY)) {
    				importManager.addImport("javax.persistence.Transient");
    stringBuffer.append(TEXT_117);
    			}
    stringBuffer.append(TEXT_118);
    stringBuffer.append(NameHelper.getCapName(enumLiteral));
    stringBuffer.append(TEXT_119);
    stringBuffer.append(modelEnumName);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(EnumerationHelper.getEnumLiteralID(enumLiteral));
    stringBuffer.append(TEXT_121);
    stringBuffer.append(modelEnumName);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(propertyName);
    stringBuffer.append(TEXT_123);
    		}
    	}
    }*/
    	//process date
    	if(TypeHelper.isDate(property)){
    		String propertyName=NameHelper.uncapSafeName(property);
    		String propertyToDateTimeCapName=PropertyNamedRuleKind.dateToDateTimeStr.getRuleCapNamed(property);
    		//String propertyToDateTimeUncapName=PropertyNamedRuleKind.dateToDateTimeStr.getRuleUnCapNamed(property);
    		importManager.addImport("com.jeefuse.base.utils.common.DateUtil");
    stringBuffer.append(TEXT_124);
    		importManager.addImport("javax.persistence.Transient");
    stringBuffer.append(TEXT_125);
    stringBuffer.append(TypeHelper.getDocumentationOrName(property));
    stringBuffer.append(TEXT_126);
    stringBuffer.append(propertyToDateTimeCapName);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(propertyName);
    stringBuffer.append(TEXT_128);
    	}
    if (TypeHelper.isEnum(property)) {
    	Enumeration enumeration=(Enumeration)property.getType();
    	for (Iterator<EnumerationLiteral> l=enumeration.getOwnedLiterals().iterator(); l.hasNext();) {
    		EnumerationLiteral enumLiteral = (EnumerationLiteral)l.next();
    stringBuffer.append(TEXT_129);
    		if (StereotypeHelper.isStereotypeApplied(uml2Class, StereotypeHelper.ENTITY)) {
    			importManager.addImport("javax.persistence.Transient");
    stringBuffer.append(TEXT_130);
    		}
    stringBuffer.append(TEXT_131);
    stringBuffer.append(NameHelper.getCapName(enumLiteral));
    stringBuffer.append(TEXT_132);
    stringBuffer.append(enumeration.getName());
    stringBuffer.append(TEXT_133);
    stringBuffer.append(EnumerationHelper.getEnumLiteralID(enumLiteral));
    stringBuffer.append(TEXT_134);
    stringBuffer.append(NameHelper.uncapSafeName(property));
    stringBuffer.append(TEXT_135);
    	}
    }
    stringBuffer.append(TEXT_136);
    stringBuffer.append(MdaHelper.getImportedFeatureType(property));
    stringBuffer.append(TEXT_137);
    stringBuffer.append(NameHelper.uncapSafeName(property));
    stringBuffer.append(TEXT_138);
    stringBuffer.append(TypeHelper.getDefaultValue(property));
    stringBuffer.append(TEXT_139);
    }
    /********process non id propperty end********************/
    /********process implement treeView start********/
    	if(TreeStereotypeHelper.isApply(uml2Class)){
    		importManager.addImport("com.jeefuse.base.modules.tree.renders.treeview.TreeViewItem");
    		Property keyProperty=TreeStereotypeHelper.getProperty_id(uml2Class);
    stringBuffer.append(TEXT_140);
    		//String keyPropertyName=NameHelper.uncapSafeName(keyProperty);
    		/********keyProperty accessor ********/
    		String keyPropertyGetAccessorName=ClassHelper.getGetAccessor(keyProperty);
    stringBuffer.append(TEXT_141);
    		//String keyPropertySetAccessorName="set"+ClassHelper.getAccessorName(keyProperty);
    stringBuffer.append(TEXT_142);
    		Property listLabelProperty=TreeStereotypeHelper.getProperty_listLabel(uml2Class);
    stringBuffer.append(TEXT_143);
    		//String listLabelPropertyName=NameHelper.uncapSafeName(listLabelProperty);
    		String listLabelPropertyGetAccessorName=ClassHelper.getGetAccessor(listLabelProperty);
    stringBuffer.append(TEXT_144);
    		//Property layerCodeProperty=TreeStereotypeHelper.getProperty_layerCode(uml2Class);
    stringBuffer.append(TEXT_145);
    		//String layerCodePropertyName=NameHelper.uncapSafeName(layerCodeProperty);
    		//Property parentIdProperty=TreeStereotypeHelper.getProperty_parentId(uml2Class);
    stringBuffer.append(TEXT_146);
    		//String parentIdPropertyName=NameHelper.uncapSafeName(parentIdProperty);
    		importManager.addImport("javax.persistence.ManyToOne");
    		importManager.addImport("javax.persistence.FetchType");
    		importManager.addImport("javax.persistence.Transient");
    		importManager.addImport("javax.persistence.JoinColumn");
    stringBuffer.append(TEXT_147);
     		String columName=TreeStereotypeHelper.getProperty_parentId_apply_column_Name(uml2Class);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(columName);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(keyPropertyGetAccessorName);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(listLabelPropertyGetAccessorName);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(keyPropertyGetAccessorName);
    stringBuffer.append(TEXT_155);
    importManager.addImport("org.apache.commons.lang.StringUtils");
    stringBuffer.append(TEXT_156);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(idPropertySetAccessorName);
    stringBuffer.append(TEXT_159);
    }
    /********process implement treeView end********/
    /********process implement keyLabel start********/
    	if(KeyLabelStereotypeHelper.isApply(uml2Class)){
    		Property listKeyProperty=KeyLabelStereotypeHelper.getProperty_liskKey(uml2Class);
    stringBuffer.append(TEXT_160);
    		//String listKeyPropertyName=NameHelper.uncapSafeName(listKeyProperty);
    		String listKeyPropertyGetAccessorName=ClassHelper.getGetAccessor(listKeyProperty);
    stringBuffer.append(TEXT_161);
    		//String listKeyPropertySetAccessorName="set"+ClassHelper.getAccessorName(listKeyProperty);
    stringBuffer.append(TEXT_162);
    		Property listLabelProperty=KeyLabelStereotypeHelper.getProperty_listLabel(uml2Class);
    stringBuffer.append(TEXT_163);
    		//String listLabelPropertyName=NameHelper.uncapSafeName(listLabelProperty);
    		String listLabelPropertyGetAccessorName=ClassHelper.getGetAccessor(listLabelProperty);
    stringBuffer.append(TEXT_164);
    		//String listLabelPropertySetAccessorName="set"+ClassHelper.getAccessorName(listLabelProperty);
    importManager.addImport("javax.persistence.Transient");
    stringBuffer.append(TEXT_165);
    stringBuffer.append(listKeyPropertyGetAccessorName);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(listLabelPropertyGetAccessorName);
    stringBuffer.append(TEXT_167);
    }
    stringBuffer.append(TEXT_168);
    importManager.addImport("org.apache.commons.lang.builder.ToStringBuilder");
    importManager.addImport("org.apache.commons.lang.builder.ToStringStyle");
    stringBuffer.append(TEXT_169);
    stringBuffer.append(GenHelper.genEntityToStringBuilder(uml2Class));
    stringBuffer.append(TEXT_170);
    if (StereotypeHelper.isStereotypeApplied(uml2Class, StereotypeHelper.ENTITY)) {
    if (!ClassHelper.hasSuperClass(uml2Class)) {
    stringBuffer.append(TEXT_171);
    stringBuffer.append(idPropertyName);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(idPropertyName);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(modelEntityName);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(idPropertyName);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(idPropertyName);
    stringBuffer.append(TEXT_178);
    }
    }
    stringBuffer.append(TEXT_179);
    importStringBuffer.insert(importInsertionPoint, importManager.computeSortedImports());
    stringBuffer.append(TEXT_180);
    return stringBuffer.toString();
  }
}
