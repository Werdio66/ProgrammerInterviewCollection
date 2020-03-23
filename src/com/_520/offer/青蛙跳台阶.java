package com._520.offer;

@SuppressWarnings("all")
public class 青蛙跳台阶 {

    // 递归，最后剩余一个台阶或者俩个台阶
    public int numWays(int n) {
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }

        return numWays(n - 1) + numWays(n - 2);
    }

    public int numWays1(int n) {
        int f1 = 1;
        int f2 = 2;
        int sum = 0;
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        for (int i = 2; i < n; i++) {
            sum = ((f1 % 1000000007) + (f2 % 1000000007)) % 1000000007;
            f1 = f2;
            f2 = sum;
        }

        return sum;
    }

    // 变态青蛙，一次可以跳任意台阶
    // f(n) = f(n - 1) + ... + f(1)
    // f(n -1) = f(n - 2) + ... + f(1)
    // f(n) - f(n - 1) = f(n - 1)
    // f(n) = 2 * f(n - 1)
    private int numWays2(int n){
        if (n == 1){
            return 1;
        }

        return 2 * numWays2(n - 1);
    }
    public static void main(String[] args) {
        青蛙跳台阶 q = new 青蛙跳台阶();
        System.out.println(q.numWays1(7));
    }
}
