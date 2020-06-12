package com.yurets_y.spring_tutor_001.aop_static_pointcut;


import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class StaticPointcutDemo {
    public static void main(String[] args) {
        Car tesla = new Tesla();
        Car ford = new FordFocus();
        Car teslaProxy;
        Car fordProxy;

        Pointcut pointcut = new StartEnginePointcut();
        // Настраиваем фильтр по классу для среза
        ((StartEnginePointcut) pointcut).setClassFilter(aClass -> aClass == FordFocus.class);
//        ((StartEnginePointcut) pointcut).setClassFilter(aClass -> true); - Для всех классов

        Advice advice = new SimpleAdvice();

//        Настраиваем советчика, устанавливаем срез, и применяемый совет
        Advisor advisor = new DefaultPointcutAdvisor(pointcut,advice);
        

//        Получаем объектых-заместители для обеих объектов
        ProxyFactory factory = new ProxyFactory();
        factory.addAdvisor(advisor);
        factory.setTarget(tesla);
        teslaProxy = (Car)factory.getProxy();

        factory = new ProxyFactory();
        factory.addAdvisor(advisor);
        factory.setTarget(ford);
        fordProxy = (Car)factory.getProxy();
        /*
        * Тестирование вызова методов.
        * SimpleAdvice будет применяться только к методу "start".equals(method.getName())
        * а также только к классу FordFocus.class
        * */
        teslaProxy.start();
        teslaProxy.run();

        fordProxy.start();
        fordProxy.run();

    }
}
