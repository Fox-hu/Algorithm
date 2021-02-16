package com.fox.algorithm.数据结构与算法.leetcode.链表

/**
 * @Author Fox
 * @Date 2021/2/16 12:27
 */

/*https://leetcode-cn.com/problems/partition-list
给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
你应当 保留 两个分区中每个节点的初始相对位置。
示例 1：
输入：head = [1,4,3,2,5,2], x = 3
输出：[1,2,2,4,3,5]

示例 2：
输入：head = [2,1], x = 2
输出：[1,2]

提示：
链表中节点的数目在范围 [0, 200] 内
-100 <= Node.val <= 100
-200 <= x <= 200
*/

/*使用左右两个链表 遍历原有链表 如果小于x则放到左边链表 大于x的放到右边链表*/
fun partition(head: ListNode?, x: Int): ListNode? {
    if (head == null) return null
    var headTemp = head
    val lHead = ListNode(0)
    var lTail = lHead
    val rHead = ListNode(0)
    var rTail = rHead

    while (headTemp != null) {
        if (headTemp.`val` < x) {
            lTail.next = headTemp
            lTail = headTemp
        } else {
            rTail.next = headTemp
            rTail = headTemp
        }
        headTemp = headTemp.next
    }

    //这句不能少 否则rTail会停止不动
    rTail.next = null
    //rHead是一个dummy 所以是rHead.next
    lTail.next = rHead.next
    return lHead.next
}