package com.company;

import java.util.concurrent.Semaphore;

public class Main {
    static public Semaphore semaphore;

    public static Integer mainResource = 1;

    public static void main(String[] args) {
        semaphore = new Semaphore(1);
        Thread consumer = new Thread(new Consumer());
        Thread producer = new Thread(new Producer());

        producer.start();
        consumer.start();


    }
}

class Consumer implements Runnable {
    @Override
    public void run() {
        try {
            Main.semaphore.acquire();
                while (Main.mainResource > 0) {
                    Thread.sleep(200);
                    --Main.mainResource;
                    System.out.printf("Consumer : resources count : %d\n", Main.mainResource);
                }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Main.semaphore.release();

    }
}


class Producer implements Runnable {

    @Override
    public void run() {
        try {
            Main.semaphore.acquire();
            while (Main.mainResource < 20) {
                Thread.sleep(100);
                ++Main.mainResource;
                System.out.printf("Producer : resources count : %d\n", Main.mainResource);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Main.semaphore.release();
        System.out.println("Method release() has not invoked");
    }
}