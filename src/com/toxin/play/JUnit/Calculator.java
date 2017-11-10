package com.toxin.play.JUnit;

public class Calculator {

    private int res;

    public void add(int... psrams) {
        for (int param : psrams) {
            res += param;
        }
    }

    public void dev(int a, int b) {
        if (b != 0) {
            res = a / b;
        } else {
            throw new ArithmeticException();
        }
    }

    public int getResult() {
        return this.res;
    }

    public void cleanResult() {
        this.res = 0;
    }
}
