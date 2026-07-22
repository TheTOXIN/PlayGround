package com.toxin.play.MultiThreading;

import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RobotStepTask {

    private static class Robot {

        private Lock lock = new ReentrantLock();
        private Condition[] conditions;

        private Leg[] allLegs;
        private Leg currentLeg = Leg.LEFT;

        public Robot() {
            allLegs = Leg.values();
            Arrays.sort(allLegs, Comparator.comparingInt(l -> l.number));

            conditions = new Condition[allLegs.length];
            for (int i = 0; i < allLegs.length; i++) {
                conditions[i] = lock.newCondition();
            }
        }

        public void step(Leg leg) throws InterruptedException {
            lock.lock();

            try {
                //защита от spurious wakeups
                while (currentLeg != leg) {
                    conditions[leg.number].await();
                }

                System.out.println("STEP: " + currentLeg.number);

                int nextLeg = (currentLeg.number + 1) % allLegs.length;
                currentLeg = allLegs[nextLeg];

                conditions[currentLeg.number].signal();
            } finally {
                //гарантировано освобождаем
                lock.unlock();
            }
        }
    }

    private static class Foot implements Runnable {

        private final Robot robot;
        private final Leg leg;

        public Foot(Robot robot, Leg leg) {
            this.robot = robot;
            this.leg = leg;
        }

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    robot.step(leg);
                } catch (InterruptedException ignored) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
    }

    public enum Leg {
        LEFT(0),
        MIDDLE(1),
        RIGHT(2);

        final int number;

        Leg(int number) {
            this.number = number;
        }
    }

    public static void main(String[] args) throws Exception {
        Robot robot = new Robot();

        try (ExecutorService executor = Executors.newFixedThreadPool(robot.allLegs.length)) {
            for (Leg leg : robot.allLegs) {
                executor.submit(new Foot(robot, leg));
            }

            Thread.sleep(10);
            executor.shutdownNow();
        }
    }
}
