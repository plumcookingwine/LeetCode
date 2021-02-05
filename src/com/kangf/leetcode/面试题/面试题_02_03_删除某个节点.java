package com.kangf.leetcode.面试题;

import com.kangf.leetcode.GeneratorNode;
import com.kangf.leetcode.ListNode;

/**
 * 面试题 02.03. 删除中间节点
 * 实现一种算法，删除单向链表中间的某个节点（即不是第一个或最后一个节点），假定你只能访问该节点。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：单向链表a->b->c->d->e->f中的节点c
 * 结果：不返回任何数据，但该链表变为a->b->d->e->f
 */
public class 面试题_02_03_删除某个节点 {


    public static void main(String[] args) {

        ListNode node = GeneratorNode.getListNode(1, 2, 3, 4, 5, 6);
        new Solution().deleteNode(node);
    }


    private static class Solution {
        public void deleteNode(ListNode node) {

            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}
