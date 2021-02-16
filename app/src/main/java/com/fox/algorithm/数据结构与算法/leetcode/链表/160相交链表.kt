package com.fox.algorithm.数据结构与算法.leetcode.链表

import java.util.HashSet

/**
 * @Author Fox
 * @Date 2021/2/16 12:01
 */

/*https://leetcode-cn.com/problems/intersection-of-two-linked-lists
编写一个程序，找到两个单链表相交的起始节点。
如下面的两个链表：
输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
输出：Reference of the node with value = 8
输入解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。

注意：
如果两个链表没有交点，返回 null.
在返回结果后，两个链表仍须保持原有的结构。
可假定整个链表结构中没有循环。
程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 */

/*将两个链表拼到一起 再遍历*/
fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
    if (headA == null || headB == null) return null
    var curA = headA
    var curB = headB
    //如果遍历完了A，则将B的头部接上去再遍历，
    //B也是同样的操作 达到拼接链表的目的 最终跳出循环的时候就是相交的节点
    while (curA != curB) {
        curA = if (curA == null) headB else curA.next
        curB = if (curB == null) headA else curB.next
    }
    //下面的代码会死循环 注意
    /* while (curA != curB) {
         curA = curA?.next ?: headB
         curB = curB?.next ?: headA
     }*/
    return curA
}

// 题设中 相交是基于节点的引用 而不是节点的值
// 1.利用set来辅助 如果两个链表相交 则hashSet中的引用是相同的
fun getIntersectionNode1(headA: ListNode?, headB: ListNode?): ListNode? {
    var headATemp = headA
    var headBTemp = headB
    if (headA == null || headB == null) {
        return null
    }
    val set: MutableSet<ListNode> = HashSet()
    while (headATemp != null) {
        set.add(headATemp)
        headATemp = headATemp.next
    }
    while (headBTemp != null) {
        if (set.contains(headBTemp)) {
            return headBTemp
        }
        headBTemp = headBTemp.next
    }
    return null
}