package com._520.offer;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author Werdio丶
 * @since 2020-08-26 07:18:48
 */
public class LRU<K, V> extends LinkedHashMap<K, V> {

    private static int SIZE = 3;

    public LRU(int size) {
        this(16, 0.75f, false);
        SIZE = size;
    }

    public LRU(int initialCapacity, float loadFactor, boolean accessOrder) {
        super(initialCapacity, loadFactor, accessOrder);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > SIZE;
    }

    public static void main(String[] args) {
        LRU<String, String> lru = new LRU<>(3);
        lru.put("k1", "a");
        lru.put("k2", "b");
        lru.put("k3", "c");
        System.out.println(lru);
        lru.put("k4", "d");
        System.out.println(lru);

    }
}
