package com._520.test;


import java.util.ArrayList;
import java.util.List;

public class Hello {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i = 0;
        String str = "";
        for (;;){
            str += (i++ + " ").intern();
            System.out.println(str);
//            list.add(str);
        }
    }
}
