package com._520.offer;

import java.util.Arrays;

@SuppressWarnings("all")
public class 调整数组顺序使奇数位于偶数前面 {

    /**
     *  双指针，左右
     */
    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right){
            // 奇数
            if ((nums[left] & 1) != 0){
                left++;
            }

            if ((nums[right] & 1) == 0){
                right--;
            }

            if (left >= right){
                break;
            }

            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        return nums;
    }

    /**
     *  双指针，快慢指针
     */
    public int[] exchange1(int[] nums) {
        int fast = 0;
        int slow = 0;

        while ((nums[fast] & 1) == 1){
            slow++;
            fast++;
        }

        while (fast < nums.length){

            // 快指针指的是奇数，和慢的交换，慢指针向前移动
            if ((nums[fast] & 1) == 1){
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
                slow++;
            }

            fast++;
        }
        return nums;
    }


    public void reOrderArray(int [] array) {
        if (array.length == 1)
            return;
        int length = array.length;
        int i = 0;
        while (i < length) {
            // 找到第一个偶数
            while ((array[i] & 1) == 1) {
                if (i >= length - 1)
                    return;
                i++;
            }
            // 找到第一个奇数
            int j = i + 1;
            while ((array[j] & 1) == 0){
                if (j >= length - 1)
                    return;
                j++;
            }
            // 记录奇数的值
            int temp = array[j];
            // 所有的数都后移
            while (j > i){
                array[j] = array[j - 1];
                j--;
            }
            // 将奇数换到前面
            array[i] = temp;
        }
    }

    public static void main(String[] args) {
        调整数组顺序使奇数位于偶数前面 t = new 调整数组顺序使奇数位于偶数前面();
        int[] arr = {1, 2, 3, 4, 5, 6};
//        for (int num : t.exchange1(arr)) {
//            System.out.print("\t" + num);
//        }

        t.reOrderArray(arr);

        System.out.println(Arrays.toString(arr));
    }
}
