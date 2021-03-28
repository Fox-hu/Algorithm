package com.fox.algorithm.数据结构与算法.leetcode.数组_排序;

/**
 * @Author Fox
 * @Date 2021/3/28 13:11
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
要保证l1 l2都是要大于等于0的
* */

class _88合并两个有序数组 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int cur = nums1.length - 1, l1 = m - 1, l2 = n - 1;
        while (l2 >= 0) {
            if (l1 >= 0 && nums2[l2] < nums1[l1]) {
                nums1[cur--] = nums1[l1--];
            } else {
                nums1[cur--] = nums2[l2--];
            }
        }
    }
}
