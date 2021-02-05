package com.kangf.leetcode.day;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class _136_只出现一次的数字 {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 2, 3, 4};

        System.out.println("num == " + new Solution().singleNumber2(nums));

    }

    private static class Solution {

        public int singleNumber2(int[] nums) {
            int res = 0;
            for (int num : nums) {
                res ^= num;
            }
            return res;
        }


        public int singleNumber(int[] nums) {

            Map<Integer, Integer> map = new HashMap<>();

            for (int num : nums) {

                Integer count = map.get(num);

                if (count == null || count == 0) {
                    map.put(num, 1);
                } else {
                    map.put(num, count + 1);
                }
            }

            Set<Integer> keys = map.keySet();

            for (Integer key : keys) {
                if (map.get(key) == 1) {
                    return key;
                }


            }

            return -1;
        }


    }
}
