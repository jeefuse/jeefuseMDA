package net.taylor.mda.generator.engine;

public class Template {
	public enum Approach { merge, skip, backup	}
	
	public String id;
	
	public Approach ifExists;
	
	public String path;

	public String outputPattern;

	public String modelElement;
	
	public String processorClass;

	public String hasStereotype;

	public String templateClassName;

	public String projectSuffix;

	public String plugin;
}
