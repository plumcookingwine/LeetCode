package com.kangf.leetcode.面试题;

import com.kangf.leetcode.GeneratorNode;
import com.kangf.leetcode.ListNode;

/**
 * 面试题 02.02. 返回倒数第 k 个节点
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 * <p>
 * 注意：本题相对原题稍作改动
 * <p>
 * 示例：
 * <p>
 * 输入： 1->2->3->4->5 和 k = 2
 * 输出： 4
 * 说明：
 * <p>
 * 给定的 k 保证是有效的。
 */
public class 面试题_02_02_返回倒数第k个节点 {

    public static void main(String[] args) {

        ListNode node = GeneratorNode.getListNode(1, 2, 3, 4, 5);
        System.out.println(new Solution().kthToLast2(node, 2));
    }

    private static class Solution {
        public int kthToLast(ListNode head, int k) {
            ListNode fast = head;
            ListNode slow = head;
            while (k-- > 0) {
                fast = fast.next;
            }
            while (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
            return slow.val;
        }

        public int kthToLast2(ListNode head, int k) {
            while (head != null) {
                ListNode tmp = head;
                int i = 0;
                while (i++ < k) {
                    tmp = tmp.next;
                }
                if(tmp == null) {
                    return head.val;
                }
                head = head.next;
            }
            return -1;
        }
    }
}
