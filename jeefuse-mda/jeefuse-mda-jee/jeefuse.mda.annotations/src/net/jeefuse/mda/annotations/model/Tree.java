/**
 * Copyright (C) 2010 jeefuse.com.
 * Email:yonclv@gmail.com
 * All Rights Reserved.
 */
package net.jeefuse.mda.annotations.model;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @todo add comment for javadoc
 *
 * @author Administrator
 * @generated
 */
@Documented
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.TYPE,ElementType.FIELD})
public @interface Tree {
	
	String id() default "id";

	String parentId() default "parendId";

	String listLabel() default "name";
	
	String layerCode() default "layerCode";
	
	int layerDeep() default 5;
	
	TreeListStyle treeListStyle() default TreeListStyle.grid;
}