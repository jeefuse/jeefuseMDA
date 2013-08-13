package com.jeefuse.base.modules.condition.criteria.expression;

import java.io.Serializable;

import com.jeefuse.base.modules.condition.criteria.NamedParam;
import com.jeefuse.base.modules.condition.exception.CriteriaQueryException;

/**
 * SQL表达式
 * 
 * @author yonclv mailTo:yonclv@gmail.com
 */
public interface Expression extends Serializable {

	/**
	 * 返回当前表达式中构造的查询SQL语句,如用命名参数,需添加在ParamValued对象中.
	 * 
	 * @param ParamValued
	 *            命名参数值对
	 * @return
	 * @throws CriteriaQueryException
	 */
	public String contructExpression(NamedParam ParamValued) throws CriteriaQueryException;

	/**
	 * 是否是组合表达式,既表达式中包含表达式.
	 */
	public boolean isCompositeExpression();

}
