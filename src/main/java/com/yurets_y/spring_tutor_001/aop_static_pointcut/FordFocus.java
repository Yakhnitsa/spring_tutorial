package com.yurets_y.spring_tutor_001.aop_static_pointcut;

public class FordFocus implements Car {
    @Override
    public void start() {
        System.out.println("Switch on a gas pomp and run starter");
    }

    @Override
    public void run() {
        System.out.println("Switch the first gear and take a power from engine through gear shift to wheels");
    }
}
