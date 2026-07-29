package com.toxin.play.MultiThreading;


import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolTest {

    public static void main(String[] args) {
        int size = 1_000_000;
        int[] array = new int[size];

        fillArray(array);

        long start = System.currentTimeMillis();

        try (ForkJoinPool pool = new ForkJoinPool()) {
            long sum = pool.invoke(new Task(array, 0, size));
            checkSum(sum, size);
        }

        long end = System.currentTimeMillis();
        System.out.println("TIME: " + (end - start));
    }

    private static void checkSum(long actual, int n) {
        long excepted = (long) n * (n + 1) / 2;
        if (excepted == actual) {
            System.out.println("RESULT CORRECT !");
        } else {
            System.out.println("RESULT WRONG !");
        }
    }

    private static void fillArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
    }

    private static class Task extends RecursiveTask<Long> {

        private final static int THRESHOLD = 1000;

        private final int[] array;
        private final int start;
        private final int end;

        public Task(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            if (end - start <= THRESHOLD) {
                long sum = 0;
                for (int i = start; i < end; i++) {
                    sum += array[i];
                }
                return sum;
            } else {
                int mid = (end - start) / 2 + start;
                Task leftTask = new Task(array, start, mid);
                Task rightTask = new Task(array, mid, end);
                leftTask.fork();
                Long rightRes = rightTask.compute();
                Long leftRes = leftTask.join();
                return leftRes + rightRes;
            }
        }
    }
}
