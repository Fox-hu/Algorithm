package com.fox.algorithm.数据结构与算法.leetcode.数组_排序

/**
 * Created by fox.hu on 2018/8/31.
 */

/*给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
给定 nums = [2, 7, 11, 15], target = 9
因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]*/

//暴力解法
fun twoSum(nums: IntArray, target: Int): IntArray {
    val ints = IntArray(2)
    for (i in nums.indices) {
        for (j in i + 1 until nums.size) {
            if (nums[i] + nums[j] == target) {
                ints[0] = i
                ints[1] = j
                break
            }
        }
    }
    return ints
}

/* 使用一个map，每遍历array中序号为index的数时，在map中寻找是否存在 target-array[index]的值
 如果存在则说明有 直接返回
 如果不存在 则说明没有 则将此时的array[index]为key，index为value，存入map中 供后续查询
 至于为什么是 array[index]为key 是因为map提供了containsKey方法 可以直接返回是否存在*/
fun twoSum1(nums: IntArray, target: Int): IntArray {
    val map = HashMap<Int, Int>()
    for (i in nums.indices) {
        val complement = target - nums[i]
        if (map.containsKey(complement)) {
            return intArrayOf(map[complement]!!, i)
        } else {
            map[nums[i]] = i
        }
    }
    throw IllegalArgumentException("No two sum solution")
}

