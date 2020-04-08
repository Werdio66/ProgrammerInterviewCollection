package com._520.offer;

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
    public static void main(String[] args) {
        调整数组顺序使奇数位于偶数前面 t = new 调整数组顺序使奇数位于偶数前面();
        int[] arr = {1, 2, 3, 4, 5, 6};
        for (int num : t.exchange1(arr)) {
            System.out.print("\t" + num);
        }
    }
}
