package com.toxin.play.Algorithms;

// Посчитать кол-во вхождений повторяющегося элемента в массив и вывести их
// (неповторяющиеся элементы не выводим)[1,1,2,2,3,3,3,5]
//        Пример:
//        1->2
//        2->2
//        3->3
//        5->не выводим
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountRepeateNumbersInArray {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(1, 1, 2, 2, 3, 3, 3, 5, 3));

        Map<Integer, Long> res = solution_4(list);
        res.forEach((key, value) -> System.out.println(key + " -> " + value));
    }

    public static Map<Integer, Long> solution_1(List<Integer> list) {
        Map<Integer, Long> res = new HashMap<>();

        for (int i = 1; i < list.size(); i++) {
            if (!res.containsKey(list.get(i))) {
                res.put(list.get(i), 1L);
            } else {
                res.put(list.get(i), res.get(list.get(i)) + 1);
            }
        }

        return res;
    }

    public static Map<Integer, Long> solution_2(List<Integer> list) {
        Map<Integer, Long> res = new HashMap<>();

        for (int i = 1; i < list.size(); i++) {
            res.merge(list.get(i), 1L, Long::sum);
        }

        return res;
    }

    public static Map<Integer, Long> solution_3(List<Integer> list) {
        return list.stream().collect(Collectors.toMap(
                Function.identity(),
                k -> 1L,
                Long::sum
        ));
    }

    public static Map<Integer, Long> solution_4(List<Integer> list) {
        return list.stream().collect(Collectors.groupingBy(
                Function.identity(),
                Collectors.counting()
        ));
    }
}