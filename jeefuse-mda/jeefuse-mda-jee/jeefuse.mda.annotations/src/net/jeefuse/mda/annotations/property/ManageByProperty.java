/**
 * Copyright (C) 2010 jeefuse.com.
 * Email:yonclv@gmail.com
 * All Rights Reserved.
 */
package net.jeefuse.mda.annotations.property;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 根据属性进行维护操作.
 *
 * @author Administrator
 * @generated
 */
@Documented
@Retention(RetentionPolicy.CLASS)
@Target(value={ElementType.METHOD,ElementType.FIELD})
public @interface ManageByProperty{
}