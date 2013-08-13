package com.jeefuse.base.modules.condition.join;

import com.jeefuse.base.modules.condition.criteria.expression.Expression;


public abstract class Join {
	public static EntityJoin addEntity(String name){
		return EntityJoin.entity(name);
	}
	public static EntityJoin addEntity(String name,String alias){
		return EntityJoin.entity(name, alias);
	}
	public static EntityJoin[] addEntity(EntityJoin... entityJoins){
		return EntityJoin.entityJoins(entityJoins);
	}
	public static RelatedJoin innerJoin(String relatedProperty,String alias){
		return new RelatedJoin(relatedProperty,JoinType.inner_join, alias);
	}
	public static RelatedJoin innerJoin(String relatedProperty,String alias,Expression... expressions){
		return new RelatedJoin(relatedProperty,JoinType.inner_join, alias,expressions);
	}
	public static RelatedJoin innerJoinFetch(String relatedProperty,String alias){
		return new RelatedJoin(relatedProperty,JoinType.inner_join_fetch, alias);
	}
	public static RelatedJoin innerJoinFetch(String relatedProperty,String alias,Expression... expressions){
		return new RelatedJoin(relatedProperty,JoinType.inner_join_fetch, alias,expressions);
	}
	public static RelatedJoin leftJoin(String relatedProperty,String alias){
		return new RelatedJoin(relatedProperty,JoinType.left_join, alias);
	}
	public static RelatedJoin leftJoin(String relatedProperty,String alias,Expression... expressions){
		return new RelatedJoin(relatedProperty,JoinType.left_join, alias,expressions);
	}
	public static RelatedJoin leftJoinFetch(String relatedProperty,String alias){
		return new RelatedJoin(relatedProperty,JoinType.left_join_fetch, alias);
	}
	public static RelatedJoin leftJoinFetch(String relatedProperty,String alias,Expression... expressions){
		return new RelatedJoin(relatedProperty,JoinType.left_join_fetch, alias,expressions);
	}
	public static RelatedJoin rightJoin(String relatedProperty,String alias){
		return new RelatedJoin(relatedProperty,JoinType.right_join, alias);
	}
	public static RelatedJoin rightJoin(String relatedProperty,String alias,Expression... expressions){
		return new RelatedJoin(relatedProperty,JoinType.right_join, alias,expressions);
	}
	public static RelatedJoin fullJoin(String relatedProperty,String alias){
		return new RelatedJoin(relatedProperty,JoinType.full_join, alias);
	}
	public static RelatedJoin fullJoin(String relatedProperty,String alias,Expression... expressions){
		return new RelatedJoin(relatedProperty,JoinType.full_join, alias,expressions);
	}
	
}
