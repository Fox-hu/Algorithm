package com.fox.algorithm.leetcode.editor.cn;

//提交时需要将此import注释掉 否则leetcode编译不过
public class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    ListNode(int x, ListNode next) {
        val = x;
        this.next = next;
    }
}