package com.learn.app.features.v21.virtualthread;

/** Understanding basics of virtual thread 1. Java Thread runs on top of OS-Threads */
public class VTBasics {

  public static void main(String[] args) {

    // 1. Basic way of creating virtual thread
    Thread vt =
        Thread.ofVirtual()
            .start(
                () ->
                    System.out.println(
                        "Running with Virtual thread : " + Thread.currentThread().threadId()));
    System.out.println("Virtual thread name : " + vt.threadId());

    Thread.startVirtualThread(
        () -> System.out.println("2nd Virtual thread : " + Thread.currentThread().threadId()));
  }
}
