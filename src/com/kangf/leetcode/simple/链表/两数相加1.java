package com.kangf.leetcode.simple.链表;

import com.kangf.leetcode.GeneratorNode;
import com.kangf.leetcode.ListNode;

/**
 * 给出两个非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0开头。
 * <p>
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 两数相加1 {


    public static void main(String[] args) {
        ListNode l1 = GeneratorNode.getListNode(9, 9, 9, 9, 9, 9, 9);
        ListNode l2 = GeneratorNode.getListNode(9, 9, 9, 9);

        System.out.println("sum == " + new Solution().addTwoNumbers(l1, l2));
    }

    private static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode node = null;
            ListNode tmp = null;
            ListNode newNode;
            int carry = 0;
            while (l1 != null || l2 != null) {
                int n1 = l1 == null ? 0 : l1.val;
                int n2 = l2 == null ? 0 : l2.val;
                int sum = n1 + n2 + carry;
                carry = sum / 10;
                int val = sum % 10;
                newNode = new ListNode(val);
                if (node == null) {
                    node = newNode;
                    tmp = node;
                } else {
                    tmp.next = newNode;
                    tmp = tmp.next;
                }
                if (l1 != null) l1 = l1.next;
                if (l2 != null) l2 = l2.next;
            }
            if (carry > 0) {
                newNode = new ListNode(carry);
                tmp.next = newNode;
            }
            return node;
        }
    }
}
