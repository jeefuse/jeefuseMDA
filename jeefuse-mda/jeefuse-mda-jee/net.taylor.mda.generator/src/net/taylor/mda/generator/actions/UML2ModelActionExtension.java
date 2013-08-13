package net.taylor.mda.generator.actions;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import net.taylor.mda.generator.engine.BasicTemplateProcessor;
import net.taylor.mda.generator.engine.Engine;
import net.taylor.mda.generator.engine.NamedElementProcessor;
import net.taylor.mda.generator.engine.Template;
import net.taylor.mda.generator.engine.Templates;
import net.taylor.mda.generator.util.MavenHelper;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;
import org.eclipse.ui.navigator.ICommonMenuConstants;
import org.eclipse.uml2.uml.Element;

public class UML2ModelActionExtension extends CommonActionProvider implements
		IMenuListener {

	public void init(ICommonActionExtensionSite aConfig) {
	}

	public void menuAboutToShow(IMenuManager manager) {
	}

	protected IStructuredSelection getSelection() {
		ISelection selection = getContext().getSelection();
		return (IStructuredSelection) selection;
	}

	protected Object getObject() {
		return getSelection().getFirstElement();
	}

	// --------------------------------------------------------------
	
	public void fillContextMenu(IMenuManager aMenu) {
		IMenuManager submenuManager = aMenu.findMenuUsingPath("generate.menu");
		if (submenuManager == null) {
			submenuManager = new MenuManager("Generate", "generate.menu");
			aMenu.appendToGroup(ICommonMenuConstants.GROUP_GENERATE,
					submenuManager);
		}

		submenuManager.add(new GenAllAction(getSelection()));

		byExtensionMenu(submenuManager);
		bySuffixMenu(submenuManager);
		byTemplateMenu(submenuManager);
		byPluginMenu(submenuManager);

		submenuManager.add(new Separator());
		submenuManager.add(new ClearCacheAction());
	}

	protected void byExtensionMenu(IMenuManager aMenu) {
		IMenuManager submenuManager = new MenuManager("By Extension",
				"byExtension.menu");
		aMenu.add(submenuManager);
		populateExtensions(submenuManager);
	}

	protected void byPluginMenu(IMenuManager aMenu) {
		IMenuManager submenuManager = new MenuManager("By Plugin",
				"byPlugin.menu");
		aMenu.add(submenuManager);
		populatePlugins(submenuManager);
	}

	protected void bySuffixMenu(IMenuManager aMenu) {
		IMenuManager submenuManager = new MenuManager("By Project Suffix",
				"bySuffix.menu");
		aMenu.add(submenuManager);
		populateSuffixes(submenuManager);
	}

	protected void byTemplateMenu(IMenuManager aMenu) {
		IMenuManager submenuManager = new MenuManager("By Template",
				"byTemplate.menu");
		aMenu.add(submenuManager);
		populateTemplates(submenuManager);
	}

	// --------------------------------------------------------------

	protected void populateExtensions(IMenuManager aMenu) {
		Set<String> extensions = Templates.getExtensions();
		for (String extension : extensions) {
			aMenu.add(new GenByExtensionAction(extension, getSelection()));
		}
	}

	protected void populatePlugins(IMenuManager aMenu) {
		Set<String> plugins = Templates.getPlugins();
		for (String plugin : plugins) {
			if (MavenHelper.isPluginIncluded((Element) getObject(), plugin)) {
				aMenu.add(new GenByPluginAction(plugin, getSelection()));
			}
		}
	}

	protected void populateSuffixes(IMenuManager aMenu) {
		Set<String> suffixes = Templates.getSuffixes();
		for (String suffix : suffixes) {
			if (MavenHelper.isSuffixIncluded((Element) getObject(), suffix)) {
				aMenu.add(new GenBySuffixAction(suffix, getSelection()));
			}
		}
	}

	protected void populateTemplates(IMenuManager aMenu) {
		Map<String, Map<String, Template>> byPlugin = new TreeMap<String, Map<String, Template>>();
		Map<String, Map<String, Template>> bySuffix = new TreeMap<String, Map<String, Template>>();
		String clazz = getObject().getClass().getName();
		Map<String, Template> templates = Templates.getTemplates().get(clazz);
		if (templates != null) {
			for (Template template : templates.values()) {
				if (MavenHelper.isPluginIncluded((Element) getObject(), template.plugin)) {
					
					Map<String, Template> sorted = byPlugin.get(template.plugin);
					if (sorted == null) {
						sorted = new TreeMap<String, Template>();
						byPlugin.put(template.plugin, sorted);
					}
					sorted.put(template.id, template);
				}
				
				if (MavenHelper.isSuffixIncluded((Element) getObject(), template.projectSuffix)) {
					
					Map<String, Template> sorted = bySuffix.get(template.projectSuffix);
					if (sorted == null) {
						sorted = new TreeMap<String, Template>();
						bySuffix.put(template.projectSuffix, sorted);
					}
					sorted.put(template.id, template);
				}
			}
		}
		Set<String> suffixes = bySuffix.keySet();
		for (String suffix : suffixes) {
			IMenuManager submenuManager = new MenuManager(suffix,
					suffix + ".menu");
			
			Map<String, Template> sorted = bySuffix.get(suffix);
			for (Template template : sorted.values()) {
				if (NamedElementProcessor.matchesStereotype((Element)getObject(), template)) {
					submenuManager.add(new GenByTemplateAction(template, getSelection()));
				}
			}
			if (!submenuManager.isEmpty()) {
				aMenu.add(submenuManager);
			}
		}
		
		aMenu.add(new Separator());
		
		Set<String> plugins = byPlugin.keySet();
		for (String plugin : plugins) {
			IMenuManager submenuManager = new MenuManager(plugin,
					plugin + ".menu");
			
			Map<String, Template> sorted = byPlugin.get(plugin);
			for (Template template : sorted.values()) {
				if (NamedElementProcessor.matchesStereotype((Element)getObject(), template)) {
					submenuManager.add(new GenByTemplateAction(template, getSelection()));
				}
			}
			if (!submenuManager.isEmpty()) {
				aMenu.add(submenuManager);
			}
		}
	}

	// --------------------------------------------------------------

	private class BaseAction extends Action {
		protected IStructuredSelection selection;

		public BaseAction(String name, ISelection selection) {
			this.selection = (IStructuredSelection) selection;
			setInfo(name);
		}

		protected Element getObject() {
			return (Element) selection.getFirstElement();
		}

		protected void setInfo(String name) {
			setText(name);
			setToolTipText(name + " Tip");
			setDescription(name + " Description");
		}

		protected void dialog() {
			MessageDialog
					.openInformation(
							Display.getDefault().getActiveShell(),
							"Generate " + getText(),
							"Generate "
									+ getText()
									+ " Complete.\n"
									+ "See the console for trace "
									+ "information and errors/exceptions.");
		}
	}

	protected class GenAllAction extends BaseAction {

		public GenAllAction(ISelection selection) {
			super("All", selection);
		}

		public void run() {
			Engine gen = new Engine(getObject());
			gen.generateAll();
			dialog();
		}
	}

	protected class GenByExtensionAction extends BaseAction {

		private String extension;

		public GenByExtensionAction(String extension, ISelection selection) {
			super(extension, selection);
			this.extension = extension;
		}

		public void run() {
			Engine gen = new Engine(getObject());
			gen.generateForExtension(extension);
			dialog();
		}
	}

	protected class GenByPluginAction extends BaseAction {

		private String plugin;

		public GenByPluginAction(String plugin, ISelection selection) {
			super(plugin, selection);
			this.plugin = plugin;
		}

		public void run() {
			Engine gen = new Engine(getObject());
			gen.generateForPlugin(plugin);
			dialog();
		}
	}

	protected class GenBySuffixAction extends BaseAction {

		private String suffix;

		public GenBySuffixAction(String suffix, ISelection selection) {
			super(suffix, selection);
			this.suffix = suffix;
			String name = suffix;
			String override = MavenHelper.getSuffix(getObject(), suffix);
			if (!override.equals(suffix)) {
				name = name + " (" + override + ")";
			}
			setInfo(name);
		}

		public void run() {
			Engine gen = new Engine(getObject());
			gen.generateForSuffix(suffix);
			dialog();
		}
	}

	protected class GenByTemplateAction extends BaseAction {

		private Template template;

		public GenByTemplateAction(Template template, ISelection selection) {
			super(template.id + " : " + template.path + " : " + template.projectSuffix + " : "
				+ (template.hasStereotype != null && template.hasStereotype.length() > 0 ? 
						template.hasStereotype + " : " : "") + 
						template.ifExists, selection);
			this.template = template;
		}

		public void run() {
			if (selection.size() > 1) {
				// TODO is this working ???
				Iterator i = selection.iterator();
				while (i.hasNext()) {
					Element elem = (Element) i.next();
					Engine gen = new Engine(elem);
					gen.generate(template);
				}

			} else {
				Engine gen = new Engine(getObject());
				gen.generate(template);
			}
			dialog();
		}
	}

	protected class ClearCacheAction extends BaseAction {

		public ClearCacheAction() {
			super("Clear Template Cache", null);
		}

		public void run() {
			// TODO JET specific
			BasicTemplateProcessor.clearTemplateCache();
			dialog();
		}
	}
}
