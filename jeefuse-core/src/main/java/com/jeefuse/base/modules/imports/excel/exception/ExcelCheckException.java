package com.jeefuse.base.modules.imports.excel.exception;

import com.jeefuse.base.exception.ApplicationException;

/**
 * excel 检查异常.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public class ExcelCheckException extends ApplicationException {

	private static final long serialVersionUID = 1L;

	public ExcelCheckException(String message, Throwable cause) {
		super(message, cause);

	}

	public ExcelCheckException(String message) {
		super(message);

	}

	public ExcelCheckException(Throwable cause) {
		super(cause);

	}

}
