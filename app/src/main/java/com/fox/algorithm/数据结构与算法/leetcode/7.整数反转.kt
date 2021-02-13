package com.fox.algorithm.数据结构与算法.leetcode

/**
 * @Author fox.hu
 * @Date 2020/1/22 17:01
 */

/*给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
示例 1:
输入: 123
输出: 321

示例 2:
输入: -123
输出: -321

示例 3:
输入: 120
输出: 21
注意:
假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。
请根据这个假设，如果反转后整数溢出那么就返回 0。*/

fun reverse(x: Int): Int {
    var temp = x
    var ret = 0
    while (temp != 0) {
        val pop = temp % 10
        //两个溢出的暂时看不懂
        if (ret > Int.MAX_VALUE / 10 || (ret == Int.MAX_VALUE / 10 && pop > 7)) {
            return 0
        }
        if (ret < Int.MIN_VALUE / 10 || (ret == Int.MIN_VALUE / 10 && pop < -8)) {
            return 0
        }
        ret = ret * 10 + pop
        temp /= 10
    }
    return ret
}

fun main() {
    println(reverse(123))
}