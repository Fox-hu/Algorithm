//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
//
// Related Topics 数组 动态规划 👍 2018 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //此问题可以转译为 数组中能不能挑出一些正整数 它们的和=整个数组元素和的一半 所以 数组和必须为偶数 奇数就不符合题意
    //0-1背包问题 di[i][j]表示数组的[0,i]这个子区间内挑选一些数 每个数字只能用一次 使这些数的和恰好等于j
    //那么状态转移方程可以得出 dp[i][j] = dp[i-1][j] || di[i-1][j-num[i]]
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        if (nums[0] <= target) {
            dp[0] = true;
        }
        for (int i = 1; i < len; i++) {
            //注意这里是从后向前遍历 因为从前向后遍历 dp[j-nums[i]]会被改写
            for (int j = target; j >= nums[i]; j--) {
                if (dp[target]) return true;
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[target];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
