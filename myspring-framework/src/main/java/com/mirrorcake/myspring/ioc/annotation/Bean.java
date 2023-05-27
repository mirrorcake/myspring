package com.mirrorcake.myspring.ioc.annotation;

import java.lang.annotation.*;

/**
 * instantiate a bean explicitly
 *
 * @author mirrorcake
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Bean {

    /**
     * bean name
     */
    String value() default "";

    String initMethod() default "";

    String destroyMethod() default "";
}
