package com._520.offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 *
 * 思路：
 *  1、使用 hash 计算每一个数字出现的次数，然后进行比较判断
 *  2、对数组进行排序，满足条件的数字肯定在中间，找到中间的数字，然后判断是否超过一半即可
 *  3、候选法：加入数组中存在众数，那么众数一定大于数组的长度的一半。
 *           思想就是：如果两个数不相等，就消去这两个数，最坏情况下，每次消去一个众数和一个非众数，
 *           那么如果存在众数，最后留下的数肯定是众数。
 * @author Werdio丶
 * @since 2020-07-28 16:15:32
 */
@SuppressWarnings("all")
public class 数组中出现次数超过一半的数字 {

    public int MoreThanHalfNum_Solution1(int [] array) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])){
                map.put(array[i], map.get(array[i]) + 1);
            }else {
                map.put(array[i], 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > array.length / 2) {
                return entry.getKey();
            }
        }

        return 0;
    }

    public int MoreThanHalfNum_Solution2(int [] array) {
        Arrays.sort(array);

        int target = array[array.length / 2];
        int count = 0;

        for (int i : array) {
            if (i == target){
                count++;
            }
        }

        return count > array.length >> 1 ? target : 0;
    }


    public int MoreThanHalfNum_Solution3(int [] array) {

        if (array == null){
            return 0;
        }

        int target = array[0];
        // 记录目标值的个数
        int count = 1;

        for (int i = 1; i < array.length; i++) {
            // 之前的数都抵消完了
            if (count == 0){
                target = array[i];
                continue;
            }
            if (target != array[i]) {
                // 相当于删除掉这俩个数
                count--;
            } else {
                // 对相同的数个数加一
                count++;
            }
        }

        count = 0;

        for (int i : array) {
            if (i == target){
                count++;
            }
        }

        return count > array.length >> 1 ? target : 0;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 2, 2, 5, 4, 2};

        数组中出现次数超过一半的数字 s = new 数组中出现次数超过一半的数字();
        System.out.println(s.MoreThanHalfNum_Solution2(arr));
    }
}
