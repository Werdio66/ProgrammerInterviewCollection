package com._520.offer;

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
