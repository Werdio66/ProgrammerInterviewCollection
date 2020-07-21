package com._520.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Werdio丶
 * @since 2020-07-19 14:44:36
 */
public class RadixSort {

    public void radixSort(int[] arr){
        int maxValue = arr[0];
        // 取得最大的数
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxValue){
                maxValue = arr[i];
            }
        }
        // 计算最大数的位数
        int maxLength = (maxValue + "").length();
        // 桶，存放每一个位数的值
        List<ArrayList<Integer>> bucketList = new ArrayList<>(10);
        // 初始化桶
        for (int i = 0; i < 10; i++) {
            bucketList.add(new ArrayList<>());
        }

        // 外循环，位数，n 表示当前计算的是个位还是十位等
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            // 将每一个数存入桶中
            for (int j = 0; j < arr.length; j++) {
                // 当前位的值
                int digit = arr[j] / n % 10;
                // 将值放入桶中
                bucketList.get(digit).add(arr[j]);
            }

            // 从桶中取出数据
            int index = 0;

            for (int k = 0; k < bucketList.size(); k++) {
                if (bucketList.get(k).size() == 0){
                    continue;
                }
                // 将桶中的数据放入数组
                for (Integer num : bucketList.get(k)) {
                    arr[index++] = num;
                }
                // 清空当前桶
                bucketList.get(k).clear();
            }

        }
    }

    public static void main(String[] args) {
        int[] arr = {46, 655, 8, 532, 93};
        System.out.println(Arrays.toString(arr));
        RadixSort sort = new RadixSort();
        sort.radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
