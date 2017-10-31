package com.toxin.play.RegEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExTest {
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("RegEx = ");
            Pattern pattern = Pattern.compile(reader.readLine());

            System.out.println("Str = ");
            Matcher matcher = pattern.matcher(reader.readLine());

            boolean found = false;
            while (matcher.find()) {
                System.out.printf("Found - " + "\"%s\" start - %d end - %d%n",
                        matcher.group(),
                        matcher.start(),
                        matcher.end());
                found = true;
            }

            if (!found)
                System.out.printf("NOT found %n");
        }
    }
}
