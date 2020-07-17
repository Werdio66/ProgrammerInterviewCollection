package com._520.sort;

import java.util.Arrays;

/**
 * @author Werdio丶
 * @since 2020-07-17 20:20:55
 */
public class MergeSort {

    private void mergeSort(int[] arr, int left, int right, int[] temp){
        if (left < right){
            int mid = left + (right - left) / 2;
            // 对数组左边进行拆分
            mergeSort(arr, left, mid, temp);
            // 对数组右边进行拆分
            mergeSort(arr, mid + 1, right, temp);
            // 合并
            merge(arr, left, mid, right, temp);
        }
    }

    private void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;           // 当前拆分左数组左边下标
        int j = mid + 1;        // 当前拆分右数组左边下标
        int t = 0;              // 中间数组

        // 挨个比较俩个数组中元素的大小，并按照顺序存入 temp数组
        while (i <= mid && j <= right){
            // 左边数组值小
            if (arr[i] <= arr[j]){
                temp[t++] = arr[i++];
            }else {
                temp[t++] = arr[j++];
            }
        }
        // 左边数组有剩余
        while (i <= mid){
            temp[t++] = arr[i++];
        }
        // 右边数组有剩余
        while (j <= right){
            temp[t++] = arr[j++];
        }

        // 将中间数组的下标置 0
        t = 0;

        // 将修改后的元素复制到原数组
        while (left <= right){
            arr[left++] = temp[t++];
        }
    }

    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        System.out.println(Arrays.toString(arr));
        MergeSort sort = new MergeSort();
        sort.mergeSort(arr, 0, arr.length - 1, new int[arr.length]);
        System.out.println(Arrays.toString(arr));
    }
}
