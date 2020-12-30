package com.fox.algorithm.数据结构与算法.算法.分治

/**
 * @Author Fox
 * @Date 2020/12/30 21:37
 */
//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//示例:
//输入: [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。 采用分治方式来试试
class 最大子序和 {
    fun maxSubArray(nums: IntArray): Int {
        return maxSubArray(nums, 0, nums.size)
    }

    //有三种可能 分别是在数组的左侧、数组的右侧以及左右侧各占一部分
    //所以结果就是比较三者的最大值
    fun maxSubArray(nums: IntArray, begin: Int, end: Int): Int {
        if (end - begin < 2) return nums[begin]
        val mid = (begin + end) shr 1

        //以mid为初始，依次像左边加 获得左侧最大的值
        var leftMax = nums[mid - 1]
        var leftSum = 0
        for (i in mid - 2 downTo begin) {
            leftSum += nums[i]
            leftMax = Math.max(leftSum, leftMax)
        }

        var rightMax = nums[mid]
        var rightSum = 0
        for (i in mid + 1 until end) {
            rightSum += nums[i]
            rightMax = Math.max(rightMax, rightSum)
        }
        //比较三种情况下 那种获得的值最大
        return Math.max(leftMax + rightMax, Math.max(maxSubArray(nums, begin, mid), maxSubArray(nums, mid, end)))
    }
}