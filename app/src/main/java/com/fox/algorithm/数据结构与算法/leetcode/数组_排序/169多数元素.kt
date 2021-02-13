package com.fox.algorithm.数据结构与算法.leetcode.数组_排序

import java.util.*

/**
 * Created by fox.hu on 2018/8/30.
 */
/*给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
你可以假设数组是非空的，并且给定的数组总是存在多数元素。
示例 1:
输入: [3,2,3]
输出: 3

示例 2:
输入: [2,2,1,1,1,2,2]
输出: 2*/

fun majorityElement(nums: IntArray): Int {
    if (nums.size == 1) {
        return nums[0]
    }
    val map = HashMap<Int, Int?>()
    for (i in nums.indices) {
        if (!map.containsKey(nums[i])) {
            map[nums[i]] = 0
        } else {
            map[nums[i]] = map[nums[i]]!! + 1
        }
    }
    var sum: Int? = 0
    var index = 0
    val integers: Set<Int> = map.keys
    for (integer in integers) {
        if (map[integer]!! > sum!!) {
            sum = map[integer]
            index = integer
        }
    }
    return index
}

fun majorityElement_MooreVote(nums: IntArray): Int {
    var res = 0
    var cnt = 0
    for (num in nums) {
        if (cnt == 0) {
            res = num
            ++cnt
        } else if (num == res) {
            ++cnt
        } else {
            --cnt
        }
    }
    return res
}
