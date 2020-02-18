package com.fox.algorithm.leetcode.链表;

/**
 * @Author fox
 * @Date 2020/2/18 19:53
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class _206反转链表 {
    //使用递归的方式
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}