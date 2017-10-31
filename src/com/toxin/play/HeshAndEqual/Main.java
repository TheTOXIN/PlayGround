package com.toxin.play.HeshAndEqual;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        HashSet<Fraction> set = new HashSet<Fraction>();
        set.add(new Fraction(2,  3));
        if (set.contains(new Fraction(4, 6)))
            System.out.println("EEEE BOOYYYYYYYS");
    }
}
