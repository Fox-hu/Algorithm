package com.fox.algorithm.数据结构与算法.leetcode.链表;

/**
 * @Author Fox
 * @Date 2021/3/27 10:34
 */
class _237删除链表中的节点 {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
