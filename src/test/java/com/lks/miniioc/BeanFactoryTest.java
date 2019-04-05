package com.lks.miniioc;

import com.lks.miniioc.factory.AutowireCapableBeanFactory;
import com.lks.miniioc.factory.BeanFactory;
import com.lks.miniioc.io.ResourceLoader;
import com.lks.miniioc.xml.XmlBeanDefinitionReader;
import org.junit.Test;

import java.util.Map;

/**
 * Created by likaisong on 2019/3/21.
 */
public class BeanFactoryTest {
    @Test
    public void test() throws Exception {
        //读取配置
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("miniioc.xml");

        //初始化beanfactory和注册bean
        BeanFactory factory = new AutowireCapableBeanFactory();
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegister().entrySet()){
            factory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }

        //bean调用
        TestService bean = (TestService) factory.getBean("testService");
        bean.hello();
    }
}
