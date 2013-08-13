package net.taylor.mda.actions;

import net.taylor.mda.navigator.Activator;
import net.taylor.mda.util.ModelUtil;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.internal.IWorkbenchGraphicConstants;
//import org.eclipse.ui.internal.WorkbenchImages;
//import org.eclipse.ui.internal.WorkbenchMessages;

/**
 * @author John
 * 
 */
public class SaveAction extends Action {

	private IStructuredSelection selection;

	public SaveAction(ISelection selection) {
		this.selection = (IStructuredSelection) selection;
		setText("Save");
		setToolTipText("Save the model file");
		setDescription("Save the model file.");
		setId("save"); //$NON-NLS-1$
		setImageDescriptor(Activator
				.getImageDescriptor("$nl$/icons/full/etool16/save_edit.gif"));
		setActionDefinitionId("org.eclipse.ui.file.save"); //$NON-NLS-1$
	}

	public void run() {
		doSave();
		MessageDialog.openInformation(Display.getDefault().getActiveShell(),
				"Save Action", "Save complete.");
	}

	protected void doSave() {
		ModelUtil.save((EObject) selection.getFirstElement());
	}
}
