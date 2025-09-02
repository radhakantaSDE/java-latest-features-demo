package com.learn.app.features.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ThreadCreation {

  public static void main(String[] args) {

    // 1. Extension of Thread class
    OneThread t1 = new OneThread();
    t1.start();

    // 2. Implementation of Runnable class
    Thread t2 = new Thread(new TwoThread());
    t2.start();

    // 3. Implements Callable interface
    FutureTask<Integer> task = new FutureTask<>(new ThreeThread());
    Thread t3 = new Thread(task);
    t3.start();
  }
}

class OneThread extends Thread {

  @Override
  public void run() {
    System.out.println("Extended Thread class : " + Thread.currentThread().getName());
  }
}

class TwoThread implements Runnable {

  @Override
  public void run() {
    System.out.println(
        "Implementation of Runnable interface : " + Thread.currentThread().getName());
  }
}

class ThreeThread implements Callable<Integer> {

  @Override
  public Integer call() {
    System.out.println(
        "Implementation of callable interface : " + Thread.currentThread().getName());
    return 1;
  }
}
