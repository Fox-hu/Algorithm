package com.fox.algorithm.数据结构与算法.算法.动态规划

/**
 * @Author fox.hu
 * @Date 2021/2/5 10:27
 */
/*
有n件物品和一个最大承重的背包，每件物品的重量是wi,价值是vi，
在保证总重量不超过W的前提下，将那几件物品装入背包，可以使背包的总价值最大？
注意 每个物品只有一件
*/

/*
假设 values 是价值数组，weights 是重量数组
编号为 k 的物品，价值是 values[k]，重量是 weights[k]，k ∈ [0, n)
假设 dp(i, j) 是 最大承重为 j、有前 i 件物品可选 时的最大总价值，i ∈ [1, n]，j ∈ [1, W]
如果j<weight[i]则 dp(i,j) = dp(i-1,j)
否则
如果不选择第i个物品 dp(i,j) = dp(i-1,j)
如果选择第i个物品 dp(i,j)= values[i-1] + dp(i-1,j-weight[i-1])
dp(i,j) = max{ dp(i-1,j) , dp(i,j) = values[i-1] + dp(i-1,j - weight[i-1])}
*/
fun maxValue(values: IntArray, weights: IntArray, capacity: Int): Int {
    if (values.isEmpty() || weights.isEmpty() || capacity <= 0 || values.size != weights.size) return 0
    val dp = Array(values.size + 1) { IntArray(capacity + 1) }

    for (i in 1..values.size) {
        for (j in 1..capacity) {
            if (j < weights[i - 1]) {
                dp[i][j] = dp[i - 1][j]
            } else {
                dp[i][j] = Math.max(dp[i - 1][j], values[i - 1] + dp[i - 1][j - weights[i - 1]])
            }
        }
    }
    return dp[values.size][capacity]
}

/*
使用一维数组进行优化
dp(i, j) 都是由 dp(i – 1, k) 推导出来的，也就是说，第 i 行的数据是由它的上一行第 i – 1 行推导出来的
因此，可以使用一维数组来优化
另外，由于 k ≤ j ，所以 j 的遍历应该由大到小，否则导致数据错乱
*/
fun maxValue1(values: IntArray, weights: IntArray, capacity: Int): Int {
    if (values.isEmpty() || weights.isEmpty() || capacity <= 0 || values.size != weights.size) return 0
    val dp = IntArray(capacity + 1)

    for (i in 1..values.size) {
        for (j in capacity downTo 1) {
            if (j >= weights[i - 1]) {
                dp[j] = Math.max(dp[j], values[i - 1] + dp[j - weights[i - 1]])
            }
        }
    }
    return dp[capacity]
}


fun main() {
    println(maxValue(intArrayOf(6, 3, 5, 4, 6), intArrayOf(2, 2, 6, 5, 4), 10))
    println(maxValue1(intArrayOf(6, 3, 5, 4, 6), intArrayOf(2, 2, 6, 5, 4), 10))
}
