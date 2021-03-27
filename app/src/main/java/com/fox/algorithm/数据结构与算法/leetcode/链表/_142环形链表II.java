package com.fox.algorithm.数据结构与算法.leetcode.链表;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author Fox
 * @Date 2021/3/25 15:17
 */

/*
给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
说明：不允许修改给定的链表。

输入：head = [3,2,0,-4], pos = 1
输出：返回索引为 1 的链表节点
解释：链表中有一个环，其尾部连接到第二个节点。

 */
class _142环形链表II {

    /*
    我们遍历链表中的每个节点，
    并将它记录下来；一旦遇到了此前遍历过的节点，
    就可以判定链表中存在环。借助哈希表可以很方便地实现。
     */
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }
}
