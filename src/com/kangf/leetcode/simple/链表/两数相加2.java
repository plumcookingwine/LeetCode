package com.kangf.leetcode.simple.链表;

import com.kangf.leetcode.GeneratorNode;
import com.kangf.leetcode.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 * <p>
 * 进阶：
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 * <p>
 * 示例：
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 两数相加2 {

    public static void main(String[] args) {
        ListNode l1 = GeneratorNode.getListNode(9, 9, 9, 9, 9);
        ListNode l2 = GeneratorNode.getListNode(9);

        System.out.println(new Solution().addTwoNumbers(l1, l2));

    }

    /**
     * 用栈先进后出的特性
     *
     * 并使用头插法创建新的链
     *
     * 4 ms	38.6 MB
     */
    private static class Solution {

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            Deque<Integer> deque1 = new LinkedList<>();
            Deque<Integer> deque2 = new LinkedList<>();


            while (l1 != null) {
                deque1.push(l1.val);
                l1 = l1.next;
            }
            while (l2 != null) {
                deque2.push(l2.val);
                l2 = l2.next;
            }

            ListNode head = null;
            ListNode newNode;
            int carry = 0;

            while (deque1.size() > 0 || deque2.size() > 0) {
                int a = 0, b = 0;
                if (!deque1.isEmpty()) {
                    a = deque1.pop();
                }
                if (!deque2.isEmpty()) {
                    b = deque2.pop();
                }

                int sum = a + b + carry;
                int val = sum % 10;
                carry = sum / 10;
                newNode = new ListNode(val);
                if (head != null) {
                    newNode.next = head;
                }
                head = newNode;
            }
            if (carry > 0) {
                newNode = new ListNode(carry);
                newNode.next  = head;
                head = newNode;
            }

            return head;

        }

    }
}
