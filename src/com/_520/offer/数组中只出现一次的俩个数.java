package com._520.offer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 思路：
 * 1、hash
 * 2、位运算，异或，俩个数相等异或为 0，和 0 异或还是本身,所以将所有的数字异或之后
 *    最后剩余的肯定是那俩个数的异或结果
 *
 * @author Werdio丶
 * @since 2020-08-09 08:05:07
 */
public class 数组中只出现一次的俩个数 {

    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])){
                map.remove(array[i]);
            }else {
                map.put(array[i], 1);
            }
        }

        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();

        int[] res = new int[2];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            Integer value = entry.getKey();
            res[index++] = value;
        }

        num1[0] = res[0];
        num2[0] = res[1];

    }
    public static void main(String[] args) {


    }
}
