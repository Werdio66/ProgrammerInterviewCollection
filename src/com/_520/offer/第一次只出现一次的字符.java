package com._520.offer;

/**
 * @author Werdio丶
 * @since 2020-08-08 07:14:45
 */
public class 第一次只出现一次的字符 {

    public int FirstNotRepeatingChar(String str) {

        int[] temp = new int[256];

        for (int i = 0; i < str.length(); i++) {
            temp[str.charAt(i)]++;
        }

        for (int i = 0; i < str.length(); i++) {
            if (1 == temp[str.charAt(i)]){
                return i;
            }
        }

        return -1;
    }
}
