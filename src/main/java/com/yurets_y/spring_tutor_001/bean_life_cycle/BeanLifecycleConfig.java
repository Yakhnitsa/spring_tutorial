package com.yurets_y.spring_tutor_001.bean_life_cycle;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Lazy;

@Configuration
@ImportResource({"classpath:/spring/app-context-lifecycle.xml"})
public class BeanLifecycleConfig {

    @Bean(name="annotationConfiguredLifecycleBean")
    @Lazy
    public LifeCycleBean getLifecycleBean(){
        return new LifeCycleBean();
    }
}
