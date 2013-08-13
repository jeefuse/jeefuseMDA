package com.jeefuse.base.modules.condition.criteria.expression;

import java.util.Collection;

import com.jeefuse.base.modules.condition.criteria.NamedParam;
import com.jeefuse.base.modules.condition.criteria.Operator;
import com.jeefuse.base.modules.condition.criteria.ParamValuedType;
import com.jeefuse.base.modules.condition.exception.CriteriaQueryException;

/**
 * @author yonclv
 * mailTo:yonclv@gmail.com
 */
public class InCollectionExpression implements Expression {
	private static final long serialVersionUID = 4209765409711271723L;
	private final String propertyName;
	private final Collection<String> values;

	public InCollectionExpression(String propertyName, Collection<String> values) {
		this.propertyName = propertyName;
		this.values = values;
	}
	public String getPropertyName() {
		return propertyName;
	}

	public Collection<String> getValues() {
		return values;
	}
	
	public String contructExpression(NamedParam paramValued)
			throws CriteriaQueryException {
		if (null == values || values.isEmpty())
			return "";
		else{
			String paramNamed = paramValued.populateParamAddGetParamName(propertyName, values, ParamValuedType.COLLECTION);
			return propertyName+" "+Operator.IN.toParam()+"(:"+paramNamed+")";
		}
	}

	public boolean isCompositeExpression() {
		return false;
	}
}
