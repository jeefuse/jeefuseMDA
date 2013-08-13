package com.jeefuse.base.web.exception;

import com.jeefuse.base.exception.ApplicationException;

/**
 * web 操作异常.
 * @author yonclv
 * 2009-10-12
 */
@SuppressWarnings("serial")
public class WebException extends ApplicationException {

	public WebException(String message) {
		super(message);
		
	}

	public WebException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public WebException(Throwable cause) {
		super(cause);
		
	}

}
