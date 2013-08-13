package net.taylor.mda.generator.util;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import net.taylor.mda.generator.parse.MdaHelper;
import net.taylor.mda.generator.parse.StringUtils;
import net.taylor.mda.generator.parse.entity.Config;
import net.taylor.mda.generator.parse.entity.EntityHelper;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StructuralFeature;
import org.eclipse.uml2.uml.Type;

import net.jeefuse.mda.annotations.MdaStereotype;

public class TypeHelper {
	private static HashSet javaReservedWords;

	private static HashSet javaLangTypes;

	/**
	 * Returns a hash of all Java's keywords and textual literals, as of Java
	 * 1.4.
	 */
	public static HashSet getJavaReservedWords() {
		if (javaReservedWords == null) {
			javaReservedWords = new HashSet(100);
			javaReservedWords.add("abstract");
			javaReservedWords.add("assert");
			javaReservedWords.add("boolean");
			javaReservedWords.add("break");
			javaReservedWords.add("byte");
			javaReservedWords.add("case");
			javaReservedWords.add("catch");
			javaReservedWords.add("char");
			javaReservedWords.add("class");
			javaReservedWords.add("const");
			javaReservedWords.add("continue");
			javaReservedWords.add("default");
			javaReservedWords.add("do");
			javaReservedWords.add("double");
			javaReservedWords.add("else");
			javaReservedWords.add("extends");
			javaReservedWords.add("false");
			javaReservedWords.add("final");
			javaReservedWords.add("finally");
			javaReservedWords.add("float");
			javaReservedWords.add("for");
			javaReservedWords.add("goto");
			javaReservedWords.add("if");
			javaReservedWords.add("implements");
			javaReservedWords.add("import");
			javaReservedWords.add("instanceof");
			javaReservedWords.add("int");
			javaReservedWords.add("interface");
			javaReservedWords.add("long");
			javaReservedWords.add("native");
			javaReservedWords.add("new");
			javaReservedWords.add("null");
			javaReservedWords.add("package");
			javaReservedWords.add("private");
			javaReservedWords.add("protected");
			javaReservedWords.add("public");
			javaReservedWords.add("return");
			javaReservedWords.add("short");
			javaReservedWords.add("static");
			javaReservedWords.add("strictfp");
			javaReservedWords.add("super");
			javaReservedWords.add("switch");
			javaReservedWords.add("synchronized");
			javaReservedWords.add("this");
			javaReservedWords.add("throw");
			javaReservedWords.add("throws");
			javaReservedWords.add("transient");
			javaReservedWords.add("true");
			javaReservedWords.add("try");
			javaReservedWords.add("void");
			javaReservedWords.add("volatile");
			javaReservedWords.add("while");
		}
		return javaReservedWords;
	}

	public static HashSet getJavaLangTypes() {
		if (javaLangTypes == null) {
			javaLangTypes = new HashSet(100);
			javaLangTypes.add("AbstractMethodError");
			javaLangTypes.add("ArithmeticException");
			javaLangTypes.add("ArrayIndexOutOfBoundsException");
			javaLangTypes.add("ArrayStoreException");
			javaLangTypes.add("Boolean");
			javaLangTypes.add("Byte");
			javaLangTypes.add("Character");
			javaLangTypes.add("Class");
			javaLangTypes.add("ClassCastException");
			javaLangTypes.add("ClassCircularityError");
			javaLangTypes.add("ClassFormatError");
			javaLangTypes.add("ClassLoader");
			javaLangTypes.add("ClassNotFoundException");
			javaLangTypes.add("CloneNotSupportedException");
			javaLangTypes.add("Cloneable");
			javaLangTypes.add("Comparable");
			javaLangTypes.add("Compiler");
			javaLangTypes.add("Double");
			javaLangTypes.add("Error");
			javaLangTypes.add("Exception");
			javaLangTypes.add("ExceptionInInitializerError");
			javaLangTypes.add("Float");
			javaLangTypes.add("FloatingDecimal");
			javaLangTypes.add("IllegalAccessError");
			javaLangTypes.add("IllegalAccessException");
			javaLangTypes.add("IllegalArgumentException");
			javaLangTypes.add("IllegalMonitorStateException");
			javaLangTypes.add("IllegalStateException");
			javaLangTypes.add("IllegalThreadStateException");
			javaLangTypes.add("IncompatibleClassChangeError");
			javaLangTypes.add("IndexOutOfBoundsException");
			javaLangTypes.add("InheritableThreadLocal");
			javaLangTypes.add("InstantiationError");
			javaLangTypes.add("InstantiationException");
			javaLangTypes.add("Integer");
			javaLangTypes.add("InternalError");
			javaLangTypes.add("InterruptedException");
			javaLangTypes.add("LinkageError");
			javaLangTypes.add("Long");
			javaLangTypes.add("Math");
			javaLangTypes.add("NegativeArraySizeException");
			javaLangTypes.add("NoClassDefFoundError");
			javaLangTypes.add("NoSuchFieldError");
			javaLangTypes.add("NoSuchFieldException");
			javaLangTypes.add("NoSuchMethodError");
			javaLangTypes.add("NoSuchMethodException");
			javaLangTypes.add("NullPointerException");
			javaLangTypes.add("Number");
			javaLangTypes.add("NumberFormatException");
			javaLangTypes.add("Object");
			javaLangTypes.add("OutOfMemoryError");
			javaLangTypes.add("Package");
			javaLangTypes.add("Process");
			javaLangTypes.add("Runnable");
			javaLangTypes.add("Runtime");
			javaLangTypes.add("RuntimeException");
			javaLangTypes.add("RuntimePermission");
			javaLangTypes.add("SecurityException");
			javaLangTypes.add("SecurityManager");
			javaLangTypes.add("Short");
			javaLangTypes.add("StackOverflowError");
			javaLangTypes.add("String");
			javaLangTypes.add("StringBuffer");
			javaLangTypes.add("StringIndexOutOfBoundsException");
			javaLangTypes.add("System");
			javaLangTypes.add("Thread");
			javaLangTypes.add("ThreadDeath");
			javaLangTypes.add("ThreadGroup");
			javaLangTypes.add("ThreadLocal");
			javaLangTypes.add("Throwable");
			javaLangTypes.add("UnknownError");
			javaLangTypes.add("UnsatisfiedLinkError");
			javaLangTypes.add("UnsupportedClassVersionError");
			javaLangTypes.add("UnsupportedOperationException");
			javaLangTypes.add("VerifyError");
			javaLangTypes.add("VirtualMachineError");
			javaLangTypes.add("Void");
			javaLangTypes.add("boolean");
			javaLangTypes.add("byte");
			javaLangTypes.add("char");
			javaLangTypes.add("double");
			javaLangTypes.add("float");
			javaLangTypes.add("int");
			javaLangTypes.add("long");
			javaLangTypes.add("short");
		}
		return javaLangTypes;
	}

	public static java.lang.Class getInstanceClass(Type type) {
		try {
			if ("String".equals(type.getName()))
				return String.class;
			if ("Boolean".equals(type.getName()))
				return Boolean.class;
			if ("Date".equals(type.getName()))
				return Date.class;// TODO decide which Calendar.class;
			if ("Time".equals(type.getName()))
				return Date.class;
			if ("Timestamp".equals(type.getName()))
				return Date.class;
			if ("Byte".equals(type.getName()))
				return Byte.TYPE;
			if ("Integer".equals(type.getName()))
				return Integer.class;
			if ("Long".equals(type.getName()))
				return Long.class;
			if ("Double".equals(type.getName()))
				return Double.class;
			if ("Short".equals(type.getName()))
				return Short.class;
			if ("Float".equals(type.getName()))
				return Float.class;
			if ("Character".equals(type.getName()))
				return Character.TYPE;
			java.lang.Class instanceClass = java.lang.Class.forName(NameHelper.getQualifiedName(type), true, Thread
					.currentThread().getContextClassLoader());
			return instanceClass;
		} catch (Exception e) {
			return null;
		}
	}

	public static String getPrimitiveObjectType(Type type) {
		java.lang.Class instanceClass = getInstanceClass(type);
		if (instanceClass == java.lang.Boolean.TYPE || instanceClass == java.lang.Boolean.class)
			return "java.lang.Boolean";
		if (instanceClass == java.lang.Byte.TYPE || instanceClass == java.lang.Byte.class)
			return "java.lang.Byte";
		if (instanceClass == java.lang.Character.TYPE || instanceClass == java.lang.Character.class)
			return "java.lang.Character";
		if (instanceClass == java.lang.Double.TYPE || instanceClass == java.lang.Double.class)
			return "java.lang.Double";
		if (instanceClass == java.lang.Float.TYPE || instanceClass == java.lang.Float.class)
			return "java.lang.Float";
		if (instanceClass == java.lang.Integer.TYPE || instanceClass == java.lang.Integer.class)
			return "java.lang.Integer";
		if (instanceClass == java.lang.Long.TYPE || instanceClass == java.lang.Long.class)
			return "java.lang.Long";
		if (instanceClass == java.lang.Short.TYPE || instanceClass == java.lang.Short.class)
			return "java.lang.Short";
		if (instanceClass == java.util.Date.class)
			return "java.util.Date";
		if (instanceClass == java.lang.String.class)
			return "java.lang.String";
		if (type instanceof Enumeration)
			return "java.lang.Long";
		return null;
	}

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
			// return "Double";
		}
		if (type.getName().equals("Percentage"))
			return "Double";
		if (type.getName().equals("Integer"))
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
		if (isPrimitiveType(type) && getInstanceClass(type) != null) {
			name = ImportHelper.getImportedName(getInstanceClass(type).getName());// type.getName();
		} else {
			//add for system entity package name
			if (EntityHelper.isStereotypeApplied(type, StereotypeHelper.ENTITY,
					MdaStereotype.model_M2m,
					MdaStereotype.model_M2mWithId)
					&& (type instanceof org.eclipse.uml2.uml.Class)) {
				name = MdaHelper.getEntityQualifiedName((org.eclipse.uml2.uml.Class) type);
				name = ImportHelper.getImportedName(name);
			} else {
				name = ImportHelper.getImportedName(NameHelper.getQualifiedName(type));
			}
			//name = ImportHelper.getImportedName(NameHelper.getQualifiedName(type));
		}
		return name;
	}

	public static String getImportedFeatureType(StructuralFeature feature) {
		if (feature.getType() == null)
			return null;
		String generatedFeatureType = TypeHelper.getImportedType(feature.getType());
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

	public static boolean isPrimitiveType(Type type) {
		try {
			if (type instanceof PrimitiveType)
				return true;
			Object result = getInstanceClass(type);
			if (result == null)
				return false;
			java.lang.Class instanceClass = (java.lang.Class) result;
			return instanceClass.isPrimitive();
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean isBooleanType(Type type) {
		return "Boolean".equals(type.getName());
		// return isPrimitiveType(type)
		// && getInstanceClass(type) == java.lang.Boolean.TYPE;
	}

	public static boolean isStringType(Type type) {
		return getInstanceClass(type) == java.lang.String.class;
	}

	// public static boolean isEnumeration(Property property) {
	// return property.getType() instanceof Enumeration;
	// }

	public static boolean isDate(Property property) {
		return "Date".equals(property.getType().getName());
	}

	public static boolean isTimestamp(Property property) {
		return "Timestamp".equals(property.getType().getName());
	}

	public static boolean isTime(Property property) {
		return "Time".equals(property.getType().getName());
	}

	public static boolean isBoolean(Property property) {
		return "Boolean".equals(property.getType().getName());
	}

	public static boolean isCurrency(Property property) {
		return "Currency".equals(property.getType().getName());
	}

	public static boolean isPercentage(Property property) {
		return "Percentage".equals(property.getType().getName());
	}

	public static boolean isText(Property property) {
		return "Text".equals(property.getType().getName());
	}

	public static boolean isImage(Property property) {
		return "Image".equals(property.getType().getName());
	}

	public static boolean isLink(Property property) {
		return "Link".equals(property.getType().getName());
	}

	public static boolean isDecimal(Property property) {
		return "Decimal".equals(property.getType().getName());
	}

	public static boolean isInteger(Property property) {
		return "Integer".equals(property.getType().getName());
	}

	public static boolean isBlob(Type type) {
		return "Byte[]".equals(type.getName());
	}

	public static boolean isDouble(Type type) {
		return "Double".equals(type.getName());
	}

	public static boolean isLong(Type type) {
		return "Long".equals(type.getName());
	}

	public static boolean isEnum(Property property) {
		return property.getType() instanceof Enumeration;
	}

	public static String getDefaultValue(Property feature) {
		if (feature.getDefaultValue() == null) {
			if (isPrimitiveType(feature.getType()) && !feature.isMultivalued())
				return getPrimitiveDefault(feature.getType());
			if (ClassHelper.isComposite(feature)) {
				return "new " + feature.getType().getName() + "()";
			}
			return null;
		}
		return feature.getDefaultValue().stringValue();
	}

	public static boolean hasDefaultValue(Property feature) {
		String dv = getDefaultValue(feature);
		return dv != null && dv.length() > 0;
	}

	public static String getPrimitiveDefault(Type type) {
		if (type instanceof Property) {
			String defaultValue = ((Property) type).getDefault();
			if (defaultValue != null && defaultValue.length() > 0) {
				String name = type.getName();
				if ("String".equals(name)) {
					return "\"" + defaultValue + "\"";
				}
				if ("Integer".equals(name)) {
					return "new Long(" + defaultValue + ")";
				}
				if ("Percentage".equals(name)) {
					return "new Double(" + defaultValue + ")";
				}
				if ("Currency".equals(name)) {
					return "new BigDecimal(" + defaultValue + ")";
				}
				if ("Decimal".equals(name)) {
					return "new Double(" + defaultValue + ")";
				}
				if ("Boolean".equals(name)) {
					if ("true".equals(defaultValue.toLowerCase())) {
						return "Boolean.TRUE";
					} else {
						return "Boolean.FALSE";
					}
				}
				if ("Date".equals(name)) {
				}
				if ("Time".equals(name)) {
				}
				if ("Timestamp".equals(name)) {
				}
			}
		}
		return null;
	}

	public static String getDocumentation(NamedElement namedElement) {
		StringBuffer result = new StringBuffer();
		List<Comment> comments=namedElement.getOwnedComments();
		if(comments.size()>0){
			Comment comment = comments.get(0);
			if (StringUtils.isNotBlank(comment.getBody())&&!comment.getBody().trim().equalsIgnoreCase("null")) {
				result.append(comment.getBody());
			}
		}
		return result.toString();
	}

	public static String getDocumentationOrName(NamedElement namedElement) {
		StringBuffer result = new StringBuffer();
		List<Comment> comments=namedElement.getOwnedComments();
		if(comments.size()>0){
			Comment comment = comments.get(0);
			if (StringUtils.isNotBlank(comment.getBody())&&!comment.getBody().trim().equalsIgnoreCase("null")) {
				result.append(comment.getBody());
			}
		}
//		for (Iterator iter = namedElement.getOwnedComments().iterator(); iter.hasNext();) {
//			Comment comment = (Comment) iter.next();
//			if (result.length() > 0) {
//				result.append("<br>");
//			}
//			if (StringUtils.isNotBlank(comment.getBody())&&!comment.getBody().trim().equalsIgnoreCase("null")) {
//				result.append(comment.getBody());
//			}
//		}
		if (result.length() == 0||result.toString().trim().equalsIgnoreCase("null")) {
			return namedElement.getName();
		}
		return result.toString();
	}
}
