package com._520.test;

public class Hello {

    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    public static void main(String[] args) {

      new Thread(() ->{
          synchronized (lock1){
              System.out.println(Thread.currentThread().getName() + " 获取 lock1 ");

              try {
                  Thread.sleep(1000);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
              synchronized (lock2){
                  System.out.println(Thread.currentThread().getName() + " 获取 lock2 ");
              }
          }
      }, "t1").start();


        new Thread(() ->{
            synchronized (lock2){
                System.out.println(Thread.currentThread().getName() + " 获取 lock2 ");

                try {
                    Thread.sleep(900);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (lock1){
                    System.out.println(Thread.currentThread().getName() + " 获取 lock1 ");
                }
            }
        }, "t2").start();
    }
}
