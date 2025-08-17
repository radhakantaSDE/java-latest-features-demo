package com.learn.app.concepts.threading.forkjoinpool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

class DoubleArrayTask extends RecursiveAction {
    private int[] arr;
    private int start, end;
    private static final int THRESHOLD = 3;

    public DoubleArrayTask(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        if (end - start <= THRESHOLD) {
            // Base case: process directly
            for (int i = start; i < end; i++) {
                arr[i] *= 2;
            }
        } else {
            // Recursive case: split task
            int mid = (start + end) / 2;
            DoubleArrayTask left = new DoubleArrayTask(arr, start, mid);
            DoubleArrayTask right = new DoubleArrayTask(arr, mid, end);
            invokeAll(left, right); // run both in parallel
        }
    }
}
public class RecursiveActionExample {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6};
        ForkJoinPool pool = new ForkJoinPool();
        DoubleArrayTask task = new DoubleArrayTask(numbers, 0, numbers.length);
        pool.invoke(task);
        System.out.println("Doubled array:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        pool.close();
    }
}


