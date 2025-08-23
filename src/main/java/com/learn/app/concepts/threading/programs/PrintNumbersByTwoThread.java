package com.learn.app.concepts.threading.programs;

/**
 * Print numbers from 1 to 10 using two threads alternately
 * */
class PrinterNumbers {
    private boolean isOddTurn = true;
    public synchronized void print(int number) {
        if (number % 2 == 0) {
            while (isOddTurn) {
                try {
                    wait();
                }catch (Exception e) {
                    System.out.println("Exception in EvenPrinter: " + e.getMessage());
                }
            }
            System.out.println("Even: " + number);
            isOddTurn = true;
            notifyAll();
        }else {
            while (!isOddTurn) {
                try {
                    wait();
                }catch (Exception e) {
                    System.out.println("Exception in OddPrinter: " + e.getMessage());
                }
            }
            System.out.println("Odd: " + number);
            isOddTurn = false;
            notifyAll();
        }
    }
}


class OddPrinter implements Runnable {
    private PrinterNumbers printerNumbers;

    public OddPrinter(PrinterNumbers printerNumbers) {
        this.printerNumbers = printerNumbers;
    }

    public void run() {
        for (int i=1; i<=10; i +=2) {
            printerNumbers.print(i);
        }
    }
}

class EvenPrinter implements Runnable {
    private PrinterNumbers printerNumbers;

    public EvenPrinter(PrinterNumbers printerNumbers) {
        this.printerNumbers = printerNumbers;
    }

    public void run() {
        for (int i=2; i<=10; i +=2) {
            printerNumbers.print(i);
        }
    }
}

public class PrintNumbersByTwoThread {

    public static void main(String[] args) {
        PrinterNumbers printerNumbers = new PrinterNumbers();
        Thread oddThread = new Thread(new OddPrinter(printerNumbers));
        Thread evenThread = new Thread(new EvenPrinter(printerNumbers));

        oddThread.start();
        evenThread.start();
    }
}
