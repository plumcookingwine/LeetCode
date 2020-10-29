package com.kangf.leetcode.simple.树;


import java.util.LinkedList;

public class GeneratorTreeNode {

    public static TreeNode getTreeNode(LinkedList<Integer> list) {
        TreeNode node = null;
        if (list == null || list.isEmpty()) {
            return null;
        }
        Integer data = list.removeFirst();
        if (data != null) {
            node = new TreeNode(data);
            node.left = getTreeNode(list);
            node.right = getTreeNode(list);
        }
        return node;
    }
}
