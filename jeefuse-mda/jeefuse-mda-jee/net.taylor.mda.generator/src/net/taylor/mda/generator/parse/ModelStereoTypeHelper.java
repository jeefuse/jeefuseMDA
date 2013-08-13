package net.taylor.mda.generator.parse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.taylor.mda.generator.util.ImportHelper;
import net.taylor.mda.generator.util.StereotypeHelper;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;

import net.jeefuse.mda.annotations.MdaStereotype;
import net.jeefuse.mda.annotations.maintain.MaintainStereotype;
import net.jeefuse.mda.annotations.site.SiteStereotype;

public class ModelStereoTypeHelper {
	
	public static String getEntityStereoType(org.eclipse.uml2.uml.Class uml2Class) {
		List<String> excludeStereotypes = new ArrayList<String>();
		excludeStereotypes.add(MdaStereotype.service_Functions);
		excludeStereotypes.add(MdaStereotype.model_Dto);
		excludeStereotypes.add(MdaStereotype.model_File);
		excludeStereotypes.add(MdaStereotype.model_Image);
		excludeStereotypes.add(MdaStereotype.model_KeyLabel);
		excludeStereotypes.add(MdaStereotype.model_M2m);
		excludeStereotypes.add(MdaStereotype.model_M2mWithId);
		excludeStereotypes.add(MdaStereotype.model_Rto);
		excludeStereotypes.add(MdaStereotype.model_Tree);
		excludeStereotypes.add(MdaStereotype.model_Vo);
		excludeStereotypes.add(MdaStereotype.model_ListForSelect);
		excludeStereotypes.add(MdaStereotype.view_Input);
		excludeStereotypes.add(MdaStereotype.impExcel);
		excludeStereotypes.add(MdaStereotype.expExcel);
		//site
		excludeStereotypes.add(SiteStereotype.viewDetail);
		excludeStereotypes.add(SiteStereotype.viewList);
		//maintain
		excludeStereotypes.add(MaintainStereotype.Maintain);
		excludeStereotypes.add(MaintainStereotype.MEdit);
		return getAnnotations(uml2Class, excludeStereotypes, false);
	}

	public static String getEntityPropertyStereoType(org.eclipse.uml2.uml.Property property, boolean tab) {
		List<String> excludeStereotypes = new ArrayList<String>();
		excludeStereotypes.add(MdaStereotype.view_Input);
		excludeStereotypes.add(MdaStereotype.view_List);
		excludeStereotypes.add(MdaStereotype.view_Search);
		excludeStereotypes.add(MdaStereotype.view_ListKind);
		excludeStereotypes.add(MdaStereotype.property_EnumKind);
		excludeStereotypes.add(MdaStereotype.M2MCheckboxs);
		excludeStereotypes.add(MdaStereotype.M2MCheckboxsPage);
		excludeStereotypes.add(MdaStereotype.M2MCheckboxsTab);
		excludeStereotypes.add(MdaStereotype.M2MCheckboxsTree);
		excludeStereotypes.add(MdaStereotype.M2MCheckboxsTreePage);
		excludeStereotypes.add(MdaStereotype.M2MCheckboxsTreeTab);
		excludeStereotypes.add(MdaStereotype.M2OSelectPage);
		excludeStereotypes.add(MdaStereotype.M2OSelect);
		excludeStereotypes.add(MdaStereotype.O2MManagerPage);
		excludeStereotypes.add(MdaStereotype.O2OSelect);
		excludeStereotypes.add(MdaStereotype.O2OSelectPage);
		excludeStereotypes.add(MdaStereotype.validate_DateCN);
		excludeStereotypes.add(MdaStereotype.validate_email);
		excludeStereotypes.add(MdaStereotype.validate_IdCardNo);
		excludeStereotypes.add(MdaStereotype.validate_letterNum);
		excludeStereotypes.add(MdaStereotype.validate_Mobile);
		excludeStereotypes.add(MdaStereotype.validate_Phone);
		excludeStereotypes.add(MdaStereotype.validate_Tel);
		excludeStereotypes.add(MdaStereotype.validate_Url);
		excludeStereotypes.add(MdaStereotype.validate_ZipCode);
		excludeStereotypes.add(MdaStereotype.property_ManageByProperty);
		//site
		excludeStereotypes.add(SiteStereotype.viewDetail);
		excludeStereotypes.add(SiteStereotype.viewList);
		//maintain
		excludeStereotypes.add(MaintainStereotype.Maintain);
		excludeStereotypes.add(MaintainStereotype.MEdit);
		//文件
		excludeStereotypes.add(MdaStereotype.property_FileType);
		excludeStereotypes.add(MdaStereotype.property_FileSize);
		excludeStereotypes.add(MdaStereotype.property_FileSavePath);
		excludeStereotypes.add(MdaStereotype.property_FileName);
		excludeStereotypes.add(MdaStereotype.property_FileExtention);
//		if (StereotypeHelper.isStereotypeApplied(property, "javax.persistence.ManyToOne")
//				&& StereotypeHelper.isStereotypeApplied(property.getOwner(),MdaStereotype.model_M2mWithId)) {
		if (StereotypeHelper.isStereotypeApplied(property, "javax.persistence.ManyToOne")) {
			// join column
			StringBuffer annotations = new StringBuffer();
			annotations.append("@JoinColumn(");
			String joinCoumnName = StereotypeHelper.getValue(property, "javax.persistence.JoinColumn", "name")
					.toString();
			annotations.append("name = \"" + joinCoumnName + "\"");
			annotations.append(", unique = false, nullable = false, insertable = true, updatable = true");
			annotations.append(")");
			annotations.append("\n" + (tab ? "\t" : ""));
			// many to one
			annotations.append("@ManyToOne(");
			annotations.append("fetch = FetchType.LAZY ");
			//annotations.append(", cascade = {CascadeType.PERSIST,CascadeType.MERGE}");
			annotations.append(")");
			excludeStereotypes.add("javax.persistence.ManyToOne");
			excludeStereotypes.add("javax.persistence.JoinColumn");
			ImportHelper.getImportedName("javax.persistence.ManyToOne");
			ImportHelper.getImportedName("javax.persistence.JoinColumn");
			ImportHelper.getImportedName("javax.persistence.FetchType");
			//ImportHelper.getImportedName("javax.persistence.CascadeType");
			String otherAnnotations=getAnnotations(property, excludeStereotypes, tab);
			annotations.append(otherAnnotations.length()==0?"":"\n" + (tab ? "\t" : "")+otherAnnotations);
			return annotations.toString();
		}

		return getAnnotations(property, excludeStereotypes, true);
	}

	public static String getAnnotations(Element element, List<String> excludeStereotypes, boolean tab) {
		StringBuffer annotations = new StringBuffer();
		List<Stereotype> showStereotype=new ArrayList<Stereotype>();
		Iterator<Stereotype> i = element.getAppliedStereotypes().iterator();
		while (i.hasNext()) {
			Stereotype stereotype = (Stereotype) i.next();
			if (null != excludeStereotypes && excludeStereotypes.contains(stereotype.getName())){
				continue;
			}
			showStereotype.add(stereotype);
		}
		for(Iterator<Stereotype> si=showStereotype.iterator();si.hasNext();){
			annotations.append(StereotypeHelper.getAnnotation(element, (Stereotype)si.next()));
			if (si.hasNext())
				annotations.append("\n" + (tab ? "\t" : ""));
		}
		return annotations.toString();
	}
	
	/*****************************************************************
	 * 定义实体类相关Stereotype
	/*****************************************************************/
	/********model tree********/
	public static boolean isApplyModel_Tree(Type element) {
		return StereotypeUtil.isAppliedStereotype(element, MdaStereotype.model_Tree);
	}

	/********model M2M********/
	public static boolean isApplyModel_M2M(Type element) {
		return StereotypeUtil.isAppliedStereotype(element, MdaStereotype.model_M2m);
	}
	/********model M2MWithId********/
	public static boolean isApplyModel_M2mWithId(Type element) {
		return StereotypeUtil.isAppliedStereotype(element, MdaStereotype.model_M2mWithId);
	}
	/********model file********/
	public static boolean isApplyModel_File(Type element) {
		return StereotypeUtil.isAppliedStereotype(element, MdaStereotype.model_File);
	}
	/********model image********/
	public static boolean isApplyModel_Image(Type element) {
		return StereotypeUtil.isAppliedStereotype(element, MdaStereotype.model_Image);
	}
	/********model rto********/
	public static boolean isApplyModel_Rto(Type element) {
		return StereotypeUtil.isAppliedStereotype(element, MdaStereotype.model_Rto);
	}
	/********model vo********/
	public static boolean isApplyModel_Vo(Type element) {
		return StereotypeUtil.isAppliedStereotype(element, MdaStereotype.model_Vo);
	}
	
	/********model vo********/
	public static boolean isApplyModel_ListForSelect(Type element) {
		return StereotypeUtil.isAppliedStereotype(element, MdaStereotype.model_ListForSelect);
	}
	
	
}
