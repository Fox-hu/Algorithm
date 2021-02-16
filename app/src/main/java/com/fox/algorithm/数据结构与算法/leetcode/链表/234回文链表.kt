package com.fox.algorithm.数据结构与算法.leetcode.链表

/**
 * @Author Fox
 * @Date 2021/2/16 12:53
 */

/*https://leetcode-cn.com/problems/palindrome-linked-list
请判断一个链表是否为回文链表。
示例 1:
输入: 1->2
输出: false

示例 2:
输入: 1->2->2->1
输出: true
进阶：
你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */

/*步骤
1.先找到链表的中间节点 (常用步骤)
2.将链表的后半部分进行反转 (常用步骤)
3.将反转后的后半部分链表与前半部分进行比较
* */
fun isPalindrome(head: ListNode?): Boolean {
    if (head?.next == null) return true
    if (head.next?.next == null) return head.`val` == head.next?.`val`
    val mid = findMiddleNode(head)
    var rHead = reverse(mid?.next)
    var lHead: ListNode = head

    while (rHead != null) {
        if (lHead.`val` != rHead.`val`) return false
        rHead = rHead.next
        lHead = lHead.next!!
    }
    return true
}

private fun reverse(head: ListNode?): ListNode? {
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

//中间节点的定义 下一个节点是右边链表的初始节点 故1->2->3->4中 2是中间节点
//使用快慢指针
private fun findMiddleNode(head: ListNode?): ListNode? {
    var fast = head
    var slow = head
    while (fast?.next?.next != null) {
        fast = fast.next?.next
        slow = slow?.next
    }
    return slow
}

//使用一个数组来完成 将链表中的值都放到数组中
fun isPalindrome1(head: ListNode?): Boolean {
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
