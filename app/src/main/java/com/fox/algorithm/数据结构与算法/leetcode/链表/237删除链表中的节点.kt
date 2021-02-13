package com.fox.algorithm.数据结构与算法.leetcode.链表

/**
 * @Author fox
 * @Date 2020/2/18 19:33
 */

fun deleteNode(node: ListNode) {
    node.`val` = node.next!!.`val`
    node.next = node.next!!.next
}
