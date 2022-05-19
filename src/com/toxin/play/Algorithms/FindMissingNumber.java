package com.toxin.play.Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.IntStream.rangeClosed;

public class FindMissingNumber {

    public static void main(String[] args) {
        int n = 10;

        List<Integer> list = new ArrayList<>(rangeClosed(0, n).boxed().toList());
        list.remove(3);

        int[] array = list.stream().mapToInt(Integer::intValue).toArray();
        int result = missingNumberFromSortedArray(array);

        System.out.println(Arrays.toString(array));
        System.out.println("Missing number = " + result);;
    }

    public static int missingNumberFromSortedArray(int[] arrays) {
        int left = 0;
        int right = arrays.length - 1;

        while (left <= right) {
            int mid = (right + left) >> 1;

            if (arrays[mid] != mid) {
                if (mid == 0 || arrays[mid - 1] == mid - 1) return mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}
