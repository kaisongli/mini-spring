package com.lks.miniioc.factory;

import com.lks.miniioc.BeanDefinition;

/**
 * Created by likaisong on 2019/3/21.
 */
public interface BeanFactory {
    public Object getBean(String name);

    public void registerBeanDefinition(String name, BeanDefinition beanDefinition);
}
