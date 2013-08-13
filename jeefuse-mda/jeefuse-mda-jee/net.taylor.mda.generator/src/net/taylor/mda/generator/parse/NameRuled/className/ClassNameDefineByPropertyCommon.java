package net.taylor.mda.generator.parse.NameRuled.className;

import net.taylor.mda.generator.parse.MdaHelper;
import net.taylor.mda.generator.parse.NameRuled.UmlClassByPropertyWrap;
import net.taylor.mda.generator.parse.NameRuled.nameRuled.NameRuledClassKind;
import net.taylor.mda.generator.parse.entity.PKGSuffix;
import net.taylor.mda.generator.util.NameHelper;

import org.eclipse.uml2.uml.Property;


/**
 * 类名称定义默认实现.
 *
 */
public class ClassNameDefineByPropertyCommon implements ClassNameDefine{
	
	protected Property property;
	protected NameRuledClassKind clazzNameRule;
	protected PKGSuffix pkgSuffix;
	protected UmlClassByPropertyWrap classByPropertyWrap;
	
	public ClassNameDefineByPropertyCommon(Property property, NameRuledClassKind clazzNameRule, PKGSuffix pkgSuffix) {
		this.property = property;
		this.clazzNameRule = clazzNameRule;
		this.pkgSuffix = pkgSuffix;
		classByPropertyWrap=new UmlClassByPropertyWrap(property);
	}

	public NameRuledClassKind getClazzNameRule() {
		return clazzNameRule;
	}

	public PKGSuffix getPkgSuffix() {
		return pkgSuffix;
	}

	@Override
	public String getClassName() {
		return clazzNameRule.getPreffix()+classByPropertyWrap.getClassByPropetyCapName() + clazzNameRule.getSuffix();
	}
	
	@Override
	public String getClassUncapName(){
		return NameHelper.uncapName(getClassName());
	}


	@Override
	public String getClassQualifiedName() {
		return getPackageQualifiedName() + "." + getClassName();
	}

	@Override
	public String getPackageQualifiedName() {
		String basePackage = classByPropertyWrap.getPackageName();
		String pkgSuffixPackage = MdaHelper.getPackageQualifiedName(basePackage, pkgSuffix);
		return pkgSuffixPackage;
	}

	@Override
	public String getClassCapName() {
		return NameHelper.capName(getClassName());
	}

	
}
