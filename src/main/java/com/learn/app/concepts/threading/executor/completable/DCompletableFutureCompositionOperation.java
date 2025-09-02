package com.learn.app.concepts.threading.executor.completable;

import java.util.concurrent.CompletableFuture;

// allOf(), anyOff(), thenCombine()
public class DCompletableFutureCompositionOperation {

  // Ex-1: Example of anyOff()
  public void testAllOf() {

    CompletableFuture<String> one =
        CompletableFuture.supplyAsync(
            () -> {
              System.out.println("One. Thread: " + Thread.currentThread().getName());
              return "One Task";
            });
    CompletableFuture<String> two =
        CompletableFuture.supplyAsync(
            () -> {
              try {
                Thread.sleep(4000);
                System.out.println("Two. Thread: " + Thread.currentThread().getName());
              } catch (Exception e) {
                throw new RuntimeException(e);
              }
              return "Two Task";
            });
    CompletableFuture<String> three =
        CompletableFuture.supplyAsync(
            () -> {
              System.out.println("Three. Thread: " + Thread.currentThread().getName());
              return "Three Task";
            });

    CompletableFuture<Void> all =
        CompletableFuture.allOf(one, two, three)
            .thenRun(
                () -> {
                  System.out.println("All tasks completed successfully.");
                  System.out.println(
                      "Results: " + one.join() + ", " + two.join() + ", " + three.join());
                });

    all.join();
  }

  public void testAnyOf() {
    CompletableFuture<String> one =
        CompletableFuture.supplyAsync(
            () -> {
              System.out.println("One. Thread: " + Thread.currentThread().getName());
              return "One Task";
            });
    CompletableFuture<String> two =
        CompletableFuture.supplyAsync(
            () -> {
              try {
                Thread.sleep(40000);
                System.out.println("Two. Thread: " + Thread.currentThread().getName());
              } catch (Exception e) {
                throw new RuntimeException(e);
              }
              return "Two Task";
            });
    CompletableFuture<String> three =
        CompletableFuture.supplyAsync(
            () -> {
              System.out.println("Three. Thread: " + Thread.currentThread().getName());
              return "Three Task";
            });

    CompletableFuture<Void> any =
        CompletableFuture.anyOf(one, two, three)
            .thenAccept(
                result -> {
                  System.out.println("First completed task result: " + result);
                });

    //        any.join();
  }

  public static void main(String[] args) {
    DCompletableFutureCompositionOperation operation = new DCompletableFutureCompositionOperation();
    //        System.out.println("************************ Ex-1: CompletableFuture.allOf()
    // *****************");
    //        operation.testAllOf();

    operation.testAnyOf();
    System.out.println(
        "************************ Completed: CompletableFuture.anyOf() *****************");

    // Note: You can add more examples for anyOff() and thenCombine() as needed.
  }
}
