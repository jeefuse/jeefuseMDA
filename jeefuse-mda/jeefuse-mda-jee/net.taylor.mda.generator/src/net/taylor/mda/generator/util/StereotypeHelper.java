package net.taylor.mda.generator.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;

public class StereotypeHelper {

	public static final String ENTITY = "javax.persistence.Entity";

	public static final String EMBEDDABLE = "javax.persistence.Embeddable";

	public static final String TABLE = "javax.persistence.Table";

	public static final String GENERATED_VALUE = "javax.persistence.GeneratedValue";
	
	public static final String annotations_GenericGenerator="org.hibernate.annotations.GenericGenerator";

	public static final String ID = "javax.persistence.Id";

	public static final String VERSION = "javax.persistence.Version";

	public static final String TEMPORAL = "javax.persistence.Temporal";

	public static final String COLUMN = "javax.persistence.Column";
	
	public static final String JONINCOLUMN = "javax.persistence.JoinColumn";

	public static final String O2M = "javax.persistence.OneToMany";

	public static final String M2O = "javax.persistence.ManyToOne";

	public static final String O2O = "javax.persistence.OneToOne";

	public static final String M2M = "javax.persistence.ManyToMany";

	public static final String LENGTH = "org.hibernate.validator.Length";

	public static final String NOT_NULL = "org.hibernate.validator.NotNull";

	public static final String WEB_SERVICE = "javax.jws.WebService";

	public static final String WEB_CONTEXT = "org.jboss.wsf.spi.annotation.WebContext";

	public static final String ONEWAY = "javax.jws.Oneway";

	public static final String JRS_PATH = "javax.ws.rs.Path";

	public static final String JRS_GET = "javax.ws.rs.GET";

	public static Stereotype getStereotype(Element element, String name) {
		Iterator i = element.getAppliedStereotypes().iterator();
		while (i.hasNext()) {
			Stereotype stereotype = (Stereotype) i.next();
			if (name.equals(stereotype.getName())) {
				return stereotype;
			}
		}
		return null;
	}

	public static boolean isStereotypeApplied(Element element, String name) {
		Iterator i = element.getAppliedStereotypes().iterator();
		while (i.hasNext()) {
			Stereotype stereotype = (Stereotype) i.next();
			if (name.equals(stereotype.getName())) {
				return true;
			}
		}
		return false;
	}

	public static String getAnnotations(Element element) {
		return getAnnotations(element, true);
	}

	public static String getAnnotations(Element element, boolean tab) {
		StringBuffer annotations = new StringBuffer();
		Iterator i = element.getAppliedStereotypes().iterator();
		while (i.hasNext()) {
			Stereotype stereotype = (Stereotype) i.next();
			annotations.append(getAnnotation(element, stereotype));
			if (i.hasNext())
				annotations.append("\n" + (tab ? "\t" : ""));
		}
		return annotations.toString();
	}

	public static String getAnnotation(Element element, String stereotype) {
		return getAnnotation(element, getStereotype(element, stereotype));
	}

	public static String getAnnotation(Element element, Stereotype stereotype) {
		// TODO ignore blanks and defaults
		
		// TODO need to handle opposite side of OneToMany w\ManyToOne
		// if (stereotype.getName().equals("OneToMany")) throw new
		// RuntimeException(stereotype.toString());
		StringBuffer annotation = new StringBuffer();
		Iterator i = stereotype.getAllAttributes().iterator();
		boolean first = true;
		boolean end = false;
		while (i.hasNext()) {
			Property property = (Property) i.next();
			if (property.getName().startsWith("base_")) {
				continue;
			}
			if (property.getName().equals("catalog")) {
				continue;
			}
			// TODO {} many
			// TODO get the right role for mappedBy - mappedBy =
			// "<%=UML2GenerationHelper.uncapSafeName(uml2Class)%>"
			// if (element.getName().equals("mappedBy")) throw new
			// RuntimeException(element.toString());
			Object value = null;
			try {
				value = element.getValue(stereotype, property.getName());
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			}
			if (value != null) {
				if (value instanceof Collection) {
					Iterator j = ((Collection) value).iterator();
					String list = "{";
					while (j.hasNext()) {
						Object next = j.next();
						if (next instanceof org.eclipse.emf.ecore.impl.DynamicEObjectImpl) {
							list += getAnnotation(
									(org.eclipse.emf.ecore.impl.DynamicEObjectImpl) next,
									element);
						} else if (next instanceof NamedElement) {
							list += "\"";
							list += ((NamedElement) next).getName();
							list += "\"";
						} else {
							list += next;
						}
						if (j.hasNext()) {
							list += ", ";
						}
					}
					list += "}";
					value = list;
					// throw new RuntimeException(stereotype.toString());
				} else if (value instanceof String) {
					if (((String) value).length() == 0)
						continue;
					if (!((String) value).endsWith(".class")
							&& !(((String) value).startsWith("{") && ((String) value)
									.endsWith("}"))) { // TODO ???
						value = "\"" + value + "\"";
					}
				} else if (value instanceof EnumerationLiteral) {
					EnumerationLiteral literal = (EnumerationLiteral) value;
					value = ImportHelper.getImportedName(((Enumeration) literal
							.eContainer()).getName())
							+ "." + literal.getName();
				}

				if (first) {
					annotation.append("(");
					first = false;
					end = true;
				} else {
					annotation.append(", ");
				}
				annotation.append(property.getName());
				annotation.append(" = ");
				annotation.append(value);
			}
		}
		if (end) {
			annotation.append(")");
		}
		return "@" + ImportHelper.getImportedName(stereotype.getName())
				+ annotation.toString();
	}

	private static NamedElement findDefinition(String nameSuffix,
			Element element) {
		org.eclipse.uml2.uml.Package pkg = element.getModel();
		EList profiles = pkg.getAppliedProfiles();
		for (Iterator iter = profiles.iterator(); iter.hasNext();) {
			Profile profile = (Profile) iter.next();
			// EList members = profile.getMembers();
			NamedElement ne = findMember(nameSuffix, profile);
			if (ne != null) {
				return ne;
			}
		}
		return null;
	}

	private static NamedElement findMember(String nameSuffix, Element element) {
		EList members = element.getOwnedElements();
		for (Iterator iter = members.iterator(); iter.hasNext();) {
			Object next = iter.next();
			if (next instanceof Stereotype
					|| next instanceof org.eclipse.uml2.uml.Class
					|| next instanceof org.eclipse.uml2.uml.Enumeration
					|| next instanceof org.eclipse.uml2.uml.EnumerationLiteral) {
				NamedElement ne = (NamedElement) next;
				if (match(ne.getName(), nameSuffix)) {
					return ne;
				} else {
					ne = findMember(nameSuffix, ne);
					if (ne != null) {
						return ne;
					}
				}
			}
		}
		return null;
	}

	private static boolean match(String l, String r) {
		l = l.replace(".", "");
		return l.equals(r);
	}

	/*
	 * @AttributeOverrides( { @AttributeOverride(name = "id", column =
	 * @Column(name = "ASSIGNEE_ID")), @AttributeOverride(name = "name", column =
	 * @Column(name = "ASSIGNEE_NAME")) })
	 */
	private static String getAnnotation(DynamicEObjectImpl impl, Element element) {
		EClass eClass = impl.eClass();
		String name = eClass.getName();
		// String label = format(capName(name), ' ');
		NamedElement definition = findDefinition(name.substring(name
				.lastIndexOf('_') + 1), element);
		return "@" + ImportHelper.getImportedName(definition.getName())
				+ getFeature(eClass, impl, element, definition);
	}

	static protected String getFeature(EClass eClass, DynamicEObjectImpl impl,
			Element element, NamedElement definition) {
		StringBuffer buffer = new StringBuffer();
		boolean first = true;
		boolean end = false;
		for (Iterator i = eClass.getEAllAttributes().iterator(); i.hasNext();) {
			EAttribute eAttribute = (EAttribute) i.next();
			Object value = impl.eGet(eAttribute);
			if (value != null) {
				if (first) {
					buffer.append("(");
					first = false;
					end = true;
				} else {
					buffer.append(", ");
				}
				buffer.append(eAttribute.getName());
				buffer.append("=");
			}
			if (value instanceof DynamicEObjectImpl) {
				buffer
						.append(getAnnotation((DynamicEObjectImpl) value,
								element));
			} else if (value instanceof Collection) {
				Iterator j = ((Collection) value).iterator();
				buffer.append("{");
				while (j.hasNext()) {
					Object next = j.next();
					if (next instanceof org.eclipse.emf.ecore.impl.DynamicEObjectImpl) {
						buffer
								.append(getAnnotation(
										(org.eclipse.emf.ecore.impl.DynamicEObjectImpl) next,
										element));
					} else if (next instanceof NamedElement) {
						buffer.append("\"");
						buffer.append(((NamedElement) next).getName());
						buffer.append("\"");
					} else if (next instanceof EEnumLiteral) {
						EEnumLiteral literal = (EEnumLiteral) next;
						String name = ((EEnum) literal.eContainer()).getName();
						NamedElement definition2 = findDefinition(name
								.substring(name.lastIndexOf('_') + 1), element);
						buffer.append(ImportHelper.getImportedName(definition2
								.getName())
								+ "." + literal.getName());
					} else if (next instanceof Boolean) {
						buffer.append(next);
					} else if (next instanceof String) {
						buffer.append("\"");
						buffer.append(next);
						buffer.append("\"");
					} else {
						buffer.append(next);
					}
					if (j.hasNext()) {
						buffer.append(", ");
					}
				}
				buffer.append("}");
			} else if (value instanceof Boolean) {
				buffer.append(value);
			} else if (value instanceof String) {
				boolean annotation = value.toString().startsWith("@");
				if (!annotation)
					buffer.append("\"");
				buffer.append(value);
				if (!annotation)
					buffer.append("\"");
			} else if (value != null) {
				buffer.append(value);
			}
		}
		for (Iterator i = eClass.getEAllReferences().iterator(); i.hasNext();) {
			EReference eReference = (EReference) i.next();
			Object value = impl.eGet(eReference);
			if (value != null) {
				if (first) {
					buffer.append("(");
					first = false;
					end = true;
				} else {
					buffer.append(", ");
				}
				buffer.append(eReference.getName());
				buffer.append("=");
				if (value instanceof org.eclipse.emf.ecore.impl.DynamicEObjectImpl) {
					buffer
							.append(getAnnotation(
									(org.eclipse.emf.ecore.impl.DynamicEObjectImpl) value,
									element));
				} else if (value instanceof NamedElement) {
					NamedElement ne = (NamedElement) value;
					buffer.append("\"");
					buffer.append(ne.getName());
					buffer.append("\"");
				} else if (value instanceof Collection) {
					Iterator j = ((Collection) value).iterator();
					buffer.append("{");
					while (j.hasNext()) {
						Object next = j.next();
						if (next instanceof org.eclipse.emf.ecore.impl.DynamicEObjectImpl) {
							buffer
									.append(getAnnotation(
											(org.eclipse.emf.ecore.impl.DynamicEObjectImpl) next,
											element));
						} else if (next instanceof NamedElement) {
							buffer.append("\"");
							buffer.append(((NamedElement) next).getName());
							buffer.append("\"");
						} else if (next instanceof Boolean) {
							buffer.append(next);
						} else if (next instanceof String) {
							buffer.append("\"");
							buffer.append(next);
							buffer.append("\"");
						} else {
							buffer.append(next);
						}
						if (j.hasNext()) {
							buffer.append(", ");
						}
					}
					buffer.append("}");
				}
			}
		}
		if (end) {
			buffer.append(")");
		}
		return buffer.toString();
	}

	static protected String capName(String name) {
		return name.length() != 0 ? name.substring(0, 1).toUpperCase()
				+ name.substring(1) : name;
	}

	static public String format(String name) {
		name = name.substring(name.lastIndexOf('_') + 1);
		String[] parts = name.split("[A-Z]");
		if (parts.length > 0 && parts[0] != null && parts[0].length() > 0) {
			return name.substring(parts[0].length());
		} else {
			return name;
		}
	}

	public static Object getValue(Element property, String stereotype,
			String attribute) {
		Stereotype s = getStereotype(property, stereotype);
		if (s == null)
			return null;
		return property.getValue(s, attribute);
	}

	public static String getValue(Element property, String stereotype,
			String attribute, String defaultValue) {
		Stereotype s = getStereotype(property, stereotype);
		if (s == null) {
			return defaultValue;
		}
		Object value = property.getValue(s, attribute);
		if (value == null) {
			return defaultValue;
		}
		return value.toString();
	}
	
	public static Iterator<Stereotype> getStereotypes(Element element) {
		List<Stereotype> list = new ArrayList<Stereotype>();
		Iterator i = element.getAppliedStereotypes().iterator();
		while (i.hasNext()) {
			Stereotype stereotype = (Stereotype) i.next();
			list.add(stereotype);
		}
		return list.iterator();
	}
	
	
	public static boolean hasStereotypes(Element element) {
		return !element.getAppliedStereotypes().isEmpty();
	}
	
	
	public static Iterator<Property> getAttributes(Stereotype stereotype) {
		List<Property> list = new ArrayList<Property>();
		Iterator i = stereotype.getAllAttributes().iterator();
		while (i.hasNext()) {
			Property property = (Property) i.next();
			if (!"base_Class".equals(property.getName())) {
				list.add(property);
			}
		}
		return list.iterator();
	}	
}
