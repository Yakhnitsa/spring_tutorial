package com.yurets_y.spring_tutor_001.configuration_profiles;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("production")
public class ProductionConfig {

    @Bean("connection")
    public ConnectionService connection(){
        return new ConnectionService(1984,"google.com.ua","jdbc:mysql/resource/url");
    }
}
