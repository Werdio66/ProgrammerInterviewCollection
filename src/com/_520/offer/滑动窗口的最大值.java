package com._520.offer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 *
 *  思路：
 *      1、使用双端队列
 *      2、首先判断当前值是否过期，过期就移除队列
 *      3、如果当前值大于之前的值，删除之前的值，然后替换，如果小于直接加在队列尾部，因为队头的值可能会过期
 *      3、将队头的值加入 list
 *
 * @author Werdio丶
 * @since 2020-08-16 08:22:22
 */
public class 滑动窗口的最大值 {

    public static ArrayList<Integer> maxInWindows(int [] num, int size){
        ArrayList<Integer> list = new ArrayList<>();
        if (size == 0 || size > num.length){
            return list;
        }
        Deque<Integer> queue = new LinkedList<>();

        for (int i = 0; i < num.length; i++) {

            // 超过范围的删除
            while (!queue.isEmpty() && queue.peekFirst() < i - size + 1){
                queue.poll();
            }
            // 当前值大于队列中的值，更新队列中的所有值
            while (!queue.isEmpty() && num[i] >= num[queue.peekLast()]){
                queue.pollLast();
            }
            // 将元素加入队列
            queue.addLast(i);
            // 将最大值加油list中
            if (i >= size - 1 && !queue.isEmpty()){
                list.add(num[queue.peekFirst()]);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 2, 6, 2, 5, 1};
        int size = 3;

        System.out.println(maxInWindows(arr, size));
    }
}
