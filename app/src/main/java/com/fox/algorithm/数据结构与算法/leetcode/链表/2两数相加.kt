package com.fox.algorithm.数据结构与算法.面试.链表

import com.fox.algorithm.数据结构与算法.leetcode.链表.ListNode

/**
 * @Author Fox
 * @Date 2021/2/13 21:07
 */

/*https://leetcode-cn.com/problems/add-two-numbers
给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
请你将两个数相加，并以相同形式返回一个表示和的链表。
你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
输入：l1 = [2,4,3], l2 = [5,6,4]
输出：[7,0,8]
解释：342 + 465 = 807.

示例 2：
输入：l1 = [0], l2 = [0]
输出：[0]

示例 3：
输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
输出：[8,9,9,9,0,0,0,1]
提示：
每个链表中的节点数在范围 [1, 100] 内,0 <= Node.val <= 9 题目数据保证列表表示的数字不含前导零
 */

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    if (l1 == null) return l2
    if (l2 == null) return l1

    val dummyHead = ListNode(0)
    var last = dummyHead
    var l1Temp: ListNode? = l1
    var l2Temp: ListNode? = l2
    var carry = 0
    while (l1Temp != null || l2Temp != null) {
        val v1 = l1Temp?.`val` ?: 0
        val v2 = l2Temp?.`val` ?: 0
        val sum = v1 + v2 + carry
        //设置进位值
        carry = sum / 10
        //sum的个位数作为新节点的值
        last.next = ListNode(sum % 10)
        last = last.next!!
        l1Temp = l1Temp?.next
        l2Temp = l2Temp?.next
    }

    //最后的进位别忘了
    if (carry > 0) {
        last.next = ListNode(1)
    }
    return dummyHead.next
}