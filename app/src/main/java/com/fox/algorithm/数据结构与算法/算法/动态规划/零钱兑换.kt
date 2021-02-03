package com.fox.algorithm.数据结构与算法.算法.动态规划

/**
 * @Author Fox
 * @Date 2021/1/19 21:43
 */
//假设有25分、20分、5分、1分的硬币，现要找给客户41分的零钱，如何办到硬币个数最少? (贪心是5 并非最优解)
//使用动态规划

/*暴力递归 自顶向下
有子结果被重复的计算
假设dp(n)是凑到n分需要的最少硬币个数
如果第1次选择了25分的硬币，那么dp(n)=dp(n-25)+1
如果第1次选择了20分的硬币，那么dp(n)=dp(n-20)+
如果第1次选择了5分的硬币，那么dp(n)=dp(n-5)+1
如果第1次选择了1分的硬币，那么dp(n)=dp(n-1)+1
所以dp(n)= min {dp(n-25), dp(n-20), dp(n-5), dp(n-1)}+1
*/
fun coins(n: Int): Int {

    if (n <= 0) return Int.MAX_VALUE
    if (n == 25 || n == 20 || n == 5 || n == 1) return 1
    val min1 = Math.min(coins(n - 25), coins(n - 20))
    val min2 = Math.min(coins(n - 5), coins(n - 1))
    return Math.min(min1, min2) + 1
}

//记忆化搜索 将中间结果存储
//自顶向下
fun coins1(n: Int): Int {
    if (n < 1) return 0
    val dp = IntArray(n + 1)
    //将dp[1、5、20、25]的值置为1
    val faces = intArrayOf(1, 5, 20, 25)
    for (face in faces) {
        if (n < face) break
        dp[face] = 1
    }
    return coins1(n, dp)
}

fun coins1(n: Int, dp: IntArray): Int {
    if (n < 1) return Int.MAX_VALUE
    if (dp[n] == 0) {
        val min1 = Math.min(coins1(n - 25, dp), coins1(n - 20, dp))
        val min2 = Math.min(coins1(n - 5, dp), coins1(n - 1, dp))
        dp[n] = Math.min(min1, min2) + 1
    }
    return dp[n]
}


//递推 自底向上
//依次求出dp[i]..dp[n]的值 最终dp[n]就是最终的结果
fun coins2(n: Int): Int {
    if (n < 1) return -1
    val dp = IntArray(n + 1)
    for (i in 1..n) {
        var min = Int.MAX_VALUE
        if (i >= 1) min = Math.min(dp[i - 1], min)
        if (i >= 5) min = Math.min(dp[i - 5], min)
        if (i >= 20) min = Math.min(dp[i - 20], min)
        if (i >= 25) min = Math.min(dp[i - 25], min)
        dp[i] = min + 1
    }
    return dp[n]
}

fun main() {
    println(coins(41))
    println(coins1(17))
    println(coins2(90))
}