package com.jeefuse.base.utils.compare;


/**匹配器.
 * @author yonclv
 * @email  yonclv@gmail.com
 */
public interface Match<T> {

	/**
	 * 如果匹配则返回true,否则返回false.
	 * @param obj
	 * @return
	 */
	public boolean isMatch(T obj);
}
