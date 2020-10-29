package com.kangf.leetcode.simple.树;

import java.util.LinkedList;

public class 树的遍历 {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        TreeNode tree = GeneratorTreeNode.getTreeNode(list);
        前序遍历(tree);
    }


    public static void 前序遍历(TreeNode tree) {
        if (tree == null) {
            return;
        }

        System.out.println(tree.val + " ");

        前序遍历(tree.left);
        前序遍历(tree.right);
    }


    public static void 中序遍历(TreeNode tree) {
        if (tree == null) {
            return;
        }

        System.out.println(tree.val + " ");

        前序遍历(tree.left);
        前序遍历(tree.right);
    }
}
