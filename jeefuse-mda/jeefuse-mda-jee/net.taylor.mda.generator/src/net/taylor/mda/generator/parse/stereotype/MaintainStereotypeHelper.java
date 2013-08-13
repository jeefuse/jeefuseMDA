package net.taylor.mda.generator.parse.stereotype;

import net.taylor.mda.generator.parse.StereotypeUtil;

import org.eclipse.uml2.uml.Property;

import net.jeefuse.mda.annotations.maintain.MaintainStereotype;

public class MaintainStereotypeHelper {

	public static boolean isApplyMaintain(Property element) {
		return StereotypeUtil.isAppliedStereotype(element, MaintainStereotype.Maintain);
	}

	public static boolean isApplyMaintainEdit(Property element) {
		return StereotypeUtil.isAppliedStereotype(element, MaintainStereotype.MEdit);
	}

	public static boolean isApplyMaintain(org.eclipse.uml2.uml.Type element) {
		return StereotypeUtil.isAppliedStereotype(element, MaintainStereotype.Maintain);
	}

	public static boolean isApplyMaintainEdit(org.eclipse.uml2.uml.Type element) {
		return StereotypeUtil.isAppliedStereotype(element, MaintainStereotype.MEdit);
	}
}
