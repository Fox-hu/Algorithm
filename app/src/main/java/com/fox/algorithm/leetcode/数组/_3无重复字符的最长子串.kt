package com.fox.algorithm.leetcode.数组

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @Author Fox
 * @Date 2020/10/12 21:17
 */

//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//示例 1:
//输入: "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

//示例 2:
//输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。

//示例 3:
//输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

class _3无重复字符的最长子串 {
    fun lengthOfLongestSubstring(s: String): Int {
        if (s.isEmpty()) return 0
        val map = hashMapOf<Char, Int>()
        var max = 0
        var left = 0

        for (i in s.indices) {
            if (map.containsKey(s[i])) {
                left = Math.max(left, map[s[i]]!! + 1)
            }
            map[s[i]] = i
            max = Math.max(max, i - left + 1)
        }
        return max

    }
}