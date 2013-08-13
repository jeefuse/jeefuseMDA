package com.jeefuse.base.modules.condition.criteria.expression;

import java.util.Arrays;

import com.jeefuse.base.modules.condition.criteria.NamedParam;
import com.jeefuse.base.modules.condition.criteria.Operator;
import com.jeefuse.base.modules.condition.criteria.ParamValuedType;
import com.jeefuse.base.modules.condition.exception.CriteriaQueryException;

/**
 * @author yonclv
 * mailTo:yonclv@gmail.com
 */
public class InExpression implements Expression {
	private static final long serialVersionUID = 4209765409711271723L;
	private final String propertyName;
	private final Object[] values;
	public InExpression(String propertyName, Object[] values) {
		this.propertyName = propertyName;
		this.values = values;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public Object[] getValues() {
		return values;
	}
	
	public String contructExpression(NamedParam paramValued)
			throws CriteriaQueryException {
		if(null==values||values.length==0)
			return "";
		else{
			String paramNamed = paramValued.populateParamAddGetParamName(propertyName, Arrays.asList(values), ParamValuedType.ARRAY);
			return propertyName+" "+Operator.IN.toParam()+"(:"+paramNamed+")";
		}
	}

	public boolean isCompositeExpression() {

		return false;
	}
}
