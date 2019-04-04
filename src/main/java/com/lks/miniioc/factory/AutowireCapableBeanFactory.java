package com.lks.miniioc.factory;

import com.lks.miniioc.BeanDefinition;

/**
 * Created by likaisong on 2019/3/22.
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory{
    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) {
        try {
            //通过反射实例化bean
            Object bean = Class.forName(beanDefinition.getBeanClassName()).newInstance();
            return bean;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
