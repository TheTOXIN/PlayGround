package com.toxin.play.MultiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class AtomicExample {

    public static void main(String[] args) throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger();

        ExecutorService executor = Executors.newFixedThreadPool(5);
        IntStream.range(0, 50).forEach(i -> executor.submit(atomicInteger::incrementAndGet));
        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.HOURS);
        executor.close();

        System.out.println(atomicInteger.get()); // выведет 50
    }
}
