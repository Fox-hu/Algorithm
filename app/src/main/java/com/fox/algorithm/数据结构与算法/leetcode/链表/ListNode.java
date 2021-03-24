package com.fox.algorithm.数据结构与算法.leetcode.链表;

/**
 * @Author Fox
 * @Date 2021/3/23 10:50
 */
public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {}

    public ListNode(int val) { this.val = val; }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
