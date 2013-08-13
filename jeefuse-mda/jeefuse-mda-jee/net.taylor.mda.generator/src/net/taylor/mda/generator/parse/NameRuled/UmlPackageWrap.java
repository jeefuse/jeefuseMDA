package net.taylor.mda.generator.parse.NameRuled;

import net.taylor.mda.generator.parse.MdaHelper;
import net.taylor.mda.generator.parse.entity.ModelNameSuffix;
import net.taylor.mda.generator.parse.entity.PKGSuffix;
import net.taylor.mda.generator.util.NameHelper;
import net.taylor.mda.generator.util.TypeHelper;

/**
 * uml类包元素的名称定义.
 * 
 * @author yonclv
 * 
 */
public class UmlPackageWrap {

	private org.eclipse.uml2.uml.Package uml2Package;

	public UmlPackageWrap(org.eclipse.uml2.uml.Package uml2Package) {
		this.uml2Package = uml2Package;
	}

	public String getName() {
		return uml2Package.getName();
	}

	public String getCapName() {
		return NameHelper.getCapName(uml2Package);
	}

	public String getUncapName() {
		return NameHelper.getUncapName(uml2Package);
	}

	public String getCommentName() {
		return TypeHelper.getDocumentationOrName(uml2Package);
	}

	public String getServiceFactoryPackageName() {
		return MdaHelper.getPackageQualifiedName(uml2Package, PKGSuffix.serviceFactory);
	}

	public String getServiceFactoryClassName() {
		return MdaHelper.getPackageClassName(uml2Package, ModelNameSuffix.serviceFactory);
	}

	public String getServiceFactoryClassQualifiedName() {
		return getServiceFactoryPackageName() + "." + getServiceFactoryClassName();
	}

}
