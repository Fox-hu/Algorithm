package com.fox.algorithm.数据结构与算法.leetcode.栈_队列

import java.util.*

/**
 * @Author fox.hu
 * @Date 2021/2/18 13:50
 */
/*https://leetcode-cn.com/problems/sliding-window-maximum
给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
返回滑动窗口中的最大值。

示例 1：
输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
输出：[3,3,5,5,6,7]
解释：
滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
1 [3  -1  -3] 5  3  6  7       3
1  3 [-1  -3  5] 3  6  7       5
1  3  -1 [-3  5  3] 6  7       5
1  3  -1  -3 [5  3  6] 7       6
1  3  -1  -3  5 [3  6  7]      7

示例 2：
输入：nums = [1], k = 1
输出：[1]

示例 3：
输入：nums = [1,-1], k = 1
输出：[1,-1]

示例 4：
输入：nums = [9,11], k = 2
输出：[11]

示例 5：
输入：nums = [4,-2], k = 2
输出：[4]

提示：
1 <= nums.length <= 10^5
-10^4 <= nums[i] <= 10^4
1 <= k <= nums.length
*/


/*
1.如果 nums[i]>=nums[队尾],不断删除队尾,直到 nums[队尾]>nums[i]
2.将i加入队尾
3.如果w>=0 删除失效的队头(队头<w 就代表失效),更新w位置的窗口最大值为nums[队头]
注意
从对头到对尾,nums[队列元素],是逐渐减小的
队列中存放的是索引
*/
fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
    if (nums.isEmpty() || k < 1) return intArrayOf()
    if (k == 1) return nums

    val maxes = IntArray(nums.size - k + 1)
    //deque中存储的是数组中的索引
    val deque: Deque<Int> = LinkedList<Int>()
    for (i in nums.indices) {
        while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()!!]) {
            deque.pollLast()
        }
        //将i添加到队尾
        deque.offerLast(i)

        //检查窗口的索引是否合法
        val w: Int = i - k + 1
        if (w < 0) continue
        if (deque.peekFirst()!! < w) {
            //不合法 则清除出队头
            deque.pollFirst()
        }

        //设置窗口的最大值
        maxes[w] = nums[deque.peekFirst()!!]
    }
    return maxes
}