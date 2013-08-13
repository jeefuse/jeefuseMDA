package net.taylor.mda.generator.parse;

import java.util.Iterator;

import net.taylor.mda.generator.util.ClassHelper;
import net.taylor.mda.generator.util.NameHelper;
import net.taylor.mda.generator.util.TypeHelper;

import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

public class ModelHelper {

	public static String getCapName(NamedElement nameElement) {
		return NameHelper.capName(NameHelper.uncapSafeName(nameElement));
	}

	public static String getUncapName(NamedElement nameElement) {
		return NameHelper.uncapName(NameHelper.uncapSafeName(nameElement));
	}

	public static String getComment(NamedElement nameElement){
		String comment=TypeHelper.getDocumentation(nameElement);
		if(StringUtils.isBlank(comment)){
			if(nameElement instanceof Property&&!ClassHelper.isSimple((Property)nameElement)){
				comment=TypeHelper.getDocumentationOrName(((Property)nameElement).getType());
			}else{
				comment=TypeHelper.getDocumentationOrName(nameElement);
			}
		}
		return comment;
	}
	/**
	 * 返回get方法名.
	 */
	public static String getGetAccessor(Property property) {
		return ClassHelper.getGetAccessor(property);
	}

	/**
	 * 返回set方法名.
	 */
	public static String getSetAccessor(Property property) {
		return "set" + ClassHelper.getAccessorName(property);
	}

	public static Class getRelTargetClass(Class relUml2Class, Class ownerUml2Class) {
		Iterator<Property> itor = ClassHelper.getAllOneToManyProperties(relUml2Class);
		if (itor.hasNext()) {
			Property property = itor.next();
			Type type = property.getType();
			if (!type.getName().equalsIgnoreCase(ownerUml2Class.getName())) {
				return (Class) type;
			}
		}
		return null;
	}

	public static String getRelIdsMethodName(Class relUml2Class, Class ownerUml2Class) {
		StringBuilder sb = new StringBuilder();
		sb.append("getRel");
		sb.append(NameHelper.getCapName(relUml2Class));
		sb.append("IdsBy");
		sb.append(NameHelper.getCapName(ownerUml2Class));
		sb.append("Id");
		return sb.toString();
	}

}
