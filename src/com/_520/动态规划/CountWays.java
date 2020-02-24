package com._520.动态规划;

/**
 *  爬楼梯
 *  每次走一步，俩步，或者三步
 */
public class CountWays {

    /**
     *  递归：自顶向下，最后一步走楼梯，共有三种情况
     *  n - 1 ， n - 2， n - 3
     */
    public static int countWays(int n) {
        // write code here
        if (n <= 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        if (n == 3){
            return 4;
        }

        return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
    }

    /**
     *  动态规划
     */
    private static int countSize(int n){

        int f1 = 1;
        int f2 = 2;
        int f3 = 4;

        if (n == 1){
            return f1;
        }
        if (n == 2){
            return f2;
        }
        if (n == 3){
            return f3;
        }

        for (int i = 4; i <= n; i++) {
            int sum = 0;
            sum += ((f1 + f2) % 1000000007 + f3) % 1000000007;
            f1 = f2;
            f2 = f3;
            f3 = sum;
        }

        return f3;
    }

    public static void main(String[] args) {
        System.out.println(countWays(5));
        System.out.println(countSize(5));
    }
}
