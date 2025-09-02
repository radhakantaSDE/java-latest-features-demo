package com.learn.app.concepts.threading.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ExecServiceTask implements Runnable {
  @Override
  public void run() {
    System.out.println("Task is running in ExecutorService");
  }
}

public class ExecutorServiceExecuteMethod {

  public void executeTest() {

    try (ExecutorService executorService = Executors.newFixedThreadPool(2)) {
      executorService.execute(new ExecServiceTask());
      System.out.println("Tasks submitted to ExecutorService");
    } catch (Exception e) {
      System.out.println("Exception occurred while executing task: " + e.getMessage());
    }
  }
}
