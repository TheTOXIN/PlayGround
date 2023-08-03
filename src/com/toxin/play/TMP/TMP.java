package com.toxin.play.TMP;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TMP {

    public static void main(String[] args) throws Exception{
        final List<String> keysA = getKeys("res/a.txt");
        final List<String> keysB = getKeys("res/b.txt");

        final List<String> errors = searchErrors(keysA, keysB);

        if (errors.isEmpty()) {
            System.out.println("OK");
        } else {
            errors.forEach(System.out::println);
        }
    }

    private static List<String> getKeys(final String path) throws Exception {
        final List<String> text = Files.readAllLines(Path.of(path));

        return text.stream().map(s -> s.split("=")[0]).map(k -> k.trim()).collect(Collectors.toList());
    }

    private static List<String> searchErrors(final List<String> keysA, final List<String> keysB) {
        final List<String> result = new ArrayList<>();

        final List<String> errors1 = keysA.stream().filter(k -> !keysB.contains(k)).toList();
        final List<String> errors2 = keysB.stream().filter(k -> !keysA.contains(k)).toList();

        result.addAll(errors1);
        result.addAll(errors2);

        return result;
    }
}
