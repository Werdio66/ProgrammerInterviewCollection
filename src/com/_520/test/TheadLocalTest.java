package com._520.test;

public class TheadLocalTest {

    private static void show(Thread thread){
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set(thread.getName());
        threadLocal.set("thread.getName()");
        System.out.println(threadLocal.get());
    }
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            TheadLocalTest.show(new Thread());
        }

    }
}
