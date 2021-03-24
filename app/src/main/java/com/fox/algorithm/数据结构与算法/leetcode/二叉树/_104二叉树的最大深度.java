package com.fox.algorithm.数据结构与算法.leetcode.二叉树;

/**
 * @Author Fox
 * @Date 2021/3/24 21:11
 */

/*https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
给定一个二叉树，找出其最大深度。
二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
说明: 叶子节点是指没有子节点的节点
 */

class _104二叉树的最大深度 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
