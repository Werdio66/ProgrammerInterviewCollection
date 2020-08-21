package com._520.test;

import java.util.ArrayList;

/**
 * @author Werdio丶
 * @since 2020-08-13 11:51:45
 */
public class ArrayListGrowTest {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 17; i++) {
            list.add(i);
        }

        System.out.println(list);
    }
}
