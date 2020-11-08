package com.fox.algorithm.程序员面试金典._02链表

/**
 * @Author Fox
 * @Date 2020/10/29 20:18
 */
//链接：https://leetcode-cn.com/problems/remove-duplicate-node-lcci
//编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
//示例1:
// 输入：[1, 2, 3, 3, 2, 1]
// 输出：[1, 2, 3]

//示例2:
// 输入：[1, 1, 1, 1, 2]
// 输出：[1, 2]
//提示：
//
//链表长度在[0, 20000]范围内。
//链表元素在[0, 20000]范围内。

//进阶：
//如果不得使用临时缓冲区，该怎么解决？

class _0201_移除重复节点 {
    fun removeDuplicateNodes(node: ListNode?): ListNode? {
        //采用一个hashset来进行去重
        //遍历这个链表 如果set中没有此节点 则移动到next节点
        //如果set中有此节点 则跳过next节点，移动到next.next节点
        val set = hashSetOf<Int>()
        var current = node
        while (current?.next != null) {
            set.add(current.`val`)
            if (set.contains(current.next!!.`val`)) {
                current.next = current.next!!.next
            } else {
                current = current.next
            }
        }
        return node
    }
}
