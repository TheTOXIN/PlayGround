package com.toxin.play.MultiThreading;

public class DeveloperJ implements Runnable{
    private int countCode = 0;

    public int getCountCode() {
        return countCode;
    }

    @Override
    public void run() {
        int i = 0;
        while (!Thread.currentThread().isInterrupted()) {
            if (CoffeeMachine.machine.drinkCoffee()) {
                System.out.println(i + " System.out.print(\"Hello word!!!\")");
                i++;
                countCode++;
                Thread.yield();
            }
        }
    }
}
