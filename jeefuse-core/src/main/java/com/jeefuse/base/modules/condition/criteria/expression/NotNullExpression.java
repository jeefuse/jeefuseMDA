package com.jeefuse.base.modules.condition.criteria.expression;

import com.jeefuse.base.modules.condition.criteria.NamedParam;
import com.jeefuse.base.modules.condition.criteria.Operator;
import com.jeefuse.base.modules.condition.exception.CriteriaQueryException;

/**
 * @author yonclv
 * mailTo:yonclv@gmail.com
 */
public class NotNullExpression implements Expression {
	private static final long serialVersionUID = -4534395210079615590L;

	public NotNullExpression(String propertyName) {
		this.propertyName = propertyName;
	}

	private final String propertyName;

	public String getPropertyName() {
		return propertyName;
	}

	public String contructExpression(NamedParam paramValued)
			throws CriteriaQueryException {
		return propertyName + " "+ Operator.IS_NOT_NULL.toParam();
	}

	@Override
	public String toString() {
		return propertyName + " "+Operator.IS_NOT_NULL.toParam();
	}

	public boolean isCompositeExpression() {

		return false;
	}
}
