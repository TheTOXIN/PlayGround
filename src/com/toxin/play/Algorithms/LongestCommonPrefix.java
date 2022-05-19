package com.toxin.play.Algorithms;

import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList(
                "FastAndFurious",
                "FastAndFuriousAgain",
                "FastAndVeryFurious",
                "FastButNotFurious",
                "FasterAndFurious",
                "FastestAndReckless"
        );
        //Collections.shuffle(strings);

        String[] array = strings.toArray(String[]::new);
        LongestCommonPrefix lcp = new LongestCommonPrefix();

        System.out.println(lcp.findLongestCommonPrefix1(array));
        System.out.println(lcp.findLongestCommonPrefix2(array));
    }

    public String findLongestCommonPrefix1(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

    public String findLongestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }
}
