package com._520.offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("all")
public class 和为s的俩个数 {

    /**
     *  穷举法
     */
    public int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] > target){
                    break;
                }
                if (nums[i] + nums[j] == target){
                    result[0] = nums[i];
                    result[1] = nums[j];
                    return result;
                }
            }
        }

        return result;
    }

    /**
     *  字典法
     */
    public int[] twoSum1(int[] nums, int target) {

        int[] result = new int[2];

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])){
                result[0] = map.get(target - nums[i]);
                result[1] = nums[i];
                return result;
            }else {
                map.put(nums[i], nums[i]);
            }
        }

        return result;
    }

    /**
     *  双指针
     */
    public int[] twoSum2(int[] nums, int target) {

        int[] result = new int[2];

        int left = 0;
        int right = nums.length - 1;

        int sum = 0;
        while (left < right){
            sum = nums[left] + nums[right];
            if (sum == target){
                result[0] = nums[left];
                result[1] = nums[right];
                return result;
            }else if (sum > target){
                right--;
            }else {
                left++;
            }
        }

        return result;
    }


    public static void main(String[] args) {
        和为s的俩个数 h = new 和为s的俩个数();
        int[] arr = {2, 7, 11, 15};
        int[] twoSum = h.twoSum2(arr, 9);
        System.out.println(Arrays.toString(twoSum));
    }
}
