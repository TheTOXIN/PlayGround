package com.toxin.play.Async;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Stream;

public class FutureTest {

    public static void main(String[] args) throws Exception {
        test_1();
        test_2();
    }

    private static void test_1() throws Exception {
        Callable<String> task = () -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                return "ХАЙ";
            } catch (InterruptedException e) {
                return "ОЙ";
            }
        };

        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<String> future = executor.submit(task);

        System.out.println("ПОГНАЛИ");

        TimeUnit.SECONDS.sleep(3);

        System.out.println(future.isDone());
        System.out.println(future.get());

        CompletableFuture<Void> completableFuture = CompletableFuture
                .completedFuture("я из будущего")
                .exceptionally(Throwable::getMessage)
                .thenAccept(System.out::println);

        completableFuture.join();
    }

    private static void test_2() throws Exception {
//        List<Future<String>> tasks = new ArrayList<>();
//
//        Stream.of("TASK_1", "TASK_2", "TASK_3").forEach(t -> {
//            tasks.add()
//        });
    }
}