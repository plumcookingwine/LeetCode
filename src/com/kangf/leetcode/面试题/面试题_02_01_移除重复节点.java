package com.kangf.leetcode.面试题;

import com.kangf.leetcode.GeneratorNode;
import com.kangf.leetcode.ListNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 *
 * 示例1:
 *
 *  输入：[1, 2, 3, 3, 2, 1]
 *  输出：[1, 2, 3]
 * 示例2:
 *
 *  输入：[1, 1, 1, 1, 2]
 *  输出：[1, 2]
 * 提示：
 *
 * 链表长度在[0, 20000]范围内。
 * 链表元素在[0, 20000]范围内。
 * 进阶：
 *
 * 如果不得使用临时缓冲区，该怎么解决？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicate-node-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 面试题_02_01_移除重复节点 {

    public static void main(String[] args) {

        ListNode node = GeneratorNode.getListNode(1, 1, 2, 2, 3, 3, 4, 1, 1);
        System.out.println(new Solution().removeDuplicateNodes(node));
    }

    private static class Solution {

        public ListNode removeDuplicateNodes1(ListNode head) {
            ListNode slow = head;


            while (slow != null) {

                ListNode fast = slow;

                while (fast.next != null) {

                    if (slow.val == fast.next.val) {
                        fast.next = fast.next.next;
                    } else {
                        fast = fast.next;
                    }

                }
                slow = slow.next;

            }

            return head;
        }

        public ListNode removeDuplicateNodes2(ListNode head) {

            List<Integer> list = new ArrayList<>();

            while (head != null) {
                if (!list.contains(head.val)) {
                    list.add(head.val);
                }
                head = head.next;
            }

            ListNode node = null;
            ListNode tail = null;

            for (Integer integer : list) {
                if (node == null) {
                    node = new ListNode(integer);
                    tail = node;
                } else {
                    tail.next = new ListNode(integer);
                    tail = tail.next;
                }
            }
            return node;

        }

        public ListNode removeDuplicateNodes(ListNode head) {
            if (head == null) return null;
            HashSet<Integer> set = new HashSet<>();
            set.add(head.val);
            ListNode node = head;
            while (node.next != null) {
                ListNode cur = node.next;
                if (set.add(cur.val)) {
                    node = node.next;
                } else {
                    node.next = node.next.next;
                }
            }
            return head;
        }
    }
}
