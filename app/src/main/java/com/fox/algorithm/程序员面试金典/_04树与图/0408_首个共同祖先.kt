package com.fox.algorithm.程序员面试金典._04树与图

/**
 * @Author Fox
 * @Date 2020/11/19 21:37
 */
/*链接：https://leetcode-cn.com/problems/first-common-ancestor-lcci
设计并实现一个算法，找出二叉树中某两个节点的第一个共同祖先。不得将其他的节点存储在另外的数据结构中。注意：这不一定是二叉搜索树。
例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4]
    3
   / \
  5   1
 / \ / \
6  2 0  8
  / \
 7   4
示例 1:                                                         示例 2:
输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1        输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
输出: 3                                                         输出: 5
解释: 节点 5 和节点 1 的最近公共祖先是节点 3。                     解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身
说明:所有节点的值都是唯一的。p、q 为不同节点且均存在于给定的二叉树中。*/

//递归的解法
fun lowestCommonAncestor(root: TreeNode?, p: TreeNode, q: TreeNode): TreeNode? {
    if (root == null || root == p || root == q) {
        return root
    }
    val left = lowestCommonAncestor(root.left, p, q)
    val right = lowestCommonAncestor(root.right, p, q)

    //如果left为空，说明这两个节点在cur结点的右子树上，我们只需要返回右子树查找的结果即可
    if (left == null) {
        return right
    }

    //同上
    return if (right == null) {
        left
    } else root
    //当root == p或者root== q时返回root
    //如果left和right都不为空，说明这两个节点一个在cur的左子树上一个在cur的右子树上，
    //我们只需要返回cur结点即可。
}