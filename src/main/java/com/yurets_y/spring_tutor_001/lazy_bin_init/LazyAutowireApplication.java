package com.yurets_y.spring_tutor_001.lazy_bin_init;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class LazyAutowireApplication {
    public static void main(String[] args) {
        ApplicationContext context =
                new GenericXmlApplicationContext("classpath:spring/app-context-lazy-component-init.xml");
        System.out.println("Request for masterByConstructor bean");
        /*Порядок связывания:
        * - При вызове ProfilesApplication context не происходит инициализация бинов с lazy-init="true"
        * - При запросе компонента masterByConstructor в конструкторе нужен компонент Lazy component
        * который создается по необходимости
        * */
//        MasterComponent initByConstructor = context.getBean("masterByConstructor",MasterComponent.class);
        /* В запросе через setter метод запрос на создание lazy компонента происходит сразу после
        * создания master компонента, без ожидания вызова самого компонента*/
        MasterComponent initByConstructor = context.getBean("masterByInitMethod",MasterComponent.class);

        System.out.println("Before lazy component usage");
        initByConstructor.useComponent();
        System.out.println("After lazy component usage");



    }
}
