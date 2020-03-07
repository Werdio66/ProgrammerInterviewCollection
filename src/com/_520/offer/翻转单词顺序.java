package com._520.offer;

@SuppressWarnings("all")
public class 翻转单词顺序 {

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] s1 = s.split(" ");
        for (int i = s1.length - 1; i >= 0; i--) {
            if (!"".equals(s1[i])){
                sb.append(s1[i]);
            }
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        翻转单词顺序 f = new 翻转单词顺序();
        String str = "hello word.";
        System.out.println(f.reverseWords(str));
    }
}
