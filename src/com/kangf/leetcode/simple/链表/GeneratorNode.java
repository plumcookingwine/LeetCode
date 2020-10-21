package com.kangf.leetcode.simple.链表;

/**
 * 为了方便测试，
 * 快速生成链表
 */
public class GeneratorNode {

    public static ListNode getListNode(int... val) {
        ListNode head = null, tailer = null;
        ListNode newNode;

        for (int i : val) {
            newNode = new ListNode(i);
            if (head == null) {
                head = tailer = newNode;
            } else {
                tailer = tailer.next = newNode;
            }
        }
        return head;
    }
}
