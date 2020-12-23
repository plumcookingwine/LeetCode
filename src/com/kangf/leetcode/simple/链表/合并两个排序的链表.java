package com.kangf.leetcode.simple.链表;

/**
 * 剑指 Offer 25. 合并两个排序的链表
 * <p>
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * <p>
 * 示例1：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * <p>
 * 限制：
 * 0 <= 链表长度 <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 合并两个排序的链表 {
    public static void main(String[] args) {

        ListNode l1 = GeneratorNode.getListNode(1, 2, 4);
        ListNode l2 = GeneratorNode.getListNode(1, 3, 4, 5, 6, 7);

        System.out.println(new Solution().mergeTwoLists(l1, l2));


    }

    private static class Solution {

        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

            ListNode node = new ListNode(-1);
            ListNode tmp = node;

            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    tmp.next = l1;
                    l1 = l1.next;
                } else {
                    tmp.next = l2;
                    l2 = l2.next;
                }
                tmp = tmp.next;
            }

            if (l1 != null) {
                tmp.next = l1;
                tmp = tmp.next;
            }
            if (l2 != null) {
                tmp.next = l2;
            }

            return node.next;
        }
    }
}
