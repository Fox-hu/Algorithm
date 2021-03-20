package com.fox.algorithm.数据结构与算法.leetcode.字符串

/**
 * @Author Fox
 * @Date 2021/3/20 14:00
 */
/*https://leetcode-cn.com/problems/longest-common-prefix/
编写一个函数来查找字符串数组中的最长公共前缀。
如果不存在公共前缀，返回空字符串 ""。
示例 1：
输入：strs = ["flower","flow","flight"]
输出："fl"
示例 2：
输入：strs = ["dog","racecar","car"]
输出：""
解释：输入不存在公共前缀。*/

/*
思路在于 遍历str1、str2 得出共有前缀prefix后将prefix与str3遍历，最终得出结果
 */

fun longestCommonPrefix(strs: Array<String>): String {
    if (strs.isEmpty()) return ""
    var prefix = strs[0]
    val count = strs.size

    for (i in 1 until count) {
        prefix = longestCommonPrefix(prefix, strs[i])
        if (prefix.isEmpty()) break
    }
    return prefix
}

fun longestCommonPrefix(str1: String, str2: String): String {
    val length = Math.min(str1.length, str2.length)
    var index = 0
    while (index < length && str1[index] == str2[index]) {
        index++
    }
    return str1.substring(0, index)
}