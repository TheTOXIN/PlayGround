package com.toxin.play.Algorithms;


import java.util.Scanner;

//1,1,2,3,5,8,13...
public class ComputeFibonacci {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int index = Integer.parseInt(scanner.next());

        int res = fibonacci(index);

        System.out.println();
        System.out.println(res);
    }

    private static int fibonacci(int index) {
        return computeFibonacci(0, 1, index, 0);
    }

    private static int computeFibonacci(int x, int y, int i, int n) {
        if (n == i) return x;
        n++;
        System.out.print(x + " ");
        return computeFibonacci(y, x + y, i, n);
    }
}
