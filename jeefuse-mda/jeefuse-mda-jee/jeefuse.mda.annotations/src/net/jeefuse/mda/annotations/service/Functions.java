package net.jeefuse.mda.annotations.service;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.TYPE)
public @interface Functions {

	boolean manage() default true;
	boolean input() default true;
	boolean save() default true;
	boolean edit() default true;
	boolean delete() default true;
	boolean getOutJson() default true;
	boolean deleteAll() default true;
//	boolean deleteAllOutJson() default true;
//	boolean exportExcelFile() default false;
//	boolean importExcelFile() default false;
//	boolean listForSelect() default false;
}
