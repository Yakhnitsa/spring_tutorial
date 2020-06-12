package com.yurets_y.spring_tutor_001.lookup_bean;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
class Master {
//    Метод поиска класса slave
    @Lookup
    Slave getSlave(){
        return null;
    }

//    Использование подчиненного объекта путем вызова метода поиска.
    void useSlave(){
        getSlave().doSomething();
    }
}
