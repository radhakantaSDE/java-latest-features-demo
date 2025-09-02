package com.learn.app.concepts.threading.programs;

import java.util.LinkedList;

class SharedResource {
  private LinkedList<Integer> resources = new LinkedList<>();
  private final int MAX_SIZE = 5;

  public synchronized void produce(int value) {
    while (resources.size() == MAX_SIZE) {
      try {
        wait();
      } catch (InterruptedException e) {
        System.out.println("Producer interrupted: " + e.getMessage());
      }
    }
    resources.add(value);
    System.out.println("Produced: " + value);
    notifyAll();
  }

  public synchronized void consume() {
    while (resources.isEmpty()) {
      try {
        wait();
      } catch (Exception e) {
        System.out.println("Consumer interrupted: " + e.getMessage());
      }
    }
    int data = resources.removeFirst();
    System.out.println("Consumed: " + data);
    notifyAll();
  }
}

class Producer implements Runnable {

  private SharedResource sharedResource;

  public Producer(SharedResource sharedResource) {
    this.sharedResource = sharedResource;
  }

  public void run() {
    for (int i = 0; i < 10; i++) {
      sharedResource.produce(i);
      try {
        Thread.sleep(1000);
      } catch (Exception e) {
        System.out.println("Producer interrupted: " + e.getMessage());
      }
    }
  }
}

class Consumer implements Runnable {

  private SharedResource sharedResource;

  public Consumer(SharedResource sharedResource) {
    this.sharedResource = sharedResource;
  }

  public void run() {
    for (int i = 0; i < 10; i++) {
      sharedResource.consume();
      try {
        Thread.sleep(3000);
      } catch (Exception e) {
        System.out.println("Producer interrupted: " + e.getMessage());
      }
    }
  }
}

public class ProducerConsumer {

  public static void main(String[] args) {
    SharedResource sharedResource = new SharedResource();
    Thread producerThread = new Thread(new Producer(sharedResource), "Producer");
    Thread consumerThread = new Thread(new Consumer(sharedResource), "Consumer");
    producerThread.start();
    consumerThread.start();
  }
}
