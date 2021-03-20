package com.fox.algorithm.数据结构与算法.leetcode.动态规划

/**
 * @Author Fox
 * @Date 2021/2/2 21:10
 */
/*链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
示例 1：
输入：nums = [10,9,2,5,3,7,101,18]
输出：4
解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。

示例 2：
输入：nums = [0,1,0,3,2,3]
输出：4

示例 3：
输入：nums = [7,7,7,7,7,7,7]
输出：1

提示：
1 <= nums.length <= 2500
-104 <= nums[i] <= 104
 
进阶：
你可以设计时间复杂度为 O(n2) 的解决方案吗？
你能将算法的时间复杂度降低到 O(n log(n)) 吗?
*/

/* 动态规划
dp[i] 是以nums[i]为结尾的最长上升子序列的长度,遍历 j ∈ [0, i)
当 nums[i] > nums[j]时
nums[i] 可以接在 nums[j] 后面，形成一个比 dp(j) 更长的上升子序列，长度为 dp(j) + 1
dp(i) = max { dp(i), dp(j) + 1 }
当 nums[i] ≤ nums[j]时
nums[i] 不能接在 nums[j] 后面，跳过此次遍历（continue）
*/
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

/*二分搜索
把每个数字看做是一张扑克牌，从左到右按顺序处理每一个扑克牌
将它压在（从左边数过来）第一个牌顶 ≥ 它的牌堆上面
如果找不到牌顶 ≥ 它的牌堆，就在最右边新建一个牌堆，将它放入这个新牌堆中
当处理完所有牌，最终牌堆的数量就是最长上升子序列的长度
*/
fun lengthOfLISByBinarySearch(nums: IntArray): Int {
    if (nums.isEmpty()) return 0
    val topArray = IntArray(nums.size)
    var length = 0
    for (num in nums) {
        var j = 0
        while (j < length) {
            //如果当前牌小于当前牌顶，则覆盖牌顶
            if (topArray[j] >= num) {
                topArray[j] = num
                break
            }
            //切换牌堆
            j += 1
        }
        //所有牌堆都不能满足 另起牌堆 将num赋值给新牌堆的牌顶
        if (j == length) {
            length += 1
            topArray[j] = num
        }
    }
    return length
}

fun main() {
    println(lengthOfLISByBinarySearch(intArrayOf(10, 2, 2, 5, 1, 7, 101, 18)))
}