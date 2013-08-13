package net.taylor.mda.generator.engine;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.uml2.uml.Element;

public interface ElementProcessor {

	void process(Element element, boolean all, String extension, String plugin,
			String suffix, Template template, IProgressMonitor monitor);
}
