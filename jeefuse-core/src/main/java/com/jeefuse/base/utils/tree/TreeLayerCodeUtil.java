package com.jeefuse.base.utils.tree;

import org.apache.commons.lang.xwork.StringUtils;

public class TreeLayerCodeUtil {

	public static final int defaultLayerLen = 3;// 默认单层字符数.
	public static final int defaultLayerMaxDeep = 5;// 默认层次深度

	/**
	 * 对字符串进行分组,每组num个字符.如果字符串为空返回null.
	 */
	static public String[] split(String str, int groupLen) {
		if (StringUtils.isBlank(str))
			return null;
		int len = str.length();
		int complete = len / groupLen;
		int group = complete;
		if (len % groupLen != 0) {
			group += 1;
		}
		String[] splits = new String[group];
		for (int i = 0; i < complete; i++) {
			splits[i] = StringUtils.substring(str, i * groupLen, (i + 1) * groupLen);
		}
		if (complete < group) {
			splits[group - 1] = StringUtils.substring(str, (group - 1) * groupLen);
		}
		return splits;
	}

	/**
	 * 计算下一个层级代码,在当前的层级代码中加1,如生成的代码不足layerLen长度将会在代码前添足"0".
	 * 
	 * @param layerCode
	 *            代码
	 * @param layerLen
	 *            长度
	 * @return
	 */
	public static String getNextLayerCode(String layerCode, int layerLen) {
		if (StringUtils.isNotBlank(layerCode)) {
			String nextLayerCode = String.valueOf((Long.parseLong(layerCode) + 1));
			int len = nextLayerCode.length();
			int fillLen = layerLen - len % layerLen;
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < fillLen; i++) {
				sb.append("0");
			}
			sb.append(nextLayerCode);
			return sb.toString();
		}
		return "001";
	}

	/**
	 * 是否是有效的层次代码.
	 */
	public static boolean isValideLayerCode(String layerCode, int layerLen) {
		if (StringUtils.isBlank(layerCode))
			return false;
		if (layerCode.length() % layerLen != 0)
			return false;
		return true;
	}

}
