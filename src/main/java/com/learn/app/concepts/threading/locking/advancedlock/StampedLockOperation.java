package com.learn.app.concepts.threading.locking.advancedlock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.StampedLock;

public class StampedLockOperation {
  private final Map<String, String> configMap = new HashMap<>();
  private final StampedLock stampedLock = new StampedLock();

  public void writeConfig(String key, String value) {
    long stamp = stampedLock.writeLock();
    try {
      configMap.put(key, value);
      System.out.println(
          "Config written: "
              + key
              + " = "
              + value
              + " by Thread: "
              + Thread.currentThread().getName());
    } finally {
      stampedLock.unlock(stamp);
    }
  }

  public String getConfig(String key) {
    long stamp = stampedLock.tryOptimisticRead();
    if (stampedLock.validate(stamp)) {
      String value = configMap.get(key);
      System.out.println(
          "Config read: "
              + key
              + " = "
              + value
              + " by Thread: "
              + Thread.currentThread().getName());
      return value;
    } else {
      stamp = stampedLock.readLock();
      try {
        String value = configMap.get(key);
        System.out.println(
            "Config read (after acquiring read lock): "
                + key
                + " = "
                + value
                + " by Thread: "
                + Thread.currentThread().getName());
        return value;
      } finally {
        stampedLock.unlockRead(stamp);
      }
    }
  }

  public static void main(String[] args) {
    StampedLockOperation operation = new StampedLockOperation();
    Thread writer1 =
        new Thread(
            () -> {
              operation.writeConfig("key1", "value1");
            },
            "Writer-1");
    Runnable reader =
        () -> {
          for (int i = 0; i < 5; i++) {
            try {
              Thread.sleep(100); // Simulate some delay
            } catch (InterruptedException e) {
              Thread.currentThread().interrupt();
            }
            operation.getConfig("key1");
          }
        };
    Thread reader1 = new Thread(reader, "Reader-1");
    Thread reader2 = new Thread(reader, "Reader-2");
    writer1.start();
    reader1.start();
    reader2.start();
  }
}
