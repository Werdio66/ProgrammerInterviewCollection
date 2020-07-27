package com._520.test;


import java.util.ArrayList;
import java.util.Iterator;

public class Hello {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);


//        for (Integer integer : list) {
//            list.remove(integer);
//            break;
//        }

        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()){
            Integer next = iterator.next();
            if (next == 3){
                iterator.remove();
            }
        }

        System.out.println(list);
    }
}
