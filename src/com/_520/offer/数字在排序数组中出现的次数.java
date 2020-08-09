package com._520.offer;

import java.util.Arrays;

/**
 *  思路：
 *      因为数组是排序的，所以我们只需要查找到 k 在数组中的位置，然后，在左右遍历即可
 *      重要的一步就是查找 k 在数组中的位置
 *      二叉查找
 *
 * @author Werdio丶
 * @since 2020-08-09 07:27:35
 */
public class 数字在排序数组中出现的次数 {

    public static int GetNumberOfK(int [] array , int k) {

        int index = Arrays.binarySearch(array, k);

        int count = 0;

        for (int i = index; i < array.length; i++) {
            if (array[i] == k){
                count++;
            }
        }

        for (int i = index - 1; i >= 0; i--) {
            if (array[i] == k){
                count++;
            }
        }
        return count;
    }
}
