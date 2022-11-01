package com.toxin.play.TMP;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TMP {

    public static void main(String[] args) {
        Map<String, Integer> result = IntStream.range(0, 6)
                .map(i -> i + 1)
                .mapToObj(Objects::toString)
                .collect(Collectors.toMap(Function.identity(), val -> 0));
        System.out.println(result);
    }
}
