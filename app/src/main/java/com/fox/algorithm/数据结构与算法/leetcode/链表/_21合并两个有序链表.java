package com.fox.algorithm.数据结构与算法.leetcode.链表;

/**
 * @Author Fox
 * @Date 2021/3/23 10:44
 */
class _21合并两个有序链表 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode preHead = new ListNode(-1);
        ListNode head = preHead;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        head.next = l1 == null ? l2 : l1;
        return preHead.next;
    }
}
