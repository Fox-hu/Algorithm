package com.fox.algorithm.数据结构与算法.leetcode.递归

/**
 * @Author Fox
 * @Date 2020/11/29 22:13
 */
/*https://leetcode-cn.com/problems/climbing-stairs/
楼梯有n阶台阶，上楼可以走1阶，也可以一步上2阶，走完n阶台阶共有多少中不同的走法？
 */

//使用递归的方式进行
fun climbStairs(n: Int): Int {
    if (n <= 2) return n
    return climbStairs(n - 1) + climbStairs(n - 2)
}

//滚动数组进行优化
fun climbStairs1(n: Int): Int {
    if (n <= 2) return n
    var first = 1
    var second = 2

    for (i in 3..n) {
        second += first
        first = second - first
    }
    return second
}

fun main() {
    climbStairs(20)
    climbStairs1(20)
}