package com._520.offer;

@SuppressWarnings("all")
public class 青蛙跳台阶 {

    // 递归，最后剩余一个台阶或者俩个台阶，也可以进行优化：剪枝
    public int numWays(int n) {
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }

        return numWays(n - 1) + numWays(n - 2);
    }

    /**
     *  动态规划
     * @param n
     * @return
     */
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


    public static void main(String[] args) {
        青蛙跳台阶 q = new 青蛙跳台阶();
        System.out.println(q.numWays1(7));
    }
}
