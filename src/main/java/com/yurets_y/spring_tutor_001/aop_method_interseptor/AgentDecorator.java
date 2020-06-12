package com.yurets_y.spring_tutor_001.aop_method_interseptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AgentDecorator implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.print("James ");
        Object object = methodInvocation.proceed();
        System.out.println("!");
        return object;
    }
}
