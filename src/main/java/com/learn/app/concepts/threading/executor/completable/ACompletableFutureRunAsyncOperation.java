package com.learn.app.concepts.threading.executor.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CompletableFuture<T> is an implementation of Future<T> that allows you to write asynchronous,
 * non-blocking code. It provides a way to handle the result of an asynchronous computation and
 * allows you to chain multiple asynchronous operations together. * Key features of
 * CompletableFuture: 1. Asynchronous Execution: CompletableFuture allows you to run tasks
 * asynchronously without blocking the main thread. You can submit tasks that will be executed in
 * the background. 2. Chaining: You can chain multiple asynchronous operations together using
 * methods like thenApply(), thenAccept(), and thenRun(). This allows you to create a pipeline of
 * operations that will be executed in sequence once the previous operation completes. 3. Exception
 * Handling: CompletableFuture provides methods like exceptionally() and handle() to handle
 * exceptions that may occur during the execution of asynchronous tasks. 4. Completion Stages:
 * CompletableFuture supports completion stages, which allow you to define what should happen when a
 * task completes, whether it completes successfully or exceptionally. 5. Non-blocking:
 * CompletableFuture allows you to write non-blocking code, meaning you can continue executing other
 * tasks while waiting for the result of an asynchronous operation. 6. Combining Results: You can
 * combine results from multiple CompletableFutures using methods like allOf() and anyOf(). This
 * allows you to wait for multiple asynchronous tasks to complete and then process their results
 * together. 7. Timeout Support: CompletableFuture provides methods to set timeouts for asynchronous
 * operations, allowing you to specify how long to wait for a task to complete before considering it
 * failed. 8. Thread Safety: CompletableFuture is designed to be thread-safe, allowing you to safely
 * use it in multi-threaded environments without additional synchronization.
 */
public class ACompletableFutureRunAsyncOperation {

  public void runAsyncOperation() {
    CompletableFuture<Void> completableFuture =
        CompletableFuture.runAsync(
            () -> {
              try {
                // Simulating a long-running task
                Thread.sleep(2000);
                System.out.println("Asynchronous operation completed successfully.");
              } catch (InterruptedException e) {
                System.err.println("Asynchronous operation was interrupted: " + e.getMessage());
              }
            });

    try {
      completableFuture.get();
    } catch (Exception e) {
      System.err.println(
          "Error occurred while waiting for the asynchronous operation to complete: "
              + e.getMessage());
    }
  }

  public void runAsyncWithCustomExecutorOperation() {

    try (ExecutorService executorService = Executors.newFixedThreadPool(2)) {
      CompletableFuture<Void> completableFuture =
          CompletableFuture.runAsync(
              () -> {
                try {
                  // Simulating a long-running task
                  Thread.sleep(2000);
                  System.out.println(
                      "Asynchronous operation completed successfully. Thread: "
                          + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                  System.err.println("Asynchronous operation was interrupted: " + e.getMessage());
                }
              },
              executorService);
      completableFuture.get();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public static void main(String[] args) {
    ACompletableFutureRunAsyncOperation operation = new ACompletableFutureRunAsyncOperation();
    operation.runAsyncOperation();
    System.out.println(
        "************************ Ex-2: RunAsync with custom executor *****************");
    operation.runAsyncWithCustomExecutorOperation();
  }
}
