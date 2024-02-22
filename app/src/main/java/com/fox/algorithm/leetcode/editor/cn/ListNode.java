package com.fox.algorithm.leetcode.editor.cn;

//提交时需要将此import注释掉 否则leetcode编译不过
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode(int x,ListNode next){
        val = x;
        this.next = next;
    }
}