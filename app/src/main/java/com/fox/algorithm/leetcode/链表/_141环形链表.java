package com.fox.algorithm.leetcode.链表;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle/
 * 判断一个链表中是否是有环形
 *
 * @Author fox
 * @Date 2020/2/20 12:47
 */
public class _141环形链表 {
    //使用快慢指针 如果指针相遇 则说明有环
    public boolean hasCyCle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

}
