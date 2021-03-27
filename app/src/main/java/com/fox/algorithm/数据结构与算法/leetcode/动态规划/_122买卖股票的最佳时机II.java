package com.fox.algorithm.数据结构与算法.leetcode.动态规划;

/**
 * @Author Fox
 * @Date 2021/3/27 9:55
 */
class _122买卖股票的最佳时机II {

    public int maxProfit(int[] prices) {
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            ans += Math.max(prices[i] - prices[i - 1], 0);
        }
        return ans;
    }
}
