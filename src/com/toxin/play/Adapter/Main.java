package com.toxin.play.Adapter;

public class Main {
    public static void main(String[] args) {
        AlphaList listAlpha = AlphaListManager.createList();
        BetaList listBeta = new ListAdapter(listAlpha);
        BetaSaveManager.saveList(listBeta);
    }
}
