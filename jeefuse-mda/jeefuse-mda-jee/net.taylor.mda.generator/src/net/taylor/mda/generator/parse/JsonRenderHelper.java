package net.taylor.mda.generator.parse;

import net.taylor.mda.generator.parse.entity.ModelNameSuffix;
import net.taylor.mda.generator.util.ClassHelper;
import net.taylor.mda.generator.util.NameHelper;
import net.taylor.mda.generator.util.TypeHelper;

import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

public class JsonRenderHelper {

	public static String getJacksonWriteRender(Property property,org.eclipse.uml2.uml.Class uml2Class){
		StringBuilder sb=new StringBuilder();
		String propertyName=NameHelper.uncapSafeName(property);
			//String propertyImportFeatureType=MdaHelper.getImportedFeatureType(property);
		String propertyGetMethod=ClassHelper.getGetAccessor(property);
		//String propertyCommentName=TypeHelper.getDocumentationOrName(property);
		String jackonWriterMethod=getJacksonWriteMethod(property.getType());
		String modelFieldcapName=MdaHelper.getModelClassName(uml2Class,ModelNameSuffix.EntityField);
		//String modelFieldUncapName=NameHelper.uncapName(modelFieldcapName);
		sb.append(jackonWriterMethod);
		sb.append("(");
		sb.append(modelFieldcapName+"."+propertyName+".getFieldName()");
		if(TypeHelper.isInteger(property)||TypeHelper.isLong(property.getType())||TypeHelper.isDouble(property.getType())){
			sb.append(",null==model."+propertyGetMethod+"()?0:model."+propertyGetMethod+"()");
		}else{
			sb.append(",model."+propertyGetMethod+"()");
		}
		sb.append(")");
		return sb.toString();
	}
	public static String getJacksonWriteMethod(Type type) {
		try {
			if ("String".equals(type.getName()))
				return "writeStringField";
			if ("Boolean".equals(type.getName()))
				return "writeBooleanField";
			if (TypeHelper.isDouble(type))
				return "writeNumberField";
			if ("Date".equals(type.getName()))
				return "writeNumberField";
			if ("Time".equals(type.getName()))
				return "writeNumberField";
			if ("Timestamp".equals(type.getName()))
				return "writeNumberField";
			if (type.getName().equals("Currency")) {
				return "writeNumberField";
			}
			if (type.getName().equals("Byte[]"))
				return "writeBinaryField";
			if (type.getName().equals("Percentage"))
				return "writeNumberField";
			if (type.getName().equals("Integer"))
				return "writeNumberField";
			if (type.getName().equals("Long"))
				return "writeNumberField";
			if (type.getName().equals("Decimal"))
				return "writeNumberField";
			if (type.getName().equals("Text"))
				return "writeStringField";
			if (type.getName().equals("Link"))
				return "writeStringField";
			return "writeStringField";
		} catch (Exception e) {
			return null;
		}
	}
}
