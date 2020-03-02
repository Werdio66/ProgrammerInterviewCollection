package com._520.动态规划;

/**
 *  在 n * n 的矩阵中，每一行，每一列，每一斜线都不能相同，一共有多少种放法
 *
 *
 */
@SuppressWarnings(value = "all")
public class N皇后 {

    // 代表每一行的第几列
    private static int[] array;

    private static int count = 0;

    private static int max;

    public int nQueens(int n) {
        array = new int[n];
        max = n;

        check(0);

        return count;
    }

    private void check(int n){

        if (n == max){
            print();
            count++;
            return;
        }

        for (int i = 0; i < max; i++) {
            array[n] = i;
            // 判断第 n 个皇后可不可以放在第 i 列
            if (judge(n)){
                // 继续放下一个皇后
                check(n + 1);
            }
        }
    }

    private boolean judge(int n) {

        for (int i = 0; i < n; i++) {
            // 判断是否在同一列或者同一斜线
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])){
                return false;
            }
        }
        return true;
    }

    private void print(){
        for (int i : array) {
            System.out.print(i + "     ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        N皇后 quean = new N皇后();
        System.out.println(quean.nQueens(6));
    }
}
