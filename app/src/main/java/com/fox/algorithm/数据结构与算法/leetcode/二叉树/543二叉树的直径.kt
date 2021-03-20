package com.fox.algorithm.数据结构与算法.leetcode.二叉树

/**
 * @Author Fox
 * @Date 2021/3/20 15:35
 */
/*
给定一棵二叉树，你需要计算它的直径长度。
一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
示例 :
给定二叉树
          1
         / \
        2   3
       / \
      4   5
返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 */
class Solution {
    var ans = 0
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        depth(root)
        return ans
    }

    fun depth(root: TreeNode?): Int {
        if (root == null) return 0
        val left = depth(root.left)
        val right = depth(root.right)
        ans = Math.max(left + right, ans)
        return Math.max(left, right) + 1
    }
}
