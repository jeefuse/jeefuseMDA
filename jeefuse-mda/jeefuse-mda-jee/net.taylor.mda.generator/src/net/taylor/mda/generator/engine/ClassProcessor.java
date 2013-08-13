package net.taylor.mda.generator.engine;

import java.util.Iterator;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;

public class ClassProcessor extends NamedElementProcessor {

	public void process(Element element, boolean all, String extension,
			String plugin, String suffix, Template template,
			IProgressMonitor monitor) {
		super.process(element, all, extension, plugin, suffix, template, monitor);

		// engage property specific templates
		Class entity = (Class) element;
		for (Iterator i = entity.getOwnedAttributes().iterator(); i.hasNext();) {
			Property p = (Property) i.next();
			ElementProcessor processor = Engine.getElementProcessor(p);
			processor.process(p, all, extension, plugin, suffix, template, monitor);
		}
	}
}
