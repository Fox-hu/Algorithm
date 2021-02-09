package com.fox.algorithm.数据结构与算法.面试.数组_排序

/**
 * @Author fox.hu
 * @Date 2021/2/9 14:48
 */

/*
链接：https://leetcode-cn.com/problems/merge-sorted-array
给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
示例 1：
输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
输出：[1,2,2,3,5,6]

示例 2：
输入：nums1 = [1], m = 1, nums2 = [], n = 0
输出：[1]

提示：
nums1.length == m + n
nums2.length == n
0 <= m, n <= 200
1 <= m + n <= 200
-109 <= nums1[i], nums2[i] <= 109
*/

/*
思路 从后往前遍历 nums1与nums2 取出两者大的一位填充最后一位后继续 直至比较完毕
* */
fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    var i1 = m - 1
    var i2 = n - 1
    var cur = nums1.size - 1

    while (i2 >= 0) {
        if (i1 >= 0 && nums2[i2] < nums1[i1]) {
            nums1[cur--] = nums1[i1--]
        } else {
            nums1[cur--] = nums2[i2--]
        }
    }
}
