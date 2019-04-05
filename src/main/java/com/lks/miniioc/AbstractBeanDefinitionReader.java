package com.lks.miniioc;

import com.lks.miniioc.io.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by likaisong on 2019/4/5.
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader{
    private Map<String, BeanDefinition> register;
    private ResourceLoader resourceLoader;

    public AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {
        this.register = new HashMap<>();
        this.resourceLoader = resourceLoader;
    }

    public Map<String, BeanDefinition> getRegister() {
        return register;
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
