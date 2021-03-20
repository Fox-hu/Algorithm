package com.fox.algorithm.数据结构与算法.leetcode.动态规划

/**
 * @Author fox.hu
 * @Date 2021/2/5 14:29
 */
/*
有 n 件物品和一个最大承重为 W 的背包，每件物品的重量是 𝑤i、价值是 𝑣i
在保证总重量恰好等于 W 的前提下，选择某些物品装入背包，背包的最大总价值是多少？
注意：每个物品只有 1 件，也就是每个物品只能选择 0 件或者 1 件
*/

/*dp(i, j) 初始状态调整
dp(i, 0) = 0，总重量恰好为 0，最大总价值必然也为 0
dp(0, j) = –∞（负无穷），j ≥ 1，负数在这里代表无法恰好装满
*/
fun maxValueExactly(values: IntArray, weights: IntArray, capacity: Int): Int {
    if (values.isEmpty() || weights.isEmpty() || capacity <= 0 || values.size != weights.size) return 0
    val dp = IntArray(capacity + 1)
    for (j in 1..capacity) {
        dp[j] = Int.MIN_VALUE
    }
    for (i in 1..values.size) {
        for (j in capacity downTo weights[i - 1]) {
            dp[j] = Math.max(dp[j], values[i - 1] + dp[j - weights[i - 1]])
        }
    }
    return if (dp[capacity] < 0) -1 else dp[capacity]
}
fun main() {
    println(maxValueExactly(intArrayOf(6, 3, 5, 4, 6), intArrayOf(2, 2, 6, 5, 4), 10))
}