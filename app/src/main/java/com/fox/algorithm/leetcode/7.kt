package com.fox.algorithm.leetcode

/**
 * @Author fox.hu
 * @Date 2020/1/22 17:01
 */
//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
//输入: 123
//输出: 321

//两个问题
//一个是如何反转
//一个是考虑溢出
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