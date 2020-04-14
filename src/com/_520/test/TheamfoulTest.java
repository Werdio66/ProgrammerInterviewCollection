package com._520.test;

import java.util.concurrent.Semaphore;

public class TheamfoulTest {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(5);

        for (int i = 0; i < 8; i++) {
            new Thread(new Worker(i, semaphore)).start();
        }
    }

    static class Worker implements Runnable{

        public int num;

        public Semaphore semaphore;

        public Worker(int num, Semaphore semaphore){
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("工人 " + num + "拿到锁");
                Thread.sleep(2500);
                semaphore.release();
                System.out.println("工人 " + num + "释放锁");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
