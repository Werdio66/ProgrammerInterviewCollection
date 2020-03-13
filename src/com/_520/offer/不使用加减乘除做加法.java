package com._520.offer;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 13二进制为：1101，9二进制为：1001。
 *
 * 十进制是遇到大于等于10就保留余数，然后进位1。
 * 那对应到二进制，就是遇到2就保留余数0，然后进位1。（二进制位之和不可能大于2）
 *
 * 计算二进制1101+1001：
 * 1.计算不进位的和。从左到右，第1位为0，第2位为1，第3位为0，第4位为0，结果为0100；
 * 2.计算进位。从左到右，第1位进位1，第2、3位没有进位，第4位进位1，结果为1001。不对，进位右边要补0，正确结果是10010。
 *
 * 计算二进制0100+10010：
 * 1.计算不进位的和：10110；
 * 2.计算进位：无。
 *
 * 因此结果为10110=22
 */
@SuppressWarnings("all")
public class 不使用加减乘除做加法 {

    public int add(int a, int b) {

        while (b != 0){
            int sum = (a ^ b);
            b = ((a & b) << 1);
            a = sum;
        }

        return a;
    }

    public int add1(int a, int b) {

        AtomicInteger atomicInteger = new AtomicInteger(a);
        return atomicInteger.addAndGet(b);

    }

    public static void main(String[] args) {
        不使用加减乘除做加法 b = new 不使用加减乘除做加法();
        System.out.println(b.add(111, 899));
    }
}
