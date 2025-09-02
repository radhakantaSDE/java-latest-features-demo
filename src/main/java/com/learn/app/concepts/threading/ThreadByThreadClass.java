package com.learn.app.concepts.threading;

class MyThread extends Thread {

  @Override
  public void run() {
    try {
      Thread.sleep(4000); // Simulating some work with sleep
      System.out.println(
          "Thread by extending Thread class. Thread Name: " + Thread.currentThread().getName());
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}

public class ThreadByThreadClass {

  public static void main(String[] args) {
    MyThread thread = new MyThread();
    thread.start();
    System.out.println("Thread started. Thread Name: " + Thread.currentThread().getName());
  }
}
