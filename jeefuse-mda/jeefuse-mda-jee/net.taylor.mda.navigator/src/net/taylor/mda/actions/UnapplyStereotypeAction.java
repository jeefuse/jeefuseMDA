package net.taylor.mda.actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.edit.ui.celleditor.FeatureEditorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @author John
 * 
 */
public class UnapplyStereotypeAction extends ApplyStereotypeAction {

	private static final String LABEL = "Unapply Stereotype";

	public UnapplyStereotypeAction(TreeViewer viewer, Shell shell,
			ISelection selection) {
		super(viewer, shell, selection);
		setText(LABEL);
	}

	@SuppressWarnings("unchecked")
	public void run() {

		final Element element = getElement();

		List choiceOfValues = new ArrayList();

		for (Iterator appliedStereotypes = element.getAppliedStereotypes()
				.iterator(); appliedStereotypes.hasNext();) {

			Stereotype stereotype = (Stereotype) appliedStereotypes.next();

			if (!element.isStereotypeRequired(stereotype)) {
				choiceOfValues.add(stereotype);
			}
		}

		Collections.sort(choiceOfValues, new TextComparator());

		final FeatureEditorDialog dialog = new FeatureEditorDialog(getShell(),
				getLabelProvider(), element, UMLPackage.eINSTANCE.getElement(),
				Collections.EMPTY_LIST, LABEL, choiceOfValues);
		dialog.open();

		if (FeatureEditorDialog.OK == dialog.getReturnCode()) {
			getEditingDomain().getCommandStack().execute(
					new RefreshingChangeCommand(getEditingDomain(),
							new Runnable() {

								public void run() {

									for (Iterator stereotypes = dialog
											.getResult().iterator(); stereotypes
											.hasNext();) {

										element
												.unapplyStereotype((Stereotype) stereotypes
														.next());
									}
								}
							}, LABEL));
		}
	}
}