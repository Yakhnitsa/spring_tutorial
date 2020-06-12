package com.yurets_y.spring_tutor_001.configuration_profiles;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("development")
public class DevelopmentConfig {

    @Bean("connection")
    public ConnectionService connection(){
        return new ConnectionService(8080,"localhost","jdbc:h2:mem:test");
    }

}
