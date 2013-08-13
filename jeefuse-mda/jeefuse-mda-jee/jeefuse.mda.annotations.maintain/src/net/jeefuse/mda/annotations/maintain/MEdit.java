package net.jeefuse.mda.annotations.maintain;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 编辑.
 */
@Documented
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.TYPE,ElementType.FIELD})
public @interface MEdit {

}
