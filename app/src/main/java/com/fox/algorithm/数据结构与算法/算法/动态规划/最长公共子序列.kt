package com.fox.algorithm.数据结构与算法.算法.动态规划

/**
 * @Author Fox
 * @Date 2021/2/3 20:55
 */
/*链接：https://leetcode-cn.com/problems/longest-common-subsequence
给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
若这两个字符串没有公共子序列，则返回 0。
示例 1:                                    示例 2:                                    示例 3:
输入：text1 = "abcde", text2 = "ace"        输入：text1 = "abc", text2 = "abc"         输入：text1 = "abc", text2 = "def"
输出：3                                     输出：3                                    输出：0
解释：最长公共子序列是 "ace"，它的长度为 3。   解释：最长公共子序列是 "abc"，它的长度为 3。 解释：两个字符串没有公共子序列，返回 0。
提示:
1 <= text1.length <= 1000
1 <= text2.length <= 1000
输入的字符串只含有小写英文字符。*/

/*
 采用递归的方式
 假设 dp(i, j) 是【nums1 前 i 个元素】与【nums2 前 j 个元素】的最长公共子序列长度
 dp(i, 0)、dp(0, j) 初始值均为 0,如果 nums1[i – 1] = nums2[j – 1]，那么 dp(i, j) = dp(i – 1, j – 1) + 1
 如果 nums1[i – 1] ≠ nums2[j – 1]，那么 dp(i, j) = max { dp(i – 1, j), dp(i, j – 1) }
*/
fun lengthLCS(nums1: IntArray, nums2: IntArray): Int {
    if (nums1.isEmpty() || nums2.isEmpty()) return 0
    return lengthLCS(nums1, nums1.size, nums2, nums2.size)
}

fun lengthLCS(nums1: IntArray, i: Int, nums2: IntArray, j: Int): Int {
    if (i == 0 || j == 0) return 0
    if (nums1[i - 1] == nums2[j - 1]) {
        return lengthLCS(nums1, i - 1, nums2, j - 1) + 1
    } else {
        return Math.max(lengthLCS(nums1, i, nums2, j - 1),
                lengthLCS(nums1, i - 1, nums2, j))
    }
}

/*
*采用动态规划的方式
*数组dp[i][j]代表的是【nums1 前 i 个元素】与【nums2 前 j 个元素】的最长公共子序列长度
*需要i*j个数据空间
*/
fun lengthLCS1(nums1: IntArray, nums2: IntArray): Int {
    if (nums1.isEmpty() || nums2.isEmpty()) return 0
    val dp = Array(nums1.size + 1) { IntArray(nums2.size + 1) }
    for (i in 1..nums1.size) {
        for (j in 1..nums2.size) {
            if (nums1[i - 1] == nums2[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1] + 1
            } else {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1])
            }
        }
    }
    return dp[nums1.size][nums2.size]
}

fun main() {
    println(lengthLCS(intArrayOf(1, 3, 5, 9, 10), intArrayOf(1, 4, 9, 10)))
    println(lengthLCS1(intArrayOf(1, 3, 5, 9, 10), intArrayOf(1, 4, 9, 10)))
}