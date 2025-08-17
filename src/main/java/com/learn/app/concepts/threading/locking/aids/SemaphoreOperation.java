package com.learn.app.concepts.threading.locking.aids;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

class SemaPrinter {
    private final Semaphore semaphore;
    public SemaPrinter(int permits) {
        this.semaphore = new Semaphore(permits);
    }
    public void print() {
        try {
            semaphore.acquire();
            for (int i = 0; i < 5; i++) {
                System.out.println("Printing By: Thread: " + Thread.currentThread().getName() + " - " + i);
                Thread.sleep(100); // Simulating some work
            }
        } catch (Exception e) {
            System.out.println("Exception in SemaPrinter: " + e.getMessage());
        }finally {
            semaphore.release();
        }
    }
}
public class SemaphoreOperation {
    public static void main(String[] args) {
        SemaPrinter printer = new SemaPrinter(2); // Allowing 2 threads to print concurrently
        try(ExecutorService executorService = Executors.newFixedThreadPool(3)) {
            for (int i = 0; i < 5; i++) {
                executorService.execute(printer::print);
            }
        } catch (Exception e) {
            System.out.println("Exception in ExecutorService: " + e.getMessage());
        } finally {
            System.out.println("All tasks submitted.");
        }
    }
}
