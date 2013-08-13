package com.jeefuse.base.exception;

/**
 * 加载文件异常.
 * 
 * @author yonclv 2009-10-20
 */
@SuppressWarnings("serial")
public class LoadFileException extends ApplicationException {

	public LoadFileException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public LoadFileException(String message) {
		super(message);
		
	}

	public LoadFileException(Throwable cause) {
		super(cause);
		
	}

}
