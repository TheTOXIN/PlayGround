package com.toxin.play.MultiThreading;

import java.util.Objects;

public class AccountTransferTask {

    private static class Account {
        private int id;
        private long balance;

        private final Object lock = new Object();

        public Account(int id, long balance) {
            this.id = id;
            this.balance = balance;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Account account = (Account) o;
            return id == account.id;
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(id);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Account account1 = new Account(1, 100);
        Account account2 = new Account(2, 100);

        for (int i = 0; i < 100; i++) {
            Thread thread1 = new Thread(() -> transfer(account1, account2, 50));
            Thread thread2 = new Thread(() -> transfer(account2, account1, 50));

            thread1.start();
            thread2.start();

            thread1.join();
            thread2.join();
        }

        System.out.println("BALANCE 1 = " + account1.balance);
        System.out.println("BALANCE 2 = " + account2.balance);
    }

    private static void transfer(
            Account accountFrom,
            Account accountTo,
            int amount
    ) {
        var firstLock = accountFrom.lock.hashCode() <= accountTo.lock.hashCode()
                ? accountFrom : accountTo;

        var secondLock = accountFrom == firstLock
                ? accountTo : accountFrom;

        synchronized (firstLock.lock) {
            synchronized (secondLock.lock) {
                accountFrom.balance -= amount;
                accountTo.balance += amount;
            }
        }
    }
}
