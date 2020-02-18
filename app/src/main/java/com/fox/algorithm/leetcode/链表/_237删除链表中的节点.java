package com.fox.algorithm.leetcode.链表;

/**
 * @Author fox
 * @Date 2020/2/18 19:33
 */
public class _237删除链表中的节点 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
