package com.jeefuse.base.web.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.jeefuse.base.web.tag.util.TagBuilder;

public abstract class AbstractTagSupport extends TagSupport {
	private static final long serialVersionUID = 1L;

	protected TagBuilder createWriter() {
		return new TagBuilder(pageContext);
	}

	@Override
	public final int doStartTag() throws JspException {
		return writeTagContent(createWriter());
	}

	protected abstract int writeTagContent(TagBuilder writer) throws JspException;

}
