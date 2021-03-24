package com.fox.algorithm.数据结构与算法.leetcode.链表

/**
 * @Author Fox
 * @Date 2021/3/18 10:30
 */
/*https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    if (l1 == null) return l2
    if (l2 == null) return l1

    val preHead = ListNode(-1)
    var pre = preHead

    var temp1 = l1
    var temp2 = l2
    while (temp1 != null && temp2 != null) {
        if (temp1.`val` <= temp2.`val`) {
            pre.next = temp1
            temp1 = temp1.next
        } else {
            pre.next = temp2
            temp2 = temp2.next
        }
        //这个不能忘
        pre = pre.next!!
    }
    pre.next = temp1 ?: temp2
    return preHead.next
}