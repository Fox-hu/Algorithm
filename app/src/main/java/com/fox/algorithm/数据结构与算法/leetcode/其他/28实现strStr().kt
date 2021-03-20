package com.fox.algorithm.数据结构与算法.leetcode

/**
 * @Author fox.hu
 * @Date 2020/1/22 15:54
 */
/*实现 strStr() 函数。
给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
如果不存在，则返回  -1。
输入: haystack = "hello", needle = "ll"
输出: 2*/

fun strStr(haystack: String, needle: String): Int {
    return haystack.indexOf(needle)
}

fun main() {
    println(strStr("hello", "ll"))
}