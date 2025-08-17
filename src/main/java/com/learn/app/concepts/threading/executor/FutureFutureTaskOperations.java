package com.learn.app.concepts.threading.executor;

import lombok.Builder;
import lombok.Data;

import java.util.concurrent.*;

/**
 * Future<T> and FutureTask<T> are used to represent the result of an asynchronous computation.
 * Future<T> is an interface that provides methods to check if the computation is complete,
 * retrieve the result, and cancel the computation.
 * Provides methods to:
 *      Check if the computation is complete (isDone()).
 *      Cancel the computation (cancel()).
 *      Retrieve the result (get()).
 *
 * FutureTask<T> ::
 * FutureTask<T> is a concrete implementation of Future<T> that can be used to wrap a Callable<T> or Runnable.
 * It allows you to create a task that can be executed asynchronously and provides methods to manage the task's execution state.
 *
 * */

@Data
@Builder
class FutureTaskWorker<T> implements Runnable {
    private T data;
    public FutureTaskWorker(T data) {
        this.data = data;
    }

    public void run() {
        System.out.println("Running FutureTask with data: " + data);
        try {
            Thread.sleep(1000); // Simulating a delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("FutureTask interrupted");
        }
    }
}

public class FutureFutureTaskOperations {

    // Ex-1: FutureTask with Runnable. FutureTask can be used to wrap a Runnable or Callable and can be executed by an
    public void futureTaskWithRunnable() {

        FutureTaskWorker<Integer> futureTaskWorker = new FutureTaskWorker<>(1000);

        FutureTask<Integer> futureTask = new FutureTask<>(futureTaskWorker, futureTaskWorker.getData());

        try(ExecutorService executorService = Executors.newFixedThreadPool(2)) {

            executorService.submit(futureTask);
        }
    }

    public void futureTaskWithCallable() {
        Callable<Integer> callableTask = () -> {
            System.out.println("Running FutureTask with Callable");
            Thread.sleep(1000); // Simulating a delay
            return 42; // Returning some result
        };

        FutureTask<Integer> futureTask = new FutureTask<>(callableTask);
        try (ExecutorService executorService = Executors.newFixedThreadPool(2)) {
            executorService.submit(futureTask);
            Integer result = futureTask.get(); // Blocking call to get the result
            System.out.println("FutureTask completed with result: " + result);
        } catch (Exception e) {
            System.out.println("Exception occurred while executing FutureTask: " + e.getMessage());
        }
    }


    public static void main(String[] args) {
        FutureFutureTaskOperations operations = new FutureFutureTaskOperations();
        operations.futureTaskWithRunnable();
        System.out.println("FutureTask submitted successfully.");

    }
}
