//给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。 
//
// 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
//输出：3
//解释：和等于 8 的路径有 3 条，如图所示。
// 
//
// 示例 2： 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：3
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [0,1000] 
// 
// -10⁹ <= Node.val <= 10⁹ 
// -1000 <= targetSum <= 1000 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 1807 👎 0
package com.fox.algorithm.leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;
import java.util.Map;

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

    //前缀和的思路
    //HashMap的key是前缀和， value是该前缀和的节点数量
    //需要进行状态恢复
    //由于题目要求：路径方向必须是向下的（只能从父节点到子节点）
    //当我们讨论两个节点的前缀和差值时，有一个前提：
    //一个节点必须是另一个节点的祖先节点
    //换句话说，当我们把一个节点的前缀和信息更新到map里时，它应当只对其子节点们有效。
    //所以我们应该 在遍历完一个节点的所有子节点后，将其从map中除去

    Map<Long, Integer> prefixMap;
    int target;

    public int pathSum(TreeNode root, int targetSum) {
        prefixMap = new HashMap<>();
        target = targetSum;
        prefixMap.put(0L, 1);  //key是前缀和，value是前缀和为这个值的路径数量。（因为可能好几条路径前缀和是同一个值。）。这里表示前缀和为0的路径有一条。（不这样做若某个节点的前缀和直接已经等于targetSum，此时反而会错过此路径）
        return recur(root, 0L);  //传入参数是根节点root，和root之前的前缀和0。
    }

    //recur函数，用于遍历二叉树，对每个节点，记录前缀和的同时，返回当前找到和为target的路径数量。传入的第二个参数curSum表示node节点之前的前缀和。
    private int recur(TreeNode node, Long curSum){
        if(node == null){
            return 0;
        }

        int res = 0;  //res记录路径数量。
        curSum += node.val;  //curSum记录前缀和，遍历到当前节点的时候就加上这个节点的值。

        res = prefixMap.getOrDefault(curSum - target, 0);  //res就是路径数量。curSum是根节点到当前节点的前缀和，如果哈希表中能找到之前存在过路径的前缀和为curSum - target，说明可以找到value条路径使其路径和为target。
        prefixMap.put(curSum, prefixMap.getOrDefault(curSum, 0) + 1);  //把当前节点的前缀和也加入到哈希表中，如果已经存在了就给value + 1

        int left = recur(node.left, curSum);  //再去遍历其左右子树继续记录前缀和并找可行路径。
        int right = recur(node.right, curSum);

        res = res + left + right;  //全都遍历完了在把所有找到的路径加起来就是总的路径数量。

        prefixMap.put(curSum, prefixMap.get(curSum) - 1);  //最后记得在哈希表中把已经找过的路径都去掉，即恢复状态。

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
