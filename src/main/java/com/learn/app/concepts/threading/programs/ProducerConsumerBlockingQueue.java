package com.learn.app.concepts.threading.programs;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class BlockingProducer implements Runnable {

  private BlockingQueue<Integer> queue;

  public BlockingProducer(BlockingQueue<Integer> queue) {
    this.queue = queue;
  }

  @Override
  public void run() {
    for (int i = 0; i < 40; i++) {
      try {
        queue.put(i);
        System.out.println("Produced : " + i);
      } catch (InterruptedException e) {
        System.out.println("Error in producer " + e.getMessage());
      }
    }
  }
}

class BlockingConsumer implements Runnable {

  private BlockingQueue<Integer> queue;

  public BlockingConsumer(BlockingQueue<Integer> queue) {
    this.queue = queue;
  }

  @Override
  public void run() {
    while (!queue.isEmpty()) {
      try {
        int consumedMessage = queue.take();
        System.out.println("Consumed message : " + consumedMessage);
      } catch (InterruptedException e) {
        System.out.println("Error in consumer " + e.getMessage());
      }
    }
  }
}

public class ProducerConsumerBlockingQueue {

  public static void main(String[] args) {

    BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(40);
    Thread producer = new Thread(new BlockingProducer(blockingQueue));
    Thread consumer = new Thread(new BlockingConsumer(blockingQueue));

    producer.start();
    consumer.start();
  }
}
