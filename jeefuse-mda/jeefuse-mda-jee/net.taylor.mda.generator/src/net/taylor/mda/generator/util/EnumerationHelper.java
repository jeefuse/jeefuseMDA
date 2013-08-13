package net.taylor.mda.generator.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;

public class EnumerationHelper {

	public static boolean isEnumeration(Property property) {
		return property.getType() instanceof Enumeration;
	}

	public static String getEnumLiteralID(EnumerationLiteral literal) {
//		return literal.getName();
		return NameHelper.format(literal.getName(), '_', null, false)
				.toUpperCase();
	}

	public static List getUniqueValuedGenEnumLiterals(Enumeration enumeration) {
		List result = new ArrayList();
		Set resultSet = new HashSet();
		for (Iterator iter = enumeration.getOwnedLiterals().iterator(); iter
				.hasNext();) {
			EnumerationLiteral enumLiteral = (EnumerationLiteral) iter.next();
			if (resultSet.add(new Integer(enumeration.getOwnedLiterals()
					.indexOf(enumLiteral)))) {
				result.add(enumLiteral);
			}
		}
		return result;
	}
	
	public static Iterator<Property> getAllEnumerations(Class element) {
		List<Property> list = new ArrayList<Property>();
		Iterator i = element.getAllAttributes().iterator();
		while (i.hasNext()) {
			Property p = (Property) i.next();
			if (isEnumeration(p)) {
				ImportHelper.addImport(p.getType());
				list.add(p);
			}
		}
		return list.iterator();
	}
	
	public static Iterator<Property> getOwnedEnumerations(Class element) {
		List<Property> list = new ArrayList<Property>();
		Iterator i = element.getOwnedAttributes().iterator();
		while (i.hasNext()) {
			Property p = (Property) i.next();
			if (isEnumeration(p)) {
				list.add(p);
			}
		}
		return list.iterator();
	}
	
	public static List<Enumeration> getAllEnumerations(Package model) {
		List<Enumeration> list = new ArrayList<Enumeration>();
		for (Iterator i = model.getMembers().iterator(); i.hasNext();) {
			NamedElement element = (NamedElement) i.next();
			collectEnum(element, list);
		}
		Collections.sort(list, new Comparator<NamedElement>() {
			public int compare(NamedElement lh, NamedElement rh) {
				return lh.getName().compareTo(rh.getName());
			}
		});
		return list;
	}

	static protected void collectEnum(NamedElement element, List<Enumeration> list) {
		if (element instanceof Package) {
			for (Iterator i = ((Package) element).getMembers().iterator(); i
					.hasNext();) {
				NamedElement ne = (NamedElement) i.next();
				collectEnum(ne, list);
			}
		}
		if (element instanceof Enumeration) {
			list.add((Enumeration) element);
		}
	}
}
