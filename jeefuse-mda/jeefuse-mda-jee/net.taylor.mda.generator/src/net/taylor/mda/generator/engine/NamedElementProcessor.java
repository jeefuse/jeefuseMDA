package net.taylor.mda.generator.engine;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;

import net.taylor.mda.generator.Console;
import net.taylor.mda.generator.util.MavenHelper;
import net.taylor.mda.generator.util.StereotypeHelper;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;

public class NamedElementProcessor implements ElementProcessor {

	public void process(Element element, boolean all, String extension, String plugin, String suffix,
			Template template, IProgressMonitor monitor) {
		if (all) {
			processAll(element, monitor);
		}
		if (extension != null) {
			processExtension(element, extension, monitor);
		}
		if (plugin != null) {
			processPlugin(element, plugin, monitor);
		}
		if (suffix != null) {
			processSuffix(element, suffix, monitor);
		}
		if (template != null) {
			processTemplate(element, template, monitor);
		}
	}

	// --------------------------------------------------------------

	protected void processAll(Element element, IProgressMonitor monitor) {
		Map<String, Template> list = getTemplates(element);
		if (list == null)
			return;
		for (Template template : list.values()) {
			processTemplate(element, template, monitor);
		}
	}

	protected void processExtension(Element element, String extension, IProgressMonitor monitor) {
		Map<String, Template> list = getTemplates(element);
		if (list == null)
			return;
		for (Template template : list.values()) {
			// extension only
			if (!template.outputPattern.endsWith("." + extension)) {
				continue;
			}

			// TODO skip if demand only

			processTemplate(element, template, monitor);
		}
	}

	protected void processPlugin(Element element, String plugin, IProgressMonitor monitor) {
		Map<String, Template> list = getTemplates(element);
		if (list == null)
			return;
		for (Template template : list.values()) {
			// plugin only
			if (!plugin.equals(template.plugin)) {
				continue;
			}

			processTemplate(element, template, monitor);
		}
	}

	protected void processSuffix(Element element, String suffix, IProgressMonitor monitor) {
		Map<String, Template> list = getTemplates(element);
		if (list == null)
			return;
		for (Template template : list.values()) {
			// skip if not right suffix
			if (!suffix.equals(template.projectSuffix)) {
				continue;
			}

			processTemplate(element, template, monitor);
		}
	}

	protected Map<String, Template> getTemplates(Element element) {
		String className = element.getClass().getName();
		return Templates.getTemplates().get(className);
	}

	// --------------------------------------------------------------

	protected void processTemplate(Element element, Template template, IProgressMonitor monitor) {
		// double check the types match
		if (!element.getClass().getName().equals(template.modelElement)) {
			return;
		}
		if (!MavenHelper.isPluginIncluded(element, template.plugin)) {
			return;
		}
		// skip if not right stereotype
		if (!matchesStereotype(element, template)) {
			return;
		}

		// do the work
		TemplateProcessor processor = Engine.getTemplateProcessor(template);
		try {
			// log to console
			Console.getStream().print(
					((NamedElement) element).getQualifiedName() + " : " + template.plugin + template.path);
			processor.generate(element, template, monitor);
		} catch (Exception e) {
			// log to console
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			Console.getStream().println(sw.toString());
		}
	}

	/**
	 * Determine if the element has all of the specified stereotypes. Comma
	 * delimited. A stereotype can be prefixed with ! if it should NOT be
	 * applied.
	 * 
	 * If the element is a package then see containsStereotype.
	 */
	public static boolean matchesStereotype(Element element, Template template) {
		if (template.hasStereotype != null && template.hasStereotype.length() > 0) {

			boolean applies = true;
			// AND conditions
			String[] stereotypes = template.hasStereotype.split(",");
			for (String commaStereTypes : stereotypes) {
				String[] joinStereTypes = commaStereTypes.split("\\|");
				if(!hasMatchStereotype(joinStereTypes,element)){
					applies=false;
					break;
				}
			}
			if (applies) {
				// good enough
				return true;
			} else if (element instanceof Package) {
				// check for at least one below this package/model element
				return containsStereotype((Package) element, stereotypes);
			} else {
				// does not apply
				return false;
			}
		}
		// no stereotype means yes
		return true;
	}

	protected static boolean hasMatchStereotype(String[] joinStereTypes, Element element) {
		for (String stereotype : joinStereTypes) {
			if (stereotype.startsWith("!")) {
				if (!StereotypeHelper.isStereotypeApplied(element, stereotype.substring(1))) {
					return true;
				}
			} else {
				if (StereotypeHelper.isStereotypeApplied(element, stereotype)) {
					// SHOULD have this stereotype
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Determine if any element under this package has one of these stereotypes
	 * applied.
	 */
	protected static boolean containsStereotype(Package pkg, String[] stereotypes) {
		List<NamedElement> members = pkg.getMembers();
		for (NamedElement namedElement : members) {
			for (String stereotype : stereotypes) {
				// ignore the NOTs
				if (!stereotype.startsWith("!")) {
					if (StereotypeHelper.isStereotypeApplied(namedElement, stereotype)) {
						// found one!
						return true;
					}
				}
			}
			// recurse
			if (namedElement instanceof Package) {
				if (containsStereotype((Package) namedElement, stereotypes)) {
					// must have found one! otherwise continue on...
					return true;
				}
			}
		}
		return false;
	}
}
