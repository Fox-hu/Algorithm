package com.fox.algorithm.数据结构与算法.leetcode.动态规划

/**
 * @Author fox.hu
 * @Date 2021/2/19 16:41
 */

/*https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof
在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？ 
示例 1:
输入:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 12
解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物

提示：
0 < grid.length <= 200
0 < grid[0].length <= 200
 */

/*动态规划
* dp[i][j]表示的是在走到i行j列时的最大价值 则可以得出
* 1.i=0 j=0时 dp[i][j] = grid[i][j]
* 2.当i = 0 时 dp[i][j] 只能向右移动 故dp[i][j] = dp[i][j-1] + grid[i][j]
* 3.当j = 0 时 dp[i][j] 只能向下移动 故dp[i][j] = dp[i-1][j] + grid[i][j]
* 4.其他时间则 dp[i][j] = max{dp[i-1][j]+grid[i][j], dp[i][j-1] + grid[i][j]}
* */
fun maxValue(grid: Array<IntArray>): Int {
    val dp = Array(grid.size) { IntArray(grid[0].size) }

    for (i in grid.indices) {
        for (j in grid[0].indices) {
            dp[i][j] = when {
                i == 0 && j == 0 -> grid[0][0]
                i == 0 -> dp[0][j - 1] + grid[0][j]
                j == 0 -> dp[i - 1][0] + grid[i][0]
                else -> Math.max(dp[i][j - 1] + grid[i][j], dp[i - 1][j] + grid[i][j])
            }
        }
    }
    return dp[grid.size - 1][grid[0].size - 1]
}