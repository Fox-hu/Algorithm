package com.fox.algorithm.数据结构与算法.leetcode.二叉树;

/**
 * @Author Fox
 * @Date 2021/3/27 14:46
 */

/*https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
输出: 6
解释: 节点 2 和节点 8 的最近公共祖先是 6。

 */
class _235二叉搜索树的最近公共祖先 {

    /*
    递归方式 如果（q-root） * （p-root） <=0 则说明他们在root两侧边 直接返回root
    否则判断是在root的左边还是右边后进行递归
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (((root.val - p.val) * (root.val - q.val)) <= 0) return root;
        TreeNode ans = p.val>root.val?root.right:root.left;
        return lowestCommonAncestor(ans, p, q);
    }

    /*
    一次遍历的方式 思路同递归
    */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ans = root;
        while (true) {
            if (q.val > ans.val && p.val > ans.val) {
                ans = ans.right;
            } else if (q.val < ans.val && p.val < ans.val) {
                ans = ans.left;
            } else {
                break;
            }
        }
        return ans;
    }
}
