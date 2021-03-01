package com.kangf.leetcode.day;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20. 有效的括号
 * 难度
 * 简单
 * <p>
 * 2176
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：s = "(]"
 * 输出：false
 * 示例 4：
 * <p>
 * 输入：s = "([)]"
 * 输出：false
 * 示例 5：
 * <p>
 * 输入：s = "{[]}"
 * 输出：true
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 */
public class _20_有效的括号 {

    public static void main(String[] args) {

        String s = "([){]}";
        System.out.println("isValid === " + new Solution().isValid3(s));
    }


    private static class Solution {
        public boolean isValid(String s) {
            while (s.contains("()") || s.contains("[]") || s.contains("{}")) {
                if (s.contains("()")) {
                    s = s.replace("()", "");
                }
                if (s.contains("[]")) {
                    s = s.replace("[]", "");
                }
                if (s.contains("{}")) {
                    s = s.replace("{}", "");
                }
            }
            return s.length() == 0;
        }


        public boolean isValid2(String s) {
            int len = s.length();
            if (len % 2 == 1) return false;
            Stack<Character> stack = new Stack<>();
            Map<Character, Character> map = new HashMap<>();
            map.put(')', '(');
            map.put(']', '[');
            map.put('}', '{');
            for (int i = 0; i < len; i++) {
                char c = s.charAt(i);
                if (map.containsKey(c)) {
                    if (stack.isEmpty() || stack.peek() != map.get(c)) {
                        return false;
                    }
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
            return stack.isEmpty();
        }

        public boolean isValid3(String s) {

            int len = s.length();
            if (len % 2 == 1) return false;
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < len; i++) {
                char c = s.charAt(i);
                if (c == '(' || c == '[' || c == '{') {
                    stack.push(c);
                } else {
                    int a = stack.peek();
                    if (a == '(' && c != ')' ||
                            a == '[' && c != ']' ||
                            a == '{' && c != '}') {
                        return false;
                    }
                    stack.pop();
                }
            }
            return stack.isEmpty();

        }
    }
}
