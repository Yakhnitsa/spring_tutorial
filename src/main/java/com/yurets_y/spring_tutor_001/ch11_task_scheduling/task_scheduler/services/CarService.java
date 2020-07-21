package com.yurets_y.spring_tutor_001.ch11_task_scheduling.task_scheduler.services;


import com.yurets_y.spring_tutor_001.ch11_task_scheduling.task_scheduler.entities.Car;

import java.util.List;

public interface CarService {
    List<Car> findAll();
    Car save(Car car);
    void updateCarAgeJob();
    boolean isDone();
}
