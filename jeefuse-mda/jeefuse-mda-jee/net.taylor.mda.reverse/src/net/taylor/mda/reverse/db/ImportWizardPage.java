package net.taylor.mda.reverse.db;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

import net.taylor.mda.reverse.DatabaseReverseEngineer;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.fieldassist.FieldAssistColors;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

public class ImportWizardPage extends WizardNewFileCreationPage {

	protected FileFieldEditor editor;

	protected Text driverNameField;

	protected Text urlField;

	protected Text schemaField;

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
		dbArea.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL
				| GridData.FILL_HORIZONTAL));

		// Jar
		Composite fileSelectionArea = new Composite(dbArea, SWT.NONE);
		GridData fileSelectionData = new GridData(GridData.GRAB_HORIZONTAL
				| GridData.FILL_HORIZONTAL);
		fileSelectionArea.setLayoutData(fileSelectionData);

		GridLayout fileSelectionLayout = new GridLayout();
		fileSelectionLayout.numColumns = 3;
		fileSelectionLayout.makeColumnsEqualWidth = false;
		fileSelectionLayout.marginWidth = 0;
		fileSelectionLayout.marginHeight = 0;
		fileSelectionArea.setLayout(fileSelectionLayout);

		editor = new FileFieldEditor("fileSelect", "Select JDBC Driver Jar: ",
				fileSelectionArea); // NON-NLS-1 //NON-NLS-2
		// editor.getTextControl(fileSelectionArea).addModifyListener(
		// new ModifyListener() {
		// public void modifyText(ModifyEvent e) {
		// IPath path = new Path(ImportWizardPage.this.editor
		// .getStringValue());
		// setFileName(path.lastSegment());
		// }
		// });
		String[] extensions = new String[] { "*.jar" }; // NON-NLS-1
		editor.setFileExtensions(extensions);
		fileSelectionArea.moveAbove(null);

		createDriverContents(dbArea);
		createUrlContents(dbArea);
		createSchemaContents(dbArea);
	}

	protected void createDriverContents(Composite parent) {
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
		nameGroup.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL
				| GridData.GRAB_HORIZONTAL));
		nameGroup.setFont(font);

		Label label = new Label(nameGroup, SWT.NONE);
		label.setText("Driver Class Name:");
		label.setFont(font);

		// resource name entry field
		driverNameField = new Text(nameGroup, SWT.BORDER);
		driverNameField.addListener(SWT.Modify, this);
		GridData data = new GridData(GridData.HORIZONTAL_ALIGN_FILL
				| GridData.GRAB_HORIZONTAL);
		// data.widthHint = SIZING_TEXT_FIELD_WIDTH;
		driverNameField.setLayoutData(data);
		driverNameField.setFont(font);
		driverNameField.setBackground(FieldAssistColors
				.getRequiredFieldBackgroundColor(driverNameField));

		// validateControls();
	}

	protected void createUrlContents(Composite parent) {
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
		nameGroup.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL
				| GridData.GRAB_HORIZONTAL));
		nameGroup.setFont(font);

		Label label = new Label(nameGroup, SWT.NONE);
		label.setText("Database URL:");
		label.setFont(font);

		// resource name entry field
		urlField = new Text(nameGroup, SWT.BORDER);
		urlField.addListener(SWT.Modify, this);
		GridData data = new GridData(GridData.HORIZONTAL_ALIGN_FILL
				| GridData.GRAB_HORIZONTAL);
		// data.widthHint = SIZING_TEXT_FIELD_WIDTH;
		urlField.setLayoutData(data);
		urlField.setFont(font);
		urlField.setBackground(FieldAssistColors
				.getRequiredFieldBackgroundColor(urlField));

		// validateControls();
	}

	protected void createSchemaContents(Composite parent) {
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
		nameGroup.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL
				| GridData.GRAB_HORIZONTAL));
		nameGroup.setFont(font);

		Label label = new Label(nameGroup, SWT.NONE);
		label.setText("Schema Pattern:");
		label.setFont(font);

		// resource name entry field
		schemaField = new Text(nameGroup, SWT.BORDER);
		schemaField.addListener(SWT.Modify, this);
		GridData data = new GridData(GridData.HORIZONTAL_ALIGN_FILL
				| GridData.GRAB_HORIZONTAL);
		// data.widthHint = SIZING_TEXT_FIELD_WIDTH;
		schemaField.setLayoutData(data);
		schemaField.setFont(font);
		schemaField.setBackground(FieldAssistColors
				.getRequiredFieldBackgroundColor(schemaField));
		
		schemaField.setText("%");

		// validateControls();
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
		final String driver = driverNameField.getText();
		final String url = urlField.getText();
		final String schema = schemaField.getText();
		final String fileName = getFileName();
		// Now invoke the finish method.
		IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor)
					throws InvocationTargetException {
				try {
					DatabaseReverseEngineer re = new DatabaseReverseEngineer();
					is = re.createModel(monitor, path,// "C:/downloads/mysql/mysql-connector-java-3.1.13/mysql-connector-java-3.1.13/mysql-connector-java-3.1.13-bin.jar",
							driver, // "org.gjt.mm.mysql.Driver",
							url, // "jdbc:mysql://localhost/mysql?user=root&password=password",
							schema,
							fileName);
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
			MessageDialog.openError(getShell(), "Error", realException
					.getMessage());
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
		return new Status(IStatus.OK, "net.taylor.mda.importwizards",
				IStatus.OK, "", null); // NON-NLS-1 //NON-NLS-2
	}
}
