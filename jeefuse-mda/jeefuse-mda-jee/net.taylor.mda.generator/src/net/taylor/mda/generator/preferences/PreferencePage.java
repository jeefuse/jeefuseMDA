package net.taylor.mda.generator.preferences;

import java.util.Set;

import net.taylor.mda.generator.engine.Templates;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.DirectoryFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * This class represents a preference page that is contributed to the
 * Preferences dialog. By subclassing <samp>FieldEditorPreferencePage</samp>,
 * we can use the field support built into JFace that allows us to create a page
 * that is small and knows how to save, restore and apply itself.
 * <p>
 * This page is used to modify preferences only. They are stored in the
 * preference store that belongs to the main plug-in class. That way,
 * preferences can be accessed directly via the preference store.
 */

public class PreferencePage extends FieldEditorPreferencePage implements
		IWorkbenchPreferencePage {

	public PreferencePage() {
		super(GRID);
		setPreferenceStore(Preferences.getStore());
		// setDescription("A demonstration of a preference page
		// implementation");
	}

	/**
	 * Creates the field editors. Field editors are abstractions of the common
	 * GUI blocks needed to manipulate various types of preferences. Each field
	 * editor knows how to save and restore itself.
	 */
	public void createFieldEditors() {

		createTemplateFilterBasePackage();
		createTemplateRootEditors();
		createFlagsEditors();
		createSuffixEditors();
		createPluginEditors();
		

		// addField(
		// new BooleanFieldEditor(
		// PreferenceConstants.P_BOOLEAN,
		// "&An example of a boolean preference",
		// getFieldEditorParent()));

		// addField(new RadioGroupFieldEditor(
		// PreferenceConstants.P_CHOICE,
		// "An example of a multiple-choice preference",
		// 1,
		// new String[][] { { "&Choice 1", "choice1" }, {
		// "C&hoice 2", "choice2" }
		// }, getFieldEditorParent()));
		// addField(
		// new StringFieldEditor(PreferenceConstants.P_STRING, "A &text
		// preference:", getFieldEditorParent()));
	}

	private void createTemplateFilterBasePackage() {
		addField(new StringFieldEditor(PreferenceConstants.FILTER_BASE_PACKAGE,"filter base package:", getFieldEditorParent()));
	}

	protected void createTemplateRootEditors() {
		Group group = new Group(getFieldEditorParent(), SWT.NONE);
		group.setText("Templates Override");

		GridLayout gridLayout = new GridLayout(3, false);
		GridData gridData = new GridData();
		// gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalSpan = 3;

		addField(new DirectoryFieldEditor(PreferenceConstants.P_TEMPLATE_ROOT,
				"&Root Directory:", group));

		group.setLayoutData(gridData);
		group.setLayout(gridLayout);
	}

	protected void createPluginEditors() {
		Group group = new Group(getFieldEditorParent(), SWT.NONE);
		group.setText("Include Generator");

		GridLayout gridLayout = new GridLayout(2, false);
		GridData gridData = new GridData(GridData.FILL);
		// gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalSpan = 2;

		Set<String> plugins = Templates.getPlugins();
		for (String plugin : plugins) {
			addField(new BooleanFieldEditor(plugin
					+ PreferenceConstants.INCLUDE, plugin, group));
		}

		group.setLayoutData(gridData);
		group.setLayout(gridLayout);
	}

	public void createSuffixEditors() {
		Group group = new Group(getFieldEditorParent(), SWT.NONE);
		group.setText("Suffix Include/Override");

		GridLayout gridLayout = new GridLayout(6, false);
		GridData gridData = new GridData(GridData.FILL);
		gridData.horizontalSpan = 6;

		Set<String> suffixes = Templates.getSuffixes();
		for (String suffix : suffixes) {
			addField(new BooleanFieldEditor(suffix
					+ PreferenceConstants.INCLUDE, suffix, group));
			addField(new StringFieldEditor(suffix + PreferenceConstants.SUFFIX,
					"", 5, group));
		}

		group.setLayoutData(gridData);
		group.setLayout(gridLayout);
	}

	protected void createFlagsEditors() {
		Group group = new Group(getFieldEditorParent(), SWT.NONE);
		group.setText("Generator Flags");

		GridLayout gridLayout = new GridLayout(2, false);
		GridData gridData = new GridData(GridData.FILL);
		gridData.horizontalSpan = 2;

		addField(new BooleanFieldEditor(PreferenceConstants.IGNORE_SKIP, "Ignore Skip", group));
		addField(new BooleanFieldEditor(PreferenceConstants.SKIP_BACKUP, "Skip Backup", group));

		group.setLayoutData(gridData);
		group.setLayout(gridLayout);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
	}

}