package com.kangf.leetcode.simple.链表;

import com.kangf.leetcode.GeneratorNode;
import com.kangf.leetcode.ListNode;

/**
 * 92. 反转链表 II
 * <p>
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 说明:
 * 1 ≤m≤n≤ 链表长度。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 反转链表2 {

    public static void main(String[] args) {

        ListNode l = GeneratorNode.getListNode(1, 2, 3, 4, 5, 6);
        System.out.println("reverse == " + new Solution().reverseBetween(l, 2, 5));
    }

    private static class Solution {
        public ListNode reverseBetween(ListNode head, int m, int n) {


            return null;
        }


    }

}
