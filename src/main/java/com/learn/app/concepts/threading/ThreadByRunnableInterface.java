package com.learn.app.concepts.threading;

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread by implementing Runnable interface");
    }
}

public class ThreadByRunnableInterface {

    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
