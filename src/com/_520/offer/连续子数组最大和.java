package com._520.offer;

/**
 * @author Werdio丶
 * @since 2020-08-07 13:52:03
 */
public class 连续子数组最大和 {

    public static int FindGreatestSumOfSubArray(int[] array) {

        int[] dp = new int[array.length];

        dp[0] = array[0];
        int max = dp[0];

        for (int i = 1; i < array.length; i++) {
            int sum = dp[i - 1] + array[i];
            dp[i] = Math.max(sum, array[i]);

            max = Math.max(dp[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1,-2,3,10,-4,7,2,-5};

        System.out.println(FindGreatestSumOfSubArray(arr));
    }
}
