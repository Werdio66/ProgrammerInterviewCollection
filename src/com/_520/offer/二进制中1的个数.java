package com._520.offer;

/**
 *  输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
 *
 *  思路：
 *      1、将数字转换为二进制字符串，遍历
 *      2、将原数字和 1 进行 & 操作，如果是奇数说明二进制中有 1，否则没有
 */
@SuppressWarnings("all")
public class 二进制中1的个数 {

    public int NumberOf(int n) {

        int res = 0;

        while (n != 0){
            res += n & 1;
            // >>> 无符号右移
            n >>>= 1;
        }

        return res;
    }

    public int NumberOf1(int n) {
        String str = Integer.toBinaryString(n);
        int count = 0;
        for(int i = 0; i < str.length(); i++){
            if (str.charAt(i) == '1')
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        二进制中1的个数 e = new 二进制中1的个数();
        System.out.println(e.NumberOf(3));
    }
}
