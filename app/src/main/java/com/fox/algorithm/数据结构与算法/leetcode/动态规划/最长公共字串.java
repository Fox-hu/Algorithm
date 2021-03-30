package com.fox.algorithm.数据结构与算法.leetcode.动态规划;

/**
 * @Author Fox
 * @Date 2021/3/30 20:54
 */

/*
最长公共子串（Longest Common Substring） 子串是连续的子序列
求两个字符串的最长公共子串长度
例:ABCBA 和 BABCA 的最长公共子串是 ABC，长度为 3
*/

/*
假设 dp(i, j) 是以 str1[i – 1]、str2[j – 1] 结尾的最长公共子串长度
i ∈ [1, str1.length]
j ∈ [1, str2.length]
dp(i, 0)、dp(0, j) 初始值均为 0
如果 str1[i – 1] = str2[j – 1]，那么 dp(i, j) = dp(i – 1, j – 1) + 1
如果 str1[i – 1] ≠ str2[j – 1]，那么 dp(i, j) = 0
最长公共子串的长度是所有 dp(i, j) 中的最大值 max { dp(i, j) }
 */

class 最长公共字串 {

    public int lengthLCSubstring(String str1, String str2) {
        if (str1.length() == 0 || str2.length() == 0) {
            return 0;
        }
        char[] cs1 = str1.toCharArray();
        char[] cs2 = str2.toCharArray();

        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        int max = 0;
        for (int i = 1; i < cs1.length; i++) {
            for (int j = 1; j < cs2.length; j++) {
                if (cs1[i - 1] == cs2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }
}
