package com.fox.algorithm.数据结构与算法.leetcode.其他

/**
 * @Author fox
 * @Date 2021/3/20 21:17
 */

/*https://leetcode-cn.com/problems/sqrtx/
实现 int sqrt(int x) 函数。
计算并返回 x 的平方根，其中 x 是非负整数。
由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
示例 1:
输入: 4
输出: 2

示例 2:
输入: 8
输出: 2
说明: 8 的平方根是 2.82842...,
     由于返回类型是整数，小数部分将被舍去。
 */

/*
采用二分法 近似可以认为是求在k*k<=x时 k的最大值
 */
fun mySqrt(x: Int): Int {
    var left = 0
    var right = x
    var ans = -1

    while (left <= right) {
        val mid = left + (right - left) / 2
        if (mid.toLong() * mid.toLong() <= x.toLong()) {
            ans = mid
            left = mid + 1
        } else {
            right = mid - 1
        }
    }
    return ans
}