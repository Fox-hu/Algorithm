package com.fox.algorithm.数据结构与算法.leetcode.链表

/**
 * @Author Fox
 * @Date 2021/3/21 11:55
 */
/*https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
输入一个链表，输出该链表中倒数第k个节点。
为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
给定一个链表: 1->2->3->4->5, 和 k = 2.
返回链表 4->5.
 */

/*
初始化： 前指针 former 、后指针 latter ，双指针都指向头节点 head​ 。
构建双指针距离： 前指针 former 先向前走 k 步（结束后，双指针 former 和 latter 间相距 k 步）。
双指针共同移动： 循环中，双指针 former 和 latter 每轮都向前走一步，直至 former 走过链表 尾节点 时跳出
（跳出后， latter 与尾节点距离为 k−1，即 latter 指向倒数第 k 个节点）。
返回值： 返回 latter 即可
 */
fun getKthFromEnd(head: ListNode?, k: Int): ListNode? {
    if (head == null) return null
    var former = head
    var latter = head

    //构造步数差距
    for (i in 0 until k) {
        former = former?.next
    }

    //当former走完之后 latter就是所需要的
    while (former != null) {
        former = former.next
        latter = latter?.next
    }
    return latter
}