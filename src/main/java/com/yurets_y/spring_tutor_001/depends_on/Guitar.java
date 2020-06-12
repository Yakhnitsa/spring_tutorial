package com.yurets_y.spring_tutor_001.depends_on;


import org.springframework.stereotype.Component;

@Component("rockGuitar")
public class Guitar {

    public void play(){
        System.out.println("Rock guitar power chord");
    }
}
