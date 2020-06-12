package com.yurets_y.spring_tutor_001.aop_security_manager;

import org.springframework.aop.framework.ProxyFactory;

public class SecurityDemo {
    public static void main(String... args) {
        SecurityManager mgr = new SecurityManager();

        SecretsKeeper bean = getSecureBean();

        mgr.login("John", "pwd");
        System.out.println(bean.secret());
        mgr.logout();

        try {
            mgr.login("invalid user", "pwd");
            System.out.println(bean.secret());
        } catch(SecurityException ex) {
            System.out.println("Exception Caught: " + ex.getMessage());
        } finally {
            mgr.logout();
        }

        try {
            System.out.println(bean.secret());
        } catch(SecurityException ex) {
            System.out.println("Exception Caught: " + ex.getMessage());
        }
    }

    private static SecretsKeeper getSecureBean() {
        SecretsKeeper target = new SecretsKeeper();

        SecurityAdvice advice = new SecurityAdvice();

        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(target);
        factory.addAdvice(advice);

        SecretsKeeper proxy = (SecretsKeeper)factory.getProxy();

        return proxy;
    }
}
