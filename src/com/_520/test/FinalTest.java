package com._520.test;

/**
 * @author Werdio丶
 * @since 2020-08-12 17:21:44
 */
public final class FinalTest {

    public final int age = 3;

    public final String str = "ff";

    public final Object obj = new Object();

    public final void t1(){
        System.out.println("final");
    }


    public static void main(String[] args) {
        FinalTest f = new FinalTest();

        System.out.println();
    }


}
