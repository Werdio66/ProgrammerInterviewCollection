package com._520.string;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *  简单模拟 LRU 算法
 */
public class LRU<K, V> extends LinkedHashMap<K, V> {

    private final int CACHE_SIZE;

    // 传入内存的容量
    public LRU(int cacheSize){
        // 指定初始化容量，加载因子，和排序规则，true 代表按照访问顺序排序，最近访问的在链表的首部
        super(16, 3 / 4, true);
        CACHE_SIZE = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {

        // 当缓存的数据大于容量时，为 true，删除最近最少（最老的）使用的数据
        return size() > CACHE_SIZE;
    }
}
