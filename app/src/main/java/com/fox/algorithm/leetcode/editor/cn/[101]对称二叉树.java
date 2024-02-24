//给你一个二叉树的根节点 root ， 检查它是否轴对称。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,2,3,4,4,3]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,2,2,null,3,null,3]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 1000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以运用递归和迭代两种方法解决这个问题吗？ 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 2651 👎 0

package com.fox.algorithm.leetcode.editor.cn;
//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    //使用递归
    //问题等价于如果递归的比较 left.left = right.right && left.right = right.left 如相等 则成立
    public boolean isSymmetric(TreeNode root) {
        //本题中root不会为空
        return travel(root.left,root.right);
    }

    private boolean travel(TreeNode left,TreeNode right) {
        //三种跳出递归的情况 全为null则为true 一方为null则为false，val不相等则为false
        if(left == null && right == null) return true;
        if(left == null || right == null ) return false;
        //这里要判断不相等 因为即使 left.val == right.val
        //这个节点也不是叶子节点 无法得出两者相等的结论
        if(left.val != right.val) return false;
        return travel(left.left,right.right) && travel(left.right,right.left);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
