package com.jeefuse.base.exception;

/**
 * Input parameter is incorrect exception.
 * 
 * @author yonclv
 */
public class InvalidParamException extends ApplicationException {

	public InvalidParamException() {
		super("Input parameter is incorrect!");
	}

	public InvalidParamException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidParamException(String message) {
		super(message);
	}

	public InvalidParamException(Throwable cause) {
		super(cause);
	}

	private static final long serialVersionUID = 1L;

}
