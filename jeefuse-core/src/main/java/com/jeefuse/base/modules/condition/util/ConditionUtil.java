package com.jeefuse.base.modules.condition.util;

import java.util.Set;

public class ConditionUtil {
	/**
	 * 用"_"替换name中的"."号,返回name使其在set中没有重名,
	 * 
	 * 如果有重名的在name后加"_序号",从1开始直到不重名为止.
	 * 
	 * @return
	 */
	public static String ensureUnique(Set<String> nameSet, String name) {
		String paramName = name;
		if (null != paramName && -1 != paramName.indexOf(".")) {
			paramName = paramName.replace('.', '_');
		}
		if (nameSet.contains(paramName)) {
			int index =1;
			String tempVar = null;
			while (true) {
				tempVar = paramName + "_" + index;
				if (!nameSet.contains(tempVar)) {
					break;
				}
				index++;
			}
			paramName = tempVar;
		}
		return paramName;
	}

}
