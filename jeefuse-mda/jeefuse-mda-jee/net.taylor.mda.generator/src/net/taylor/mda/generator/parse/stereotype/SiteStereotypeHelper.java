package net.taylor.mda.generator.parse.stereotype;

import net.taylor.mda.generator.parse.StereotypeUtil;

import org.eclipse.uml2.uml.Property;

import net.jeefuse.mda.annotations.site.SiteStereotype;

public class SiteStereotypeHelper {

	public static boolean isApplySiteViewList(Property element) {
		return StereotypeUtil.isAppliedStereotype(element, SiteStereotype.viewList);
	}

	public static boolean isApplySiteViewDetail(Property element) {
		return StereotypeUtil.isAppliedStereotype(element, SiteStereotype.viewDetail);
	}

	public static boolean isApplySiteViewList(org.eclipse.uml2.uml.Type element) {
		return StereotypeUtil.isAppliedStereotype(element, SiteStereotype.viewList);
	}

	public static boolean isApplySiteViewDetail(org.eclipse.uml2.uml.Type element) {
		return StereotypeUtil.isAppliedStereotype(element, SiteStereotype.viewDetail);
	}
}
