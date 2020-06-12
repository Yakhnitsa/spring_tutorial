package com.yurets_y.spring_tutor_001.names_and_aliases;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

public class NamesApplication {
    public static void main(String[] args) {
        GenericXmlApplicationContext context =
                new GenericXmlApplicationContext("classpath:spring/app-context-names-and-aliases.xml");

        String[] aliases = context.getAliases("alcohol");
        for(String name: aliases){
            System.out.println(name);
        }

    }
}
