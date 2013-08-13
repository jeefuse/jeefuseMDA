package net.taylor.mda.generator.engine;

import java.util.Iterator;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;

public class PackageProcessor extends NamedElementProcessor {

	public void process(Element element, boolean all, String extension, String plugin,
			String suffix, Template template, IProgressMonitor monitor) {
		super.process(element, all, extension, plugin, suffix, template, monitor);

		Package uml2Package = (Package) element;
		for (Iterator i = uml2Package.getMembers().iterator(); i.hasNext();) {
			NamedElement ne = (NamedElement) i.next();
			ElementProcessor processor = Engine.getElementProcessor(ne);
			processor.process(ne, all, extension, plugin, suffix, template, monitor);
		}
	}

}
