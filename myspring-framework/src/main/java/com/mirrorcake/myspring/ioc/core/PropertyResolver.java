package com.mirrorcake.myspring.ioc.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class PropertyResolver {

    private final Logger logger = LoggerFactory.getLogger(PropertyResolver.class);

    Map<String, String> propertyMap = new HashMap<>();

    public PropertyResolver(Properties props) {
        // put system env
        this.propertyMap.putAll(System.getenv());
        // duplicate keys
        Set<String> nameSet = props.stringPropertyNames();
        for (String name : nameSet) {
            this.propertyMap.put(name, props.getProperty(name));
        }
    }

    public String getProperty(String key) {
        return this.propertyMap.get(key);
    }
}
