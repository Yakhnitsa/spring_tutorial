package com.yurets_y.spring_tutor_001.configuration_profiles;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.Arrays;

/*Изменение управляющего профиля происходит через аргумент VM
* -Dspring.profiles.active="development"
* Или через указание профиля в самом приложенни
* */

public class ProfilesApplication {
    public static void main(String[] args) {
        GenericApplicationContext context = new AnnotationConfigApplicationContext(
                DevelopmentConfig.class, ProductionConfig.class);
        //Установка профиля в приложении
        context.getEnvironment().setActiveProfiles("development");
        // Нихрена не работает, все-равно берется активный профиль через аргумент VM, без аргумента не работает.


        Arrays.asList(context.getEnvironment().getActiveProfiles()).forEach(
                System.out::println
        );
        ConnectionService service = context.getBean("connection",ConnectionService.class);





        System.out.println(service);
    }
}
