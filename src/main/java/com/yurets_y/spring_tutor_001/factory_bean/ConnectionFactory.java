package com.yurets_y.spring_tutor_001.factory_bean;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConnectionFactory {

    @Bean("connectionProvider")
    public ConnectionProvider getConnectionProvider(){
        return new ConnectionProviderImpl(null);
    }

    @Bean("connectionProviderFactoryBean")
    public ConnectionProvider getConnectionProviderFactoryBean() throws Exception {
        return new ConnectionProviderFactoryBean().getObject();
    }

}
