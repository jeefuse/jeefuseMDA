package com.jeefuse.base.exception;

/**
 * 无效状态异常.
 * @author yonclv
 * 2009-10-20
 */
@SuppressWarnings("serial")
public class InvalidStateException extends ApplicationException {

	public InvalidStateException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public InvalidStateException(String message) {
		super(message);
		
	}

	public InvalidStateException(Throwable cause) {
		super(cause);
		
	}

}
