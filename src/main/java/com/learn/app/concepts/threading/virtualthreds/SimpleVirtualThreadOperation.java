package com.learn.app.concepts.threading.virtualthreds;

public class SimpleVirtualThreadOperation {
  public static void main(String[] args) {
    Thread thread =
        Thread.startVirtualThread(
            () -> {
              System.out.println("virtual thread! Thread: " + Thread.currentThread().getName());
            });

    Thread threadWithName =
        Thread.ofVirtual()
            .name("VirtualThread#001")
            .start(
                () -> {
                  System.out.println(
                      "Virtual thread(With name)! Thread: " + Thread.currentThread().getName());
                });

    System.out.println(
        "Virtual thread started: " + thread.getName() + " isDaemon: " + thread.isDaemon());
    System.out.println(
        "Virtual thread (With name) started: "
            + threadWithName.getName()
            + " isDaemon: "
            + threadWithName.isDaemon());
    try {
      thread.join();
      threadWithName.join();
    } catch (InterruptedException e) {
      System.out.println("Virtual thread interrupted: " + e.getMessage());
    }
  }
}
