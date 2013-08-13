package net.taylor.mda.generator.parse.stereotype;

import net.taylor.mda.generator.parse.StereotypeUtil;
import net.taylor.mda.generator.util.StereotypeHelper;

import org.eclipse.uml2.uml.Property;

public class ColumnStereotypeHelper {

	final static String stereotype = StereotypeHelper.COLUMN;

	public static boolean isApply(Property element) {
		return StereotypeUtil.isAppliedStereotype(element, stereotype);
	}

	static public String getApplyColumn_name(Property element) {
		if(null==element){
			return null;
		}
		String attribute = "name";
		Object value = StereotypeHelper.getValue(element, stereotype, attribute);
		return (String) value;
	}
	
	static public Integer getApplyColumn_length(Property property){
		if (StereotypeHelper.isStereotypeApplied(property, StereotypeHelper.COLUMN)) {
			return (Integer) StereotypeHelper.getValue(property, StereotypeHelper.COLUMN, "length");
		}
		return null;
	}

}
