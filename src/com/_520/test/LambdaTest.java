package com._520.test;

/**
 * @author Werdio丶
 * @since 2020-08-19 15:34:05
 */
public class LambdaTest {

    private int age = 13;

    public static void main(String[] args) {

        LambdaTest l = new LambdaTest();

        final int hh = 456;
        String name = "sss";

        Sum sum = (() -> {
            System.out.println(l.age);
            l.age++;
            System.out.println(hh);

            return null;
        });

        sum.get();

        Sum sum1 = new Sum() {
            @Override
            public Object get() {
                System.out.println(hh);
                l.age++;
                System.out.println(l.age);
                return null;
            }
        };

        sum1.get();

    }
}


