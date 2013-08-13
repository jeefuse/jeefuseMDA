package net.taylor.mda.builder;

import java.util.List;

import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.Annotation;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;

public class InterfaceSynchronizer extends ElementSynchronizer {

	public InterfaceSynchronizer() {
	}

	protected boolean isMine(NamedElement element) {
		return element instanceof Interface;
	}

	protected void doSynchronize(final IType type, final NamedElement element)
			throws JavaModelException {
		final CompilationUnit root = getCompilationUnit(type);
		// TODO some code will be in Bean class
		final Interface interfaze = (Interface) element;
		TypeDeclaration td = getTypeDeclaration(root);
		updateComment(td, interfaze);
		final List<Annotation> classAnnotations = getAnnotations(td);
		applyStereotypes(interfaze, classAnnotations, root);

		MethodDeclaration[] methodDecs = td.getMethods();
		for (int i = 0; i < methodDecs.length; i++) {
			if (isGenerated(methodDecs[i])) {
				final String name = methodDecs[i].getName()
						.getFullyQualifiedName();
				Operation operation = interfaze.getOwnedOperation(name, null,
						null);
				if (null == operation) {
//					operation = ((Interface) element).createOwnedOperation(
//							name, null, null);
					// TODO params
				} else {
					final List<Annotation> methodAnnotations = getAnnotations(methodDecs[i]);
					applyStereotypes(operation, methodAnnotations, root);
				}
//				updateComment(methodDecs[i], operation);
			}
		}
	}
}
