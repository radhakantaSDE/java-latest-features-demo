package com.learn.app.concepts.threading.locking.advancedlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockOperation {
  int balance = 100;
  ReentrantLock lock = new ReentrantLock();

  public void withdrawBalance(int amount) {
    lock.lock();
    try {
      balance = balance - amount;
      System.out.println(
          "Balance after withdrawal: " + balance + " Thread: " + Thread.currentThread().getName());
    } catch (Exception e) {
      System.out.println("Exception occurred : " + e.getMessage());
    } finally {
      lock.unlock();
    }
  }

  public static void main(String[] args) {
    ReentrantLockOperation reentrantLockOperation = new ReentrantLockOperation();
    try (ExecutorService executorService = Executors.newFixedThreadPool(3)) {
      for (int i = 0; i < 5; i++) {
        // Using executor service to run the withdrawBalance method concurrently
        executorService.execute(
            () -> {
              reentrantLockOperation.withdrawBalance(20);
            });
      }
    }
  }
}
