package com._520.offer;

@SuppressWarnings("all")
public class 左旋转字符串 {

    public String reverseLeftWords(String s, int n) {

        String end = s.substring(n);
        String begin = s.substring(0, n);

//        return new StringBuilder(s.substring(n)).append(s.substring(0, n)).toString();
        return end + begin;
    }

    public static void main(String[] args) {
        左旋转字符串 z = new 左旋转字符串();
        String str = "abcdefg";
        System.out.println(z.reverseLeftWords(str, 2));
    }
}
