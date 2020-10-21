package com.kangf.leetcode.simple.链表;

public class 找到两个单链表相交的起始节点 {
    public static void main(String[] args) {
        ListNode nodeA = GeneratorNode.getListNode(0, 9, 1, 2, 4);
        ListNode nodeB = GeneratorNode.getListNode(3, 2, 4);
        ListNode n = new Solution().getIntersectionNode2(nodeA, nodeB);

        System.out.println(n.toString());
    }

    private static class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            int aLen = getLength(headA);
            int bLen = getLength(headB);

            if (aLen < bLen) {
                int count = bLen - aLen;
                while (count-- > 0) {
                    headB = headB.next;
                }
            }
            if (aLen > bLen) {
                int count = aLen - bLen;
                while (count-- > 0) {
                    headA = headA.next;
                }
            }

            while (headA != null) {
                if (headA.val == headB.val) {
                    break;
                }
                headA = headA.next;
                headB = headB.next;
            }

            return headA;
        }


        public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {

            ListNode pA = headA;
            ListNode pB = headB;

            while (pA != pB) {

                if (pA != null) pA = pA.next;
                else pA = headB;

                if (pB != null) pB = pB.next;
                else pB = pA;
            }

            return pA;


        }

        private int getLength(ListNode node) {
            int len = 0;
            while (node != null) {
                len++;
                node = node.next;
            }
            return len;
        }
    }
}
