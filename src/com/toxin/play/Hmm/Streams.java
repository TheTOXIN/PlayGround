package com.toxin.play.Hmm;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Streams {

    public static void main(String[] args) {
        test_3();
    }

    private static void test_2() {
        final List<String> list = List.of("dog", "cat", "hamster");

        list.stream()
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.length() <= 3;
                })
                .map(s1 -> {
                    System.out.println("map: " + s1);
                    return s1.toUpperCase();
                })
                .sorted() // <--
                .forEach(x -> {
                    System.out.println("forEach: " + x);
                });
    }

    private static void test_3() {
        List.of(1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5)
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .forEach(System.out::println);
    }

    private static void test_1() {
        CompletableFuture.runAsync(() -> {
            System.out.println("Test " + 0);
        });

        IntStream.range(1, 11)
                .mapToObj(i -> CompletableFuture.runAsync(() -> {
                    System.out.println("Test " + i);
                }))
                .forEach(cf -> {
                    System.out.println("ForEach");
//                    cf.join();
                });
    }
}
