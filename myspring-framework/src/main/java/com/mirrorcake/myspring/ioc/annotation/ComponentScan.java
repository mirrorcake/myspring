package com.mirrorcake.myspring.ioc.annotation;

import java.lang.annotation.*;

/**
 * to mark the package for scan
 *
 * @author mirrorcake
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface ComponentScan {

    /**
     * package names to scan. Default to current package
     */
    String[] value() default {};
}
