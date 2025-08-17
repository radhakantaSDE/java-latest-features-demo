package com.learn.app.concepts.threading.forkjoinpool;


import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class SimpleSumTask extends RecursiveTask<Integer> {

    private int[] arr;
    private int start, end;

    public SimpleSumTask(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (end - start <= 2) {
            // Base case: sum directly
            int sum = 0;
            for (int i = start; i < end; i++) {
                sum += arr[i];
            }
            return sum;
        } else {
            // Recursive case: split task
            int mid = (start + end) / 2;
            SimpleSumTask left = new SimpleSumTask(arr, start, mid);
            SimpleSumTask right = new SimpleSumTask(arr, mid, end);
            left.fork(); // run left in parallel
            // compute right directly - no need to fork if required then, it will fork by thread
            int rightResult = right.compute();
            int leftResult = left.join(); // wait for left
            return leftResult + rightResult;
        }
    }
}
public class ForkJonPoolSumListOfNumbers {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        ForkJoinPool pool = new ForkJoinPool();
        SimpleSumTask task = new SimpleSumTask(numbers, 0, numbers.length);
        int result = pool.invoke(task);
        System.out.println("Sum: " + result);
        pool.close();
    }
}
