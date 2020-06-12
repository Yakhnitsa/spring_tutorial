package com.yurets_y.spring_tutor_001.lookup_bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LookupApplication {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext();
//        Добавление новых бинов в приложение через регистрацию
        ((AnnotationConfigApplicationContext) context).registerBean(Master.class);
        ((AnnotationConfigApplicationContext) context).registerBean(Slave.class);
        ((AnnotationConfigApplicationContext) context).refresh();

        Master master = context.getBean(Master.class);
//        Запуск исполения, за счет аннотации @Scope("prototype") каждый раз новый раб
        master.useSlave();
        master.useSlave();
        master.useSlave();
    }
}
