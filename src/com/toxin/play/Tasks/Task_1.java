package com.toxin.play.Tasks;

import java.util.Arrays;

public class Task_1 {

    /**
     * нужно реализовать функцию increment, которая увеличивает каждый элемент массива на 1.
     */
    public static void main(String[] args) {
        int[] source = {9, 9, 9};

        int[] result = new int[source.length];
        System.arraycopy(source, 0, result, 0, source.length);

        int carry = 1;

        for (int i = result.length - 1; i >= 0; i--) {
            int sum = result[i] + carry;
            result[i] = sum % 10;
            carry = sum / 10;
        }

        if (carry > 0) {
            int[] newSource = new int[result.length + 1];
            newSource[0] = carry;
            System.arraycopy(result, 0, newSource, 1, result.length);
            result = newSource;
        }

        System.out.println(Arrays.toString(result));
    }
}
