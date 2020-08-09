package com._520.test;

public class TheadTest {

    private static final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    static String str = "msg";

    public static void print(){
        threadLocal.set(str);

        System.out.println(threadLocal.get());
        str += "lllll";
    }
    public static void main(String[] args) {

//        print();

        new Thread(TheadTest::print, "我是线程 1").start();
//        new Thread(TheadTest::print).start();

        threadLocal.set(str);

        threadLocal.set(str);


        System.out.println(threadLocal.get());
    }

}
