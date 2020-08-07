package com._520.offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 *
 * 思路：
 *  1、直接排序，然后找到 k 个数
 *  2、使用大顶堆，维护 k 个数据，通过不断替换，等到遍历完数组，那么这 k 个数就是最小的
 *      这个解法也就是类似于 top k 问题
 *
 * @author Werdio丶
 * @since 2020-08-07 12:03:36
 */
public class 最小的k个数 {

    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {

        ArrayList<Integer> list = new ArrayList<>();

        if (k > input.length || k <= 0){
            return list;
        }
        // 用来构建大顶堆的数组
        // 初始化数组
        int[] arr = Arrays.copyOf(input, k);
        // 将数组构建成大顶堆
        buildHeap(arr);

        for (int i = k; i < input.length; i++) {
            // 找到更小的元素，和大顶堆第一个元素替换
            if (input[i] < arr[0]){
                arr[0] = input[i];
                // 调整大顶堆
                adjust(arr, 0, arr.length);
            }
        }

        // 将最小的 k 个数加入 list
        for (int j : arr) {
            list.add(j);
        }
        return list;
    }

    private static void buildHeap(int[] arr){
        // 从最后一个非叶子结点开始调整
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjust(arr, i, arr.length);
        }
    }

    private static void adjust(int[] arr, int i, int length) {

        int parentValue = arr[i];

        for (int j = 2 * i + 1; j < length; j = j * 2 + 1) {
            // 找到叶子中较大的一个
            if (j + 1 < length && arr[j] < arr[j + 1]){
                j++;
            }

            if (arr[j] > parentValue){
                arr[i] = arr[j];
                /**
                 *          2            5             5             5
                 *        4   5  ==>  4    5  ==>   4    3    ==> 4     3
                 *       1   3       1    3       1    3        1     2
                 *  如果当前 parentValue = 2，那么会先从它的子结点中找到一个较大的 5，然后 5 > 2 所以
                 *  将 2 换为 5，然后将 i 指向 j，也就是 i 指向第二个 5，刚替换的那个，在一次 for 循环
                 *  会继续和这个结点的子结点进行比较，所以找到了 3，然后判断是否大于 parentValue(2)，
                 *  大于就修改值，然后继续找 3 的子结点，发现没有了，就退出循环，然后将 parentValue 赋
                 *  给 3
                 */
                i = j;      // 调整子结点，判断父结点在子结点中的位置
            }else {
                break;
            }

            arr[j] = parentValue;
        }

    }


    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 1, 6, 5, 7, 8};

        int k = 6;
        System.out.println(GetLeastNumbers_Solution(arr, k));
    }
}
