package com.mirrorcake.myspring.ioc.core;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 *  bean info
 *
 * @author mirrorcake
 */
public class BeanDefinition {
    String name;

    Class<?> clazz;

    Object instance = null;

    Constructor<?> constructor;

    int order;

    // @Primary
    boolean primary;

    String factoryName;
    Method factoryMethod;

    // @PostConstruct
    String initMethodName;
    Method initMethod;

    // @PreDestroy
    String destroyMethodName;
    Method destroyMethod;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public void setClazz(Class<?> clazz) {
        this.clazz = clazz;
    }

    public Object getInstance() {
        return instance;
    }

    public void setInstance(Object instance) {
        this.instance = instance;
    }

    public Constructor<?> getConstructor() {
        return constructor;
    }

    public void setConstructor(Constructor<?> constructor) {
        this.constructor = constructor;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public boolean isPrimary() {
        return primary;
    }

    public void setPrimary(boolean primary) {
        this.primary = primary;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    public Method getFactoryMethod() {
        return factoryMethod;
    }

    public void setFactoryMethod(Method factoryMethod) {
        this.factoryMethod = factoryMethod;
    }

    public String getInitMethodName() {
        return initMethodName;
    }

    public void setInitMethodName(String initMethodName) {
        this.initMethodName = initMethodName;
    }

    public Method getInitMethod() {
        return initMethod;
    }

    public void setInitMethod(Method initMethod) {
        this.initMethod = initMethod;
    }

    public String getDestroyMethodName() {
        return destroyMethodName;
    }

    public void setDestroyMethodName(String destroyMethodName) {
        this.destroyMethodName = destroyMethodName;
    }

    public Method getDestroyMethod() {
        return destroyMethod;
    }

    public void setDestroyMethod(Method destroyMethod) {
        this.destroyMethod = destroyMethod;
    }

    @Override
    public String toString() {
        return "BeanDefinition{" +
                "name='" + name + '\'' +
                ", clazz=" + clazz +
                ", instance=" + instance +
                ", constructor=" + constructor +
                ", order=" + order +
                ", primary=" + primary +
                ", factoryName='" + factoryName + '\'' +
                ", factoryMethod=" + factoryMethod +
                ", initMethodName='" + initMethodName + '\'' +
                ", initMethod=" + initMethod +
                ", destroyMethodName='" + destroyMethodName + '\'' +
                ", destroyMethod=" + destroyMethod +
                '}';
    }
}
