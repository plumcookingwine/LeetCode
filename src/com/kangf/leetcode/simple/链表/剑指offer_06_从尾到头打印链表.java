package com.kangf.leetcode.simple.链表;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 * 示例 1：
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * <p>
 * 限制：
 * 0 <= 链表长度 <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 剑指offer_06_从尾到头打印链表 {

    public static void main(String[] args) {
        ListNode node = GeneratorNode.getListNode(1, 3, 4, 5, 6, 7, 9);

        int[] arr = new Solution().reversePrint2(node);

        System.out.println(Arrays.toString(arr));
    }

    private static class Solution {

        /**
         * 0 ms    -------->100.00%
         * 39.2 MB -------->85.37%
         *
         * @param head
         * @return
         */
        public int[] reversePrint(ListNode head) {
            int length = 0;
            ListNode l = head;
            while (l != null) {
                length++;
                l = l.next;
            }

            int[] a = new int[length];
            while (head != null) {
                a[--length] = head.val;
                head = head.next;
            }

            return a;
        }


        /**
         *
         * @param head
         * @return
         */
        public int[] reversePrint2(ListNode head) {

            Deque<Integer> deque = new LinkedList<>();
            while (head != null) {
                deque.push(head.val);
                head = head.next;
            }

            int[] a = new int[deque.size()];
            int i = 0;

            while (!deque.isEmpty()) {
                a[i] = deque.pop();
                i++;
            }
            return a;
        }

    }
}
