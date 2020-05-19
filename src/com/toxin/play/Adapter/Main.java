package com.toxin.play.Adapter;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        AlphaList listAlpha = AlphaListManager.createList();
//        BetaList listBeta = new ListAdapter(listAlpha);
//        BetaSaveManager.saveList(listBeta);

        List<Object> objects = Arrays.asList(null, new Object());
        for (Object o : objects) {
            System.out.println((Integer) o);
        }
    }
}
