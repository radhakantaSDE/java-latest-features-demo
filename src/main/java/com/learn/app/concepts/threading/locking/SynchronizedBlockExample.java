package com.learn.app.concepts.threading.locking;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Printer {
    public void print() {
        synchronized (this) {
            System.out.println("Printing By:  Thread: " + Thread.currentThread().getName());
            for (int i = 0; i < 5; i++) {
                System.out.println(i);
            }
        }
    }
}
class PrinterWorker implements Runnable {
    private final Printer printer;
    public PrinterWorker(Printer printer) {
        this.printer = printer;
    }
    @Override
    public void run() {
        printer.print();
    }
}
public class SynchronizedBlockExample {
    public static void main(String[] args) {
        try (ExecutorService executorService = Executors.newFixedThreadPool(3)) {
            Printer printer = new Printer();
            for (int i=0; i<=3; i++) {
                executorService.execute(new PrinterWorker(printer));
            }
        }
    }
}
