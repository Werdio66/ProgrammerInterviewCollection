package com._520.offer;

import java.util.Arrays;

@SuppressWarnings("all")
public class 构建乘积数组 {

    public int[] constructArr(int[] a) {
        int[] res = new int[a.length];
        int temp = 1;

        // 计算 i 之前的乘积
        for (int i = 0; i < a.length; i++) {
            res[i] = temp;
            temp *= a[i];
        }

        temp = 1;

        // 再和 i 之后的相乘
        for (int i = a.length - 1; i >= 0; i--) {
            res[i] *= temp;
            temp *= a[i];
        }

        return res;
    }


    public static void main(String[] args) {
        构建乘积数组 g = new 构建乘积数组();
        int[] arr = {1, 2, 3, 4, 5};
        int[] ints = g.constructArr(arr);
        System.out.println(Arrays.toString(ints));
    }
}
