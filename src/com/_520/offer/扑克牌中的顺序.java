package com._520.offer;

import java.util.Arrays;

@SuppressWarnings("all")
public class 扑克牌中的顺序 {

    // 非排序
    public boolean isStraight(int[] nums) {

        boolean[] booleans = new boolean[14];
        int max = 0;
        int min = 14;

        for (int num : nums) {
            // 有重复直接返回 false
            if (booleans[num]){
                return false;
            }
            if (num == 0){
                continue;
            }
            booleans[num] = true;
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        return max - min < 5;
    }

    // 排序
    public boolean isStraight1(int[] nums) {
        Arrays.sort(nums);

        int count = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0){
                count++;
                continue;
            }
            if (nums[4] - nums[i] > 4){
                return false;
            }
            // 去重
            if (nums[i] == nums[i + 1]){
                return false;
            }

            while (nums[i + 1] - nums[i] > 1){
                count--;
                nums[i]++;
            }
        }

        return count >= 0;

    }

    public static void main(String[] args) {
        扑克牌中的顺序 p = new 扑克牌中的顺序();
        int[] arr = {1, 2, 0, 0, 4};
        System.out.println(p.isStraight1(arr));
    }
}
