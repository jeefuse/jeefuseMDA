package net.taylor.mda.generator.parse.stereotype;

import net.taylor.mda.generator.parse.StereotypeUtil;
import net.taylor.mda.generator.parse.StringUtils;
import net.taylor.mda.generator.parse.UmlHelper;
import net.taylor.mda.generator.parse.entity.EntityHelper;
import net.taylor.mda.generator.util.StereotypeHelper;

import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Property;

import net.jeefuse.mda.annotations.MdaStereotype;
import net.jeefuse.mda.annotations.model.KeyLabelAnnotations;

public class KeyLabelStereotypeHelper {

	final static String stereotype= MdaStereotype.model_KeyLabel;
	
	public static boolean isApply(Class element) {
		return StereotypeUtil.isAppliedStereotype(element, stereotype);
	}
	
	
	static public String getApplyKeyLabel_liskKey(Class element) {
		String attribute=KeyLabelAnnotations.listKey.toString();
		Object value=StereotypeHelper.getValue(element, stereotype, attribute);
		return (String)value;
	}
	
	public static String getApplyKeyLabel_listLabel(Class element){
		String attribute=KeyLabelAnnotations.listLabel.toString();
		String value=StereotypeUtil.getAppliedValueForString(element, stereotype, attribute);
		return value;
	}
	
	/**
	 * 获取stereotype:liskKey 值对应的属性.
	 */
	static public Property getProperty_liskKey(Class element){
		Property property=null;
		//根据Stererotype设置的ID属性值查找其名称相同的属性
		String stereotypeValue=getApplyKeyLabel_liskKey(element);
		if(StringUtils.isNotBlank(stereotypeValue)){
			property= UmlHelper.getPropertyElement(element,stereotypeValue );
		}
		//默认
		if(null==property){
			property=EntityHelper.getIDProperty(element);
		}
		return property;
	}
	
	/**
	 * 获取stereotype:listLabel 值对应的属性.
	 */
	static public Property getProperty_listLabel(Class element){
		Property property=null;
		//根据Stererotype设置的ID属性值查找其名称相同的属性
		String stereotypeValue=getApplyKeyLabel_listLabel(element);
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
	


}
