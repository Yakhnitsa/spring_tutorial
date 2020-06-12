package com.yurets_y.spring_tutor_001.aop_method_after_advice;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

public class SimpleAfterReturningAdvice implements AfterReturningAdvice
{
    public static void main(String[] args) {
        Singer target = new Singer();
        ProxyFactory pf = new ProxyFactory();

        pf.setTarget(target);
        pf.addAdvice(new SimpleAfterReturningAdvice());

        Singer proxy = (Singer)pf.getProxy();
        proxy.sing();

    }
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("After " + method.getName() + " make a joke about bass guitarist");
    }
}
