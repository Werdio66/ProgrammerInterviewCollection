package com._520.test;

public class ReflectTest {

    public static void main(String[] args) throws Exception {

        Class<?> user = Class.forName("com._520.test.User");
        System.out.println(user);

//        Object o = user.newInstance();
//        System.out.println(o);

        Object o1 = user.getDeclaredConstructor().newInstance();
        System.out.println(o1);
    }
}
