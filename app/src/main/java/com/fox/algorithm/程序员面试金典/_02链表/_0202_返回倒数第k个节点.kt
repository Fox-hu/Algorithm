package com.fox.algorithm.程序员面试金典._02链表

/**
 * @Author Fox
 * @Date 2020/10/29 21:00
 */
//链接：https://leetcode-cn.com/problems/kth-node-from-end-of-list-lcci
//实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
//注意：本题相对原题稍作改动
//示例：
//输入： 1->2->3->4->5 和 k = 2
//输出： 4
//说明：
//
//给定的 k 保证是有效的。
class _0202_返回倒数第k个节点 {

    //遍历链表转换为数组 获取倒数k的节点
    fun kthToLast(head: ListNode?, k: Int): Int {
        var node = head
        val list = arrayListOf<Int>()
        while (node != null) {
            list.add(node.`val`)
            node = node.next
        }
        return list[list.size - k]
    }

    //双指针 初始时，两个指针均指向 head。
    //先将 q 向后移动 k 次。此时p，q的距离为 k。
    //同时移动 p，q, 直到 q 指向 nullptr。此时p->val即为答案。
    fun kthToLast1(head: ListNode?, k: Int): Int {
        var node = head
        var p = head

        for (i in 0 until k) {
            p = p?.next
        }

        while (p != null) {
            p = p.next
            node = node?.next
        }

        return node!!.`val`
    }

}