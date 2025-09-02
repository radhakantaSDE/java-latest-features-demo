package com.learn.app.concepts.threading.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class ExecSubmitTask<T> implements Runnable {
  private T data;

  @Override
  public void run() {
    System.out.println("Task is running in ExecutorService using submit method");
  }
}

class ExecSubmitCallableTask<T> implements Callable<T> {
  private final T data;

  public ExecSubmitCallableTask(T data) {
    this.data = data;
  }

  @Override
  public T call() throws Exception {
    System.out.println("Callable task is running in ExecutorService using submit method");
    return data;
  }
}

public class ExecutorSubmitMethod {

  public void submitWithRunnable() {
    try (ExecutorService executorService = Executors.newFixedThreadPool(2)) {
      ExecSubmitTask<String> executorServiceTask = new ExecSubmitTask<>();
      Future<?> result = executorService.submit(executorServiceTask);
      result.get();
    } catch (Exception ex) {
      System.out.println("Exception occurred while submitting task: " + ex.getMessage());
    }
  }

  public void submitWithRunnableAndResult() {
    try (ExecutorService executorService = Executors.newFixedThreadPool(2)) {
      ExecSubmitTask<String> executorServiceTask = new ExecSubmitTask<>();
      Future<String> result = executorService.submit(executorServiceTask, "Task Result");
      String data = result.get();
      System.out.println("Runnable task completed with result: " + data);
    } catch (Exception ex) {
      System.out.println(
          "Exception occurred while submitting task with result: " + ex.getMessage());
    }
  }

  public void submitWithCallable() {
    try (ExecutorService executorService = Executors.newFixedThreadPool(2)) {

      ExecSubmitCallableTask<Integer> executorServiceTask = new ExecSubmitCallableTask<>(1000);
      Future<Integer> result = executorService.submit(executorServiceTask);
      Integer data = result.get();
      System.out.println("Callable task completed with result: " + data);
    } catch (Exception ex) {
      System.out.println(
          "Exception occurred while submitting task with result: " + ex.getMessage());
    }
  }

  public static void main(String[] args) {
    ExecutorSubmitMethod executorSubmitMethod = new ExecutorSubmitMethod();
    executorSubmitMethod.submitWithRunnable();
    executorSubmitMethod.submitWithRunnableAndResult();
    executorSubmitMethod.submitWithCallable();
    System.out.println("Tasks submitted to ExecutorService using submit method");
  }
}
