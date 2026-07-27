package com.toxin.play.MultiThreading;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

    // 1. Создаем замок
    private static final ReentrantLock lock = new ReentrantLock();
    private static int count = 0;

    public static void increment() {
        // 2. Закрываем дверь на ключ
        lock.lock();

        try {
            // Критическая секция: сюда может зайти только 1 поток одновременно
            count++;
            System.out.println(Thread.currentThread().getName() + " увеличил count до: " + count);
        } finally {
            // 3. ОБЯЗАТЕЛЬНО открываем замок при выходе
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        // Запускаем два потока, которые параллельно меняют одну переменную
        Thread t1 = new Thread(ReentrantLockExample::increment, "Поток-1");
        Thread t2 = new Thread(ReentrantLockExample::increment, "Поток-2");

        t1.start();
        t2.start();
    }
}
