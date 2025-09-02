package com.learn.app.concepts.collection.map;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapOperation {

  // Ex-1 : Insertion order in ConcurrentHashMap
  public void concurrentHashMapInsertionOrderExample() {
    ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();

    // Adding elements to the ConcurrentHashMap
    concurrentHashMap.put("B", 2);
    concurrentHashMap.put("A", 1);
    concurrentHashMap.put("C", 3);

    // Displaying the ConcurrentHashMap
    System.out.println("ConcurrentHashMap: " + concurrentHashMap);

    // Removing an element from the ConcurrentHashMap
    concurrentHashMap.remove("B");
    System.out.println("ConcurrentHashMap after removal: " + concurrentHashMap);
  }

  // Ex-2 : ConcurrentHashMap with multiple threads
  public void concurrentHashMapMultiThreadExample() {
    ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();

    // Adding elements to the ConcurrentHashMap
    concurrentHashMap.put("A", 1);
    concurrentHashMap.put("B", 2);

    // Simulating multiple threads updating the map
    Runnable task1 =
        () -> {
          for (int i = 0; i < 5; i++) {
            concurrentHashMap.put("Thread1-" + i, i);
          }
        };

    Runnable task2 =
        () -> {
          for (int i = 0; i < 5; i++) {
            concurrentHashMap.put("Thread2-" + i, i + 5);
          }
        };

    Thread thread1 = new Thread(task1);
    Thread thread2 = new Thread(task2);

    thread1.start();
    thread2.start();

    try {
      thread1.join();
      thread2.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("ConcurrentHashMap after multi-threading: " + concurrentHashMap);
  }

  public static void main(String[] args) {
    ConcurrentHashMapOperation operation = new ConcurrentHashMapOperation();
    operation.concurrentHashMapInsertionOrderExample();

    operation.concurrentHashMapMultiThreadExample();
  }
}
