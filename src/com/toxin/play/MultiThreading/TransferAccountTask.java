package com.toxin.play.MultiThreading;

public class TransferAccountTask {

    public static void main(String[] args) {

    }

    private static class Foo {



        void transfer(Account accountSender, Account accountReceiver, float amount) {
            synchronized (accountSender) {
                //some
                //some
                //some
                synchronized (accountReceiver) {
                    accountSender.withdraw(amount);
                    accountReceiver.deposit(amount);
                }
            }
        }

        class Account {
            int id;

            public void withdraw(float amount) {
                //...
            }

            public void deposit(float amount) {
                //...
            }
        }
    }
}
