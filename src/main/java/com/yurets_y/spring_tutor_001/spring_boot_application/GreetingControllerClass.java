package com.yurets_y.spring_tutor_001.spring_boot_application;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/*
* Запуск контроллера требует зависимость
* spring-boot-starter-web
*
* */
@RestController
public class GreetingControllerClass {

    @GetMapping("/")
    public String greening(@RequestParam(required = false) String name){
        if(name== null)
        return "Hello world!";
        else
            return "Hello " + name;
    }
}
