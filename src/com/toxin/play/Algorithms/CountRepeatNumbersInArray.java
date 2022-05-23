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

public class CountRepeatNumbersInArray {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(1, 1, 2, 2, 3, 3, 3, 5, 3));

        Map<Integer, Long> res = solution_1(list);
        res.forEach((key, value) -> System.out.println(key + " -> " + value));
    }

    public static Map<Integer, Long> solution_1(List<Integer> list) {
        Map<Integer, Long> res = new HashMap<>();

        for (Integer integer : list) {
            if (!res.containsKey(integer)) {
                res.put(integer, 1L);
            } else {
                res.put(integer, res.get(integer) + 1);
            }
        }

        return res;
    }

    public static Map<Integer, Long> solution_2(List<Integer> list) {
        Map<Integer, Long> res = new HashMap<>();

        for (Integer integer : list) {
            res.merge(integer, 1L, Long::sum);
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