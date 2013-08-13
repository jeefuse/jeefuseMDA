package com.jeefuse.base.exception;

import java.util.List;

/**
 * 约束违反异常.继承自应用异常ApplicationException.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public class ValidateViolationException extends ApplicationException {
	private static final long serialVersionUID = 1L;
	private List<String> errors;

	public ValidateViolationException() {
		super();
	}

	public ValidateViolationException(String message) {
		super(message);
	}

	public ValidateViolationException(String message, Throwable cause) {
		super(message, cause);
	}

	public ValidateViolationException(Throwable cause) {
		super(cause);
	}

	public ValidateViolationException(String message, List<String> errors) {
		super(message);
		this.errors = errors;
	}

	public ValidateViolationException(List<String> errors) {
		super();
		this.errors = errors;
	}

	/*
	 * 返回所有验证出错信息字符串.
	 * 
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		StringBuilder sb = new StringBuilder(64);
		if (null != super.getMessage()) {
			sb.append(super.getMessage() + "\n");
		}
		if (null != errors && !errors.isEmpty()) {
			for (String error : errors) {
				sb.append(error + "\n");
			}
		}
		return sb.toString();
	}

	/**
	 * @return the errors
	 */
	public List<String> getErrors() {
		return errors;
	}

}
