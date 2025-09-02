package com.learn.app.concepts.threading.executor.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BCompletableFutureSupplyAsyncOperation {

  public void supplyAsyncOperation() {
    CompletableFuture<Integer> completableFuture =
        CompletableFuture.supplyAsync(
            () -> {
              try {
                Thread.sleep(100);
              } catch (Exception e) {
                System.err.println(
                    "Error occurred during asynchronous operation: " + e.getMessage());
              }
              return 100;
            });
    try {
      Integer res = completableFuture.get();
      System.out.println("Asynchronous operation completed successfully with result: " + res);
    } catch (Exception e) {
      System.err.println(
          "Error occurred while waiting for the asynchronous operation to complete: "
              + e.getMessage());
    }
  }

  public void supplyAsyncWithCustomExecutorOperation() {

    try (ExecutorService executorService = Executors.newFixedThreadPool(3)) {
      CompletableFuture<Integer> completableFuture =
          CompletableFuture.supplyAsync(
              () -> {
                try {
                  Thread.sleep(2000);
                } catch (Exception e) {
                  System.out.println(
                      "Error occurred during asynchronous operation: " + e.getMessage());
                }
                return 1000;
              },
              executorService);

      Integer res = completableFuture.get();
      System.out.println("Asynchronous operation completed successfully with result: " + res);
    } catch (Exception e) {
      System.out.println("Error occurred while creating executor service: " + e.getMessage());
    }
  }

  public static void main(String[] args) {
    BCompletableFutureSupplyAsyncOperation operation = new BCompletableFutureSupplyAsyncOperation();
    operation.supplyAsyncOperation();
    System.out.println(
        "************************ Ex-2: SupplyAsync with custom executor *****************");
    operation.supplyAsyncWithCustomExecutorOperation();
  }
}
