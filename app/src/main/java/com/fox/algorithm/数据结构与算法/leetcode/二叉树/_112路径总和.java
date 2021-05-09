package com.fox.algorithm.数据结构与算法.leetcode.二叉树;

/**
 * @Author Fox
 * @Date 2021/3/24 21:16
 */

/*https://leetcode-cn.com/problems/path-sum/
给你二叉树的根节点 root 和一个表示目标和的整数 targetSum,
判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
输入：root = [1,2,3], targetSum = 5
输出：false
输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
输出：true
树中节点的数目在范围 [0, 5000] 内
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000
 */

class _112路径总和 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        if(root.right == null && root.left == null) return root.val == targetSum;
        int result = targetSum - root.val;
        return hasPathSum(root.left,result) || hasPathSum(root.right,result);
    }
}
