package com.fox.algorithm.数据结构与算法.leetcode.二叉树

/**
 * @Author Fox
 * @Date 2021/3/20 14:46
 */
/*https://leetcode-cn.com/problems/symmetric-tree/
给定一个二叉树，检查它是否是镜像对称的。
例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 */

fun isSymmetric(root: TreeNode?): Boolean {
    return check(root, root)
}

fun check(p: TreeNode?, q: TreeNode?): Boolean {
    if (p == null && q == null) return true
    if (p == null || q == null) return false
    return p.`val` == q.`val` && check(p.left, q.right) && check(p.right, q.left)
}