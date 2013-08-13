package net.taylor.mda.generator.parse.page.render;

import net.taylor.mda.generator.parse.entity.Config;
import net.taylor.mda.generator.util.NameHelper;
import net.taylor.mda.generator.util.StereotypeHelper;

import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Property;

import net.jeefuse.mda.annotations.MdaStereotype;

public class ImageRender implements Render {
	protected String prefix = "model.";

	protected Class uml2Class = null;

	protected Property property = null;

	protected Property parent = null;

	protected StringBuffer tag = null;

	public ImageRender(String prefix, Class uml2Class, Property property, Property parent) {
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
	}

	protected void attributes() {
		type();
		id();
		value();
		onchange();
		styleClass();
	}
	
	protected void onchange(){
		tag.append(" onchange=\"validateImage(this,'previewImage');") ;
	}

	protected String getFileAcceptType(){
		return Config.imageDeaultAcceptType;
	}
	
	protected void styleClass() {
		tag.append( "class=\"image");
		if (isRequired()) {
			tag.append(" required");
		}
		tag.append("\"");
	}

	protected boolean isRequired() {

		if (StereotypeHelper.isStereotypeApplied(property, StereotypeHelper.NOT_NULL)) {
			return true;
		} else if (StereotypeHelper.isStereotypeApplied(property, "net.taylor.validator.Required")) {
			return true;
		/*} else if (StereotypeHelper.isStereotypeApplied(property, StereotypeHelper.LENGTH)) {
			Object min = StereotypeHelper.getValue(property, StereotypeHelper.LENGTH, "min");
			if (min instanceof Number) {
				if (((Number) (min)).intValue() > 0) {
					return true;
				}
			}*/
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

	protected void maxLength() {
		if (StereotypeHelper.isStereotypeApplied(property, StereotypeHelper.COLUMN)) {
			StereotypeHelper.getValue(property, StereotypeHelper.COLUMN, "length");
			// tag.append("maxLength=\"true\"");
		}
		if (StereotypeHelper.isStereotypeApplied(property, StereotypeHelper.LENGTH)) {
			StereotypeHelper.getValue(property, StereotypeHelper.LENGTH, "max");
			// tag.append("maxLength=\"true\"");
		}
	}

	protected void body() {

	}

	protected void endTag() {
		// tag.append(NEWLINE);
		// tag.append(BASE_TAB);
		// tag.append(TAB);
		// tag.append(TAB);
		// tag.append("</");
		// tagName();
		tag.append(" />");
	}

	protected void tagName() {
		//tag.append("tt:input");
		tag.append("input");
	}

	protected void value() {
		// tag.append(TAB);
		tag.append(" value=\"${");
		tag.append(prefix);// +
		tag.append(".");
		tag.append(NameHelper.uncapSafeName(property));
		tag.append("}\"");
	}

	protected void type() {
		tag.append(" type=\"");
		tag.append("file");
		tag.append("\"");
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
