package net.taylor.mda.reverse;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;

public class ReverseEngineer {

	protected static String LINE = "================================================";

	public static boolean DEBUG = true;

	protected final ResourceSet RESOURCE_SET = new ResourceSetImpl();

	private MessageConsoleStream consoleStream = null;

	protected void out(String output) {

		if (DEBUG) {
			// Display d = Display.getCurrent();
			// getConsoleStream().setColor(Display.getCurrent().getSystemColor(SWT.COLOR_DARK_GREEN));
			try {
				getConsoleStream().println(output);
			} catch (Throwable e) {
				System.out.println(output);
			}
		}
	}

	protected void err(String error) {
		// getConsoleStream().setColor(Display.getCurrent().getSystemColor(SWT.COLOR_DARK_MAGENTA));
		try {
			getConsoleStream().println(error);
		} catch (Throwable e) {
			System.err.println(error);
		}
	}

	protected void err(String error, Throwable ex) {
		// getConsoleStream().setColor(Display.getCurrent().getSystemColor(SWT.COLOR_DARK_MAGENTA));
		try {
			getConsoleStream().println(error);
			ex.printStackTrace(new PrintStream(getConsoleStream()));
		} catch (Throwable e) {
			System.err.println(error);
		}
	}

	protected MessageConsoleStream getConsoleStream() {
		if (consoleStream == null) {
			MessageConsole console = new MessageConsole("Taylor Console", null);
			console.activate();
			ConsolePlugin.getDefault().getConsoleManager().addConsoles(
					new IConsole[] { console });
			consoleStream = console.newMessageStream();
		}
		return consoleStream;

	}

	protected void registerResourceFactories() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE);
	}

	protected void registerPathmaps(URI uri) {
		URIConverter.URI_MAP.put(URI.createURI(UMLResource.LIBRARIES_PATHMAP),
				uri.appendSegment("libraries").appendSegment(""));

		URIConverter.URI_MAP.put(URI.createURI(UMLResource.METAMODELS_PATHMAP),
				uri.appendSegment("metamodels").appendSegment(""));

		URIConverter.URI_MAP.put(URI.createURI(UMLResource.PROFILES_PATHMAP),
				uri.appendSegment("profiles").appendSegment(""));
	}

	protected void save(Package package_, URI uri) {
		Resource resource = (Resource) RESOURCE_SET.getResources().get(0);
		if (resource == null) {
			resource = RESOURCE_SET.createResource(uri);
			resource.getContents().add(package_);
		}

		try {
			resource.save(null);

			out("Done.");
		} catch (IOException ioe) {
			err(ioe.getMessage());
		}
	}

	protected InputStream toInputStream(Package package_, URI uri) {
		Resource resource = (Resource) RESOURCE_SET.getResources().get(0);
		if (resource == null) {
			resource = RESOURCE_SET.createResource(uri);
			resource.getContents().add(package_);
		}

		try {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			resource.save(out, null);
			return new ByteArrayInputStream(out.toByteArray());
		} catch (IOException ioe) {
			throw new RuntimeException(ioe);
		}
	}

	protected Package load(URI uri) {
		Package package_ = null;

		try {
			Resource resource = RESOURCE_SET.getResource(uri, true);

			package_ = (Package) EcoreUtil.getObjectByType(resource
					.getContents(), UMLPackage.eINSTANCE.getPackage());
		} catch (WrappedException we) {
			err(uri + " : " + we.getMessage());
		}

		return package_;
	}

}
