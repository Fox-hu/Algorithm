package com.fox.algorithm.数据结构与算法.leetcode.数组_排序

/**
 * Created by fox.hu on 2018/8/31.
 */
/*给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
说明:
返回的下标值（index1 和 index2）不是从零开始的。
你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
示例:
输入: numbers = [2, 7, 11, 15], target = 9
输出: [1,2]
解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。*/

fun twoSum(numbers: IntArray?, target: Int): IntArray? {
    if (numbers == null || numbers.isEmpty()) {
        return null
    }
    //本题设中 一定会有解 采用双指针法 指向数组两端
    //相加大于target则头指针后移 小于target则尾指针前移，直到相等
    var i = 0
    var j = numbers.size - 1
    while (i < j) {
        if (numbers[i] + numbers[j] > target) {
            j--
        } else if (numbers[i] + numbers[j] < target) {
            i++
        } else {
            return intArrayOf(i + 1, j + 1)
        }
    }
    return null
}
