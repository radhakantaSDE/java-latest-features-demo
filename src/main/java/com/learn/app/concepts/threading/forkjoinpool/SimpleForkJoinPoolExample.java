package com.learn.app.concepts.threading.forkjoinpool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinWorkerThread;

public class SimpleForkJoinPoolExample {

  public static void main(String[] args) {
    try {
      ForkJoinPool.ForkJoinWorkerThreadFactory customFactory =
          pool -> {
            ForkJoinWorkerThread worker =
                ForkJoinPool.defaultForkJoinWorkerThreadFactory.newThread(pool);
            worker.setName("CustomWorker-" + worker.getPoolIndex());
            return worker;
          };
      ForkJoinPool customPool = new ForkJoinPool(4, customFactory, null, false);
      // Code should go here to submit tasks to the custom pool
      customPool.close();
    } catch (Exception e) {
      System.err.println("Error occurred while creating ForkJoinPool: " + e.getMessage());
    }
  }
}
