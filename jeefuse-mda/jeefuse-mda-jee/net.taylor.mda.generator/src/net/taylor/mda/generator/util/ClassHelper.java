package net.taylor.mda.generator.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import net.taylor.mda.generator.parse.entity.Config;

import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.Actor;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.StructuralFeature;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Type;

public class ClassHelper {

	public static String getGetAccessor(StructuralFeature feature) {
		String capName = NameHelper.getCapName(feature);
		String result = TypeHelper.isBooleanType(feature.getType()) ? "get"
		// "is" not right for Boolean, only boolean
				+ capName : "get"
				+ ("Class".equals(capName) ? "Class_" : capName);
		return result;
	}

	public static String getSetAccessorName(StructuralFeature feature) {
		return "set"+NameHelper.getCapName(feature);
	}
	
	public static String getAccessorName(StructuralFeature feature) {
		return NameHelper.getCapName(feature);
	}

	public static String getAccessorNameNonPlural(StructuralFeature feature) {
		String name = NameHelper.capNameNonPlural(feature);
		return name;
	}

	public static boolean isRoot(Class uml2Class) {
		return !uml2Class.getSuperClasses().iterator().hasNext()
				&& hasSubclasses(uml2Class);
	}

	public static String getInheritance(Class uml2Class) {
		List<Class> subclasses = getSubclasses(uml2Class);
		return StereotypeHelper.getAnnotations((Element) subclasses.get(0)
				.getGeneralizations().get(0), false);
	}

	public static List<Class> getSubclasses(Class uml2Class) {
		List<Class> classes = getClasses(uml2Class.getModel());
		List<Class> subclasses = new ArrayList<Class>();
		for (Iterator i = classes.iterator(); i.hasNext();) {
			Class element = (Class) i.next();
			List supers = element.getSuperClasses();
			for (Iterator j = supers.iterator(); j.hasNext();) {
				Class y = (Class) j.next();
				if (uml2Class.equals(y))
					subclasses.add(element);
			}
		}
		return subclasses;
	}

	public static boolean hasSubclasses(Class uml2Class) {
		return !getSubclasses(uml2Class).isEmpty();
		// List<Class> classes = getClasses(uml2Class.getModel());
		// for (Iterator i = classes.iterator(); i.hasNext();) {
		// Class element = (Class) i.next();
		// List supers = element.getSuperClasses();
		// for (Iterator j = supers.iterator(); j.hasNext();) {
		// Class y = (Class) j.next();
		// if (uml2Class.equals(y))
		// return true;
		// }
		// }
		// return false;
	}

	public static List<Class> getClasses(Package model) {
		List<Class> list = new ArrayList<Class>();
		for (Iterator i = model.getMembers().iterator(); i.hasNext();) {
			NamedElement element = (NamedElement) i.next();
			collectClass(element, list);
		}
		Collections.sort(list, new Comparator<Class>() {
			public int compare(Class lh, Class rh) {
				return lh.getName().compareTo(rh.getName());
			}
		});
		return list;
	}

	static protected void collectClass(NamedElement element, List<Class> list) {
		if (element instanceof Package) {
			for (Iterator i = ((Package) element).getMembers().iterator(); i
					.hasNext();) {
				NamedElement ne = (NamedElement) i.next();
				collectClass(ne, list);
			}
		}
		if (!(element instanceof StateMachine)
				&& !(element instanceof Activity)
				&& !(element instanceof Stereotype) && element instanceof Class) {
			list.add((Class) element);
		}
	}

	static public boolean isSimple(Property p) {
		return p.getAssociation() == null
				&& !p.isMultivalued()
				&& (TypeHelper.isPrimitiveType(p.getType()) || EnumerationHelper
						.isEnumeration(p));
	}

	static public Iterator<Property> getAllSimpleProperties(Class element) {
		return getAllSimplePropertiesList(element, new ArrayList<Property>())
				.iterator();
	}

	static public List<Property> getOwnedSimpleProperties(Class element,
			List<Property> list) {
		Iterator<Property> i = element.getOwnedAttributes().iterator();
		while (i.hasNext()) {
			Property p = (Property) i.next();
			if (isSimple(p)) {
				list.add(p);
			}
		}
		return list;
	}

	static public List<Property> getAllSimplePropertiesList(Class element,
			List<Property> list) {
		List<Class> supers = element.getSuperClasses();
		for (Class parent : supers) {
			getAllSimplePropertiesList(parent, list);
		}
		getOwnedSimpleProperties(element, list);
		return list;
	}

	static public Iterator<Property> getOwnedSimpleProperties(Class element) {
		List<Property> list = new ArrayList<Property>();
		Iterator<Property> i = element.getOwnedAttributes().iterator();
		while (i.hasNext()) {
			Property p = (Property) i.next();
			if (isSimple(p)) {
				list.add(p);
			}
		}
		return list.iterator();
	}

	static public Iterator<Property> getCompositeProperties(Class element) {
		List<Property> list = new ArrayList<Property>();
		Iterator i = element.getAllAttributes().iterator();
		while (i.hasNext()) {
			Property p = (Property) i.next();
			if (isComposite(p)) {
				ImportHelper.addImport(p.getType());
				list.add(p);
			}
		}
		return list.iterator();
	}

	static public Iterator<Property> getOwnedCompositeProperties(Class element) {
		List<Property> list = new ArrayList<Property>();
		Iterator i = element.getOwnedAttributes().iterator();
		while (i.hasNext()) {
			Property p = (Property) i.next();
			if (isComposite(p)) {
				ImportHelper.addImport(p.getType());
				list.add(p);
			}
		}
		return list.iterator();
	}

	static public boolean isComposite(Property p) {
		return (p.getAssociation() == null
				&& !TypeHelper.isPrimitiveType(p.getType()) && !EnumerationHelper
				.isEnumeration(p));
	}

	static public Iterator<Property> getAllManyToOneProperties(Class element) {
		return getAllManyToOneProperties(element, true);
		/*
		 * Iterator i = element.getAssociations().iterator(); while
		 * (i.hasNext()) { Association association = (Association) i.next(); if
		 * (isManyToOne(association)) { Property p =
		 * association.getMemberEnds().get(1);
		 * ImportHelper.addImport(p.getType()); list.add(p); } }
		 */
	}

	static public Iterator<Property> getAllManyToOneProperties(Class element,
			boolean withImport) {
		List<Property> list = new ArrayList<Property>();
		Iterator i = element.getAllAttributes().iterator();
		while (i.hasNext()) {
			Property p = (Property) i.next();
			if (isManyToOne(p)) {
				if (withImport) {
					if (p.getType() == null) {
						throw new RuntimeException("No Type assigned for: " + p);
					}
					ImportHelper.addImport(p.getType());
				}
				list.add(p);
			}
		}
		return list.iterator();
	}

	static public List<Property> getAllManyToOnePropertiesList(Class element) {
		List<Property> list = new ArrayList<Property>();
		Iterator i = element.getAllAttributes().iterator();
		while (i.hasNext()) {
			Property p = (Property) i.next();
			if (isManyToOne(p)) {
				list.add(p);
			}
		}
		return list;
	}
	
	static public Iterator<Property> getAllOneToOneProperties(Class element) {
		List<Property> list = new ArrayList<Property>();
		Iterator i = element.getAllAttributes().iterator();
		while (i.hasNext()) {
			Property p = (Property) i.next();
			if (isOneToOne(p)) {
				ImportHelper.addImport(p.getType());
				list.add(p);
			}
		}
		return list.iterator();
	}

	static public boolean isChild(Class element) {
		Iterator i = element.getAllAttributes().iterator();
		while (i.hasNext()) {
			Property p = (Property) i.next();
			if (isChild(p) && !isShared(p.getOpposite())) {
				return true;
			}
		}
		return false;
	}

	static private boolean isChild(Property p) {
		// TODO has association, has opposite which is multi, self is not multi
		return p.getAssociation() != null && !p.isMultivalued()
				&& !p.getType().equals(p.getOwner())
				&& (p.getOpposite() != null && p.getOpposite().isMultivalued());// isManyToOne(p);
		// return (p.getAssociation() == null
		// && !TypeHelper.isPrimitiveType(p.getType()) && !EnumerationHelper
		// .isEnumeration(p))
		// || (p.getAssociation() != null && !p.isMultivalued());
	}

	static public boolean isMyParent(Property p) {
		return p.getAssociation() != null && !p.isMultivalued()
				&& (p.getOpposite() != null && p.getOpposite().isMultivalued());
	}

	private static boolean checkCardinality(Association association,
			boolean firstMulti, boolean secondMulti) {
		Property first = association.getMemberEnds().get(0);
		Property second = association.getMemberEnds().get(1);
		if (first.isMultivalued() == firstMulti) {
			return false;
		}
		if (second.isMultivalued() == secondMulti) {
			return false;
		}
		return true;
	}

	static public boolean isManyToOne(Property p) {
		return (p.getAssociation() == null
				&& !TypeHelper.isPrimitiveType(p.getType()) && !EnumerationHelper
				.isEnumeration(p))
				|| (p.getAssociation() != null && !p.isMultivalued());
	}

	static public boolean isManyToOne(Association association) {
		return checkCardinality(association, true, false);
	}

	static public boolean isManyToMany(Property p) {
		return p.getAssociation() != null && p.isMultivalued()
				&& (p.getOpposite() == null || p.getOpposite().isMultivalued());
	}

	static public boolean isOneToOne(Property p) {
		return p.getAssociation() != null && !p.isMultivalued()
				&& p.getOpposite() != null && !p.getOpposite().isMultivalued();
	}

	static public Iterator<Property> getOwnedManyToOneProperties(Class element) {
		List<Property> list = new ArrayList<Property>();
		Iterator i = element.getOwnedAttributes().iterator();
		while (i.hasNext()) {
			Property p = (Property) i.next();
			if (isManyToOne(p)) {
				ImportHelper.addImport(p.getType());
				list.add(p);
			}
		}
		/*
		 * Iterator i = element.getAssociations().iterator(); while
		 * (i.hasNext()) { Association association = (Association) i.next(); if
		 * (isManyToOne(association)) { Property p =
		 * association.getMemberEnds().get(1); if (p.getOwner().equals(element)) {
		 * ImportHelper.addImport(p.getType()); list.add(p); } } }
		 */
		return list.iterator();
	}

	static public Iterator<Property> getAllManyToManyProperties(Class element) {
		List<Property> list = new ArrayList<Property>();
		Iterator i = element.getAllAttributes().iterator();
		while (i.hasNext()) {
			Property p = (Property) i.next();
			if (isManyToMany(p)) {
				ImportHelper.addImport(p.getType());
				list.add(p);
			}
		}
		return list.iterator();
	}

	static public Iterator<Property> getOwnedManyToManyProperties(Class element) {
		List<Property> list = new ArrayList<Property>();
		Iterator i = element.getOwnedAttributes().iterator();
		while (i.hasNext()) {
			Property p = (Property) i.next();
			if (isManyToMany(p)) {
				ImportHelper.addImport(p.getType());
				list.add(p);
			}
		}
		return list.iterator();
	}

	static public Iterator<Property> getOwnedOneToOneProperties(Class element) {
		List<Property> list = new ArrayList<Property>();
		Iterator i = element.getOwnedAttributes().iterator();
		while (i.hasNext()) {
			Property p = (Property) i.next();
			if (isOneToOne(p)) {
				ImportHelper.addImport(p.getType());
				list.add(p);
			}
		}
		return list.iterator();
	}

	static public Iterator<Property> getAllManyToOneNotNavigableProperties(
			Class element) {
		List<Property> list = new ArrayList<Property>();
		Iterator i = element.getAllAttributes().iterator();
		while (i.hasNext()) {
			Property p = (Property) i.next();
			if (p.getAssociation() != null && p.getOpposite() != null
					&& !p.getOpposite().isNavigable() && !p.isMultivalued()) {
				ImportHelper.addImport(p.getType());
				list.add(p);
			}
		}
		return list.iterator();
	}

	static public Iterator<Property> getOwnedManyToOneNotNavigableProperties(
			Class element) {
		List<Property> list = new ArrayList<Property>();
		Iterator i = element.getOwnedAttributes().iterator();
		while (i.hasNext()) {
			Property p = (Property) i.next();
			if (p.getAssociation() != null && p.getOpposite() != null
					&& !p.getOpposite().isNavigable() && !p.isMultivalued()) {
				ImportHelper.addImport(p.getType());
				list.add(p);
			}
		}
		return list.iterator();
	}

	static public boolean isOneToMany(Property p) {
		return p.getAssociation() != null && p.isMultivalued()
				&& p.getOpposite() != null && !p.getOpposite().isMultivalued();
	}

	static public Iterator<Property> getAllOneToManyProperties(Class element) {
		List<Property> list = new ArrayList<Property>();
		Iterator i = element.getAllAttributes().iterator();
		while (i.hasNext()) {
			Property p = (Property) i.next();
			if (isOneToMany(p)) {
				ImportHelper.addImport(p.getType());
				list.add(p);
			}
		}
		return list.iterator();
	}

	static public Iterator<Property> getOwnedOneToManyProperties(Class element) {
		List<Property> list = new ArrayList<Property>();
		Iterator i = element.getOwnedAttributes().iterator();
		while (i.hasNext()) {
			Property p = (Property) i.next();
			if (isOneToMany(p)) {
				ImportHelper.addImport(p.getType());
				list.add(p);
			}
		}
		return list.iterator();
	}

	static public boolean isShared(Property p) {
		return AggregationKind.SHARED_LITERAL.equals(p.getAggregation());
	}

	static public boolean needsCanDelete(Class element) {
		return getReferencesToMe(element).hasNext() || hasSharedParent(element);
	}

	static public boolean hasSharedParent(Class element) {
		Iterator<Property> i = getAllManyToOneProperties(element);
		while (i.hasNext()) {
			Property p = (Property) i.next();
			if (isMyParent(p) && isShared(p.getOpposite())) {
				return true;
			}
		}
		return false;
	}

	static public Iterator<Property> getReferencesToMe(Class element) {
		List<Property> list = new ArrayList<Property>();
		List<Class> classes = getClasses(element.getModel());
		for (Class clazz : classes) {
			if (!clazz.equals(element)) {
				for (Iterator<Property> i = ClassHelper
						.getAllManyToOneProperties(clazz, false); i.hasNext();) {
					Property property = i.next();
					if (isType(element, property.getType())
							&& !isChild(property)) {
						list.add(property);
					}
				}
				// TODO o2o, m2m ??? probably not m2m, need to look at cascade
				// type
				// m2m based on src/tgt
			}
		}
		return list.iterator();
	}

	static protected boolean isType(Class element, Type type) {
		if (element.equals(type)) {
			return true;
		}
		// EList<Class> list = element.getSuperClasses();
		// for (Class class1 : list) {
		// if (isType(class1, type)){
		// return true;
		// }
		// }
		return false;
	}

	public static String getExtendsAndImplementsLitteral(Class uml2Class) {
		String extendsLitteral = "";
		String implementsLitteral = "";
		List superClasses = uml2Class.getSuperClasses();
		if (superClasses.iterator().hasNext()) {
			Class superClass = (Class) superClasses.iterator().next();
			String superClassQualifiedName = NameHelper
					.getQualifiedName(superClass);
			if (extendsLitteral.equals(""))
				extendsLitteral = " extends "
						+ ImportHelper.getImportedName(superClassQualifiedName);
			else
				extendsLitteral = implementsLitteral
						+ ","
						+ ImportHelper.getImportManager().getImportedName(
								superClassQualifiedName);
		}
		if (!uml2Class.getSuperClasses().iterator().hasNext()) {
			ImportHelper.getImportedName("java.io.Serializable");
			if (StereotypeHelper.isStereotypeApplied(uml2Class, StereotypeHelper.ENTITY)) {
				implementsLitteral = " implements Serializable, Cloneable";
			} else {
				implementsLitteral = " implements Serializable";
			}
		}
		List interfaces = uml2Class.getInterfaceRealizations();// TODO
		// .getImplementedInterfaces();
		for (Iterator it = interfaces.iterator(); it.hasNext();) {
			Interface itf = (Interface) it.next();
			String itfQualifiedName = NameHelper.getQualifiedName(itf);
			if (implementsLitteral.equals(""))
				if (extendsLitteral.equals(""))
					implementsLitteral = " implements "
							+ ImportHelper.getImportedName(itfQualifiedName);
				else
					implementsLitteral = ", implements "
							+ ImportHelper.getImportedName(itfQualifiedName);
			else
				implementsLitteral = implementsLitteral + ","
						+ ImportHelper.getImportedName(itfQualifiedName);
		}
		return extendsLitteral + implementsLitteral;
	}

	public static String getExtendsAndImplementsSerialize(Class uml2Class) {
		String extendsLitteral = "";
		String implementsLitteral = "";
		List superClasses = uml2Class.getSuperClasses();
		if (superClasses.iterator().hasNext()) {
			Class superClass = (Class) superClasses.iterator().next();
			String superClassQualifiedName = NameHelper
					.getQualifiedName(superClass);
			if (extendsLitteral.equals(""))
				extendsLitteral = " extends "
						+ ImportHelper.getImportedName(superClassQualifiedName);
			else
				extendsLitteral = implementsLitteral
						+ ","
						+ ImportHelper.getImportManager().getImportedName(
								superClassQualifiedName);
		}
		if (!uml2Class.getSuperClasses().iterator().hasNext()) {
			ImportHelper.getImportedName("java.io.Serializable");
			implementsLitteral = " implements Serializable";
		}
		List interfaces = uml2Class.getInterfaceRealizations();// TODO
		// .getImplementedInterfaces();
		for (Iterator it = interfaces.iterator(); it.hasNext();) {
			Interface itf = (Interface) it.next();
			String itfQualifiedName = NameHelper.getQualifiedName(itf);
			if (implementsLitteral.equals(""))
				if (extendsLitteral.equals(""))
					implementsLitteral = " implements "
							+ ImportHelper.getImportedName(itfQualifiedName);
				else
					implementsLitteral = ", implements "
							+ ImportHelper.getImportedName(itfQualifiedName);
			else
				implementsLitteral = implementsLitteral + ","
						+ ImportHelper.getImportedName(itfQualifiedName);
		}
		return extendsLitteral + implementsLitteral;
	}

	public static String getExtendsIdEntityAndImplementsSerialize(Class uml2Class) {
		ImportHelper.getImportedName(Config.base_IdEntityQualifiedName);
		String extendsLitteral = " extends IdEntity ";
		String implementsLitteral = "";
		List superClasses = uml2Class.getSuperClasses();
		if (superClasses.iterator().hasNext()) {
			Class superClass = (Class) superClasses.iterator().next();
			String superClassQualifiedName = NameHelper
					.getQualifiedName(superClass);
			if (extendsLitteral.equals(""))
				extendsLitteral = " extends "
						+ ImportHelper.getImportedName(superClassQualifiedName);
			else
				extendsLitteral = implementsLitteral
						+ ","
						+ ImportHelper.getImportManager().getImportedName(
								superClassQualifiedName);
		}
		if (!uml2Class.getSuperClasses().iterator().hasNext()) {
			ImportHelper.getImportedName("java.io.Serializable");
			implementsLitteral = " implements Serializable";
		}
		List interfaces = uml2Class.getInterfaceRealizations();// TODO
		// .getImplementedInterfaces();
		for (Iterator it = interfaces.iterator(); it.hasNext();) {
			Interface itf = (Interface) it.next();
			String itfQualifiedName = NameHelper.getQualifiedName(itf);
			if (implementsLitteral.equals(""))
				if (extendsLitteral.equals(""))
					implementsLitteral = " implements "
							+ ImportHelper.getImportedName(itfQualifiedName);
				else
					implementsLitteral = ", implements "
							+ ImportHelper.getImportedName(itfQualifiedName);
			else
				implementsLitteral = implementsLitteral + ","
						+ ImportHelper.getImportedName(itfQualifiedName);
		}
		return extendsLitteral + implementsLitteral;
	}
	
	public static String getExtends(Class uml2Class, String suffix) {
		String extendsLiteral = "";
		List superClasses = uml2Class.getSuperClasses();
		if (superClasses.iterator().hasNext()) {
			Class superClass = (Class) superClasses.iterator().next();
			extendsLiteral = "extends "
					+ ImportHelper.getImportedName(superClass) + suffix;
		}
		return extendsLiteral;
	}

	public static String getAbstract(Class uml2Class) {
		// List superClasses = uml2Class.getSuperClasses();
		// if (superClasses.iterator().hasNext() || uml2Class.isAbstract()) {
		// return "abstract ";
		// }
		return "";
	}

	public static boolean hasSuperClass(Class uml2Class) {
		List superClasses = uml2Class.getSuperClasses();
		return superClasses.iterator().hasNext();
	}

	public static Iterator<Property> getCompositionParents(Class element) {
		List<Property> list = new ArrayList<Property>();
		Iterator i = element.getAllAttributes().iterator();
		while (i.hasNext()) {
			Property p = (Property) i.next();
			if (p.getAssociation() != null && p.getOpposite() != null
					&& p.getOpposite().isComposite()) {
				list.add(p);
			}
		}
		return list.iterator();
	}

	public static boolean hasProperty(Class element, String name) {
		Iterator i = element.getAllAttributes().iterator();
		while (i.hasNext()) {
			Property p = (Property) i.next();
			if (name.equals(p.getName())) {
				return true;
			}
		}
		return false;
	}

	public static boolean hasNameProperty(Class entity) {
		return hasPropertyNamed(entity, "name");
	}

	public static boolean hasPropertyNamed(Class entity, String name) {
		EList<Property> list = entity.getAllAttributes();
		for (Property property : list) {
			if (name.equals(property.getName())) {
				return true;
			}
		}
		return false;
	}
	
	public static Iterator<Actor> getActors(Model model) {
		Set<Actor> set = new HashSet<Actor>();
		for (Iterator i = model.getMembers().iterator(); i.hasNext();) {
			NamedElement element = (NamedElement) i.next();
			collectActor(element, set);
		}
		List<Actor> list = new ArrayList<Actor>(set);
		Collections.sort(list, new Comparator<Actor>() {
			public int compare(Actor lh, Actor rh) {
				return lh.getName().compareTo(rh.getName());
			}
		});
		return list.iterator();
	}

	static protected void collectActor(NamedElement element, Set<Actor> list) {
		if (element instanceof Package) {
			for (Iterator i = ((Package) element).getMembers().iterator(); i
					.hasNext();) {
				NamedElement ne = (NamedElement) i.next();
				collectActor(ne, list);
			}
		}
		if (element instanceof Actor) {
			list.add((Actor) element);
		}
	}

	static public int getSimplePropertiesCount(Class element) {
		return getAllSimplePropertiesList(element, new ArrayList<Property>())
				.size();
	}

	static public boolean hasOneToManyParent(Class element) {
		Iterator i = element.getOwnedAttributes().iterator();
		while (i.hasNext()) {
			Property p = (Property) i.next();
			if (isManyToOne(p)
					&& p.getOpposite() != null
					&& (p.getOpposite().isComposite() || isShared(p
							.getOpposite()))) {
				return true;
			}
		}
		return false;
	}

	static public boolean hasOneToOneParent(Class element) {
		Iterator i = element.getOwnedAttributes().iterator();
		while (i.hasNext()) {
			Property p = (Property) i.next();
			if (isOneToOne(p) && !isSource(p)) {
				return true;
			}
		}
		return false;
	}

	static public int getPropertyCount(Class uml2Class) {
		int count = getAllSimplePropertiesList(uml2Class,
				new ArrayList<Property>()).size();
		for (Iterator<Property> i = ClassHelper
				.getAllManyToOneProperties(uml2Class); i.hasNext();) {
			Property property = i.next();
			if ((property.getOpposite() == null || !property.getOpposite()
					.isComposite())) {
				count += getAllSimplePropertiesList((Class) property.getType(),
						new ArrayList<Property>()).size();
				for (Iterator<Property> j = ClassHelper
						.getAllManyToOneProperties((Class) property.getType()); j
						.hasNext();) {
					Property property2 = j.next();
					count += getAllSimplePropertiesList(
							(Class) property2.getType(),
							new ArrayList<Property>()).size();
				}
			}
		}
		return count;
	}

	static public Boolean hasChildren(Class element) {
		Iterator<Property> i = element.getAllAttributes().iterator();
		while (i.hasNext()) {
			Property p = (Property) i.next();
			if (isOneToMany(p)) {
				return true;
			}
			if (isManyToMany(p)) {
				return true;
			}
			if (isOneToOne(p)) {
				return true;
			}
		}
		return false;
	}

	static public String printAssociations(Class element) {
		StringBuilder builder = new StringBuilder();
		Set<Class> hits = new HashSet<Class>();
		printAssociations(element, hits, "--> ", "", builder);
		return builder.toString();
	}

	static protected void printAssociations(Class element, Set<Class> hits, String tab, String pname, StringBuilder builder) {
		builder.append(tab);
		if (pname.length() > 0) {
			builder.append(pname);
			builder.append(" - ");
		}
		builder.append(element.getName());
		
//		if (hasLoop(element, hits)) {
//			builder.append(" [[LOOP]]");
//		}
		
		if (hits.contains(element)) {
			builder.append(" [hit]\n");
			return;
		}
		builder.append("\n");
		hits.add(element);
		
		Iterator<Property> o2m = getAllOneToManyProperties(element);
		while (o2m.hasNext()) {
			Property property = o2m.next();
			Class type = (Class) property.getType();
			printAssociations(type, hits, "\t" + tab, "(o2m) " + property.getName(), builder);
		}
		
		Iterator<Property> m2o = getAllManyToOneProperties(element);
		while (m2o.hasNext()) {
			Property property = m2o.next();
			if (!isMyParent(property)) {
				Class type = (Class) property.getType();
				printAssociations(type, hits, "\t" + tab, "(m2o) " + property.getName(), builder);
			}
		}
		
		Iterator<Property> m2m = getAllManyToManyProperties(element);
		while (m2m.hasNext()) {
			Property property = m2m.next();
			Class type = (Class) property.getType();
			printAssociations(type, hits, "\t" + tab, "(m2m) " + property.getName(), builder);
		}
	}
	static protected boolean hasLoop(Class element, Set<Class> hits) {
		Iterator<Property> o2m = getAllOneToManyProperties(element);
		while (o2m.hasNext()) {
			Property property = o2m.next();
			Class type = (Class) property.getType();
			if (hits.contains(type)) {
				return true;
			}
		}
		
		Iterator<Property> m2o = getAllManyToOneProperties(element);
		while (m2o.hasNext()) {
			Property property = m2o.next();
			if (!isMyParent(property)) {
				Class type = (Class) property.getType();
				if (hits.contains(type)) {
					return true;
				}
			}
		}
		
		Iterator<Property> m2m = getAllManyToManyProperties(element);
		while (m2m.hasNext()) {
			Property property = m2m.next();
			Class type = (Class) property.getType();
			if (hits.contains(type)) {
				return true;
			}
		}
		return false;
	}
	
	static public Iterator<Class> getAllNestedAssociations(Class element) {
		Set<Class> set = new HashSet<Class>();
		getAllNestedAssociations(element, set);
		List<Class> list = new ArrayList<Class>(set);
		Collections.sort(list, new Comparator<Class>() {
			public int compare(Class o1, Class o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		return list.iterator();
	}

	static protected void getAllNestedAssociations(Class element,
			Set<Class> list) {
		if (list.contains(element)) {
			// short-circuit an infinite loop
			return;
		}
		ImportHelper.addImport(element);
		list.add(element);
		List<Class> subclasses = getSubclasses(element);
		for (Class class1 : subclasses) {
			list.add(class1);
			getAllNestedAssociations(class1, list);
		}
		Iterator<Property> i = element.getAllAttributes().iterator();
		while (i.hasNext()) {
			Property p = (Property) i.next();
			if (isOneToMany(p)) {
				getAllNestedAssociations((Class) p.getType(), list);
			}
			if (isManyToMany(p)) {
				getAllNestedAssociations((Class) p.getType(), list);
			}
			if (isOneToOne(p)) {
				getAllNestedAssociations((Class) p.getType(), list);
			}
		}
	}

	static public boolean isSource(Property p) {
		Association a = p.getAssociation();
		if (a == null) {
			return false;
		}
		Property second = a.getMemberEnds().get(0);
		if (p.equals(second)) {
			return true;
		}
		return false;
	}

	public static Set<String> getUniqueProperties(Model model) {
		List<Class> classes = getClasses(model);
		Set<String> set = new TreeSet<String>();
		for (Class clazz : classes) {
			for (Iterator i = clazz.getMembers().iterator(); i.hasNext();) {
				Object next = i.next();
				if (next instanceof StateMachine) {
					continue;
				}
				Property property = (Property) next;
				String value = property.getName();
				if (StereotypeHelper.isStereotypeApplied(property,
						StereotypeHelper.COLUMN)) {
					value = value
							+ " - "
							+ StereotypeHelper.getValue(property,
									StereotypeHelper.COLUMN, "name");
				}
				set.add(value);// + " : " + property.getType().getName());
			}
		}
		return set;
	}

	public static Set<String> getWords(Model model) {
		Set<String> set = new TreeSet<String>();
		List<Class> classes = getClasses(model);
		for (Class clazz : classes) {
			String name = clazz.getName();
			List<String> parts = NameHelper.parseName(name, '_');
			for (String part : parts) {
				set.add(part);
			}
			for (Iterator i = clazz.getMembers().iterator(); i.hasNext();) {
				Property property = (Property) i.next();
				name = property.getName();
				parts = NameHelper.parseName(name, '_');
				for (String part : parts) {
					set.add(part);
				}
			}
		}
		return set;
	}

	public static String getTableName(Class element) {
		if (StereotypeHelper.isStereotypeApplied(element,
				StereotypeHelper.TABLE)) {
			Stereotype stereotype = StereotypeHelper.getStereotype(element,
					StereotypeHelper.TABLE);
			return element.getValue(stereotype, "name").toString();
		} else {
			return element.getName();
		}
	}

	public static String getColumnName(Property element) {
		if (StereotypeHelper.isStereotypeApplied(element,
				StereotypeHelper.COLUMN)) {
			Stereotype stereotype = StereotypeHelper.getStereotype(element,
					StereotypeHelper.COLUMN);
			Object value = element.getValue(stereotype, "name");
			if (value != null) {
				return element.getValue(stereotype, "name").toString();
			} else {
				return element.getName();
			}
		} else {
			if (StereotypeHelper.isStereotypeApplied(element,
					StereotypeHelper.M2O)) {
				return element.getName() + "_id";
			} else {
				return element.getName();
			}
		}
	}

	public static String getColumnNames(Class element) {
		StringBuilder builder = new StringBuilder();
		for (Iterator<Property> i = ClassHelper.getAllSimpleProperties(element); i
				.hasNext();) {
			Property property = i.next();
			builder.append("|*");
			builder.append(getColumnName(property));
			builder.append("*");
		}
		for (Iterator<Property> i = ClassHelper
				.getAllManyToOneProperties(element); i.hasNext();) {
			Property property = i.next();
			builder.append("|*");
			builder.append(getColumnName(property));
			builder.append("*");
		}
		builder.append("|");
		return builder.toString();
	}

	public static String getColumns(Class element) {
		StringBuilder builder = new StringBuilder();
		for (Iterator<Property> i = ClassHelper.getAllSimpleProperties(element); i
				.hasNext();) {
			Property property = i.next();
			builder.append("|");
			if (property.getDefault() != null) {
				builder.append(property.getDefault());
			}
		}
		for (Iterator<Property> i = ClassHelper
				.getAllManyToOneProperties(element); i.hasNext();) {
			Property property = i.next();
			builder.append("|");
			if (property.getDefault() != null) {
				builder.append(property.getDefault());
			}
		}
		builder.append("|");
		return builder.toString();
	}

	static public Iterator<Property> getEnumerations(Class element) {
		return getEnumerationsList(element, new ArrayList<Property>())
				.iterator();
	}

	static public Iterator<Property> getOwnedEnumerations(Class element) {
		return getEnumerations(element, new ArrayList<Property>()).iterator();
	}

	static protected List<Property> getEnumerations(Class element,
			List<Property> list) {
		Iterator i = element.getOwnedAttributes().iterator();
		while (i.hasNext()) {
			Property p = (Property) i.next();
			if (EnumerationHelper.isEnumeration(p)) {
				list.add(p);
			}
		}
		return list;
	}

	static protected List<Property> getEnumerationsList(Class element,
			List<Property> list) {
		List<Class> supers = element.getSuperClasses();
		for (Class parent : supers) {
			getEnumerationsList(parent, list);
		}
		getEnumerations(element, list);
		return list;
	}

	static public Iterator<Property> getManyToOneFilter(Class element,
			Property m2o) {
		List<Property> list = new ArrayList<Property>();
		Iterator i = element.getAllAttributes().iterator();
		while (i.hasNext()) {
			Property p = (Property) i.next();
			if (isManyToOne(p) && !m2o.equals(p)
					&& !p.getType().equals(element)) { //  
				Class t = (Class) m2o.getType();
				Iterator j = t.getAllAttributes().iterator();
				while (j.hasNext()) {
					Property p2 = (Property) j.next();
					if (p2.getType().equals(p.getType())) {
						list.add(p);
						continue;
					}
				}
			}
		}
		return list.iterator();
	}
	
	public static List<Association> getOneToManyAssociations(Package model) {
		return getAssociations(model, false, true);
	}
	
	public static List<Association> getManyToOneAssociations(Package model) {
		return getAssociations(model, true, false);
	}
	
	public static List<Association> getManyToManyAssociations(Package model) {
		return getAssociations(model, false, false);
	}
	
	public static List<Association> getOneToOneAssociations(Package model) {
		return getAssociations(model, true, true);
	}

	public static List<Association> getAssociations(Package model, boolean firstMulti, boolean secondMulti) {
		List<Association> list = new ArrayList<Association>();
		List<Association> all = getAssociations(model);
		for (Association association : all) {
			if (checkCardinality(association, firstMulti, secondMulti)) {
				list.add(association);
			}
		}
		return list;
	}
	
	public static List<Association> getAssociations(Package model) {
		List<Association> list = new ArrayList<Association>();
		for (Iterator i = model.getMembers().iterator(); i.hasNext();) {
			NamedElement element = (NamedElement) i.next();
			collectAssociations(element, list);
		}
		Collections.sort(list, new Comparator<Association>() {
			public int compare(Association lh, Association rh) {
				if (((NamedElement) lh.getMemberEnds().get(0).getOwner())
						.getName() == null) {
					throw new RuntimeException("Missing Name: " + lh.getMemberEnds().get(0).getOwner());
				}
				if (((NamedElement) rh.getMemberEnds().get(0)
						.getOwner()).getName() == null) {
					throw new RuntimeException("Missing Owner: " + rh.getMemberEnds().get(0));
				}
				return ((NamedElement) lh.getMemberEnds().get(0).getOwner())
						.getName().compareTo(
								((NamedElement) rh.getMemberEnds().get(0)
										.getOwner()).getName());
			}
		});
		return list;
	}

	static protected void collectAssociations(NamedElement element,
			List<Association> list) {
		// TODO ignore use case associations
		if (element instanceof Package) {
			for (Iterator i = ((Package) element).getMembers().iterator(); i
					.hasNext();) {
				NamedElement ne = (NamedElement) i.next();
				collectAssociations(ne, list);
			}
		}
		if (element instanceof Association) {
			list.add((Association) element);
		}
	}
	
	//---------------------------------------------------------------
	// status flow related
	//---------------------------------------------------------------
	
	public static Region getRegion(Class element) {
		List<Region> list = new ArrayList<Region>();
		for (Iterator<Behavior> i = element.getOwnedBehaviors().iterator(); i.hasNext();) {
			Behavior b = i.next();
//			if (b instanceof StateMachine) {
				for (Iterator<Region> j = ((StateMachine)b).getRegions().iterator(); j.hasNext();) {
					Region r = j.next();
					list.add(r);
				}
//			}
		}
		if (list.size() > 1) {
			throw new RuntimeException("Should have only 1 status machine: " + element);
		}
		if (list.size() == 0) {
			return null;
		}
		return list.get(0);
	}
	
	public static Iterator<Transition> getTransitions(Region region) {
		Set<String> names = new HashSet<String>();
		List<Transition> list = new ArrayList<Transition>();
		for (Iterator<Transition> i = region.getTransitions().iterator(); i.hasNext();) {
			Transition t = i.next();
			if (t.getName() != null && t.getName().length() > 0 && !names.contains(t.getName())) {
				list.add(t);
				names.add(t.getName());
			}
		}
		return list.iterator();
	}
	
	public static Iterator<State> getStates(Region region) {
		List<State> list = new ArrayList<State>();
		for (Iterator i = region.getSubvertices().iterator(); i.hasNext();) {
			Object state = i.next();
			if (state instanceof State && ((State)state).getName() != null) {
				list.add((State) state);
			}
		}
		return list.iterator();
	}
	
	public static Iterator<Transition> getTransitions(State state) {
		List<Transition> list = new ArrayList<Transition>();
		for (Iterator<Transition> i = state.getOutgoings().iterator(); i.hasNext();) {
			Transition t = i.next();
			if (t.getName() != null) {
				list.add(t);
			}
		}
		return list.iterator();
	}
}
