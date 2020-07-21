package com.yurets_y.spring_tutor_001.ch11_task_scheduling.task_scheduler.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@Configuration
@Import({DataServiceConfig.class})
@EnableScheduling
public class AppConfig {

    @Bean
    TaskScheduler carScheduler(){
        ThreadPoolTaskScheduler carScheduler = new ThreadPoolTaskScheduler();
        carScheduler.setPoolSize(10);
        carScheduler.setThreadNamePrefix(
                "ThreadPoolTaskScheduler");
        return  carScheduler;
    }
}
