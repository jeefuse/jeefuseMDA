package com.jeefuse.base.modules.condition.exception;


/**SQL语句构造异常.
 * @author yonclv
 *         mailTo:yonclv@gmail.com
 */
public class CriteriaQueryException extends RuntimeException {
	private static final long serialVersionUID = -1721484143492859752L;

	public CriteriaQueryException(Throwable root) {
		super(root);
	}

	public CriteriaQueryException(String string, Throwable root) {
		super(string, root);
	}

	public CriteriaQueryException(String s) {
		super(s);
	}
}
