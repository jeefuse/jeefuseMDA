package com.jeefuse.base.web.action;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Action基类,提供基本的web操作.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
@SuppressWarnings("serial")
public class BaseAction extends ActionSupport {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	/**
	 * 没有权限.
	 */
	public static final String NO_AUTHORITY = "noAuthority";
	/**
	 * 用户未登录.
	 */
	public static final String NO_LOGIN = "nologin";

	
	public HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	public HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}

	public HttpSession getSession() {
		return ServletActionContext.getRequest().getSession();
	}

	/**
	 * 取得Request Parameter.
	 */
	public String getRequestParam(String paramName) {
		return getRequest().getParameter(paramName);
	}

	/**
	 * 取得Request Attribute.
	 */
	public Object getRequestAttribute(String attrName) {
		return getRequest().getAttribute(attrName);
	}

	/**
	 * 取得Session Attribute.
	 */
	public Object getSessionAttribute(String attrName) {
		return getSession().getAttribute(attrName);
	}

	public Collection<String> getActionErrorsOrNull() {
		Collection<String> errors = getActionErrors();
		if (null == errors || errors.isEmpty())
			return null;
		return errors;
	}

}
