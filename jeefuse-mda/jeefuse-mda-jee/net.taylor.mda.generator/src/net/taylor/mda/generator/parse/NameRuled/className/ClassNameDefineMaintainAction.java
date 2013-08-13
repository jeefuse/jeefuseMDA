package net.taylor.mda.generator.parse.NameRuled.className;

import net.taylor.mda.generator.parse.MdaHelper;
import net.taylor.mda.generator.parse.NameRuled.nameRuled.NameRuledClassKind;
import net.taylor.mda.generator.parse.NameRuled.nameRuled.NameRuledWebPathKind;
import net.taylor.mda.generator.parse.entity.PKGSuffix;
import net.taylor.mda.generator.parse.entity.WebUrlName;

import org.eclipse.uml2.uml.Class;

/**
 * maintain action 类名称、命名空间、web资源路径等定义.
 * 
 */
public class ClassNameDefineMaintainAction extends ClassNameDefineCommon {

	private static NameRuledClassKind classNamed = NameRuledClassKind.maintain_action;
	private static PKGSuffix pkgSuffix = PKGSuffix.maintain_action;

	public ClassNameDefineMaintainAction(Class clazz) {
		super(clazz, classNamed, pkgSuffix);
	}

	/**
	 * 获取URL命名空间.
	 */
	public String getNamespace() {
		String urlNamespace = MdaHelper.getUrlNamespace(clazz.getNearestPackage());
		String modelUnCapName = namedUmlClass.getUncapName();
		return "/maintain/" + urlNamespace + "/" + modelUnCapName;
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
	 * 获取web资源路径.
	 */
	public String getWebPath(NameRuledWebPathKind nameRuledWebPath) {
		String urlNamespace = getNamespace();
		return nameRuledWebPath.getPreffix() + urlNamespace + "/" + namedUmlClass.getUncapName()
				+ nameRuledWebPath.getSuffix();
	}

}
