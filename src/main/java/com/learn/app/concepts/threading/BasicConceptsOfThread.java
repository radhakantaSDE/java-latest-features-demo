package com.learn.app.concepts.threading;

public class BasicConceptsOfThread {

    // Ex-1 : Sleeping of a thread
    public void threadSleepExample() {

        Thread thread1 = new Thread(() -> {
            try {
                Thread.sleep(1000); // Sleep for 1000 milliseconds (1 second)
                System.out.println("Thread 1 woke up after sleeping for 1 second");
            }catch (Exception ex) {
                System.out.println("Thread 1 encountered an exception: " + ex.getMessage());
            }
        });
        thread1.start();
    }

    // Ex-2 : Thread.sleep() with InterruptedException
    public void threadSleepWithInterruptedExceptionExample() {
        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(2000); // Sleep for 2000 milliseconds (2 seconds)
                System.out.println("Thread 2 woke up after sleeping for 2 seconds");
            } catch (InterruptedException e) {
                System.out.println("Thread 2 was interrupted: " + e.getMessage());
            }
        });
        thread2.start();
        try {
            // Interrupt the thread after 1 second
            Thread.sleep(1000);
            thread2.interrupt(); // This will interrupt thread2
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted: " + e.getMessage());
        }
    }

    // Ex-3 : Start a thread twice (will throw IllegalThreadStateException)
    public void startThreadTwiceExample() {
        Thread thread1 = new Thread(() -> {
            System.out.println("This thread is running");
        });

        thread1.start();
        try {
            thread1.start(); // Attempting to start the same thread again
        } catch (IllegalThreadStateException e) {
            System.out.println("Starting a thread twice failed. Caught IllegalThreadStateException: " + e.getMessage());
        }
    }

    // Ex-4 : Execute run method directly (not recommended)
    public void runMethodDirectlyExample() {
        Thread thread3 = new Thread(() -> {
            System.out.println("This is the run method being executed directly. Thread name: " + Thread.currentThread().getName());
        });

        // Calling run() directly instead of start()
        thread3.run(); // This will not start a new thread, it will execute in the current thread
    }

    // Ex-5 : Join example (not included in the original code, but useful)
    public void joinExample() {
        Thread joinThread1 = new Thread(() -> {
            try {
                Thread.sleep(5000); // Simulate some work
                System.out.println("T1 : Join thread finished work. Thread name: " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                System.out.println("Join thread was interrupted: " + e.getMessage());
            }
        });
        Thread joinThread2 = new Thread(() -> {
            try {
                System.out.println("T2 : Join thread finished work. Thread name: " + Thread.currentThread().getName());
            } catch (Exception e) {
                System.out.println("Join thread was interrupted: " + e.getMessage());
            }
        });

        joinThread1.start();
        joinThread2.start();
        try {
            joinThread1.join(); // Wait for the joinThread to finish
            System.out.println("Main thread resumed after joinThread finished. Thread name: " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted: " + e.getMessage());
        }
    }


    public static void main(String[] args) {
        BasicConceptsOfThread concepts = new BasicConceptsOfThread();
//        concepts.threadSleepExample();
//        concepts.threadSleepWithInterruptedExceptionExample();
//        concepts.startThreadTwiceExample();
//        concepts.runMethodDirectlyExample();
        concepts.joinExample();
    }
}


class ThreadDemo extends Thread {
    public ThreadDemo(String threadName) {
        super(threadName);
    }
    @Override
    public void run() {
        System.out.println("Thread by extending Thread class");
    }
}

