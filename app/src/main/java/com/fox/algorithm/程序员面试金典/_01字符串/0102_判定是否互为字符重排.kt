package com.fox.algorithm.程序员面试金典._01字符串

import java.util.*

/**
 * @Author Fox
 * @Date 2020/10/20 21:49
 */
/*链接:https://leetcode-cn.com/problems/check-permutation-lcci/
给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
示例 1：
输入: s1 = "abc", s2 = "bca"
输出: true

示例 2：
输入: s1 = "abc", s2 = "bad"
输出: false
说明：
0 <= len(s1) <= 100
0 <= len(s2) <= 100*/


//采用一个list来添加s1的所有char 然后遍历s2中的char
//如果list中没有s2中当前遍历的char 则表示不能重排为s2
//如果有则删除掉当前遍历的char 继续遍历
fun CheckPermutation(s1: String, s2: String): Boolean {
    if (s1.length != s2.length) return false
    val list = mutableListOf<Char>()
    for (c in s1) {
        list.add(c)
    }

    for (c in s2) {
        if (!list.contains(c)) {
            return false
        } else {
            list.remove(c)
        }
    }
    return true
}

//如果s1能打乱重排序变为s2 则 两个s1 s2排序后的str应该是相同的
fun CheckPermutation1(s1: String, s2: String): Boolean {
    val charArray1 = s1.toCharArray()
    Arrays.sort(charArray1)
    val charArray2 = s2.toCharArray()
    Arrays.sort(charArray2)
    return String(charArray1) == String(charArray2)
}

