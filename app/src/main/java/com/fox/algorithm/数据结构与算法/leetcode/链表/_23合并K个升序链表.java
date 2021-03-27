package com.fox.algorithm.数据结构与算法.leetcode.链表;

import java.util.PriorityQueue;

/**
 * @Author Fox
 * @Date 2021/3/27 15:38
 */

/*
用容量为K的最小堆优先队列，把链表的头结点都放进去，然后出队当前优先队列中最小的，挂上链表
让出队的那个节点的下一个入队，再出队当前优先队列中最小的，直到优先队列为空 直到优先队列为空。
 */
class _23合并K个升序链表 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);

        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }

        while (!pq.isEmpty()) {
            ListNode nextNode = pq.poll();
            cur.next = nextNode;
            cur = cur.next;
            //入队 当前出队节点的下一个节点 跟现有的node进行比较
            if (nextNode.next != null) {
                pq.add(nextNode.next);
            }
        }

        return dummyHead.next;
    }
}
