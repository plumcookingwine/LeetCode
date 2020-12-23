package com.kangf.leetcode.day;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 * <p>
 * 示例1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _3_无重复字符的最长子串 {

    public static void main(String[] args) {
        System.out.println("lenght == " + new Solution().lengthOfLongestSubstring("aab"));
    }

    /**
     * 惭愧
     *
     * 执行用时： 789 ms , 在所有 Java 提交中击败了 5.00% 的用户
     * 内存消耗： 39.3 MB , 在所有 Java 提交中击败了 28.12% 的用户
     */
    private static class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s.isEmpty()) return 0;
            if (s.length() == 1) return 1;
            List<Character> list = new LinkedList<>();
            int count = 0;
            char[] c = s.toCharArray();

            int left = 0, right = 1;
            list.add(c[left]);
            while (right < c.length) {
                if (list.contains(c[right])) {
                    left++;
                    right = left + 1;
                    count = Math.max(count, list.size());
                    list.clear();
                    list.add(c[left]);
                } else {
                    list.add(c[right]);
                    right++;
                }
            }
            System.out.println("list == " + list);
            count = Math.max(count, list.size());
            return count;
        }

    }
}
