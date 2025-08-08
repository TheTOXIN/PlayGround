package com.toxin.play.MultiThreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LockExample {

    // Общий объект-монитор, на котором будут вызываться wait/notify
    private final Object lock = new Object();
    private final Queue<Integer> buffer = new LinkedList<>();
    private final int MAX_CAPACITY = 5;

    private void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            synchronized (lock) {
                // Если буфер полный, производитель должен ждать
                while (buffer.size() == MAX_CAPACITY) {
                    System.out.println("Буфер полон. Производитель ждет.");
                    lock.wait();
                }

                // Добавляем элемент в буфер
                buffer.add(value);
                System.out.println("Производитель добавил: " + value);
                value++;

                // Сообщаем потребителю, что в буфере появился новый элемент
                lock.notifyAll(); // можно использовать notify(), но notifyAll() безопаснее
            }
            // Имитируем задержку
            Thread.sleep(1000);
        }
    }

    private void consume() throws InterruptedException {
        while (true) {
            System.out.println(" STOP");
            synchronized (lock) {
                // Если буфер пустой, потребитель должен ждать
                while (buffer.isEmpty()) {
                    System.out.println("Буфер пуст. Потребитель ждет.");
                    lock.wait();
                }

                // Извлекаем элемент из буфера
                int value = buffer.poll();
                System.out.println("Потребитель забрал: " + value);

                // Сообщаем производителю, что в буфере освободилось место
                lock.notifyAll();
            }
            // Имитируем задержку
            Thread.sleep(2000);
        }
    }

    public static void main(String[] args) {
        LockExample pc = new LockExample();

        ExecutorService exec = Executors.newFixedThreadPool(2);

        exec.submit(() -> {
            try {
                pc.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        exec.submit(() -> {
            try {
                pc.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}