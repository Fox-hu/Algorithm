package com.fox.algorithm.leetcode.数组

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * @Author Fox
 * @Date 2020/10/13 21:36
 */
//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
//示例 1：
//输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
//示例 2：
//
//输入: "cbbd"
//输出: "bb"


class _5最长回文子串 {
    //中心扩散法
    //需要考虑 奇偶回文子串都有可能
    fun longestPalindrome(s: String): String {
        if (s.isEmpty()) return ""
        var start: Int = 0
        var end: Int = 0

        for (i in s.indices) {
            //奇数回文子串最大长度
            val len1 = expandAroundCent(s, i, i)
            //偶数回文子串最大长度
            val len2 = expandAroundCent(s, i, i + 1)
            val max = Math.max(len1, len2)
            //如果此循环的max大于之前累计的max 则更新start end指针的值
            if (max > start - end) {
                start = i - (max - 1) / 2
                end = i + max / 2
            }
        }
        return s.substring(start, end + 1)
    }

    //以start end 为基础进行扩散 返回最大回文子串长度
    fun expandAroundCent(s: String, left: Int, right: Int): Int {
        var tempLeft = left
        var tempRight = right
        while (tempLeft >= 0 && tempRight < s.length && s[tempLeft] == s[tempRight]) {
            tempLeft--
            tempRight++
        }
        //这个地方可以拿纸画一下 跳出循环后的最大回文子串的长度
        return tempRight - tempLeft - 1
    }
}