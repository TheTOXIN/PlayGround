package com.toxin.play.MultiThreading;

import java.util.concurrent.Semaphore;

class PhilosopherTask extends Thread {

    private final Semaphore sem;

    // поел ли философ
    private boolean full = false;

    private final String name;

    PhilosopherTask(Semaphore sem, String name) {
        this.sem = sem;
        this.name = name;
    }

    public void run() {
        try {
            // если философ еще не ел
            if (!full) {
                System.out.println(name + " пришел кушац");

                //Запрашиваем у семафора разрешение на выполнение
                sem.acquire();
                System.out.println(name + " садится за стол");

                // философ ест
                sleep(300);
                full = true;

                System.out.println(name + " поел! Он выходит из-за стола");
                sem.release();

                // философ ушел, освободив место другим
                sleep(300);
                System.out.println(name + " ушел");
            }
        } catch (InterruptedException e) {
            System.out.println("Что-то пошло не так!");
        }
    }

    public static void main(String[] args) {
        Semaphore sem = new Semaphore(2, true);

        new PhilosopherTask(sem, "Сократ").start();
        new PhilosopherTask(sem, "Платон").start();
        new PhilosopherTask(sem, "Аристотель").start();
        new PhilosopherTask(sem, "Фалес").start();
        new PhilosopherTask(sem, "Пифагор").start();
    }
}