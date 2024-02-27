//给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的
// 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。 
//
// candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 
//
// 对于给定的输入，保证和为 target 的不同组合数少于 150 个。 
//
// 
//
// 示例 1： 
//
// 
//输入：candidates = [2,3,6,7], target = 7
//输出：[[2,2,3],[7]]
//解释：
//2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
//7 也是一个候选， 7 = 7 。
//仅有这两种组合。 
//
// 示例 2： 
//
// 
//输入: candidates = [2,3,5], target = 8
//输出: [[2,2,2,2],[2,3,3],[3,5]] 
//
// 示例 3： 
//
// 
//输入: candidates = [2], target = 1
//输出: []
// 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 2 <= candidates[i] <= 40 
// candidates 的所有元素 互不相同 
// 1 <= target <= 40 
// 
//
// Related Topics 数组 回溯 👍 2730 👎 0


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //以 target = 7 为 根结点 ，创建一个分支的时 做减法 ；
    //每一个箭头表示：从父亲结点的数值减去边上的数值，得到孩子结点的数值。边的值就是题目中给出的 candidate 数组的每个元素的值；
    //减到 0 或者负数的时候停止，即：结点 0 和负数结点成为叶子结点；
    //所有从根结点到结点 0 的路径（只能从上往下，没有回路）就是题目要找的一个结果。
    //为了去除重复结果 每一次搜索的时候设置 下一轮搜索的起点,
    //即从每一层的第 2个结点开始，都不能再搜索产生同一层结点已经使用过的 candidate 里的元素。

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        Deque<Integer> path = new ArrayDeque<>();
        backtrack(candidates, len, path, 0, target);
        return res;
    }

    private void backtrack(int[] candidates, int len, Deque<Integer> path, int start, int target) {
        //相减的结果已经小于0 不用继续了
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        //这里要注意 下一轮的起点 要排除当前遍历的元素 要不就会有重复元素 所以i从start开始
        for (int i = start; i < len; i++) {
            path.add(candidates[i]);
            backtrack(candidates, len, path, i, target - candidates[i]);
            path.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
