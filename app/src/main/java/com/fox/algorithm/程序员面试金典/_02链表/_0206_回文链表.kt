package com.fox.algorithm.程序员面试金典._02链表

/**
 * @Author fox.hu
 * @Date 2020/10/30 15:13
 */
//编写一个函数，检查输入的链表是否是回文的。
//链接：https://leetcode-cn.com/problems/palindrome-linked-list-lcci
//示例 1：
//输入： 1->2
//输出： false

//示例 2：
//输入： 1->2->2->1
//输出： true

//进阶：
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
class _0206_回文链表 {

    //使用一个链表来完成
    fun isPalindrome(head: ListNode?): Boolean {
        val list = arrayListOf<Int>()
        var node = head
        while (node != null) {
            list.add(node.`val`)
            node = node.next
        }

        if (list.size == 0) return true

        for (i in 0..(list.size / 2)) {
            if (list[i] != list[list.size - 1 - i]) {
                return false
            }
        }
        return true
    }

    //使用快慢指针和反转链表来完成
    //思路在于 先找到链表的中点 将后部链表反转 与前部进行比较
    fun isPalindrome1(head: ListNode?): Boolean {

        //使用迭代进行链表逆序
        fun reverse(head: ListNode?): ListNode? {
            var pre: ListNode? = null
            var next: ListNode? = null
            var node = head
            while (node != null) {
                next = node.next
                node.next = pre
                pre = node
                node = next
            }
            return pre
        }

        //快慢指针找到中间节点
        var head1 = head
        val dummy = ListNode(0)
        dummy.next = head1
        var slow: ListNode? = dummy
        var fast: ListNode? = dummy
        while (fast?.next != null) {
            slow = slow!!.next
            fast = fast.next!!.next
        }
        var reverseHead = reverse(slow!!.next)
        while (reverseHead != null) {
            if (reverseHead.`val` != head1!!.`val`) {
                return false
            }
            reverseHead = reverseHead.next
            head1 = head1.next
        }
        return true
    }
}