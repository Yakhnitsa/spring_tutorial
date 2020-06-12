package com.yurets_y.spring_tutor_001.factory_bean;

import org.springframework.beans.factory.FactoryBean;

import javax.annotation.PostConstruct;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MessageDigestFactoryBean implements FactoryBean<MessageDigest> {
    private String algorithmName = "MD5";
    private MessageDigest messageDigest;

    @Override
    public MessageDigest getObject() throws Exception {
        return messageDigest;
    }

    @Override
    public Class<?> getObjectType() {
        return MessageDigest.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @PostConstruct
    public void initBean() throws NoSuchAlgorithmException {
        messageDigest = MessageDigest.getInstance(algorithmName);
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }
}
