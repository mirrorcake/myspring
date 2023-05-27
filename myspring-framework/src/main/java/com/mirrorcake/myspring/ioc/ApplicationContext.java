package com.mirrorcake.myspring.ioc;

import java.util.List;

/**
 *  Abstract IoC container
 *
 * @author mirrorcake
 */
public interface ApplicationContext extends AutoCloseable {

    boolean containsBean(String name);

    <T> T getBean(String name);

    <T> T getBean(String name, Class<T> requiredType);

    <T> T getBean(Class<T> requiredType);

    <T> List<T> getBeans(Class<T> requiredType);
}
