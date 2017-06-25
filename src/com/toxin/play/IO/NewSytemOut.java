package com.toxin.play.IO;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class NewSytemOut {
    public static void main(String[] args) {
        PrintStream consolePrint = System.out;

        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(byteArray);
        System.setOut(stream);

        printSomething();

        String result = byteArray.toString();
        System.setOut(consolePrint);

        StringBuilder sb = new StringBuilder();
        sb.append(result);
        sb.reverse();
        result = sb.toString();

        System.out.println(result);
    }

    private static void printSomething() {
        System.out.println("JAVA");
        System.out.println("THE");
        System.out.println("BEST");
    }
}
