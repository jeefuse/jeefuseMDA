package net.taylor.mda.generator.parse.stereotype;

import net.taylor.mda.generator.parse.StereotypeUtil;
import net.taylor.mda.generator.util.StereotypeHelper;

public class TableStereotypeHelper {

final static String stereotype= StereotypeHelper.TABLE;
	
	public static boolean isApply(org.eclipse.uml2.uml.Class element) {
		return StereotypeUtil.isAppliedStereotype(element, stereotype);
	}
	
	
	static public String getApplyTable_name(org.eclipse.uml2.uml.Class element) {
		String attribute="name";
		Object value=StereotypeHelper.getValue(element, stereotype, attribute);
		return (String)value;
	}
	


}
