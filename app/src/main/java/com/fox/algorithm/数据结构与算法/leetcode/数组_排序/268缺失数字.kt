package com.fox.algorithm.数据结构与算法.leetcode.数组_排序

/**
 * Created by fox.hu on 2018/8/31.
 */
/*给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
示例 1:
输入: [3,0,1]
输出: 2

示例 2:
输入: [9,6,4,2,3,5,7,0,1]
输出: 8*/

fun missingNumber(nums: IntArray): Int {
    //利用等差公式求和 再减去数组中所有的值，剩下的即为所缺值
    val n = nums.size + 1
    var sum = n * (n - 1) / 2
    for (num in nums) {
        sum -= num
    }
    return sum
}
