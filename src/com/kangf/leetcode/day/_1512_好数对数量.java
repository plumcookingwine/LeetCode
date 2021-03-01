package com.kangf.leetcode.day;

import java.util.HashMap;
import java.util.Set;

public class _1512_好数对数量 {

    public static void main(String[] args) {

        System.out.println("aaa===" + test3(new int[]{1, 1, 1, 1}));
    }

    private static int test3(int[] a) {
        int[] s = new int[101];
        int count = 0;
        for (int i : a) {
            s[i] = s[i] + 1;
            count = count + s[i] - 1;
        }
        return count;
    }

    private static int test2(int[] a) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : a) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        int count = 0;
        Set<Integer> keys = map.keySet();
        for (Integer key : keys) {
            int c = map.get(key);
            if (c > 1) {

                count = count + ((c) * (c - 1) / 2);

            }
        }

        return count;

    }


    private static int test(int[] a) {

        if (a.length < 2) return 0;

        int slow = 0;
        int fast = 1;

        int count = 0;

        while (slow < a.length - 1) {

            if (a[slow] == a[fast]) {
                count++;
            }
            if (fast == a.length - 1) {
                slow++;
                fast = slow + 1;
            } else {
                fast++;
            }
            System.out.println(fast);
        }

        return count;


    }
}
