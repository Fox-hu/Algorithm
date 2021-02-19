package com.fox.algorithm.数据结构与算法.leetcode.字符串

/**
 * @Author fox.hu
 * @Date 2021/2/19 13:52
 */
/*https://leetcode-cn.com/problems/valid-anagram
给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
示例 1:
输入: s = "anagram", t = "nagaram"
输出: true

示例 2:
输入: s = "rat", t = "car"
输出: false
说明:
你可以假设字符串只包含小写字母。

进阶:
如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？*/

fun isAnagram(s: String, t: String): Boolean {
    val srcList = s.toMutableList()
    val desList = t.toMutableList()
    for (c in desList) {
        if (!srcList.remove(c)) return false
    }
    return srcList.isEmpty()
}

fun isAnagram1(s: String, t: String): Boolean {
    return s.toMutableList().sorted() == t.toMutableList().sorted()
}