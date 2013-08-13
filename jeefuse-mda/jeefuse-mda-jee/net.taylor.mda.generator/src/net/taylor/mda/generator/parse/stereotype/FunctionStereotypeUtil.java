package net.taylor.mda.generator.parse.stereotype;

import net.taylor.mda.generator.parse.StereotypeUtil;

import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Stereotype;

import net.jeefuse.mda.annotations.MdaStereotype;
import net.jeefuse.mda.annotations.service.FunctionsAttributes;

/**
 * mda.annotations.service.Functions stereotype应用工具.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public class FunctionStereotypeUtil {
	static public final String stereotype = MdaStereotype.service_Functions;

	/**
	 * 判断元素是否应用了定型.
	 */
	public static boolean isApplied(NamedElement element) {
		return StereotypeUtil.isAppliedStereotype(element, stereotype);
	}

	/**
	 * 获取应用的stereotype.
	 */
	public static Stereotype getApplied(NamedElement element) {
		return StereotypeUtil.getAppliedStereotype(element, stereotype);
	}

	/**
	 * 获取应用的stereotype的属性值.如果没有应用stereotype将返回空.
	 */
//	private static Object getAppliedStereotypeValue(NamedElement element, FunctionsAttributes attribute) {
//		return StereotypeUtil.getAppliedValue(element, stereotype, attribute.toString());
//	}

	/**
	 * 判断元素是否应用了定型,且其指定属性的值与给定的值相等.如果其属性类型是boolean、enum将转化为String后比较.
	 */
	private static boolean isApplied(NamedElement element, FunctionsAttributes attribute, String value) {
		return StereotypeUtil.isAppliedValueMatch(element, stereotype, attribute.toString(), value);
	}


//	public static boolean isApplied_ListForSelect(NamedElement element) {
//		return isApplied(element, FunctionsAttributes.listForSelect, "true");
//	}
	
	public static boolean isApplied_manage(NamedElement element){
		NamedElement uml2Class=element;
		FunctionStereotypeUtil.isApplied_saveOutJson(uml2Class);
		return isApplied(element, FunctionsAttributes.manage, "true");
	}
	
	public static boolean isApplied_deleteAllOutJson(NamedElement element){
		return isApplied(element, FunctionsAttributes.deleteAll, "true");
	}
	
	public static boolean isApplied_deleteOutJson(NamedElement element){
		return isApplied(element, FunctionsAttributes.delete, "true");
	}
	
	public static boolean isApplied_edit(NamedElement element){
		return isApplied(element, FunctionsAttributes.edit, "true");
	}
	
	public static boolean isApplied_getOutJson(NamedElement element){
		return isApplied(element, FunctionsAttributes.getOutJson, "true");
	}
	
	public static boolean isApplied_input(NamedElement element){
		return isApplied(element, FunctionsAttributes.input, "true");
	}
	
	public static boolean isApplied_listOutJson(NamedElement element){
		return isApplied(element, FunctionsAttributes.manage, "true");
	}
	
	public static boolean isApplied_saveOutJson(NamedElement element){
		return isApplied(element, FunctionsAttributes.save, "true");
	}
	
//	public static boolean isApplied_updateOutJson(NamedElement element){
//		return isApplied(element, FunctionsAttributes.updateOutJson, "true");
//	}
}