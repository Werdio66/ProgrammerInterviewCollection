package com._520.stack;

import java.util.ArrayList;
import java.util.Stack;

/**
 *  用俩个栈进行排序
 *
 *  一个栈用来存储所有的数据，另一个用来排序
 *
 */
public class TwoStacks {

    public ArrayList<Integer> twoStacksSort(int[] numbers) {

        Stack<Integer> initStack = new Stack<>();
        Stack<Integer> sortStack = new Stack<>();

        for (int n : numbers){
            initStack.push(n);
        }

        while (!initStack.empty()){

            // 第一次排序的栈中没有数据
            if (sortStack.empty()){
                sortStack.push(initStack.pop());
            }
            // 使用变量来记录当前要插入的数
            int num = initStack.pop();

            // 这里是按照栈顶元素最大
            // 如果大于栈顶元素直接压栈
            if (num >= sortStack.peek()){
                sortStack.push(num);
            }else {

                // 小于的话，将比要插入元素 num 大的数都弹出栈，压到 initStack 中

                // 记录从排序栈中弹出的数量
                int size = 0;

                while (!sortStack.empty() && sortStack.peek() > num){
                    initStack.push(sortStack.pop());
                    size++;
                }

                // 找到合适的位置，插入进去
                sortStack.push(num);

                // 将弹出来的数还回去
                while (size-- > 0){
                    sortStack.push(initStack.pop());
                }
            }

        }

        ArrayList<Integer> list = new ArrayList<>();

        while (!sortStack.isEmpty()){
            list.add(sortStack.pop());
        }

        return list;
    }


    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 2, 6, 5, 8, 8, 10, 7};
        new TwoStacks().twoStacksSort(nums).forEach(System.out::println);
    }
}
