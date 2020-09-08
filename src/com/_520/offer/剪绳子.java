package com._520.offer;

/**
 * @author Werdio丶
 * @since 2020-09-08 14:34:38
 */
public class 剪绳子 {

    int count = 0;
    int[] arr;


    public int cutRope(int target) {

        if (target == 2){
            return 1;
        }

        if (target == 3){
            return 2;
        }

        arr = new int[target + 1];

        return back_track1(target);
    }

    /**
     *  递归三部曲
     *      1、递归函数的作用       : 计算分解后的最大乘积
     *      2、递归结束条件        : 因为如果当前长度小于等于 4，分解后的乘积小于本身，所以直接返回
     *      3、状态转移方程        ： 如果当前切割 1 份，那么下一次递归就是 back_track(n - 1)
     *                              乘积就是 1 * back_track(n - 1)
     *
     * @param n
     * @return
     */
    private int back_track(int n) {
        count++;
        if (n <= 4){
            return n;
        }
        //记录最值
        int ret = 0;
        // for 循环含义：当前切割的数量
        for (int i = 1; i < n; i++) {
            ret = Math.max(ret, i * back_track(n - i));
        }

        return ret;
    }
    private int back_track1(int n) {
        count++;
        if (n <= 4){
            return n;      
        }

        if (arr[n] != 0){
            return arr[n];
        }

        int ret = 0;

        for (int i = 1; i < n; i++) {

            int j = back_track1(n - i);
            ret = Math.max(ret, i * j);
            arr[n - i] = j;

        }

        return ret;
    }


    /**
     *  动态规划
     *      1、状态转移方程             ： f * f(n - i)
     *      2、初始值                  ： 2 的时候是 1,3 的时候是 2，4 的时候是 4
     *      3、定义 dp 数组，含义       ： 当前长度下的最大乘积值，i 代表当前绳子长度
     *
     * @param target
     * @return
     */
    public int cutRope1(int target) {
        if (target == 2){
            return 1;
        }

        if (target == 3){
            return 2;
        }

        int[] dp = new int[target + 1];
        // 当长度小于 5 的时候，本来的值最大，不需要剪
        for (int i = 0; i < 5; i++) {
            dp[i] = i;
        }
        // i 代表当前绳子的长度
        for (int i = 5; i <= target; i++) {
            // j 代表将绳子切割的长度，这个 for 循环计算的是当前长度下使用不同的分割方式后的乘积最大值
            for (int j = 1; j < i; j++) {
                // dp[i - j] 代表将当前长度切割 j 后的乘积最大值
                dp[i] = Math.max(dp[i], j * dp[i - j]);
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        剪绳子 j = new 剪绳子();
        System.out.println(j.cutRope1(8));
//        System.out.println(j.count);
    }
}


