package com.yurets_y.spring_tutor_001.aop_method_before_advice;

import org.springframework.aop.framework.ProxyFactory;

public class BeforeAdviceDemo {
    public static void main(String[] args) {
        Singer sting = new Sting();

        ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(new SimpleBeforeAdvice());
        pf.setTarget(sting);

        Singer proxy = (Singer)pf.getProxy();

        proxy.sing();
    }
}
