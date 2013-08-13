package com.jeefuse.base.web.tag.util;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;

import org.springframework.util.StringUtils;

/**
 * tag writer wrap.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public class TagBuilder {
	private final Writer writer;

	public TagBuilder(Writer writer) {
		this.writer = writer;
	}

	public TagBuilder(PageContext pageContext) {
		this.writer = pageContext.getOut();
	}

	/**
	 * 写入html 元素属性,格式:attributeName=attributeValue
	 * 
	 * @throws IOException
	 */
	public void writeAttribute(String attributeName, String attributeValue) throws JspException {
		this.append(" ").append(attributeName).append("=\"").append(attributeValue).append("\"");
	}

	/**
	 * 如果属性值不为则,写入html 元素属性,格式:attributeName=attributeValue
	 * 
	 * @throws IOException
	 */
	public void writeOptionalAttributeValue(String attributeName, String attributeValue) throws JspException {
		if (StringUtils.hasText(attributeValue)) {
			writeAttribute(attributeName, attributeValue);
		}
	}

	/**
	 * 追加字符串.
	 * 
	 * @throws JspException
	 * 
	 * @throws IOException
	 */
	public TagBuilder append(String value) throws JspException {
		try {
			writer.write(value);
			return this;
		} catch (IOException ex) {
			throw new JspException("Unable to write to JspWriter", ex);
		}
	}
}
