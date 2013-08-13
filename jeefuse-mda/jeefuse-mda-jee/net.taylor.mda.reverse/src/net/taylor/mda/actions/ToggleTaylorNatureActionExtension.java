package net.taylor.mda.actions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.taylor.mda.reverse.Activator;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonMenuConstants;

public class ToggleTaylorNatureActionExtension extends CommonActionProvider {

	private static final String NATURE_ID = Activator.getDefault().getBundle()
			.getSymbolicName()
			+ ".taylornature";

	public void fillContextMenu(IMenuManager aMenu) {
		aMenu.appendToGroup(ICommonMenuConstants.GROUP_ADDITIONS,
				new ToggleTaylorNatureAction(getSelection()));
	}

	protected IStructuredSelection getSelection() {
		ISelection selection = getContext().getSelection();
		return (IStructuredSelection) selection;
	}

	public class ToggleTaylorNatureAction extends Action {

		private IStructuredSelection selection;

		public ToggleTaylorNatureAction(ISelection selection) {
			this.selection = (IStructuredSelection) selection;
			setText("Add/Remove Taylor Nature");
			// setToolTipText(name + " Tip");
			// setDescription(name + " Description");
		}

		public void run() {
			IProject project = (IProject) selection.getFirstElement();

			// cannot modify closed project
			if (!project.isOpen()) {
				return;
			}

			// get description
			IProjectDescription description;
			try {
				description = project.getDescription();
			} catch (CoreException e) {
				e.printStackTrace();
				return;
			}

			// toggle nature
			List<String> newIds = new ArrayList<String>();
			newIds.addAll(Arrays.asList(description.getNatureIds()));
			int index = newIds.indexOf(NATURE_ID);
			if (index == -1) {
				newIds.add(NATURE_ID);
			} else {
				newIds.remove(NATURE_ID);
			}
			description.setNatureIds(newIds.toArray(new String[newIds.size()]));

			// save description
			try {
				project.setDescription(description, null);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
	}
}
