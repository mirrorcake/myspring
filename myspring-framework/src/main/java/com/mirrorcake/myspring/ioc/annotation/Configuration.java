package com.mirrorcake.myspring.ioc.annotation;

import java.lang.annotation.*;

/**
 * configuration
 *
 * @author mirrorcake
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Component
public @interface Configuration {
    /**
     * bean name
     */
    String value() default "";
}
