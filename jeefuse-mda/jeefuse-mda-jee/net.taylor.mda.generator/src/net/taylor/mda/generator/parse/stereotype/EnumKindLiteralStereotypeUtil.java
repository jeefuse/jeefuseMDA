package net.taylor.mda.generator.parse.stereotype;

import net.taylor.mda.generator.parse.StereotypeUtil;

import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Stereotype;

import net.jeefuse.mda.annotations.MdaStereotype;
import net.jeefuse.mda.commons.kind.EnumKindLiteralAttributes;

public class EnumKindLiteralStereotypeUtil {
	static public final String stereotype = MdaStereotype.EnumKindLiteral;

	/**
	 * 判断元素是否应用了定型<%=modelName%>.
	 */
	public static boolean isApplied(NamedElement element) {
		return StereotypeUtil.isAppliedStereotype(element, stereotype);
	}

	/**
	 * 获取应用的stereotype:<%=modelName%>.
	 */
	public static Stereotype getApplied(NamedElement element) {
		return StereotypeUtil.getAppliedStereotype(element, stereotype);
	}

	/**
	 * 获取应用的stereotype的属性值.如果没有应用stereotype将返回空.
	 */
	public static Object getApplied(NamedElement element, EnumKindLiteralAttributes attribute) {
		return StereotypeUtil.getAppliedValue(element, stereotype, attribute.toString());
	}

	/**
	 * 判断元素是否应用了定型,且其指定属性的值与给定的值相等.如果其属性类型是boolean、enum将转化为String后比较.
	 */
	public static boolean isApplied(NamedElement element, EnumKindLiteralAttributes attribute, String value) {
		return StereotypeUtil.isAppliedValueMatch(element, stereotype, attribute.toString(), value);
	}

	// --------------------------------------------------------------
	// special value define
	// --------------------------------------------------------------

	public static String getLiteralValue(EnumerationLiteral element) {
		Object value = getApplied(element, EnumKindLiteralAttributes.value);
		return (String) value;
	}

	public static String getLiteralLable(EnumerationLiteral element) {
		Object value = getApplied(element, EnumKindLiteralAttributes.lable);
		return (String) value;
	}

	public static String getLiteralColor(EnumerationLiteral element) {
		String value = StereotypeUtil.getAppliedValueForString(element, stereotype, EnumKindLiteralAttributes.color.toString());
		return value;
	}

}