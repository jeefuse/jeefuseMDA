package net.taylor.mda.reverse.db2modelMerge;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.IWorkbench;

public class ImportWizard extends Wizard implements IImportWizard {
	
	ImportWizardPage mainPage;

	public ImportWizard() {
		super();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	public boolean performFinish() {
		//File file = mainPage.updateContents();
        //if (file == null)
        //    return false;
		mainPage.updateContents();
        return true;
	}
	 
	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench, org.eclipse.jface.viewers.IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		setWindowTitle("Database Import Wizard"); //NON-NLS-1
		setNeedsProgressMonitor(true);
		mainPage = new ImportWizardPage("Import DB to uml model with merge exist file",selection); //NON-NLS-1
	}
	
	/* (non-Javadoc)
     * @see org.eclipse.jface.wizard.IWizard#addPages()
     */
    public void addPages() {
        super.addPages(); 
        addPage(mainPage);        
    }

}
