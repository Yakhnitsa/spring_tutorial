package com.yurets_y.spring_tutor_001.aop_static_pointcut;

public class Tesla implements Car{
    @Override
    public void start() {
        System.out.println("Worm up batteries...");
    }

    @Override
    public void run() {
        System.out.println("Take a power to electric engine and run");
    }
}
