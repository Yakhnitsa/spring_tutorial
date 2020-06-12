package com.yurets_y.spring_tutor_001.factory_bean;

import java.security.MessageDigest;

public class MessageDigestFactory {

    private String algorithmName = "MD5";

    public MessageDigest createInstance() throws Exception{
        return MessageDigest.getInstance(algorithmName);
    }


    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }
}
