package com.jeefuse.base.dao;

import com.jeefuse.base.exception.ApplicationException;


/**DAO访问异常.
 * @author  yonclv
 * @created 2009-7-27
 */
@SuppressWarnings("serial")
public class DAOException extends ApplicationException {

	public DAOException(String s, Throwable throwable) {
		super(s, throwable);
		
	}

	public DAOException(String s) {
		super(s);
		
	}

	public DAOException(Throwable throwable) {
		super(throwable);
		
	}

}
