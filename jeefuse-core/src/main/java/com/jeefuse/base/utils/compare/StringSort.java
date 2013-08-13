package com.jeefuse.base.utils.compare;

import java.util.Comparator;

/**
 * 字符串排序.
 * 
 * @author yonclv
 * @date 2013-7-31
 * @email yonclv@gmail.com
 */
public class StringSort implements Comparator<String> {
	public final static int UP = 1;
	public final static int DOWM = -1;

	private int order;

	/**
	 * 字符排序.
	 * 
	 * @param state
	 *            StringSort.UP 升序,StringSort.DOWM 降序
	 */
	public StringSort(int order) {
		this.order = order;
	}

	public StringSort() {

	}

	public int compare(String o1, String o2) {
		if (order == StringSort.DOWM)
			return sortDown(o1, o2);
		return sortUp(o1, o2);
	}

	private int sortUp(String o1, String o2) {
		if (o1.compareTo(o2) < 0)
			return -1;
		else if (o1.compareTo(o2) > 0)
			return 1;
		else
			return 0;
	}

	private int sortDown(String o1, String o2) {
		if (o1.compareTo(o2) > 0)
			return -1;
		else if (o1.compareTo(o2) < 0)
			return 1;
		else
			return 0;
	}
}
