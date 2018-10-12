package com.toxin.play.ByteCode;

public class Main {
    public static void main(String[] args) {
        int n = 0;
        //for (int i = 0; i < 3; i++) {
            n = ++n + n++;
        //}
        System.out.println(n);
    }
}
