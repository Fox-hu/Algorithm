package com.fox.algorithm.leetcode.数组

/**
 * @Author fox.hu
 * @Date 2020/1/22 14:52
 */

//给你一个整数 n，请你返回 任意 一个由 n 个 各不相同 的整数组成的数组，并且这 n 个数相加和为 0 。
//输入：n = 5
//输出：[-7,-1,1,3,4]
//解释：这些数组也是正确的 [-5,-1,1,2,3]，[-3,-1,2,-2,4]。

//不需要判断是否是奇偶，如果是奇数 最后的就是0
fun sumZero(n: Int): IntArray {
    val intArray = IntArray(n)
    var index = 0
    for (i in 1..n / 2) {
        intArray[index++] = -i
        intArray[index++] = i
    }
    return intArray
}


