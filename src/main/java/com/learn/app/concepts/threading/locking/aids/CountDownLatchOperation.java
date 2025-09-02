package com.learn.app.concepts.threading.locking.aids;

import java.util.concurrent.CountDownLatch;

class Cooker {
  private CountDownLatch latch;

  public Cooker(int count) {
    this.latch = new CountDownLatch(count);
  }

  public void cook(String dish) {
    System.out.println("Cooking " + dish + " by Thread: " + Thread.currentThread().getName());
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
    latch.countDown(); // Decrement the count of the latch
    System.out.println(dish + " is ready!");
  }

  public void waitForCooking() {
    try {
      latch.await(); // Wait until the count reaches zero
      System.out.println("All dishes are ready!");
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }
}

public class CountDownLatchOperation {
  public static void main(String[] args) {
    Cooker cooker = new Cooker(3); // CountDownLatch initialized with 3
    Thread chef1 = new Thread(() -> cooker.cook("Pasta"));
    Thread chef2 = new Thread(() -> cooker.cook("Pizza"));
    Thread chef3 = new Thread(() -> cooker.cook("Salad"));
    chef1.start();
    chef2.start();
    chef3.start();
    cooker.waitForCooking(); // Main thread waits for all dishes to be ready
    System.out.println("All cooking operations completed.");
  }
}
