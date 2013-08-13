package net.taylor.mda.generator.engine;

import java.util.Iterator;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.StateMachine;

public class StateMachineProcessor extends NamedElementProcessor {

	public void process(Element element, boolean all, String extension, String plugin,
			String suffix, Template template, IProgressMonitor monitor) {
		super.process(element, all, extension, plugin, suffix, template, monitor);

		StateMachine sm = (StateMachine) element;
		for (Iterator i = sm.getRegions().iterator(); i.hasNext();) {
			Region r = (Region) i.next();
			ElementProcessor processor = Engine.getElementProcessor(r);
			processor.process(r, all, extension, plugin, suffix, template, monitor);
		}
	}

}
