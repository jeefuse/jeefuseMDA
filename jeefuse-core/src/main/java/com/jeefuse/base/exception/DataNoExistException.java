package com.jeefuse.base.exception;

/**
 * 数据不存在异常.
 * @author yonclv
 * 2009-10-20
 */
@SuppressWarnings("serial")
public class DataNoExistException extends ApplicationException {

	public DataNoExistException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public DataNoExistException(String message) {
		super(message);
		
	}

	public DataNoExistException(Throwable cause) {
		super(cause);
		
	}

}
