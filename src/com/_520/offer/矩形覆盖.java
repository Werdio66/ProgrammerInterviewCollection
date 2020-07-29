package com._520.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *
 * 比如n=3时，2*3的矩形块有3种覆盖方法：
 *
 * 思路：
 *      1、当 n = 1 时，只能竖着放
 *      2、当 n = 2 时，可以横着放和竖着放
 *      3、当 n = 3 时，可以考虑第三级如何放，
 *          如果横着放，那么需要俩个才能放满，剩余 n = 1，如果竖着放，那么可以放一个，剩余 n = 2，
 *          所以 n = 3 时，就是 n = 1 和 n = 2 的和
 *      4、当 n = 4 时，考虑第四级如何放，
 *          如果横着放，那么需要俩个才能放满，剩余 n = 2，如果竖着放，那么可以放一个，剩余 n = 3，
 *          所以 n = 4 时，就是 n = 2 和 n = 3 的和
 *       所以可以推出递推方程：f(n) = f(n - 1) + f(n - 2)
 *
 *       可以使用递归，或者动态规划来完成
 * @author Werdio丶
 * @since 2020-07-29 16:52:49
 */
public class 矩形覆盖 {


    Map<Integer, Integer> map = new HashMap<>();
    public int RectCover(int target) {
        if (target <= 0){
            return 0;
        }
        if (target == 1)
            return 1;
        if (target == 2)
            return 2;

        int pre = 0;
        if (map.containsKey(target - 1)){
            pre = map.get(target - 1);
        }else {
            pre = RectCover(target - 1);
            map.put(target - 1, pre);
        }

        int ppre = 0;
        if (map.containsKey(target - 2)){
            ppre = map.get(target - 2);
        }else {
            ppre = RectCover(target - 2);
            map.put(target - 2, ppre);
        }
        return ppre + pre;
    }

    public int RectCover1(int target) {

        if (target <= 0){
            return 0;
        }
        int first = 1;
        int second = 2;

        for (int i = 2; i < target; i++) {
            int temp = first + second;
            first = second;
            second = temp;
        }

        return second;
    }

    public static void main(String[] args) {
        矩形覆盖 j = new 矩形覆盖();

        System.out.println(j.RectCover1(4));
    }
}
