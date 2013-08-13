package com.jeefuse.base.web.tag.keyLabel;

import java.util.List;

import javax.servlet.jsp.JspException;

import org.apache.commons.lang.StringUtils;

import com.jeefuse.base.modules.keyLabel.KeyLabel;
import com.jeefuse.base.web.tag.AbstractHtmlElementTag;
import com.jeefuse.base.web.tag.util.TagBuilder;

/**
 * 抽象keyLabel列表渲染html Radio标签.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public abstract class AbstractKeyLabelRadioTag<T extends KeyLabel> extends AbstractHtmlElementTag {
	private static final long serialVersionUID = 1L;
	public static final String ID_ATTRIBUTE = "id";
	public static final String NAME_ATTRIBUTE = "name";
	public static final String TYPE_ATTRIBUTE = "type";
	public static final String CLASS_ATTRIBUTE = "class";
	public static final String STYLE_ATTRIBUTE = "style";
	private String name;
	private String cssClass;
	private String cssStyle;
	private String value;
	private String defaultValue;// 默认值

	public abstract List<T> getKeyLabels();

	@Override
	protected int writeTagContent(TagBuilder tagBuilder) throws JspException {
		List<T> keyLabels = getKeyLabels();
		if (null == keyLabels || keyLabels.size() == 0)
			return 0;
		if (StringUtils.isBlank(value)) {
			if (StringUtils.isNotBlank(defaultValue)) {
				value = defaultValue;
			}
		}
		for (int i = 0, loop = keyLabels.size(); i < loop; i++) {
			KeyLabel keyLabel = keyLabels.get(i);
			// input radio
			tagBuilder.append("<input");
			String inputId = getName() + "_" + i;
			tagBuilder.writeAttribute(ID_ATTRIBUTE, inputId);
			tagBuilder.writeAttribute(TYPE_ATTRIBUTE, "radio");
			tagBuilder.writeAttribute(NAME_ATTRIBUTE, getName());
			tagBuilder.writeAttribute("value", keyLabel.getKey());
			if (keyLabel.getKey().equals(value)) {
				tagBuilder.append(" checked='checked'");
			}
			if (null == getCssClass()) {
				tagBuilder.writeAttribute(CLASS_ATTRIBUTE, "radio");
			} else {
				tagBuilder.writeAttribute(CLASS_ATTRIBUTE, getCssClass());
			}
			tagBuilder.writeOptionalAttributeValue(STYLE_ATTRIBUTE, getCssStyle());
			writeOptionalAttributes(tagBuilder);
			tagBuilder.append(" />");
			// label
			tagBuilder.append("<label");
			tagBuilder.writeAttribute("for", inputId);
			tagBuilder.writeAttribute("class", "forInput");
			tagBuilder.append(" >");
			tagBuilder.append(keyLabel.getLabel());
			tagBuilder.append("</label>");
		}
		return 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	public String getCssStyle() {
		return cssStyle;
	}

	public void setCssStyle(String cssStyle) {
		this.cssStyle = cssStyle;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
