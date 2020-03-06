package com._520.offer;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class 和为s的连续正整数和 {

    /**
     *  双指针，滑动窗口
     *
     *  target = 9
     *
     *  左指针 left = 0,右指针 right = 1;
     *  sum = 3 < target; right + 1 = 2;
     *  sum = 1 + 2 + 3 = 6 < target; right + 1 = 3;
     *  sum = 1 + 2 + 3 + 4 = 10 > target; left + 1 = 1;
     *  sum = 2 + 3 + 4 = 9 = target
     *
     *  对于 sum 的求和
     *  1.可以使用等差数列求和
     *  2.利用滑动窗口，左边向右滑动时，删除最左边的值，右边向右滑动时加上新的值
     */
    public int[][] findContinuousSequence(int target) {

        List<int[]> list = new ArrayList<>();
        // 左指针
        int left = 1;
        // 右指针
        int right = 2;
        // 连续数组和
        int sum = 0;
        sum = left + right;

        while (left < right){
            // 等差数列求和
//            sum = ((left + right) * (right - left + 1)) >> 1;
            // 和目标值相等，将连续的数组存入 list，并且 left + 1，
            // 以每一个结点起始只能有一组连续序列和目标值相等
            if (sum == target){
                list.add(getArray(left, right));
                sum -= left;
                left++;

                // 大于目标值，可以将数组长度减少，来减少和
            }else if (sum > target){
                sum -= left;
                left++;

                // 小于目标值，加大数组长度
            }else {
                right++;
                sum += right;
            }
        }

        return list.toArray(new int[list.size()][]);
    }

    private int[] getArray(int left, int right) {
        int len = right - left + 1;
        int[] arr = new int[len];

        for (int i = 0; i < len; i++) {
            arr[i] = left;
            left++;
        }
        return arr;
    }

    public static void main(String[] args) {
        和为s的连续正整数和 h = new 和为s的连续正整数和();

        int[][] res = h.findContinuousSequence(15);

        for (int[] re : res) {
            for (int i : re) {
                System.out.print(i + "   ");
            }
            System.out.println();
        }
    }
}
