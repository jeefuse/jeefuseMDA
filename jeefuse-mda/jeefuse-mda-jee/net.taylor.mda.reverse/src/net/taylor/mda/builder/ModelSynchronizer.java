package net.taylor.mda.builder;

import java.util.Map;

import net.taylor.mda.reverse.Activator;
import net.taylor.mda.util.ModelUtil;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.uml2.uml.NamedElement;

public class ModelSynchronizer extends IncrementalProjectBuilder {

	public static final String BUILDER_ID = Activator.getDefault().getBundle()
			.getSymbolicName()
			+ ".modelsynchronizer";

	public ModelSynchronizer() {
	}

	@Override
	protected IProject[] build(int kind, Map args, IProgressMonitor monitor)
			throws CoreException {
		IResourceDelta delta = getDelta(getProject());
		if (delta != null) {
			build(delta);
		}
		return null;
	}

	protected void build(IResourceDelta delta) throws JavaModelException {
		if (isJava(delta)) {
			IJavaElement element = JavaCore.create(delta.getResource());
			ICompilationUnit unit = (ICompilationUnit) element;

			IType[] types = unit.getAllTypes();
			for (int i = 0; i < types.length; i++) {
				NamedElement ne = ModelUtil.getElement(types[i].getElementName());
				if (ne != null) {
					if (types[i].isClass()) {
						ClassSynchronizer sync = new ClassSynchronizer();
						sync.synchronize(types[i], ne);
					}
					if (types[i].isInterface()) {
						InterfaceSynchronizer sync = new InterfaceSynchronizer();
						sync.synchronize(types[i], ne);
					}
					if (types[i].isEnum()) {
						EnumerationSynchronizer sync = new EnumerationSynchronizer();
						sync.synchronize(types[i], ne);
					}
				} else {
					// try without Bean suffix
					String name = types[i].getElementName();
					int length = name.length();
					ne = ModelUtil.getElement(types[i].getElementName().substring(0, length-4));
					if (ne != null) {
						InterfaceSynchronizer sync = new InterfaceSynchronizer();
						sync.synchronize(types[i], ne);
					}
				}
			}
		}

		// recurse
		IResourceDelta[] children = delta.getAffectedChildren();
		for (int i = 0; i < children.length; i++) {
			IResourceDelta child = children[i];
			build(child);
		}
	}

	protected boolean isJava(IResourceDelta delta) {
		return "java".equals(delta.getProjectRelativePath().getFileExtension());
	}

}
