package com.jeefuse.base.exception;

/**应用异常,定义从该类派生的异常为应用异常,应用程序的所有异常应衍生自该类,需要明确捕获异常,并记录异常信息.
 * 该异常继承自RuntimeException.
 * @author  yonclv
 * @created 2009-9-22
 */
@SuppressWarnings("serial")
public class ApplicationException extends RuntimeException {

	public ApplicationException(String message, Throwable cause) {
		super(message, cause);
	}

	public ApplicationException(String message) {
		super(message);
	}

	public ApplicationException(Throwable cause) {
		super(cause);
	}

	public ApplicationException() {
		super();
	}

}
