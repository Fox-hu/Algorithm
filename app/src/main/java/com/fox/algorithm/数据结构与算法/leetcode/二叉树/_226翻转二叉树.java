package com.fox.algorithm.数据结构与算法.leetcode.二叉树;

/**
 * @Author Fox
 * @Date 2021/3/24 20:38
 */
class _226翻转二叉树 {

    public TreeNode invertTree(TreeNode node) {
        if(node == null) return null;

        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

        invertTree(node.left);
        invertTree(node.right);
        return node;
    }
}
