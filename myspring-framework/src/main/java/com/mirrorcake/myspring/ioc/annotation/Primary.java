package com.mirrorcake.myspring.ioc.annotation;

import java.lang.annotation.*;

/**
 * @author mirrorcake
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Primary {
}
