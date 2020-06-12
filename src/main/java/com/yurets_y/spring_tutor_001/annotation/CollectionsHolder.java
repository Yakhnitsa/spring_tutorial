package com.yurets_y.spring_tutor_001.annotation;


import com.yurets_y.spring_tutor_001.bin.MessageProvider;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Properties;

@Component
public class CollectionsHolder {

    private List<String> stringList;

    private Map<String,String> simpleMap;

    private Map<String, MessageProvider> extendedMap;

    private Properties properties;


    public List<String> getStringList() {
        return stringList;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    public Map<String, String> getSimpleMap() {
        return simpleMap;
    }

    public void setSimpleMap(Map<String, String> simpleMap) {
        this.simpleMap = simpleMap;
    }

    public Map<String, MessageProvider> getExtendedMap() {
        return extendedMap;
    }

    public void setExtendedMap(Map<String, MessageProvider> extendedMap) {
        this.extendedMap = extendedMap;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
