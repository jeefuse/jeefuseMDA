package net.taylor.mda.generator.engine;

import java.lang.reflect.InvocationTargetException;

import net.taylor.mda.generator.Console;
import net.taylor.mda.generator.GeneratorPlugin;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.StateMachine;

/**
 * @author jgilbert
 * @version $Id: Engine.java,v 1.9 2007/12/17 21:40:48 jgilbert01 Exp $
 * 
 */
public class Engine {

	private static final String START = "*** Start Generate ";
	private static final String END = "*** End Generate ******************";
	
	private Element element;

	public Engine(Element object) {
		this.element = object;
	}

	protected Element getElement() {
		return element;
	}

	// --------------------------------------------------------------
	
	public void generateAll() {
		log(START + "All ************");
		generate(true, null, null, null, null);
		log(END);
	}
	
	public void generateForExtension(String extension) {
		log(START + "Mergable *******");
		generate(false, extension, null, null, null);
		log(END);
	}

	public void generateForPlugin(String plugin) {
		log(START + "for Plugin *****");
		generate(false, null, plugin, null, null);
		log(END);
	}

	public void generateForSuffix(String suffix) {
		log(START + "for Suffix *****");
		generate(false, null, null, suffix, null);
		log(END);
	}

	public void generate(Template template) {
		log(START + "for Template ***");
		generate(false, null, null, null, template);
		log(END);
	}

	// --------------------------------------------------------------

	public void generate(final boolean all, final String extension,
			final String plugin, final String suffix, final Template template) {

//		javaFiles.clear();
		
		WorkspaceModifyOperation op = new WorkspaceModifyOperation() {
			public void execute(IProgressMonitor monitor) throws CoreException,
					InvocationTargetException, InterruptedException {

				ElementProcessor processor = getElementProcessor(getElement());
				processor.process(getElement(), all, extension, plugin, suffix,
						template, monitor);
			}
		};

		run(op);
		
//		op = new WorkspaceModifyOperation() {
//			public void execute(IProgressMonitor monitor) throws CoreException,
//					InvocationTargetException, InterruptedException {
//
//				organizeImports();
//			}
//		};
//
//		run(op);
	}

	protected void run(WorkspaceModifyOperation op) {
		Shell shell = GeneratorPlugin.getActiveWorkbenchShell();
		ProgressMonitorDialog dialog = new ProgressMonitorDialog(shell);
		try {
			dialog.run(false, true, op);
		} catch (Exception e) {
			MessageDialog.openError(Display.getDefault().getActiveShell(),
					"Generation Exception", e.toString());
			throw new RuntimeException(e);
		}
	}

	// --------------------------------------------------------------

	public static ElementProcessor getElementProcessor(Element element) {
		if (element instanceof Package) {
			return new PackageProcessor();
		}
		if (element instanceof StateMachine) {
			return new StateMachineProcessor();
		}
		if (element instanceof Region) {
			return new RegionProcessor();
		}
		if (element instanceof Activity) {
			return new ActivityProcessor();
		}
		if (element instanceof org.eclipse.uml2.uml.UseCase) {
			return new UseCaseProcessor();
		}
		if (element instanceof org.eclipse.uml2.uml.Class) {
			return new ClassProcessor();
		}
		return new NamedElementProcessor();
	}

	public static TemplateProcessor getTemplateProcessor(Template template) {
		String processorClass = template.processorClass;
		if (processorClass == null) {
			return new BasicTemplateProcessor();
		} else {
			try {
				java.lang.Class<?> processor = java.lang.Class
						.forName(processorClass);
				return (TemplateProcessor) processor.newInstance();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

	// --------------------------------------------------------------
	
	protected void log(String text) {
		Console.getStream().println(text);
	}
	
//	static List<IFile> javaFiles = new ArrayList<IFile>();
//	static void addJavaFile(IFile file) {
//		javaFiles.add(file);
//	}
//	static void organizeImports() {
//		for (IFile file : javaFiles) {
//			final IJavaElement jFile = JavaCore.create(file);
//
//			Runnable runnable = new Runnable() {
//				public void run() {
//					// TODO why does this open all the editor?
//					OrganizeImportsAction action = new OrganizeImportsAction(
//							GeneratorPlugin.getDefault().getWorkbench()
//									.getActiveWorkbenchWindow().getActivePage()
//									.getActivePart().getSite());
//					action.run(new StructuredSelection(jFile));
//				}
//			};
//			Display.getDefault().syncExec(runnable);
//		}
//	}
}
