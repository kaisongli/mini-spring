package com.lks.miniioc.factory;

import com.lks.miniioc.BeanDefinition;
import com.lks.miniioc.PropertyValue;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by likaisong on 2019/3/22.
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory{

    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
        //获取实例化bean
        Object bean = createBeanInstance(beanDefinition);
        //初始化bean
        applyPropertyValues(bean, beanDefinition);
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition) throws Exception {
        return Class.forName(beanDefinition.getBeanClassName()).newInstance();
    }

    protected void applyPropertyValues(Object bean, BeanDefinition beanDefinition) throws Exception {
       List<PropertyValue> propertyValues = beanDefinition.getPropertyValues().getPropertyValues();
       for (PropertyValue propertyValue : propertyValues){
           Field beanField = bean.getClass().getDeclaredField(propertyValue.getName());
           beanField.setAccessible(true);
           beanField.set(bean, propertyValue.getValue());
       }
    }
}
