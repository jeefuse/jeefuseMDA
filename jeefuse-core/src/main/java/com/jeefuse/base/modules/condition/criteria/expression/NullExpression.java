package com.jeefuse.base.modules.condition.criteria.expression;

import com.jeefuse.base.modules.condition.criteria.NamedParam;
import com.jeefuse.base.modules.condition.criteria.Operator;
import com.jeefuse.base.modules.condition.exception.CriteriaQueryException;

/**
 * @author yonclv
 * mailTo:yonclv@gmail.com
 */
public class NullExpression implements Expression {
	private static final long serialVersionUID = 7322096424128399326L;
	private final String propertyName;

	public String getPropertyName() {
		return propertyName;
	}

	public NullExpression(String propertyName) {
		this.propertyName = propertyName;
	}

	public String contructExpression(NamedParam paramValued)
			throws CriteriaQueryException {
		return propertyName+" "+Operator.IS_NULL.toParam();
	}

	public boolean isCompositeExpression() {

		return false;
	}

}
