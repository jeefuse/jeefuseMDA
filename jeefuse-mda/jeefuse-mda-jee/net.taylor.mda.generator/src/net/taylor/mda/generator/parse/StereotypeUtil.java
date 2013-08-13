package net.taylor.mda.generator.parse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.taylor.mda.generator.parse.entity.EntityHelper;
import net.taylor.mda.generator.util.StereotypeHelper;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;

/**
 * Stereotype 工具类.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public class StereotypeUtil {

	/**
	 * 获取元素所应用的定型.
	 * 
	 * @param element
	 * @return
	 */
	public static Iterator<Stereotype> getAppliedStereotypes(Element element) {
		return StereotypeHelper.getStereotypes(element);
	}

	/**
	 * 判断元素是否应用了定型.
	 */
	public static boolean isAppliedStereotype(Element element, String stereotype) {
		return StereotypeHelper.isStereotypeApplied(element, stereotype);
	}

	/**
	 * 获取应用的stereotype对象.
	 */
	/**
	 * @param element
	 * @param stereotype
	 * @return
	 */
	public static Stereotype getAppliedStereotype(Element element, String stereotype) {
		return StereotypeHelper.getStereotype(element, stereotype);
	}

	/**
	 * 获取应用的stereotype的属性值.如果没有应用stereotype将返回空.
	 * 
	 * @param element
	 *            uml元素
	 * @param stereotype
	 *            应用定型
	 * @param attribute
	 *            定型属性
	 * @return
	 */
	public static Object getAppliedValue(Element element, String stereotype, String attribute) {
		if (isAppliedStereotype(element, stereotype)) {
			Object s_value = StereotypeHelper.getValue(element, stereotype, attribute);
			return s_value;
		}
		return null;
	}

	/**
	 * 获取应用的stereotype的属性值.如果没有应用stereotype将返回空..如果其属性类型是boolean、enum将转化为String.
	 * 
	 * @param element
	 *            uml元素
	 * @param stereotype
	 *            应用定型
	 * @param attribute
	 *            定型属性
	 * @return
	 */
	public static String getAppliedValueForString(NamedElement element, String stereotype, String attribute) {
		if (isAppliedStereotype(element, stereotype)) {
			Object s_value = StereotypeHelper.getValue(element, stereotype, attribute);
			if (null == s_value)
				return null;
			if (s_value instanceof Boolean) {
				return ((Boolean) s_value).toString();

			}
			if (s_value instanceof EnumerationLiteral) {
				EnumerationLiteral enumerationLiteral = (EnumerationLiteral) s_value;
				if (null != enumerationLiteral) {
					return enumerationLiteral.getName();
				}
			}
			return s_value.toString();
		}
		return null;
	}

	/**
	 * 判断元素是否应用了定型,且其指定属性的值与给定的值相等.如果其属性类型是boolean、enum将转化为String后比较.
	 * 
	 * @param element
	 *            uml元素
	 * @param stereotype
	 *            应用定型
	 * @param attribute
	 *            定型属性
	 * @param value
	 *            属性值
	 * @return
	 */
	public static boolean isAppliedValueMatch(NamedElement element, String stereotype, String attribute, String value) {
		if (isAppliedStereotype(element, stereotype)) {
			Object s_value = StereotypeHelper.getValue(element, stereotype, attribute);
			if (null == s_value)
				return false;
			if (s_value instanceof Boolean) {
				if (((Boolean) s_value).toString().equalsIgnoreCase(value)) {
					return true;
				}
			}
			if (s_value instanceof EnumerationLiteral) {
				EnumerationLiteral enumerationLiteral = (EnumerationLiteral) s_value;
				if (null != enumerationLiteral) {
					return enumerationLiteral.getName().equalsIgnoreCase(value);
				}
			}
			return value.equalsIgnoreCase(s_value.toString());
		}
		return false;
	}

	/**
	 * 是否应用了stereotype的attribute值设置为"true".
	 * 
	 * @param element
	 *            uml元素
	 * @param stereotype
	 *            应用定型
	 * @param attribute
	 *            定型属性
	 * @return
	 */
	public static boolean isApliedValueTrue(NamedElement element, String stereotype, String attribute) {
		return isAppliedValueMatch(element, stereotype, attribute, "true");
	}

	/**
	 * 获取元素应用的stereotype的属性值,且该属性的类型为enum,如果没有值或不是enum类型则返回空.
	 * 
	 * @param element
	 *            uml元素
	 * @param stereotype
	 *            应用定型
	 * @param stereotypeAttribute
	 *            定型属性
	 * @return
	 */
	public static String getAppliedValueForEnum(NamedElement element, String stereotype, String stereotypeAttribute) {
		Object value = StereotypeHelper.getValue(element, stereotype, stereotypeAttribute);
		if (value instanceof EnumerationLiteral) {
			EnumerationLiteral enumerationLiteral = (EnumerationLiteral) value;
			if (null != enumerationLiteral) {
				return enumerationLiteral.getName();
			}
		}
		return null;
	}

	/**
	 * 判断元素是否应用了定型,且其指定属性的值与给定的值相等.属性的类型为enum.
	 * 
	 * @param element
	 *            uml元素
	 * @param stereotype
	 *            应用定型
	 * @param attribute
	 *            定型属性
	 * @param value
	 *            属性值
	 * @return
	 */
	public static boolean isAppliedValueMatchForEnum(NamedElement element, String stereotype, String attribute,
			String value) {
		String s_value = getAppliedValueForEnum(element, stereotype, attribute);
		if (null == s_value)
			return false;
		return value.equalsIgnoreCase(s_value);
	}

	/**
	 * 获取类中应用了stereotype的属性例表.
	 * 
	 * @param uml2Class
	 *            uml类
	 * @param stereotype
	 *            定型
	 * @return
	 */
	public static List<Property> getClassProperties(org.eclipse.uml2.uml.Class uml2Class, String stereotype) {
		List<Property> resultList = new ArrayList<Property>();
		List<Property> properties = EntityHelper.getAllProperties(uml2Class);
		for (Property property : properties) {
			if (StereotypeHelper.isStereotypeApplied(property, stereotype))
				resultList.add(property);
		}
		return resultList;
	}

	/**
	 * 获取uml class类中应用了stereotype的属性.只返回查找到的首个.
	 * 
	 * @param uml2Class
	 *            uml类
	 * @param stereotype
	 *            定型
	 * @return
	 */
	public static Property getClassProperty(org.eclipse.uml2.uml.Class uml2Class, String stereotype) {
		List<Property> properties = EntityHelper.getAllProperties(uml2Class);
		for (Property property : properties) {
			if (StereotypeHelper.isStereotypeApplied(property, stereotype))
				return property;
		}
		return null;
	}
}
