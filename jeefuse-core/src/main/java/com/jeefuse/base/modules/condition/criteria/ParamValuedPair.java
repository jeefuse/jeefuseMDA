package com.jeefuse.base.modules.condition.criteria;

public class ParamValuedPair {

	private String paramName;
	private Object paramValue;
	private ParamValuedType paramValueType;

	public ParamValuedPair(String paramName, Object paramValue, ParamValuedType paramValueType) {
		this.paramName = paramName;
		this.paramValue = paramValue;
		this.paramValueType = paramValueType;
	}

	public String getParamName() {
		return paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	public Object getParamValue() {
		return paramValue;
	}

	public void setParamValue(Object paramValue) {
		this.paramValue = paramValue;
	}

	public ParamValuedType getParamValueType() {
		return paramValueType;
	}

	public void setParamValueType(ParamValuedType paramValueType) {
		this.paramValueType = paramValueType;
	}

}
