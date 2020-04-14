package com._520.test;

public class ByteTesy {

    public static void main(String[] args) {

        new ByteTesy().add();


    }

    public void add(){
        int i = 1;
        int b = i++;
        int c = ++i;
        System.out.println(this);
//        System.out.println(i);
    }
}
