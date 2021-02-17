package com.kangf.leetcode.day;

import java.nio.charset.StandardCharsets;

/**
 * 9. 回文数
 * <p>
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * <p>
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 * <p>
 * 示例 1
 * 输入：x = 121
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * <p>
 * 示例 3：
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 * <p>
 * 示例 4：
 * 输入：x = -101
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * -2^31 <= x <= 2^31 - 1
 * <p>
 * <p>
 * 进阶：你能不将整数转为字符串来解决这个问题吗？
 */
public class _9_回文数 {

    public static void main(String[] args) {

        int x = 1001;

        System.out.println("是否是回文数：" + new Solution().isPalindrome3(x));

    }


    private static class Solution {


        // 事实证明2 为最佳解
        public boolean isPalindrome2(int x) {
            if (x < 0) return false;
            if (x < 10) return true;
            if (x % 10 == 0) return false;
            int reverse =  0 ;
            while (x > reverse) {
                reverse = reverse * 10 + x % 10;
                x /= 10;
            }
            return reverse == x || reverse / 10 == x;
        }

        public boolean isPalindrome3(int x) {
            if (x < 0) return false;
            if (x < 10) return true;
            if (x % 10 == 0) return false;

            char[] strs = String.valueOf(x).toCharArray();
            int length = strs.length;
            int start = 0;
            int end = length - 1;
            while (start <= end) {
                if (strs[start] != (strs[end])) {
                    return false;
                }
                start++;
                end--;
            }
            return true;
        }

        // 转换成字符串从头到尾比较    123321
        public boolean isPalindrome(int x) {
            if (x < 0) return false;
            if (x < 10) return true;
            String[] strs = String.valueOf(x).split("");
            int length = strs.length;
            int start = 0;
            int end = length - 1;
            while (start <= end) {
                if (!strs[start].equals(strs[end])) {
                    return false;
                }
                start++;
                end--;
            }
            return true;
        }
    }
}
