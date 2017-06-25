package com.toxin.play.Date;

import java.util.Date;

public class TimeController {
    public Date now;

    public TimeController() {
        now = new Date();
    }

    public void printNowDate() {
        System.out.println("Today - " + now);
        System.out.println("Time - " + now.getTime());
    }

    public void testDistance() {
        Date cur = new Date();
        long dis = cur.getTime() - now.getTime();
        System.out.println("Distance - " + dis);
    }

    public void startTime(int sec) {
        for (int i = 0; i < sec; i++) {
            Date cur = new Date();
            cur.setSeconds(i+1);
            System.out.println(cur.getHours() + ":" + cur.getMinutes() + ":" + cur.getSeconds());
        }
    }
}
