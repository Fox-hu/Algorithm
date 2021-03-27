package com.fox.algorithm.数据结构与算法.leetcode.二叉树;

import java.util.ArrayList;

/**
 * @Author Fox
 * @Date 2021/3/27 15:06
 */

/*https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
输入：root = [3,1,4,null,2], k = 1
输出：1
 */

    /*
    中序遍历后，转为一个list后就可以取出第k小的元素
     */
class _230二叉搜索树中第K小的元素 {

    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> list = inorder(root, new ArrayList<>());
        return list.get(k - 1);
    }

    //中序遍历
    private ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> list) {
        if(root == null) return list;
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
        return list;
    }
}
