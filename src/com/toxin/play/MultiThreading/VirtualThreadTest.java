package com.toxin.play.MultiThreading;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class VirtualThreadTest {

    public static void main(String[] args) {
        List<Task> tasks = generateTasks();

        long start = System.currentTimeMillis();

        try (ExecutorService es = Executors.newVirtualThreadPerTaskExecutor()) {
            tasks.forEach(es::submit);
        }

        long end = System.currentTimeMillis();

        System.out.println("TIME: " + (end - start));
    }

    private static List<Task> generateTasks() {
        return IntStream.rangeClosed(0, 1_000_000)
                .mapToObj(Task::new)
                .toList();
    }

    private record Task(int number) implements Runnable {
        @Override
            public void run() {
                System.out.println("DO WORK = " + number);
            }
        }
}
