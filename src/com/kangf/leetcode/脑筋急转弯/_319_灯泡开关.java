package com.kangf.leetcode.脑筋急转弯;

import java.util.Arrays;

public class _319_灯泡开关 {

    public static void main(String[] args) {
        System.out.println("light num === " + new Solution().bulbSwitch(99999));
    }

    private static class Solution {
        public int bulbSwitch(int n) {
            return (int) Math.sqrt(n);
        }
    }
}
