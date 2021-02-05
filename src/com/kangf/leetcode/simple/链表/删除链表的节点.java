package com.kangf.leetcode.simple.链表;

import com.kangf.leetcode.GeneratorNode;
import com.kangf.leetcode.ListNode;

/**
 * 剑指 Offer 18. 删除链表的节点
 * <p>
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 * 注意：此题对比原题有改动
 * <p>
 * 示例 1:
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为5的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * <p>
 * 示例 2:
 * 输入: head = [4,5,1,9], val = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为1的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 删除链表的节点 {

    public static void main(String[] args) {
        ListNode node = GeneratorNode.getListNode(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println(new Solution().deleteNode(node, 1));
    }

    private static class Solution {

        /**
         * 0ms    ------ 100%
         * 37.7------- 98.5%
         * @param head
         * @param val
         * @return
         */
        public ListNode deleteNode(ListNode head, int val) {
            if (head == null) return null;
            if (head.next == null) {
                if (head.val == val) return null;
                else return head;
            }


            ListNode slow = head;
            ListNode fast = head.next;

            // 如果第一个就是要删除的节点，那么直接改变其指向即可
            if(slow.val == val) {
                slow.val = slow.next.val;
                slow.next = slow.next.next;
                return head;
            }

            while (fast != null && fast.val != val) {
                fast = fast.next;
                slow = slow.next;
            }

            if(fast == null) {
                slow.next = null;
            } else {
                slow.next = fast.next;
            }
            return head;


        }
    }

}
