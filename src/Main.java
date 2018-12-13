package com.company;

public class Main {
    static public final String lockObject1 = "LockObject 1";
    static public final String lockObject2 = "LockObject 2";

    public static Integer mainResource = 1;

    public static void main(String[] args) {

        Thread consumer = new Thread(new Consumer());
        Thread producer = new Thread(new Producer());

        producer.start();
        consumer.start();

    }
}

class Consumer implements Runnable {


    @Override
    public void run() {
        synchronized (Main.lockObject1) {
            try {
                synchronized (Main.mainResource) {
                    while (Main.mainResource > 0) {
                        Thread.sleep(200);
                        --Main.mainResource;
                        System.out.printf("Consumer : resources count : %d\n", Main.mainResource);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (Main.lockObject2) {
                System.out.println(Main.lockObject2);
            }
        }
    }
}

class Producer implements Runnable {

    @Override
    public void run() {
        synchronized (Main.lockObject2) {
            try {
                synchronized (Main.mainResource) {
                    while (Main.mainResource < 20) {
                        Thread.sleep(100);
                        ++Main.mainResource;
                        System.out.printf("Producer : resources count : %d\n", Main.mainResource);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (Main.lockObject1) {
                System.out.println(Main.lockObject1);
            }
        }
    }
}