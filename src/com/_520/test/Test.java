package com._520.test;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author Werdio丶
 * @since 2020-08-16 15:14:19
 */
public class Test {

    public static int CalulateMethodCount (int num_money) {


        return 2 * CalulateMethodCount(num_money - 1);
    }

    public static int CalulateMethodCount1 (int num_money) {
        int cur = 1;
        int next = 2;

        if (num_money == 1){
            return cur;
        }

        for (int i = 1; i < num_money; i++) {
            if (i == 31){
                return Integer.MAX_VALUE;
            }
            next = cur << 1;
            cur = next;
        }


        return next;
    }

    public static void main(String[] args) {

        String str = "hello undo word undo";
        LinkedList<String> stack = new LinkedList<>();
        String trim = str.trim();
        String[] s = trim.split("\\s+");
        System.out.println(s.length);
        String pop = "";
        stack.push(s[0]);
        for (int i = 1; i < s.length; i++) {

            if (s[i].equals("undo")){
                pop = stack.pop();
                if (i + 1 < s.length && s[i + 1].equals("redo")){
                    stack.push(pop);
                    i++;
                }
            }else {
                stack.push(s[i]);
            }
        }

        String res = "";
        while (!stack.isEmpty()){
            res += stack.removeLast();
            res += " ";
        }

        System.out.println(res.trim());
    }
}
