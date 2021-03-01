package com.kangf.leetcode.day;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 66. 加一
 * 难度
 * 简单
 * <p>
 * 627
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * 示例 2：
 * <p>
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * 示例 3：
 * <p>
 * 输入：digits = [0]
 * 输出：[1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 */
public class _66_加一 {


    public static void main(String[] args) {

        int[] ans = new int[]{9, 9, 9, 9};
        int[] tmp = new int[ans.length + 1];
        System.out.println("tmp === " + Arrays.toString(tmp));
        System.out.println(Arrays.toString(new Solution().plusOne(ans)));

    }

    private static class Solution {
        public int[] plusOne(int[] digits) {
            int len = digits.length;
            int carry = 0;
            for (int i = len - 1; i >= 0; i--) {
                int cur = digits[i];
                int sum;
                if (i == len - 1) {
                    sum = cur + 1;
                } else {
                    sum = cur + carry;
                }
                int real = sum % 10;
                carry = sum / 10;
                digits[i] = real;
                if (carry == 0) {
                    break;
                }
            }


            if (carry > 0) {
                int[] ans = new int[len + 1];
                System.arraycopy(digits, 0, ans, 1, len);
                ans[0] = carry;
                digits = ans;
            }


            return digits;

        }
    }
}
