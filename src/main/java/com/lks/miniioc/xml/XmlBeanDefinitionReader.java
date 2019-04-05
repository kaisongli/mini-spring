package com.lks.miniioc.xml;

import com.lks.miniioc.AbstractBeanDefinitionReader;
import com.lks.miniioc.BeanDefinition;
import com.lks.miniioc.BeanReference;
import com.lks.miniioc.PropertyValue;
import com.lks.miniioc.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

/**
 * Created by likaisong on 2019/4/5.
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    public XmlBeanDefinitionReader(ResourceLoader resourceLoader) {
        super(resourceLoader);
    }

    @Override
    public void loadBeanDefinitions(String location) throws Exception {
        InputStream inputStream = getResourceLoader().getResource(location).getInputStream();
        doLoadBeanDefinitions(inputStream);
    }

    private void doLoadBeanDefinitions(InputStream inputStream) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(inputStream);
        registerBeanDefinitions(doc);
        inputStream.close();
    }

    private void registerBeanDefinitions(Document doc) {
        Element root = doc.getDocumentElement();

        parseBeanDefinitions(root);
    }

    private void parseBeanDefinitions(Element root) {
        NodeList nodeList = root.getChildNodes();
        if (nodeList != null || nodeList.getLength() > 0) {
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node instanceof Element) {
                    Element ele = (Element) node;
                    processBeanDefinition(ele);
                }
            }
        }
    }

    private void processBeanDefinition(Element ele) {
        String name = ele.getAttribute("name");
        String className = ele.getAttribute("class");
        BeanDefinition beanDefinition = new BeanDefinition();
        processProperty(ele, beanDefinition);
        beanDefinition.setBeanClassName(className);
        getRegistry().put(name, beanDefinition);
    }

    private void processProperty(Element ele, BeanDefinition beanDefinition) {
        NodeList properties = ele.getElementsByTagName("property");
        if (properties != null || properties.getLength() > 0) {
            for (int i = 0; i < properties.getLength(); i++) {
                Node node = properties.item(i);
                if (node instanceof Element) {
                    Element property = (Element) node;
                    String name = property.getAttribute("name");
                    String value = property.getAttribute("value");
                    if (value != null && value.length() > 0) {
                        beanDefinition.getPropertyValues().addPropertyValues(new PropertyValue(name, value));
                    }else {
                        String ref = property.getAttribute("ref");
                        if (ref == null || ref.length() == 0) {
                            throw new IllegalArgumentException("Configuration problem: <property> element for property '"
                                    + name + "' must specify a ref or value");
                        }
                        BeanReference beanReference = new BeanReference(ref);
                        beanDefinition.getPropertyValues().addPropertyValues(new PropertyValue(name, beanReference));
                    }
                }
            }
        }
    }
}
