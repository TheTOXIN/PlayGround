package com.toxin.play.MultiThreading;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        DeveloperJ developerJ = new DeveloperJ();
        DeveloperC developerC = new DeveloperC();

        Thread threadJ = new Thread(developerJ);
        Thread threadC = developerC;

        threadC.start();
        threadJ.start();

        Thread.sleep(100);

        threadC.interrupt();
        threadJ.interrupt();

        System.out.println("Java - " + developerJ.getCountCode());
        System.out.println("C++ - " + developerC.getCountCode());
        System.out.println("Coffee - " + (developerJ.getCountCode() + developerC.getCountCode()));
    }
}
