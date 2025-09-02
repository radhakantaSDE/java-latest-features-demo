package com.learn.app.concepts.threading.programs;

class SafeCounter {
  private int count = 0;
  private Thread lastThread = null;

  public SafeCounter(int initialCount) {
    this.count = initialCount;
  }

  public synchronized void increment() {

    while (lastThread == Thread.currentThread()) {
      try {
        wait();
      } catch (InterruptedException e) {
        System.out.println("Thread interrupted: " + e.getMessage());
      }
    }

    count = count + 1;
    lastThread = Thread.currentThread();
    System.out.println("Incrementing count: " + count + " by " + Thread.currentThread().getName());
    notifyAll();
  }

  public synchronized int getCount() {
    return count;
  }
}

class CounterTask implements Runnable {
  private SafeCounter counter;

  public CounterTask(SafeCounter counter) {
    this.counter = counter;
  }

  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {
      counter.increment();
      try {
        Thread.sleep(100); // Simulate some work
      } catch (InterruptedException e) {
        System.out.println("Thread interrupted: " + e.getMessage());
      }
    }
  }
}

public class ThreadSafeCounter {

  public static void main(String[] args) {

    SafeCounter counter = new SafeCounter(0);
    Thread thread1 = new Thread(new CounterTask(counter), "Thread-1");
    Thread thread2 = new Thread(new CounterTask(counter), "Thread-2");

    thread1.start();
    thread2.start();
  }
}
