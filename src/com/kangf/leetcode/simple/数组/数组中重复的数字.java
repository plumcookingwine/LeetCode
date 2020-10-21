package com.kangf.leetcode.simple.数组;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 剑指 Offer 03. 数组中重复的数字
 * <p>
 * 找出数组中重复的数字。
 * <p>
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 * <p>
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 * <p>
 * 限制：
 * 2 <= n <= 100000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 数组中重复的数字 {

    public static void main(String[] args) {
        int[] nums = {0, 100, 2, 3, 4, 3, 2, 100};
        System.out.println("i === " + new Solution3().findRepeatNumber(nums));
    }


    /**
     * 使用Hashmap记录次数
     * 9 ms	46.8 MB
     */
    private static class Solution {
        public int findRepeatNumber(int[] nums) {
            final Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                if (map.get(num) != null) {
                    return num;
                }
                map.put(num, 1);
            }
            return -1;

        }
    }

    /**
     * 根据 HashSet特性解法
     *
     * 5 ms	48.1 MB
     */
    private static class Solution2 {
        public int findRepeatNumber(int[] nums) {

            final Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                if (!set.add(num)) {
                    return num;
                }
            }

            return -1;

        }
    }


    /**
     * 使用int数组记录次数(测试使用此方法效率最高)
     *
     * 1 ms	 45.2 MB
     */
    private static class Solution3 {
        public int findRepeatNumber(int[] nums) {

            final int[] cac = new int[nums.length];

            for (int num : nums) {

                if (++cac[num] > 1) {
                    return num;
                }
            }


            return -1;

        }
    }
}
