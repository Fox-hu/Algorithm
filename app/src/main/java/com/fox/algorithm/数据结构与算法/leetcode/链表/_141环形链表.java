package com.fox.algorithm.数据结构与算法.leetcode.链表;

/**
 * @Author Fox
 * @Date 2021/3/29 10:30
 */
/*https://leetcode-cn.com/problems/linked-list-cycle/
给定一个链表，判断链表中是否有环。
如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
如果链表中存在环，则返回 true 。 否则，返回 false 。
 */

/*
快慢指针
 */
class _141环形链表 {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode slow = head,fast = head.next;
        while (fast != null && fast.next != null){
            if(slow == fast) return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
