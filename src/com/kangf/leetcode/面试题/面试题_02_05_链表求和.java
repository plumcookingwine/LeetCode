package com.kangf.leetcode.面试题;

import com.kangf.leetcode.GeneratorNode;
import com.kangf.leetcode.ListNode;

public class 面试题_02_05_链表求和 {


    public static void main(String[] args) {
        ListNode l1 = GeneratorNode.getListNode(2, 4, 3);
        ListNode l2 = GeneratorNode.getListNode(5, 6, 4);

        System.out.println(new Solution().addTwoNumbers(l1, l2));
    }

    private static class Solution {

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            ListNode node = null;
            ListNode tail = null;
            int carry = 0;

            while (l1 != null || l2 != null) {
                int val1 = 0;
                int val2 = 0;

                if (l1 != null) val1 = l1.val;
                if (l2 != null) val2 = l2.val;

                int sum = val1 + val2 + carry;
                int cur = sum % 10;
                carry = sum / 10;

                if (node == null) {
                    node = new ListNode(cur);
                    tail = node;
                } else {
                    tail.next = new ListNode(cur);
                    tail = tail.next;
                }

                if (l1 != null) l1 = l1.next;
                if (l2 != null) l2 = l2.next;
            }


            if (carry > 0) {
                tail.next = new ListNode(carry);
            }

            return node;

        }
    }
}
