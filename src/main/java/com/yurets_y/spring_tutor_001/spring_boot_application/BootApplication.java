package com.yurets_y.spring_tutor_001.spring_boot_application;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;
import java.util.Arrays;

@SpringBootApplication
public class BootApplication {
    private static Logger logger = LoggerFactory.getLogger(BootApplication.class);

    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext context = SpringApplication.run(BootApplication.class, args);

        assert(context != null);

        logger.info("Список всех найденых компонентов:");
        Arrays.stream(context.getBeanDefinitionNames()).forEach(bean -> logger.info("****=>" + bean));
        ExecutableClass executor = context.getBean("executor", ExecutableClass.class);
        executor.execute();
        System.in.read();
        context.close();
    }
}

