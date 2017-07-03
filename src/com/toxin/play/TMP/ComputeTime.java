package com.toxin.play.TMP;

public class ComputeTime {
    public static void main(String[] args) {
        Long before = System.currentTimeMillis();
        go();
        Long after = System.currentTimeMillis();
        System.out.println("БАБЛЫ: " + (after - before) + " mill_sec");
    }

    public static void go() {
        int array[] = new int[1000];
        for (int i = 0; i < array.length; i++) {
            array[i] = array.length - i;
        }
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] < array[j]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }
}
