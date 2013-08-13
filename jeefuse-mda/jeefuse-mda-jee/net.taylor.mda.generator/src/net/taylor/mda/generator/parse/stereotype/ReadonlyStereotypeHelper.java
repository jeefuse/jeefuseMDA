package net.taylor.mda.generator.parse.stereotype;

import net.taylor.mda.generator.parse.StereotypeUtil;
import net.taylor.mda.generator.parse.StringUtils;
import net.taylor.mda.generator.parse.UmlHelper;
import net.taylor.mda.generator.parse.entity.EntityHelper;
import net.taylor.mda.generator.util.StereotypeHelper;

import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Property;

import net.jeefuse.mda.annotations.MdaStereotype;
import net.jeefuse.mda.annotations.model.TreeAnnotations;

public class ReadonlyStereotypeHelper {

	final static String stereotype= MdaStereotype.model_Tree;
	
	public static boolean isApply(Class element) {
		return StereotypeUtil.isAppliedStereotype(element, stereotype);
	}
	
	static public String getValue_id(Class element) {
		String attribute=TreeAnnotations.id.toString();
		Object value=StereotypeHelper.getValue(element, stereotype, attribute);
		return (String)value;
	}
	
	static public String getValue_parentId(Class element) {
		String attribute=TreeAnnotations.parentId.toString();
		Object value=StereotypeHelper.getValue(element, stereotype, attribute);
		return (String)value;
	}
	
	static public String getValue_listLabel(Class element) {
		String attribute=TreeAnnotations.listLabel.toString();
		Object value=StereotypeHelper.getValue(element, stereotype, attribute);
		return (String)value;
	}
	
	static public String getValue_layerCode(Class element) {
		String attribute=TreeAnnotations.layerCode.toString();
		Object value=StereotypeHelper.getValue(element, stereotype, attribute);
		return (String)value;
	}
	
	static public String getValue_layerDeep(Class element) {
		String attribute=TreeAnnotations.layerDeep.toString();
		Object value=StereotypeHelper.getValue(element, stereotype, attribute);
		if(null==value||value.toString().trim().equals(""))
			return "TreeLayerCodeUtil.defaultLayerMaxDeep";
		return value.toString();
	}
	
	/**
	 * 获取stereotype:id 值对应的属性.
	 */
	static public Property getProperty_id(Class element){
		Property property=null;
		//根据Stererotype设置的ID属性值查找其名称相同的属性
		String stereotypeValue=getValue_id(element);
		if(StringUtils.isNotBlank(stereotypeValue)){
			property= UmlHelper.getPropertyElement(element,stereotypeValue );
		}
		//默认
		if(null==property){
			//property=UmlHelper.getPropertyElement(element,"id" );
			property=EntityHelper.getIDProperty(element);
		}
		return property;
	}
	
	
	/**
	 * 获取stereotype:parentId 值对应的属性.
	 */
	static public Property getProperty_parentId(Class element){
		Property property=null;
		//根据Stererotype设置的ID属性值查找其名称相同的属性
		String stereotypeValue=getValue_parentId(element);
		if(StringUtils.isNotBlank(stereotypeValue)){
			property= UmlHelper.getPropertyElement(element,stereotypeValue );
		}
		//应用了stereotype:ListLabel
		if(null==property){
			property=StereotypeUtil.getClassProperty(element, MdaStereotype.property_ParendId);
		}
		//默认
		if(null==property){
			property=UmlHelper.getPropertyElement(element,"parentId" );
		}
		return property;
	}
	
	/**
	 * 获取stereotype:parentId 值对应的属性.
	 */
	static public String getProperty_parentId_apply_column_Name(Class element){
		Property property=getProperty_parentId( element);
		String parentIdColumnName=null;
		if(null!=property){
			parentIdColumnName=ColumnStereotypeHelper.getApplyColumn_name(property); 
		}
		if(null==parentIdColumnName)
			parentIdColumnName="PARENT_ID";
		return parentIdColumnName;
	}
	
	/**
	 * 获取stereotype:listLabel 值对应的属性.
	 */
	static public Property getProperty_listLabel(Class element){
		Property property=null;
		//根据Stererotype设置的ID属性值查找其名称相同的属性
		String stereotypeValue=getValue_listLabel(element);
		if(StringUtils.isNotBlank(stereotypeValue)){
			property= UmlHelper.getPropertyElement(element,stereotypeValue );
		}
		//应用了stereotype:ListLabel
		if(null==property){
			property=StereotypeUtil.getClassProperty(element, MdaStereotype.property_ListLabel);
		}
		//默认
		if(null==property){
			property=UmlHelper.getPropertyElement(element,"name" );
		}
		return property;
	}
	
	/**
	 * 获取stereotype:layerCode 值对应的属性.
	 */
	static public Property getProperty_layerCode(Class element){
		Property property=null;
		//根据Stererotype设置的ID属性值查找其名称相同的属性
		String stereotypeValue=getValue_listLabel(element);
		if(StringUtils.isNotBlank(stereotypeValue)){
			property= UmlHelper.getPropertyElement(element,stereotypeValue );
		}
		//应用了stereotype:ListLabel
		if(null==property){
			property=StereotypeUtil.getClassProperty(element, MdaStereotype.property_LayerCode);
		}
		//默认
		if(null==property){
			property=UmlHelper.getPropertyElement(element,"layerCode" );
		}
		return property;
	}
	
	static public boolean isParentIdProperty(Property property){
		if(null==property){
			return false;
		}
		if(StereotypeUtil.isAppliedStereotype(property,MdaStereotype.property_ParendId)){
			return true;
		}
		if(property.getName().equalsIgnoreCase("parentId"))
			return true;
		return false;
	}
}
