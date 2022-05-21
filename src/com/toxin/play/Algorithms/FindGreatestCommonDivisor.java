package com.toxin.play.Algorithms;

public class FindGreatestCommonDivisor {

    //Euclid's algorithm
    public static void main(String[] args) {
        int x = (int) (Math.random() * 100);
        int y = (int) (Math.random() * 100);

        int res = gcd_2(24, 54);
        System.out.printf("GCD of %d-%d = %d%n", x, y, res);
    }

    public static int gcd_1(int x, int y) {
        if (y == 0 || x == 0) return x;

        if (x > y) {
            x = x % y;
        } else {
            y = y % x;
        }

        return gcd_1(x, y);
    }

    public static int gcd_2(int x, int y) {
        if (y == 0) return x;
        return gcd_2(y, x % y);
    }
}
