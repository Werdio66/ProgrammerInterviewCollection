package com._520.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Werdio丶
 * @since 2020-07-31 07:36:19
 */
public class ConcurentHashMapItertor {

    public static void main(String[] args) {
        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();


        HashSet<String> hashSet = new HashSet<>();
        hashSet.add(new String("abc"));
        hashSet.add(new String("abc"));

        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()){
            Map.Entry<Integer, Integer> entry = iterator.next();
            map.remove(entry.getKey());
        }
    }
}
