package net.taylor.mda.generator.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Type;

public class NameHelper {

	public static String toDisplay(String value) {
		if ("OK".equals(value)) {
			return value;
		}
		StringBuilder builder = new StringBuilder();
		char[] chars = value.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (i == 0) {
				builder.append(Character.toUpperCase(chars[i]));
			} else
			if (Character.isUpperCase(chars[i])) {
				builder.append(" ");
				builder.append(chars[i]);
			} else {
				builder.append(chars[i]);
			}
		}
		return builder.toString();
	}

	public static String toUpperCamel(String value) {
		StringBuilder builder = new StringBuilder();
		String[] tokens = value.split("[ _-]");
		for (String string : tokens) {
			string = (string.substring(0, 1).toUpperCase() + string.substring(1));
			builder.append(string);
		}
		return builder.toString();
	}

	public static String toLowerCamel(String value) {
		value = toUpperCamel(value);
		return (value.substring(0, 1).toLowerCase() + value.substring(1));
	}

	public static String toCamelCase(String value) {
		boolean cap = Character.isUpperCase(value.charAt(0));
		if (cap) {
			return toUpperCamel(value);
		} else {
			return toLowerCamel(value);
		}
	}

	public static String capName(String name) {
		if (name == null || name.length() == 0) {
			return name;
		} else {
			return toUpperCamel(name);
		}
	}

	public static String uncapName(String name) {
		if (name == null || name.length() == 0) {
			return name;
		} else {
			return toLowerCamel(name);
		}
	}

	public static String uncapPrefixedName(String name) {
		// lower all except the last upper case character if there are
		// more than one upper case characters in the beginning.
		// e.g. XSDElementContent -> xsdElementContent
		// However if the whole string is uppercase, the whole string
		// is turned into lower case.
		// e.g. CPU -> cpu
		if (name == null || name.length() == 0) {
			return name;
		} else {
			String lowerName = name.toLowerCase();
			int i;
			for (i = 0; i < name.length(); i++) {
				if (name.charAt(i) == lowerName.charAt(i)) {
					break;
				}
			}
			if (i > 1 && i < name.length()) {
				--i;
			}
			return name.substring(0, i).toLowerCase() + name.substring(i);
		}
	}

	public static String safeName(String name) {
		if (TypeHelper.getJavaReservedWords().contains(name))
			return name + "_";
		return name;
	}

	public static String getCapName(NamedElement namedElement) {
		return capName(namedElement.getName());
	}

	public static String getCapName(String name) {
		return capName(name);
	}
	
	public static String uncapSafeName(NamedElement namedElement) {
		if(null==namedElement){
			return null;
		}
		return safeName(uncapPrefixedName(namedElement.getName()));
	}

	public static String uncapSafeNameNonPlural(NamedElement parameter) {
		String name = uncapPrefixedName(parameter.getName());
		return safeName(nonPural(name));
	}

	public static String capNameNonPlural(NamedElement parameter) {
		String name = getCapName(parameter);
		return safeName(nonPural(name));
	}

	protected static String nonPural(String name) {
		if (name.endsWith("ies")) {
			name = name.substring(0, name.length() - 3) + "y";
		}
		if (name.endsWith("s")) {
			name = name.substring(0, name.length() - 1);
		}
		return name;
	}

	public static String uncapSafeName(Parameter parameter) {
		return safeName(uncapPrefixedName(parameter.getName()));
	}

	public static String getFormattedName(NamedElement namedElement) {
		return format(getCapName(namedElement), ' ', null, false);
	}

	public static String getUpperName(NamedElement namedElement) {
		return format(namedElement.getName(), '_', null, false).toUpperCase();
	}

	public static String removeSpaces(String name) {
		return name.replaceAll(" ", "");
	}

	public static String getDeclaringName(Operation operation) {
		String qn = operation.getQualifiedName();
		qn = qn.replaceAll("::", ".");
		return qn.substring(qn.indexOf(".") + 1, qn.lastIndexOf("."));
	}

	/**
	 * This method breaks sourceName into words delimited by sourceSeparator
	 * and/or mixed-case naming.
	 */
	public static List parseName(String sourceName, char sourceSeparator) {
		List result = new ArrayList();
		StringBuffer currentWord = new StringBuffer();
		int length = sourceName.length();
		boolean lastIsLower = false;
		for (int index = 0; index < length; index++) {
			char curChar = sourceName.charAt(index);
			if (Character.isUpperCase(curChar)
					|| (!lastIsLower && Character.isDigit(curChar))
					|| curChar == sourceSeparator) {
				if (lastIsLower || curChar == sourceSeparator) {
					result.add(currentWord.toString());
					currentWord = new StringBuffer();
				}
				lastIsLower = false;
			} else {
				if (!lastIsLower) {
					int currentWordLength = currentWord.length();
					if (currentWordLength > 1) {
						char lastChar = currentWord.charAt(--currentWordLength);
						currentWord.setLength(currentWordLength);
						result.add(currentWord.toString());
						currentWord = new StringBuffer();
						currentWord.append(lastChar);
					}
				}
				lastIsLower = true;
			}
			if (curChar != sourceSeparator) {
				currentWord.append(curChar);
			}
		}
		result.add(currentWord.toString());
		return result;
	}

	public static String format(String name, char separator, String prefix,
			boolean includePrefix) {
		List parsedName = new ArrayList();
		if (prefix != null && name.startsWith(prefix)) {
			name = name.substring(prefix.length());
			if (includePrefix) {
				parsedName = parseName(prefix, '_');
			}
		}
		if (name.length() != 0)
			parsedName.addAll(parseName(name, '_'));
		StringBuffer result = new StringBuffer();
		for (Iterator nameIter = parsedName.iterator(); nameIter.hasNext();) {
			String nameComponent = (String) nameIter.next();
			result.append(nameComponent);
			if (nameIter.hasNext() && nameComponent.length() > 1) {
				result.append(separator);
			}
		}
		return result.length() == 0 && prefix != null ? prefix : result
				.toString();
	}

	public static String getUncapName(NamedElement namedElement) {
		return uncapPrefixedName(namedElement.getName());
	}

	public static String getPackageDir(NamedElement element) {
		String qn = element.getQualifiedName();
		qn = qn.replaceAll("::", "/");
		return qn.substring(qn.indexOf("/") + 1, qn.lastIndexOf("/")) + "/";
	}

	public static String getQualifiedName(Type type) {
		String qualifiedName = type.getName();
		Package parentPackage = type.getPackage();
		while (parentPackage != null && !(parentPackage instanceof Model)) {
			if (qualifiedName != null)
				qualifiedName = parentPackage.getName() + "." + qualifiedName;
			else
				qualifiedName = parentPackage.getName();
			parentPackage = parentPackage.getNestingPackage();
		}
		return toCamelCase(qualifiedName);
	}

	public static String getQualifiedName(Package pack) {
		String qualifiedName = pack.getName();
		Package parentPackage = pack.getNestingPackage();
		while (parentPackage != null && !(parentPackage instanceof Model)) {
			if (qualifiedName != null)
				qualifiedName = parentPackage.getName() + "." + qualifiedName;
			else
				qualifiedName = parentPackage.getName();
			parentPackage = parentPackage.getNestingPackage();
		}
		return toCamelCase(qualifiedName);
	}

	public static String getQualifiedName(String qn) {
		qn = toLowerCamel(qn);
		qn = qn.replaceAll("::", ".");
		return qn.substring(qn.indexOf(".") + 1);
	}
	
	public static String getQualifiedFileName(NamedElement element) {
		return element.getQualifiedName().replaceAll("::", "-");
	}

	public static String reverse(Package pkg) {
		String[] name = getQualifiedName(pkg).split("\\.");
		List<String> list = Arrays.asList(name);
		Collections.reverse(list);
		StringBuffer buf = new StringBuffer();
		for (String s : list) {
			buf.append(s);
			buf.append(".");
		}
		return buf.substring(0, buf.length() - 1);
	}
}