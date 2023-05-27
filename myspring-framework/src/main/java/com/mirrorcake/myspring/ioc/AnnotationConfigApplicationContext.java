package com.mirrorcake.myspring.ioc;

import com.mirrorcake.myspring.ioc.core.BeanDefinition;

import java.util.List;
import java.util.Map;

/**
 *  IoC container based on annotations
 *
 * @author mirrorcake
 */
public class AnnotationConfigApplicationContext implements ApplicationContext{
    Map<String, BeanDefinition> beanMap;

    @Override
    public void close() throws Exception {

    }

    @Override
    public boolean containsBean(String name) {
        return this.beanMap.containsKey(name);
    }

    @Override
    public <T> T getBean(String name) {
        return null;
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) {
        return null;
    }

    @Override
    public <T> T getBean(Class<T> requiredType) {
        return null;
    }

    @Override
    public <T> List<T> getBeans(Class<T> requiredType) {
        return null;
    }

    public BeanDefinition getBeanDefinition(String name) {
        return this.beanMap.get(name);
    }
}
