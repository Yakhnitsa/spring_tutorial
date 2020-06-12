package com.yurets_y.spring_tutor_001.configuration_profiles;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class DefaultConfig {

    @Bean("connection")
    public ConnectionService connection(){
        return new ConnectionService(0000,"default_host","default_database");
    }

}
