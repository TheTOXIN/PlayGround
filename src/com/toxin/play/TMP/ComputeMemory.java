package com.toxin.play.TMP;

public class ComputeMemory {
    public static void main(String[] args) {
        long before = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (1024 * 1024);
        System.out.println("Before: " + before + " mb");
        System.out.println("Total: " + Runtime.getRuntime().totalMemory());
        System.out.println("Free: " + Runtime.getRuntime().freeMemory());

        go();

        long after = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (1024 * 1024);
        System.out.println("After: " + after + " mb");
        System.out.println("Total: " + Runtime.getRuntime().totalMemory());
        System.out.println("Free: " + Runtime.getRuntime().freeMemory());
    }

    public static void go() {
        int array[] = new int[100000];
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
