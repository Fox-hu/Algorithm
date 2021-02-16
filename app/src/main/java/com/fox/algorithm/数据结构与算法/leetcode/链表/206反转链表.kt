package com.fox.algorithm.数据结构与算法.leetcode.链表

/**
 * @Author fox
 * @Date 2020/2/18 19:53
 */

/*https://leetcode-cn.com/problems/reverse-linked-list/
反转一个单链表。
示例:
输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
进阶:
你可以迭代或递归地反转链表。你能否用两种方法解决这道题？*/

//使用递归的方式
fun reverseList(head: ListNode?): ListNode? {
    if (head?.next == null) {
        return head
    }
    val newHead = reverseList(head.next)
    head.next!!.next = head
    head.next = null
    return newHead
}

//使用循环的方式
fun reverseList1(head: ListNode?): ListNode? {
    var headTemp = head
    if (headTemp?.next == null) {
        return headTemp
    }
    var newHead: ListNode? = null
    while (headTemp != null) {
        val temp = headTemp.next
        headTemp.next = newHead
        newHead = headTemp
        headTemp = temp
    }
    return newHead
}
