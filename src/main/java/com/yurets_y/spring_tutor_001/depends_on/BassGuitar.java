package com.yurets_y.spring_tutor_001.depends_on;


import org.springframework.stereotype.Component;

@Component
public class BassGuitar extends Guitar {

    @Override
    public void play(){
        System.out.println("Bass guitar play");
    }

}
