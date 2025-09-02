package com.learn.app.concepts.collection.arraylist;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueOperations {

  // Create a queue example
  public void queueExample() {
    Queue<String> queue = new LinkedList<>();

    // Adding elements to the queue
    queue.add("Element 1");
    queue.add("Element 2");
    queue.add("Element 3");

    // Displaying the queue
    System.out.println("Queue: " + queue);

    // Removing an element from the queue
    String removedElement = queue.poll();
    System.out.println("Removed Element: " + removedElement);

    // Displaying the queue after removal
    System.out.println("Queue after removal: " + queue);
  }

  // Example of a priority queue - Default is a min-heap
  public void priorityQueueMinHeapExample() {

    // Creating a priority queue - Default is min-heap
    Queue<Integer> priorityQueue = new PriorityQueue<>();
    // Adding elements to the priority queue
    priorityQueue.add(5);
    priorityQueue.add(1);
    priorityQueue.add(3);

    // Displaying the priority queue
    System.out.println("Priority Queue: " + priorityQueue);

    // Removing the head of the priority queue
    Integer head = priorityQueue.poll();
    System.out.println("Removed Head: " + head);
  }

  // Example of a priority queue with custom comparator (max-heap)
  public void priorityQueueMaxHeapExample() {
    // Creating a priority queue with a custom comparator for max-heap
    Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

    // Adding elements to the max-heap
    maxHeap.add(5);
    maxHeap.add(1);
    maxHeap.add(3);

    // Displaying the max-heap
    System.out.println("Max Heap: " + maxHeap);

    // Removing the head of the max-heap
    Integer head = maxHeap.poll();
    System.out.println("Removed Head from Max Heap: " + head);
  }

  public static void main(String[] args) {
    QueueOperations operations = new QueueOperations();
    operations.queueExample();

    operations.priorityQueueMinHeapExample();
    operations.priorityQueueMaxHeapExample();
  }
}
