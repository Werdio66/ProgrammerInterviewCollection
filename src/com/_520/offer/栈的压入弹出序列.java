package com._520.offer;

import java.util.LinkedList;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 *
 *  思路：
 *      使用栈模拟压栈出栈的场景
 *
 * @author Werdio丶
 * @since 2020-08-02 11:59:23
 */
public class 栈的压入弹出序列 {

    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        // 使用 linkedList 中的栈方法
        LinkedList<Integer> stack = new LinkedList<>();

        int i = 0;

        // 遍历 push 序列
        for (int num : pushA) {
            // 每一次都将元素压入栈中
            stack.push(num);
            // 只要栈的第一个元素和 pop 序列相等，就将栈中的数据删除
            while (i < pushA.length && stack.getFirst() == popA[i]){
                stack.pop();
                i++;
            }
        }

        // 如果最后栈为空，则表示 pop 序列是该压栈序列的弹出序列
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        int[] pushA = {1, 2, 3, 4, 5};
        int[] popA = {4, 5, 3, 1, 2};

        System.out.println(IsPopOrder(pushA, popA));
    }
}
