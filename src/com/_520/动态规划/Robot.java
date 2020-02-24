package com._520.动态规划;

import java.util.Arrays;

public class Robot {

    public static int countWays(int x, int y) {

        if (x <= 0 || y <= 0){
            return 0;
        }

        if (x == 1 || y == 1){
            return 1;
        }

        return countWays(x - 1, y) + countWays(x, y - 1);
    }

    public static int countWays1(int x, int y) {

        int[] dp = new int[y];

        Arrays.fill(dp, 1);

        for (int i = 0; i < x - 1; i++) {
            for (int j = 1; j < y; j++) {
                dp[j] = dp[j - 1] + dp[j];
            }
        }


        return dp[y - 1];
    }

    public static void main(String[] args) {
        System.out.println(countWays(3, 4));
        System.out.println(countWays1(3, 4));
    }
}