package net.taylor.mda.utils;

import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;

public class LogUtil {
	public static boolean DEBUG = true;
	private static MessageConsoleStream consoleStream = null;

	protected MessageConsoleStream getConsoleStream() {
		if (consoleStream == null) {
			MessageConsole console = new MessageConsole("Taylor Console", null);
			console.activate();
			ConsolePlugin.getDefault().getConsoleManager().addConsoles(new IConsole[] { console });
			consoleStream = console.newMessageStream();
		}
		return consoleStream;

	}

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
}
