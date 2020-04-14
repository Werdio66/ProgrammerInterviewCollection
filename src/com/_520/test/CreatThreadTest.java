package com._520.test;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class CreatThreadTest {

    static class RunaleTest implements Runnable{

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("run.................");
        }
    }


    static class CallableTest implements Callable<String>{

        @Override
        public String call() throws Exception {
            System.out.println("call.................");
            return "ok";
        }
    }

    public static void main(String[] args) {
        new Thread(new RunaleTest()).start();

        new CallableTest();
    }
}
