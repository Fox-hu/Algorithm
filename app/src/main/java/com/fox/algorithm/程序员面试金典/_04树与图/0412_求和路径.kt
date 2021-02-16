package com.fox.algorithm.程序员面试金典._04树与图

/**
 * @Author fox.hu
 * @Date 2020/11/26 15:03
 */
/*链接：https://leetcode-cn.com/problems/paths-with-sum-lcci
给定一棵二叉树，其中每个节点都含有一个整数数值(该值或正或负)。
设计一个算法，打印节点数值总和等于某个给定值的所有路径的数量。
注意，路径不一定非得从二叉树的根节点或叶节点开始或结束，但是其方向必须向下(只能从父节点指向子节点方向)。
示例:
给定如下二叉树，以及目标和 sum = 22，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
返回: 3
解释：和为 22 的路径有：[5,4,11,2], [5,8,4,5], [4,11,7]
提示： 节点总数 <= 10000*/

//代表共有几条路径
var ret = 0

//双dfs解法
fun pathSum(root: TreeNode?, sum: Int): Int {
    preOrder(root, sum)
    return ret
}

//每个节点都要以自身为根节点 再进行深度遍历 找出和为sum的路径
private fun preOrder(root: TreeNode?, sum: Int) {
    if (root == null) return
    dfs(root, sum)
    preOrder(root.left, sum)
    preOrder(root.right, sum)
}

//采用dfs找出和为sum的路径 将sum-root的值带入下次递归中
private fun dfs(root: TreeNode?, sum: Int) {
    if (root == null) return
    if (sum == root.`val`) ret++
    dfs(root.left, sum - root.`val`)
    dfs(root.right, sum - root.`val`)
}