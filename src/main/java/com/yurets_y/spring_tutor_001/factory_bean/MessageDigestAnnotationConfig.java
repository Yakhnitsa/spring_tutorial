package com.yurets_y.spring_tutor_001.factory_bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageDigestAnnotationConfig {
    @Bean
    public MessageDigestFactoryBean shaDigest(){
        MessageDigestFactoryBean factoryBean = new MessageDigestFactoryBean();
        factoryBean.setAlgorithmName("SHA1");
        return factoryBean;
    }

    @Bean
    public MessageDigestFactoryBean defaultDigest(){
        MessageDigestFactoryBean factoryBean = new MessageDigestFactoryBean();
        return factoryBean;
    }

    @Bean
    public MessageDigester digester() throws Exception {
        MessageDigester messageDigester = new MessageDigester();
        messageDigester.setMessageDigest1(shaDigest().getObject());
        messageDigester.setMessageDigest2(defaultDigest().getObject());

        return  messageDigester;
    }
}
