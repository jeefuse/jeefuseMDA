package net.taylor.mda.generator.parse.NameRuled.className;

import net.taylor.mda.generator.parse.NameRuled.NamedUtil;
import net.taylor.mda.generator.parse.NameRuled.UmlClassWrap;
import net.taylor.mda.generator.parse.NameRuled.nameRuled.NameRuledClassKind;
import net.taylor.mda.generator.parse.entity.PKGSuffix;
import net.taylor.mda.generator.util.NameHelper;

import org.eclipse.uml2.uml.Class;

/**
 * 类名称、包名、类名的定义默认实现.
 */
public class ClassNameDefineCommon implements ClassNameDefine {

	protected org.eclipse.uml2.uml.Class clazz;
	protected UmlClassWrap namedUmlClass;
	protected NameRuledClassKind clazzNameRule;
	protected PKGSuffix pkgSuffix;

	/**
	 * 类名称、包名、类名的定义默认实现.
	 */
	public ClassNameDefineCommon(Class clazz, NameRuledClassKind clazzNameRule, PKGSuffix pkgSuffix) {
		this.clazz = clazz;
		this.clazzNameRule = clazzNameRule;
		this.pkgSuffix = pkgSuffix;
		this.namedUmlClass = new UmlClassWrap(clazz);
	}

	/*
	 * 类名 
	 * 
	 * @seenet.taylor.mda.generator.parse.NameRuled.className.ClassNameDefine#
	 * getClassName()
	 */
	@Override
	public String getClassName() {
		return clazzNameRule.getPreffix() + namedUmlClass.getName() + clazzNameRule.getSuffix();
	}

	/* (non-Javadoc)
	 * @see net.taylor.mda.generator.parse.NameRuled.className.ClassNameDefine#getClassCapName()
	 */
	@Override
	public String getClassCapName() {
		return NameHelper.capName(getClassName());
	}

	/* (non-Javadoc)
	 * @see net.taylor.mda.generator.parse.NameRuled.className.ClassNameDefine#getClassUncapName()
	 */
	@Override
	public String getClassUncapName() {
		return NameHelper.uncapName(getClassName());
	}

	/* (non-Javadoc)
	 * @see net.taylor.mda.generator.parse.NameRuled.className.ClassNameDefine#getClassQualifiedName()
	 */
	@Override
	public String getClassQualifiedName() {
		return getPackageQualifiedName() + "." + getClassName();
	}

	/* (non-Javadoc)
	 * @see net.taylor.mda.generator.parse.NameRuled.className.ClassNameDefine#getPackageQualifiedName()
	 */
	@Override
	public String getPackageQualifiedName() {
		String pkgSuffixPackage = NamedUtil.getPackageQualifiedName(clazz, pkgSuffix);
		return pkgSuffixPackage;
	}

}
