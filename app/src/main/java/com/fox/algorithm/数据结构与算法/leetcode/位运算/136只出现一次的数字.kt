package com.fox.algorithm.数据结构与算法.leetcode.位运算

/**
 * @Author Fox
 * @Date 2021/3/21 12:10
 */

/*https://leetcode-cn.com/problems/single-number/
给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
说明：
你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
示例 1:
输入: [2,2,1]
输出: 1
示例 2:
输入: [4,1,2,1,2]
输出: 4
 */

/*
使用异或操作 一个数和自身异或是0 和0异或是其本身 所以我们可以利用这点
 */
fun singleNumber(nums: IntArray): Int {
    var result = 0

    for (num in nums) {
        result = result xor num
    }
    return result
}