package com.kangf.leetcode.simple.链表;

import com.kangf.leetcode.GeneratorNode;
import com.kangf.leetcode.ListNode;

/**
 * 给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
 * <p>
 * 请你返回该链表所表示数字的 十进制值 。
 * <p>
 * <p>
 * 输入：head = [1,0,1]
 * 输出：5
 * 解释：二进制数 (101) 转化为十进制数 (5)
 * <p>
 * <p>
 * 输入：head = [0]
 * 输出：0
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-binary-number-in-a-linked-list-to-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _1290_二进制链表转整数 {

    public static void main(String[] args) {
        ListNode node = GeneratorNode.getListNode(0, 0, 1, 0, 1, 0, 1, 0);
        System.out.println(new Solution().getDecimalValue2(node));
    }

    private static class Solution {

        public int getDecimalValue2(ListNode head) {

            int sum = 0;

            while (head != null) {
                sum = sum * 2 + head.val;
                System.out.println("sum == " + sum);
                head = head.next;
            }
            return sum;

        }

        public int getDecimalValue(ListNode head) {

            int length = getNodeLength(head);

            int sum = 0;

            while (length > 0) {

                length--;

                int curVal = head.val;

                if (curVal != 0) {
                    sum += getPower(2, length);
                }
                head = head.next;


            }

            return sum;

        }

        private int getPower(int num, int power) {
            if (num == 0) return 0;
            if (power == 0) return 1;

            int a = num;
            while (power > 1) {
                a *= num;
                power--;
            }
            return a;
        }

        private int getNodeLength(ListNode node) {
            int l = 0;

            while (node != null) {
                node = node.next;
                l++;
            }

            return l;
        }
    }
}
