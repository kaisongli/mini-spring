package com.lks.miniioc;

import org.junit.Test;

/**
 * Created by likaisong on 2019/3/21.
 */
public class BeanFactoryTest {
    @Test
    public void test(){
        //实例化beanFactory
        BeanFactory factory = new BeanFactory();

        //注入bean
        BeanDefinition beanDefinition = new BeanDefinition(new TestService());
        factory.registerBeanDefinition("testService", beanDefinition);

        //bean调用
        TestService bean = (TestService) factory.getBean("testService");
        bean.hello();
    }
}
