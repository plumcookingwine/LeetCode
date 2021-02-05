package com.kangf.leetcode.simple.链表;

import com.kangf.leetcode.GeneratorNode;
import com.kangf.leetcode.ListNode;

import java.util.*;

/**
 * 编写一个函数，检查输入的链表是否是回文的。
 * <p>
 * 例 1：
 * <p>
 * 输入： 1->2
 * 输出： false
 * 示例 2：
 * <p>
 * 输入： 1->2->2->1
 * 输出： true
 */
public class 面试题_0206_回文链表 {

    public static void main(String[] args) {
        ListNode node = GeneratorNode.getListNode(1, 2, 3, 3, 2, 1);

        System.out.println("isPalindrome === " + new Solution().isPalindrome2(node));
    }


    private static class Solution {

        public boolean isPalindrome2(ListNode head) {

            List<Integer> list = new ArrayList<>();
            while (head != null) {
                list.add(head.val);
                head = head.next;
            }

            int first = 0;
            int last = list.size() - 1;

            while (first <= last) {

                if (!list.get(first).equals(list.get(last))) {
                    return false;
                }
                first++;
                last--;
            }

            return true;

        }


        public boolean isPalindrome(ListNode head) {

            ListNode slow = head;
            ListNode fast = head;

            ListNode tmp = null;

            //  1,2,3,4,5,6,7,6,5,4,3,2,1

            while (fast != null) {

                if (fast.next == null) {
                    break;
                }

                ListNode node = new ListNode(slow.val);
                node.next = tmp;
                tmp = node;

                slow = slow.next;
                fast = fast.next.next;

            }


            if (!getIsOod(head) && slow != null) {
                // 如果长度为奇数，就从下一个开始比较
                slow = slow.next;
            }

            System.out.println("tmp == " + tmp);
            System.out.println("slow == " + slow);

            while (slow != null) {


                if (tmp == null || tmp.val != slow.val) {
                    return false;
                }
                slow = slow.next;
                tmp = tmp.next;
            }

            return true;

        }

        private boolean getIsOod(ListNode node) {
            int len = 0;
            while (node != null) {
                node = node.next;
                len++;
            }
            return len % 2 == 0;
        }
    }
}
