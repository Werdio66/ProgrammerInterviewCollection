package com._520.offer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
 * 则打印出这三个数字能排成的最小数字为321323。
 *
 * @author Werdio丶
 * @since 2020-08-07 14:31:22
 */
public class 把数组排成最小的数 {

    public static String PrintMinNumber(int [] numbers) {

        List<Integer> list = new ArrayList<>();

        for (int number : numbers) {
            list.add(number);
        }

        StringBuilder sb = new StringBuilder();

        list.stream().sorted(((o1, o2) -> {
            String s1 = o1 + "" + o2;
            String s2 = o2 + "" + o1;
            return Integer.parseInt(s1) - Integer.parseInt(s2);
        })).forEach(sb::append);


        return sb.toString();
    }

    public static void main(String[] args) {
        int[] arr = {3, 323, 321};
        System.out.println(PrintMinNumber(arr));
    }
}
