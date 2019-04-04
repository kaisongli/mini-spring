package com.lks.miniioc;

/**
 * Created by likaisong on 2019/3/21.
 */
public class BeanDefinition {
    private Object bean;

    private Class beanClass;

    private String beanClassName;

    public BeanDefinition() {
    }

    public Object getBean() {
        return bean;
    }

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public String getBeanClassName() {
        return beanClassName;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
    }

}
