package net.taylor.mda.generator.parse.stereotype;

import java.util.Iterator;
import java.util.List;

import net.taylor.mda.generator.parse.StereotypeUtil;
import net.taylor.mda.generator.parse.entity.EntityHelper;
import net.taylor.mda.generator.util.ClassHelper;

import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Property;

import net.jeefuse.mda.annotations.MdaStereotype;

public class PropertyStereotypeHelper {

	/*****************************************************************
	 * stereotype define
	/*****************************************************************/

	public static boolean isApplyPropertyTitle(Property element) {
		return StereotypeUtil.isAppliedStereotype(element, MdaStereotype.property_Title);
	}

	public static boolean isApplyPropertyIntro(Property element) {
		return StereotypeUtil.isAppliedStereotype(element, MdaStereotype.property_Intro);
	}
	
	public static boolean isApplyPropertyContent(Property element) {
		return StereotypeUtil.isAppliedStereotype(element, MdaStereotype.property_Content);
	}

	public static boolean isApplyProperty_category(Property element) {
		return StereotypeUtil.isAppliedStereotype(element, MdaStereotype.property_Category);
	}
	
	/*****************************************************************
	 * utils
	/*****************************************************************/
	public static Property getProperty_Title(Class uml2Class){
		Iterator<Property> i = ClassHelper.getAllSimpleProperties(uml2Class);
		for (; i.hasNext();) {
			Property property = (Property) i.next();
			if (isApplyPropertyTitle(property))
				return property;
			if(property.getName().equalsIgnoreCase("title"))
				return property;
		}
		return null;
	}

	public static Property getProperty_Intro(Class uml2Class){
		Iterator<Property> i = ClassHelper.getAllSimpleProperties(uml2Class);
		for (; i.hasNext();) {
			Property property = (Property) i.next();
			if (isApplyPropertyIntro(property))
				return property;
			if(property.getName().equalsIgnoreCase("Intro")||property.getName().equalsIgnoreCase("descript"))
				return property;
		}
		return null;
	}
	
	public static Property getProperty_Content(Class uml2Class){
		Iterator<Property> i = ClassHelper.getAllSimpleProperties(uml2Class);
		for (; i.hasNext();) {
			Property property = (Property) i.next();
			if (isApplyPropertyContent(property))
				return property;
			if(property.getName().equalsIgnoreCase("Content"))
				return property;
		}
		return null;
	}
	
	public static boolean hasProperty_Category(Class uml2Class){
		List<Property> list = EntityHelper.getAllRelProperties(uml2Class,false);
		for (Iterator<Property> i=list.iterator(); i.hasNext();) {
			Property property = (Property) i.next();
			if (isApplyProperty_category(property))
				return true;
		}
		return false;
	}
	
	public static Property getProperty_Category(Class uml2Class){
		List<Property> list = EntityHelper.getAllRelProperties(uml2Class,false);
		for (Iterator<Property> i=list.iterator(); i.hasNext();) {
			Property property = (Property) i.next();
			if (isApplyProperty_category(property))
				return property;
		}
		return null;
	}
}
