package com.kangf.leetcode.simple.链表;

public class ListNode {

    int val;

    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public void print() {
        ListNode node = this;
        while (node != null) {
            System.out.print(node.val + "   ");
            node = node.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        ListNode node = this;
        while (node != null) {
            str.append(node.val).append("   ");
            node = node.next;
        }

        return str.toString();
    }
}
