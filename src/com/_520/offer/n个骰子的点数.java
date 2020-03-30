package com._520.offer;

import java.util.Arrays;

@SuppressWarnings("all")
public class n个骰子的点数 {

    // 2 - 12
    public double[] twoSum(int n) {
        // 存储每个点数出现的次数
        double[] dp = new double[6 * n + 1];
        double all = Math.pow(6, n);
        // 初始化，当有一个骰子的情况
        for (int i = 0; i < 6; i++) {
            dp[i] = 1;
        }
        if (n == 1){
            double[] ans = new double[6];
            for (int i = 0; i < 6; i++) {
                ans[i] = 1.0 / 6.0;
            }
            return ans;
        }

        double[] res = new double[5 * n + 1];

        for (int i = 2; i <= n; i++) {
            // 计算次数，从后往前，只需要一次遍历
            for (int j = 6 * n; j >= 1; j--) {
                int temp = 0;
                // 每一个出现的次数是前六个的和
                for (int k = 0; k < 6; k++) {
                    if (j - k >= i - 1){
                        temp += dp[j - k - 1];
                    }
                }
                dp[j] = temp;
            }

        }

        System.out.println(Arrays.toString(dp));
        for (int i = n - 1; i <= res.length; i++) {
            res[i - n + 1] = dp[i] / all;
        }
        return res;
    }

    public static void main(String[] args) {
        n个骰子的点数 n = new n个骰子的点数();
// 0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778
        double[] doubles = n.twoSum(3);
        for (double aDouble : doubles) {
            //
            System.out.printf("%.5f\t", aDouble);
        }

    }
}
