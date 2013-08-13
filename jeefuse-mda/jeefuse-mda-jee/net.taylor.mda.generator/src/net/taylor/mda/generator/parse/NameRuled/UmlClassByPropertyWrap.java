package net.taylor.mda.generator.parse.NameRuled;

import net.taylor.mda.generator.parse.MdaHelper;
import net.taylor.mda.generator.parse.ModelHelper;
import net.taylor.mda.generator.parse.NameRuled.className.ClassNameDefineByPropertyCommon;
import net.taylor.mda.generator.parse.NameRuled.className.ClassNameDefineMaintainActionByProperty;
import net.taylor.mda.generator.parse.NameRuled.className.ClassNameDefineSiteActionByProperty;
import net.taylor.mda.generator.parse.NameRuled.nameRuled.NameRuledClassKind;
import net.taylor.mda.generator.parse.NameRuled.nameRuled.NameRuledWebPathKind;
import net.taylor.mda.generator.parse.entity.EntityHelper;
import net.taylor.mda.generator.parse.entity.PKGSuffix;
import net.taylor.mda.generator.parse.entity.WebUrlName;
import net.taylor.mda.generator.util.ClassHelper;
import net.taylor.mda.generator.util.NameHelper;

import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Property;

/**
 * 定义关联属性名称、类名、命名空间等.
 */
public class UmlClassByPropertyWrap {
	private Property property;

	/**
	 * 定义关联属性名称、类名、命名空间等.
	 * 
	 * @param property
	 *            uml property
	 */
	public UmlClassByPropertyWrap(Property property) {
		this.property = property;
	}

	/**
	 * 返回ownerClass name+"By"+property name.
	 */
	public String getClassByPropetyName() {
		Class ownerClass = (Class) property.getOwner();
		return ownerClass.getName() + "By" + NameHelper.getCapName(property);
	}

	/**
	 * 返回ownerClass name+"By"+property name.首字母大写
	 */
	public String getClassByPropetyCapName() {
		Class ownerClass = (Class) property.getOwner();
		String ownerModelCapName = NameHelper.getCapName(ownerClass);
		return ownerModelCapName + "By" + NameHelper.getCapName(property);
	}

	/**
	 * 返回属性注释.
	 */
	public String getComment() {
		return ModelHelper.getComment(property);
	}

	/**
	 * 返回ownerClass name+"By"+property name.首字母小写
	 */
	public String getClassByPropetyUncapName() {
		return NameHelper.uncapName(getClassByPropetyName());
	}

	/**
	 * 返回URL命名空间.如"/model/property".
	 */
	public String getNamespace() {
		Class ownerClass = (Class) property.getOwner();
		String urlNamespace = MdaHelper.getUrlNamespace(ownerClass.getNearestPackage());
		String classByPropetyUncapName = getClassByPropetyUncapName();
		return "/" + urlNamespace + "/" + classByPropetyUncapName;
	}

	/**
	 * 返回命名空间以"."分隔.
	 */
	public String getNamespaceForDot() {
		String urlNamespace = getNamespace();
		String urlWithUnderline = urlNamespace.replace("/", ".");
		if (urlWithUnderline.startsWith("."))
			urlWithUnderline = urlWithUnderline.substring(1);
		return urlWithUnderline;
	}

	/**
	 * 返回命名空间以"_"分隔.
	 */
	public String getNamespaceForUnderline() {
		String urlNamespace = getNamespace();
		String urlWithUnderline = urlNamespace.replace("/", "_");
		if (urlWithUnderline.startsWith("_"))
			urlWithUnderline = urlWithUnderline.substring(1);
		return urlWithUnderline;
	}

	/**
	 * 属性所属类的包名.
	 */
	public String getPackageName() {
		Class ownerClass = (Class) property.getOwner();
		String basePackage = NameHelper.getQualifiedName(ownerClass.getNearestPackage());
		return basePackage;
	}

	/**
	 *获取web资源路径.
	 */
	public String getWebPath(NameRuledWebPathKind nameRuledWebPath) {
		Class ownerClass = (Class) property.getOwner();
		String packageNamespace = MdaHelper.getUrlNamespace(ownerClass.getNearestPackage());
		String ownerUncapName = NameHelper.getUncapName(ownerClass);
		return nameRuledWebPath.getPreffix() + "/" + packageNamespace + "/" + ownerUncapName + "/" + getClassByPropetyUncapName()
				+ nameRuledWebPath.getSuffix();
	}

	/**
	 * 获取url路径.
	 */
	public String getUrl(WebUrlName webUrlName) {
		String urlNamespace = getNamespace();
		String urlRequestName = MdaHelper.getModelRequestName(webUrlName);
		return urlNamespace + "/" + urlRequestName;
	}

	/**
	 * 获取get访问方法. 简单数据的访问,如:getName();
	 * 如果属性类型是实体类刚访问实体类的主键,如:getEntity().getId();
	 */
	public String getValueGetAccessor() {
		String propertyGetAccessor = ModelHelper.getGetAccessor(property);
		StringBuilder sb = new StringBuilder();
		sb.append(propertyGetAccessor);
		if (!ClassHelper.isSimple(property)) {
			Class ownerClazz = (Class) property.getType();
			Property ownerClassIdProperty = EntityHelper.getIDProperty(ownerClazz);
			String ownerClassIdPropertyGetter = ClassHelper.getGetAccessor(ownerClassIdProperty);
			sb.append("().");
			sb.append(ownerClassIdPropertyGetter);
		}
		sb.append("()");
		return sb.toString();
	}

	/**
	 * 获取值访问路径. 如:name; 如果属性类型是实体类刚访问实体类的主键,如:entity.id;
	 */
	public String getValueName() {
		String propertyGetAccessor = ModelHelper.getUncapName(property);
		StringBuilder sb = new StringBuilder();
		sb.append(propertyGetAccessor);
		if (!ClassHelper.isSimple(property)) {
			Class ownerClazz = (Class) property.getType();
			Property ownerClassIdProperty = EntityHelper.getIDProperty(ownerClazz);
			String ownerClassIdPropertyUnCapName = ModelHelper.getUncapName(ownerClassIdProperty);
			sb.append(".");
			sb.append(ownerClassIdPropertyUnCapName);
		}
		return sb.toString();
	}

	/**
	 * 获取取值访问路径. 如:name; 如果属性类型是实体类刚访问实体类的主键,如:entity_id;
	 */
	public String getValueNameWithUnderLine() {
		String propertyGetAccessor = ModelHelper.getUncapName(property);
		StringBuilder sb = new StringBuilder();
		sb.append(propertyGetAccessor);
		if (!ClassHelper.isSimple(property)) {
			Class ownerClazz = (Class) property.getType();
			Property ownerClassIdProperty = EntityHelper.getIDProperty(ownerClazz);
			String ownerClassIdPropertyCapName = ModelHelper.getUncapName(ownerClassIdProperty);
			sb.append("_");
			sb.append(ownerClassIdPropertyCapName);
		}
		return sb.toString();
	}

	/**
	 * 获取set访问方法. 简单数据的访问,如:setName();
	 * 如果属性类型是实体类刚访问实体类的主键,如:getEntity().setId();
	 */
	public String getSetValueMethod() {
		StringBuilder sb = new StringBuilder();
		if (!ClassHelper.isSimple(property)) {
			String propertyGetAccessor = ModelHelper.getGetAccessor(property);
			sb.append(propertyGetAccessor);
			sb.append("().");
			Class ownerClazz = (Class) property.getType();
			Property ownerClassIdProperty = EntityHelper.getIDProperty(ownerClazz);
			String ownerClassIdPropertySetAccessor = ModelHelper.getSetAccessor(ownerClassIdProperty);
			sb.append(ownerClassIdPropertySetAccessor);
		} else {
			String propertySetAccessor = ModelHelper.getSetAccessor(property);
			sb.append(propertySetAccessor);
		}
		return sb.toString();
	}

	/**
	 * 获取ActionByProperty特定类名、包名定义.
	 */
	public ClassNameDefineByPropertyCommon getNameDefineActionByProperty() {
		return new ClassNameDefineByPropertyCommon(property, NameRuledClassKind.Action, PKGSuffix.action);
	}

	/**
	 * 获取maintain action 类名称、命名空间、web资源路径等定义.
	 */
	public ClassNameDefineMaintainActionByProperty getNameDefineMaintainActionByProperty() {
		return new ClassNameDefineMaintainActionByProperty(property);
	}

	/**
	 * 获取SiteAction 类名称、命名空间、web资源路径等定义.
	 */
	public ClassNameDefineSiteActionByProperty getNameDefineSiteActionByProperty() {
		return new ClassNameDefineSiteActionByProperty(property);
	}

	/**
	 * 获取FlexiGridJsonWriter特定类名、包名定义.
	 */
	public ClassNameDefineByPropertyCommon getNameDefineFlexiGridJsonWriterByProperty() {
		return new ClassNameDefineByPropertyCommon(property, NameRuledClassKind.FlexiGridJsonWriter,
				PKGSuffix.FlexiGridJsonWriter);
	}

	/**
	 * 获取ResultMsgJsonWriter特定类名、包名定义.
	 */
	public ClassNameDefineByPropertyCommon getNameDefineResultMsgJsonWriterByProperty() {
		return new ClassNameDefineByPropertyCommon(property, NameRuledClassKind.ResultMsgJsonWriter,
				PKGSuffix.ResultMsgJsonWriter);
	}

	/**
	 * 获取TreeGridJsonWriter特定类名、包名定义.
	 */
	public ClassNameDefineByPropertyCommon getNameDefineTreeGridJsonWriterByProperty() {
		return new ClassNameDefineByPropertyCommon(property, NameRuledClassKind.TreeGridJsonWriter,
				PKGSuffix.TreeGridJsonWriter);
	}

	/**
	 * 获取RenderUtil特定类名、包名定义.
	 */
	public ClassNameDefineByPropertyCommon getNameDefineRenderUtilByProperty() {
		return new ClassNameDefineByPropertyCommon(property, NameRuledClassKind.RenderUtil, PKGSuffix.RenderUtil);
	}

}
