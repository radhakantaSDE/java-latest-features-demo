package com.learn.app.concepts.threading.executor.completable;

import java.util.concurrent.CompletableFuture;

/**
 * Why supplyAsync() closes the execution / jvm finish its execution ? but, in case of plain thread,
 * it does not close the execution.
 *
 * <p>Ans : Uses of CompletableFuture.supplyAsync(), which runs tasks in the
 * ForkJoinPool.commonPool. Threads in this pool are daemon threads and Daemon threads do not
 * prevent the JVM from exiting. but, In case of plain thread, it is not daemon thread.
 */
public class ESleepInSupplyAsyncVsPlainThread {

  //
  public void sleepInSupplyAsync() {
    CompletableFuture<String> completableFuture =
        CompletableFuture.supplyAsync(
            () -> {
              try {
                Thread.sleep(4000); // Simulating some work with sleep
                System.out.println(
                    "Asynchronous task completed. Thread Name: "
                        + Thread.currentThread().getName());
              } catch (InterruptedException e) {
                throw new RuntimeException(e);
              }
              return "Task completed after sleep";
            });
  }

  public void sleepInRunningThread() {
    Thread thread =
        new Thread(
            () -> {
              try {
                Thread.sleep(4000); // Simulating some work with sleep
                System.out.println(
                    "Runnable task completed. Thread Name: " + Thread.currentThread().getName());
              } catch (InterruptedException e) {
                throw new RuntimeException(e);
              }
            });
    thread.start();
  }

  public static void main(String[] args) {
    ESleepInSupplyAsyncVsPlainThread operation = new ESleepInSupplyAsyncVsPlainThread();

    // Test sleep in supplyAsync
    //        operation.sleepInSupplyAsync();
    //        System.out.println("Asynchronous task initiated. Thread Name: " +
    // Thread.currentThread().getName());

    // Test sleep in running thread
    operation.sleepInRunningThread();
    System.out.println("Runnable task initiated. Thread Name: " + Thread.currentThread().getName());
  }
}
