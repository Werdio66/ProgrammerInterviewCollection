package com._520.offer;

@SuppressWarnings("all")
public class 二进制中1的个数 {

    public int hammingWeight(int n) {

        int res = 0;

        while (n != 0){
            res += n & 1;
            n >>>= 1;
        }

        return res;
    }

    public static void main(String[] args) {
        二进制中1的个数 e = new 二进制中1的个数();
        System.out.println(e.hammingWeight(3));
    }
}
