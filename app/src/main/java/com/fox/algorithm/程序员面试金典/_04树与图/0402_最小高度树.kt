package com.fox.algorithm.程序员面试金典._04树与图

import java.util.*

/**
 * @Author Fox
 * @Date 2020/11/12 21:43
 */

/*链接：https://leetcode-cn.com/problems/minimum-height-tree-lcci
给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树
示例:
给定有序数组: [-10,-3,0,5,9],
一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
          0
         / \
       -3   9
       /   /
     -10  5*/


//采用递归的方式进行 同二分法
fun sortedArrayToBST(nums: IntArray): TreeNode? {
    if (nums.isEmpty()) return null
    val root = TreeNode(nums[nums.size / 2])
    root.left = sortedArrayToBST(nums.copyOfRange(0, nums.size / 2))
    root.right = sortedArrayToBST(nums.copyOfRange(nums.size / 2 + 1, nums.size))
    return root
}
