package com.fox.algorithm.数据结构与算法.leetcode.动态规划;

/**
 * @Author Fox
 * @Date 2021/3/28 12:48
 */

/*https://leetcode-cn.com/problems/maximum-subarray/
给定一个长度为 n 的整数序列，求它的最大连续子序列和
比如 –2、1、–3、4、–1、2、1、–5、4 的最大连续子序列和是 4 + (–1) + 2 + 1 = 6

假设 dp(i) 是以 nums[i] 结尾的最大连续子序列和（nums是整个序列）
以 nums[0] –2 结尾的最大连续子序列是 –2，所以 dp(0) = –2
以 nums[1] 1 结尾的最大连续子序列是 1，所以 dp(1) = 1
以 nums[2] –3 结尾的最大连续子序列是 1、–3，所以 dp(2) = dp(1) + (–3) = –2
以 nums[3] 4 结尾的最大连续子序列是 4，所以 dp(3) = 4
以 nums[4] –1 结尾的最大连续子序列是 4、–1，所以 dp(4) = dp(3) + (–1) = 3
所以 可以得出 当dp[i-1]<=0时 dp[i] = nums[i] 当dp[i-1]>0时 dp[i] = dp[i-1] + nums[i]*/

class _53最大子序和 {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < dp.length; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
