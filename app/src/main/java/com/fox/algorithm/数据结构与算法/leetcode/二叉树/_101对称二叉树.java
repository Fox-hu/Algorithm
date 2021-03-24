package com.fox.algorithm.数据结构与算法.leetcode.二叉树;

/**
 * @Author Fox
 * @Date 2021/3/24 20:14
 */

/*https://leetcode-cn.com/problems/symmetric-tree/
给定一个二叉树，检查它是否是镜像对称的。
例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 */

class _101对称二叉树 {

    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && check(left.left, right.right) && check(left.right,
                right.left);
    }
}
