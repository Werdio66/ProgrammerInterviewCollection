package com._520.sort;

import java.util.Arrays;

public class ShellSort {


    public static void shellSort(int[] arr){
//        int count = 0;
        // 把数组分为gap组
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //
            for (int i = gap; i < arr.length; i++) {
                // 第二个数是要插入的数组
                int insertValue = arr[i];
                // 要插入位置数字的下标
                int insertIndex = i;
                // 后面的数小于前面的数时，移动位置
                while (insertIndex - gap >= 0 && insertValue < arr[insertIndex - gap]){
                    // 替换当前值
                    arr[insertIndex] = arr[insertIndex - gap];
                    // 和前边的继续比较
                    insertIndex -= gap;
                }
                // 找到了正确的位置
                arr[insertIndex] = insertValue;



            }
//            System.out.println("第" + (++count) + "轮");
//            System.out.println(Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 4, 2, 6, 0, 5};
        System.out.println(Arrays.toString(arr));
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
