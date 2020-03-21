package com._520.offer;

@SuppressWarnings("all")
public class 斐波那契数列 {

    // 递归，可以优化，将计算过的值存储起来
    public int fib(int n) {

        if (n == 0){
            return 0;
        }

        if (n == 1){
            return 1;
        }

        return fib(n - 1) + fib(n - 2);
    }

    // 动态规划，(a + b) % n = ((a % n) + (b % n)) % n
    public int fib1(int n){
        if (n == 0){
            return 0;
        }

        if (n == 1){
            return 1;
        }

        int f1 = 0;
        int f2 = 1;
        int sum = 0;

        for (int i = 1; i < n; i++) {
            sum = ((f1 % 1000000007) + (f2 % 1000000007)) % 1000000007;
            f1 = f2;
            f2 = sum;
        }

        return sum;
    }
    public static void main(String[] args) {
        斐波那契数列 f = new 斐波那契数列();
        // 45   134903163       48      807526948
        System.out.println(f.fib1(48));
    }
}
