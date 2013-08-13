package net.jeefuse.mda.annotations.view;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import net.jeefuse.mda.annotations.condition.Operator;

/**
 * 标识该字段需要查询.
 * @author yonclv
 * @email yonclv@gmail.com
 */
@Documented
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.FIELD)
public @interface Search {
	
	/**
	 * 是否应用到系统.
	 */
	boolean enabled() default true;
	public Operator operator() default Operator.likeStart;
    public String searchText();
    public String searchTextLabel();
    public String searchTextTwo();
    public String searchTextTwoLabel();
    
	/**
	 * 是否应用到网站.
	 */
	boolean siteenabled() default true;
    
}
