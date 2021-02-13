package com.fox.algorithm.数据结构与算法.面试.数组_排序

/**
 * @Author fox.hu
 * @Date 2021/2/9 15:48
 */
/*链接：https://leetcode-cn.com/problems/sort-colors
* 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
示例 1：
输入：nums = [2,0,2,1,1,0]
输出：[0,0,1,1,2,2]

示例 2：
输入：nums = [2,0,1]
输出：[0,1,2]

示例 3：
输入：nums = [0]
输出：[0]
 
提示：
n == nums.length
1 <= n <= 300
nums[i] 为 0、1 或 2
 
进阶：
你可以不使用代码库中的排序函数来解决这道题吗？
你能想出一个仅使用常数空间的一趟扫描算法吗*/

/*
思路 遍历数组 将0放到左边去 将2放到右边去 1不动 遍历完成则数组排序完成
定义三个指针 遍历指针、指向0的指针、指向2的指针
遇到1：跳过，遍历指针++
遇到0：跟指向0的指针交换值，指向零的指针++、遍历指针++
遇到2：跟指向2的指针交换值，指向2的指针--，再次对遍历指针的值进行判断
* */
fun sortColors(nums: IntArray): Unit {
    var i0 = 0
    var i = 0
    var i2 = nums.size - 1

    while (i <= i2) {
        when (nums[i]) {
            0 -> {
                swap(nums, i0++, i++)
            }
            1 -> {
                i++
            }
            2 -> {
                swap(nums, i, i2--)
            }
        }
    }
}

fun swap(nums: IntArray, n: Int, m: Int) {
    val temp = nums[n]
    nums[n] = nums[m]
    nums[m] = temp
}