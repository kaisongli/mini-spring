package com.lks.miniioc;

/**
 * Created by likaisong on 2019/4/5.
 */
public class BeanReference {
    private String name;

    private Object bean;

    public BeanReference(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Object getBean() {
        return bean;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }
}
