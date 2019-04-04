package com.lks.miniioc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by likaisong on 2019/4/4.
 */
public class PropertyValues {
    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public void addPropertyValues(PropertyValue propertyValue){
        //TODO: 过滤重复的属性名
        propertyValueList.add(propertyValue);
    }

    public List<PropertyValue> getPropertyValues() {
        return propertyValueList;
    }


}
