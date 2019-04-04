package com.lks.miniioc;

import com.lks.miniioc.factory.AutowireCapableBeanFactory;
import com.lks.miniioc.factory.BeanFactory;
import org.junit.Test;

/**
 * Created by likaisong on 2019/3/21.
 */
public class BeanFactoryTest {
    @Test
    public void test() throws Exception {
        //实例化beanFactory
        BeanFactory factory = new AutowireCapableBeanFactory();

        //注入bean
        BeanDefinition beanDefinition = new BeanDefinition(new TestService());
        beanDefinition.setBeanClassName("com.lks.miniioc.TestService");
        //属性注入
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValues(new PropertyValue("text", "hello world"));
        beanDefinition.setPropertyValues(propertyValues);
        //注册bean
        factory.registerBeanDefinition("testService", beanDefinition);

        //bean调用
        TestService bean = (TestService) factory.getBean("testService");
        bean.hello();
    }
}
