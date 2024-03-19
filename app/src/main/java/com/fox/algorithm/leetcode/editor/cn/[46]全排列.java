//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// Related Topics 数组 回溯 👍 2819 👎 0


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //采用回溯算法 循环+递归+状态恢复
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        Deque<Integer> deque = new ArrayDeque();
        dfs(res, deque, nums);
        return res;
    }

    private void dfs(List<List<Integer>> res, Deque<Integer> deque, int[] nums) {
        //当收集到长度符合要求的队列后 退出递归
        if (nums.length == deque.size()) {
            //java引用传递的特性 需要重新新建对象
            res.add(new ArrayList(deque));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //回溯跳过
            if (deque.contains(nums[i])) continue;
            //添加操作
            deque.addLast(nums[i]);
            dfs(res, deque, nums);
            //撤销操作
            deque.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
