package com.fox.algorithm.程序员面试金典._02链表

/**
 * @Author fox.hu
 * @Date 2020/10/30 14:27
 */
//链接：https://leetcode-cn.com/problems/sum-lists-lcci
//给定两个用链表表示的整数，每个节点包含一个数位。
//这些数位是反向存放的，也就是个位排在链表首部。
//编写函数对这两个整数求和，并用链表形式返回结果。
//示例：
//输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
//输出：2 -> 1 -> 9，即912

//进阶：思考一下，假设这些数位是正向存放的，又该如何解决呢?
//
//示例：
//输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
//输出：9 -> 1 -> 2，即912
class _0205_链表求和 {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var p1 = l1
        var p2 = l2
        var result = ListNode(0)
        var p = result
        var carr = 0

        while (p1 != null || p2 != null || carr > 0) {
            var sum = carr
            sum += p1?.`val` ?: 0
            sum += p2?.`val` ?: 0

            p.next = ListNode(sum % 10)
            p = p.next!!

            carr = sum / 10

            if (p1 != null) {
                p1 = p1.next
            }

            if (p2 != null) {
                p2 = p2.next
            }
        }
        return result.next
    }
}