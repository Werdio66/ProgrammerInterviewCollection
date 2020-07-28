package com._520.offer;

/**
 * @author Werdio丶
 * @since 2020-07-29 07:34:22
 */
public class 青蛙跳台阶_变态 {

    // 变态青蛙，一次可以跳任意台阶
    // f(n) = f(n - 1) + ... + f(1)
    // f(n -1) = f(n - 2) + ... + f(1)
    // f(n) - f(n - 1) = f(n - 1)
    // f(n) = 2 * f(n - 1)
    // 不存在重复，所以不用剪枝
    private int numWays1(int n){
        if (n == 1){
            return 1;
        }

        return 2 * numWays1(n - 1);
    }


    // 动态规划
    private int numWays2(int n){

        int cur = 1;
        int next = 2;

        for (int i = 1; i < n; i++) {
            next = cur << 1;
            cur = next;
        }

        return next;
    }
    public static void main(String[] args) {
        青蛙跳台阶_变态 q = new 青蛙跳台阶_变态();
        System.out.println(q.numWays2(7));
    }
}
