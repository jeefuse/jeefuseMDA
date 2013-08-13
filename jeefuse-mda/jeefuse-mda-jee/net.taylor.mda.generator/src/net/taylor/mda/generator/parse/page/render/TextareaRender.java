package net.taylor.mda.generator.parse.page.render;

import java.util.ArrayList;
import java.util.List;

import net.taylor.mda.generator.util.NameHelper;
import net.taylor.mda.generator.util.StereotypeHelper;

import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Property;

public class TextareaRender implements Render {

	protected String prefix = "model.";

	protected Class uml2Class = null;

	protected Property property = null;

	protected Property parent = null;

	protected StringBuffer tag = null;

	public TextareaRender(String prefix, Class uml2Class, Property property, Property parent) {
		this.prefix = prefix;
		this.parent = parent;
		this.uml2Class = uml2Class;
		this.property = property;
	}

	@Override
	public String render() {
		tag = new StringBuffer();
		startTag();
		body();
		endTag();
		return tag.toString();
	}

	protected void startTag() {
		tag.append("<");
		tagName();
		attributes();
		tag.append(">");
	}

	protected void attributes() {
		id();
		styleClass();
	}

	protected void styleClass() {
		List<String> cls=new ArrayList<String>();
		if (isRequired()) {
			cls.add("required");
		}
		for(int i=0;i<cls.size();i++){
			if(i>0){
				tag.append(" ");
			}
			tag.append(cls.get(i));
		}
	}

	protected boolean isRequired() {

		if (StereotypeHelper.isStereotypeApplied(property, StereotypeHelper.NOT_NULL)) {
			return true;
		} else if (StereotypeHelper.isStereotypeApplied(property, "net.taylor.validator.Required")) {
			return true;
		} else if (StereotypeHelper.isStereotypeApplied(property, StereotypeHelper.COLUMN)) {
			Object nullable = StereotypeHelper.getValue(property, StereotypeHelper.COLUMN, "nullable");
			if (nullable instanceof Boolean) {
				if (((Boolean) (nullable)).equals(Boolean.FALSE)) {
					return true;
				}
			}
		}
		return false;
	}

	protected void body() {
		tag.append("${");
		tag.append(prefix);// +
		tag.append(".");
		tag.append(NameHelper.uncapSafeName(property));
		tag.append("}\"");
	}

	protected void endTag() {
		tag.append("</textarea>");
	}

	protected void tagName() {
		tag.append("textarea");
	}

	protected void id() {
		tag.append(" id=\"");
		if (parent == null) {
			tag.append(NameHelper.uncapSafeName(property));
		} else {
			tag.append(NameHelper.uncapSafeName(parent));
			tag.append(".");
			tag.append(NameHelper.getCapName(property));
		}
		tag.append("\"");
	}

}
