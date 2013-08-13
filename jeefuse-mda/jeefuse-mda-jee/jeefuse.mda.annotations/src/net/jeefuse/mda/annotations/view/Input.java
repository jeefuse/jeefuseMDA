package net.jeefuse.mda.annotations.view;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标识该字段需要编辑.
 * @author yonclv
 * @email yonclv@gmail.com
 */
@Documented
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.FIELD)
public @interface Input {

	/**
	 * 是否应用到系统.
	 */
	boolean enabled() default true;
	InputKind type() default InputKind.text;
	int  width()  default 120;
	String cssClass() default "text";
	String validateRule() ;
	boolean readonly() default false;
	
	/**
	 * 是否应用到网站.
	 */
	boolean siteenabled() default true;
	InputKind sitetype() default InputKind.text;
	int  sitewidth()  default 120;
	String sitecssClass() default "text";
}
