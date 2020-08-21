package com._520.sort;

import java.util.Arrays;

/**
 * @author Werdio丶
 * @since 2020-07-18 18:07:11
 */
public class HeapSort {

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public void heapSort(int[] arr){

        // 将数组调整为大顶堆，从最后一个非叶子结点开始调整
        for (int i = (arr.length >> 1) - 1; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            swap(arr, 0, i);
            heapify(arr, 0, i);
        }
    }

    /**
     *
     * @param arr       调整数组
     * @param i         当前子树的根结点
     * @param length    当前数组待排序长度
     */
    private void heapify(int[] arr, int i, int length){
        // 当前子树根结点的值
        int parentValue = arr[i];

        // 遍历子结点
        for (int j = 2 * i + 1; j < length; j = j * 2 + 1) {
            // 找到子结点中较大的
            if (j + 1 < length && arr[j] < arr[j + 1]){
                j++;
            }
            // 判断子结点是否比根结点的值大
            if (arr[j] > parentValue){

                arr[i] = arr[j];
                // 指向子结点，调整子结点的子结点为大顶堆
                i = j;
            }else {
                break;
            }
        }

        arr[i] = parentValue;
    }


    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9};
        System.out.println(Arrays.toString(arr));
        HeapSort sort = new HeapSort();
        sort.heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
