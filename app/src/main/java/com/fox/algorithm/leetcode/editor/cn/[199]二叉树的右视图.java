//给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: [1,2,3,null,5,null,4]
//输出: [1,3,4]
// 
//
// 示例 2: 
//
// 
//输入: [1,null,3]
//输出: [1,3]
// 
//
// 示例 3: 
//
// 
//输入: []
//输出: []
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [0,100] 
// 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1032 👎 0


package com.fox.algorithm.leetcode.editor.cn;
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

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
    List<Integer> list = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);
        return list;
    }

    //采用根-右-左的方式遍历 可以保证每层第一个访问的元素就是最右侧的节点
    //depth代表的层数 当层数 = 已收集元素的大小
    //那么就是代表当前层数没有收集最右侧元素 需要将当前的元素放入结果列表中
    private void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (list.size() == depth) {
            list.add(root.val);
        }
        depth++;
        dfs(root.right, depth);
        dfs(root.left, depth);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
