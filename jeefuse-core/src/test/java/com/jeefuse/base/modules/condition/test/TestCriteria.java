package com.jeefuse.base.modules.condition.test;

import com.jeefuse.base.modules.condition.criteria.Condition;
import com.jeefuse.base.modules.condition.criteria.Restrict;

public class TestCriteria {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		String result = "";
		for (int i = 0; i < 10000; i++) {
			Condition condition = Condition.conjunction().add(Restrict.gt("age", 25)).add(
					Restrict.or(Restrict.startsLike("name", "王"), Restrict.startsLike("name", "孙"))).add(
					Restrict.ge("score", 90));
			result = condition.toSql();
		}
		System.out.println(result);
		long endTime = System.currentTimeMillis();
		System.out.println("using " + (endTime - startTime) + " ms");
	}
}
