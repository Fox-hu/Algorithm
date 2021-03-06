package com.fox.algorithm.程序员面试金典._04树与图

/**
 * @Author Fox
 * @Date 2020/11/19 21:01
 */
/*链接：https://leetcode-cn.com/problems/successor-lcci
设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
如果指定节点没有对应的“下一个”节点，则返回null。
示例 1:
输入: root = [2,1,3], p = 1
  2
 / \
1   3

输出: 2
示例 2:
输入: root = [5,3,6,2,4,null,null,1], p = 6

      5
     / \
    3   6
   / \
  2   4
 /
1

输出: null*/

/* 题目中是二叉搜索树 中序后继 所谓 p 的后继节点，就是这串升序数字中，比 p 大的下一个。
如果 p 大于等于当前节点的值，说明后继节点一定在 RightTree
如果 p 小于当前节点的值，说明后继节点一定在 LeftTree 或自己就是
使用递归实现:
- 如果根节点小于或等于要查找的节点p, 直接进入右子树递归
- 如果根节点大于要查找的节点, 则暂存左子树递归查找的结果,
- 如果是 null, 说明在该根节点的左子树中没找到比p大的节点，也就说明该根节点就是要找的p的后继，则直接返回当前根节点;
- 如果不是 null,说明找到了答案，返回左子树递归查找的结果*/
fun inorderSuccessor(root: TreeNode?, p: TreeNode?): TreeNode? {
    if (root == null || p == null) {
        return null
    }
    return if (p.`val` >= root.`val`) {
        inorderSuccessor(root.right, p)
    } else {
        val left = inorderSuccessor(root.left, p)
        left ?: root
    }
}