package net.taylor.mda.generator.util;

import org.eclipse.emf.codegen.util.ImportManager;
import org.eclipse.uml2.uml.NamedElement;

public class ImportHelper {
	private static ImportManager importManager = new ImportManager("");

	public static ImportManager getImportManager() {
		return importManager;
	}

	public static ImportManager makeImportManager(String packageName) {
		importManager = new ImportManager(packageName);
		return importManager;
	}

	public static void addImport(NamedElement namedElement) {
		if (namedElement == null) {
			throw new RuntimeException("Type to be imported is null.");
		}
		if (namedElement.getNearestPackage() == null) {
			throw new RuntimeException("No package for: " + namedElement);
		}
		String qn = namedElement.getNearestPackage().getQualifiedName();
		if (qn == null) {
			throw new RuntimeException("No package name for: " + namedElement);
		}
		qn = qn.replaceAll("::", ".");
		qn = qn.substring(qn.indexOf(".") + 1);
		if (!"types".equals(qn)) {// TODO
			importManager.addImport(qn, namedElement.getName());
		}
	}

	public static void addImport(NamedElement namedElement, String suffix) {
		NamedElement pkg = namedElement.getNearestPackage();
		String qn = pkg.getQualifiedName();
		qn = qn.replaceAll("::", ".");
		qn = qn.substring(qn.indexOf(".") + 1);
		if (!"types".equals(qn)) {// TODO
			importManager.addImport(qn, namedElement.getName() + suffix);
		}
	}

	public static String getImportedName(String qualifiedName) {
		importManager.addImport(qualifiedName);
		return importManager.getImportedName(qualifiedName);
	}

	public static String getImportedName(NamedElement namedElement) {
		addImport(namedElement);
		String qn = NameHelper.getQualifiedName(namedElement.getQualifiedName());
		return importManager.getImportedName(qn);
	}

}
