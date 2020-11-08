package com.fox.algorithm.程序员面试金典._02链表

/**
 * @Author fox.hu
 * @Date 2020/10/30 10:42
 */
//链接：https://leetcode-cn.com/problems/delete-middle-node-lcci
//实现一种算法，删除单向链表中间的某个节点（即不是第一个或最后一个节点），假定你只能访问该节点。
//示例：
//输入：单向链表a->b->c->d->e->f中的节点c
//结果：不返回任何数据，但该链表变为a->b->d->e->f
class _0203_删除中间节点 {
    fun deleteNode(node: ListNode?) {
        //删除该节点
        //相当于把该节点替换为下个节点，然后跳过下个节点
        node?.`val` = node?.next?.`val`!!
        node.next = node.next?.next
    }
}