package com._520.offer;

import java.util.*;

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

    // hash
    public boolean duplicate(int numbers[],int length,int [] duplication) {

        int[] arr = new int[length];

        for (int i = 0; i < numbers.length; i++) {
            arr[numbers[i]]++;
            if (arr[numbers[i]] == 1){
                duplication[0] = numbers[i];
                return true;
            }
        }

        return false;
    }


    private void swap(int[] arr, int left, int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
    public static void main(String[] args) {
        数组中重复的数字 a = new 数组中重复的数字();

        int[] arr = {1, 4, 3, 2, 6, 5, 7, 6};

        System.out.println(a.findRepeatNumber(arr));
    }
}
