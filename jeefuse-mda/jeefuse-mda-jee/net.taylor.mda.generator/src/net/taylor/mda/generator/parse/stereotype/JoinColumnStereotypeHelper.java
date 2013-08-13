package net.taylor.mda.generator.parse.stereotype;

import net.taylor.mda.generator.parse.StereotypeUtil;
import net.taylor.mda.generator.util.StereotypeHelper;

import org.eclipse.uml2.uml.Property;

public class JoinColumnStereotypeHelper {

final static String stereotype= StereotypeHelper.JONINCOLUMN;
	
	public static boolean isApply(Property element) {
		return StereotypeUtil.isAppliedStereotype(element, stereotype);
	}
	
	
	static public String getApplyColumn_name(Property element) {
		String attribute="name";
		Object value=StereotypeHelper.getValue(element, stereotype, attribute);
		return (String)value;
	}
	


}
