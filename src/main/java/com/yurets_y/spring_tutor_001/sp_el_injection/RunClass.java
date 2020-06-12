package com.yurets_y.spring_tutor_001.sp_el_injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "com.yurets_y.spring_tutor_001.sp_el_injection")
public class RunClass {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(RunClass.class);
        ServiceClass serviceClass = ac.getBean("service-class",ServiceClass.class);
        System.out.println(serviceClass.toString());
    }

}
