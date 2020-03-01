package com._520.sort;

import java.util.Arrays;

public class QuickSort {


    public static void sort(int[] array, int start, int end) {
        if (array.length < 1 || start < 0 || end >= array.length || start > end) return;
        int smallIndex = partition(array, start, end);
        if (smallIndex > start)
            sort(array, start, smallIndex - 1);
        if (smallIndex < end)
            sort(array, smallIndex + 1, end);
    }

    public static int partition(int[] array, int start, int end) {
        int pivot = (int) (start + Math.random() * (end - start + 1));
        int smallIndex = start - 1;
        swap(array, pivot, end);
        for (int i = start; i <= end; i++)
            if (array[i] <= array[end]) {
                smallIndex++;
                if (i > smallIndex)
                    swap(array, i, smallIndex);
            }
        return smallIndex;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 6, 5, 7, 4, 9};
        System.out.println(Arrays.toString(arr));
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
