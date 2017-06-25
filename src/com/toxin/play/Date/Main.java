package com.toxin.play.Date;

public class Main {
    public static void main(String[] args) {
        TimeController timer = new TimeController();
        timer.printNowDate();
        timer.startTime(100);
        timer.testDistance();
    }
}
