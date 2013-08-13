package net.taylor.mda.navigator.sorters;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.uml2.uml.NamedElement;

public class NamedElementSorter extends ViewerSorter {

	public int compare(Viewer viewer, Object o1, Object o2) {
		if (o1 instanceof NamedElement && o2 instanceof NamedElement) {
			NamedElement lh = (NamedElement) o1;
			NamedElement rh = (NamedElement) o2;
			if (lh.getName() == null || rh.getName() == null) {
				return 1;
			}
			return getSortString(lh).compareTo(getSortString(rh));
		} else {
			return 1;
		}
	}
	
	private String getSortString(NamedElement ne) {
		String s = ne.getClass().getName() + ne.getName();
		return s;
	}
}
