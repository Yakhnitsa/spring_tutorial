package com.yurets_y.spring_tutor_001.spring_boot_application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;



@Component("executor")
public class ExecutableClass {
    private static Logger logger = LoggerFactory.getLogger(ExecutableClass.class);

    public void execute(){
        logger.info("Executor do some work...");
    }
}
