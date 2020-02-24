package com._520.动态规划;

/**
 *  机器人走方格，有障碍物
 */
public class Robot2 {

    public static int countWays(int[][] map, int x, int y) {

        int[][] dp = new int[x][y];

        for (int i = 0; i < dp.length; i++) {
            if (map[i][0] == 1){
                break;
            }
            dp[i][0] = 1;
        }

        for (int i = 0; i < dp[0].length; i++) {
            if (map[0][i] == 1){
                break;
            }
            dp[0][i] = 1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (map[i][j] == 1){
                    dp[i][j] = 0;
                }else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[x - 1][y - 1];
    }

    public static void main(String[] args) {

        int[][] map = new int[4][4];

        map[3][0] = 1;
        map[0][2] = 1;
        map[2][2] = 1;

        System.out.println(countWays(map, 4, 4));
    }
}