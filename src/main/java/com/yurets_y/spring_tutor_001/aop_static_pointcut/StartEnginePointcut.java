package com.yurets_y.spring_tutor_001.aop_static_pointcut;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

/*
* Срез для настройки к каким методам и к каким классам применять перехватчик событий
* */
public class StartEnginePointcut extends StaticMethodMatcherPointcut {

/*
* Матчер для метода, к которому применять перехватчик
* */
    @Override
    public boolean matches(Method method, Class<?> aClass) {
        return ("start".equals(method.getName()));
    }
/* Определяем класс, к которому применяем срез
* */
//    @Override
//    public ClassFilter getClassFilter() {
//        return cls -> (cls == FordFocus.class);
//    }
}
