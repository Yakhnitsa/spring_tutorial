package com.yurets_y.spring_tutor_001.aop_static_pointcut;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;


public class SimpleAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation)throws Throwable{
        System.out.println(">> Invoking "
                + invocation.getMethod().getName());

        Object retVal = invocation.proceed();
        System.out.println(">> Done");
        return retVal;
    }

}

