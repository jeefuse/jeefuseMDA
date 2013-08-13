package com.jeefuse.base.web.tag.keyLabel;

import java.util.Arrays;
import java.util.List;

import javax.servlet.jsp.JspException;

import org.apache.commons.lang.StringUtils;

import com.jeefuse.base.modules.keyLabel.KeyLabel;
import com.jeefuse.base.web.tag.AbstractHtmlElementTag;
import com.jeefuse.base.web.tag.util.TagBuilder;

/**
 * keyLabel列表渲染html select标签.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public class KeyLabelSelectTag<T extends KeyLabel> extends AbstractHtmlElementTag {
	private static final long serialVersionUID = 1L;
	public static final String ID_ATTRIBUTE = "id";
	public static final String NAME_ATTRIBUTE = "name";
	public static final String TYPE_ATTRIBUTE = "type";
	public static final String CLASS_ATTRIBUTE = "class";
	public static final String STYLE_ATTRIBUTE = "style";
	private String name;
	private String cssClass;
	private String cssStyle;
	private List<T> keyLabels;
	private String value;
	private Integer defaultValueIdx;// 当值为空时，选择指定序号的值
	private String headerLabel;// 添加在顶部的显示label
	private String headerValue;// 添加在顶部的值
	private String defaultValue;// 默认值

	@Override
	protected int writeTagContent(TagBuilder tagBuilder) throws JspException {
		if (null == keyLabels || keyLabels.size() == 0)
			return 0;
		tagBuilder.append("<select");
		tagBuilder.writeAttribute(NAME_ATTRIBUTE, name);
		tagBuilder.writeOptionalAttributeValue(ID_ATTRIBUTE, name);
		tagBuilder.writeOptionalAttributeValue(STYLE_ATTRIBUTE, getCssStyle());
		writeOptionalAttributes(tagBuilder);
		tagBuilder.append(" >");
		if (null != headerLabel || null != headerValue) {
			tagBuilder.append(" <option value=\"").append(headerValue).append("\"");
			tagBuilder.append(">");
			tagBuilder.append(headerLabel);
			tagBuilder.append("</option>");
		}
		for (int i = 0, loop = keyLabels.size(); i < loop; i++) {
			KeyLabel item = keyLabels.get(i);
			//input radio
			tagBuilder.append(" <option value=\"").append(item.getKey()).append("\"");
			if (StringUtils.isNotBlank(value)&&item.getKey().equals(value)) {
					tagBuilder.append(" selected=\"selected\" ");
			} else if(null != defaultValueIdx && i == defaultValueIdx) {
					tagBuilder.append(" selected=\"selected\" ");
			} else if (null != defaultValue && defaultValue.equals(item.getKey())) {
				tagBuilder.append(" selected=\"selected\" ");
			}
			tagBuilder.append(">");
			tagBuilder.append(item.getLabel());
			tagBuilder.append("</option>");
		}
		tagBuilder.append(" </select>");
		return 0;
	}

	public List<T> getKeyLabels() {
		return keyLabels;
	}

	public void setKeyLabels(List<T> keyLabels) {
		this.keyLabels = keyLabels;
	}

	public void setKeyLabels(T[] keyLabels) {
		if (null != keyLabels) {
			this.keyLabels = Arrays.asList(keyLabels);
		}
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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Integer getDefaultValueIdx() {
		return defaultValueIdx;
	}

	public void setDefaultValueIdx(Integer defaultValueIdx) {
		this.defaultValueIdx = defaultValueIdx;
	}

	public String getHeaderLabel() {
		return headerLabel;
	}

	public void setHeaderLabel(String headerLabel) {
		this.headerLabel = headerLabel;
	}

	public String getHeaderValue() {
		return headerValue;
	}

	public void setHeaderValue(String headerValue) {
		this.headerValue = headerValue;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
}
