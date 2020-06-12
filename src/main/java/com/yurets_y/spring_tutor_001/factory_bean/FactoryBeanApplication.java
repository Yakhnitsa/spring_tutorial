package com.yurets_y.spring_tutor_001.factory_bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FactoryBeanApplication {
    public static void main(String[] args) {
        String message = "Test message for digest";
        ApplicationContext context = new AnnotationConfigApplicationContext(MessageDigestXmlConfig.class);
        MessageDigester digester = context.getBean("digester2",MessageDigester.class);
        digester.digest(message);

        System.out.println("Using java configured digester...");

        context = new AnnotationConfigApplicationContext(MessageDigestAnnotationConfig.class);
        digester = context.getBean("digester",MessageDigester.class);
        digester.digest(message);

    }
}
