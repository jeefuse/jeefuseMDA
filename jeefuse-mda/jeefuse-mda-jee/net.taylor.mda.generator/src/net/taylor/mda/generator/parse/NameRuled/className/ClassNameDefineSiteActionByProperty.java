package net.taylor.mda.generator.parse.NameRuled.className;

import net.taylor.mda.generator.parse.MdaHelper;
import net.taylor.mda.generator.parse.NameRuled.nameRuled.NameRuledClassKind;
import net.taylor.mda.generator.parse.NameRuled.nameRuled.NameRuledWebPathKind;
import net.taylor.mda.generator.parse.entity.PKGSuffix;
import net.taylor.mda.generator.parse.entity.WebUrlName;
import net.taylor.mda.generator.util.NameHelper;

import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Property;

/**
 * site action 类名称定义.
 * 
 */
public class ClassNameDefineSiteActionByProperty extends ClassNameDefineByPropertyCommon {

	private static NameRuledClassKind classNamed = NameRuledClassKind.site_action;
	private static PKGSuffix pkgSuffix = PKGSuffix.site_action;

	public ClassNameDefineSiteActionByProperty(Property property) {
		super(property, classNamed, pkgSuffix);
	}
	
	public String getNamespace() {
		Class ownerClass = (Class) property.getOwner();
		String urlNamespace = MdaHelper.getUrlNamespace(ownerClass.getNearestPackage());
		String modelUnCapName = classByPropertyWrap.getClassByPropetyUncapName();
		return "/site/"+urlNamespace + "/" + modelUnCapName;
	}
	
	public String getWebPath(NameRuledWebPathKind nameRuledWebPath) {
		Class ownerClass = (Class) property.getOwner();
		String ownerClassUncapName = NameHelper.getUncapName(ownerClass);
		String urlNamespace = MdaHelper.getUrlNamespace(ownerClass.getNearestPackage());
		return nameRuledWebPath.getPreffix()+ "/site/"+urlNamespace + "/" + ownerClassUncapName + "/" + classByPropertyWrap.getClassByPropetyUncapName()
				+ nameRuledWebPath.getSuffix();
	}
	
	public String getUrl(WebUrlName webUrlName) {
		String urlNamespace = getNamespace();
		String urlRequestName = MdaHelper.getModelRequestName(webUrlName);
		return urlNamespace + "/" + urlRequestName;
	}
	
	public  String getUrlForSite(WebUrlName webUrlName) {
		String urlNamespace = getNamespace();
		String urlRequestName = MdaHelper.getModelRequestName(webUrlName);
		return urlNamespace + "/" + urlRequestName;
	}
}
