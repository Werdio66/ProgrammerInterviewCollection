package com._520.string;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *  确定俩个字符串乱序重构
 *
 *  给定两个字符串，请编写程序，确定其中一个字符串的字符重新排列后，
 *  能否变成另一个字符串。这里规定大小写为不同字符，且考虑字符串中的空格。
 */
public class CheckSam {

    // 将 a 串中的字符存放到 list 中，判断 b 串中是否拥有，有就删除 list 中的字符
    public boolean checkSam(String stringA, String stringB) {

        if (stringA.length() != stringB.length()){
            return false;
        }

        List<Character> list = new LinkedList<>();

        for (int i = 0; i < stringA.length(); i++) {
            list.add(stringA.charAt(i));
        }

        for (int i = 0; i < stringB.length(); i++) {
            if (list.contains(stringB.charAt(i))){
                list.remove(Character.valueOf(stringB.charAt(i)));
            }else {
                return false;
            }
        }
        return true;
    }

    // 判断字符出现的次数是否相等
    public boolean checkSam1(String stringA, String stringB) {

        if (stringA.length() != stringB.length()){
            return false;
        }

        int[] dateA = new int[256];
        int[] dateB = new int[256];

        for (int i = 0; i < stringA.length(); i++) {
            dateA[stringA.charAt(i)]++;
            dateB[stringB.charAt(i)]++;
        }

        return Arrays.equals(dateA, dateB);
    }
    public static void main(String[] args) {
        String str1 = "hello word";
        String str2 = "word holle";
        System.out.println(new CheckSam().checkSam(str1, str2));
        System.out.println(new CheckSam().checkSam1(str1, str2));
    }

}
