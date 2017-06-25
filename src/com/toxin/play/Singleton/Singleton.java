package com.toxin.play.Singleton;

public class Singleton {

    private int secretNumber;
    private static Singleton instance;

    private Singleton() {}

    public int getSecretNumber() {
        return secretNumber;
    }

    public void setSecretNumber(int secretNumber) {
        this.secretNumber = secretNumber;
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
