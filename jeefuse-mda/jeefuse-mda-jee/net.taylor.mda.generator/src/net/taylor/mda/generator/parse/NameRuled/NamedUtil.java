package net.taylor.mda.generator.parse.NameRuled;

import net.taylor.mda.generator.parse.MdaHelper;
import net.taylor.mda.generator.parse.NameRuled.nameRuled.MethodNamedRuleKind;
import net.taylor.mda.generator.parse.NameRuled.nameRuled.NameRuledClassKind;
import net.taylor.mda.generator.parse.NameRuled.nameRuled.PropertyNamedRuleKind;
import net.taylor.mda.generator.parse.entity.PKGSuffix;
import net.taylor.mda.generator.util.NameHelper;

import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Type;

/**
 * 命名工具类.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public class NamedUtil {

	/**
	 * 构造包名.
	 * 
	 * @param basePackage
	 * @param layerPackageSuffix
	 * @return
	 */
	public static final String getPackageQualifiedName(String basePackage, PKGSuffix pkgSuffix) {
		basePackage = MdaHelper.getPackageName(basePackage);
		if (null != pkgSuffix) {
			return basePackage + "." + pkgSuffix.getValue();
		}
		return basePackage;
	}

	/**
	 * 构造包名.
	 * 
	 * @param clazz
	 * @param layerPackageSuffix
	 * @param modelNameSuffix
	 * @return
	 */
	public static final String getPackageQualifiedName(Type clazz, PKGSuffix pkgSuffix) {
		String basePackage = NameHelper.getQualifiedName(clazz.getNearestPackage());
		return getPackageQualifiedName(basePackage, pkgSuffix);
	}

	/**
	 * 构造类名.
	 * 
	 * @param clazz
	 * @param modelSuffix
	 * @return
	 */
	public static final String getClassName(Type clazz, NameRuledClassKind classNamed) {
		return classNamed.getRuleNamed(clazz);
	}

	/**
	 * 构造全限定类名.既:包名+类名.
	 * 
	 * @param clazz
	 * @param layerPackageSuffix
	 * @param modelNameSuffix
	 * @return
	 */
	public static final String getClassQualifiedName(Type clazz, PKGSuffix pkgSuffix, NameRuledClassKind classNamed) {
		return getPackageQualifiedName(clazz, pkgSuffix) + "." + getClassName(clazz, classNamed);
	}

	/**
	 * 获取属性命名.
	 * 
	 * @return
	 */
	public static final String getPropertyNamed(NamedElement nameElement, PropertyNamedRuleKind nameRuled) {
		return nameRuled.getRuleCapNamed(nameElement);
	}

	/**
	 * 获取属性命名.首字不写
	 * 
	 * @return
	 */
	public static final String getPropertyNamedUncap(NamedElement nameElement, PropertyNamedRuleKind nameRuled) {
		return NameHelper.uncapName(getPropertyNamed(nameElement, nameRuled));
	}

	/**
	 * 返回方法命名
	 * 
	 * @param nameElement uml元素
	 * @param methodNamedRule 方法命名规则
	 * @return
	 */
	public static final String getMethodNamedCapital(NamedElement nameElement, MethodNamedRuleKind methodNamedRule) {
		return methodNamedRule.getRuleNamed(nameElement);
	}
	
	/**
	 * 返回方法命名,首字母小写
	 * 
	 * @param nameElement uml元素
	 * @param methodNamedRule 方法命名规则
	 * @return
	 */
	public static final String getMethodNamedUncap(NamedElement nameElement, MethodNamedRuleKind methodNamedRule) {
		return NameHelper.uncapName(getMethodNamedCapital(nameElement, methodNamedRule));
	}
}
