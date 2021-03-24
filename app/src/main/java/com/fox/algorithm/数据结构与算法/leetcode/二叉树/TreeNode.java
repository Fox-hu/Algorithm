package com.fox.algorithm.数据结构与算法.leetcode.二叉树;

/**
 * @Author Fox
 * @Date 2021/3/24 20:34
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {}

    public TreeNode(int val) { this.val = val; }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
