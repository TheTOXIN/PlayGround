package com.toxin.play.MultiThreading;

import java.util.LinkedList;

public class TwoDeveloperTask {
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

    public static class DeveloperC extends Thread {
        private int countCode = 0;

        public int getCountCode() {
            return countCode;
        }

        @Override
        public void run() {
            int i = 0;
            while (!Thread.currentThread().isInterrupted()) {
                if (CoffeeMachineTask.machine.drinkCoffee()) {
                    System.out.println(i + " cout << \"Hello word!!!\"");
                    i++;
                    countCode++;
                    Thread.yield();
                }
            }
        }
    }

    public static class DeveloperJ implements Runnable {
        private int countCode = 0;

        public int getCountCode() {
            return countCode;
        }

        @Override
        public void run() {
            int i = 0;
            while (!Thread.currentThread().isInterrupted()) {
                if (CoffeeMachineTask.machine.drinkCoffee()) {
                    System.out.println(i + " System.out.print(\"Hello word!!!\")");
                    i++;
                    countCode++;
                    Thread.yield();
                }
            }
        }
    }
}
