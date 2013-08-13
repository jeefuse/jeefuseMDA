package net.taylor.mda.navigator.filters;

import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.uml2.uml.Element;

public class StereotypeFilter extends ViewerFilter {

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if (element instanceof DynamicEObjectImpl) {
			TreePath path = (TreePath)parentElement;
			Object last = path.getLastSegment();
			if (last instanceof Element || last instanceof DynamicEObjectImpl) {
				return true;
			} else {
				return false;
			}
		}
		return true;
	}
}
