package net.taylor.mda.generator.parse.NameRuled;

import net.taylor.mda.generator.parse.MdaHelper;
import net.taylor.mda.generator.parse.NameRuled.className.ClassNameDefineCommon;
import net.taylor.mda.generator.parse.NameRuled.className.ClassNameDefineMaintainAction;
import net.taylor.mda.generator.parse.NameRuled.className.ClassNameDefineSiteAction;
import net.taylor.mda.generator.parse.NameRuled.nameRuled.MethodNamedRuleKind;
import net.taylor.mda.generator.parse.NameRuled.nameRuled.NameRuledClassKind;
import net.taylor.mda.generator.parse.NameRuled.nameRuled.NameRuledIbatisSqlMapKind;
import net.taylor.mda.generator.parse.NameRuled.nameRuled.NameRuledWebPathKind;
import net.taylor.mda.generator.parse.NameRuled.nameRuled.PropertyNamedRuleKind;
import net.taylor.mda.generator.parse.entity.PKGSuffix;
import net.taylor.mda.generator.parse.entity.WebUrlName;
import net.taylor.mda.generator.util.NameHelper;
import net.taylor.mda.generator.util.TypeHelper;

import org.eclipse.uml2.uml.Class;

/**
 * uml class类命名定义.
 * 
 * @author yonclv
 * 
 */
public class UmlClassWrap {

	private org.eclipse.uml2.uml.Class clazz;

	public UmlClassWrap(Class clazz) {
		this.clazz = clazz;
	}

	/**
	 *类名.
	 */
	public String getName() {
		return clazz.getName();
	}

	/**
	 * 首字母大写的类名.
	 */
	public String getCapName() {
		return NameHelper.getCapName(clazz);
	}

	/**
	 * 首字母小写的类名.
	 */
	public String getUncapName() {
		return NameHelper.getUncapName(clazz);
	}

	/**
	 * class注释.
	 */
	public String getCommentName() {
		return TypeHelper.getDocumentationOrName(clazz);
	}

	/**
	 * 返回包的命名空间，分割用/.
	 */
	public String getNamespace() {
		String urlNamespace = MdaHelper.getUrlNamespace(clazz.getNearestPackage());
		String modelUnCapName = getUncapName();
		return "/" + urlNamespace + "/" + modelUnCapName;
	}

	/**
	 * 返回包的命名空间，分割用.。
	 */
	public String getNamespaceForDot() {
		String urlNamespace = getNamespace();
		String urlWithUnderline = urlNamespace.replace("/", ".");
		if (urlWithUnderline.startsWith("."))
			urlWithUnderline = urlWithUnderline.substring(1);
		return urlWithUnderline;
	}

	/**
	 * 返回包的命名空间，分割用_。
	 */
	public String getNamespaceForUnderline() {
		String urlNamespace = getNamespace();
		String urlWithUnderline = urlNamespace.replace("/", "_");
		if (urlWithUnderline.startsWith("_"))
			urlWithUnderline = urlWithUnderline.substring(1);
		return urlWithUnderline;
	}

	/**
	 * 返回全包名。
	 */
	public String getPackageName() {
		String packageName = NameHelper.getQualifiedName(clazz.getNearestPackage());
		return MdaHelper.getPackageName(packageName);
	}

	/**
	 * 获取URL定义.
	 * 
	 * @param webUrlName
	 * @return
	 */
	public String getUrl(WebUrlName webUrlName) {
		String urlNamespace = getNamespace();
		String urlRequestName = MdaHelper.getModelRequestName(webUrlName);
		return urlNamespace + "/" + urlRequestName;
	}

	/**
	 * 获取资源文件路径定义.
	 * 
	 * @param nameRuledWebPath
	 * @return
	 */
	public String getWebPath(NameRuledWebPathKind nameRuledWebPath) {
		String urlNamespace = getNamespace();
		String modelUncapName = NameHelper.getUncapName(clazz);
		return nameRuledWebPath.getPreffix() + urlNamespace + "/" + modelUncapName + nameRuledWebPath.getSuffix();
	}

	
	/**
	 * 方法命名.
	 */
	public String getNamedRuleMethod(MethodNamedRuleKind methodNamedRule) {
		return methodNamedRule.getRuleNamed(clazz);
	}

	/**
	 * 属性命名.
	 */
	public String getNamedRuleProperty(PropertyNamedRuleKind propertyNamedRule) {
		return propertyNamedRule.getRuleCapNamed(clazz);
	}

	/**
	 * ibatisSqlMap命名.
	 */
	public String getNamedRuleIbatis(NameRuledIbatisSqlMapKind ibatisSqlMap) {
		return ibatisSqlMap.getRuleNamed(clazz);
	}

	/**
	 * 获取Action特定类名、包名定义.
	 */
	public ClassNameDefineCommon getNameDefineAction() {
		return new ClassNameDefineCommon(clazz, NameRuledClassKind.Action, PKGSuffix.action);
	}

	/**
	 * 获取MaintainAction特定类名、包名定义.
	 */
	public ClassNameDefineMaintainAction getNameDefineMaintainAction() {
		return new ClassNameDefineMaintainAction(clazz);
	}

	/**
	 * 获取SiteAction特定类名、包名定义.
	 */
	public ClassNameDefineSiteAction getNameDefineSiteAction() {
		return new ClassNameDefineSiteAction(clazz);
	}

	/**
	 * 获取VO特定类名、包名定义.
	 */
	public ClassNameDefineCommon getNameDefineVo() {
		return new ClassNameDefineCommon(clazz, NameRuledClassKind.VO, PKGSuffix.vo);
	}

	/**
	 * 获取Entity特定类名、包名定义.
	 */
	public ClassNameDefineCommon getNameDefineEntity() {
		return new ClassNameDefineCommon(clazz, NameRuledClassKind.Entity, PKGSuffix.model);
	}

	/**
	 * 获取EntityField特定类名、包名定义.
	 */
	public ClassNameDefineCommon getNameDefineEntityField() {
		return new ClassNameDefineCommon(clazz, NameRuledClassKind.EntityField, PKGSuffix.EntityField);
	}

	/**
	 * 获取Validate特定类名、包名定义.
	 */
	public ClassNameDefineCommon getNameDefineValidate() {
		return new ClassNameDefineCommon(clazz, NameRuledClassKind.Validate, PKGSuffix.Validate);
	}

	/**
	 * 获取EntityPropertyValueGet特定类名、包名定义.
	 */
	public ClassNameDefineCommon getNameDefineEntityPropertyValueGet() {
		return new ClassNameDefineCommon(clazz, NameRuledClassKind.EntityPropertyValueGet, PKGSuffix.EntityPropertyValueGet);
	}

	/**
	 * 获取RTO特定类名、包名定义.
	 */
	public ClassNameDefineCommon getNameDefineRTO() {
		return new ClassNameDefineCommon(clazz, NameRuledClassKind.RTO, PKGSuffix.rto);
	}

	/**
	 * 获取Service特定类名、包名定义.
	 */
	public ClassNameDefineCommon getNameDefineService() {
		return new ClassNameDefineCommon(clazz, NameRuledClassKind.Service, PKGSuffix.service);
	}

	/**
	 * 获取serviceGeneric特定类名、包名定义.
	 */
	public ClassNameDefineCommon getNameDefineServiceGeneric() {
		return new ClassNameDefineCommon(clazz, NameRuledClassKind.serviceGeneric, PKGSuffix.serviceGeneric);
	}

	/**
	 * 获取serviceGenericImpl特定类名、包名定义.
	 */
	public ClassNameDefineCommon getNameDefineServiceGenericImpl() {
		return new ClassNameDefineCommon(clazz, NameRuledClassKind.serviceGenericImpl, PKGSuffix.serviceGenericImpl);
	}

	/**
	 * 获取RenderUtil特定类名、包名定义.
	 */
	public ClassNameDefineCommon getNameDefineRenderUtil() {
		return new ClassNameDefineCommon(clazz, NameRuledClassKind.RenderUtil, PKGSuffix.RenderUtil);
	}

	/**
	 * 获取FlexiGridJsonWriter特定类名、包名定义.
	 */
	public ClassNameDefineCommon getNameDefineFlexiGridJsonWrite() {
		return new ClassNameDefineCommon(clazz, NameRuledClassKind.FlexiGridJsonWriter, PKGSuffix.FlexiGridJsonWriter);
	}

	/**
	 * 获取ResultMsgJsonWriter特定类名、包名定义.
	 */
	public ClassNameDefineCommon getNameDefineResultMsgJsonWriter() {
		return new ClassNameDefineCommon(clazz, NameRuledClassKind.ResultMsgJsonWriter, PKGSuffix.ResultMsgJsonWriter);
	}

	/**
	 * 获取exportFactory特定类名、包名定义.
	 */
	public ClassNameDefineCommon getNameDefineExportFactory() {
		return new ClassNameDefineCommon(clazz, NameRuledClassKind.exportFactory, PKGSuffix.exportFactory);
	}

	/**
	 * 获取importFactory特定类名、包名定义.
	 */
	public ClassNameDefineCommon getNameDefineImportFactory() {
		return new ClassNameDefineCommon(clazz, NameRuledClassKind.importFactory, PKGSuffix.importFactory);
	}

	/**
	 * 获取importExcel特定类名、包名定义.
	 */
	public ClassNameDefineCommon getNameDefineImportExcel() {
		return new ClassNameDefineCommon(clazz, NameRuledClassKind.importExcel, PKGSuffix.importExcel);
	}

	/**
	 * 获取TreeGridJsonWriter特定类名、包名定义.
	 */
	public ClassNameDefineCommon getNameDefineTreeGridJsonWriter() {
		return new ClassNameDefineCommon(clazz, NameRuledClassKind.TreeGridJsonWriter, PKGSuffix.TreeGridJsonWriter);
	}

	/**
	 * 获取fileUpload特定类名、包名定义.
	 */
	public ClassNameDefineCommon getNameDefineFileUpload() {
		return new ClassNameDefineCommon(clazz, NameRuledClassKind.fileUpload, PKGSuffix.fileUpload);
	}

	/**
	 * 获取IndexDAO特定类名、包名定义.
	 */
	public ClassNameDefineCommon getNameDefineIndexDAO() {
		return new ClassNameDefineCommon(clazz, NameRuledClassKind.indexDAO, PKGSuffix.indexDAO);
	}

	/**
	 * 获取IndexDAO特定类名、包名定义.
	 */
	public ClassNameDefineCommon getNameDefineIndexDAOImpl() {
		return new ClassNameDefineCommon(clazz, NameRuledClassKind.indexDAOImpl, PKGSuffix.indexDAOImpl);
	}

	/**
	 * 获取IndexSearchService特定类名、包名定义.
	 */
	public ClassNameDefineCommon getNameDefineIndexSearchService() {
		return new ClassNameDefineCommon(clazz, NameRuledClassKind.IndexSearchService, PKGSuffix.IndexSearchService);
	}

	/**
	 * 获取IndexSearchServiceImpl特定类名、包名定义.
	 */
	public ClassNameDefineCommon getNameDefineIndexSearchServiceImpl() {
		return new ClassNameDefineCommon(clazz, NameRuledClassKind.IndexSearchServiceImpl, PKGSuffix.IndexSearchServiceImpl);
	}

	/**
	 * 获取IndexCreateService特定类名、包名定义.
	 */
	public ClassNameDefineCommon getNameDefineIndexCreateService() {
		return new ClassNameDefineCommon(clazz, NameRuledClassKind.IndexCreateService, PKGSuffix.IndexCreateService);
	}

	/**
	 * 获取IndexCreateServiceImpl特定类名、包名定义.
	 */
	public ClassNameDefineCommon getNameDefineIndexCreateServiceImpl() {
		return new ClassNameDefineCommon(clazz, NameRuledClassKind.IndexCreateServiceImpl, PKGSuffix.IndexCreateServiceImpl);
	}

	/**
	 * 获取IndexCreateServiceImplTest特定类名、包名定义.
	 */
	public ClassNameDefineCommon getNameDefineIndexCreateServiceTest() {
		return new ClassNameDefineCommon(clazz, NameRuledClassKind.IndexCreateServiceImplTest,
				PKGSuffix.IndexCreateServiceImplTest);
	}

	public ClassNameDefineCommon getNameDefineIndexSearchServiceTest() {
		return new ClassNameDefineCommon(clazz, NameRuledClassKind.IndexSearchServiceImplTest,
				PKGSuffix.IndexSearchServiceImplTest);
	}

	/**
	 * 获取Service特定类名、包名定义.
	 */
	public ClassNameDefineCommon getNameDefineIndexSolrServer() {
		return new ClassNameDefineCommon(clazz, NameRuledClassKind.IndexSolrServer, PKGSuffix.IndexSolrServer);
	}

}
