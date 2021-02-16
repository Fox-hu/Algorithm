package com.fox.algorithm.数据结构与算法.leetcode.链表

/**
 * 判断一个链表中是否是有环形
 * @Author fox
 * @Date 2020/2/20 12:47
 */

/*https://leetcode-cn.com/problems/linked-list-cycle/
 *使用快慢指针 如果指针相遇 则说明有环
 */
fun hasCyCle(head: ListNode?): Boolean {
    if (head?.next == null) {
        return false
    }
    var slow = head
    var fast = head.next
    while (fast?.next != null) {
        if (slow === fast) {
            return true
        }
        slow = slow!!.next
        fast = fast.next!!.next
    }
    return false
}
