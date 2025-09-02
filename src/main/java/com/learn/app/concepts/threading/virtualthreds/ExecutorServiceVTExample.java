package com.learn.app.concepts.threading.virtualthreds;

import java.util.concurrent.Executors;

public class ExecutorServiceVTExample {
  public static void main(String[] args) {
    try (var executorService = Executors.newVirtualThreadPerTaskExecutor()) {
      for (int i = 0; i < 10; i++) {
        int taskId = i;
        executorService.submit(
            () -> {
              System.out.println(
                  "Task " + taskId + " is running on " + Thread.currentThread().getName());
              try {
                // Simulating some work
                Thread.sleep(1000);
              } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Task " + taskId + " was interrupted.");
              }
              System.out.println(
                  "Task " + taskId + " completed on " + Thread.currentThread().getName());
            });
      }
    }
  }
}
