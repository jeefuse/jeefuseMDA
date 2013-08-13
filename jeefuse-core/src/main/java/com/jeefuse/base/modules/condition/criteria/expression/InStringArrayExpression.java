package com.jeefuse.base.modules.condition.criteria.expression;

import com.jeefuse.base.modules.condition.criteria.NamedParam;
import com.jeefuse.base.modules.condition.criteria.Operator;
import com.jeefuse.base.modules.condition.criteria.ParamValuedType;
import com.jeefuse.base.modules.condition.exception.CriteriaQueryException;

public class InStringArrayExpression implements Expression {
	private static final long serialVersionUID = 4209765409711271723L;
	private final String propertyName;
	private final String[] values;

	public InStringArrayExpression(String propertyName, String[] values) {
		this.propertyName = propertyName;
		this.values = values;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public String[] getValues() {
		return values;
	}

	public String contructExpression(NamedParam paramValued) throws CriteriaQueryException {
		if (null == values || values.length == 0)
			return "";
		else {
			String paramNamed = paramValued.populateParamAddGetParamName(propertyName, values, ParamValuedType.ARRAY);
			return propertyName + " " + Operator.IN.toParam() + "(:" + paramNamed + ")";
		}
	}

	public boolean isCompositeExpression() {

		return false;
	}

}
