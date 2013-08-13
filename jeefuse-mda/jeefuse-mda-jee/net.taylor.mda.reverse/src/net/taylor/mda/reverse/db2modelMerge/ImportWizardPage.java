package net.taylor.mda.reverse.db2modelMerge;

import java.lang.reflect.InvocationTargetException;

import net.taylor.mda.utils.StrUtil;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.fieldassist.FieldAssistColors;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.uml2.uml.resource.UMLResource;

public class ImportWizardPage extends WizardPage implements Listener {

	protected FileFieldEditor existModelFileEditor;
	protected FileFieldEditor modelConfigEditor;
	//protected Text packageNameField;
	protected FileFieldEditor driverJarEditor;

	public ImportWizardPage(String pageName, IStructuredSelection selection) {
		super(pageName);
		//setPageComplete(false);
		setTitle(pageName); // NON-NLS-1
		setDescription("Create a UML model by importing database schema"); // NON-NLS-1
	}

	@Override
	public void createControl(Composite parent) {
		initializeDialogUnits(parent);
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new GridLayout());
		container.setLayoutData(new GridData(272));
		container.setFont(parent.getFont());
		createAdvancedControls(container);
		setControl(container);
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

		createExistModelFile(dbArea);
		//createImportPackage(dbArea);
		createDriverJarFile(dbArea);
		createDbToModelXml(dbArea);
		//createDriverContents(dbArea);
		//createUrlContents(dbArea);
		//createSchemaContents(dbArea);
	}

	private void createExistModelFile(Composite parent) {
		Composite fileSelectionArea = new Composite(parent, SWT.NONE);
		GridData fileSelectionData = new GridData(GridData.GRAB_HORIZONTAL | GridData.FILL_HORIZONTAL);
		fileSelectionArea.setLayoutData(fileSelectionData);

		GridLayout fileSelectionLayout = new GridLayout();
		fileSelectionLayout.numColumns = 3;
		fileSelectionLayout.makeColumnsEqualWidth = false;
		fileSelectionLayout.marginWidth = 0;
		fileSelectionLayout.marginHeight = 0;
		fileSelectionArea.setLayout(fileSelectionLayout);

		existModelFileEditor = new FileFieldEditor("fileSelect", "Select Exist model File: ", fileSelectionArea);
		String[] extensions = new String[] { "*.uml" }; // NON-NLS-1
		existModelFileEditor.setFileExtensions(extensions);
		fileSelectionArea.moveAbove(null);

	}

	private void createImportPackage(Composite parent) {
		Font font = parent.getFont();
		// server name group
		Composite composite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		composite.setLayout(layout);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		composite.setFont(font);

		// resource name group
		Composite nameGroup = new Composite(composite, SWT.NONE);
		layout = new GridLayout();
		layout.numColumns = 2;
		layout.marginWidth = 0;
		nameGroup.setLayout(layout);
		nameGroup.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL));
		nameGroup.setFont(font);

		Label label = new Label(nameGroup, SWT.NONE);
		label.setText("import package name:");
		label.setFont(font);

		// resource name entry field
		//packageNameField = new Text(nameGroup, SWT.BORDER);
		//packageNameField.addListener(SWT.Modify, this);
		GridData data = new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL);
		// data.widthHint = SIZING_TEXT_FIELD_WIDTH;
		//packageNameField.setLayoutData(data);
		//packageNameField.setFont(font);
		//packageNameField.setBackground(FieldAssistColors.getRequiredFieldBackgroundColor(packageNameField));

		// validateControls();

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

		driverJarEditor = new FileFieldEditor("fileSelect", "Select JDBC Driver Jar: ", fileSelectionArea);
		String[] extensions = new String[] { "*.jar" }; // NON-NLS-1
		driverJarEditor.setFileExtensions(extensions);
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


	protected void updateContents() {
		final String existModelFile = existModelFileEditor.getStringValue();
		//final String packageName = packageNameField.getText();
		final String modelConfigFile = modelConfigEditor.getStringValue();
		final String driverJarPath = driverJarEditor.getStringValue();
		// Now invoke the finish method.
		IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InvocationTargetException {
				try {
					DbToModelMergeReverseEngineer re = new DbToModelMergeReverseEngineer();
					 re.createMergeModel(monitor,existModelFile,modelConfigFile, driverJarPath);
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

	public void handleEvent(Event event) {
		setPageComplete(validatePage());
	}

	protected boolean validatePage() {
		boolean valid = true;
		final String existModelFile = existModelFileEditor.getStringValue();
		//final String packageName = packageNameField.getText();
		final String modelConfigFile = modelConfigEditor.getStringValue();
		final String driverJarPath = driverJarEditor.getStringValue();
		if(StrUtil.isBlank(existModelFile)){
			setErrorMessage("please select model file");
			return false;
		}
		if(!existModelFile.endsWith(UMLResource.FILE_EXTENSION)){
			setErrorMessage("invalid model file");
			return false;
		}
//		if(StrUtil.isEmptyOrWhitespaceOnly(packageName)){
//			setErrorMessage("please select model package");
//			return false;
//		}
		if(StrUtil.isBlank(modelConfigFile)){
			setErrorMessage("please select import config file");
			return false;
		}
		return valid;
	}

}
