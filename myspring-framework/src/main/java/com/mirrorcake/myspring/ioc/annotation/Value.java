package com.mirrorcake.myspring.ioc.annotation;

import java.lang.annotation.*;

/**
 * inject value from properties
 *
 * @author mirrorcake
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Documented
public @interface Value {
    String value();
}
