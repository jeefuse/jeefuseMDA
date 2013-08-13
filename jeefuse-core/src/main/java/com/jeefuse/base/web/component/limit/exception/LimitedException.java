package com.jeefuse.base.web.component.limit.exception;

import com.jeefuse.base.service.exception.ServiceException;

/**条件构造异常.
 * @author  yonclv
 * @created 2009-7-24
 */
@SuppressWarnings("serial")
public class LimitedException extends ServiceException {

	public LimitedException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public LimitedException(String message) {
		super(message);
		
	}

	public LimitedException(Throwable cause) {
		super(cause);
		
	}

}
