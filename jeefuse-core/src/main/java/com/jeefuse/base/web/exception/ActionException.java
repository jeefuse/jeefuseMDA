package com.jeefuse.base.web.exception;


/**Action操作异常.
 * @author yonclv
 * @email  yonclv@gmail.com
 */
@SuppressWarnings("serial")
public class ActionException extends WebException {


	public ActionException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public ActionException(String message) {
		super(message);
		
	}

	public ActionException(Throwable cause) {
		super(cause);
		
	}

}
