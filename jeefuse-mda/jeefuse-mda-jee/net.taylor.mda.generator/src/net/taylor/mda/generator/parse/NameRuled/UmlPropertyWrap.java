package net.taylor.mda.generator.parse.NameRuled;

import net.taylor.mda.generator.parse.ModelHelper;
import net.taylor.mda.generator.util.NameHelper;

import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

/**
 * 属性元素的名称定义.
 * 
 * @author yonclv
 * 
 */
public class UmlPropertyWrap {

	private org.eclipse.uml2.uml.Property property;

	public UmlPropertyWrap(Property property) {
		this.property = property;
	}

	public String getName() {
		return NameHelper.uncapSafeName(property);
	}

	public String getCapName() {
		return NameHelper.getCapName(getName());
	}

	public String getUncapName() {
		return NameHelper.uncapName(getName());
	}

	public String getCommentName() {
		return ModelHelper.getComment(property);
	}

	public org.eclipse.uml2.uml.Class getOwerClass() {
		return (org.eclipse.uml2.uml.Class) property.getOwner();
	}

	/**
	 * 返回get方法.
	 */
	public String getGetAccessor() {
		return ModelHelper.getGetAccessor(property);
	}

	/**
	 * 返回set方法.
	 */
	public String getSetAccessor() {
		return ModelHelper.getSetAccessor(property);
	}

	/**
	 * 定义关联属性名称、类名、命名空间等.
	 */
	public UmlClassByPropertyWrap getClassByPropertyWrap() {
		return new UmlClassByPropertyWrap(property);
	}
	
	/**
	 * 获取索引字段类型.
	 */
	public String getIndexSolrFieldType(){
		Type type=property.getType();
		if (type.getName().equalsIgnoreCase("Byte[]"))
			return "binary";
		if (type.getName().equalsIgnoreCase("Currency")) 
			return "double";
		if (type.getName().equalsIgnoreCase("Percentage"))
			return "double";
		if (type.getName().equalsIgnoreCase("Double"))
			return "double";
		if (type.getName().equalsIgnoreCase("Float"))
			return "float";
		if (type.getName().equalsIgnoreCase("Integer"))
			return "int";
		if (type.getName().equalsIgnoreCase("Long"))
			return "long";
		if (type.getName().equalsIgnoreCase("Boolean"))
			return "boolean";
		if (type.getName().equalsIgnoreCase("String"))
			return "string";
		if (type.getName().equalsIgnoreCase("Character"))
			return "string";
		if (type.getName().equalsIgnoreCase("Decimal"))
			return "double";
		if (type.getName().equalsIgnoreCase("Date"))
			return "date";
		if (type.getName().equalsIgnoreCase("Image"))
			return "string";
		if (type.getName().equalsIgnoreCase("Text"))
			return "string";
		if (type.getName().equalsIgnoreCase("Link"))
			return "string";

		return "string";
	}

}
