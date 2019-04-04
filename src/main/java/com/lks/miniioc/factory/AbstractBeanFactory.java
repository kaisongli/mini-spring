package com.lks.miniioc.factory;

import com.lks.miniioc.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by likaisong on 2019/3/22.
 */
public abstract class AbstractBeanFactory implements BeanFactory{
    Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();
    @Override
    public Object getBean(String name) {
        return beanDefinitionMap.get(name).getBean();
    }

    @Override
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception {
        Object bean = doCreateBean(beanDefinition);
        beanDefinition.setBean(bean);
        beanDefinitionMap.put(name, beanDefinition);
    }

    //初始化bean
    protected abstract Object doCreateBean(BeanDefinition beanDefinition) throws Exception;
}
