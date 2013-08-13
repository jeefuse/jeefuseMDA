package com.jeefuse.base.web.tag;

import javax.servlet.jsp.JspException;

import com.jeefuse.base.web.tag.util.TagBuilder;

/**
 * html element基本可选属性.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public abstract class AbstractHtmlElementTag extends AbstractTagSupport {
	private static final long serialVersionUID = 1L;

	public static final String LANG_ATTRIBUTE = "lang";
	public static final String TITLE_ATTRIBUTE = "title";
	public static final String DIR_ATTRIBUTE = "dir";
	public static final String TABINDEX_ATTRIBUTE = "tabindex";
	public static final String ONCLICK_ATTRIBUTE = "onclick";
	public static final String ONDBLCLICK_ATTRIBUTE = "ondblclick";
	public static final String ONMOUSEDOWN_ATTRIBUTE = "onmousedown";
	public static final String ONMOUSEUP_ATTRIBUTE = "onmouseup";
	public static final String ONMOUSEOVER_ATTRIBUTE = "onmouseover";
	public static final String ONMOUSEMOVE_ATTRIBUTE = "onmousemove";
	public static final String ONMOUSEOUT_ATTRIBUTE = "onmouseout";
	public static final String ONKEYPRESS_ATTRIBUTE = "onkeypress";
	public static final String ONKEYUP_ATTRIBUTE = "onkeyup";
	public static final String ONKEYDOWN_ATTRIBUTE = "onkeydown";
	public static final String ONFOCUS_ATTRIBUTE = "onfocus";
	public static final String ONBLUR_ATTRIBUTE = "onblur";
	public static final String ONCHANGE_ATTRIBUTE = "onchange";
	public static final String ACCESSKEY_ATTRIBUTE = "accesskey";
	public static final String DISABLED_ATTRIBUTE = "disabled";
	public static final String READONLY_ATTRIBUTE = "readonly";
	private String lang;
	private String title;
	private String dir;
	private String tabindex;
	private String onclick;
	private String ondblclick;
	private String onmousedown;
	private String onmouseup;
	private String onmouseover;
	private String onmousemove;
	private String onmouseout;
	private String onkeypress;
	private String onkeyup;
	private String onkeydown;
	private String onfocus;
	private String onblur;
	private String onchange;
	private String accesskey;
	private boolean disabled;
	private boolean readonly;

	/**
	 * 设置属性,若属性值不为空刚设置，否则不设置，设置的属性为title,dir,lang,tabindex,及input节点事件属性.
	 * 
	 * @param tagBuilder
	 * @throws JspException
	 */
	protected void writeOptionalAttributes(TagBuilder tagBuilder) throws JspException {
		tagBuilder.writeOptionalAttributeValue(TITLE_ATTRIBUTE, getTitle());
		tagBuilder.writeOptionalAttributeValue(DIR_ATTRIBUTE, getDir());
		tagBuilder.writeOptionalAttributeValue(LANG_ATTRIBUTE, getLang());
		tagBuilder.writeOptionalAttributeValue(TABINDEX_ATTRIBUTE, getTabindex());
		tagBuilder.writeOptionalAttributeValue(ONCLICK_ATTRIBUTE, getOnclick());
		tagBuilder.writeOptionalAttributeValue(ONDBLCLICK_ATTRIBUTE, getOndblclick());
		tagBuilder.writeOptionalAttributeValue(ONBLUR_ATTRIBUTE, getOnblur());
		tagBuilder.writeOptionalAttributeValue(ONCHANGE_ATTRIBUTE, getOnchange());
		tagBuilder.writeOptionalAttributeValue(ONFOCUS_ATTRIBUTE, getOnfocus());
		tagBuilder.writeOptionalAttributeValue(ONMOUSEDOWN_ATTRIBUTE, getOnmousedown());
		tagBuilder.writeOptionalAttributeValue(ONMOUSEUP_ATTRIBUTE, getOnmouseup());
		tagBuilder.writeOptionalAttributeValue(ONMOUSEOVER_ATTRIBUTE, getOnmouseover());
		tagBuilder.writeOptionalAttributeValue(ONMOUSEMOVE_ATTRIBUTE, getOnmousemove());
		tagBuilder.writeOptionalAttributeValue(ONMOUSEOUT_ATTRIBUTE, getOnmouseout());
		tagBuilder.writeOptionalAttributeValue(ONKEYPRESS_ATTRIBUTE, getOnkeypress());
		tagBuilder.writeOptionalAttributeValue(ONKEYUP_ATTRIBUTE, getOnkeyup());
		tagBuilder.writeOptionalAttributeValue(ONKEYDOWN_ATTRIBUTE, getOnkeydown());
		tagBuilder.writeOptionalAttributeValue(ACCESSKEY_ATTRIBUTE, getAccesskey());
		if (isDisabled()) {
			tagBuilder.writeAttribute(DISABLED_ATTRIBUTE, "disabled");
		}
		if (isReadonly()) {
			tagBuilder.writeAttribute(READONLY_ATTRIBUTE, "readonly");
		}

	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public String getTabindex() {
		return tabindex;
	}

	public void setTabindex(String tabindex) {
		this.tabindex = tabindex;
	}

	public String getOnclick() {
		return onclick;
	}

	public void setOnclick(String onclick) {
		this.onclick = onclick;
	}

	public String getOndblclick() {
		return ondblclick;
	}

	public void setOndblclick(String ondblclick) {
		this.ondblclick = ondblclick;
	}

	public String getOnmousedown() {
		return onmousedown;
	}

	public void setOnmousedown(String onmousedown) {
		this.onmousedown = onmousedown;
	}

	public String getOnmouseup() {
		return onmouseup;
	}

	public void setOnmouseup(String onmouseup) {
		this.onmouseup = onmouseup;
	}

	public String getOnmouseover() {
		return onmouseover;
	}

	public void setOnmouseover(String onmouseover) {
		this.onmouseover = onmouseover;
	}

	public String getOnmousemove() {
		return onmousemove;
	}

	public void setOnmousemove(String onmousemove) {
		this.onmousemove = onmousemove;
	}

	public String getOnmouseout() {
		return onmouseout;
	}

	public void setOnmouseout(String onmouseout) {
		this.onmouseout = onmouseout;
	}

	public String getOnkeypress() {
		return onkeypress;
	}

	public void setOnkeypress(String onkeypress) {
		this.onkeypress = onkeypress;
	}

	public String getOnkeyup() {
		return onkeyup;
	}

	public void setOnkeyup(String onkeyup) {
		this.onkeyup = onkeyup;
	}

	public String getOnkeydown() {
		return onkeydown;
	}

	public void setOnkeydown(String onkeydown) {
		this.onkeydown = onkeydown;
	}

	public String getOnfocus() {
		return onfocus;
	}

	public void setOnfocus(String onfocus) {
		this.onfocus = onfocus;
	}

	public String getOnblur() {
		return onblur;
	}

	public void setOnblur(String onblur) {
		this.onblur = onblur;
	}

	public String getOnchange() {
		return onchange;
	}

	public void setOnchange(String onchange) {
		this.onchange = onchange;
	}

	public String getAccesskey() {
		return accesskey;
	}

	public void setAccesskey(String accesskey) {
		this.accesskey = accesskey;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public boolean isReadonly() {
		return readonly;
	}

	public void setReadonly(boolean readonly) {
		this.readonly = readonly;
	}

}
