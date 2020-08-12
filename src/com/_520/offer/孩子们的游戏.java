package com._520.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Werdio丶
 * @since 2020-08-11 08:12:26
 */
public class 孩子们的游戏 {

    public static int LastRemaining_Solution(int n, int m) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        int index = 0;

        while (list.size() > 1){

            for (int i = 1; i < m; i++) {
                index++;
                if (index >= list.size()){
                    index %= list.size();
                }
            }
            list.remove(index);
        }
        return list.get(0);
    }

    public static void main(String[] args) {

        //  3
        System.out.println(LastRemaining_Solution(5, 3));
    }
}
