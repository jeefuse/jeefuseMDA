package com.jeefuse.base.modules.condition.join;

import com.jeefuse.base.modules.condition.criteria.Criteria;
import com.jeefuse.base.modules.condition.exception.CriteriaQueryException;


/**查询实体
 * @author yonclv
 * mailTo:yonclv@gmail.com
 */
public class EntityJoin implements Criteria{
	private static final long serialVersionUID = -8217727979794892886L;

	public static EntityJoin[] entityJoins(EntityJoin... entityJoins) {
		return entityJoins;
	}

	public static EntityJoin entity(String entityName) {
		return new EntityJoin(entityName);
	}

	public static EntityJoin entity(String entityName,String alias) {
		return new EntityJoin(entityName,alias);
	}
	private String entityName=null;
	private String alias=null;

	public EntityJoin(String entityName) {
		this.entityName = entityName;
	}

	public EntityJoin(String entityName, String alias) {
		this.entityName = entityName;
		this.alias = alias;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	public String toSql() throws CriteriaQueryException {
		if(null==alias||this.alias.trim().equals("")){
			return this.entityName;
		}else{
			return this.entityName+" "+alias;
		}
	}
	
	@Override
	public String toString() {
		return String.format("%s name=%s alias=%s", getClass().getSimpleName(),
				getEntityName(), getAlias());
	}
}
