package com._520.test;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@SuppressWarnings("ALL")
public class TheadTest {

    private ReentrantLock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();

    private void get(){
        lock.lock();
        try {
            condition1.await();
            System.out.println(Thread.currentThread().getName());
//            condition2.signal();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            lock.unlock();
        }
    }

    private void get1(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName());
            condition1.signal();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {

        new Thread(() -> new TheadTest().get(), "t1").start();
        new Thread(() -> new TheadTest().get1(), "t2").start();
    }

}
