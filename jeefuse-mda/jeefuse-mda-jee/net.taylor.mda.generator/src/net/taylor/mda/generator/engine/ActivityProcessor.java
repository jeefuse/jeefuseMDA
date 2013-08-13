package net.taylor.mda.generator.engine;

import java.util.Iterator;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.Element;

public class ActivityProcessor extends NamedElementProcessor {

	public void process(Element element, boolean all, String extension,
			String plugin, String suffix, Template template,
			IProgressMonitor monitor) {
		super.process(element, all, extension, plugin, suffix, template, monitor);

		Activity a = (Activity) element;
		for (Iterator i = a.getNodes().iterator(); i.hasNext();) {
			Element e = (Element) i.next();
			ElementProcessor processor = Engine.getElementProcessor(e);
			processor.process(e, all, extension, plugin, suffix, template, monitor);
		}
	}
}
