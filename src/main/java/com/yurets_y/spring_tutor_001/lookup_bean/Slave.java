package com.yurets_y.spring_tutor_001.lookup_bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype") // Позволяет создавать несколько єкземпляров, а не синглтон.
class Slave {
    void doSomething(){
        System.out.println("My name is " + this);
        System.out.println("I will do everything for my master!");
    }
}
