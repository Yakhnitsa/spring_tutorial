package com.yurets_y.spring_tutor_001.ch11_task_scheduling.task_scheduler.repos;


import com.yurets_y.spring_tutor_001.ch11_task_scheduling.task_scheduler.entities.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {
}
