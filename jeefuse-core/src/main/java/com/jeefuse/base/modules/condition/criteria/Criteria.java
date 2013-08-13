package com.jeefuse.base.modules.condition.criteria;

import java.io.Serializable;

import com.jeefuse.base.modules.condition.exception.CriteriaQueryException;

/**
 * SQL表达式构造.
 * 
 * @author yonclv mailTo:yonclv@gmail.com
 */
public interface Criteria extends Serializable {
	public String toSql() throws CriteriaQueryException;
}
