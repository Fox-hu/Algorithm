package com.fox.algorithm.程序员面试金典._04树与图

import com.fox.algorithm.程序员面试金典._02链表.ListNode
import java.util.*

/**
 * @Author Fox
 * @Date 2020/11/16 21:59
 */
/*链接：https://leetcode-cn.com/problems/list-of-depth-lcci
给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
示例：

输入：[1,2,3,4,5,null,7,8]

        1
       /  \
      2    3
     / \    \
    4   5    7
   /
  8

输出：[[1],[2,3],[4,5,7],[8]]*/

//采用层序遍历的变种
//每次遍历一层 都将这层元素的左右元素放入待遍历的队列中
fun listOfDepth(tree: TreeNode?): Array<ListNode?> {
    val queue = LinkedList<TreeNode?>()
    queue.offer(tree)
    val res: MutableList<ListNode?> = ArrayList()
    val dummy = ListNode(0)
    while (!queue.isEmpty()) {
        val size = queue.size
        var curr: ListNode? = dummy
        for (i in 0 until size) {
            val treeNode = queue.poll()
            curr!!.next = ListNode(treeNode!!.`val`)
            if (treeNode.left != null) {
                queue.offer(treeNode.left)
            }
            if (treeNode.right != null) {
                queue.offer(treeNode.right)
            }
            curr = curr.next
        }
        res.add(dummy.next)
        dummy.next = null
    }
    return res.toTypedArray()
}
