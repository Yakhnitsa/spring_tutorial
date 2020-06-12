package com.yurets_y.spring_tutor_001.factory_bean;

import java.security.MessageDigest;

public class MessageDigester {
    private MessageDigest messageDigest1;
    private MessageDigest messageDigest2;


    public void setMessageDigest1(MessageDigest messageDigest1) {
        this.messageDigest1 = messageDigest1;
    }

    public void setMessageDigest2(MessageDigest messageDigest2) {
        this.messageDigest2 = messageDigest2;
    }

    public void digest(String message) {
        System.out.println("Using messageDigest1");
        digest(message, messageDigest1);
        System.out.println("Using messageDigest2");
        digest(message, messageDigest2);
    }

    private void digest(String msg, MessageDigest digest) {
        System.out.println("Using alogrithm: "
                + digest.getAlgorithm());
        digest.reset();
        byte[] bytes = msg.getBytes();
        byte[] out = digest.digest(bytes);
        System.out.println(out);

    }
}