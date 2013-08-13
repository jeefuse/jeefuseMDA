package net.taylor.mda.generator.engine;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.uml2.uml.Element;

public interface TemplateProcessor {

	public void generate(Element element, Template template,
			IProgressMonitor monitor);

}