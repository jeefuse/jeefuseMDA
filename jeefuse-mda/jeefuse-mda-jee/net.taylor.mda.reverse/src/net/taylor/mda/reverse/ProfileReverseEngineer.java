package net.taylor.mda.reverse;

import java.io.File;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.Extension;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.VisibilityKind;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.osgi.framework.Bundle;

public class ProfileReverseEngineer extends ModelReverseEngineer {

	private static String IGNORE_METHOD = "hashCode,toString,equals,annotationType";

	private Map<String, Enumeration> enums = new HashMap<String, Enumeration>();

	private Map<String, Package> packages = new HashMap<String, Package>();

	public InputStream createProfile(IProgressMonitor monitor, String path,
			String name) {
		try {
			registerResourceFactories();

			Bundle b = Platform.getBundle("org.eclipse.uml2.uml.resources");
			String location = b.getLocation();
			location = location.replace("reference", "jar");
			location = location + "!/";
			
			registerPathmaps(URI
					.createURI(location));
			ClassLoader cl = loadJar(path);

			out("Creating profile...");
			Profile profile = createProfile(name, URI.createURI("profiles")
					.appendSegment(name).appendFileExtension(
							UMLResource.PROFILE_FILE_EXTENSION));

			out("Creating enumerations...");
			reverse(profile, path, false, cl);

			out("Creating stereotypes...");
			reverse(profile, path, true, cl);

			out("Defining profile...");
			defineProfile(profile);

			out("Saving profile...");
			return toInputStream(profile, URI.createURI("profiles")
					.appendSegment(name).appendFileExtension(
							UMLResource.PROFILE_FILE_EXTENSION));

		} catch (Exception e) {
			err("ERROR: " + e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}
	
	protected ClassLoader loadJar(String jarPath) throws Exception {
		URL[] jars = new URL[1];
		jars[0] = new File(jarPath).toURL();
		return URLClassLoader.newInstance(jars, this.getClass()
				.getClassLoader());
	}

	public void reverse(Profile profile, String path, boolean annon,
			ClassLoader cl) throws Exception {
		// TODO create profile with name
		JarFile jar = new JarFile(path);
		// System.out.println(jar);
		java.util.Enumeration<JarEntry> e = jar.entries();// TODO loop for
		// enum first then
		// annotation
		while (e.hasMoreElements()) {
			JarEntry entry = e.nextElement();
			// System.out.println(entry.getName());
			if (!annon && entry.isDirectory()
					&& !"META-INF/".equals(entry.getName())) {
				// reversePackage(profile, entry);
			}
			if (!entry.isDirectory()
					&& !"META-INF/MANIFEST.MF".equals(entry.getName())) {
				try {
					if (entry.getName().endsWith(".class")) {
						Class clazz = Class.forName(entry.getName().replaceAll("/",
						".").replaceAll(".class", ""), true, cl);
						reverse(profile, clazz, annon);
					}
				} catch (ExceptionInInitializerError ex) {
					err("WARNING: " + ex + " loading " + entry.getName(), ex);
				} catch (ClassNotFoundException ex) {
					err("WARNING: " + ex + " loading " + entry.getName(), ex);
				} catch (NoClassDefFoundError ex) {
					err("WARNING: " + ex + " loading " + entry.getName(), ex);
				} catch (Throwable ex) {
					err("ERROR: " + ex + " loading " + entry.getName(), ex);
				}
			}
		}
	}

	public void reverse(Profile profile, Class clazz, boolean annon) {
		if (annon && clazz.isAnnotation()) {
			reverseAnnotation(profile, clazz);
		}
		if (!annon && clazz.isEnum()) {
			reverseEnum(profile, clazz);
		}
	}

	protected void reversePackage(Profile profile, JarEntry entry) {
		out(LINE);
		out("Create Package: " + entry.getName());
		StringTokenizer t = new StringTokenizer(entry.getName(), "/");
		String[] names = new String[t.countTokens()];
		int count = 0;
		while (t.hasMoreTokens()) {
			names[count++] = t.nextToken();
			out(names[count - 1]);
		}
		Package parent = profile;
		if (names.length > 1) {
			parent = packages.get(names[names.length - 2]);
		}
		Package p = createPackage(parent, names[names.length - 1]);
		packages.put(names[names.length - 1], p);
		out(LINE);
	}

	protected Package getPackage(Profile profile, Class element) {
		String name = element.getPackage().getName().substring(
				element.getPackage().getName().lastIndexOf(".") + 1);
		out("Package Name: " + name);
		Package p = packages.get(name);
		if (p == null) {
			p = profile;
		}
		return p;
	}

	private void reverseEnum(Profile profile, Class enumeration) {
		out(LINE);
		out("Create Enumeration: " + enumeration);
		Enumeration e = createEnumeration(profile, enumeration.getName());
		enums.put(enumeration.getName(), e);

		Field[] fields = enumeration.getFields();
		// System.out.println(fields);
		for (int i = 0; i < fields.length; i++) {
			out("Create Literal: " + fields[i].getName());
			createEnumerationLiteral(e, fields[i].getName());
		}
		out(LINE);
	}

	PrimitiveType booleanPrimitiveType = null;

	PrimitiveType stringPrimitiveType = null;

	PrimitiveType intPrimitiveType = null;

	private Type getType(Profile profile, Class type) {
		if ("Integer,int,Long,long,Float,float,Double,double".contains(type.getSimpleName())) {
			if (intPrimitiveType == null) {
				intPrimitiveType = importPrimitiveType(profile, "Integer");
			}
			return intPrimitiveType;
		} else if ("Boolean,boolean".contains(type.getSimpleName())) {
			if (booleanPrimitiveType == null) {
				booleanPrimitiveType = importPrimitiveType(profile, "Boolean");
			}
			return booleanPrimitiveType;
		} else if (type.isEnum()) {
			Type t = enums.get(type.getName());
			if (t == null) {
				reverseEnum(profile, type);
				t = enums.get(type.getName());
			}
			return t;
		} else {
			if (stringPrimitiveType == null) {
				stringPrimitiveType = importPrimitiveType(profile, "String");
			}
			return stringPrimitiveType;
		}
		// TODO other primitives?

	}

	private void setDefault(Property property, Method method) {
		if ("Boolean,boolean".contains(method.getReturnType().getName())) {
			property.setDefault(method.getDefaultValue().toString());
		}
	}

	private org.eclipse.uml2.uml.Class propertyMetaclass = null;

	private org.eclipse.uml2.uml.Class operationMetaclass = null;

	private org.eclipse.uml2.uml.Class interfaceMetaclass = null;

	private org.eclipse.uml2.uml.Class classMetaclass = null;

	private org.eclipse.uml2.uml.Class packageMetaclass = null;

	private org.eclipse.uml2.uml.Class parameterMetaclass = null;

	private void setMetaclass(Profile profile, Stereotype stereotype,
			Class annotation) {
		// NOTE: manually modify the model to remove any of these that you do not want
		// for example Property vs Operation and Class vs Interface
		
		if (isTarget(annotation, ElementType.FIELD)) {
			out("Extend Property");
			if (propertyMetaclass == null) {
				propertyMetaclass = referenceMetaclass(profile,
						UMLPackage.eINSTANCE.getProperty().getName());
				out("propertyMetaclass: " + propertyMetaclass);
			}
			createExtension(propertyMetaclass, stereotype, false);
		}
		if (isTarget(annotation, ElementType.METHOD)) {
			out("Extend Operation");
			if (operationMetaclass == null) {
				operationMetaclass = referenceMetaclass(profile,
						UMLPackage.eINSTANCE.getOperation().getName());
			}
			createExtension(operationMetaclass, stereotype, false);
		}
		if (isTarget(annotation, ElementType.TYPE)) {
			out("Extend Class");// TODO
			if (classMetaclass == null) {
				classMetaclass = referenceMetaclass(profile,
						UMLPackage.eINSTANCE.getClass_().getName());// "Class");
				out("classMetaclass: " + classMetaclass);
			}
			createExtension(classMetaclass, stereotype, false);
			
			if (interfaceMetaclass == null) {
				interfaceMetaclass = referenceMetaclass(profile,
						UMLPackage.eINSTANCE.getInterface().getName());
				out("interfaceMetaclass: " + interfaceMetaclass);
			}
			createExtension(interfaceMetaclass, stereotype, false);
		}
		if (isTarget(annotation, ElementType.PARAMETER)) {
			if (parameterMetaclass == null) {
				parameterMetaclass = referenceMetaclass(profile,
						UMLPackage.eINSTANCE.getParameter().getName());
				out("parameterMetaclass: " + parameterMetaclass);
			}
			createExtension(parameterMetaclass, stereotype, false);
		}
		if (isTarget(annotation, ElementType.PACKAGE)) {
			if (packageMetaclass == null) {
				packageMetaclass = referenceMetaclass(profile,
						UMLPackage.eINSTANCE.getPackage().getName());
				out("packageMetaclass: " + packageMetaclass);
			}
			createExtension(packageMetaclass, stereotype, false);
		}
	}

	private void reverseAnnotation(Profile profile, Class annotation) {
		out(LINE);
		out("Create Stereotype: " + annotation.getName() + " : "
				+ annotation.getName());
		Stereotype stereotype = createStereotype(profile, annotation.getName(),
				false);

		Field[] fields = annotation.getFields();
		// System.out.println(fields);
		for (int i = 0; i < fields.length; i++) {
			System.out.println("Field: " + fields[i].getName());
		}
		Method[] methods = annotation.getMethods();
		// System.out.println(methods);
		for (int i = 0; i < methods.length; i++) {
			String name = methods[i].getName();
			if (!IGNORE_METHOD.contains(name)) {
				out("Add Property: " + name + " of type: "
						+ methods[i].getReturnType().getName()
						+ " with default: " + methods[i].getDefaultValue());
				// TODO Enumerations
				// TODO array & list
				// TODO translate
				// TODO default value by type or definitions???
				Class returnType = methods[i].getReturnType();
				Type type = getType(profile, returnType);
				Property property = createAttribute(stereotype, name, type, 0,
						1);
				setDefault(property, methods[i]);
			}
		}

		Annotation[] annotations = annotation.getAnnotations();
		for (int i = 0; i < annotations.length; i++) {
			// System.out.println("Annotation: " + annotations[i]);//TODO double
			// check
		}

		setMetaclass(profile, stereotype, annotation);
		out(LINE);
	}

	private boolean isTarget(Class annotation, ElementType type) {
		Target target = (Target) annotation.getAnnotation(Target.class);
		if (target == null) {
			out("******************NO TARGET????");
			return false;
		}
		ElementType[] et = target.value();
		for (int i = 0; i < et.length; i++) {
			if (et[i].equals(type))
				return true;
		}
		return false;
	}

	// =====================================================================

	protected Profile createProfile(String name, URI uri) {
		Profile profile = UMLFactory.eINSTANCE.createProfile();
		profile.setName(name);
		Resource resource = RESOURCE_SET.createResource(uri);
		resource.getContents().add(profile);

		out("Profile '" + profile.getQualifiedName() + "' created.");

		return profile;
	}

	protected PrimitiveType importPrimitiveType(Package package_, String name) {
		Model uml2Library = (Model) load(URI
				.createURI(UMLResource.UML_PRIMITIVE_TYPES_LIBRARY_URI));

		PrimitiveType primitiveType = (PrimitiveType) uml2Library
				.getOwnedType(name);

		package_.createElementImport(primitiveType,
				VisibilityKind.PUBLIC_LITERAL);

		out("Primitive type '" + primitiveType.getQualifiedName()
				+ "' imported.");

		return primitiveType;
	}

	protected Stereotype createStereotype(Profile profile, String name,
			boolean isAbstract) {
		Stereotype stereotype = profile.createOwnedStereotype(name, isAbstract);

		// Stereotype stereotype = (Stereotype) profile
		// .createOwnedMember(UML2Package.Literals.STEREOTYPE);
		// stereotype.setName(name);
		// stereotype.setIsAbstract(isAbstract);

		out("Stereotype '" + stereotype.getQualifiedName() + "' created.");

		return stereotype;
	}

	protected org.eclipse.uml2.uml.Class referenceMetaclass(Profile profile,
			String name) {
		// out("referenceMetaclass: " + name);
		Model uml2Metamodel = (Model) load(URI
				.createURI(UMLResource.UML_METAMODEL_URI));

		org.eclipse.uml2.uml.Class metaclass = (org.eclipse.uml2.uml.Class) uml2Metamodel
				.getOwnedType(name);

		profile.createMetaclassReference(metaclass);

		out("Metaclass '" + metaclass.getQualifiedName() + "' referenced.");

		return metaclass;
	}

	protected Extension createExtension(org.eclipse.uml2.uml.Class metaclass,
			Stereotype stereotype, boolean required) {
		Profile profile = stereotype.getProfile();
		boolean a = profile.getReferencedMetaclasses().contains(metaclass);
		boolean b = profile.getReferencedMetamodels().contains(
				metaclass.getModel());

		if (!a && !b) {

			out("classMetaclass: " + metaclass);
		}

		Extension extension = stereotype.createExtension(metaclass, required);

		out((required ? "Required extension '" : "Extension '")
				+ extension.getQualifiedName() + "' created.");

		return extension;
	}

	protected void defineProfile(Profile profile) {
		profile.define();

		out("Profile '" + profile.getQualifiedName() + "' defined.");
	}

	protected void applyProfile(Package package_, Profile profile) {
		package_.applyProfile(profile);

		out("Profile '" + profile.getQualifiedName() + "' applied to package '"
				+ package_.getQualifiedName() + "'.");
	}

	protected void applyStereotype(NamedElement namedElement,
			Stereotype stereotype) {
		namedElement.applyStereotype(stereotype);

		out("Stereotype '" + stereotype.getQualifiedName()
				+ "' applied to element '" + namedElement.getQualifiedName()
				+ "'.");
	}

	protected Object getStereotypePropertyValue(NamedElement namedElement,
			Stereotype stereotype, Property property) {
		Object value = namedElement.getValue(stereotype, property.getName());

		out("Value of stereotype property '" + property.getQualifiedName()
				+ "' on element '" + namedElement.getQualifiedName() + "' is "
				+ String.valueOf(value) + ".");

		return value;
	}

	protected void setStereotypePropertyValue(NamedElement namedElement,
			Stereotype stereotype, Property property, Object value) {
		namedElement.setValue(stereotype, property.getName(), value);

		out("Value of stereotype property '" + property.getQualifiedName()
				+ "' on element '" + namedElement.getQualifiedName()
				+ "' set to " + String.valueOf(value) + ".");
	}
}
