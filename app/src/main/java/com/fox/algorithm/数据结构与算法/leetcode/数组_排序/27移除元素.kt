package com.fox.algorithm.数据结构与算法.leetcode.数组_排序

/**
 * Created by fox.hu on 2018/8/30.
 */
/*https://leetcode-cn.com/problems/remove-element/
给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
给定 nums = [0,1,2,2,3,0,4,2], val = 2,
函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

思路同26 双指针 指针相同则跳指针 不同则替换慢指针的值*/

fun removeElement(nums: IntArray, value: Int): Int {
    var k = 0
    for (i in nums.indices) {
        if (nums[i] != value) {
            nums[k++] = nums[i]
        }
    }
    return k
}
