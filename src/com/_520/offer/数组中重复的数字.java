package com._520.offer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 数组中重复的数字 {

    public int findRepeatNumber(int[] nums) {

        Set<Integer> set = new HashSet<>();

        int result = -1;

        for (int num : nums) {
            if (!set.add(num)){
                result = num;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        数组中重复的数字 a = new 数组中重复的数字();

        int[] arr = {1, 4, 3, 2, 6, 5, 7, 6};

        System.out.println(a.findRepeatNumber(arr));
    }
}
