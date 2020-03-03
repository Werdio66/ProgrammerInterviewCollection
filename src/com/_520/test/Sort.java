package com._520.test;

import java.util.Arrays;

public class Sort {

    public static void sort(int[] array, int start, int end) {
        int left = start;
        int right = end;

        int pivot = array[(left + right) >> 1];

        System.out.println(pivot);

        while (left < right){

            while (array[left] < pivot){
                left++;
            }

            while (array[right] > pivot){
                right--;
            }

            if (left > right){
                break;
            }

            swap(array, left, right);

            if (array[left] == pivot){
                left++;
            }

            if (array[right] == pivot){
                right--;
            }
        }

        System.out.println("left = " + left + "  right = " + right);

        // 左递归
        if (start < right){
            sort(array, start, right);
        }

        // 右递归
        if (left < end){
            sort(array, left, end);
        }
    }


    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        Sort sort = new Sort();
        int[] arr = {1, 3, 2, 6, 5, 7, 4, 9, 0};
        System.out.println(Arrays.toString(arr));
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
