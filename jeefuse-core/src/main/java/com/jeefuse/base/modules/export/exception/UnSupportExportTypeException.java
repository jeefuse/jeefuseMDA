package com.jeefuse.base.modules.export.exception;

import com.jeefuse.base.exception.ApplicationException;

public class UnSupportExportTypeException extends ApplicationException {

	private static final long serialVersionUID = 1L;

	public UnSupportExportTypeException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public UnSupportExportTypeException(String message) {
		super(message);
		
	}

	public UnSupportExportTypeException(Throwable cause) {
		super(cause);
		
	}

}
