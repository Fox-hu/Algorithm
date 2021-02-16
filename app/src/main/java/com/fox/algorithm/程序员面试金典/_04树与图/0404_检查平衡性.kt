package com.fox.algorithm.程序员面试金典._04树与图

/**
 * @Author Fox
 * @Date 2020/11/17 21:08
 */
/*链接：https://leetcode-cn.com/problems/check-balance-lcci
实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。
示例 1:
给定二叉树 [3,9,20,null,null,15,7]
    3
   / \
  9  20
    /  \
   15   7
返回 true

示例 2:
给定二叉树 [1,2,2,3,3,null,null,4,4]
      1
     / \
    2   2
   / \
  3   3
 / \
4   4
返回 false*/


//使用递归的方式 对每个节点的左右子树进行遍历
//递归的比较子树的高度
fun isBalanced(root: TreeNode?): Boolean {
    if (root == null) return true

    val leftTreeDepth = treeDepth(root.left)
    val rightTreeDepth = treeDepth(root.right)

    if (Math.abs(leftTreeDepth - rightTreeDepth) > 1) {
        return false
    }
    //若以当前节点为根的子树是平衡的，继续递归检查它左右子树的平衡性
    return isBalanced(root.left) && isBalanced(root.right)
}

private fun treeDepth(node: TreeNode?): Int {
    if (node == null) return 0
    // 当前二叉树的高度 = max(左子树高度,右子树高度) + 1
    return Math.max(treeDepth(node.right), treeDepth(node.left)) + 1
}
