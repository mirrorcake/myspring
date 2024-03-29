package com.mirrorcake.myspring.ioc.annotation;

import java.lang.annotation.*;

/**
 * to mark a bean to be instantiated
 *
 * @author mirrorcake
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface Component {
    /**
     * bean name
     */
    String value() default "";
}
