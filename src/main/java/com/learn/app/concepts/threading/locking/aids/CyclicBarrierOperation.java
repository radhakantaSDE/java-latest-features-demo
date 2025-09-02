package com.learn.app.concepts.threading.locking.aids;

import java.util.concurrent.CyclicBarrier;

class CycleWorker implements Runnable {
  private final CyclicBarrier barrier;

  public CycleWorker(CyclicBarrier barrier) {
    this.barrier = barrier;
  }

  @Override
  public void run() {
    try {
      System.out.println(
          "Thread " + Thread.currentThread().getName() + " is waiting at the barrier.");
      barrier.await(); // Wait for other threads to reach this point
      System.out.println(
          "Thread " + Thread.currentThread().getName() + " has crossed the barrier.");
    } catch (Exception e) {
      System.out.println(
          "Exception in thread " + Thread.currentThread().getName() + ": " + e.getMessage());
    }
  }
}

public class CyclicBarrierOperation {
  public static void main(String[] args) {
    int numberOfThreads = 3;
    CyclicBarrier barrier =
        new CyclicBarrier(
            numberOfThreads,
            () -> {
              System.out.println("All threads have reached the barrier. Barrier is now reset.");
            });
    for (int i = 0; i < numberOfThreads; i++) {
      new Thread(new CycleWorker(barrier), "Thread-" + (i + 1)).start();
    }
  }
}
