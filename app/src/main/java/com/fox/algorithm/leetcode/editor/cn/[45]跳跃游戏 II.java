//给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。 
//
// 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处: 
//
// 
// 0 <= j <= nums[i] 
// i + j < n 
// 
//
// 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
//
// 示例 2: 
//
// 
//输入: nums = [2,3,0,1,4]
//输出: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁴ 
// 0 <= nums[i] <= 1000 
// 题目保证可以到达 nums[n-1] 
// 
//
// Related Topics 贪心 数组 动态规划 👍 2452 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //贪心算法 遍历数组
    //更新目前能跳到的最远距离和边界(当前数能跳的最远距离)
    //如果到达了边界 启动下次跳跃 那么下次跳跃的起点就是当前能够跳跃的最远距离
    public int jump(int[] nums) {
        // 目前能跳到的最远位置的下标
        int max = 0;
        // 当前能跳跃到的位置的边界下标
        int border = 0;
        // 所用步数
        int step = 0;
        // 这里注意 因为题目保证一定能跳到nums[n-1]，这里遍历的右边界是i<nums.length-1
        for (int i = 0; i < nums.length - 1; i++) {
            //更新前i个元素 能跳的最远距离
            max = Math.max(max, i + nums[i]);
            //如果到达了边界 那么要跳了 下一跳的起点 就是当前能跳的最大距离
            //比如 [2,3,1,1,4] 当i=1时 border是i=0时的取值2 而max则是4 不进入判断
            if (i == border) {
                border = max;
                step++;
            }
        }
        return step;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
