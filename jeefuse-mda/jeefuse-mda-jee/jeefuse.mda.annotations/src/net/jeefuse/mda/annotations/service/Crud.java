/**
 * Copyright (C) 2010 jeefuse.com.
 * Email:yonclv@gmail.com
 * All Rights Reserved.
 */
package net.jeefuse.mda.annotations.service;
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
@Target(ElementType.TYPE)
public @interface Crud{

	boolean create() default true;
  
	boolean delete() default true;
  
	boolean read()  default true;
  
	boolean update() default true;
  
	String name();
  
	String descript();
  
}