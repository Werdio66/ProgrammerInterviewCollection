package com._520.test;

/**
 * @author Werdio丶
 * @since 2020-08-01 18:21:38
 */
public class ClassInitOrder {

    static {
        System.out.println("静态代码块");
    }

    private static int a = 1;

    public static void main(String[] args) {

    }
}
