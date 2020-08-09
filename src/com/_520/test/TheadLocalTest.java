package com._520.test;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.StampedLock;

public class TheadLocalTest {


    private static CountDownLatch lock = new CountDownLatch(2);

    private static CyclicBarrier lock1 = new CyclicBarrier(4);

    private static Semaphore lock2 = new Semaphore(2);

    private static StampedLock lock3 = new StampedLock();


    public void test1(){
        System.out.println("test1");
        lock.countDown();
    }

    public void test2(){

        try {
            lock.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("test2");
    }

    public void test3(){
        System.out.println("test3");
        lock.countDown();
    }


    public void semaphoreTest(){
        try {
            lock2.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 通过");
        System.out.println("当前还可以通过 " + lock2.availablePermits() + " 辆车");

//        lock2.release();
    }

    public void stanpedTest(){

    }

    public static void main(String[] args) throws Exception {
        TheadLocalTest theadLocalTest = new TheadLocalTest();
//        new Thread(theadLocalTest::test1).start();
//        new Thread(theadLocalTest::test2).start();
//        new Thread(theadLocalTest::test3).start();


        new Thread(new Party(), "张三").start();
        new Thread(new Party(), "李四").start();
        new Thread(new Party(), "王五").start();
        new Thread(new Party(), "赵六").start();

        Thread.sleep(4000);

        new Thread(new Party(), "张三").start();
        new Thread(new Party(), "李四").start();
        new Thread(new Party(), "王五").start();
        new Thread(new Party(), "赵六").start();

//        new Thread(theadLocalTest::semaphoreTest, "兰博基尼").start();
//        new Thread(theadLocalTest::semaphoreTest, "劳斯莱斯").start();
//        new Thread(theadLocalTest::semaphoreTest, "法拉利").start();

    }


    static class Party implements Runnable{

        @Override
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(" " + Thread.currentThread().getName() + " 到达");
            try {
                lock1.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }

            System.out.println("所有人都到达了，开始 party");
        }
    }
}

