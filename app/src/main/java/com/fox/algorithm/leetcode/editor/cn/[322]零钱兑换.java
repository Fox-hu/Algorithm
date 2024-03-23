//给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。 
//
// 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 2³¹ - 1 
// 0 <= amount <= 10⁴ 
// 
//
// Related Topics 广度优先搜索 数组 动态规划 👍 2721 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //动态规划
    //这里的dp[i]只得是目标为i时 最少能用的硬币数目
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[max];
        //这里全部填充amount+1的原因是 后面需要进行min的操作 如果是0会有问题
        //所以填充一个不可能的大值 用于min操作和最后有效判断
        Arrays.fill(dp, max);
        dp[0] = 0; //这里的0位置要放在后面
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                //金额值大于当前硬币面额值时 才进行更新 否则无意义
                if (i >= coin) {
                    //当前遍历的硬币币值是coin 那么我只需要知道dp[i-coin]就行
                    //那么dp[i] = dp[i-coin]+1
                    //因为币值有很多种 需要筛出最小数目的
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        //如果不存在的话 那么dp[amount] = amount + 1
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
