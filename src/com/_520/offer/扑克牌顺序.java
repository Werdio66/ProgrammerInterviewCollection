package com._520.offer;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * @author Werdio丶
 * @since 2020-08-10 07:55:41
 */
public class 扑克牌顺序 {

    public static boolean isContinuous(int [] numbers) {

        TreeSet<Integer> set = new TreeSet<>();
        // 记录 0 的个数
        int count = 0;

        for (int number : numbers) {
            if (number == 0){
                count++;
            }else {
                set.add(number);
            }
        }
        // 0 的个数大于等于四个，说明字符串肯定是有序的
        if (count >= 4){
            return true;
        }

        // 有重复元素
        if (set.size() + count < numbers.length){
            return false;
        }


        // 因为走到这一步，已经可以保证，一共有五个数，所以只有最大值和最小值的差值小于等于 4，
        // 就可以保证是有序的，其他的数可以用 set 中的或者 0 来填充
        return set.last() - set.first() <= 4;
    }

    public static boolean isContinuous1(int [] numbers) {

        if(numbers == null || numbers.length == 0){
            return false;
        }

        Arrays.sort(numbers);

        int count = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0){
                count++;
            }else {
                int j = i + 1;
                if (j < numbers.length && numbers[i] == numbers[j]){
                    return false;
                }
            }
        }

        if (count >= 4){
            return true;
        }


        return numbers[numbers.length - 1] - numbers[count] <= 4;
    }

    public static void main(String[] args) {
        int[] arr = {0, 3, 1, 6, 4};
        System.out.println(isContinuous1(arr));
    }
}
