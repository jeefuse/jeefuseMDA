package net.taylor.mda.generator.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import net.taylor.mda.generator.Console;
import net.taylor.mda.generator.GeneratorPlugin;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ui.console.MessageConsoleStream;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;

public class InterfaceHelper {

	public static String getDeclaringName(Operation operation) {
		String qn = operation.getQualifiedName();
		qn = qn.replaceAll("::", ".");
		return qn.substring(qn.indexOf(".") + 1, qn.lastIndexOf("."));
	}

	public static String getParameterType(Parameter parameter) {
		String qn = parameter.getType().getQualifiedName();
		qn = qn.replaceAll("::", ".");
		return qn.substring(qn.indexOf(".") + 1);
	}

	public static String getExtendsLitteral(Interface uml2Interface) {
		String extendsLitteral = "";
		List generalizations = uml2Interface.getGeneralizations();
		for (Iterator iter = generalizations.iterator(); iter.hasNext();) {
			Generalization generalization = (Generalization) iter.next();
			Classifier general = generalization.getGeneral();
			if (general instanceof Interface) {
				Interface itf = (Interface) general;
				String itfQualifiedName = NameHelper.getQualifiedName(itf);
				if (extendsLitteral.equals(""))
					extendsLitteral = " implements "
							+ ImportHelper.getImportManager().getImportedName(
									itfQualifiedName);
				else
					extendsLitteral = extendsLitteral
							+ ","
							+ ImportHelper.getImportManager().getImportedName(
									itfQualifiedName);
			}

		}
		return extendsLitteral;
	}

	public static String getRuntimeParameters(Operation operation) {
		StringBuffer buffer = new StringBuffer();
		for (Iterator j = operation.getOwnedParameters().iterator(); j
				.hasNext();) {
			Parameter parameter = (Parameter) j.next();
			if (parameter.getDirection() == ParameterDirectionKind.IN_LITERAL) {
				if (buffer.length() > 0) {
					buffer.append(", ");
				}
				buffer.append(NameHelper.uncapSafeName(parameter));
			}
		}
		return buffer.toString();
	}

	public static String getParameters(Operation operation) {
		return getParameters(operation, true, true);
	}

	public static String getReturn(Operation operation) {
		for (Iterator iter = operation.getOwnedParameters().iterator(); iter
				.hasNext();) {
			Parameter parameter = (Parameter) iter.next();
			if (parameter.getDirection().equals(
					ParameterDirectionKind.RETURN_LITERAL)) {
				// <%if (operation.getType() == null) {%>void<%} else
				// {%><%=UML2GenerationHelper.getImportedType(operation.getType())%><%}%>
				String param = TypeHelper.getImportedType(parameter.getType());
				if (parameter.isMultivalued()) {
					ImportHelper.getImportedName("java.util.List");
					return "List<" + param + ">";
				}
				return param;
			}
		}
		return "void";
	}

	public static boolean isVoid(Operation operation) {
		for (Iterator iter = operation.getOwnedParameters().iterator(); iter
				.hasNext();) {
			Parameter parameter = (Parameter) iter.next();
			if (parameter.getDirection().equals(
					ParameterDirectionKind.RETURN_LITERAL)) {
				return false;
			}
		}
		return true;
	}

	public static String getParameterType2(Parameter parameter) {
		String param = TypeHelper.getImportedType(parameter.getType());
		if (parameter.isMultivalued()) {
			ImportHelper.getImportedName("java.util.List");
			return "List<" + param + ">";
		}
		return param;
	}

	public static String getParameters(Operation operation, boolean formal,
			boolean withAnnotations) {
		StringBuffer result = new StringBuffer();
		for (Iterator iter = operation.getOwnedParameters().iterator(); iter
				.hasNext();) {
			Parameter parameter = (Parameter) iter.next();
			if (!parameter.getDirection().equals(
					ParameterDirectionKind.RETURN_LITERAL)) {
				if (result.length() > 0)
					result.append(", ");

				if (formal) {
					if (withAnnotations) {
						String annotations = StereotypeHelper
								.getAnnotations(parameter);
						if (annotations != null && annotations.length() > 0) {
							result.append(annotations);
							result.append(' ');
						}
					}
					result.append(TypeHelper.getImportedType(parameter
							.getType()));
					result.append(' ');
				}
				String paramName = parameter.getName();
				if (paramName != null && paramName.trim().length() == 0)
					paramName = null;
				result.append(paramName == null ? "arg"
						+ operation.getOwnedParameters().indexOf(parameter)
						: paramName);
			}
		}
		return result.toString();
	}

	public static String getWebParams(Operation operation) {
		StringBuffer result = new StringBuffer();
		for (Iterator iter = operation.getOwnedParameters().iterator(); iter
				.hasNext();) {
			Parameter parameter = (Parameter) iter.next();
			if (!parameter.getDirection().equals(
					ParameterDirectionKind.RETURN_LITERAL)) {
				if (result.length() > 0) {
					result.append(", ");
				}
				String paramName = parameter.getName();
				if (paramName == null || paramName.trim().length() == 0) {
					paramName = "arg"
						+ operation.getOwnedParameters().indexOf(parameter);
				}
				result.append("@WebParam(name = \"");
				result.append(paramName);
				result.append("\") ");
				
				result.append(TypeHelper.getImportedType(parameter
						.getType()));
				result.append(' ');
				result.append(paramName);
			}
		}
		return result.toString();
	}

	public static String getFirstParameterName(Operation operation) {
		for (Iterator iter = operation.getOwnedParameters().iterator(); iter
				.hasNext();) {
			Parameter parameter = (Parameter) iter.next();
			if (parameter.getDirection().equals(
					ParameterDirectionKind.IN_LITERAL)) {
				return parameter.getName();
			}
		}
		return "";
	}

	public static String getFirstParameterType(Operation operation) {
		for (Iterator iter = operation.getOwnedParameters().iterator(); iter
				.hasNext();) {
			Parameter parameter = (Parameter) iter.next();
			if (parameter.getDirection().equals(
					ParameterDirectionKind.IN_LITERAL)) {
				return TypeHelper.getImportedType(parameter.getType());
			}
		}
		return "";
	}

	public static String getParameterName(Operation operation, int arg) {
		int count = 0;
		for (Iterator iter = operation.getOwnedParameters().iterator(); iter
				.hasNext();) {
			Parameter parameter = (Parameter) iter.next();
			if (parameter.getDirection().equals(
					ParameterDirectionKind.IN_LITERAL)
					&& count == arg) {
				return parameter.getName();
			}
			if (parameter.getDirection().equals(
					ParameterDirectionKind.IN_LITERAL)) {
				count++;
			}
		}
		return "";
	}

	public static String getParameterType(Operation operation, int arg) {
		int count = 0;
		for (Iterator iter = operation.getOwnedParameters().iterator(); iter
				.hasNext();) {
			Parameter parameter = (Parameter) iter.next();
			if (parameter.getDirection().equals(
					ParameterDirectionKind.IN_LITERAL)
					&& count == arg) {
				return TypeHelper.getImportedType(parameter.getType());
			}
			if (parameter.getDirection().equals(
					ParameterDirectionKind.IN_LITERAL)) {
				count++;
			}
		}
		return "";
	}

	public static List<Interface> getInterfaces(Package model) {
		List<Interface> list = new ArrayList<Interface>();
		for (Iterator i = model.getMembers().iterator(); i.hasNext();) {
			NamedElement element = (NamedElement) i.next();
			collectInterface(element, list, false);
		}
		Collections.sort(list, new Comparator<NamedElement>() {
			public int compare(NamedElement lh, NamedElement rh) {
				return lh.getName().compareTo(rh.getName());
			}
		});
		return list;
	}

	public static List<Interface> getWebServices(Model model) {
		List<Interface> list = new ArrayList<Interface>();
		for (Iterator i = model.getMembers().iterator(); i.hasNext();) {
			NamedElement element = (NamedElement) i.next();
			collectInterface(element, list, true);
		}
		return list;
	}

	static protected void collectInterface(NamedElement element,
			List<Interface> list, boolean webserviceOnly) {
		if (element instanceof Package) {
			for (Iterator i = ((Package) element).getMembers().iterator(); i
					.hasNext();) {
				NamedElement ne = (NamedElement) i.next();
				collectInterface(ne, list, webserviceOnly);
			}
		}
		if (element instanceof Interface
				&& (!webserviceOnly || StereotypeHelper.isStereotypeApplied(
						element, StereotypeHelper.WEB_SERVICE))) {
			list.add((Interface) element);
		}
	}

	public static String getDependencyType(Dependency dependency) {
		if (dependency.getSuppliers() == null)
			return null;
		Interface supplier = (Interface) dependency.getSuppliers().get(0);
		ImportHelper.addImport(supplier);
		String suffix = "";
		if (!StereotypeHelper.isStereotypeApplied(supplier,
				"org.jboss.seam.annotation.Name")
				&& !StereotypeHelper.isStereotypeApplied(supplier,
						"org.jboss.annotation.ejb.Service")) {
			suffix = "Local";
			ImportHelper.addImport(supplier, suffix);
		}
		return supplier.getName() + suffix;
	}

	public static String getDependencyName(Dependency dependency) {
		if (dependency.getSuppliers() == null)
			return null;
		Interface supplier = (Interface) dependency.getSuppliers().get(0);
		String name = dependency.getName();
		if (name != null && !name.contains("<") && !name.contains(">")) {
			return name;
		}
		return NameHelper.uncapSafeName(supplier);
	}

	public static Interface getDependency(Dependency dependency) {
		if (dependency.getSuppliers() == null)
			return null;
		return (Interface) dependency.getSuppliers().get(0);
	}
	
	public static String getDelegateType(Interface uml2Interface, boolean qualified) {
		Interface delegate = getDelegate(uml2Interface);
		if (qualified) {
			return NameHelper.getQualifiedName(delegate);
		} else {
			return NameHelper.getCapName(delegate);
		}
	}
	
	public static String getDelegateName(Interface uml2Interface) {
		Interface delegate = getDelegate(uml2Interface);
		String serviceName = NameHelper.getUncapName(delegate);
		return serviceName;
	}
	
	public static Interface getDelegate(Interface uml2Interface) {
		EList<Dependency> dependencies = uml2Interface.getClientDependencies();
		if (dependencies.size() == 0) {
			log("No dependency defined for: "
					+ uml2Interface.getQualifiedName());
			return uml2Interface;
		} else {
			if (dependencies.size() > 1) {
				log("More then one dependency defined for: "
						+ uml2Interface.getQualifiedName());
			}
			Dependency dependency = dependencies.get(0);
			if (dependency.getSuppliers() != null) {
				return (Interface) dependency.getSuppliers().get(0);
			} else {
				log("Dependency has no Supplier defined for: "
						+ uml2Interface.getQualifiedName());
				return uml2Interface;
			}
		}
	}

	private static void log(String msg) {
		try {
			MessageConsoleStream stream = Console.getStream();
			if (stream != null) {
				stream.println(msg);
			}
		} catch (Exception e) {			
		}
		GeneratorPlugin plugin = GeneratorPlugin.getDefault();
		if (plugin != null) {
			plugin.log(msg);
		}
	}
}
