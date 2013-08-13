package net.taylor.mda.generator.parse;

import java.util.List;

import net.taylor.mda.generator.parse.entity.Config;
import net.taylor.mda.generator.parse.entity.EntityHelper;
import net.taylor.mda.generator.parse.entity.ModelNameSuffix;
import net.taylor.mda.generator.parse.entity.PKGSuffix;
import net.taylor.mda.generator.parse.entity.WebUrlName;
import net.taylor.mda.generator.preferences.Preferences;
import net.taylor.mda.generator.util.ImportHelper;
import net.taylor.mda.generator.util.NameHelper;
import net.taylor.mda.generator.util.StereotypeHelper;
import net.taylor.mda.generator.util.TypeHelper;

import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StructuralFeature;
import org.eclipse.uml2.uml.Type;

import net.jeefuse.mda.annotations.MdaStereotype;

public class MdaHelper {

	/**
	 * 获取包名,过滤"/"为".",如果以"."号为结尾将被去除.
	 */
	public static String getPackageName(String packageName) {
		if (null == packageName)
			return "";
		packageName = packageName.replaceAll("/", "\\.");
		packageName = packageName.replaceAll("::", "\\.");
		if (packageName.endsWith(".")) {
			packageName = packageName.substring(0, packageName.length() - 1);
		}
		if (packageName.startsWith(".")) {
			packageName = packageName.substring(1, packageName.length());
		}
		NameHelper.toLowerCamel(packageName);
		return packageName;
	}
	

	/**
	 * 获取包名,过滤"/"为".",如果以"."号为结尾将被去除.
	 */
	public static String getPackageName(org.eclipse.uml2.uml.Package element) {
		String packageName = NameHelper.getQualifiedName(element);
		return getPackageName(packageName);
	}

	/**返回用户设置的命名空间前缀,返回形式如:com.jeefuse.过滤"/"为".",如果存在如com/goolov形式,将被过滤为com.goolov.
	 * @return
	 */
	public static String getNamespacePrefix() {
		String namespacePrefix = Preferences.getTemplateFilterBasePackage();
		namespacePrefix = namespacePrefix.replaceAll("/", ".");
		return namespacePrefix;
	}

	/**返回用户设置的命名空间前缀,返回形式如:com.jeefuse.过滤"/"为".",如果存在如com/goolov形式,将被过滤为com.goolov.
	 * @return
	 */
	public static String getNamespacePrefixDir() {
		String namespacePrefix = getNamespacePrefix();
		String namespacePrefixDir = namespacePrefix.replaceAll(".", "/");
		return namespacePrefixDir;
	}

	/**
	 * 获取过滤掉系统命名空间的包名.
	 */
	public static String getPackageNameFilterNamespacePrefix(org.eclipse.uml2.uml.Package element) {
		String packgeName = getPackageName(element);
		String namespacePrefix = getNamespacePrefix();
		if (packgeName.startsWith(namespacePrefix)) {
			packgeName = packgeName.replaceFirst(namespacePrefix, "");
		}
		return packgeName;
	}

	/**
	 * 获取过滤掉系统命名空间的目录.过滤"."为"/".如果前后首字母为"/",将被去除.
	 * @return
	 */
	public static String getPackageDirFilterNamespacePrefix(org.eclipse.uml2.uml.Package uml2Package) {
		String packageName = getPackageNameFilterNamespacePrefix(uml2Package);
		packageName = packageName.replaceAll("\\.", "/");
		if (packageName.startsWith("/")) {
			packageName = packageName.substring(1);
		}
		if (packageName.endsWith("/")) {
			packageName = packageName.substring(0, packageName.length() - 1);
		}
		return packageName;
	}
	
	
	/**
	 * 获取包目录.过滤"."为"/".如果前后首字母为"/",将被去除.
	 * @return
	 */
	public static String getPackageDir(org.eclipse.uml2.uml.Package uml2Package) {
		String packageName = getPackageName(uml2Package);
		packageName = packageName.replaceAll("\\.", "/");
		if (packageName.startsWith("/")) {
			packageName = packageName.substring(1);
		}
		if (packageName.endsWith("/")) {
			packageName = packageName.substring(0, packageName.length() - 1);
		}
		return packageName;
	}

	/**
	 * 获取过滤掉系统命名空间的目录.过滤"_"为"_".如果前后首字母为"_",将被去除.
	 * @return
	 */
//	public static String getPackageUnderlineFilterNamespacePrefix(NamedElement element) {
//		String packageName = getPackageNameFilterNamespacePrefix(element.getNearestPackage());
//		packageName = packageName.replaceAll("\\.", "_");
//		if (packageName.startsWith("_")) {
//			packageName = packageName.substring(1);
//		}
//		if (packageName.endsWith("_")) {
//			packageName = packageName.substring(0, packageName.length() - 1);
//		}
//		return packageName;
//	}
	
	/**
	 * 获取过滤掉系统命名空间.过滤"."为"/".如果前后首字母为"/",将被去除.
	 * @return
	 */
	public static String getPackageWithUnderlineFilterNamespacePrefix(NamedElement element) {
		String packageName = getPackageDirFilterNamespacePrefix(element.getNearestPackage());
		return packageName.replace("/", "_");
	}
	
	/**按系统包组件结构,生成完整系统包,形式:packageName.layerPackageSuffix.
	 * @param basePackage
	 * @param layerPackageSuffix
	 * @return
	 */
	public static final String getPackageQualifiedName(String basePackage,PKGSuffix pkgSuffix) {
		basePackage = getPackageName(basePackage);
		List<String> pkgSuffixList = PKGSuffix.toValuesList();//Config.pkgSuffixList;
		for (String suffix : pkgSuffixList) {
			if(StringUtils.isBlank(suffix))
				continue;
			if (basePackage.endsWith(suffix)) {
				basePackage = basePackage.substring(0, basePackage.indexOf(suffix) - 1);
				break;
			}
		}
		return basePackage + "." + pkgSuffix.getValue();
	}

	/**
	 * 按系统包组件结构,生成完整系统包
	 */
	public static final String getPackageQualifiedName(org.eclipse.uml2.uml.Package element ,PKGSuffix pkgSuffix) {
		String basePackage = NameHelper.getQualifiedName(element);
		return getPackageQualifiedName(basePackage, pkgSuffix);
	}

	/**
	 * 按系统包组件结构,生成完整系统包
	 */
	public static final String getPackageQualifiedName(Type clazz,PKGSuffix pkgSuffix) {
		String basePackage = NameHelper.getQualifiedName(clazz.getPackage());
		return getPackageQualifiedName(basePackage, pkgSuffix);
	}

	/**
	 * 按系统包组件结构,生成完整系统包
	 */
	public static final String getEntityPackageQualifiedName(org.eclipse.uml2.uml.Class clazz) {
		String basePackage = NameHelper.getQualifiedName(clazz.getPackage());
		return getPackageQualifiedName(basePackage,PKGSuffix.model);
	}

	
	/**
	 * 按系统包组件结构,生成完整系统包
	 */
	public static final String getPackageQualifiedNameByRel(Type relClazz,PKGSuffix pkgSuffix) {
		String basePackage = NameHelper.getQualifiedName(relClazz.getPackage());
		return getPackageQualifiedName(basePackage, pkgSuffix);
	}
	
	
	/**
	 *获取最后一个点号后面的名称。
	 */
	public static String getBriefClassName(String name){
		if(name.lastIndexOf(".")!=-1){
			return name.substring(name.lastIndexOf(".")+1);
		}
		return name;
	}

	/**获取模形全限定名. 形式如:模块包名+包后缀.元素名+类后缀.
	 * @param clazz
	 * @param layerPackageSuffix
	 * @param modelNameSuffix
	 * @return
	 */
	public static final String getModelQualifiedName(Type clazz,PKGSuffix pkgSuffix,ModelNameSuffix modelSuffix) {
		String basePackage = NameHelper.getQualifiedName(clazz.getPackage());
		return getPackageQualifiedName(basePackage, pkgSuffix) + "." + getModelClassName(clazz,modelSuffix);
	}
	
	/**获取模形根据关联的全限定类名. 形式如:模块包名+包后缀.元素名+类后缀.
	 * @param clazz
	 * @param layerPackageSuffix
	 * @param modelNameSuffix
	 * @return
	 */
	public static final String getModelQualifiedNameByRel(org.eclipse.uml2.uml.Class ownerClass,org.eclipse.uml2.uml.Class relClass,PKGSuffix pkgSuffix,ModelNameSuffix modelSuffix) {
		String basePackage = getPackageQualifiedNameByRel(relClass,pkgSuffix);
		return basePackage + "." + getModelClassNameByRel(ownerClass,relClass,modelSuffix);
	}

	
	
	/**获取模形类名. 形式如:元素名+类后缀.
	 * @param clazz
	 * @param modelSuffix
	 * @return
	 */
	public static final String getModelClassName(Type clazz,ModelNameSuffix modelSuffix){
		return  NameHelper.getCapName(clazz)+ modelSuffix.getValue();
	}

	/**获取模形根据关联的类名. 形式如:元素名+'by'+关联类名+类后缀.
	 * @param clazz
	 * @param modelSuffix
	 * @return
	 */
	public static final String getModelClassNameByRel(org.eclipse.uml2.uml.Class ownerClass,org.eclipse.uml2.uml.Class relClass,ModelNameSuffix modelSuffix){
		return  NameHelper.getCapName(getModelNameByRel(ownerClass,relClass))+ modelSuffix.getValue();
	}

	public static final String getModelNameByRel(org.eclipse.uml2.uml.Class ownerClass,Type relClass){
		String ownerModelCapName = NameHelper.getCapName(ownerClass);
		String relModelCapName = NameHelper.getCapName(relClass);
		return  ownerModelCapName+"By"+relModelCapName;
	}

	
	
	/**获取包类名.形式如:包名(最后一个点开始)+类后缀.
	 * @return
	 */
	public static final String getPackageClassName(org.eclipse.uml2.uml.Package uml2Package,ModelNameSuffix modelSuffix){
		String packageName=uml2Package.getName();
		if(packageName.lastIndexOf(".")!=-1){
			packageName=packageName.substring(packageName.lastIndexOf(".")+1);
		}
		return NameHelper.getCapName(packageName+modelSuffix.getValue());
	}

	
	/**获取实体全限定名. 形式如:模块包名.元素名+模块后缀.
	 * @param clazz
	 * @param layerPackageSuffix
	 * @param modelNameSuffix
	 * @return
	 */
	public static final String getEntityQualifiedName(org.eclipse.uml2.uml.Class clazz) {
		return getModelQualifiedName(clazz, PKGSuffix.model, ModelNameSuffix.Entity);
	}


//	/**获取生成的web页面路径.
//	 * @param clazz
//	 * @param pageSuffix
//	 * @return
//	 */
//	public static final String getWebResourcePath(org.eclipse.uml2.uml.Class clazz, WebResourcePrefix webResourcePrefix, WebPageSuffix webPageSuffix) {
//		String packageDirFilterNamespacePrefix = MdaHelper.getPackageDirFilterNamespacePrefix(clazz.getPackage());
//		String modelUncapName = NameHelper.getUncapName(clazz);
//		return webResourcePrefix.getValue() + "/" + packageDirFilterNamespacePrefix + "/" + modelUncapName + "/" + modelUncapName+ webPageSuffix.getValue();
//	}

//	/**获取生成的web页面路径.
//	 * @param clazz
//	 * @param pageSuffix
//	 * @return
//	 */
//	public static final String getWebResourcePathByRel(org.eclipse.uml2.uml.Class ownerClazz,org.eclipse.uml2.uml.Class relClazz, WebResourcePrefix webResourcePrefix, WebPageSuffix webPageSuffix) {
//		String packageDirFilterNamespacePrefix = MdaHelper.getPackageDirFilterNamespacePrefix(relClazz.getPackage());
//		String relClazzUncapName = NameHelper.getUncapName(relClazz);
//		String modelNameByRel=getModelNameByRel(ownerClazz,relClazz);
//		return webResourcePrefix.getValue() + "/" + packageDirFilterNamespacePrefix + "/" + relClazzUncapName+"/" + modelNameByRel+ webPageSuffix.getValue();
//	}
	
//	/**获取生成的web js路径.
//	 * @param clazz
//	 * @param pageSuffix
//	 * @return
//	 */
//	public static final String getWebJsPath(org.eclipse.uml2.uml.Class clazz,WebPageSuffix webPageSuffix) {
//		return getWebResourcePath(clazz, WebResourcePrefix.js, webPageSuffix);
//	}

//	public static final String getWebJsPathForSite(org.eclipse.uml2.uml.Class clazz,WebPageSuffix webPageSuffix) {
//		String packageDirFilterNamespacePrefix = MdaHelper.getPackageDirFilterNamespacePrefix(clazz.getPackage());
//		String modelUncapName = NameHelper.getUncapName(clazz);
//		return WebResourcePrefix.js_site.getValue() + "/site/" + packageDirFilterNamespacePrefix + "/" + modelUncapName + "/" + modelUncapName+ webPageSuffix.getValue();
//	}
	
//	public static final String getWebInputJsPath(org.eclipse.uml2.uml.Class clazz) {
//		return getWebJsPath(clazz,WebPageSuffix.js_input);
//	}
//
//	public static final String getWebManagerJsPath(org.eclipse.uml2.uml.Class clazz) {
//		return getWebJsPath(clazz, WebPageSuffix.js_manager);
//	}

//	/**获取生成的web jsp路径.
//	 * @param clazz
//	 * @param pageSuffix
//	 * @return
//	 */
//	public static final String getWebJspPath(org.eclipse.uml2.uml.Class clazz,WebPageSuffix webPageSuffix) {
//		return getWebResourcePath(clazz, WebResourcePrefix.jsp, webPageSuffix);
//	}

//	public static final String getWebJspPathForSite(org.eclipse.uml2.uml.Class clazz,WebPageSuffix webPageSuffix) {
//		String packageDirFilterNamespacePrefix = MdaHelper.getPackageDirFilterNamespacePrefix(clazz.getPackage());
//		String modelUncapName = NameHelper.getUncapName(clazz);
//		return WebResourcePrefix.jsp_site.getValue() + "/site/" + packageDirFilterNamespacePrefix + "/" + modelUncapName + "/" + modelUncapName+ webPageSuffix.getValue();
//	}
	
//	public static final String getWebInputJspPath(org.eclipse.uml2.uml.Class clazz) {
//		return getWebJspPath(clazz, WebPageSuffix.jsp_input);
//	}
//
//	public static final String getWebManagerJspPath(org.eclipse.uml2.uml.Class clazz) {
//		return getWebJspPath(clazz, WebPageSuffix.jsp_manager);
//	}
	
	/**
	 * 根据包获取url命名空间.
	 * @return
	 */
	public static final String getUrlNamespace(org.eclipse.uml2.uml.Package uml2Package){
		String packageDirFilterNamespacePrefix = MdaHelper.getPackageDirFilterNamespacePrefix(uml2Package);
		return packageDirFilterNamespacePrefix;
	}
	
	public static final String getModelUrlNamespace(org.eclipse.uml2.uml.Class clazz){
		String urlNamespace = getUrlNamespace(clazz.getNearestPackage());
		String modelUnCapName = NameHelper.getUncapName(clazz);
		return "/" + urlNamespace + "/" + modelUnCapName;
	}
	
	
	public static final String getModelUrlNamespaceByRel(org.eclipse.uml2.uml.Class ownerClass,org.eclipse.uml2.uml.Class relClass){
		String urlNamespace = getUrlNamespace(relClass.getNearestPackage());
		String modelUnCapName = NameHelper.uncapName(getModelNameByRel(ownerClass,relClass));
		return "/" + urlNamespace + "/" + modelUnCapName ;
	}
	
	public static final String getModelUrlNamespaceWithUnderline(org.eclipse.uml2.uml.Class clazz){
		String  urlNamespace= getModelUrlNamespace(clazz);
		String urlWithUnderline=urlNamespace.replace("/", "_");
		if(urlWithUnderline.startsWith("_"))
			urlWithUnderline=urlWithUnderline.substring(1);
		return urlWithUnderline;	
	}
	
	public static final String getPackageUrlNamespaceWithUnderline(org.eclipse.uml2.uml.Package uml2Package){
		String urlNamespace = getUrlNamespace(uml2Package);
		String urlWithUnderline=urlNamespace.replace("/", "_");
		if(urlWithUnderline.startsWith("_"))
			urlWithUnderline=urlWithUnderline.substring(1);
		return urlWithUnderline;	
	}
	
	public static final String getPackageUrlNamespaceWithDot(org.eclipse.uml2.uml.Class clazz){
		String  urlNamespace= getModelUrlNamespace(clazz);
		String urlWithUnderline=urlNamespace.replace("/", ".");
		if(urlWithUnderline.startsWith("."))
			urlWithUnderline=urlWithUnderline.substring(1);
		return urlWithUnderline;	
	}
	
	/**获取请求名称.不包括命名空间.
	 * @param webUrlName
	 * @return
	 */
	public static final String getModelRequestName(WebUrlName webUrlName){
		String urlName=webUrlName.getValue();
		if (urlName.startsWith("/")) {
			urlName = urlName.substring(1);
		}
		return webUrlName.getValue()+Config.web_action_suffix;
	}
	
	public static final String getModelUrl(org.eclipse.uml2.uml.Class clazz, WebUrlName webUrlName) {
		String  urlNamespace= getModelUrlNamespace(clazz);
		String urlRequestName=getModelRequestName(webUrlName);
		return urlNamespace + "/" + urlRequestName;
	}
	
	public static final String getModelUrlForSite(org.eclipse.uml2.uml.Class clazz, WebUrlName webUrlName) {
		String  urlNamespace= getModelUrlNamespace(clazz);
		String urlRequestName=getModelRequestName(webUrlName);
		return "/site"+urlNamespace + "/" + urlRequestName;
	}
	
	public static final String getModelUrlByRel(org.eclipse.uml2.uml.Class ownerClass,org.eclipse.uml2.uml.Class relClass, WebUrlName webUrlName) {
		String  urlNamespace= getModelUrlNamespaceByRel( ownerClass, relClass);
		String urlRequestName=getModelRequestName(webUrlName);
		return urlNamespace + "/" + urlRequestName;
	}

	public static final String getModelUrlWithUnderline(org.eclipse.uml2.uml.Class clazz, WebUrlName webUrlName) {
		String  urlNamespace= getModelUrlNamespace(clazz);
		String urlName=webUrlName.getValue();
		if (urlName.startsWith("/")) {
			urlName = urlName.substring(1);
		}
		String urlWithUnderline=(urlNamespace+"/"+urlName).replace("/", "_");
		if(urlWithUnderline.startsWith("_"))
			urlWithUnderline=urlWithUnderline.substring(1);
		return urlWithUnderline;
	}
	
//	public static final String getUrl_listOutJson(org.eclipse.uml2.uml.Class clazz) {
//		return getModelUrl(clazz,WebUrlName.listOutJson);
//	}
//
//	public static final String getUrl_deleteAllOutJson(org.eclipse.uml2.uml.Class clazz) {
//		return getModelUrl(clazz, WebUrlName.deleteAllOutJson);
//	}
//
//	public static final String getUrl_deleteOutJson(org.eclipse.uml2.uml.Class clazz) {
//		return getModelUrl(clazz, WebUrlName.deleteOutJson);
//	}
//
//	public static final String getUrl_systempage_edit(org.eclipse.uml2.uml.Class clazz) {
//		return getModelUrl(clazz, WebUrlName.systempage_edit);
//	}
//
//	public static final String getUrl_systempage_input(org.eclipse.uml2.uml.Class clazz) {
//		return getModelUrl(clazz, WebUrlName.systempage_input);
//	}
//
//	public static final String getUrl_saveOutJsont(org.eclipse.uml2.uml.Class clazz) {
//		return getModelUrl(clazz, WebUrlName.saveOutJson);
//	}

	/**
	 * Returns the primitive or class name for the given Type. Class names will
	 * be added as imports to the GenModel's ImportManager, and the imported
	 * form will be returned.
	 */
	public static String getImportedType(Type type) {
		if (type.getName().equals("Byte[]"))
			return "byte[]";
		if (type.getName().equals("Currency")) {
			return ImportHelper.getImportedName("java.math.BigDecimal");
		}
		if (type.getName().equals("Percentage"))
			return "Double";
		if (type.getName().equals("Integer"))
			return "Integer";
		if (type.getName().equals("Long"))
			return "Long";
		if (type.getName().equals("Decimal"))
			return "Double";
		if (type.getName().equals("Image"))
			return "String";
		if (type.getName().equals("Text"))
			return "String";
		if (type.getName().equals("Link"))
			return "String";
		//ImportHelper.addImport(type);
		String name = "";
		//if (TypeHelper.isPrimitiveType(type) && TypeHelper.getInstanceClass(type) != null) {
		if (TypeHelper.isPrimitiveType(type) ) {
			name = ImportHelper.getImportedName(TypeHelper.getInstanceClass(type).getName());// type.getName();
		} else {
			//add for system entity package construct
			if (EntityHelper.isStereotypeApplied(type, StereotypeHelper.ENTITY,
					MdaStereotype.model_M2m,
					MdaStereotype.model_M2mWithId)
					&& (type instanceof org.eclipse.uml2.uml.Class)) {
				name = MdaHelper.getEntityQualifiedName((org.eclipse.uml2.uml.Class) type);
				name = ImportHelper.getImportedName(name);
			} else {
				name = ImportHelper.getImportedName(NameHelper.getQualifiedName(type));
			}
		}
		return name;
	}

	public static String getImportedFeatureType(StructuralFeature feature) {
		if (feature.getType() == null)
			return null;
		String generatedFeatureType = getImportedType(feature.getType());
		if (feature.isMultivalued()) {
			if (feature instanceof Property
					&& (((Property) feature).getOpposite() == null || ((Property) feature).getOpposite()
							.isMultivalued())) {
				generatedFeatureType = ImportHelper.getImportedName("java.util.Set");
			} else {
				generatedFeatureType = ImportHelper.getImportedName("java.util.List");
			}
			String typeName = getImportedType(feature.getType());
			generatedFeatureType = generatedFeatureType + "<" + typeName + ">";
		}
		return generatedFeatureType;
	}

}
