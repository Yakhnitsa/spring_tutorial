package com.yurets_y.spring_tutor_001.bean_life_cycle;


import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


/*
* Пример метода с тремя типами инициализации
* */

public class LifeCycleBean implements DisposableBean, InitializingBean {

    private int index = 0;
//    1
    public LifeCycleBean() {
        System.out.println(++index + " Using constructor");
    }
//  2
    @PostConstruct
    public void postConstructByAnnotation(){
        System.out.println(++index + " Using annotated method postConstructByAnnotation");
    }
//  3
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(++index + " Using interface InitializingBean implementation method afterPropertiesSet()");
    }
//  4
    public void postConstructXMLConfig(){
        System.out.println(++index + " Using xml configuration method postConstructXMLConfig");
    }
//  5
    @PreDestroy
    public void preDestroyByAnnotation(){
        System.out.println(++index + " Using annotated  method preDestroyByAnnotation");
    }


    // 6 Имплементация интерфейса для метода destroy
    @Override
    public void destroy() throws Exception {
        System.out.println(++index + " Using interface DisposableBean implementation method destroy()");
    }

    public void destroyXMLConfig(){
        System.out.println(++index + " Using xml configuration method destroyXMLConfig");
    }




}
