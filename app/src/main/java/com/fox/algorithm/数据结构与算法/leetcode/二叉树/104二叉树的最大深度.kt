package com.fox.algorithm.数据结构与算法.leetcode.二叉树

/**
 * @Author Fox
 * @Date 2021/3/18 11:56
 */
/*https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
给定一个二叉树，找出其最大深度。
二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
说明: 叶子节点是指没有子节点的节点
 */
fun maxDepth(root: TreeNode?): Int {
    if (root == null) return 0
    val leftHeight = maxDepth(root.left)
    val rightHeight = maxDepth(root.right)
    return Math.max(leftHeight, rightHeight) + 1
}