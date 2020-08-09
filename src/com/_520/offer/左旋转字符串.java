package com._520.offer;

import java.util.Arrays;

@SuppressWarnings("all")
public class 左旋转字符串 {

    public String LeftRotateString(String str,int n) {

        if (n > str.length()){
            return "";
        }

        return str.substring(n) + str.substring(0, n);
    }

    public static void main(String[] args) {
        左旋转字符串 z = new 左旋转字符串();

        String str = "abcdefg";

        System.out.println(z.LeftRotateString(str, 3));
    }
}
