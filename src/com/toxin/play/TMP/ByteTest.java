package com.toxin.play.TMP;

public class ByteTest {

    public static void main(String[] args) {
        test("SECRET");
    }

    private static void test(String secret) {
        String superSecret = "SUPER " + secret;
        System.out.println(superSecret);
    }
}
