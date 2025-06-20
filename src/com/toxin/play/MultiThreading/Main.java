package com.toxin.play.MultiThreading;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;

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

        LinkedList<Object> objects = new LinkedList<>();

        objects.add(developerJ);
        objects.offer(developerC);
        objects.push(developerC);

        objects.pop();
        objects.poll();
        objects.peek();
    }
}
