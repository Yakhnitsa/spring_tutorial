package com.yurets_y.spring_tutor_001.ch11_task_scheduling.async_tasks;

import java.util.concurrent.Future;

public interface AsyncService {
    void asyncTask();
    Future<String> asyncWithReturn(String name);
}
