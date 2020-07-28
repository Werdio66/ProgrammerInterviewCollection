package com._520.offer;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("all")
public class  斐波那契数列 {

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

    /**
     *  剪枝
     * @param n
     * @return
     */
    Map<Integer, Integer> map = new HashMap<>();
    public int fib1(int n) {
        if (n == 0){
            return 0;
        }

        if (n == 1){
            return 1;
        }

        int first = 0;
        if (map.containsKey(n - 1)){
            first = map.get(n - 1);
        }else {
            first = fib1(n - 1);
            map.put(n - 1, first);
        }


        int second = 0;
        if (map.containsKey(n - 2)){
            second = map.get(n - 2);
        }else {
            second = fib1(n - 2);
            map.put(n - 2, second);
        }

        return first + second;
    }

    // 动态规划，(a + b) % n = ((a % n) + (b % n)) % n
    public int fib2(int n){
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
        System.out.println(f.fib2(48));
    }
}
