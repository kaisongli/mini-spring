package com.lks.miniioc;

/**
 * Created by likaisong on 2019/4/5.
 */
public interface BeanDefinitionReader {
    void loadBeanDefinitions(String location) throws Exception;
}
