package com.fox.algorithm.数据结构与算法.leetcode.栈_队列

import com.fox.algorithm.数据结构与算法.leetcode.二叉树.TreeNode
import java.util.*

/**
 * @Author fox.hu
 * @Date 2021/2/18 16:28
 */
/*https://leetcode-cn.com/problems/maximum-binary-tree
给定一个不含重复元素的整数数组 nums 。一个以此数组直接递归构建的 最大二叉树 定义如下：
二叉树的根是数组 nums 中的最大元素。
左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。
右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。
返回有给定数组 nums 构建的 最大二叉树 。

输入：nums = [3,2,1,6,0,5]
输出：[6,3,5,null,2,0,null,null,1]
解释：递归调用如下所示：
- [3,2,1,6,0,5] 中的最大值是 6 ，左边部分是 [3,2,1] ，右边部分是 [0,5] 。
- [3,2,1] 中的最大值是 3 ，左边部分是 [] ，右边部分是 [2,1] 。
- 空数组，无子节点。
- [2,1] 中的最大值是 2 ，左边部分是 [] ，右边部分是 [1] 。
- 空数组，无子节点。
- 只有一个元素，所以子节点是一个值为 1 的节点。
- [0,5] 中的最大值是 5 ，左边部分是 [0] ，右边部分是 [] 。
- 只有一个元素，所以子节点是一个值为 0 的节点。
- 空数组，无子节点。

提示：
1 <= nums.length <= 1000
0 <= nums[i] <= 1000
nums 中的所有整数 互不相同
*/

//使用递归的方式来完成
fun constructMaximumBinaryTree(nums: IntArray): TreeNode? {
    return findRoot(nums, 0, nums.size)
}

/**
 *  找出[l,r)之间的根节点
 */
private fun findRoot(nums: IntArray, l: Int, r: Int): TreeNode? {
    if (l == r) return null
    var maxIndex = l

    for (i in l + 1 until r) {
        if (nums[i] > nums[maxIndex]) {
            maxIndex = i
        }
    }

    val root = TreeNode(nums[maxIndex])
    root.left = findRoot(nums, l, maxIndex)
    root.right = findRoot(nums, maxIndex + 1, r)
    return root
}

//变种 返回一个数组 这个数组代表着这个二叉树
//这个数组存储的是其根节点的索引 即min{左边第一个比此节点大,右边第一个比此节点大}的值的索引值
//使用一个栈 保持栈从栈底到栈顶是单调递减的  则
//入栈操作 代表栈顶节点是首个左边比入栈节点大的值
//出栈操作 代表入栈节点是首个右边比栈顶节点大的值
fun constructMaximumBinaryTreeByStack(nums: IntArray): IntArray? {
    //扫描一遍所有的数组
    //保持栈从栈底到栈顶是单调递减的
    if (nums.isEmpty()) return null
    val lis = IntArray(nums.size)
    val ris = IntArray(nums.size)
    val pis = IntArray(nums.size)
    val stack = Stack<Int>()

    for (i in nums.indices) {
        lis[i] = -1
        ris[i] = -1

        while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
            ris[stack.pop()] = i
        }
        lis[i] = if (stack.isEmpty()) -1 else stack.peek()
        stack.push(i)
    }

    //比较lis和ris中 索引 指向的位置那个小 取哪个
    for (i in nums.indices) {
        pis[i] = when {
            (lis[i] == -1 && ris[i] == -1) -> -1
            (lis[i] == -1) -> ris[i]
            (ris[i] == -1) -> lis[i]
            else -> if (nums[lis[i]] < nums[ris[i]]) lis[i] else ris[i]
        }
    }
    return pis
}

fun main() {
    println(constructMaximumBinaryTreeByStack(intArrayOf(3, 2, 1, 6, 0, 5)))
}
