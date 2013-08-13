package net.jeefuse.mda.annotations.view;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标识该字段需要查询.
 * @author yonclv
 * @email yonclv@gmail.com
 */
@Documented
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.FIELD)
public @interface View {
	/**
	 * 是否应用到系统.
	 */
	boolean enabled() default true;

	/**
	 * 是否应用到网站.
	 */
	boolean siteenabled() default true;
}
