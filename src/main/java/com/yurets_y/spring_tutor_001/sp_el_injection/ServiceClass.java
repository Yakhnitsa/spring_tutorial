package com.yurets_y.spring_tutor_001.sp_el_injection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("service-class")
public class ServiceClass {
    @Value("#{injectSimpleConfig.name}")
    private String name;
    @Value("#{injectSimpleConfig.age + 1}")
    private int age;
    @Value("#{injectSimpleConfig.height}")
    private float height;
    @Value("#{injectSimpleConfig.programmer}")
    private boolean programmer;
    @Value("#{injectSimpleConfig.ageinSeconds}")
    private Long ageInSeconds;

    @Override
    public String toString() {
        return "ServiceClass{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", programmer=" + programmer +
                ", ageInSeconds=" + ageInSeconds +
                '}';
    }
}
