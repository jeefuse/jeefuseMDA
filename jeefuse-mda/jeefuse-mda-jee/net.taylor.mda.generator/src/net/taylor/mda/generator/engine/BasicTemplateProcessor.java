package net.taylor.mda.generator.engine;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import net.taylor.mda.generator.Console;
import net.taylor.mda.generator.GeneratorPlugin;
import net.taylor.mda.generator.engine.Template.Approach;
import net.taylor.mda.generator.parse.MdaHelper;
import net.taylor.mda.generator.parse.NameRuled.UmlClassByPropertyWrap;
import net.taylor.mda.generator.preferences.Preferences;
import net.taylor.mda.generator.util.ClassHelper;
import net.taylor.mda.generator.util.MavenHelper;
import net.taylor.mda.generator.util.NameHelper;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.codegen.jet.JETEmitter;
import org.eclipse.emf.codegen.jet.JETException;
import org.eclipse.emf.codegen.merge.java.JControlModel;
import org.eclipse.emf.codegen.merge.java.JMerger;
import org.eclipse.emf.codegen.util.CodeGenUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;

public class BasicTemplateProcessor implements TemplateProcessor {

	protected IProgressMonitor monitor = null;

	public void generate(Element element, Template template,
			IProgressMonitor monitor) {
		this.monitor = monitor;
		try {
			String src = generate(element, template);
			IFile file = getFile((NamedElement) element, template);
			save(file, src,	template.ifExists, element);
		} catch (Exception e) {
			String[] path = getTemplatePath(template);
			throw new RuntimeException(path[0] + " : " + path[1]+":"+e.getMessage(), e);
		}
	}

	protected String generate(Object element, Template template) throws Exception {
		JETEmitter emitter = getEmitter(template);
		Object[] arguments = new Object[] { element };
		return emitter.generate(monitor, arguments);
	}

	// --- File -----------------------------------------------------
	
	protected IFile getFile(NamedElement element, Template template)
			throws CoreException {
		if (element.getQualifiedName() == null) {
			throw new RuntimeException(
					"Element must have a fully qualified name. "
							+ " Check package and model names. " + element);
		}
		
		String name = getFileName(element, template);
		IProject project = getProject(element, template);
		IFile file = project.getFile(name);
		return file;
	}

	protected void save(IFile file, String code, Approach ifExists, Element element)
			throws CoreException {
		monitor.worked(1);
		boolean create = true;
//		if ("java".equals(file.getFileExtension())) {
//			code = formatCode(code, file.getName());
//			Engine.addJavaFile(file);
//		}
		if (file.exists()) {
//			if ("properties".equals(file.getFileExtension())) {
//				code = mergeProperties(code, file, null);
//				println(" - merged");
//				create = false;
//			} else 
			if (ifExists.equals(Approach.merge)) {
				code = merge(code, file);
				log(" - merged");
				create = false;
				// file.delete(true, true, monitor);
			} else if (ifExists.equals(Approach.backup)
					|| isIgnoreSkip(element)) {
				if (file.isReadOnly()) {
					file.getFullPath().addFileExtension("new");
					create = true;
				} else {
					if (!Preferences.isSkipBackup()) {
						renameFile(file);
						log(" - backed up");
					} else {
						log(" - ignored skip");
					}
					create = false;
				}
				// file.delete(true, true, monitor);
			} else if (ifExists.equals(Approach.skip)) {
				log(" - skipped");
				return;
			} else {
				throw new RuntimeException("Unknown approach: " + ifExists);
			}
		}
		if (file.getParent() instanceof IFolder)
			prepareFolder((IFolder) file.getParent());

		if (create) {
			log(" - created");
			file.create(new ByteArrayInputStream(code.getBytes()), true,
					monitor);
		} else {
			file.setContents(new ByteArrayInputStream(code.getBytes()),
					IFile.FORCE | IFile.KEEP_HISTORY, monitor);
		}
	}
	
	protected String getFileName(NamedElement element, Template template) {
		Model m=element.getModel();
		String modelNameByRel="";
		String modelNameByRelUncap="";
		String propertyOwnerClassUncapName="";
		if(element instanceof Property){
			Property property=(Property)element;
//			if(!ClassHelper.isSimple(property)){
//				modelNameByRel=MdaHelper.getModelNameByRel((org.eclipse.uml2.uml.Class)property.getOwner(), property.getType());
//			}
			UmlClassByPropertyWrap named=new UmlClassByPropertyWrap(property);
			modelNameByRel=named.getClassByPropetyName();
			modelNameByRelUncap=NameHelper.uncapName(modelNameByRel);
			propertyOwnerClassUncapName=NameHelper.getUncapName((org.eclipse.uml2.uml.Class)property.getOwner());
		}else{
			propertyOwnerClassUncapName=NameHelper.getUncapName(element);
		}
		String model="";
		if(null!=m){
			model = element.getModel().getName().toLowerCase().replaceAll("_", ".");
			String model2 = model.replaceAll("-", ".");
			String qn = element.getQualifiedName().replaceAll("::", "-");
			String path = getPackageDir(element);
			String name = NameHelper.removeSpaces(element.getName());
			String capName = NameHelper.toUpperCamel(element.getName());
			String uncapName=NameHelper.getUncapName(element);
			String parent = "";
			NamedElement parentElement = null;
			if (element.getOwner() instanceof NamedElement) {
				parentElement = ((NamedElement) element.getOwner());
				parent = parentElement.getName();
			}
			String parentParent = "";
			if (parentElement != null && parentElement.getOwner() instanceof NamedElement) {
				parentParent = ((NamedElement) parentElement.getOwner()).getName();
			}
			
			String pattern = getOutputPattern(element, template);
			MessageFormat format = new MessageFormat(pattern);
			
			//filter package 
			String namespacePrefixDir=MdaHelper.getNamespacePrefixDir();
			String modelPackageDirFilterNamespace=MdaHelper.getPackageDirFilterNamespacePrefix(element.getNearestPackage());
			String lastIndexName=name.substring(name.lastIndexOf(".")+1);
			String lastIndexCapName=NameHelper.capName(lastIndexName);
			String propertyClassUncapName=null;
			if(element instanceof Property){
				propertyClassUncapName=NameHelper.getUncapName(((Property)element).getType());
			}
			return format.format(new Object[] { path, name,parent, qn, model, model2, parentParent, capName,
					namespacePrefixDir,modelPackageDirFilterNamespace,lastIndexName,lastIndexCapName,uncapName,modelNameByRel,propertyClassUncapName,propertyOwnerClassUncapName,modelNameByRelUncap });
		}else{
			model=element.getName().toLowerCase().replaceAll("_", ".");
			String model2 = model.replaceAll("-", ".");
			String qn = element.getQualifiedName().replaceAll("::", "-");
			String path = getProfileDir(element);
			String name = NameHelper.removeSpaces(element.getName());
			String capName = NameHelper.toUpperCamel(element.getName());
			String uncapName=NameHelper.getUncapName(element);
			String parent = "";
			NamedElement parentElement = null;
			if (element.getOwner() instanceof NamedElement) {
				parentElement = ((NamedElement) element.getOwner());
				parent = parentElement.getName();
			}
			String parentParent = "";
			if (parentElement != null && parentElement.getOwner() instanceof NamedElement) {
				parentParent = ((NamedElement) parentElement.getOwner()).getName();
			}
			
			String pattern =  template.outputPattern;
			MessageFormat format = new MessageFormat(pattern);
			
			//filter package 
			String namespacePrefixDir=MdaHelper.getNamespacePrefixDir();
			String modelPackageDirFilterNamespace=MdaHelper.getPackageDirFilterNamespacePrefix(element.getNearestPackage());
			String lastIndexName=name.substring(name.lastIndexOf(".")+1);
			String lastIndexCapName=NameHelper.capName(lastIndexName);
			String propertyClassUncapName=null;
			if(element instanceof Property){
				propertyClassUncapName=NameHelper.getUncapName(((Property)element).getType());
			}
			return format.format(new Object[] { path, name,parent, qn, model, model2, parentParent,capName,
					namespacePrefixDir,modelPackageDirFilterNamespace,lastIndexName,lastIndexCapName,uncapName,modelNameByRel,propertyClassUncapName,propertyOwnerClassUncapName,modelNameByRelUncap});
		}
	}

	protected String getPackageDir(NamedElement element) {
		String qn = element.getNearestPackage().getQualifiedName();
		qn = qn.replaceAll("\\.", "/");
		qn = qn.replaceAll("::", "/");
		qn = NameHelper.toLowerCamel(qn);
//		if (element instanceof Package) {
			return qn.substring(qn.indexOf("/") + 1) + "/";
//		} else {
//			return qn.substring(qn.indexOf("/") + 1, qn.lastIndexOf("/")) + "/";
//		}
	}

	protected String getProfileDir(NamedElement element) {
		String qn = element.getNearestPackage().getQualifiedName();
		qn = qn.replaceAll("\\.", "/");
		qn = qn.replaceAll("::", "/");
		qn = NameHelper.toLowerCamel(qn);
//		if (element instanceof Package) {
			return qn + "/";
//		} else {
//			return qn.substring(qn.indexOf("/") + 1, qn.lastIndexOf("/")) + "/";
//		}
	}
	
	protected IProject getProject(Element element, Template template)
			throws CoreException {
		String name = getProjectName(element, template);
		String suffix = getProjectSuffix(element, template);
		if (suffix != null && suffix.length() != 0) {
			name = name + "-" + suffix;
		}
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(
				name);
		if (!project.exists()) {
			String parentId = getParentId(element.getNearestPackage());
			if (name.equals(parentId)) {
				project.create(monitor);				
			} else {
				IProject parent = ResourcesPlugin.getWorkspace().getRoot().getProject(
						parentId);
				if (!parent.exists()) {
					parent.create(monitor);
				}
				if (!parent.isOpen()) {
					parent.open(monitor);
				}
				IProjectDescription description = ResourcesPlugin
						.getWorkspace().newProjectDescription(name);
				description.setLocation(parent.getLocation().append(name));

				project.create(description, monitor);			
			}
		}
		if (!project.isOpen()) {
			project.open(monitor);
		}
		return project;
	}

	protected void prepareFolder(IFolder folder) throws CoreException {
		IContainer parent = folder.getParent();
		if (parent instanceof IFolder) {
			prepareFolder((IFolder) parent);
		}
		if (!folder.exists()) {
			folder.create(true, true, monitor);
		}
	}

	protected void renameFile(IFile file) throws CoreException {
		//long time = System.currentTimeMillis();
		DateFormat format = new SimpleDateFormat("yyyyMMdd-HHmmss");
    	String time=format.format(new Date());
		IPath destination = file.getFullPath().addFileExtension("bak." + time);
		file.copy(destination, true, monitor);
	}

	// ---- JET -----------------------------------------------------
	
	protected static Map<String, JETEmitter> emitters = new HashMap<String, JETEmitter>();

	public static void clearTemplateCache() {
		emitters.clear();
	}

	protected JETEmitter getEmitter(Template template) {
		JETEmitter emitter = emitters.get(template.path);
		if (emitter == null) {
			String[] path = getTemplatePath(template);
			ClassLoader classloader = getClass().getClassLoader();
			emitter = new JETEmitter(path, template.path, classloader);
			try {
				// TODO add these as extensions???
				emitter
						.addVariable("MDA_GENERATOR",
								"net.taylor.mda.generator");
				// emitter.addVariable(template.plugin, template.plugin);
				emitter.addVariable("UML2", "org.eclipse.uml2.uml");
				emitter.addVariable("EMF_CODEGEN", "org.eclipse.emf.codegen");
				emitter.addVariable("EMF_COMMON", "org.eclipse.emf.common");
				emitter.addVariable("EMF_CODEGEN_ECORE",
						"org.eclipse.emf.codegen.ecore");
				emitter.addVariable("EMF_ECORE", "org.eclipse.emf.ecore");

				setStaticTemplateClass(emitter, template);
			} catch (JETException e) {
				throw new RuntimeException(e);
			}
			emitters.put(template.path, emitter);
		}
		return emitter;
	}

	protected void setStaticTemplateClass(JETEmitter jetEmitter,
			Template template) {
		if (template.templateClassName == null
				|| template.templateClassName.length() == 0) {
			return;
		}
		try {
			Class templateClass = getClass().getClassLoader().loadClass(
					template.templateClassName);
			Method emitterMethod = templateClass.getDeclaredMethod("generate",
					new Class[] { Object.class });
			jetEmitter.setMethod(emitterMethod);
		} catch (Exception exception) {
			// It's okay for there not be a precompiled template, so fail
			// quietly.
		}
	}

	protected String[] getTemplatePath(Template template) {
		String[] path = new String[2];
		path[0] = Preferences.getTemplateRoot(); // TODO override on stereotype as well
		path[1] = Platform.getBundle(template.plugin).getEntry("/").toString()
				+ "/templates";// TODO
		return path;
	}

	// --- JMerge ---------------------------------------------------
	
	protected String merge(String generated, IFile file) {

		try {
			// log("generated: " + generated);
			JMerger merger = getJMerger();
			merger.setSourceCompilationUnit(merger
					.createCompilationUnitForContents(generated));
			merger.setTargetCompilationUnit(merger
					.createCompilationUnitForInputStream(file.getContents()));
			merger.merge();

			return merger.getTargetCompilationUnitContents();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected JMerger getJMerger() {
		String uri = Platform.getBundle(GeneratorPlugin.PLUGIN_ID)
				.getEntry("/").toString()
				+ "templates/merge.xml";
		JControlModel jControlModel = new JControlModel();
		jControlModel.initialize(CodeGenUtil
				.instantiateFacadeHelper(JMerger.DEFAULT_FACADE_HELPER_CLASS),
				uri);
		JMerger jmerger = new JMerger(jControlModel);
		return jmerger;
	}
	

	// --- Maven ----------------------------------------------------
	
	protected String getOutputPattern(NamedElement element, Template template) {
		return MavenHelper.getOutputPattern(element, template);
	}
	
	protected String getParentId(Package nearestPackage) {
		return MavenHelper.getParentId(nearestPackage);
	}

	protected String getProjectSuffix(Element element, Template template) {
		return MavenHelper.getProjectSuffix(element, template);
	}

	protected String getProjectName(Element element, Template template) {
		return MavenHelper.getProjectName(element, template);
	}

	protected boolean isIgnoreSkip(Element element) {
		return MavenHelper.isIgnoreSkip(element);
	}
	
	// --- Other ----------------------------------------------------

	protected void log(String text) {
		Console.getStream().println(text);
	}
	
	/**
	 * Use the default JDT code formatter to format the given compilation unit
	 * contents.
	 */
//	protected String formatCode(String contents, String filename) {
//		// http://dev.eclipse.org/viewcvs/index.cgi/org.eclipse.emf/org.eclipse.emf.search/plugins/org.eclipse.emf.search.codegen/src/org/eclipse/emf/search/codegen/engine/AbstractEMFCodeGenerator.java?root=Modeling_Project&view=co
//		// Create a code formatter for this compilation unit
//		CodeFormatter codeFormatter = ToolFactory.createCodeFormatter(null);
//		IDocument doc = new Document(contents);
//		TextEdit edit = codeFormatter.format(CodeFormatter.K_COMPILATION_UNIT,
//				doc.get(), 0, doc.get().length(), 0, null);
//
//		try {
//			if (edit != null) {
//				edit.apply(doc);
//				contents = doc.get();
//			} else {
//				IStatus s = new Status(IStatus.ERROR,
//						GeneratorPlugin.PLUGIN_ID, "Error formmating file: "
//								+ filename);
//				GeneratorPlugin.getDefault().getLog().log(s);
//			}
//		} catch (MalformedTreeException e) {
//			throw new RuntimeException(e);
//		} catch (BadLocationException e) {
//			throw new RuntimeException(e);
//		}
//		return contents;
//	}

	/**
	 * Perform a Properties merge.
	 */
//	protected String mergeProperties(String generatedString, IFile targetFile,
//			IProgressMonitor monitor) throws CoreException {
//		String newContents = generatedString;
//		if (targetFile.exists()) {
//			PropertyMerger propertyMerger = new PropertyMerger();
//			propertyMerger.setSourceProperties(generatedString);
//			// monitor.subTask(Messages.getString("AbstractEMFCodeGenerator.MessagesParsingError1"));
//			// //$NON-NLS-1$
//			String oldProperties = propertyMerger
//					.createPropertiesForInputStream(targetFile.getContents());
//			propertyMerger.setTargetProperties(oldProperties);
//			// monitor.subTask(Messages.getString("AbstractEMFCodeGenerator.MessagesParsingError2"));
//			// //$NON-NLS-1$
//			propertyMerger.merge();
//
//			String mergedResult = propertyMerger.getTargetProperties();
//			if (!mergedResult.equals(oldProperties)) {
//				// If the target is read-only, we can ask the platform to
//				// release it, and it may be updated in the process.
//				//
//				if (targetFile.isReadOnly() && validateEdit(targetFile)) {
//					propertyMerger.setTargetProperties(propertyMerger
//							.createPropertiesForInputStream(targetFile
//									.getContents()));
//					propertyMerger.merge();
//					mergedResult = propertyMerger.getTargetProperties();
//				}
//			}
//		}
//		return newContents;
//	}

	/**
	 * Check whether the file can be modified
	 */
//	protected static boolean validateEdit(IFile file) {
//		return file.getWorkspace().validateEdit(new IFile[] { file }, null)
//				.isOK();
//	}
}
