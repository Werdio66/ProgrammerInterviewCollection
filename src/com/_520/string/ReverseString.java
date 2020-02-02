package com._520.string;

import java.util.Arrays;

/**
 *  原串反转
 *
 *  请实现一个算法，在不使用额外数据结构和储存空间的情况下，翻转一个给定的字符串(可以使用单个过程变量)。
 *
 * 给定一个string iniString，请返回一个string，为翻转后的字符串。保证字符串的长度小于等于5000。
 *
 */
public class ReverseString {

     public String reverseString(String iniString) {

         char[] chars = iniString.toCharArray();
         int left = 0;
         int right = chars.length - 1;
         while (left < right){
             swap(chars, left, right);
             left++;
             right--;
         }
         
         // 使用 StringBuilder 中的字符串反转函数
//         StringBuilder sb = new StringBuilder(iniString);
//         return sb.reverse().toString();

         return Arrays.toString(chars);
    }

    private void swap(char[] chars, int left, int right) {
        char temp = chars[left];
        chars[left] = chars[right];
        chars[right] = temp;
    }


    public static void main(String[] args) {
        String str = "hello word body!";
        System.out.println(new ReverseString().reverseString(str));
    }
}
