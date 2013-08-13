package com.jeefuse.base.service.exception;

/**未登入异常,系统发生此异常时将会提示用户,要求进行登录操作.
 * @author  yonclv
 * @created 2009-8-13
 */
@SuppressWarnings("serial")
public class NoLoginException extends ServiceException {

	public NoLoginException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public NoLoginException(String message) {
		super(message);
		
	}

	public NoLoginException(Throwable cause) {
		super(cause);
		
	}

}
