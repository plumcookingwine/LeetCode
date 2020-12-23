package com.kangf.leetcode.day;

/**
 * 7. 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * 输入: 123
 * 输出: 321
 * <p>
 * 示例 2:
 * 输入: -123
 * 输出: -321
 * <p>
 * 示例 3:
 * 输入: 120
 * 输出: 21
 */
public class _7_整数反转 {

    public static void main(String[] args) {

        System.out.println("i === " + new Solution().reverse(1534236469));
    }

    private static class Solution {


        public int reverse(int x) {
            long y = 0;
            while (x != 0) {
                y = y * 10 + x % 10;
                x = x / 10;
            }

            return (int) y == y ? (int) y : 0;
        }
    }
}
