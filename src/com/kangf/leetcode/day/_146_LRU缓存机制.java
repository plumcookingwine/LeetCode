package com.kangf.leetcode.day;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class _146_LRU缓存机制 {

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}

        System.out.println(lRUCache.get(1));// 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(lRUCache.get(2));// 返回 -1 (未找到)

        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(lRUCache.get(1)); // 返回 -1 (未找到)
        System.out.println(lRUCache.get(3));// 返回 3
        System.out.println(lRUCache.get(4)); // 返回 4
    }


    private static class LRUCache {

        private final Map<Integer, Integer> map;

        private final int mCapacity;

        public LRUCache(int capacity) {
            map = new LinkedHashMap<>(0, 0.75f, true);
            mCapacity = capacity;
        }

        public int get(int key) {
            Integer v = map.get(key);
            if (v == null) {
                return -1;
            }
            return v;
        }

        public void put(int key, int value) {

            if (map.size() == mCapacity) {
                Iterator<Integer> it = map.keySet().iterator();
                map.remove(it.next());
            }

            map.put(key, value);

            map.forEach((k,v)->{
                System.out.println("map ----- key === " + k + "; v === " + v );
            });
        }
    }
}
