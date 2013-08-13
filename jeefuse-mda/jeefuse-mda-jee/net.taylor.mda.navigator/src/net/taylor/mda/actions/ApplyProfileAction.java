package net.taylor.mda.actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.ui.celleditor.FeatureEditorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.ProfileApplication;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.eclipse.uml2.uml.util.UMLSwitch;

/**
 * @author John
 * 
 */
public class ApplyProfileAction extends ApplyStereotypeAction {

	private static final String LABEL = "Apply Profile";

	public ApplyProfileAction(TreeViewer viewer, Shell shell,
			ISelection selection) {
		super(viewer, shell, selection);
		setText(LABEL);
	}

	@SuppressWarnings("unchecked")
	public void run() {
		final org.eclipse.uml2.uml.Package package_ = (org.eclipse.uml2.uml.Package) getElement();

		final List choiceOfValues = new ArrayList();

		ResourceSet resourceSet = package_.eResource().getResourceSet();

		try {
			resourceSet.getResource(URI
					.createURI(UMLResource.STANDARD_PROFILE_URI), true);

			resourceSet.getResource(URI
					.createURI(UMLResource.ECORE_PROFILE_URI), true);
		} catch (Exception e) {
			// ignore
		}

		for (Iterator resources = resourceSet.getResources().iterator(); resources
				.hasNext();) {

			Iterator allContents = ((Resource) resources.next())
					.getAllContents();

			while (allContents.hasNext()) {

				new UMLSwitch() {

					public Object caseProfile(Profile profile) {

						if (profile.isDefined()) {
							ProfileApplication profileApplication = package_
									.getProfileApplication(profile);

							if (profileApplication == null
									|| profileApplication
											.getAppliedDefinition() != profile
											.getDefinition()) {

								choiceOfValues.add(profile);
							}
						}

						return profile;
					}
				}.doSwitch((EObject) allContents.next());
			}
		}

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
												.applyProfile((Profile) profiles
														.next());
									}
								}
							}, LABEL));
		}
	}
}