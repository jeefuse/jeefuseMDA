package com.jeefuse.base.exception;

/**
 * 无效数据异常.
 * @author yonclv
 * 2009-10-20
 */
@SuppressWarnings("serial")
public class InvalidDataException extends ApplicationException {

	public InvalidDataException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public InvalidDataException(String message) {
		super(message);
		
	}

	public InvalidDataException(Throwable cause) {
		super(cause);
		
	}

}
