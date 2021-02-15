package com.fox.algorithm.数据结构与算法.leetcode.二叉树

/**
 * @Author fox
 * @Date 2020/3/3 17:59
 */

fun invertTree(root: TreeNode?): TreeNode? {
    if (root == null) {
        return null
    }
    val temp = root.left
    root.left = root.right
    root.right = temp
    invertTree(root.left)
    invertTree(root.right)
    return root
}
