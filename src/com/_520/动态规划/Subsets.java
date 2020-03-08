package com._520.动态规划;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *  题目描述
 * 请编写一个方法，返回某集合的所有非空子集。
 *
 * 给定一个int数组A和数组的大小int n，请返回A的所有非空子集。保证A的元素个数小于等于20，且元素互异。
 * 各子集内部从大到小排序,子集之间字典逆序排序，
 */
public class Subsets {

    public static ArrayList<ArrayList<Integer>> getSubsets(int[] A, int n) {
        Arrays.sort(A);
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

        for (int i = 0; i < 2 << n - 1; i++) {
            ArrayList<Integer> list = new ArrayList<>();

            for (int j = A.length - 1; j >= 0; j--) {
                list.add(A[i]);
            }

            lists.add(list);
        }


        return lists;
    }

    public static void main(String[] args) {
        int[] arr = {123, 456, 789};

        ArrayList<ArrayList<Integer>> subsets = getSubsets(arr, arr.length);

        System.out.println(subsets);
    }

}
