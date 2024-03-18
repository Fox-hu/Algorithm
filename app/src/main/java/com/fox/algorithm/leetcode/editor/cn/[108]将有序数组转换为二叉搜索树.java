package com.fox.algorithm.leetcode.editor.cn;
/**
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * <p>
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [-10,-3,0,5,9]
 * 输出：[0,-3,9,-10,null,5]
 * 解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
 * <p>
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [1,3]
 * 输出：[3,1]
 * 解释：[1,null,3] 和 [3,1] 都是高度平衡二叉搜索树。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 10⁴
 * -10⁴ <= nums[i] <= 10⁴
 * nums 按 严格递增 顺序排列
 * <p>
 * <p>
 * Related Topics 树 二叉搜索树 数组 分治 二叉树 👍 1128 👎 0
 */

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
    //BST的中序遍历是升序的，因此本题等同于根据中序遍历的序列恢复二叉搜索树
    //使用递归 根节点左子树都小于根节点 根节点右子树都大于根节点
    //又因为需要高度平衡 所以以中间元素作为根节点root
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    //根据数组恢复二叉树 看到有序数组 考虑二分法
    //看到搜索二叉树 考虑中序遍历
    private TreeNode dfs(int[] nums, int low, int hi) {
        if (low > hi) {
            return null;
        }
        int mid = low + (hi - low) / 2;
        TreeNode midNode = new TreeNode(nums[mid]);
        midNode.left = dfs(nums, low, mid - 1);
        midNode.right = dfs(nums, mid + 1, hi);
        return midNode;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
