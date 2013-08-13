package net.taylor.mda.reverse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.taylor.mda.generator.util.StereotypeHelper;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;

public class ModelReverseEngineer extends ReverseEngineer {

	protected Model createModel(String name, URI uri) {
		Model model = UMLFactory.eINSTANCE.createModel();
		model.setName(name);
		Resource resource = RESOURCE_SET.createResource(uri);
		resource.getContents().add(model);

		List<String> profiles = getProfiles();
		for (String string : profiles) {
			out("importing profile: " + string);
			importProfile(model, string);
		}

		out("Model '" + model.getQualifiedName() + "' created.");

		return model;
	}

	protected List<String> getProfiles() {
		List<String> profiles = new ArrayList<String>();
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		if (registry == null)
			return profiles;

		IExtensionPoint point = registry.getExtensionPoint("net.taylor.mda.profiles.profiles");
		if (point == null)
			throw new RuntimeException("No profiles defined");
		IExtension[] extensions = point.getExtensions();
		for (int i = 0; i < extensions.length; i++) {
			IConfigurationElement[] ce = extensions[i].getConfigurationElements();
			for (int j = 0; j < ce.length; j++) {
				profiles.add(ce[j].getAttribute("id"));
			}
		}
		return profiles;
	}

	protected Package createPackage(Package nestingPackage, String name) {
		Package package_ = null;
		package_ = nestingPackage.getNestedPackage(name);
		if (null != package_) {
			out("Package '" + package_.getQualifiedName() + "' has been exist.use it");
			return package_;
		}
		package_ = nestingPackage.createNestedPackage(name);

		out("Package '" + package_.getQualifiedName() + "' created.");

		return package_;
	}

	protected PrimitiveType createPrimitiveType(Package package_, String name) {
		PrimitiveType primitiveType = (PrimitiveType) package_.createOwnedPrimitiveType(name);

		out("Primitive type '" + primitiveType.getQualifiedName() + "' created.");

		return primitiveType;
	}

	protected Enumeration createEnumeration(Package package_, String name) {
		Enumeration enumeration = (Enumeration) package_.createOwnedEnumeration(name);

		out("Enumeration '" + enumeration.getQualifiedName() + "' created.");

		return enumeration;
	}

	protected EnumerationLiteral createEnumerationLiteral(Enumeration enumeration, String name) {
		EnumerationLiteral enumerationLiteral = enumeration.createOwnedLiteral(name);

		out("Enumeration literal '" + enumerationLiteral.getQualifiedName() + "' created.");

		return enumerationLiteral;
	}

	protected org.eclipse.uml2.uml.Class createClass(Package package_, String name, boolean isAbstract) {
		Type type = package_.getOwnedType(name);
		if (null != type) {
			if (type instanceof org.eclipse.uml2.uml.Class) {
				org.eclipse.uml2.uml.Class class_ = (org.eclipse.uml2.uml.Class) type;
				return class_;
			}

		}
		// if(null!=type){
		// type.destroy();
		// }
		org.eclipse.uml2.uml.Class class_ = package_.createOwnedClass(name, isAbstract);

		out("Class '" + class_.getQualifiedName() + "' created.");

		return class_;
	}

	protected org.eclipse.uml2.uml.Interface createInterface(Package package_, String name, boolean isAbstract) {
		org.eclipse.uml2.uml.Interface class_ = package_.createOwnedInterface(name);

		out("Interface '" + class_.getQualifiedName() + "' created.");

		return class_;
	}

	protected org.eclipse.uml2.uml.Operation createOperation(org.eclipse.uml2.uml.Interface service, String name) {
		org.eclipse.uml2.uml.Operation op = service.createOwnedOperation(name, null, null, null);

		out("Operation '" + op.getQualifiedName() + "' created.");

		return op;
	}

	protected Generalization createGeneralization(Classifier specificClassifier, Classifier generalClassifier) {
		Generalization generalization = specificClassifier.createGeneralization(generalClassifier);

		out("Generalization " + specificClassifier.getQualifiedName() + " ->> " + generalClassifier.getQualifiedName()
				+ " created.");

		return generalization;
	}

	protected Property createAttribute(org.eclipse.uml2.uml.Class class_, String name, Type type, int lowerBound,
			int upperBound) {
		Property property=class_.getOwnedAttribute(name, type);
		if(null!=property){
			return property;
		}
		Property attribute = class_.createOwnedAttribute(name, type, lowerBound, upperBound);

		StringBuffer sb = new StringBuffer();

		sb.append("Attribute '");

		sb.append(attribute.getQualifiedName());

		sb.append("' : ");

		sb.append(type.getQualifiedName());

		sb.append(" [");
		sb.append(lowerBound);
		sb.append("..");
		sb.append(-1 == upperBound ? "*" : String.valueOf(upperBound));
		sb.append("]");

		sb.append(" created.");

		out(sb.toString());

		return attribute;
	}

	protected Association createAssociation(Type type1, boolean end1IsNavigable, AggregationKind end1Aggregation,
			String end1Name, int end1LowerBound, int end1UpperBound, Type type2, boolean end2IsNavigable,
			AggregationKind end2Aggregation, String end2Name, int end2LowerBound, int end2UpperBound) {
//		List<Association> associations = type1.getAssociations();
//		for(Association association:associations){
//		}
		Association association = type1.createAssociation(end1IsNavigable, end1Aggregation, end1Name, end1LowerBound,
				end1UpperBound, type2, end2IsNavigable, end2Aggregation, end2Name, end2LowerBound, end2UpperBound);
		StringBuffer sb = new StringBuffer();

		sb.append("Association ");

		if (null == end1Name || 0 == end1Name.length()) {
			sb.append('{');
			sb.append(type1.getQualifiedName());
			sb.append('}');
		} else {
			sb.append("'");
			sb.append(type1.getQualifiedName());
			sb.append(NamedElement.SEPARATOR);
			sb.append(end1Name);
			sb.append("'");
		}

		sb.append(" [");
		sb.append(end1LowerBound);
		sb.append("..");
		sb.append(-1 == end1UpperBound ? "*" : String.valueOf(end1UpperBound));
		sb.append("] ");

		sb.append(end2IsNavigable ? '<' : '-');
		sb.append('-');
		sb.append(end1IsNavigable ? '>' : '-');
		sb.append(' ');

		if (null == end2Name || 0 == end2Name.length()) {
			sb.append('{');
			sb.append(type2.getQualifiedName());
			sb.append('}');
		} else {
			sb.append("'");
			sb.append(type2.getQualifiedName());
			sb.append(NamedElement.SEPARATOR);
			sb.append(end2Name);
			sb.append("'");
		}

		sb.append(" [");
		sb.append(end2LowerBound);
		sb.append("..");
		sb.append(-1 == end2UpperBound ? "*" : String.valueOf(end2UpperBound));
		sb.append("]");

		sb.append(" created.");

		out(sb.toString());

		return association;
	}

	protected void importProfile(Package package_, String path) {
		Profile profile = (Profile) load(URI.createURI(path));
		package_.applyProfile(profile);
	}

	protected Stereotype applyStereotype(Element element, String name) {
		if (StereotypeHelper.isStereotypeApplied(element, name)) {
			return StereotypeHelper.getStereotype(element, name);
		}
		for (Iterator applicableStereotypes = element.getApplicableStereotypes().iterator(); applicableStereotypes
				.hasNext();) {

			Stereotype stereotype = (Stereotype) applicableStereotypes.next();
			// out("Applicable Stereotype: " + stereotype.getName());

			if (stereotype.getName().equals(name)) {
				out("Applied Stereotype: " + stereotype.getName());
				element.applyStereotype(stereotype);
				return stereotype;
			}
		}
		return null;
	}

	protected Stereotype getStereotype(Element element, String name) {
		for (Iterator applicableStereotypes = element.getApplicableStereotypes().iterator(); applicableStereotypes
				.hasNext();) {

			Stereotype stereotype = (Stereotype) applicableStereotypes.next();
			// out("Applicable Stereotype: " + stereotype.getName());

			if (stereotype.getName().equals(name)) {
				// out("Applied Stereotype: " + stereotype.getName());
				// element.applyStereotype(stereotype);
				return stereotype;
			}
		}
		return null;
	}
}
