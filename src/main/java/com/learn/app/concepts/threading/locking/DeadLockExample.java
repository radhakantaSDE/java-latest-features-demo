package com.learn.app.concepts.threading.locking;

public class DeadLockExample {
  public static void main(String[] args) {
    String lock1 = "Lock1";
    String lock2 = "Lock2";

    Thread thread1 =
        new Thread(
            () -> {
              synchronized (lock1) {
                System.out.println("Thread 1 : Holding " + lock1);
                synchronized (lock2) {
                  System.out.println("Thread 1 : Holding " + lock1 + " and " + lock2);
                  try {
                    Thread.sleep(100);
                  } catch (InterruptedException e) {
                    System.out.println("Thread 1 interrupted");
                  }
                }
              }
            });

    Thread thread2 =
        new Thread(
            () -> {
              synchronized (lock2) {
                System.out.println("Thread 2 : Holding " + lock2);
                synchronized (lock1) {
                  System.out.println("Thread 2 : Holding " + lock2 + " and " + lock1);
                  try {
                    Thread.sleep(100);
                  } catch (InterruptedException e) {
                    System.out.println("Thread 2 interrupted");
                  }
                }
              }
            });
    thread1.start();
    thread2.start();
  }
}
