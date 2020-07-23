package com._520.offer;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 * 俩种方法：
 * 1、遍历数组，找到就返回
 * 2、使用二分查找
 * @author Werdio丶
 * @since 2020-07-23 07:08:27
 */
@SuppressWarnings("all")
public class 旋转数组中最小的数字 {

    public static int minNumberInRotateArray(int [] array) {
        int length = array.length;

        // 如果第一个数小于最后一个，说明，旋转后的数组是一个非递减的数组，类似 1,2,3,4,5，所以返回第一个元素
        if (array[0] < array[length - 1]){
            return array[0];
        }

        // 如果第一个元素大于第二个元素，说明把数组全部旋转了，所以最小的应该是最后一个元素
        if (array[0] > array[1]){
            return array[length - 1];
        }

        // 遍历数组
        for (int i = 0; i < length - 1; i++) {
            // 当前元素大于后一个元素，说明后一个就是最小的元素
            if (array[i] > array[i + 1]){
                return array[i + 1];
            }
        }

        // 我感觉已经考虑完所有的可能了，但是最后还要一个返回值
        return array[length - 1];
    }

    public static int minNumberInRotateArray1(int [] array) {

        int left = 0;
        int right = array.length - 1;

        // 使用二分查找
        while (left < right){
            int mid = (left + right) >> 1;

            // 因为是非递减数列，所以有相等的元素，
            if (array[mid] == array[right]){
                right--;
                // 最小值在左边
            }else if (array[mid] < array[right]){
                right = mid;
            }else {
                // 中间值比右边的大，因为这是非递减数列，所以最小值肯定在右边
                left = mid + 1;
            }
        }

        return array[left];
    }
    public static void main(String[] args) {

        int[] arr = {3, 4, 5, 1, 2};
        int[] arr2 = {1, 2, 3, 4, 5};
        int[] arr3 = {5, 4, 3, 2, 1};
        System.out.println(minNumberInRotateArray1(arr));
        System.out.println(minNumberInRotateArray1(arr2));
        System.out.println(minNumberInRotateArray1(arr3));
    }
}
