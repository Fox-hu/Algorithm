package com.fox.algorithm.数据结构与算法.算法.动态规划

/**
 * @Author fox.hu
 * @Date 2021/2/4 15:15
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
fun lengthLCSubstring(str1: String, str2: String): Int {
    if (str1.isEmpty() || str2.isEmpty()) return 0
    val cs1 = str1.toCharArray()
    val cs2 = str2.toCharArray()
    val dp = Array(cs1.size + 1) { IntArray(cs2.size + 1) }
    var max = 0
    for (i in 1..cs1.size) {
        for (j in 1..cs2.size) {
            if (cs1[i - 1] == cs2[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1] + 1
                max = Math.max(max, dp[i][j])
            }
        }
    }
    return max
}

fun main() {
    println(lengthLCSubstring("ABCBA", "BABCA"))
}