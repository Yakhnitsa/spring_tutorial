package com.yurets_y.spring_tutor_001.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.yurets_y.spring_tutor_001.annotation")
@ComponentScan(basePackages = "com.yurets_y.spring_tutor_001.depends_on")
public class AutoScanConfiguration {

}
