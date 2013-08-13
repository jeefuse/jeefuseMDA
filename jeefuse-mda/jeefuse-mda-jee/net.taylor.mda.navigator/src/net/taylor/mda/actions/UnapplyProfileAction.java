package net.taylor.mda.actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.edit.ui.celleditor.FeatureEditorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @author John
 * 
 */
public class UnapplyProfileAction extends ApplyStereotypeAction {

	private static final String LABEL = "Unapply Profile";

	public UnapplyProfileAction(TreeViewer viewer, Shell shell,
			ISelection selection) {
		super(viewer, shell, selection);
		setText(LABEL);
	}

	@SuppressWarnings("unchecked")
	public void run() {
		final org.eclipse.uml2.uml.Package package_ = (org.eclipse.uml2.uml.Package) getElement();
		final List choiceOfValues = new ArrayList(package_.getAppliedProfiles());

		Collections.sort(choiceOfValues, new TextComparator());

		final FeatureEditorDialog dialog = new FeatureEditorDialog(getShell(),
				getLabelProvider(), package_, UMLPackage.Literals.PROFILE,
				Collections.EMPTY_LIST, LABEL, choiceOfValues);
		dialog.open();

		if (dialog.getReturnCode() == FeatureEditorDialog.OK) {
			getEditingDomain().getCommandStack().execute(
					new RefreshingChangeCommand(getEditingDomain(),
							new Runnable() {

								public void run() {

									for (Iterator profiles = dialog.getResult()
											.iterator(); profiles.hasNext();) {

										package_
												.unapplyProfile((Profile) profiles
														.next());
									}
								}
							}, LABEL));
		}
	}
}