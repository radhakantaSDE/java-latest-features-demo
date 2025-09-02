package com.learn.app.concepts.threading.locking;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import lombok.Getter;

@Getter
class BasicCounter {
  private int count = 0;

  public void increment() {
    synchronized (this) {
      count = count + 1;
      System.out.println("Counter: " + count + " Thread: " + Thread.currentThread().getName());
    }
  }
}

class CounterThread implements Runnable {
  private final BasicCounter basicCounter;

  public CounterThread(BasicCounter basicCounter) {
    this.basicCounter = basicCounter;
  }

  @Override
  public void run() {
    basicCounter.increment();
  }
}

public class BasicLockOperation {
  public static void main(String[] args) {
    try (ExecutorService executorService = Executors.newFixedThreadPool(3)) {
      BasicCounter basicCounter = new BasicCounter();
      for (int i = 0; i < 10; i++) {
        executorService.submit(new CounterThread(basicCounter));
      }
    }
  }
}
