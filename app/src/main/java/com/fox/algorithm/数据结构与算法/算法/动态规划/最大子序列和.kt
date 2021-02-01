package com.fox.algorithm.数据结构与算法.算法.动态规划

import com.fox.algorithm.数据结构与算法.算法.分治.maxSubArrayByDivide

/**
 * @Author Fox
 * @Date 2021/2/1 22:11
 */
//给定一个长度为 n 的整数序列，求它的最大连续子序列和
//比如 –2、1、–3、4、–1、2、1、–5、4 的最大连续子序列和是 4 + (–1) + 2 + 1 = 6


//假设 dp(i) 是以 nums[i] 结尾的最大连续子序列和（nums是整个序列）
//以 nums[0] –2 结尾的最大连续子序列是 –2，所以 dp(0) = –2
//以 nums[1] 1 结尾的最大连续子序列是 1，所以 dp(1) = 1
//以 nums[2] –3 结尾的最大连续子序列是 1、–3，所以 dp(2) = dp(1) + (–3) = –2
//以 nums[3] 4 结尾的最大连续子序列是 4，所以 dp(3) = 4
//以 nums[4] –1 结尾的最大连续子序列是 4、–1，所以 dp(4) = dp(3) + (–1) = 3
//所以 可以得出 当dp[i-1]<=0时 dp[i] = nums[i] 当dp[i-1]>0时 dp[i] = dp[i-1] + nums[i]
fun maxSubArrayByPd(nums: IntArray): Int {
    if (nums.isEmpty()) return 0
    val dp = IntArray(nums.size)

    dp[0] = nums[0]
    var max = dp[0]

    for (i in 1 until dp.size) {
        if (dp[i - 1] <= 0) {
            dp[i] = nums[i]
        } else {
            dp[i] = dp[i - 1] + nums[i]
        }
        max = Math.max(max, dp[i])
    }
    return max
}

fun main() {
    println(maxSubArrayByPd(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
    println(maxSubArrayByDivide(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
}