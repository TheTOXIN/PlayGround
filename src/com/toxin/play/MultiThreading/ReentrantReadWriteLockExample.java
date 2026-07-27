package com.toxin.play.MultiThreading;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockExample {
    // 1. Создаем двойной замок
    private static final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    private static String data = "Исходная информация";

    // Чтение (могут выполнять несколько потоков ОДНОВРЕМЕННО)
    public static void readData() {
        rwLock.readLock().lock(); // Захватываем замок на ЧТЕНИЕ
        try {
            System.out.println(Thread.currentThread().getName() + " читает: " + data);
        } finally {
            rwLock.readLock().unlock(); // Освобождаем
        }
    }

    // Запись (выполняет только ОДИН поток, остальные ждут)
    public static void writeData(String newData) {
        rwLock.writeLock().lock(); // Захватываем замок на ЗАПИСЬ
        try {
            System.out.println(Thread.currentThread().getName() + " пишет новое значение...");
            data = newData;
        } finally {
            rwLock.writeLock().unlock(); // Освобождаем
        }
    }

    public static void main(String[] args) {
        // Запускаем 3 потока на чтение и 1 на запись
        Thread reader1 = new Thread(ReentrantReadWriteLockExample::readData, "Читатель-1");
        Thread writer = new Thread(() -> writeData("Новые данные!"), "Писатель");
        Thread reader2 = new Thread(ReentrantReadWriteLockExample::readData, "Читатель-2");

        reader1.start();
        writer.start();
        reader2.start();
    }
}
