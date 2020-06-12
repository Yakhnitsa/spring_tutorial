package com.yurets_y.spring_tutor_001.aop_method_interseptor;

import org.springframework.aop.framework.ProxyFactory;

public class AgentAopDemo {
    public static void main(String[] args) {
        Agent target = new Agent();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvice(new AgentDecorator());
        proxyFactory.setTarget(target);

        Agent proxy = (Agent) proxyFactory.getProxy();
        target.speak();
        System.out.println("");
        proxy.speak();
    }
}
