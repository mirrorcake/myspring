package com.mirrorcake.myspring.ioc.annotation;

import java.lang.annotation.*;

/**
 * order of a bean
 *
 * @author mirrorcake
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
public @interface Order {
    int value();
}
