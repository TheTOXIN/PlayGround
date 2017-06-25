package com.toxin.play.Singleton;

public class Main {
    public static void main(String[] args) {
        Singleton instance_1 = Singleton.getInstance();
        instance_1.setSecretNumber(666);
        System.out.println(instance_1.getSecretNumber());
    }
}
