package com.yurets_y.spring_tutor_001.ch11_task_scheduling.task_scheduler;

import com.yurets_y.spring_tutor_001.ch11_task_scheduling.task_scheduler.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class ScheduleTaskAnnotationDemo {

	public static void main(String... args) throws Exception {
		GenericApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

		System.in.read();

		ctx.close();
	}
} 
