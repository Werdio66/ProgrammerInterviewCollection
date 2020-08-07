package com._520.offer;

/**
 *  整数中 1 的个数
 *
 *  思路：
 *      1、将每一个数转换成字符串，然后判断每一个字符是不是 1
 *      2、直接对每一个数进行切分，分为个位十位等，判断最低为是不是 1，时间复杂度是 O(k * n)，k 是
 *         给定数的位数，例如 225 就是 3，所以这个还是比较快的
 *
 *  225
 *
 * @author Werdio丶
 * @since 2020-08-07 14:13:05
 */
public class 整数中1出现的次数 {

    public static int NumberOf1Between1AndN_Solution(int n) {

        int count  = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = i; j > 0; j /= 10) {
                if (j % 10 == 1){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(NumberOf1Between1AndN_Solution(10));
    }
}
