package com.yurets_y.spring_tutor_001.factory_bean;

import org.springframework.beans.factory.FactoryBean;

public class ConnectionProviderFactoryBean implements FactoryBean<ConnectionProvider> {
    @Override
    public ConnectionProvider getObject() throws Exception {
        return new ConnectionProviderImpl(null);
    }

    @Override
    public Class<?> getObjectType() {
        return ConnectionProvider.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
