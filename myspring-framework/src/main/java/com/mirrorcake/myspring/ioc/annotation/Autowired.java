package com.mirrorcake.myspring.ioc.annotation;

import java.lang.annotation.*;

/**
 * inject a bean from IoC container
 *
 * @author mirrorcake
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Autowired {

    /**
     * is required
     */
    boolean value() default true;

    /**
     * bean name if set
     */
    String name() default "";
}
