package com.toxin.play.Async;

import java.util.concurrent.*;

public class FutureTest {

    public static void main(String[] args) throws Exception {
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

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(
            () -> "я из будущего", executor
        );

        completableFuture.thenAcceptAsync(System.out::println);
        completableFuture.get();
    }
}
