package net.taylor.mda.generator.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.taylor.mda.generator.parse.stereotype.ColumnStereotypeHelper;

import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Property;

public class SiteViewHelper {

	public static List<Property> getViewDetailPropertiesFromSimple(Class element) {
		List<Property> propertyList = new ArrayList<Property>();
		Iterator<Property> i = ClassHelper.getAllSimpleProperties(element);
		for (; i.hasNext();) {
			Property property = (Property) i.next();
			propertyList.add(property);
		}
		return propertyList;
	}
	
	/**
	 * 获取长度大于257的属性集合.
	 */
	public static List<Property> getContentPropertiesFromSimple(Class element) {
		List<Property> propertyList = new ArrayList<Property>();
		Iterator<Property> i = ClassHelper.getAllSimpleProperties(element);
		for (; i.hasNext();) {
			Property property = (Property) i.next();
			Integer length=ColumnStereotypeHelper.getApplyColumn_length(property);
			if(null!=length&&length>257){
				propertyList.add(property);
			}
		}
		return propertyList;
	}
}
