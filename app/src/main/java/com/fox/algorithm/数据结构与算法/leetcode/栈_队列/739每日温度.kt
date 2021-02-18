package com.fox.algorithm.数据结构与算法.leetcode.栈_队列

import java.util.*

/**
 * @Author Fox
 * @Date 2021/2/18 21:51
 */
/*https://leetcode-cn.com/problems/daily-temperatures
请根据每日 气温 列表，重新生成一个列表。
对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
*/

//同654 result数组代表着离当前位置的最小距离
//维护一个单项递减的栈 出栈操作 代表入栈节点是首个右边比栈顶节点大的值
fun dailyTemperatures(nums: IntArray): IntArray {
    if (nums.isEmpty()) return intArrayOf()

    val result = IntArray(nums.size)
    val stack: Stack<Int> = Stack()
    for (i in nums.indices) {
        while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
            val topIndex = stack.peek()
            result[topIndex] = i - topIndex
            stack.pop()
        }
        stack.push(i)
    }

    return result
}