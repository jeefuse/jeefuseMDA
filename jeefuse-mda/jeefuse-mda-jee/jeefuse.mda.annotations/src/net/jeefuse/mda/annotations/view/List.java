package net.jeefuse.mda.annotations.view;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标识该字段需要例表显示.
 * @author yonclv
 * @email yonclv@gmail.com
 */
@Documented
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.FIELD)
public @interface List {
	
	/**
	 * 是否应用到系统.
	 */
	boolean enabled() default true;
	boolean sortable() default true;
	boolean toggle() default true;
	int width() default 100;
	String listLabel();
	
	/**
	 * 是否应用到网站.
	 */
	boolean siteenabled() default true;
	boolean sitesortable() default true;
	boolean sitetoggle() default true;
	int sitewidth() default 100;
	String siteListLabel();
}
