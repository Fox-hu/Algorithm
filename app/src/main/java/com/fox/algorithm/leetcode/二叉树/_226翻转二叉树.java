package com.fox.algorithm.leetcode.二叉树;

/**
 * @Author fox
 * @Date 2020/3/3 17:59
 */
public class _226翻转二叉树 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}

