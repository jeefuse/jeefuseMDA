package net.taylor.mda.generator.parse;

import java.util.ArrayList;
import java.util.List;

import net.taylor.mda.generator.util.StereotypeHelper;

import org.eclipse.uml2.uml.Element;

import net.jeefuse.mda.annotations.MdaStereotype;

public class PackageHelper {

	public static List<org.eclipse.uml2.uml.Class> getJoinServiceFactoryClass(org.eclipse.uml2.uml.Package uml2Package){
		List<org.eclipse.uml2.uml.Class> classList=new ArrayList<org.eclipse.uml2.uml.Class>();
		List<Element> elements=uml2Package.getOwnedElements();
		for(Element element:elements){
			if(element instanceof org.eclipse.uml2.uml.Class){
				if(StereotypeHelper.isStereotypeApplied(element,StereotypeHelper.ENTITY )||StereotypeHelper.isStereotypeApplied(element, MdaStereotype.service_JoinServiceFactory)){
					classList.add((org.eclipse.uml2.uml.Class)element);
				}
			}
		}
		return classList;
	}
}
