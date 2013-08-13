package net.taylor.mda.builder;

import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.NamedElement;

public class EnumerationSynchronizer extends ElementSynchronizer {

	public EnumerationSynchronizer() {
	}

	protected boolean isMine(NamedElement element) {
		return element instanceof Enumeration;
	}

	protected void doSynchronize(final IType type, final NamedElement element)
			throws JavaModelException {
		IField[] fields = type.getFields();
		for (int i = 0; i < fields.length; i++) {
			final String name = fields[i].getElementName();
			final Enumeration e = (Enumeration) element;
			if (null == e.getOwnedLiteral(name)) {
				// fields[i].getJavadocRange()
				((Enumeration) e).createOwnedLiteral(name);
			}
			// note: literals will not be removed from the model because they
			// could have been added since the last generate. thus, the code
			// should be regenerated.
		}
	}
}
