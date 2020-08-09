package com._520.offer;

import java.util.ArrayList;
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

    /**
     *  双指针
     * @param array
     * @param sum
     * @return
     */
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        // 左指针
        int left = 0;
        // 右指针
        int right = array.length - 1;

        ArrayList<Integer> list = new ArrayList<>();
        // 记录乘积最小的值
        int min = Integer.MAX_VALUE;

        while (left < right){

            int s = array[left] + array[right];
            // 只有和相等且乘积最小才加入 list 中
            if (s == sum && array[left] * array[right] < min){
                // 因为结果只需要一组数据，所以清除之前的乘积比较大的值
                list.clear();
                list.add(array[left]);
                list.add(array[right]);
                // 更新乘积最小值
                min = array[left] * array[right];
                // 指针向右移动
                left++;

            }else if (s > sum){
                right--;
            }else {
                left++;
            }
        }
        return list;
    }

    /**
     *  字典法，
     *      思路：目标值是 sum，其中一个是 a，另一个是 b，那么就可在插入 a 的时候，判断
     *            是否有 b，有的话，就能满足 sum
     *
     * @param array
     * @param sum
     * @return
     */
    public ArrayList<Integer> FindNumbersWithSum1(int [] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();

        int min = Integer.MAX_VALUE;
        //
        for (int i = 0; i < array.length; i++) {
            // 计算和当前值和为 sum 的值
            int b = sum - array[i];
            // map 值包含的，且他俩的乘积较小，加入 list
            if (map.containsKey(b) && array[i] * b < min){
                list.clear();
                list.add(b);
                list.add(array[i]);
                min = array[i] * b;
            }else {
                map.put(array[i], array[i]);
            }
        }

        return list;
    }
    public static void main(String[] args) {
        和为s的俩个数 h = new 和为s的俩个数();
        int[] arr = {2, 7, 11, 15};
        int[] twoSum = h.twoSum2(arr, 9);
        System.out.println(Arrays.toString(twoSum));

        System.out.println(h.FindNumbersWithSum1(arr, 9));
    }
}
