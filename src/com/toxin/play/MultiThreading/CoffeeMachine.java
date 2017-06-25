package com.toxin.play.MultiThreading;

public class CoffeeMachine {
    public static CoffeeMachine machine = new CoffeeMachine();

    private volatile double count = 150;
    private volatile boolean isEnd = false;

    public synchronized boolean drinkCoffee() {
        if (count >= 0.5 && !isEnd) {
            count -= 0.5;
            return true;
        }
        else if (!isEnd) {
            System.out.println("Coffee is end");
            isEnd = true;
        }
        return false;
    }
}
