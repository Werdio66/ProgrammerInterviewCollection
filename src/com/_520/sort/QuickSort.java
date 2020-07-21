package com._520.sort;

import java.util.Arrays;

public class QuickSort {


    public static void sort(int[] array, int start, int end) {
        int left = start;
        int right = end;

        int pivot = (int) (start + Math.random() * (end - start + 1));

        while (left < right){
            while (array[left] < array[pivot]){
                left++;
            }

            while (array[right] > array[pivot]){
                right--;
            }

            if (left > right){
                break;
            }

            swap(array, left, right);
            System.out.println(Arrays.toString(array));
        }
    }

    public void quickSort(int[] arr, int start, int end){
        // 条件成立，说明当前序列已经有序
        if (start >= end){
            return;
        }
        // 基准值，左边的都比基准值小，右边的都比基准值大
        int potition = potition(arr, start, end);
        // 对基准值左边的进行排序
        quickSort(arr, start, potition - 1);
        // 对基准值右边的进行排序
        quickSort(arr, potition + 1, end);
    }
    private static int potition(int[] array, int start, int end){
        int left = start;
        int right = end;
        // 随机选取基准下标
        int pivot = (int) (start + Math.random() * (end - start + 1));
        // 基准值
        int value = array[pivot];
        // 将基准换到最后，因为第一次从左边找到比基准值大的数，可以直接和基准值交换，
        swap(array, pivot, end);
        while (left < right){
            // 从左往右找到比基准值大的数
            while (left < right && array[left] < value){
                left++;
            }

            // 当前序列还没有满足条件
            if (left < right){
                // 将比基准值大的数换到右边
                swap(array, left, right);
                // 因为右边的数已经大于基准值，不用再次比较，所以将 right - 1
                right--;
            }

            // 从右边找到比基准值小的数
            while (left < right && array[right] > value){
                right--;
            }

            // 当前序列还没有满足条件
            if (left < right){
                // 将比基准值小的数换到左边
                swap(array, right, left);
                // 因为左边的数已经小于基准值，不用再次比较，所以将 left + 1
                left++;
            }

        }

        // 返回基准下标
        return left;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        QuickSort sort = new QuickSort();
        int[] arr = {1, 3, 2, 6, 5, 7, 4, 9};
        System.out.println(Arrays.toString(arr));
//        sort(arr, 0, arr.length - 1);
        sort.quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
