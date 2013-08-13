package com.jeefuse.base.service.exception;

import com.jeefuse.base.exception.ApplicationException;

/**Service层Exception.
 * 继承自ApplicationException,使异常抛出会触发Spring的事务管理引起事务回退.
 * @author yonclv
 * @email  yonclv@gmail.com
 */
public class ServiceException extends ApplicationException {

	private static final long serialVersionUID = 1401593546385403720L;


	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}
}
