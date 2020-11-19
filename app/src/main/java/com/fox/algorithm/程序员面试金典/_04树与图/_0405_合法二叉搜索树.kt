package com.fox.algorithm.程序员面试金典._04树与图

/**
 * @Author Fox
 * @Date 2020/11/17 21:40
 */
//链接：https://leetcode-cn.com/problems/legal-binary-search-tree-lcci
//实现一个函数，检查一棵二叉树是否为二叉搜索树。
//
//示例 1:
//输入:
//    2
//   / \
//  1   3
//输出: true
//示例 2:
//输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
class _0405_合法二叉搜索树 {

    // 带区间的递归
    // 左树的区间在最小值和 root.val之间
    // 右树的区间在 root.val和最大值之间
    fun isValidBST(root: TreeNode?): Boolean {
        if (root == null) return true

        return isValidBSTHelp(root.left, Long.MIN_VALUE, root.`val`.toLong())
                && isValidBSTHelp(root.right, root.`val`.toLong(), Long.MAX_VALUE)
    }

    private fun isValidBSTHelp(node: TreeNode?, minValue: Long, maxValue: Long): Boolean {
        if (node == null) return true

        if (node.`val` <= minValue || node.`val` >= maxValue) return false

        val left = isValidBSTHelp(node.left, minValue, node.`val`.toLong())
        val right = isValidBSTHelp(node.right, node.`val`.toLong(), maxValue)
        return left && right
    }
}