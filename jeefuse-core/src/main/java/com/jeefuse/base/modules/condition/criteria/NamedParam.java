package com.jeefuse.base.modules.condition.criteria;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 命名参数构造.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
@SuppressWarnings("serial")
public class NamedParam implements Serializable {
	private List<ParamValuedPair> paramValuedPairList = new ArrayList<ParamValuedPair>();

	public List<ParamValuedPair> getParamValuedList() {
		return paramValuedPairList;
	}

	/**
	 * 是否为空.
	 */
	public boolean isEmpty() {
		if (null == paramValuedPairList || paramValuedPairList.isEmpty())
			return true;
		return false;
	}

	/**
	 * 添加命名参数值.如果添加的参数名键值已经存在,则参数名会被替换 为paramName +" _序号"的形式,序号从1开始,直到没有重复的为止.
	 * 
	 * @param paramName
	 * @param value
	 * @param paramValueType
	 * @return 添加的参数名
	 */
	public String populateParamAddGetParamName(String propertyName, Object propertyValue,
			ParamValuedType paramValueType) {
		String paramName = propertyName;
		if (-1 != paramName.indexOf(".")) {
			paramName = paramName.replace('.', '_');
		}
		paramName = paramName + "_" + paramValuedPairList.size();
		paramValuedPairList.add(new ParamValuedPair(paramName, propertyValue, paramValueType));
		return paramName;
	}

	/**
	 * 添加命名参数.
	 * 
	 * @param paramName
	 *            参数名
	 * @param value
	 *            值
	 * @param paramValueType
	 *            类型
	 */
	public void addParamValuedPair(String paramName, Object value, ParamValuedType paramValueType) {
		paramValuedPairList.add(new ParamValuedPair(paramName, value, paramValueType));
	}

}
