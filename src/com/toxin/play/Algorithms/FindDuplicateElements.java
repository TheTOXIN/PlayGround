package com.toxin.play.Algorithms;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FindDuplicateElements {

    public static void main(String[] args) {
        int[] array = IntStream.generate(() -> (int) (Math.random() * 10))
                .limit(10)
                .peek(i -> System.out.print(i + "\s"))
                .toArray();
        System.out.println();

        int result1 = duplicate(array);
        System.out.println("Result 1: " + result1);

        int result2 = duplicateUsingHashSet(array);
        System.out.println("Result 2: " + result2);

        int result3 = duplicateUsingHashtable(array);
        System.out.println("Result 3: " + result3);
    }

    public static int duplicate(int[] numbersWithDuplicates) {
        for (int i = 0; i < numbersWithDuplicates.length; i++) {
            for (int j = i + 1; j < numbersWithDuplicates.length; j++) {
                if (numbersWithDuplicates[i] == numbersWithDuplicates[j]) {
                    return numbersWithDuplicates[i];
                }
            }
        }
        throw new RuntimeException("No Duplicate Found");
    }

    public static int duplicateUsingHashSet(int[] givenArray) {
        Set<Integer> temporarySet = new HashSet<>();
        for (int number : givenArray) {
            if (!temporarySet.add(number)) {
                return number;
            }
        }
        throw new RuntimeException("No Duplicate Found");
    }

    public static int duplicateUsingHashtable(int[] givenArray) {
        Map<Integer, Integer> numberWithCount = new Hashtable<>();
        for (int number : givenArray) {
            Integer count = numberWithCount.get(number);
            if (count == null) {
                numberWithCount.put(number, 1);
            } else {
                return number;
            }
        }
        throw new RuntimeException("No Duplicate Found");
    }
}
