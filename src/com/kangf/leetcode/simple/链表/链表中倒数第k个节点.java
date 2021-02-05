package com.kangf.leetcode.simple.链表;

import com.kangf.leetcode.GeneratorNode;
import com.kangf.leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 * <p>
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * 返回链表 4->5.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 链表中倒数第k个节点 {

    public static void main(String[] args) {

//        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(5);
//
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;

        ListNode node = GeneratorNode.getListNode(1, 2, 3, 4, 5);

        ListNode findNode = new Solution().getKthFromEnd2(node, 2);

        findNode.print();
    }

    private static class Solution {

        public ListNode getKthFromEnd(ListNode head, int k) {

            List<ListNode> list = new ArrayList<>();
            while (head != null) {
                list.add(head);
                head = head.next;
            }

            return list.get(list.size() - k);
        }


        /**
         * 链表也可以用双指针，
         * <p>
         * 开始让快指针先走k步，
         * 完成后，让快慢指针一起走， 直到快指针走到最后一个，
         * 那么慢指针指向的就是倒数第k个
         *
         * @param head
         * @param k
         * @return
         */
        public ListNode getKthFromEnd2(ListNode head, int k) {

            ListNode first = head;
            ListNode second = head;

            for (int i = 0; i < k; i++) {
                second = second.next;
            }

            while (second != null) {
                first = first.next;
                second = second.next;
            }


            return first;
        }
    }
}
