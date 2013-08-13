package net.taylor.mda.reverse.db2model;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;


import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

public class ImportWizardPage extends WizardNewFileCreationPage {

	protected FileFieldEditor editor;

	protected FileFieldEditor modelConfigEditor;

	public ImportWizardPage(String pageName, IStructuredSelection selection) {
		super(pageName, selection);
		setTitle(pageName); // NON-NLS-1
		setDescription("Create a UML model by importing database schema"); // NON-NLS-1
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.dialogs.WizardNewFileCreationPage#createAdvancedControls(org.eclipse.swt.widgets.Composite)
	 */
	protected void createAdvancedControls(Composite parent) {
		Composite dbArea = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		dbArea.setLayout(layout);
		dbArea.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.FILL_HORIZONTAL));

		createDriverJarFile(dbArea);
		createDbToModelXml(dbArea);
		//createDriverContents(dbArea);
		//createUrlContents(dbArea);
		//createSchemaContents(dbArea);
	}

	/**reference driver Jar file.
	 * @param parent
	 */
	private void createDriverJarFile(Composite parent) {

		Composite fileSelectionArea = new Composite(parent, SWT.NONE);
		GridData fileSelectionData = new GridData(GridData.GRAB_HORIZONTAL | GridData.FILL_HORIZONTAL);
		fileSelectionArea.setLayoutData(fileSelectionData);

		GridLayout fileSelectionLayout = new GridLayout();
		fileSelectionLayout.numColumns = 3;
		fileSelectionLayout.makeColumnsEqualWidth = false;
		fileSelectionLayout.marginWidth = 0;
		fileSelectionLayout.marginHeight = 0;
		fileSelectionArea.setLayout(fileSelectionLayout);

		editor = new FileFieldEditor("fileSelect", "Select JDBC Driver Jar: ", fileSelectionArea);
		String[] extensions = new String[] { "*.jar" }; // NON-NLS-1
		editor.setFileExtensions(extensions);
		fileSelectionArea.moveAbove(null);

	}

	/**Db to model config xml file.
	 * @param dbArea
	 */
	private void createDbToModelXml(Composite parent) {

		Composite fileSelectionArea = new Composite(parent, SWT.NONE);
		GridData fileSelectionData = new GridData(GridData.GRAB_HORIZONTAL | GridData.FILL_HORIZONTAL);
		fileSelectionArea.setLayoutData(fileSelectionData);

		GridLayout fileSelectionLayout = new GridLayout();
		fileSelectionLayout.numColumns = 3;
		fileSelectionLayout.makeColumnsEqualWidth = false;
		fileSelectionLayout.marginWidth = 0;
		fileSelectionLayout.marginHeight = 0;
		fileSelectionArea.setLayout(fileSelectionLayout);

		modelConfigEditor = new FileFieldEditor("fileSelect", "Select Import DbToModel config file: ",
				fileSelectionArea);
		String[] extensions = new String[] { "*.xml" }; // NON-NLS-1
		modelConfigEditor.setFileExtensions(extensions);
		fileSelectionArea.moveAbove(null);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.dialogs.WizardNewFileCreationPage#createLinkTarget()
	 */
	protected void createLinkTarget() {
	}

	private InputStream is;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.dialogs.WizardNewFileCreationPage#getInitialContents()
	 */
	protected InputStream getInitialContents() {
		final String path = editor.getStringValue();
		final String dbToModelFile = modelConfigEditor.getStringValue();
		final String fileName = getFileName();
		// Now invoke the finish method.
		IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InvocationTargetException {
				try {
					DbToModelReverseEngineer re = new DbToModelReverseEngineer();
					is = re.createModel(monitor, path, dbToModelFile, fileName);
				} finally {
					monitor.done();
				}
			}
		};
		try {
			getContainer().run(true, false, op);
		} catch (Exception e) {
			e.printStackTrace();
			Throwable realException = e.getCause();
			MessageDialog.openError(getShell(), "Error", realException.getMessage());
			// return null;
			throw new RuntimeException(e);
		}
		return is;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.dialogs.WizardNewFileCreationPage#getNewFileLabel()
	 */
	protected String getNewFileLabel() {
		return "New Model File Name:"; // NON-NLS-1
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.dialogs.WizardNewFileCreationPage#validateLinkedResource()
	 */
	protected IStatus validateLinkedResource() {
		return new Status(IStatus.OK, "net.jeefuse.mda.importwizards", IStatus.OK, "", null); // NON-NLS-1 //NON-NLS-2
	}
}
