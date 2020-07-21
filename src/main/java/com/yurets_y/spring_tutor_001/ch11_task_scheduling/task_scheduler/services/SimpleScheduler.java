package com.yurets_y.spring_tutor_001.ch11_task_scheduling.task_scheduler.services;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SimpleScheduler {
    @Scheduled(fixedDelay=1000)
    public void timeSchedule(){
        System.out.println("ping");
    }
    @Scheduled(fixedDelay=1000)
    public void timeSchedule2(){
        System.out.println("pong");
    }

}
