package com.fox.algorithm.数据结构与算法.leetcode.二叉树;

/**
 * @Author Fox
 * @Date 2021/3/24 21:30
 */

/*https://leetcode-cn.com/problems/diameter-of-binary-tree/
给定一棵二叉树，你需要计算它的直径长度。
一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
示例 :
给定二叉树
          1
         / \
        2   3
       / \
      4   5
返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 */

class _543二叉树的直径 {

    private int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return ans;
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = depth(root.left);
        int right = depth(root.right);
        ans = Math.max(ans, left + right);
        return Math.max(left, right) + 1;
    }
}
