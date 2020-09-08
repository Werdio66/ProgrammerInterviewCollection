package com._520.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Werdio丶
 * @since 2020-08-30 20:33:07
 */
public class 字符串的排列 {

    static ArrayList<String> list = new ArrayList<>();
    static int count = 0;
    public static ArrayList<String> permutation(String str) {

        dfs(0, str.toCharArray());

        return list;
    }

    // 递归
    private static void dfs(int index, char[] chars) {
        count++;

        // 递归结束条件
        if (index + 1 == chars.length) {
            String s = new String(chars);
            if (!list.contains(s)) {
                list.add(s);
            }
            return;
        }

        // 固定一个交换其他的即可
        for (int i = index; i < chars.length; i++) {

            swap(chars, i, index);
            dfs(index + 1, chars);
            // 回溯
            swap(chars, i, index);
        }

    }

    private static void swap(char[] chars, int left, int right){
        char temp = chars[left];
        chars[left] = chars[right];
        chars[right] = temp;
    }



    public static void main(String[] args) {
        System.out.println(permutation("abc"));
        System.out.println(count);
    }
}
