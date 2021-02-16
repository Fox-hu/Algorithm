package com.fox.algorithm.数据结构与算法.面试.链表

import com.fox.algorithm.数据结构与算法.leetcode.链表.ListNode

/**
 * 删除链表中等于给定值 val 的所有节点
 * @Author Fox
 * @Date 2021/2/13 20:34
 */

/*https://leetcode-cn.com/problems/remove-linked-list-elements/
示例:
输入: 1->2->6->3->4->5->6, val = 6
输出: 1->2->3->4->5
*/

/*创建一个新的链表来移除链表元素 创建新表头和表尾
新链表的表头是虚拟节点 依次遍历链表元素 如果是val则跳过
 */
fun removeElements(head: ListNode?, `val`: Int): ListNode? {
    //使用虚拟头节点 来规避边界问题
    var headNode = head
    if (headNode == null) return null
    val newHead = ListNode(0)
    var newTail = newHead

    while (headNode != null) {
        if (headNode.`val` != `val`) {
            newTail.next = headNode
            newTail = headNode
        }
        headNode = headNode.next
    }
    //最后一定不要忘了清除掉tail的next 将其置空
    newTail.next = null
    return newHead.next
}