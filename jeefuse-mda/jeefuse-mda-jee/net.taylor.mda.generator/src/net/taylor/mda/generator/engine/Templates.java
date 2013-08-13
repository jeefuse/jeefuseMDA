package net.taylor.mda.generator.engine;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import net.taylor.mda.generator.engine.Template.Approach;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;

/**
 * @author jgilbert
 * @version $Id: Templates.java,v 1.2 2007/08/11 23:42:02 jgilbert01 Exp $
 * 
 */
public class Templates {

	protected static IExtensionPoint getExtensionPoint() {
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		return registry.getExtensionPoint("net.taylor.mda.generator.templates");
	}

	private static Map<String, Map<String, Template>> templates = null;

	static public Map<String, Map<String, Template>> getTemplates() {
		if (templates != null)
			return templates;
		templates = new HashMap<String, Map<String, Template>>();
		IExtensionPoint point = getExtensionPoint();
		if (point == null)
			throw new RuntimeException("No templates defined");
		IExtension[] extensions = point.getExtensions();
		for (int i = 0; i < extensions.length; i++) {
			IConfigurationElement[] ce = extensions[i]
					.getConfigurationElements();
			for (int j = 0; j < ce.length; j++) {
				Template t = new Template();
				t.plugin = ce[j].getContributor().getName();
				t.id = ce[j].getAttribute("id");
				t.path = ce[j].getAttribute("path");
				t.outputPattern = ce[j].getAttribute("outputPattern");
				t.modelElement = ce[j].getAttribute("modelElement");
				t.processorClass = ce[j].getAttribute("processorClass");
				t.hasStereotype = ce[j].getAttribute("hasStereotype");
				t.ifExists = Approach.valueOf(ce[j].getAttribute("ifExists"));
				t.projectSuffix = ce[j].getAttribute("projectSuffix");

				Map<String, Template> ts = (Map<String, Template>) templates
						.get(t.modelElement);
				if (ts == null) {
					ts = new HashMap<String, Template>();
					templates.put(t.modelElement, ts);
				}
				ts.put(t.id, t);
			}
		}
		return templates;
	}

	private static Set<String> outputExtensions = null;

	public static Set<String> getExtensions() {
		if (outputExtensions != null)
			return outputExtensions;
		outputExtensions = new TreeSet<String>();
		IExtensionPoint point = getExtensionPoint();
		if (point == null) {
			return outputExtensions;
		}

		IExtension[] extensions = point.getExtensions();
		for (int i = 0; i < extensions.length; i++) {
			IConfigurationElement[] ce = extensions[i]
					.getConfigurationElements();
			for (int j = 0; j < ce.length; j++) {
				String outputPattern = ce[j].getAttribute("outputPattern");
				if (outputPattern != null && outputPattern.length() > 0) {
					int k = outputPattern.lastIndexOf(".");
					String ext = outputPattern.substring(k+1);
					outputExtensions.add(ext);
				}
			}
		}
		return outputExtensions;
	}

	private static Set<String> plugins = null;

	public static Set<String> getPlugins() {
		if (plugins != null)
			return plugins;
		plugins = new TreeSet<String>();
		IExtensionPoint point = getExtensionPoint();
		if (point == null) {
			return plugins;
		}

		IExtension[] extensions = point.getExtensions();
		for (int i = 0; i < extensions.length; i++) {
			IConfigurationElement[] ce = extensions[i]
					.getConfigurationElements();
			for (int j = 0; j < ce.length; j++) {
				String name = ce[j].getContributor().getName();
				plugins.add(name);
			}
		}
		return plugins;
	}

	private static Set<String> suffixes = null;

	public static Set<String> getSuffixes() {
		if (suffixes != null)
			return suffixes;
		suffixes = new TreeSet<String>();
		IExtensionPoint point = getExtensionPoint();
		if (point == null) {
			return suffixes;
		}

		IExtension[] extensions = point.getExtensions();
		for (int i = 0; i < extensions.length; i++) {
			IConfigurationElement[] ce = extensions[i]
					.getConfigurationElements();
			for (int j = 0; j < ce.length; j++) {
				String suffix = ce[j].getAttribute("projectSuffix");
				if (suffix != null && suffix.length() > 0) {
					suffixes.add(suffix);
				}
			}
		}
		return suffixes;
	}
}
