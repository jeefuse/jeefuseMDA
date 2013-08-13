package net.taylor.mda.generator.parse;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Property;

public class UmlHelper {

	/**
	 * 在package中,获取指定名称的元素.
	 */
	public static Element getElement(org.eclipse.uml2.uml.Package model,String name) {
		List<Element> allElements = model.allOwnedElements();
		for (Element element : allElements) {
			if (!(element instanceof NamedElement))
				continue;
			NamedElement namedElement = (NamedElement) element;
			if (name.equalsIgnoreCase(namedElement.getName()))
				return namedElement;
		}
		return null;
	}
	
	/**
	 * 在package中,获取指定名称且元素的类型为Enumeration的元素.
	 */
	public static Enumeration getEnumerationElement(org.eclipse.uml2.uml.Package umlPackage,String name) {
		Model model=umlPackage.getModel();
		List<Element> allElements = model.allOwnedElements();
		for (Element element : allElements) {
			if (!(element instanceof org.eclipse.uml2.uml.Enumeration))
				continue;
			org.eclipse.uml2.uml.Enumeration namedElement = (org.eclipse.uml2.uml.Enumeration) element;
			if (name.equalsIgnoreCase(namedElement.getName())){
				return (Enumeration) namedElement;
			}
		}
		//search the import element
		EList<PackageableElement>  packageableElements=model.getImportedElements();
		//EList<Profile>  allAppliedProfiles=model.getModel().getAllAppliedProfiles();
		//EList<ElementImport>  importElements=model.getModel().getElementImports();
		for(PackageableElement importElement:packageableElements){
			if (!(importElement instanceof org.eclipse.uml2.uml.Enumeration))
				continue;
			org.eclipse.uml2.uml.Enumeration namedElement = (org.eclipse.uml2.uml.Enumeration) importElement;
			//LogUtil.log("search import element '"+name+"':is match:("+namedElement.getName()+")"+(name.equalsIgnoreCase(namedElement.getName())));
			if (name.equalsIgnoreCase(namedElement.getName())){
				return (Enumeration) namedElement;
			}
		}
		return null;
	}
	
	/**
	 * 在package中,获取指定名称且元素的类型为Class的元素.
	 */
	public static org.eclipse.uml2.uml.Class getClassElement(org.eclipse.uml2.uml.Package model,String name) {
		List<Element> allElements = model.allOwnedElements();
		for (Element element : allElements) {
			if (!(element instanceof org.eclipse.uml2.uml.Class))
				continue;
			org.eclipse.uml2.uml.Class namedElement = (org.eclipse.uml2.uml.Class) element;
			if (name.equalsIgnoreCase(namedElement.getName()))
				return namedElement;
		}
		return null;
	}
	

	/**
	 * 根据名称获取类的属性.
	 */
	public static org.eclipse.uml2.uml.Property getPropertyElement(org.eclipse.uml2.uml.Class model,String name) {
		List<Property> allElements = model.getAllAttributes();
		for (Property element : allElements) {
			if (name.equalsIgnoreCase(element.getName()))
				return element;
		}
		return null;
	}
}
