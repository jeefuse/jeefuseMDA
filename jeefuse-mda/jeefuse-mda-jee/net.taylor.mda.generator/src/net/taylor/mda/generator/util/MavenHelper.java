package net.taylor.mda.generator.util;

import java.util.List;
import java.util.Map;

import net.taylor.mda.generator.engine.NamedElementProcessor;
import net.taylor.mda.generator.engine.Template;
import net.taylor.mda.generator.engine.Templates;
import net.taylor.mda.generator.preferences.Preferences;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;

public class MavenHelper {

	private static final String MAVEN = "Maven";

	public static String getPackageName(Element element){
		Package parentPackage = element.getNearestPackage();
		while (parentPackage != null ) {
			parentPackage = parentPackage.getNestingPackage();
		}
		if(null==parentPackage){
			return "goolov.mda";
		}
		return parentPackage.getName();
	}
	
	public static String getModelName(Element pkg){
		String modelName="";
		if(null!=pkg.getModel()){
			modelName=pkg.getModel().getName();
		}else{
			modelName=getPackageName(pkg);
		}
		return modelName;
	}
	
	public static String getGroupId(Package pkg) {
		return getValue(pkg, "groupId",getModelName(pkg));
	}

	public static String getArtifactId(Package pkg, String suffix) {
		suffix = getSuffix(pkg, suffix);
		return getValue(pkg, "artifactId", getModelName(pkg)) + "-" + suffix;
	}

	public static String getParentId(Package pkg) {
		return getValue(pkg, "parentId", getModelName(pkg) + "-master");
	}

	public static String getName(Package pkg, String suffix) {
		return getValue(pkg, "name", NameHelper.getCapName(getModelName(pkg))) + " " + suffix;
	}

	public static String getVersion(Package pkg) {
		return getValue(pkg, "version", "1.0.0-SNAPSHOT");
	}

	public static String getPackaging(Package pkg, String defaultValue) {
		return getValue(pkg, "packaging", defaultValue);
	}


	protected static String getValue(Package pkg, String attributeName, String defaultValue) {
		Object value = null;
		if (StereotypeHelper.isStereotypeApplied(pkg, MAVEN)) {
			Stereotype maven = StereotypeHelper.getStereotype(pkg, MAVEN);
			value = pkg.getValue(maven, attributeName);
		}
		if (value == null){
			value = defaultValue;
		}
		return value.toString();
	}

	public static Object getMavenAttribute(Package pkg, String attribute) {
		if (StereotypeHelper.isStereotypeApplied(pkg, MAVEN)) {
			Stereotype maven = StereotypeHelper.getStereotype(pkg, MAVEN);
			return pkg.getValue(maven, attribute);
		} else {
			if (pkg.getOwner() != null && pkg.getOwner() instanceof Package) {
				return getMavenAttribute((Package) pkg.getOwner(), attribute);
			} else {
				return null;
			}
		}
	}

	public static String getOutputPattern(NamedElement element,
			Template template) {
		List<DynamicEObjectImpl> overrides = (List<DynamicEObjectImpl>) MavenHelper
				.getMavenAttribute(element.getNearestPackage(),
						"outputPatternOverrides");
		if (overrides != null) {
			for (DynamicEObjectImpl override : overrides) {
				EStructuralFeature feature = override.eClass()
						.getEStructuralFeature("source");
				Object source = override.eGet(feature);
				if (template.outputPattern.contains(source.toString())) {
					EStructuralFeature feature2 = override.eClass()
							.getEStructuralFeature("target");
					Object target = override.eGet(feature2);
					return template.outputPattern.replace(source.toString(),
							target.toString());
				}
			}
		}
		return template.outputPattern;
	}

	public static String getProjectName(Element element, Template template) {
		String artifactId = (String) MavenHelper.getMavenAttribute(element
				.getNearestPackage(), "artifactId");
		if (artifactId != null && artifactId.length() != 0) {
			return artifactId;
		}

		//String modelName = element.getModel().getName();
		String modelName=getModelName(element);
		if (modelName != null && modelName.length() != 0) {
			return modelName;
		}

		URI uri = element.eResource().getURI();
		return uri.segment(0);
	}

	public static String getProjectSuffix(Element element, Template template) {
		return getSuffix(element, template.projectSuffix);
	}

	public static boolean isIgnoreSkip(Element element) {
		Boolean ignoreSkip = (Boolean) MavenHelper.getMavenAttribute(element
				.getNearestPackage(), "ignoreSkip");
		if (ignoreSkip == null) ignoreSkip = false;
		return ignoreSkip || Preferences.isIgnoreSkip();
	}

	public static boolean isPluginIncluded(Element element, String plugin) {
		List<String> overrides = (List<String>) MavenHelper.getMavenAttribute(
				element.getNearestPackage(), "excludeGenerators");
		if (overrides != null) {
			for (String override : overrides) {
				if (plugin.equals(override)) {
					return false;
				}
			}
		}
		return Preferences.isPluginIncluded(plugin);
	}

	public static boolean isSuffixIncluded(Element element, String suffix) {
		// TODO is suffix active ??? nearest pkg
		// TODO
//		List<String> overrides = (List<String>) MavenHelper.getMavenAttribute(
//				element.getNearestPackage(), "excludeGenerators");
//		if (overrides != null) {
//			for (String override : overrides) {
//				if (suffix.equals(override)) {
//					return false;
//				}
//			}
//		}
		return Preferences.isSuffixIncluded(suffix);
	}

	public static String getSuffix(Element element, String suffix) {
		List<DynamicEObjectImpl> overrides = (List<DynamicEObjectImpl>) MavenHelper
				.getMavenAttribute(element.getNearestPackage(),
						"suffixOverrides");
		if (overrides != null) {
			for (DynamicEObjectImpl override : overrides) {
				EStructuralFeature feature = override.eClass()
						.getEStructuralFeature("source");
				Object source = override.eGet(feature);
				if (suffix.equals(source.toString())) {
					EStructuralFeature feature2 = override.eClass()
							.getEStructuralFeature("target");
					Object target = override.eGet(feature2);
					if (target == null) {
						return null;
					} else {
						return target.toString();
					}
				}
			}
		}
		return Preferences.getSuffix(suffix);
	}

	public static boolean isInstalled(Package pkg, String suffix) {
		boolean installed = isSuffixIncluded(pkg, suffix);
		if (installed) {
			Map<String, Template> templates = Templates.getTemplates().get(
					pkg.getClass().getName());
			if (templates != null) {
				for (Template template : templates.values()) {
					if (suffix.equals(template.projectSuffix)) {
						if (NamedElementProcessor.matchesStereotype(pkg, template)) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}
}
