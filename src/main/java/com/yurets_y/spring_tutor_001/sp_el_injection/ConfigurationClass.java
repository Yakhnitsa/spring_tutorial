package com.yurets_y.spring_tutor_001.sp_el_injection;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component("injectSimpleConfig")
public class ConfigurationClass {
    private String name = "some name";
    private int age = 39;
    private float height = 1.92f;
    private boolean programmer = false;
    private Long ageinSeconds = 1_241_401_112L;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public float getHeight() {
        return height;
    }

    public boolean isProgrammer() {
        return programmer;
    }

    public Long getAgeinSeconds() {
        return ageinSeconds;
    }
}
