package com.toxin.play.MultiThreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RobotStepTask {

    private static class Robot {

        private Lock lock = new ReentrantLock();
        private Condition condition = lock.newCondition();

        private Leg currentLeg = Leg.LEFT;

        public void step(Leg leg) throws InterruptedException {
            lock.lock();

            try {
                // Защита от spurious wakeups
                while (currentLeg != leg) condition.await();

                System.out.println("STEP: " + currentLeg.ordinal());

                currentLeg = currentLeg.getNext();
                condition.signal();
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
        LEFT, RIGHT;

        public Leg getNext() {
            return this == LEFT ? RIGHT : LEFT;
        }
    }

    public static void main(String[] args) throws Exception {
        Robot robot = new Robot();

        Thread thread1 = new Thread(new Foot(robot, Leg.LEFT), "LegLeftThread");
        Thread thread2 = new Thread(new Foot(robot, Leg.RIGHT), "LegRightThread");

        thread1.start();
        thread2.start();

        Thread.sleep(10);

        thread1.interrupt();
        thread2.interrupt();

        //дожидаемя завершения
        thread1.join();
        thread2.join();
    }
}
