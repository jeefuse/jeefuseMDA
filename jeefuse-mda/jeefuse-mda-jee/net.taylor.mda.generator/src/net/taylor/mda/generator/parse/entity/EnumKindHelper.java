package net.taylor.mda.generator.parse.entity;

import java.util.ArrayList;
import java.util.List;

import net.taylor.mda.generator.parse.ExcelImportHelper;
import net.taylor.mda.generator.parse.UmlHelper;
import net.taylor.mda.generator.util.NameHelper;
import net.taylor.mda.generator.util.StereotypeHelper;

import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.Property;

import net.jeefuse.mda.annotations.MdaStereotype;
import net.jeefuse.mda.annotations.property.EnumKindAttributes;

public class EnumKindHelper {

	public static boolean isAppliedEnumKind(Property property) {
		return StereotypeHelper.isStereotypeApplied(property,
				MdaStereotype.property_EnumKind);
	}

	public static List<Property> getPropertiesAppliedEnumKind(Class uml2Class) {
		List<Property> resultList = new ArrayList<Property>();
		List<Property> propertyList = EntityHelper.getAllProperties(uml2Class);
		for (Property property : propertyList) {
			if (isAppliedEnumKind(property)) {
				resultList.add(property);
			}
		}
		return resultList;
	}

	public static Enumeration getAppliedEnumKindEnumeration(Property property) {
		if (isAppliedEnumKind(property)) {
			String stereotype = MdaStereotype.property_EnumKind;
			String stereotypeAttribute = EnumKindAttributes.enumName.toString();
			Object enumName = StereotypeHelper.getValue(property, stereotype, stereotypeAttribute);
			if (null == enumName) {
				return null;
			}
			return UmlHelper.getEnumerationElement(property.getModel(),(String) enumName);
		} else {
			return null;
		}
	}

	public static String getEnumKindPropertyJsonFormat(Property property) {
		StringBuilder sb = new StringBuilder("");
		if (EnumKindHelper.isAppliedEnumKind(property)) {
			Enumeration enumeration = EnumKindHelper.getAppliedEnumKindEnumeration(property);
			if (null != enumeration) {
				sb.append(",process:format");
				sb.append(NameHelper.getCapName(enumeration));
			}
		}
		return sb.toString();
	}

	public static String getExcelImportPropertyFormat(Property property) {
		StringBuilder sb = new StringBuilder("");
		sb.append("ExcelCheck.");
		Enumeration enumeration = null;
		if (EnumKindHelper.isAppliedEnumKind(property)) {
			enumeration = EnumKindHelper.getAppliedEnumKindEnumeration(property);
			if (null != enumeration) {
				sb.append(ExcelImportHelper.getExcelCheckString(property.getType()));
			}
		}
		return sb.toString();
	}

}
