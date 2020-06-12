package com.yurets_y.spring_tutor_001.aop_method_before_advice;

public class Sting implements Singer {
    private String song = "Every breath you take";
    @Override
    public void sing() {
        System.out.println(song);
    }
}
