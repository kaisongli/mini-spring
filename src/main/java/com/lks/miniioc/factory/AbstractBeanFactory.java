package com.lks.miniioc.factory;

import com.lks.miniioc.BeanDefinition;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by likaisong on 2019/3/22.
 */
public abstract class AbstractBeanFactory implements BeanFactory{
    Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();
    private final List<String> beanDefinitionNames = new ArrayList<>();
    private volatile Object bean;
    @Override
    public Object getBean(String name) throws Exception {
        BeanDefinition beanDefinition = beanDefinitionMap.get(name);
        if (beanDefinition == null) {
            throw new IllegalArgumentException("No bean named " + name + " is defined");
        }
        bean = beanDefinition.getBean();
        if (bean == null){
            synchronized (this.getClass()) {
                if (bean == null) {
                    bean = doCreateBean(beanDefinition);
                }
            }
        }
        return bean;
    }

    @Override
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception {
        beanDefinitionMap.put(name, beanDefinition);
        beanDefinitionNames.add(name);
    }

   public void  preInstantiateSingletons() throws Exception {
       for (Iterator it = this.beanDefinitionNames.iterator(); it.hasNext();) {
           String beanName = (String) it.next();
           getBean(beanName);
       }
   }

    //初始化bean
    protected abstract Object doCreateBean(BeanDefinition beanDefinition) throws Exception;
}
