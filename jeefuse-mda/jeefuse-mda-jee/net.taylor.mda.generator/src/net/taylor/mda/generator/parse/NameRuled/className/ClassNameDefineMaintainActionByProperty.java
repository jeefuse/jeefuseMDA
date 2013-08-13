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
 * maintain action 类名称、命名空间、web资源路径等定义
 * 
 */
public class ClassNameDefineMaintainActionByProperty extends ClassNameDefineByPropertyCommon {

	/**
	 * site action 类名称、命名空间、web资源路径等定义.
	 */
	public ClassNameDefineMaintainActionByProperty(Property property) {
		super(property, NameRuledClassKind.maintain_action, PKGSuffix.maintain_action);
	}

	/**
	 * 获取URL命名空间.
	 */
	public String getNamespace() {
		Class ownerClass = (Class) property.getOwner();
		String urlNamespace = MdaHelper.getUrlNamespace(ownerClass.getNearestPackage());
		String modelUnCapName = classByPropertyWrap.getClassByPropetyUncapName();
		return "/maintain/" + urlNamespace + "/" + modelUnCapName;
	}

	/**
	 * 获取web资源路径.
	 */
	public String getWebPath(NameRuledWebPathKind nameRuledWebPath) {
		Class ownerClass = (Class) property.getOwner();
		String ownerClassUncapName = NameHelper.getUncapName(ownerClass);
		String urlNamespace = MdaHelper.getUrlNamespace(ownerClass.getNearestPackage());
		return nameRuledWebPath.getPreffix()+ "/maintain/"+urlNamespace + "/" + ownerClassUncapName + "/" + classByPropertyWrap.getClassByPropetyUncapName()
				+ nameRuledWebPath.getSuffix();
	}

	/**
	 * 获取请求URL.
	 */
	public String getUrl(WebUrlName webUrlName) {
		String urlNamespace = getNamespace();
		String urlRequestName = MdaHelper.getModelRequestName(webUrlName);
		return urlNamespace + "/" + urlRequestName;
	}

	/**
	 * 获取请求URL.
	 */
	public String getUrlForSite(WebUrlName webUrlName) {
		String urlNamespace = getNamespace();
		String urlRequestName = MdaHelper.getModelRequestName(webUrlName);
		return urlNamespace + "/" + urlRequestName;
	}
}
