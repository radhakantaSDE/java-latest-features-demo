package com.learn.app.concepts.threading.locking;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class StaticPrinter {
  public static synchronized void print() {
    System.out.println("Printing By:  Thread: " + Thread.currentThread().getName());
    for (int i = 0; i < 5; i++) {
      System.out.println(i);
    }
  }
}

class StaticBlockPrinter {
  public static void print() {
    synchronized (StaticBlockPrinter.class) {
      System.out.println("Printing By:  Thread: " + Thread.currentThread().getName());
      for (int i = 0; i < 5; i++) {
        System.out.println(i);
      }
    }
  }
}

class StaticPrinterWorker implements Runnable {
  private StaticPrinter staticPrinter;

  public StaticPrinterWorker(StaticPrinter staticPrinter) {
    this.staticPrinter = staticPrinter;
  }

  public void run() {
    StaticPrinter.print();
  }
}

public class StaticSynchronizationExample {
  public static void main(String[] args) {
    try (ExecutorService executorService = Executors.newFixedThreadPool(3)) {
      for (int i = 0; i <= 3; i++) {
        // Creating StaticPrinter class instances to demonstrate static synchronization
        StaticPrinter staticPrinter = new StaticPrinter();
        executorService.execute(new StaticPrinterWorker(staticPrinter));
      }
    }
  }
}
