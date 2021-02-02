package com.fox.algorithm.数据结构与算法.算法.动态规划

/**
 * @Author Fox
 * @Date 2021/2/2 21:10
 */
//链接：https://leetcode-cn.com/problems/longest-common-subsequence
//给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
//一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
//例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
//若这两个字符串没有公共子序列，则返回 0。
//示例 1:                                    示例 2:                                    示例 3:
//输入：text1 = "abcde", text2 = "ace"        输入：text1 = "abc", text2 = "abc"         输入：text1 = "abc", text2 = "def"
//输出：3                                     输出：3                                    输出：0
//解释：最长公共子序列是 "ace"，它的长度为 3。   解释：最长公共子序列是 "abc"，它的长度为 3。 解释：两个字符串没有公共子序列，返回 0。
//提示:
//1 <= text1.length <= 1000
//1 <= text2.length <= 1000
//输入的字符串只含有小写英文字符。

//dp[i] 是以nums[i]为结尾的最长上升子序列的长度
//遍历 j ∈ [0, i),当 nums[i] > nums[j]时,nums[i] 可以接在 nums[j] 后面，形成一个比 dp(j) 更长的上升子序列，长度为 dp(j) + 1
//dp(i) = max { dp(i), dp(j) + 1 }
//当 nums[i] ≤ nums[j]时nums[i] 不能接在 nums[j] 后面，跳过此次遍历（continue）
fun lengthOfLIS(nums: IntArray): Int {
    if (nums.isEmpty()) return 0
    val dp = IntArray(nums.size)
    var max = 1
    for (i in nums.indices) {
        dp[i] = 1
        for (j in 0 until i) {
            if (nums[i] > nums[j]) {
                dp[i] = Math.max(dp[i], dp[j] + 1)
            }
        }
        max = Math.max(max, dp[i])
    }
    return max
}

fun main() {
    println(lengthOfLIS(intArrayOf(10, 2, 2, 5, 1, 7, 101, 18)))
}