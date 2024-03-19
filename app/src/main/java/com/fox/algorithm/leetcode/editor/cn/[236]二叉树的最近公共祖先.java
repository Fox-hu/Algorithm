//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出：3
//解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
// 
//
// 示例 2： 
// 
// 
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出：5
//解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], p = 1, q = 2
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [2, 10⁵] 内。 
// -10⁹ <= Node.val <= 10⁹ 
// 所有 Node.val 互不相同 。 
// p != q 
// p 和 q 均存在于给定的二叉树中。 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 2614 👎 0
package com.fox.algorithm.leetcode.editor.cn;


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    //若 root 是 p,q 的 最近公共祖先 ，则只可能为以下情况之一：
    //p和 q在 root的子树中，且分列 root的 异侧（即分别在左、右子树中）；
    //p=root ，且 q 在 root 的左或右子树中；
    //q=root ，且 p 在 root 的左或右子树中；
    //使用递归 直接找node=q和node=p的场合
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            //如果root == p || root == q 那么不会是下一层的节点了 返回这一层的数
            return root;
        }
        //根节点不是p q中的任意一个 那么就继续往左子树和右子树找p和q
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        //左子树没有 返回右子树的结果
        if(left == null) return right;
        //右子树没有 返回左子树的结果
        if(right == null) return left;
        //左右子树都有结果了 说明在q和p分别在两个左右子树上 那么此时最近的公告先祖就是root
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
